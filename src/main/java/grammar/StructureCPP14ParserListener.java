package grammar;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14ParserBaseListener;

import ast.ASTNode;
import ast.DeclarationListASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionListASTNode;
import ast.ExpressionListBlockerASTNode;
import ast.ExpressionType;
import ast.FunctionDeclarationASTNode;
import ast.JumpStatementASTNode;
import ast.JumpStatementType;
import ast.PostFixExpressionASTNode;

public class StructureCPP14ParserListener extends CPP14ParserBaseListener {

    public ASTNode currentNode;

    public Stack<ExpressionASTNode> expressionStack = new Stack<>();

    @Override
    public void enterFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {
        FunctionDeclarationASTNode functionDeclarationASTNode = new FunctionDeclarationASTNode();
        functionDeclarationASTNode.returnType = ctx.getChild(0).getText();
        functionDeclarationASTNode.ctx = ctx;
        connectToParent(currentNode, functionDeclarationASTNode);

        // descend
        currentNode = functionDeclarationASTNode;
    }

    @Override
    public void exitFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {
    }

    //
    // Variable declarations
    //

    @Override
    public void enterSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {
        DeclarationListASTNode declarationListASTNode = new DeclarationListASTNode();
        declarationListASTNode.type = ctx.getChild(0).getText();
        declarationListASTNode.ctx = ctx;
        connectToParent(currentNode, declarationListASTNode);

        // descend
        currentNode = declarationListASTNode;
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {
        // ascend
        currentNode = currentNode.parent;
    }

    @Override
    public void enterInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {
        DeclaratorASTNode declaratorASTNode = new DeclaratorASTNode();
        declaratorASTNode.ctx = ctx;
        connectToParent(currentNode, declaratorASTNode);

        // descend
        currentNode = declaratorASTNode;
    }

    @Override
    public void exitInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {
        if (!expressionStack.empty()) {
            ((DeclaratorASTNode) currentNode).children.add(expressionStackPop());
        }

        // ascend
        currentNode = currentNode.parent;
    }

    @Override
    public void enterPointerOperator(CPP14Parser.PointerOperatorContext ctx) {
    }

    @Override
    public void exitPointerOperator(CPP14Parser.PointerOperatorContext ctx) {
        if (currentNode instanceof DeclaratorASTNode) {
            ((DeclaratorASTNode) currentNode).isPointer = true;
        }
    }

    @Override
    public void enterNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {
    }

    @Override
    public void exitNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {
        if (currentNode == null) {
            return;
        }
        currentNode.value = ctx.getText();
    }

    //
    // Expressions
    //

    @Override
    public void enterPrimaryExpression(CPP14Parser.PrimaryExpressionContext ctx) {
        
    }

    @Override
    public void exitPrimaryExpression(CPP14Parser.PrimaryExpressionContext ctx) {

        System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 3) {
            if (ctx.children.get(0).getText().equalsIgnoreCase("(") && ctx.children.get(2).getText().equalsIgnoreCase(")")) {
                return;
            }
        }

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = ctx.getText();
        expressionASTNode.expressionType = ExpressionType.Primary;
        expressionStackPush(expressionASTNode);
    }

    @Override
    public void enterAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {
    }

    @Override
    public void exitAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        processExpressionOperator(ctx, ExpressionType.Add);
    }

    @Override
    public void exitMultiplicativeExpression(CPP14Parser.MultiplicativeExpressionContext ctx) {
        if (ctx.children.size() == 1) {
            return;
        }

        processExpressionOperator(ctx, ExpressionType.Mul);
    }

    @Override
    public void enterPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

    }

    /**
     * Currently expecting int value = get_value(1, 2);
     */
    @Override
    public void exitPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        if (ctx.children.size() == 3) {

            // retrieve function name
            ExpressionASTNode functionNameExpressionASTNode = expressionStackPop();

            PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
            postFixExpressionASTNode.name = functionNameExpressionASTNode;

            expressionStackPush(postFixExpressionASTNode);

            return;
        }

        // retrieve function name
        ExpressionASTNode expressionListASTNode = expressionStackPop();
        ExpressionASTNode functionNameExpressionASTNode = expressionStackPop();

        PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
        postFixExpressionASTNode.name = functionNameExpressionASTNode;
        postFixExpressionASTNode.list = expressionListASTNode;

        expressionStackPush(postFixExpressionASTNode);
    }

    @Override public void enterExpressionList(CPP14Parser.ExpressionListContext ctx) {
        // add a blocker
        expressionStackPush(new ExpressionListBlockerASTNode());
     }

	@Override public void exitExpressionList(CPP14Parser.ExpressionListContext ctx) {
        ExpressionListASTNode expressionListASTNode = new ExpressionListASTNode();
        while (!(expressionStack.peek() instanceof ExpressionListBlockerASTNode)) {
            ExpressionASTNode expressionASTNode = expressionStackPop();
            expressionListASTNode.children.add(0, expressionASTNode);
        }
        // remove the blocker
        expressionStackPop();
        expressionStackPush(expressionListASTNode);
    }

    //
    // Statements
    //

    @Override
    public void enterJumpStatement(CPP14Parser.JumpStatementContext ctx) {
    }

    @Override
    public void exitJumpStatement(CPP14Parser.JumpStatementContext ctx) {

        JumpStatementASTNode jumpStatementASTNode = new JumpStatementASTNode();
        jumpStatementASTNode.ctx = ctx;
        jumpStatementASTNode.value = ctx.getText();
        jumpStatementASTNode.children.add(expressionStackPop());
        jumpStatementASTNode.type = JumpStatementType.valueOf(ctx.getChild(0).getText().toUpperCase());

        currentNode.children.add(jumpStatementASTNode);
    }

    //
    // utility
    //

    private void connectToParent(ASTNode parent, ASTNode child) {
        // connect parent and child
        parent.children.add(child);
        child.parent = parent;
    }

    private ExpressionASTNode expressionStackPop() {
        return expressionStack.pop();
    }

    private void expressionStackPush(ExpressionASTNode expressionASTNode) {
        expressionStack.push(expressionASTNode);
    }

    private void processExpressionOperator(ParserRuleContext ctx, ExpressionType expressionType) {
        for (int i = 1; i < ctx.children.size(); i += 2) {

            ExpressionASTNode rhs = expressionStackPop();
            ExpressionASTNode lhs = expressionStackPop();

            ExpressionASTNode expressionASTNode = new ExpressionASTNode();
            expressionASTNode.ctx = ctx;
            expressionASTNode.expressionType = expressionType;
            expressionASTNode.lhs = lhs;
            expressionASTNode.rhs = rhs;

            connectToParent(expressionASTNode, lhs);
            connectToParent(expressionASTNode, rhs);

            expressionStackPush(expressionASTNode);
        }
    }
}
