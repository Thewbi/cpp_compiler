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

    private static final boolean ADD_SUB_NODE = false;

    public String filename;

    public StringBuilder outputStringBuilder;

    public Stack<FileStackFrame> fileStack;

    public Path basePath;

    public FileStackFrameCallback callback;

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

        // CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        // for (int i = 0; i < 10; i++) {

        // List<Token> tokenList = commonTokenStream.get(0, commonTokenStream.size());
        // for (Token t : tokenList) {
        // System.out.println(
        // "" + t.getChannel() + "[" + t.getTokenIndex() + "] : " + t.getText());
        // }

        // commonTokenStream.consume();

        // }

        /**/
        ASTNode rootNode = new ASTNode();
        rootNode.value = "root____";
        rootNode.parent = null;

        ASTNode currentNode = rootNode;

        // boolean isDefine = false;

        Token token = lexer.nextToken();
        while ((token != null) && (token.getType() != Token.EOF)) {

            // System.out.println(token);
            System.out.println(
                    " " + token.getChannel() + "[" + token.getTokenIndex() + "] : " + token.getText());

            // if (token.getText().equalsIgnoreCase("#define")) {

            //     isDefine = true;

            //     token = lexer.nextToken();
            //     continue;
            // }

            ASTNode node = new ASTNode();

            String text = token.getText();

            if (text.equalsIgnoreCase(" ")) {

                // what is this branch for?

                if (currentNode.parent == null) {
                    token = lexer.nextToken();
                    continue;
                }

                // ascend
                // currentNode = currentNode.parent;

            }
            else if (text.equalsIgnoreCase("#define")) {

                //token = lexer.nextToken();
                //processDefine(rootNode);

                node = new ASTNode();
                node.value = "#define";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            }
            // else if (text.equalsIgnoreCase("#if")) {

            //     System.out.println("if");

            //     // TODO: continue here

            // } else if (text.equalsIgnoreCase("#ifdef")) {

            //     System.out.println("ifdef");

            //     // TODO: continue here

            // }
            else if (text.equalsIgnoreCase("#include")) {

                String includeFile = "";
                while (includeFile.isBlank()) {
                    includeFile = lexer.nextToken().getText();
                }

                includeFile = StringUtil.unwrap(includeFile);

                System.out.println("Processing include file: \"" + includeFile + "\"");

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

                if (currentNode.parent == null) {

                    token = lexer.nextToken();
                    continue;
                }

                // // ascend ( into sub )
                // currentNode = currentNode.parent;

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

                if (currentNode.value.equalsIgnoreCase("defined")) {
                    // ascend ( out of sub into parent )
                    currentNode = currentNode.parent;
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

                System.out.println("Newline");

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

            } else {

                node.value = text;

                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                // currentNode = node;

                if (ADD_SUB_NODE) {
                    if (currentNode.value.equalsIgnoreCase("defined")) {
                        // ascend ( out of sub into parent )
                        currentNode = currentNode.parent;
                    }
                }

            }

            token = lexer.nextToken();

            // TODO: do not put new_line into the hidden channel! So we can detect it here!
            // if (token.getType() == Token.New)

        }

        // output the very last node
        if (rootNode.children.size() != 0) {

            callback.execute(rootNode);
        }

        fileStack.pop();
    }



}
