package mips;

public enum MIPSInstructionType {

    I,

    R,

    F;

    public static MIPSInstructionType fromValue(final MIPSInstruction instruction) {

        switch (instruction) {

            //
            // I-type instructions
            //
            
            /** branch less than zero */
            case BLTZ:

            /** branch greater than or equal zero */
            case BGEZ:

            /** jump */
            case J:

            /** jump and link */
            case JAL:

            /** branch if equal */
            case BEQ:

            /** branch if not equal */
            case BNE:

            /** branch if less than or equal to zero */
            case BLEZ:

            /** branch if greater than zero */
            case BGTZ:

            /** add immediate */
            case ADDI:

            /** add immediate unsigned */
            case ADDIU:

            /** set less than immediate */
            case SLTI:

            /** set less than immediate unsigned */
            case SLTIU:

            /** and immediate */
            case ANDI:

            /** or immediate */
            case ORI:

            /** xor immediate */
            case XORI:

            /** load upper immediate */
            case LUI:

            /** move from/to coprocessor */
            case MFC0:

            /** branch if fcond is false / true */
            case BCLF:

            /** branch if fcond is false / true */
            case BCLT:

            /** multiply */
            case MUL:

            /** load byte */
            case LB:

            /** load halfword */
            case LH:

            /** load word */
            case LW:

            /** load byte unsigned */
            case LBU:

            /** load halfword unsigned */
            case LHU:

            /** store byte */
            case SB:

            /** store halfword */
            case SH:

            /** store word */
            case SW:

            /** load word to fp coprocessor */
            case LWC1:

            /** store word to fp coprocessor */
            case SWC1:
                return I;

            //
            // R-Type instructions (They all have the same opcode 000000 and are distinguished by funct)
            //

            /** Shift left logial */
            case SLL:

            /** Shift right logical */
            case SRL:

            /** Shift right arithmetic */
            case SRA:

            /** Shift left logical variable */
            case SLLV:

            /** Shift right logical variable */
            case SRLV:

            /** Shift right arithmetic variable */
            case SRAV:

            /** jump register */
            case JR:

            /** jump and link register */
            case JALR:

            /** system call */
            case SYSCALL:

            /** break */
            case BREAK:

            /** move from hi */
            case MFHI:

            /** move to hi */
            case MTHI:

            /** move from lo */
            case MFLO:

            /** move to lo */
            case MTLO:

            /** multiply */
            case MULT:

            /** multiply unsigned */
            case MULTU:

            /** divide */
            case DIV:

            /** divide unsigned */
            case DIVU:

            /** add */
            case ADD:

            /** add unsigned */
            case ADDU:

            /** subtract */
            case SUB:

            /** subtract unsigned */
            case SUBU:

            /** and */
            case AND:

            /** or */
            case OR:

            /** xor */
            case XOR:

            /** nor */
            case NOR:

            /** set less than */
            case SLT:

            /** set less than unsigned */
            case SLTU:
                return R;

            //
            // F-Type instructions (They all have the opcode 010001 and are distinguished by funct)
            //

            /** floating point add (FP add) */
            case ADD_S:
            case ADD_D:

            case SUB_S:
            case SUB_D:

            case MUL_S:
            case MUL_D:

            case DIV_S:
            case DIV_D:

            case ABS_S:
            case ABS_D:

            case NEG_S:
            case NEG_D:

            case C_SEQ_S:
            case C_SEQ_D:

            case C_LT_S:
            case C_LT_D:

            case C_LE_S:
            case C_LE_D:
                return F;

            default:
                throw new RuntimeException("Unknown instruction type for instruction: " + instruction + "!");
        }
    }
    
}
