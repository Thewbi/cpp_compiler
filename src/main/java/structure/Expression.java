package structure;

import java.util.ArrayList;
import java.util.List;

import types.FuncDecl;

public class Expression {

    private Expression parent;

    private List<Expression> children = new ArrayList<>();

    private ExpressionType expressionType = ExpressionType.UNKNOWN;

    private Integer intValue;

    private Float floatValue;

    private String stringValue;

    private String charValue;

    private FuncDecl funcDeclValue;

    private String identifierValue;

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

            case FLOAT_LITERAL:
                stringBuilder.append(" Value: ").append(floatValue);
                break;

            case STRING_LITERAL:
                stringBuilder.append(" Value: ").append(stringValue);
                break;

            case CHAR_LITERAL:
                stringBuilder.append(" Value: ").append(charValue);
                break;

            case FUNCTION_CALL:
                stringBuilder.append(" Value: ");
                funcDeclValue.toString(stringBuilder, indent+1);
                break;

            case IDENTIFIER:
                stringBuilder.append(" Value: ").append(identifierValue);
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

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    public FuncDecl getFuncDeclValue() {
        return funcDeclValue;
    }

    public void setFuncDeclValue(FuncDecl funcDeclValue) {
        this.funcDeclValue = funcDeclValue;
    }

    public String getIdentifierValue() {
        return identifierValue;
    }

    public void setIdentifierValue(String identifierValue) {
        this.identifierValue = identifierValue;
    }

}
