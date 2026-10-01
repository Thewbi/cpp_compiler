package preprocessor;

import java.io.IOException;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.math.NumberUtils;

import com.cpp.grammar.PreprocessorLexer2;

import ast.ASTNode;
import common.StringUtil;

public class SimpleFileStackFrame extends AbstractFileStackFrame {

    public Map<String, ASTNode> defineValueMap;
    public boolean defineMode;
    public boolean defineModeKey;
    public boolean defineModeValue;

    private ParserMode parserMode = ParserMode.NORMAL;

    private TreeNode expressionRootNode = null;
    private int customWeight = 0;
    private int balance = 0;
    private boolean identifier = false;
    private boolean lookAheadUsed = false;

    @Override
    public void start() throws IOException {

        CharStream charStream = includeToCharStream();
        final PreprocessorLexer2 lexer = new PreprocessorLexer2(charStream);

        ASTNode rootNode = new ASTNode();
        rootNode.value = "root____";
        rootNode.parent = null;

        ASTNode currentNode = rootNode;

        // DEBUG
        // int line = 1;
        //System.out.println("Line: " + line);

        //
        // Comments:
        //
        // Using a lexer has the advange that the lexer will not emit any comments!
        // The preprocessor contains no code that deals with comments!
        //

        Token token = lexer.nextToken();
        while ((token != null) && (token.getType() != Token.EOF)) {

            String text = token.getText();

            // add a newline
            if (token.getType() == PreprocessorLexer2.Newline) {
                outputStringBuilder.append("\n");
            }

            // skip space
            if (text.equalsIgnoreCase(" ")) {
                token = lexer.nextToken();
                continue;
            }

            ASTNode node = new ASTNode();

            if (text.equalsIgnoreCase("#define")) {

                setParserMode(ParserMode.DEFINE);

                defineMode = true;
                defineModeKey = true;
                defineModeValue = false;

                node = new ASTNode();
                node.value = "#define";

                // connect child and parent
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

                node = new ASTNode();

            } else if (text.equalsIgnoreCase("#if")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new ASTNode();
                node.value = "#if";

                // connect parent and child
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

                token = lexer.nextToken();
                continue;

            } else if (text.equalsIgnoreCase("#elif")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new ASTNode();
                node.value = "#elif";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#else")) {

                setParserMode(ParserMode.PREPROCESSOR);

                node = new ASTNode();
                node.value = "#else";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#endif")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new ASTNode();
                node.value = "#endif";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifdef")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new ASTNode();
                node.value = "#ifdef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifndef")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new ASTNode();
                node.value = "#ifndef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#include")) {

                setParserMode(ParserMode.PREPROCESSOR);

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

                setParserMode(ParserMode.NORMAL);

            } else if (text.equalsIgnoreCase("(")) {

                if (parserMode == ParserMode.EXPRESSION) {

                    processExpressionNode(text);

                } else if (parserMode == ParserMode.DEFINE) {

                    processExpressionNode(text);

                } else if (parserMode == ParserMode.PREPROCESSOR) {

                    throw new RuntimeException("");

                } else {

                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(" ").append(text);
                    }

                }

            } else if (text.equalsIgnoreCase(")")) {

                if (parserMode == ParserMode.DEFINE) {

                    processExpressionNode(text);

                    // an expression is finished
                    if (balance == 0) {
                        currentNode.children.add(expressionRootNode);

                        // start new expression
                        expressionRootNode = null;
                        identifier = false;
                    }

                } else if (parserMode == ParserMode.EXPRESSION) {

                    // an if-statement is finished
                    if (balance == 0) {

                        currentNode.children.add(expressionRootNode);

                        expressionRootNode = null;

                        // go back to the root node
                        currentNode = currentNode.parent;

                    } else {

                        processExpressionNode(text);

                    }

                } else {

                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(" ").append(text);
                    }

                }

            } else if (token.getType() == PreprocessorLexer2.Newline) {

                // deal with completely empty lines
                // (the node is still the root node and it has no children)
                if (rootNode.children.size() == 0) {
                    token = lexer.nextToken();
                    continue;
                }

                if (parserMode == ParserMode.EXPRESSION) {

                    currentNode.children.add(expressionRootNode);
                    expressionRootNode = null;

                    setParserMode(ParserMode.NORMAL);

                } else if (parserMode == ParserMode.DEFINE) {

                    if (expressionRootNode != null) {
                        currentNode.children.add(expressionRootNode);
                        expressionRootNode = null;
                    }

                    setParserMode(ParserMode.NORMAL);

                }

                ((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;
                callback.execute(rootNode);

                // start a new root
                rootNode = new ASTNode();
                rootNode.value = "root____";
                rootNode.parent = null;

                currentNode = rootNode;

                defineMode = false;

                setParserMode(ParserMode.NORMAL);

            } else {
                if (parserMode == ParserMode.DEFINE) {

                    processExpressionNode(text);

                    // perform lookahead
                    lookAheadUsed = true;

                    token = lexer.nextToken();
                    String temp = token.getText();

                    // skip whitespace
                    while (temp.equalsIgnoreCase(" ")) {
                        token = lexer.nextToken();
                        // continue;
                        temp = token.getText();
                    }

                    if (

                        currentNode.children.size() == 0
                        && !temp.equalsIgnoreCase("(")
                        && !temp.equalsIgnoreCase(")")
                        ||
                        (token.getType() == Token.EOF)
                        ||
                        temp.equalsIgnoreCase("\n")
                    ) {
                        currentNode.children.add(expressionRootNode);

                        balance = 0;
                        customWeight = 0;
                        identifier = false;
                        expressionRootNode = null;
                    }

                } else if (parserMode == ParserMode.EXPRESSION) {

                    processExpressionNode(text);

                } else if (parserMode == ParserMode.PREPROCESSOR) {

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

                } else {
                    // Replace defined symbols by their defined meaning!
                    text = filterByPreprocessorValues(text);
                    // ???
                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(" ").append(text);
                    }
                }
            }

            if (!lookAheadUsed) {
                token = lexer.nextToken();
            }

            lookAheadUsed = false;
        }

        // output the very last node
        if (rootNode.children.size() != 0) {

            callback.execute(rootNode);
        }

        fileStack.pop();

    }

    /**
     * Replace defined symbols by their defined meaning!
     *
     * @param data
     * @return
     */
    private String filterByPreprocessorValues(String data) {

        // if the current symbol is not a DEFINED symbol which needs to be replaced, early out
        if (!defineValueMap.containsKey(data)) {
            return data;
        }

        // replace the DEFINED symbol by it's definition
        TreeNode treeNode = (TreeNode) defineValueMap.get(data);
        evaluatePreprocessorTreeNode(treeNode);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(treeNode.stringValueEval);

        return stringBuilder.toString();
    }

    private void evaluatePreprocessorTreeNode(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        if ((treeNode.rhs == null) && (treeNode.lhs == null)) {

            if (defineValueMap.containsKey(treeNode.value)) {
                TreeNode valueTreeNode = (TreeNode) defineValueMap.get(treeNode.value);
                treeNode.stringValueEval = valueTreeNode.value;
                if (NumberUtils.isParsable(valueTreeNode.value)) {
                    treeNode.integerValueEval = Integer.valueOf(valueTreeNode.value);
                }
            } else {
                treeNode.stringValueEval = treeNode.value;
            }

            return;
        }

        evaluatePreprocessorTreeNode(treeNode.lhs);
        evaluatePreprocessorTreeNode(treeNode.rhs);

        if (treeNode.value.equalsIgnoreCase("*")) {
            treeNode.integerValueEval = treeNode.lhs.integerValueEval * treeNode.rhs.integerValueEval;
            treeNode.stringValueEval = treeNode.integerValueEval.toString();
        }

    }

    private void evaluatePreprocessorTreeNodeAsString(TreeNode treeNode, StringBuilder stringBuilder) {

        if (treeNode == null) {
            return;
        }

        if ((treeNode.rhs == null) && (treeNode.lhs == null)) {
            if (defineValueMap.containsKey(treeNode.value)) {
                stringBuilder.append(defineValueMap.get(treeNode.value).value);
            } else {
                stringBuilder.append(treeNode.value);
            }
            return;
        }

        evaluatePreprocessorTreeNodeAsString(treeNode.lhs, stringBuilder);
        stringBuilder.append(treeNode.value);
        evaluatePreprocessorTreeNodeAsString(treeNode.rhs, stringBuilder);
    }

    private void setParserMode(ParserMode parserMode) {
        this.parserMode = parserMode;
    }

    private void processExpressionNode(String currentTokenAsString) {

        // // DEBUG
        // System.out.println(currentToken);

        if (currentTokenAsString.equalsIgnoreCase("(")) {

            balance++;

            if (identifier) {

                // DEBUG
                // System.out.println("function call detected: " + lastIdentifier);

                //functionCall = true;
                expressionRootNode.functionCall = true;
            }

            customWeight += 1000;
            return;

        }
        if (currentTokenAsString.equalsIgnoreCase(")")) {

            balance--;

            customWeight -= 1000;
            return;
        }

        identifier = AbstractFileStackFrame.isIdentifier(currentTokenAsString);

        boolean isFuncCall = expressionRootNode != null ? expressionRootNode.functionCall : false;

        expressionRootNode = insertTokenIntoTree(expressionRootNode, currentTokenAsString, customWeight,
                isFuncCall);


        // // DEBUG
        // StringBuilder stringBuilder = new StringBuilder();
        // expressionRootNode.printRecursive(stringBuilder, 0);
        // System.out.println(stringBuilder.toString());
        // System.out.println("--------------------------------------");
    }

    /**
     * This function contains the basic idea of the algorithm. The purpose of the
     * algorithm is to parse expressions without a parser, using a lexer and token
     * only.
     * The expression is represented using a binary tree.
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

            // System.out.println("existing node is heavier");

            TreeNode newNode = new TreeNode();
            newNode.value = token;
            newNode.customWeight = customWeight;

            newNode.reparent(node);

            return newNode;

        } else {

            // System.out.println("existing node is lighter");

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

            priorityLHS = customWeight;
            if (lhs != null) {
                priorityLHS += AbstractFileStackFrame.getPriority(lhs);
            }
            if (rhs != null) {
                priorityRHS = AbstractFileStackFrame.getPriority(rhs);
            }

        }

        return priorityRHS - priorityLHS;

    }

}
