package grammar;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.cpp.grammar.CPP14Lexer;
import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14Parser.TranslationUnitContext;

/**
 * https://en.cppreference.com/w/cpp/language/translation_phases
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        translationUnit();
        System.out.println("End");
    }

    private static void translationUnit() throws IOException {
        System.out.println("translationUnit");

        final CharStream charStream = CharStreams
                .fromFileName("src/test/resources/helloworld.cpp");

        final CPP14Lexer lexer = new CPP14Lexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final CPP14Parser parser = new CPP14Parser(tokens);

        // parse
        TranslationUnitContext root = parser.translationUnit();

        ConsoleCPP14ParserListener listener = new ConsoleCPP14ParserListener();
        // DefaultStructuredTextListener listener = new DefaultStructuredTextListener();

        // // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);

        // // dump output
        // Node rootNode = listener.getRootNode();
        // rootNode.print(0);

        System.out.println();
    }

}
