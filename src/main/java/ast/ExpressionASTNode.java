package ast;

public class ExpressionASTNode extends ASTNode {

    public ExpressionType expressionType = ExpressionType.UNKNOWN;

    public ExpressionASTNode lhs;

    public ExpressionASTNode rhs;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[EXPR] type='").append(expressionType).append("' ");

        // if ((lhs != null) && (rhs != null)) {
        //     // stringBuilder.append("lhs=");
        //     stringBuilder.append("\n");
        //     lhs.printRecursive(stringBuilder, indent + 1);
        //     // stringBuilder.append("rhs=");
        //     rhs.printRecursive(stringBuilder, indent + 1);
        // }

        if (value != null) {
            stringBuilder.append("value='").append(value).append("' ");
        }

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1, addLineBreak);
        }
    }

}
