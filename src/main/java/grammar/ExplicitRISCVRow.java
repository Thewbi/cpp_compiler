package grammar;

import riscv.RISCVInstruction;
import riscv.RISCVRegister;

public class ExplicitRISCVRow {

    private int pc;

    private RISCVInstruction riscVInstruction;

    private RISCVRegister rdRISCVRegister;

    private RISCVRegister rs1RISCVRegister;

    private RISCVRegister rs2RISCVRegister;

    private int immediate;

    @Override
    public String toString() {
        switch (riscVInstruction) {
            case JALR:
            case LW:
                return riscVInstruction + " " + rdRISCVRegister + ", " + immediate + "(" + rs1RISCVRegister + ")";
            case SW:
                return riscVInstruction + " " + rs2RISCVRegister + ", " + immediate + "(" + rs1RISCVRegister + ")";
            default:
                return riscVInstruction + " " + rdRISCVRegister + ", " + rs1RISCVRegister + ", " + immediate;
        }
    }

    public RISCVRegister getRs2RISCVRegister() {
        return rs2RISCVRegister;
    }

    public void setRs2RISCVRegister(RISCVRegister rs2riscvRegister) {
        rs2RISCVRegister = rs2riscvRegister;
    }

    public RISCVRegister getRs1RISCVRegister() {
        return rs1RISCVRegister;
    }

    public void setRs1RISCVRegister(RISCVRegister rs1riscvRegister) {
        rs1RISCVRegister = rs1riscvRegister;
    }

    public int getImmediate() {
        return immediate;
    }

    public void setImmediate(int immediate) {
        this.immediate = immediate;
    }

    public RISCVInstruction getRiscVInstruction() {
        return riscVInstruction;
    }

    public void setRiscVInstruction(RISCVInstruction riscVInstruction) {
        this.riscVInstruction = riscVInstruction;
    }

    public RISCVRegister getRdRISCVRegister() {
        return rdRISCVRegister;
    }

    public void setRdRISCVRegister(RISCVRegister rdRISCVRegister) {
        this.rdRISCVRegister = rdRISCVRegister;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

}
