// http://lab.antlr.org/

parser grammar TACKYParser;

options {
	tokenVocab = TACKYLexer;
}

tacky_file
    : ( program function_definition+ )
    EOF
    ;

program
    : PROGRAM LEFT_PAREN StringLiteral RIGHT_PAREN
    ;

function_definition
    : FUNCTION LEFT_PAREN StringLiteral COMMA statement_list RIGHT_PAREN
    ;

/*
block_scope
    : LEFT_BRACE statement_list RIGHT_BRACE
    ;
*/

statement_list
    : statement statement_list
    | statement
    ;

statement
    : return_statement
    | unary
    | binary
    | copy
    | jump
    | jump_if_zero
    | jump_if_not_zero
    | label
    | var_declaration_statement
    | assignment_statement
    ;

return_statement
    : RETURN LEFT_PAREN val RIGHT_PAREN
    ;

unary
    : UNARY LEFT_PAREN unary_operator COMMA val COMMA val RIGHT_PAREN
    ;

unary_operator
    : COMPLEMENT
    | NEGATE
    | NOT
    ;

binary
    : BINARY LEFT_PAREN binary_operator COMMA val COMMA val COMMA val RIGHT_PAREN
    ;

binary_operator
    : ADD
    | SUBTRACT
    | MULTIPLY
    | DIVIDE
    | REMAINDER
    | EQUAL
    | NOTEQUAL
    | LESSTHAN
    | LESSOREQUAL
    | GREATERTHAN
    | GREATEROREQUAL
    ;

copy
    : COPY LEFT_PAREN val COMMA val RIGHT_PAREN
    ;

// Jump is used with Identifier and with StringLiteral
// page 76, e.g. Jump("there"), page 76, e.g. Jump(end)
jump
    : JUMP LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    ;

// page 76, e.g. JumpIfZero(v1, false_label)
jump_if_zero
    : JUMPIFZERO LEFT_PAREN val COMMA ( Identifier | StringLiteral ) RIGHT_PAREN
    ;

jump_if_not_zero
    : JUMPIFNOTZERO LEFT_PAREN val COMMA ( Identifier | StringLiteral ) RIGHT_PAREN
    ;

// Label is used with Identifier and with StringLiteral
// page 76, e.g. Label("there"). page 76, e.g. Label(false_label)
label
    : LABEL LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    ;

var_declaration_statement
    : Identifier EQUAL_SIGN VAR LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    ;

assignment_statement
    : Identifier EQUAL_SIGN expr
    ;

expr
    : expr (ASTERISK | SLASH) expr
    | expr (PLUS | MINUS) expr
    | expr (LESS_THAN | LESS_THAN_OR_EQUAL | GREATER_THAN_OR_EQUAL | GREATER_THAN | EQUAL_OPERATOR) expr
    | expr ( AMPERSAND_DOUBLE | BAR_DOUBLE) expr
//    | expr '(' exprList? ')'
    | Identifier
    | IntegerLiteral
    ;

// VAR are either created using StringLiterals (page 37, e.g. Var("tmp.1")) or via identifiers (page )
val
    : CONSTANT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | VAR LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    | Identifier
    ;