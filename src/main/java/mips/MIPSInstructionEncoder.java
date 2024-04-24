package mips;

import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import common.IntegerParserUtil;

public class MIPSInstructionEncoder {

    private byte[] buffer;

    private int bufferIdx;

    public void encode(final MIPSRow mipsRow, final Map<String, Integer> labelMap) {

        String instruction = mipsRow.getInstruction();

        // ignore comments, preprocessor directives or empty lines
        if (StringUtils.isBlank(instruction)) {
            return;
        }

        // System.out.println("Encoding: " + mipsRow);
        // System.out.println("LabelMap: " + labelMap);

        // MIPSRow resolvedMipsRow = mipsRow;

        /*
         * // resolve pseudo instructions
         * //
         * // "A listing of standard RISC-V pseudoinstructions"
         * // https://github.com/riscv-non-isa/riscv-asm-manual/blob/master/riscv-asm.md
         * if (StringUtils.equalsIgnoreCase(instruction, MIPSInstruction.LI)) {
         * 
         * // li x15, 1 ---> addi x15, x0, 1
         * instruction = "addi";
         * 
         * final String register0 = mipsRow.getParameters().get(0).getRegister();
         * final String register1 = "x0";
         * final String expression = mipsRow.getParameters().get(1).getExpression();
         * 
         * MIPSRow resolvedMipsRow = synthesizeADDI(mipsRow, instruction, register0,
         * register1, expression);
         * System.out.println(resolvedMipsRow);
         * 
         * mipsRow.getChildren().add(resolvedMipsRow);
         * 
         * } else
         */

        /*
         * if (StringUtils.equalsIgnoreCase(instruction, MIPSInstruction.BGT)) {
         * 
         * // bgt a4, a5, -4 ---> blt x15 x14 -4
         * 
         * instruction = "blt";
         * 
         * MIPSRow resolvedMipsRow = new MIPSRow();
         * resolvedMipsRow.setInstruction(instruction);
         * resolvedMipsRow.setLine(mipsRow.getLine());
         * resolvedMipsRow.getBufferIdxs().addAll(mipsRow.getBufferIdxs());
         * 
         * //
         * MIPSRowParam MIPSRowParam = new MIPSRowParam();
         * MIPSRowParam.setRegister(mipsRow.getParameters().get(1).getRegister());
         * resolvedMipsRow.getParameters().add(MIPSRowParam);
         * 
         * //
         * MIPSRowParam = new MIPSRowParam();
         * MIPSRowParam.setRegister(mipsRow.getParameters().get(0).getRegister());
         * resolvedMipsRow.getParameters().add(MIPSRowParam);
         * 
         * //
         * MIPSRowParam = new MIPSRowParam();
         * MIPSRowParam.setExpression(mipsRow.getParameters().get(2).getExpression());
         * 
         * // convert label to offset
         * final String label = mipsRow.getParameters().get(2).getLabel();
         * if (StringUtils.isNotEmpty(label)) {
         * MIPSRowParam.setOffset(convertLabelToOffset(labelMap, label));
         * }
         * 
         * resolvedMipsRow.getParameters().add(MIPSRowParam);
         * 
         * System.out.println(resolvedMipsRow);
         * 
         * mipsRow.getChildren().add(resolvedMipsRow);
         * 
         * } else
         */

        // if (StringUtils.equalsIgnoreCase(instruction, "j")) {

        //     // j offset --> jal x0, offset

        //     instruction = "jal";

        //     final String register0 = "$0";

        //     MIPSRow resolvedMipsRow = synthesizeJAL(mipsRow, labelMap, instruction, register0);

        //     // System.out.println(resolvedMipsRow);

        //     mipsRow.getChildren().add(resolvedMipsRow);

        // } else if (StringUtils.equalsIgnoreCase(instruction, "jr")) {

        //     // jr x1 ---> jalr x0, 0(x1)

        //     instruction = "jalr";

        //     MIPSRow resolvedMipsRow = new MIPSRow();
        //     resolvedMipsRow.setInstruction(instruction);
        //     resolvedMipsRow.setLine(mipsRow.getLine());
        //     resolvedMipsRow.getBufferIdxs().addAll(mipsRow.getBufferIdxs());

        //     //
        //     MIPSRowParam MIPSRowParam = new MIPSRowParam();
        //     MIPSRowParam.setRegister("x0");
        //     resolvedMipsRow.getParameters().add(MIPSRowParam);

        //     //
        //     MIPSRowParam = new MIPSRowParam();
        //     MIPSRowParam.setRegister(mipsRow.getParameters().get(0).getRegister());
        //     resolvedMipsRow.getParameters().add(MIPSRowParam);

        //     //
        //     MIPSRowParam = new MIPSRowParam();
        //     MIPSRowParam.setOffset(0);
        //     MIPSRowParam.setExpression("0");
        //     resolvedMipsRow.getParameters().add(MIPSRowParam);

        //     System.out.println(resolvedMipsRow);

        //     mipsRow.getChildren().add(resolvedMipsRow);

        // } else if (StringUtils.equalsIgnoreCase(instruction, "mv")) {

        //     // mv a0, a5 ---> addi x10, x15, 0

        //     instruction = "addi";

        //     final String register0 = mipsRow.getParameters().get(0).getRegister();
        //     final String register1 = mipsRow.getParameters().get(1).getRegister();
        //     final String expression = "0";

        //     MIPSRow resolvedMipsRow = synthesizeADDI(mipsRow, instruction, register0, register1, expression);

        //     mipsRow.getChildren().add(resolvedMipsRow);

        // } else if (StringUtils.equalsIgnoreCase(instruction, "call")) {

        //     // fib: addi x1, x1, 1
        //     // call fib ---> jal x1, -4

        //     instruction = "jal";

        //     final String register0 = "x1";

        //     MIPSRow resolvedMipsRow = synthesizeJAL(mipsRow, labelMap, instruction, register0);

        //     System.out.println(resolvedMipsRow);

        //     mipsRow.getChildren().add(resolvedMipsRow);

        // }

        // 0x00e41025
        //
        // 00000000000000000000000000000000
        // 00000000000001000000000000000000
        // 00000000111000000000000000000000
        // 00000000000000000001000000000000
        // 00000000111001000001000000100101
        //
        // 00000000111000100010000000100101

        // 00e22025
        // 00000000111000100010000000100101

        // encode all rows
        //
        // if a row has children, the children are encoded instead of the row itself
        // this happens, when a pseudo instruction is replaced by one or more
        // real instructions
        if (CollectionUtils.isEmpty(mipsRow.getChildren())) {
            encodeMIPSRow(mipsRow, labelMap);
        } else {
            for (MIPSRow childMIPSRow : mipsRow.getChildren()) {
                int bufferIdx = encodeMIPSRow(childMIPSRow, labelMap);
                mipsRow.getBufferIdxs().add(bufferIdx);
            }
        }
    }

    private MIPSRow synthesizeJAL(final MIPSRow mipsRow, final Map<String, Integer> labelMap, String instruction,
            final String register0) {

        MIPSRow resolvedMipsRow = new MIPSRow();
        resolvedMipsRow.setInstruction(instruction);
        resolvedMipsRow.setLine(mipsRow.getLine());
        resolvedMipsRow.getBufferIdxs().addAll(mipsRow.getBufferIdxs());

        MIPSRowParam MIPSRowParam = new MIPSRowParam();
        MIPSRowParam.setRegister(register0);
        resolvedMipsRow.getParameters().add(MIPSRowParam);

        MIPSRowParam = new MIPSRowParam();
        MIPSRowParam param0 = mipsRow.getParameters().get(0);
        int offset = param0.getOffset();
        if (StringUtils.isNotBlank(param0.getLabel())) {
            offset = convertLabelToOffset(labelMap, param0.getLabel());
        }
        MIPSRowParam.setOffset(offset);
        resolvedMipsRow.getParameters().add(MIPSRowParam);
        return resolvedMipsRow;
    }

    private MIPSRow synthesizeADDI(final MIPSRow mipsRow, String instruction, final String register0,
            final String register1, final String expression) {

        MIPSRow resolvedMipsRow = new MIPSRow();
        resolvedMipsRow.setInstruction(instruction);
        resolvedMipsRow.setLine(mipsRow.getLine());
        resolvedMipsRow.getBufferIdxs().addAll(mipsRow.getBufferIdxs());

        MIPSRowParam MIPSRowParam = new MIPSRowParam();
        MIPSRowParam.setRegister(register0);
        resolvedMipsRow.getParameters().add(MIPSRowParam);

        MIPSRowParam = new MIPSRowParam();
        MIPSRowParam.setRegister(register1);
        resolvedMipsRow.getParameters().add(MIPSRowParam);

        MIPSRowParam = new MIPSRowParam();
        MIPSRowParam.setExpression(expression);
        resolvedMipsRow.getParameters().add(MIPSRowParam);

        return resolvedMipsRow;
    }

    private int convertLabelToOffset(final Map<String, Integer> labelMap, String label) {
        int labelBufferIdx = labelMap.get(label);
        return labelBufferIdx - bufferIdx;
    }

    private int encodeMIPSRow(final MIPSRow mipsRow, final Map<String, Integer> labelMap) {

        // // DEBUG
        // System.out.println(mipsRow);

        MIPSInstruction riscVInstruction = MIPSInstruction.valueOf(StringUtils.upperCase(mipsRow.getInstruction()));
        MIPSInstructionType riscVInstructionType = MIPSInstructionType.fromValue(riscVInstruction);

        switch (riscVInstructionType) {

            case R:
                return encodeR(mipsRow, riscVInstruction, riscVInstructionType);

            case I:
                return encodeI(mipsRow, riscVInstruction, riscVInstructionType, labelMap);

            // case F:
            // return encodeF(MIPSRow, riscVInstruction, riscVInstructionType);

            // case S:
            // return encodeS(MIPSRow, riscVInstruction, riscVInstructionType);

            // case B:
            // return encodeB(MIPSRow, riscVInstruction, riscVInstructionType);

            // case J:
            // return encodeJ(MIPSRow, riscVInstruction, riscVInstructionType);

            default:
                throw new RuntimeException("Unknown instruction type " + riscVInstructionType + "!");
        }
    }

    /*
     * private int encodeR(MIPSRow MIPSRow, MIPSInstruction riscVInstruction,
     * MIPSInstructionType riscVInstructionType) {
     * 
     * // opcode
     * int opcode = MIPSInstruction.getOpcode(riscVInstruction);
     * 
     * // rd
     * MIPSRowParam param1 = MIPSRow.getParameters().get(0);
     * int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
     * int rd = ((registerIndexParam1) << 7);
     * System.out.println("rd " + StringUtils.leftPad(Integer.toBinaryString(rd),
     * 12, '0'));
     * 
     * // funct3
     * int funct3 = MIPSInstruction.getFunc3(riscVInstruction);
     * funct3 <<= 12;
     * System.out.println("funct3 " +
     * StringUtils.leftPad(Integer.toBinaryString(funct3), 15, '0'));
     * 
     * // rs1
     * MIPSRowParam param2 = MIPSRow.getParameters().get(1);
     * int registerIndexParam2 = MIPSRegister.mapRegister(param2.getRegister());
     * int rs1 = ((registerIndexParam2) << 15);
     * System.out.println("rs1 " + StringUtils.leftPad(Integer.toBinaryString(rs1),
     * 20, '0'));
     * 
     * // rs2
     * MIPSRowParam param3 = MIPSRow.getParameters().get(2);
     * int registerIndexParam3 = MIPSRegister.mapRegister(param3.getRegister());
     * int rs2 = ((registerIndexParam3) << 20);
     * System.out.println("rs2 " + StringUtils.leftPad(Integer.toBinaryString(rs2),
     * 25, '0'));
     * 
     * // funct7
     * int funct7 = MIPSInstruction.getFunc7(riscVInstruction);
     * funct7 <<= 25;
     * System.out.println("funct7 " +
     * StringUtils.leftPad(Integer.toBinaryString(funct7), 25, '0'));
     * 
     * // assemble
     * int encoded = funct7 | rs2 | rs1 | funct3 | rd | opcode;
     * 
     * // // DEBUG
     * // String encodedBinary =
     * StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
     * // '0');
     * // System.out.println("encoded: " + encoded + " " +
     * // encodedBinary);
     * 
     * // DEBUG
     * System.out.println(IntegerParserUtil.hex(encoded));
     * 
     * MIPSRow.getBufferIdxs().add(bufferIdx);
     * 
     * int oldBufferIdx = bufferIdx;
     * IntegerParserUtil.insert(buffer, bufferIdx, encoded);
     * 
     * // DEBUG
     * int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer,
     * bufferIdx);
     * if (encodedInstruction != 0) {
     * System.out.println(IntegerParserUtil.hex(encodedInstruction));
     * }
     * 
     * bufferIdx += 4;
     * 
     * return oldBufferIdx;
     * }
     * 
     * private int encodeJ(MIPSRow MIPSRow, MIPSInstruction riscVInstruction,
     * MIPSInstructionType riscVInstructionType) {
     * 
     * // opcode
     * int opcode = MIPSInstruction.getOpcode(riscVInstruction);
     * 
     * // rd
     * MIPSRowParam param1 = MIPSRow.getParameters().get(0);
     * int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
     * int rd = ((registerIndexParam1) << 7);
     * 
     * // DEBUG
     * // String rs2Binary = StringUtils.leftPad(Integer.toBinaryString(rs2), 32,
     * // '0');
     * // System.out.println("rs2: " + rs2 + " " +
     * // rs2Binary);
     * 
     * // immediate
     * MIPSRowParam param2 = MIPSRow.getParameters().get(1);
     * //int immediateValue = IntegerParserUtil.parseInt(param2.getExpression());
     * int immediateValue = param2.getOffset();
     * 
     * int imm101 = ((immediateValue & 0b11111111110) << 20);
     * int imm11 = ((immediateValue & 0b100000000000) << 9);
     * int imm1912 = ((immediateValue & 0b11111111000000000000) << 0);
     * int imm20 = ((immediateValue & 0b100000000000000000000) << 11);
     * 
     * // assemble
     * int encoded = imm20 | imm101 | imm11 | imm1912 | rd | opcode;
     * 
     * // // DEBUG
     * // String encodedBinary =
     * StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
     * // '0');
     * // System.out.println("encoded: " + encoded + " " +
     * // encodedBinary);
     * 
     * // DEBUG
     * System.out.println(IntegerParserUtil.hex(encoded));
     * 
     * MIPSRow.getBufferIdxs().add(bufferIdx);
     * 
     * int oldBufferIdx = bufferIdx;
     * IntegerParserUtil.insert(buffer, bufferIdx, encoded);
     * 
     * // DEBUG
     * int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer,
     * bufferIdx);
     * if (encodedInstruction != 0) {
     * System.out.println(IntegerParserUtil.hex(encodedInstruction));
     * }
     * 
     * bufferIdx += 4;
     * 
     * return oldBufferIdx;
     * }
     * 
     * / * *
     * https://luplab.gitlab.io/rvcodecjs/#q=fee7cee3&abi=false&isa=AUTO
     * 
     * @param MIPSRow
     * 
     * @param riscVInstruction
     * 
     * @param riscVInstructionType
     * 
     * @return
     * /
     * private int encodeB(MIPSRow MIPSRow, MIPSInstruction riscVInstruction,
     * MIPSInstructionType riscVInstructionType) {
     * 
     * // opcode
     * int opcode = MIPSInstruction.getOpcode(riscVInstruction);
     * System.out.println("opcode " +
     * StringUtils.leftPad(Integer.toBinaryString(opcode), 7, '0'));
     * 
     * // funct3
     * int funct3 = MIPSInstruction.getFunc3(riscVInstruction);
     * funct3 <<= 12;
     * System.out.println("funct3 " +
     * StringUtils.leftPad(Integer.toBinaryString(funct3), 15, '0'));
     * 
     * // rs1
     * MIPSRowParam param1 = MIPSRow.getParameters().get(0);
     * int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
     * int rs1 = ((registerIndexParam1) << 15);
     * System.out.println("rs1 " + StringUtils.leftPad(Integer.toBinaryString(rs1),
     * 20, '0'));
     * 
     * // rs2
     * MIPSRowParam param2 = MIPSRow.getParameters().get(1);
     * int registerIndexParam2 = MIPSRegister.mapRegister(param2.getRegister());
     * int rs2 = ((registerIndexParam2) << 20);
     * System.out.println("rs2 " + StringUtils.leftPad(Integer.toBinaryString(rs2),
     * 25, '0'));
     * 
     * // immediate
     * MIPSRowParam param3 = MIPSRow.getParameters().get(2);
     * int immediateValue;
     * if (StringUtils.isNotBlank(param3.getExpression())) {
     * immediateValue = IntegerParserUtil.parseInt(param3.getExpression());
     * } else if (param3.getOffset() != 0) {
     * immediateValue = param3.getOffset();
     * } else {
     * throw new RuntimeException("Could not retrieve an immediate value!");
     * }
     * 
     * System.out.println("immediateValue " +
     * StringUtils.leftPad(Integer.toBinaryString(immediateValue), 32, '0'));
     * 
     * int imm11 = ((immediateValue & 0b100000000000) >> 4);
     * System.out.println("imm11 " +
     * StringUtils.leftPad(Integer.toBinaryString(imm11), 8, '0'));
     * 
     * int imm41 = ((immediateValue & 0b11110) << 7);
     * System.out.println("imm41 " +
     * StringUtils.leftPad(Integer.toBinaryString(imm41), 12, '0'));
     * 
     * int imm105 = ((immediateValue & 0b11111100000) << 20);
     * System.out.println("imm105 " +
     * StringUtils.leftPad(Integer.toBinaryString(imm105), 31, '0'));
     * 
     * int imm12 = ((immediateValue & 0b1000000000000) << 19);
     * System.out.println("imm12 " +
     * StringUtils.leftPad(Integer.toBinaryString(imm12), 32, '0'));
     * 
     * // assemble
     * int encoded = imm12 | imm105 | rs2 | rs1 | funct3 | imm41 | imm11 | opcode;
     * 
     * // DEBUG
     * System.out.println(IntegerParserUtil.hex(encoded));
     * 
     * // // DEBUG
     * // String encodedBinary =
     * StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
     * // '0');
     * // System.out.println("encoded: " + encoded + " " +
     * // encodedBinary);
     * 
     * // DEBUG
     * System.out.println(IntegerParserUtil.hex(encoded));
     * 
     * MIPSRow.getBufferIdxs().add(bufferIdx);
     * 
     * int oldBufferIdx = bufferIdx;
     * IntegerParserUtil.insert(buffer, bufferIdx, encoded);
     * 
     * // DEBUG
     * int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer,
     * bufferIdx);
     * if (encodedInstruction != 0) {
     * System.out.println(IntegerParserUtil.hex(encodedInstruction));
     * }
     * 
     * bufferIdx += 4;
     * 
     * return oldBufferIdx;
     * 
     * }
     * 
     * / * *
     * <pre>
     * sw ra, 28(sp)
     * 0x00112e23
     * </pre>
     * 
     * @param mipsRow
     * 
     * @param riscVInstruction
     * 
     * @param riscVInstructionType
     * /
     * private int encodeS(MIPSRow MIPSRow, MIPSInstruction riscVInstruction,
     * MIPSInstructionType riscVInstructionType) {
     * 
     * // opcode
     * int opcode = MIPSInstruction.getOpcode(riscVInstruction);
     * 
     * // funct3
     * int funct3 = MIPSInstruction.getFunc3(riscVInstruction);
     * funct3 <<= 12;
     * 
     * // rs2
     * MIPSRowParam param1 = MIPSRow.getParameters().get(0);
     * int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
     * int rs2 = ((registerIndexParam1) << 20);
     * 
     * // DEBUG
     * // String rs2Binary = StringUtils.leftPad(Integer.toBinaryString(rs2), 32,
     * // '0');
     * // System.out.println("rs2: " + rs2 + " " +
     * // rs2Binary);
     * 
     * // immediate
     * MIPSRowParam param2 = MIPSRow.getParameters().get(1);
     * int immediateValue = param2.getOffset();
     * int imm40 = ((immediateValue & 0b11111) << 7);
     * // String imm40Binary = StringUtils.leftPad(Integer.toBinaryString(imm40),
     * 32,
     * // '0');
     * // System.out.println("imm40: " + imm40 + " " +
     * // imm40Binary);
     * int imm115 = ((immediateValue & 0b1111100000) << 25);
     * 
     * // DEBUG
     * // String imm115Binary = StringUtils.leftPad(Integer.toBinaryString(imm115),
     * 32,
     * // '0');
     * // System.out.println("imm115: " + imm115 + " " +
     * // imm115Binary);
     * 
     * // rs1
     * int registerIndexParam2 = MIPSRegister.mapRegister(param2.getRegister());
     * // System.out.println("rs2: " + registerIndexParam2);
     * int rs1 = ((registerIndexParam2) << 15);
     * 
     * // DEBUG
     * // String rs1Binary = StringUtils.leftPad(Integer.toBinaryString(rs1), 32,
     * // '0');
     * // System.out.println("rs1: " + rs1 + " " +
     * // rs1Binary);
     * 
     * // assemble
     * int encoded = imm115 | rs2 | rs1 | funct3 | imm40 | opcode;
     * 
     * // // DEBUG
     * // String encodedBinary =
     * StringUtils.leftPad(Integer.toBinaryString(encoded), 32,
     * // '0');
     * // System.out.println("encoded: " + encoded + " " +
     * // encodedBinary);
     * 
     * // DEBUG
     * System.out.println(IntegerParserUtil.hex(encoded));
     * 
     * MIPSRow.getBufferIdxs().add(bufferIdx);
     * 
     * int oldBufferIdx = bufferIdx;
     * IntegerParserUtil.insert(buffer, bufferIdx, encoded);
     * 
     * // DEBUG
     * int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer,
     * bufferIdx);
     * if (encodedInstruction != 0) {
     * System.out.println(IntegerParserUtil.hex(encodedInstruction));
     * }
     * 
     * bufferIdx += 4;
     * 
     * return oldBufferIdx;
     * }
     */
    /**
     * <pre>
     * 0x02010413
     * ADDI x8, x2, 32
     * </pre>
     * 
     * @param MIPSRow
     * @param riscVInstruction
     * @param riscVInstructionType
     */
    private int encodeI(final MIPSRow MIPSRow, final MIPSInstruction riscVInstruction,
            final MIPSInstructionType riscVInstructionType, final Map<String, Integer> labelMap) {

        // System.out.println("Encoding: " + MIPSRow);

        // TODO: remember the index of the current byte in the output buffer where
        // this mipsRow has been assembled into.
        //
        // Store all indexes into the MIPSRow

        // opcode (6 bits)
        int opcode = MIPSInstruction.getOpcode(riscVInstruction);
        opcode = opcode << 26;
        //System.out.println("opcode:  " + StringUtils.leftPad(Integer.toBinaryString(opcode), 32, '0'));

        // int immediate = 0;
        // MIPSRowParam param1 = MIPSRow.getParameters().get(0);

        // if (param1.getRegister() != null) {
        //     int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
        //     immediate = registerIndexParam1;
        // } else {
        //     immediate = param1.getOffset();
        // }

        // System.out.println(StringUtils.leftPad(Integer.toBinaryString(immediate), 32, '0'));

        // rt (5 bits)
        MIPSRowParam param1 = MIPSRow.getParameters().get(0);
        int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
        int rt = registerIndexParam1 << 16;
        //System.out.println("rt:      " + StringUtils.leftPad(Integer.toBinaryString(rt), 32, '0'));

        // rs (5 bits)
        MIPSRowParam param2 = null;
        int rs = 0;
        if (MIPSRow.getParameters().size() >= 2) {
            param2 = MIPSRow.getParameters().get(1);

            if (param2.getRegister() != null) {
                int registerIndexParam2 = MIPSRegister.mapRegister(param2.getRegister());
                rs = registerIndexParam2 << 21;
            } else {
                rs = param2.getOffset();
            }

            //System.out.println("rs:      " + StringUtils.leftPad(Integer.toBinaryString(rs), 32, '0'));
        }

        // imm (16 bits)              lw $2, 80($0)

        int immediate = 0;

        if (MIPSRow.getParameters().size() >= 3) {

            MIPSRowParam param3 = MIPSRow.getParameters().get(2);
            
            if (StringUtils.isNotBlank(param3.getExpression())) {
                immediate = IntegerParserUtil.parseInt(param3.getExpression());
            } else {
                final String label = param3.getLabel();
                if (StringUtils.isNotEmpty(label)) {
                    immediate = convertLabelToOffset(labelMap, label);
                }
            }

        } else {

            immediate = param2.getOffset();

        }

        int imm = (immediate << 0) & 0xFFFF;
        //System.out.println("imm      " + StringUtils.leftPad(Integer.toBinaryString(imm), 32, '0'));

        // int rd = ((registerIndexParam1) << 7);

        // DEBUG
        // String rdBinary = StringUtils.leftPad(Integer.toBinaryString(rd), 32,
        // '0');
        // System.out.println("rd: " + rd + " " +
        // rdBinary);

        // // rs1
        // MIPSRowParam param2 = MIPSRow.getParameters().get(1);
        // int registerIndexParam2 = MIPSRegister.mapRegister(param2.getRegister());
        // int rs1 = ((registerIndexParam2) << 15);

        // DEBUG
        // String rs1Binary = StringUtils.leftPad(Integer.toBinaryString(rs1), 32,
        // '0');
        // System.out.println("rs1: " + rs1 + " " +
        // rs1Binary);

        // // immediate
        // int immediateValue = 0;

        // if (MIPSRow.getParameters().size() > 2) {
        // MIPSRowParam param3 = MIPSRow.getParameters().get(2);
        // String expression = param3.getExpression();
        // immediateValue = IntegerParserUtil.parseInt(expression);
        // } else {
        // immediateValue = MIPSRow.getParameters().get(1).getOffset();
        // }

        // int imm110 = ((immediateValue) << 20);

        // DEBUG
        // String imm110Binary = StringUtils.leftPad(Integer.toBinaryString(imm110), 32,
        // '0');
        // System.out.println("imm110: " + imm110 + " " +
        // imm110Binary);

        // assemble
        int encoded = opcode | rs | rt | imm;
        //int encoded = opcode | imm;

        // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded),
        // 32,
        // '0');
        // System.out.println("encoded: " + encoded + " " +
        // encodedBinary);

        // DEBUG
        System.out.println("encoded: " + IntegerParserUtil.hex(encoded));

        // MIPSRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // // DEBUG
        // int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer,
        // bufferIdx);
        // if (encodedInstruction != 0) {
        // System.out.println(IntegerParserUtil.hex(encodedInstruction));
        // }

        bufferIdx += 4;

        return oldBufferIdx;
    }

    private int encodeR(MIPSRow MIPSRow, MIPSInstruction riscVInstruction,
            MIPSInstructionType riscVInstructionType) {

        // System.out.println("Encoding: " + MIPSRow);

        // TODO: remember the index of the current byte in the output buffer where
        // this mipsRow has been assembled into.
        //
        // Store all indexes into the MIPSRow

        // opcode (6 bits)
        int opcode = MIPSInstruction.getOpcode(riscVInstruction);
        opcode = opcode << 26;
        //System.out.println(StringUtils.leftPad(Integer.toBinaryString(opcode), 32, '0'));

        // rd (5 bits)
        MIPSRowParam param1 = MIPSRow.getParameters().get(0);
        int registerIndexParam1 = MIPSRegister.mapRegister(param1.getRegister());
        int rd = (registerIndexParam1 & 0x1F) << 11;
        //System.out.println(StringUtils.leftPad(Integer.toBinaryString(rd), 32, '0'));

        // rs (5 bits)
        MIPSRowParam param2 = MIPSRow.getParameters().get(1);
        int registerIndexParam2 = MIPSRegister.mapRegister(param2.getRegister());
        int rs = (registerIndexParam2 & 0x1F) << 21;
        //System.out.println(StringUtils.leftPad(Integer.toBinaryString(rs), 32, '0'));

        // rt (5 bits)
        MIPSRowParam param3 = MIPSRow.getParameters().get(2);
        int registerIndexParam3 = MIPSRegister.mapRegister(param3.getRegister());
        int rt = (registerIndexParam3 & 0x1F) << 16;
        //System.out.println(StringUtils.leftPad(Integer.toBinaryString(rt), 32, '0'));

        // shamt
        int shamt = 0;

        // funct
        int funct = MIPSInstruction.getFunc(riscVInstruction);

        // assemble
        int encoded = opcode | rs | rt | rd | shamt | funct;

        // // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded),
        //         32,
        //         '0');
        // System.out.println("encoded: " + encoded + " " +
        //         encodedBinary);

        // // DEBUG
        // String encodedBinary = StringUtils.leftPad(Integer.toBinaryString(encoded), 32, '0');
        // System.out.println("encoded: " + encodedBinary);

        // DEBUG
        System.out.println("encoded: " + IntegerParserUtil.hex(encoded));

        // MIPSRow.getBufferIdxs().add(bufferIdx);

        int oldBufferIdx = bufferIdx;
        IntegerParserUtil.insert(buffer, bufferIdx, encoded);

        // // DEBUG
        // int encodedInstruction = IntegerParserUtil.retrieveIntegerFromBuffer(buffer,
        // bufferIdx);
        // if (encodedInstruction != 0) {
        // System.out.println(IntegerParserUtil.hex(encodedInstruction));
        // }

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
