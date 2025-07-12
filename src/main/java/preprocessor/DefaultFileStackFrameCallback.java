package preprocessor;

import java.util.Map;
import java.util.Stack;

import ast.ASTNode;

public class DefaultFileStackFrameCallback implements FileStackFrameCallback {

    public ASTNode dummyASTNode;

    public Map<String, ASTNode> defineMap;

    public Stack<IfStackFrame> ifStack = new Stack<>();

    @Override
    public void execute(ASTNode astNode) {

        // // DEBUG
        // StringBuilder hierarchyStringBuilder = new StringBuilder();
        // int indent = 0;
        // astNode.printRecursive(hierarchyStringBuilder, indent);
        // System.out.println(hierarchyStringBuilder.toString());

        ASTNode node = null;
        // add defines into the define map
        if (isDefine(astNode) != null) {
            processDefine(isDefine(astNode));
        } else if ((node = isIf(astNode)) != null) {
            processIf(node);
        } else if ((node = isElif(astNode)) != null) {
            processElif(node);
        } else if ((node = isElse(astNode)) != null) {
            processElse(node);
        } else if ((node = isEndif(astNode)) != null) {
            processEndif(node);
        } else if (ifStack.isEmpty() || ifStack.peek().performOutput) {

            // StringBuilder stringBuilder = new StringBuilder();
            // outputASTNode(astNode, stringBuilder);

            // System.out.println(stringBuilder);
            // DEBUG
            StringBuilder stringBuilder = new StringBuilder();
            outputASTNode(astNode, stringBuilder);
            System.out.println(stringBuilder.toString());

        }
    }

    private ASTNode isIf(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
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

    private ASTNode isElif(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
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
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if ("#else".equalsIgnoreCase(astNode.children.get(i).value)) {
            // ifStack.peek().performOutput = false;
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
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if ("#endif".equalsIgnoreCase(astNode.children.get(i).value)) {
            // ifStack.peek().performOutput = false;
            return astNode.children.get(i);
        }
        return null;
    }

    private void processEndif(ASTNode astNode) {

        // enable output content for the branch
        ifStack.peek().performOutput = false;

        // if (ifStack.peek().processed) {
        //     return;
        // }

        ifStack.pop();
    }

    private ASTNode isDefine(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        if ("#define".equalsIgnoreCase(astNode.children.get(i).value)) {
            return astNode.children.get(i);
        }
        return null;
    }

    private void processDefine(ASTNode astNode) {

        // ASTNode defineASTNode = astNode.children.get(0);

        // insert into define map
        ASTNode keyASTNode = astNode.children.get(0);
        ASTNode valueASTNode = null;
        if (astNode.children.size() > 1) {
            valueASTNode = astNode.children.get(1);
            defineMap.put(keyASTNode.value, valueASTNode);
        } else {
            defineMap.put(keyASTNode.value, dummyASTNode);
        }
    }

    private boolean evaluate(ASTNode astNode) {
        if ("||".equalsIgnoreCase(astNode.value)) {
            boolean lhsValue = evaluate(astNode.children.get(0));
            boolean rhsValue = evaluate(astNode.children.get(1));
            return lhsValue || rhsValue;
        } else if ("defined".equalsIgnoreCase(astNode.value)) {
            ASTNode dataASTNode = astNode.children.get(1);
            return defineMap.containsKey(dataASTNode.value);
        }
        throw new RuntimeException("Not implemented yet! " + astNode.value);
        // return false;
    }

    private void outputASTNode(ASTNode astNode, StringBuilder stringBuilder) {

        if (ifStack.peek().blocked) {
            return;
        }

        for (ASTNode childNode : astNode.children) {

            if (childNode.children.size() == 0) {
                stringBuilder.append(childNode.value).append(" ");
            } else {
                outputASTNode(childNode, stringBuilder);
            }

        }

    }

}
