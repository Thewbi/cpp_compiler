package grammar;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.cpp.grammar.CPP14Lexer;
import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.PreprocessorLexer;
import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.CPP14Parser.TranslationUnitContext;
import com.cpp.grammar.PreprocessorParser.StreamContext;

/**
 * https://en.cppreference.com/w/cpp/language/translation_phases
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        preProcessor();
        //translationUnit();
        System.out.println("End");
    }

    private static void preProcessor() throws IOException {

        //final String filename = "src/test/resources/preprocessor.cpp";
        final String filename = "src/test/resources/preprocessor2.cpp";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final PreprocessorLexer lexer = new PreprocessorLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final PreprocessorParser parser = new PreprocessorParser(tokens);

        // parse
        StreamContext root = parser.stream();

        PreprocessorParserListener listener = new PreprocessorParserListener();

        // // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);
    }

    private static void translationUnit() throws IOException {

        System.out.println("translationUnit");

        //final String filename = "src/test/resources/helloworld.cpp";
        //final String filename = "src/test/resources/interface.h";
        //final String filename = "src/test/resources/main.cpp";
        //final String filename = "src/test/resources/pragma.h";
        //final String filename = "src/test/resources/preprocessor.cpp";
        //final String filename = "src/test/resources/scratchpad.h";
        final String filename = "src/test/resources/template.h";
        //final String filename = "src/test/resources/test_f.cpp";
        //final String filename = "src/test/resources/variables.cpp";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

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
