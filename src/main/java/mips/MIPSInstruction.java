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
    SLRV,

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

            case BLTZ:
            case BGEZ:
                return 0b000001;

            case J:
                return 0b000010;

            default:
                throw new RuntimeException("Unknown instruction! " + mipsInstruction);

        }

    }
}
