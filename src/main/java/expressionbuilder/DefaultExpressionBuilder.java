package expressionbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

import com.cpp.grammar.CPP14Lexer;

import ast.ASTNode;

public class DefaultExpressionBuilder implements ExpressionBuilder {

    private static final boolean PUT_BRACKETS_INTO_THEIR_OWN_NODE = true;

    public List<ExpressionBuilderRule> rules = new ArrayList<>();

    public Stack<ASTNode> stack = new Stack<>();

    @Override
    public boolean addToken(Token token, Token lookAheadToken) {

        // DEBUG
        //System.out.println(token + " Type: " + vocabulary.getSymbolicName(token.getType()));
        System.out.println(token);

        // // DEBUG
        // if (token.getText().equalsIgnoreCase("*")) {
        //     System.out.println("test");
        // }

        boolean readNextToken = false;

        Optional<Set<ExpressionBuilderRule>> reduce_rule_set = CHECK_ACTIVATED_RULES_USING_STACK_ONLY();
        Optional<Set<ExpressionBuilderRule>> shift_rule_set = CHECK_ACTIVATED_RULES_USING_STACK_AND_CURR_TOKEN(token,
                lookAheadToken);

        if (reduce_rule_set.isPresent() && shift_rule_set.isPresent()) {

            // System.out.println("Two or more Rules activated!");
            // throw new RuntimeException("Not implemented yet!");

            // select highest priority rule
            ExpressionBuilderRule reduceRule = findHighestPriorityRule(reduce_rule_set.get());
            ExpressionBuilderRule shiftRule = findHighestPriorityRule(shift_rule_set.get());

            // DEBUG
            System.out.println((reduceRule != null) ? ("REDUCE_RULE: " + reduceRule.name + " (Prio: " + reduceRule.priority +")") : "");
            System.out.println((shiftRule != null) ? ("SHIFT_RULE: " + shiftRule.name + " (Prio: " + shiftRule.priority +")") : "");

            if (shiftRule.priority <= reduceRule.priority) {

                System.out.println("SHIFT");

                System.out.println(
                        ">> Choose SHIFT: [PUSH_CURRENT_TOKEN] place current token onto stack + [GET_NEXT_TOKEN]");

                // [PUSH_CURRENT_TOKEN]
                ASTNode astNode = new ASTNode();
                astNode.token = token;
                astNode.value = token.getText();
                stack.push(astNode);

                // [GET_NEXT_TOKEN]
                readNextToken = true;

            } else {

                System.out.println("REDUCE");

                // [REDUCE]
                ASTNode resultASTNode = reduceRule(reduceRule);

                // [PUSH_RESULT]
                stack.push(resultASTNode);

                // DO NOT PERFORM [GET_NEXT_TOKEN]
                readNextToken = false;

            }

        } else if (reduce_rule_set.isEmpty() && shift_rule_set.isEmpty()) {

            System.out.println("No Rules are active!");

            if ((token.getType() == CPP14Lexer.EOF) && (stack.peek().token.getType() == CPP14Lexer.EOF))  {
                throw new RuntimeException("EOF detected a second time but start token has not been reduced yet!");
            }

            System.out
                    .println(">> Choose SHIFT: [PUSH_CURRENT_TOKEN] place current token onto stack + [GET_NEXT_TOKEN]");

            // [PUSH_CURRENT_TOKEN]
            ASTNode astNode = new ASTNode();
            astNode.token = token;
            astNode.value = token.getText();
            stack.push(astNode);

            // [GET_NEXT_TOKEN]
            readNextToken = true;

        } else if (reduce_rule_set.isPresent()) {

            // DEBUG
            System.out.println(">> Choose REDUCE: Reduce Rules activated!");

            // sort by priority
            var set = reduce_rule_set.get();
            ExpressionBuilderRule selectedRule = findHighestPriorityRule(set);

            // DEBUG
            System.out.println(">> Choose REDUCE with rule: " + selectedRule.name);

            // // DEBUG
            // if (selectedRule.name.equalsIgnoreCase("rule_identifier_to_exp")) {
            //     System.out.println("test");
            // }

            // [REDUCE]
            ASTNode resultASTNode = reduceRule(selectedRule);

            // [PUSH_RESULT]
            stack.push(resultASTNode);

            // DO NOT PERFORM [GET_NEXT_TOKEN]
            readNextToken = false;

        } else if (shift_rule_set.isPresent()) {

            System.out
                    .println(">> Choose SHIFT: [PUSH_CURRENT_TOKEN] place current token onto stack + [GET_NEXT_TOKEN]");

            // [PUSH_CURRENT_TOKEN]
            PUSH_CURRENT_TOKEN(token);

            // [GET_NEXT_TOKEN]
            readNextToken = true;

        }

        return readNextToken;
    }

    private ExpressionBuilderRule findHighestPriorityRule(Set<ExpressionBuilderRule> set) {
        ExpressionBuilderRule[] rules = set.toArray(ExpressionBuilderRule[]::new);
        Arrays.sort(rules, new Comparator<ExpressionBuilderRule>() {
            @Override
            public int compare(ExpressionBuilderRule lhs, ExpressionBuilderRule rhs) {
                return lhs.priority - rhs.priority;
            }
        });

        // select highest priority rule
        ExpressionBuilderRule selectedRule = rules[0];
        return selectedRule;
    }

    private ASTNode reduceRule(ExpressionBuilderRule rule) {

        ASTNode newASTNode = new ASTNode();
        newASTNode.token = new CommonToken(rule.resultType);
        newASTNode.value = rule.name;

        // // DEBUG
        // if (rule.elements.size() == 3) {
        // System.out.println("test");
        // }
        // System.out.println(rule.name);
        // if (rule.name.equalsIgnoreCase("rule_4")) {
        // System.out.println("test");
        // }

        for (int index = 0; index < rule.elements.size(); index++) {

            int elementIndex = rule.elements.size() - 1 - index;

            Integer ruleElement = rule.elements.get(elementIndex);

            int stackIndex = stack.size() - 1 - index;
            int stackTokenType = stack.get(stackIndex).token.getType();

            if (ruleElement.intValue() != stackTokenType) {
                throw new RuntimeException();
            }

        }

        boolean in_reverse_order = false;
        if (in_reverse_order) {
            // add children in reverse order
            for (int i = 0; i < rule.elements.size(); i++) {
                newASTNode.children.add(stack.pop());
            }
        } else {
            ASTNode tempParent = null;

            // consume children in human readable order
            for (int i = rule.elements.size(); i > 0; i--) {

                int stackIndex = stack.size() - i;
                ASTNode stackASTNode = stack.get(stackIndex);

                if (PUT_BRACKETS_INTO_THEIR_OWN_NODE) {

                    // detect brackets and ignore them instead of inserting them into the parent
                    // Instead add a new hierachy and insert a single "bracket" node
                    if (stackASTNode.value.equalsIgnoreCase("(")) {
                        tempParent = new ASTNode();
                        tempParent.value = "()";
                        continue;
                    }
                    if (stackASTNode.value.equalsIgnoreCase(")")) {
                        continue;
                    }

                    if (tempParent == null) {
                        newASTNode.children.add(stackASTNode);
                    } else {
                        tempParent.children.add(stackASTNode);
                    }
                    
                } else {

                    // inserting them into the parent as is
                    newASTNode.children.add(stack.get(stack.size() - i));

                }
            }
            if (tempParent != null) {
                newASTNode.children.add(tempParent);
            }
            for (int i = 0; i < rule.elements.size(); i++) {
                stack.pop();
            }
        }

        return newASTNode;
    }

    private void PUSH_CURRENT_TOKEN(Token token) {

        ASTNode astNode = new ASTNode();
        astNode.token = token;
        astNode.value = token.getText();
        stack.push(astNode);
    }

    private Optional<Set<ExpressionBuilderRule>> CHECK_ACTIVATED_RULES_USING_STACK_AND_CURR_TOKEN(Token token,
            Token lookAheadToken) {

        ASTNode tokenASTNode = new ASTNode();
        tokenASTNode.token = token;

        // ASTNode lookAheadTokenASTNode = new ASTNode();
        // lookAheadTokenASTNode.token = lookAheadToken;
        // stack.push(tokenASTNode);
        // Optional<Set<ExpressionBuilderRule>> set =
        // CHECK_ACTIVATED_RULES_USING_STACK_ONLY();
        // stack.pop();

        Set<ExpressionBuilderRule> set = new HashSet<>();

        for (ExpressionBuilderRule rule : rules) {

            // // DEBUG
            // System.out.println(rule.name);

            // // DEBUG
            // if (rule.name.equalsIgnoreCase("rule_pointer_type_cast")) {
            //     System.out.println("test");
            // }

            if (rule.isPrefix(stack, tokenASTNode)) {
                set.add(rule);
            }
        }

        if (set.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(set);
    }

    private Optional<Set<ExpressionBuilderRule>> CHECK_ACTIVATED_RULES_USING_STACK_ONLY() {

        if (stack.empty()) {
            return Optional.empty();
        }

        Set<ExpressionBuilderRule> set = new HashSet<>();
        set.addAll(rules);

        int index = 0;
        for (@SuppressWarnings("unused") ASTNode astNode : stack) {

            List<ExpressionBuilderRule> removeList = new ArrayList<>();
            for (ExpressionBuilderRule rule : set) {

                if (index >= rule.elements.size()) {
                    continue;
                }

                Integer ruleElement = rule.elements.get(rule.elements.size() - 1 - index);

                if (ruleElement.intValue() != stack.get(stack.size() - 1 - index).token.getType()) {
                    removeList.add(rule);
                }

            }

            set.removeAll(removeList);

            index++;
        }

        // remove all rules that have not been fully checked because there are not
        // enough elements on the stack
        List<ExpressionBuilderRule> removeList = new ArrayList<>();
        for (ExpressionBuilderRule rule : set) {
            if (index < rule.elements.size()) {
                removeList.add(rule);
            }
        }
        set.removeAll(removeList);

        if (set.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(set);
    }

    public Stack<ASTNode> getStack() {
        return stack;
    }
    
}
