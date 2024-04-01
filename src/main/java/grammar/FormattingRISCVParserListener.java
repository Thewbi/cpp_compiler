package grammar;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.RISCVParser.MnemonicContext;
import com.cpp.grammar.RISCVParser.ParamContext;
import com.cpp.grammar.RISCVParserBaseListener;

public class FormattingRISCVParserListener extends RISCVParserBaseListener {

    private static final String SPACE_BUDGET = "                                             ";
    private static final int COLUMN_0 = 0;
    private static final int COLUMN_1 = 10;
    private static final int COLUMN_2 = 20;
    private static final int COLUMN_3 = 45;

    private StringBuilder stringBuilder = new StringBuilder();

    private void clearBuffer() {
        stringBuilder.setLength(0);
    }

    private void addToBuffer(final String data) {
        stringBuilder.append(data);
    }

    private void addToBuffer(final int column, final String data) {

        int currentColumn = stringBuilder.length();

        if (currentColumn >= column) {
            // throw new RuntimeException("Column not possible!");
            stringBuilder.append(" ");
        } else {
            stringBuilder.append(SPACE_BUDGET, currentColumn, column);
            //stringBuilder.append(SPACE_BUDGET, 0, (column - currentColumn) );
        }

        stringBuilder.append(data);
    }

    private void outputBuffer() {
        System.out.print(stringBuilder.toString());
    }

    @Override public void enterAsm_file(RISCVParser.Asm_fileContext ctx) { }
	
	@Override public void exitAsm_file(RISCVParser.Asm_fileContext ctx) { 
        outputBuffer();
        clearBuffer();
    }

    @Override
    public void enterNewline(RISCVParser.NewlineContext ctx) {
        addToBuffer("\n");

        outputBuffer();
        clearBuffer();
    }

    @Override
    public void exitNewline(RISCVParser.NewlineContext ctx) {
    }

    @Override public void enterLabel_definition(RISCVParser.Label_definitionContext ctx) { 
        final String text = ctx.getText();
        addToBuffer(text);
    }
	@Override public void exitLabel_definition(RISCVParser.Label_definitionContext ctx) { }

    @Override public void enterConst_list(RISCVParser.Const_listContext ctx) {
        addToBuffer(COLUMN_1, ctx.getText());
     }
	@Override public void exitConst_list(RISCVParser.Const_listContext ctx) { }

    @Override
    public void enterRow(RISCVParser.RowContext ctx) {
    }

    @Override
    public void exitRow(RISCVParser.RowContext ctx) {
    }

    @Override
    public void enterComment(RISCVParser.CommentContext ctx) {
        final String text = ctx.getText();
        addToBuffer(COLUMN_3, text);
    }

    @Override
    public void exitComment(RISCVParser.CommentContext ctx) {
    }

    @Override
    public void enterPreprocessor_directive(RISCVParser.Preprocessor_directiveContext ctx) {
    }

    @Override
    public void exitPreprocessor_directive(RISCVParser.Preprocessor_directiveContext ctx) {
    }

    @Override
    public void enterInstruction_row(RISCVParser.Instruction_rowContext ctx) {
    }

    @Override
    public void exitInstruction_row(RISCVParser.Instruction_rowContext ctx) {
    }

    @Override
    public void enterInstruction(RISCVParser.InstructionContext ctx) {

        MnemonicContext mnemonicContext = ctx.mnemonic();

        addToBuffer(COLUMN_1, StringUtils.lowerCase(mnemonicContext.getText()));
        addToBuffer(COLUMN_2, "");

        int idx = 0;
        for (ParamContext param : ctx.param()) {

            if (idx != 0) {
                addToBuffer(", ");
            }

            addToBuffer(param.getText());

            idx++;
        }
    }

    @Override
    public void exitInstruction(RISCVParser.InstructionContext ctx) {
    }

    @Override
    public void enterAsm_intrinsic_instruction(RISCVParser.Asm_intrinsic_instructionContext ctx) {

        int idx = 0;

        // // ignore the DOT
        // idx++;

        ParseTree parseTree = ctx.getChild(idx);
        idx++;

        TerminalNodeImpl terminalNodeImpl = (TerminalNodeImpl) parseTree;
        Token symbol = terminalNodeImpl.getSymbol();

        switch (symbol.getType()) {

            case RISCVParser.ALIGN:
                addToBuffer(COLUMN_1, ".align ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.FILE:
                addToBuffer(COLUMN_1, ".file ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.GLOBL:
                addToBuffer(COLUMN_1, ".globl ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.IDENT:
                addToBuffer(COLUMN_1, ".ident ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.OPTION:
                addToBuffer(COLUMN_1, ".option ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.TEXT:
                addToBuffer(COLUMN_1, ".text");
                break;

            case RISCVParser.DATA:
                addToBuffer(COLUMN_1, ".data");
                break;

            case RISCVParser.TYPE:
                addToBuffer(COLUMN_1, ".type ");
                addToBuffer(ctx.getChild(idx).getText());
                idx++;
                addToBuffer(", ");
                idx++;
                addToBuffer(ctx.getChild(idx).getText());
                idx++;
                break;

            case RISCVParser.SIZE:
                addToBuffer(COLUMN_1, ".size ");
                addToBuffer(ctx.getChild(idx).getText());
                idx++;
                addToBuffer(", ");
                idx++;
                addToBuffer(ctx.getChild(idx).getText());
                idx++;
                break;

            case RISCVParser.WORD:
                addToBuffer(COLUMN_1, ".word ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.SPACE:
                addToBuffer(COLUMN_1, ".space ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.INCLUDE:
                addToBuffer(COLUMN_1, ".include ");
                addToBuffer(ctx.getChild(idx).getText());
                break;

            case RISCVParser.STRING_KEYWORD:
                addToBuffer(COLUMN_1, ".string ");
                addToBuffer(ctx.getChild(idx).getText());
                break;
/*
            case RISCVParser.ADD:
                System.out.println("");
                break;
            case RISCVParser.ADDI:
                System.out.println("");
                break;
            case RISCVParser.BGT:
                System.out.println("");
                break;
            case RISCVParser.CALL:
                System.out.println("");
                break;
            case RISCVParser.J_:
                System.out.println("");
                break;
            case RISCVParser.JR:
                System.out.println("");
                break;
            case RISCVParser.LI:
                System.out.println("");
                break;
            case RISCVParser.LW:
                System.out.println("");
                break;
            case RISCVParser.MV:
                System.out.println("");
                break;
            case RISCVParser.SW:
                System.out.println("");
                break;
            // case RISCVParser.ALIGN:
            //     System.out.println("");
            //     break;
            case RISCVParser.ASTERISK:
                System.out.println("");
                break;
            case RISCVParser.AT:
                System.out.println("");
                break;
            case RISCVParser.CLOSEING_BRACKET:
                System.out.println("");
                break;
            case RISCVParser.COLON:
                System.out.println("");
                break;
            case RISCVParser.COMMA:
                System.out.println("");
                break;
            case RISCVParser.CSEG:
                System.out.println("");
                break;
            // case RISCVParser.DATA:
            //     System.out.println("");
            //     break;
            case RISCVParser.DEF:
                System.out.println("");
                break;
            case RISCVParser.DEVICE:
                System.out.println("");
                break;
            case RISCVParser.DOT:
                System.out.println("");
                break;
            case RISCVParser.ELSE:
                System.out.println("");
                break;
            case RISCVParser.END_MACRO:
                System.out.println("");
                break;
            case RISCVParser.ENDIF:
                System.out.println("");
                break;
            case RISCVParser.EQUALS:
                System.out.println("");
                break;
            case RISCVParser.EQU:
                System.out.println("");
                break;
            case RISCVParser.ERROR:
                System.out.println("");
                break;
            // case RISCVParser.FILE:
            //     System.out.println("");
            //     break;
            case RISCVParser.FUNCTION:
                System.out.println("");
                break;
            // case RISCVParser.GLOBL:
            //     System.out.println("");
            //     break;
            case RISCVParser.GT:
                System.out.println("");
                break;
            case RISCVParser.HASH_TAG:
                System.out.println("");
                break;
            // case RISCVParser.IDENT:
            //     System.out.println("");
            //     break;
            case RISCVParser.IF:
                System.out.println("");
                break;
            // case RISCVParser.INCLUDE:
            //     System.out.println("");
            //     break;
            case RISCVParser.LEFT_SHIFT:
                System.out.println("");
                break;
            case RISCVParser.LT:
                System.out.println("");
                break;
            case RISCVParser.MACRO:
                System.out.println("");
                break;
            case RISCVParser.MINUS:
                System.out.println("");
                break;
            case RISCVParser.NOPIC:
                System.out.println("");
                break;
            case RISCVParser.OPENING_BRACKET:
                System.out.println("");
                break;
            // case RISCVParser.OPTION:
            //     System.out.println("");
            //     break;
            case RISCVParser.ORG:
                System.out.println("");
                break;
            case RISCVParser.PLUS:
                System.out.println("");
                break;
            case RISCVParser.RIGHT_SHIFT:
                System.out.println("");
                break;
            // case RISCVParser.SIZE:
            //     System.out.println("");
            //     break;
            case RISCVParser.SLASH:
                System.out.println("");
                break;
            // case RISCVParser.SPACE:
            //     System.out.println("");
            //     break;
            // case RISCVParser.STRING_KEYWORD:
            //     System.out.println("");
            //     break;
            // case RISCVParser.TEXT:
            //     System.out.println("");
            //     break;
            // case RISCVParser.TYPE:
            //     System.out.println("");
            //     break;
            // case RISCVParser.WORD:
            //     System.out.println("");
            //    break;
            case RISCVParser.NEWLINE:
                System.out.println("");
                break;
            case RISCVParser.WS:
                System.out.println("");
                break;
            case RISCVParser.LINE_COMMENT:
                System.out.println("");
                break;
            case RISCVParser.BLOCK_COMMENT:
                System.out.println("");
                break;
            // case RISCVParser.DOUBLE_SLASH_:
            //     System.out.println("");
            //     break;
            // case RISCVParser.LINE_COMMENT:
            //     System.out.println("");
            //     break;
            case RISCVParser.STRING:
                System.out.println("");
                break;
            case RISCVParser.NUMBER:
                System.out.println("");
                break;
            case RISCVParser.HEX_NUMBER:
                System.out.println("");
                break;
            case RISCVParser.BINARY_NUMBER:
                System.out.println("");
                break;
            case RISCVParser.IDENTIFIER:
                System.out.println("");
                break;
 */
            default:
                break;
        }
    }

    @Override
    public void exitAsm_intrinsic_instruction(RISCVParser.Asm_intrinsic_instructionContext ctx) {
    }

}
