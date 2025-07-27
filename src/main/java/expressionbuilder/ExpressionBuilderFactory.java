package expressionbuilder;

import java.util.ArrayList;
import java.util.List;
import com.cpp.grammar.CPP14Lexer;

public class ExpressionBuilderFactory {

    ExpressionBuilder build() {

        // Precedences: https://en.cppreference.com/w/cpp/language/operator_precedence.html

        // expression comma list
        ExpressionBuilderRule rule_expression_comma_list = new ExpressionBuilderRule();
        rule_expression_comma_list.name = "rule_expression_comma_list";
        rule_expression_comma_list.priority = 90;
        //rule_expression_comma_list.elements.add(CPP14Lexer.Identifier);
        //rule_expression_comma_list.elements.add(CPP14Lexer.LeftParen);
        // rule_expression_comma_list.elements.add(ExpressionBuilderRule.exprType);
        rule_expression_comma_list.elements.add(ExpressionBuilderRule.exprType);
        rule_expression_comma_list.elements.add(CPP14Lexer.Comma);
        rule_expression_comma_list.elements.add(ExpressionBuilderRule.exprType);
        //rule_expression_comma_list.elements.add(ExpressionBuilderRule.exprCommaListType);
        //rule_expression_comma_list.elements.add(CPP14Lexer.RightParen);
        rule_expression_comma_list.resultType = ExpressionBuilderRule.exprCommaListType;

        ExpressionBuilderRule rule_expression_comma_list_middle = new ExpressionBuilderRule();
        rule_expression_comma_list_middle.name = "rule_expression_comma_list_middle";
        rule_expression_comma_list_middle.priority = 89;
        //rule_expression_comma_list_middle.elements.add(CPP14Lexer.Identifier);
        //rule_expression_comma_list_middle.elements.add(CPP14Lexer.LeftParen);
        rule_expression_comma_list_middle.elements.add(ExpressionBuilderRule.exprType);
        rule_expression_comma_list_middle.elements.add(CPP14Lexer.Comma);
        rule_expression_comma_list_middle.elements.add(ExpressionBuilderRule.exprCommaListType);
        // rule_expression_comma_list_middle.elements.add(CPP14Lexer.Comma);
        //rule_expression_comma_list_middle.elements.add(ExpressionBuilderRule.exprCommaListType);
        //rule_expression_comma_list_middle.elements.add(CPP14Lexer.RightParen);
        rule_expression_comma_list_middle.resultType = ExpressionBuilderRule.exprCommaListType;

        // ExpressionBuilderRule rule_expression_comma_list_end = new ExpressionBuilderRule();
        // rule_expression_comma_list_end.name = "rule_expression_comma_list_end";
        // rule_expression_comma_list_end.priority = 89;
        // //rule_expression_comma_list_end.elements.add(CPP14Lexer.Identifier);
        // //rule_expression_comma_list_end.elements.add(CPP14Lexer.LeftParen);
        // rule_expression_comma_list_end.elements.add(ExpressionBuilderRule.exprCommaListType);
        // // rule_expression_comma_list_end.elements.add(CPP14Lexer.Comma);
        // rule_expression_comma_list_end.elements.add(ExpressionBuilderRule.exprType);
        // //rule_expression_comma_list_end.elements.add(ExpressionBuilderRule.exprCommaListType);
        // //rule_expression_comma_list_end.elements.add(CPP14Lexer.RightParen);
        // rule_expression_comma_list_end.resultType = ExpressionBuilderRule.exprCommaListType;

        // exprCommaListType ::= expr
        ExpressionBuilderRule rule_exp_to_exp_comma_list = new ExpressionBuilderRule();
        rule_exp_to_exp_comma_list.name = "rule_exp_to_exp_comma_list";
        rule_exp_to_exp_comma_list.priority = 90;
        rule_exp_to_exp_comma_list.elements.add(ExpressionBuilderRule.exprType);
        rule_exp_to_exp_comma_list.resultType = ExpressionBuilderRule.exprCommaListType;


        // function_call
        ExpressionBuilderRule rule_function_call = new ExpressionBuilderRule();
        rule_function_call.name = "rule_function_call";
        rule_function_call.priority = 2;
        rule_function_call.elements.add(CPP14Lexer.Identifier);
        rule_function_call.elements.add(CPP14Lexer.LeftParen);
        // rule_function_call.elements.add(ExpressionBuilderRule.exprType);
        rule_function_call.elements.add(CPP14Lexer.RightParen);
        rule_function_call.resultType = ExpressionBuilderRule.exprType;


        // function_call
        ExpressionBuilderRule rule_function_call_with_single_param = new ExpressionBuilderRule();
        rule_function_call_with_single_param.name = "rule_function_call_with_single_param";
        rule_function_call_with_single_param.priority = 2;
        rule_function_call_with_single_param.elements.add(CPP14Lexer.Identifier);
        rule_function_call_with_single_param.elements.add(CPP14Lexer.LeftParen);
        rule_function_call_with_single_param.elements.add(ExpressionBuilderRule.exprType);
        rule_function_call_with_single_param.elements.add(CPP14Lexer.RightParen);
        rule_function_call_with_single_param.resultType = ExpressionBuilderRule.exprType;

        // function_call
        ExpressionBuilderRule rule_function_call_with_paramlist = new ExpressionBuilderRule();
        rule_function_call_with_paramlist.name = "rule_function_call";
        rule_function_call_with_paramlist.priority = 2;
        rule_function_call_with_paramlist.elements.add(CPP14Lexer.Identifier);
        rule_function_call_with_paramlist.elements.add(CPP14Lexer.LeftParen);
        rule_function_call_with_paramlist.elements.add(ExpressionBuilderRule.exprCommaListType);
        rule_function_call_with_paramlist.elements.add(CPP14Lexer.RightParen);
        rule_function_call_with_paramlist.resultType = ExpressionBuilderRule.exprType;

        // parenthesis
        ExpressionBuilderRule rule_parenthesis = new ExpressionBuilderRule();
        rule_parenthesis.name = "rule_parenthesis";
        rule_parenthesis.priority = 3;
        rule_parenthesis.elements.add(CPP14Lexer.LeftParen);
        rule_parenthesis.elements.add(ExpressionBuilderRule.exprType);
        rule_parenthesis.elements.add(CPP14Lexer.RightParen);
        rule_parenthesis.resultType = ExpressionBuilderRule.exprType;

        // dot_concat
        ExpressionBuilderRule rule_dot_concat = new ExpressionBuilderRule();
        rule_dot_concat.name = "rule_dot_concat";
        rule_dot_concat.priority = 3;
        rule_dot_concat.elements.add(ExpressionBuilderRule.exprType);
        rule_dot_concat.elements.add(CPP14Lexer.Dot);
        rule_dot_concat.elements.add(ExpressionBuilderRule.exprType);
        rule_dot_concat.resultType = ExpressionBuilderRule.exprType;

        // pointer_type_cast
        ExpressionBuilderRule rule_pointer_type_cast = new ExpressionBuilderRule();
        rule_pointer_type_cast.name = "rule_pointer_type_cast";
        rule_pointer_type_cast.priority = 60;
        rule_pointer_type_cast.elements.add(CPP14Lexer.LeftParen);
        //rule_pointer_type_cast.elements.add(CPP14Lexer.Identifier);
        rule_pointer_type_cast.elements.add(ExpressionBuilderRule.exprType);
        rule_pointer_type_cast.elements.add(CPP14Lexer.Star);
        rule_pointer_type_cast.elements.add(CPP14Lexer.RightParen);
        rule_pointer_type_cast.resultType = ExpressionBuilderRule.cStyleCast;

        // unary not
        ExpressionBuilderRule rule_unary_not = new ExpressionBuilderRule();
        rule_unary_not.name = "rule_unary_not";
        rule_unary_not.priority = 4;
        rule_unary_not.elements.add(CPP14Lexer.Not);
        rule_unary_not.elements.add(ExpressionBuilderRule.exprType);
        rule_unary_not.resultType = ExpressionBuilderRule.exprType;

        // address_of
        ExpressionBuilderRule rule_address_of = new ExpressionBuilderRule();
        rule_address_of.name = "rule_address_of";
        rule_address_of.priority = 4;
        rule_address_of.elements.add(CPP14Lexer.And);
        rule_address_of.elements.add(ExpressionBuilderRule.exprType);
        rule_address_of.resultType = ExpressionBuilderRule.exprType;

        // parenthesis
        ExpressionBuilderRule rule_cast_applied = new ExpressionBuilderRule();
        rule_cast_applied.name = "rule_cast_applied";
        rule_cast_applied.priority = 4;
        rule_cast_applied.elements.add(CPP14Lexer.LeftParen);
        rule_cast_applied.elements.add(ExpressionBuilderRule.cStyleCast);
        rule_cast_applied.elements.add(ExpressionBuilderRule.exprType);
        rule_cast_applied.elements.add(CPP14Lexer.RightParen);
        rule_cast_applied.resultType = ExpressionBuilderRule.exprType;

        // expr ::= expr * expr
        ExpressionBuilderRule rule_bin_mult = new ExpressionBuilderRule();
        rule_bin_mult.name = "rule_bin_mult";
        rule_bin_mult.priority = 6;
        rule_bin_mult.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_mult.elements.add(CPP14Lexer.Star);
        rule_bin_mult.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_mult.resultType = ExpressionBuilderRule.exprType;

        // expr ::= expr + expr
        ExpressionBuilderRule rule_bin_plus = new ExpressionBuilderRule();
        rule_bin_plus.name = "rule_bin_plus";
        rule_bin_plus.priority = 7;
        rule_bin_plus.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_plus.elements.add(CPP14Lexer.Plus);
        rule_bin_plus.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_plus.resultType = ExpressionBuilderRule.exprType;

        // expr ::= expr == expr
        ExpressionBuilderRule rule_bin_equal = new ExpressionBuilderRule();
        rule_bin_equal.name = "rule_bin_equal";
        rule_bin_equal.priority = 11;
        rule_bin_equal.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_equal.elements.add(CPP14Lexer.Equal);
        rule_bin_equal.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_equal.resultType = ExpressionBuilderRule.exprType;

        // expr ::= expr && expr
        ExpressionBuilderRule rule_bin_andand = new ExpressionBuilderRule();
        rule_bin_andand.name = "rule_bin_andand";
        rule_bin_andand.priority = 15;
        rule_bin_andand.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_andand.elements.add(CPP14Lexer.AndAnd);
        rule_bin_andand.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_andand.resultType = ExpressionBuilderRule.exprType;

        // expr ::= expr || expr
        ExpressionBuilderRule rule_bin_oror = new ExpressionBuilderRule();
        rule_bin_oror.name = "rule_bin_oror";
        rule_bin_oror.priority = 16;
        rule_bin_oror.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_oror.elements.add(CPP14Lexer.OrOr);
        rule_bin_oror.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_oror.resultType = ExpressionBuilderRule.exprType;

        // expr ::= identifier
        ExpressionBuilderRule rule_identifier_to_exp = new ExpressionBuilderRule();
        rule_identifier_to_exp.name = "rule_identifier_to_exp";
        rule_identifier_to_exp.priority = 51;
        rule_identifier_to_exp.elements.add(CPP14Lexer.Identifier);
        rule_identifier_to_exp.resultType = ExpressionBuilderRule.exprType;

        ExpressionBuilderRule rule_void_to_exp = new ExpressionBuilderRule();
        rule_void_to_exp.name = "rule_void_to_exp";
        rule_void_to_exp.priority = 51;
        rule_void_to_exp.elements.add(CPP14Lexer.Void);
        rule_void_to_exp.resultType = ExpressionBuilderRule.exprType;

        // expr ::= string_literal
        ExpressionBuilderRule rule_string_literal_to_exp = new ExpressionBuilderRule();
        rule_string_literal_to_exp.name = "rule_string_literal_to_exp";
        rule_string_literal_to_exp.priority = 51;
        rule_string_literal_to_exp.elements.add(CPP14Lexer.StringLiteral);
        rule_string_literal_to_exp.resultType = ExpressionBuilderRule.exprType;

        // expr ::= integer_literal
        ExpressionBuilderRule rule_int_literal_to_exp = new ExpressionBuilderRule();
        rule_int_literal_to_exp.name = "rule_int_literal_to_exp";
        rule_int_literal_to_exp.priority = 51;
        rule_int_literal_to_exp.elements.add(CPP14Lexer.IntegerLiteral);
        rule_int_literal_to_exp.resultType = ExpressionBuilderRule.exprType;

        // start_symbol ::= expr <EOF>
        ExpressionBuilderRule rule_start_symbol = new ExpressionBuilderRule();
        rule_start_symbol.name = "rule_start_symbol";
         rule_start_symbol.priority = 100;
        //rule_start_symbol.priority = 1;
        rule_start_symbol.elements.add(ExpressionBuilderRule.exprType);
        rule_start_symbol.elements.add(CPP14Lexer.EOF);
        rule_start_symbol.resultType = ExpressionBuilderRule.startSymbolType;








        DefaultExpressionBuilder expressionBuilder = new DefaultExpressionBuilder();
        // 1
        expressionBuilder.rules.add(rule_parenthesis);
        expressionBuilder.rules.add(rule_expression_comma_list);
        expressionBuilder.rules.add(rule_expression_comma_list_middle);
        // expressionBuilder.rules.add(rule_expression_comma_list_end);
        //expressionBuilder.rules.add(rule_exp_to_exp_comma_list);
        // 2
        expressionBuilder.rules.add(rule_function_call);
        expressionBuilder.rules.add(rule_function_call_with_paramlist);
        expressionBuilder.rules.add(rule_function_call_with_single_param);
        expressionBuilder.rules.add(rule_dot_concat);
        expressionBuilder.rules.add(rule_pointer_type_cast);
        // 3
        expressionBuilder.rules.add(rule_unary_not);
        expressionBuilder.rules.add(rule_address_of);
        expressionBuilder.rules.add(rule_cast_applied);
        // 5
        expressionBuilder.rules.add(rule_bin_mult);
        // 6
        expressionBuilder.rules.add(rule_bin_plus);
        // 10
        expressionBuilder.rules.add(rule_bin_equal);
        // 14
        expressionBuilder.rules.add(rule_bin_andand);
        // 15
        expressionBuilder.rules.add(rule_bin_oror);
        // 50
        expressionBuilder.rules.add(rule_identifier_to_exp);
        expressionBuilder.rules.add(rule_void_to_exp);
        expressionBuilder.rules.add(rule_int_literal_to_exp);
        expressionBuilder.rules.add(rule_string_literal_to_exp);
        // 100
        expressionBuilder.rules.add(rule_start_symbol);

        return expressionBuilder;
    }

    @SuppressWarnings("unused")
    private List<ExpressionBuilderRule> getRules() {

        List<ExpressionBuilderRule> rules = new ArrayList<>();

        // Precedences: https://en.cppreference.com/w/cpp/language/operator_precedence.html

        // expression comma list
        ExpressionBuilderRule rule_expression_comma_list = new ExpressionBuilderRule();
        rule_expression_comma_list.name = "rule_expression_comma_list";
        rule_expression_comma_list.priority = 90;
        rule_expression_comma_list.elements.add(ExpressionBuilderRule.exprType);
        rule_expression_comma_list.elements.add(CPP14Lexer.Comma);
        rule_expression_comma_list.elements.add(ExpressionBuilderRule.exprType);
        rule_expression_comma_list.resultType = ExpressionBuilderRule.exprCommaListType;
        rules.add(rule_expression_comma_list);

        ExpressionBuilderRule rule_expression_comma_list_middle = new ExpressionBuilderRule();
        rule_expression_comma_list_middle.name = "rule_expression_comma_list_middle";
        rule_expression_comma_list_middle.priority = 89;
        rule_expression_comma_list_middle.elements.add(ExpressionBuilderRule.exprType);
        rule_expression_comma_list_middle.elements.add(CPP14Lexer.Comma);
        rule_expression_comma_list_middle.elements.add(ExpressionBuilderRule.exprCommaListType);
        rule_expression_comma_list_middle.resultType = ExpressionBuilderRule.exprCommaListType;
        rules.add(rule_expression_comma_list_middle);

        // exprCommaListType ::= expr
        ExpressionBuilderRule rule_exp_to_exp_comma_list = new ExpressionBuilderRule();
        rule_exp_to_exp_comma_list.name = "rule_exp_to_exp_comma_list";
        rule_exp_to_exp_comma_list.priority = 90;
        rule_exp_to_exp_comma_list.elements.add(ExpressionBuilderRule.exprType);
        rule_exp_to_exp_comma_list.resultType = ExpressionBuilderRule.exprCommaListType;
        rules.add(rule_exp_to_exp_comma_list);

        // function_call
        ExpressionBuilderRule rule_function_call = new ExpressionBuilderRule();
        rule_function_call.name = "rule_function_call";
        rule_function_call.priority = 2;
        rule_function_call.elements.add(CPP14Lexer.Identifier);
        rule_function_call.elements.add(CPP14Lexer.LeftParen);
        rule_function_call.elements.add(CPP14Lexer.RightParen);
        rule_function_call.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_function_call);

        // rule_function_call_with_single_param
        ExpressionBuilderRule rule_function_call_with_single_param = new ExpressionBuilderRule();
        rule_function_call_with_single_param.name = "rule_function_call_with_single_param";
        rule_function_call_with_single_param.priority = 2;
        rule_function_call_with_single_param.elements.add(CPP14Lexer.Identifier);
        rule_function_call_with_single_param.elements.add(CPP14Lexer.LeftParen);
        rule_function_call_with_single_param.elements.add(ExpressionBuilderRule.exprType);
        rule_function_call_with_single_param.elements.add(CPP14Lexer.RightParen);
        rule_function_call_with_single_param.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_function_call_with_single_param);

        // function_call
        ExpressionBuilderRule rule_function_call_with_paramlist = new ExpressionBuilderRule();
        rule_function_call_with_paramlist.name = "rule_function_call";
        rule_function_call_with_paramlist.priority = 2;
        rule_function_call_with_paramlist.elements.add(CPP14Lexer.Identifier);
        rule_function_call_with_paramlist.elements.add(CPP14Lexer.LeftParen);
        rule_function_call_with_paramlist.elements.add(ExpressionBuilderRule.exprCommaListType);
        rule_function_call_with_paramlist.elements.add(CPP14Lexer.RightParen);
        rule_function_call_with_paramlist.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_function_call_with_paramlist);

        // parenthesis
        ExpressionBuilderRule rule_parenthesis = new ExpressionBuilderRule();
        rule_parenthesis.name = "rule_parenthesis";
        rule_parenthesis.priority = 3;
        rule_parenthesis.elements.add(CPP14Lexer.LeftParen);
        rule_parenthesis.elements.add(ExpressionBuilderRule.exprType);
        rule_parenthesis.elements.add(CPP14Lexer.RightParen);
        rule_parenthesis.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_parenthesis);

        // dot_concat
        ExpressionBuilderRule rule_dot_concat = new ExpressionBuilderRule();
        rule_dot_concat.name = "rule_dot_concat";
        rule_dot_concat.priority = 3;
        rule_dot_concat.elements.add(ExpressionBuilderRule.exprType);
        rule_dot_concat.elements.add(CPP14Lexer.Dot);
        rule_dot_concat.elements.add(ExpressionBuilderRule.exprType);
        rule_dot_concat.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_dot_concat);

        // pointer_type_cast
        ExpressionBuilderRule rule_pointer_type_cast = new ExpressionBuilderRule();
        rule_pointer_type_cast.name = "rule_pointer_type_cast";
        rule_pointer_type_cast.priority = 60;
        rule_pointer_type_cast.elements.add(CPP14Lexer.LeftParen);
        rule_pointer_type_cast.elements.add(ExpressionBuilderRule.exprType);
        rule_pointer_type_cast.elements.add(CPP14Lexer.Star);
        rule_pointer_type_cast.elements.add(CPP14Lexer.RightParen);
        rule_pointer_type_cast.resultType = ExpressionBuilderRule.cStyleCast;
        rules.add(rule_pointer_type_cast);

        // unary not
        ExpressionBuilderRule rule_unary_not = new ExpressionBuilderRule();
        rule_unary_not.name = "rule_unary_not";
        rule_unary_not.priority = 4;
        rule_unary_not.elements.add(CPP14Lexer.Not);
        rule_unary_not.elements.add(ExpressionBuilderRule.exprType);
        rule_unary_not.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_unary_not);

        // address_of
        ExpressionBuilderRule rule_address_of = new ExpressionBuilderRule();
        rule_address_of.name = "rule_address_of";
        rule_address_of.priority = 4;
        rule_address_of.elements.add(CPP14Lexer.And);
        rule_address_of.elements.add(ExpressionBuilderRule.exprType);
        rule_address_of.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_address_of);

        // parenthesis
        ExpressionBuilderRule rule_cast_applied = new ExpressionBuilderRule();
        rule_cast_applied.name = "rule_cast_applied";
        rule_cast_applied.priority = 4;
        rule_cast_applied.elements.add(CPP14Lexer.LeftParen);
        rule_cast_applied.elements.add(ExpressionBuilderRule.cStyleCast);
        rule_cast_applied.elements.add(ExpressionBuilderRule.exprType);
        rule_cast_applied.elements.add(CPP14Lexer.RightParen);
        rule_cast_applied.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_cast_applied);

        // expr ::= expr * expr
        ExpressionBuilderRule rule_bin_mult = new ExpressionBuilderRule();
        rule_bin_mult.name = "rule_bin_mult";
        rule_bin_mult.priority = 6;
        rule_bin_mult.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_mult.elements.add(CPP14Lexer.Star);
        rule_bin_mult.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_mult.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_bin_mult);

        // expr ::= expr + expr
        ExpressionBuilderRule rule_bin_plus = new ExpressionBuilderRule();
        rule_bin_plus.name = "rule_bin_plus";
        rule_bin_plus.priority = 7;
        rule_bin_plus.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_plus.elements.add(CPP14Lexer.Plus);
        rule_bin_plus.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_plus.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_bin_plus);

        // expr ::= expr == expr
        ExpressionBuilderRule rule_bin_equal = new ExpressionBuilderRule();
        rule_bin_equal.name = "rule_bin_equal";
        rule_bin_equal.priority = 11;
        rule_bin_equal.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_equal.elements.add(CPP14Lexer.Equal);
        rule_bin_equal.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_equal.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_bin_equal);

        // expr ::= expr && expr
        ExpressionBuilderRule rule_bin_andand = new ExpressionBuilderRule();
        rule_bin_andand.name = "rule_bin_andand";
        rule_bin_andand.priority = 15;
        rule_bin_andand.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_andand.elements.add(CPP14Lexer.AndAnd);
        rule_bin_andand.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_andand.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_bin_andand);

        // expr ::= expr || expr
        ExpressionBuilderRule rule_bin_oror = new ExpressionBuilderRule();
        rule_bin_oror.name = "rule_bin_oror";
        rule_bin_oror.priority = 16;
        rule_bin_oror.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_oror.elements.add(CPP14Lexer.OrOr);
        rule_bin_oror.elements.add(ExpressionBuilderRule.exprType);
        rule_bin_oror.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_bin_oror);

        // expr ::= identifier
        ExpressionBuilderRule rule_identifier_to_exp = new ExpressionBuilderRule();
        rule_identifier_to_exp.name = "rule_identifier_to_exp";
        rule_identifier_to_exp.priority = 51;
        rule_identifier_to_exp.elements.add(CPP14Lexer.Identifier);
        rule_identifier_to_exp.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_identifier_to_exp);

        ExpressionBuilderRule rule_void_to_exp = new ExpressionBuilderRule();
        rule_void_to_exp.name = "rule_void_to_exp";
        rule_void_to_exp.priority = 51;
        rule_void_to_exp.elements.add(CPP14Lexer.Void);
        rule_void_to_exp.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_void_to_exp);

        // expr ::= string_literal
        ExpressionBuilderRule rule_string_literal_to_exp = new ExpressionBuilderRule();
        rule_string_literal_to_exp.name = "rule_string_literal_to_exp";
        rule_string_literal_to_exp.priority = 51;
        rule_string_literal_to_exp.elements.add(CPP14Lexer.StringLiteral);
        rule_string_literal_to_exp.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_string_literal_to_exp);

        // expr ::= integer_literal
        ExpressionBuilderRule rule_int_literal_to_exp = new ExpressionBuilderRule();
        rule_int_literal_to_exp.name = "rule_int_literal_to_exp";
        rule_int_literal_to_exp.priority = 51;
        rule_int_literal_to_exp.elements.add(CPP14Lexer.IntegerLiteral);
        rule_int_literal_to_exp.resultType = ExpressionBuilderRule.exprType;
        rules.add(rule_int_literal_to_exp);

        // start_symbol ::= expr <EOF>
        ExpressionBuilderRule rule_start_symbol = new ExpressionBuilderRule();
        rule_start_symbol.name = "rule_start_symbol";
        rule_start_symbol.priority = 100;
        rule_start_symbol.elements.add(ExpressionBuilderRule.exprType);
        rule_start_symbol.elements.add(CPP14Lexer.EOF);
        rule_start_symbol.resultType = ExpressionBuilderRule.startSymbolType;
        rules.add(rule_start_symbol);
        return rules;
    }
    
}
