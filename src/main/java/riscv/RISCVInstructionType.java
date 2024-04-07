package riscv;

public enum RISCVInstructionType {

    R, // register/register

    I, // immediate

    S, // store

    B, // branch

    U, // upper immediate

    J; // jump

    public static RISCVInstructionType fromValue(final RISCVInstruction instruction) {

        switch (instruction) {

            case LUI:
                return U;

            case AUIPC:
                return U;

            case JAL:
                return J;

            case JALR:
                return I;

            case BEQ:
                return B;

            case BNE:
                return B;

            case BLT:
                return B;

            case BGE:
                return B;

            case BLTU:
                return B;

            case BGEU:
                return B;

            case LB:
                return I;

            case LH:
                return I;

            case LW:
                return I;

            case LBU:
                return I;

            case LHU:
                return I;

            case SB:
                return S;

            case SH:
                return S;

            case SW:
                return S;

            case ADDI:
                return I;

            case SLTI:
                return I;

            case SLTIU:
                return I;

            case XORI:
                return I;

            case ORI:
                return I;

            case ANDI:
                return I;

            case SLLI:
                return I;

            case SRLI:
                return I;

            case SRAI:
                return I;

            case ADD:
                return I;

            case SUB:
                return I;

            case SLL:
                return I;

            case SLT:
                return I;

            case SLTU:
                return I;

            case XOR:
                return I;

            case SRL:
                return I;

            case SRA:
                return I;

            case OR:
                return I;

            case AND:
                return I;

            case FENCE:
                return I;

            case FENCE_I:
                return I;

            case ECALL:
                return I;

            case EBREAK:
                return I;

            case CSRRW:
                return I;

            case CSRRS:
                return I;

            case CSRRC:
                return I;

            case CSRRWI:
                return I;

            case CSRRSI:
                return I;

            case CSRRCI:
                return I;

            default:
                throw new RuntimeException("unknown register!");
        }
    }

}
