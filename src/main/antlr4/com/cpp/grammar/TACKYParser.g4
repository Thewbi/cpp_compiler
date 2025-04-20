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
    : PROGRAM LeftParen StringLiteral RightParen
    ;

function_definition
    : FUNCTION LeftParen StringLiteral Comma statement_list RightParen
    ;

/*
block_scope
    : LeftBrace statement_list RightBrace
    ;
*/

statement_list
    : statement statement_list
    | statement
    ;

statement
    : return_statement
    ;

return_statement
    : RETURN LeftParen val RightParen
    ;

val
    : CONSTANT LeftParen IntegerLiteral RightParen
    | VAR LeftParen Identifier RightParen
    ;