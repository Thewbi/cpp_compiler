// http://lab.antlr.org/

parser grammar TACKYParser;

options {
	tokenVocab = TACKYLexer;
}

tacky_file
    : ( program top_level+ )
    EOF
    ;

program
    : PROGRAM LEFT_PAREN StringLiteral RIGHT_PAREN
    ;

top_level
    : function_definition
    | static_variable
    | static_constant
    ;

// page 259
static_variable
    : STATICVARIABLE LEFT_PAREN Identifier COMMA ( TRUE | FALSE ) COMMA type COMMA static_init_list RIGHT_PAREN
    ;

// page 442
static_constant
    : STATICCONSTANT LEFT_PAREN ( Identifier | StringLiteral ) COMMA type COMMA static_init RIGHT_PAREN
    ;

type
    : INT
    | BOOL
    | ASCII
    | ASCIIZ
    ;

static_init_list
    : static_init static_init_list
    | static_init
    ;

// page 437
static_init
    : INTINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | LONGINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | UINTINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | ULONGINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
/* I think this is not TACKY but AST! But is is also needed in TACKY to define the type of a static init variable!
     | IntInit(int)
     | LongInit(int)
    | UIntInit(int)
    | ULongInit(int)
    */
    | CHARINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | UCHARINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | DOUBLEINIT LEFT_PAREN FloatingLiteral RIGHT_PAREN
    | ZEROINIT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | STRINGINIT LEFT_PAREN StringLiteral ( TRUE | FALSE ) RIGHT_PAREN
    | POINTERINIT LEFT_PAREN StringLiteral RIGHT_PAREN
    ;

/*
// page 438 - I think this is not TACKY but AST!
identifier_attrs
    : FunAttr(bool defined, bool global)
    | StaticAttr(initial_value init, bool global)
    | ConstantAttr(static_init init)
    | LocalAttr
    ;
*/

// page 281, page 481
//
// In TACKY, the function definition does not contain a parameter for the return value.
// Only the function call will contain a parameter for a function return value!
function_definition
//    : FUNCTION LEFT_PAREN StringLiteral COMMA ( TRUE | FALSE ) ( COMMA param_list )? COMMA statement_list RIGHT_PAREN
//    : FUNCTION LEFT_PAREN StringLiteral COMMA ( TRUE | FALSE ) COMMA statement_list RIGHT_PAREN
    : FUNCTION LEFT_PAREN StringLiteral COMMA ( TRUE | FALSE ) ( param_list )? COMMA LEFT_BRACKET statement_list RIGHT_BRACKET RIGHT_PAREN
    ;

param_list
    : COMMA Identifier param_list
    | COMMA Identifier
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
/* page 309
    | SignExtend(val src, val dst)
    | Truncate(val src, val dst)
    | ZeroExtend(val src, val dst)
    | DoubleToInt(val src, val dst)
    | DoubleToUInt(val src, val dst)
    | IntToDouble(val src, val dst)
    | UIntToDouble(val src, val dst)
*/
    | unary
    | binary
    | copy

/* page 370, 371
| GetAddress(val src, val dst)
| Load(val src_ptr, val dst)
| Store(val src, val dst_ptr)
*/

/* page 407
| AddPtr(val ptr, val index, int scale, val dst)
| CopyToOffset(val src, identifier dst, int offset)
*/

/* page 513
| CopyFromOffset(identifier src, int offset, val dst)
*/
    | jump
    | jump_if_zero
    | jump_if_not_zero
    | label
    | var_declaration_statement
    | assignment_statement
    | func_call
    | printf_call
    ;

return_statement
    : RETURN LEFT_PAREN ( val )? RIGHT_PAREN
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

// page 479
func_call
    : FUNCCALL LEFT_PAREN Identifier COMMA ( TRUE | FALSE ) ( COMMA arg_list )? ( COMMA val )? RIGHT_PAREN
    ;

printf_call
    : PRINTF LEFT_PAREN StringLiteral RIGHT_PAREN
    ;

arg_list
    : val COMMA arg_list
    | val
    ;

/*
// VAR are either created using StringLiterals (page 37, e.g. Var("tmp.1")) or via identifiers (page )
val
    : CONSTANT LEFT_PAREN IntegerLiteral RIGHT_PAREN
    | VAR LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    | Identifier
    ;
*/

// VAR are either created using StringLiterals (page 37, e.g. Var("tmp.1")) or via identifiers (page )
val
    : CONSTANT LEFT_PAREN CONSTCHAR LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | CONSTANT LEFT_PAREN CONSTUCHAR LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | CONSTANT LEFT_PAREN CONSTINT LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | CONSTANT LEFT_PAREN CONSTUINT LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | CONSTANT LEFT_PAREN CONSTLONG LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | CONSTANT LEFT_PAREN CONSTULONG LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | CONSTANT LEFT_PAREN CONSTDOUBLE LEFT_PAREN IntegerLiteral RIGHT_PAREN RIGHT_PAREN
    | VAR LEFT_PAREN ( Identifier | StringLiteral ) RIGHT_PAREN
    | Identifier
    ;