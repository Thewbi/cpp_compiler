package tacky.ast;

import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;

public class FunctionDefinitionASTNode extends TACKYASTNode {

    public List<VariableDeclarationASTNode> localVariables = new ArrayList<>();

    public boolean global;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[function_definition] name: \"").append(value).append("\" global: ").append(global);

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // // DEBUG: print all local variables
        // for (ASTNode localVariable : localVariables) {
        //     localVariable.printRecursive(stringBuilder, indent + 1);
        // }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
