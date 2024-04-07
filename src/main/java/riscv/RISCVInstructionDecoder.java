package riscv;

import org.apache.commons.lang3.StringUtils;

/**
 * https://marz.utk.edu/my-courses/cosc230/book/example-risc-v-assembly-programs/
 */
public class RISCVInstructionDecoder {

    public void decode() {

        // add t1,t0,a0
        // int data = 0x00a28333;
        // 101000101000001100110011
        // 00 01010 00101 000 00110 0110011

        // addi
        // int data = 0x3e800093;

        // addi
        // int data = 0xfe010113;

        // addi sp, sp, -16
        // int data = 0xff010113;
        // 11111111000000010000000100010011

        // addi
        // int data = 0x02010413;

        // ADDI
        // int data = 0xfec42703;
        // int data = 0x00100793;

        // SW
        // int data = 0x00112e23;

        // SW
        // int data = 0xfea42623;

        // BLT
        // int data = 0x00e7c663;

        // LW
        // int data = 0xfec42783;

        // JAL
        // int data = 0x0300006f;

        // int data = 0xfec42783;

        int[] dataAsArray = new int[256];
        int idx = 0;
        dataAsArray[idx++] = 0xfe010113; // ADDI x2, x2, -32
        dataAsArray[idx++] = 0x00112e23; // SW x1, 28(x2)
        dataAsArray[idx++] = 0x00812c23; // SW x8, 24(x2)
        dataAsArray[idx++] = 0x00912a23; // SW x9, 20(x2)
        dataAsArray[idx++] = 0x02010413; // ADDI x8, x2, 32
        dataAsArray[idx++] = 0xfea42623; // SW x10, -20(x8)
        dataAsArray[idx++] = 0xfec42703; // LW x14, -20(x8)
        dataAsArray[idx++] = 0x00100793; // ADDI x15, x0, 1
        dataAsArray[idx++] = 0x00e7c663; // BLT x14, x15, 12
        dataAsArray[idx++] = 0xfec42783; // LW x15, -20(x8)
        dataAsArray[idx++] = 0x0300006f; //
        dataAsArray[idx++] = 0xfec42783;
        dataAsArray[idx++] = 0xfff78793;
        dataAsArray[idx++] = 0x00078513;
        dataAsArray[idx++] = 0xfc9ff0ef;
        dataAsArray[idx++] = 0x00050493;
        dataAsArray[idx++] = 0xfec42783;
        dataAsArray[idx++] = 0xffe78793;
        dataAsArray[idx++] = 0x00078513;
        dataAsArray[idx++] = 0xfb5ff0ef;
        dataAsArray[idx++] = 0x00050793;
        dataAsArray[idx++] = 0x00f487b3;
        dataAsArray[idx++] = 0x00078513;
        dataAsArray[idx++] = 0x01c12083;
        dataAsArray[idx++] = 0x01812403;
        dataAsArray[idx++] = 0x01412483;
        dataAsArray[idx++] = 0x02010113;
        dataAsArray[idx++] = 0x00008067;
        dataAsArray[idx++] = 0xfe010113;
        dataAsArray[idx++] = 0x00812e23;
        dataAsArray[idx++] = 0x02010413;
        dataAsArray[idx++] = 0xfea42623;
        dataAsArray[idx++] = 0xfec42783;
        dataAsArray[idx++] = 0x00078513;
        dataAsArray[idx++] = 0x01c12403;
        dataAsArray[idx++] = 0x02010113;
        dataAsArray[idx++] = 0x00008067;
        dataAsArray[idx++] = 0xfe010113;
        dataAsArray[idx++] = 0x00112e23;
        dataAsArray[idx++] = 0x00812c23;
        dataAsArray[idx++] = 0x02010413;
        dataAsArray[idx++] = 0x00300793;
        dataAsArray[idx++] = 0xfef42623;
        dataAsArray[idx++] = 0xfec42503;
        dataAsArray[idx++] = 0xf51ff0ef;
        dataAsArray[idx++] = 0x00050793;
        dataAsArray[idx++] = 0x00078513;
        dataAsArray[idx++] = 0xfb5ff0ef;
        dataAsArray[idx++] = 0xfea42423;
        dataAsArray[idx++] = 0xfe842783;
        dataAsArray[idx++] = 0x00078513;
        dataAsArray[idx++] = 0x01c12083;
        dataAsArray[idx++] = 0x01812403;
        dataAsArray[idx++] = 0x02010113;
        dataAsArray[idx++] = 0x00008067;

        int lastIdx = idx;
        idx = 0;
        for (int data : dataAsArray) {

            if (idx >= lastIdx) {
                break;
            }
            idx++;

            String dataAsHexString = StringUtils.leftPad(Integer.toHexString(data), 8, '0');
            // System.out.println(dataAsHexString);

            // String encodedInstructionBinary =
            // StringUtils.leftPad(Integer.toBinaryString(data), 32, '0');
            // System.out.println(encodedInstructionBinary);

            // when the first 2 bits are 11, it designates a 32-bit instruction
            int lowerTwoBits = data & 0x03;
            if (lowerTwoBits != 0x03) {
                throw new RuntimeException("Not a 32 bit encoded instruction! ");
            }

            // opcode is seven bits (lowermost two bits are always 11 for 32 bit encoded
            // instructions)
            int opcode = ((data & 0x7F) >> 0);
            String opcodeBinary = StringUtils.leftPad(Integer.toBinaryString(opcode), 7, '0');
            // System.out.println("opcode: " + opcode + " " + opcodeBinary);

            // funct3 is 3 bits (hence the 3 in the name)
            int funct3 = ((data & 0x7000) >> 12);
            String funct3Binary = StringUtils.leftPad(Integer.toBinaryString(funct3), 3, '0');
            // System.out.println("funct3: " + funct3 + " " + funct3Binary);

            // funct7 is 7 bits (hence the 7 in the name)
            int funct7 = ((data & 0xFE000000) >> 25);
            String funct7Binary = StringUtils.leftPad(Integer.toBinaryString(funct7), 7, '0');
            // System.out.println("funct7: " + funct7 + " " + funct7Binary);

            RISCVInstruction riscVInstruction = findOpcode(opcode, funct3, funct7);
            // System.out.println(riscVInstruction);

            RISCVInstructionType riscVInstructionType = RISCVInstructionType.fromValue(riscVInstruction);

            switch (riscVInstructionType) {

                // case R

                case I: {
                    int imm110 = ((data & 0xFFF00000) >> 20);
                    int imm110Unsigned = imm110 & 0b00000000000000000000111111111111;
                    String imm110Binary = StringUtils.leftPad(Integer.toBinaryString(imm110), 12, '0');
                    // System.out.println("imm110: " + imm110 + " " + imm110Unsigned + " " +
                    // imm110Binary);

                    int rs1 = ((data & 0xF8000) >> 15);
                    String rs1Binary = StringUtils.leftPad(Integer.toBinaryString(rs1), 5, '0');
                    // System.out.println("rs1: " + rs1 + " " + rs1Binary);

                    RISCVRegister rs1RISCVRegister = RISCVRegister.fromValue(rs1);

                    int rd = ((data & 0xF80) >> 7);
                    String rdBinary = StringUtils.leftPad(Integer.toBinaryString(rd), 5, '0');
                    // System.out.println("rd: " + rd + " " + rdBinary);

                    RISCVRegister rdRISCVRegister = RISCVRegister.fromValue(rd);

                    switch (riscVInstruction) {
                        case LW:
                            System.out.println(dataAsHexString + " " + riscVInstruction + " " + rdRISCVRegister + ", "
                                    + imm110 + "(" + rs1RISCVRegister + ")");
                            break;

                        default:
                            System.out.println(dataAsHexString + " " + riscVInstruction + " " + rdRISCVRegister + ", "
                                    + rs1RISCVRegister + ", " + imm110);
                            break;
                    }

                }
                    break;

                case S: {
                    int imm115 = ((data & 0xFE000000) >> 25);
                    int imm115temp = ((data & 0xFE000000) >> 20);
                    int imm115Unsigned = imm115 & 0b00000000000000000000000001111111;
                    String imm115Binary = StringUtils.leftPad(Integer.toBinaryString(imm115temp), 7, '0');

                    int imm40 = ((data & 0xF80) >> 7);
                    int imm40Unsigned = imm40 & 0b00000000000000000000000001111111;
                    String imm40Binary = StringUtils.leftPad(Integer.toBinaryString(imm40), 5, '0');

                    // System.out.println(imm115Binary);
                    // System.out.println(imm115Binary + "." + imm40Binary);

                    int imm = imm115temp | imm40;
                    String immBinary = StringUtils.leftPad(Integer.toBinaryString(imm), 32, '0');
                    // System.out.println(immBinary);

                    int rs1 = ((data & 0xF8000) >> 15);
                    String rs1Binary = StringUtils.leftPad(Integer.toBinaryString(rs1), 5, '0');
                    RISCVRegister rs1RISCVRegister = RISCVRegister.fromValue(rs1);

                    int rs2 = ((data & 0x1F00000) >> 20);
                    String rs2Binary = StringUtils.leftPad(Integer.toBinaryString(rs2), 5, '0');
                    RISCVRegister rs2RISCVRegister = RISCVRegister.fromValue(rs2);

                    switch (riscVInstruction) {
                        case SW:
                            System.out.println(dataAsHexString + " " + riscVInstruction + " " + rs2RISCVRegister + ", "
                                    + imm + "(" + rs1RISCVRegister + ")");
                            break;

                        default:
                            System.out.println(dataAsHexString + " " + riscVInstruction + " " + rs2RISCVRegister + ", "
                                    + rs1RISCVRegister + ", " + imm);
                            break;
                    }

                }
                    break;

                // case B

                // case U

                case J:

                    String encodedInstructionBinary = StringUtils.leftPad(Integer.toBinaryString(data), 32, '0');
                    // System.out.println(encodedInstructionBinary);

                    int rd = ((data & 0xF80) >> 7);
                    // int imm40Unsigned = rd & 0b00000000000000000000000001111111;
                    // String rdBinary = StringUtils.leftPad(Integer.toBinaryString(rd), 5, '0');
                    RISCVRegister rdRISCVRegister = RISCVRegister.fromValue(rd);

                    int imm = ((data & 0xFFFFF000) >> 12);
                    String immBinary = StringUtils.leftPad(Integer.toBinaryString(imm), 20, '0');
                    // System.out.println(immBinary);

                    // imm[20|10:1|11|19:12]
                    //

                    // 8 bit
                    // imm[7:0] goes to imm[19:12], hence shifted 9 to the left
                    int imm19_12 = ((imm & 0xFF) << 11);

                    // 1 bit
                    // imm[9] goes to imm[11]
                    // int imm11 = ((imm & 0x100) >> 0);
                    int imm11 = ((imm & 0x100) << 2);

                    // 10 bit
                    // imm[19:9] goes to imm[10:1], hence shifted 1 to the left
                    int imm10_1 = ((imm & 0x7FE00) >> 8);
                    String imm10_1Binary = StringUtils.leftPad(Integer.toBinaryString(imm10_1), 20, '0');
                    // System.out.println(imm10_1Binary);

                    // 1 bit
                    // imm[20] goes to imm[20], hence no shift
                    int imm20 = ((imm & 0x80000) >> 0);

                    int immCombined = 0;
                    if (imm20 == 0) {
                        immCombined = imm20 | imm19_12 | imm11 | imm10_1;
                    } else {
                        immCombined = 0xFFF00000 | imm20 | imm19_12 | imm11 | imm10_1;
                    }

                    String immCombinedBinary = StringUtils.leftPad(Integer.toBinaryString(immCombined), 20, '0');
                    //System.out.println(immCombinedBinary);

                    System.out.println(
                            dataAsHexString + " " + riscVInstruction + " " + rdRISCVRegister + ", " + immCombined);
                    break;

                default:
                    throw new RuntimeException("idx: " + idx + " " + riscVInstruction);
            }
        }

    }

    private RISCVInstruction findOpcode(int opcode, int funct3, int funct7) {

        switch (opcode) {
            case 0b0110111:
                return RISCVInstruction.LUI;
            case 0b0010111:
                return RISCVInstruction.AUIPC;
            case 0b1101111:
                return RISCVInstruction.JAL;
            case 0b1100111:
                return RISCVInstruction.JALR;
            case 0b1100011:
                switch (funct3) {
                    case 0b000:
                        return RISCVInstruction.BEQ;
                    case 0b001:
                        return RISCVInstruction.BNE;
                    case 0b100:
                        return RISCVInstruction.BLT;
                    case 0b101:
                        return RISCVInstruction.BGE;
                    case 0b110:
                        return RISCVInstruction.BLTU;
                    case 0b111:
                        return RISCVInstruction.BGEU;
                    default:
                        throw new RuntimeException("Unknown opcode!");
                }
            case 0b0000011:
                switch (funct3) {
                    case 0b000:
                        return RISCVInstruction.LB;
                    case 0b001:
                        return RISCVInstruction.LH;
                    case 0b010:
                        return RISCVInstruction.LW;
                    case 0b100:
                        return RISCVInstruction.LBU;
                    case 0b101:
                        return RISCVInstruction.LHU;
                    default:
                        throw new RuntimeException("Unknown opcode!");
                }
            case 0b0100011:
                switch (funct3) {
                    case 0b000:
                        return RISCVInstruction.SB;
                    case 0b001:
                        return RISCVInstruction.SH;
                    case 0b010:
                        return RISCVInstruction.SW;
                    default:
                        throw new RuntimeException("Unknown opcode!");
                }
            case 0b0010011:
                switch (funct3) {
                    case 0b000:
                        return RISCVInstruction.ADDI;
                    default:
                        throw new RuntimeException("Unknown opcode!");
                }
            case 0b0110011:
                switch (funct3) {
                    case 0b000:
                        switch (funct7) {
                            case 0b0000000:
                                return RISCVInstruction.ADD;
                            default:
                                throw new RuntimeException("Unknown opcode!");
                        }
                    default:
                        throw new RuntimeException("Unknown opcode!");
                }
            default:
                throw new RuntimeException("Unknown opcode!");
        }
    }

}
