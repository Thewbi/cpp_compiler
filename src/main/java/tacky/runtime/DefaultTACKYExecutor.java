package tacky.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import ast.ASTNode;
import ast.ExpressionASTNode;
import grammar.ActualParameter;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.DataType;
import tacky.ast.FunctionCallASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.GetAddressASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.LabelASTNode;
import tacky.ast.LoadFromAddressASTNode;
import tacky.ast.ReturnASTNode;
import tacky.ast.StoreToAddressASTNode;
import tacky.ast.TACKYASTNode;
import tacky.ast.ValueASTNode;
import tacky.ast.VariableDeclarationASTNode;
import tacky.generation.tacky.TackyDataType;
import tacky.ast.SizeofASTNode;
import types.FormalParameter;

/**
 * TODO: currently unclear if the TACKY executor should handle scopes or not!
 * Maybe checking scopes is the job of the frontend!
 * In assembly, no scopes exist!
 */
public class DefaultTACKYExecutor implements TACKYExecutor {

    // private static final boolean DEBUG_OUTPUT_STATEMENTS = true;
    private static final boolean DEBUG_OUTPUT_STATEMENTS = false;

    public int stackPointer = 0;

    public int memory[] = new int[10000];

    public Stack<TACKYStackFrame> executionStack = new Stack<>();

    public Map<String, FunctionDefinitionASTNode> functionDefinitionMap = new HashMap<>();

    public int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode, int currentIndex,
            FunctionDefinitionASTNode functionDefinition) {

        // // DEBUG
        // System.out.println("Executing function: '" + functionDefinition.value + "'");

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

        // execute all statements within the function body
        boolean done = functionDefinition.children.size() <= 0;
        while (!done) {

            TACKYASTNode statement = (TACKYASTNode) functionDefinition.children.get(index);

            // DEBUG
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
                    executePrintfBuildInFunction(tackyStackFrame, statement);
                    index++;
                    break;

                case Exit:
                    executeExitBuildInFunction(tackyStackFrame, statement);
                    done = true;
                    returnValue = 0;
                    index++;
                    break;

                case Return:
                    ReturnResult returnResult = returnStatement(tackyStackFrame, (ReturnASTNode) statement);
                    done = true;
                    returnValue = returnResult.returnValue;
                    index = returnResult.returnIndex;
                    break;

                case Label:
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
                            index = jumpIfNotZero(tackyStackFrame, jumpASTNode, index);
                            break;

                        case JumpIfEqual:
                            index = jumpIfEqual(tackyStackFrame, jumpASTNode, index);
                            break;

                        case JumpIfNotEqual:
                            index = jumpIfNotEqual(tackyStackFrame, jumpASTNode, index);
                            break;

                        case JumpIfGreaterThanOrEqual:
                            index = jumpIfGreaterThanOrEqual(tackyStackFrame, jumpASTNode, index);
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
                    TACKYStackFrameVariableDescriptor ptr = tackyStackFrame.variables.get(ptrVariableName);
                    int address = ptr.address;

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

                case StoreToAddress: {
                    StoreToAddressASTNode storeToAddressASTNode = (StoreToAddressASTNode) statement;

                    // assign value
                    String variableName = storeToAddressASTNode.variableName;
                    TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables.get(variableName);
                    int varValue = memory[descriptor.address / 4];

                    // retrieve address
                    String ptrVariableName = storeToAddressASTNode.ptrVariableName;
                    TACKYStackFrameVariableDescriptor ptrDescriptor = tackyStackFrame.variables.get(ptrVariableName);

                    if (ptrDescriptor == null) {
                        throw new RuntimeException("Variable \"" + ptrVariableName + "\" is undefined!");
                    }
                    int address = ptrDescriptor.address;
                    int ptrTargetAddressValue = memory[address / 4];

                    memory[ptrTargetAddressValue / 4] = varValue;
                }

                    // execute next instruction
                    index++;
                    break;

                case Sizeof: {
                    SizeofASTNode sizeof = (SizeofASTNode) statement;

                    // find data type
                    String type = sizeof.sizeOfType;
                    int varValue = TackyDataType.sizeOf(type);

                    // store value into target variable

                    // retrieve the target variable
                    String targetVariableName = sizeof.targetVariableName;
                    TACKYStackFrameVariableDescriptor varDescriptor = tackyStackFrame.variables.get(targetVariableName);

                    // retrieve and use address
                    int address = varDescriptor.address;
                    memory[address / 4] = varValue;
                }

                    // execute next instruction
                    index++;
                    break;

                case FunctionCall: {

                    FunctionCallASTNode functionCallASTNode = (FunctionCallASTNode) statement;

                    // retrieve the function definition
                    FunctionDefinitionASTNode functionDefinitionASTNode = functionDefinitionMap.get(statement.value);

                    TACKYStackFrame newTackyStackFrame = new TACKYStackFrame();

                    // insert the parameters into the stack frame
                    int i = 0;
                    for (FormalParameter formalParameter : functionDefinitionASTNode.formalParameters) {

                        ActualParameter actualParameter = functionCallASTNode.actualParameters.get(i);

                        int value = 0;
                        if (actualParameter.isConstant) {

                            switch (actualParameter.tackyDataType) {

                                case INT_32:
                                    value = actualParameter.intValue;
                                    break;

                                default:
                                    throw new RuntimeException();
                            }

                        } else if (actualParameter.isVariable) {
                            // retrieve variable from current stackframe
                            TACKYStackFrameVariableDescriptor varDesc = tackyStackFrame.variables
                                    .get(actualParameter.name);
                            value = memory[varDesc.address / 4];
                        } else {
                            throw new RuntimeException("Not implemented yet!");
                        }

                        insertVariableIntoStackFrame(newTackyStackFrame, formalParameter.getName(),
                                value);

                        i++;
                    }

                    // retrieve the definition and execute it

                    returnValue = executeFunction(newTackyStackFrame, statement, currentIndex + 1,
                            functionDefinitionASTNode);

                    // FunctionCallASTNode functionCallASTNode = (FunctionCallASTNode) statement;
                    String returnVariableName = functionCallASTNode.returnVariable;

                    TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables.get(returnVariableName);
                    memory[descriptor.address / 4] = returnValue;

                    // execute next instruction
                    index++;
                    break;
                }

                default:
                    throw new RuntimeException("Unknown node type: " + statement.nodeType);
            }

        }

        // remove stackframe
        executionStack.pop();

        return returnValue;
    }

    /**
     * To ease development, a built in printf() is provided.
     *
     * @param tackyStackFrame
     * @param statement
     */
    private void executePrintfBuildInFunction(TACKYStackFrame tackyStackFrame, TACKYASTNode statement) {

        // retrieve the format string
        String outputString = StringUtils.unwrap(statement.value, '"');

        // sibling nodes to the format string carry the data to replace the placeholders with.
        // Replace all placeholders.
        for (ASTNode childASTNode : statement.children) {

            ExpressionASTNode expressionASTNode = (ExpressionASTNode) childASTNode;

            switch (expressionASTNode.expressionType) {

                case StringLiteral:
                    outputString = outputString.replaceFirst("%.",
                            StringUtils.unwrap(childASTNode.value, '"'));
                    break;

                case IntegerLiteral:
                    outputString = outputString.replaceFirst("%.",
                            StringUtils.unwrap(childASTNode.value, '"'));
                    break;

                case Identifier:
                    TACKYStackFrameVariableDescriptor descriptor = tackyStackFrame.variables
                            .get(expressionASTNode.value);
                    int identifierVal = memory[descriptor.address / 4];
                    outputString = outputString.replaceFirst("%.", "" + identifierVal);
                    break;

                default:
                    throw new RuntimeException("PRINTF Unknown Expression-type: " + expressionASTNode.expressionType);
            }
        }

        // Escape characters

        // replace tab with four spaces
        outputString = outputString.replaceAll("\\\\t", "    ");

        // newline
        String[] newLineSplit = outputString.split("\\\\n", -1);

        int counter = 1;
        for (String line : newLineSplit) {

            if (counter < newLineSplit.length) {
                System.out.println(line);
            } else {
                System.out.print(line);
            }

            counter++;

            // if (counter < newLineSplit.length) {
            //     System.out.print(line);
            //     System.out.print("\n");
            // } else {
            //     // last split element
            //     if ((line == null) || (line.length() == 0)) {
            //         ;
            //     } else {
            //         System.out.print("\n");
            //     }
            // }
            // counter++;
        }
    }

    private void executeExitBuildInFunction(TACKYStackFrame tackyStackFrame, TACKYASTNode statement) {
        // nop
    }

    private ReturnResult returnStatement(TACKYStackFrame tackyStackFrame, ReturnASTNode returnASTNode) {

        ReturnResult returnResult = new ReturnResult();

        ASTNode astNode = returnASTNode.getChildren().get(0);

        if (astNode instanceof ConstantDeclarationASTNode) {

            returnResult.returnValue = retrieveConstantValue(
                    (ConstantDeclarationASTNode) returnASTNode.getChildren().get(0));

        } else if (astNode instanceof ValueASTNode) {

            // remove Var(" prefix and ") suffix
            String data = astNode.value;
            // data = data.substring(5, data.length() - 2);

            TACKYStackFrameVariableDescriptor varDesc = tackyStackFrame.variables.get(data);
            returnResult.returnValue = memory[varDesc.address / 4];
        }
        returnResult.returnIndex = tackyStackFrame.returnIndex;
        return returnResult;
    }

    private int jump(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {
        String targetLabel = jumpASTNode.value;
        if (!tackyStackFrame.labels.containsKey(targetLabel)) {
            throw new RuntimeException("TargetLabel \"" + targetLabel + "\" does not exist!");
        }
        return tackyStackFrame.labels.get(targetLabel);
    }

    private int jumpIfZero(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {

        ASTNode astNode = jumpASTNode.getChildren().get(0);
        int value = retrieveValueFromASTNode(tackyStackFrame, astNode);
        if (value == 0) {
            String targetLabel = jumpASTNode.value;
            return tackyStackFrame.labels.get(targetLabel);
        }
        return index + 1;
    }

    private int jumpIfNotZero(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {
        ASTNode astNode = jumpASTNode.getChildren().get(0);
        int value = retrieveValueFromASTNode(tackyStackFrame, astNode);
        if (value != 0) {
            String targetLabel = jumpASTNode.value;
            return tackyStackFrame.labels.get(targetLabel);
        }
        return index + 1;
    }

    private int jumpIfEqual(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {

        ASTNode astNodeLHS = jumpASTNode.getChildren().get(0);
        ASTNode astNodeRHS = jumpASTNode.getChildren().get(1);

        int valueLHS = retrieveValueFromASTNode(tackyStackFrame, astNodeLHS);
        int valueRHS = retrieveValueFromASTNode(tackyStackFrame, astNodeRHS);

        String targetLabel = jumpASTNode.value;

        if (valueLHS == valueRHS) {
            return tackyStackFrame.labels.get(targetLabel);
        }

        return index + 1;
    }

    private int jumpIfNotEqual(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {

        ASTNode astNodeLHS = jumpASTNode.getChildren().get(0);
        ASTNode astNodeRHS = jumpASTNode.getChildren().get(1);

        int valueLHS = retrieveValueFromASTNode(tackyStackFrame, astNodeLHS);
        int valueRHS = retrieveValueFromASTNode(tackyStackFrame, astNodeRHS);

        String targetLabel = jumpASTNode.value;

        if (valueLHS != valueRHS) {
            return tackyStackFrame.labels.get(targetLabel);
        }

        return index + 1;
    }

    private int jumpIfGreaterThanOrEqual(TACKYStackFrame tackyStackFrame, JumpASTNode jumpASTNode, int index) {

        ASTNode astNodeLHS = jumpASTNode.getChildren().get(0);
        ASTNode astNodeRHS = jumpASTNode.getChildren().get(1);

        int valueLHS = retrieveValueFromASTNode(tackyStackFrame, astNodeLHS);
        int valueRHS = retrieveValueFromASTNode(tackyStackFrame, astNodeRHS);

        String targetLabel = jumpASTNode.value;

        if (valueLHS >= valueRHS) {
            return tackyStackFrame.labels.get(targetLabel);
        }

        return index + 1;
    }

    private int retrieveValueFromASTNode(TACKYStackFrame tackyStackFrame, ASTNode astNode) {

        int value = 0;

        if (astNode instanceof ConstantDeclarationASTNode) {

            value = retrieveConstantValue((ConstantDeclarationASTNode) astNode);

        } else if (astNode instanceof ValueASTNode) {

            if (!tackyStackFrame.variables.containsKey(astNode.value)) {
                throw new RuntimeException("Variable \"" + astNode.value + "\" is not defined in stack frame!");
            }

            TACKYStackFrameVariableDescriptor varDesc = tackyStackFrame.variables.get(astNode.value);
            value = memory[varDesc.address / 4];

        } else if (astNode instanceof ExpressionASTNode) {

            value = evaluateExpression(tackyStackFrame, (ExpressionASTNode) astNode);

        }

        return value;
    }

    private void assignment(TACKYStackFrame tackyStackFrame, AssignmentASTNode assignmentASTNode) {
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

            case Mul:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue * rhsValue;

            case Div:
                lhsValue = evaluateExpression(tackyStackFrame, expression.lhs);
                rhsValue = evaluateExpression(tackyStackFrame, expression.rhs);
                return lhsValue / rhsValue;

            case Constant:
                return retrieveConstantValue((ConstantDeclarationASTNode) expression.getChildren().get(0));

            case Primary:
                return evaluateExpressionValue(tackyStackFrame, expression.value);

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

            case Identifier:
                return evaluateExpressionValue(tackyStackFrame, expression.value);

            case IntegerLiteral:
                return evaluateExpressionValue(tackyStackFrame, expression.value);

            default:
                throw new RuntimeException("Unknown expression type: " + expression.expressionType);

        }
    }

    private int evaluateExpressionValue(TACKYStackFrame tackyStackFrame, String expressionVal) {

        // CHECK
        if (expressionVal == null) {
            throw new RuntimeException("Parameter 'expressionVal' is null!");
        }

        boolean isNumeric = StringUtils.isNumeric(expressionVal);
        if (isNumeric) {
            return Integer.parseInt(expressionVal);
        }
        // retrieve variable from current stackframe
        TACKYStackFrameVariableDescriptor varDesc = tackyStackFrame.variables.get(expressionVal);
        if (varDesc == null) {
            throw new RuntimeException("'" + expressionVal + "' is not defined!");
        }
        return memory[varDesc.address / 4];
    }

    private int retrieveConstantValue(ConstantDeclarationASTNode constantDeclarationASTNode) {

        ASTNode astNode = constantDeclarationASTNode.getChildren().get(0);



        ConstIntASTNode constIntASTNode = (ConstIntASTNode) astNode;
        return Integer.parseInt(constIntASTNode.value);
    }

    private void createConstant(TACKYStackFrame tackyStackFrame,
            ConstantDeclarationASTNode constantDeclarationASTNode) {

        StringBuilder stringBuilder = new StringBuilder();
        constantDeclarationASTNode.printRecursive(stringBuilder, 0, false);
    }

    private void createVariable(TACKYStackFrame tackyStackFrame, VariableDeclarationASTNode variableDeclaration) {
        // TODO: a variable should initially go into a register. It should not
        // immediately spill into memory (stack or heap)

        String varName = variableDeclaration.variableName;

        if (variableDeclaration.getChildren().size() > 0) {
            DataType dataType = (DataType) variableDeclaration.getChildren().get(0);
            if (dataType.isArray) {

                for (int i = 0; i < dataType.arraySize; i++) {

                    String tempVarName = "";
                    if (i > 0) {
                        tempVarName = varName + "_" + i;
                    } else {
                        tempVarName = varName;
                    }

                    insertVariableIntoStackFrame(tackyStackFrame, tempVarName,
                            (int) (Math.random() * Integer.MAX_VALUE));
                }
            }
        } else {
            insertVariableIntoStackFrame(tackyStackFrame, varName, (int) (Math.random() * Integer.MAX_VALUE));
        }
    }

    private void insertVariableIntoStackFrame(TACKYStackFrame tackyStackFrame, String varName, int value) {

        // TODO: should TACKY executor handle scopes or are scopes part of the frontend
        // only?
        //
        // In Assembly, no scopes exist! Variables will remain defined
        // even across for-loop iterations! This message will be output for each
        // local variable inside the loop and this is expected!
        if (tackyStackFrame.variables.containsKey(varName)) {
            // throw new RuntimeException("Variable \"" + varName + "\" declared already!");

            // TODO
            // System.out.println("Variable \"" + varName + "\" declared already!");
        }

        TACKYStackFrameVariableDescriptor descriptor = new TACKYStackFrameVariableDescriptor();
        descriptor.name = varName;
        descriptor.address = stackPointer;
        memory[descriptor.address / 4] = value;

        tackyStackFrame.variables.put(varName, descriptor);

        stackPointer += 4; // TODO increment by sizeof(type)
        tackyStackFrame.endAddress = stackPointer;
    }

    private void createLabel(TACKYStackFrame tackyStackFrame, LabelASTNode labelASTNode, int index) {
        String labelName = labelASTNode.value;
        if (tackyStackFrame.labels.containsKey(labelName)) {

            // TODO
            // throw new RuntimeException("Label \"" + labelName + "\" declared already!");
        }
        // map label to line
        tackyStackFrame.labels.put(labelName, index);
    }

}
