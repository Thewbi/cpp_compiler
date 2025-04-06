package ast;

public class PostFixExpressionASTNode extends ExpressionASTNode {

    public ExpressionASTNode name;

    public ExpressionASTNode list;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[EXPR_POSTFIX] name='").append(name.value).append("' "); //.append(value);
        stringBuilder.append("\n");

        list.printRecursive(stringBuilder, indent + 1);

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
