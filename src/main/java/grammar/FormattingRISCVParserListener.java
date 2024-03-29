package grammar;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.RISCVParser.Label_definitionContext;
import com.cpp.grammar.RISCVParser.MnemonicContext;
import com.cpp.grammar.RISCVParser.ParamContext;
import com.cpp.grammar.RISCVParserBaseListener;

public class FormattingRISCVParserListener extends RISCVParserBaseListener {

    private static final String SPACE_BUDGET = "                                             ";
    private static final int COLUMN_1 = 4;
    private static final int COLUMN_2 = 10;

    private StringBuilder stringBuilder = new StringBuilder();

    private void clearBuffer() {
        stringBuilder.setLength(0);
    }

    private void addToBuffer(final String data) {
        stringBuilder.append(data);
    }

    private void addToBuffer(final int column, final String data) {

        int currentColumn = stringBuilder.length();

        if (currentColumn > column) {
            throw new RuntimeException("Column not possible!");
        }

        stringBuilder.append(SPACE_BUDGET, currentColumn, column);

        stringBuilder.append(data);
    }

    private void outputBuffer() {
        System.out.print(stringBuilder.toString());
    }

    @Override
    public void enterNewline(RISCVParser.NewlineContext ctx) {
        System.out.println("");
    }

    @Override
    public void exitNewline(RISCVParser.NewlineContext ctx) {
    }

    @Override
    public void enterRow(RISCVParser.RowContext ctx) {
        clearBuffer();
    }

    @Override
    public void enterPreprocessor_directive(RISCVParser.Preprocessor_directiveContext ctx) {
    }

    @Override
    public void exitPreprocessor_directive(RISCVParser.Preprocessor_directiveContext ctx) {
    }

    @Override
    public void enterInstruction_row(RISCVParser.Instruction_rowContext ctx) {
        Label_definitionContext label_definitionContext = ctx.label_definition();
        if (label_definitionContext != null) {
            System.out.print(label_definitionContext.getText());
        }
    }

    @Override
    public void exitInstruction_row(RISCVParser.Instruction_rowContext ctx) {
    }

    @Override
    public void enterInstruction(RISCVParser.InstructionContext ctx) {

        MnemonicContext mnemonicContext = ctx.mnemonic();

        addToBuffer(COLUMN_1, mnemonicContext.getText());
        addToBuffer(COLUMN_2, "");

        int idx = 0;
        for (ParamContext param : ctx.param()) {

            if (idx != 0) {
                addToBuffer(", ");
            }

            addToBuffer(param.getText());

            idx++;
        }
        outputBuffer();
    }

    @Override
    public void exitInstruction(RISCVParser.InstructionContext ctx) {
    }

    @Override
    public void enterAsm_intrinsic_instruction(RISCVParser.Asm_intrinsic_instructionContext ctx) {

        ParseTree parseTree = ctx.getChild(1);
        TerminalNodeImpl terminalNodeImpl = (TerminalNodeImpl) parseTree;
        Token symbol = terminalNodeImpl.getSymbol();

        switch (symbol.getType()) {

            case RISCVParser.ALIGN:
                addToBuffer(COLUMN_1, ".align ");
                addToBuffer(ctx.getChild(2).getText());
                outputBuffer();
                break;

            case RISCVParser.FILE:
                addToBuffer(COLUMN_1, ".file ");
                addToBuffer(ctx.getChild(2).getText());
                outputBuffer();
                break;

            case RISCVParser.GLOBL:
                addToBuffer(COLUMN_1, ".globl ");
                addToBuffer(ctx.getChild(2).getText());
                outputBuffer();
                break;

            case RISCVParser.IDENT:
                addToBuffer(COLUMN_1, ".ident ");
                addToBuffer(ctx.getChild(2).getText());
                outputBuffer();
                break;

            case RISCVParser.OPTION:
                addToBuffer(COLUMN_1, ".option ");
                addToBuffer(ctx.getChild(2).getText());
                outputBuffer();
                break;

            case RISCVParser.TEXT:
                addToBuffer(COLUMN_1, ".text");
                outputBuffer();
                break;

            case RISCVParser.TYPE:
                addToBuffer(COLUMN_1, ".type ");
                addToBuffer(ctx.getChild(2).getText());
                addToBuffer(", ");
                addToBuffer(ctx.getChild(4).getText());
                outputBuffer();
                break;

            case RISCVParser.SIZE:
                addToBuffer(COLUMN_1, ".size ");
                addToBuffer(ctx.getChild(2).getText());
                addToBuffer(", ");
                addToBuffer(ctx.getChild(4).getText());
                outputBuffer();
                break;

            default:
                break;
        }
    }

    @Override
    public void exitAsm_intrinsic_instruction(RISCVParser.Asm_intrinsic_instructionContext ctx) {
    }

}
