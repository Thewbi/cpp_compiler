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

    ADDI, // 000 001 0011

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
    // RV32M Standard Extension
    //

    MUL,

    MULH,

    MULHSU,

    MULHU,

    DIV,

    DIVU,

    REM,

    REMU,

    //
    // C extension
    //

    C_ADDI16SP,

    C_LUI,

    //
    // pseudo instructions
    //

    BGT,

    LI, // li x15, 1 ---> addi x15, x0, 1

    CALL,

    MV,

    JR,

    J;

    public static int getOpcode(RISCVInstruction riscVInstruction) {

        switch (riscVInstruction) {

            // case LUI:
            // return 0b00010011;

            // case AUIPC:
            // return 0b00010011;

            case JAL:
                return 0b01101111;

            case JALR:
                return 0b01100111;

            // case BEQ:
            // return 0b00010011;

            // case BNE:
            // return 0b00010011;

            case BLT:
                return 0b01100011;

            // case BGE:
            // return 0b00010011;

            // case BLTU:
            // return 0b00010011;

            // case BGEU:
            // return 0b00010011;

            // case LB:
            // return 0b00010011;

            // case LH:
            // return 0b00010011;

            case LW:
                return 0b00000011;

            // case LBU:
            // return 0b00010011;

            // case LHU:
            // return 0b00010011;
            
            // case SB:
            // return 0b00010011;

            // case SH:
            // return 0b00010011;

            case SW:
                return 0b00100011;

            case ADDI:
                return 0b00010011;

            // case SLTI:
            // return 0b00010011;

            // case SLTIU:
            // return 0b00010011;

            // case XORI:
            // return 0b00010011;

            // case ORI:
            // return 0b00010011;

            // case ANDI:
            // return 0b00010011;

            // case SLLI:
            // return 0b00010011;

            // case SRLI:
            // return 0b00010011;

            // case SRAI:
            // return 0b00010011;

            case ADD:
                return 0b00110011;

            // case SUB:
            // return 0b00010011;

            // case SLL:
            // return 0b00010011;

            // case SLT:
            // return 0b00010011;

            // case SLTU:
            // return 0b00010011;

            // case XOR:
            // return 0b00010011;

            // case SRL:
            // return 0b00010011;

            // case SRA:
            // return 0b00010011;

            // case OR:
            // return 0b00010011;

            // case AND:
            // return 0b00010011;

            // case FENCE:
            // return 0b00010011;

            // case FENCE_I:
            // return 0b00010011;

            // case ECALL:
            // return 0b00010011;

            // case EBREAK:
            // return 0b00010011;

            // case CSRRW:
            // return 0b00010011;

            // case CSRRS:
            // return 0b00010011;

            // case CSRRC:
            // return 0b00010011;

            // case CSRRWI:
            // return 0b00010011;

            // case CSRRSI:
            // return 0b00010011;

            // case CSRRCI:
            // return 0b00010011;

            // //
            // // RV32M Standard Extension
            // //

            // case MUL:
            // return 0b00010011;

            // case MULH:
            // return 0b00010011;

            // case MULHSU:
            // return 0b00010011;

            // case MULHU:
            // return 0b00010011;

            // case DIV:
            // return 0b00010011;

            // case DIVU:
            // return 0b00010011;

            // case REM:
            // return 0b00010011;

            // case REMU:
            // return 0b00010011;

            // //
            // // C extension
            // //

            // case C_ADDI16SP:
            // return 0b00010011;

            // case C_LUI:
            // return 0b00010011;

            default:
                throw new RuntimeException("Unknown instruction! " + riscVInstruction);
        }
    }

    public static int getFunc3(RISCVInstruction riscVInstruction) {

        switch (riscVInstruction) {

            // case LUI:
            // return 0b00010011;

            // case AUIPC:
            // return 0b00010011;

            // case JAL:
            // return 0b01101111;

            case JALR:
                return 0b000;

            // case BEQ:
            // return 0b00010011;

            // case BNE:
            // return 0b00010011;

            case BLT:
                return 0b100;

            // case BGE:
            // return 0b00010011;

            // case BLTU:
            // return 0b00010011;

            // case BGEU:
            // return 0b00010011;

            // case LB:
            // return 0b00010011;

            // case LH:
            // return 0b00010011;

            case LW:
                return 0b010;

            // case LBU:
            // return 0b00010011;

            // case LHU:
            // return 0b00010011;

            // case SB:
            // return 0b00010011;

            // case SH:
            // return 0b00010011;

            case SW:
                return 0b010;

            case ADDI:
                return 0b000;

            // case SLTI:
            // return 0b00010011;

            // case SLTIU:
            // return 0b00010011;

            // case XORI:
            // return 0b00010011;

            // case ORI:
            // return 0b00010011;

            // case ANDI:
            // return 0b00010011;

            // case SLLI:
            // return 0b00010011;

            // case SRLI:
            // return 0b00010011;

            // case SRAI:
            // return 0b00010011;

            case ADD:
            return 0b000;

            // case SUB:
            // return 0b00010011;

            // case SLL:
            // return 0b00010011;

            // case SLT:
            // return 0b00010011;

            // case SLTU:
            // return 0b00010011;

            // case XOR:
            // return 0b00010011;

            // case SRL:
            // return 0b00010011;

            // case SRA:
            // return 0b00010011;

            // case OR:
            // return 0b00010011;

            // case AND:
            // return 0b00010011;

            // case FENCE:
            // return 0b00010011;

            // case FENCE_I:
            // return 0b00010011;

            // case ECALL:
            // return 0b00010011;

            // case EBREAK:
            // return 0b00010011;

            // case CSRRW:
            // return 0b00010011;

            // case CSRRS:
            // return 0b00010011;

            // case CSRRC:
            // return 0b00010011;

            // case CSRRWI:
            // return 0b00010011;

            // case CSRRSI:
            // return 0b00010011;

            // case CSRRCI:
            // return 0b00010011;

            // //
            // // RV32M Standard Extension
            // //

            // case MUL:
            // return 0b00010011;

            // case MULH:
            // return 0b00010011;

            // case MULHSU:
            // return 0b00010011;

            // case MULHU:
            // return 0b00010011;

            // case DIV:
            // return 0b00010011;

            // case DIVU:
            // return 0b00010011;

            // case REM:
            // return 0b00010011;

            // case REMU:
            // return 0b00010011;

            // //
            // // C extension
            // //

            // case C_ADDI16SP:
            // return 0b00010011;

            // case C_LUI:
            // return 0b00010011;

            default:
                throw new RuntimeException("Unknown instruction! " + riscVInstruction);
        }
    }

    public static int getFunc7(RISCVInstruction riscVInstruction) {

        switch (riscVInstruction) {

            //         case LUI:
    //         return 0b00010011;

    // case AUIPC:
    // return 0b00010011;

    // case JAL:
    // return 0b01101111;

// case JALR:
// return 0b00010011;

// case BEQ:
// return 0b00010011;

// case BNE:
// return 0b00010011;

// case BLT:
// return 0b100;

// case BGE:
// return 0b00010011;

// case BLTU:
// return 0b00010011;

// case BGEU:
// return 0b00010011;

// case LB:
// return 0b00010011;

// case LH:
// return 0b00010011;

// case LW:
// return 0b010;

// case LBU:
// return 0b00010011;

// case LHU:
// return 0b00010011;

// case SB:
// return 0b00010011;

// case SH:
// return 0b00010011;

// case SW:
// return 0b010;

// case ADDI:
// return 0b000;

// case SLTI:
// return 0b00010011;

// case SLTIU:
// return 0b00010011;

// case XORI:
// return 0b00010011;

// case ORI:
// return 0b00010011;

// case ANDI:
// return 0b00010011;

// case SLLI:
// return 0b00010011;

// case SRLI:
// return 0b00010011;

// case SRAI:
// return 0b00010011;

case ADD:
                return 0b0000000;

// case SUB:
// return 0b00010011;

// case SLL:
// return 0b00010011;

// case SLT:
// return 0b00010011;

// case SLTU:
// return 0b00010011;

// case XOR:
// return 0b00010011;

// case SRL:
// return 0b00010011;

// case SRA:
// return 0b00010011;

// case OR:
// return 0b00010011;

// case AND:
// return 0b00010011;

// case FENCE:
// return 0b00010011;

// case FENCE_I:
// return 0b00010011;

// case ECALL:
// return 0b00010011;

// case EBREAK:
// return 0b00010011;

// case CSRRW:
// return 0b00010011;

// case CSRRS:
// return 0b00010011;

// case CSRRC:
// return 0b00010011;

// case CSRRWI:
// return 0b00010011;

// case CSRRSI:
// return 0b00010011;

// case CSRRCI:
// return 0b00010011;

// //
// // RV32M Standard Extension
// //

// case MUL:
// return 0b00010011;

// case MULH:
// return 0b00010011;

// case MULHSU:
// return 0b00010011;

// case MULHU:
// return 0b00010011;

// case DIV:
// return 0b00010011;

// case DIVU:
// return 0b00010011;

// case REM:
// return 0b00010011;

// case REMU:
// return 0b00010011;

// //
// // C extension
// //

// case C_ADDI16SP:
// return 0b00010011;

// case C_LUI:
// return 0b00010011;

            default:
                throw new RuntimeException("Unknown instruction! " + riscVInstruction);
        }
    }

}
