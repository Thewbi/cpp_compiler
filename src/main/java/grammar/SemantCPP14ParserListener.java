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

public class SemantCPP14ParserListener extends CPP14ParserBaseListener {

    private Stack<String> exprTypeStack = new Stack<String>();

    private Map<String, String> typeMap = new HashMap<>();

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        String name = ctx.initDeclaratorList().initDeclarator().get(0).declarator().getText();

        if (ctx.declSpecifierSeq() != null) {

            // type of declared variable
            String type = ctx.declSpecifierSeq().getText();

            // type of the assigned value
            String typeA = exprTypeStack.pop();

            if (!StringUtils.equalsIgnoreCase(typeA, type)) {
                throw new RuntimeException(
                        "type error! Var's type: \"" + type + "\" Assigned value's type: \"" + typeA + "\"");
            }

            typeMap.put(name, type);

        } else {

            String type = typeMap.get(name);

            // type of the assigned value
            String typeA = exprTypeStack.pop();

            if (!StringUtils.equalsIgnoreCase(typeA, type)) {
                throw new RuntimeException(
                        "type error! Var's type: \"" + type + "\" Assigned value's type: \"" + typeA + "\"");
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

        String typeA = null;

        for (ParserRuleContext expr : objs) {

            if (size == 1) {
                break;
            }
            size--;

            typeA = exprTypeStack.pop();
            String typeB = exprTypeStack.pop();

            if (!StringUtils.equalsIgnoreCase(typeA, typeB)) {
                throw new RuntimeException("addition type error! typeA: \"" + typeA + "\" typeB: \"" + typeB
                        + "\" Line: " + expr.getStart().getLine());
            }

            exprTypeStack.push(typeA);
        }
    }

    @Override
    public void exitLiteral(CPP14Parser.LiteralContext ctx) {
        boolean typeProcessed = false;
        TerminalNode literalTerminalNode = ctx.IntegerLiteral();
        if (literalTerminalNode != null) {
            exprTypeStack.push("int");
            typeProcessed = true;
        }
        literalTerminalNode = ctx.StringLiteral();
        if (literalTerminalNode != null) {
            exprTypeStack.push("string");
            typeProcessed = true;
        }
        literalTerminalNode = ctx.CharacterLiteral();
        if (literalTerminalNode != null) {
            exprTypeStack.push("char");
            typeProcessed = true;
        }
        literalTerminalNode = ctx.FloatingLiteral();
        if (literalTerminalNode != null) {
            exprTypeStack.push("float");
            typeProcessed = true;
        }
        if (!typeProcessed) {
            throw new RuntimeException("type not covered!");
        }
    }

}
