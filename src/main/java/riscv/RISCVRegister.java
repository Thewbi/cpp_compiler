package riscv;

import org.apache.commons.lang3.StringUtils;

public enum RISCVRegister {

    x0(0), zero(0),

    x1(1), ra(1),

    x2(2), sp(2),

    x3(3), gp(3),

    x4(4), tp(4),

    x5(5), t0(5),

    x6(6), t1(6),

    x7(7), t2(7),

    x8(8), s0(8), fp(8),

    x9(9), s1(9),

    x10(10), a0(10),

    x11(11), a1(11),

    x12(12), a2(12),

    x13(13), a3(13),

    x14(14), a4(14),

    x15(15), a5(15),

    x16(16), a6(16),

    x17(17), a7(17),

    x18(18), s2(18),

    x19(19), s3(19),

    x20(20), s4(20),

    x21(21), s5(21),

    x22(22), s6(22),

    x23(23), s7(23),

    x24(24), s8(24),

    x25(25), s9(25),

    x26(26), s10(26),

    x27(27), s11(27),

    x28(28), t3(28),

    x29(29), t4(29),

    x30(30), t5(30),

    x31(31), t6(31)

    ;

    private int numVal;

    RISCVRegister(final int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

    public static RISCVRegister fromValue(final int numVal) {

        switch (numVal) {

            case 0:
                return RISCVRegister.x0;

            case 1:
                return RISCVRegister.x1;

            case 2:
                return RISCVRegister.x2;

            case 3:
                return RISCVRegister.x3;

            case 4:
                return RISCVRegister.x4;

            case 5:
                return RISCVRegister.x5;

            case 6:
                return RISCVRegister.x6;

            case 7:
                return RISCVRegister.x7;

            case 8:
                return RISCVRegister.x8;

            case 9:
                return RISCVRegister.x9;

            case 10:
                return RISCVRegister.x10;

            case 11:
                return RISCVRegister.x11;

            case 12:
                return RISCVRegister.x12;

            case 13:
                return RISCVRegister.x13;

            case 14:
                return RISCVRegister.x14;

            case 15:
                return RISCVRegister.x15;

            case 16:
                return RISCVRegister.x16;

            case 17:
                return RISCVRegister.x17;

            case 18:
                return RISCVRegister.x18;

            case 19:
                return RISCVRegister.x19;

            case 20:
                return RISCVRegister.x20;

            case 21:
                return RISCVRegister.x21;

            case 22:
                return RISCVRegister.x22;

            case 23:
                return RISCVRegister.x23;

            case 24:
                return RISCVRegister.x24;

            case 25:
                return RISCVRegister.x25;

            case 26:
                return RISCVRegister.x26;

            case 27:
                return RISCVRegister.x27;

            case 28:
                return RISCVRegister.x28;

            case 29:
                return RISCVRegister.x29;

            case 30:
                return RISCVRegister.x30;

            case 31:
                return RISCVRegister.x31;

            default:
                throw new RuntimeException("unknown register!");
        }
    }

    public static RISCVRegister fromValueToABI(final int numVal) {

        switch (numVal) {

            case 0:
                return RISCVRegister.zero;

            case 1:
                return RISCVRegister.ra;

            case 2:
                return RISCVRegister.sp;

            case 3:
                return RISCVRegister.gp;

            case 4:
                return RISCVRegister.tp;

            case 5:
                return RISCVRegister.t0;

            case 6:
                return RISCVRegister.t1;

            case 7:
                return RISCVRegister.t2;

            case 8:
                return RISCVRegister.fp;

            case 9:
                return RISCVRegister.s1;

            case 10:
                return RISCVRegister.a0;

            case 11:
                return RISCVRegister.a1;

            case 12:
                return RISCVRegister.a2;

            case 13:
                return RISCVRegister.a3;

            case 14:
                return RISCVRegister.a4;

            case 15:
                return RISCVRegister.a5;

            case 16:
                return RISCVRegister.a6;

            case 17:
                return RISCVRegister.a7;

            case 18:
                return RISCVRegister.a2;

            case 19:
                return RISCVRegister.s3;

            case 20:
                return RISCVRegister.s4;

            case 21:
                return RISCVRegister.s5;

            case 22:
                return RISCVRegister.s6;

            case 23:
                return RISCVRegister.s7;

            case 24:
                return RISCVRegister.s8;

            case 25:
                return RISCVRegister.s9;

            case 26:
                return RISCVRegister.s10;

            case 27:
                return RISCVRegister.s11;

            case 28:
                return RISCVRegister.t3;

            case 29:
                return RISCVRegister.t4;

            case 30:
                return RISCVRegister.t5;

            case 31:
                return RISCVRegister.t6;

            default:
                throw new RuntimeException("unknown register!");
        }
    }

    /**
     * https://en.wikichip.org/wiki/risc-v/registers
     * 
     * @param registerName
     * @return
     */
    public static int mapRegister(String registerName) {

        if (StringUtils.equalsIgnoreCase(registerName, "x1") || StringUtils.equalsIgnoreCase(registerName, "ra")) {
            return 1;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "x2") || StringUtils.equalsIgnoreCase(registerName, "sp")) {
            return 2;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "x8") || StringUtils.equalsIgnoreCase(registerName, "s0")
                || StringUtils.equalsIgnoreCase(registerName, "fp")) {
            return 8;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "x9") || StringUtils.equalsIgnoreCase(registerName, "s1")) {
            return 9;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "x10") || StringUtils.equalsIgnoreCase(registerName, "a0")) {
            return 10;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "x14") || StringUtils.equalsIgnoreCase(registerName, "a4")) {
            return 14;
        }

        if (StringUtils.equalsIgnoreCase(registerName, "x15") || StringUtils.equalsIgnoreCase(registerName, "a5")) {
            return 15;
        }

        throw new RuntimeException("Unknown register name: \"" + registerName + "\"");
    }

}
