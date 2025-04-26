package ast;

public enum ExpressionType {

    /* Addition: + */
    Add,

    /** ++ */
    UnaryIncrement,

    /** Multiplication: * */
    Mul,

    /** Division Assignment: /= */
    Div_Assign,

    /** == */
    Equality,

    /** != */
    Not_Equal,

    /** < */
    LessThen,

    /** <= */
    LessThenOrEquals,

    /** & */
    AddressOperator,

    /** % */
    Modulo,

    Primary, // expressions that are not subdivided further

    Cast, // used during cast operations. The type is stored in the rhs property

    // used in for loop variable initialization
    Assignment,

    UNKNOWN;

    public static ExpressionType fromString(final String data) {
        String tempData = data.trim().toLowerCase();
        if (tempData.equalsIgnoreCase("+")) {
            return Add;
        } else if (tempData.equalsIgnoreCase("++")) {
            return UnaryIncrement;
        } else if (tempData.equalsIgnoreCase("*")) {
            return Mul;
        } else if (tempData.equalsIgnoreCase("/=")) {
            return Div_Assign;
        } else if (tempData.equalsIgnoreCase("==")) {
            return Equality;
        } else if (tempData.equalsIgnoreCase("!=")) {
            return Not_Equal;
        } else if (tempData.equalsIgnoreCase("<")) {
            return LessThen;
        } else if (tempData.equalsIgnoreCase("<=")) {
            return LessThenOrEquals;
        } else if (tempData.equalsIgnoreCase("*")) {
            return Mul;
        } else if (tempData.equalsIgnoreCase("&")) {
            return AddressOperator;
        } else if (tempData.equalsIgnoreCase("%")) {
            return Modulo;
        } else {
            throw new RuntimeException("Unknown type: " + data);
        }
    }

}
