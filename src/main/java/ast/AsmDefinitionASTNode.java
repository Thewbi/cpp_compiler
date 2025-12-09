package ast;

import java.util.ArrayList;
import java.util.List;

public class AsmDefinitionASTNode extends StatementASTNode {

    public List<String> asmLines = new ArrayList<>();

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("[ASM] \n");

        // output the asm lines
        for (String asmLine : asmLines) {
            stringBuilder.append(asmLine);
        }

    }
}
