package grammar;

import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14ParserBaseListener;

import types.Type;

public class SemantCPP14ParserListener extends CPP14ParserBaseListener {

    private Stack<Type> exprTypeStack = new Stack<>();

    /** type name to type */
    private Map<String, Type> typeMap = new HashMap<>();

    /** variable name to type */
    private Map<String, Type> varTypeMap = new HashMap<>();

    private boolean isArray;

    private Type initializerType;

    private String declaratorName;

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        final ParserRuleContext parserRuleContext = ctx.initDeclaratorList().initDeclarator().get(0).declarator();
        // String varName = parserRuleContext.getText();

        String varName = declaratorName;

        if (ctx.declSpecifierSeq() == null) {

            // assignment without type declaration (a = 1;)

            Type targetType = varTypeMap.get(varName);

            // type of the assigned value (right hand side (rhs))
            if (initializerType != null) {
                performTypeCheck(targetType, initializerType, "[Assignment TypeError] VarName: \"" + varName + "\"",
                        parserRuleContext);
            }

        } else {

            // assignment with type declaration (int a = 1;)

            // type of declared variable
            String targetTypeName = ctx.declSpecifierSeq().getText();
            Type targetType = typeMap.get(targetTypeName);

            // type of the assigned value
            if (initializerType != null) {
                performTypeCheck(targetType, initializerType, "[Assignment TypeError]", ctx.declSpecifierSeq());
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

        // reset
        exprTypeStack.clear();
        initializerType = null;
        isArray = false;
        declaratorName = null;
    }

    @Override
    public void exitDeclaratorid(CPP14Parser.DeclaratoridContext ctx) {
        declaratorName = ctx.getText();
    }

    @Override
    public void enterInitializerClause(CPP14Parser.InitializerClauseContext ctx) {
        // int numbers[3] = {10, '20', 30};
        // forget about the array length literal '3'
        exprTypeStack.clear();
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
        
        // else if (exprTypeStack.size() == 2) {
        //     System.out.println(exprTypeStack.pop());
        // } else {
        //     throw new RuntimeException();
        // }
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

}
