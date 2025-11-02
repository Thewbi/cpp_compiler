package tacky.ast;

import ast.ASTNode;

public class JumpASTNode extends TACKYASTNode {

    public JumpType jumpType;

    // public String variable;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }

        stringBuilder.append("[jump] type=\"").append(jumpType);
        // if (jumpType == JumpType.JumpIfZero || jumpType == JumpType.JumpIfNotZero) {
        //     stringBuilder.append("\" variable=\"").append(variable);
        // }
        stringBuilder.append("\" target=\"").append(value).append("\"");

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
