package grammar;

import org.antlr.v4.runtime.ParserRuleContext;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14Parser.IdExpressionContext;
import com.cpp.grammar.CPP14Parser.InitializerContext;
import com.cpp.grammar.CPP14Parser.ParametersAndQualifiersContext;
import com.cpp.grammar.CPP14ParserBaseListener;

import ast.ASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import ast.FunctionDeclarationASTNode;
import ast.IterationStatementASTNode;
import ast.NoPointerDeclarator;
import ast.ParametersAndQualifiersASTNode;
import ast.PostFixExpressionASTNode;
import ast.SimpleDeclarationASTNode;
import ast.StatementType;

public class SimpleCPP14ParserBaseListener extends CPP14ParserBaseListener {

    public ASTNode currentNode;

    //
    // Variable declarations
    //

    @Override
    public void enterSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        // why declaration list? This produces confusing output when parsing
        // initialize_struct.cpp For which case is this required? For for-loops
        // (iteration statement)
        SimpleDeclarationASTNode simpleDeclarationASTNode = new SimpleDeclarationASTNode();
        simpleDeclarationASTNode.ctx = ctx;
        simpleDeclarationASTNode.type = ctx.children.get(0).getText();

        connectToParent(currentNode, simpleDeclarationASTNode);
        descend(simpleDeclarationASTNode);
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {
        ascend();
    }

    @Override
    public void enterInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        //NoPointerDeclarator noPointerDeclarator = new NoPointerDeclarator();
        DeclaratorASTNode noPointerDeclarator = new DeclaratorASTNode();
        noPointerDeclarator.ctx = ctx;

        connectToParent(currentNode, noPointerDeclarator);
        descend(noPointerDeclarator);
    }

    @Override
    public void exitInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {

        System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        // NoPointerDeclarator noPointerDeclarator = (NoPointerDeclarator) currentNode;
        DeclaratorASTNode noPointerDeclarator = (DeclaratorASTNode) currentNode;

        processDeclarator(ctx, noPointerDeclarator);

        ascend();
    }

    @Override
    public void enterNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        //NoPointerDeclarator noPointerDeclarator = new NoPointerDeclarator();
        DeclaratorASTNode noPointerDeclarator = new DeclaratorASTNode();
        noPointerDeclarator.ctx = ctx;

        connectToParent(currentNode, noPointerDeclarator);
        descend(noPointerDeclarator);
    }

    @Override
    public void exitNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {

        System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        // NoPointerDeclarator noPointerDeclarator = (NoPointerDeclarator) currentNode;
        DeclaratorASTNode noPointerDeclarator = (DeclaratorASTNode) currentNode;

        processDeclarator(ctx, noPointerDeclarator);

        ascend();
    }

    private void processDeclarator(org.antlr.v4.runtime.ParserRuleContext ctx, DeclaratorASTNode declaratorASTNode) {
        if ((ctx.children.size() == 3)
                && (ctx.getChild(1).getText().equalsIgnoreCase("["))
                && (ctx.getChild(2).getText().equalsIgnoreCase("]"))) {

            declaratorASTNode.isArray = true;

        } else if ((ctx.children.size() > 3)
                && (ctx.getChild(1).getText().equalsIgnoreCase("["))
                && (ctx.getChild(3).getText().equalsIgnoreCase("]"))) {

            currentNode.value = ctx.getChild(0).getText();
            currentNode.children.remove(0);

            declaratorASTNode.indexExpression = (ExpressionASTNode) currentNode.children.get(0);
            currentNode.children.remove(0);

            declaratorASTNode.isArray = true;

        } else if (currentNode instanceof FunctionDeclarationASTNode) {

            // do not copy trash into the value attribute. The function name is identified
            // by a NoPointerDeclarator node that has a single child only
            if (ctx.children.size() == 1) {
                currentNode.value = ctx.getText();
            }

        } else {

            currentNode.value = ctx.getText();

            declaratorASTNode.isFunctionCall = currentNode.children.stream().filter(e -> {
                if (e instanceof ParametersAndQualifiersASTNode) {
                    return true;
                }
                return false;
            }).count() > 0;

            if (ctx.children.get(1) instanceof InitializerContext) {

                InitializerContext child1 = (InitializerContext) ctx.children.get(1);
                if (child1.children.get(0).getText().equalsIgnoreCase(("("))) {
                    declaratorASTNode.isFunctionCall = true;
                }
            }
        }
    }

    @Override
    public void enterParametersAndQualifiers(CPP14Parser.ParametersAndQualifiersContext ctx) {

        ParametersAndQualifiersASTNode parametersAndQualifiersASTNode = new ParametersAndQualifiersASTNode();
        parametersAndQualifiersASTNode.ctx = ctx;

        connectToParent(currentNode, parametersAndQualifiersASTNode);
        descend(parametersAndQualifiersASTNode);
    }

    @Override
    public void exitParametersAndQualifiers(CPP14Parser.ParametersAndQualifiersContext ctx) {
        ascend();
    }

    //
    // Function Definition
    //

    @Override
    public void enterFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {

        FunctionDeclarationASTNode functionDeclarationASTNode = new FunctionDeclarationASTNode();
        functionDeclarationASTNode.ctx = ctx;
        functionDeclarationASTNode.returnType = ctx.getChild(0).getText();
        
        connectToParent(currentNode, functionDeclarationASTNode);
        descend(functionDeclarationASTNode);
    }

    @Override
    public void exitFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {
        ascend();
    }

    //
    // Expressions
    //

    @Override
    public void exitPrimaryExpression(CPP14Parser.PrimaryExpressionContext ctx) {

        // IdExpressions produce their own AST nodes. Do not produce an additional node
        if ((ctx.children.size() == 1) && (ctx.children.get(0) instanceof IdExpressionContext)) {
            return;
        }

        // test for single-element expression wrapped in brackets to ignore
        // single-element expressions
        if (ctx.children.size() == 3) {
            if (ctx.children.get(0).getText().equalsIgnoreCase("(")
                    && ctx.children.get(2).getText().equalsIgnoreCase(")")) {
                return;
            }
        }

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = ctx.getText();
        expressionASTNode.expressionType = ExpressionType.Primary;

        connectToParent(currentNode, expressionASTNode);
    }

    @Override
    public void exitIdExpression(CPP14Parser.IdExpressionContext ctx) {

        // test for single-element expression wrapped in brackets to ignore
        // single-element expressions
        if (ctx.children.size() == 3) {
            if (ctx.children.get(0).getText().equalsIgnoreCase("(")
                    && ctx.children.get(2).getText().equalsIgnoreCase(")")) {
                return;
            }
        }

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = ctx.getText();
        expressionASTNode.expressionType = ExpressionType.Identifier;

        connectToParent(currentNode, expressionASTNode);
    }

    @Override
    public void enterRelationalExpression(CPP14Parser.RelationalExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = ctx.getText();
        expressionASTNode.expressionType = ExpressionType.fromString(ctx.children.get(1).getText());
        expressionASTNode.type = "REL";

        connectToParent(currentNode, expressionASTNode);
        descend(expressionASTNode);
    }

    @Override
    public void exitRelationalExpression(CPP14Parser.RelationalExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        ascend();
    }

    @Override
    public void enterPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        if (ctx.children.size() == 2) {
            if (ctx.children.get(1).getText().equalsIgnoreCase("++")) {

                PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
                // postFixExpressionASTNode.lhs = expressionStackPop();
                postFixExpressionASTNode.expressionType = ExpressionType.fromString("++");

                connectToParent(currentNode, postFixExpressionASTNode);
                descend(postFixExpressionASTNode);

                return;
            }
        }
    }

    @Override
    public void exitPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        if (ctx.children.size() == 2) {
            ascend();
        }
    }

    //
    // Loops
    //

    @Override
    public void enterIterationStatement(CPP14Parser.IterationStatementContext ctx) {

        IterationStatementASTNode iterationStatementASTNode = new IterationStatementASTNode();
        iterationStatementASTNode.ctx = ctx;
        iterationStatementASTNode.value = ctx.getText();
        iterationStatementASTNode.statementType = StatementType.valueOf(ctx.getChild(0).getText().toUpperCase());

        connectToParent(currentNode, iterationStatementASTNode);
        descend(iterationStatementASTNode);
    }

    @Override
    public void exitIterationStatement(CPP14Parser.IterationStatementContext ctx) {
        ascend();
    }

    //
    // utility
    //

    /**
     * connect parent and child
     * 
     * @param parent
     * @param child
     */
    private void connectToParent(ASTNode parent, ASTNode child) {
        parent.children.add(child);
        child.parent = parent;
    }

    private void ascend() {
        if (currentNode.parent == null) {
            throw new RuntimeException("Ascending to null parent!");
        }
        currentNode = currentNode.parent;
    }

    private void descend(ASTNode newCurrentNode) {
        currentNode = newCurrentNode;
    }

}
