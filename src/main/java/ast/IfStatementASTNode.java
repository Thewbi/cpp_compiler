package ast;

public class IfStatementASTNode extends StatementASTNode {

    public ExpressionASTNode expression;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {
        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[IF_STMT] expression:\n");
        expression.printRecursive(stringBuilder, indent + 1);

        if (children.size() > 0) {
            ASTNode astNode = children.get(0);
            if (astNode != null) {
                for (int i = 0; i < indent; i++) {
                    stringBuilder.append("  ");
                }
                stringBuilder.append("[IF_STMT TRUE_CASE]\n");
                astNode.printRecursive(stringBuilder, indent + 1);
            }
        }

        if (children.size() > 1) {
            ASTNode astNode = children.get(1);
            if (astNode != null) {
                for (int i = 0; i < indent; i++) {
                    stringBuilder.append("  ");
                }
                stringBuilder.append("[IF_STMT FALSE_CASE]\n");
                astNode.printRecursive(stringBuilder, indent + 1);
            }
        }

        // // all children
        // for (ASTNode child : children) {
        //     child.printRecursive(stringBuilder, indent + 1);
        // }
    }

}
