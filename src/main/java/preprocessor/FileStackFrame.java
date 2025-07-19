package preprocessor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    /**
     * When angle brackets / chevrons are used, the include file
     * is resolved using the include-path. The include-path is a variable
     * combining several folders where include files are searched.
     *
     * If this variable is set to true, then the application looks for the
     * include file in the include-path.
     *
     * If this variable is set to false, then the application looks for the
     * include file in relative paths, relative to the basePath variable which
     * is also defined in this class.
     */
    public boolean useIncludePathResolution;

    public List<Path> includePath = new ArrayList<>();

    public Path basePath;

    public StringBuilder outputStringBuilder;

    public Stack<FileStackFrame> fileStack;

    public FileStackFrameCallback callback;

    public boolean defineMode;

    public boolean defineModeKey;
    public boolean defineModeValue;

    public static Optional<Path> match(String glob, String location) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
        return Files.walk(Paths.get(location)).filter(pathMatcher::matches).findFirst();
    }

    public void start() throws IOException {

        CharStream charStream = null;

        if (useIncludePathResolution) {

            for (Path path : includePath) {
                Optional<Path> result = match("glob:**/stdio.h", path.toAbsolutePath().toString());
                if (result.isPresent()) {
                    String foundFile = result.get().toAbsolutePath().toString();
                    System.out.println("Result: \"" + foundFile + "\"");
                    charStream = CharStreams.fromFileName(foundFile);
                    break;
                }
            }

        } else if (basePath == null) {

            basePath = Path.of(filename);
            //System.out.println("BasePath: \"" + basePath.getParent().toString() + "\"");
            charStream = CharStreams .fromFileName(filename);

        } else {

            Path newFile = basePath.resolveSibling(filename);
            charStream = CharStreams
                    .fromFileName(newFile.toString());

        }

        final PreprocessorLexer2 lexer = new PreprocessorLexer2(charStream);

        ASTNode rootNode = new ASTNode();
        rootNode.value = "root____";
        rootNode.parent = null;

        ASTNode currentNode = rootNode;

        int line = 1;
        // System.out.println("Line: " + line);

        Token token = lexer.nextToken();
        while ((token != null) && (token.getType() != Token.EOF)) {

            if (line != token.getLine()) {
                line = token.getLine();
                // System.out.println("Line: " + line);
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

                String temp = "";
                boolean useIncludePathResolution = false;

                StringBuilder includeFilePreprocessorCommand = new StringBuilder();

                boolean includeFileStringAssembled = false;
                while (!includeFileStringAssembled) {

                    while (temp.isBlank()) {
                        temp = lexer.nextToken().getText();
                    }

                    if (temp.equalsIgnoreCase("<")) {

                        includeFilePreprocessorCommand.append(temp);

                        // when angle brackets / chevrons are used, the include file
                        // is resolved using the include-path. The include-path is a variable
                        // combining several folders where include files are searched
                        useIncludePathResolution = true;

                    } else if (temp.equalsIgnoreCase(">")) {

                        includeFilePreprocessorCommand.append(temp);
                        includeFileStringAssembled = true;

                    } else if (temp.startsWith("\"")) {

                        includeFilePreprocessorCommand.append(temp);
                        includeFileStringAssembled = true;

                    } else {

                        includeFilePreprocessorCommand.append(temp);

                        // throw new RuntimeException("Cannot parse include-file preprocessor
                        // command!");

                    }

                    temp = "";

                }

                String includeFile = StringUtil.unwrap(includeFilePreprocessorCommand.toString());

                // DEBUG
                // System.out.println("Processing include file: \"" + includeFile + "\"");

                ((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;

                FileStackFrame fileStackFrame = new FileStackFrame();
                fileStackFrame.filename = includeFile;
                fileStackFrame.useIncludePathResolution = useIncludePathResolution;
                fileStackFrame.includePath.add(basePath.getParent()); // fake dummy include path using the basepath
                fileStackFrame.basePath = basePath;
                fileStackFrame.outputStringBuilder = outputStringBuilder;
                fileStackFrame.callback = callback;
                fileStackFrame.fileStack = fileStack;

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

                // DEBUG
                StringBuilder debugStringBuilder = new StringBuilder();
                rootNode.printRecursive(debugStringBuilder, 0);
                System.out.println(debugStringBuilder.toString());

                // deal with completely empty lines (the node is still the root node and it has
                // no children)
                if (rootNode.children.size() == 0) {
                    token = lexer.nextToken();
                    continue;
                }

                ((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;
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
