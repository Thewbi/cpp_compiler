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

    public PreprocessorLexer2 lexer;

    /**
     * This is a map that maps from a symbol's name to it's definition.
     * The defintiion is stored as a tree of ASTNodes.
     *
     * e.g. #define SQUARE(x) ((x) * (x))
     * will exist in the defineValueMap.
     * The key is: SQUARE and the value is an ASTNode which is the root
     * of the ASTNode.
     */
    //public Map<String, ASTNode> defineValueMap; // TODO teh value needs to be a struct with ASTNode as root and the amount of parameters expected!
    public Map<String, DefinedSymbolStruct> defineValueMap;
    public boolean defineMode;
    public boolean defineModeKey;
    public boolean defineModeValue;

    private ParserMode parserMode = ParserMode.NORMAL;

    private TreeNode expressionRootNode = null;
    private int customWeight = 0;
    private int balance = 0;
    private int bracketCount = 0;
    private boolean identifier = false;
    private boolean lookAheadUsed = false;

    private DefinedSymbolStruct definedSymbolStruct = new DefinedSymbolStruct();

    /**
     * The testcases are located in the folder: src\test\resources\preprocessor\
     * There are many .pp file. The file extension .pp means pre processor.
     * A file from src\test\resources\preprocessor\ is selected in main.java.
     * The preprocessed output is written into preprocessed.cpp
     *
     * This function creates ASTNodes and when a ASTNode is constructed,
     * it is placed into a callback. The callback is implemented as an
     * interface and can be injected from the outside.
     *
     * A preprocessor has two tasks:
     * - TASK 1 - using preprocessor commands (#define, ...) the preprocessor is
     *   programmed. Symbols and their meaning are defined.
     * - TASK 2 - When a symbol is detected in code, the preprocessor has to
     *   replace the symbol by it's definition.
     *
     * This implementation will set a flag defineMode to true when #define
     * is encountered and set the flag to false, when a newline is encountered.
     * This means a #define is a single line item and cannot span more than
     * a single line.
     *
     * TASK 1 - When #define is encountered, the parserMode variable is set to #define.
     * In this state, all encountered characters are converted into an expression
     * which consists of a tree of ASTNodes.
     * When a newline is encountered in #define parserMode, parserMode is replaced
     * by normal node and the current ASTNode tree is processed by the callback.
     * The callback will insert the defined-symbol and it's meaning into the
     * defineValueMap. The defineValueMap is a shared variable. It is shared between
     * the callback and the preprocessor. The callback inserts into the map and the
     * preprocessor only reads from the map.
     *
     * TASK 2 - When a previously defined symbol is encountered in normal mode, the
     * preprocessor will find that symbol in the defineValueMap because the callback
     * has inserted it. The preprocessor has the TASK 2, which means to place the
     * actual parameters (e.g. MIN(2, 9)) into the symbol's definition and then to
     * evaluate the expression's ASTNode tree into a final value. Then the preprocessor
     * needs to remove the symbol from the output stream and replace it by the evaluated
     * value.
     *
     * How is an expression ASTNode tree in parserMode DEFINE implemented?
     * If defineMode is true, first a new AstNode is created. If the newline
     * is encountered i.e. the define is processed, then the preprocessor
     * makes this node the current node if defineMode is true.
     *
     * The central function for building the tree is: processExpressionNode()
     * It is called when '(', ')' or any other normal (non-preprocessor) token
     * is encountered. This means, all these symbols go into processExpressionNode().
     * An exception is when the parser is not in DEFINE or EXPRESSION mode, then
     * the tree is not extended.
     *
     * processExpressionNode() calls into insertTokenIntoTree().
     * insertTokenIntoTree() has a good function comment. The comment explains
     * the central idea of the AST-tree generation algorithm:
     *
     * To build the tree, all token types are identified and if the token is a C/C++
     * operator, the precedence of that operator is used as a weight. The heavier
     * the node (higher precedence) the deeper the token will sink into the tree.
     * Literals have the highest weight and will sink down and act as the leafs of
     * the tree (Leaf == no children).
     *
     * To find the weight of a token, insertTokenIntoTree() calls comparePriority()
     *
     * The sinking into the tree is implemented inside: insertTokenIntoTree()
     *
     * The evaluation of a Expression AST Node with actual parameters is implemented in ???
     *
     * If a define exists: e.g. #define SQUARE(x) ((x) * (x))
     * and that defined is used: e.g. printf("Square of 4: %d\n", SQUARE(4));
     * then the formal parameter x needs to be replaced by the actual parameter 4.
     */
    @Override
    public void start() throws IOException {

        CharStream charStream = includeToCharStream();
        lexer = new PreprocessorLexer2(charStream);

        TreeNode rootNode = new TreeNode();
        rootNode.value = "root____";
        rootNode.parent = null;

        TreeNode currentNode = rootNode;

        // DEBUG
        // int line = 1;
        // System.out.println("Line: " + line);

        //
        // Comments:
        //
        // Using a lexer has the advantage that the lexer will not emit any comments
        // because the comment rules in the grammar move comments to a stream which
        // deletes token immediately and does not return them!
        //
        // The preprocessor contains no code that deals with comments!
        //

        Token token = lexer.nextToken();
        while ((token != null) && (token.getType() != Token.EOF)) {

            String text = token.getText();

            // skip space
            if (text.equalsIgnoreCase(" ")) {
                token = lexer.nextToken();
                continue;
            }

            if (!text.matches("\\s+")) {
                System.out.println("text: '" + text + "'");
            }

            // add a newline
            if (token.getType() == PreprocessorLexer2.Newline) {
                outputStringBuilder.append("\n");
            }

            TreeNode node = new TreeNode();

            if (text.equalsIgnoreCase("#define")) {

                setParserMode(ParserMode.DEFINE);

                defineMode = true; // enter define mode
                defineModeKey = true;
                defineModeValue = false;

                node = new TreeNode();
                node.value = "#define";

                // connect child and parent
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

                node = new TreeNode();

            } else if (text.equalsIgnoreCase("#undef")) {

                setParserMode(ParserMode.DEFINE);

                defineMode = true; // enter define mode
                defineModeKey = true;
                defineModeValue = false;

                node = new TreeNode();
                node.value = "#undef";

                // connect child and parent
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

                node = new TreeNode();

            } else if (text.equalsIgnoreCase("#if")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new TreeNode();
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

                node = new TreeNode();
                node.value = "#elif";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#else")) {

                setParserMode(ParserMode.PREPROCESSOR);

                node = new TreeNode();
                node.value = "#else";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#endif")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new TreeNode();
                node.value = "#endif";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifdef")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new TreeNode();
                node.value = "#ifdef";
                currentNode.children.add(node);
                node.parent = currentNode;

                // descend
                currentNode = node;

            } else if (text.equalsIgnoreCase("#ifndef")) {

                setParserMode(ParserMode.EXPRESSION);

                node = new TreeNode();
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

                //DefaultFileStackFrame fileStackFrame = new DefaultFileStackFrame();
                SimpleFileStackFrame fileStackFrame = new SimpleFileStackFrame();
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

                bracketCount++; // ( or ) processed for the current define

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

                bracketCount++; // ( or ) processed for the current define

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
                        currentNode = (TreeNode) currentNode.parent;

                    } else {

                        processExpressionNode(text);

                    }

                } else {

                    DefaultFileStackFrameCallback cb = (preprocessor.DefaultFileStackFrameCallback) callback;
                    if (cb.ifStack.isEmpty() || cb.ifStack.peek().performOutput) {
                        outputStringBuilder.append(" ").append(text);
                    }

                }
            }
            // else if (text.equalsIgnoreCase("defined")) {

            //     node = new TreeNode();
            //     node.value = "defined";
            //     currentNode.children.add(node);
            //     node.parent = currentNode;

            //     // descend
            //     currentNode = node;

            //     // this will consume the 'defined' token itself
            //     token = lexer.nextToken();

            //     // processExpressionNode(text);

            //     continue;
            // }
            else if (token.getType() == PreprocessorLexer2.Newline) {

                // reset bracket count because the define is over with the newline
                bracketCount = 0;

                // deal with completely empty lines
                // (the node is still the root node and it has no children)
                if (rootNode.children.size() == 0) {
                    // consume the space
                    token = lexer.nextToken();

                    continue;
                }

                //
                // perform action based on current ParserMode
                //

                if (parserMode == ParserMode.EXPRESSION) {

                    if (expressionRootNode != null) {
                        currentNode.children.add(expressionRootNode);
                        expressionRootNode = null;
                    }

                    setParserMode(ParserMode.NORMAL);

                } else if (parserMode == ParserMode.DEFINE) {

                    if (expressionRootNode != null) {
                        currentNode.children.add(expressionRootNode);
                        expressionRootNode = null;
                    }

                    setParserMode(ParserMode.NORMAL);
                }

                //
                // ascend to the root node
                //

                while (currentNode.parent != null) {
                    currentNode = (TreeNode) currentNode.parent;
                }

                //
                // DEBUG
                //

                System.out.println("-------------- DefinedSymbolStruct --------------");
                StringBuilder stringBuilder = new StringBuilder();
                int indent = 0;
                if (definedSymbolStruct.treeNode != null) {
                    definedSymbolStruct.treeNode.printRecursive(stringBuilder, indent);
                    System.out.println(stringBuilder.toString());
                }
                System.out.println("-------------------------------------------------");

                System.out.println("------------------ currentNode ------------------");
                stringBuilder = new StringBuilder();
                indent = 0;
                currentNode.printRecursive(stringBuilder, indent);
                System.out.println(stringBuilder.toString());
                System.out.println("-------------------------------------------------");

                System.out.println("------------------- rootNode --------------------");
                stringBuilder = new StringBuilder();
                indent = 0;
                currentNode.printRecursive(stringBuilder, indent);
                System.out.println(stringBuilder.toString());
                System.out.println("-------------------------------------------------");

                //
                // execute the current line
                //

                definedSymbolStruct.treeNode = currentNode;

                ((DefaultFileStackFrameCallback) callback).stringBuilder = outputStringBuilder;
                callback.execute(definedSymbolStruct);

                //
                // start a new root because the newline terminates the current preprocessor line
                //

                rootNode = new TreeNode();
                rootNode.value = "root____";
                rootNode.parent = null;

                currentNode = rootNode;

                defineMode = false;

                definedSymbolStruct = new DefinedSymbolStruct();

                setParserMode(ParserMode.NORMAL);

            } else {

                //
                // A text token is encountered, which has no special meaning
                // but is programming language or preprpocessor content.
                //

                if (parserMode == ParserMode.DEFINE) {

                    System.out.println("bracketCount: " + bracketCount);

                    // to identify formal parameters, this algorithm counts the amount
                    // of brackets '(' which have been opened so far!
                    // If the count is 1, this means the parser parses over the formal
                    // parameters right now!

                    // detect a define of a new symbol
                    if (bracketCount == 0) {

                        // DEBUG
                        System.out.println("Defined Preprocessor Symbol '" + text + "' found!");
                        definedSymbolStruct = new DefinedSymbolStruct();
                        definedSymbolStruct.symbolName = text;
                        definedSymbolStruct.treeNode = rootNode;

                    } else if (bracketCount == 1) {

                        // detect formal parameter

                        // DEBUG
                        System.out.println("Formal parameter " + text + " found!");

                        // the vector encodes all names of all parameters and also
                        // indirectly the order in which they appear
                        if (!text.equalsIgnoreCase(",")) {
                            definedSymbolStruct.formalParameters.add(text);
                            definedSymbolStruct.parameterMap.put(text, "");
                        }
                    }

                    processExpressionNode(text);

                    // perform lookahead
                    lookAheadUsed = true;

                    token = lexer.nextToken();
                    String temp = token.getText();

                    // skip whitespace
                    while (temp.equalsIgnoreCase(" ")) {
                        token = lexer.nextToken();
                        temp = token.getText();
                    }

                    // check if the end of the #define is encountered by checking for )
                    if (currentNode.children.size() == 0
                        && !temp.equalsIgnoreCase("(")
                        && !temp.equalsIgnoreCase(")")
                            || (token.getType() == Token.EOF)
                            || temp.equalsIgnoreCase("\n")
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

                        currentNode = (TreeNode) currentNode.parent;

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
                    //
                    // parserMode is ParserMode.NORMAL
                    //

                    // Replace defined symbols by their defined meaning!
                    text = filterByPreprocessorValues(text);

                    // output if no sourrounding if-statement exists
                    // or if the sourrounding if-statement  is enabled
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

            // enter phase 2, where the parsed line is executed
            callback.execute(definedSymbolStruct);
        }

        fileStack.pop();
    }

    /**
     * Replace defined symbols by their defined meaning!
     *
     * ```
     * #define SQUARE(x) ((x) * (x))
     *
     * int main() {
     *   printf("Square of 4: %d\n", SQUARE(4));
     *   printf("Square of 5: %d\n", SQUARE(5));
     *   return 0;
     * }
     * ```
     *
     * e.g. replace SQUARE by the definition (x) * (x)
     *
     * @param data
     * @return
     */
    private String filterByPreprocessorValues(String data) {

        // if the current symbol is not a DEFINED symbol which needs to be replaced,
        // early out
        if (!defineValueMap.containsKey(data)) {
            return data;
        }

        // replace the DEFINED symbol by it's definition
        DefinedSymbolStruct definedSymbolStruct = defineValueMap.get(data);
        TreeNode treeNode = (TreeNode) definedSymbolStruct.treeNode.children.get(0);

        // TODO
        // Before evaluating the define, retrieve all actual parameters
        // from the input.

        int parameterCount = definedSymbolStruct.formalParameters.size();
        if (parameterCount > 0) {

            // consume (
            Token t = lexer.nextToken();

            for (int i = 0; i < parameterCount; i++) {

                if (i > 0) {
                    // consume ,
                    t = lexer.nextToken();
                }

                t = lexer.nextToken();
                definedSymbolStruct.parameterMap.put(definedSymbolStruct.formalParameters.get(i), t.getText());
            }

            // consume )
            t = lexer.nextToken();
        }

        // now that the formal parameters are parsed, replace values in the tree
        treeNode = definedSymbolStruct.replaceFormalParameters();

        // evaluate the ASTNode. Formal variables are replaced by actual
        // values and the operators are applied to their operands.
        // The final result of the evaluation is assigned to the root node's
        // stringValueEval member variable
        ASTNode astNode = treeNode.children.get(0);
        TreeNode treeNode2 = (TreeNode) astNode.getChildren().get(1);
        evaluatePreprocessorTreeNode(treeNode2);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(treeNode2.stringValueEval);

        return stringBuilder.toString();
    }

    /**
     * Evaluate the ASTNode. Formal variables are replaced by actual
     * values and the operators are applied to their operands.
     * The final result of the evaluation is assigned to the root node's
     * stringValueEval member variable.
     *
     * The actual values are?
     **/
    private void evaluatePreprocessorTreeNode(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        // check if the node is a leaf (has no children in LHS and RHS)
        if ((treeNode.lhs == null) && (treeNode.rhs == null)) {

            // retrieve the symbol from the list of all #DEFINED symbols
            if (defineValueMap.containsKey(treeNode.value)) {

                DefinedSymbolStruct definedSymbolStruct2 = defineValueMap.get(treeNode.value);
                TreeNode valueTreeNode = definedSymbolStruct2.treeNode;
                treeNode.stringValueEval = valueTreeNode.value;
                if (NumberUtils.isParsable(valueTreeNode.value)) {
                    treeNode.integerValueEval = Integer.valueOf(valueTreeNode.value);
                }
            } else {
                treeNode.stringValueEval = treeNode.value;
                try {
                    treeNode.integerValueEval = Integer.parseInt(treeNode.value);
                } catch (Exception e) {

                }
            }

            return;
        }

        // node is not a leaf (it has children in LHS and/or RHS)

        // convert symbol into evaluated value by making a recursive call
        evaluatePreprocessorTreeNode(treeNode.lhs);
        evaluatePreprocessorTreeNode(treeNode.rhs);

        if (treeNode.value.equalsIgnoreCase("*")) {
            // add the evaluated value into yourself!
            treeNode.integerValueEval = treeNode.lhs.integerValueEval * treeNode.rhs.integerValueEval;
            treeNode.stringValueEval = treeNode.integerValueEval.toString();
        } else {
            throw new RuntimeException("TODO: Support operator: " + treeNode.value);
        }
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

        boolean isFuncCall = expressionRootNode != null
            ? expressionRootNode.functionCall : false;

        expressionRootNode = insertTokenIntoTree(expressionRootNode,
            currentTokenAsString,
            customWeight,
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
     *
     * The expression is represented using a binary tree.
     *
     * To build the tree, all token types are identified and if the token is a C/C++
     * operator, the precedence of that operator is used as a weight. The heavier
     * the node (higher precedence) the deeper the token will sink into the tree.
     * Literals have the highest weight and will sink down and act as the leafs of
     * the tree (Leaf == no children).
     */
    private static TreeNode insertTokenIntoTree(TreeNode node,
        String token, int customWeight, boolean functionCall) {

        if (node == null) {

            TreeNode newTreeNode = new TreeNode();
            newTreeNode.value = token;
            newTreeNode.unaryOperator = AbstractFileStackFrame.isUnaryOperator(token);
            newTreeNode.customWeight = customWeight;

            return newTreeNode;
        }

        if (comparePriority(functionCall, node.customWeight, node.value, token) < 0) {

            // System.out.println("existing node is heavier");

            //
            // existing node is heaver, this means the new node is lighter and will
            // stay on top and become the new parent
            //

            TreeNode newNode = new TreeNode();
            newNode.value = token;
            newNode.customWeight = customWeight;

            newNode.reparent(node);

            return newNode;

        } else {

            // System.out.println("existing node is lighter");

            //
            // The new node is heavier and needs to descend into the tree to find
            // it's correct location
            //

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
            priorityRHS = AbstractFileStackFrame.getOperatorPriority(rhs);

        } else {

            priorityLHS = customWeight;
            if (lhs != null) {
                priorityLHS += AbstractFileStackFrame.getOperatorPriority(lhs);
            }
            if (rhs != null) {
                priorityRHS = AbstractFileStackFrame.getOperatorPriority(rhs);
            }

        }

        return priorityRHS - priorityLHS;
    }

}




// private void evaluatePreprocessorTreeNodeAsString(TreeNode treeNode, StringBuilder stringBuilder) {

    //     if (treeNode == null) {
    //         return;
    //     }

    //     if ((treeNode.rhs == null) && (treeNode.lhs == null)) {
    //         if (defineValueMap.containsKey(treeNode.value)) {
    //             stringBuilder.append(defineValueMap.get(treeNode.value).value);
    //         } else {
    //             stringBuilder.append(treeNode.value);
    //         }
    //         return;
    //     }

    //     evaluatePreprocessorTreeNodeAsString(treeNode.lhs, stringBuilder);
    //     stringBuilder.append(treeNode.value);
    //     evaluatePreprocessorTreeNodeAsString(treeNode.rhs, stringBuilder);
    // }