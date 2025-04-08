package ast;

import grammar.StorageSpecifier;

public class DeclarationListASTNode extends ASTNode {

    public StorageSpecifier storageSpecifier;

    public DeclarationSpecifier declarationSpecifier;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[DECL_LIST] ");
        if ((null != declarationSpecifier) && (DeclarationSpecifier.UNKNOWN != declarationSpecifier)) {
            stringBuilder.append("declaration-spec='").append(declarationSpecifier).append("' ");
        }
        if ((null != storageSpecifier) && (StorageSpecifier.UNKNOWN != storageSpecifier)) {
            stringBuilder.append("storage-spec='").append(storageSpecifier).append("' ");
        }
        stringBuilder.append("type='").append(type).append("' ");
        stringBuilder.append("\n");

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
