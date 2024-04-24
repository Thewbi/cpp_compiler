package riscv;

import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import common.IntegerParserUtil;
import grammar.RISCVRow;
import grammar.RISCVRowParam;

public class RISCVInstructionEncoder {

    private byte[] buffer;

    private int bufferIdx;

    public void encode(final RISCVRow riscRow, final Map<String, Integer> labelMap) {

        String instruction = riscRow.getInstruction();

        // ignore comments, preprocessor directives or empty lines
        if (StringUtils.isBlank(instruction)) {
            return;
        }

        System.out.println("Encoding: " + riscRow);
        System.out.println("LabelMap: " + labelMap);

        // RISCVRow resolvedRiscRow = riscRow;

        // resolve pseudo instructions
        //
        // "A listing of standard RISC-V pseudoinstructions"
        // https://github.com/riscv-non-isa/riscv-asm-manual/blob/master/riscv-asm.md
        if (StringUtils.equalsIgnoreCase(instruction, "li")) {

            // li x15, 1 ---> addi x15, x0, 1
            instruction = "addi";

            final String register0 = riscRow.getParameters().get(0).getRegister();
            final String register1 = "x0";
            final String expression = riscRow.getParameters().get(1).getExpression();

            RISCVRow resolvedRiscRow = synthesizeADDI(riscRow, instruction, register0, register1, expression);
            System.out.println(resolvedRiscRow);

            riscRow.getChildren().add(resolvedRiscRow);

        } else if (StringUtils.equalsIgnoreCase(instruction, "bgt")) {

            // bgt a4, a5, -4 ---> blt x15 x14 -4

            instruction = "blt";

            RISCVRow resolvedRiscRow = new RISCVRow();
            resolvedRiscRow.setInstruction(instruction);
            resolvedRiscRow.setLine(riscRow.getLine());
            resolvedRiscRow.getBufferIdxs().addAll(riscRow.getBufferIdxs());

            // 
            RISCVRowParam riscVRowParam = new RISCVRowParam();
            riscVRowParam.setRegister(riscRow.getParameters().get(1).getRegister());
            resolvedRiscRow.getParameters().add(riscVRowParam);

            //
            riscVRowParam = new RISCVRowParam();
            riscVRowParam.setRegister(riscRow.getParameters().get(0).getRegister());
            resolvedRiscRow.getParameters().add(riscVRowParam);

            // 
            riscVRowParam = new RISCVRowParam();
            riscVRowParam.setExpression(riscRow.getParameters().get(2).getExpression());

            // convert label to offset
            final String label = riscRow.getParameters().get(2).getLabel();
            if (StringUtils.isNotEmpty(label)) {
                riscVRowParam.setOffset(convertLabelToOffset(labelMap, label));
            }

            resolvedRiscRow.getParameters().add(riscVRowParam);

            System.out.println(resolvedRiscRow);

            riscRow.getChildren().add(resolvedRiscRow);

        } else if (StringUtils.equalsIgnoreCase(instruction, "j")) {

            // j offset --> jal x0, offset

            instruction = "jal";

            final String register0 = "x0";

            RISCVRow resolvedRiscRow = synthesizeJAL(riscRow, labelMap, instruction, register0);

            System.out.println(resolvedRiscRow);

            riscRow.getChildren().add(resolvedRiscRow);

        } else if (StringUtils.equalsIgnoreCase(instruction, "jr")) {

            // jr x1 ---> jalr x0, 0(x1)

            instruction = "jalr";

            RISCVRow resolvedRiscRow = new RISCVRow();
            resolvedRiscRow.setInstruction(instruction);
            resolvedRiscRow.setLine(riscRow.getLine());
            resolvedRiscRow.getBufferIdxs().addAll(riscRow.getBufferIdxs());

            // 
            RISCVRowParam riscVRowParam = new RISCVRowParam();
            riscVRowParam.setRegister("x0");
            resolvedRiscRow.getParameters().add(riscVRowParam);

            //
            riscVRowParam = new RISCVRowParam();
            riscVRowParam.setRegister(riscRow.getParameters().get(0).getRegister());
            resolvedRiscRow.getParameters().add(riscVRowParam);

            // 
            riscVRowParam = new RISCVRowParam();
            riscVRowParam.setOffset(0);
            riscVRowParam.setExpression("0");
            resolvedRiscRow.getParameters().add(riscVRowParam);

            System.out.println(resolvedRiscRow);

            riscRow.getChildren().add(resolvedRiscRow);

        } else if (StringUtils.equalsIgnoreCase(instruction, "mv")) {

            // mv a0, a5 ---> addi x10, x15, 0

            instruction = "addi";

            final String register0 = riscRow.getParameters().get(0).getRegister();
            final String register1 = riscRow.getParameters().get(1).getRegister();
            final String expression = "0";

            RISCVRow resolvedRiscRow = synthesizeADDI(riscRow, instruction, register0, register1, expression);

            riscRow.getChildren().add(resolvedRiscRow);

        } else if (StringUtils.equalsIgnoreCase(instruction, "call")) {

            // fib: addi x1, x1, 1
            //      call fib        ---> jal x1, -4

            instruction = "jal";

            final String register0 = "x1";

            RISCVRow resolvedRiscRow = synthesizeJAL(riscRow, labelMap, instruction, register0);

            System.out.println(resolvedRiscRow);

            riscRow.getChildren().add(resolvedRiscRow);

        }

        // encode all rows
        //
        // if a row has children, the children are encoded instead of the row itself
        // this happens, when a pseudo instruction is replaced by one or more 
        // real instructions
        if (CollectionUtils.isEmpty(riscRow.getChildren())) {
            encodeRiscVRow(riscRow);
        } else {
            for (RISCVRow childRiscVRow : riscRow.getChildren()) {
                int bufferIdx = encodeRiscVRow(childRiscVRow);
                riscRow.getBufferIdxs().add(bufferIdx);
            }
        }
        
    }

    private RISCVRow synthesizeJAL(final RISCVRow riscRow, final Map<String, Integer> labelMap, String instruction,
            final String register0) {

        RISCVRow resolvedRiscRow = new RISCVRow();
        resolvedRiscRow.setInstruction(instruction);
        resolvedRiscRow.setLine(riscRow.getLine());
        resolvedRiscRow.getBufferIdxs().addAll(riscRow.getBufferIdxs());

        RISCVRowParam riscVRowParam = new RISCVRowParam();
        riscVRowParam.setRegister(register0);
        resolvedRiscRow.getParameters().add(riscVRowParam);

        riscVRowParam = new RISCVRowParam();
        RISCVRowParam param0 = riscRow.getParameters().get(0);
        int offset = param0.getOffset();
        if (StringUtils.isNotBlank(param0.getLabel())) {
            offset = convertLabelToOffset(labelMap, param0.getLabel());
        }
        riscVRowParam.setOffset(offset);
        resolvedRiscRow.getParameters().add(riscVRowParam);
        return resolvedRiscRow;
    }

    private RISCVRow synthesizeADDI(final RISCVRow riscRow, String instruction, final String register0,
            final String register1, final String expression) {

        RISCVRow resolvedRiscRow = new RISCVRow();
        resolvedRiscRow.setInstruction(instruction);
        resolvedRiscRow.setLine(riscRow.getLine());
        resolvedRiscRow.getBufferIdxs().addAll(riscRow.getBufferIdxs());

        RISCVRowParam riscVRowParam = new RISCVRowParam();
        riscVRowParam.setRegister(register0);
        resolvedRiscRow.getParameters().add(riscVRowParam);

        riscVRowParam = new RISCVRowParam();
        riscVRowParam.setRegister(register1);
        resolvedRiscRow.getParameters().add(riscVRowParam);

        riscVRowParam = new RISCVRowParam();
        riscVRowParam.setExpression(expression);
        resolvedRiscRow.getParameters().add(riscVRowParam);

        return resolvedRiscRow;
    }

    private int convertLabelToOffset(final Map<String, Integer> labelMap, String label) {
        int labelBufferIdx = labelMap.get(label);
        return labelBufferIdx - bufferIdx;
    }

    private int encodeRiscVRow(RISCVRow riscVRow) {

        RISCVInstruction riscVInstruction = RISCVInstruction.valueOf(StringUtils.upperCase(riscVRow.getInstruction()));
        RISCVInstructionType riscVInstructionType = RISCVInstructionType.fromValue(riscVInstruction);

        switch (riscVInstructionType) {

            case R:
                return encodeR(riscVRow, riscVInstruction, riscVInstructionType);

            case I:
                return encodeI(riscVRow, riscVInstruction, riscVInstructionType);

            case S:
                return encodeS(riscVRow, riscVInstruction, riscVInstructionType);

            case B:
                return encodeB(riscVRow, riscVInstruction, riscVInstructionType);

            case J:
                return encodeJ(riscVRow, riscVInstruction, riscVInstructionType);

            default:
                throw new RuntimeException("Unknown instruction type " + riscVInstructionType + "!");
        }
    }

    private int encodeR(RISCVRow riscVRow, RISCVInstruction riscVInstruction,
            RISCVInstructionType riscVInstructionType) {

        // opcode
        int opcode = RISCVInstruction.getOpcode(riscVInstruction);

        // rd
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());
        int rd = ((registerIndexParam1) << 7);
        System.out.println("rd " + StringUtils.leftPad(Integer.toBinaryString(rd), 12, '0'));

        // funct3
        int funct3 = RISCVInstruction.getFunc3(riscVInstruction);
        funct3 <<= 12;
        System.out.println("funct3 " + StringUtils.leftPad(Integer.toBinaryString(funct3), 15, '0'));

        // rs1
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());
        int rs1 = ((registerIndexParam2) << 15);
        System.out.println("rs1 " + StringUtils.leftPad(Integer.toBinaryString(rs1), 20, '0'));

        // rs2
        RISCVRowParam param3 = riscVRow.getParameters().get(2);
        int registerIndexParam3 = RISCVRegister.mapRegister(param3.getRegister());
        int rs2 = ((registerIndexParam3) << 20);
        System.out.println("rs2 " + StringUtils.leftPad(Integer.toBinaryString(rs2), 25, '0'));

        // funct7
        int funct7 = RISCVInstruction.getFunc7(riscVInstruction);
        funct7 <<= 25;
        System.out.println("funct7 " + StringUtils.leftPad(Integer.toBinaryString(funct7), 25, '0'));

        // assemble
        int encoded = funct7 | rs2 | rs1 | funct3 | rd | opcode;

        // // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
        //         '0');
        // System.out.println("encoded: " + encoded + " " +
        //         encodedBinary);

        // DEBUG
        System.out.println(IntegerParserUtil.hex(encoded));

        riscVRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // DEBUG
        int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer, bufferIdx);
        if (encodedInstruction != 0) {
            System.out.println(IntegerParserUtil.hex(encodedInstruction));
        }

        bufferIdx += 4;

        return oldBufferIdx;
    }

    private int encodeJ(RISCVRow riscVRow, RISCVInstruction riscVInstruction,
            RISCVInstructionType riscVInstructionType) {
        
        // opcode
        int opcode = RISCVInstruction.getOpcode(riscVInstruction);

        // rd
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());
        int rd = ((registerIndexParam1) << 7);

        // DEBUG
        // String rs2Binary = StringUtils.leftPad(Integer.toBinaryString(rs2), 32,
        //         '0');
        // System.out.println("rs2: " + rs2 + " " +
        // rs2Binary);

        // immediate
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        //int immediateValue = IntegerParserUtil.parseInt(param2.getExpression());
        int immediateValue = param2.getOffset();

        int imm101 =  ((immediateValue & 0b11111111110) << 20);
        int imm11 =   ((immediateValue & 0b100000000000) << 9);
        int imm1912 = ((immediateValue & 0b11111111000000000000) << 0);
        int imm20 =   ((immediateValue & 0b100000000000000000000) << 11);

        // assemble
        int encoded = imm20 | imm101 | imm11 | imm1912 | rd | opcode;

        // // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
        //         '0');
        // System.out.println("encoded: " + encoded + " " +
        //         encodedBinary);

        // DEBUG
        System.out.println(IntegerParserUtil.hex(encoded));

        riscVRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // DEBUG
        int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer, bufferIdx);
        if (encodedInstruction != 0) {
            System.out.println(IntegerParserUtil.hex(encodedInstruction));
        }

        bufferIdx += 4;

        return oldBufferIdx;
    }

    /**
     * https://luplab.gitlab.io/rvcodecjs/#q=fee7cee3&abi=false&isa=AUTO
     * 
     * @param riscVRow
     * @param riscVInstruction
     * @param riscVInstructionType
     * @return
     */
    private int encodeB(RISCVRow riscVRow, RISCVInstruction riscVInstruction,
            RISCVInstructionType riscVInstructionType) {

        // opcode
        int opcode = RISCVInstruction.getOpcode(riscVInstruction);
        System.out.println("opcode " + StringUtils.leftPad(Integer.toBinaryString(opcode), 7, '0'));

        // funct3
        int funct3 = RISCVInstruction.getFunc3(riscVInstruction);
        funct3 <<= 12;
        System.out.println("funct3 " + StringUtils.leftPad(Integer.toBinaryString(funct3), 15, '0'));

        // rs1
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());
        int rs1 = ((registerIndexParam1) << 15);
        System.out.println("rs1 " + StringUtils.leftPad(Integer.toBinaryString(rs1), 20, '0'));

        // rs2
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());
        int rs2 = ((registerIndexParam2) << 20);
        System.out.println("rs2 " + StringUtils.leftPad(Integer.toBinaryString(rs2), 25, '0'));

        // immediate
        RISCVRowParam param3 = riscVRow.getParameters().get(2);
        int immediateValue;
        if (StringUtils.isNotBlank(param3.getExpression())) {
            immediateValue = IntegerParserUtil.parseInt(param3.getExpression());
        } else if (param3.getOffset() != 0) {
            immediateValue = param3.getOffset();
        } else {
            throw new RuntimeException("Could not retrieve an immediate value!");
        }

        System.out.println("immediateValue " + StringUtils.leftPad(Integer.toBinaryString(immediateValue), 32, '0'));

        int imm11 = ((immediateValue & 0b100000000000) >> 4);
        System.out.println("imm11 " + StringUtils.leftPad(Integer.toBinaryString(imm11), 8, '0'));

        int imm41 = ((immediateValue & 0b11110) << 7);
        System.out.println("imm41 " + StringUtils.leftPad(Integer.toBinaryString(imm41), 12, '0'));

        int imm105 = ((immediateValue & 0b11111100000) << 20);
        System.out.println("imm105 " + StringUtils.leftPad(Integer.toBinaryString(imm105), 31, '0'));

        int imm12 = ((immediateValue & 0b1000000000000) << 19);
        System.out.println("imm12 " + StringUtils.leftPad(Integer.toBinaryString(imm12), 32, '0'));

        // assemble
        int encoded = imm12 | imm105 | rs2 | rs1 | funct3 | imm41 | imm11 | opcode;

        // DEBUG
        System.out.println(IntegerParserUtil.hex(encoded));

        // // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
        //         '0');
        // System.out.println("encoded: " + encoded + " " +
        //         encodedBinary);

        // DEBUG
        System.out.println(IntegerParserUtil.hex(encoded));

        riscVRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // DEBUG
        int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer, bufferIdx);
        if (encodedInstruction != 0) {
            System.out.println(IntegerParserUtil.hex(encodedInstruction));
        }

        bufferIdx += 4;

        return oldBufferIdx;
                
    }

    /**
     * <pre>
     * sw ra, 28(sp)
     * 0x00112e23
     * </pre>
     * 
     * @param riscRow
     * @param riscVInstruction
     * @param riscVInstructionType
     */
    private int encodeS(RISCVRow riscVRow, RISCVInstruction riscVInstruction,
            RISCVInstructionType riscVInstructionType) {

        // opcode
        int opcode = RISCVInstruction.getOpcode(riscVInstruction);

        // funct3
        int funct3 = RISCVInstruction.getFunc3(riscVInstruction);
        funct3 <<= 12;

        // rs2
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());
        int rs2 = ((registerIndexParam1) << 20);

        // DEBUG
        // String rs2Binary = StringUtils.leftPad(Integer.toBinaryString(rs2), 32,
        //         '0');
        // System.out.println("rs2: " + rs2 + " " +
        // rs2Binary);

        // immediate
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int immediateValue = param2.getOffset();
        int imm40 = ((immediateValue & 0b11111) << 7);
        // String imm40Binary = StringUtils.leftPad(Integer.toBinaryString(imm40), 32,
        //         '0');
        // System.out.println("imm40: " + imm40 + " " +
        //         imm40Binary);
        int imm115 = ((immediateValue & 0b1111100000) << 25);

        // DEBUG
        // String imm115Binary = StringUtils.leftPad(Integer.toBinaryString(imm115), 32,
        //         '0');
        // System.out.println("imm115: " + imm115 + " " +
        //         imm115Binary);

        // rs1
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());
        // System.out.println("rs2: " + registerIndexParam2);
        int rs1 = ((registerIndexParam2) << 15);

        // DEBUG
        // String rs1Binary = StringUtils.leftPad(Integer.toBinaryString(rs1), 32,
        //         '0');
        // System.out.println("rs1: " + rs1 + " " +
        //         rs1Binary);

        // assemble
        int encoded = imm115 | rs2 | rs1 | funct3 | imm40 | opcode;

        // // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
        //         '0');
        // System.out.println("encoded: " + encoded + " " +
        //         encodedBinary);

        // DEBUG
        System.out.println(IntegerParserUtil.hex(encoded));

        riscVRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // DEBUG
        int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer, bufferIdx);
        if (encodedInstruction != 0) {
            System.out.println(IntegerParserUtil.hex(encodedInstruction));
        }

        bufferIdx += 4;

        return oldBufferIdx;
    }

    /**
     * <pre>
     * 0x02010413
     * ADDI x8, x2, 32
     * </pre>
     * 
     * @param riscVRow
     * @param riscVInstruction
     * @param riscVInstructionType
     */
    private int encodeI(RISCVRow riscVRow, RISCVInstruction riscVInstruction,
            RISCVInstructionType riscVInstructionType) {

        System.out.println("Encoding: " + riscVRow);

        // TODO: remember the index of the current byte in the output buffer where
        // this riscRow has been assembled into.
        //
        // Store all indexes into the RISCVRow

        // opcode
        int opcode = RISCVInstruction.getOpcode(riscVInstruction);

        // funct3
        int funct3 = RISCVInstruction.getFunc3(riscVInstruction);
        funct3 <<= 12;

        // rd
        RISCVRowParam param1 = riscVRow.getParameters().get(0);
        int registerIndexParam1 = RISCVRegister.mapRegister(param1.getRegister());
        int rd = ((registerIndexParam1) << 7);

        // DEBUG
        // String rdBinary = StringUtils.leftPad(Integer.toBinaryString(rd), 32,
        //         '0');
        // System.out.println("rd: " + rd + " " +
        //         rdBinary);

        // rs1
        RISCVRowParam param2 = riscVRow.getParameters().get(1);
        int registerIndexParam2 = RISCVRegister.mapRegister(param2.getRegister());
        int rs1 = ((registerIndexParam2) << 15);

        // DEBUG
        // String rs1Binary = StringUtils.leftPad(Integer.toBinaryString(rs1), 32,
        //         '0');
        // System.out.println("rs1: " + rs1 + " " +
        //         rs1Binary);

        // immediate
        int immediateValue = 0;

        if (riscVRow.getParameters().size() > 2) {
            RISCVRowParam param3 = riscVRow.getParameters().get(2);
            String expression = param3.getExpression();
            immediateValue = IntegerParserUtil.parseInt(expression);
        } else {
            immediateValue = riscVRow.getParameters().get(1).getOffset();
        }
        
        int imm110 = ((immediateValue) << 20);

        // DEBUG
        // String imm110Binary = StringUtils.leftPad(Integer.toBinaryString(imm110), 32,
        //         '0');
        // System.out.println("imm110: " + imm110 + " " +
        //         imm110Binary);

        // assemble
        int encoded = imm110 | rs1 | funct3 | rd | opcode;

        // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
        //         '0');
        // System.out.println("encoded: " + encoded + " " +
        //         encodedBinary);

        // DEBUG
        System.out.println(IntegerParserUtil.hex(encoded));

        riscVRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // DEBUG
        int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer, bufferIdx);
        if (encodedInstruction != 0) {
            System.out.println(IntegerParserUtil.hex(encodedInstruction));
        }

        bufferIdx += 4;

        return oldBufferIdx;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

}
