package ast;

public class IterationStatementASTNode extends StatementASTNode {

    /* left expresion that initializes */
    public ExpressionASTNode initExpression;

    /* middle condition of a for loop */
    public ExpressionASTNode condition;

    /* right expression of a for loop */
    public ExpressionASTNode expression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[" + statementType.name() + "] ");
        stringBuilder.append("\n");

        // for-loop first part
        if (initExpression != null) {
            for (int i = 0; i < indent+1; i++) {
                stringBuilder.append("  ");
            }
            stringBuilder.append("[INIT-EXPR] \n");
            initExpression.printRecursive(stringBuilder, indent + 2);
            // stringBuilder.append("\n");
        }

        // for-loop second part
        if (condition != null) {
            condition.printRecursive(stringBuilder, indent + 1);
            // stringBuilder.append("\n");
        }

        // for-loop third part
        if (expression != null) {
            expression.printRecursive(stringBuilder, indent + 1);
            // stringBuilder.append("\n");
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
