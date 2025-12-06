package tacky.ast;

public enum JumpType {

    /** Unconditional Jump */
    Jump,

    JumpIfZero,

    JumpIfNotZero,

    JumpIfEqual,

    JumpIfNotEqual,

    JumpGreaterThanOrEqual,

    Break,

    UNKNOWN;

    public static JumpType fromString(final String data) {
        String tempData = data.trim().toLowerCase();
        if (tempData.equalsIgnoreCase("Jump")) {
            return Jump;
        } else if (tempData.equalsIgnoreCase("JumpIfZero")) {
            return JumpIfZero;
        } else if (tempData.equalsIgnoreCase("JumpIfNotZero")) {
            return JumpIfNotZero;
        } else if (tempData.equalsIgnoreCase("JumpIfEqual")) {
            return JumpIfEqual;
        } else if (tempData.equalsIgnoreCase("JumpIfNotEqual")) {
            return JumpIfNotEqual;
        } else if (tempData.equalsIgnoreCase("JumpGreaterThanOrEqual")) {
            return JumpGreaterThanOrEqual;
        } else if (tempData.equalsIgnoreCase("Break")) {
            return Break;
        } else {
            throw new RuntimeException("Unknown Jump-Type: " + data);
        }
    }

}
