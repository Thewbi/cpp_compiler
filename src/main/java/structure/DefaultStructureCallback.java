package structure;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import types.FuncDecl;
import types.Type;

public class DefaultStructureCallback implements StructureCallback {

    private List<Expression> expressions = new ArrayList<>();

    Expression currentExpression;

    @Override
    public void startScope() {
        System.out.println("[STR-CB] startScope()");
    }

    @Override
    public void endScope() {
        System.out.println("[STR-CB] endScope()");
    }

    @Override
    public void functionCall(String name, FuncDecl funcDecl) {
        System.out.println("[STR-CB] functionCall()");
        startScope();
    }

    @Override
    public void variableDeclaration(String name, Type type) {
        System.out.println("[STR-CB] variableDeclaration() Name: \"" + name + "\" Type: " + type);

        expressions.clear();
    }

    @Override
    public void variableAssignment(String name) {
        System.out.println("[STR-CB] variableAssignment() Name: \"" + name + "\" \nExpressions: " + expressions);

        expressions.clear();
    }

    @Override
    public void addExpression() {
        // System.out.println("[STR-CB] addExpression()");

        Expression expression = new Expression();

        if (CollectionUtils.isEmpty(expressions)) {
            expressions.add(expression);
        } else {
            // Expression lastExpression = expressions.get(expressions.size()-1);
            currentExpression.getChildren().add(expression);
            expression.setParent(currentExpression);
        }

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

        if (CollectionUtils.isEmpty(expressions)) {
            // throw new RuntimeException("no parent found!");
            expressions.add(expression);
        } else {
            currentExpression.getChildren().add(expression);
            expression.setParent(currentExpression);
        }
    }

    @Override
    public void stringLiteral(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stringLiteral'");
    }

    @Override
    public void charLiteral(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'charLiteral'");
    }

    @Override
    public void floatLiteral(Float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'floatLiteral'");
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

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    

}
