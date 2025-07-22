package preprocessor;

import java.util.List;

import org.stringtemplate.v4.compiler.STParser.ifstat_return;

import ast.ASTNode;

public class TreeNode extends ASTNode {

    public boolean side;

    public TreeNode lhs;

    public TreeNode rhs;

    public int customWeight = 0;

    public boolean unaryOperator;

    public boolean functionCall;

    public int balance;

    public void addChild(TreeNode node) {

        if (unaryOperator) {

            if (lhs == null) {
                lhs = node;
                rhs = node;
                node.side = true;

                children.add(node);
            } else {
                throw new RuntimeException("Error");
            }

        } else {

            if (lhs == null) {
                lhs = node;
                node.side = true;
            } else if (rhs == null) {
                rhs = node;
                node.side = false;
            } else {
                throw new RuntimeException("Error");
            }

        }

        node.parent = this;
    }

    public void reparent(TreeNode node) {
        this.parent = node.parent;

        if (unaryOperator) {

            throw new RuntimeException();

        } else {

            if (node.parent != null) {

                TreeNode parent = ((TreeNode) this.parent);

                if (parent.unaryOperator) {

                    parent.lhs = this;
                    parent.rhs = this;

                } else {

                    if (node.side == true) {
                        parent.lhs = this;
                    } else {
                        parent.rhs = this;
                    }
                }
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
        if (functionCall) {
            stringBuilder.append(" (functionCall)");
        }

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        if (unaryOperator) {
            if (lhs != null) {
                lhs.printRecursive(stringBuilder, indent + 1, true);
            }
        } else {
            // output all children
            if (lhs != null) {
                lhs.printRecursive(stringBuilder, indent + 1, true);
            }
            if (rhs != null) {
                rhs.printRecursive(stringBuilder, indent + 1, true);
            }
        }
    }

    public List<ASTNode> getChildren() {

        if ((lhs != null) && (rhs != null)) {
            return List.of(lhs, rhs);
        }

        if (lhs != null) {
            return List.of(lhs);
        }

        if (rhs != null) {
            return List.of(rhs);
        }

        return children;
    }

    public void linearAddInto(List<ASTNode> target) {
        if (functionCall) {
            target.add(this);
            if (lhs != null) {
                lhs.linearAddInto(target);
            }
            if (rhs != null) {
                rhs.linearAddInto(target);
            }
        } else {
            if (lhs != null) {
                lhs.linearAddInto(target);
            }
            target.add(this);
            if (rhs != null) {
                rhs.linearAddInto(target);
            }
        }
    }

}
