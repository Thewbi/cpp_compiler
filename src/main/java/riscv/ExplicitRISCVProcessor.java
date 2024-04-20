package riscv;

import java.util.ArrayList;
import java.util.List;

import grammar.ExplicitRISCVRow;

/**
 * 
 */
public class ExplicitRISCVProcessor extends BaseRISCVProcessor {

    private List<ExplicitRISCVRow> rows = new ArrayList<>();

    /**
     * ctor
     */
    public ExplicitRISCVProcessor() {

        // initialize stack pointer
        registerFile[RISCVRegister.mapRegister("sp")] = 1024;

        // for the fibonacci example
        idx = 37;
    }

    public List<ExplicitRISCVRow> getRows() {
        return rows;
    }

    public boolean isDone() {
        return idx >= rows.size();
    }

    public void processRow() {

        ExplicitRISCVRow riscVRow = rows.get(idx);

        // DEBUG
        RISCVInstruction instruction = riscVRow.getRiscVInstruction();
        //System.out.println(instruction);
        System.out.println(riscVRow);

        processRow(riscVRow);
    }

    public void processRow(ExplicitRISCVRow riscVRow) {

        RISCVInstruction riscVInstruction = riscVRow.getRiscVInstruction();

        // https://msyksphinz-self.github.io/riscv-isadoc/html/index.html
        switch (riscVInstruction) {

            case ADD:
                processADD(riscVRow);
                break;

            case ADDI:
                processADDI(riscVRow);
                break;

            // case AUIPC:
            // processAUIPC(riscVRow);
            // break;

            // case BGT:
            // processBGT(riscVRow);
            // break;

            case BLT:
                processBLT(riscVRow);
                break;

            case SW:
                processSW(riscVRow);
                break;

            // case LI:
            // processLI(riscVRow);
            // break;

            case LW:
                processLW(riscVRow);
                break;

            // case CALL:
            // processCALL(riscVRow);
            // break;

            // case MV:
            // processMV(riscVRow);
            // break;

            // case JR:
            //     processJR(riscVRow);
            //     break;

            // case J:
            // processJ(riscVRow);
            // break;

            case JAL:
                processJAL(riscVRow);
                break;

            case JALR:
                processJALR(riscVRow);
                break;

            default:
                throw new RuntimeException("Cannot execute unknown instruction: " + riscVInstruction);

        }

    }

    /**
     * The indirect jump instruction JALR (jump and link register) uses the I-type
     * encoding. The target
     * address is obtained by adding the 12-bit signed I-immediate to the register
     * rs1, then setting the
     * least-significant bit of the result to zero. The address of the instruction
     * following the jump (pc+4)
     * is written to register rd.
     * 
     * @param riscVRow
     */
    private void processJALR(ExplicitRISCVRow riscVRow) {

        // link register will contain the return address
        RISCVRegister rd = riscVRow.getRdRISCVRegister();

        RISCVRegister rs1 = riscVRow.getRs1RISCVRegister();

        int imm = riscVRow.getImmediate();

        // store return address
        registerFile[rd.getNumVal()] = idx + 4 / 4;

        idx = idx + (registerFile[rs1.getNumVal()] / 4) + (imm / 4);
    }

    /**
     * https://riscv.org/wp-content/uploads/2017/05/riscv-spec-v2.2.pdf
     * page 15
     * 
     * The jump and link (JAL) instruction uses the J-type format, where the
     * J-immediate encodes a
     * signed offset in multiples of 2 bytes. The offset is sign-extended and added
     * to the pc to form the
     * jump target address.
     * 
     * Jumps can therefore target a ±1 MiB range. JAL stores the address of the
     * instruction following the jump (pc+4) into register rd
     * 
     * <pre>
     * JAL x0, 48
     * </pre>
     * 
     * @param riscVRow
     */
    private void processJAL(ExplicitRISCVRow riscVRow) {

        // link register will contain the return address
        RISCVRegister rd = riscVRow.getRdRISCVRegister();

        int imm = riscVRow.getImmediate();

        // store return address
        registerFile[rd.getNumVal()] = idx + 4 / 4;

        idx = idx + imm / 4;
    }

    // private void processJR(ExplicitRISCVRow riscVRow) {
    // }

    /**
     * https://riscv.org/wp-content/uploads/2017/05/riscv-spec-v2.2.pdf
     * page 31
     * 
     * The LD instruction loads a 64-bit value from memory into register rd for
     * RV64I.
     * 
     * <pre>
     * lw dst, off(src) => dst[31:0] = M[src + off]
     * <pre>
     * 
     * <pre>
     * LW x14, -20(x8)
     * </pre>
     * 
     * @param riscVRow
     */
    private void processLW(ExplicitRISCVRow riscVRow) {

        // destination register
        RISCVRegister rd = riscVRow.getRdRISCVRegister();

        // source register
        RISCVRegister rs1 = riscVRow.getRs1RISCVRegister();

        // offset
        int offset = riscVRow.getImmediate();

        int sourceAddress = registerFile[rs1.getNumVal()] + offset;

        registerFile[rd.getNumVal()] = memory[sourceAddress];

        idx++;
    }

    /**
     * https://riscv.org/wp-content/uploads/2017/05/riscv-spec-v2.2.pdf
     * page 31
     * 
     * The SD, SW, SH, and SB instructions store 64-bit, 32-bit, 16-bit, and 8-bit
     * values from the low bits of register rs2 to memory
     * 
     * <pre>
     * sw src, off(dst) => M[dst + off] = src[31:0]
     * 
     * <pre>
     * 
     * @param riscVRow
     */
    private void processSW(ExplicitRISCVRow riscVRow) {

        // base
        RISCVRegister rs1 = riscVRow.getRs1RISCVRegister();

        // source
        RISCVRegister rs2 = riscVRow.getRs2RISCVRegister();

        // offset
        int offset = riscVRow.getImmediate();

        int targetAddress = registerFile[rs1.getNumVal()] + offset;
        // System.out.println(targetAddress);
        memory[targetAddress] = registerFile[rs2.getNumVal()];

        idx++;
    }

    /**
     * https://riscv.org/wp-content/uploads/2017/05/riscv-spec-v2.2.pdf
     * page 17
     * 
     * BLT and BLTU take the branch if rs1 is less than rs2, using
     * signed and unsigned comparison respectively.
     * 
     * <pre>
     * 00e7c663 BLT x15, x14, 12
     * </pre>
     * 
     * @param riscVRow
     */
    private void processBLT(ExplicitRISCVRow riscVRow) {

        RISCVRegister rs1 = riscVRow.getRs1RISCVRegister();
        RISCVRegister rs2 = riscVRow.getRs2RISCVRegister();
        int imm = riscVRow.getImmediate();

        int lhs = registerFile[rs1.getNumVal()];
        int rhs = registerFile[rs2.getNumVal()];

        if (lhs < rhs) {
            idx = idx + imm / 4;
        } else {
            idx++;
        }
    }

    private void processADDI(ExplicitRISCVRow riscVRow) {

        RISCVRegister rd = riscVRow.getRdRISCVRegister();
        RISCVRegister rs1 = riscVRow.getRs1RISCVRegister();
        int imm = riscVRow.getImmediate();

        registerFile[rd.getNumVal()] = registerFile[rs1.getNumVal()] + imm;

        idx++;
    }

    /**
     * https://riscv.org/wp-content/uploads/2017/05/riscv-spec-v2.2.pdf
     * page 15
     * 
     * ADD and SUB perform addition and subtraction respectively. Overflows are
     * ignored and the low XLEN bits of results are written to the destination.
     * 
     * @param riscVRow
     */
    private void processADD(ExplicitRISCVRow riscVRow) {

        RISCVRegister rd = riscVRow.getRdRISCVRegister();
        RISCVRegister rs1 = riscVRow.getRs1RISCVRegister();
        RISCVRegister rs2 = riscVRow.getRs2RISCVRegister();

        registerFile[rd.getNumVal()] = registerFile[rs1.getNumVal()] + registerFile[rs2.getNumVal()];

        idx++;
    }

}
