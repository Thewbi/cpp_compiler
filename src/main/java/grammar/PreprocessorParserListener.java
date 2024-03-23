package grammar;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.PreprocessorParserBaseListener;

public class PreprocessorParserListener extends PreprocessorParserBaseListener {

    private int indent;

    private StringBuilder stringBuilder;

    private boolean insert;

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
        System.out.println(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
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
                stringBuilder.append(node.getText());
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

}
