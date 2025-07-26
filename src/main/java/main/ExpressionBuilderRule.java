package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.cpp.grammar.CPP14Lexer;

import ast.ASTNode;

public class ExpressionBuilderRule {

    public static int startSymbolType;

    public static int exprType;

    public static int cStyleCast;

    public static int exprCommaListType;

    public List<Integer> elements = new ArrayList<>();

    public int priority;

    public int resultType;

    public String name;

    public boolean isPrefix(Stack<ASTNode> stack, ASTNode tokenASTNode) {

        // System.out.println(name);

        // DEBUG
        if ((stack.size() == 1) && (tokenASTNode.token.getType() == CPP14Lexer.EOF) && name.equalsIgnoreCase("rule_start_symbol")) {
            System.out.println("test");
        }

        // start looking with the second element from the right.
        // any rule that has a single element only is excluded per definition
        if (elements.size() == 1) {
            return false;
        }
        if (stack.size() == 0) {
            return false;
        }

        int startIndex = elements.size() - 2;

        if (startIndex == 0) {
            return false;
        }

        boolean result = true;

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

}
