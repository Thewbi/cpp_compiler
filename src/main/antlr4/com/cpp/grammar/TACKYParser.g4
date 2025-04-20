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
    ;

val
    : CONSTANT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | VAR LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    ;