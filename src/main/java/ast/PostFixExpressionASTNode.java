package ast;

/**
 * <pre>
 * i++;
 * </pre>
 */
public class PostFixExpressionASTNode extends ExpressionASTNode {

    public ExpressionASTNode name;

    public ExpressionASTNode list;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[EXPR_POSTFIX] ");

        if (expressionType != null) {
            stringBuilder.append("expressionType='").append(expressionType.toString()).append("' ");
            stringBuilder.append("\n");
        }

        if (lhs != null) {
            lhs.printRecursive(stringBuilder, indent + 1);
        }

        if (name != null) {
            stringBuilder.append("name='").append(name.value).append("' ");
            stringBuilder.append("\n");
        }

        if (list != null) {
            list.printRecursive(stringBuilder, indent + 1);
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
