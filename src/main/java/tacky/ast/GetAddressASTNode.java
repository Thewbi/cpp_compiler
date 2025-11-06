package tacky.ast;

public class GetAddressASTNode extends TACKYASTNode {

    public String variableName;

    public String ptrVariableName;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[GetAddress()] ").append(ptrVariableName).append(" = *(").append(variableName).append(")");

        stringBuilder.append("\n");

    }

}
