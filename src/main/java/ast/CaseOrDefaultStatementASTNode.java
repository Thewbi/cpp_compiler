package ast;

import java.lang.Thread.State;

public class CaseOrDefaultStatementASTNode extends StatementASTNode {

    public ExpressionASTNode expression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[" + statementType + "_STMT] ").append(value).append("\n");

        if (statementType == StatementType.CASE) {
            // stringBuilder.append("expression:\n");
            expression.printRecursive(stringBuilder, indent + 1);
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
