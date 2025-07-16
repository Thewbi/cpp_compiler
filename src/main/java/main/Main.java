package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Console;
import java.io.File;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.parse.v4ParserException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.CPP14Lexer;
import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14ParserListener;
import com.cpp.grammar.CPreprocessorLexer;
import com.cpp.grammar.CPreprocessorLexerRule;
import com.cpp.grammar.CPreprocessorParser;
import com.cpp.grammar.CPreprocessorParser.ProgramContext;
import com.cpp.grammar.PreprocessorLexer;
import com.cpp.grammar.PreprocessorLexer2;
import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.CPP14Parser.TranslationUnitContext;
import com.cpp.grammar.PreprocessorParser.Code_fileContext;
import com.cpp.grammar.RISCVParser.Asm_fileContext;
import com.cpp.grammar.TACKYParser.Tacky_fileContext;
import com.cpp.grammar.TACKYParserListener;
import com.cpp.grammar.TACKYParser;

import ast.ASTNode;
import ast.ExpressionASTNode;
import grammar.ConsoleCPP14ParserListener;
import grammar.ConsoleCPreprocessorParserListener;
import grammar.ConsoleTACKYParserListener;
import grammar.PreprocessorParserListener;
import grammar.RISCVRow;
import grammar.RISCVRowListener;
import grammar.RISCVRowParam;
import grammar.SemantCPP14ParserListener;
import grammar.StructureCPP14ParserListener;
import grammar.StructureTACKYParserListener;
import grammar.SyntaxErrorListener;
import preprocessor.DefaultFileStackFrameCallback;
import preprocessor.FileStackFrame;
import riscv.ExplicitRISCVProcessor;
import riscv.RISCVInstructionDecoder;
import riscv.RISCVInstructionEncoder;
import riscv.RISCVProcessor;

import com.cpp.grammar.RISCVLexer;
import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.TACKYLexer;

import structure.DefaultStructureCallback;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.ProgramASTNode;
import tacky.runtime.DefaultTACKYExecutor;
import types.FuncDecl;
import types.Type;

/**
 * https://en.cppreference.com/w/cpp/language/translation_phases
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        //preprocessor();
        preprocessor_2();
        //preprocessor_3();
        //translationUnit();
        //riscvassembler();
        //riscvdecoder();
        //riscvencoder();
        //tacky();

        // ide();

        System.out.println("End");
    }

    private static void tacky() throws IOException {

        // final String filename = "src/test/resources/TACKY/for_loop.tky";
        // final String filename = "src/test/resources/TACKY/pointer_creation.tky";
        //final String filename = "src/test/resources/TACKY/array_int.tky";
        final String filename = "src/test/resources/TACKY/function_call.tky";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final TACKYLexer lexer = new TACKYLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final TACKYParser parser = new TACKYParser(tokens);

        // parse
        Tacky_fileContext root = parser.tacky_file();

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        // DEBUG output parse tree
        boolean printParseTree = true;
        // boolean printParseTree = false;
        if (printParseTree) {
            ConsoleTACKYParserListener printListener = new ConsoleTACKYParserListener();
            walker.walk(printListener, root);
        }

        ASTNode rootNode = new ASTNode();
        rootNode.value = "[tacky_file] root";

        StructureTACKYParserListener structureTACKYParserListener = new StructureTACKYParserListener();
        structureTACKYParserListener.currentNode = rootNode;

        TACKYParserListener listener = structureTACKYParserListener;

        // start the base scope
        // structureCallback.startScope();

        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);

        // end the base scope
        // structureCallback.endScope();

        // System.out.println(typeMap);

        boolean printAST = true;
        // boolean printAST = false;
        if (printAST) {
            StringBuilder stringBuilder = new StringBuilder();
            rootNode.printRecursive(stringBuilder, 0, true);
            System.out.print(stringBuilder.toString());
        }

        // run the TACKY code

        // find the 'program' statement
        ProgramASTNode program = (ProgramASTNode) rootNode.children.stream().filter(e -> e instanceof ProgramASTNode)
                .findFirst().get();
        String mainEntryPointName = program.value;

        System.out.println("MainEntryPoint is \"" + mainEntryPointName + "\"");
        FunctionDefinitionASTNode mainFunction = (FunctionDefinitionASTNode) rootNode.children.stream().filter(
                e -> ((e instanceof FunctionDefinitionASTNode) && (e.value.equalsIgnoreCase(mainEntryPointName))))
                .findFirst().get();

        System.out.println("mainFunction found is \"" + mainFunction.value + "\"");

        DefaultTACKYExecutor tackyExecutor = new DefaultTACKYExecutor();
        tackyExecutor.executeFunction(rootNode, 0, mainFunction);
    }

    /**
     * C/CPP translation unit
     *
     * @throws IOException
     */
    private static void translationUnit() throws IOException {

        System.out.println("translationUnit");

        // final String filename =
        // "src/test/resources/WritingACCompilerNoraSandler/simplest.c";

        // final String filename = "src/test/resources/initialize_with_expressions.cpp";

        // final String filename = "src/test/resources/initialize_pointers.cpp";

        // test
        // final String filename = "src/test/resources/initialize_use_pointers.cpp";

        // final String filename = "src/test/resources/initialize_arrays.cpp";
        // final String filename = "src/test/resources/inititalize_variable_cast.cpp";
        // final String filename =
        // "src/test/resources/initialize_function_declaration.cpp";
        // final String filename = "src/test/resources/initialize_static_variables.cpp";
        // final String filename = "src/test/resources/initialize_struct.cpp";
        // final String filename = "src/test/resources/initialize_class.cpp";
        // final String filename = "src/test/resources/initialize_typedef.cpp";
        // final String filename = "src/test/resources/initialize_if_elseif_else.cpp";
        // final String filename = "src/test/resources/initialize_switch_case.cpp";
        // final String filename = "src/test/resources/initialize_for_loop.cpp";
        // final String filename = "src/test/resources/initialize_while_loop.cpp";
        // final String filename = "src/test/resources/initialize_do_while_loop.cpp";

        // final String filename = "src/test/resources/drawPath.cpp";

        // final String filename = "src/test/resources/palindrome_number.cpp";
        final String filename = "src/test/resources/array_example.c";

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
        // final String filename = "src/test/resources/ECO32/ECO32_1.cpp";

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

        Type voidType = new Type();
        voidType.setName("void");
        typeMap.put(voidType.getName(), voidType);

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

        DefaultStructureCallback structureCallback = new DefaultStructureCallback();

        /*
         * SemantCPP14ParserListener semantCPP14ParserListener = new
         * SemantCPP14ParserListener();
         * semantCPP14ParserListener.setTypeMap(typeMap);
         *
         * Map<String, FuncDecl> funcDeclMap = new HashMap<>();
         * semantCPP14ParserListener.setFuncDeclMap(funcDeclMap);
         *
         * StackFrame baseStackFrame = new StackFrame();
         * Stack<StackFrame> executionStack = new Stack<>();
         * executionStack.push(baseStackFrame);
         * semantCPP14ParserListener.setExecutionStack(executionStack);
         * semantCPP14ParserListener.setStructureCallback(structureCallback);
         *
         * // semantCPP14ParserListener.getSemAntModeStack().push(SemAntMode.DEFAULT);
         * CPP14ParserListener listener = semantCPP14ParserListener;
         * // }
         */

        ASTNode rootNode = new ASTNode();
        rootNode.value = "[CompilationUnit] root";

        StructureCPP14ParserListener structureCPP14ParserListener = new StructureCPP14ParserListener();
        structureCPP14ParserListener.currentNode = rootNode;

        CPP14ParserListener listener = structureCPP14ParserListener;

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        // boolean printParseTree = true;
        boolean printParseTree = false;
        if (printParseTree) {
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

        boolean printAST = true;
        if (printAST) {
            StringBuilder stringBuilder = new StringBuilder();
            rootNode.printRecursive(stringBuilder, 0);
            System.out.println(stringBuilder.toString());
        }

        // check if expression stack is empty
        if (listener instanceof StructureCPP14ParserListener) {

            StructureCPP14ParserListener tempStructureCPP14ParserListener = (StructureCPP14ParserListener) listener;
            Stack<ExpressionASTNode> expressionStack = tempStructureCPP14ParserListener.expressionStack;

            int exprStackSize = expressionStack.size();
            if (exprStackSize != 0) {
                throw new RuntimeException("Expression Stack is not empty after AST parse!");
            } else {
                System.out.println("Expression stack is empty!");
            }
        }

        boolean debugOutputListenerData = true;
        // boolean debugOutputListenerData = false;
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

    private static void preprocessor_2() throws IOException {

        //final String filename = "src/test/resources/preprocessor/define.pp";

        final String filename = "src/test/resources/preprocessor/ifndef.pp";
        //final String filename = "src/test/resources/preprocessor/if_defined.pp";
        //final String filename = "src/test/resources/preprocessor/if_defined_nested.pp";
        //final String filename = "src/test/resources/preprocessor/ifdef_else.pp";
        //final String filename = "src/test/resources/preprocessor/include.pp";
        //final String filename = "src/test/resources/preprocessor/scratchpad.pp";

        //final String filename = "src/test/resources/preprocessor/funcs.pp";

        // TODO: next
        //final String filename = "src/test/resources/preprocessor/define_square.pp";
        //final String filename = "src/test/resources/preprocessor/printf_test_1.pp";

        ASTNode dummyASTNode = new ASTNode();
        dummyASTNode.value = "__DUMMY___11223344__";

        StringBuilder outputStringBuilder = new StringBuilder();
        Map<String, ASTNode> defineMap = new HashMap<>();
        Map<String, ASTNode> defineKeyMap = new HashMap<>();

        DefaultFileStackFrameCallback defaultfileStackFrameCallback = new DefaultFileStackFrameCallback();
        defaultfileStackFrameCallback.defineMap = defineMap;
        defaultfileStackFrameCallback.defineKeyMap = defineKeyMap;
        defaultfileStackFrameCallback.dummyASTNode = dummyASTNode;

        FileStackFrame fileStackFrame = new FileStackFrame();
        fileStackFrame.callback = defaultfileStackFrameCallback;
        fileStackFrame.filename = filename;
        fileStackFrame.outputStringBuilder = outputStringBuilder;

        Stack<FileStackFrame> fileStack = new Stack<>();
        fileStack.push(fileStackFrame);

        fileStackFrame.fileStack = fileStack;

        fileStackFrame.start();

        System.out.println(outputStringBuilder.toString());

    }

    private static void preprocessor_3() throws IOException {

        //final String filename = "src/test/resources/preprocessor/if_defined.pp";
        final String filename = "src/test/resources/preprocessor/scratchpad.pp";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        //final CPreprocessorLexerRule lexer = new CPreprocessorLexerRule(charStream);
        final CPreprocessorLexer lexer = new CPreprocessorLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final CPreprocessorParser parser = new CPreprocessorParser(tokens);

        // parse
        ProgramContext root = parser.program();

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        boolean printParseTree = true;
        //boolean printParseTree = false;
        if (printParseTree) {
            ConsoleCPreprocessorParserListener printListener = new ConsoleCPreprocessorParserListener();
            walker.walk(printListener, root);
        }

    }

    private static void ide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ide'");
    }

    private static void riscvencoder() {

        RISCVRow riscVRow = new RISCVRow();
        riscVRow.setInstruction(StringUtils.upperCase("addi"));

        RISCVRowParam riscvRowParam = new RISCVRowParam();
        riscvRowParam.setRegister("x8");
        riscVRow.getParameters().add(riscvRowParam);

        riscvRowParam = new RISCVRowParam();
        riscvRowParam.setRegister("x2");
        riscVRow.getParameters().add(riscvRowParam);

        riscvRowParam = new RISCVRowParam();
        riscvRowParam.setExpression("32");
        riscVRow.getParameters().add(riscvRowParam);

        RISCVInstructionEncoder riscVInstructionEncoder = new RISCVInstructionEncoder();
        riscVInstructionEncoder.encode(riscVRow, null);
    }

    private static void riscvdecoder() {

        RISCVInstructionDecoder riscVInstructionDecoder = new RISCVInstructionDecoder();
        riscVInstructionDecoder.decode();

        ExplicitRISCVProcessor riscVProcessor = new ExplicitRISCVProcessor();
        riscVProcessor.getRows().addAll(riscVInstructionDecoder.getRows());

        System.out.println("Start Execution: ---------------------------------------");

        while (!riscVProcessor.isDone()) {
            riscVProcessor.processRow();
        }
    }

    private static void riscvassembler() throws IOException {

        final String filename = "src/test/resources/RISCV/addi.s";
        // final String filename = "src/test/resources/RISCV/auipc.s";
        // final String filename = "src/test/resources/RISCV/fibonacci.s";
        // final String filename = "src/test/resources/RISCV/hello.s";
        // final String filename = "src/test/resources/RISCV/hello2.s";
        // final String filename = "src/test/resources/RISCV/sw.s";
        // final String filename = "src/test/resources/RISCV/test.s";
        // final String filename = "src/test/resources/RISCV/intrinsic.s";
        // final String filename = "src/test/resources/RISCV/data_list.s";
        // final String filename = "src/test/resources/RISCV/scratchpad.s";

        // final String filename = "C:\\aaa_se\\riscv\\snake_game_risc-v\\Main.asm";
        // final String filename =
        // "C:\\aaa_se\\riscv\\snake_game_risc-v\\include\\background.asm";
        // final String filename =
        // "C:\\aaa_se\\riscv\\snake_game_risc-v\\include\\Directions.asm";

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

        boolean print = false;
        // boolean print = true;
        if (print) {

            ConsoleCPP14ParserListener printListener = new ConsoleCPP14ParserListener();
            walker.walk(printListener, root);

        }

        // RISCVParserListener listener = new RISCVParserListener();
        // ConsoleRISCVParserListener listener = new ConsoleRISCVParserListener();
        // FormattingRISCVParserListener listener = new FormattingRISCVParserListener();
        RISCVRowListener listener = new RISCVRowListener();

        walker.walk(listener, root);

        listener.enterNewline(null);

        if (listener instanceof RISCVRowListener) {

            RISCVProcessor riscVProcessor = new RISCVProcessor();
            riscVProcessor.getRows().addAll(listener.getRows());
            riscVProcessor.processLabels();
            riscVProcessor.startAtLabel("main");
            while (!riscVProcessor.isDone()) {
                riscVProcessor.processRow();
            }

            // for (RISCVRow row : listener.getRows()) {

            // System.out.println(row);
            // System.out.println("");

            // riscVProcessor.processRow(row);
            // }
        }
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
