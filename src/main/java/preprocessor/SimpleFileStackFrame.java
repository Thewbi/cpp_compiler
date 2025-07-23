package preprocessor;

import java.io.IOException;

import javax.management.RuntimeErrorException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import com.cpp.grammar.PreprocessorLexer2;

import ast.ASTNode;
import common.StringUtil;

public class SimpleFileStackFrame extends AbstractFileStackFrame {

    // private static final boolean ADD_SUB_NODE = true;

    public boolean defineMode;
    public boolean defineModeKey;
    public boolean defineModeValue;

    private ParserMode parserMode = ParserMode.NORMAL;

    private TreeNode expressionRootNode = null;
    private int customWeight = 0;
    private int balance = 0;
    private boolean functionCall = false;
    private boolean identifier = false;
    private boolean lookAheadUsed =false;

    @Override
    public void start() throws IOException {

        CharStream charStream = includeToCharStream();
        final PreprocessorLexer2 lexer = new PreprocessorLexer2(charStream);

        ASTNode rootNode = new ASTNode();
        rootNode.value = "root____";
        rootNode.parent = null;

        ASTNode currentNode = rootNode;

        Token token = lexer.nextToken();
        while ((token != null) && (token.getType() != Token.EOF)) {

            String text = token.getText();

            // skip whitespace
            if (text.equalsIgnoreCase(" ")) {
            //if (text.equalsIgnoreCase("\s+")) {
            //if (text.isBlank()) {
                token = lexer.nextToken();
                continue;
            }

            ASTNode node = new ASTNode();

            if (text.equalsIgnoreCase("#define")) {

                parserMode = ParserMode.DEFINE;

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

                parserMode = ParserMode.EXPRESSION;

                node = new ASTNode();
                node.value = "#if";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

                // skip brace ('(')
                //token = lexer.nextToken();

                token = lexer.nextToken();
                continue;

            } else if (text.equalsIgnoreCase("#elif")) {

                parserMode = ParserMode.EXPRESSION;

                node = new ASTNode();
                node.value = "#elif";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#else")) {

                parserMode = ParserMode.PREPROCESSOR;

                node = new ASTNode();
                node.value = "#else";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#endif")) {

                //throw new RuntimeException();

            } else if (text.equalsIgnoreCase("#ifdef")) {

                parserMode = ParserMode.EXPRESSION;

                node = new ASTNode();
                node.value = "#ifdef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifndef")) {

                parserMode = ParserMode.EXPRESSION;

                node = new ASTNode();
                node.value = "#ifndef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#include")) {

                parserMode = ParserMode.PREPROCESSOR;

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

                } else if (parserMode == ParserMode.DEFINE) {

                    processExpressionNode(text);

                } else if (parserMode == ParserMode.PREPROCESSOR) {

                    // ????
                    throw new RuntimeException("");

                } else {

                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(text);
                    }

                }

            } else if (text.equalsIgnoreCase(")")) {

                // if (ADD_SUB_NODE) {
                //     // ascend (out of sub into parent)
                //     currentNode = currentNode.parent;
                // }

                if (parserMode == ParserMode.DEFINE) {

                    // // an expression is finished
                    // if (expressionRootNode.balance == 0) {

                    //     // expressionRootNode.linearAddInto(currentNode.children);
                    //     // expressionRootNode = null;

                    //     // node = new ASTNode();
                    //     // node.value = token.getText();
                    //     // currentNode.children.add(node);

                    //     // // go back to the root node
                    //     // currentNode = currentNode.parent;

                    //     // // parserMode = ParserMode.NORMAL;

                    //     // if (ADD_SUB_NODE) {
                    //     //     // ascend (out of sub into parent)
                    //     //     currentNode = currentNode.parent;
                    //     // }

                    //     //node = new ASTNode();
                    //     ///node.value = ")";

                    //     // DEBUG
                    //     // if (currentNode == null) {
                    //     //     System.out.println("test");
                    //     // }

                    //     // currentNode.children.add(node);
                    //     // node.parent = currentNode;

                    //     // if (currentNode.parent == null) {

                    //     //     token = lexer.nextToken();
                    //     //     continue;
                    //     // }

                    //     // if (ADD_SUB_NODE) {
                    //     //     // ascend (out of sub into parent)
                    //     //     currentNode = currentNode.parent;
                    //     // }

                    //     // if (currentNode.value != null && currentNode.value.equalsIgnoreCase("defined")) {
                    //     //     // ascend (out of sub into parent)
                    //     //     currentNode = currentNode.parent;
                    //     // }

                    //     // if ("define_key___".equalsIgnoreCase(currentNode.type)) {

                    //     //     currentNode = currentNode.parent;
                    //     //     defineModeKey = false;
                    //     //     defineModeValue = true;

                    //     //     node = new ASTNode();

                    //     //     currentNode.children.add(node);
                    //     //     node.parent = currentNode;

                    //     //     node.value = "define_value___";
                    //     //     node.type = "define_value___";

                    //     //     // descend into key
                    //     //     currentNode = node;

                    //     // }

                    //     currentNode.children.add(expressionRootNode);
                    //     expressionRootNode = null;

                    // } else {

                        processExpressionNode(text);

                        // an expression is finished
                        if (balance == 0) {
                            currentNode.children.add(expressionRootNode);

                            // start new expression
                            expressionRootNode = null;
                            identifier = false;
                        }

                    // }

                } else if (parserMode == ParserMode.EXPRESSION) {

                    // an if-statement is finished
                    if (expressionRootNode.balance == 0) {

                        currentNode.children.add(expressionRootNode);

                        //expressionRootNode.linearAddInto(currentNode.children);
                        expressionRootNode = null;

                        // node = new ASTNode();
                        // node.value = token.getText();
                        // currentNode.children.add(node);

                        // go back to the root node
                        currentNode = currentNode.parent;

                        // parserMode = ParserMode.NORMAL;

                    } else {

                        processExpressionNode(text);

                    }

                } else {

                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(text);
                    }

                }

            }

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

                    currentNode.children.add(expressionRootNode);
                    expressionRootNode = null;

                    parserMode = ParserMode.NORMAL;

                } else if (parserMode == ParserMode.DEFINE) {

                    if (expressionRootNode != null) {
                        currentNode.children.add(expressionRootNode);
                        expressionRootNode = null;
                    }

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

                /*
                if (text.equalsIgnoreCase("if")) {

                    if (ADD_SUB_NODE) {
                        node.value = "sub";

                        currentNode.children.add(node);
                        node.parent = currentNode;

                        // descend
                        currentNode = node;
                    }

                    TreeNode treeNode = new TreeNode();
                    treeNode.value = text;

                    // connect child and parent
                    currentNode.children.add(treeNode);
                    treeNode.parent = currentNode;

                    // ascend
                    currentNode = treeNode;

                    parserMode = ParserMode.EXPRESSION;

                    // skip whitespace up to bracket
                    do {
                        token = lexer.nextToken();
                    } while (!token.getText().equalsIgnoreCase("("));

                    node = new ASTNode();
                    node.value = token.getText();

                    currentNode.parent.children.add(node);
                    node.parent = currentNode.parent;

                    //currentNode.children.add(node);

                    token = lexer.nextToken();

                    continue;
                }
                */

                if (parserMode == ParserMode.DEFINE) {

                    // if (expressionRootNode != null) {
                    //     if (!text.equalsIgnoreCase("(") && !text.equalsIgnoreCase(")")) {


                    //         System.out.println("new");

                    //         currentNode.children.add(expressionRootNode);

                    //         balance = 0;
                    //         customWeight = 0;
                    //         identifier = false;
                    //         expressionRootNode = null;
                    //     }
                    // }



                    processExpressionNode(text);

                    // perform lookahead
                    lookAheadUsed = true;

                    token = lexer.nextToken();
                    String temp = token.getText();


                    // skip whitespace
                    while (temp.equalsIgnoreCase(" ")) {
                    //if (text.equalsIgnoreCase("\s+")) {
                    //if (text.isBlank()) {
                        token = lexer.nextToken();
                        //continue;
                        temp = token.getText();
                    }

                    if (!temp.equalsIgnoreCase("(") && !temp.equalsIgnoreCase(")")) {

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

                    // if (ADD_SUB_NODE) {
                    //     if (currentNode.value.equalsIgnoreCase("defined")) {
                    //         // ascend ( out of sub into parent )
                    //         currentNode = currentNode.parent;
                    //     }
                    // }

                } else {

                    // throw new RuntimeException();
                    //System.out.println(text);

                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(text);
                    }

                    //((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;
                    //callback.execute(null);

                }

            }

            if (!lookAheadUsed) {
                token = lexer.nextToken();
            }

            lookAheadUsed = false;

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

        //System.out.println(currentToken);

        if (currentToken.equalsIgnoreCase("(")) {

            balance++;

            if (identifier) {

                // DEBUG
                //System.out.println("function call detected: " + lastIdentifier);

                functionCall = true;
            }

            customWeight += 1000;
            return;

        }
        if (currentToken.equalsIgnoreCase(")")) {

            balance--;

            customWeight -= 1000;
            return;
        }

        identifier = AbstractFileStackFrame.isIdentifier(currentToken);
        // lastIdentifier = currentToken;

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

            priorityLHS = customWeight;
            if (lhs != null) {
                AbstractFileStackFrame.getPriority(lhs);
            }
            if (rhs != null) {
            priorityRHS = AbstractFileStackFrame.getPriority(rhs);
            }

        }

        return priorityRHS - priorityLHS;

    }

}
