package tacky.generation.tacky;

public enum TackyDataType {

    UNKNOWN,

    INT_8,

    INT_16,

    INT_32,
    
    STRING;

    public static String toString(TackyDataType data) {
        switch (data) {
            case INT_8:
                return "int8";
            case INT_16:
                return "int16";
            case INT_32:
                return "int32";
            case STRING:
                return "string";
            default:
                throw new RuntimeException("Unknown");
        }
    }

    public static TackyDataType fromString(String data) {
        if ("int8".equalsIgnoreCase(data)) {
            return INT_8;
        } else if ("int16".equalsIgnoreCase(data)) {
            return INT_16;
        } else if ("int".equalsIgnoreCase(data) || "int32".equalsIgnoreCase(data)) {
            return INT_32;
        } else if ("string".equalsIgnoreCase(data)) {
            return STRING;
        } else {
            throw new RuntimeException("Unknown");
        }
    }

    public static int sizeOf(String data) {
        if ("int8".equalsIgnoreCase(data)) {
            return 1;
        } else if ("int16".equalsIgnoreCase(data)) {
            return 2;
        } else if ("int32".equalsIgnoreCase(data)) {
            return 4;
        } else {
            throw new RuntimeException("Unknown");
        }
    }

}
