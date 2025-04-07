package ast;

public enum ExpressionType {

    Add,

    Mul,

    AddressOperator,

    Primary, // expressions that are not subdivided further

    Unknown;

}
