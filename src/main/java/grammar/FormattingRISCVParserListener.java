package grammar;

import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.RISCVParserBaseListener;

public class FormattingRISCVParserListener extends RISCVParserBaseListener {

    @Override
    public void enterRow(RISCVParser.RowContext ctx) {
        System.out.println("row: " + ctx.getText());
    }

}
