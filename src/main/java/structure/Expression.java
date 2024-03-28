package structure;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private Expression parent;

    private Integer intValue;

    private ExpressionType expressionType = ExpressionType.UNKNOWN;

    private List<Expression> children = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        toString(stringBuilder, 0);

        return stringBuilder.toString();
    }

    public void toString(StringBuilder stringBuilder, int indent) {

        stringBuilder.append("\n");

        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }

        stringBuilder.append("Type: ").append(expressionType);

        switch (expressionType) {

            case INT_LITERAL:
                stringBuilder.append(" Value: ").append(intValue);
                break;

            default:
                break;
        }

        for (Expression child : children) {
            child.toString(stringBuilder, indent + 1);
        }

    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public void setExpressionType(ExpressionType expressionType) {
        this.expressionType = expressionType;
    }

    public List<Expression> getChildren() {
        return children;
    }

    public Expression getParent() {
        return parent;
    }

    public void setParent(Expression parent) {
        this.parent = parent;
    }

}
