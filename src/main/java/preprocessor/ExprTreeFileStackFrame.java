package preprocessor;

import java.io.IOException;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import com.cpp.grammar.PreprocessorLexer2;

import ast.ASTNode;
import ast.ExpressionType;
import common.StringUtil;

public class ExprTreeFileStackFrame extends AbstractFileStackFrame {

    private static final boolean ADD_SUB_NODE = true;

    public boolean defineMode;
    public boolean defineModeKey;
    public boolean defineModeValue;

    private ParserMode parserMode = ParserMode.NORMAL;

    // public TreeNode rootTreeNode;
    // public TreeNode currentTreeNode;

    private TreeNode expressionRootNode = null;
    private int customWeight = 0;
    private boolean identifier = false;
    private String lastIdentifier = null;

    @Override
    public void start() throws IOException {

        CharStream charStream = includeToCharStream();
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

                parserMode = ParserMode.EXPRESSION;

                //processExpressionNode(text);

                // skip brace ('(')
                token = lexer.nextToken();

                token = lexer.nextToken();
                continue;

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

                DefaultFileStackFrame fileStackFrame = new DefaultFileStackFrame();
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

                if (parserMode == ParserMode.EXPRESSION) {

                    processExpressionNode(text);

                } else {

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

                }

            } else if (text.equalsIgnoreCase(")")) {

                if (parserMode == ParserMode.EXPRESSION) {

                    // an if-statement is finished
                    if (expressionRootNode.balance == 0) {

                        expressionRootNode.linearAddInto(currentNode.children);
                        expressionRootNode = null;

                        node = new ASTNode();
                        node.value = token.getText();
                        currentNode.children.add(node);

                        // go back to the root node
                        currentNode = currentNode.parent;

                        parserMode = ParserMode.NORMAL;

                    } else {

                        processExpressionNode(text);

                    }

                } else {

                    node = new ASTNode();
                    node.value = ")";
                    currentNode.children.add(node);
                    node.parent = currentNode;

                    if (currentNode.parent == null) {

                        token = lexer.nextToken();
                        continue;
                    }

                    if (ADD_SUB_NODE) {
                        // ascend (out of sub into parent)
                        currentNode = currentNode.parent;
                    }

                    if (currentNode.value != null && currentNode.value.equalsIgnoreCase("defined")) {
                        // ascend (out of sub into parent)
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

                }

            }


            // else if (text.equalsIgnoreCase("defined")) {

            //     node = new ASTNode();
            //     node.value = "defined";
            //     currentNode.children.add(node);
            //     node.parent = currentNode;

            //     // descend
            //     currentNode = node;

            // }

            // else if (isBinaryOperator(text)) {

            //     if (parserMode == ParserMode.EXPRESSION) {

            //         TreeNode treeNode = new TreeNode();
            //         treeNode.parent = null;
            //         treeNode.value = text;

            //         treeNode.addChild(rootTreeNode);

            //         rootTreeNode = treeNode;

            //     } else {

            //         int size = currentNode.children.size();
            //         ASTNode lhs = currentNode.children.get(size - 1);

            //         currentNode.children.remove(lhs);

            //         node = new ASTNode();
            //         node.value = text;
            //         currentNode.children.add(node);
            //         node.parent = currentNode;

            //         // reparent
            //         node.children.add(lhs);
            //         lhs.parent = node;

            //         // descend
            //         currentNode = node;

            //     }

            // }

            else if (token.getType() == PreprocessorLexer2.Newline) {

                // DEBUG
                //outputRootNode(rootNode);

                // deal with completely empty lines (the node is still the root node and it has
                // no children)
                if (rootNode.children.size() == 0) {
                    token = lexer.nextToken();
                    continue;
                }

                if (parserMode == ParserMode.EXPRESSION) {
                    //expressionRootNode.linearAddInto(currentNode.children);
                    currentNode.children.add(expressionRootNode);
                    expressionRootNode = null;

                    parserMode = ParserMode.NORMAL;
                }

                ((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;
                callback.execute(rootNode);

                // start a new root
                rootNode = new ASTNode();
                rootNode.value = "root____";
                rootNode.parent = null;

                currentNode = rootNode;

                defineMode = false;

                parserMode = ParserMode.NORMAL;

            } else {

                if (text.equalsIgnoreCase("if")) {

                    TreeNode treeNode = new TreeNode();
                    treeNode.value = text;

                    currentNode.children.add(treeNode);
                    treeNode.parent = currentNode;

                    currentNode = treeNode;

                    parserMode = ParserMode.EXPRESSION;

                    // skip bracket
                    do {
                        token = lexer.nextToken();
                    } while (!token.getText().equalsIgnoreCase("("));

                    node = new ASTNode();
                    node.value = token.getText();
                    currentNode.children.add(node);

                    token = lexer.nextToken();

                    continue;
                }

                if (parserMode == ParserMode.EXPRESSION) {

                    processExpressionNode(text);

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

            }

            token = lexer.nextToken();

        }

        // output the very last node
        if (rootNode.children.size() != 0) {

            // ((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;
            callback.execute(rootNode);
        }

        fileStack.pop();

    }

    private void outputRootNode(ASTNode rootNode) {
        StringBuilder debugStringBuilder = new StringBuilder();
        rootNode.printRecursive(debugStringBuilder, 0);
        System.out.println(debugStringBuilder.toString());
    }

    private void processExpressionNode(String currentToken) {

        if (currentToken.equalsIgnoreCase("(")) {

            expressionRootNode.balance++;

            if (identifier) {

                // DEBUG
                //System.out.println("function call detected: " + lastIdentifier);

                expressionRootNode.functionCall = true;
            }

            customWeight += 1000;
            return;

        }
        if (currentToken.equalsIgnoreCase(")")) {

            expressionRootNode.balance--;

            customWeight -= 1000;
            return;
        }

        identifier = AbstractFileStackFrame.isIdentifier(currentToken);
        lastIdentifier = currentToken;

        expressionRootNode = insertTokenIntoTree(expressionRootNode, currentToken, customWeight,
                expressionRootNode != null ? expressionRootNode.functionCall : false);

        // // DEBUG
        // StringBuilder stringBuilder = new StringBuilder();
        // expressionRootNode.printRecursive(stringBuilder, 0);
        // System.out.println(stringBuilder.toString());

        // System.out.println("--------------------------------------");
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

            //System.out.println("existing node is heavier");

            TreeNode newNode = new TreeNode();
            newNode.value = token;
            newNode.customWeight = customWeight;

            newNode.reparent(node);

            return newNode;

        } else {

            //System.out.println("existing node is lighter");

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

}
