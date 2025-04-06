package ast;

public class DeclaratorASTNode extends ASTNode {

    public boolean isPointer;

    public String type;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[INIT_DECL] name='").append(value).append("' type='").append(type).append("' is-pointer=").append(isPointer);
        stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
