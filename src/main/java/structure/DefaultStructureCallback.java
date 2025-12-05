package structure;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.collections4.CollectionUtils;

import types.FormalParameter;
import types.FuncDecl;
import types.Type;

public class DefaultStructureCallback implements StructureCallback {

    private List<Expression> expressions = new ArrayList<>();

    private Expression currentExpression;

    @Override
    public void startScope() {
        // DEBUG
        // System.out.println("[STR-CB] startScope()");
    }

    @Override
    public void endScope() {
        // DEBUG
        // System.out.println("[STR-CB] endScope()");
    }

    @Override
    public void functionCall(String name, FuncDecl funcDecl) {

        List<Expression> expressionList = new ArrayList<>();

        List<FormalParameter> params = funcDecl.getParams();
        // iterate in reverse
        ListIterator<FormalParameter> literator = funcDecl.getParams().listIterator(funcDecl.getParams().size());
        while (literator.hasPrevious()) {

            FormalParameter formalParameter = (FormalParameter) literator.previous();

            Expression actualParameter = expressions.get(expressions.size() - 1);
            expressions.remove(expressions.size() - 1);

            expressionList.add(0, actualParameter);
            actualParameter.setParent(actualParameter);
        }

        Expression expression = new Expression();
        expression.setExpressionType(ExpressionType.RETURN_VALUE_PREVIOUS_CALL);
        expressions.add(expression);

        // System.out.println("[STR-CB] functionCall() Name: \"" + name + "\" Params: " + expressionList);

        startScope();
        System.out.println("");
    }

    @Override
    public void functionDeclaration(FuncDecl funcDecl) {
        // System.out.println("[STR-CB] functionDeclaration() " + funcDecl);
        clearExpressions();
        // System.out.println("");
    }

    @Override
    public void variableDeclaration(String name, Type type) {
        // System.out.println("[STR-CB] variableDeclaration() Name: \"" + name + "\" Type: " + type);
        // System.out.println("");
    }

    @Override
    public void variableAssignment(String name) {
        // System.out.println("[STR-CB] variableAssignment() Name: \"" + name + "\" \nExpressions: " + expressions);
        clearExpressions();
        // System.out.println("");
    }

    @Override
    public void returnStatement() {
        // System.out.println("[STR-CB] returnStatement() \nExpressions: " + expressions);
        clearExpressions();
        // System.out.println("");
    }

    @Override
    public void addExpression() {
        // System.out.println("[STR-CB] addExpression()");

        Expression expression = new Expression();
        connectExpression(expression);

        currentExpression = expression;
    }

    @Override
    public void multExpression() {
        // System.out.println("[STR-CB] multExpression()");
    }

    @Override
    public void ascendExpression() {
        currentExpression = currentExpression.getParent();
    }

    @Override
    public void intLiteral(Integer value) {
        Expression expression = new Expression();
        expression.setExpressionType(ExpressionType.INT_LITERAL);
        expression.setIntValue(value);
        connectExpression(expression);
    }

    @Override
    public void stringLiteral(String value) {
        Expression expression = new Expression();
        expression.setExpressionType(ExpressionType.STRING_LITERAL);
        expression.setStringValue(value);
        connectExpression(expression);
    }

    @Override
    public void charLiteral(String value) {
        Expression expression = new Expression();
        expression.setExpressionType(ExpressionType.CHAR_LITERAL);
        expression.setCharValue(value);
        connectExpression(expression);
    }

    @Override
    public void floatLiteral(Float value) {
        Expression expression = new Expression();
        expression.setExpressionType(ExpressionType.FLOAT_LITERAL);
        expression.setFloatValue(value);
        connectExpression(expression);
    }

    @Override
    public void identifierLiteral(String value) {
        Expression expression = new Expression();
        expression.setExpressionType(ExpressionType.IDENTIFIER);
        expression.setIdentifierValue(value);
        connectExpression(expression);
    }

    private void connectExpression(Expression expression) {
        if (currentExpression == null || CollectionUtils.isEmpty(expressions)) {
            expressions.add(expression);
        } else {
            currentExpression.getChildren().add(expression);
            expression.setParent(currentExpression);
        }
    }

    @Override
    public void plus() {
        currentExpression.setExpressionType(ExpressionType.ADD);
    }

    @Override
    public void mult() {
        currentExpression.setExpressionType(ExpressionType.MUL);
    }

    @Override
    public void minus() {
        currentExpression.setExpressionType(ExpressionType.SUB);
    }

    @Override
    public void divisor() {
        currentExpression.setExpressionType(ExpressionType.DIV);
    }

    private void clearExpressions() {
        expressions.clear();
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

}
