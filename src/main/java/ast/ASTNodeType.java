package ast;

public enum ASTNodeType {

    UNKNOWN,
    
    ROOT,

    FUNCTION_DECLARATION,

    FUNCTION_CALL,

    INIT_DECLARATION,

    ITERATION_STATEMENT,

    JUMP_STATEMENT,

    SIMPLE_DECLARATION,
    
    EXPRESSION,
    
    ASSIGNMENT,
    
    LABEL,
    
    RETURN,
    
    PROGRAM,
    
    FUNCTION_DEFINITION,
    
    VARIABLE_DECLARATION,
    
    CONSTANT_DECLARATION,
    
    PRINTF,
    
    EXIT,
    
    GET_ADDRESS,
    
    LOAD_FROM_ADDRESS,
    
    STORE_TO_ADDRESS,
    
    VALUE,
    
    DATA_TYPE,
    
    SIZEOF;

}
