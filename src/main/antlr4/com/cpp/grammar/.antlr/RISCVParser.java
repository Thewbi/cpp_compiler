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
		ADD=1, ADDI=2, BEQ=3, BGT=4, CALL=5, CSRW=6, CSRSI=7, ECALL=8, J_=9, JAL=10, 
		JR=11, LA=12, LI=13, LW=14, MV=15, SW=16, ALIGN=17, ASTERISK=18, AT=19, 
		CLOSEING_BRACKET=20, COLON=21, COMMA=22, CSEG=23, DATA=24, DEF=25, DEVICE=26, 
		DOT=27, ELSE=28, END_MACRO=29, ENDIF=30, EQUALS=31, EQU=32, ERROR=33, 
		FILE=34, FUNCTION=35, GLOBL=36, GT=37, HASH_TAG=38, IDENT=39, IF=40, INCLUDE=41, 
		LEFT_SHIFT=42, LT=43, MACRO=44, MINUS=45, NOPIC=46, OPENING_BRACKET=47, 
		OPTION=48, ORG=49, PLUS=50, RIGHT_SHIFT=51, SIZE=52, SLASH=53, SPACE=54, 
		STRING_KEYWORD=55, TEXT=56, TYPE=57, WORD=58, NEWLINE=59, WS=60, LINE_COMMENT=61, 
		BLOCK_COMMENT=62, DOUBLE_SLASH_LINE_COMMENT=63, STRING=64, NUMBER=65, 
		HEX_NUMBER=66, BINARY_NUMBER=67, IDENTIFIER=68;
	public static final int
		RULE_asm_file = 0, RULE_newline = 1, RULE_label_definition = 2, RULE_row = 3, 
		RULE_expression_list = 4, RULE_comment = 5, RULE_instruction_row = 6, 
		RULE_instruction = 7, RULE_param = 8, RULE_label_name = 9, RULE_macro_placeholder = 10, 
		RULE_expression = 11, RULE_offset_expression = 12, RULE_offset_expression_amount = 13, 
		RULE_offset_expression_register = 14, RULE_asm_intrinsic_instruction = 15, 
		RULE_entity_type = 16, RULE_asm_intrinsic_usage = 17, RULE_preprocessor_directive = 18, 
		RULE_mnemonic = 19, RULE_mnemonic_a = 20, RULE_mnemonic_b = 21, RULE_mnemonic_c = 22, 
		RULE_mnemonic_e = 23, RULE_mnemonic_j = 24, RULE_mnemonic_l = 25, RULE_mnemonic_m = 26, 
		RULE_mnemonic_s = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"asm_file", "newline", "label_definition", "row", "expression_list", 
			"comment", "instruction_row", "instruction", "param", "label_name", "macro_placeholder", 
			"expression", "offset_expression", "offset_expression_amount", "offset_expression_register", 
			"asm_intrinsic_instruction", "entity_type", "asm_intrinsic_usage", "preprocessor_directive", 
			"mnemonic", "mnemonic_a", "mnemonic_b", "mnemonic_c", "mnemonic_e", "mnemonic_j", 
			"mnemonic_l", "mnemonic_m", "mnemonic_s"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'align'", "'*'", "'@'", "')'", "':'", 
			"','", "'cseg'", "'data'", "'def'", "'device'", "'.'", "'else'", "'endmacro'", 
			"'endif'", "'='", null, "'error'", "'file'", "'function'", "'globl'", 
			"'>'", "'#'", "'ident'", "'if'", "'include'", "'<<'", "'<'", "'macro'", 
			"'-'", "'nopic'", "'('", "'option'", "'org'", "'+'", "'>>'", "'size'", 
			"'/'", "'space'", "'string'", "'text'", "'type'", "'word'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "ADDI", "BEQ", "BGT", "CALL", "CSRW", "CSRSI", "ECALL", 
			"J_", "JAL", "JR", "LA", "LI", "LW", "MV", "SW", "ALIGN", "ASTERISK", 
			"AT", "CLOSEING_BRACKET", "COLON", "COMMA", "CSEG", "DATA", "DEF", "DEVICE", 
			"DOT", "ELSE", "END_MACRO", "ENDIF", "EQUALS", "EQU", "ERROR", "FILE", 
			"FUNCTION", "GLOBL", "GT", "HASH_TAG", "IDENT", "IF", "INCLUDE", "LEFT_SHIFT", 
			"LT", "MACRO", "MINUS", "NOPIC", "OPENING_BRACKET", "OPTION", "ORG", 
			"PLUS", "RIGHT_SHIFT", "SIZE", "SLASH", "SPACE", "STRING_KEYWORD", "TEXT", 
			"TYPE", "WORD", "NEWLINE", "WS", "LINE_COMMENT", "BLOCK_COMMENT", "DOUBLE_SLASH_LINE_COMMENT", 
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
			setState(63); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(59);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(56);
							newline();
							}
							} 
						}
						setState(61);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					}
					setState(62);
					row();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(65); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(67);
				newline();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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
			setState(75);
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
		enterRule(_localctx, 4, RULE_label_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			label_name();
			setState(78);
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
	public static class RowContext extends ParserRuleContext {
		public Preprocessor_directiveContext preprocessor_directive() {
			return getRuleContext(Preprocessor_directiveContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public Asm_intrinsic_instructionContext asm_intrinsic_instruction() {
			return getRuleContext(Asm_intrinsic_instructionContext.class,0);
		}
		public Label_definitionContext label_definition() {
			return getRuleContext(Label_definitionContext.class,0);
		}
		public Instruction_rowContext instruction_row() {
			return getRuleContext(Instruction_rowContext.class,0);
		}
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_row);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				preprocessor_directive();
				setState(82);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(81);
					comment();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(84);
					label_definition();
					}
					break;
				}
				setState(87);
				asm_intrinsic_instruction();
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(88);
					comment();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT || _la==IDENTIFIER) {
					{
					setState(91);
					label_definition();
					}
				}

				setState(94);
				instruction_row();
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(95);
					comment();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(98);
					label_definition();
					}
					break;
				}
				setState(101);
				expression_list();
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(102);
					comment();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				label_definition();
				setState(107);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(106);
					comment();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				comment();
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
	public static class Expression_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RISCVParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RISCVParser.COMMA, i);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			expression(0);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(113);
				match(COMMA);
				setState(114);
				expression(0);
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		enterRule(_localctx, 10, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305843009213693952L) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_instruction_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(122);
				newline();
				}
			}

			setState(125);
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
		enterRule(_localctx, 14, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			mnemonic();
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(128);
				param();
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(129);
					match(COMMA);
					setState(130);
					param();
					}
					break;
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(133);
					match(COMMA);
					setState(134);
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
		enterRule(_localctx, 16, RULE_param);
		int _la;
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(139);
					match(MINUS);
					}
				}

				setState(142);
				match(IDENTIFIER);
				setState(144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(143);
					match(PLUS);
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				offset_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				asm_intrinsic_usage();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				macro_placeholder();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
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
		enterRule(_localctx, 18, RULE_label_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(153);
				match(DOT);
				}
			}

			setState(156);
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
		enterRule(_localctx, 20, RULE_macro_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(AT);
			setState(159);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENING_BRACKET:
				{
				setState(162);
				match(OPENING_BRACKET);
				setState(163);
				expression(0);
				setState(164);
				match(CLOSEING_BRACKET);
				}
				break;
			case PLUS:
				{
				setState(166);
				match(PLUS);
				setState(167);
				expression(9);
				}
				break;
			case MINUS:
				{
				setState(168);
				match(MINUS);
				setState(169);
				expression(8);
				}
				break;
			case BINARY_NUMBER:
				{
				setState(170);
				match(BINARY_NUMBER);
				}
				break;
			case HEX_NUMBER:
				{
				setState(171);
				match(HEX_NUMBER);
				}
				break;
			case NUMBER:
				{
				setState(172);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(173);
				match(IDENTIFIER);
				}
				break;
			case STRING:
				{
				setState(174);
				match(STRING);
				}
				break;
			case AT:
				{
				setState(175);
				macro_placeholder();
				}
				break;
			case DOT:
				{
				setState(176);
				match(DOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(203);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(180);
						match(LEFT_SHIFT);
						setState(181);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(183);
						match(RIGHT_SHIFT);
						setState(184);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(185);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(186);
						match(SLASH);
						setState(187);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(189);
						match(GT);
						setState(190);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(192);
						match(LT);
						setState(193);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(195);
						match(EQUALS);
						setState(196);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(198);
						match(MINUS);
						setState(199);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(201);
						match(PLUS);
						setState(202);
						expression(11);
						}
						break;
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 24, RULE_offset_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			offset_expression_amount();
			setState(209);
			match(OPENING_BRACKET);
			setState(210);
			offset_expression_register();
			setState(211);
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
		enterRule(_localctx, 26, RULE_offset_expression_amount);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(213);
				match(MINUS);
				}
			}

			setState(216);
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
		enterRule(_localctx, 28, RULE_offset_expression_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		public TerminalNode DATA() { return getToken(RISCVParser.DATA, 0); }
		public TerminalNode WORD() { return getToken(RISCVParser.WORD, 0); }
		public TerminalNode SPACE() { return getToken(RISCVParser.SPACE, 0); }
		public TerminalNode STRING_KEYWORD() { return getToken(RISCVParser.STRING_KEYWORD, 0); }
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
		enterRule(_localctx, 30, RULE_asm_intrinsic_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(DOT);
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCLUDE:
				{
				setState(221);
				match(INCLUDE);
				setState(222);
				match(STRING);
				}
				break;
			case DEVICE:
				{
				setState(223);
				match(DEVICE);
				setState(224);
				match(IDENTIFIER);
				}
				break;
			case DEF:
				{
				setState(225);
				match(DEF);
				setState(226);
				expression(0);
				}
				break;
			case EQU:
				{
				setState(227);
				match(EQU);
				setState(228);
				expression(0);
				}
				break;
			case CSEG:
				{
				setState(229);
				match(CSEG);
				}
				break;
			case ORG:
				{
				setState(230);
				match(ORG);
				setState(231);
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
				setState(232);
				match(MACRO);
				setState(233);
				match(IDENTIFIER);
				}
				break;
			case END_MACRO:
				{
				setState(234);
				match(END_MACRO);
				}
				break;
			case IF:
				{
				setState(235);
				match(IF);
				setState(236);
				expression(0);
				}
				break;
			case ELSE:
				{
				setState(237);
				match(ELSE);
				}
				break;
			case ENDIF:
				{
				setState(238);
				match(ENDIF);
				}
				break;
			case ERROR:
				{
				setState(239);
				match(ERROR);
				setState(240);
				match(STRING);
				}
				break;
			case FILE:
				{
				setState(241);
				match(FILE);
				setState(242);
				match(STRING);
				}
				break;
			case TEXT:
				{
				setState(243);
				match(TEXT);
				}
				break;
			case IDENT:
				{
				setState(244);
				match(IDENT);
				setState(245);
				match(STRING);
				}
				break;
			case SIZE:
				{
				setState(246);
				match(SIZE);
				setState(247);
				expression(0);
				setState(248);
				match(COMMA);
				setState(249);
				expression(0);
				}
				break;
			case ALIGN:
				{
				setState(251);
				match(ALIGN);
				setState(252);
				match(NUMBER);
				}
				break;
			case GLOBL:
				{
				setState(253);
				match(GLOBL);
				setState(254);
				match(IDENTIFIER);
				}
				break;
			case TYPE:
				{
				setState(255);
				match(TYPE);
				{
				setState(256);
				match(IDENTIFIER);
				setState(257);
				match(COMMA);
				setState(258);
				entity_type();
				}
				}
				break;
			case OPTION:
				{
				setState(259);
				match(OPTION);
				{
				setState(260);
				match(NOPIC);
				}
				}
				break;
			case DATA:
				{
				setState(261);
				match(DATA);
				}
				break;
			case WORD:
				{
				setState(262);
				match(WORD);
				setState(263);
				expression(0);
				}
				break;
			case SPACE:
				{
				setState(264);
				match(SPACE);
				setState(265);
				expression(0);
				}
				break;
			case STRING_KEYWORD:
				{
				setState(266);
				match(STRING_KEYWORD);
				setState(267);
				match(STRING);
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
		enterRule(_localctx, 32, RULE_entity_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(AT);
			{
			setState(271);
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
		enterRule(_localctx, 34, RULE_asm_intrinsic_usage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(IDENTIFIER);
			setState(274);
			match(OPENING_BRACKET);
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(275);
				match(IDENTIFIER);
				}
				break;
			case AT:
				{
				setState(276);
				macro_placeholder();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(279);
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
		enterRule(_localctx, 36, RULE_preprocessor_directive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(HASH_TAG);
			setState(283); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(282);
					_la = _input.LA(1);
					if ( !(((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & 515396076545L) != 0)) ) {
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
				setState(285); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		public Mnemonic_eContext mnemonic_e() {
			return getRuleContext(Mnemonic_eContext.class,0);
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
		enterRule(_localctx, 38, RULE_mnemonic);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case ADDI:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				mnemonic_a();
				}
				break;
			case BEQ:
			case BGT:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				mnemonic_b();
				}
				break;
			case CALL:
			case CSRW:
			case CSRSI:
				enterOuterAlt(_localctx, 3);
				{
				setState(289);
				mnemonic_c();
				}
				break;
			case ECALL:
				enterOuterAlt(_localctx, 4);
				{
				setState(290);
				mnemonic_e();
				}
				break;
			case J_:
			case JAL:
			case JR:
				enterOuterAlt(_localctx, 5);
				{
				setState(291);
				mnemonic_j();
				}
				break;
			case LA:
			case LI:
			case LW:
				enterOuterAlt(_localctx, 6);
				{
				setState(292);
				mnemonic_l();
				}
				break;
			case MV:
				enterOuterAlt(_localctx, 7);
				{
				setState(293);
				mnemonic_m();
				}
				break;
			case SW:
				enterOuterAlt(_localctx, 8);
				{
				setState(294);
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
		enterRule(_localctx, 40, RULE_mnemonic_a);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
		public TerminalNode BEQ() { return getToken(RISCVParser.BEQ, 0); }
		public TerminalNode BGT() { return getToken(RISCVParser.BGT, 0); }
		public Mnemonic_bContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_b; }
	}

	public final Mnemonic_bContext mnemonic_b() throws RecognitionException {
		Mnemonic_bContext _localctx = new Mnemonic_bContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mnemonic_b);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_la = _input.LA(1);
			if ( !(_la==BEQ || _la==BGT) ) {
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
	public static class Mnemonic_cContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(RISCVParser.CALL, 0); }
		public TerminalNode CSRW() { return getToken(RISCVParser.CSRW, 0); }
		public TerminalNode CSRSI() { return getToken(RISCVParser.CSRSI, 0); }
		public Mnemonic_cContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_c; }
	}

	public final Mnemonic_cContext mnemonic_c() throws RecognitionException {
		Mnemonic_cContext _localctx = new Mnemonic_cContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mnemonic_c);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 224L) != 0)) ) {
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
	public static class Mnemonic_eContext extends ParserRuleContext {
		public TerminalNode ECALL() { return getToken(RISCVParser.ECALL, 0); }
		public Mnemonic_eContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_e; }
	}

	public final Mnemonic_eContext mnemonic_e() throws RecognitionException {
		Mnemonic_eContext _localctx = new Mnemonic_eContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mnemonic_e);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(ECALL);
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
		public TerminalNode JAL() { return getToken(RISCVParser.JAL, 0); }
		public TerminalNode JR() { return getToken(RISCVParser.JR, 0); }
		public Mnemonic_jContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_j; }
	}

	public final Mnemonic_jContext mnemonic_j() throws RecognitionException {
		Mnemonic_jContext _localctx = new Mnemonic_jContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mnemonic_j);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
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
		public TerminalNode LA() { return getToken(RISCVParser.LA, 0); }
		public TerminalNode LI() { return getToken(RISCVParser.LI, 0); }
		public TerminalNode LW() { return getToken(RISCVParser.LW, 0); }
		public Mnemonic_lContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_l; }
	}

	public final Mnemonic_lContext mnemonic_l() throws RecognitionException {
		Mnemonic_lContext _localctx = new Mnemonic_lContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mnemonic_l);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
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
		enterRule(_localctx, 52, RULE_mnemonic_m);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
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
		enterRule(_localctx, 54, RULE_mnemonic_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
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
		case 11:
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
		"\u0004\u0001D\u013a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0004\u0000@\b\u0000\u000b\u0000\f\u0000A\u0001\u0000\u0005\u0000E\b"+
		"\u0000\n\u0000\f\u0000H\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003"+
		"\u0003S\b\u0003\u0001\u0003\u0003\u0003V\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003Z\b\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003a\b\u0003\u0001\u0003\u0003\u0003d\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003h\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"l\b\u0003\u0001\u0003\u0003\u0003o\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004t\b\u0004\n\u0004\f\u0004w\t\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0003\u0006|\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0084\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0088\b\u0007\u0003\u0007\u008a\b\u0007"+
		"\u0001\b\u0003\b\u008d\b\b\u0001\b\u0001\b\u0003\b\u0091\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0098\b\b\u0001\t\u0003\t\u009b\b\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00b2\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00cc\b\u000b\n"+
		"\u000b\f\u000b\u00cf\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0003\r\u00d7\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u010d\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u0116\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0004\u0012\u011c\b\u0012\u000b\u0012\f\u0012"+
		"\u011d\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0128\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0001\u0016\u001c\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.0246\u0000\b\u0001\u0000=?\u0002\u0000BBDD\u0003\u0000"+
		"\u001e\u001e((AD\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004\u0001"+
		"\u0000\u0005\u0007\u0001\u0000\t\u000b\u0001\u0000\f\u000e\u016c\u0000"+
		"?\u0001\u0000\u0000\u0000\u0002K\u0001\u0000\u0000\u0000\u0004M\u0001"+
		"\u0000\u0000\u0000\u0006n\u0001\u0000\u0000\u0000\bp\u0001\u0000\u0000"+
		"\u0000\nx\u0001\u0000\u0000\u0000\f{\u0001\u0000\u0000\u0000\u000e\u007f"+
		"\u0001\u0000\u0000\u0000\u0010\u0097\u0001\u0000\u0000\u0000\u0012\u009a"+
		"\u0001\u0000\u0000\u0000\u0014\u009e\u0001\u0000\u0000\u0000\u0016\u00b1"+
		"\u0001\u0000\u0000\u0000\u0018\u00d0\u0001\u0000\u0000\u0000\u001a\u00d6"+
		"\u0001\u0000\u0000\u0000\u001c\u00da\u0001\u0000\u0000\u0000\u001e\u00dc"+
		"\u0001\u0000\u0000\u0000 \u010e\u0001\u0000\u0000\u0000\"\u0111\u0001"+
		"\u0000\u0000\u0000$\u0119\u0001\u0000\u0000\u0000&\u0127\u0001\u0000\u0000"+
		"\u0000(\u0129\u0001\u0000\u0000\u0000*\u012b\u0001\u0000\u0000\u0000,"+
		"\u012d\u0001\u0000\u0000\u0000.\u012f\u0001\u0000\u0000\u00000\u0131\u0001"+
		"\u0000\u0000\u00002\u0133\u0001\u0000\u0000\u00004\u0135\u0001\u0000\u0000"+
		"\u00006\u0137\u0001\u0000\u0000\u00008:\u0003\u0002\u0001\u000098\u0001"+
		"\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>@\u0003\u0006\u0003\u0000?;\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BF\u0001"+
		"\u0000\u0000\u0000CE\u0003\u0002\u0001\u0000DC\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\u0000"+
		"\u0000\u0001J\u0001\u0001\u0000\u0000\u0000KL\u0005;\u0000\u0000L\u0003"+
		"\u0001\u0000\u0000\u0000MN\u0003\u0012\t\u0000NO\u0005\u0015\u0000\u0000"+
		"O\u0005\u0001\u0000\u0000\u0000PR\u0003$\u0012\u0000QS\u0003\n\u0005\u0000"+
		"RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000So\u0001\u0000\u0000"+
		"\u0000TV\u0003\u0004\u0002\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0003\u001e\u000f\u0000XZ\u0003"+
		"\n\u0005\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Zo\u0001"+
		"\u0000\u0000\u0000[]\u0003\u0004\u0002\u0000\\[\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0003\f\u0006"+
		"\u0000_a\u0003\n\u0005\u0000`_\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ao\u0001\u0000\u0000\u0000bd\u0003\u0004\u0002\u0000cb\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0003"+
		"\b\u0004\u0000fh\u0003\n\u0005\u0000gf\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000ho\u0001\u0000\u0000\u0000ik\u0003\u0004\u0002\u0000"+
		"jl\u0003\n\u0005\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000"+
		"lo\u0001\u0000\u0000\u0000mo\u0003\n\u0005\u0000nP\u0001\u0000\u0000\u0000"+
		"nU\u0001\u0000\u0000\u0000n\\\u0001\u0000\u0000\u0000nc\u0001\u0000\u0000"+
		"\u0000ni\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000o\u0007\u0001"+
		"\u0000\u0000\u0000pu\u0003\u0016\u000b\u0000qr\u0005\u0016\u0000\u0000"+
		"rt\u0003\u0016\u000b\u0000sq\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000"+
		"\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v\t\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0007\u0000\u0000\u0000y\u000b"+
		"\u0001\u0000\u0000\u0000z|\u0003\u0002\u0001\u0000{z\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0003\u000e"+
		"\u0007\u0000~\r\u0001\u0000\u0000\u0000\u007f\u0089\u0003&\u0013\u0000"+
		"\u0080\u0083\u0003\u0010\b\u0000\u0081\u0082\u0005\u0016\u0000\u0000\u0082"+
		"\u0084\u0003\u0010\b\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0005\u0016\u0000\u0000\u0086\u0088\u0003\u0010\b\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0001"+
		"\u0000\u0000\u0000\u0089\u0080\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u000f\u0001\u0000\u0000\u0000\u008b\u008d\u0005"+
		"-\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0005D\u0000"+
		"\u0000\u008f\u0091\u00052\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0098\u0001\u0000\u0000\u0000"+
		"\u0092\u0098\u0003\u0018\f\u0000\u0093\u0098\u0003\u0016\u000b\u0000\u0094"+
		"\u0098\u0003\"\u0011\u0000\u0095\u0098\u0003\u0014\n\u0000\u0096\u0098"+
		"\u0003\u0012\t\u0000\u0097\u008c\u0001\u0000\u0000\u0000\u0097\u0092\u0001"+
		"\u0000\u0000\u0000\u0097\u0093\u0001\u0000\u0000\u0000\u0097\u0094\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0096\u0001"+
		"\u0000\u0000\u0000\u0098\u0011\u0001\u0000\u0000\u0000\u0099\u009b\u0005"+
		"\u001b\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0005"+
		"D\u0000\u0000\u009d\u0013\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0013"+
		"\u0000\u0000\u009f\u00a0\u0005A\u0000\u0000\u00a0\u0015\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0006\u000b\uffff\uffff\u0000\u00a2\u00a3\u0005/\u0000"+
		"\u0000\u00a3\u00a4\u0003\u0016\u000b\u0000\u00a4\u00a5\u0005\u0014\u0000"+
		"\u0000\u00a5\u00b2\u0001\u0000\u0000\u0000\u00a6\u00a7\u00052\u0000\u0000"+
		"\u00a7\u00b2\u0003\u0016\u000b\t\u00a8\u00a9\u0005-\u0000\u0000\u00a9"+
		"\u00b2\u0003\u0016\u000b\b\u00aa\u00b2\u0005C\u0000\u0000\u00ab\u00b2"+
		"\u0005B\u0000\u0000\u00ac\u00b2\u0005A\u0000\u0000\u00ad\u00b2\u0005D"+
		"\u0000\u0000\u00ae\u00b2\u0005@\u0000\u0000\u00af\u00b2\u0003\u0014\n"+
		"\u0000\u00b0\u00b2\u0005\u001b\u0000\u0000\u00b1\u00a1\u0001\u0000\u0000"+
		"\u0000\u00b1\u00a6\u0001\u0000\u0000\u0000\u00b1\u00a8\u0001\u0000\u0000"+
		"\u0000\u00b1\u00aa\u0001\u0000\u0000\u0000\u00b1\u00ab\u0001\u0000\u0000"+
		"\u0000\u00b1\u00ac\u0001\u0000\u0000\u0000\u00b1\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b1\u00ae\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00cd\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\n\u0011\u0000\u0000\u00b4\u00b5\u0005*\u0000\u0000"+
		"\u00b5\u00cc\u0003\u0016\u000b\u0012\u00b6\u00b7\n\u0010\u0000\u0000\u00b7"+
		"\u00b8\u00053\u0000\u0000\u00b8\u00cc\u0003\u0016\u000b\u0011\u00b9\u00ba"+
		"\n\u000f\u0000\u0000\u00ba\u00bb\u00055\u0000\u0000\u00bb\u00cc\u0003"+
		"\u0016\u000b\u0010\u00bc\u00bd\n\u000e\u0000\u0000\u00bd\u00be\u0005%"+
		"\u0000\u0000\u00be\u00cc\u0003\u0016\u000b\u000f\u00bf\u00c0\n\r\u0000"+
		"\u0000\u00c0\u00c1\u0005+\u0000\u0000\u00c1\u00cc\u0003\u0016\u000b\u000e"+
		"\u00c2\u00c3\n\f\u0000\u0000\u00c3\u00c4\u0005\u001f\u0000\u0000\u00c4"+
		"\u00cc\u0003\u0016\u000b\r\u00c5\u00c6\n\u000b\u0000\u0000\u00c6\u00c7"+
		"\u0005-\u0000\u0000\u00c7\u00cc\u0003\u0016\u000b\f\u00c8\u00c9\n\n\u0000"+
		"\u0000\u00c9\u00ca\u00052\u0000\u0000\u00ca\u00cc\u0003\u0016\u000b\u000b"+
		"\u00cb\u00b3\u0001\u0000\u0000\u0000\u00cb\u00b6\u0001\u0000\u0000\u0000"+
		"\u00cb\u00b9\u0001\u0000\u0000\u0000\u00cb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00cb\u00bf\u0001\u0000\u0000\u0000\u00cb\u00c2\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c5\u0001\u0000\u0000\u0000\u00cb\u00c8\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u0017\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003\u001a\r\u0000\u00d1"+
		"\u00d2\u0005/\u0000\u0000\u00d2\u00d3\u0003\u001c\u000e\u0000\u00d3\u00d4"+
		"\u0005\u0014\u0000\u0000\u00d4\u0019\u0001\u0000\u0000\u0000\u00d5\u00d7"+
		"\u0005-\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005"+
		"A\u0000\u0000\u00d9\u001b\u0001\u0000\u0000\u0000\u00da\u00db\u0005D\u0000"+
		"\u0000\u00db\u001d\u0001\u0000\u0000\u0000\u00dc\u010c\u0005\u001b\u0000"+
		"\u0000\u00dd\u00de\u0005)\u0000\u0000\u00de\u010d\u0005@\u0000\u0000\u00df"+
		"\u00e0\u0005\u001a\u0000\u0000\u00e0\u010d\u0005D\u0000\u0000\u00e1\u00e2"+
		"\u0005\u0019\u0000\u0000\u00e2\u010d\u0003\u0016\u000b\u0000\u00e3\u00e4"+
		"\u0005 \u0000\u0000\u00e4\u010d\u0003\u0016\u000b\u0000\u00e5\u010d\u0005"+
		"\u0017\u0000\u0000\u00e6\u00e7\u00051\u0000\u0000\u00e7\u010d\u0007\u0001"+
		"\u0000\u0000\u00e8\u00e9\u0005,\u0000\u0000\u00e9\u010d\u0005D\u0000\u0000"+
		"\u00ea\u010d\u0005\u001d\u0000\u0000\u00eb\u00ec\u0005(\u0000\u0000\u00ec"+
		"\u010d\u0003\u0016\u000b\u0000\u00ed\u010d\u0005\u001c\u0000\u0000\u00ee"+
		"\u010d\u0005\u001e\u0000\u0000\u00ef\u00f0\u0005!\u0000\u0000\u00f0\u010d"+
		"\u0005@\u0000\u0000\u00f1\u00f2\u0005\"\u0000\u0000\u00f2\u010d\u0005"+
		"@\u0000\u0000\u00f3\u010d\u00058\u0000\u0000\u00f4\u00f5\u0005\'\u0000"+
		"\u0000\u00f5\u010d\u0005@\u0000\u0000\u00f6\u00f7\u00054\u0000\u0000\u00f7"+
		"\u00f8\u0003\u0016\u000b\u0000\u00f8\u00f9\u0005\u0016\u0000\u0000\u00f9"+
		"\u00fa\u0003\u0016\u000b\u0000\u00fa\u010d\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0005\u0011\u0000\u0000\u00fc\u010d\u0005A\u0000\u0000\u00fd\u00fe"+
		"\u0005$\u0000\u0000\u00fe\u010d\u0005D\u0000\u0000\u00ff\u0100\u00059"+
		"\u0000\u0000\u0100\u0101\u0005D\u0000\u0000\u0101\u0102\u0005\u0016\u0000"+
		"\u0000\u0102\u010d\u0003 \u0010\u0000\u0103\u0104\u00050\u0000\u0000\u0104"+
		"\u010d\u0005.\u0000\u0000\u0105\u010d\u0005\u0018\u0000\u0000\u0106\u0107"+
		"\u0005:\u0000\u0000\u0107\u010d\u0003\u0016\u000b\u0000\u0108\u0109\u0005"+
		"6\u0000\u0000\u0109\u010d\u0003\u0016\u000b\u0000\u010a\u010b\u00057\u0000"+
		"\u0000\u010b\u010d\u0005@\u0000\u0000\u010c\u00dd\u0001\u0000\u0000\u0000"+
		"\u010c\u00df\u0001\u0000\u0000\u0000\u010c\u00e1\u0001\u0000\u0000\u0000"+
		"\u010c\u00e3\u0001\u0000\u0000\u0000\u010c\u00e5\u0001\u0000\u0000\u0000"+
		"\u010c\u00e6\u0001\u0000\u0000\u0000\u010c\u00e8\u0001\u0000\u0000\u0000"+
		"\u010c\u00ea\u0001\u0000\u0000\u0000\u010c\u00eb\u0001\u0000\u0000\u0000"+
		"\u010c\u00ed\u0001\u0000\u0000\u0000\u010c\u00ee\u0001\u0000\u0000\u0000"+
		"\u010c\u00ef\u0001\u0000\u0000\u0000\u010c\u00f1\u0001\u0000\u0000\u0000"+
		"\u010c\u00f3\u0001\u0000\u0000\u0000\u010c\u00f4\u0001\u0000\u0000\u0000"+
		"\u010c\u00f6\u0001\u0000\u0000\u0000\u010c\u00fb\u0001\u0000\u0000\u0000"+
		"\u010c\u00fd\u0001\u0000\u0000\u0000\u010c\u00ff\u0001\u0000\u0000\u0000"+
		"\u010c\u0103\u0001\u0000\u0000\u0000\u010c\u0105\u0001\u0000\u0000\u0000"+
		"\u010c\u0106\u0001\u0000\u0000\u0000\u010c\u0108\u0001\u0000\u0000\u0000"+
		"\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u001f\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0005\u0013\u0000\u0000\u010f\u0110\u0005#\u0000\u0000\u0110"+
		"!\u0001\u0000\u0000\u0000\u0111\u0112\u0005D\u0000\u0000\u0112\u0115\u0005"+
		"/\u0000\u0000\u0113\u0116\u0005D\u0000\u0000\u0114\u0116\u0003\u0014\n"+
		"\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0114\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u0014\u0000"+
		"\u0000\u0118#\u0001\u0000\u0000\u0000\u0119\u011b\u0005&\u0000\u0000\u011a"+
		"\u011c\u0007\u0002\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0001\u0000\u0000\u0000\u011e%\u0001\u0000\u0000\u0000\u011f\u0128"+
		"\u0003(\u0014\u0000\u0120\u0128\u0003*\u0015\u0000\u0121\u0128\u0003,"+
		"\u0016\u0000\u0122\u0128\u0003.\u0017\u0000\u0123\u0128\u00030\u0018\u0000"+
		"\u0124\u0128\u00032\u0019\u0000\u0125\u0128\u00034\u001a\u0000\u0126\u0128"+
		"\u00036\u001b\u0000\u0127\u011f\u0001\u0000\u0000\u0000\u0127\u0120\u0001"+
		"\u0000\u0000\u0000\u0127\u0121\u0001\u0000\u0000\u0000\u0127\u0122\u0001"+
		"\u0000\u0000\u0000\u0127\u0123\u0001\u0000\u0000\u0000\u0127\u0124\u0001"+
		"\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0126\u0001"+
		"\u0000\u0000\u0000\u0128\'\u0001\u0000\u0000\u0000\u0129\u012a\u0007\u0003"+
		"\u0000\u0000\u012a)\u0001\u0000\u0000\u0000\u012b\u012c\u0007\u0004\u0000"+
		"\u0000\u012c+\u0001\u0000\u0000\u0000\u012d\u012e\u0007\u0005\u0000\u0000"+
		"\u012e-\u0001\u0000\u0000\u0000\u012f\u0130\u0005\b\u0000\u0000\u0130"+
		"/\u0001\u0000\u0000\u0000\u0131\u0132\u0007\u0006\u0000\u0000\u01321\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0007\u0007\u0000\u0000\u01343\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0005\u000f\u0000\u0000\u01365\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005\u0010\u0000\u0000\u01387\u0001\u0000\u0000\u0000"+
		"\u001d;AFRUY\\`cgknu{\u0083\u0087\u0089\u008c\u0090\u0097\u009a\u00b1"+
		"\u00cb\u00cd\u00d6\u010c\u0115\u011d\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}