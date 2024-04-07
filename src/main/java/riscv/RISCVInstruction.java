package riscv;

public enum RISCVInstruction {

    //
    // RV32I Base Instruction Set
    //

    LUI,

    AUIPC,

    JAL,

    JALR,

    BEQ,

    BNE,

    BLT,

    BGE,

    BLTU,

    BGEU,    

    LB,

    LH,

    LW,

    LBU,

    LHU,

    SB,

    SH,

    SW,

    ADDI,

    SLTI,

    SLTIU,

    XORI,

    ORI,

    ANDI,

    SLLI,

    SRLI,

    SRAI,

    ADD,

    SUB,

    SLL,

    SLT,

    SLTU,

    XOR,

    SRL,

    SRA,

    OR,

    AND,

    FENCE,

    FENCE_I,

    ECALL,

    EBREAK,

    CSRRW,

    CSRRS,

    CSRRC,

    CSRRWI,

    CSRRSI,

    CSRRCI,





    //
    // pseudo instructions
    //

    BGT,

    LI,

    CALL,

    MV,

    JR,

    J,

    
    
}
