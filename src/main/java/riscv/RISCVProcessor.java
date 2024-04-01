package riscv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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

        //throw new UnsupportedOperationException("Unimplemented method 'processJR'");

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
     * https://inst.eecs.berkeley.edu/~cs61c/resources/RISCV_Calling_Convention.pdf
     * 
     * pseudo instruction
     * 
     * @param riscVRow
     */
    private void processCALL(RISCVRow riscVRow) {

        System.out.println(riscVRow);

        throw new UnsupportedOperationException("Unimplemented method 'processCALL'");
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
     * <pre>
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
