// http://lab.antlr.org/

parser grammar TACKYParser;

options {
	tokenVocab = TACKYLexer;
}

tacky_file
    : program
    | function_definition
    EOF
    ;

program
    : PROGRAM LeftParen StringLiteral RightParen
    ;

function_definition
    : FUNCTION Identifier LeftParen Identifier COMMA statement_list RightParen
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
    : RETURN
    ;