package grammar;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.PreprocessorParserBaseListener;

public class PreprocessorParserListener extends PreprocessorParserBaseListener {

    private int indent;

    private StringBuilder stringBuilder;

    private boolean insert;

    // @Override
    // public void exitNormal_row(PreprocessorParser.Normal_rowContext ctx) {
    //     System.out.println("\"" + ctx.getText() + "\"");
    // }

    // @Override
    // public void enterPreproc_row(PreprocessorParser.Preproc_rowContext ctx) {
    //     insert = false;
    // }

    // @Override
    // public void exitPreproc_row(PreprocessorParser.Preproc_rowContext ctx) {
    //     insert = true;
    // }

    // @Override
    // public void exitInclude_pcmd(PreprocessorParser.Include_pcmdContext ctx) {
    //     // System.out.println(ctx.StringLiteral());
    //     // System.out.println(ctx.TriStringLiteral());
    // }

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
        descend();
        printIndent();
        System.out.println(node.getText());
        ascend();

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
