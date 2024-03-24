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

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        final ParserRuleContext parserRuleContext = ctx.initDeclaratorList().initDeclarator().get(0).declarator();
        String varName = parserRuleContext.getText();

        if (ctx.declSpecifierSeq() != null) {

            // assignment with type declaration (int a = 1;)

            // type of declared variable
            String targetTypeName = ctx.declSpecifierSeq().getText();
            Type targetType = typeMap.get(targetTypeName);

            // type of the assigned value
            // String rhsTypeName = exprTypeStack.pop();
            // Type rhsType = typeMap.get(rhsTypeName);
            Type rhsType = exprTypeStack.pop();

            performTypeCheck(targetType, rhsType, "[Assignment TypeError]", ctx.declSpecifierSeq());

            varTypeMap.put(varName, targetType);

        } else {

            // assignment without type declaration (a = 1;)

            Type targetType = varTypeMap.get(varName);

            // type of the assigned value (right hand side (rhs))
            // String rhsTypeName = exprTypeStack.pop();
            // Type rhsType = typeMap.get(rhsTypeName);
            Type rhsType = exprTypeStack.pop();

            performTypeCheck(targetType, rhsType, "[Assignment TypeError] VarName: \"" + varName + "\"",
                    parserRuleContext);
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

        //Type typeA = null;

        for (ParserRuleContext expr : objs) {

            if (size == 1) {
                break;
            }
            size--;

            // String typeAName = exprTypeStack.pop();
            // Type typeA = typeMap.get(typeAName);
            // String typeB = exprTypeStack.pop();
            Type typeA = exprTypeStack.pop();
            Type typeB = exprTypeStack.pop();

            performTypeCheck(typeA, typeB, "Addition TypeError", expr);

            exprTypeStack.push(typeA);
        }
    }

    @Override
    public void exitLiteral(CPP14Parser.LiteralContext ctx) {
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
        //if (!StringUtils.equalsIgnoreCase(targetType, rhsType)) {
        if (targetType != rhsType) {
            throw new RuntimeException(
                    "[" + label + "]" + " Var's type: \"" + targetType + "\" Assigned value's type: \"" + rhsType
                            + "\" Line: " + ctx.getStart().getLine());
        }
    }

    public Map<String, Type> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, Type> typeMap) {
        this.typeMap = typeMap;
    }

}
