package grammar;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.math.NumberUtils;

import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14Parser.IdExpressionContext;
import com.cpp.grammar.CPP14Parser.InitializerContext;
import com.cpp.grammar.CPP14ParserBaseListener;

import ast.ASTNode;
import ast.ASTNodeType;
import ast.BodyASTNode;
import ast.DeclaratorASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import ast.FunctionDeclarationASTNode;
import ast.IterationStatementASTNode;
import ast.JumpStatementASTNode;
import ast.ParameterDeclarationASTNode;
import ast.ParameterDeclarationListASTNode;
import ast.ParametersAndQualifiersASTNode;
import ast.PostFixExpressionASTNode;
import ast.SelectionStatementASTNode;
import ast.SimpleDeclarationASTNode;
import ast.StatementType;
import tacky.ast.FunctionCallASTNode;

public class SimpleCPP14ParserBaseListener extends CPP14ParserBaseListener {

    public ASTNode currentNode;

    // Variable declarations

    @Override
    public void enterSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {

        SimpleDeclarationASTNode simpleDeclarationASTNode = new SimpleDeclarationASTNode();
        simpleDeclarationASTNode.ctx = ctx;
        simpleDeclarationASTNode.astNodeType = ASTNodeType.SIMPLE_DECLARATION;

        connectToParent(currentNode, simpleDeclarationASTNode);
        descend(simpleDeclarationASTNode);
    }

    @Override
    public void exitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {
        if (!(currentNode instanceof SimpleDeclarationASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected SimpleDeclarationASTNode");
        }
        ascend();
    }

    @Override
    public void enterInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        DeclaratorASTNode noPointerDeclarator = new DeclaratorASTNode();
        noPointerDeclarator.ctx = ctx;
        noPointerDeclarator.astNodeType = ASTNodeType.INIT_DECLARATION;

        connectToParent(currentNode, noPointerDeclarator);
        descend(noPointerDeclarator);
    }

    @Override
    public void exitInitDeclarator(CPP14Parser.InitDeclaratorContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        if (currentNode instanceof DeclaratorASTNode) {
            DeclaratorASTNode noPointerDeclarator = (DeclaratorASTNode) currentNode;
            processDeclarator(ctx, noPointerDeclarator);
        }

        ascend();
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

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        DeclaratorASTNode noPointerDeclarator = new DeclaratorASTNode();
        noPointerDeclarator.ctx = ctx;

        connectToParent(currentNode, noPointerDeclarator);
        descend(noPointerDeclarator);
    }

    @Override
    public void exitNoPointerDeclarator(CPP14Parser.NoPointerDeclaratorContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        // NoPointerDeclarator noPointerDeclarator = (NoPointerDeclarator) currentNode;
        DeclaratorASTNode noPointerDeclarator = (DeclaratorASTNode) currentNode;

        processDeclarator(ctx, noPointerDeclarator);

        if (!(currentNode instanceof DeclaratorASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected DeclaratorASTNode");
        }
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

            if (currentNode.parent instanceof SimpleDeclarationASTNode) {

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

                if (declaratorASTNode.isFunctionCall) {
                    declaratorASTNode.astNodeType = ASTNodeType.FUNCTION_CALL;
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

    // Types

    // Type specifier (int, float, double, custom types ...)

    @Override
    public void enterTypeSpecifier(CPP14Parser.TypeSpecifierContext ctx) {
    }

    @Override
    public void exitTypeSpecifier(CPP14Parser.TypeSpecifierContext ctx) {
        currentNode.type = ctx.getChild(0).getText();
    }

    // Function Definition

    @Override
    public void enterFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {

        FunctionDeclarationASTNode functionDeclarationASTNode = new FunctionDeclarationASTNode();
        functionDeclarationASTNode.ctx = ctx;
        functionDeclarationASTNode.returnType = ctx.getChild(0).getText();
        functionDeclarationASTNode.astNodeType = ASTNodeType.FUNCTION_DECLARATION;

        connectToParent(currentNode, functionDeclarationASTNode);
        descend(functionDeclarationASTNode);
    }

    @Override
    public void exitFunctionDefinition(CPP14Parser.FunctionDefinitionContext ctx) {
        if (!(currentNode instanceof FunctionDeclarationASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected FunctionDeclarationASTNode");
        }
        ascend();
    }

    @Override
    public void enterParameterDeclarationList(CPP14Parser.ParameterDeclarationListContext ctx) {

        ParameterDeclarationListASTNode parameterDeclarationListASTNode = new ParameterDeclarationListASTNode();
        parameterDeclarationListASTNode.ctx = ctx;

        connectToParent(currentNode, parameterDeclarationListASTNode);
        descend(parameterDeclarationListASTNode);
    }

    @Override
    public void exitParameterDeclarationList(CPP14Parser.ParameterDeclarationListContext ctx) {

        if (!(currentNode instanceof ParameterDeclarationListASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected ParameterDeclarationListASTNode");
        }
        ascend();
    }

    @Override
    public void enterParameterDeclaration(CPP14Parser.ParameterDeclarationContext ctx) {

        ParameterDeclarationASTNode parameterDeclarationASTNode = new ParameterDeclarationASTNode();
        parameterDeclarationASTNode.ctx = ctx;

        connectToParent(currentNode, parameterDeclarationASTNode);
        descend(parameterDeclarationASTNode);
    }

    @Override
    public void exitParameterDeclaration(CPP14Parser.ParameterDeclarationContext ctx) {

        if (!(currentNode instanceof ParameterDeclarationASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected ParameterDeclarationASTNode");
        }
        ascend();
    }

    @Override
    public void enterFunctionBody(CPP14Parser.FunctionBodyContext ctx) {

        BodyASTNode bodyASTNode = new BodyASTNode();

        connectToParent(currentNode, bodyASTNode);
        descend(bodyASTNode);
    }

    @Override
    public void exitFunctionBody(CPP14Parser.FunctionBodyContext ctx) {

        if (!(currentNode instanceof BodyASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected BodyASTNode");
        }
        ascend();
    }

    // Expressions

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

        String rawValue = ctx.getText();

        if (NumberUtils.isParsable(rawValue)) {

        }

        ExpressionASTNode expressionASTNode = new ExpressionASTNode();
        expressionASTNode.ctx = ctx;
        expressionASTNode.value = rawValue;

        if (NumberUtils.isParsable(rawValue)) {

            expressionASTNode.expressionType = ExpressionType.Primary;

        } else if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {

            expressionASTNode.expressionType = ExpressionType.StringLiteral;

        } else if (rawValue.startsWith("\'") && rawValue.endsWith("\'")) {

            expressionASTNode.expressionType = ExpressionType.CharacterLiteral;

        } else {

            throw new RuntimeException();

        }

        expressionASTNode.astNodeType = ASTNodeType.EXPRESSION;

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
        expressionASTNode.astNodeType = ASTNodeType.EXPRESSION;

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
        expressionASTNode.astNodeType = ASTNodeType.EXPRESSION;

        connectToParent(currentNode, expressionASTNode);
        descend(expressionASTNode);
    }

    @Override
    public void exitRelationalExpression(CPP14Parser.RelationalExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        if (!(currentNode instanceof ExpressionASTNode)) {
            throw new RuntimeException("Node Hierarchy is broken! Expected ExpressionASTNode");
        }
        ascend();
    }

    @Override
    public void enterPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }
        // if (ctx.children.size() == 3) {
        //     // empty parameter list in function
        //     return;
        // }

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 2) {

            if (ctx.children.get(1).getText().equalsIgnoreCase("++")) {

                PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
                postFixExpressionASTNode.expressionType = ExpressionType.fromString("++");
                postFixExpressionASTNode.type = "UNARY";

                connectToParent(currentNode, postFixExpressionASTNode);
                descend(postFixExpressionASTNode);

                return;
            }

        } else if (ctx.children.size() == 4) {

            String startSymbol = ctx.children.get(1).getText();
            String endSymbol = ctx.children.get(3).getText();

            if (startSymbol.equalsIgnoreCase("[")
                    && endSymbol.equalsIgnoreCase("]")) {

                // DEBUG
                // System.out.println("array-indexing");

                PostFixExpressionASTNode postFixExpressionASTNode = new PostFixExpressionASTNode();
                postFixExpressionASTNode.expressionType = ExpressionType.ArrayIndexing;
                postFixExpressionASTNode.type = "UNARY";
                postFixExpressionASTNode.value = ctx.children.get(0).getText();

                connectToParent(currentNode, postFixExpressionASTNode);
                descend(postFixExpressionASTNode);

            } else if (startSymbol.equalsIgnoreCase("(")
                    && endSymbol.equalsIgnoreCase(")")) {

                String functionName = ctx.children.get(0).getText();

                DeclaratorASTNode functionCallASTNode = new DeclaratorASTNode();
                // FunctionCallASTNode functionCallASTNode = new FunctionCallASTNode();
                functionCallASTNode.value = functionName;

                // // DEBUG
                // ParseTree bodyParseTree = ctx.children.get(2);
                // for (int i = 0; i < bodyParseTree.getChildCount(); i++) {
                //     ParseTree child = bodyParseTree.getChild(i);
                //     System.out.println(child);
                // }

                connectToParent(currentNode, functionCallASTNode);
                descend(functionCallASTNode);

            } else {

                throw new RuntimeException();

            }

        } else {

            throw new RuntimeException();

        }
    }

    @Override
    public void exitPostfixExpression(CPP14Parser.PostfixExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        if (ctx.children.size() == 2) {
            if (!(currentNode instanceof PostFixExpressionASTNode)) {
                throw new RuntimeException("Node Hierarchy is broken! Expected PostFixExpressionASTNode");
            }
            ascend();
        }

        if (ctx.children.size() == 4) {

            String startSymbol = ctx.children.get(1).getText();
            String endSymbol = ctx.children.get(3).getText();

            if (startSymbol.equalsIgnoreCase("[")
                    && endSymbol.equalsIgnoreCase("]")) {

                if (!(currentNode instanceof PostFixExpressionASTNode)) {
                    throw new RuntimeException("Node Hierarchy is broken! Expected PostFixExpressionASTNode");
                }

                ascend();

            } else if (startSymbol.equalsIgnoreCase("(")
                    && endSymbol.equalsIgnoreCase(")")) {

                if (!(currentNode instanceof DeclaratorASTNode)) {
                    // if (!(currentNode instanceof FunctionCallASTNode)) {
                    throw new RuntimeException("Node Hierarchy is broken! Expected PostFixExpressionASTNode");
                }

                ascend();

            }
        }
    }

    @Override
    public void enterAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        String operatorAsString = ctx.getChild(1).getText();

        ExpressionASTNode exprASTNode = new ExpressionASTNode();
        exprASTNode.expressionType = ExpressionType.fromString(operatorAsString);
        exprASTNode.astNodeType = ASTNodeType.EXPRESSION;

        // processExpressionOperator(ctx, ExpressionType.Add);

        connectToParent(currentNode, exprASTNode);
        descend(exprASTNode);
    }

    @Override
    public void exitAdditiveExpression(CPP14Parser.AdditiveExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }
        // processExpressionOperator(ctx, ExpressionType.Add);

        ascend();
    }

    @Override
    public void enterMultiplicativeExpression(CPP14Parser.MultiplicativeExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        String operatorAsString = ctx.getChild(1).getText();

        ExpressionASTNode exprASTNode = new ExpressionASTNode();
        exprASTNode.expressionType = ExpressionType.fromString(operatorAsString);
        exprASTNode.astNodeType = ASTNodeType.EXPRESSION;

        // processExpressionOperator(ctx, ExpressionType.fromString(operatorAsString));

        connectToParent(currentNode, exprASTNode);
        descend(exprASTNode);
    }

    @Override
    public void exitMultiplicativeExpression(CPP14Parser.MultiplicativeExpressionContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        if (ctx.children.size() == 1) {
            return;
        }

        ascend();
    }

    @Override
    public void enterEqualityExpression(CPP14Parser.EqualityExpressionContext ctx) {

        if (ctx.children.size() == 1) {
            return;
        }

        String operatorAsString = ctx.getChild(1).getText();

        ExpressionASTNode exprASTNode = new ExpressionASTNode();
        exprASTNode.expressionType = ExpressionType.fromString(operatorAsString);
        exprASTNode.astNodeType = ASTNodeType.EXPRESSION;

        // processExpressionOperator(ctx, ExpressionType.Add);

        connectToParent(currentNode, exprASTNode);
        descend(exprASTNode);
    }

    @Override
    public void exitEqualityExpression(CPP14Parser.EqualityExpressionContext ctx) {
        if (ctx.children.size() == 1) {
            return;
        }
        ascend();
    }

    // Loops

    @Override
    public void enterIterationStatement(CPP14Parser.IterationStatementContext ctx) {

        IterationStatementASTNode iterationStatementASTNode = new IterationStatementASTNode();
        iterationStatementASTNode.ctx = ctx;
        iterationStatementASTNode.value = ctx.getText();
        iterationStatementASTNode.statementType = StatementType.valueOf(ctx.getChild(0).getText().toUpperCase());
        iterationStatementASTNode.astNodeType = ASTNodeType.ITERATION_STATEMENT;

        connectToParent(currentNode, iterationStatementASTNode);
        descend(iterationStatementASTNode);
    }

    @Override
    public void exitIterationStatement(CPP14Parser.IterationStatementContext ctx) {
        ascend();
    }

    // Jump Statements

    @Override
    public void enterJumpStatement(CPP14Parser.JumpStatementContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        // if (ctx.getStart().getType() == CPP14Parser.Break) {
        // System.out.printn("test");
        // }

        switch (ctx.getStart().getType()) {

            case CPP14Parser.Break: {

                JumpStatementASTNode breakASTNode = new JumpStatementASTNode();
                breakASTNode.ctx = ctx;
                breakASTNode.value = ctx.getText();
                breakASTNode.statementType = StatementType.valueOf(ctx.getChild(0).getText().toUpperCase());
                breakASTNode.astNodeType = ASTNodeType.JUMP_STATEMENT;

                connectToParent(currentNode, breakASTNode);
                descend(breakASTNode);
            }
                break;

            case CPP14Parser.Return: {

                JumpStatementASTNode returnASTNode = new JumpStatementASTNode();
                returnASTNode.ctx = ctx;
                returnASTNode.value = ctx.getText();
                returnASTNode.statementType = StatementType.valueOf(ctx.getChild(0).getText().toUpperCase());
                returnASTNode.astNodeType = ASTNodeType.RETURN;

                connectToParent(currentNode, returnASTNode);
                descend(returnASTNode);
            }
                break;

            default:
                throw new RuntimeException(
                        "Unknown Jump-Statement Type: " + ctx.getStart().getType() + "! Lookup: CPP14Parser.java!");
        }
    }

    @Override
    public void exitJumpStatement(CPP14Parser.JumpStatementContext ctx) {
        ascend();
    }

    // selection statements (if)

    @Override
    public void enterSelectionStatement(CPP14Parser.SelectionStatementContext ctx) {

        // System.out.println("[" + ctx.hashCode() + "] " + ctx.getText());

        switch (ctx.getStart().getType()) {

            case CPP14Parser.If: {
                SelectionStatementASTNode selectionStatementASTNode = new SelectionStatementASTNode();
                selectionStatementASTNode.ctx = ctx;
                selectionStatementASTNode.value = ctx.getText();
                selectionStatementASTNode.statementType = StatementType
                        .valueOf(ctx.getChild(0).getText().toUpperCase());
                selectionStatementASTNode.astNodeType = ASTNodeType.SELECTION_STATEMENT;

                connectToParent(currentNode, selectionStatementASTNode);
                descend(selectionStatementASTNode);
            }
                break;

            default:
                throw new RuntimeException(
                        "Unknown Selection-Statement Type: " + ctx.getStart().getType()
                                + "! Lookup: CPP14Parser.java!");
        }
    }

    @Override
    public void exitSelectionStatement(CPP14Parser.SelectionStatementContext ctx) {
        ascend();
    }

    // utility

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
