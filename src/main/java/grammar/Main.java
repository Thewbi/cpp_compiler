package grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.cpp.grammar.CPP14Lexer;
import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14ParserListener;
import com.cpp.grammar.PreprocessorLexer;
import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.CPP14Parser.TranslationUnitContext;
import com.cpp.grammar.PreprocessorParser.Code_fileContext;

import types.Type;

/**
 * https://en.cppreference.com/w/cpp/language/translation_phases
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        // preprocessor();
        translationUnit();

        System.out.println("End");
    } 

    private static void translationUnit() throws IOException {

        System.out.println("translationUnit");

        // final String filename = "src/test/resources/helloworld.cpp";
        // final String filename = "src/test/resources/interface.h";
        // final String filename = "src/test/resources/main.cpp";
        // final String filename = "src/test/resources/pragma.h";
        // final String filename = "src/test/resources/preprocessor.cpp";
        // final String filename = "src/test/resources/scratchpad.h";
        // final String filename = "src/test/resources/template.h";
        // final String filename = "src/test/resources/test_f.cpp";
        // final String filename = "src/test/resources/variables.cpp";
        // final String filename = "src/test/resources/declaration_type_error.cpp";
        final String filename = "src/test/resources/declaration.cpp";
        //final String filename = "src/test/resources/arrays.cpp";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final CPP14Lexer lexer = new CPP14Lexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final CPP14Parser parser = new CPP14Parser(tokens);

        // parse
        TranslationUnitContext root = parser.translationUnit();

        CPP14ParserListener listener = null;
        boolean print = false;
        //boolean print = true;
        if (print) {
            listener = new ConsoleCPP14ParserListener();
        } else {
            /**/
            final Map<String, Type> typeMap = new HashMap<>();

            Type intType = new Type();
            intType.setName("int");
            typeMap.put(intType.getName(), intType);

            Type charType = new Type();
            charType.setName("char");
            typeMap.put(charType.getName(), charType);

            Type floatType = new Type();
            floatType.setName("float");
            typeMap.put(floatType.getName(), floatType);

            Type stringType = new Type();
            stringType.setName("std::string");
            typeMap.put(stringType.getName(), stringType);

            SemantCPP14ParserListener semantCPP14ParserListener = new SemantCPP14ParserListener();
            semantCPP14ParserListener.setTypeMap(typeMap);

            listener = semantCPP14ParserListener;
        }

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);

        // System.out.println(typeMap);

        if (listener instanceof SemantCPP14ParserListener) {
            SemantCPP14ParserListener l = (SemantCPP14ParserListener) listener;
            System.out.println(l.getVarTypeMap());
        }
        

        // // dump output
        // Node rootNode = listener.getRootNode();
        // rootNode.print(0);
    }

    private static void preprocessor() throws IOException {

        // final String filename = "src/test/resources/preprocessor.cpp";
        // final String filename = "src/test/resources/preprocessor2.cpp";
        // final String filename = "src/test/resources/preprocessor3.cpp";
        // final String filename = "src/test/resources/preprocessor4.cpp";
        // final String filename = "src/test/resources/preprocessor5.cpp";
        // final String filename = "src/test/resources/main.cpp";
        // final String filename = "src/test/resources/class.h";
        // final String filename = "src/test/resources/for_loop.cpp";
        // final String filename = "src/test/resources/helloworld.cpp";
        // final String filename = "src/test/resources/helloworld2.cpp";
        final String filename = "src/test/resources/declaration_type_error.cpp";

        List<String> processedIncludeFiles = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        preProcessor(filename, processedIncludeFiles, stringBuilder);

        System.out.println(stringBuilder.toString());
        Files.writeString(Paths.get("preprocessed.cpp"), stringBuilder.toString());
    }

    public static void preProcessor(String filename, List<String> processedIncludeFiles, StringBuilder stringBuilder)
            throws IOException {

        File file = new File(filename);
        System.out.println(file.getAbsolutePath());

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final PreprocessorLexer lexer = new PreprocessorLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final PreprocessorParser parser = new PreprocessorParser(tokens);

        // parse
        // StreamContext root = parser.stream();
        // RowsContext root = parser.rows();
        Code_fileContext root = parser.code_file();

        PreprocessorParserListener listener = new PreprocessorParserListener();
        listener.setProcessedIncludeFiles(processedIncludeFiles);
        listener.setStringBuilder(stringBuilder);

        // // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);

        // System.out.println("-----------------------------------------");
        // System.out.println(stringBuilder.toString());
    }

}
