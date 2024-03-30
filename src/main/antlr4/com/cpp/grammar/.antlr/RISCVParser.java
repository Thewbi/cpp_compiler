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
		ADD=1, ADDW=2, ADDI=3, ADDIW=4, AND=5, ANDI=6, AUIPC=7, BEQ=8, BNE=9, 
		BLT=10, BGE=11, BGT=12, BLTU=13, BGEU=14, CALL=15, CSRW=16, CSRRW=17, 
		CSRRS=18, CSRRC=19, CSRRWI=20, CSRRSI=21, CSRRCI=22, CSRSI=23, DIV=24, 
		DIVU=25, DIVW=26, DIVUW=27, ECALL=28, EBREAK=29, FENCE=30, FENCE_I=31, 
		J_=32, JAL=33, JALR=34, JR=35, LA=36, LB=37, LD=38, LI=39, LH=40, LW=41, 
		LUI=42, LBU=43, LHU=44, LWU=45, MV=46, MUL=47, MULH=48, MULHSU=49, MULHU=50, 
		OR=51, ORI=52, RET=53, SB=54, SD=55, SH=56, SW=57, SLLI=58, SLLIW=59, 
		SRL=60, SRLW=61, SRLI=62, SRLIW=63, SRA=64, SRAW=65, SRAI=66, SRAIW=67, 
		SUB=68, SUBW=69, SLT=70, SLTU=71, SLTI=72, SLTIU=73, SLL=74, SLLW=75, 
		XOR=76, XORI=77, ALIGN=78, ASTERISK=79, AT=80, CLOSEING_BRACKET=81, COLON=82, 
		COMMA=83, CSEG=84, DATA=85, DEF=86, DEVICE=87, DOT=88, ELSE=89, END_MACRO=90, 
		ENDIF=91, EQUALS=92, EQU=93, ERROR=94, FILE=95, FUNCTION=96, GLOBL=97, 
		GT=98, HASH_TAG=99, IDENT=100, IF=101, INCLUDE=102, LEFT_SHIFT=103, LT=104, 
		MACRO=105, MINUS=106, NOPIC=107, OPENING_BRACKET=108, OPTION=109, ORG=110, 
		PLUS=111, RIGHT_SHIFT=112, REM=113, REMW=114, REMU=115, REMUW=116, SIZE=117, 
		SLASH=118, SPACE=119, STRING_KEYWORD=120, TEXT=121, TYPE=122, WORD=123, 
		MULW=124, NEWLINE=125, WS=126, LINE_COMMENT=127, BLOCK_COMMENT=128, DOUBLE_SLASH_LINE_COMMENT=129, 
		STRING=130, NUMBER=131, HEX_NUMBER=132, BINARY_NUMBER=133, IDENTIFIER=134;
	public static final int
		RULE_asm_file = 0, RULE_newline = 1, RULE_label_definition = 2, RULE_row = 3, 
		RULE_expression_list = 4, RULE_comment = 5, RULE_instruction_row = 6, 
		RULE_instruction = 7, RULE_param = 8, RULE_label_name = 9, RULE_macro_placeholder = 10, 
		RULE_expression = 11, RULE_offset_expression = 12, RULE_offset_expression_amount = 13, 
		RULE_offset_expression_register = 14, RULE_asm_intrinsic_instruction = 15, 
		RULE_entity_type = 16, RULE_asm_intrinsic_usage = 17, RULE_preprocessor_directive = 18, 
		RULE_mnemonic = 19, RULE_mnemonic_a = 20, RULE_mnemonic_b = 21, RULE_mnemonic_c = 22, 
		RULE_mnemonic_d = 23, RULE_mnemonic_e = 24, RULE_mnemonic_f = 25, RULE_mnemonic_j = 26, 
		RULE_mnemonic_l = 27, RULE_mnemonic_m = 28, RULE_mnemonic_o = 29, RULE_mnemonic_r = 30, 
		RULE_mnemonic_s = 31, RULE_mnemonic_x = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"asm_file", "newline", "label_definition", "row", "expression_list", 
			"comment", "instruction_row", "instruction", "param", "label_name", "macro_placeholder", 
			"expression", "offset_expression", "offset_expression_amount", "offset_expression_register", 
			"asm_intrinsic_instruction", "entity_type", "asm_intrinsic_usage", "preprocessor_directive", 
			"mnemonic", "mnemonic_a", "mnemonic_b", "mnemonic_c", "mnemonic_d", "mnemonic_e", 
			"mnemonic_f", "mnemonic_j", "mnemonic_l", "mnemonic_m", "mnemonic_o", 
			"mnemonic_r", "mnemonic_s", "mnemonic_x"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'align'", "'*'", "'@'", "')'", "':'", 
			"','", "'cseg'", "'data'", "'def'", "'device'", "'.'", "'else'", "'endmacro'", 
			"'endif'", "'='", null, "'error'", "'file'", "'function'", "'globl'", 
			"'>'", "'#'", "'ident'", "'if'", "'include'", "'<<'", "'<'", "'macro'", 
			"'-'", "'nopic'", "'('", "'option'", "'org'", "'+'", "'>>'", null, null, 
			null, null, "'size'", "'/'", "'space'", "'string'", "'text'", "'type'", 
			"'word'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "ADDW", "ADDI", "ADDIW", "AND", "ANDI", "AUIPC", "BEQ", 
			"BNE", "BLT", "BGE", "BGT", "BLTU", "BGEU", "CALL", "CSRW", "CSRRW", 
			"CSRRS", "CSRRC", "CSRRWI", "CSRRSI", "CSRRCI", "CSRSI", "DIV", "DIVU", 
			"DIVW", "DIVUW", "ECALL", "EBREAK", "FENCE", "FENCE_I", "J_", "JAL", 
			"JALR", "JR", "LA", "LB", "LD", "LI", "LH", "LW", "LUI", "LBU", "LHU", 
			"LWU", "MV", "MUL", "MULH", "MULHSU", "MULHU", "OR", "ORI", "RET", "SB", 
			"SD", "SH", "SW", "SLLI", "SLLIW", "SRL", "SRLW", "SRLI", "SRLIW", "SRA", 
			"SRAW", "SRAI", "SRAIW", "SUB", "SUBW", "SLT", "SLTU", "SLTI", "SLTIU", 
			"SLL", "SLLW", "XOR", "XORI", "ALIGN", "ASTERISK", "AT", "CLOSEING_BRACKET", 
			"COLON", "COMMA", "CSEG", "DATA", "DEF", "DEVICE", "DOT", "ELSE", "END_MACRO", 
			"ENDIF", "EQUALS", "EQU", "ERROR", "FILE", "FUNCTION", "GLOBL", "GT", 
			"HASH_TAG", "IDENT", "IF", "INCLUDE", "LEFT_SHIFT", "LT", "MACRO", "MINUS", 
			"NOPIC", "OPENING_BRACKET", "OPTION", "ORG", "PLUS", "RIGHT_SHIFT", "REM", 
			"REMW", "REMU", "REMUW", "SIZE", "SLASH", "SPACE", "STRING_KEYWORD", 
			"TEXT", "TYPE", "WORD", "MULW", "NEWLINE", "WS", "LINE_COMMENT", "BLOCK_COMMENT", 
			"DOUBLE_SLASH_LINE_COMMENT", "STRING", "NUMBER", "HEX_NUMBER", "BINARY_NUMBER", 
			"IDENTIFIER"
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
			setState(73); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(69);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(66);
							newline();
							}
							} 
						}
						setState(71);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					}
					setState(72);
					row();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(75); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(77);
				newline();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
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
			setState(85);
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
			setState(87);
			label_name();
			setState(88);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				preprocessor_directive();
				setState(92);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(91);
					comment();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(94);
					label_definition();
					}
					break;
				}
				setState(97);
				asm_intrinsic_instruction();
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(98);
					comment();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT || _la==IDENTIFIER) {
					{
					setState(101);
					label_definition();
					}
				}

				setState(104);
				instruction_row();
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(105);
					comment();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(108);
					label_definition();
					}
					break;
				}
				setState(111);
				expression_list();
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(112);
					comment();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				label_definition();
				setState(117);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(116);
					comment();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
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
			setState(122);
			expression(0);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(123);
				match(COMMA);
				setState(124);
				expression(0);
				}
				}
				setState(129);
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
			setState(130);
			_la = _input.LA(1);
			if ( !(((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & 7L) != 0)) ) {
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
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(132);
				newline();
				}
			}

			setState(135);
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
			setState(137);
			mnemonic();
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(138);
				param();
				setState(141);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(139);
					match(COMMA);
					setState(140);
					param();
					}
					break;
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(143);
					match(COMMA);
					setState(144);
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
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(149);
					match(MINUS);
					}
				}

				setState(152);
				match(IDENTIFIER);
				setState(154);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(153);
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
				setState(156);
				offset_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				asm_intrinsic_usage();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				macro_placeholder();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
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
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(163);
				match(DOT);
				}
			}

			setState(166);
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
			setState(168);
			match(AT);
			setState(169);
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
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENING_BRACKET:
				{
				setState(172);
				match(OPENING_BRACKET);
				setState(173);
				expression(0);
				setState(174);
				match(CLOSEING_BRACKET);
				}
				break;
			case PLUS:
				{
				setState(176);
				match(PLUS);
				setState(177);
				expression(9);
				}
				break;
			case MINUS:
				{
				setState(178);
				match(MINUS);
				setState(179);
				expression(8);
				}
				break;
			case BINARY_NUMBER:
				{
				setState(180);
				match(BINARY_NUMBER);
				}
				break;
			case HEX_NUMBER:
				{
				setState(181);
				match(HEX_NUMBER);
				}
				break;
			case NUMBER:
				{
				setState(182);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				{
				setState(183);
				match(IDENTIFIER);
				}
				break;
			case STRING:
				{
				setState(184);
				match(STRING);
				}
				break;
			case AT:
				{
				setState(185);
				macro_placeholder();
				}
				break;
			case DOT:
				{
				setState(186);
				match(DOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(213);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(190);
						match(LEFT_SHIFT);
						setState(191);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(193);
						match(RIGHT_SHIFT);
						setState(194);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(196);
						match(SLASH);
						setState(197);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(199);
						match(GT);
						setState(200);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(202);
						match(LT);
						setState(203);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(205);
						match(EQUALS);
						setState(206);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(208);
						match(MINUS);
						setState(209);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(211);
						match(PLUS);
						setState(212);
						expression(11);
						}
						break;
					}
					} 
				}
				setState(217);
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
			setState(218);
			offset_expression_amount();
			setState(219);
			match(OPENING_BRACKET);
			setState(220);
			offset_expression_register();
			setState(221);
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
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(223);
				match(MINUS);
				}
			}

			setState(226);
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
			setState(228);
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
			setState(230);
			match(DOT);
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCLUDE:
				{
				setState(231);
				match(INCLUDE);
				setState(232);
				match(STRING);
				}
				break;
			case DEVICE:
				{
				setState(233);
				match(DEVICE);
				setState(234);
				match(IDENTIFIER);
				}
				break;
			case DEF:
				{
				setState(235);
				match(DEF);
				setState(236);
				expression(0);
				}
				break;
			case EQU:
				{
				setState(237);
				match(EQU);
				setState(238);
				expression(0);
				}
				break;
			case CSEG:
				{
				setState(239);
				match(CSEG);
				}
				break;
			case ORG:
				{
				setState(240);
				match(ORG);
				setState(241);
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
				setState(242);
				match(MACRO);
				setState(243);
				match(IDENTIFIER);
				}
				break;
			case END_MACRO:
				{
				setState(244);
				match(END_MACRO);
				}
				break;
			case IF:
				{
				setState(245);
				match(IF);
				setState(246);
				expression(0);
				}
				break;
			case ELSE:
				{
				setState(247);
				match(ELSE);
				}
				break;
			case ENDIF:
				{
				setState(248);
				match(ENDIF);
				}
				break;
			case ERROR:
				{
				setState(249);
				match(ERROR);
				setState(250);
				match(STRING);
				}
				break;
			case FILE:
				{
				setState(251);
				match(FILE);
				setState(252);
				match(STRING);
				}
				break;
			case TEXT:
				{
				setState(253);
				match(TEXT);
				}
				break;
			case IDENT:
				{
				setState(254);
				match(IDENT);
				setState(255);
				match(STRING);
				}
				break;
			case SIZE:
				{
				setState(256);
				match(SIZE);
				setState(257);
				expression(0);
				setState(258);
				match(COMMA);
				setState(259);
				expression(0);
				}
				break;
			case ALIGN:
				{
				setState(261);
				match(ALIGN);
				setState(262);
				match(NUMBER);
				}
				break;
			case GLOBL:
				{
				setState(263);
				match(GLOBL);
				setState(264);
				match(IDENTIFIER);
				}
				break;
			case TYPE:
				{
				setState(265);
				match(TYPE);
				{
				setState(266);
				match(IDENTIFIER);
				setState(267);
				match(COMMA);
				setState(268);
				entity_type();
				}
				}
				break;
			case OPTION:
				{
				setState(269);
				match(OPTION);
				{
				setState(270);
				match(NOPIC);
				}
				}
				break;
			case DATA:
				{
				setState(271);
				match(DATA);
				}
				break;
			case WORD:
				{
				setState(272);
				match(WORD);
				setState(273);
				expression(0);
				}
				break;
			case SPACE:
				{
				setState(274);
				match(SPACE);
				setState(275);
				expression(0);
				}
				break;
			case STRING_KEYWORD:
				{
				setState(276);
				match(STRING_KEYWORD);
				setState(277);
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
			setState(280);
			match(AT);
			{
			setState(281);
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
			setState(283);
			match(IDENTIFIER);
			setState(284);
			match(OPENING_BRACKET);
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(285);
				match(IDENTIFIER);
				}
				break;
			case AT:
				{
				setState(286);
				macro_placeholder();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(289);
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
			setState(291);
			match(HASH_TAG);
			setState(293); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(292);
					_la = _input.LA(1);
					if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 16492674417665L) != 0)) ) {
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
				setState(295); 
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
		public Mnemonic_rContext mnemonic_r() {
			return getRuleContext(Mnemonic_rContext.class,0);
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
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case ADDW:
			case ADDI:
			case ADDIW:
			case AND:
			case ANDI:
			case AUIPC:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				mnemonic_a();
				}
				break;
			case BEQ:
			case BNE:
			case BLT:
			case BGE:
			case BGT:
			case BLTU:
			case BGEU:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				mnemonic_b();
				}
				break;
			case CALL:
			case CSRW:
			case CSRRW:
			case CSRRS:
			case CSRRC:
			case CSRRWI:
			case CSRRSI:
			case CSRRCI:
			case CSRSI:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				mnemonic_c();
				}
				break;
			case ECALL:
			case EBREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				mnemonic_e();
				}
				break;
			case J_:
			case JAL:
			case JALR:
			case JR:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				mnemonic_j();
				}
				break;
			case LA:
			case LB:
			case LD:
			case LI:
			case LH:
			case LW:
			case LUI:
			case LBU:
			case LHU:
			case LWU:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				mnemonic_l();
				}
				break;
			case MV:
			case MUL:
			case MULH:
			case MULHSU:
			case MULHU:
				enterOuterAlt(_localctx, 7);
				{
				setState(303);
				mnemonic_m();
				}
				break;
			case RET:
				enterOuterAlt(_localctx, 8);
				{
				setState(304);
				mnemonic_r();
				}
				break;
			case SB:
			case SD:
			case SH:
			case SW:
			case SLLI:
			case SLLIW:
			case SRL:
			case SRLW:
			case SRLI:
			case SRLIW:
			case SRA:
			case SRAW:
			case SRAI:
			case SRAIW:
			case SUB:
			case SUBW:
			case SLT:
			case SLTU:
			case SLTI:
			case SLTIU:
			case SLL:
			case SLLW:
				enterOuterAlt(_localctx, 9);
				{
				setState(305);
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
		public TerminalNode ADDW() { return getToken(RISCVParser.ADDW, 0); }
		public TerminalNode ADDI() { return getToken(RISCVParser.ADDI, 0); }
		public TerminalNode ADDIW() { return getToken(RISCVParser.ADDIW, 0); }
		public TerminalNode AND() { return getToken(RISCVParser.AND, 0); }
		public TerminalNode ANDI() { return getToken(RISCVParser.ANDI, 0); }
		public TerminalNode AUIPC() { return getToken(RISCVParser.AUIPC, 0); }
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
			setState(308);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 254L) != 0)) ) {
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
		public TerminalNode BNE() { return getToken(RISCVParser.BNE, 0); }
		public TerminalNode BLT() { return getToken(RISCVParser.BLT, 0); }
		public TerminalNode BGE() { return getToken(RISCVParser.BGE, 0); }
		public TerminalNode BGT() { return getToken(RISCVParser.BGT, 0); }
		public TerminalNode BLTU() { return getToken(RISCVParser.BLTU, 0); }
		public TerminalNode BGEU() { return getToken(RISCVParser.BGEU, 0); }
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
			setState(310);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32512L) != 0)) ) {
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
		public TerminalNode CSRRW() { return getToken(RISCVParser.CSRRW, 0); }
		public TerminalNode CSRRS() { return getToken(RISCVParser.CSRRS, 0); }
		public TerminalNode CSRRC() { return getToken(RISCVParser.CSRRC, 0); }
		public TerminalNode CSRRWI() { return getToken(RISCVParser.CSRRWI, 0); }
		public TerminalNode CSRRSI() { return getToken(RISCVParser.CSRRSI, 0); }
		public TerminalNode CSRRCI() { return getToken(RISCVParser.CSRRCI, 0); }
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
			setState(312);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16744448L) != 0)) ) {
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
	public static class Mnemonic_dContext extends ParserRuleContext {
		public TerminalNode DIV() { return getToken(RISCVParser.DIV, 0); }
		public TerminalNode DIVU() { return getToken(RISCVParser.DIVU, 0); }
		public TerminalNode DIVW() { return getToken(RISCVParser.DIVW, 0); }
		public TerminalNode DIVUW() { return getToken(RISCVParser.DIVUW, 0); }
		public Mnemonic_dContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_d; }
	}

	public final Mnemonic_dContext mnemonic_d() throws RecognitionException {
		Mnemonic_dContext _localctx = new Mnemonic_dContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mnemonic_d);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) ) {
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
		public TerminalNode EBREAK() { return getToken(RISCVParser.EBREAK, 0); }
		public Mnemonic_eContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_e; }
	}

	public final Mnemonic_eContext mnemonic_e() throws RecognitionException {
		Mnemonic_eContext _localctx = new Mnemonic_eContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mnemonic_e);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !(_la==ECALL || _la==EBREAK) ) {
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
	public static class Mnemonic_fContext extends ParserRuleContext {
		public TerminalNode FENCE() { return getToken(RISCVParser.FENCE, 0); }
		public TerminalNode FENCE_I() { return getToken(RISCVParser.FENCE_I, 0); }
		public Mnemonic_fContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_f; }
	}

	public final Mnemonic_fContext mnemonic_f() throws RecognitionException {
		Mnemonic_fContext _localctx = new Mnemonic_fContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mnemonic_f);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==FENCE || _la==FENCE_I) ) {
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
	public static class Mnemonic_jContext extends ParserRuleContext {
		public TerminalNode J_() { return getToken(RISCVParser.J_, 0); }
		public TerminalNode JAL() { return getToken(RISCVParser.JAL, 0); }
		public TerminalNode JALR() { return getToken(RISCVParser.JALR, 0); }
		public TerminalNode JR() { return getToken(RISCVParser.JR, 0); }
		public Mnemonic_jContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_j; }
	}

	public final Mnemonic_jContext mnemonic_j() throws RecognitionException {
		Mnemonic_jContext _localctx = new Mnemonic_jContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mnemonic_j);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
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
		public TerminalNode LB() { return getToken(RISCVParser.LB, 0); }
		public TerminalNode LD() { return getToken(RISCVParser.LD, 0); }
		public TerminalNode LI() { return getToken(RISCVParser.LI, 0); }
		public TerminalNode LH() { return getToken(RISCVParser.LH, 0); }
		public TerminalNode LW() { return getToken(RISCVParser.LW, 0); }
		public TerminalNode LUI() { return getToken(RISCVParser.LUI, 0); }
		public TerminalNode LBU() { return getToken(RISCVParser.LBU, 0); }
		public TerminalNode LHU() { return getToken(RISCVParser.LHU, 0); }
		public TerminalNode LWU() { return getToken(RISCVParser.LWU, 0); }
		public Mnemonic_lContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_l; }
	}

	public final Mnemonic_lContext mnemonic_l() throws RecognitionException {
		Mnemonic_lContext _localctx = new Mnemonic_lContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mnemonic_l);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 70300024700928L) != 0)) ) {
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
		public TerminalNode MUL() { return getToken(RISCVParser.MUL, 0); }
		public TerminalNode MULH() { return getToken(RISCVParser.MULH, 0); }
		public TerminalNode MULHSU() { return getToken(RISCVParser.MULHSU, 0); }
		public TerminalNode MULHU() { return getToken(RISCVParser.MULHU, 0); }
		public Mnemonic_mContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_m; }
	}

	public final Mnemonic_mContext mnemonic_m() throws RecognitionException {
		Mnemonic_mContext _localctx = new Mnemonic_mContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_mnemonic_m);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181431069507584L) != 0)) ) {
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
	public static class Mnemonic_oContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(RISCVParser.OR, 0); }
		public TerminalNode ORI() { return getToken(RISCVParser.ORI, 0); }
		public Mnemonic_oContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_o; }
	}

	public final Mnemonic_oContext mnemonic_o() throws RecognitionException {
		Mnemonic_oContext _localctx = new Mnemonic_oContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_mnemonic_o);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==ORI) ) {
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
	public static class Mnemonic_rContext extends ParserRuleContext {
		public TerminalNode RET() { return getToken(RISCVParser.RET, 0); }
		public Mnemonic_rContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_r; }
	}

	public final Mnemonic_rContext mnemonic_r() throws RecognitionException {
		Mnemonic_rContext _localctx = new Mnemonic_rContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_mnemonic_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(RET);
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
		public TerminalNode SB() { return getToken(RISCVParser.SB, 0); }
		public TerminalNode SD() { return getToken(RISCVParser.SD, 0); }
		public TerminalNode SH() { return getToken(RISCVParser.SH, 0); }
		public TerminalNode SW() { return getToken(RISCVParser.SW, 0); }
		public TerminalNode SLLI() { return getToken(RISCVParser.SLLI, 0); }
		public TerminalNode SLLIW() { return getToken(RISCVParser.SLLIW, 0); }
		public TerminalNode SRL() { return getToken(RISCVParser.SRL, 0); }
		public TerminalNode SRLW() { return getToken(RISCVParser.SRLW, 0); }
		public TerminalNode SRLI() { return getToken(RISCVParser.SRLI, 0); }
		public TerminalNode SRLIW() { return getToken(RISCVParser.SRLIW, 0); }
		public TerminalNode SRA() { return getToken(RISCVParser.SRA, 0); }
		public TerminalNode SRAW() { return getToken(RISCVParser.SRAW, 0); }
		public TerminalNode SRAI() { return getToken(RISCVParser.SRAI, 0); }
		public TerminalNode SRAIW() { return getToken(RISCVParser.SRAIW, 0); }
		public TerminalNode SUB() { return getToken(RISCVParser.SUB, 0); }
		public TerminalNode SUBW() { return getToken(RISCVParser.SUBW, 0); }
		public TerminalNode SLT() { return getToken(RISCVParser.SLT, 0); }
		public TerminalNode SLTU() { return getToken(RISCVParser.SLTU, 0); }
		public TerminalNode SLTI() { return getToken(RISCVParser.SLTI, 0); }
		public TerminalNode SLTIU() { return getToken(RISCVParser.SLTIU, 0); }
		public TerminalNode SLL() { return getToken(RISCVParser.SLL, 0); }
		public TerminalNode SLLW() { return getToken(RISCVParser.SLLW, 0); }
		public Mnemonic_sContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_s; }
	}

	public final Mnemonic_sContext mnemonic_s() throws RecognitionException {
		Mnemonic_sContext _localctx = new Mnemonic_sContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_mnemonic_s);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			_la = _input.LA(1);
			if ( !(((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 4194303L) != 0)) ) {
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
	public static class Mnemonic_xContext extends ParserRuleContext {
		public TerminalNode XOR() { return getToken(RISCVParser.XOR, 0); }
		public TerminalNode XORI() { return getToken(RISCVParser.XORI, 0); }
		public Mnemonic_xContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnemonic_x; }
	}

	public final Mnemonic_xContext mnemonic_x() throws RecognitionException {
		Mnemonic_xContext _localctx = new Mnemonic_xContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_mnemonic_x);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !(_la==XOR || _la==XORI) ) {
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
		"\u0004\u0001\u0086\u014f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0005\u0000D"+
		"\b\u0000\n\u0000\f\u0000G\t\u0000\u0001\u0000\u0004\u0000J\b\u0000\u000b"+
		"\u0000\f\u0000K\u0001\u0000\u0005\u0000O\b\u0000\n\u0000\f\u0000R\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0003"+
		"\u0003\u0003`\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003d\b\u0003\u0001"+
		"\u0003\u0003\u0003g\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003k\b\u0003"+
		"\u0001\u0003\u0003\u0003n\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"r\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003v\b\u0003\u0001\u0003\u0003"+
		"\u0003y\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004~\b\u0004"+
		"\n\u0004\f\u0004\u0081\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0003"+
		"\u0006\u0086\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u008e\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0092\b\u0007\u0003\u0007\u0094\b\u0007\u0001\b\u0003\b\u0097\b"+
		"\b\u0001\b\u0001\b\u0003\b\u009b\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u00a2\b\b\u0001\t\u0003\t\u00a5\b\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00bc\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00d6\b\u000b\n\u000b\f\u000b\u00d9\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0003\r\u00e1\b\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0117\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0120\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0004\u0012\u0126\b\u0012\u000b\u0012\f\u0012\u0127\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u0133\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0000"+
		"\u0001\u0016!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000\u000f\u0001\u0000\u007f"+
		"\u0081\u0002\u0000\u0084\u0084\u0086\u0086\u0003\u0000[[ee\u0083\u0086"+
		"\u0001\u0000\u0001\u0007\u0001\u0000\b\u000e\u0001\u0000\u000f\u0017\u0001"+
		"\u0000\u0018\u001b\u0001\u0000\u001c\u001d\u0001\u0000\u001e\u001f\u0001"+
		"\u0000 #\u0001\u0000$-\u0001\u0000.2\u0001\u000034\u0001\u00006K\u0001"+
		"\u0000LM\u017d\u0000I\u0001\u0000\u0000\u0000\u0002U\u0001\u0000\u0000"+
		"\u0000\u0004W\u0001\u0000\u0000\u0000\u0006x\u0001\u0000\u0000\u0000\b"+
		"z\u0001\u0000\u0000\u0000\n\u0082\u0001\u0000\u0000\u0000\f\u0085\u0001"+
		"\u0000\u0000\u0000\u000e\u0089\u0001\u0000\u0000\u0000\u0010\u00a1\u0001"+
		"\u0000\u0000\u0000\u0012\u00a4\u0001\u0000\u0000\u0000\u0014\u00a8\u0001"+
		"\u0000\u0000\u0000\u0016\u00bb\u0001\u0000\u0000\u0000\u0018\u00da\u0001"+
		"\u0000\u0000\u0000\u001a\u00e0\u0001\u0000\u0000\u0000\u001c\u00e4\u0001"+
		"\u0000\u0000\u0000\u001e\u00e6\u0001\u0000\u0000\u0000 \u0118\u0001\u0000"+
		"\u0000\u0000\"\u011b\u0001\u0000\u0000\u0000$\u0123\u0001\u0000\u0000"+
		"\u0000&\u0132\u0001\u0000\u0000\u0000(\u0134\u0001\u0000\u0000\u0000*"+
		"\u0136\u0001\u0000\u0000\u0000,\u0138\u0001\u0000\u0000\u0000.\u013a\u0001"+
		"\u0000\u0000\u00000\u013c\u0001\u0000\u0000\u00002\u013e\u0001\u0000\u0000"+
		"\u00004\u0140\u0001\u0000\u0000\u00006\u0142\u0001\u0000\u0000\u00008"+
		"\u0144\u0001\u0000\u0000\u0000:\u0146\u0001\u0000\u0000\u0000<\u0148\u0001"+
		"\u0000\u0000\u0000>\u014a\u0001\u0000\u0000\u0000@\u014c\u0001\u0000\u0000"+
		"\u0000BD\u0003\u0002\u0001\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HJ\u0003\u0006\u0003\u0000"+
		"IE\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LP\u0001\u0000\u0000\u0000MO\u0003\u0002"+
		"\u0001\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000ST\u0005\u0000\u0000\u0001T\u0001\u0001\u0000"+
		"\u0000\u0000UV\u0005}\u0000\u0000V\u0003\u0001\u0000\u0000\u0000WX\u0003"+
		"\u0012\t\u0000XY\u0005R\u0000\u0000Y\u0005\u0001\u0000\u0000\u0000Z\\"+
		"\u0003$\u0012\u0000[]\u0003\n\u0005\u0000\\[\u0001\u0000\u0000\u0000\\"+
		"]\u0001\u0000\u0000\u0000]y\u0001\u0000\u0000\u0000^`\u0003\u0004\u0002"+
		"\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ac\u0003\u001e\u000f\u0000bd\u0003\n\u0005\u0000cb\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000dy\u0001\u0000\u0000\u0000eg\u0003"+
		"\u0004\u0002\u0000fe\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hj\u0003\f\u0006\u0000ik\u0003\n\u0005\u0000"+
		"ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ky\u0001\u0000\u0000"+
		"\u0000ln\u0003\u0004\u0002\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0003\b\u0004\u0000pr\u0003\n"+
		"\u0005\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000ry\u0001"+
		"\u0000\u0000\u0000su\u0003\u0004\u0002\u0000tv\u0003\n\u0005\u0000ut\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wy\u0003\n\u0005\u0000xZ\u0001\u0000\u0000\u0000x_\u0001\u0000\u0000\u0000"+
		"xf\u0001\u0000\u0000\u0000xm\u0001\u0000\u0000\u0000xs\u0001\u0000\u0000"+
		"\u0000xw\u0001\u0000\u0000\u0000y\u0007\u0001\u0000\u0000\u0000z\u007f"+
		"\u0003\u0016\u000b\u0000{|\u0005S\u0000\u0000|~\u0003\u0016\u000b\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\t\u0001\u0000"+
		"\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0007\u0000"+
		"\u0000\u0000\u0083\u000b\u0001\u0000\u0000\u0000\u0084\u0086\u0003\u0002"+
		"\u0001\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0003\u000e"+
		"\u0007\u0000\u0088\r\u0001\u0000\u0000\u0000\u0089\u0093\u0003&\u0013"+
		"\u0000\u008a\u008d\u0003\u0010\b\u0000\u008b\u008c\u0005S\u0000\u0000"+
		"\u008c\u008e\u0003\u0010\b\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005S\u0000\u0000\u0090\u0092\u0003\u0010\b\u0000\u0091\u008f"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094"+
		"\u0001\u0000\u0000\u0000\u0093\u008a\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u000f\u0001\u0000\u0000\u0000\u0095\u0097"+
		"\u0005j\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009a\u0005"+
		"\u0086\u0000\u0000\u0099\u009b\u0005o\u0000\u0000\u009a\u0099\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00a2\u0001\u0000"+
		"\u0000\u0000\u009c\u00a2\u0003\u0018\f\u0000\u009d\u00a2\u0003\u0016\u000b"+
		"\u0000\u009e\u00a2\u0003\"\u0011\u0000\u009f\u00a2\u0003\u0014\n\u0000"+
		"\u00a0\u00a2\u0003\u0012\t\u0000\u00a1\u0096\u0001\u0000\u0000\u0000\u00a1"+
		"\u009c\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000\u00a1"+
		"\u009e\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u0011\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a5\u0005X\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005\u0086\u0000\u0000\u00a7\u0013\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005P\u0000\u0000\u00a9\u00aa\u0005\u0083\u0000\u0000\u00aa\u0015\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0006\u000b\uffff\uffff\u0000\u00ac\u00ad"+
		"\u0005l\u0000\u0000\u00ad\u00ae\u0003\u0016\u000b\u0000\u00ae\u00af\u0005"+
		"Q\u0000\u0000\u00af\u00bc\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005o\u0000"+
		"\u0000\u00b1\u00bc\u0003\u0016\u000b\t\u00b2\u00b3\u0005j\u0000\u0000"+
		"\u00b3\u00bc\u0003\u0016\u000b\b\u00b4\u00bc\u0005\u0085\u0000\u0000\u00b5"+
		"\u00bc\u0005\u0084\u0000\u0000\u00b6\u00bc\u0005\u0083\u0000\u0000\u00b7"+
		"\u00bc\u0005\u0086\u0000\u0000\u00b8\u00bc\u0005\u0082\u0000\u0000\u00b9"+
		"\u00bc\u0003\u0014\n\u0000\u00ba\u00bc\u0005X\u0000\u0000\u00bb\u00ab"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b0\u0001\u0000\u0000\u0000\u00bb\u00b2"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b4\u0001\u0000\u0000\u0000\u00bb\u00b5"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b6\u0001\u0000\u0000\u0000\u00bb\u00b7"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b8\u0001\u0000\u0000\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00d7"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\n\u0011\u0000\u0000\u00be\u00bf\u0005"+
		"g\u0000\u0000\u00bf\u00d6\u0003\u0016\u000b\u0012\u00c0\u00c1\n\u0010"+
		"\u0000\u0000\u00c1\u00c2\u0005p\u0000\u0000\u00c2\u00d6\u0003\u0016\u000b"+
		"\u0011\u00c3\u00c4\n\u000f\u0000\u0000\u00c4\u00c5\u0005v\u0000\u0000"+
		"\u00c5\u00d6\u0003\u0016\u000b\u0010\u00c6\u00c7\n\u000e\u0000\u0000\u00c7"+
		"\u00c8\u0005b\u0000\u0000\u00c8\u00d6\u0003\u0016\u000b\u000f\u00c9\u00ca"+
		"\n\r\u0000\u0000\u00ca\u00cb\u0005h\u0000\u0000\u00cb\u00d6\u0003\u0016"+
		"\u000b\u000e\u00cc\u00cd\n\f\u0000\u0000\u00cd\u00ce\u0005\\\u0000\u0000"+
		"\u00ce\u00d6\u0003\u0016\u000b\r\u00cf\u00d0\n\u000b\u0000\u0000\u00d0"+
		"\u00d1\u0005j\u0000\u0000\u00d1\u00d6\u0003\u0016\u000b\f\u00d2\u00d3"+
		"\n\n\u0000\u0000\u00d3\u00d4\u0005o\u0000\u0000\u00d4\u00d6\u0003\u0016"+
		"\u000b\u000b\u00d5\u00bd\u0001\u0000\u0000\u0000\u00d5\u00c0\u0001\u0000"+
		"\u0000\u0000\u00d5\u00c3\u0001\u0000\u0000\u0000\u00d5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00d5\u00c9\u0001\u0000\u0000\u0000\u00d5\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d5\u00cf\u0001\u0000\u0000\u0000\u00d5\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u0017\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u001a"+
		"\r\u0000\u00db\u00dc\u0005l\u0000\u0000\u00dc\u00dd\u0003\u001c\u000e"+
		"\u0000\u00dd\u00de\u0005Q\u0000\u0000\u00de\u0019\u0001\u0000\u0000\u0000"+
		"\u00df\u00e1\u0005j\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005\u0083\u0000\u0000\u00e3\u001b\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0005\u0086\u0000\u0000\u00e5\u001d\u0001\u0000\u0000\u0000\u00e6"+
		"\u0116\u0005X\u0000\u0000\u00e7\u00e8\u0005f\u0000\u0000\u00e8\u0117\u0005"+
		"\u0082\u0000\u0000\u00e9\u00ea\u0005W\u0000\u0000\u00ea\u0117\u0005\u0086"+
		"\u0000\u0000\u00eb\u00ec\u0005V\u0000\u0000\u00ec\u0117\u0003\u0016\u000b"+
		"\u0000\u00ed\u00ee\u0005]\u0000\u0000\u00ee\u0117\u0003\u0016\u000b\u0000"+
		"\u00ef\u0117\u0005T\u0000\u0000\u00f0\u00f1\u0005n\u0000\u0000\u00f1\u0117"+
		"\u0007\u0001\u0000\u0000\u00f2\u00f3\u0005i\u0000\u0000\u00f3\u0117\u0005"+
		"\u0086\u0000\u0000\u00f4\u0117\u0005Z\u0000\u0000\u00f5\u00f6\u0005e\u0000"+
		"\u0000\u00f6\u0117\u0003\u0016\u000b\u0000\u00f7\u0117\u0005Y\u0000\u0000"+
		"\u00f8\u0117\u0005[\u0000\u0000\u00f9\u00fa\u0005^\u0000\u0000\u00fa\u0117"+
		"\u0005\u0082\u0000\u0000\u00fb\u00fc\u0005_\u0000\u0000\u00fc\u0117\u0005"+
		"\u0082\u0000\u0000\u00fd\u0117\u0005y\u0000\u0000\u00fe\u00ff\u0005d\u0000"+
		"\u0000\u00ff\u0117\u0005\u0082\u0000\u0000\u0100\u0101\u0005u\u0000\u0000"+
		"\u0101\u0102\u0003\u0016\u000b\u0000\u0102\u0103\u0005S\u0000\u0000\u0103"+
		"\u0104\u0003\u0016\u000b\u0000\u0104\u0117\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0005N\u0000\u0000\u0106\u0117\u0005\u0083\u0000\u0000\u0107\u0108"+
		"\u0005a\u0000\u0000\u0108\u0117\u0005\u0086\u0000\u0000\u0109\u010a\u0005"+
		"z\u0000\u0000\u010a\u010b\u0005\u0086\u0000\u0000\u010b\u010c\u0005S\u0000"+
		"\u0000\u010c\u0117\u0003 \u0010\u0000\u010d\u010e\u0005m\u0000\u0000\u010e"+
		"\u0117\u0005k\u0000\u0000\u010f\u0117\u0005U\u0000\u0000\u0110\u0111\u0005"+
		"{\u0000\u0000\u0111\u0117\u0003\u0016\u000b\u0000\u0112\u0113\u0005w\u0000"+
		"\u0000\u0113\u0117\u0003\u0016\u000b\u0000\u0114\u0115\u0005x\u0000\u0000"+
		"\u0115\u0117\u0005\u0082\u0000\u0000\u0116\u00e7\u0001\u0000\u0000\u0000"+
		"\u0116\u00e9\u0001\u0000\u0000\u0000\u0116\u00eb\u0001\u0000\u0000\u0000"+
		"\u0116\u00ed\u0001\u0000\u0000\u0000\u0116\u00ef\u0001\u0000\u0000\u0000"+
		"\u0116\u00f0\u0001\u0000\u0000\u0000\u0116\u00f2\u0001\u0000\u0000\u0000"+
		"\u0116\u00f4\u0001\u0000\u0000\u0000\u0116\u00f5\u0001\u0000\u0000\u0000"+
		"\u0116\u00f7\u0001\u0000\u0000\u0000\u0116\u00f8\u0001\u0000\u0000\u0000"+
		"\u0116\u00f9\u0001\u0000\u0000\u0000\u0116\u00fb\u0001\u0000\u0000\u0000"+
		"\u0116\u00fd\u0001\u0000\u0000\u0000\u0116\u00fe\u0001\u0000\u0000\u0000"+
		"\u0116\u0100\u0001\u0000\u0000\u0000\u0116\u0105\u0001\u0000\u0000\u0000"+
		"\u0116\u0107\u0001\u0000\u0000\u0000\u0116\u0109\u0001\u0000\u0000\u0000"+
		"\u0116\u010d\u0001\u0000\u0000\u0000\u0116\u010f\u0001\u0000\u0000\u0000"+
		"\u0116\u0110\u0001\u0000\u0000\u0000\u0116\u0112\u0001\u0000\u0000\u0000"+
		"\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u001f\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0005P\u0000\u0000\u0119\u011a\u0005`\u0000\u0000\u011a!"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u0086\u0000\u0000\u011c\u011f"+
		"\u0005l\u0000\u0000\u011d\u0120\u0005\u0086\u0000\u0000\u011e\u0120\u0003"+
		"\u0014\n\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u011e\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0005Q\u0000"+
		"\u0000\u0122#\u0001\u0000\u0000\u0000\u0123\u0125\u0005c\u0000\u0000\u0124"+
		"\u0126\u0007\u0002\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127"+
		"\u0128\u0001\u0000\u0000\u0000\u0128%\u0001\u0000\u0000\u0000\u0129\u0133"+
		"\u0003(\u0014\u0000\u012a\u0133\u0003*\u0015\u0000\u012b\u0133\u0003,"+
		"\u0016\u0000\u012c\u0133\u00030\u0018\u0000\u012d\u0133\u00034\u001a\u0000"+
		"\u012e\u0133\u00036\u001b\u0000\u012f\u0133\u00038\u001c\u0000\u0130\u0133"+
		"\u0003<\u001e\u0000\u0131\u0133\u0003>\u001f\u0000\u0132\u0129\u0001\u0000"+
		"\u0000\u0000\u0132\u012a\u0001\u0000\u0000\u0000\u0132\u012b\u0001\u0000"+
		"\u0000\u0000\u0132\u012c\u0001\u0000\u0000\u0000\u0132\u012d\u0001\u0000"+
		"\u0000\u0000\u0132\u012e\u0001\u0000\u0000\u0000\u0132\u012f\u0001\u0000"+
		"\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0131\u0001\u0000"+
		"\u0000\u0000\u0133\'\u0001\u0000\u0000\u0000\u0134\u0135\u0007\u0003\u0000"+
		"\u0000\u0135)\u0001\u0000\u0000\u0000\u0136\u0137\u0007\u0004\u0000\u0000"+
		"\u0137+\u0001\u0000\u0000\u0000\u0138\u0139\u0007\u0005\u0000\u0000\u0139"+
		"-\u0001\u0000\u0000\u0000\u013a\u013b\u0007\u0006\u0000\u0000\u013b/\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0007\u0007\u0000\u0000\u013d1\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0007\b\u0000\u0000\u013f3\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0007\t\u0000\u0000\u01415\u0001\u0000\u0000\u0000"+
		"\u0142\u0143\u0007\n\u0000\u0000\u01437\u0001\u0000\u0000\u0000\u0144"+
		"\u0145\u0007\u000b\u0000\u0000\u01459\u0001\u0000\u0000\u0000\u0146\u0147"+
		"\u0007\f\u0000\u0000\u0147;\u0001\u0000\u0000\u0000\u0148\u0149\u0005"+
		"5\u0000\u0000\u0149=\u0001\u0000\u0000\u0000\u014a\u014b\u0007\r\u0000"+
		"\u0000\u014b?\u0001\u0000\u0000\u0000\u014c\u014d\u0007\u000e\u0000\u0000"+
		"\u014dA\u0001\u0000\u0000\u0000\u001dEKP\\_cfjmqux\u007f\u0085\u008d\u0091"+
		"\u0093\u0096\u009a\u00a1\u00a4\u00bb\u00d5\u00d7\u00e0\u0116\u011f\u0127"+
		"\u0132";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}