package grammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.cpp.grammar.MIPSLexer;
import com.cpp.grammar.MIPSParser;
import com.cpp.grammar.MIPSParser.Asm_fileContext;

import java.io.IOException;

public class MainMIPS {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        final String filename = "src/test/resources/MIPS/add.s";
        // final String filename = "src/test/resources/MIPS/addi.s";

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

        //boolean print = false;
        boolean print = true;
        if (print) {

            ConsoleCPP14ParserListener printListener = new ConsoleCPP14ParserListener();
            walker.walk(printListener, root);

        }

        System.out.println("\nEnd");
    }

}
