package ast;

public enum ExpressionType {

    Add,

    Mul,

    AddressOperator,

    Primary, // expressions that are not subdivided further

    Cast, // used during cast operations. The type is stored in the rhs property

    Unknown;

}
