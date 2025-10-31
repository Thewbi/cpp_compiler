package tacky.ast;

import ast.ASTNode;

public class FunctionCallASTNode extends TACKYASTNode {

    public String returnVariable;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[function_call] name: \"").append(value).append("\"");

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // indent
        for (int i = 0; i < indent + 1; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("returnVariable = \"").append(returnVariable).append("\"\n");

        // expression.printRecursive(stringBuilder, indent + 1);

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }
    
}
