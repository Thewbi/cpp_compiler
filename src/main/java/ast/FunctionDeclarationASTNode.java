package ast;

public class FunctionDeclarationASTNode extends ASTNode {

    public String returnType;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[FUNC_DECL] name='").append(value).append("' return-type=").append(returnType);
        stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
