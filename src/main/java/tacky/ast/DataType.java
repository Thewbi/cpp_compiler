package tacky.ast;

public class DataType extends TACKYASTNode {

    public String typeName;

    public boolean isArray;

    public int arraySize;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[data_type] name: \"").append(typeName).append("\"");

        if (isArray) {
            stringBuilder.append(" array: true, arraySize: " + arraySize);
        }

        stringBuilder.append("\n");
    }
    
}
