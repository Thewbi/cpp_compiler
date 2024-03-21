parser grammar PreprocessorParser;

options {
	tokenVocab = PreprocessorLexer;
}

stream:
    (
        preprocessor_command lineComment?
        |
        element lineComment?
        |
        whitespace
    )*
    ;

preprocessor_command:
    if_pcmd
    | include_PCmd
    ;

if_pcmd: 
    If_PCmd
    ;

include_PCmd:
    Include_PCmd whitespace* StringLiteral
    ;

element:
    Element
    ;

whitespace:
    Whitespace
    ;

lineComment:
    LineComment
    ;