package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ast.ASTNode;

public class ExpressionBuilderRule {

    public static int startSymbolType;

    public static int exprType;

    public static int cStyleCast;

    public List<Integer> elements = new ArrayList<>();

    public int priority;

    public int resultType;

    public String name;

    public boolean isPrefix(Stack<ASTNode> stack, ASTNode tokenASTNode) {

        // System.out.println(name);

        // start looking with the second element from the right.
        // any rule that has a single element only is excluded per definition
        if (elements.size() == 1) {
            return false;
        }
        if (stack.size() == 0) {
            return false;
        }

        int startIndex = elements.size() - 2;

        boolean result = true;

        if (startIndex == 0) {
            return false;
        }


        // //if (startIndex >= stack.size() + 1) {
        // if ((elements.size()-1) > stack.size() + 1) {
        //     return false;
        // }

        // outer loop
        while (startIndex > 0) {



            result = true;
            int stackIndex = stack.size() - 1;

            ASTNode preToken = tokenASTNode;

            // search prefix in rule element starting from the startIndex back to zero
            for (int i = startIndex; i >= 0; i--) {

                // no elements on stack left to fit the current rule!
                // !the rule does not match
                if (stackIndex < 0) {
                    result = false;
                    break;
                }

                int ruleElementType = elements.get(i);

                if (preToken != null) {

                    if (ruleElementType != preToken.token.getType()) {
                        result = false;
                        break;
                    }

                    preToken = null;

                } else {



                    //int stackElementType = stack.get(stack.size() + 1 - i).token.getType();
                    int stackElementType = stack.get(stackIndex--).token.getType();
                    if (ruleElementType != stackElementType) {
                        result = false;
                        break;
                    }
                }

            }

            // the entire rule has matched correctly!
            if (result == true) {
                return true;
            }

            startIndex--;

        }

        return result;

    }

    // public boolean isPrefix(Stack<ASTNode> stack, ASTNode tokenASTNode) {

    //     if (elements.size() == 1) {
    //         return false;
    //     }

    //     for (int i = 1; i < elements.size(); i++) {

    //         int type = elements.get(elements.size() - 1 - i);

    //         if (i == 1) {

    //             if (type != tokenASTNode.token.getType()) {
    //                 return false;
    //             }

    //         } else {

    //             if (type != stack.get(stack.size() + 1 - i).token.getType()) {
    //                 return false;
    //             }

    //         }

    //     }

    //     return true;
    // }

}
