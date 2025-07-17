package preprocessor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import com.cpp.grammar.PreprocessorLexer2;

import ast.ASTNode;
import common.StringUtil;

public class FileStackFrame {

    private static final boolean ADD_SUB_NODE = true;

    public String filename;

    public StringBuilder outputStringBuilder;

    public Stack<FileStackFrame> fileStack;

    public Path basePath;

    public FileStackFrameCallback callback;

    public boolean defineMode;

    public boolean defineModeKey;
    public boolean defineModeValue;

    public void start() throws IOException {

        CharStream charStream = null;

        if (basePath == null) {

            basePath = Path.of(filename);
            System.out.println("BasePath: \"" + basePath.getParent().toString() + "\"");

            charStream = CharStreams
                    .fromFileName(filename);

        } else {

            Path newFile = basePath.resolveSibling(filename);
            charStream = CharStreams
                    .fromFileName(newFile.toString());

        }

        // final CPP14Lexer lexer = new CPP14Lexer(charStream);
        final PreprocessorLexer2 lexer = new PreprocessorLexer2(charStream);

        ASTNode rootNode = new ASTNode();
        rootNode.value = "root____";
        rootNode.parent = null;

        ASTNode currentNode = rootNode;

        int line = 1;
        //System.out.println("Line: " + line);

        Token token = lexer.nextToken();
        while ((token != null) && (token.getType() != Token.EOF)) {

            if (line != token.getLine()) {
                line = token.getLine();
                //System.out.println("Line: " + line);
            }

            // DEBUG
            // System.out.println(
            // " " + token.getChannel() + "[" + token.getTokenIndex() + "] : " +
            // token.getText());

            ASTNode node = new ASTNode();

            String text = token.getText();

            if (text.equalsIgnoreCase(" ")) {

                // what is this branch for?

                if (currentNode.parent == null) {
                    token = lexer.nextToken();
                    continue;
                }

            } else if (text.equalsIgnoreCase("#define")) {

                defineMode = true;
                defineModeKey = true;
                defineModeValue = false;

                node = new ASTNode();
                node.value = "#define";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

                node = new ASTNode();

            } else if (text.equalsIgnoreCase("#if")) {

                node = new ASTNode();
                node.value = "#if";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#elif")) {

                node = new ASTNode();
                node.value = "#elif";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#else")) {

                node = new ASTNode();
                node.value = "#else";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifdef")) {

                node = new ASTNode();
                node.value = "#ifdef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifndef")) {

                node = new ASTNode();
                node.value = "#ifndef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#include")) {

                String includeFile = "";
                while (includeFile.isBlank()) {
                    includeFile = lexer.nextToken().getText();
                }

                includeFile = StringUtil.unwrap(includeFile);

                // DEBUG
                // System.out.println("Processing include file: \"" + includeFile + "\"");

                FileStackFrame fileStackFrame = new FileStackFrame();
                fileStackFrame.filename = includeFile;
                fileStackFrame.outputStringBuilder = outputStringBuilder;
                fileStackFrame.callback = callback;
                fileStackFrame.fileStack = fileStack;
                fileStackFrame.basePath = basePath;

                fileStack.push(fileStackFrame);

                fileStackFrame.start();

            } else if (text.equalsIgnoreCase("(")) {

                if (ADD_SUB_NODE) {
                    node.value = "sub";

                    currentNode.children.add(node);
                    node.parent = currentNode;

                    // descend
                    currentNode = node;

                    node = new ASTNode();
                }

                node.value = "(";
                currentNode.children.add(node);

            } else if (text.equalsIgnoreCase(")")) {

                node = new ASTNode();
                node.value = ")";
                currentNode.children.add(node);
                node.parent = currentNode;

                if (currentNode.parent == null) {

                    token = lexer.nextToken();
                    continue;
                }

                if (ADD_SUB_NODE) {
                    // ascend ( out of sub into parent )
                    currentNode = currentNode.parent;
                }

                if (currentNode.value != null && currentNode.value.equalsIgnoreCase("defined")) {
                    // ascend ( out of sub into parent )
                    currentNode = currentNode.parent;
                }

                if ("define_key___".equalsIgnoreCase(currentNode.type)) {

                    currentNode = currentNode.parent;
                    defineModeKey = false;
                    defineModeValue = true;

                    node = new ASTNode();

                    currentNode.children.add(node);
                    node.parent = currentNode;

                    node.value = "define_value___";
                    node.type = "define_value___";

                    // descend into key
                    currentNode = node;

                }

            } else if (text.equalsIgnoreCase("defined")) {

                node = new ASTNode();
                node.value = "defined";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("||")
                    ||
                    text.equalsIgnoreCase("&&")
                    ||
                    text.equalsIgnoreCase(">=")) {

                int size = currentNode.children.size();
                ASTNode lhs = currentNode.children.get(size - 1);

                currentNode.children.remove(lhs);

                node = new ASTNode();
                node.value = text;
                currentNode.children.add(node);
                node.parent = currentNode;

                // reparent
                node.children.add(lhs);
                lhs.parent = node;

                // descend
                currentNode = node;

            } else if (token.getType() == PreprocessorLexer2.Newline) {

                // deal with completely empty lines (the node is still the root node and it has
                // no children)
                if (rootNode.children.size() == 0) {
                    token = lexer.nextToken();
                    continue;
                }

                callback.execute(rootNode);

                // start a new root
                rootNode = new ASTNode();
                rootNode.value = "root____";
                rootNode.parent = null;

                currentNode = rootNode;

                defineMode = false;

            } else {

                node.value = text;

                if ("define_key___".equalsIgnoreCase(currentNode.type)) {

                    node.type = "define_value___";

                    currentNode = currentNode.parent;

                    currentNode.children.add(node);
                    node.parent = currentNode;

                    token = lexer.nextToken();
                    continue;
                }

                currentNode.children.add(node);
                node.parent = currentNode;

                if (defineMode && defineModeKey) {

                    node.type = "define_key___";

                    // descend into key
                    currentNode = node;

                    defineModeKey = false;

                }

                if (ADD_SUB_NODE) {
                    if (currentNode.value.equalsIgnoreCase("defined")) {
                        // ascend ( out of sub into parent )
                        currentNode = currentNode.parent;
                    }
                }

            }

            token = lexer.nextToken();

        }

        // output the very last node
        if (rootNode.children.size() != 0) {

            callback.execute(rootNode);
        }

        fileStack.pop();
    }

}
