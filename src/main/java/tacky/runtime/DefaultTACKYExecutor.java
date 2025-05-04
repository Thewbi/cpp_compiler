package tacky.runtime;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import ast.ASTNode;
import ast.ExpressionASTNode;
import tacky.ast.AssignmentASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.LabelASTNode;
import tacky.ast.TACKYASTNode;
import tacky.ast.VariableDeclarationASTNode;

public class DefaultTACKYExecutor implements TACKYExecutor {

    public Stack<TACKYStackFrame> executionStack = new Stack<>();

    public void executeFunction(ASTNode rootNode, int currentIndex, FunctionDefinitionASTNode functionDefinition) {

        TACKYStackFrame tackyStackFrame = new TACKYStackFrame();
        tackyStackFrame.returnIndex = currentIndex;
        executionStack.push(tackyStackFrame);

        int index = 0;
        for (ASTNode astNode : functionDefinition.children) {

            index++;

            TACKYASTNode statement = (TACKYASTNode) astNode;
            switch (statement.nodeType) {
                case Label:
                    createLabel(tackyStackFrame, (LabelASTNode) statement, index);
                    break;
            }

        }

        index = 0;

        boolean done = false;
        while (!done) {

            TACKYASTNode statement = (TACKYASTNode) functionDefinition.children.get(index);
            //

            switch (statement.nodeType) {

                case Program:
                    throw new RuntimeException("Program");
                // break;

                case FunctionDefinition:
                    throw new RuntimeException("FunctionDefinition");
                // break;

                case VariableDeclaration:
                    createVariable(tackyStackFrame, (VariableDeclarationASTNode) statement);
                    index++;
                    break;

                case ConstantDeclaration:
                    throw new RuntimeException("ConstantDeclaration");
                // break;

                case Assignment:
                    assignment(tackyStackFrame, (AssignmentASTNode) statement);
                    index++;
                    break;

                case Printf:
                    System.out.println(statement.value);
                    index++;
                    break;

                case Return:
                    index = returnStatement(tackyStackFrame);
                    if (executionStack.size() == 1) {
                        System.out.println("Application is done!");
                        return;
                    }
                    executionStack.pop();
                    break;

                case Label:
                    // createLabel(tackyStackFrame, (LabelASTNode) statement);
                    index++;
                    break;

                case Jump:
                    JumpASTNode jumpASTNode = (JumpASTNode) statement;
                    switch (jumpASTNode.jumpType) {

                        case Jump:
                            index = jump(tackyStackFrame, jumpASTNode, index);
                            break;

                        case JumpIfZero:
                            index = jumpIfZero(tackyStackFrame, jumpASTNode, index);
                            break;

                        case JumpIfNotZero:
                            break;

                        default:
                            throw new RuntimeException(jumpASTNode.jumpType.toString());
                    }
                    break;

                default:
                    throw new RuntimeException("default");
            }

        }

        executionStack.pop();
    }

    private int returnStatement(TACKYStackFrame tackyStackFrame) {
        return tackyStackFrame.returnIndex;
    }

    private int jump(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {
        String targetLabel = jumpASTNode.value;
        return tackyStackFrame.labels.get(targetLabel);
    }

    private int jumpIfZero(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {

        String variableName = jumpASTNode.variable;
        String targetLabel = jumpASTNode.value;

        Integer variableValue = tackyStackFrame.variables.get(variableName);
        if (variableValue == 0) {
            return tackyStackFrame.labels.get(targetLabel);
        }

        return index + 1;
    }

    private void assignment(TACKYStackFrame tackyStackFrame, AssignmentASTNode assignmentASTNode) {
        // System.out.println(assignmentASTNode);

        // // DEBUG
        // StringBuilder stringBuilder = new StringBuilder();
        // assignmentASTNode.printRecursive(stringBuilder, 0, false);
        // System.out.println(stringBuilder.toString());

        int value = evaluateExpression(tackyStackFrame, assignmentASTNode.expression);

        tackyStackFrame.variables.replace(assignmentASTNode.lhs, value);
    }

    private int evaluateExpression(TACKYStackFrame tackyStackFrame, ExpressionASTNode expression) {

        int lhsValue = 0;
        int rhsValue = 0;

        switch (expression.expressionType) {

            case Add:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue + rhsValue;

            case Primary:
                boolean isNumeric = StringUtils.isNumeric(expression.value);
                if (isNumeric) {
                    return Integer.parseInt(expression.value);
                }
                return tackyStackFrame.variables.get(expression.value);

            case LessThen:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue < rhsValue ? 1 : 0;

            default:
                throw new RuntimeException("null");

        }
    }

    private void createVariable(TACKYStackFrame tackyStackFrame, VariableDeclarationASTNode variableDeclaration) {
        // System.out.println(variableDeclaration);

        String varName = variableDeclaration.variableName;

        if (tackyStackFrame.variables.containsKey(varName)) {
            throw new RuntimeException("Variable \"" + varName + "\" declared already!");
        }

        // simulate random memory content
        int initialValue = (int) (Math.random() * Integer.MAX_VALUE);
        tackyStackFrame.variables.put(varName, initialValue);
    }

    private void createLabel(TACKYStackFrame tackyStackFrame, LabelASTNode labelASTNode, int index) {

        String labelName = labelASTNode.value;

        if (tackyStackFrame.labels.containsKey(labelName)) {
            throw new RuntimeException("Label \"" + labelName + "\" declared already!");
        }

        // map label to line
        tackyStackFrame.labels.put(labelName, index);

        // System.out.println("Label: " + labelName + " --> " + index);
    }

}
