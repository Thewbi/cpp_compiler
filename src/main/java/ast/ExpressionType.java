package ast;

public enum ExpressionType {

    /* Addition: + */
    Add,

    /** ++ */
    UnaryIncrement,

    /** Multiplication: * */
    Mul,

    /** == */
    Equality,

    /** < */
    LessThen,

    /** <= */
    LessThenOrEquals,

    /** & */
    AddressOperator,

    Primary, // expressions that are not subdivided further

    Cast, // used during cast operations. The type is stored in the rhs property

    // used in for loop variable initialization
    Assignment,

    UNKNOWN;

    public static ExpressionType fromString(final String data) {
        String tempData = data.trim().toLowerCase();
        if (tempData.equalsIgnoreCase("+")) {
            return Add;
        } if (tempData.equalsIgnoreCase("++")) {
            return UnaryIncrement;
        } else if (tempData.equalsIgnoreCase("*")) {
            return Mul;
        } else if (tempData.equalsIgnoreCase("==")) {
            return Equality;
        } else if (tempData.equalsIgnoreCase("<")) {
            return LessThen;
        } else if (tempData.equalsIgnoreCase("<=")) {
            return LessThenOrEquals;
        } else if (tempData.equalsIgnoreCase("*")) {
            return Mul;
        } else if (tempData.equalsIgnoreCase("&")) {
            return AddressOperator;
        } else if (tempData.equalsIgnoreCase("*")) {
            return Mul;
        }
        // else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // } else if (tempData.equalsIgnoreCase("*")) {
        //     return Mul;
        // }
        else {
            throw new RuntimeException("Unknown type: " + data);
            //return UNKNOWN;
        }
    }

}
