package grammar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.IOException;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.PreprocessorParserBaseListener;

public class PreprocessorParserListener extends PreprocessorParserBaseListener {

    private int indent;

    private StringBuilder stringBuilder;

    private boolean insert = true;

    private List<String> processedIncludeFiles;

    @Override
    public void enterPinclude(PreprocessorParser.PincludeContext ctx) {
        // System.out.println("");
        TerminalNode terminalNode = ctx.PINCLUDEPTEXT().get(0);

        String filename = terminalNode.getText();
        filename = filename.substring(1);

        System.out.println("Including: \"" + filename + "\"");

        if (!processedIncludeFiles.contains(filename)) {
        //if (!processedIncludeFiles.contains("test2.h")) {

            try {

                processedIncludeFiles.add(filename);
                Main.preProcessor("src/test/resources/" + filename, processedIncludeFiles, stringBuilder);

                // processedIncludeFiles.add("test2.h");
                // Main.preProcessor("src/test/resources/test2.h", processedIncludeFiles, stringBuilder);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        insert = false;
    }

    @Override
    public void exitPinclude(PreprocessorParser.PincludeContext ctx) {
        insert = true;
    }

    @Override
    public void enterPifdef(PreprocessorParser.PifdefContext ctx) {
        insert = false;
    }

    @Override
    public void exitPifdef(PreprocessorParser.PifdefContext ctx) {
        insert = true;
    }

    @Override
    public void enterPelse(PreprocessorParser.PelseContext ctx) {
        insert = false;
    }

    @Override
    public void exitPelse(PreprocessorParser.PelseContext ctx) {
        insert = true;
    }

    @Override
    public void enterPendif(PreprocessorParser.PendifContext ctx) {
        insert = false;
    }

    @Override
    public void exitPendif(PreprocessorParser.PendifContext ctx) {
        insert = true;
    }

    @Override
    public void exitCode_block(PreprocessorParser.Code_blockContext ctx) {
        // System.out.println(stringBuilder.toString());
        // stringBuilder.delete(0, stringBuilder.length());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        printIndent();
        System.out.println(ctx.getClass().getSimpleName() + " [" + ctx.getStart().getText() + "]");
        descend();
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        ascend();
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // descend();
        // printIndent();
        // System.out.println(node.getText());
        // ascend();

        if (stringBuilder != null) {
            if (insert) {

                if (StringUtils.equalsIgnoreCase(node.getText(), "<EOF>")) {

                } else {
                    stringBuilder.append(node.getText());
                }
            }
        }
    }

    private void descend() {
        indent++;
    }

    private void ascend() {
        indent--;
    }

    private void printIndent() {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void setProcessedIncludeFiles(List<String> processedIncludeFiles) {
        this.processedIncludeFiles = processedIncludeFiles;
    }

}
