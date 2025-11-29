package grammar;

import tacky.generation.tacky.TackyDataType;

public class ActualParameter {

    public TackyDataType tackyDataType = TackyDataType.UNKNOWN;

    public boolean isVariable;
    public String name; // var name for pointer or variables

    public boolean isConstant;
    public int intValue; // a value field for constants
    public String stringValue;

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        String indent1 = "";
        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            indent1 += "  ";
        }

        String indent2 = indent1 + "  ";

        // @formatter:off
        stringBuilder.append(indent1).append("[actual_param] ").append("\n");

        stringBuilder.append(indent2).append("isVariable: \"").append(isVariable).append(" ").append("\n");
        stringBuilder.append(indent2).append("name: \"").append(name).append(" ").append("\n");

        stringBuilder.append(indent2).append("isConstant: \"").append(isConstant).append(" ").append("\n");
        stringBuilder.append(indent2).append("intValue: \"").append(intValue).append(" ").append("\n");
        stringBuilder.append(indent2).append("stringValue: \"").append(stringValue).append(" ").append("\n");

        // @formatter:on
    }
}
