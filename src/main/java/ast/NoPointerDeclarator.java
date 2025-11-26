package ast;

public class NoPointerDeclarator extends ASTNode {

    public boolean isPointer;

    public boolean isArray;

    public boolean isFunctionCall;

    public ExpressionASTNode indexExpression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[NO_PTR_DECL] ");
        stringBuilder.append("name='").append(value).append("', ");
        if (type != null) {
            stringBuilder.append("type='").append(type).append("', ");
        }
        stringBuilder.append("is-pointer=").append(isPointer).append(", ");
        stringBuilder.append("is-array=").append(isArray).append(", ");
        stringBuilder.append("is-funcCall=").append(isFunctionCall);
        stringBuilder.append("\n");

        // for array access
        if (isArray && indexExpression != null) {
            for (int i = 0; i < indent; i++) {
                stringBuilder.append("  ");
            }
            stringBuilder.append("index-expression: \n");
            indexExpression.printRecursive(stringBuilder, indent + 1);
        }

        if (children.size() > 0) {
            for (int i = 0; i < indent; i++) {
                stringBuilder.append("  ");
            }
            stringBuilder.append("assigned-value: \n");
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }
    
}
