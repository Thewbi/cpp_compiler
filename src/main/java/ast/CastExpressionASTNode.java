package ast;

public class CastExpressionASTNode extends ExpressionASTNode {

    public ExpressionASTNode castTypeExpression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[CAST] \n");

        for (int i = 0; i < indent+1; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("cast-target-type: ");
        // for (int i = 0; i < indent+2; i++) {
        //     stringBuilder.append("  ");
        // }
        castTypeExpression.printRecursive(stringBuilder, 0, true);
        // stringBuilder.append("' ");

        for (int i = 0; i < indent+1; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("cast-source: ");
        rhs.printRecursive(stringBuilder, 0, true);
        // stringBuilder.append("'");

        // if (value != null) {
        //     stringBuilder.append(value);
        // }
        // stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
