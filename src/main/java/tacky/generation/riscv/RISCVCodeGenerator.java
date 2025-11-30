package tacky.generation.riscv;

import ast.ASTNode;
import ast.ExpressionASTNode;
import ast.JumpStatementASTNode;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.LabelASTNode;
import tacky.ast.PrintfASTNode;
import tacky.ast.ReturnASTNode;
import tacky.generation.Generator;
import tacky.runtime.TACKYStackFrame;

public class RISCVCodeGenerator implements Generator {

    public StringBuilder stringBuilder = new StringBuilder();

    public int stackPointer;

    public RISCVStackFrame stackFrame;

    public String indent = "        ";

    @Override
    public void start() {

        //
        // DATA SEGMENT
        //

        // stringBuilder.append(indent).append(".data").append("\n").append("\n");

        //
        // CODE SEGMENT
        //

        // stringBuilder.append("\n").append(indent).append(".text").append("\n").append("\n");

        // start symbol
        stringBuilder.append("main:").append("\n");
        stringBuilder.append("_start:").append("\n");

    }

    @Override
    public void end() {

        // add definition of puts function

        // puts:
        stringBuilder.append("puts:").append("\n");
        // li a7, 92 ; ecall for puts
        stringBuilder.append(indent).append("li      a7, 92   # ecall for puts").append("\n");
        // ecall
        stringBuilder.append(indent).append("ecall").append("\n");
        // jr ra
        stringBuilder.append(indent).append("jr      ra").append("\n");

    }

    /*
     * @Override
     * public int executeFunction(TACKYStackFrame tackyStackFrame, ASTNode rootNode,
     * int currentIndex,
     * FunctionDefinitionASTNode functionDefinition) {
     * 
     * //
     * // Build StackFrame for this function call
     * //
     * 
     * RISCVStackFrame stackFrame = new RISCVStackFrame();
     * 
     * for (ASTNode astNode : functionDefinition.children) {
     * astNode.addToStackFrame(stackFrame);
     * }
     * 
     * // advance stack pointer
     * 
     * for (ASTNode astNode : functionDefinition.children) {
     * execute(astNode);
     * }
     * 
     * return 0;
     * 
     * }
     */

    @Override
    public int executeFunction(ASTNode functionAstNode) {

        //
        // Build StackFrame for this function call
        //

        stackFrame = new RISCVStackFrame();

        // 1. for each local variable declaration used in this function, reserve space
        // on the stack
        for (ASTNode astNode : functionAstNode.children) {
            astNode.addToStackFrame(stackFrame);
        }

        //
        // advance stack pointer
        //

        int stackSizeUsed = stackFrame.computeAddresses(stackPointer);

        stringBuilder.append(indent).append("addi    sp, sp, ").append((-1) * stackSizeUsed).append("\n");

        stackPointer -= stackSizeUsed;

        // generate code for all children
        for (ASTNode astNode : functionAstNode.children) {
            execute(astNode);
        }

        // TODO:

        return 0;
    }

    private void execute(ASTNode astNode) {

        // DEBUG print node
        boolean printAST = true;
        // boolean printAST = false;
        if (printAST) {
            StringBuilder tempStringBuilder = new StringBuilder();
            astNode.printRecursive(tempStringBuilder, 0, true);
            System.out.print(tempStringBuilder.toString());
        }

        switch (astNode.astNodeType) {

            case ROOT:
                break;

            case FUNCTION_DECLARATION:
                break;

            case FUNCTION_CALL:
                processFunctionCall(astNode);
                break;

            case INIT_DECLARATION:
                // e.g. length = Var("length")
                // No output takes place. The only change is that the stack pointer is
                // decremented to makes room for the local variable on teh stack.
                break;

            case ITERATION_STATEMENT:
                break;

            case JUMP_STATEMENT:
                processJump((JumpASTNode) astNode);
                break;

            case SIMPLE_DECLARATION:
                break;

            case EXPRESSION:
                break;

            case ASSIGNMENT:
                processAssignment((AssignmentASTNode) astNode);
                break;

            case LABEL:
                processLabel((LabelASTNode) astNode);
                break;

            case RETURN:
                processReturn((ReturnASTNode) astNode);
                break;

            case UNKNOWN:
            default:
                System.out.println("Unknown type: " + astNode.astNodeType);
                // throw new RuntimeException("Unknown type: " + astNode.astNodeType);
                return;
        }

        // if (astNode instanceof ReturnASTNode) {
        // ReturnASTNode returnASTNode = (ReturnASTNode) astNode;
        // // generateReturnStatement(returnASTNode);
        // } else {
        // throw new RuntimeException("Unknown!");
        // }
    }

    private void processReturn(ReturnASTNode astNode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processReturn'");
    }

    private void processJump(JumpASTNode astNode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processJump'");
    }

    private void processLabel(LabelASTNode astNode) {
        stringBuilder.append(astNode.value).append(":").append("\n");
    }

    private void processAssignment(AssignmentASTNode assignmentASTNode) {

        String variableName = assignmentASTNode.lhs;

        // TODO: figure out if the value is a constant or not
        int value = 22;

        ExpressionASTNode expressionASTNode = assignmentASTNode.expression;
        switch (expressionASTNode.expressionType) {

            case Constant: {
                ConstantDeclarationASTNode constantDeclarationASTNode = (ConstantDeclarationASTNode) expressionASTNode.children
                        .get(0);
                ConstIntASTNode constIntASTNode = (ConstIntASTNode) constantDeclarationASTNode.children.get(0);
                value = Integer.parseInt(constIntASTNode.value);
            }
                break;

            case LessThen:
                System.out.println("test");
                value = 77;
                throw new RuntimeException("Implement this!");
                // break;

            default:
                // throw new RuntimeException();
                System.out.println("Default: " + expressionASTNode.expressionType);
                break;
        }

        RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(variableName);

        int address = riscvStackEntry.address;
        int offset = address - stackPointer;

        String tempRegister = "t0";
        stringBuilder.append(indent).append("# variable '").append(variableName).append("'").append("\n");
        stringBuilder.append(indent).append("li      ").append(tempRegister).append(", ").append(value).append("\n");
        stringBuilder.append(indent).append("sw      ").append(tempRegister).append(", ").append(offset).append("(sp)")
                .append("\n");
    }

    private void processFunctionCall(ASTNode astNode) {
        if (astNode instanceof PrintfASTNode) {
            processPrintfFunctionCall((PrintfASTNode) astNode);
        } else {
            throw new RuntimeException();
        }
    }

    private void processPrintfFunctionCall(PrintfASTNode astNode) {

        // System.out.println(astNode);

        // a7 describes the service that is called by the ecall
        // a0 is a parameter register. a0 contains the address of the data

        //
        // DATA SEGMENT
        //

        // stringBuilder.append(indent).append(".data").append("\n").append("\n");

        // define data
        // .string "abc"
        String labelName = ".LABEL_0";
        stringBuilder.append(labelName).append(": ").append("\n");
        stringBuilder.append(indent).append(".string ").append(astNode.value).append("\n");

        // //
        // // CODE SEGMENT
        // //

        // //
        // stringBuilder.append("\n").append(indent).append(".text").append("\n").append("\n");

        // // start symbol
        // stringBuilder.append("main:").append("\n");
        // stringBuilder.append("_start:").append("\n");

        // load address of data into a5

        // lui a5, %hi(.LC3)
        stringBuilder.append(indent).append("lui     a5, ").append("%hi(").append(labelName).append(")").append("\n");
        // addi a0, a5, %lo(.LC3)
        stringBuilder.append(indent).append("addi    a0, a5, ").append("%lo(").append(labelName).append(")")
                .append("\n");
        // call puts
        stringBuilder.append(indent).append("call    puts").append("\n");

        stringBuilder.append(indent).append("ret").append("\n");

    }

}
