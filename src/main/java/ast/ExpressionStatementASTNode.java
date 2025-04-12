package ast;

public class ExpressionStatementASTNode extends ExpressionASTNode {

    public ExpressionASTNode expression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[EXPR-STMT] type='").append(expressionType).append("' ");
        stringBuilder.append("\n");

        if (expression != null) {
            expression.printRecursive(stringBuilder, indent + 1);
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1, addLineBreak);
        }
    }

}
