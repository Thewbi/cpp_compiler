package grammar;

import java.util.Stack;

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
            ((DeclaratorASTNode) currentNode).children.add(expressionStack.pop());
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
        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = ctx.getText();
        expressionASTNode.expressionType = ExpressionType.Primary;
        expressionStack.push(expressionASTNode);
    }

    @Override
    public void enterAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {
    }

    @Override
    public void exitAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        for (int i = 1; i < ctx.children.size(); i += 2) {

            ExpressionASTNode rhs = expressionStack.pop();
            ExpressionASTNode lhs = expressionStack.pop();

            ExpressionASTNode expressionASTNode = new ExpressionASTNode();
            expressionASTNode.ctx = ctx;
            // expressionASTNode.value = ctx.getText();
            expressionASTNode.expressionType = ExpressionType.Add;
            expressionASTNode.lhs = lhs;
            expressionASTNode.rhs = rhs;

            connectToParent(expressionASTNode, lhs);
            connectToParent(expressionASTNode, rhs);

            expressionStack.push(expressionASTNode);
        }
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
            ExpressionASTNode functionNameExpressionASTNode = expressionStack.pop();

            PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
            postFixExpressionASTNode.name = functionNameExpressionASTNode;

            expressionStack.push(postFixExpressionASTNode);

            return;
        }

        // retrieve function name
        ExpressionASTNode expressionListASTNode = expressionStack.pop();
        ExpressionASTNode functionNameExpressionASTNode = expressionStack.pop();

        PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
        postFixExpressionASTNode.name = functionNameExpressionASTNode;
        postFixExpressionASTNode.list = expressionListASTNode;

        expressionStack.push(postFixExpressionASTNode);
    }

    @Override public void enterExpressionList(CPP14Parser.ExpressionListContext ctx) {
        // add a blocker
        expressionStack.push(new ExpressionListBlockerASTNode());
     }

	@Override public void exitExpressionList(CPP14Parser.ExpressionListContext ctx) {
        ExpressionListASTNode expressionListASTNode = new ExpressionListASTNode();
        while (!(expressionStack.peek() instanceof ExpressionListBlockerASTNode)) {
            ExpressionASTNode expressionASTNode = expressionStack.pop();
            expressionListASTNode.children.add(0, expressionASTNode);
        }
        // remove the blocker
        expressionStack.pop();
        expressionStack.push(expressionListASTNode);
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
        jumpStatementASTNode.children.add(expressionStack.pop());
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
}
