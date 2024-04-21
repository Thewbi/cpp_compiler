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

    /** function return value */
    $v0(2),

    /** function return value */
    $v1(3),

    /** function arguments */
    $a0(4),

    /** function arguments */
    $a1(5),

    /** function arguments */
    $a2(6),

    /** function arguments */
    $a3(7),

    /** temporary variables */
    $t0(8),

    /** temporary variables */
    $t1(9),

    /** temporary variables */
    $t2(10),

    /** temporary variables */
    $t3(11),

    /** temporary variables */
    $t4(12),

    /** temporary variables */
    $t5(13),

    /** temporary variables */
    $t6(14),

    /** temporary variables */
    $t7(15),

    /** saved variables */
    $s0(16),

    /** saved variables */
    $s1(17),

    /** saved variables */
    $s2(18),

    /** saved variables */
    $s3(19),

    /** saved variables */
    $s4(20),

    /** saved variables */
    $s5(21),

    /** saved variables */
    $s6(22),

    /** saved variables */
    $s7(23),

    /** temporary variables */
    $t8(24),

    /** temporary variables */
    $t9(25),

    /** operating system (OS) temporary variables */
    $k0(26),

    /** operating system (OS) temporary variables */
    $k1(27),

    /** global pointer */
    $gp(28),

    /** stack pointer */
    $sp(29),

    /** frame pointer */
    $fp(30),

    /** function return address */
    $ra(31)

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

        throw new RuntimeException("Unknown register name: \"" + registerName + "\"");
    }
    
}
