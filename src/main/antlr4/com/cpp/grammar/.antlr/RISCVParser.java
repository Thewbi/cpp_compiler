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
		RULE_asm_file = 0, RULE_newline = 1, RULE_row = 2, RULE_comment = 3, RULE_instruction_row = 4, 
		RULE_instruction = 5, RULE_param = 6, RULE_label_definition = 7, RULE_label_name = 8, 
		RULE_macro_placeholder = 9, RULE_expression = 10, RULE_offset_expression = 11, 
		RULE_offset_expression_amount = 12, RULE_offset_expression_register = 13, 
		RULE_asm_intrinsic_instruction = 14, RULE_entity_type = 15, RULE_asm_intrinsic_usage = 16, 
		RULE_preprocessor_directive = 17, RULE_mnemonic = 18, RULE_mnemonic_a = 19, 
		RULE_mnemonic_b = 20, RULE_mnemonic_c = 21, RULE_mnemonic_j = 22, RULE_mnemonic_l = 23, 
		RULE_mnemonic_m = 24, RULE_mnemonic_s = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"asm_file", "newline", "row", "comment", "instruction_row", "instruction", 
			"param", "label_definition", "label_name", "macro_placeholder", "expression", 
			"offset_expression", "offset_expression_amount", "offset_expression_register", 
			"asm_intrinsic_instruction", "entity_type", "asm_intrinsic_usage", "preprocessor_directive", 
			"mnemonic", "mnemonic_a", "mnemonic_b", "mnemonic_c", "mnemonic_j", "mnemonic_l", 
			"mnemonic_m", "mnemonic_s"
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
		public TerminalNode EOF() { return getToken(RISCVParser.EOF, 0); }
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
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
			setState(59); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(55);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(52);
							newline();
							}
							} 
						}
						setState(57);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					}
					setState(58);
					row();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(61); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(63);
				newline();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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
	public static class NewlineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(RISCVParser.NEWLINE, 0); }
		public NewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newline; }
	}

	public final NewlineContext newline() throws RecognitionException {
		NewlineContext _localctx = new NewlineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_newline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(NEWLINE);
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
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public Preprocessor_directiveContext preprocessor_directive() {
			return getRuleContext(Preprocessor_directiveContext.class,0);
		}
		public Asm_intrinsic_instructionContext asm_intrinsic_instruction() {
			return getRuleContext(Asm_intrinsic_instructionContext.class,0);
		}
		public Instruction_rowContext instruction_row() {
			return getRuleContext(Instruction_rowContext.class,0);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_row);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				comment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				preprocessor_directive();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				asm_intrinsic_instruction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				instruction_row();
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
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT() { return getToken(RISCVParser.LINE_COMMENT, 0); }
		public TerminalNode DOUBLE_SLASH_LINE_COMMENT() { return getToken(RISCVParser.DOUBLE_SLASH_LINE_COMMENT, 0); }
		public TerminalNode BLOCK_COMMENT() { return getToken(RISCVParser.BLOCK_COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15762598695796736L) != 0)) ) {
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
	public static class Instruction_rowContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public Label_definitionContext label_definition() {
			return getRuleContext(Label_definitionContext.class,0);
		}
		public NewlineContext newline() {
			return getRuleContext(NewlineContext.class,0);
		}
		public Instruction_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_row; }
	}

	public final Instruction_rowContext instruction_row() throws RecognitionException {
		Instruction_rowContext _localctx = new Instruction_rowContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruction_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT || _la==IDENTIFIER) {
				{
				setState(81);
				label_definition();
				}
			}

			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(84);
				newline();
				}
			}

			setState(87);
			instruction();
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
		enterRule(_localctx, 10, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			mnemonic();
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(90);
				param();
				setState(93);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(91);
					match(COMMA);
					setState(92);
					param();
					}
					break;
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(95);
					match(COMMA);
					setState(96);
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
		enterRule(_localctx, 12, RULE_param);
		int _la;
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(101);
					match(MINUS);
					}
				}

				setState(104);
				match(IDENTIFIER);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS) {
					{
					setState(105);
					match(PLUS);
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				offset_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				asm_intrinsic_usage();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				macro_placeholder();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
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
		enterRule(_localctx, 14, RULE_label_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			label_name();
			setState(116);
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
		enterRule(_localctx, 16, RULE_label_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(118);
				match(DOT);
				}
			}

			setState(121);
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
		enterRule(_localctx, 18, RULE_macro_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(AT);
			setState(124);
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
		public TerminalNode PLUS() { return getToken(RISCVParser.PLUS, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENING_BRACKET:
				{
				setState(127);
				match(OPENING_BRACKET);
				setState(128);
				expression(0);
				setState(129);
				match(CLOSEING_BRACKET);
				}
				break;
			case PLUS:
				{
				setState(131);
				match(PLUS);
				setState(132);
				expression(9);
				}
				break;
			case MINUS:
				{
				setState(133);
				match(MINUS);
				setState(134);
				expression(8);
				}
				break;
			case BINARY_NUMBER:
				{
				setState(135);
				match(BINARY_NUMBER);
				}
				break;
			case HEX_NUMBER:
				{
				setState(136);
				match(HEX_NUMBER);
				}
				break;
			case NUMBER:
				{
				setState(137);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(138);
				match(IDENTIFIER);
				}
				break;
			case STRING:
				{
				setState(139);
				match(STRING);
				}
				break;
			case AT:
				{
				setState(140);
				macro_placeholder();
				}
				break;
			case DOT:
				{
				setState(141);
				match(DOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(145);
						match(LEFT_SHIFT);
						setState(146);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(148);
						match(RIGHT_SHIFT);
						setState(149);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(151);
						match(SLASH);
						setState(152);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(154);
						match(GT);
						setState(155);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(157);
						match(LT);
						setState(158);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(160);
						match(EQUALS);
						setState(161);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(163);
						match(MINUS);
						setState(164);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(166);
						match(PLUS);
						setState(167);
						expression(11);
						}
						break;
					}
					} 
				}
				setState(172);
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
		enterRule(_localctx, 22, RULE_offset_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			offset_expression_amount();
			setState(174);
			match(OPENING_BRACKET);
			setState(175);
			offset_expression_register();
			setState(176);
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
		enterRule(_localctx, 24, RULE_offset_expression_amount);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(178);
				match(MINUS);
				}
			}

			setState(181);
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
		enterRule(_localctx, 26, RULE_offset_expression_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
		enterRule(_localctx, 28, RULE_asm_intrinsic_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(DOT);
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCLUDE:
				{
				setState(186);
				match(INCLUDE);
				setState(187);
				match(STRING);
				}
				break;
			case DEVICE:
				{
				setState(188);
				match(DEVICE);
				setState(189);
				match(IDENTIFIER);
				}
				break;
			case DEF:
				{
				setState(190);
				match(DEF);
				setState(191);
				expression(0);
				}
				break;
			case EQU:
				{
				setState(192);
				match(EQU);
				setState(193);
				expression(0);
				}
				break;
			case CSEG:
				{
				setState(194);
				match(CSEG);
				}
				break;
			case ORG:
				{
				setState(195);
				match(ORG);
				setState(196);
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
				setState(197);
				match(MACRO);
				setState(198);
				match(IDENTIFIER);
				}
				break;
			case END_MACRO:
				{
				setState(199);
				match(END_MACRO);
				}
				break;
			case IF:
				{
				setState(200);
				match(IF);
				setState(201);
				expression(0);
				}
				break;
			case ELSE:
				{
				setState(202);
				match(ELSE);
				}
				break;
			case ENDIF:
				{
				setState(203);
				match(ENDIF);
				}
				break;
			case ERROR:
				{
				setState(204);
				match(ERROR);
				setState(205);
				match(STRING);
				}
				break;
			case FILE:
				{
				setState(206);
				match(FILE);
				setState(207);
				match(STRING);
				}
				break;
			case TEXT:
				{
				setState(208);
				match(TEXT);
				}
				break;
			case IDENT:
				{
				setState(209);
				match(IDENT);
				setState(210);
				match(STRING);
				}
				break;
			case SIZE:
				{
				setState(211);
				match(SIZE);
				setState(212);
				expression(0);
				setState(213);
				match(COMMA);
				setState(214);
				expression(0);
				}
				break;
			case ALIGN:
				{
				setState(216);
				match(ALIGN);
				setState(217);
				match(NUMBER);
				}
				break;
			case GLOBL:
				{
				setState(218);
				match(GLOBL);
				setState(219);
				match(IDENTIFIER);
				}
				break;
			case TYPE:
				{
				setState(220);
				match(TYPE);
				{
				setState(221);
				match(IDENTIFIER);
				setState(222);
				match(COMMA);
				setState(223);
				entity_type();
				}
				}
				break;
			case OPTION:
				{
				setState(224);
				match(OPTION);
				{
				setState(225);
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
		enterRule(_localctx, 30, RULE_entity_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(AT);
			{
			setState(229);
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
		enterRule(_localctx, 32, RULE_asm_intrinsic_usage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(IDENTIFIER);
			setState(232);
			match(OPENING_BRACKET);
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(233);
				match(IDENTIFIER);
				}
				break;
			case AT:
				{
				setState(234);
				macro_placeholder();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(237);
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
		enterRule(_localctx, 34, RULE_preprocessor_directive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(HASH_TAG);
			setState(241); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(240);
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
				setState(243); 
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
		enterRule(_localctx, 36, RULE_mnemonic);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case ADDI:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				mnemonic_a();
				}
				break;
			case BGT:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				mnemonic_b();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				mnemonic_c();
				}
				break;
			case J_:
			case JR:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				mnemonic_j();
				}
				break;
			case LI:
			case LW:
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				mnemonic_l();
				}
				break;
			case MV:
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				mnemonic_m();
				}
				break;
			case SW:
				enterOuterAlt(_localctx, 7);
				{
				setState(251);
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
		enterRule(_localctx, 38, RULE_mnemonic_a);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
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
		enterRule(_localctx, 40, RULE_mnemonic_b);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
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
		enterRule(_localctx, 42, RULE_mnemonic_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
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
		enterRule(_localctx, 44, RULE_mnemonic_j);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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
		enterRule(_localctx, 46, RULE_mnemonic_l);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
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
		enterRule(_localctx, 48, RULE_mnemonic_m);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
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
		enterRule(_localctx, 50, RULE_mnemonic_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
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
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001:\u010d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0005\u00006\b\u0000\n\u0000\f\u0000"+
		"9\t\u0000\u0001\u0000\u0004\u0000<\b\u0000\u000b\u0000\f\u0000=\u0001"+
		"\u0000\u0005\u0000A\b\u0000\n\u0000\f\u0000D\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002N\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0003"+
		"\u0004S\b\u0004\u0001\u0004\u0003\u0004V\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005^\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005b\b\u0005\u0003\u0005d\b\u0005\u0001"+
		"\u0006\u0003\u0006g\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006k\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"r\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0003\bx\b\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u008f\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u00a9\b\n\n\n\f\n\u00ac\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u00b4\b\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00e3\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ec\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0004\u0011\u00f2\b\u0011"+
		"\u000b\u0011\f\u0011\u00f3\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00fd\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0000\u0001\u0014\u001a\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02\u0000\u0006\u0001\u000035\u0002\u000088::\u0003\u0000\u0017\u0017!"+
		"!7:\u0001\u0000\u0001\u0002\u0001\u0000\u0005\u0006\u0001\u0000\u0007"+
		"\b\u0132\u0000;\u0001\u0000\u0000\u0000\u0002G\u0001\u0000\u0000\u0000"+
		"\u0004M\u0001\u0000\u0000\u0000\u0006O\u0001\u0000\u0000\u0000\bR\u0001"+
		"\u0000\u0000\u0000\nY\u0001\u0000\u0000\u0000\fq\u0001\u0000\u0000\u0000"+
		"\u000es\u0001\u0000\u0000\u0000\u0010w\u0001\u0000\u0000\u0000\u0012{"+
		"\u0001\u0000\u0000\u0000\u0014\u008e\u0001\u0000\u0000\u0000\u0016\u00ad"+
		"\u0001\u0000\u0000\u0000\u0018\u00b3\u0001\u0000\u0000\u0000\u001a\u00b7"+
		"\u0001\u0000\u0000\u0000\u001c\u00b9\u0001\u0000\u0000\u0000\u001e\u00e4"+
		"\u0001\u0000\u0000\u0000 \u00e7\u0001\u0000\u0000\u0000\"\u00ef\u0001"+
		"\u0000\u0000\u0000$\u00fc\u0001\u0000\u0000\u0000&\u00fe\u0001\u0000\u0000"+
		"\u0000(\u0100\u0001\u0000\u0000\u0000*\u0102\u0001\u0000\u0000\u0000,"+
		"\u0104\u0001\u0000\u0000\u0000.\u0106\u0001\u0000\u0000\u00000\u0108\u0001"+
		"\u0000\u0000\u00002\u010a\u0001\u0000\u0000\u000046\u0003\u0002\u0001"+
		"\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u000097\u0001"+
		"\u0000\u0000\u0000:<\u0003\u0004\u0002\u0000;7\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>B\u0001\u0000\u0000\u0000?A\u0003\u0002\u0001\u0000@?\u0001\u0000"+
		"\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001"+
		"\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"EF\u0005\u0000\u0000\u0001F\u0001\u0001\u0000\u0000\u0000GH\u00051\u0000"+
		"\u0000H\u0003\u0001\u0000\u0000\u0000IN\u0003\u0006\u0003\u0000JN\u0003"+
		"\"\u0011\u0000KN\u0003\u001c\u000e\u0000LN\u0003\b\u0004\u0000MI\u0001"+
		"\u0000\u0000\u0000MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"ML\u0001\u0000\u0000\u0000N\u0005\u0001\u0000\u0000\u0000OP\u0007\u0000"+
		"\u0000\u0000P\u0007\u0001\u0000\u0000\u0000QS\u0003\u000e\u0007\u0000"+
		"RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000"+
		"\u0000TV\u0003\u0002\u0001\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0003\n\u0005\u0000X\t\u0001"+
		"\u0000\u0000\u0000Yc\u0003$\u0012\u0000Z]\u0003\f\u0006\u0000[\\\u0005"+
		"\u0010\u0000\u0000\\^\u0003\f\u0006\u0000][\u0001\u0000\u0000\u0000]^"+
		"\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_`\u0005\u0010\u0000"+
		"\u0000`b\u0003\f\u0006\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bd\u0001\u0000\u0000\u0000cZ\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000d\u000b\u0001\u0000\u0000\u0000eg\u0005&\u0000\u0000fe\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hj\u0005:\u0000\u0000ik\u0005+\u0000\u0000ji\u0001\u0000\u0000\u0000j"+
		"k\u0001\u0000\u0000\u0000kr\u0001\u0000\u0000\u0000lr\u0003\u0016\u000b"+
		"\u0000mr\u0003\u0014\n\u0000nr\u0003 \u0010\u0000or\u0003\u0012\t\u0000"+
		"pr\u0003\u0010\b\u0000qf\u0001\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000"+
		"qm\u0001\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qp\u0001\u0000\u0000\u0000r\r\u0001\u0000\u0000\u0000st\u0003\u0010"+
		"\b\u0000tu\u0005\u000f\u0000\u0000u\u000f\u0001\u0000\u0000\u0000vx\u0005"+
		"\u0014\u0000\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000yz\u0005:\u0000\u0000z\u0011\u0001\u0000\u0000"+
		"\u0000{|\u0005\r\u0000\u0000|}\u00057\u0000\u0000}\u0013\u0001\u0000\u0000"+
		"\u0000~\u007f\u0006\n\uffff\uffff\u0000\u007f\u0080\u0005(\u0000\u0000"+
		"\u0080\u0081\u0003\u0014\n\u0000\u0081\u0082\u0005\u000e\u0000\u0000\u0082"+
		"\u008f\u0001\u0000\u0000\u0000\u0083\u0084\u0005+\u0000\u0000\u0084\u008f"+
		"\u0003\u0014\n\t\u0085\u0086\u0005&\u0000\u0000\u0086\u008f\u0003\u0014"+
		"\n\b\u0087\u008f\u00059\u0000\u0000\u0088\u008f\u00058\u0000\u0000\u0089"+
		"\u008f\u00057\u0000\u0000\u008a\u008f\u0005:\u0000\u0000\u008b\u008f\u0005"+
		"6\u0000\u0000\u008c\u008f\u0003\u0012\t\u0000\u008d\u008f\u0005\u0014"+
		"\u0000\u0000\u008e~\u0001\u0000\u0000\u0000\u008e\u0083\u0001\u0000\u0000"+
		"\u0000\u008e\u0085\u0001\u0000\u0000\u0000\u008e\u0087\u0001\u0000\u0000"+
		"\u0000\u008e\u0088\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000\u0000"+
		"\u0000\u008e\u008a\u0001\u0000\u0000\u0000\u008e\u008b\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u00aa\u0001\u0000\u0000\u0000\u0090\u0091\n\u0011\u0000\u0000"+
		"\u0091\u0092\u0005#\u0000\u0000\u0092\u00a9\u0003\u0014\n\u0012\u0093"+
		"\u0094\n\u0010\u0000\u0000\u0094\u0095\u0005,\u0000\u0000\u0095\u00a9"+
		"\u0003\u0014\n\u0011\u0096\u0097\n\u000f\u0000\u0000\u0097\u0098\u0005"+
		".\u0000\u0000\u0098\u00a9\u0003\u0014\n\u0010\u0099\u009a\n\u000e\u0000"+
		"\u0000\u009a\u009b\u0005\u001e\u0000\u0000\u009b\u00a9\u0003\u0014\n\u000f"+
		"\u009c\u009d\n\r\u0000\u0000\u009d\u009e\u0005$\u0000\u0000\u009e\u00a9"+
		"\u0003\u0014\n\u000e\u009f\u00a0\n\f\u0000\u0000\u00a0\u00a1\u0005\u0018"+
		"\u0000\u0000\u00a1\u00a9\u0003\u0014\n\r\u00a2\u00a3\n\u000b\u0000\u0000"+
		"\u00a3\u00a4\u0005&\u0000\u0000\u00a4\u00a9\u0003\u0014\n\f\u00a5\u00a6"+
		"\n\n\u0000\u0000\u00a6\u00a7\u0005+\u0000\u0000\u00a7\u00a9\u0003\u0014"+
		"\n\u000b\u00a8\u0090\u0001\u0000\u0000\u0000\u00a8\u0093\u0001\u0000\u0000"+
		"\u0000\u00a8\u0096\u0001\u0000\u0000\u0000\u00a8\u0099\u0001\u0000\u0000"+
		"\u0000\u00a8\u009c\u0001\u0000\u0000\u0000\u00a8\u009f\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a2\u0001\u0000\u0000\u0000\u00a8\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u0015\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003\u0018\f\u0000"+
		"\u00ae\u00af\u0005(\u0000\u0000\u00af\u00b0\u0003\u001a\r\u0000\u00b0"+
		"\u00b1\u0005\u000e\u0000\u0000\u00b1\u0017\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b4\u0005&\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u00057\u0000\u0000\u00b6\u0019\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005"+
		":\u0000\u0000\u00b8\u001b\u0001\u0000\u0000\u0000\u00b9\u00e2\u0005\u0014"+
		"\u0000\u0000\u00ba\u00bb\u0005\"\u0000\u0000\u00bb\u00e3\u00056\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0013\u0000\u0000\u00bd\u00e3\u0005:\u0000\u0000"+
		"\u00be\u00bf\u0005\u0012\u0000\u0000\u00bf\u00e3\u0003\u0014\n\u0000\u00c0"+
		"\u00c1\u0005\u0019\u0000\u0000\u00c1\u00e3\u0003\u0014\n\u0000\u00c2\u00e3"+
		"\u0005\u0011\u0000\u0000\u00c3\u00c4\u0005*\u0000\u0000\u00c4\u00e3\u0007"+
		"\u0001\u0000\u0000\u00c5\u00c6\u0005%\u0000\u0000\u00c6\u00e3\u0005:\u0000"+
		"\u0000\u00c7\u00e3\u0005\u0016\u0000\u0000\u00c8\u00c9\u0005!\u0000\u0000"+
		"\u00c9\u00e3\u0003\u0014\n\u0000\u00ca\u00e3\u0005\u0015\u0000\u0000\u00cb"+
		"\u00e3\u0005\u0017\u0000\u0000\u00cc\u00cd\u0005\u001a\u0000\u0000\u00cd"+
		"\u00e3\u00056\u0000\u0000\u00ce\u00cf\u0005\u001b\u0000\u0000\u00cf\u00e3"+
		"\u00056\u0000\u0000\u00d0\u00e3\u0005/\u0000\u0000\u00d1\u00d2\u0005 "+
		"\u0000\u0000\u00d2\u00e3\u00056\u0000\u0000\u00d3\u00d4\u0005-\u0000\u0000"+
		"\u00d4\u00d5\u0003\u0014\n\u0000\u00d5\u00d6\u0005\u0010\u0000\u0000\u00d6"+
		"\u00d7\u0003\u0014\n\u0000\u00d7\u00e3\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0005\u000b\u0000\u0000\u00d9\u00e3\u00057\u0000\u0000\u00da\u00db\u0005"+
		"\u001d\u0000\u0000\u00db\u00e3\u0005:\u0000\u0000\u00dc\u00dd\u00050\u0000"+
		"\u0000\u00dd\u00de\u0005:\u0000\u0000\u00de\u00df\u0005\u0010\u0000\u0000"+
		"\u00df\u00e3\u0003\u001e\u000f\u0000\u00e0\u00e1\u0005)\u0000\u0000\u00e1"+
		"\u00e3\u0005\'\u0000\u0000\u00e2\u00ba\u0001\u0000\u0000\u0000\u00e2\u00bc"+
		"\u0001\u0000\u0000\u0000\u00e2\u00be\u0001\u0000\u0000\u0000\u00e2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00c2\u0001\u0000\u0000\u0000\u00e2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00c5\u0001\u0000\u0000\u0000\u00e2\u00c7"+
		"\u0001\u0000\u0000\u0000\u00e2\u00c8\u0001\u0000\u0000\u0000\u00e2\u00ca"+
		"\u0001\u0000\u0000\u0000\u00e2\u00cb\u0001\u0000\u0000\u0000\u00e2\u00cc"+
		"\u0001\u0000\u0000\u0000\u00e2\u00ce\u0001\u0000\u0000\u0000\u00e2\u00d0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00d1\u0001\u0000\u0000\u0000\u00e2\u00d3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00d8\u0001\u0000\u0000\u0000\u00e2\u00da"+
		"\u0001\u0000\u0000\u0000\u00e2\u00dc\u0001\u0000\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e3\u001d\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0005\r\u0000\u0000\u00e5\u00e6\u0005\u001c\u0000\u0000\u00e6\u001f\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0005:\u0000\u0000\u00e8\u00eb\u0005(\u0000"+
		"\u0000\u00e9\u00ec\u0005:\u0000\u0000\u00ea\u00ec\u0003\u0012\t\u0000"+
		"\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u000e\u0000\u0000"+
		"\u00ee!\u0001\u0000\u0000\u0000\u00ef\u00f1\u0005\u001f\u0000\u0000\u00f0"+
		"\u00f2\u0007\u0002\u0000\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f4#\u0001\u0000\u0000\u0000\u00f5\u00fd"+
		"\u0003&\u0013\u0000\u00f6\u00fd\u0003(\u0014\u0000\u00f7\u00fd\u0003*"+
		"\u0015\u0000\u00f8\u00fd\u0003,\u0016\u0000\u00f9\u00fd\u0003.\u0017\u0000"+
		"\u00fa\u00fd\u00030\u0018\u0000\u00fb\u00fd\u00032\u0019\u0000\u00fc\u00f5"+
		"\u0001\u0000\u0000\u0000\u00fc\u00f6\u0001\u0000\u0000\u0000\u00fc\u00f7"+
		"\u0001\u0000\u0000\u0000\u00fc\u00f8\u0001\u0000\u0000\u0000\u00fc\u00f9"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fd%\u0001\u0000\u0000\u0000\u00fe\u00ff\u0007"+
		"\u0003\u0000\u0000\u00ff\'\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0003"+
		"\u0000\u0000\u0101)\u0001\u0000\u0000\u0000\u0102\u0103\u0005\u0004\u0000"+
		"\u0000\u0103+\u0001\u0000\u0000\u0000\u0104\u0105\u0007\u0004\u0000\u0000"+
		"\u0105-\u0001\u0000\u0000\u0000\u0106\u0107\u0007\u0005\u0000\u0000\u0107"+
		"/\u0001\u0000\u0000\u0000\u0108\u0109\u0005\t\u0000\u0000\u01091\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0005\n\u0000\u0000\u010b3\u0001\u0000"+
		"\u0000\u0000\u00157=BMRU]acfjqw\u008e\u00a8\u00aa\u00b3\u00e2\u00eb\u00f3"+
		"\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}