package mips;

import org.apache.commons.lang3.StringUtils;

/**
 * Digital Design and Computer Architecture, David Money Harris & Sarah L. Harris, page 300
 */
public enum MIPSRegister {

    /** 0, the constant value zero */
    $0(0),

    /** 1, assembler temporary */
    $at(1),
    $1(1),

    /** function return value */
    $v0(2),
    $2(2),

    /** function return value */
    $v1(3),
    $3(3),

    /** function arguments */
    $a0(4),
    $4(4),

    /** function arguments */
    $a1(5),
    $5(5),

    /** function arguments */
    $a2(6),
    $6(6),

    /** function arguments */
    $a3(7),
    $7(7),

    /** temporary variables */
    $t0(8),
    $8(8),

    /** temporary variables */
    $t1(9),
    $9(9),

    /** temporary variables */
    $t2(10),
    $10(10),

    /** temporary variables */
    $t3(11),
    $11(11),

    /** temporary variables */
    $t4(12),
    $12(12),

    /** temporary variables */
    $t5(13),
    $13(13),

    /** temporary variables */
    $t6(14),
    $14(14),

    /** temporary variables */
    $t7(15),
    $15(15),

    /** saved variables */
    $s0(16),
    $16(16),

    /** saved variables */
    $s1(17),
    $17(17),

    /** saved variables */
    $s2(18),
    $18(18),

    /** saved variables */
    $s3(19),
    $19(19),

    /** saved variables */
    $s4(20),
    $20(20),

    /** saved variables */
    $s5(21),
    $21(21),

    /** saved variables */
    $s6(22),
    $22(22),

    /** saved variables */
    $s7(23),
    $23(23),

    /** temporary variables */
    $t8(24),
    $24(24),

    /** temporary variables */
    $t9(25),
    $25(25),

    /** operating system (OS) temporary variables */
    $k0(26),
    $26(26),

    /** operating system (OS) temporary variables */
    $k1(27),
    $27(27),

    /** global pointer */
    $gp(28),
    $28(28),

    /** stack pointer */
    $sp(29),
    $29(29),

    /** frame pointer */
    $fp(30),
    $30(30),

    /** function return address */
    $ra(31),
    $31(31)

    ;

    private int numVal;

    /**
     * ctor
     * 
     * @param numVal
     */
    MIPSRegister(final int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

    public static MIPSRegister fromValue(final int numVal) {

        switch (numVal) {

            case 0:
                return MIPSRegister.$0;

            case 1:
                return MIPSRegister.$at;

            case 2:
                return MIPSRegister.$v0;

            case 3:
                return MIPSRegister.$v1;

            case 4:
                return MIPSRegister.$a0;

            case 5:
                return MIPSRegister.$a1;

            case 6:
                return MIPSRegister.$a2;

            case 7:
                return MIPSRegister.$a3;

            case 8:
                return MIPSRegister.$t0;

            case 9:
                return MIPSRegister.$t1;

            case 10:
                return MIPSRegister.$t2;

            case 11:
                return MIPSRegister.$t3;

            case 12:
                return MIPSRegister.$t4;

            case 13:
                return MIPSRegister.$t5;

            case 14:
                return MIPSRegister.$t6;

            case 15:
                return MIPSRegister.$t7;

            case 16:
                return MIPSRegister.$s0;

            case 17:
                return MIPSRegister.$s1;

            case 18:
                return MIPSRegister.$s2;

            case 19:
                return MIPSRegister.$s3;

            case 20:
                return MIPSRegister.$s4;

            case 21:
                return MIPSRegister.$s5;

            case 22:
                return MIPSRegister.$s6;

            case 23:
                return MIPSRegister.$s7;

            case 24:
                return MIPSRegister.$t8;

            case 25:
                return MIPSRegister.$t9;

            case 26:
                return MIPSRegister.$k0;

            case 27:
                return MIPSRegister.$k1;

            case 28:
                return MIPSRegister.$gp;

            case 29:
                return MIPSRegister.$sp;

            case 30:
                return MIPSRegister.$fp;

            case 31:
                return MIPSRegister.$ra;

            default:
                throw new RuntimeException("unknown register!");
        }
    }

    public static int mapRegister(String registerName) {

        if (StringUtils.equalsIgnoreCase(registerName, "$0")) {
            return 0;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$at") | StringUtils.equalsIgnoreCase(registerName, "$1")) {
            return 1;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$v0") | StringUtils.equalsIgnoreCase(registerName, "$2")) {
            return 2;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$v1") | StringUtils.equalsIgnoreCase(registerName, "$3")) {
            return 3;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$a0") | StringUtils.equalsIgnoreCase(registerName, "$4")) {
            return 4;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$a1") | StringUtils.equalsIgnoreCase(registerName, "$5")) {
            return 5;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$a2") | StringUtils.equalsIgnoreCase(registerName, "$6")) {
            return 6;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$a3") | StringUtils.equalsIgnoreCase(registerName, "$7")) {
            return 7;
        }
        
        if (StringUtils.equalsIgnoreCase(registerName, "$t0") | StringUtils.equalsIgnoreCase(registerName, "$8")) {
            return 8;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t1") | StringUtils.equalsIgnoreCase(registerName, "$9")) {
            return 9;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t2") | StringUtils.equalsIgnoreCase(registerName, "$10")) {
            return 10;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t3") | StringUtils.equalsIgnoreCase(registerName, "$11")) {
            return 11;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t4") | StringUtils.equalsIgnoreCase(registerName, "$12")) {
            return 12;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t5") | StringUtils.equalsIgnoreCase(registerName, "$13")) {
            return 13;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t6") | StringUtils.equalsIgnoreCase(registerName, "$14")) {
            return 14;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t7") | StringUtils.equalsIgnoreCase(registerName, "$15")) {
            return 15;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s0") | StringUtils.equalsIgnoreCase(registerName, "$16")) {
            return 16;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s1") | StringUtils.equalsIgnoreCase(registerName, "$17")) {
            return 17;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s2") | StringUtils.equalsIgnoreCase(registerName, "$18")) {
            return 18;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s3") | StringUtils.equalsIgnoreCase(registerName, "$19")) {
            return 19;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s4") | StringUtils.equalsIgnoreCase(registerName, "$20")) {
            return 20;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s5") | StringUtils.equalsIgnoreCase(registerName, "$21")) {
            return 21;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s6") | StringUtils.equalsIgnoreCase(registerName, "$22")) {
            return 22;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$s7") | StringUtils.equalsIgnoreCase(registerName, "$23")) {
            return 23;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t8") | StringUtils.equalsIgnoreCase(registerName, "$24")) {
            return 24;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$t9") | StringUtils.equalsIgnoreCase(registerName, "$25")) {
            return 25;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$k0") | StringUtils.equalsIgnoreCase(registerName, "$26")) {
            return 26;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$k1") | StringUtils.equalsIgnoreCase(registerName, "$27")) {
            return 27;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$gp") | StringUtils.equalsIgnoreCase(registerName, "$28")) {
            return 28;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$sp") | StringUtils.equalsIgnoreCase(registerName, "$29")) {
            return 29;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$fp") | StringUtils.equalsIgnoreCase(registerName, "$30")) {
            return 30;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "$ra") | StringUtils.equalsIgnoreCase(registerName, "$31")) {
            return 31;
        }

        throw new RuntimeException("Unknown register name: \"" + registerName + "\"");
    }
    
}
