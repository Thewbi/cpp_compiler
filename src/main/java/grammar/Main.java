package grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.File;

import org.antlr.v4.runtime.ANTLRErrorListener;
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
import com.cpp.grammar.RISCVParser.Asm_fileContext;
import com.cpp.grammar.RISCVLexer;
import com.cpp.grammar.RISCVParser;

import structure.DefaultStructureCallback;
import types.FuncDecl;
import types.StackFrame;
import types.Type;

/**
 * https://en.cppreference.com/w/cpp/language/translation_phases
 */
public class Main { 

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        // preprocessor();
        // translationUnit();
        riscvassembler();

        System.out.println("End");
    }

    private static void riscvassembler() throws IOException {

        final String filename = "src/test/resources/RISCV/fibonacci.s";
        //final String filename = "src/test/resources/RISCV/addi.s";
        //final String filename = "src/test/resources/RISCV/sw.s";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final RISCVLexer lexer = new RISCVLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();

        final RISCVParser parser = new RISCVParser(tokens);
        parser.addErrorListener(syntaxErrorListener);

        // parse
        Asm_fileContext root = parser.asm_file();
        
        if (syntaxErrorListener.getErrorCount() > 0) {
            throw new RuntimeException("Errors detected!");
        }

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        //RISCVParserListener riscVParserListener = new RISCVParserListener();
        // ConsoleRISCVParserListener riscVParserListener = new ConsoleRISCVParserListener();
        FormattingRISCVParserListener riscVParserListener = new FormattingRISCVParserListener();

        walker.walk(riscVParserListener, root);
    }

    private static void translationUnit() throws IOException {

        System.out.println("translationUnit");

        // final String filename = "src/test/resources/sample1.cpp";
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
        // final String filename = "src/test/resources/declaration.cpp";
        // final String filename = "src/test/resources/arrays.cpp";
        // final String filename = "src/test/resources/if.cpp";
        // final String filename = "src/test/resources/for_loop.cpp";
        // final String filename = "src/test/resources/function_definition.cpp";
        // final String filename = "src/test/resources/function_call.cpp";
        // final String filename = "src/test/resources/while.cpp";
        // final String filename = "src/test/resources/app1.cpp";
        final String filename = "src/test/resources/ECO32_1.cpp";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final CPP14Lexer lexer = new CPP14Lexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final CPP14Parser parser = new CPP14Parser(tokens);

        // parse
        TranslationUnitContext root = parser.translationUnit();

        // else {

        final Map<String, Type> typeMap = new HashMap<>();

        // Type bonk1122Type = new Type();
        // bonk1122Type.setName("bonk1122");
        // typeMap.put(bonk1122Type.getName(), bonk1122Type);

        Type boolType = new Type();
        boolType.setName("bool");
        typeMap.put(boolType.getName(), boolType);

        Type intType = new Type();
        intType.setName("int");
        typeMap.put(intType.getName(), intType);

        Type charType = new Type();
        charType.setName("char");
        typeMap.put(charType.getName(), charType);

        Type floatType = new Type();
        floatType.setName("float");
        typeMap.put(floatType.getName(), floatType);

        Type doubleType = new Type();
        doubleType.setName("double");
        typeMap.put(doubleType.getName(), doubleType);

        Type stringType = new Type();
        stringType.setName("std::string");
        typeMap.put(stringType.getName(), stringType);

        SemantCPP14ParserListener semantCPP14ParserListener = new SemantCPP14ParserListener();
        semantCPP14ParserListener.setTypeMap(typeMap);

        Map<String, FuncDecl> funcDeclMap = new HashMap<>();
        semantCPP14ParserListener.setFuncDeclMap(funcDeclMap);

        StackFrame baseStackFrame = new StackFrame();
        Stack<StackFrame> executionStack = new Stack<>();
        executionStack.push(baseStackFrame);
        semantCPP14ParserListener.setExecutionStack(executionStack);

        DefaultStructureCallback structureCallback = new DefaultStructureCallback();
        semantCPP14ParserListener.setStructureCallback(structureCallback);

        // semantCPP14ParserListener.getSemAntModeStack().push(SemAntMode.DEFAULT);
        CPP14ParserListener listener = semantCPP14ParserListener;
        // }

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        boolean print = false;
        // boolean print = true;
        if (print) {

            ConsoleCPP14ParserListener printListener = new ConsoleCPP14ParserListener();
            walker.walk(printListener, root);

        }

        // start the base scope
        structureCallback.startScope();

        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);

        // end the base scope
        structureCallback.endScope();

        // System.out.println(typeMap);

        // boolean debugOutputListenerData = true;
        boolean debugOutputListenerData = false;
        if (debugOutputListenerData) {

            if (listener instanceof SemantCPP14ParserListener) {

                SemantCPP14ParserListener lstnr = (SemantCPP14ParserListener) listener;

                // if (lstnr.getSemAntModeStack().size() != 1) {
                // throw new RuntimeException("SemAntModeStack invalid!");
                // }
                // if (lstnr.getSemAntModeStack().peek() != SemAntMode.DEFAULT) {
                // throw new RuntimeException("SemAntModeStack invalid!");
                // }

                System.out.println("");
                System.out.println("Variables (VarName | VarType)");
                System.out.println("-------------------------------------------");
                // System.out.println("VarTypeMap: " + lstnr.getVarTypeMap());
                for (Map.Entry<String, Type> entry : lstnr.getVarTypeMap().entrySet()) {
                    // System.out.println("VarName: \"" + entry.getKey() + "\" VarType: " +
                    // entry.getValue());
                    System.out.println(entry.getKey() + " | " + entry.getValue());
                }

                System.out.println("");
                System.out.println("Functions");
                System.out.println("-------------------------------------------");
                // System.out.println("FuncDeclMap: " + lstnr.getFuncDeclMap());
                for (Map.Entry<String, FuncDecl> entry : lstnr.getFuncDeclMap().entrySet()) {
                    System.out.println(entry.getKey() + " | " + entry.getValue());
                    System.out.println("");
                }
            }
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
