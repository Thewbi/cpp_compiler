package ast;

public enum ExpressionType {

    /* Addition: + */
    Add,

    /** ++ */
    UnaryIncrement,

    /** Subtract: - */
    Subtract,

    /** -- */
    UnaryDecrement,

    /** Multiplication: * */
    Mul,

    /** Division: * */
    Div,

    /** Division Assignment: /= */
    Div_Assign,

    /** == */
    Equality,

    /** != */
    Not_Equal,

    /** < */
    LessThen,

    /** <= */
    LessThenOrEqual,

    /** > */
    GreaterThen,

    /** >= */
    GreaterThenOrEqual,

    /** & */
    AddressOperator,

    /** % */
    Modulo,

    Primary, // expressions that are not subdivided further

    StringLiteral,

    IntegerLiteral,

    Identifier,

    Constant,

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
        } else if (tempData.equalsIgnoreCase("-")) {
            return Subtract;
        } else if (tempData.equalsIgnoreCase("--")) {
            return UnaryDecrement;
        } else if (tempData.equalsIgnoreCase("*")) {
            return Mul;
        } else if (tempData.equalsIgnoreCase("/")) {
            return Div;
        } else if (tempData.equalsIgnoreCase("/=")) {
            return Div_Assign;
        } else if (tempData.equalsIgnoreCase("==")) {
            return Equality;
        } else if (tempData.equalsIgnoreCase("=")) {
            return Assignment;
        } else if (tempData.equalsIgnoreCase("!=")) {
            return Not_Equal;
        } else if (tempData.equalsIgnoreCase("<")) {
            return LessThen;
        } else if (tempData.equalsIgnoreCase("<=")) {
            return LessThenOrEqual;
        } else if (tempData.equalsIgnoreCase(">")) {
            return GreaterThen;
        } else if (tempData.equalsIgnoreCase(">=")) {
            return GreaterThenOrEqual;
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
