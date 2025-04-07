package ast;

public class UnaryOperatorExpressionASTNode extends ExpressionASTNode {
    
    public void printRecursive(final StringBuilder stringBuilder, final int indent) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[EXPR] type='").append(expressionType).append("' ");
        
        if (value != null) {
            stringBuilder.append(value);
        }
        stringBuilder.append("\n");

        if (rhs != null) {
            rhs.printRecursive(stringBuilder, indent + 1);
        }
        // stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
