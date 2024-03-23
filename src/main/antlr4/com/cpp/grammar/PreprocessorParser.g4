parser grammar PreprocessorParser;

options {
	tokenVocab = PreprocessorLexer;
}

rows:
    (
        preproc_row
        |
        normal_row
        |
        NewLine
    )*
    ;

normal_row:
(
    NormalIdentifier
    |
    NormalWhitespace
    )+
    ;

preproc_row:
    Hashtag
    preprocessor_command
    ( NewLine | EOF )
    ;

/*
stream:
    ( stream_element )*
    ;

stream_element:
    (
        preprocessor_command
        |
        element
        |
        whitespace
        |
        lineComment
        |
        blockComment
    )
    ;
 */

expression :
    expression Greater expression
    |
    expression Less expression
    |
    Number
    ;

preprocessor_command:
    if_pcmd
    |
    endif_pcmd
    | 
    include_pcmd
    ;

/*if_pcmd: 
    If_PCmd expression 
    ( Elif_PCmd expression )*
    ( Else_PCmd )?
    Endif_PCmd
    ;
    */

if_pcmd: 
    If_PCmd expression
    ;
//    ( Elif_PCmd expression )*
//    ( Else_PCmd )?

endif_pcmd:
    Endif_PCmd
    ;

include_pcmd:
    Include_PCmd ( StringLiteral | TriStringLiteral /*| TriStringLiteral*/ )
    ;

//element:
//    Element
//    ;

// whitespace:
//     Whitespace
//     ;

lineComment:
    LineComment
    ;

blockComment:
    BlockComment
    ;