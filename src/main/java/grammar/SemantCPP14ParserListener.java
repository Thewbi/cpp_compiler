package grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14Parser.DeclSpecifierSeqContext;
import com.cpp.grammar.CPP14Parser.InitDeclaratorContext;
import com.cpp.grammar.CPP14Parser.InitDeclaratorListContext;
import com.cpp.grammar.CPP14ParserBaseListener;

import types.FormalParameter;
import types.FuncDecl;
import types.Type;

public class SemantCPP14ParserListener extends CPP14ParserBaseListener {

    private Stack<Type> exprTypeStack = new Stack<>();

    /** type name to type */
    private Map<String, Type> typeMap = new HashMap<>();

    /** variable name to type */
    private Map<String, Type> varTypeMap = new HashMap<>();

    private boolean isArray;

    private Type initializerType;

    private List<String> declaratorNames = new ArrayList<>();

    private SemAntMode semAntMode = SemAntMode.DEFAULT;

    private FuncDecl funcDecl;

    private Map<String, FuncDecl> funcDeclMap = new HashMap<>();

    @Override
    public void enterStatement(CPP14Parser.StatementContext ctx) {
        setSemAntMode(SemAntMode.STATEMENT);
    }

    @Override
    public void exitStatement(CPP14Parser.StatementContext ctx) {
        setSemAntMode(SemAntMode.DEFAULT);
    }

    /**
     * Function Declaration begins
     */
    @Override
    public void enterFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {

        setSemAntMode(SemAntMode.FUNCTION_DECLARATION);

        funcDecl = new FuncDecl();

        // return type
        String typeName = ctx.declSpecifierSeq().getText();
        Type returnType = null;
        if (StringUtils.equalsIgnoreCase("void", typeName)) {
            returnType = null;
        } else {
            if (!typeMap.containsKey(typeName)) {
                throw new RuntimeException("type \"" + typeName + "\" not covered!");
            }
            returnType = typeMap.get(typeName);
        }
        funcDecl.setReturnType(returnType);

        // // function name
        // IdExpressionContext declarator = ctx.getChild(IdExpressionContext.class, 1);
        // String functionName = declarator.getText();

        // ctx.get

        // funcDecl.setName(functionName);
    }

    @Override
    public void exitFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {

        setSemAntMode(SemAntMode.DEFAULT);

        FuncDecl oldFuncDecl = funcDeclMap.put(funcDecl.getName(), funcDecl);
        if (oldFuncDecl != null) {
            throw new RuntimeException("[Function Declaration Error (Line " + ctx.getStart().getLine()
                    + ")] Function \"" + funcDecl.getName() + "\" already defined!");
        }
        funcDecl = null;
    }

    @Override
    public void enterFunctionBody(CPP14Parser.FunctionBodyContext ctx) {
        setSemAntMode(SemAntMode.FUNCTION_BODY);
    }

    @Override
    public void exitFunctionBody(CPP14Parser.FunctionBodyContext ctx) {
        setSemAntMode(SemAntMode.DEFAULT);
    }

    @Override
    public void enterParameterDeclaration(CPP14Parser.ParameterDeclarationContext ctx) {
        setSemAntMode(SemAntMode.PARAMETER_DECLARATION);

        FormalParameter formalParameter = new FormalParameter();
        funcDecl.getParams().add(formalParameter);
    }

    @Override
    public void exitParameterDeclaration(CPP14Parser.ParameterDeclarationContext ctx) {
        setSemAntMode(SemAntMode.DEFAULT);
    }

    @Override
    public void exitSimpleTypeSpecifier(CPP14Parser.SimpleTypeSpecifierContext ctx) {
        final String typeName = ctx.getText();
        // System.out.println(typeName);
        // if (funcDecl != null) {

        if (semAntMode == SemAntMode.PARAMETER_DECLARATION) {

            if (!typeMap.containsKey(typeName)) {
                throw new RuntimeException("type \"" + typeName + "\" not covered!");
            }
            Type formalParameterType = typeMap.get(typeName);

            FormalParameter formalParameter = funcDecl.getParams().get(funcDecl.getParams().size() - 1);
            formalParameter.setType(formalParameterType);

        }

        // else {

        // Type returnType = null;
        // if (StringUtils.equalsIgnoreCase("void", typeName)) {
        // returnType = null;
        // } else {
        // if (!typeMap.containsKey(typeName)) {
        // throw new RuntimeException("type \"" + typeName + "\" not covered!");
        // }
        // returnType = typeMap.get(typeName);
        // }
        // funcDecl.setReturnType(returnType);

        // }
        // }
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        // check if this declaration is a single semicolon and then skip the empty
        // statement
        if (StringUtils.equalsIgnoreCase(ctx.getText(), ";")) {
            return;
        }

        InitDeclaratorListContext initDeclaratorListContext = ctx.initDeclaratorList();
        List<InitDeclaratorContext> InitDeclaratorContexts = initDeclaratorListContext.initDeclarator();
        InitDeclaratorContext initDeclaratorContext = InitDeclaratorContexts.get(0);
        final ParserRuleContext parserRuleContext = initDeclaratorContext.declarator();

        if (semAntMode == SemAntMode.STATEMENT) {

            System.out.println("Statement: " + declaratorNames);

        } else {
            for (String varName : declaratorNames) {
                processVariableDeclaration(ctx, parserRuleContext, varName);
            }
        }

        // reset
        exprTypeStack.clear();
        initializerType = null;
        isArray = false;
        declaratorNames.clear();
    }

    private void processVariableDeclaration(CPP14Parser.SimpleDeclarationContext ctx,
            final ParserRuleContext parserRuleContext,
            String varName) {

        if (ctx.declSpecifierSeq() == null) {

            // assignment without type declaration (a = 1;)

            Type targetType = varTypeMap.get(varName);
            if (targetType == null) {
                throw new RuntimeException("Unknown type:  \"" + targetType + "\"");
            }

            // type of the assigned value (right hand side (rhs))
            if (initializerType != null) {
                performTypeCheck(targetType, initializerType, "[Assignment TypeError] VarName: \"" + varName + "\"",
                        parserRuleContext);
            }

        } else {

            // assignment with type declaration (int a = 1;)

            // type of declared variable
            DeclSpecifierSeqContext declSpecifierSeqContext = ctx.declSpecifierSeq();
            String targetTypeName = declSpecifierSeqContext.getText();
            Type targetType = typeMap.get(targetTypeName);

            if (targetType == null) {
                throw new RuntimeException("Unknown type:  \"" + targetType + "\"");
            }

            // type of the assigned value
            if (initializerType != null) {
                performTypeCheck(targetType, initializerType, "[Assignment TypeError]", declSpecifierSeqContext);
            }

            // create an array type if the variable is an array
            if (isArray) {
                Type arrayVarType = new Type();
                arrayVarType.setArraySubType(targetType);
                varTypeMap.put(varName, arrayVarType);
            } else {
                varTypeMap.put(varName, targetType);
            }
        }
    }

    @Override
    public void exitDeclaratorid(CPP14Parser.DeclaratoridContext ctx) {

        String id = ctx.getText();

        switch (semAntMode) {
            case FUNCTION_DECLARATION:
                funcDecl.setName(id);
                break;

            default:
                declaratorNames.add(id);
                break;
        }
    }

    @Override
    public void enterInitializerClause(CPP14Parser.InitializerClauseContext ctx) {
        // int numbers[3] = {10, '20', 30};
        // forget about the array length literal '3'
        exprTypeStack.clear();
        setSemAntMode(SemAntMode.INITIALIZER);
    }

    @Override
    public void exitInitializerClause(CPP14Parser.InitializerClauseContext ctx) {
        // store type in the initializerType member so the SimpleDeclaration rule
        // can retrieve the type from the member

        if (exprTypeStack.size() == 1) {
            Type tempInitializerType = exprTypeStack.pop();
            if ((initializerType != null) && (!initializerType.equals(tempInitializerType))) {
                throw new RuntimeException(
                        "[Error: Initializer Types not compatible! (Line " + ctx.getStart().getLine() + ")] "
                                + tempInitializerType + " is added to " + initializerType);
            }
            initializerType = tempInitializerType;
        }

        setSemAntMode(SemAntMode.DEFAULT);
    }

    @Override
    public void exitNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {

        // sometimes two NoPointerDeclaratorContext are directly nested!
        // Only deal with the nexted node, ignore the parent!
        if (ctx.getParent() instanceof CPP14Parser.NoPointerDeclaratorContext) {
            return;
        }

        if (ctx.getChildCount() > 1) {

            // System.out.println(ctx.getChild(1).getText());
            // System.out.println(ctx.getChild(ctx.getChildCount()-1).getText());

            boolean arrayStartFound = false;
            boolean arrayEndFound = false;

            if (StringUtils.equalsIgnoreCase(ctx.getChild(1).getText(), "[")) {
                arrayStartFound = true;
            }
            if (StringUtils.equalsIgnoreCase(ctx.getChild(ctx.getChildCount() - 1).getText(), "]")) {
                arrayEndFound = true;
            }

            if (arrayStartFound && arrayEndFound) {
                isArray = true;
            }
        }
    }

    @Override
    public void exitMultiplicativeExpression(CPP14Parser.MultiplicativeExpressionContext ctx) {
        getExpr(ctx.pointerMemberExpression());
    }

    @Override
    public void exitAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {
        getExpr(ctx.multiplicativeExpression());
    }

    private void getExpr(List<? extends ParserRuleContext> objs) {

        int size = CollectionUtils.size(objs);
        if (size == 1) {
            return;
        }

        for (ParserRuleContext expr : objs) {

            if (size == 1) {
                break;
            }
            size--;

            Type typeA = exprTypeStack.pop();
            Type typeB = exprTypeStack.pop();

            performTypeCheck(typeA, typeB, "Addition TypeError", expr);

            exprTypeStack.push(typeA);
        }
    }

    @Override
    public void enterPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {
        String primaryExpression = ctx.getText();
        //System.out.println(primaryExpression);

        if (StringUtils.endsWithIgnoreCase(primaryExpression, ")")) {
            setSemAntMode(SemAntMode.FUNCTION_CALL);
        }
    }

    @Override
    public void exitIdExpression(CPP14Parser.IdExpressionContext ctx) {

        final String varName = ctx.getText();

        // System.out.println(varName);

        switch (semAntMode) {

            case INITIALIZER: {
                if (!varTypeMap.containsKey(varName)) {
                    throw new RuntimeException(
                            "[Error: Initializer variable not defined! (Line " + ctx.getStart().getLine() + ")] "
                                    + " Undefined variable is: \"" + varName + "\"");
                }

                Type type = varTypeMap.get(ctx.getText());
                exprTypeStack.push(type);
            }
                break;

            case PARAMETER_DECLARATION: {
                //System.out.println("Add parameter");

                FormalParameter formalParameter = funcDecl.getParams().get(funcDecl.getParams().size() - 1);
                formalParameter.setName(varName);
            }
                break;

            case FUNCTION_DECLARATION: {
                funcDecl.setName(varName);
                declaratorNames.clear();
            }
                break;

                case FUNCTION_CALL: {
                    //throw new RuntimeException("FunctionCall not implemented yet!");
                    if (!funcDeclMap.containsKey(varName)) {
                        throw new RuntimeException(
                                "[Error: Function not defined! (Line " + ctx.getStart().getLine() + ")] "
                                        + " Undefined function is: \"" + varName + "\"");
                    }
    
                    FuncDecl funcDecl = funcDeclMap.get(ctx.getText());
                    exprTypeStack.push(funcDecl.getReturnType());
                }
                    break;

            default:
                break;
        }

        // if (semAntMode == SemAntMode.INITIALIZER) {

        // if (!varTypeMap.containsKey(varName)) {
        // throw new RuntimeException(
        // "[Error: Initializer variable not defined! (Line " + ctx.getStart().getLine()
        // + ")] "
        // + " Undefined variable is: \"" + varName + "\"");
        // }

        // Type type = varTypeMap.get(ctx.getText());
        // exprTypeStack.push(type);
        // }

        // if (semAntMode == SemAntMode.PARAMETER_DECLARATION) {
        // System.out.println("Add parameter");

        // FormalParameter formalParameter =
        // funcDecl.getParams().get(funcDecl.getParams().size() - 1);
        // formalParameter.setName(varName);

        // } else if (funcDecl != null) {
        // funcDecl.setName(varName);
        // }
    }

    @Override
    public void exitLiteral(CPP14Parser.LiteralContext ctx) {

        // System.out.println(ctx.getText());

        boolean typeProcessed = false;
        TerminalNode literalTerminalNode = ctx.IntegerLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("int");
            typeProcessed = true;
        }
        literalTerminalNode = ctx.StringLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("std::string");
            typeProcessed = true;
        }
        literalTerminalNode = ctx.CharacterLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("char");
            typeProcessed = true;
        }
        literalTerminalNode = ctx.FloatingLiteral();
        if (literalTerminalNode != null) {
            checkAndAddType("float");
            typeProcessed = true;
        }
        if (!typeProcessed) {
            throw new RuntimeException("type not covered!");
        }
    }

    private void checkAndAddType(final String typeName) {
        if (!typeMap.containsKey(typeName)) {
            throw new RuntimeException("type \"" + typeName + "\" not covered!");
        }
        exprTypeStack.push(typeMap.get(typeName));
    }

    private void performTypeCheck(final Type targetType, final Type rhsType, final String label,
            final ParserRuleContext ctx) {
        if (targetType != rhsType) {
            throw new RuntimeException(
                    "[Error: " + label + " Line: " + ctx.getStart().getLine() + "]" + " Var's type: \"" + targetType
                            + "\" Assigned value's type: \"" + rhsType
                            + "\" ");
        }
    }

    public Map<String, Type> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, Type> typeMap) {
        this.typeMap = typeMap;
    }

    public Map<String, Type> getVarTypeMap() {
        return varTypeMap;
    }

    public Map<String, FuncDecl> getFuncDeclMap() {
        return funcDeclMap;
    }

    public void setFuncDeclMap(Map<String, FuncDecl> funcDeclMap) {
        this.funcDeclMap = funcDeclMap;
    }

    public void setSemAntMode(SemAntMode semAntMode) {
        // System.out.println("SemAntMode old: " + this.semAntMode + " new: " +
        // semAntMode);
        this.semAntMode = semAntMode;
    }

}
