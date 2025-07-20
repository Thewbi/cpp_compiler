package preprocessor;

import java.util.Map;
import java.util.Stack;

import ast.ASTNode;

public class DefaultFileStackFrameCallback implements FileStackFrameCallback {

    public ASTNode dummyASTNode;

    public Map<String, ASTNode> defineMap;

    public Map<String, ASTNode> defineKeyMap;

    public Stack<IfStackFrame> ifStack = new Stack<>();

    public StringBuilder stringBuilder;

    @Override
    public void execute(ASTNode astNode) {

        // // DEBUG
        // StringBuilder hierarchyStringBuilder = new StringBuilder();
        // int indent = 0;
        // astNode.printRecursive(hierarchyStringBuilder, indent);
        // System.out.println(hierarchyStringBuilder.toString());

        ASTNode node = null;
        if (isDefine(astNode) != null) {

            processDefine(isDefine(astNode));

        } else if ((node = isIf(astNode)) != null) {

            processIf(node);

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

            // StringBuilder stringBuilder = new StringBuilder();
            outputASTNode(astNode, stringBuilder);
            stringBuilder.append("\n");

            // DEBUG
            // System.out.println(stringBuilder.toString());

        }
    }

    private ASTNode isIf(ASTNode astNode) {
        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#if".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processIf(ASTNode astNode) {

        IfStackFrame ifStackFrame = new IfStackFrame();

        if (!ifStack.empty() && ifStack.peek().performOutput == false) {
            ifStackFrame.blocked = true;
        }

        ifStack.push(ifStackFrame);

        ifStack.peek().performOutput = false;

        // evaluate expression and enable output content for the branch
        boolean evaluationResult = evaluate(astNode.children.get(0));
        ifStackFrame.processed = evaluationResult;
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

        boolean isDefined = defineMap.containsKey(dataASTNode.value);

        IfStackFrame ifStackFrame = new IfStackFrame();

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

        boolean isDefined = defineMap.containsKey(dataASTNode.value);

        IfStackFrame ifStackFrame = new IfStackFrame();

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

        ifStack.peek().performOutput = false;

        if (ifStack.peek().processed) {
            return;
        }

        // enable output content for the branch
        ifStack.peek().performOutput = true;
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

        // enable output content for the branch
        ifStack.peek().performOutput = false;

        // if (ifStack.peek().processed) {
        // return;
        // }

        ifStack.pop();
    }

    private ASTNode isDefine(ASTNode astNode) {

        int i = 0;
        while ((i < astNode.children.size()) && astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if (i >= astNode.children.size()) {
            return null;
        }
        if ("#define".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }

        return null;
    }

    private void processDefine(ASTNode astNode) {

        // this define might be contained inside an #ifdef statement.
        // Check if the if-stack frame is disabled
        if (!ifStack.isEmpty() && !ifStack.peek().performOutput) {
            return;
        }

        // insert into define map
        ASTNode keyASTNode = astNode.children.get(0);
        ASTNode valueASTNode = null;
        if (astNode.children.size() > 1) {

            defineKeyMap.put(keyASTNode.value, keyASTNode);

            valueASTNode = astNode.children.get(1);
            defineMap.put(keyASTNode.value, valueASTNode);

            StringBuilder keyStringBuilder = new StringBuilder();
            outputASTNode(keyASTNode, keyStringBuilder);

            StringBuilder valueStringBuilder = new StringBuilder();
            outputASTNode(valueASTNode, valueStringBuilder);

            //System.out.println("processDefine(): Defining Symbol: " + keyASTNode.value + " key: "
            //        + keyStringBuilder.toString() + " value: " + valueStringBuilder.toString());

        } else {

            defineKeyMap.put(keyASTNode.value, keyASTNode);

            dummyASTNode.value = "<dummy>";
            defineMap.put(keyASTNode.value, dummyASTNode);

            StringBuilder keyStringBuilder = new StringBuilder();
            outputASTNode(keyASTNode, keyStringBuilder);

            StringBuilder valueStringBuilder = new StringBuilder();
            outputASTNode(dummyASTNode, valueStringBuilder);

            //System.out.println("processDefine(): Defining Symbol: " + keyASTNode.value + " key: "
            //        + keyStringBuilder.toString() + " value: " + valueStringBuilder.toString());

        }
    }

    private boolean evaluate(ASTNode astNode) {

        if ("||".equalsIgnoreCase(astNode.value)) {

            ASTNode lhs = astNode.children.get(0);
            boolean lhsValue = evaluate(lhs);

            ASTNode rhs = astNode.children.get(1);
            boolean rhsValue = evaluate(rhs);

            return lhsValue || rhsValue;

        } else if ("defined".equalsIgnoreCase(astNode.value)) {

            ASTNode sub = astNode.children.get(0);

            ASTNode dataASTNode = sub.children.get(1);
            return defineMap.containsKey(dataASTNode.value);

        }

        throw new RuntimeException("Not implemented yet! " + astNode.value);
    }

    private void outputASTNode(ASTNode astNode, StringBuilder stringBuilder) {

       // DEBUG
        StringBuilder debugStringBuilder = new StringBuilder();
        astNode.printRecursive(debugStringBuilder, 0);
        System.out.println(debugStringBuilder.toString());
        System.out.println("");


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

                // if the child node
                if (!defineMap.containsKey(childNode.value)) {
                    index++;
                    continue;
                }

                // 0. retrieve the key ASTNode from the map
                ASTNode key = defineKeyMap.get(childNode.value);

                // 1. retrieve the value ASTNode from the map
                ASTNode newValueASTNode = defineMap.get(childNode.value);

                if (newValueASTNode.children.size() == 0) {

                    childNode.value = newValueASTNode.value;

                } else {

                    // 2. clone it
                    ASTNode definedReplacement = newValueASTNode.deepClone();

                    // 3. Inside the clone, replace the variable with the actual parameter value

                    // find actual parameter (find the sub node that contains the actual parameter)
                    ASTNode actualParameterNewValueSubNode = astNode.children.get(index + 1);

                    // assume a single actual parameter
                    ASTNode actualParameterNewValue = actualParameterNewValueSubNode.children.get(1);

                    // find the formal parameter
                    ASTNode formalParameterSubNode = key.children.get(0);
                    String formalParameter = formalParameterSubNode.children.get(1).value;

                    // 4. output the value
                    // String newValue = actualParameterNewValue.value;
                    StringBuilder internalStringBuilder = new StringBuilder();
                    outputASTNode(actualParameterNewValue, internalStringBuilder);
                    String newValue = internalStringBuilder.toString();
                    replaceActualParameterByValue(definedReplacement, formalParameter, newValue);

                    // 5. exchange the original node with the replacement
                    childNode.children.clear();
                    childNode.children.add(definedReplacement);
                    definedReplacement.parent = childNode;

                    //
                    // Also remove the next three nodes because the contain '(' <FORMAL_PAREMTER>
                    // ')'
                    // which has been replaced
                    //

                    astNode.children.get(index + 1).purge();

                }

                index++;

            }

            // finally output replaced children
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

    private void replaceActualParameterByValue(ASTNode definedReplacement, String formalParameterIdentifier,
            String newValue) {
        if (definedReplacement.value.equalsIgnoreCase(formalParameterIdentifier)) {
            definedReplacement.value = newValue;
        }
        for (ASTNode childASTNode : definedReplacement.children) {
            replaceActualParameterByValue(childASTNode, formalParameterIdentifier, newValue);
        }
    }

}
