package preprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import ast.ASTNode;

public class DefinedSymbolStruct {

    public String symbolName;
    public Vector<String> formalParameters = new Vector<>();
    public Map<String, String> parameterMap = new HashMap<>();
    public TreeNode treeNode;

    public TreeNode replaceFormalParameters() {

        TreeNode result = treeNode.deepClone();

        replaceValueInNode(result);

        return result;
    }

    private void replaceValueInNode(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        System.out.println("Value: " + treeNode.value);

        if (parameterMap.containsKey(treeNode.value)) {
            treeNode.value = parameterMap.get(treeNode.value);
        }

        for (ASTNode child : treeNode.children) {
            replaceValueInNode((TreeNode) child);
        }

        replaceValueInNode(treeNode.lhs);
        replaceValueInNode(treeNode.rhs);
    }

}
