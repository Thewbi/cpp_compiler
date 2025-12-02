package tacky.ast;

public class SizeofASTNode extends TACKYASTNode {

    public String sizeOfType;

    public String targetVariableName;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[Sizeof()] ").append(type).append(" = *(").append(targetVariableName).append(")");

        stringBuilder.append("\n");

    }

}
