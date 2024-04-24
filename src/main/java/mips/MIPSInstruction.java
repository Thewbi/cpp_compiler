package mips;

/**
 * Digital Design and Computer Architecture, David Money Harris & Sarah L. Harris, Appendix B, page 619
 */
public enum MIPSInstruction {

    //
    // I-type instructions
    //
    
    /** branch less than zero */
    BLTZ,

    /** branch greater than or equal zero */
    BGEZ,

    /** jump */
    J,

    /** jump and link */
    JAL,

    /** branch if equal */
    BEQ,

    /** branch if not equal */
    BNE,

    /** branch if less than or equal to zero */
    BLEZ,

    /** branch if greater than zero */
    BGTZ,

    /** add immediate */
    ADDI,

    /** add immediate unsigned */
    ADDIU,

    /** set less than immediate */
    SLTI,

    /** set less than immediate unsigned */
    SLTIU,

    /** and immediate */
    ANDI,

    /** or immediate */
    ORI,

    /** xor immediate */
    XORI,

    /** load upper immediate */
    LUI,

    /** move from/to coprocessor */
    MFC0,

    /** branch if fcond is false / true */
    BCLF,

    /** branch if fcond is false / true */
    BCLT,

    /** multiply */
    MUL,

    /** load byte */
    LB,

    /** load halfword */
    LH,

    /** load word */
    LW,

    /** load byte unsigned */
    LBU,

    /** load halfword unsigned */
    LHU,

    /** store byte */
    SB,

    /** store halfword */
    SH,

    /** store word */
    SW,

    /** load word to fp coprocessor */
    LWC1,

    /** store word to fp coprocessor */
    SWC1,

    //
    // R-Type instructions (They all have the same opcode 000000 and are distinguished by funct)
    //

    /** Shift left logial */
    SLL,

    /** Shift right logical */
    SRL,

    /** Shift right arithmetic */
    SRA,

    /** Shift left logical variable */
    SLLV,

    /** Shift right logical variable */
    SRLV,

    /** Shift right arithmetic variable */
    SRAV,

    /** jump register */
    JR,

    /** jump and link register */
    JALR,

    /** system call */
    SYSCALL,

    /** break */
    BREAK,

    /** move from hi */
    MFHI,

    /** move to hi */
    MTHI,

    /** move from lo */
    MFLO,

    /** move to lo */
    MTLO,

    /** multiply */
    MULT,

    /** multiply unsigned */
    MULTU,

    /** divide */
    DIV,

    /** divide unsigned */
    DIVU,

    /** add */
    ADD,

    /** add unsigned */
    ADDU,

    /** subtract */
    SUB,

    /** subtract unsigned */
    SUBU,

    /** and */
    AND,

    /** or */
    OR,

    /** xor */
    XOR,

    /** nor */
    NOR,

    /** set less than */
    SLT,

    /** set less than unsigned */
    SLTU,

    //
    // F-Type instructions (They all have the opcode 010001 and are distinguished by funct)
    //

    /** floating point add (FP add) */
    ADD_S,
    ADD_D,

    SUB_S,
    SUB_D,

    MUL_S,
    MUL_D,

    DIV_S,
    DIV_D,

    ABS_S,
    ABS_D,

    NEG_S,
    NEG_D,

    C_SEQ_S,
    C_SEQ_D,

    C_LT_S,
    C_LT_D,

    C_LE_S,
    C_LE_D

    ;

    public static int getOpcode(MIPSInstruction mipsInstruction) {

        switch (mipsInstruction) {

            case OR:
            case ADD:
            case SUB:
            case AND:
            case SLT:
                return 0b000000;

            case BEQ:
                return 0b000100;

            case ADDI:
                return 0b001000;

            case BLTZ:
            case BGEZ:
                return 0b000001;

            case J:
                return 0b000010;

            case JAL:
                return 0b000011;
                
            case SW:
                return 0b101011;

            case LW:
                return 0b100011;

            default:
                throw new RuntimeException("Unknown instruction! " + mipsInstruction);

        }

    }

    public static int getFunc(MIPSInstruction mipsInstruction) {

        switch (mipsInstruction) {

            case SLL:
                return 0b000000;

            case SRL:
                return 0b000001;
            
            case SRA:
                return 0b000011;

            case SLLV:
                return 0b000100;

            case SRLV:
                return 0b000110;

            case SRAV:
                return 0b000111;

            case JR:
                return 0b001000;

            case JALR:
                return 0b001001;

            case SYSCALL:
                return 0b001100;

            case BREAK:
                return 0b001101;

            case MFHI:
                return 0b010000;

            case MTHI:
                return 0b010001;

            case MFLO:
                return 0b010010;

            case MTLO:
                return 0b010011;

            case MULT:
                return 0b011000;

            case MULTU:
                return 0b011001;

            case DIV:
                return 0b011010;

            case DIVU:
                return 0b011011;

            case ADD:
                return 0b100000;

            case ADDU:
                return 0b100001;

            case SUB:
                return 0b100010;

            case SUBU:
                return 0b100011;

            case AND:
                return 0b100100;

            case OR:
                return 0b100101;

            case XOR:
                return 0b100110;

            case NOR:
                return 0b100111;

            case SLT:
                return 0b101010;

            case SLTU:
                return 0b101011;

            default:
                throw new RuntimeException("Unknown function! " + mipsInstruction);

        }

    }
}
