package grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
import types.StackFrame;
import types.Type;

public class SemantCPP14ParserListener extends CPP14ParserBaseListener {

    // private Stack<Type> exprTypeStack = new Stack<>();

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

    // private String calledFunctionName;

    private Stack<String> calledFunctionNameStack = new Stack();

    private Stack<StackFrame> executionStack = new Stack<>();

    @Override
    public void enterExpressionList(CPP14Parser.ExpressionListContext ctx) {
    }

    @Override
    public void exitExpressionList(CPP14Parser.ExpressionListContext ctx) {

        if (calledFunctionNameStack.isEmpty()) {
            return;
        }

        String calledFunctionName = calledFunctionNameStack.pop();

        // System.out.println("FUNCTION_CALL_WITH_PARAMETERS: " + calledFunctionName);

        FuncDecl funcDecl = funcDeclMap.get(calledFunctionName);

        int returnValueIsOnStackToo = 1;
        if (funcDecl.getParams().size() != (executionStack.peek().exprTypeStack.size() - returnValueIsOnStackToo)) {
            throw new RuntimeException(
                        "[ERROR: Bonked! Actual parameter count does not match formal parameter count! (Line \""
                                + ctx.getStart().getLine() + "\")]");
        }

        // Iterate in reverse.
        ListIterator li = funcDecl.getParams().listIterator(funcDecl.getParams().size());
        while (li.hasPrevious()) {

            // System.out.println(li.previous());

            Type actualParameterType = executionStack.peek().exprTypeStack.pop();

            FormalParameter formalParameter = (FormalParameter) li.previous();
            // System.out.println(formalParameter);

            performTypeCheck(formalParameter.getType(), actualParameterType, "[ERROR: function call of function: \""
                    + calledFunctionName + "\"(). Actual parameter type does not match!", ctx);
        }

        // last value on the stack is the return type of the function
        // store it into initializerType so that the declaration can perform type check
        // between the function value and the assigned variable
        initializerType = executionStack.peek().exprTypeStack.peek();

        System.out.println("FUNCTION_CALL exit detected");

        // the return value of the the called function goes onto the exprTypeStack of
        // the lower stackFrome
        Type returnValue = executionStack.peek().exprTypeStack.pop();
        executionStack.pop();
        executionStack.peek().exprTypeStack.push(returnValue);

        setSemAntMode(SemAntMode.DEFAULT);

        // System.out.println("");
    }

    @Override
    public void enterStatement(CPP14Parser.StatementContext ctx) {
        setSemAntMode(SemAntMode.STATEMENT);
    }

    @Override
    public void exitStatement(CPP14Parser.StatementContext ctx) {
        setSemAntMode(SemAntMode.DEFAULT);
    }

    /**
     * Function Definition begins
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
        if (semAntMode == SemAntMode.PARAMETER_DECLARATION) {

            if (!typeMap.containsKey(typeName)) {
                throw new RuntimeException("type \"" + typeName + "\" not covered!");
            }
            Type formalParameterType = typeMap.get(typeName);

            FormalParameter formalParameter = funcDecl.getParams().get(funcDecl.getParams().size() - 1);
            formalParameter.setType(formalParameterType);
        }
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        System.out.println(ctx.getText());

        if (declaratorNames.isEmpty()) {
            return;
        }

        if (semAntMode == SemAntMode.STATEMENT) {
            return;
        }

        // check if this declaration is a single semicolon and then skip the empty
        // statement
        if (StringUtils.equalsIgnoreCase(ctx.getText(), ";")) {
            return;
        }

        InitDeclaratorListContext initDeclaratorListContext = ctx.initDeclaratorList();
        List<InitDeclaratorContext> InitDeclaratorContexts = initDeclaratorListContext.initDeclarator();
        InitDeclaratorContext initDeclaratorContext = InitDeclaratorContexts.get(0);
        final ParserRuleContext parserRuleContext = initDeclaratorContext.declarator();

        // if (semAntMode == SemAntMode.STATEMENT) {

        // System.out.println("Statement: " + declaratorNames);

        // } else {
        for (String varName : declaratorNames) {
            processVariableDeclaration(ctx, parserRuleContext, varName);
        }
        // }

        // reset
        executionStack.peek().exprTypeStack.clear();
        initializerType = null;
        isArray = false;
        declaratorNames.clear();
    }

    private void processVariableDeclaration(CPP14Parser.SimpleDeclarationContext ctx,
            ParserRuleContext parserRuleContext,
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
        System.out.println(id);

        switch (semAntMode) {
            case FUNCTION_DECLARATION:
                funcDecl.setName(id);
                break;

            case FUNCTION_CALL:
                // funcDecl.setName(id);
                break;

            case STATEMENT:
                // funcDecl.setName(id);
                break;

            default:
                declaratorNames.add(id);
                break;
        }
    }

    @Override
    public void enterBraceOrEqualInitializer(CPP14Parser.BraceOrEqualInitializerContext ctx) {
        // int numbers[3] = {10, '20', 30};
        // forget about the array length literal '3'
        executionStack.peek().exprTypeStack.clear();
        setSemAntMode(SemAntMode.INITIALIZER);
    }

    @Override
    public void exitInitializerClause(CPP14Parser.InitializerClauseContext ctx) {

        // System.out.println(ctx.getText());

        // store type in the initializerType member so the SimpleDeclaration rule
        // can retrieve the type from the member

        if (executionStack.peek().exprTypeStack.size() == 1) {
            Type tempInitializerType = executionStack.peek().exprTypeStack.pop();
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

            Type typeA = executionStack.peek().exprTypeStack.pop();
            Type typeB = executionStack.peek().exprTypeStack.pop();

            performTypeCheck(typeA, typeB, "Addition TypeError", expr);

            executionStack.peek().exprTypeStack.push(typeA);
        }
    }

    // @Override
    // public void enterPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

    //     if (ctx.getChild(0) instanceof CPP14Parser.PostfixExpressionContext) {

    //         System.out.println("FUNCTION_CALL enter detected");

    //         StackFrame stackFrame = new StackFrame();
    //         executionStack.push(stackFrame);

    //         setSemAntMode(SemAntMode.FUNCTION_CALL);
    //     }

    //     // String primaryExpression = ctx.getText();
    //     // // System.out.println(primaryExpression);

    //     // if (StringUtils.endsWithIgnoreCase(primaryExpression, ")")) {
    //     // setSemAntMode(SemAntMode.FUNCTION_CALL);
    //     // }
    // }

    // @Override
    // public void exitPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

    //     if (ctx.getChild(0) instanceof CPP14Parser.PostfixExpressionContext) {

    //         System.out.println("FUNCTION_CALL exit detected");

    //         // the return value of the the called function goes onto the exprTypeStack of
    //         // the lower stackFrome
    //         Type returnValue = executionStack.peek().exprTypeStack.pop();
    //         executionStack.pop();
    //         executionStack.peek().exprTypeStack.push(returnValue);

    //         setSemAntMode(SemAntMode.DEFAULT);

    //     }

    // }

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
                executionStack.peek().exprTypeStack.push(type);
            }
                break;

            case PARAMETER_DECLARATION: {
                // System.out.println("Add parameter");

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
                // throw new RuntimeException("FunctionCall not implemented yet!");
                if (!funcDeclMap.containsKey(varName)) {
                    throw new RuntimeException(
                            "[Error: Function not defined! (Line " + ctx.getStart().getLine() + ")] "
                                    + " Undefined function is: \"" + varName + "\"");
                }

                FuncDecl funcDecl = funcDeclMap.get(ctx.getText());

                executionStack.peek().exprTypeStack.push(funcDecl.getReturnType());

                // executionStack.peek();

                // Type bonkMarkerType = typeMap.get("bonk1122");
                // exprTypeStack.push(bonkMarkerType);

                System.out.println("FUNCTION_CALL: " + varName);

                calledFunctionNameStack.push(varName);
            }
                break;

            default:
                break;
        }
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
        executionStack.peek().exprTypeStack.push(typeMap.get(typeName));
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

    /**
     * With the AST that the grammar produces, it is hard to tell where a function call occurs!
     * 
     * The strategy here is to check every identifier versus known declared function names.
     * If the identifier is a function name, then assume a function call.
     */
    @Override
    public void enterUnqualifiedId(CPP14Parser.UnqualifiedIdContext ctx) {
        String funcName = ctx.getText();

        // System.out.println(funcName);

        if (funcDeclMap.containsKey(funcName)) {
            
            System.out.println("FUNCTION_CALL enter detected");

            StackFrame stackFrame = new StackFrame();
            executionStack.push(stackFrame);

            setSemAntMode(SemAntMode.FUNCTION_CALL);
        }
    }

    @Override
    public void exitUnqualifiedId(CPP14Parser.UnqualifiedIdContext ctx) {
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

    public Stack<StackFrame> getExecutionStack() {
        return executionStack;
    }

    public void setExecutionStack(Stack<StackFrame> executionStack) {
        this.executionStack = executionStack;
    }

}
