package preprocessor;

import ast.ASTNode;

public class TreeNode extends ASTNode {

    public boolean side;

    public TreeNode lhs;

    public TreeNode rhs;

    public int customWeight = 0;

    public void addChild(TreeNode node) {

        if (lhs == null) {
            lhs = node;
            node.side = true;
        } else if (rhs == null) {
            rhs = node;
            node.side = false;
        } else {
            throw new RuntimeException("Error");
        }

        node.parent = this;
    }

    public void reparent(TreeNode node) {
        this.parent = node.parent;

        if (node.parent != null) {
            if (node.side == true) {
                ((TreeNode) this.parent).lhs = this;
            } else {
                ((TreeNode) this.parent).rhs = this;
            }
        }
        addChild(node);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent) {
        printRecursive(stringBuilder, indent, true);
    }

    public void printRecursive(final StringBuilder stringBuilder, final int indent, final boolean addLineBreak) {

        // indent and operator or symbol
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("  ");
        }

        // output this node
        stringBuilder.append(value);

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // output all children
        if (lhs != null) {
            //stringBuilder.append("LHS: ");
            lhs.printRecursive(stringBuilder, indent + 1, true);
        }
        if (rhs != null) {
            //stringBuilder.append("RHS: ");
            rhs.printRecursive(stringBuilder, indent + 1, true);
        }
    }

}
