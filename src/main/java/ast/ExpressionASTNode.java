package ast;

public class ExpressionASTNode extends ASTNode {

    public ExpressionType expressionType = ExpressionType.Unknown;

    public ExpressionASTNode lhs;

    public ExpressionASTNode rhs;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        //stringBuilder.append("[EXPR] name='").append(value).append("' is-pointer=").append(isPointer);
        stringBuilder.append("[EXPR] type='").append(expressionType).append("' ").append(value);
        stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
