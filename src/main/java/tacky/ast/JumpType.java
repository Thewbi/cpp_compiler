package tacky.ast;

public enum JumpType {

    /** Unconditional Jump */
    Jump,

    JumpIfZero,

    JumpIfNotZero,

    UNKNOWN;

    public static JumpType fromString(final String data) {
        String tempData = data.trim().toLowerCase();
        if (tempData.equalsIgnoreCase("Jump")) {
            return Jump;
        } else if (tempData.equalsIgnoreCase("JumpIfZero")) {
            return JumpIfZero;
        } else if (tempData.equalsIgnoreCase("JumpIfNotZero")) {
            return JumpIfNotZero;
        } else {
            throw new RuntimeException("Unknown type: " + data);
        }
    }

}
