package tacky.ast;

public class LoadFromAddressASTNode extends TACKYASTNode {

    public String ptrVariableName;

    public String variableName;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[Load()] ").append(variableName).append(" = *(").append(ptrVariableName).append(")");

        stringBuilder.append("\n");

    }

}
