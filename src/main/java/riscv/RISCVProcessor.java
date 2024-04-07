package riscv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import common.IntegerParserUtil;
import grammar.RISCVRow;
import grammar.RISCVRowParam;

/**
 * https://shakti.org.in/docs/risc-v-asm-manual.pdf
 * https://www.cs.sfu.ca/~ashriram/Courses/CS295/assets/notebooks/RISCV/RISCV_CARD.pdf
 */
public class RISCVProcessor {

    private List<RISCVRow> rows = new ArrayList<>();

    private Map<String, Integer> labels = new HashMap<>();

    private int[] registerFile = new int[32];

    // private byte[] memory = new byte[1024];
    private int[] memory = new int[1024];

    private int idx = 0;

    private boolean done;

    /**
     * ctor
     */
    public RISCVProcessor() {

        // initialize stack pointer
        registerFile[RISCVRegister.mapRegister("sp")] = 1024;
    }

    public void processLabels() {

        int tempIdx = 0;
        for (RISCVRow row : rows) {

            if (StringUtils.isNotBlank(row.getLabel())) {

                if (labels.containsKey(row.getLabel())) {
                    throw new RuntimeException("Duplicate label: \"" + row.getLabel() + "\"");
                }
                labels.put(row.getLabel(), tempIdx);
            }

            tempIdx++;
        }
    }

    public void startAtLabel(String label) {

        idx = 0;

        if (labels.isEmpty()) {
            System.out.println("No labels found!");
            return;
        }
        if (!labels.containsKey(label)) {
            System.out.println("No label \"" + label + "\" found!");
            return;
        }

        idx = labels.get(label);
    }

    public void processRow() {

        RISCVRow row = rows.get(idx);
        String instructionAsString = row.getInstruction();

        if (StringUtils.isBlank(instructionAsString)) {
            idx++;
            return;
        }

        System.out.println(instructionAsString);

        processRow(row);
    }

    public void processRow(RISCVRow riscVRow) {

        if (StringUtils.isNotBlank(riscVRow.getInstruction())) {

            String instruction = StringUtils.upperCase(riscVRow.getInstruction());
            RISCVInstruction riscVInstruction = RISCVInstruction.valueOf(instruction);

            // https://msyksphinz-self.github.io/riscv-isadoc/html/index.html
            switch (riscVInstruction) {

                case ADDI:
                    processADDI(riscVRow);
                    break;

                case AUIPC:
                    processAUIPC(riscVRow);
                    break;

                case BGT:
                    processBGT(riscVRow);
                    break;

                case SW:
                    processSW(riscVRow);
                    break;

                case LI:
                    processLI(riscVRow);
                    break;

                case LW:
                    processLW(riscVRow);
                    break;

                case CALL:
                    processCALL(riscVRow);
                    break;

                case MV:
                    processMV(riscVRow);
                    break;

                case JR:
                    processJR(riscVRow);
                    break;

                case J:
                    processJ(riscVRow);
                    break;

                case JALR:
                    processJALR(riscVRow);
                    break;

                default:
                    throw new RuntimeException("Unknown instruction: " + riscVInstruction);

            }

        }

    }

    /**
     * <pre>
     * bgt rs, rt, offset
     * </pre>
     * 
     * @param riscVRow
     */
    private void processBGT(RISCVRow riscVRow) {

        // lhs register
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());
        int lhsValue = registerFile[registerIndexParam1];

        // rhs register
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());
        int rhsValue = registerFile[registerIndexParam2];

        int offset = 0;

        // offset register
        RISCVRowParam param3 = riscVRow.getParameters().get(2);
        String registerName = param3.getRegister();

        if (StringUtils.isNotEmpty(registerName)) {
            int registerIndexParam3 = RISCVRegister.mapRegister(registerName);
            offset = registerFile[registerIndexParam3];
        }

        if (StringUtils.isNotEmpty(param3.getLabel())) {
            if (!labels.containsKey(param3.getLabel())) {
                throw new RuntimeException("Unknown label: \"" + param3.getLabel() + "\"");
            }
            offset = labels.get(param3.getLabel());
        }

        if (lhsValue > rhsValue) {
            idx = idx + (offset / 4);
        } else {
            idx++;
        }
    }

    /**
     * Jump Register (JR) is a pseudo-instruction which translates to Jump and Link
     * Register (JALR) which jumps to the address and places the return address in a
     * general purpose register (GPR).
     * 
     * Syntax
     * 
     * <pre>
     * jr rs1
     * </pre>
     * 
     * where,
     * jr Jump Register (mnemonic)
     * rs1 Return Address (parameter 1)
     * 
     * @param riscVRow
     */
    private void processJR(RISCVRow riscVRow) {

        // System.out.println(riscVRow);

        // produce the current pc address
        // compute the next pc address
        // place the next pc address into the register given in parameter 2
        // perform the jump. The address to jump to is stored in the register given as
        // first parameter

        // throw new UnsupportedOperationException("Unimplemented method 'processJR'");

        RISCVRowParam param1 = riscVRow.getParameters().get(0);

        idx = registerFile[RISCVRegister.mapRegister(param1.getRegister())];
    }

    private void processJ(RISCVRow riscVRow) {

        RISCVRowParam param1 = riscVRow.getParameters().get(0);

        if (StringUtils.isNotEmpty(param1.getLabel())) {
            if (!labels.containsKey(param1.getLabel())) {
                throw new RuntimeException("Unknown label: \"" + param1.getLabel() + "\"");
            }

            // store return address
            registerFile[RISCVRegister.mapRegister("ra")] = idx + 1;

            // perform the jump
            idx = labels.get(param1.getLabel());

            return;
        }

        throw new RuntimeException("Not implemented! No implementation other than jumping to label present yet!");
    }

    /**
     * Jump and link register.
     * 
     * Return address (PC+4) goes into rd
     * Then performs jump to rs1 + imm
     * 
     * <pre>
     * jalr rd rs1 imm
     * rd = PC+4; PC = rs1 + imm
     * </pre>
     * 
     * https://stackoverflow.com/questions/58280089/risc-v-difference-between-jal-and-jalr
     * 
     * As we can see in specification (page 15), the main difference between jal and
     * jalr is the address value encoding. jal use immediate (20bits) encoding for
     * destination address and can jump +-1MiB range. And saves the actual address +
     * 4 in register rd. (x1 in your example). jalr usees indirect address (x1 in
     * your
     * example) plus a constant of 12bits (0 in your example). It saves the actual
     * address + 4 in register rd too. In your example you set x0 as return address
     * register because you don't care. When you return from subroutine for
     * example, the return address is not usefull then we set x0.
     * 
     * https://xiayingp.gitbook.io/build_a_os/hardware-device-assembly/risc-v-assembly
     * 
     * https://riscv.org/blog/2022/03/risc-v-rv32i-jalr-instruction-maven-silicon/
     * 
     * https://stackoverflow.com/questions/64695981/what-does-jalr-with-only-1-argument-and-offset-do
     * 
     * <pre>
     * jalr rs
     * </pre>
     * 
     * expands to
     * 
     * <pre>
     * jalr x1, rs, 0
     * </pre>
     * 
     * <pre>
     * jalr rs, imm
     * </pre>
     * 
     * expands to
     * 
     * <pre>
     * jalr x1, rs, imm
     * </pre>
     * 
     * he RISC-V Instruction Set Manual Volume I: User-Level ISA has a table of
     * pseudo-instructions, in which it says that jalr rs expands to jalr x1, rs, 0
     * (with x1 just being a different name for ra). So by extension, jalr rs, imm
     * ought to expand into jalr x1, rs, imm
     * 
     * @param riscVRow
     */
    private void processJALR(RISCVRow riscVRow) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processJALR'");
    }

    /**
     * (RV32I Base Instruction Set) Add Upper Immediate to Program Counter
     * 
     * AUIPC (add upper immediate to pc) is used to build pc-relative addresses and
     * uses the U-type format. AUIPC forms a 32-bit offset from the 20-bit
     * U-immediate, filling in the lowest 12 bits with zeros, adds this offset to
     * the pc, then places the result in register rd.
     * 
     * This means, the immediate value decoded from the 32 bit opcode is 20 bits
     * long. These 20 bits are treated as the uppermost 20 bits and the lowermost 12
     * bits are set to 0 which in total forms a 32 bit offset value. This offset
     * value is then added to the current PC value, the result is stored into the
     * destination register rd. PC remains untouched.
     * 
     * <pre>
     * auipc rd, imm
     * </pre>
     * 
     * <pre>
     * auipc rd, symbol[31:12]
     * </pre>
     * 
     * According to https://github.com/riscv/riscv-isa-manual/issues/144 when
     * implementing a RISCV assembler, the assembler has to perform some special
     * +1 trick which I have not fully understood yet!
     * 
     * <pre>
     * Thanks. I have read this document too.
     *
     * Eventually, I found out the trick that the RISC-V assembler does to deal with sign-extension of symbol[11:0]. When symbol[11] equals 1, it adds 1 to symbol[31:12]. This resets the high bits that were set to 1 as a result of sign-extension:
     *
     * auipc rd, symbol[31:12] + 1
     * addi rd, rd, symbol[11:0]
     * 
     * Probably, this is worth mentioning in the documentation.
     * </pre>
     * 
     * https://stackoverflow.com/questions/52574537/risc-v-pc-absolute-vs-pc-relative
     * 
     * Examples:
     * 
     * <pre>
     * auipc a0, 0x0
     * auipc ra, 0x0
     * </pre>
     * 
     * @param riscVRow
     */
    private void processAUIPC(RISCVRow riscVRow) {

        // destination register
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());

        // immediate value (assumption: this is a 32 bit value! The decoder has to
        // assemble this value from the 20 bits in the instruction!)
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int immediateValue = IntegerParserUtil.parseInt(param2.getExpression());

        registerFile[registerIndexParam1] = idx + immediateValue;

        idx++;
    }

    /**
     * https://inst.eecs.berkeley.edu/~cs61c/resources/RISCV_Calling_Convention.pdf
     * 
     * (Pseudo Instruction)
     * 
     * call offset
     * 
     * Call far-away subroutine
     * 
     * <pre>
     * jalr x1, x1, offset[11:0]
     * auipc x6, offset[31:12]
     * </pre>
     * 
     * @param riscVRow
     */
    private void processCALL(RISCVRow riscVRow) {

        System.out.println(riscVRow);

        // offset
        //
        // when a label is used, the immediate offset value is computed from that label.
        // The rule for computing the offset value from a label is to take the current
        // address stored inside the pc and build the relative offset between the pc and
        // the label's address: (label - pc)

        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        String paramt1Label = param1.getLabel();
        int labelOffset = labels.get(paramt1Label);
        int offsetImmediate = idx - labelOffset;

        System.out.println("Label: \"" + paramt1Label + "\" offsetImmediate: " + offsetImmediate);

        throw new UnsupportedOperationException("Unimplemented method 'processCALL'");
    }

    /**
     * pseudo instruction
     * 
     * <pre>
     * mv	a5,a0
     * </pre>
     * 
     * translation:
     * 
     * <pre>
     * addi rd, rs1, 0
     * </pre>
     * 
     * @param riscVRow
     */
    private void processMV(RISCVRow riscVRow) {

        // destination register
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());

        // source register
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());

        registerFile[registerIndexParam1] = registerFile[registerIndexParam2];

        idx++;
    }

    /**
     * <pre>
     * lw rd,offset(rs1)
     * </pre>
     * 
     * @param riscVRow
     */
    private void processLW(RISCVRow riscVRow) {

        // destination register
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());

        // source register
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());

        // offset
        int offset = param2.getOffset();

        int sourceAddress = registerFile[registerIndexParam2] + offset;

        registerFile[registerIndexParam1] = memory[sourceAddress];

        idx++;
    }

    /**
     * pseudoinstruction LI = lui addi
     * 
     * https://stackoverflow.com/questions/76331514/riscv-li-instruction
     * 
     * Hint: t2 is the ABI name for register x7
     * 
     * <pre>
     * li      t2, 0x1800
     * </pre>
     * 
     * is resolved to
     * 
     * <pre>
     * lui x7 2
     * addi x7 x7 -2048
     * </pre>
     * 
     * @param riscVRow
     */
    private void processLI(RISCVRow riscVRow) {

        // target register
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());

        // immediate value
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        String expression = param2.getExpression();
        int param2Value = Integer.parseInt(expression);

        registerFile[registerIndexParam1] = param2Value;

        idx++;
    }

    /**
     * load address pseudo instruction
     * 
     * https://github.com/riscv/riscv-isa-manual/issues/144
     * 
     * <pre>
     * auipc rd, symbol[31:12]
     * addi rd, rd, symbol[11:0]
     * </pre>
     * 
     * @param riscVRow
     */
    private void processLA(RISCVRow riscVRow) {

    }

    /**
     * LUI (load upper immediate)
     * 
     * @param riscVRow
     */
    private void processLUI(RISCVRow riscVRow) {

    }

    /**
     * <pre>
     * sw src, off(dst) => M[dst + off] = src[31:0]
     * 
     * <pre>
     * 
     * https://electronics.stackexchange.com/questions/554981/help-in-understanding-store-word-sw-instruction-in-risc-v
     * 
     * @param riscVRow
     */
    private void processSW(RISCVRow riscVRow) {

        // source
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());

        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());

        // offset
        int offset = param2.getOffset();

        int targetAddress = registerFile[registerIndexParam2] + offset;

        System.out.println(targetAddress);

        memory[targetAddress] = registerFile[registerIndexParam1];

        // throw new RuntimeException("Implement memory access (store operation)");

        idx++;
    }

    /**
     * <pre>
     * addi rd, rs1, rs2 => rd <- rs1 + rs2
     * </pre>
     * 
     * https://stackoverflow.com/questions/50687431/risc-v-addi-instruction
     * 
     * @param riscVRow
     */
    private void processADDI(RISCVRow riscVRow) {

        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());

        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());

        RISCVRowParam param3 = riscVRow.getParameters().get(2);
        String expression = param3.getExpression();
        int param3Value = Integer.parseInt(expression);

        registerFile[registerIndexParam1] = registerFile[registerIndexParam2] + param3Value;

        // System.out.println(registerFile[registerIndexParam1]);

        idx++;
    }

    public List<RISCVRow> getRows() {
        return rows;
    }

    public void setRows(List<RISCVRow> rows) {
        this.rows = rows;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
