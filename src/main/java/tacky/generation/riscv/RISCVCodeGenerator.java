package tacky.generation.riscv;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ast.ASTNode;
import ast.ExpressionASTNode;
import common.ByteArrayUtil;
import grammar.ActualParameter;
import tacky.ast.AssignmentASTNode;
import tacky.ast.ConstIntASTNode;
import tacky.ast.ConstantDeclarationASTNode;
import tacky.ast.ExitASTNode;
import tacky.ast.FunctionCallASTNode;
import tacky.ast.FunctionDefinitionASTNode;
import tacky.ast.JumpASTNode;
import tacky.ast.LabelASTNode;
import tacky.ast.LoadFromAddressASTNode;
import tacky.ast.PrintfASTNode;
import tacky.ast.PutintASTNode;
import tacky.ast.ReturnASTNode;
import tacky.ast.SizeofASTNode;
import tacky.ast.ValueASTNode;
import tacky.ast.VariableDeclarationASTNode;
import tacky.generation.Generator;
import tacky.generation.tacky.TackyDataType;
import types.FormalParameter;

public class RISCVCodeGenerator implements Generator {

    // output of code

    public StringBuilder stringBuilder = new StringBuilder();

    public String indent = "        ";

    // stack frame generation

    // private static final int FP_OFFSET = 4;

    private static final String FRAME_POINTER = "fp";

    private static final boolean PRINT_STACK_FRAME_LAYOUT = true;
    // private static final boolean PRINT_STACK_FRAME_LAYOUT = false;

    private int STACK_POINTER_ADDRESS = 0x20000;
    private int framePointer = STACK_POINTER_ADDRESS;

    public RISCVStackFrame stackFrame;

    // function parameter handling

    public FunctionDefinitionASTNode prototype;

    // printf processing

    public int literalStringRecordIndex;

    public List<LiteralStringRecord> literalStringRecordList = new ArrayList<>();

    @Override
    public void start() {

        // DATA SEGMENT

        // stringBuilder.append(indent).append(".data").append("\n").append("\n");

        // CODE SEGMENT
        // stringBuilder.append("\n").append(indent).append(".text").append("\n").append("\n");

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

        // add definition of "putint" function

        // putint:
        stringBuilder.append("putint:").append("\n");
        // li a7, 92 ; ecall for putint
        stringBuilder.append(indent).append("li      a7, 105   # ecall for putint").append("\n");
        // ecall
        stringBuilder.append(indent).append("ecall").append("\n");
        // jr ra
        stringBuilder.append(indent).append("jr      ra").append("\n");

    }

    @Override
    public void end() {

        // define data to print inside printf

        for (LiteralStringRecord literalStringRecord : literalStringRecordList) {
            stringBuilder.append(literalStringRecord.getLabel()).append(": ").append("\n");
            stringBuilder.append(indent).append(".string ").append("\"")
                    .append(StringUtils.unwrap(literalStringRecord.value, "\""))
                    .append("\"")
                    .append("\n");
        }
    }

    @Override
    public void execute(ASTNode astNode) {

        // DEBUG print node
        // boolean printAST = true;
        boolean printAST = false;
        if (printAST) {
            StringBuilder tempStringBuilder = new StringBuilder();
            astNode.printRecursive(tempStringBuilder, 0, true);
            System.out.print(tempStringBuilder.toString());
        }

        switch (astNode.astNodeType) {

            case ROOT: {
            }
                break;

            case PROGRAM: {
            }
                break;

            case FUNCTION_DEFINITION: {
                prototype = (FunctionDefinitionASTNode) astNode;
                executeFunction((FunctionDefinitionASTNode) astNode);
            }
                break;

            case FUNCTION_DECLARATION: {
                // System.out.println(astNode.toString());
            }
                break;

            case FUNCTION_CALL: {
                // the delegator inserts special code for built-in print(), exit() functions
                // and also handles calls to normal code-declared functions
                processFunctionCallDelegator(astNode);
            }
                break;

            case INIT_DECLARATION: {
                // e.g. length = Var("length")
                // No output takes place. The only change is that the stack pointer is
                // decremented to makes room for the local variable on teh stack.
                // System.out.println(astNode.toString());
            }
                break;

            case ITERATION_STATEMENT: {
                // System.out.println(astNode.toString());
            }
                break;

            case JUMP_STATEMENT: {
                processJump((JumpASTNode) astNode);
            }
                break;

            case SIMPLE_DECLARATION: {
                // nop
                // System.out.println(astNode.toString());
            }
                break;

            case EXPRESSION: {
                // nop
                // System.out.println(astNode.toString());
            }
                break;

            case ASSIGNMENT: {
                processAssignment((AssignmentASTNode) astNode);
            }
                break;

            case LABEL: {
                processLabel((LabelASTNode) astNode);
            }
                break;

            case RETURN: {
                processReturn((ReturnASTNode) astNode);
                // remove the callee function from the stack and make the caller current again
                // functionCallStack.pop();
            }
                break;

            case SIZEOF: {
                // load value into the temp variable

                SizeofASTNode sizeofASTNode = (SizeofASTNode) astNode;
                String typeToProcess = sizeofASTNode.sizeOfType;

                int size = TackyDataType.sizeOf(typeToProcess);

                ASTNode child0 = astNode.children.get(0);
                String targetVariableName = child0.value;

                // write the 'size' value into the local variable 'targetVariableName'
                // addToStackFram

                RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(targetVariableName);
                int address = riscvStackEntry.address;

                // compute offset from stack_pointer (positive value)
                // int stackPointerOffset = address - stackPointer;

                // compute offset from frame_pointer (negative value)
                // int framePointerOffset = framePointer - address - FP_OFFSET;
                // int framePointerOffset = framePointer - address;
                int framePointerOffset = address - framePointer;

                // @formatter:off
                String tempRegister = "t0";

                // comment
                stringBuilder.append(indent).append("# ").append("<sizeof " + typeToProcess + ">").append("\n");

                stringBuilder.append(indent)
                    .append("li      ").append(tempRegister).append(", ")
                    .append(size)
                    .append("\n");

                // relative to stack pointer
                // stringBuilder.append(indent)
                //     .append("sw      ").append(tempRegister).append(", ")
                //     .append(stackPointerOffset).append("(").append(STACK_POINTER).append(")")
                //     .append("\n");

                // relative to frame pointer
                stringBuilder.append(indent)
                    .append("sw      ").append(tempRegister).append(", ")
                    .append(framePointerOffset).append("(").append(FRAME_POINTER).append(")")
                    .append("\n");

                // @formatter:on
            }
                break;

            case GET_ADDRESS: {

                // NEEDS TO USE ABSOLUTE ADDRESSES

                // GetAddress(temp_array, temp_array.ptr)
                // load address of variable 'temp_array' into variable 'temp_array.ptr'

                ASTNode child0 = astNode.children.get(0);
                ASTNode child1 = astNode.children.get(1);

                RISCVStackEntry sourceRISCVStackEntry = stackFrame.stackEntryMap.get(child0.value);
                RISCVStackEntry targetRISCVStackEntry = stackFrame.stackEntryMap.get(child1.value);

                int sourceAddressOffset = (-1) * sourceRISCVStackEntry.fpRelativeAddress;
                int targetAddressOffset = (-1) * targetRISCVStackEntry.fpRelativeAddress;

                // int offset = targetAddress - stackPointer;
                // compute offset from stack_pointer (positive value)
                // int stackPointerOffset = address - stackPointer;

                // compute offset from frame_pointer (negative value)
                // int framePointerOffset = stackPointer - targetAddress - FP_OFFSET;
                // int framePointerOffset = targetAddress - framePointer;
                // int framePointerOffset = targetRISCVStackEntry.fpRelativeAddress;

                // @formatter:off

                // comment
                stringBuilder.append(indent)
                    .append("# GetAddress(").append(child0.value).append(", ")
                    .append(child1.value).append(")")
                    .append("\n");

                String tempRegister = "t0";

                // // li dest, src
                // stringBuilder.append(indent)
                //     .append("li      ").append(tempRegister).append(", ")
                //     // .append(sourceAddress)
                //     .append(ByteArrayUtil.byteToHex(sourceAddress))
                //     .append("\n");

                // addi dest, fp, fp_rel
                stringBuilder.append(indent)
                    .append("addi      ").append(tempRegister).append(", ")
                    .append("fp").append(", ")
                    .append(ByteArrayUtil.byteToHex(sourceAddressOffset))
                    .append("\n");

                // sw
                stringBuilder.append(indent)
                    .append("sw      ").append(tempRegister).append(", ")
                    .append(targetAddressOffset).append("(").append(FRAME_POINTER).append(")")
                    .append("\n");
                // @formatter:on

            }
                break;

            case STORE_TO_ADDRESS: {

                // NEEDS TO USE ABSOLUTE ADDRESSES

                // Store(src, ptr)
                //
                // Store the value contained in the variable 'src' into
                // the memory cell having the address stored in ptr

                ValueASTNode sourceRISCVStackEntry = (ValueASTNode) astNode.children.get(0);
                ValueASTNode targetRISCVStackEntry = (ValueASTNode) astNode.children.get(1);

                String valueVariableName = sourceRISCVStackEntry.value;
                String ptrVariableName = targetRISCVStackEntry.value;

                // RISCVStackEntry riscvStackEntry =
                // stackFrame.stackEntryMap.get(ptrVariableName);
                // int address = riscvStackEntry.address;

                stringBuilder.append(indent).append("# StoreToAddress()").append("\n");

                String tempRegister = "t2";
                loadLocalVariableIntoTempRegister(tempRegister, valueVariableName);

                String addressRegister = "t3";
                loadLocalVariableIntoTempRegister(addressRegister, ptrVariableName);

                int offset = 0;

                // @formatter:off
                stringBuilder.append(indent)
                    .append("sw      ").append(tempRegister).append(", ")
                    .append(offset).append("(").append(addressRegister).append(")")
                    .append("\n");
                // @formatter:on

                // DEBUG
                // stringBuilder.append(indent).append("nop").append("\n");

                // System.out.println();
            }
                break;

            case LOAD_FROM_ADDRESS: {

                // Load(numbers.addr.ptr.ptr.tmp, idxResult)

                // lw ra,28(sp)

                LoadFromAddressASTNode loadFromAddressASTNode = (LoadFromAddressASTNode) astNode;

                // retrieve local variable from stack and store it's value into a temp register
                String tempRegister = "t0";

                stringBuilder.append(indent).append("# >> dereference into temp register: " + tempRegister)
                        .append("\n");

                loadLocalVariableIntoTempRegister(tempRegister, loadFromAddressASTNode.ptrVariableName);

                // load data from address the pointer points to
                // lw t0, 0(t0)
                stringBuilder.append(indent).append("lw      ")
                        .append(tempRegister).append(", 0(").append(tempRegister)
                        .append(")").append("\n");

                stringBuilder.append(indent).append("# << dereference into temp register: " + tempRegister)
                        .append("\n");

                // store word into target local variable

                // retrieve address of variable to load into from the stack
                RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(loadFromAddressASTNode.variableName);

                // build offset to destination variable
                int address = riscvStackEntry.address;

                // compute offset from stack_pointer (positive value)
                // int stackPointerOffset = address - stackPointer;

                // compute offset from frame_pointer (negative value)
                // int framePointerOffset = stackPointer - address - FP_OFFSET;
                int framePointerOffset = address - framePointer;

                // store value into variable

                // @formatter:off

                // comment
                stringBuilder.append(indent).append("# >> store to stack").append("\n");

                // // relative to stack pointer
                // stringBuilder.append(indent)
                //     .append("sw      ").append(tempRegister).append(", ")
                //     .append(stackPointerOffset).append("(").append(STACK_POINTER).append(")")
                //     .append("\n");

                // relative to frame pointer
                stringBuilder.append(indent)
                    .append("sw      ").append(tempRegister).append(", ")
                    .append(framePointerOffset).append("(").append(FRAME_POINTER).append(")")
                    .append("\n");

                stringBuilder.append(indent).append("# << store to stack").append("\n");
                // @formatter:on

            }
                break;

            case UNKNOWN:
            default:
                // System.out.println("Unknown type: " + astNode.astNodeType);
                // return;
                throw new RuntimeException("Unknown AST-Node type: " + astNode.astNodeType);

        }
    }

    private void executeFunction(FunctionDefinitionASTNode functionAstNode) {

        // build StackFrame for this function call

        stackFrame = new RISCVStackFrame();

        // reserve space on the stack for the 'ra' (return address register)
        VariableDeclarationASTNode ra = new VariableDeclarationASTNode();
        ra.variableName = "_____ra_____";
        ra.isArray = false;
        ra.arraySize = 0;
        @SuppressWarnings("unused")
        RISCVStackEntry raStackEntry = ra.addToStackFrame(stackFrame);

        // reserve space on the stack for the 's0'/'fp' (frame pointer)
        VariableDeclarationASTNode spfp = new VariableDeclarationASTNode();
        spfp.variableName = "_____spfp_____";
        spfp.isArray = false;
        spfp.arraySize = 0;
        @SuppressWarnings("unused")
        RISCVStackEntry spfpStackEntry = spfp.addToStackFrame(stackFrame);

        // 1. for each local variable declaration used in this function,
        // insert it into the data structure first
        for (ASTNode astNode : functionAstNode.children) {

            // in order to correctly allocate memory for all local variables,
            // this has to recursively dive into the for-loop and if-else statements.
            // Basically, every nested scope has to be visited and local varibles need
            // to go into the stack frame.

            @SuppressWarnings("unused")
            RISCVStackEntry stackEntry = astNode.addToStackFrame(stackFrame);
        }

        // 2. for each local variable declaration used in this function,
        // reserve space on the stack
        int stackSizeUsed = stackFrame.computeAddresses(STACK_POINTER_ADDRESS);

        stackFrame.stackSizeUsed = stackSizeUsed;

        // DEBUG - output the stack frame and it's details
        if (PRINT_STACK_FRAME_LAYOUT) {
            System.out.println(stackFrame.toString());
        }

        // insert function label for the function
        stringBuilder.append(functionAstNode.value).append(":").append("\n");
        if (functionAstNode.value.equalsIgnoreCase("main")) {

            // insert start symbol for the function called main
            stringBuilder.append("_start:").append("\n");
        }

        stringBuilder.append(indent).append("# -- stack frame create --").append("\n");

        // advance stack pointer
        // move stack pointer, make space for new stackframe (8 elements)
        // (I think GCC always builds stack frames with a multiple of
        // 16 byte sizes! Not all elements are used!)

        stringBuilder.append(indent).append("print_reg sp").append("\n");

        // @formatter:off
        stringBuilder.append(indent)
            .append("addi    sp, sp, ").append((-1) * stackSizeUsed)
            .append("\n");
        // @formatter:on

        // sw ra,28(sp) // store address to return to (stored in ra) onto the stack
        // (SHOULD WE WANT TO CALL MORE FUNCTIONS WITHIN THE BODY OF THIS FUNCTION)
        stringBuilder.append(indent)
                .append("sw      ra, " + (stackSizeUsed - 4) + "(sp)")
                .append("\n");

        // sw s0,24(sp) // store old s0/fp (frame pointer) on the stack so it can be
        // restored later because it will be used within this function
        stringBuilder.append(indent)
                .append("sw      fp, " + (stackSizeUsed - 8) + "(sp)")
                .append("\n");

        // set new s0/fp (frame pointer) to the start of our new
        // stackframe. Now offseting (with negative offsets) from new
        // s0/fp grants access to all local variables contained the new stack frame
        // This means the stragey in the emitted assembler code is to refer to
        // local variables not via the stack pointer but via the frame pointer.
        // The frame pointer is used to access the stack frame hence the name.

        // addi s0, sp, 32
        stringBuilder.append(indent)
                .append("addi    fp, sp, ").append(stackSizeUsed)
                .append("\n");

        // stackPointer -= stackSizeUsed;

        stringBuilder.append(indent).append("# -- stack frame create --").append("\n");

        // generate code for all children
        for (ASTNode astNode : functionAstNode.children) {
            execute(astNode);
        }

        // no ret command or jr ra is added since these types
        // of return statements are handled by the code generation for
        // the return-statement. See processReturn()
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
    private void processReturn(ReturnASTNode returnASTNode) {

        // check if there is a parameter to the return keyword
        if (returnASTNode.children.size() > 0) {

            ASTNode astNode = returnASTNode.children.get(0);
            // System.out.println(astNode);

            if (astNode instanceof ValueASTNode) {
                loadLocalVariableIntoTempRegister("a0", astNode.value);
            } else if (astNode instanceof ExpressionASTNode) {
                loadValueIntoRegister("a0", astNode.value);
            } else if (astNode instanceof ConstantDeclarationASTNode) {
                ASTNode temp0 = astNode.children.get(0);
                loadValueIntoRegister("a0", temp0.value);
            }
        }

        int stackSizeUsed = stackFrame.stackSizeUsed;

        // comment
        stringBuilder.append(indent).append("# -- stack frame remove --").append("\n");

        // ; delete stack frame (inverse operation to create stack frame)
        // lw ra,28(sp) ; restore address to return to
        stringBuilder.append(indent)
                .append("lw      ra, " + (stackSizeUsed - 4) + "(sp)")
                .append("\n");

        // lw s0,24(sp) ; restore s0/fp (frame pointer)
        stringBuilder.append(indent)
                .append("lw      s0, " + (stackSizeUsed - 8) + "(sp)")
                .append("\n");

        // addi sp,sp,32 ; remove stack pointer, return space for new stackframe, 8
        // elements
        stringBuilder.append(indent)
                .append("addi    sp, sp, ").append(stackSizeUsed)
                .append("\n");

        stringBuilder.append(indent).append("print_reg sp").append("\n");

        // comment
        stringBuilder.append(indent).append("# -- stack frame remove --").append("\n");

        // DEBUG - NOP
        stringBuilder.append(indent).append("nop").append("\n");

        // jump to return address
        stringBuilder.append(indent).append("# ").append("<processReturn()>").append("\n");
        stringBuilder.append(indent).append("ret").append("\n");
    }

    private void processJump(JumpASTNode astNode) {

        switch (astNode.jumpType) {

            case Jump: {
                // @formatter:off
                stringBuilder.append(indent)
                    .append("j       ").append(astNode.value)
                    .append("\n");
                // @formatter:on
            }
                break;

            case JumpIfZero: {

                // beq x5, x0, not_zero_block

                ASTNode child0 = astNode.children.get(0);

                if (child0 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t0", child0.value);
                } else if (child0 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t0", child0.value);
                }

                // @formatter:off
                // this produces code like: beq zero, ... which reads very nicely as "branch equal zero"!
                stringBuilder.append(indent)
                    .append("beq     ")
                    .append("zero").append(", ")
                    .append("t0").append(", ")
                    .append(astNode.value)
                    .append("\n");
                // @formatter:on
            }
                break;

            case JumpIfEqual: {
                ASTNode child0 = astNode.children.get(0);

                if (child0 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t0", child0.value);
                } else if (child0 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t0", child0.value);
                } else if (child0 instanceof ConstantDeclarationASTNode) {
                    ASTNode temp0 = child0.children.get(0);
                    loadValueIntoRegister("t0", temp0.value);
                }

                ASTNode child1 = astNode.children.get(1);

                if (child1 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t1", child1.value);
                } else if (child1 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t1", child1.value);
                } else if (child1 instanceof ConstantDeclarationASTNode) {
                    ASTNode temp1 = child1.children.get(0);
                    loadValueIntoRegister("t1", temp1.value);
                }

                // @formatter:off
                // this produces code like: beq zero, ... which reads very nicely as "branch equal zero"!
                stringBuilder.append(indent)
                    .append("beq     ")
                    .append("t0").append(", ")
                    .append("t1").append(", ")
                    .append(astNode.value)
                    .append("\n");
                // @formatter:on
            }
                break;

            case JumpIfNotEqual: {
                ASTNode child0 = astNode.children.get(0);

                if (child0 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t0", child0.value);
                } else if (child0 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t0", child0.value);
                } else if (child0 instanceof ConstantDeclarationASTNode) {
                    ASTNode temp0 = child0.children.get(0);
                    loadValueIntoRegister("t0", temp0.value);
                }

                ASTNode child1 = astNode.children.get(1);

                if (child1 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t1", child1.value);
                } else if (child1 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t1", child1.value);
                } else if (child1 instanceof ConstantDeclarationASTNode) {
                    ASTNode temp1 = child1.children.get(0);
                    loadValueIntoRegister("t1", temp1.value);
                }

                // @formatter:off
                // this produces code like: beq zero, ... which reads very nicely as "branch equal zero"!
                stringBuilder.append(indent)
                    .append("bne     ")
                    .append("t0").append(", ")
                    .append("t1").append(", ")
                    .append(astNode.value)
                    .append("\n");
                // @formatter:on
            }
                break;

            case JumpIfGreaterThanOrEqual: {

                ASTNode child0 = astNode.children.get(0);
                ASTNode child1 = astNode.children.get(1);

                if (child0 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t0", child0.value);
                } else if (child0 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t0", child0.value);
                }

                if (child1 instanceof ValueASTNode) {
                    loadLocalVariableIntoTempRegister("t1", child1.value);
                } else if (child1 instanceof ExpressionASTNode) {
                    loadValueIntoRegister("t1", child1.value);
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

        String value = "?";
        boolean valueIsRegister = false;

        ExpressionASTNode expressionASTNode = assignmentASTNode.expression;
        switch (expressionASTNode.expressionType) {

            case IntegerLiteral: {
                value = expressionASTNode.value;
            }
                break;

            case Constant: {
                ConstantDeclarationASTNode constantDeclarationASTNode = (ConstantDeclarationASTNode) expressionASTNode.children
                        .get(0);
                ConstIntASTNode constIntASTNode = (ConstIntASTNode) constantDeclarationASTNode.children.get(0);
                value = constIntASTNode.value;
            }
                break;

            case LessThen: {
                // System.out.println("test");
                value = "??";
                throw new RuntimeException("Implement this!");
            }

            case Add: {

                String tempRegister0 = "t0";
                String tempRegister1 = "t1";

                loadIntoTempRegisters(expressionASTNode, tempRegister0, tempRegister1);

                String tempRegister = "t0";

                // @formatter:off
                stringBuilder.append(indent)
                    .append("add     ").append(tempRegister).append(", ")
                    .append(tempRegister0).append(", ")
                    .append(tempRegister1)
                    .append("\n");
                // @formatter:on

                // store register containing the result of the add operation
                value = tempRegister;
                valueIsRegister = true;
            }
                break;

            case Subtract: {

                String tempRegister0 = "t0";
                String tempRegister1 = "t1";

                loadIntoTempRegisters(expressionASTNode, tempRegister0, tempRegister1);

                String tempRegister = "t0";

                // @formatter:off
                stringBuilder.append(indent)
                    .append("sub     ").append(tempRegister).append(", ")
                    .append(tempRegister0).append(", ")
                    .append(tempRegister1)
                    .append("\n");
                // @formatter:on

                // store register containing the result of the add operation
                value = tempRegister;
                valueIsRegister = true;
            }
                break;

            case Mul: {

                String tempRegister0 = "t0";
                String tempRegister1 = "t1";

                loadIntoTempRegisters(expressionASTNode, tempRegister0, tempRegister1);

                String tempRegister = "t0";

                // @formatter:off
                stringBuilder.append(indent)
                    .append("mul     ").append(tempRegister).append(", ")
                    .append(tempRegister0).append(", ")
                    .append(tempRegister1)
                    .append("\n");
                // @formatter:on

                value = tempRegister;
                valueIsRegister = true;
            }
                break;

            case Div: {

                String tempRegister0 = "t0";
                String tempRegister1 = "t1";

                loadIntoTempRegisters(expressionASTNode, tempRegister0, tempRegister1);

                String tempRegister = "t0";

                // @formatter:off
                stringBuilder.append(indent)
                    .append("div     ").append(tempRegister).append(", ")
                    .append(tempRegister0).append(", ")
                    .append(tempRegister1)
                    .append("\n");
                // @formatter:on

                value = tempRegister;
                valueIsRegister = true;
            }
                break;

            case Identifier: {
                value = "t0";
                valueIsRegister = true;

                loadLocalVariableIntoTempRegister(value, expressionASTNode.value);
            }
                break;

            default:
                throw new RuntimeException(expressionASTNode.expressionType.toString() + " " + expressionASTNode.value);
        }

        // Store result of the add operation into the destination (= Assignment)

        RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(variableName);

        // // compute offset from frame_pointer (negative value)
        // int address = riscvStackEntry.address;
        // int framePointerOffset = address - framePointer;

        int framePointerOffset = (-1) * riscvStackEntry.fpRelativeAddress;

        String tempRegister = "t0";

        // @formatter:off
        stringBuilder.append(indent)
                .append("# variable '").append(variableName).append("'")
                .append("\n");
        // @formatter:on

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

        // // @formatter:off
        // stringBuilder.append(indent)
        //     .append("sw      ").append(tempRegister).append(", ")
        //     .append(stackPointerOffset).append("(").append(STACK_POINTER).append(")")
        //     .append("\n");
        // // @formatter:on

        // @formatter:off
        stringBuilder.append(indent)
            .append("sw      ").append(tempRegister).append(", ")
            .append(framePointerOffset).append("(").append(FRAME_POINTER).append(")")
            .append("\n");
        // @formatter:on

    }

    /**
     * load first child of expressionASTNode into tempRegister0 and load second
     * child expressionASTNode into tempRegister1
     *
     * @param expressionASTNode
     * @param tempRegister0
     * @param tempRegister1
     */
    private void loadIntoTempRegisters(ExpressionASTNode expressionASTNode,
            String tempRegister0, String tempRegister1) {

        ASTNode child0 = expressionASTNode.children.get(0);
        ASTNode child1 = expressionASTNode.children.get(1);

        if (child0 instanceof ValueASTNode) {

            loadLocalVariableIntoTempRegister(tempRegister0, child0.value);

        } else if (child0 instanceof ExpressionASTNode) {

            ExpressionASTNode child0ExpressionASTNode = (ExpressionASTNode) child0;
            switch (child0ExpressionASTNode.expressionType) {

                case Identifier:
                    loadLocalVariableIntoTempRegister(tempRegister0, child0.value);
                    break;

                case IntegerLiteral:
                    loadValueIntoRegister(tempRegister0, child0.value);
                    break;

                case Constant:
                    loadValueIntoRegister(tempRegister0, unwrapConstant(child0).value);
                    break;

                default:
                    throw new RuntimeException(
                            "Unknown loadIntoTempRegisters type: " + child0ExpressionASTNode.expressionType);
            }
        }

        if (child1 instanceof ValueASTNode) {
            loadLocalVariableIntoTempRegister(tempRegister1, child1.value);
        } else if (child1 instanceof ExpressionASTNode) {
            ExpressionASTNode child1ExpressionASTNode = (ExpressionASTNode) child1;
            switch (child1ExpressionASTNode.expressionType) {
                case Identifier:
                    loadLocalVariableIntoTempRegister(tempRegister1, child1.value);
                    break;
                case Constant:
                    loadValueIntoRegister(tempRegister1, unwrapConstant(child1).value);
                    break;
                default:
                    throw new RuntimeException();
            }
        }
    }

    /**
     * Find the variable in the current stack frame (= local variable),
     * retrieves the value by emitting a lw instruction into the 'register'.
     *
     * @param register
     * @param varName
     * @return
     */
    private String loadLocalVariableIntoTempRegister(String register, String varName) {

        RISCVStackEntry riscvStackEntry = stackFrame.stackEntryMap.get(varName);

        // a local variable can also be a parameter to the current function call.
        // If the local variable is not on the stack, look it up in the functions
        // prototype and according to the location, read it from the matching
        // argument register
        if (riscvStackEntry == null) {

            int formalParameterIndex = 0;
            for (FormalParameter formalParameter : prototype.formalParameters) {
                if (formalParameter.getName().equalsIgnoreCase(varName)) {
                    break;
                }
                formalParameterIndex++;
            }

            String formalParameterRegister = "a" + formalParameterIndex;

            // move
            stringBuilder.append(indent)
                    .append("mv      ").append(register).append(", ")
                    .append(formalParameterRegister)
                    .append("\n");

            return formalParameterRegister;

        } else {

            // the variable is local on the stack and not a function parameter.
            // Load it into a register and return the register used.

            // // compute offset from frame_pointer (negative value)
            // int address = riscvStackEntry.address;
            // int framePointerOffset = address - framePointer;

            int framePointerOffset = (-1) * riscvStackEntry.fpRelativeAddress;

            // load word

            // // @formatter:off
            // stringBuilder.append(indent)
            //         .append("lw      ")
            //         .append(register).append(", ")
            //         .append(stackPointerOffset).append("(").append(STACK_POINTER).append(")")
            //         .append("\n");
            // // @formatter:on

            // @formatter:off
            stringBuilder.append(indent)
                    .append("lw      ").append(register).append(", ")
                    .append(framePointerOffset).append("(").append(FRAME_POINTER).append(")")
                    .append("\n");
            // @formatter:on

            return register;

        }

    }

    private void processFunctionCallDelegator(ASTNode astNode) {

        if (astNode instanceof PrintfASTNode) {

            // special treatment for built-in printf()
            processPrintfFunctionCall((PrintfASTNode) astNode);

        } else if (astNode instanceof ExitASTNode) {

            // special treatment for built-in exit()
            processExitFunctionCall((ExitASTNode) astNode);

        } else if (astNode instanceof PutintASTNode) {

            // special treatment for built-in exit()
            processPutintFunctionCall((PutintASTNode) astNode);

        } else if (astNode instanceof FunctionCallASTNode) {

            FunctionDefinitionASTNode currentFunction = (FunctionDefinitionASTNode) astNode.parent;

            FunctionCallASTNode newFunction = (FunctionCallASTNode) astNode;

            // generate code for function call to code-declared functions (not built-in)
            processFunctionCall(currentFunction, newFunction);

        } else {

            throw new RuntimeException();

        }
    }

    private void processPutintFunctionCall(PutintASTNode astNode) {

        // save a0 because it is used
        stringBuilder.append(indent).append("mv      t6, a0").append("\n");

        String tempRegister = "a0";
        loadLocalVariableIntoTempRegister(tempRegister, astNode.value);

        // stringBuilder.append(indent)
        // .append("li ").append(tempRegister).append(", ")
        // .append(astNode.value)
        // .append("\n");

        // call putint
        stringBuilder.append(indent).append("call    putint").append("\n");

        // restore a0
        stringBuilder.append(indent).append("mv      a0, t6").append("\n");
    }

    private void processFunctionCall(FunctionDefinitionASTNode callerFunctionCallASTNode,
            FunctionCallASTNode calleeFunctionCallASTNode) {

        String callerFunctionName = callerFunctionCallASTNode.value;
        String calleeFunctionName = calleeFunctionCallASTNode.value;

        // System.out.println(callerFunctionName + "() -> " + calleeFunctionName +
        // "()");
        stringBuilder.append(indent).append("# ").append(callerFunctionName + "() -> " + calleeFunctionName + "()")
                .append("\n");

        // save caller actual parameter registers a0 - a7 since they are caller saved
        // and hence could be overridden by the callee at any time

        int formalParmeterCounter = 0;
        for (@SuppressWarnings("unused")
        FormalParameter formalParameter : callerFunctionCallASTNode.formalParameters) {
            String parameterRegister = "a" + formalParmeterCounter;
            stackPushRegister(parameterRegister);
            formalParmeterCounter++;
        }

        // setup parameters to the called function into a0, a1, a2, ...

        int index = 0;

        for (ActualParameter actualParameter : calleeFunctionCallASTNode.actualParameters) {

            String argumentRegisterName = "a" + index;

            String label = actualParameter.name;
            if (label == null) {
                label = "" + actualParameter.intValue;
            }

            stringBuilder.append(indent).append("# load argument register ")
                    .append(argumentRegisterName)
                    .append(" with parameter '")
                    .append(label)
                    .append("'\n");

            if (actualParameter.name != null) {
                loadLocalVariableIntoTempRegister(argumentRegisterName, actualParameter.name);
            } else {
                loadValueIntoRegister(argumentRegisterName, "" + actualParameter.intValue);
            }

            index++;
        }

        // DEBUG - NOP
        // stringBuilder.append(indent).append("nop").append("\n");

        stringBuilder.append(indent).append("print_reg sp").append("\n");

        // call function
        stringBuilder.append(indent).append("call    ").append(calleeFunctionName).append("\n");

        stringBuilder.append(indent).append("print_reg sp").append("\n");

        // DEBUG - NOP
        stringBuilder.append(indent).append("nop").append("\n");

        // get actual parameters back
        for (@SuppressWarnings("unused")
        FormalParameter formalParameter : callerFunctionCallASTNode.formalParameters) {
            formalParmeterCounter--;
            String parameterRegister = "a" + formalParmeterCounter;
            stackPopRegister(parameterRegister);
        }
    }

    private void stackPushRegister(String register) {

        stringBuilder.append(indent).append("# ++ push parameter").append("\n");

        // b - byte - 8 bits
        // h - half word - 16 bits (2 bytes)
        // w - word - 32 bits (4 bytes)
        // d - double word - 64 bits (8 bytes)

        int offset = 0;

        // addi sp, sp, -4
        stringBuilder.append(indent).append("addi    sp, sp, -4").append("\n");
        // sw <register>, 24(sp)
        stringBuilder.append(indent)
                .append("sw      ").append(register).append(", ")
                .append(offset).append("(sp)").append("\n");

        stringBuilder.append(indent).append("# ++ push parameter").append("\n");
    }

    private void stackPopRegister(String register) {

        int offset = 0;

        stringBuilder.append(indent).append("# -- pop parameter").append("\n");

        // lw <register>, 24(sp)
        stringBuilder.append(indent)
                .append("lw      ").append(register).append(", ")
                .append(offset).append("(sp)").append("\n");
        // addi sp, sp, 4
        stringBuilder.append(indent).append("addi    sp, sp, 4").append("\n");

        stringBuilder.append(indent).append("# -- pop parameter").append("\n");
    }

    private void processPrintfFunctionCall(PrintfASTNode astNode) {

        // System.out.println(astNode);

        LiteralStringRecord literalStringRecord = new LiteralStringRecord();
        literalStringRecordList.add(literalStringRecord);

        literalStringRecord.index = literalStringRecordIndex;
        literalStringRecordIndex++;

        literalStringRecord.value = astNode.value;

        // save a0 because it is used
        stringBuilder.append(indent).append("mv      t6, a0").append("\n");

        // a7 describes the service that is called by the ecall
        // a0 is a parameter register. a0 contains the address of the data

        // parameter a0 is the format string's address

        String tempRegister1 = "a0";
        // has to be a0 because this is where the ecall expects to find the string-data
        // to print!
        String tempRegister2 = "a0";

        // lui a5, %hi(.LC3)
        stringBuilder.append(indent).append("lui     ").append(tempRegister1).append(", ")
                .append("%hi(").append(literalStringRecord.getLabel()).append(")")
                .append("\n");

        // addi a0, a5, %lo(.LC3)
        stringBuilder.append(indent).append("addi    ").append(tempRegister2).append(", ")
                .append(tempRegister1).append(", ")
                .append("%lo(").append(literalStringRecord.getLabel()).append(")")
                .append("\n");

        // stringBuilder.append(indent).append("li      ").append(tempRegister1).append(", ")
        //     .append(literalStringRecord.getLabel())
        //     .append("\n");

        stringBuilder.append(indent).append("print_reg sp").append("\n");

        // call puts
        stringBuilder.append(indent).append("call    puts").append("\n");

        stringBuilder.append(indent).append("print_reg sp").append("\n");

        // restore a0
        stringBuilder.append(indent).append("mv      a0, t6").append("\n");

    }

    private void processExitFunctionCall(ExitASTNode astNode) {
        // call exit
        stringBuilder.append(indent).append("call    exit").append("\n");
    }

    private String loadValueIntoRegister(String register, String value) {

        int valueDecimalAsInt = Integer.parseInt(value, 10);
        String valueAsHexString = ByteArrayUtil.byteToHex(valueDecimalAsInt);

        // load
        stringBuilder.append(indent)
                .append("li      ")
                .append(register).append(", ")
                // .append(value)
                .append(valueAsHexString)
                .append("\n");

        return register;
    }

    @SuppressWarnings("unused")
    private String retrieveLiteralFromExpression(ExpressionASTNode astNode) {
        switch (astNode.expressionType) {
            case Constant:
                ASTNode temp2 = unwrapConstant(astNode);
                return temp2.value;
            case Identifier:
                return astNode.value;
            default:
                throw new RuntimeException();
        }
    }

    private ASTNode unwrapConstant(ASTNode astNode) {
        ConstantDeclarationASTNode temp = (ConstantDeclarationASTNode) astNode.getChildren().get(0);
        ASTNode temp2 = temp.children.get(0);
        return temp2;
    }

}