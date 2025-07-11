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

        // DEBUG
        StringBuilder stringBuilder = new StringBuilder();
        int indent = 0;
        astNode.printRecursive(stringBuilder, indent);
        System.out.println(stringBuilder.toString());

        // add defines into the define map
        if (isDefine(astNode)) {
            processDefine(astNode);
        }

        if (isIf(astNode)) {
            processIf(astNode);
        }

        if (isElif(astNode)) {
            processElif(astNode);
        }

        if (isElse(astNode)) {
            processElse(astNode);
        }
    }

    private boolean isIf(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        return "#if".equalsIgnoreCase(astNode.children.get(i).value);
    }

    private void processIf(ASTNode astNode) {
        IfStackFrame ifStackFrame = new IfStackFrame();
        ifStack.push(ifStackFrame);

        boolean evaluationResult = evaluate(astNode.children.get(1));

        ifStackFrame.processed = evaluationResult;

        if (evaluationResult) {
            // TODO:output the content of the if branch!
            System.out.println("test");
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
        return false;
    }

    private boolean isElif(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        return "#elif".equalsIgnoreCase(astNode.children.get(i).value);
    }

    private void processElif(ASTNode astNode) {
        if (ifStack.peek().processed) {
            return;
        }

        // TODO: evaluate expression and output content of the branch
    }

    private boolean isElse(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        return "#else".equalsIgnoreCase(astNode.children.get(i).value);
    }

    private void processElse(ASTNode astNode) {
        if (ifStack.peek().processed) {
            return;
        }

        // TODO: output the content of the if branch!
        System.out.println("test");
    }

    private boolean isDefine(ASTNode astNode) {
        int i = 0;
        while (astNode.children.get(i).value.isBlank()) {
            i++;
        }
        return "#define".equalsIgnoreCase(astNode.children.get(i).value);
    }

    private void processDefine(ASTNode astNode) {

        // System.out.println("define");
        ASTNode defineASTNode = astNode.children.get(0);

        // insert into define map
        ASTNode keyASTNode = defineASTNode.children.get(0);
        ASTNode valueASTNode = null;
        if (defineASTNode.children.size() > 1) {
            valueASTNode = defineASTNode.children.get(1);
            defineMap.put(keyASTNode.value, valueASTNode);
        } else {
            defineMap.put(keyASTNode.value, dummyASTNode);
        }
    }

}
