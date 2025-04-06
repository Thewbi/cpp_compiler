package grammar;

import java.util.Stack;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14ParserBaseListener;

import ast.ASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import ast.FunctionDeclarationASTNode;
import ast.JumpStatementASTNode;
import ast.JumpStatementType;

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
        DeclaratorASTNode declaratorASTNode = new DeclaratorASTNode();
        declaratorASTNode.type = ctx.getChild(0).getText();
        declaratorASTNode.ctx = ctx;
        connectToParent(currentNode, declaratorASTNode);

        // descend
        currentNode = declaratorASTNode;
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {
    }

    @Override
    public void enterInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {

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

        ExpressionASTNode rhs = expressionStack.pop();
        ExpressionASTNode lhs = expressionStack.pop();

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = ctx.getText();
        expressionASTNode.expressionType = ExpressionType.Add;
        expressionASTNode.lhs = lhs;
        expressionASTNode.rhs = rhs;

        connectToParent(expressionASTNode, lhs);
        connectToParent(expressionASTNode, rhs);

        expressionStack.push(expressionASTNode);
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

        //connectToParent(jumpStatementASTNode, currentNode);

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
