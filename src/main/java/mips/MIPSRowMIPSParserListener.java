package mips;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;

import com.cpp.grammar.MIPSParser.MnemonicContext;
import com.cpp.grammar.MIPSParser.ExpressionContext;
import com.cpp.grammar.MIPSParser;
import com.cpp.grammar.MIPSParser.Label_nameContext;
import com.cpp.grammar.MIPSParser.Offset_expressionContext;
import com.cpp.grammar.MIPSParser.RegisterContext;
import com.cpp.grammar.MIPSParserBaseListener;

public class MIPSRowMIPSParserListener extends MIPSParserBaseListener {

    private List<MIPSRow> rows = new ArrayList<>();

    private MIPSRow row = new MIPSRow();

    private Vocabulary vocab = MIPSParser.VOCABULARY;

    private int line;

    @Override
    public void enterLabel_definition(MIPSParser.Label_definitionContext ctx) {
        final String text = ctx.label_name().getText();
        row.setLabel(text);
    }

    @Override
    public void enterInstruction(MIPSParser.InstructionContext ctx) {

        MnemonicContext mnemonicContext = ctx.mnemonic();

        String mnemonic = mnemonicContext.getText();
        row.setInstruction(mnemonic);

        // addToBuffer(COLUMN_1, StringUtils.lowerCase(mnemonicContext.getText()));
        // addToBuffer(COLUMN_2, "");

        // int idx = 0;
        // for (ParamContext param : ctx.param()) {

        // System.out.println(param.getText());

        // idx++;
        // }
    }

    // @Override
    // public void
    // enterAsm_intrinsic_instruction(MIPSParser.Asm_intrinsic_instructionContext
    // ctx) {

    // int idx = 0;

    // ParseTree parseTree = ctx.getChild(idx);
    // idx++;

    // TerminalNodeImpl terminalNodeImpl = (TerminalNodeImpl) parseTree;
    // Token symbol = terminalNodeImpl.getSymbol();
    // int tokenType = symbol.getType();

    // String literalName = vocab.getLiteralName(tokenType);
    // // System.out.println(literalName);
    // row.setIntrinsic(literalName);

    // switch (tokenType) {

    // // case MIPSParser.ALIGN:
    // // addToBuffer(COLUMN_1, ".align ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // case MIPSParser.FILE: {
    // // MIPSRowParam MIPSRowParam = new MIPSRowParam();
    // // MIPSRowParam.setLabel(ctx.getChild(idx).getText());
    // // row.getParameters().add(MIPSRowParam);

    // row.getIntrinsicParameters().add(ctx.getChild(idx).getText());
    // }
    // break;

    // // case MIPSParser.GLOBL:
    // // addToBuffer(COLUMN_1, ".globl ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // // case MIPSParser.IDENT:
    // // addToBuffer(COLUMN_1, ".ident ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // // case MIPSParser.OPTION:
    // // addToBuffer(COLUMN_1, ".option ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // // case MIPSParser.TEXT:
    // // addToBuffer(COLUMN_1, ".text");
    // // break;

    // // case MIPSParser.DATA:
    // // addToBuffer(COLUMN_1, ".data");
    // // break;

    // // case MIPSParser.TYPE:
    // // addToBuffer(COLUMN_1, ".type ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // idx++;
    // // addToBuffer(", ");
    // // idx++;
    // // addToBuffer(ctx.getChild(idx).getText());
    // // idx++;
    // // break;

    // // case MIPSParser.SIZE:
    // // addToBuffer(COLUMN_1, ".size ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // idx++;
    // // addToBuffer(", ");
    // // idx++;
    // // addToBuffer(ctx.getChild(idx).getText());
    // // idx++;
    // // break;

    // // case MIPSParser.WORD:
    // // addToBuffer(COLUMN_1, ".word ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // // case MIPSParser.SPACE:
    // // addToBuffer(COLUMN_1, ".space ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // // case MIPSParser.INCLUDE:
    // // addToBuffer(COLUMN_1, ".include ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // // case MIPSParser.STRING_KEYWORD:
    // // addToBuffer(COLUMN_1, ".string ");
    // // addToBuffer(ctx.getChild(idx).getText());
    // // break;

    // default:
    // break;
    // }
    // }

    @Override
    public void enterParam(MIPSParser.ParamContext ctx) {

        // System.out.println(ctx.getClass() + " childcount: " + ctx.getChildCount() + "
        // " + ctx.getText());

        ParseTree parseTree = ctx.getChild(0);

        if (parseTree instanceof Offset_expressionContext) {

            ; // is parsed in child node

        } else if (parseTree instanceof ExpressionContext) {

            MIPSRowParam MIPSRowParam = new MIPSRowParam();
            MIPSRowParam.setExpression(parseTree.getText());

            row.getParameters().add(MIPSRowParam);

        } else if (parseTree instanceof Label_nameContext) {

            MIPSRowParam MIPSRowParam = new MIPSRowParam();
            MIPSRowParam.setLabel(parseTree.getText());

            row.getParameters().add(MIPSRowParam);

        } else if (parseTree instanceof RegisterContext) {

            MIPSRowParam MIPSRowParam = new MIPSRowParam();
            MIPSRowParam.setRegister(parseTree.getText());

            row.getParameters().add(MIPSRowParam);

        } else {

            System.out.println(
                    parseTree.getText() + " " + parseTree.getClass() + " childcount: " + parseTree.getChildCount());

            // MIPSRowParam MIPSRowParam = new MIPSRowParam();
            // MIPSRowParam.setRegister(parseTree.getText());

            // row.getParameters().add(MIPSRowParam);

            throw new RuntimeException("Unknown type!");

        }
    }

    @Override
    public void enterOffset_expression(MIPSParser.Offset_expressionContext ctx) {

        MIPSRowParam MIPSRowParam = new MIPSRowParam();
        MIPSRowParam.setOffset(Integer.parseInt(ctx.offset_expression_amount().getText()));
        MIPSRowParam.setRegister(ctx.offset_expression_register().getText());

        row.getParameters().add(MIPSRowParam);
    }

    @Override
    public void enterNewline(MIPSParser.NewlineContext ctx) {
        line++;
        row.setLine(line);
        rows.add(row);

        // next row
        row = new MIPSRow();
    }

    public List<MIPSRow> getRows() {
        return rows;
    }

    public void setRows(List<MIPSRow> rows) {
        this.rows = rows;
    }

}