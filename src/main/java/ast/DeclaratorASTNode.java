package ast;

public class DeclaratorASTNode extends ASTNode {

    public boolean isPointer;

    public boolean isArray;

    public ExpressionASTNode indexExpression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[INIT_DECL] name='").append(value).append("' is-pointer=").append(isPointer).append("' is-array=").append(isArray);
        stringBuilder.append("\n");

        // for array access
        if (isArray && indexExpression != null) {
            for (int i = 0; i < indent; i++) {
                stringBuilder.append("  ");
            }
            stringBuilder.append("index-expression: \n");
            indexExpression.printRecursive(stringBuilder, indent + 1);
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
