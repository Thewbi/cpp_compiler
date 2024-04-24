package grammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.MIPSLexer;
import com.cpp.grammar.MIPSParser;
import com.cpp.grammar.MIPSParser.Asm_fileContext;

import mips.MIPSInstructionEncoder;
import mips.MIPSRow;
import mips.MIPSRowMIPSParserListener;
import riscv.RISCVInstructionEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMIPS {

    private static List<MIPSRow> rows = new ArrayList<>();

    private static byte[] buffer = new byte[1024];

    public static void main(String[] args) throws IOException {

        System.out.println("Start");

        //final String filename = "src/test/resources/MIPS/add.s";
        //final String filename = "src/test/resources/MIPS/addi.s";
        //final String filename = "src/test/resources/MIPS/sub.s";
        //final String filename = "src/test/resources/MIPS/sw.s";
        //final String filename = "src/test/resources/MIPS/lw.s";
        //final String filename = "src/test/resources/MIPS/example_6_8.s";
        //final String filename = "src/test/resources/MIPS/figure_6_4.s";
        //final String filename = "src/test/resources/MIPS/figure_6_15.s";
        //final String filename = "src/test/resources/MIPS/figure_6_16.s";
        //final String filename = "src/test/resources/MIPS/figure_6_18.s";
        //final String filename = "src/test/resources/MIPS/example_6_12.s";
        //final String filename = "src/test/resources/MIPS/example_6_13.s";
        //final String filename = "src/test/resources/MIPS/mipstest.s";
        //final String filename = "src/test/resources/MIPS/factorial.s";
        final String filename = "src/test/resources/MIPS/mipstest.s";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final MIPSLexer lexer = new MIPSLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();

        final MIPSParser parser = new MIPSParser(tokens);
        parser.addErrorListener(syntaxErrorListener);

        // parse
        Asm_fileContext root = parser.asm_file();
        
        if (syntaxErrorListener.getErrorCount() > 0) {
            throw new RuntimeException("Errors detected!");
        }

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        boolean print = false;
        //boolean print = true;
        if (print) {
            ConsoleCPP14ParserListener printListener = new ConsoleCPP14ParserListener();
            walker.walk(printListener, root);
        }

        MIPSRowMIPSParserListener listener = new MIPSRowMIPSParserListener();
        walker.walk(listener, root);
        listener.enterNewline(null);

        // // DEBUG
        // for (MIPSRow row : listener.getRows()) {
        //     System.out.println(row);
        // }
        
        rows.addAll(listener.getRows());

        MIPSInstructionEncoder mipsInstructionEncoder = new MIPSInstructionEncoder();
        mipsInstructionEncoder.setBuffer(buffer);

 /**/       
        int bufferIdx = 0;
        List<String> queuedLabels = new ArrayList<>();
        Map<String, Integer> labelMap = new HashMap<>();
        for (MIPSRow row : rows) {

            if (StringUtils.isNotBlank(row.getLabel())) {
                queuedLabels.add(row.getLabel());
            }

            if (StringUtils.isNotBlank(row.getInstruction())) {

                if (queuedLabels.size() > 0) {
                    for (String label : queuedLabels) {
                        labelMap.put(label, bufferIdx);
                    }
                    queuedLabels.clear();
                }

                bufferIdx += 4;
            }
            
        }

        int temp = 1;
        for (MIPSRow row : rows) {

            // System.out.println(row);

            mipsInstructionEncoder.encode(row, labelMap);

            // System.out.println(temp + ") [OK] " + row);

            temp++;
        }

        // mipsProcessor.setBuffer(buffer);

        // System.out.println("test");

        // int pc = mipsProcessor.getPc();
        // // highlightRow(pc);
 
        System.out.println("\nEnd");
    }

}
