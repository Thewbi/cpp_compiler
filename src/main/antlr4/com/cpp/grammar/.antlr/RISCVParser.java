// Generated from c:/aaa_se/cpp_compiler/src/main/antlr4/com/cpp/grammar/RISCVParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RISCVParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, ADDI=2, BGT=3, CALL=4, J_=5, JR=6, LI=7, LW=8, MV=9, SW=10, ALIGN=11, 
		ASTERISK=12, AT=13, CLOSEING_BRACKET=14, COLON=15, COMMA=16, CSEG=17, 
		DEF=18, DEVICE=19, DOT=20, ELSE=21, END_MACRO=22, ENDIF=23, EQUALS=24, 
		EQU=25, ERROR=26, FILE=27, FUNCTION=28, GLOBL=29, GT=30, HASH_TAG=31, 
		IDENT=32, IF=33, INCLUDE=34, LEFT_SHIFT=35, LT=36, MACRO=37, MINUS=38, 
		NOPIC=39, OPENING_BRACKET=40, OPTION=41, ORG=42, PLUS=43, RIGHT_SHIFT=44, 
		SIZE=45, SLASH=46, TEXT=47, TYPE=48, NEWLINE=49, WS=50, LINE_COMMENT=51, 
		BLOCK_COMMENT=52, DOUBLE_SLASH_LINE_COMMENT=53, STRING=54, NUMBER=55, 
		HEX_NUMBER=56, BINARY_NUMBER=57, IDENTIFIER=58;
	public static final int
		RULE_asm_file = 0, RULE_row = 1, RULE_instruction = 2, RULE_param = 3, 
		RULE_label_definition = 4, RULE_label_name = 5, RULE_macro_placeholder = 6, 
		RULE_expression = 7, RULE_offset_expression = 8, RULE_offset_expression_amount = 9, 
		RULE_offset_expression_register = 10, RULE_asm_intrinsic_instruction = 11, 
		RULE_entity_type = 12, RULE_asm_intrinsic_usage = 13, RULE_preprocessor_directive = 14, 
		RULE_mnemonic = 15, RULE_mnemonic_a = 16, RULE_mnemonic_b = 17, RULE_mnemonic_c = 18, 
		RULE_mnemonic_j = 19, RULE_mnemonic_l = 20, RULE_mnemonic_m = 21, RULE_mnemonic_s = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"asm_file", "row", "instruction", "param", "label_definition", "label_name", 
			"macro_placeholder", "expression", "offset_expression", "offset_expression_amount", 
			"offset_expression_register", "asm_intrinsic_instruction", "entity_type", 
			"asm_intrinsic_usage", "preprocessor_directive", "mnemonic", "mnemonic_a", 
			"mnemonic_b", "mnemonic_c", "mnemonic_j", "mnemonic_l", "mnemonic_m", 
			"mnemonic_s"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "'align'", 
			"'*'", "'@'", "')'", "':'", "','", "'cseg'", "'def'", "'device'", "'.'", 
			"'else'", "'endmacro'", "'endif'", "'='", null, "'error'", "'file'", 
			"'function'", "'globl'", "'>'", "'#'", "'ident'", "'if'", "'include'", 
			"'<<'", "'<'", "'macro'", "'-'", "'nopic'", "'('", "'option'", "'org'", 
			"'+'", "'>>'", "'size'", "'/'", "'text'", "'type'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "ADDI", "BGT", "CALL", "J_", "JR", "LI", "LW", "MV", "SW", 
			"ALIGN", "ASTERISK", "AT", "CLOSEING_BRACKET", "COLON", "COMMA", "CSEG", 
			"DEF", "DEVICE", "DOT", "ELSE", "END_MACRO", "ENDIF", "EQUALS", "EQU", 
			"ERROR", "FILE", "FUNCTION", "GLOBL", "GT", "HASH_TAG", "IDENT", "IF", 
			"INCLUDE", "LEFT_SHIFT", "LT", "MACRO", "MINUS", "NOPIC", "OPENING_BRACKET", 
			"OPTION", "ORG", "PLUS", "RIGHT_SHIFT", "SIZE", "SLASH", "TEXT", "TYPE", 
			"NEWLINE", "WS", "LINE_COMMENT", "BLOCK_COMMENT", "DOUBLE_SLASH_LINE_COMMENT", 
			"STRING", "NUMBER", "HEX_NUMBER", "BINARY_NUMBER", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RISCVParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RISCVParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Asm_fileContext extends ParserRuleContext {
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public TerminalNode EOF() { return getToken(RISCVParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(RISCVParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RISCVParser.NEWLINE, i);
		}
		public Asm_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_file; }
	}

	public final Asm_fileContext asm_file() throws RecognitionException {
		Asm_fileContext _localctx = new Asm_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_asm_file);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(46);
				match(NEWLINE);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			row();
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(53);
						match(NEWLINE);
						}
						}
						setState(58);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(59);
					row();
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(65);
				match(NEWLINE);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RowContext extends ParserRuleContext {
		public Preprocessor_directiveContext preprocessor_directive() {
			return getRuleContext(Preprocessor_directiveContext.class,0);
		}
		public Asm_intrinsic_instructionContext asm_intrinsic_instruction() {
			return getRuleContext(Asm_intrinsic_instructionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public Label_definitionContext label_definition() {
			return getRuleContext(Label_definitionContext.class,0);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_row);
		int _la;
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				preprocessor_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				asm_intrinsic_instruction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT || _la==IDENTIFIER) {
					{
					setState(75);
					label_definition();
					}
				}

				setState(78);
				instruction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public MnemonicContext mnemonic() {
			return getRuleContext(MnemonicContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RISCVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RISCVParser.COMMA, i);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			mnemonic();
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(82);
				param();
				setState(85);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(83);
					match(COMMA);
					setState(84);
					param();
					}
					break;
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(87);
					match(COMMA);
					setState(88);
					param();
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RISCVParser.IDENTIFIER, 0); }
		public TerminalNode MINUS() { return getToken(RISCVParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(RISCVParser.PLUS, 0); }
		public Offset_expressionContext offset_expression() {
			return getRuleContext(Offset_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Asm_intrinsic_usageContext asm_intrinsic_usage() {
			return getRuleContext(Asm_intrinsic_usageContext.class,0);
		}
		public Macro_placeholderContext macro_placeholder() {
			return getRuleContext(Macro_placeholderContext.class,0);
		}
		public Label_nameContext label_name() {
			return getRuleContext(Label_nameContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		int _la;
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(93);
					match(MINUS);
					}
				}

				setState(96);
				match(IDENTIFIER);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS) {
					{
					setState(97);
					match(PLUS);
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				offset_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				asm_intrinsic_usage();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				macro_placeholder();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(104);
				label_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Label_definitionContext extends ParserRuleContext {
		public Label_nameContext label_name() {
			return getRuleContext(Label_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(RISCVParser.COLON, 0); }
		public Label_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label_definition; }
	}

	public final Label_definitionContext label_definition() throws RecognitionException {
		Label_definitionContext _localctx = new Label_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_label_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			label_name();
			setState(108);
			match(COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Label_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RISCVParser.IDENTIFIER, 0); }
		public TerminalNode DOT() { return getToken(RISCVParser.DOT, 0); }
		public Label_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label_name; }
	}

	public final Label_nameContext label_name() throws RecognitionException {
		Label_nameContext _localctx = new Label_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_label_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(110);
				match(DOT);
				}
			}

			setState(113);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macro_placeholderContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(RISCVParser.AT, 0); }
		public TerminalNode NUMBER() { return getToken(RISCVParser.NUMBER, 0); }
		public Macro_placeholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_placeholder; }
	}

	public final Macro_placeholderContext macro_placeholder() throws RecognitionException {
		Macro_placeholderContext _localctx = new Macro_placeholderContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_macro_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(AT);
			setState(116);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode OPENING_BRACKET() { return getToken(RISCVParser.OPENING_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CLOSEING_BRACKET() { return getToken(RISCVParser.CLOSEING_BRACKET, 0); }
		public TerminalNode MINUS() { return getToken(RISCVParser.MINUS, 0); }
		public TerminalNode BINARY_NUMBER() { return getToken(RISCVParser.BINARY_NUMBER, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(RISCVParser.HEX_NUMBER, 0); }
		public TerminalNode NUMBER() { return getToken(RISCVParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(RISCVParser.IDENTIFIER, 0); }
		public TerminalNode STRING() { return getToken(RISCVParser.STRING, 0); }
		public Macro_placeholderContext macro_placeholder() {
			return getRuleContext(Macro_placeholderContext.class,0);
		}
		public TerminalNode DOT() { return getToken(RISCVParser.DOT, 0); }
		public TerminalNode LEFT_SHIFT() { return getToken(RISCVParser.LEFT_SHIFT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(RISCVParser.RIGHT_SHIFT, 0); }
		public TerminalNode SLASH() { return getToken(RISCVParser.SLASH, 0); }
		public TerminalNode GT() { return getToken(RISCVParser.GT, 0); }
		public TerminalNode LT() { return getToken(RISCVParser.LT, 0); }
		public TerminalNode EQUALS() { return getToken(RISCVParser.EQUALS, 0); }
		public TerminalNode PLUS() { return getToken(RISCVParser.PLUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENING_BRACKET:
				{
				setState(119);
				match(OPENING_BRACKET);
				setState(120);
				expression(0);
				setState(121);
				match(CLOSEING_BRACKET);
				}
				break;
			case MINUS:
				{
				setState(123);
				match(MINUS);
				setState(124);
				expression(8);
				}
				break;
			case BINARY_NUMBER:
				{
				setState(125);
				match(BINARY_NUMBER);
				}
				break;
			case HEX_NUMBER:
				{
				setState(126);
				match(HEX_NUMBER);
				}
				break;
			case NUMBER:
				{
				setState(127);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(128);
				match(IDENTIFIER);
				}
				break;
			case STRING:
				{
				setState(129);
				match(STRING);
				}
				break;
			case AT:
				{
				setState(130);
				macro_placeholder();
				}
				break;
			case DOT:
				{
				setState(131);
				match(DOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(135);
						match(LEFT_SHIFT);
						setState(136);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(137);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(138);
						match(RIGHT_SHIFT);
						setState(139);
						expression(16);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(141);
						match(SLASH);
						setState(142);
						expression(15);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(143);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(144);
						match(GT);
						setState(145);
						expression(14);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(146);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(147);
						match(LT);
						setState(148);
						expression(13);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(150);
						match(EQUALS);
						setState(151);
						expression(12);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(153);
						match(MINUS);
						setState(154);
						expression(11);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(156);
						match(PLUS);
						setState(157);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Offset_expressionContext extends ParserRuleContext {
		public Offset_expression_amountContext offset_expression_amount() {
			return getRuleContext(Offset_expression_amountContext.class,0);
		}
		public TerminalNode OPENING_BRACKET() { return getToken(RISCVParser.OPENING_BRACKET, 0); }
		public Offset_expression_registerContext offset_expression_register() {
			return getRuleContext(Offset_expression_registerContext.class,0);
		}
		public TerminalNode CLOSEING_BRACKET() { return getToken(RISCVParser.CLOSEING_BRACKET, 0); }
		public Offset_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset_expression; }
	}

	public final Offset_expressionContext offset_expression() throws RecognitionException {
		Offset_expressionContext _localctx = new Offset_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_offset_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			offset_expression_amount();
			setState(164);
			match(OPENING_BRACKET);
			setState(165);
			offset_expression_register();
			setState(166);
			match(CLOSEING_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Offset_expression_amountContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(RISCVParser.NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(RISCVParser.MINUS, 0); }
		public Offset_expression_amountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset_expression_amount; }
	}

	public final Offset_expression_amountContext offset_expression_amount() throws RecognitionException {
		Offset_expression_amountContext _localctx = new Offset_expression_amountContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_offset_expression_amount);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(168);
				match(MINUS);
				}
			}

			setState(171);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Offset_expression_registerContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RISCVParser.IDENTIFIER, 0); }
		public Offset_expression_registerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset_expression_register; }
	}

	public final Offset_expression_registerContext offset_expression_register() throws RecognitionException {
		Offset_expression_registerContext _localctx = new Offset_expression_registerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_offset_expression_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Asm_intrinsic_instructionContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(RISCVParser.DOT, 0); }
		public TerminalNode INCLUDE() { return getToken(RISCVParser.INCLUDE, 0); }
		public TerminalNode STRING() { return getToken(RISCVParser.STRING, 0); }
		public TerminalNode DEVICE() { return getToken(RISCVParser.DEVICE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(RISCVParser.IDENTIFIER, 0); }
		public TerminalNode DEF() { return getToken(RISCVParser.DEF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQU() { return getToken(RISCVParser.EQU, 0); }
		public TerminalNode CSEG() { return getToken(RISCVParser.CSEG, 0); }
		public TerminalNode ORG() { return getToken(RISCVParser.ORG, 0); }
		public TerminalNode MACRO() { return getToken(RISCVParser.MACRO, 0); }
		public TerminalNode END_MACRO() { return getToken(RISCVParser.END_MACRO, 0); }
		public TerminalNode IF() { return getToken(RISCVParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(RISCVParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(RISCVParser.ENDIF, 0); }
		public TerminalNode ERROR() { return getToken(RISCVParser.ERROR, 0); }
		public TerminalNode FILE() { return getToken(RISCVParser.FILE, 0); }
		public TerminalNode TEXT() { return getToken(RISCVParser.TEXT, 0); }
		public TerminalNode IDENT() { return getToken(RISCVParser.IDENT, 0); }
		public TerminalNode SIZE() { return getToken(RISCVParser.SIZE, 0); }
		public TerminalNode COMMA() { return getToken(RISCVParser.COMMA, 0); }
		public TerminalNode ALIGN() { return getToken(RISCVParser.ALIGN, 0); }
		public TerminalNode NUMBER() { return getToken(RISCVParser.NUMBER, 0); }
		public TerminalNode GLOBL() { return getToken(RISCVParser.GLOBL, 0); }
		public TerminalNode TYPE() { return getToken(RISCVParser.TYPE, 0); }
		public TerminalNode OPTION() { return getToken(RISCVParser.OPTION, 0); }
		public TerminalNode HEX_NUMBER() { return getToken(RISCVParser.HEX_NUMBER, 0); }
		public Entity_typeContext entity_type() {
			return getRuleContext(Entity_typeContext.class,0);
		}
		public TerminalNode NOPIC() { return getToken(RISCVParser.NOPIC, 0); }
		public Asm_intrinsic_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_intrinsic_instruction; }
	}

	public final Asm_intrinsic_instructionContext asm_intrinsic_instruction() throws RecognitionException {
		Asm_intrinsic_instructionContext _localctx = new Asm_intrinsic_instructionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_asm_intrinsic_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(DOT);
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCLUDE:
				{
				setState(176);
				match(INCLUDE);
				setState(177);
				match(STRING);
				}
				break;
			case DEVICE:
				{
				setState(178);
				match(DEVICE);
				setState(179);
				match(IDENTIFIER);
				}
				break;
			case DEF:
				{
				setState(180);
				match(DEF);
				setState(181);
				expression(0);
				}
				break;
			case EQU:
				{
				setState(182);
				match(EQU);
				setState(183);
				expression(0);
				}
				break;
			case CSEG:
				{
				setState(184);
				match(CSEG);
				}
				break;
			case ORG:
				{
				setState(185);
				match(ORG);
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==HEX_NUMBER || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case MACRO:
				{
				setState(187);
				match(MACRO);
				setState(188);
				match(IDENTIFIER);
				}
				break;
			case END_MACRO:
				{
				setState(189);
				match(END_MACRO);
				}
				break;
			case IF:
				{
				setState(190);
				match(IF);
				setState(191);
				expression(0);
				}
				break;
			case ELSE:
				{
				setState(192);
				match(ELSE);
				}
				break;
			case ENDIF:
				{
				setState(193);
				match(ENDIF);
				}
				break;
			case ERROR:
				{
				setState(194);
				match(ERROR);
				setState(195);
				match(STRING);
				}
				break;
			case FILE:
				{
				setState(196);
				match(FILE);
				setState(197);
				match(STRING);
				}
				break;
			case TEXT:
				{
				setState(198);
				match(TEXT);
				}
				break;
			case IDENT:
				{
				setState(199);
				match(IDENT);
				setState(200);
				match(STRING);
				}
				break;
			case SIZE:
				{
				setState(201);
				match(SIZE);
				setState(202);
				expression(0);
				setState(203);
				match(COMMA);
				setState(204);
				expression(0);
				}
				break;
			case ALIGN:
				{
				setState(206);
				match(ALIGN);
				setState(207);
				match(NUMBER);
				}
				break;
			case GLOBL:
				{
				setState(208);
				match(GLOBL);
				setState(209);
				match(IDENTIFIER);
				}
				break;
			case TYPE:
				{
				setState(210);
				match(TYPE);
				{
				setState(211);
				match(IDENTIFIER);
				setState(212);
				match(COMMA);
				setState(213);
				entity_type();
				}
				}
				break;
			case OPTION:
				{
				setState(214);
				match(OPTION);
				{
				setState(215);
				match(NOPIC);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entity_typeContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(RISCVParser.AT, 0); }
		public TerminalNode FUNCTION() { return getToken(RISCVParser.FUNCTION, 0); }
		public Entity_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_type; }
	}

	public final Entity_typeContext entity_type() throws RecognitionException {
		Entity_typeContext _localctx = new Entity_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_entity_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(AT);
			{
			setState(219);
			match(FUNCTION);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Asm_intrinsic_usageContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(RISCVParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RISCVParser.IDENTIFIER, i);
		}
		public TerminalNode OPENING_BRACKET() { return getToken(RISCVParser.OPENING_BRACKET, 0); }
		public TerminalNode CLOSEING_BRACKET() { return getToken(RISCVParser.CLOSEING_BRACKET, 0); }
		public Macro_placeholderContext macro_placeholder() {
			return getRuleContext(Macro_placeholderContext.class,0);
		}
		public Asm_intrinsic_usageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_intrinsic_usage; }
	}

	public final Asm_intrinsic_usageContext asm_intrinsic_usage() throws RecognitionException {
		Asm_intrinsic_usageContext _localctx = new Asm_intrinsic_usageContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_asm_intrinsic_usage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(IDENTIFIER);
			setState(222);
			match(OPENING_BRACKET);
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(223);
				match(IDENTIFIER);
				}
				break;
			case AT:
				{
				setState(224);
				macro_placeholder();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(227);
			match(CLOSEING_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Preprocessor_directiveContext extends ParserRuleContext {
		public TerminalNode HASH_TAG() { return getToken(RISCVParser.HASH_TAG, 0); }
		public List<TerminalNode> IF() { return getTokens(RISCVParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(RISCVParser.IF, i);
		}
		public List<TerminalNode> ENDIF() { return getTokens(RISCVParser.ENDIF); }
		public TerminalNode ENDIF(int i) {
			return getToken(RISCVParser.ENDIF, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(RISCVParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RISCVParser.IDENTIFIER, i);
		}
		public List<TerminalNode> HEX_NUMBER() { return getTokens(RISCVParser.HEX_NUMBER); }
		public TerminalNode HEX_NUMBER(int i) {
			return getToken(RISCVParser.HEX_NUMBER, i);
		}
		public List<TerminalNode> BINARY_NUMBER() { return getTokens(RISCVParser.BINARY_NUMBER); }
		public TerminalNode BINARY_NUMBER(int i) {
			return getToken(RISCVParser.BINARY_NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(RISCVParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(RISCVParser.NUMBER, i);
		}
		public Preprocessor_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocessor_directive; }
	}

	public final Preprocessor_directiveContext preprocessor_directive() throws RecognitionException {
		Preprocessor_directiveContext _localctx = new Preprocessor_directiveContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_preprocessor_directive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(HASH_TAG);
			setState(231); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(230);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 540431963882782720L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(233); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MnemonicContext extends ParserRuleContext {
		public Mnemonic_aContext mnemonic_a() {
			return getRuleContext(Mnemonic_aContext.class,0);
		}
		public Mnemonic_bContext mnemonic_b() {
			return getRuleContext(Mnemonic_bContext.class,0);
		}
		public Mnemonic_cContext mnemonic_c() {
			return getRuleContext(Mnemonic_cContext.class,0);
		}
		public Mnemonic_jContext mnemonic_j() {
			return getRuleContext(Mnemonic_jContext.class,0);
		}
		public Mnemonic_lContext mnemonic_l() {
			return getRuleContext(Mnemonic_lContext.class,0);
		}
		public Mnemonic_mContext mnemonic_m() {
			return getRuleContext(Mnemonic_mContext.class,0);
		}
		public Mnemonic_sContext mnemonic_s() {
			return getRuleContext(Mnemonic_sContext.class,0);
		}
		public MnemonicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic; }
	}

	public final MnemonicContext mnemonic() throws RecognitionException {
		MnemonicContext _localctx = new MnemonicContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mnemonic);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case ADDI:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				mnemonic_a();
				}
				break;
			case BGT:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				mnemonic_b();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				mnemonic_c();
				}
				break;
			case J_:
			case JR:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				mnemonic_j();
				}
				break;
			case LI:
			case LW:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				mnemonic_l();
				}
				break;
			case MV:
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				mnemonic_m();
				}
				break;
			case SW:
				enterOuterAlt(_localctx, 7);
				{
				setState(241);
				mnemonic_s();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_aContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(RISCVParser.ADD, 0); }
		public TerminalNode ADDI() { return getToken(RISCVParser.ADDI, 0); }
		public Mnemonic_aContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_a; }
	}

	public final Mnemonic_aContext mnemonic_a() throws RecognitionException {
		Mnemonic_aContext _localctx = new Mnemonic_aContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mnemonic_a);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==ADDI) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_bContext extends ParserRuleContext {
		public TerminalNode BGT() { return getToken(RISCVParser.BGT, 0); }
		public Mnemonic_bContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_b; }
	}

	public final Mnemonic_bContext mnemonic_b() throws RecognitionException {
		Mnemonic_bContext _localctx = new Mnemonic_bContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mnemonic_b);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(BGT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_cContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(RISCVParser.CALL, 0); }
		public Mnemonic_cContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_c; }
	}

	public final Mnemonic_cContext mnemonic_c() throws RecognitionException {
		Mnemonic_cContext _localctx = new Mnemonic_cContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mnemonic_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(CALL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_jContext extends ParserRuleContext {
		public TerminalNode J_() { return getToken(RISCVParser.J_, 0); }
		public TerminalNode JR() { return getToken(RISCVParser.JR, 0); }
		public Mnemonic_jContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_j; }
	}

	public final Mnemonic_jContext mnemonic_j() throws RecognitionException {
		Mnemonic_jContext _localctx = new Mnemonic_jContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_mnemonic_j);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !(_la==J_ || _la==JR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_lContext extends ParserRuleContext {
		public TerminalNode LI() { return getToken(RISCVParser.LI, 0); }
		public TerminalNode LW() { return getToken(RISCVParser.LW, 0); }
		public Mnemonic_lContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_l; }
	}

	public final Mnemonic_lContext mnemonic_l() throws RecognitionException {
		Mnemonic_lContext _localctx = new Mnemonic_lContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_mnemonic_l);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==LI || _la==LW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_mContext extends ParserRuleContext {
		public TerminalNode MV() { return getToken(RISCVParser.MV, 0); }
		public Mnemonic_mContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_m; }
	}

	public final Mnemonic_mContext mnemonic_m() throws RecognitionException {
		Mnemonic_mContext _localctx = new Mnemonic_mContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mnemonic_m);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(MV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mnemonic_sContext extends ParserRuleContext {
		public TerminalNode SW() { return getToken(RISCVParser.SW, 0); }
		public Mnemonic_sContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_s; }
	}

	public final Mnemonic_sContext mnemonic_s() throws RecognitionException {
		Mnemonic_sContext _localctx = new Mnemonic_sContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mnemonic_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(SW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001:\u0103\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0001\u0000\u0005\u00007\b\u0000\n\u0000\f\u0000"+
		":\t\u0000\u0001\u0000\u0005\u0000=\b\u0000\n\u0000\f\u0000@\t\u0000\u0001"+
		"\u0000\u0005\u0000C\b\u0000\n\u0000\f\u0000F\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001M\b\u0001\u0001"+
		"\u0001\u0003\u0001P\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002V\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002Z\b\u0002"+
		"\u0003\u0002\\\b\u0002\u0001\u0003\u0003\u0003_\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003c\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003j\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0003\u0005p\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0085"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u009f\b\u0007\n\u0007\f\u0007\u00a2\t\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0003\t\u00aa\b\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00d9\b\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00e2\b\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0004\u000e\u00e8\b\u000e\u000b\u000e\f\u000e\u00e9\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00f3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0001"+
		"\u000e\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0005\u0002\u000088::\u0003\u0000"+
		"\u0017\u0017!!7:\u0001\u0000\u0001\u0002\u0001\u0000\u0005\u0006\u0001"+
		"\u0000\u0007\b\u0129\u00001\u0001\u0000\u0000\u0000\u0002O\u0001\u0000"+
		"\u0000\u0000\u0004Q\u0001\u0000\u0000\u0000\u0006i\u0001\u0000\u0000\u0000"+
		"\bk\u0001\u0000\u0000\u0000\no\u0001\u0000\u0000\u0000\fs\u0001\u0000"+
		"\u0000\u0000\u000e\u0084\u0001\u0000\u0000\u0000\u0010\u00a3\u0001\u0000"+
		"\u0000\u0000\u0012\u00a9\u0001\u0000\u0000\u0000\u0014\u00ad\u0001\u0000"+
		"\u0000\u0000\u0016\u00af\u0001\u0000\u0000\u0000\u0018\u00da\u0001\u0000"+
		"\u0000\u0000\u001a\u00dd\u0001\u0000\u0000\u0000\u001c\u00e5\u0001\u0000"+
		"\u0000\u0000\u001e\u00f2\u0001\u0000\u0000\u0000 \u00f4\u0001\u0000\u0000"+
		"\u0000\"\u00f6\u0001\u0000\u0000\u0000$\u00f8\u0001\u0000\u0000\u0000"+
		"&\u00fa\u0001\u0000\u0000\u0000(\u00fc\u0001\u0000\u0000\u0000*\u00fe"+
		"\u0001\u0000\u0000\u0000,\u0100\u0001\u0000\u0000\u0000.0\u00051\u0000"+
		"\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u00004>\u0003\u0002\u0001\u000057\u00051\u0000\u000065\u0001"+
		"\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000;=\u0003\u0002\u0001\u0000<8\u0001\u0000\u0000\u0000=@\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?D\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AC\u00051\u0000\u0000BA\u0001"+
		"\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000GH\u0005\u0000\u0000\u0001H\u0001\u0001\u0000\u0000\u0000IP\u0003"+
		"\u001c\u000e\u0000JP\u0003\u0016\u000b\u0000KM\u0003\b\u0004\u0000LK\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NP\u0003\u0004\u0002\u0000OI\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000"+
		"\u0000OL\u0001\u0000\u0000\u0000P\u0003\u0001\u0000\u0000\u0000Q[\u0003"+
		"\u001e\u000f\u0000RU\u0003\u0006\u0003\u0000ST\u0005\u0010\u0000\u0000"+
		"TV\u0003\u0006\u0003\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VY\u0001\u0000\u0000\u0000WX\u0005\u0010\u0000\u0000XZ\u0003\u0006"+
		"\u0003\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001"+
		"\u0000\u0000\u0000[R\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\\u0005\u0001\u0000\u0000\u0000]_\u0005&\u0000\u0000^]\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0005:\u0000"+
		"\u0000ac\u0005+\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cj\u0001\u0000\u0000\u0000dj\u0003\u0010\b\u0000ej\u0003\u000e\u0007"+
		"\u0000fj\u0003\u001a\r\u0000gj\u0003\f\u0006\u0000hj\u0003\n\u0005\u0000"+
		"i^\u0001\u0000\u0000\u0000id\u0001\u0000\u0000\u0000ie\u0001\u0000\u0000"+
		"\u0000if\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000j\u0007\u0001\u0000\u0000\u0000kl\u0003\n\u0005\u0000lm\u0005"+
		"\u000f\u0000\u0000m\t\u0001\u0000\u0000\u0000np\u0005\u0014\u0000\u0000"+
		"on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qr\u0005:\u0000\u0000r\u000b\u0001\u0000\u0000\u0000st\u0005\r\u0000"+
		"\u0000tu\u00057\u0000\u0000u\r\u0001\u0000\u0000\u0000vw\u0006\u0007\uffff"+
		"\uffff\u0000wx\u0005(\u0000\u0000xy\u0003\u000e\u0007\u0000yz\u0005\u000e"+
		"\u0000\u0000z\u0085\u0001\u0000\u0000\u0000{|\u0005&\u0000\u0000|\u0085"+
		"\u0003\u000e\u0007\b}\u0085\u00059\u0000\u0000~\u0085\u00058\u0000\u0000"+
		"\u007f\u0085\u00057\u0000\u0000\u0080\u0085\u0005:\u0000\u0000\u0081\u0085"+
		"\u00056\u0000\u0000\u0082\u0085\u0003\f\u0006\u0000\u0083\u0085\u0005"+
		"\u0014\u0000\u0000\u0084v\u0001\u0000\u0000\u0000\u0084{\u0001\u0000\u0000"+
		"\u0000\u0084}\u0001\u0000\u0000\u0000\u0084~\u0001\u0000\u0000\u0000\u0084"+
		"\u007f\u0001\u0000\u0000\u0000\u0084\u0080\u0001\u0000\u0000\u0000\u0084"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u00a0\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\n\u0010\u0000\u0000\u0087\u0088\u0005#\u0000\u0000\u0088\u009f"+
		"\u0003\u000e\u0007\u0011\u0089\u008a\n\u000f\u0000\u0000\u008a\u008b\u0005"+
		",\u0000\u0000\u008b\u009f\u0003\u000e\u0007\u0010\u008c\u008d\n\u000e"+
		"\u0000\u0000\u008d\u008e\u0005.\u0000\u0000\u008e\u009f\u0003\u000e\u0007"+
		"\u000f\u008f\u0090\n\r\u0000\u0000\u0090\u0091\u0005\u001e\u0000\u0000"+
		"\u0091\u009f\u0003\u000e\u0007\u000e\u0092\u0093\n\f\u0000\u0000\u0093"+
		"\u0094\u0005$\u0000\u0000\u0094\u009f\u0003\u000e\u0007\r\u0095\u0096"+
		"\n\u000b\u0000\u0000\u0096\u0097\u0005\u0018\u0000\u0000\u0097\u009f\u0003"+
		"\u000e\u0007\f\u0098\u0099\n\n\u0000\u0000\u0099\u009a\u0005&\u0000\u0000"+
		"\u009a\u009f\u0003\u000e\u0007\u000b\u009b\u009c\n\t\u0000\u0000\u009c"+
		"\u009d\u0005+\u0000\u0000\u009d\u009f\u0003\u000e\u0007\n\u009e\u0086"+
		"\u0001\u0000\u0000\u0000\u009e\u0089\u0001\u0000\u0000\u0000\u009e\u008c"+
		"\u0001\u0000\u0000\u0000\u009e\u008f\u0001\u0000\u0000\u0000\u009e\u0092"+
		"\u0001\u0000\u0000\u0000\u009e\u0095\u0001\u0000\u0000\u0000\u009e\u0098"+
		"\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009f\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u000f\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0003\u0012\t\u0000\u00a4\u00a5\u0005"+
		"(\u0000\u0000\u00a5\u00a6\u0003\u0014\n\u0000\u00a6\u00a7\u0005\u000e"+
		"\u0000\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00aa\u0005&\u0000"+
		"\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u00057\u0000\u0000"+
		"\u00ac\u0013\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005:\u0000\u0000\u00ae"+
		"\u0015\u0001\u0000\u0000\u0000\u00af\u00d8\u0005\u0014\u0000\u0000\u00b0"+
		"\u00b1\u0005\"\u0000\u0000\u00b1\u00d9\u00056\u0000\u0000\u00b2\u00b3"+
		"\u0005\u0013\u0000\u0000\u00b3\u00d9\u0005:\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0012\u0000\u0000\u00b5\u00d9\u0003\u000e\u0007\u0000\u00b6\u00b7\u0005"+
		"\u0019\u0000\u0000\u00b7\u00d9\u0003\u000e\u0007\u0000\u00b8\u00d9\u0005"+
		"\u0011\u0000\u0000\u00b9\u00ba\u0005*\u0000\u0000\u00ba\u00d9\u0007\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0005%\u0000\u0000\u00bc\u00d9\u0005:\u0000\u0000"+
		"\u00bd\u00d9\u0005\u0016\u0000\u0000\u00be\u00bf\u0005!\u0000\u0000\u00bf"+
		"\u00d9\u0003\u000e\u0007\u0000\u00c0\u00d9\u0005\u0015\u0000\u0000\u00c1"+
		"\u00d9\u0005\u0017\u0000\u0000\u00c2\u00c3\u0005\u001a\u0000\u0000\u00c3"+
		"\u00d9\u00056\u0000\u0000\u00c4\u00c5\u0005\u001b\u0000\u0000\u00c5\u00d9"+
		"\u00056\u0000\u0000\u00c6\u00d9\u0005/\u0000\u0000\u00c7\u00c8\u0005 "+
		"\u0000\u0000\u00c8\u00d9\u00056\u0000\u0000\u00c9\u00ca\u0005-\u0000\u0000"+
		"\u00ca\u00cb\u0003\u000e\u0007\u0000\u00cb\u00cc\u0005\u0010\u0000\u0000"+
		"\u00cc\u00cd\u0003\u000e\u0007\u0000\u00cd\u00d9\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0005\u000b\u0000\u0000\u00cf\u00d9\u00057\u0000\u0000\u00d0"+
		"\u00d1\u0005\u001d\u0000\u0000\u00d1\u00d9\u0005:\u0000\u0000\u00d2\u00d3"+
		"\u00050\u0000\u0000\u00d3\u00d4\u0005:\u0000\u0000\u00d4\u00d5\u0005\u0010"+
		"\u0000\u0000\u00d5\u00d9\u0003\u0018\f\u0000\u00d6\u00d7\u0005)\u0000"+
		"\u0000\u00d7\u00d9\u0005\'\u0000\u0000\u00d8\u00b0\u0001\u0000\u0000\u0000"+
		"\u00d8\u00b2\u0001\u0000\u0000\u0000\u00d8\u00b4\u0001\u0000\u0000\u0000"+
		"\u00d8\u00b6\u0001\u0000\u0000\u0000\u00d8\u00b8\u0001\u0000\u0000\u0000"+
		"\u00d8\u00b9\u0001\u0000\u0000\u0000\u00d8\u00bb\u0001\u0000\u0000\u0000"+
		"\u00d8\u00bd\u0001\u0000\u0000\u0000\u00d8\u00be\u0001\u0000\u0000\u0000"+
		"\u00d8\u00c0\u0001\u0000\u0000\u0000\u00d8\u00c1\u0001\u0000\u0000\u0000"+
		"\u00d8\u00c2\u0001\u0000\u0000\u0000\u00d8\u00c4\u0001\u0000\u0000\u0000"+
		"\u00d8\u00c6\u0001\u0000\u0000\u0000\u00d8\u00c7\u0001\u0000\u0000\u0000"+
		"\u00d8\u00c9\u0001\u0000\u0000\u0000\u00d8\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d0\u0001\u0000\u0000\u0000\u00d8\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u0017\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u0005\r\u0000\u0000\u00db\u00dc\u0005\u001c\u0000\u0000\u00dc"+
		"\u0019\u0001\u0000\u0000\u0000\u00dd\u00de\u0005:\u0000\u0000\u00de\u00e1"+
		"\u0005(\u0000\u0000\u00df\u00e2\u0005:\u0000\u0000\u00e0\u00e2\u0003\f"+
		"\u0006\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u000e"+
		"\u0000\u0000\u00e4\u001b\u0001\u0000\u0000\u0000\u00e5\u00e7\u0005\u001f"+
		"\u0000\u0000\u00e6\u00e8\u0007\u0001\u0000\u0000\u00e7\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001d\u0001\u0000"+
		"\u0000\u0000\u00eb\u00f3\u0003 \u0010\u0000\u00ec\u00f3\u0003\"\u0011"+
		"\u0000\u00ed\u00f3\u0003$\u0012\u0000\u00ee\u00f3\u0003&\u0013\u0000\u00ef"+
		"\u00f3\u0003(\u0014\u0000\u00f0\u00f3\u0003*\u0015\u0000\u00f1\u00f3\u0003"+
		",\u0016\u0000\u00f2\u00eb\u0001\u0000\u0000\u0000\u00f2\u00ec\u0001\u0000"+
		"\u0000\u0000\u00f2\u00ed\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f2\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u001f\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0007\u0002\u0000\u0000\u00f5!\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0005\u0003\u0000\u0000\u00f7#\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0005\u0004\u0000\u0000\u00f9%\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0007\u0003\u0000\u0000\u00fb\'\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0007\u0004\u0000\u0000\u00fd)\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005"+
		"\t\u0000\u0000\u00ff+\u0001\u0000\u0000\u0000\u0100\u0101\u0005\n\u0000"+
		"\u0000\u0101-\u0001\u0000\u0000\u0000\u001518>DLOUY[^bio\u0084\u009e\u00a0"+
		"\u00a9\u00d8\u00e1\u00e9\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}