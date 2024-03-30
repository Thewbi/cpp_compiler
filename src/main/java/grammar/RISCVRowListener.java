package grammar;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.RISCVParser.MnemonicContext;
import com.cpp.grammar.RISCVParser.Offset_expressionContext;
import com.cpp.grammar.RISCVParser.ExpressionContext;
import com.cpp.grammar.RISCVParser.Label_nameContext;
import com.cpp.grammar.RISCVParserBaseListener;

public class RISCVRowListener extends RISCVParserBaseListener {

    private List<RISCVRow> rows = new ArrayList<>();

    private RISCVRow row = new RISCVRow();

    private Vocabulary vocab = RISCVParser.VOCABULARY;

    @Override
    public void enterLabel_definition(RISCVParser.Label_definitionContext ctx) {
        final String text = ctx.label_name().getText();
        row.setLabel(text);
    }

    @Override
    public void enterInstruction(RISCVParser.InstructionContext ctx) {

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

    @Override
    public void enterAsm_intrinsic_instruction(RISCVParser.Asm_intrinsic_instructionContext ctx) {

        int idx = 0;

        // // ignore the DOT
        // idx++;

        ParseTree parseTree = ctx.getChild(idx);
        idx++;

        TerminalNodeImpl terminalNodeImpl = (TerminalNodeImpl) parseTree;
        Token symbol = terminalNodeImpl.getSymbol();
        int tokenType = symbol.getType();

        String literalName = vocab.getLiteralName(tokenType);
        // System.out.println(literalName);
        row.setIntrinsic(literalName);
    }

    @Override
    public void enterParam(RISCVParser.ParamContext ctx) {

        // System.out.println(ctx.getClass() + " childcount: " + ctx.getChildCount() + " " + ctx.getText());

        ParseTree parseTree = ctx.getChild(0);

        if (parseTree instanceof Offset_expressionContext) {

            ; // is parsed in child node

        } else if (parseTree instanceof ExpressionContext) {

            RISCVRowParam riscVRowParam = new RISCVRowParam();
            riscVRowParam.setExpression(parseTree.getText());

            row.getParameters().add(riscVRowParam);

        } 
        else if (parseTree instanceof Label_nameContext) {

            RISCVRowParam riscVRowParam = new RISCVRowParam();
            riscVRowParam.setLabel(parseTree.getText());

            row.getParameters().add(riscVRowParam);

        } 
        else {

            //System.out.println(parseTree.getText() + " " + parseTree.getClass() + " childcount: " + parseTree.getChildCount());

            RISCVRowParam riscVRowParam = new RISCVRowParam();
            riscVRowParam.setRegister(parseTree.getText());

            row.getParameters().add(riscVRowParam);

        }
    }

    @Override
    public void enterOffset_expression(RISCVParser.Offset_expressionContext ctx) {

        RISCVRowParam riscVRowParam = new RISCVRowParam();
        riscVRowParam.setOffset(Integer.parseInt(ctx.offset_expression_amount().getText()));
        riscVRowParam.setRegister(ctx.offset_expression_register().getText());

        row.getParameters().add(riscVRowParam);
    }

    @Override
    public void enterNewline(RISCVParser.NewlineContext ctx) {
        rows.add(row);
        row = new RISCVRow();
    }

    public List<RISCVRow> getRows() {
        return rows;
    }

    public void setRows(List<RISCVRow> rows) {
        this.rows = rows;
    }

}
