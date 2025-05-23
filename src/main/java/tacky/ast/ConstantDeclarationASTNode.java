package tacky.ast;

import ast.ASTNode;

public class ConstantDeclarationASTNode extends TACKYASTNode {

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[constant_declaration]");

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
