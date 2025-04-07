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
        stringBuilder.append("[CAST] ");
        
        stringBuilder.append("cast-target-type='");
        castTypeExpression.printRecursive(stringBuilder, 0, false);
        stringBuilder.append("' ");
        
        stringBuilder.append("type='");
        rhs.printRecursive(stringBuilder, 0, false);
        stringBuilder.append("'");
        
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
