package tacky.generation.riscv;

import ast.ASTNode;
import ast.ASTNodeType;
import ast.ExpressionASTNode;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.ExitASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.LabelASTNode;
import tacky.ast.PrintfASTNode;
import tacky.ast.ReturnASTNode;
import tacky.ast.ValueASTNode;
import tacky.generation.Generator;

public class RISCVCodeGenerator implements Generator {

    public StringBuilder stringBuilder = new StringBuilder();

    public int stackPointer;

    public RISCVStackFrame stackFrame;

    public String indent = "        ";

    String printLabelName = ".LABEL_0";

    @Override
    public void start() {

        // DATA SEGMENT

        // stringBuilder.append(indent).append(".data").append("\n").append("\n");

        // define data to print inside printf
        
        stringBuilder.append(printLabelName).append(": ").append("\n");
        stringBuilder.append(indent).append(".string ").append("\"test_string_test\\n\"").append("\n");

        // CODE SEGMENT

        // stringBuilder.append("\n").append(indent).append(".text").append("\n").append("\n");

        // start symbol
        stringBuilder.append("main:").append("\n");
        stringBuilder.append("_start:").append("\n");

    }

    @Override
    public void end() {

        // add definition of "exit" function

        // puts:
        stringBuilder.append("exit:").append("\n");
        // li a7, 92 ; ecall for puts
        stringBuilder.append(indent).append("li      a7, 93   # ecall for exit").append("\n");
        // ecall
        stringBuilder.append(indent).append("ecall").append("\n");
        // jr ra
        stringBuilder.append(indent).append("jr      ra").append("\n");

        // add definition of "puts" function

        // puts:
        stringBuilder.append("puts:").append("\n");
        // li a7, 92 ; ecall for puts
        stringBuilder.append(indent).append("li      a7, 92   # ecall for puts").append("\n");
        // ecall
        stringBuilder.append(indent).append("ecall").append("\n");
        // jr ra
        stringBuilder.append(indent).append("jr      ra").append("\n");
    }

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
                // nop
                break;

            case EXPRESSION:
                // nop
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
                // System.out.println("Unknown type: " + astNode.astNodeType);
                // return;
                throw new RuntimeException("Unknown type: " + astNode.astNodeType);
        }
    }

    /**
     * <pre>
     * ; delete stack frame (inverse operation to create stack frame)
     *    lw      ra,28(sp)           ; restore address to return to
     *    lw      s0,24(sp)           ; restore s0/fp (frame pointer)
     *    addi    sp,sp,32            ; remove stack pointer, return space for new stackframe, 8 elements
     *
     *    ; return
     *    jr      ra                  ; jump to return address
     * </pre>
     * 
     * @param astNode
     */
    private void processReturn(ReturnASTNode astNode) {

        // throw new UnsupportedOperationException("Unimplemented method
        // 'processReturn'");

        // <processReturn()>
        stringBuilder.append(indent).append("# ").append("<processReturn()>").append("\n");
        stringBuilder.append(indent).append("ret").append("\n");
    }

    private void processJump(JumpASTNode astNode) {

        switch (astNode.jumpType) {

            case Jump:
                // @formatter:off
                stringBuilder.append(indent)
                    .append("j       ").append(astNode.value)
                    .append("\n");
                // @formatter:on
                break;

            case JumpGreaterThanOrEqual: {

                ASTNode child0 = astNode.children.get(0);
                ASTNode child1 = astNode.children.get(1);

                if (child0 instanceof ValueASTNode) {
                    loadVariableIntoTempRegister("t0", child0.value);
                } else if (child0 instanceof ExpressionASTNode) {
                    loadValueIntoTempRegister("t0", child0.value);
                }

                if (child1 instanceof ValueASTNode) {
                    loadVariableIntoTempRegister("t1", child1.value);
                } else if (child1 instanceof ExpressionASTNode) {
                    loadValueIntoTempRegister("t1", child1.value);
                }

                // @formatter:off
                stringBuilder.append(indent)
                    .append("ble     ")
                    .append("t1").append(", ")
                    .append("t0").append(", ")
                    .append(astNode.value)
                    .append("\n");
                // @formatter:on

                }
                break;

            default:
                throw new RuntimeException("" + astNode.jumpType);
        }
    }

    private void processLabel(LabelASTNode astNode) {
        stringBuilder.append(astNode.value).append(":").append("\n");
    }

    private void processAssignment(AssignmentASTNode assignmentASTNode) {

        String variableName = assignmentASTNode.lhs;

        // TODO: figure out if the value is a constant or not
        // int value = 22;
        String value = "?";
        boolean valueIsRegister = false;

        ExpressionASTNode expressionASTNode = assignmentASTNode.expression;
        switch (expressionASTNode.expressionType) {

            case Constant: {
                ConstantDeclarationASTNode constantDeclarationASTNode = (ConstantDeclarationASTNode) expressionASTNode.children
                        .get(0);
                ConstIntASTNode constIntASTNode = (ConstIntASTNode) constantDeclarationASTNode.children.get(0);
                value = constIntASTNode.value;
            }
                break;

            case LessThen: {
                System.out.println("test");
                value = "??";
                throw new RuntimeException("Implement this!");
            }

            case Add: {
                String literalLhs = retrieveLiteralFromExpression(
                        (ExpressionASTNode) expressionASTNode.children.get(0));

                String literalRhs = retrieveLiteralFromExpression(
                        (ExpressionASTNode) expressionASTNode.children.get(1));

                String tempRegister = "t0";
                loadVariableIntoTempRegister(tempRegister, literalLhs);

                // @formatter:off
                stringBuilder.append(indent)
                    .append("addi    a5, ")
                    .append(tempRegister).append(", ")
                    .append(literalRhs)
                    .append("\n");
                // @formatter:on

                value = "a5";
                valueIsRegister = true;
            }
                break;

            case Identifier: {
                value = "a5";
                valueIsRegister = true;

                loadVariableIntoTempRegister(value, expressionASTNode.value);
            }
                break;

            default:
                throw new RuntimeException(expressionASTNode.expressionType.toString() + " " + expressionASTNode.value);
            // System.out.println("Default: " + expressionASTNode.expressionType);
            // break;
        }

        RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(variableName);

        int address = riscvStackEntry.address;
        int offset = address - stackPointer;

        String tempRegister = "t0";
        stringBuilder.append(indent).append("# variable '").append(variableName).append("'").append("\n");

        if (valueIsRegister) {

            // @formatter:off
            stringBuilder.append(indent)
                .append("mv      ").append(tempRegister).append(", ")
                .append(value)
                .append("\n");
            // @formatter:on

        } else {

            // @formatter:off
            stringBuilder.append(indent)
                .append("li      ").append(tempRegister).append(", ")
                .append(value)
                .append("\n");
            // @formatter:on

        }

        stringBuilder.append(indent).append("sw      ").append(tempRegister).append(", ").append(offset).append("(sp)")
                .append("\n");
    }

    private String loadVariableIntoTempRegister(String register, String varName) {

        RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(varName);

        int address = riscvStackEntry.address;
        int offset = address - stackPointer;

        // load
        stringBuilder.append(indent)
                .append("lw      ").append(register).append(", ")
                .append(offset).append("(sp)")
                .append("\n");

        return register;
    }
    
    private String loadValueIntoTempRegister(String register, String value) {

        // RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(varName);

        // int address = riscvStackEntry.address;
        // int offset = address - stackPointer;

        // load
        stringBuilder.append(indent)
                .append("li      ").append(register).append(", ")
                .append(value)
                .append("\n");

        return register;
    }

    private String retrieveLiteralFromExpression(ExpressionASTNode astNode) {

        switch (astNode.expressionType) {

            case Constant:
                ConstantDeclarationASTNode temp = (ConstantDeclarationASTNode) astNode.getChildren().get(0);
                ASTNode temp2 = temp.children.get(0);
                return temp2.value;

            case Identifier:
                return astNode.value;

            default:
                throw new RuntimeException();

        }

        // return "";
    }

    private void processFunctionCall(ASTNode astNode) {
        if (astNode instanceof PrintfASTNode) {
            processPrintfFunctionCall((PrintfASTNode) astNode);
        } else if (astNode instanceof ExitASTNode) {
            processExitFunctionCall((ExitASTNode) astNode);
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

        // // define data to print inside printf
        // String labelName = ".LABEL_0";
        // stringBuilder.append(labelName).append(": ").append("\n");
        // stringBuilder.append(indent).append(".string ").append(astNode.value).append("\n");

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
        stringBuilder.append(indent).append("lui     a5, ").append("%hi(").append(printLabelName).append(")").append("\n");
        // addi a0, a5, %lo(.LC3)
        stringBuilder.append(indent).append("addi    a0, a5, ").append("%lo(").append(printLabelName).append(")")
                .append("\n");
        // call puts
        stringBuilder.append(indent).append("call    puts").append("\n");

        // stringBuilder.append(indent).append("ret").append("\n");

    }

    private void processExitFunctionCall(ExitASTNode astNode) {
        // call exit
        stringBuilder.append(indent).append("call    exit").append("\n");
    }

}
