package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ast.ASTNode;

public class ExpressionBuilderRule {

    public static int startSymbolType;

    public static int exprType;

    public List<Integer> elements = new ArrayList<>();

    public int priority;

    public int resultType;

    public String name;

    public boolean isPrefix(Stack<ASTNode> stack, ASTNode tokenASTNode) {

        if (elements.size() == 1) {
            return false;
        }

        for (int i = 1; i < elements.size(); i++) {

            int type = elements.get(elements.size() - 1 - i);

            if (i == 1) {

                if (type != tokenASTNode.token.getType()) {
                    return false;
                }

            } else {

                if (type != stack.get(stack.size() + 1 - i).token.getType()) {
                    return false;
                }

            }

        }

        return true;
    }

}
