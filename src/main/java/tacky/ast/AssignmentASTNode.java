package tacky.ast;

import ast.ASTNode;
import ast.ExpressionASTNode;

public class AssignmentASTNode extends TACKYASTNode {

    public String lhs;

    public ExpressionASTNode expression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[assignment_stmt]");

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        for (int i = 0; i < indent + 1; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("lhs = \"").append(lhs).append("\"\n");

        expression.printRecursive(stringBuilder, indent + 1);

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
