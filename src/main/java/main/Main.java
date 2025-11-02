package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

import javax.management.RuntimeErrorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;

import com.cpp.grammar.CPP14Lexer;
import com.cpp.grammar.CPP14Parser;
import com.cpp.grammar.CPP14ParserListener;
import com.cpp.grammar.CPreprocessorLexer;
import com.cpp.grammar.CPreprocessorParser;
import com.cpp.grammar.CPreprocessorParser.ProgramContext;
import com.cpp.grammar.PreprocessorLexer;
import com.cpp.grammar.PreprocessorParser;
import com.cpp.grammar.CPP14Parser.TranslationUnitContext;
import com.cpp.grammar.PreprocessorParser.Code_fileContext;
import com.cpp.grammar.RISCVParser.Asm_fileContext;
import com.cpp.grammar.TACKYParser.Tacky_fileContext;
import com.cpp.grammar.TACKYParserListener;
import com.cpp.grammar.TACKYParser;

import ast.ASTNode;
import ast.ExpressionASTNode;
import expressionbuilder.ExpressionBuilderExecutor;
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
import preprocessor.AbstractFileStackFrame;
import preprocessor.DefaultFileStackFrameCallback;
import riscv.ExplicitRISCVProcessor;
import riscv.RISCVInstructionDecoder;
import riscv.RISCVInstructionEncoder;
import riscv.RISCVProcessor;
import preprocessor.IFileStackFrame;
import preprocessor.SimpleFileStackFrame;
import preprocessor.TreeNode;

import com.cpp.grammar.RISCVLexer;
import com.cpp.grammar.RISCVParser;
import com.cpp.grammar.TACKYLexer;

import structure.DefaultStructureCallback;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.ProgramASTNode;
import tacky.runtime.DefaultTACKYExecutor;
import tacky.runtime.TACKYStackFrame;
import types.FuncDecl;
import types.Type;

/**
 * https://en.cppreference.com/w/cpp/language/translation_phases
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        // preprocessor();
        // continue here:

        // preprocessor_2(); <----------------- Continue here

        // preprocessor_3();
        // translationUnit();
        // riscvassembler();
        // riscvdecoder();
        // riscvencoder();
        tacky();
        // manualExpressionParsing();

        // manualExpressionParsing2();

        // manualExpressionParsing3(); // TODO: transform parse tree into expression
        // tree by deleting all grammar nodes

        // ide();

        System.out.println("End");
    }

    private static void manualExpressionParsing3() {

        String data = "";

        // data = "\"identifier\"";

        // data = "a";
        // data = "a + b";
        // data = "a * b";
        // data = "a * b + c";
        // data = "a + b * c";
        // data = "a + b + c";
        // data = "a * b * c";

        // data = "(x)";
        // data = "a + (x)";
        // data = "(x) + a";
        // data = "(x) + (y)";
        // data = "((x) + (y))";
        // data = "a * (x + y)";
        // data = "(x + y) * a";

        // data = "SQUARE(x)";
        // data = "defined(_DEBUG)";
        // data = "SQUARE(a + b)"; // OK
        // data = "SQUARE(a * b)"; // OK
        // data = "SQUARE(a * b + c)";
        // data = "SQUARE(a * (b + c))";
        // data = "P()";
        // data = "P(x)";
        // data = "P(a, b)";
        // data = "P(a, b, c)";
        // data = "P(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v,
        // w, x, y, z)";
        // data = "P(void)";
        // data = "P((void))";

        // data = "1";
        // data = "1 + 2";
        // data = "1 + a";
        // data = "a * 1";
        // data = "SQUARE(a * (b + 1))";

        // data = "printf(\"File: %s\n\", __FILE__)"; // TODO

        // data = "a || b";
        // data = "a || 1 + b";

        // data = "a && b";
        // data = "a && 1 + b";

        // data = "!a";
        // data = "!defined(_DEBUG) && defined(_UNIT_TEST)";
        // data = "!defined _DEBUG && defined _UNIT_TEST"; // does not work with the
        // grammar!

        // data = "a.b";
        // data = "a.b.c";

        // data = "prsvec_1 == oindex_1";
        // data = "(prsvec_1 == oindex_1 || prso == every)";
        // data = "(prsvec_1.prso == oindex_1.valua || prsvec_1.prso ==
        // oindex_1.every)";

        // data = "&orphs_1";
        // data = "(integer *)"; // this will not parse on it's own based on the grammar
        // data = "((integer *)&orphs_1)";

        ExpressionBuilderExecutor expressionBuilderExecutor = new ExpressionBuilderExecutor();
        ASTNode astNode = expressionBuilderExecutor.execute(data);

        // DEBUG output ParserTree
        StringBuilder stringBuilder = new StringBuilder();
        astNode.printRecursive(stringBuilder, 0);
        System.out.println(stringBuilder);

        // rebuild parse tree into expression tree
        //
        // the process starts at the leaves
        // every child that is not a grammar node is move up one level
        //
        // For the rule_start_symbol, drop the <EOF> node
        //
        // For rule_parenthesis, add opening, central node and closing braces
        // into parent
        //
        // depth first search, while decending up again
        //
        // On the way down into the children.
        // - if a bracket ( or ) is discovered, create a new ASTNode with value "()"
        // and insert it in places of the "(" node, delete the ")" Node
        //
        // arriving at a node:
        // - is the node a grammar node AND does the node have only
        // leaves (NON-Grammar nodes) as children?
        // if yes, remove the node from the parent
        // reparent children to remaining child of parent
        //
        // - if the node is NOT a grammar node, do nothing

        System.out.println("The End");
    }

    private static void manualExpressionParsing2() {

        List<String> tokens = new ArrayList<>();

        // // a.b == c.d || e.f == g.h
        // tokens.add("a");
        // tokens.add(".");
        // tokens.add("b");
        // tokens.add("==");
        // tokens.add("c");
        // tokens.add(".");
        // tokens.add("d");
        // tokens.add("||");
        // tokens.add("e");
        // tokens.add(".");
        // tokens.add("f");
        // tokens.add("==");
        // tokens.add("g");
        // tokens.add(".");
        // tokens.add("h");

        // // a > b == c < d
        // tokens.add("a");
        // tokens.add(">");
        // tokens.add("b");
        // tokens.add("==");
        // tokens.add("c");
        // tokens.add("<");
        // tokens.add("d");

        // // a > b > c
        // tokens.add("a");
        // tokens.add(">");
        // tokens.add("b");
        // tokens.add(">");
        // tokens.add("c");

        // // a + b * c
        // tokens.add("a");
        // tokens.add("+");
        // tokens.add("b");
        // tokens.add("*");
        // tokens.add("c");

        // // ( a + b ) * c
        // tokens.add("(");
        // tokens.add("a");
        // tokens.add("+");
        // tokens.add("b");
        // tokens.add(")");
        // tokens.add("*");
        // tokens.add("c");

        // // n <= 20 && n >= 10
        // tokens.add("n");
        // tokens.add("<=");
        // tokens.add("20");
        // tokens.add("&&");
        // tokens.add("n");
        // tokens.add(">=");
        // tokens.add("10");

        // // n % 2 == 0
        // tokens.add("n");
        // tokens.add("%");
        // tokens.add("2");
        // tokens.add("==");
        // tokens.add("0");

        // // prsvec_1.prscon <= 1
        // tokens.add("prsvec_1");
        // tokens.add(".");
        // tokens.add("prscon");
        // tokens.add("<=");
        // tokens.add("1");

        // // prsvec_1.prso == oindex_1.valua || prsvec_1.prso == oindex_1.every
        // tokens.add("prsvec_1");
        // tokens.add(".");
        // tokens.add("prso");
        // tokens.add("==");
        // tokens.add("oindex_1");
        // tokens.add(".");
        // tokens.add("valua");
        // tokens.add("||");
        // tokens.add("prsvec_1");
        // tokens.add(".");
        // tokens.add("prso");
        // tokens.add("==");
        // tokens.add("oindex_1");
        // tokens.add(".");
        // tokens.add("every");

        // // ! a
        // tokens.add("!");
        // tokens.add("a");

        // // ! prsvec_1.prswon
        // tokens.add("!");
        // tokens.add("prsvec_1");
        // tokens.add(".");
        // tokens.add("prswon");

        // // ! prsvec_1.prswon || prsvec_1.prsa != vindex_1.walkw
        // tokens.add("!");
        // tokens.add("prsvec_1");
        // tokens.add(".");
        // tokens.add("prswon");
        // tokens.add("||");
        // tokens.add("prsvec_1");
        // tokens.add(".");
        // tokens.add("prsa");
        // tokens.add("!=");
        // tokens.add("vindex_1");
        // tokens.add(".");
        // tokens.add("walkw");

        // // ! findex_1.echof && play_1.here == rindex_1.echor
        // tokens.add("!");
        // tokens.add("findex_1");
        // tokens.add(".");
        // tokens.add("echof");
        // tokens.add("&&");
        // tokens.add("play_1");
        // tokens.add(".");
        // tokens.add("here");
        // tokens.add("==");
        // tokens.add("rindex_1");
        // tokens.add(".");
        // tokens.add("echor");

        // // strcmp(input_1.inbuf, "ECHO") != 0
        // tokens.add("strcmp");
        // tokens.add("(");
        // tokens.add("input_1");
        // tokens.add(".");
        // tokens.add("inbuf");
        // tokens.add(",");
        // tokens.add("\"ECHO\"");
        // tokens.add(")");
        // tokens.add("!=");
        // tokens.add("0");

        // // strcmp(a)
        // tokens.add("strcmp");
        // tokens.add("(");
        // tokens.add("a");
        // tokens.add(")");

        // // strcmp(a, b)
        // tokens.add("strcmp");
        // tokens.add("(");
        // tokens.add("a");
        // tokens.add(",");
        // tokens.add("b");
        // tokens.add(")");

        // // strcmp(a, b, c)
        // tokens.add("strcmp");
        // tokens.add("(");
        // tokens.add("a");
        // tokens.add(",");
        // tokens.add("b");
        // tokens.add(",");
        // tokens.add("c");
        // tokens.add(")");

        // // strcmp(a, b, c, d)
        // tokens.add("strcmp");
        // tokens.add("(");
        // tokens.add("a");
        // tokens.add(",");
        // tokens.add("b");
        // tokens.add(",");
        // tokens.add("c");
        // tokens.add(",");
        // tokens.add("d");
        // tokens.add(")");

        // // strcmp(input_1.inbuf, "ECHO")
        // tokens.add("strcmp");
        // tokens.add("(");
        // tokens.add("input_1");
        // tokens.add(".");
        // tokens.add("inbuf");
        // tokens.add(",");
        // tokens.add("\"ECHO\"");
        // tokens.add(")");

        // // defined(_DEBUG) || defined(_UNIT_TEST)
        // tokens.add("defined");
        // tokens.add("(");
        // tokens.add("_DEBUG");
        // tokens.add(")");
        // tokens.add("||");
        // tokens.add("defined");
        // tokens.add("(");
        // tokens.add("_UNIT_TEST");
        // tokens.add(")");

        tokens.add("(");
        tokens.add("(");
        tokens.add("x");
        tokens.add(")");
        tokens.add("*");
        tokens.add("(");
        tokens.add("x");
        tokens.add(")");
        tokens.add(")");

        System.out.println("--------------------------------------");

        int customWeight = 0;

        TreeNode rootNode = null;

        boolean identifier = false;
        String lastIdentifier = null;

        for (int i = 0; i < tokens.size(); i++) {

            String currentToken = tokens.get(i);

            if (currentToken.equalsIgnoreCase("(")) {

                if (identifier) {

                    // DEBUG
                    // System.out.println("function call detected: " + lastIdentifier);

                    rootNode.functionCall = true;
                }

                customWeight += 1000;
                continue;

            }
            if (currentToken.equalsIgnoreCase(")")) {
                customWeight -= 1000;
                continue;
            }

            identifier = AbstractFileStackFrame.isIdentifier(currentToken);
            lastIdentifier = currentToken;

            rootNode = insertTokenIntoTree(rootNode, currentToken, customWeight,
                    rootNode != null ? rootNode.functionCall : false);

            // DEBUG
            StringBuilder stringBuilder = new StringBuilder();
            rootNode.printRecursive(stringBuilder, 0);
            System.out.println(stringBuilder.toString());

            System.out.println("--------------------------------------");
        }
    }

    /**
     * This function contains the basic idea of the algorithm. The purpose of the
     * algorithm is to parse expressions without a parse, using a lexer and token
     * only.
     * The expression is expressed using a binary tree.
     * To build the tree, all token types are identified and if the token is a C/C++
     * operator, the precedence of that operator is used as a weight. The heavier
     * the node (higher precedence) the deeper the token will sink into the tree.
     * Literals have the highest weight and will sink down and act as the leafs of
     * the tree (Leaf == no children).
     */
    private static TreeNode insertTokenIntoTree(TreeNode node, String token, int customWeight, boolean functionCall) {

        if (node == null) {
            TreeNode newTreeNode = new TreeNode();
            newTreeNode.value = token;
            newTreeNode.unaryOperator = AbstractFileStackFrame.isUnaryOperator(token);
            newTreeNode.customWeight = customWeight;

            return newTreeNode;
        }

        if (comparePriority(functionCall, node.customWeight, node.value, token) < 0) {

            System.out.println("existing node is heavier");

            TreeNode newNode = new TreeNode();
            newNode.value = token;
            newNode.customWeight = customWeight;

            newNode.reparent(node);

            return newNode;

        } else {

            System.out.println("existing node is lighter");

            if ((node.lhs != null) && (node.rhs != null)) {
                insertTokenIntoTree(node.rhs, token, customWeight, false);
                return node;
            }

            TreeNode newNode = new TreeNode();
            newNode.value = token;
            newNode.customWeight = customWeight;
            node.addChild(newNode);

            return node;

        }

    }

    private static void manualExpressionParsing() {

        List<String> tokens = new ArrayList<>();
        tokens.add("a");
        tokens.add(".");
        tokens.add("b");
        tokens.add("==");
        tokens.add("c");
        tokens.add(".");
        tokens.add("d");
        tokens.add("||");
        tokens.add("e");
        tokens.add(".");
        tokens.add("f");
        tokens.add("==");
        tokens.add("g");
        tokens.add(".");
        tokens.add("h");

        TreeNode rootNode = null;

        TreeNode currentNode = null;
        TreeNode currentOperator = null;

        boolean done = false;
        int i = 0;
        while (!done) {

            System.out.println("--------------------------------------");
            if (rootNode != null) {
                // DEBUG
                StringBuilder stringBuilder = new StringBuilder();
                rootNode.printRecursive(stringBuilder, 0);
                System.out.println(stringBuilder.toString());
            }

            String currentToken = tokens.get(i);
            String lookaheadToken = (i + 1) < tokens.size() ? tokens.get(i + 1) : null;

            System.out.println("CurrToken: " + currentToken);
            System.out.println("LookaheadToken: " + lookaheadToken);
            System.out.println("--------------------------------------");

            if (AbstractFileStackFrame.isBinaryOperator(currentToken)) {

                TreeNode newNode = new TreeNode();
                newNode.value = currentToken;

                newNode.addChild(currentNode);

                currentNode = newNode;

                currentOperator = currentNode;

                rootNode = currentOperator;

            } else {

                TreeNode newNode = null;
                if (currentNode == null) {
                    currentNode = new TreeNode();
                    currentNode.value = currentToken;
                } else {
                    newNode = new TreeNode();
                    newNode.value = currentToken;

                    currentNode.addChild(newNode);
                }

                boolean shifted = false;
                if ((lookaheadToken != null) && (AbstractFileStackFrame.isBinaryOperator(lookaheadToken))
                        && (currentOperator != null)) {
                    if (comparePriority(false, 0, currentOperator.value, lookaheadToken) < 0) {
                        System.out.println("SHIFT");

                        TreeNode newOperatorNode = new TreeNode();
                        newOperatorNode.value = lookaheadToken;
                        currentOperator = newOperatorNode;

                        newOperatorNode.reparent(newNode);
                        currentNode = newOperatorNode;

                        // DEBUG
                        StringBuilder stringBuilder = new StringBuilder();
                        rootNode.printRecursive(stringBuilder, 0);
                        System.out.println(stringBuilder.toString());

                        i++;
                        shifted = true;
                    }
                }

                if (!shifted) {
                    System.out.println("REDUCE");

                    while (AbstractFileStackFrame.isBinaryOperator(currentNode.value)) {
                        if (currentNode.parent == null) {
                            break;
                        }

                        currentNode = (TreeNode) currentNode.parent;
                        currentOperator = currentNode;

                    }

                }

            }

            i++;

            if (i >= tokens.size()) {
                done = true;
                continue;
            }

        }

        // DEBUG
        StringBuilder stringBuilder = new StringBuilder();
        rootNode.printRecursive(stringBuilder, 0);
        System.out.println(stringBuilder.toString());

        System.out.println("end");
    }

    private static int comparePriority(boolean functionCall, int customWeight, String lhs, String rhs) {

        int priorityLHS = 0;
        int priorityRHS = 0;

        if (functionCall) {

            priorityLHS = 1000 - 2;
            priorityRHS = AbstractFileStackFrame.getPriority(rhs);

        } else {

            priorityLHS = customWeight + AbstractFileStackFrame.getPriority(lhs);
            priorityRHS = AbstractFileStackFrame.getPriority(rhs);

        }

        return priorityRHS - priorityLHS;

    }

    private static void tacky() throws IOException {

        //
        // for verification ordered by amount of dependencies used
        // from essential to higher level
        //
        // All scripts should return the value 0. Otherwise validation
        // throws an error
        //
        // final String filename = "src/test/resources/TACKY/main_function_return_value.tky";
        // final String filename = "src/test/resources/TACKY/jump.tky";
        // final String filename = "src/test/resources/TACKY/assignment.tky";
        // final String filename = "src/test/resources/TACKY/expression_add.tky";
        // final String filename = "src/test/resources/TACKY/expression_less_than_constants.tky";
        // final String filename = "src/test/resources/TACKY/expression_less_than_var_constant.tky";
        // final String filename = "src/test/resources/TACKY/if_else.tky";
        // final String filename = "src/test/resources/TACKY/for_loop.tky";
        // final String filename = "src/test/resources/TACKY/while_loop.tky";
        // final String filename = "src/test/resources/TACKY/do_while_loop.tky";
        // TODO
        final String filename = "src/test/resources/TACKY/pointer_creation.tky";
        // TODO
        // final String filename = "src/test/resources/TACKY/array_int.tky";
        // final String filename = "src/test/resources/TACKY/printf_function_call.tky";
        // final String filename = "src/test/resources/TACKY/function_call.tky";
        // final String filename = "src/test/resources/TACKY/function_call_return_value.tky";
        //final String filename = "src/test/resources/TACKY/function_call_pass_by_value.tky";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        final TACKYLexer lexer = new TACKYLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final TACKYParser parser = new TACKYParser(tokens);

        // parse
        Tacky_fileContext root = parser.tacky_file();

        // create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        System.out.println("-- 1 - Parsing Input ------------------------------------");

        // DEBUG output parse tree while parsing
        boolean printParseTree = true;
        // boolean printParseTree = false;

        if (printParseTree) {
            ConsoleTACKYParserListener printListener = new ConsoleTACKYParserListener();
            walker.walk(printListener, root);
        }

        System.out.println("----------------------------------------------------------\n");

        System.out.println("-- 2 - Parsing Tree ---> Abstract Syntax Tree ------------");

        ASTNode rootNode = new ASTNode();
        rootNode.value = "[tacky_file] root";

        StructureTACKYParserListener structureTACKYParserListener = new StructureTACKYParserListener();
        structureTACKYParserListener.currentNode = rootNode;

        TACKYParserListener listener = structureTACKYParserListener;

        // Walk the tree created during the parse, trigger callbacks
        walker.walk(listener, root);

        System.out.println("----------------------------------------------------------\n");

        System.out.println("-- 3 - DEBUG OUTPUT Abstract Syntax Tree -------------------");

        // DEBUG print AST
        boolean printAST = true;
        // boolean printAST = false;
        if (printAST) {
            StringBuilder stringBuilder = new StringBuilder();
            rootNode.printRecursive(stringBuilder, 0, true);
            System.out.print(stringBuilder.toString());
        }

        System.out.println("----------------------------------------------------------\n");

        System.out.println("-- 4 - Run the TACKY code ----------------------------------");

        //
        // run the TACKY code
        //

        // find the 'program' statement
        ProgramASTNode program = (ProgramASTNode) rootNode.children.stream().filter(e -> e instanceof ProgramASTNode)
                .findFirst().get();
        String mainEntryPointName = program.value;

        System.out.println("MainEntryPoint is \"" + mainEntryPointName + "\"");
        FunctionDefinitionASTNode mainFunction = structureTACKYParserListener.functionDefinitionMap
                .get(mainEntryPointName);

        System.out.println("mainFunction found is \"" + mainFunction.value + "\"");

        TACKYStackFrame newTackyStackFrame = new TACKYStackFrame();

        DefaultTACKYExecutor tackyExecutor = new DefaultTACKYExecutor();
        tackyExecutor.functionDefinitionMap = structureTACKYParserListener.functionDefinitionMap;
        int returnValue = tackyExecutor.executeFunction(newTackyStackFrame, rootNode, 0, mainFunction);

        if (returnValue == 0) {
            System.out.println("[OK]");
            System.out.println("[OK]");
            System.out.println("[OK]");
        } else {
            throw new RuntimeException("\n[ERROR]\n[ERROR] Script did not return zero but " + returnValue + "! Unit Test failed!\n[ERROR]");
        }

        System.out.println("----------------------------------------------------------\n");

        System.out.println("Application is done!");
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

        // TODO:
        // STATUS: SQUARE macro is parsed correctly, but not resolved when encountered!
        // final String filename = "src/test/resources/preprocessor/define_square.pp";

        // STATUS: OK
        // SQUARE macro is parsed correctly! The define key map contains the
        // function call including the formal parameter and the define map contains
        // the macro body
        // final String filename = "src/test/resources/preprocessor/define.pp";

        // TODO:
        // STATUS: goes into PREPROCESSOR parse mode and this is throwing a
        // RuntimeException!
        // final String filename = "src/test/resources/preprocessor/dgame.pp"; // TODO

        // STATUS: OK
        // final String filename =
        // "src/test/resources/preprocessor/if_defined_nested.pp";

        // STATUS: OK
        // final String filename = "src/test/resources/preprocessor/if_defined.pp";

        // STATUS: Macro is defined correctly, but not resolved when encountered!
        // final String filename = "src/test/resources/preprocessor/if_not_defined.pp";

        // STATUS: OK
        // final String filename = "src/test/resources/preprocessor/if.pp";

        // STATUS: OK
        // macro is parsed correctly! The define key map contains the
        // function call including the formal parameter and the define map contains
        // the macro body
        // final String filename = "src/test/resources/preprocessor/ifdef_2.pp";

        // final String filename = "src/test/resources/preprocessor/ifdef_else.pp";

        // final String filename = "src/test/resources/preprocessor/ifdef.pp";
        // final String filename = "src/test/resources/preprocessor/ifndef.pp";

        // final String filename = "src/test/resources/preprocessor/include.pp";
        // final String filename = "src/test/resources/preprocessor/scratchpad.pp";

        // final String filename = "src/test/resources/preprocessor/funcs.h";
        // final String filename = "src/test/resources/preprocessor/vars.h";
        //

        // final String filename = "src/test/resources/preprocessor/replace_1.pp";
        // final String filename = "src/test/resources/preprocessor/replace_2.pp";

        // TODO: next
        //
        final String filename = "src/test/resources/preprocessor/printf_test_1.pp";

        ASTNode dummyASTNode = new ASTNode();
        dummyASTNode.value = "__DUMMY___11223344__";

        StringBuilder outputStringBuilder = new StringBuilder();
        Map<String, ASTNode> defineMap = new HashMap<>();
        Map<String, ASTNode> defineKeyMap = new HashMap<>();

        DefaultFileStackFrameCallback defaultFileStackFrameCallback = new DefaultFileStackFrameCallback();
        defaultFileStackFrameCallback.defineMap = defineMap;
        defaultFileStackFrameCallback.defineKeyMap = defineKeyMap;
        defaultFileStackFrameCallback.dummyASTNode = dummyASTNode;

        // ExprTreeFileStackFrame fileStackFrame = new ExprTreeFileStackFrame();
        // DefaultFileStackFrame fileStackFrame = new DefaultFileStackFrame();
        SimpleFileStackFrame fileStackFrame = new SimpleFileStackFrame();
        fileStackFrame.callback = defaultFileStackFrameCallback;
        fileStackFrame.filename = filename;
        fileStackFrame.outputStringBuilder = outputStringBuilder;

        Stack<IFileStackFrame> fileStack = new Stack<>();
        fileStack.push(fileStackFrame);

        fileStackFrame.fileStack = fileStack;

        // here, the stackframe parses the input file
        fileStackFrame.start();

        String result = outputStringBuilder.toString();
        System.out.println(result);

        Files.writeString(Paths.get(filename + ".out"), result);

        System.out.println("\n\n---------------- Define Key Map ------------------");

        for (Map.Entry<String, ASTNode> entry : defineKeyMap.entrySet()) {

            String entryKey = entry.getKey();
            TreeNode entryValue = (TreeNode) entry.getValue();

            System.out.println("functionCall: " + entryValue.functionCall);

            StringBuilder stringBuilder = new StringBuilder();
            entryValue.printRecursive(stringBuilder, 0);
            System.out.println(entryKey + " - " + stringBuilder.toString());
        }

        System.out.println("\n\n---------------- Define Value Map ------------------");

        for (Map.Entry<String, ASTNode> entry : defineMap.entrySet()) {

            String entryKey = entry.getKey();
            ASTNode entryValue = entry.getValue();

            StringBuilder stringBuilder = new StringBuilder();
            entryValue.printRecursive(stringBuilder, 0);
            System.out.println(entryKey + " - " + stringBuilder.toString());
        }

    }

    private static void preprocessor_3() throws IOException {

        // final String filename = "src/test/resources/preprocessor/if_defined.pp";
        final String filename = "src/test/resources/preprocessor/scratchpad.pp";

        final CharStream charStream = CharStreams
                .fromFileName(filename);

        // final CPreprocessorLexerRule lexer = new CPreprocessorLexerRule(charStream);
        final CPreprocessorLexer lexer = new CPreprocessorLexer(charStream);

        // create a buffer of tokens pulled from the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final CPreprocessorParser parser = new CPreprocessorParser(tokens);

        // parse
        ProgramContext root = parser.program();

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();

        boolean printParseTree = true;
        // boolean printParseTree = false;
        if (printParseTree) {
            ConsoleCPreprocessorParserListener printListener = new ConsoleCPreprocessorParserListener();
            walker.walk(printListener, root);
        }

    }

    private static void ide() {
        // Auto-generated method stub
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
