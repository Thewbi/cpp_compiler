package ast;

public class MemberDeclarationASTNode extends DeclaratorASTNode {

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[MemberDeclaration] ");
        // stringBuilder.append(type).append(" ");
        // stringBuilder.append(value).append("\n");
        stringBuilder.append("name='").append(value).append("' ");
        if (type != null) {
            stringBuilder.append("type='").append(type).append("' ");
        }
        stringBuilder.append("is-pointer=").append(isPointer).append(" ");
        stringBuilder.append("is-array=").append(isArray);
        stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
