package preprocessor;

import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import ast.ASTNode;

/**
 * This class is executing preprocessor instructions.
 *
 * Once an entire line has been parsed and a newline is encountered,
 * the driver (SimpleFileStackFrame), will call this callback.
 */
public class DefaultFileStackFrameCallback implements FileStackFrameCallback {

    public TreeNode dummyASTNode;
    public Map<String, DefinedSymbolStruct> defineValueMap;
    public Map<String, ASTNode> defineKeyMap;
    public Stack<IfStackFrame> ifStack = new Stack<>();
    public StringBuilder stringBuilder;

    @Override
    public void executePragma(String pragma_instruction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executePragma'");
    }

    @Override
    public void execute(DefinedSymbolStruct definedSymbolStruct) {

        TreeNode astNode = definedSymbolStruct.treeNode;

        // DEBUG
        StringBuilder stringBuilder = new StringBuilder();
        int indent = 0;
        astNode.printRecursive(stringBuilder, indent);
        System.out.println(stringBuilder.toString());

        ASTNode node = null;
        if ((node = isDefine(astNode)) != null) {
            processDefine(definedSymbolStruct);
        } else if ((node = isUndef(astNode)) != null) {
            processUndef(definedSymbolStruct);
        } else if ((node = isPreprocessorIf(astNode)) != null) {
            processPreprocessorIf(node);
        } else if ((node = isIfdef(astNode)) != null) {
            processIfdef(node);
        } else if ((node = isIfndef(astNode)) != null) {
            processIfndef(node);
        } else if ((node = isElif(astNode)) != null) {
            processElif(node);
        } else if ((node = isElse(astNode)) != null) {
            processElse(node);
        } else if ((node = isEndif(astNode)) != null) {
            processEndif(node);
        } else if (ifStack.isEmpty() || ifStack.peek().performOutput) {
            outputASTNode(astNode, stringBuilder);
            stringBuilder.append("\n");
        } else {
            throw new RuntimeException("" + astNode);
        }
    }

    private ASTNode isPreprocessorIf(ASTNode astNode) {
        // skip blank nodes until the first non-blank is found
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }

        // first non-blank node has to be #if
        if ("#if".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processPreprocessorIf(ASTNode astNode) {

        // create new if element and make the current if-element it's parent
        IfStackFrame ifStackFrame = new IfStackFrame();
        if (!ifStack.empty()) {
            // set parent into new if
            ifStackFrame.parent = ifStack.peek();
        }

        // if the parent if statement should not perform output,
        // initially also block the new if statement
        // Later evaluation might unblock the new if statement.
        //
        // Question: Why is it possible to unblock an if statement
        // if the parent is disabled???
        if (!ifStack.empty() && ifStack.peek().performOutput == false) {
            // block the new if
            ifStackFrame.blocked = true;
        }

        // push the new if
        ifStack.push(ifStackFrame);

        // evaluate the if's expression
        ASTNode child0 = astNode.children.get(0);
        boolean evaluationResult = evaluate(child0);

        // store evaluation result
        ifStackFrame.processed = evaluationResult;

        // enable output for the if statement content
        // if the evaluationResult is true
        ifStackFrame.performOutput = false;
        if (evaluationResult) {
            ifStackFrame.performOutput = true;
        }
    }

    private ASTNode isIfdef(ASTNode astNode) {
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#ifdef".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processIfdef(ASTNode astNode) {

        ASTNode dataASTNode = astNode.children.get(0);

        boolean isDefined = defineValueMap.containsKey(dataASTNode.value);

        IfStackFrame ifStackFrame = new IfStackFrame();
        if (!ifStack.empty()) {
            ifStackFrame.parent = ifStack.peek();
        }

        if (!ifStack.empty() && ifStack.peek().performOutput == false) {
            ifStackFrame.blocked = true;
        }

        ifStack.push(ifStackFrame);

        ifStack.peek().performOutput = isDefined;

        ifStack.peek().processed = isDefined;
    }

    private ASTNode isIfndef(ASTNode astNode) {
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#ifndef".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processIfndef(ASTNode astNode) {

        ASTNode dataASTNode = astNode.children.get(0);

        boolean isDefined = defineValueMap.containsKey(dataASTNode.value);

        IfStackFrame ifStackFrame = new IfStackFrame();
        if (!ifStack.empty()) {
            ifStackFrame.parent = ifStack.peek();
        }

        if (!ifStack.empty() && ifStack.peek().performOutput == false) {
            ifStackFrame.blocked = true;
        }

        ifStack.push(ifStackFrame);

        ifStack.peek().performOutput = !isDefined;

        ifStack.peek().processed = !isDefined;
    }

    private ASTNode isElif(ASTNode astNode) {
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#elif".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processElif(ASTNode astNode) {

        ifStack.peek().performOutput = false;

        if (ifStack.peek().processed) {
            return;
        }

        // evaluate expression and enable output content for the branch
        boolean evaluationResult = evaluate(astNode.children.get(0));
        ifStack.peek().processed = evaluationResult;
        if (evaluationResult) {
            ifStack.peek().performOutput = true;
        }
    }

    private ASTNode isElse(ASTNode astNode) {
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#else".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processElse(ASTNode astNode) {

        IfStackFrame currenIfStackFrame = ifStack.peek();

        currenIfStackFrame.performOutput = false;

        // if one of the branches has been taken already, do not use the else branch
        if (currenIfStackFrame.processed) {
            return;
        }

        boolean performOutput = true;

        if (currenIfStackFrame.parent != null) {
            performOutput = currenIfStackFrame.parent.performOutput;
        }

        // if (ifStack.size() > 1) {
        //     outputEnabled = ifStack.elementAt(ifStack.size()-1).performOutput;
        // }

        // check if output is enabled in any of the lower stack if-stack entries
        //boolean outputEnabled = !ifStack.stream().filter(frame -> (frame.performOutput == false)).findFirst().isPresent();

        // enable output content for the branch
        ifStack.peek().performOutput = performOutput;
    }

    private ASTNode isEndif(ASTNode astNode) {
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#endif".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processEndif(ASTNode astNode) {
        ifStack.pop();
    }

    private ASTNode isDefine(ASTNode astNode) {

        // find first non-blank child node
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }

        // check if the first non-blank child is #define
        if ("#define".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }

        return null;
    }

    //private void processDefine(ASTNode astNode) {
    private void processDefine(DefinedSymbolStruct definedSymbolStruct) {

        // this define might be contained inside an #ifdef statement.
        // Check if the if-stack frame is disabled.
        // If so, do not perform any operations and do not define the symbol!
        if (!ifStack.isEmpty() && !ifStack.peek().performOutput) {
            return;
        }

        TreeNode astNode = (TreeNode) definedSymbolStruct.treeNode.children.get(0);

        // insert into define map
        ASTNode keyASTNode = astNode.children.get(0);
        ASTNode valueASTNode = null;
        if (astNode.children.size() > 1) {

            defineKeyMap.put(keyASTNode.value, keyASTNode);

            valueASTNode = astNode.children.get(1);

            defineValueMap.put(keyASTNode.value, definedSymbolStruct);

            // output preprocessed data into the destination file
            StringBuilder keyStringBuilder = new StringBuilder();
            outputASTNode(keyASTNode, keyStringBuilder);

            // output preprocessed data into the destination file
            StringBuilder valueStringBuilder = new StringBuilder();
            outputASTNode(valueASTNode, valueStringBuilder);



        } else {

            defineKeyMap.put(keyASTNode.value, keyASTNode);

            dummyASTNode.value = "<dummy>";

            definedSymbolStruct.treeNode = dummyASTNode;
            defineValueMap.put(keyASTNode.value, definedSymbolStruct);

            StringBuilder keyStringBuilder = new StringBuilder();
            outputASTNode(keyASTNode, keyStringBuilder);

            StringBuilder valueStringBuilder = new StringBuilder();
            outputASTNode(dummyASTNode, valueStringBuilder);
        }
    }

    private ASTNode isUndef(ASTNode astNode) {

        // find first non-blank child node
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }

        // check if the first non-blank child is #define
        if ("#undef".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }

        return null;
    }

    /**
     * The purpose of #undef is to remove a previously defined symbol from
     * the symbol store. Therefore perform a remove using the symbol on the
     * defineKeyMap
     */
    private void processUndef(DefinedSymbolStruct definedSymbolStruct) {

        // this define might be contained inside an #ifdef statement.
        // Check if the if-stack frame is disabled.
        // If so, do not perform any operations and do not define the symbol!
        if (!ifStack.isEmpty() && !ifStack.peek().performOutput) {
            return;
        }

        TreeNode astNode = (TreeNode) definedSymbolStruct.treeNode.children.get(0);

        // the purpose of #undef is to remove a previously defined symbol from
        // the symbol store. Therefore perform a remove using the symbol on the
        // defineKeyMap

        // remove from define map
        ASTNode keyASTNode = astNode.children.get(0);
        if (defineKeyMap.containsKey(keyASTNode.value)) {
            defineKeyMap.remove(keyASTNode.value);
        }
        if (defineValueMap.containsKey(keyASTNode.value)) {
            defineValueMap.remove(keyASTNode.value);
        }
    }

    private boolean evaluate(ASTNode astNode) {

        if ("!".equalsIgnoreCase(astNode.value)) {

            boolean lhsValue = false;

            if (astNode instanceof TreeNode) {
                TreeNode treeNode = (TreeNode) astNode;
                lhsValue = evaluate(treeNode.lhs);
            }

            return !lhsValue;

        } else if (("||".equalsIgnoreCase(astNode.value)) || ("&&".equalsIgnoreCase(astNode.value))) {

            boolean lhsValue = false;
            boolean rhsValue = false;

            if (astNode instanceof TreeNode) {

                TreeNode treeNode = (TreeNode) astNode;

                lhsValue = evaluate(treeNode.lhs);
                rhsValue = evaluate(treeNode.rhs);

            } else {

                ASTNode lhs = astNode.children.get(0);
                lhsValue = evaluate(lhs);

                ASTNode rhs = astNode.children.get(1);
                rhsValue = evaluate(rhs);

            }

            if (("||".equalsIgnoreCase(astNode.value))) {
                return lhsValue || rhsValue;
            } else if (("&&".equalsIgnoreCase(astNode.value))) {
                return lhsValue && rhsValue;
            }

        } else if ("defined".equalsIgnoreCase(astNode.value)) {

            if (astNode instanceof TreeNode) {

                TreeNode treeNode = (TreeNode) astNode;

                // the defined-operator evaluates to true if the symbol
                // is contained in the definedMap, in other words, if it is defined
                if (treeNode.lhs != null) {
                    return defineValueMap.containsKey(treeNode.lhs.value);
                }
                if (treeNode.rhs != null) {
                    return defineValueMap.containsKey(treeNode.rhs.value);
                }

                for (ASTNode child : treeNode.children) {
                    if (defineValueMap.containsKey(child.value)) {
                        return true;
                    }
                }

                return false;
            } else {

                ASTNode sub = astNode.children.get(0);
                ASTNode dataASTNode = sub.children.get(1);
                return defineValueMap.containsKey(dataASTNode.value);

            }

        } else if (">=".equalsIgnoreCase(astNode.value)) {

            if (astNode instanceof TreeNode) {

                TreeNode treeNode = (TreeNode) astNode;

                double lhsDouble = 0.0d;
                double rhsDouble = 0.0d;

                if (treeNode.lhs != null) {
                    String key = treeNode.lhs.value;
                    if (StringUtils.isNumeric(key)) {
                        rhsDouble = Double.parseDouble(key);
                    } else {
                        if (!defineValueMap.containsKey(key)) {
                            return false;
                        }
                        DefinedSymbolStruct definedSymbolStruct = defineValueMap.get(key);
                        //lhsDouble = Double.parseDouble(definedSymbolStruct.treeNode.value);
                        lhsDouble = Double.parseDouble(definedSymbolStruct.symbolName);
                    }
                }
                if (treeNode.rhs != null) {
                    String key = treeNode.rhs.value;
                    if (StringUtils.isNumeric(key)) {
                        rhsDouble = Double.parseDouble(key);
                    } else {
                        if (!defineValueMap.containsKey(key)) {
                            return false;
                        }
                        DefinedSymbolStruct definedSymbolStruct = defineValueMap.get(key);
                        lhsDouble = Double.parseDouble(definedSymbolStruct.treeNode.value);
                    }
                }

                return lhsDouble >= rhsDouble;

            }

        }

        throw new RuntimeException("Not implemented yet! " + astNode.value);
    }

    private void outputASTNode(ASTNode astNode, StringBuilder stringBuilder) {

        try {

            // when inside a if-branch which is skipped (= blocked) because the
            // expression did evaluate to false, then do not output the line
            if (!ifStack.empty() && ifStack.peek().blocked) {
                return;
            }

            if (astNode.children.size() == 0) {

                // add the parents value
                stringBuilder.append(astNode.value);

                return;
            }

            // go over each child node and replace defined symbols by the defined values
            int index = 0;
            for (ASTNode childNode : astNode.children) {

                // if the child node is not a symbol go to next child
                if (!defineValueMap.containsKey(childNode.value)) {
                    index++;
                    continue;
                }

                // 0. retrieve the key ASTNode from the map
                ASTNode key = defineKeyMap.get(childNode.value);

                // 1. retrieve the value ASTNode from the map

                DefinedSymbolStruct definedSymbolStruct = defineValueMap.get(childNode.value);

                if (definedSymbolStruct.treeNode.children.size() == 0) {

                    childNode.value = definedSymbolStruct.treeNode.value;

                } else {

                    // 2. clone it
                    ASTNode definedReplacement = definedSymbolStruct.treeNode.deepClone();

                    // 3. Inside the clone, replace the variable with the actual parameter value

                    // find actual parameter (find the sub node that contains the actual parameter)
                    ASTNode actualParameterNewValueSubNode = astNode.children.get(index + 1);

                    // assume a single actual parameter
                    ASTNode actualParameterNewValue = actualParameterNewValueSubNode.children.get(1);

                    // find the formal parameter
                    ASTNode formalParameterSubNode = key.children.get(0);
                    String formalParameter = formalParameterSubNode.children.get(1).value;

                    // 4. output the value
                    StringBuilder internalStringBuilder = new StringBuilder();
                    outputASTNode(actualParameterNewValue, internalStringBuilder);
                    String newValue = internalStringBuilder.toString();
                    replaceActualParameterByValue(definedReplacement, formalParameter, newValue);

                    // 5. exchange the original node with the replacement
                    childNode.children.clear();
                    childNode.children.add(definedReplacement);
                    definedReplacement.parent = childNode;

                    //
                    // Also remove the next three nodes because they contain '(' <FORMAL_PARAMETER>
                    // ')' which has been replaced
                    //

                    astNode.children.get(index + 1).purge();
                }

                index++;
            }

            // finally output children
            for (ASTNode childNode : astNode.children) {

                if (childNode.children.size() == 0) {
                    String val = childNode.value;
                    if (val != null) {
                        stringBuilder.append(val).append(" ");
                    }
                } else {
                    outputASTNode(childNode, stringBuilder);
                }

            }

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private void replaceActualParameterByValue(ASTNode definedReplacement,
        String formalParameterIdentifier, String newValue)
    {
        if (definedReplacement.value.equalsIgnoreCase(formalParameterIdentifier)) {
            definedReplacement.value = newValue;
        }
        for (ASTNode childASTNode : definedReplacement.children) {
            replaceActualParameterByValue(childASTNode, formalParameterIdentifier, newValue);
        }
    }

}

// System.out.println("processDefine(): Defining Symbol: " + keyASTNode.value +
            // " key: "
            // + keyStringBuilder.toString() + " value: " + valueStringBuilder.toString());
