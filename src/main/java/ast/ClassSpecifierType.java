package ast;

public enum ClassSpecifierType {

    struct_type,

    class_type,

    UNKNOWN;

    public static ClassSpecifierType fromString(final String data) {
        String tempData = data.trim().toLowerCase();
        if (tempData.equalsIgnoreCase("struct")) {
            return struct_type;
        } else if (tempData.equalsIgnoreCase("class")) {
            return class_type;
        } else {
            return UNKNOWN;
        }
    }

}
