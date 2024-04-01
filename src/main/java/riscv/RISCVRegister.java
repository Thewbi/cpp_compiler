package riscv;

import org.apache.commons.lang3.StringUtils;

public enum RISCVRegister {

    x0(0),

    zero(0),

    x1(1),	ra(1),

    x2(2),	sp(2),

    x3(3),	gp(3),

    x4(4),	tp(4),

    x5(5),	t0(5),

    x6(6),	t1(6),

    x7(7),	t2(7),

    x8(8),	s0(8),  fp(8),

    x9(9),	s1(9),

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

        if (StringUtils.equalsIgnoreCase(registerName, "x8") || StringUtils.equalsIgnoreCase(registerName, "s0") || StringUtils.equalsIgnoreCase(registerName, "fp")) {
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
