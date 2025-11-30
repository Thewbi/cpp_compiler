package ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import tacky.generation.riscv.RISCVStackFrame;

public class ASTNode {

    public ASTNode parent;

    public List<ASTNode> children = new ArrayList<>();

    public String value;

    public String type;

    public ParseTree ctx;

    public Token token;

    public ASTNodeType astNodeType = ASTNodeType.UNKNOWN;

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

        // debug
        //if (value.equalsIgnoreCase("||")) {
            // System.out.println("test");
        //}

        if (addLineBreak) {
            stringBuilder.append("\n");
        }

        // output all children
        for (ASTNode child : children) {
            child.printRecursive(stringBuilder, indent + 1, true);
        }
    }

    public ASTNode deepClone() {

        ASTNode clone = new ASTNode();
        clone.parent = parent;
        clone.value = value;
        clone.type = type;
        clone.ctx = ctx;

        if (!children.isEmpty()) {

            for (ASTNode childNode : children) {

                ASTNode childNodeClone = childNode.deepClone();
                childNodeClone.parent = clone;
                clone.children.add(childNodeClone);
            }
        }

        return clone;
    }

    public void purge() {
        children.clear();
        parent = null;
        value = null;
        type = null;
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    public void addToStackFrame(RISCVStackFrame stackFrame) {
        ;
    }

}
