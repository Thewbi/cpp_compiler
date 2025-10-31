package tacky.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import ast.ASTNode;
import ast.ExpressionASTNode;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.GetAddressASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.LabelASTNode;
import tacky.ast.LoadFromAddressASTNode;
import tacky.ast.ReturnASTNode;
import tacky.ast.TACKYASTNode;
import tacky.ast.VariableDeclarationASTNode;

public class DefaultTACKYExecutor implements TACKYExecutor {

    private static final boolean DEBUG_OUTPUT_STATEMENTS = false;

    public int stackPointer = 0;

    public int memory[] = new int[256];

    public Stack<TACKYStackFrame> executionStack = new Stack<>();

    public Map<String, FunctionDefinitionASTNode> functionDefinitionMap = new HashMap<>();

    public int executeFunction(ASTNode rootNode, int currentIndex, FunctionDefinitionASTNode functionDefinition) {

        TACKYStackFrame tackyStackFrame = new TACKYStackFrame();
        tackyStackFrame.startAddress = stackPointer;
        tackyStackFrame.endAddress = stackPointer;
        tackyStackFrame.returnIndex = currentIndex;

        // add stackframe
        executionStack.push(tackyStackFrame);

        // look for labels and create entries in the label map
        int index = 0;
        for (ASTNode astNode : functionDefinition.children) {
            index++;
            TACKYASTNode statement = (TACKYASTNode) astNode;
            switch (statement.nodeType) {
                case Label:
                    createLabel(tackyStackFrame, (LabelASTNode) statement, index);
                    break;
                default:
                    // ignored
                    break;
            }
        }

        index = 0;

        int returnValue = -1;

        boolean done = false;
        while (!done) {

            TACKYASTNode statement = (TACKYASTNode) functionDefinition.children.get(index);

            // DEBUB
            if (DEBUG_OUTPUT_STATEMENTS) {
                StringBuilder stringBuilder = new StringBuilder();
                statement.printRecursive(stringBuilder, 0);
                System.out.println("\nExecuting: ");
                System.out.println(stringBuilder.toString());
            }

            switch (statement.nodeType) {

                case Program:
                    throw new RuntimeException("Program");

                case FunctionDefinition:
                    throw new RuntimeException("FunctionDefinition");

                case VariableDeclaration:
                    createVariable(tackyStackFrame, (VariableDeclarationASTNode) statement);
                    index++;
                    break;

                case ConstantDeclaration:
                    createConstant(tackyStackFrame, (ConstantDeclarationASTNode) statement);
                    index++;
                    break;

                case Assignment:
                    assignment(tackyStackFrame, (AssignmentASTNode) statement);
                    index++;
                    break;

                case Printf:
                    System.out.println(statement.value);
                    index++;
                    break;

                case Return:
                    ReturnResult returnResult = returnStatement(tackyStackFrame, (ReturnASTNode) statement);
                    done = true;
                    returnValue = returnResult.returnValue;
                    index = returnResult.returnIndex;
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

                        default:
                            throw new RuntimeException(jumpASTNode.jumpType.toString());
                    }
                    break;

                case GetAddress: {
                    GetAddressASTNode getAddressASTNode = (GetAddressASTNode) statement;

                    // retrieve address
                    String variableName = getAddressASTNode.variableName;
                    int address = tackyStackFrame.variables.get(variableName).address;

                    // store address
                    String ptrVariableName = getAddressASTNode.ptrVariableName;
                    TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables.get(ptrVariableName);
                    memory[descriptor.address / 4] = address;
                }
                    // execute next instruction
                    index++;
                    break;

                case LoadFromAddress: {
                    LoadFromAddressASTNode loadFromAddressASTNode = (LoadFromAddressASTNode) statement;

                    // retrieve address
                    String ptrVariableName = loadFromAddressASTNode.ptrVariableName;
                    int address = tackyStackFrame.variables.get(ptrVariableName).address;

                    // get the address that the pointer points to
                    int value = memory[address / 4];

                    // retrieve the value from the address
                    int derefValue = memory[value / 4];

                    // assign value
                    String variableName = loadFromAddressASTNode.variableName;
                    TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables.get(variableName);
                    memory[descriptor.address / 4] = derefValue;
                }
                    
                    // execute next instruction
                    index++;
                    break;

                case FunctionCall: {
                    FunctionDefinitionASTNode functionDefinitionASTNode = functionDefinitionMap.get(statement.value);
                    returnValue = executeFunction(statement, currentIndex + 1, functionDefinitionASTNode);
                    
                    // execute next instruction
                    index++;
                    break;
                }

                default:
                    throw new RuntimeException("default");
            }

        }

        // remove stackframe
        executionStack.pop();

        return returnValue;
    }

    private ReturnResult returnStatement(TACKYStackFrame tackyStackFrame, ReturnASTNode returnASTNode) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.returnValue = retrieveConstantValue(returnASTNode);
        returnResult.returnIndex = tackyStackFrame.returnIndex;
        return returnResult;
    }

    private int jump(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {
        String targetLabel = jumpASTNode.value;
        return tackyStackFrame.labels.get(targetLabel);
    }

    private int jumpIfZero(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {

        String variableName = jumpASTNode.variable;
        String targetLabel = jumpASTNode.value;

        TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables.get(variableName);
        Integer variableValue = memory[descriptor.address / 4];
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

        TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables.get(assignmentASTNode.lhs);
        memory[descriptor.address / 4] = value;
    }

    private int evaluateExpression(TACKYStackFrame tackyStackFrame, ExpressionASTNode expression) {

        int lhsValue = 0;
        int rhsValue = 0;

        switch (expression.expressionType) {

            case Add:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue + rhsValue;

            case Subtract:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue - rhsValue;

            case Constant:
                return retrieveConstantValue(expression);

            case Primary:
                boolean isNumeric = StringUtils.isNumeric(expression.value);
                if (isNumeric) {
                    return Integer.parseInt(expression.value);
                }

                // retrieve variable from current stackframe
                TACKYStackFrameVariableDescriptor varDesc = tackyStackFrame.variables.get(expression.value);
                return memory[varDesc.address / 4];

            case Equality:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue == rhsValue ? 1 : 0;

            case LessThen:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue < rhsValue ? 1 : 0;

            case LessThenOrEqual:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue <= rhsValue ? 1 : 0;

            case GreaterThen:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue > rhsValue ? 1 : 0;

            case GreaterThenOrEqual:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue >= rhsValue ? 1 : 0;

            default:
                throw new RuntimeException("Unknown expression type: " + expression.expressionType);

        }
    }

    private int retrieveConstantValue(ASTNode astNode) {
        ConstantDeclarationASTNode constantDeclarationASTNode = (ConstantDeclarationASTNode) astNode.children.get(0);
        ConstIntASTNode constIntASTNode = (ConstIntASTNode) constantDeclarationASTNode.getChildren().get(0);
        return Integer.parseInt(constIntASTNode.value);
    }

    private void createConstant(TACKYStackFrame tackyStackFrame, ConstantDeclarationASTNode constantDeclarationASTNode) {
        //createVariable(tackyStackFrame, variableDeclaration);

        StringBuilder stringBuilder = new StringBuilder();
        constantDeclarationASTNode.printRecursive(stringBuilder, 0, false);
        System.out.println(stringBuilder.toString());

        // String varName = constantDeclarationASTNode.value;
        // System.out.println(varName);
    }

    private void createVariable(TACKYStackFrame tackyStackFrame, VariableDeclarationASTNode variableDeclaration) {
        // System.out.println(variableDeclaration);

        // TODO: a variable should initially go into a register. It should not
        // immediately spill into memory (stack or heap)

        String varName = variableDeclaration.variableName;

        if (tackyStackFrame.variables.containsKey(varName)) {
            throw new RuntimeException("Variable \"" + varName + "\" declared already!");
        }

        // simulate random memory content
        TACKYStackFrameVariableDescriptor descriptor = new TACKYStackFrameVariableDescriptor();
        descriptor.name = varName;
        descriptor.address = stackPointer;
        // descriptor.value = (int) (Math.random() * Integer.MAX_VALUE);
        memory[descriptor.address / 4] = (int) (Math.random() * Integer.MAX_VALUE);

        tackyStackFrame.variables.put(varName, descriptor);

        stackPointer += 4; // TODO increment by sizeof(type)
        tackyStackFrame.endAddress = stackPointer;
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
