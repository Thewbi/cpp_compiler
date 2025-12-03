package tacky.ast;

import ast.ASTNode;
import tacky.generation.riscv.RISCVStackEntry;
import tacky.generation.riscv.RISCVStackFrame;

public class VariableDeclarationASTNode extends TACKYASTNode {

    public String variableSymbolName;

    public String variableName;

    public RISCVStackEntry stackEntry;

    public boolean isArray;

    public int arraySize;

    public RISCVStackEntry addToStackFrame(RISCVStackFrame stackFrame) {
        stackEntry = stackFrame.addVariable(variableName, isArray, arraySize);
        return stackEntry;
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[variable_declaration] symbol_name: \"").append(variableSymbolName)
                .append("\" var_name: \"").append(variableName).append("\"");

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1);
        }
    }

}
