package tacky.runtime;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import ast.ASTNode;
import ast.ExpressionASTNode;
import ast.ExpressionType;
import tacky.ast.AssignmentASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.TACKYASTNode;
import tacky.ast.VariableDeclarationASTNode;

public class DefaultTACKYExecutor implements TACKYExecutor {

    public Stack<TACKYStackFrame> executionStack = new Stack<>();

    public void executeFunction(ASTNode rootNode, int currentIndex, FunctionDefinitionASTNode functionDefinition) {

        TACKYStackFrame tackyStackFrame = new TACKYStackFrame();
        tackyStackFrame.returnIndex = currentIndex;
        executionStack.push(tackyStackFrame);

        for (ASTNode astNode : functionDefinition.children) {

            TACKYASTNode statement = (TACKYASTNode) astNode;
            System.out.println(statement);

            switch (statement.nodeType) {

                case Program:
                    break;

                case FunctionDefinition:
                    break;

                case VariableDeclaration:
                    createVariable(tackyStackFrame, (VariableDeclarationASTNode) statement);
                    break;

                case ConstantDeclaration:
                    break;

                case Assignment:
                    assignment(tackyStackFrame, (AssignmentASTNode) statement);
                    break;

                case Printf:
                    break;

                case Return:
                    break;

                case Label:
                    break;

                case Jump:
                    break;
            }
        }

        executionStack.pop();
    }

    private void assignment(TACKYStackFrame tackyStackFrame, AssignmentASTNode assignmentASTNode) {
        System.out.println(assignmentASTNode);

        int value = evaluateExpression(tackyStackFrame, assignmentASTNode.expression);

        tackyStackFrame.variables.replace(assignmentASTNode.lhs, value);
    }

    private int evaluateExpression(TACKYStackFrame tackyStackFrame, ExpressionASTNode expression) {

        if (expression.expressionType == ExpressionType.Primary) {
            boolean isNumeric = StringUtils.isNumeric(expression.value);
            if (isNumeric) {
                return Integer.parseInt(expression.value);
            }
            return tackyStackFrame.variables.get(expression.value);
        }
        return 0;
    }

    private void createVariable(TACKYStackFrame tackyStackFrame, VariableDeclarationASTNode variableDeclaration) {
        System.out.println(variableDeclaration);

        int initialValue = (int) (Math.random() * Integer.MAX_VALUE);
        tackyStackFrame.variables.put(variableDeclaration.variableName, initialValue);
    }

}
