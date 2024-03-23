// Generated from c:/aaa_se/cpp_compiler/src/main/antlr4/com/cpp/grammar/CPP14Parser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CPP14Parser extends grammar.CPP14ParserBase {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntegerLiteral=1, CharacterLiteral=2, FloatingLiteral=3, StringLiteral=4, 
		BooleanLiteral=5, PointerLiteral=6, UserDefinedLiteral=7, LineBreakCombiner=8, 
		Alignas=9, Alignof=10, Asm=11, Auto=12, Bool=13, Break=14, Case=15, Catch=16, 
		Char=17, Char16=18, Char32=19, Class=20, Const=21, Constexpr=22, Const_cast=23, 
		Continue=24, Decltype=25, Default=26, Delete=27, Do=28, Double=29, Dynamic_cast=30, 
		Else=31, Enum=32, Explicit=33, Export=34, Extern=35, False_=36, Final=37, 
		Float=38, For=39, Friend=40, Goto=41, If=42, Inline=43, Int=44, Long=45, 
		Mutable=46, Namespace=47, New=48, Noexcept=49, Nullptr=50, Operator=51, 
		Override=52, Private=53, Protected=54, Public=55, Register=56, Reinterpret_cast=57, 
		Return=58, Short=59, Signed=60, Sizeof=61, Static=62, Static_assert=63, 
		Static_cast=64, Struct=65, Switch=66, Template=67, This=68, Thread_local=69, 
		Throw=70, True_=71, Try=72, Typedef=73, Typeid_=74, Typename_=75, Union=76, 
		Unsigned=77, Using=78, Virtual=79, Void=80, Volatile=81, Wchar=82, While=83, 
		LeftParen=84, RightParen=85, LeftBracket=86, RightBracket=87, LeftBrace=88, 
		RightBrace=89, Plus=90, Minus=91, Star=92, Div=93, Mod=94, Caret=95, And=96, 
		Or=97, Tilde=98, Not=99, Assign=100, Less=101, Greater=102, PlusAssign=103, 
		MinusAssign=104, StarAssign=105, DivAssign=106, ModAssign=107, XorAssign=108, 
		AndAssign=109, OrAssign=110, LeftShiftAssign=111, RightShiftAssign=112, 
		Equal=113, NotEqual=114, LessEqual=115, GreaterEqual=116, AndAnd=117, 
		OrOr=118, PlusPlus=119, MinusMinus=120, Comma=121, ArrowStar=122, Arrow=123, 
		Question=124, Colon=125, Doublecolon=126, Semi=127, Dot=128, DotStar=129, 
		Ellipsis=130, Identifier=131, DecimalLiteral=132, OctalLiteral=133, HexadecimalLiteral=134, 
		BinaryLiteral=135, Integersuffix=136, UserDefinedIntegerLiteral=137, UserDefinedFloatingLiteral=138, 
		UserDefinedStringLiteral=139, UserDefinedCharacterLiteral=140, Whitespace=141, 
		Newline=142, BlockComment=143, LineComment=144;
	public static final int
		RULE_translationUnit = 0, RULE_primaryExpression = 1, RULE_idExpression = 2, 
		RULE_unqualifiedId = 3, RULE_qualifiedId = 4, RULE_nestedNameSpecifier = 5, 
		RULE_lambdaExpression = 6, RULE_lambdaIntroducer = 7, RULE_lambdaCapture = 8, 
		RULE_captureDefault = 9, RULE_captureList = 10, RULE_capture = 11, RULE_simpleCapture = 12, 
		RULE_initcapture = 13, RULE_lambdaDeclarator = 14, RULE_postfixExpression = 15, 
		RULE_typeIdOfTheTypeId = 16, RULE_expressionList = 17, RULE_pseudoDestructorName = 18, 
		RULE_unaryExpression = 19, RULE_unaryOperator = 20, RULE_newExpression_ = 21, 
		RULE_newPlacement = 22, RULE_newTypeId = 23, RULE_newDeclarator_ = 24, 
		RULE_noPointerNewDeclarator = 25, RULE_newInitializer_ = 26, RULE_deleteExpression = 27, 
		RULE_noExceptExpression = 28, RULE_castExpression = 29, RULE_pointerMemberExpression = 30, 
		RULE_multiplicativeExpression = 31, RULE_additiveExpression = 32, RULE_shiftExpression = 33, 
		RULE_shiftOperator = 34, RULE_relationalExpression = 35, RULE_equalityExpression = 36, 
		RULE_andExpression = 37, RULE_exclusiveOrExpression = 38, RULE_inclusiveOrExpression = 39, 
		RULE_logicalAndExpression = 40, RULE_logicalOrExpression = 41, RULE_conditionalExpression = 42, 
		RULE_assignmentExpression = 43, RULE_assignmentOperator = 44, RULE_expression = 45, 
		RULE_constantExpression = 46, RULE_statement = 47, RULE_labeledStatement = 48, 
		RULE_expressionStatement = 49, RULE_compoundStatement = 50, RULE_statementSeq = 51, 
		RULE_selectionStatement = 52, RULE_condition = 53, RULE_iterationStatement = 54, 
		RULE_forInitStatement = 55, RULE_forRangeDeclaration = 56, RULE_forRangeInitializer = 57, 
		RULE_jumpStatement = 58, RULE_declarationStatement = 59, RULE_declarationseq = 60, 
		RULE_declaration = 61, RULE_blockDeclaration = 62, RULE_aliasDeclaration = 63, 
		RULE_simpleDeclaration = 64, RULE_staticAssertDeclaration = 65, RULE_emptyDeclaration_ = 66, 
		RULE_attributeDeclaration = 67, RULE_declSpecifier = 68, RULE_declSpecifierSeq = 69, 
		RULE_storageClassSpecifier = 70, RULE_functionSpecifier = 71, RULE_typedefName = 72, 
		RULE_typeSpecifier = 73, RULE_trailingTypeSpecifier = 74, RULE_typeSpecifierSeq = 75, 
		RULE_trailingTypeSpecifierSeq = 76, RULE_simpleTypeLengthModifier = 77, 
		RULE_simpleTypeSignednessModifier = 78, RULE_simpleTypeSpecifier = 79, 
		RULE_theTypeName = 80, RULE_decltypeSpecifier = 81, RULE_elaboratedTypeSpecifier = 82, 
		RULE_enumName = 83, RULE_enumSpecifier = 84, RULE_enumHead = 85, RULE_opaqueEnumDeclaration = 86, 
		RULE_enumkey = 87, RULE_enumbase = 88, RULE_enumeratorList = 89, RULE_enumeratorDefinition = 90, 
		RULE_enumerator = 91, RULE_namespaceName = 92, RULE_originalNamespaceName = 93, 
		RULE_namespaceDefinition = 94, RULE_namespaceAlias = 95, RULE_namespaceAliasDefinition = 96, 
		RULE_qualifiednamespacespecifier = 97, RULE_usingDeclaration = 98, RULE_usingDirective = 99, 
		RULE_asmDefinition = 100, RULE_linkageSpecification = 101, RULE_attributeSpecifierSeq = 102, 
		RULE_attributeSpecifier = 103, RULE_alignmentspecifier = 104, RULE_attributeList = 105, 
		RULE_attribute = 106, RULE_attributeNamespace = 107, RULE_attributeArgumentClause = 108, 
		RULE_balancedTokenSeq = 109, RULE_balancedtoken = 110, RULE_initDeclaratorList = 111, 
		RULE_initDeclarator = 112, RULE_declarator = 113, RULE_pointerDeclarator = 114, 
		RULE_noPointerDeclarator = 115, RULE_parametersAndQualifiers = 116, RULE_trailingReturnType = 117, 
		RULE_pointerOperator = 118, RULE_cvqualifierseq = 119, RULE_cvQualifier = 120, 
		RULE_refqualifier = 121, RULE_declaratorid = 122, RULE_theTypeId = 123, 
		RULE_abstractDeclarator = 124, RULE_pointerAbstractDeclarator = 125, RULE_noPointerAbstractDeclarator = 126, 
		RULE_abstractPackDeclarator = 127, RULE_noPointerAbstractPackDeclarator = 128, 
		RULE_parameterDeclarationClause = 129, RULE_parameterDeclarationList = 130, 
		RULE_parameterDeclaration = 131, RULE_functionDefinition = 132, RULE_functionBody = 133, 
		RULE_initializer = 134, RULE_braceOrEqualInitializer = 135, RULE_initializerClause = 136, 
		RULE_initializerList = 137, RULE_bracedInitList = 138, RULE_className = 139, 
		RULE_classSpecifier = 140, RULE_classHead = 141, RULE_classHeadName = 142, 
		RULE_classVirtSpecifier = 143, RULE_classKey = 144, RULE_memberSpecification = 145, 
		RULE_memberdeclaration = 146, RULE_memberDeclaratorList = 147, RULE_memberDeclarator = 148, 
		RULE_virtualSpecifierSeq = 149, RULE_virtualSpecifier = 150, RULE_pureSpecifier = 151, 
		RULE_baseClause = 152, RULE_baseSpecifierList = 153, RULE_baseSpecifier = 154, 
		RULE_classOrDeclType = 155, RULE_baseTypeSpecifier = 156, RULE_accessSpecifier = 157, 
		RULE_conversionFunctionId = 158, RULE_conversionTypeId = 159, RULE_conversionDeclarator = 160, 
		RULE_constructorInitializer = 161, RULE_memInitializerList = 162, RULE_memInitializer = 163, 
		RULE_meminitializerid = 164, RULE_operatorFunctionId = 165, RULE_literalOperatorId = 166, 
		RULE_templateDeclaration = 167, RULE_templateparameterList = 168, RULE_templateParameter = 169, 
		RULE_typeParameter = 170, RULE_simpleTemplateId = 171, RULE_templateId = 172, 
		RULE_templateName = 173, RULE_templateArgumentList = 174, RULE_templateArgument = 175, 
		RULE_typeNameSpecifier = 176, RULE_explicitInstantiation = 177, RULE_explicitSpecialization = 178, 
		RULE_tryBlock = 179, RULE_functionTryBlock = 180, RULE_handlerSeq = 181, 
		RULE_handler = 182, RULE_exceptionDeclaration = 183, RULE_throwExpression = 184, 
		RULE_exceptionSpecification = 185, RULE_dynamicExceptionSpecification = 186, 
		RULE_typeIdList = 187, RULE_noeExceptSpecification = 188, RULE_theOperator = 189, 
		RULE_literal = 190;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "primaryExpression", "idExpression", "unqualifiedId", 
			"qualifiedId", "nestedNameSpecifier", "lambdaExpression", "lambdaIntroducer", 
			"lambdaCapture", "captureDefault", "captureList", "capture", "simpleCapture", 
			"initcapture", "lambdaDeclarator", "postfixExpression", "typeIdOfTheTypeId", 
			"expressionList", "pseudoDestructorName", "unaryExpression", "unaryOperator", 
			"newExpression_", "newPlacement", "newTypeId", "newDeclarator_", "noPointerNewDeclarator", 
			"newInitializer_", "deleteExpression", "noExceptExpression", "castExpression", 
			"pointerMemberExpression", "multiplicativeExpression", "additiveExpression", 
			"shiftExpression", "shiftOperator", "relationalExpression", "equalityExpression", 
			"andExpression", "exclusiveOrExpression", "inclusiveOrExpression", "logicalAndExpression", 
			"logicalOrExpression", "conditionalExpression", "assignmentExpression", 
			"assignmentOperator", "expression", "constantExpression", "statement", 
			"labeledStatement", "expressionStatement", "compoundStatement", "statementSeq", 
			"selectionStatement", "condition", "iterationStatement", "forInitStatement", 
			"forRangeDeclaration", "forRangeInitializer", "jumpStatement", "declarationStatement", 
			"declarationseq", "declaration", "blockDeclaration", "aliasDeclaration", 
			"simpleDeclaration", "staticAssertDeclaration", "emptyDeclaration_", 
			"attributeDeclaration", "declSpecifier", "declSpecifierSeq", "storageClassSpecifier", 
			"functionSpecifier", "typedefName", "typeSpecifier", "trailingTypeSpecifier", 
			"typeSpecifierSeq", "trailingTypeSpecifierSeq", "simpleTypeLengthModifier", 
			"simpleTypeSignednessModifier", "simpleTypeSpecifier", "theTypeName", 
			"decltypeSpecifier", "elaboratedTypeSpecifier", "enumName", "enumSpecifier", 
			"enumHead", "opaqueEnumDeclaration", "enumkey", "enumbase", "enumeratorList", 
			"enumeratorDefinition", "enumerator", "namespaceName", "originalNamespaceName", 
			"namespaceDefinition", "namespaceAlias", "namespaceAliasDefinition", 
			"qualifiednamespacespecifier", "usingDeclaration", "usingDirective", 
			"asmDefinition", "linkageSpecification", "attributeSpecifierSeq", "attributeSpecifier", 
			"alignmentspecifier", "attributeList", "attribute", "attributeNamespace", 
			"attributeArgumentClause", "balancedTokenSeq", "balancedtoken", "initDeclaratorList", 
			"initDeclarator", "declarator", "pointerDeclarator", "noPointerDeclarator", 
			"parametersAndQualifiers", "trailingReturnType", "pointerOperator", "cvqualifierseq", 
			"cvQualifier", "refqualifier", "declaratorid", "theTypeId", "abstractDeclarator", 
			"pointerAbstractDeclarator", "noPointerAbstractDeclarator", "abstractPackDeclarator", 
			"noPointerAbstractPackDeclarator", "parameterDeclarationClause", "parameterDeclarationList", 
			"parameterDeclaration", "functionDefinition", "functionBody", "initializer", 
			"braceOrEqualInitializer", "initializerClause", "initializerList", "bracedInitList", 
			"className", "classSpecifier", "classHead", "classHeadName", "classVirtSpecifier", 
			"classKey", "memberSpecification", "memberdeclaration", "memberDeclaratorList", 
			"memberDeclarator", "virtualSpecifierSeq", "virtualSpecifier", "pureSpecifier", 
			"baseClause", "baseSpecifierList", "baseSpecifier", "classOrDeclType", 
			"baseTypeSpecifier", "accessSpecifier", "conversionFunctionId", "conversionTypeId", 
			"conversionDeclarator", "constructorInitializer", "memInitializerList", 
			"memInitializer", "meminitializerid", "operatorFunctionId", "literalOperatorId", 
			"templateDeclaration", "templateparameterList", "templateParameter", 
			"typeParameter", "simpleTemplateId", "templateId", "templateName", "templateArgumentList", 
			"templateArgument", "typeNameSpecifier", "explicitInstantiation", "explicitSpecialization", 
			"tryBlock", "functionTryBlock", "handlerSeq", "handler", "exceptionDeclaration", 
			"throwExpression", "exceptionSpecification", "dynamicExceptionSpecification", 
			"typeIdList", "noeExceptSpecification", "theOperator", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'alignas'", "'alignof'", 
			"'asm'", "'auto'", "'bool'", "'break'", "'case'", "'catch'", "'char'", 
			"'char16_t'", "'char32_t'", "'class'", "'const'", "'constexpr'", "'const_cast'", 
			"'continue'", "'decltype'", "'default'", "'delete'", "'do'", "'double'", 
			"'dynamic_cast'", "'else'", "'enum'", "'explicit'", "'export'", "'extern'", 
			"'false'", "'final'", "'float'", "'for'", "'friend'", "'goto'", "'if'", 
			"'inline'", "'int'", "'long'", "'mutable'", "'namespace'", "'new'", "'noexcept'", 
			"'nullptr'", "'operator'", "'override'", "'private'", "'protected'", 
			"'public'", "'register'", "'reinterpret_cast'", "'return'", "'short'", 
			"'signed'", "'sizeof'", "'static'", "'static_assert'", "'static_cast'", 
			"'struct'", "'switch'", "'template'", "'this'", "'thread_local'", "'throw'", 
			"'true'", "'try'", "'typedef'", "'typeid'", "'typename'", "'union'", 
			"'unsigned'", "'using'", "'virtual'", "'void'", "'volatile'", "'wchar_t'", 
			"'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'^'", "'&'", "'|'", "'~'", null, "'='", "'<'", "'>'", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'^='", "'&='", "'|='", "'<<='", 
			"'>>='", "'=='", "'!='", "'<='", "'>='", null, null, "'++'", "'--'", 
			"','", "'->*'", "'->'", "'?'", "':'", "'::'", "';'", "'.'", "'.*'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IntegerLiteral", "CharacterLiteral", "FloatingLiteral", "StringLiteral", 
			"BooleanLiteral", "PointerLiteral", "UserDefinedLiteral", "LineBreakCombiner", 
			"Alignas", "Alignof", "Asm", "Auto", "Bool", "Break", "Case", "Catch", 
			"Char", "Char16", "Char32", "Class", "Const", "Constexpr", "Const_cast", 
			"Continue", "Decltype", "Default", "Delete", "Do", "Double", "Dynamic_cast", 
			"Else", "Enum", "Explicit", "Export", "Extern", "False_", "Final", "Float", 
			"For", "Friend", "Goto", "If", "Inline", "Int", "Long", "Mutable", "Namespace", 
			"New", "Noexcept", "Nullptr", "Operator", "Override", "Private", "Protected", 
			"Public", "Register", "Reinterpret_cast", "Return", "Short", "Signed", 
			"Sizeof", "Static", "Static_assert", "Static_cast", "Struct", "Switch", 
			"Template", "This", "Thread_local", "Throw", "True_", "Try", "Typedef", 
			"Typeid_", "Typename_", "Union", "Unsigned", "Using", "Virtual", "Void", 
			"Volatile", "Wchar", "While", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", "Star", "Div", 
			"Mod", "Caret", "And", "Or", "Tilde", "Not", "Assign", "Less", "Greater", 
			"PlusAssign", "MinusAssign", "StarAssign", "DivAssign", "ModAssign", 
			"XorAssign", "AndAssign", "OrAssign", "LeftShiftAssign", "RightShiftAssign", 
			"Equal", "NotEqual", "LessEqual", "GreaterEqual", "AndAnd", "OrOr", "PlusPlus", 
			"MinusMinus", "Comma", "ArrowStar", "Arrow", "Question", "Colon", "Doublecolon", 
			"Semi", "Dot", "DotStar", "Ellipsis", "Identifier", "DecimalLiteral", 
			"OctalLiteral", "HexadecimalLiteral", "BinaryLiteral", "Integersuffix", 
			"UserDefinedIntegerLiteral", "UserDefinedFloatingLiteral", "UserDefinedStringLiteral", 
			"UserDefinedCharacterLiteral", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
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
	public String getGrammarFileName() { return "CPP14Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CPP14Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CPP14Parser.EOF, 0); }
		public List<DeclarationseqContext> declarationseq() {
			return getRuleContexts(DeclarationseqContext.class);
		}
		public DeclarationseqContext declarationseq(int i) {
			return getRuleContext(DeclarationseqContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1543754443169808157L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 459384754220313597L) != 0)) {
				{
				{
				setState(382);
				declarationseq();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public TerminalNode This() { return getToken(CPP14Parser.This, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primaryExpression);
		try {
			int _alt;
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(391); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(390);
						literal();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(393); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				match(This);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 3);
				{
				setState(396);
				match(LeftParen);
				setState(397);
				expression();
				setState(398);
				match(RightParen);
				}
				break;
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(400);
				idExpression();
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 5);
				{
				setState(401);
				lambdaExpression();
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
	public static class IdExpressionContext extends ParserRuleContext {
		public UnqualifiedIdContext unqualifiedId() {
			return getRuleContext(UnqualifiedIdContext.class,0);
		}
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public IdExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idExpression; }
	}

	public final IdExpressionContext idExpression() throws RecognitionException {
		IdExpressionContext _localctx = new IdExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_idExpression);
		try {
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				unqualifiedId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				qualifiedId();
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
	public static class UnqualifiedIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public OperatorFunctionIdContext operatorFunctionId() {
			return getRuleContext(OperatorFunctionIdContext.class,0);
		}
		public ConversionFunctionIdContext conversionFunctionId() {
			return getRuleContext(ConversionFunctionIdContext.class,0);
		}
		public LiteralOperatorIdContext literalOperatorId() {
			return getRuleContext(LiteralOperatorIdContext.class,0);
		}
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public TemplateIdContext templateId() {
			return getRuleContext(TemplateIdContext.class,0);
		}
		public UnqualifiedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unqualifiedId; }
	}

	public final UnqualifiedIdContext unqualifiedId() throws RecognitionException {
		UnqualifiedIdContext _localctx = new UnqualifiedIdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unqualifiedId);
		try {
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(409);
				operatorFunctionId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(410);
				conversionFunctionId();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(411);
				literalOperatorId();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(412);
				match(Tilde);
				setState(415);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(413);
					className();
					}
					break;
				case Decltype:
					{
					setState(414);
					decltypeSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(417);
				templateId();
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
	public static class QualifiedIdContext extends ParserRuleContext {
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public UnqualifiedIdContext unqualifiedId() {
			return getRuleContext(UnqualifiedIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public QualifiedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedId; }
	}

	public final QualifiedIdContext qualifiedId() throws RecognitionException {
		QualifiedIdContext _localctx = new QualifiedIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qualifiedId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			nestedNameSpecifier(0);
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Template) {
				{
				setState(421);
				match(Template);
				}
			}

			setState(424);
			unqualifiedId();
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
	public static class NestedNameSpecifierContext extends ParserRuleContext {
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TheTypeNameContext theTypeName() {
			return getRuleContext(TheTypeNameContext.class,0);
		}
		public NamespaceNameContext namespaceName() {
			return getRuleContext(NamespaceNameContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public NestedNameSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedNameSpecifier; }
	}

	public final NestedNameSpecifierContext nestedNameSpecifier() throws RecognitionException {
		return nestedNameSpecifier(0);
	}

	private NestedNameSpecifierContext nestedNameSpecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NestedNameSpecifierContext _localctx = new NestedNameSpecifierContext(_ctx, _parentState);
		NestedNameSpecifierContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_nestedNameSpecifier, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(430);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(427);
				theTypeName();
				}
				break;
			case 2:
				{
				setState(428);
				namespaceName();
				}
				break;
			case 3:
				{
				setState(429);
				decltypeSpecifier();
				}
				break;
			}
			setState(432);
			match(Doublecolon);
			}
			_ctx.stop = _input.LT(-1);
			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NestedNameSpecifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_nestedNameSpecifier);
					setState(434);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(440);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(435);
						match(Identifier);
						}
						break;
					case 2:
						{
						setState(437);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Template) {
							{
							setState(436);
							match(Template);
							}
						}

						setState(439);
						simpleTemplateId();
						}
						break;
					}
					setState(442);
					match(Doublecolon);
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaIntroducerContext lambdaIntroducer() {
			return getRuleContext(LambdaIntroducerContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public LambdaDeclaratorContext lambdaDeclarator() {
			return getRuleContext(LambdaDeclaratorContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lambdaExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			lambdaIntroducer();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(449);
				lambdaDeclarator();
				}
			}

			setState(452);
			compoundStatement();
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
	public static class LambdaIntroducerContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public LambdaCaptureContext lambdaCapture() {
			return getRuleContext(LambdaCaptureContext.class,0);
		}
		public LambdaIntroducerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaIntroducer; }
	}

	public final LambdaIntroducerContext lambdaIntroducer() throws RecognitionException {
		LambdaIntroducerContext _localctx = new LambdaIntroducerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lambdaIntroducer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(LeftBracket);
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -9223372032291373055L) != 0)) {
				{
				setState(455);
				lambdaCapture();
				}
			}

			setState(458);
			match(RightBracket);
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
	public static class LambdaCaptureContext extends ParserRuleContext {
		public CaptureListContext captureList() {
			return getRuleContext(CaptureListContext.class,0);
		}
		public CaptureDefaultContext captureDefault() {
			return getRuleContext(CaptureDefaultContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public LambdaCaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaCapture; }
	}

	public final LambdaCaptureContext lambdaCapture() throws RecognitionException {
		LambdaCaptureContext _localctx = new LambdaCaptureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdaCapture);
		int _la;
		try {
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				captureList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				captureDefault();
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(462);
					match(Comma);
					setState(463);
					captureList();
					}
				}

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
	public static class CaptureDefaultContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public CaptureDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_captureDefault; }
	}

	public final CaptureDefaultContext captureDefault() throws RecognitionException {
		CaptureDefaultContext _localctx = new CaptureDefaultContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_captureDefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_la = _input.LA(1);
			if ( !(_la==And || _la==Assign) ) {
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
	public static class CaptureListContext extends ParserRuleContext {
		public List<CaptureContext> capture() {
			return getRuleContexts(CaptureContext.class);
		}
		public CaptureContext capture(int i) {
			return getRuleContext(CaptureContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public CaptureListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_captureList; }
	}

	public final CaptureListContext captureList() throws RecognitionException {
		CaptureListContext _localctx = new CaptureListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_captureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			capture();
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(471);
				match(Comma);
				setState(472);
				capture();
				}
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(478);
				match(Ellipsis);
				}
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
	public static class CaptureContext extends ParserRuleContext {
		public SimpleCaptureContext simpleCapture() {
			return getRuleContext(SimpleCaptureContext.class,0);
		}
		public InitcaptureContext initcapture() {
			return getRuleContext(InitcaptureContext.class,0);
		}
		public CaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture; }
	}

	public final CaptureContext capture() throws RecognitionException {
		CaptureContext _localctx = new CaptureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_capture);
		try {
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				simpleCapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				initcapture();
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
	public static class SimpleCaptureContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode This() { return getToken(CPP14Parser.This, 0); }
		public SimpleCaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCapture; }
	}

	public final SimpleCaptureContext simpleCapture() throws RecognitionException {
		SimpleCaptureContext _localctx = new SimpleCaptureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleCapture);
		int _la;
		try {
			setState(490);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==And) {
					{
					setState(485);
					match(And);
					}
				}

				setState(488);
				match(Identifier);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				match(This);
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
	public static class InitcaptureContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public InitcaptureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initcapture; }
	}

	public final InitcaptureContext initcapture() throws RecognitionException {
		InitcaptureContext _localctx = new InitcaptureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initcapture);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(492);
				match(And);
				}
			}

			setState(495);
			match(Identifier);
			setState(496);
			initializer();
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
	public static class LambdaDeclaratorContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ParameterDeclarationClauseContext parameterDeclarationClause() {
			return getRuleContext(ParameterDeclarationClauseContext.class,0);
		}
		public TerminalNode Mutable() { return getToken(CPP14Parser.Mutable, 0); }
		public ExceptionSpecificationContext exceptionSpecification() {
			return getRuleContext(ExceptionSpecificationContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TrailingReturnTypeContext trailingReturnType() {
			return getRuleContext(TrailingReturnTypeContext.class,0);
		}
		public LambdaDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaDeclarator; }
	}

	public final LambdaDeclaratorContext lambdaDeclarator() throws RecognitionException {
		LambdaDeclaratorContext _localctx = new LambdaDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lambdaDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(LeftParen);
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1237504995584196377L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 297237575406461917L) != 0)) {
				{
				setState(499);
				parameterDeclarationClause();
				}
			}

			setState(502);
			match(RightParen);
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Mutable) {
				{
				setState(503);
				match(Mutable);
				}
			}

			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Noexcept || _la==Throw) {
				{
				setState(506);
				exceptionSpecification();
				}
			}

			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(509);
				attributeSpecifierSeq();
				}
			}

			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Arrow) {
				{
				setState(512);
				trailingReturnType();
				}
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
	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public SimpleTypeSpecifierContext simpleTypeSpecifier() {
			return getRuleContext(SimpleTypeSpecifierContext.class,0);
		}
		public TypeNameSpecifierContext typeNameSpecifier() {
			return getRuleContext(TypeNameSpecifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dynamic_cast() { return getToken(CPP14Parser.Dynamic_cast, 0); }
		public TerminalNode Static_cast() { return getToken(CPP14Parser.Static_cast, 0); }
		public TerminalNode Reinterpret_cast() { return getToken(CPP14Parser.Reinterpret_cast, 0); }
		public TerminalNode Const_cast() { return getToken(CPP14Parser.Const_cast, 0); }
		public TypeIdOfTheTypeIdContext typeIdOfTheTypeId() {
			return getRuleContext(TypeIdOfTheTypeIdContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public TerminalNode Dot() { return getToken(CPP14Parser.Dot, 0); }
		public TerminalNode Arrow() { return getToken(CPP14Parser.Arrow, 0); }
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public PseudoDestructorNameContext pseudoDestructorName() {
			return getRuleContext(PseudoDestructorNameContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode PlusPlus() { return getToken(CPP14Parser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPP14Parser.MinusMinus, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(516);
				primaryExpression();
				}
				break;
			case 2:
				{
				setState(519);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Decltype:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Unsigned:
				case Void:
				case Wchar:
				case Doublecolon:
				case Identifier:
					{
					setState(517);
					simpleTypeSpecifier();
					}
					break;
				case Typename_:
					{
					setState(518);
					typeNameSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(527);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
					{
					setState(521);
					match(LeftParen);
					setState(523);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257204718907L) != 0)) {
						{
						setState(522);
						expressionList();
						}
					}

					setState(525);
					match(RightParen);
					}
					break;
				case LeftBrace:
					{
					setState(526);
					bracedInitList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(529);
				_la = _input.LA(1);
				if ( !(((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 2216203124865L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(530);
				match(Less);
				setState(531);
				theTypeId();
				setState(532);
				match(Greater);
				setState(533);
				match(LeftParen);
				setState(534);
				expression();
				setState(535);
				match(RightParen);
				}
				break;
			case 4:
				{
				setState(537);
				typeIdOfTheTypeId();
				setState(538);
				match(LeftParen);
				setState(541);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(539);
					expression();
					}
					break;
				case 2:
					{
					setState(540);
					theTypeId();
					}
					break;
				}
				setState(543);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(574);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(572);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(547);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(548);
						match(LeftBracket);
						setState(551);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IntegerLiteral:
						case CharacterLiteral:
						case FloatingLiteral:
						case StringLiteral:
						case BooleanLiteral:
						case PointerLiteral:
						case UserDefinedLiteral:
						case Alignof:
						case Auto:
						case Bool:
						case Char:
						case Char16:
						case Char32:
						case Const_cast:
						case Decltype:
						case Delete:
						case Double:
						case Dynamic_cast:
						case Float:
						case Int:
						case Long:
						case New:
						case Noexcept:
						case Operator:
						case Reinterpret_cast:
						case Short:
						case Signed:
						case Sizeof:
						case Static_cast:
						case This:
						case Throw:
						case Typeid_:
						case Typename_:
						case Unsigned:
						case Void:
						case Wchar:
						case LeftParen:
						case LeftBracket:
						case Plus:
						case Minus:
						case Star:
						case And:
						case Or:
						case Tilde:
						case Not:
						case PlusPlus:
						case MinusMinus:
						case Doublecolon:
						case Identifier:
							{
							setState(549);
							expression();
							}
							break;
						case LeftBrace:
							{
							setState(550);
							bracedInitList();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(553);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(555);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(556);
						match(LeftParen);
						setState(558);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257204718907L) != 0)) {
							{
							setState(557);
							expressionList();
							}
						}

						setState(560);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(561);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(562);
						_la = _input.LA(1);
						if ( !(_la==Arrow || _la==Dot) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(568);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
						case 1:
							{
							setState(564);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Template) {
								{
								setState(563);
								match(Template);
								}
							}

							setState(566);
							idExpression();
							}
							break;
						case 2:
							{
							setState(567);
							pseudoDestructorName();
							}
							break;
						}
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(570);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(571);
						_la = _input.LA(1);
						if ( !(_la==PlusPlus || _la==MinusMinus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(576);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	public static class TypeIdOfTheTypeIdContext extends ParserRuleContext {
		public TerminalNode Typeid_() { return getToken(CPP14Parser.Typeid_, 0); }
		public TypeIdOfTheTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdOfTheTypeId; }
	}

	public final TypeIdOfTheTypeIdContext typeIdOfTheTypeId() throws RecognitionException {
		TypeIdOfTheTypeIdContext _localctx = new TypeIdOfTheTypeIdContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeIdOfTheTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(Typeid_);
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
	public static class ExpressionListContext extends ParserRuleContext {
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			initializerList();
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
	public static class PseudoDestructorNameContext extends ParserRuleContext {
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public List<TheTypeNameContext> theTypeName() {
			return getRuleContexts(TheTypeNameContext.class);
		}
		public TheTypeNameContext theTypeName(int i) {
			return getRuleContext(TheTypeNameContext.class,i);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public PseudoDestructorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudoDestructorName; }
	}

	public final PseudoDestructorNameContext pseudoDestructorName() throws RecognitionException {
		PseudoDestructorNameContext _localctx = new PseudoDestructorNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pseudoDestructorName);
		int _la;
		try {
			setState(600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(581);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(584);
					theTypeName();
					setState(585);
					match(Doublecolon);
					}
				}

				setState(589);
				match(Tilde);
				setState(590);
				theTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(591);
				nestedNameSpecifier(0);
				setState(592);
				match(Template);
				setState(593);
				simpleTemplateId();
				setState(594);
				match(Doublecolon);
				setState(595);
				match(Tilde);
				setState(596);
				theTypeName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(598);
				match(Tilde);
				setState(599);
				decltypeSpecifier();
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
	public static class UnaryExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CPP14Parser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPP14Parser.MinusMinus, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public TerminalNode Sizeof() { return getToken(CPP14Parser.Sizeof, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Alignof() { return getToken(CPP14Parser.Alignof, 0); }
		public NoExceptExpressionContext noExceptExpression() {
			return getRuleContext(NoExceptExpressionContext.class,0);
		}
		public NewExpression_Context newExpression_() {
			return getRuleContext(NewExpression_Context.class,0);
		}
		public DeleteExpressionContext deleteExpression() {
			return getRuleContext(DeleteExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryExpression);
		try {
			setState(629);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(602);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PlusPlus:
					{
					setState(603);
					match(PlusPlus);
					}
					break;
				case MinusMinus:
					{
					setState(604);
					match(MinusMinus);
					}
					break;
				case Plus:
				case Minus:
				case Star:
				case And:
				case Or:
				case Tilde:
				case Not:
					{
					setState(605);
					unaryOperator();
					}
					break;
				case Sizeof:
					{
					setState(606);
					match(Sizeof);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(609);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				match(Sizeof);
				setState(619);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
					{
					setState(611);
					match(LeftParen);
					setState(612);
					theTypeId();
					setState(613);
					match(RightParen);
					}
					break;
				case Ellipsis:
					{
					setState(615);
					match(Ellipsis);
					setState(616);
					match(LeftParen);
					setState(617);
					match(Identifier);
					setState(618);
					match(RightParen);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(621);
				match(Alignof);
				setState(622);
				match(LeftParen);
				setState(623);
				theTypeId();
				setState(624);
				match(RightParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(626);
				noExceptExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(627);
				newExpression_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(628);
				deleteExpression();
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
	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode Or() { return getToken(CPP14Parser.Or, 0); }
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode Plus() { return getToken(CPP14Parser.Plus, 0); }
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public TerminalNode Minus() { return getToken(CPP14Parser.Minus, 0); }
		public TerminalNode Not() { return getToken(CPP14Parser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 967L) != 0)) ) {
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
	public static class NewExpression_Context extends ParserRuleContext {
		public TerminalNode New() { return getToken(CPP14Parser.New, 0); }
		public NewTypeIdContext newTypeId() {
			return getRuleContext(NewTypeIdContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public NewPlacementContext newPlacement() {
			return getRuleContext(NewPlacementContext.class,0);
		}
		public NewInitializer_Context newInitializer_() {
			return getRuleContext(NewInitializer_Context.class,0);
		}
		public NewExpression_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression_; }
	}

	public final NewExpression_Context newExpression_() throws RecognitionException {
		NewExpression_Context _localctx = new NewExpression_Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_newExpression_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doublecolon) {
				{
				setState(633);
				match(Doublecolon);
				}
			}

			setState(636);
			match(New);
			setState(638);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(637);
				newPlacement();
				}
				break;
			}
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case Doublecolon:
			case Identifier:
				{
				setState(640);
				newTypeId();
				}
				break;
			case LeftParen:
				{
				setState(641);
				match(LeftParen);
				setState(642);
				theTypeId();
				setState(643);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(648);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen || _la==LeftBrace) {
				{
				setState(647);
				newInitializer_();
				}
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
	public static class NewPlacementContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NewPlacementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newPlacement; }
	}

	public final NewPlacementContext newPlacement() throws RecognitionException {
		NewPlacementContext _localctx = new NewPlacementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newPlacement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			match(LeftParen);
			setState(651);
			expressionList();
			setState(652);
			match(RightParen);
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
	public static class NewTypeIdContext extends ParserRuleContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public NewDeclarator_Context newDeclarator_() {
			return getRuleContext(NewDeclarator_Context.class,0);
		}
		public NewTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTypeId; }
	}

	public final NewTypeIdContext newTypeId() throws RecognitionException {
		NewTypeIdContext _localctx = new NewTypeIdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_newTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			typeSpecifierSeq();
			setState(656);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(655);
				newDeclarator_();
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
	public static class NewDeclarator_Context extends ParserRuleContext {
		public PointerOperatorContext pointerOperator() {
			return getRuleContext(PointerOperatorContext.class,0);
		}
		public NewDeclarator_Context newDeclarator_() {
			return getRuleContext(NewDeclarator_Context.class,0);
		}
		public NoPointerNewDeclaratorContext noPointerNewDeclarator() {
			return getRuleContext(NoPointerNewDeclaratorContext.class,0);
		}
		public NewDeclarator_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDeclarator_; }
	}

	public final NewDeclarator_Context newDeclarator_() throws RecognitionException {
		NewDeclarator_Context _localctx = new NewDeclarator_Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_newDeclarator_);
		try {
			setState(663);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(658);
				pointerOperator();
				setState(660);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(659);
					newDeclarator_();
					}
					break;
				}
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(662);
				noPointerNewDeclarator(0);
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
	public static class NoPointerNewDeclaratorContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public NoPointerNewDeclaratorContext noPointerNewDeclarator() {
			return getRuleContext(NoPointerNewDeclaratorContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public NoPointerNewDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerNewDeclarator; }
	}

	public final NoPointerNewDeclaratorContext noPointerNewDeclarator() throws RecognitionException {
		return noPointerNewDeclarator(0);
	}

	private NoPointerNewDeclaratorContext noPointerNewDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoPointerNewDeclaratorContext _localctx = new NoPointerNewDeclaratorContext(_ctx, _parentState);
		NoPointerNewDeclaratorContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_noPointerNewDeclarator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(666);
			match(LeftBracket);
			setState(667);
			expression();
			setState(668);
			match(RightBracket);
			setState(670);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(669);
				attributeSpecifierSeq();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(681);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerNewDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerNewDeclarator);
					setState(672);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(673);
					match(LeftBracket);
					setState(674);
					constantExpression();
					setState(675);
					match(RightBracket);
					setState(677);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(676);
						attributeSpecifierSeq();
						}
						break;
					}
					}
					} 
				}
				setState(683);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
	public static class NewInitializer_Context extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public NewInitializer_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newInitializer_; }
	}

	public final NewInitializer_Context newInitializer_() throws RecognitionException {
		NewInitializer_Context _localctx = new NewInitializer_Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_newInitializer_);
		int _la;
		try {
			setState(690);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(684);
				match(LeftParen);
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257204718907L) != 0)) {
					{
					setState(685);
					expressionList();
					}
				}

				setState(688);
				match(RightParen);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(689);
				bracedInitList();
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
	public static class DeleteExpressionContext extends ParserRuleContext {
		public TerminalNode Delete() { return getToken(CPP14Parser.Delete, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public DeleteExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteExpression; }
	}

	public final DeleteExpressionContext deleteExpression() throws RecognitionException {
		DeleteExpressionContext _localctx = new DeleteExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_deleteExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doublecolon) {
				{
				setState(692);
				match(Doublecolon);
				}
			}

			setState(695);
			match(Delete);
			setState(698);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(696);
				match(LeftBracket);
				setState(697);
				match(RightBracket);
				}
				break;
			}
			setState(700);
			castExpression();
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
	public static class NoExceptExpressionContext extends ParserRuleContext {
		public TerminalNode Noexcept() { return getToken(CPP14Parser.Noexcept, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoExceptExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noExceptExpression; }
	}

	public final NoExceptExpressionContext noExceptExpression() throws RecognitionException {
		NoExceptExpressionContext _localctx = new NoExceptExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_noExceptExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			match(Noexcept);
			setState(703);
			match(LeftParen);
			setState(704);
			expression();
			setState(705);
			match(RightParen);
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
	public static class CastExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_castExpression);
		try {
			setState(713);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(707);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(708);
				match(LeftParen);
				setState(709);
				theTypeId();
				setState(710);
				match(RightParen);
				setState(711);
				castExpression();
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
	public static class PointerMemberExpressionContext extends ParserRuleContext {
		public List<CastExpressionContext> castExpression() {
			return getRuleContexts(CastExpressionContext.class);
		}
		public CastExpressionContext castExpression(int i) {
			return getRuleContext(CastExpressionContext.class,i);
		}
		public List<TerminalNode> DotStar() { return getTokens(CPP14Parser.DotStar); }
		public TerminalNode DotStar(int i) {
			return getToken(CPP14Parser.DotStar, i);
		}
		public List<TerminalNode> ArrowStar() { return getTokens(CPP14Parser.ArrowStar); }
		public TerminalNode ArrowStar(int i) {
			return getToken(CPP14Parser.ArrowStar, i);
		}
		public PointerMemberExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerMemberExpression; }
	}

	public final PointerMemberExpressionContext pointerMemberExpression() throws RecognitionException {
		PointerMemberExpressionContext _localctx = new PointerMemberExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pointerMemberExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			castExpression();
			setState(720);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ArrowStar || _la==DotStar) {
				{
				{
				setState(716);
				_la = _input.LA(1);
				if ( !(_la==ArrowStar || _la==DotStar) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(717);
				castExpression();
				}
				}
				setState(722);
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
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<PointerMemberExpressionContext> pointerMemberExpression() {
			return getRuleContexts(PointerMemberExpressionContext.class);
		}
		public PointerMemberExpressionContext pointerMemberExpression(int i) {
			return getRuleContext(PointerMemberExpressionContext.class,i);
		}
		public List<TerminalNode> Star() { return getTokens(CPP14Parser.Star); }
		public TerminalNode Star(int i) {
			return getToken(CPP14Parser.Star, i);
		}
		public List<TerminalNode> Div() { return getTokens(CPP14Parser.Div); }
		public TerminalNode Div(int i) {
			return getToken(CPP14Parser.Div, i);
		}
		public List<TerminalNode> Mod() { return getTokens(CPP14Parser.Mod); }
		public TerminalNode Mod(int i) {
			return getToken(CPP14Parser.Mod, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			pointerMemberExpression();
			setState(728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & 7L) != 0)) {
				{
				{
				setState(724);
				_la = _input.LA(1);
				if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & 7L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(725);
				pointerMemberExpression();
				}
				}
				setState(730);
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
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> Plus() { return getTokens(CPP14Parser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(CPP14Parser.Plus, i);
		}
		public List<TerminalNode> Minus() { return getTokens(CPP14Parser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(CPP14Parser.Minus, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			multiplicativeExpression();
			setState(736);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Plus || _la==Minus) {
				{
				{
				setState(732);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(733);
				multiplicativeExpression();
				}
				}
				setState(738);
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
	public static class ShiftExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<ShiftOperatorContext> shiftOperator() {
			return getRuleContexts(ShiftOperatorContext.class);
		}
		public ShiftOperatorContext shiftOperator(int i) {
			return getRuleContext(ShiftOperatorContext.class,i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_shiftExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			additiveExpression();
			setState(745);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(740);
					shiftOperator();
					setState(741);
					additiveExpression();
					}
					} 
				}
				setState(747);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
	public static class ShiftOperatorContext extends ParserRuleContext {
		public List<TerminalNode> Greater() { return getTokens(CPP14Parser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(CPP14Parser.Greater, i);
		}
		public List<TerminalNode> Less() { return getTokens(CPP14Parser.Less); }
		public TerminalNode Less(int i) {
			return getToken(CPP14Parser.Less, i);
		}
		public ShiftOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftOperator; }
	}

	public final ShiftOperatorContext shiftOperator() throws RecognitionException {
		ShiftOperatorContext _localctx = new ShiftOperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_shiftOperator);
		try {
			setState(752);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Greater:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				match(Greater);
				setState(749);
				match(Greater);
				}
				break;
			case Less:
				enterOuterAlt(_localctx, 2);
				{
				setState(750);
				match(Less);
				setState(751);
				match(Less);
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
	public static class RelationalExpressionContext extends ParserRuleContext {
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public List<TerminalNode> Less() { return getTokens(CPP14Parser.Less); }
		public TerminalNode Less(int i) {
			return getToken(CPP14Parser.Less, i);
		}
		public List<TerminalNode> Greater() { return getTokens(CPP14Parser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(CPP14Parser.Greater, i);
		}
		public List<TerminalNode> LessEqual() { return getTokens(CPP14Parser.LessEqual); }
		public TerminalNode LessEqual(int i) {
			return getToken(CPP14Parser.LessEqual, i);
		}
		public List<TerminalNode> GreaterEqual() { return getTokens(CPP14Parser.GreaterEqual); }
		public TerminalNode GreaterEqual(int i) {
			return getToken(CPP14Parser.GreaterEqual, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_relationalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(754);
			shiftExpression();
			setState(759);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(755);
					_la = _input.LA(1);
					if ( !(((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & 49155L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(756);
					shiftExpression();
					}
					} 
				}
				setState(761);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
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
	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> Equal() { return getTokens(CPP14Parser.Equal); }
		public TerminalNode Equal(int i) {
			return getToken(CPP14Parser.Equal, i);
		}
		public List<TerminalNode> NotEqual() { return getTokens(CPP14Parser.NotEqual); }
		public TerminalNode NotEqual(int i) {
			return getToken(CPP14Parser.NotEqual, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			relationalExpression();
			setState(767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Equal || _la==NotEqual) {
				{
				{
				setState(763);
				_la = _input.LA(1);
				if ( !(_la==Equal || _la==NotEqual) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(764);
				relationalExpression();
				}
				}
				setState(769);
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
	public static class AndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> And() { return getTokens(CPP14Parser.And); }
		public TerminalNode And(int i) {
			return getToken(CPP14Parser.And, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			equalityExpression();
			setState(775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==And) {
				{
				{
				setState(771);
				match(And);
				setState(772);
				equalityExpression();
				}
				}
				setState(777);
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
	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> Caret() { return getTokens(CPP14Parser.Caret); }
		public TerminalNode Caret(int i) {
			return getToken(CPP14Parser.Caret, i);
		}
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_exclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			andExpression();
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Caret) {
				{
				{
				setState(779);
				match(Caret);
				setState(780);
				andExpression();
				}
				}
				setState(785);
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
	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public List<ExclusiveOrExpressionContext> exclusiveOrExpression() {
			return getRuleContexts(ExclusiveOrExpressionContext.class);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression(int i) {
			return getRuleContext(ExclusiveOrExpressionContext.class,i);
		}
		public List<TerminalNode> Or() { return getTokens(CPP14Parser.Or); }
		public TerminalNode Or(int i) {
			return getToken(CPP14Parser.Or, i);
		}
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_inclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			exclusiveOrExpression();
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(787);
				match(Or);
				setState(788);
				exclusiveOrExpression();
				}
				}
				setState(793);
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
	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<InclusiveOrExpressionContext> inclusiveOrExpression() {
			return getRuleContexts(InclusiveOrExpressionContext.class);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression(int i) {
			return getRuleContext(InclusiveOrExpressionContext.class,i);
		}
		public List<TerminalNode> AndAnd() { return getTokens(CPP14Parser.AndAnd); }
		public TerminalNode AndAnd(int i) {
			return getToken(CPP14Parser.AndAnd, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			inclusiveOrExpression();
			setState(799);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AndAnd) {
				{
				{
				setState(795);
				match(AndAnd);
				setState(796);
				inclusiveOrExpression();
				}
				}
				setState(801);
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
	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> OrOr() { return getTokens(CPP14Parser.OrOr); }
		public TerminalNode OrOr(int i) {
			return getToken(CPP14Parser.OrOr, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			logicalAndExpression();
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OrOr) {
				{
				{
				setState(803);
				match(OrOr);
				setState(804);
				logicalAndExpression();
				}
				}
				setState(809);
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
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode Question() { return getToken(CPP14Parser.Question, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_conditionalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
			logicalOrExpression();
			setState(816);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Question) {
				{
				setState(811);
				match(Question);
				setState(812);
				expression();
				setState(813);
				match(Colon);
				setState(814);
				assignmentExpression();
				}
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
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public ThrowExpressionContext throwExpression() {
			return getRuleContext(ThrowExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_assignmentExpression);
		try {
			setState(824);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(818);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(819);
				logicalOrExpression();
				setState(820);
				assignmentOperator();
				setState(821);
				initializerClause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(823);
				throwExpression();
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
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(CPP14Parser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(CPP14Parser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPP14Parser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(CPP14Parser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPP14Parser.MinusAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPP14Parser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPP14Parser.LeftShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPP14Parser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPP14Parser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPP14Parser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			_la = _input.LA(1);
			if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & 8185L) != 0)) ) {
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			assignmentExpression();
			setState(833);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(829);
				match(Comma);
				setState(830);
				assignmentExpression();
				}
				}
				setState(835);
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
	public static class ConstantExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			conditionalExpression();
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
	public static class StatementContext extends ParserRuleContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public TryBlockContext tryBlock() {
			return getRuleContext(TryBlockContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_statement);
		try {
			setState(851);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(838);
				labeledStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(839);
				declarationStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(841);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(840);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(849);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IntegerLiteral:
				case CharacterLiteral:
				case FloatingLiteral:
				case StringLiteral:
				case BooleanLiteral:
				case PointerLiteral:
				case UserDefinedLiteral:
				case Alignof:
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Const_cast:
				case Decltype:
				case Delete:
				case Double:
				case Dynamic_cast:
				case Float:
				case Int:
				case Long:
				case New:
				case Noexcept:
				case Operator:
				case Reinterpret_cast:
				case Short:
				case Signed:
				case Sizeof:
				case Static_cast:
				case This:
				case Throw:
				case Typeid_:
				case Typename_:
				case Unsigned:
				case Void:
				case Wchar:
				case LeftParen:
				case LeftBracket:
				case Plus:
				case Minus:
				case Star:
				case And:
				case Or:
				case Tilde:
				case Not:
				case PlusPlus:
				case MinusMinus:
				case Doublecolon:
				case Semi:
				case Identifier:
					{
					setState(843);
					expressionStatement();
					}
					break;
				case LeftBrace:
					{
					setState(844);
					compoundStatement();
					}
					break;
				case If:
				case Switch:
					{
					setState(845);
					selectionStatement();
					}
					break;
				case Do:
				case For:
				case While:
					{
					setState(846);
					iterationStatement();
					}
					break;
				case Break:
				case Continue:
				case Goto:
				case Return:
					{
					setState(847);
					jumpStatement();
					}
					break;
				case Try:
					{
					setState(848);
					tryBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Case() { return getToken(CPP14Parser.Case, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(CPP14Parser.Default, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_labeledStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(853);
				attributeSpecifierSeq();
				}
			}

			setState(860);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(856);
				match(Identifier);
				}
				break;
			case Case:
				{
				setState(857);
				match(Case);
				setState(858);
				constantExpression();
				}
				break;
			case Default:
				{
				setState(859);
				match(Default);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(862);
			match(Colon);
			setState(863);
			statement();
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
	public static class ExpressionStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767483L) != 0)) {
				{
				setState(865);
				expression();
				}
			}

			setState(868);
			match(Semi);
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
	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public StatementSeqContext statementSeq() {
			return getRuleContext(StatementSeqContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			match(LeftBrace);
			setState(872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -68680119803248898L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4494592363198414985L) != 0) || _la==Ellipsis || _la==Identifier) {
				{
				setState(871);
				statementSeq();
				}
			}

			setState(874);
			match(RightBrace);
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
	public static class StatementSeqContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementSeq; }
	}

	public final StatementSeqContext statementSeq() throws RecognitionException {
		StatementSeqContext _localctx = new StatementSeqContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_statementSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(876);
				statement();
				}
				}
				setState(879); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -68680119803248898L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -4494592363198414985L) != 0) || _la==Ellipsis || _la==Identifier );
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
	public static class SelectionStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CPP14Parser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(CPP14Parser.Else, 0); }
		public TerminalNode Switch() { return getToken(CPP14Parser.Switch, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_selectionStatement);
		try {
			setState(896);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(881);
				match(If);
				setState(882);
				match(LeftParen);
				setState(883);
				condition();
				setState(884);
				match(RightParen);
				setState(885);
				statement();
				setState(888);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(886);
					match(Else);
					setState(887);
					statement();
					}
					break;
				}
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				match(Switch);
				setState(891);
				match(LeftParen);
				setState(892);
				condition();
				setState(893);
				match(RightParen);
				setState(894);
				statement();
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
	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_condition);
		int _la;
		try {
			setState(909);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(898);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(900);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(899);
					attributeSpecifierSeq();
					}
				}

				setState(902);
				declSpecifierSeq();
				setState(903);
				declarator();
				setState(907);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Assign:
					{
					setState(904);
					match(Assign);
					setState(905);
					initializerClause();
					}
					break;
				case LeftBrace:
					{
					setState(906);
					bracedInitList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
	public static class IterationStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(CPP14Parser.While, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(CPP14Parser.Do, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode For() { return getToken(CPP14Parser.For, 0); }
		public ForInitStatementContext forInitStatement() {
			return getRuleContext(ForInitStatementContext.class,0);
		}
		public ForRangeDeclarationContext forRangeDeclaration() {
			return getRuleContext(ForRangeDeclarationContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public ForRangeInitializerContext forRangeInitializer() {
			return getRuleContext(ForRangeInitializerContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_iterationStatement);
		int _la;
		try {
			setState(944);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(911);
				match(While);
				setState(912);
				match(LeftParen);
				setState(913);
				condition();
				setState(914);
				match(RightParen);
				setState(915);
				statement();
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(917);
				match(Do);
				setState(918);
				statement();
				setState(919);
				match(While);
				setState(920);
				match(LeftParen);
				setState(921);
				expression();
				setState(922);
				match(RightParen);
				setState(923);
				match(Semi);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(925);
				match(For);
				setState(926);
				match(LeftParen);
				setState(939);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(927);
					forInitStatement();
					setState(929);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8866313656233506558L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4719772474384301683L) != 0) || _la==Identifier) {
						{
						setState(928);
						condition();
						}
					}

					setState(931);
					match(Semi);
					setState(933);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767483L) != 0)) {
						{
						setState(932);
						expression();
						}
					}

					}
					break;
				case 2:
					{
					setState(935);
					forRangeDeclaration();
					setState(936);
					match(Colon);
					setState(937);
					forRangeInitializer();
					}
					break;
				}
				setState(941);
				match(RightParen);
				setState(942);
				statement();
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
	public static class ForInitStatementContext extends ParserRuleContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public ForInitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitStatement; }
	}

	public final ForInitStatementContext forInitStatement() throws RecognitionException {
		ForInitStatementContext _localctx = new ForInitStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_forInitStatement);
		try {
			setState(948);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(946);
				expressionStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(947);
				simpleDeclaration();
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
	public static class ForRangeDeclarationContext extends ParserRuleContext {
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ForRangeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRangeDeclaration; }
	}

	public final ForRangeDeclarationContext forRangeDeclaration() throws RecognitionException {
		ForRangeDeclarationContext _localctx = new ForRangeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_forRangeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(951);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(950);
				attributeSpecifierSeq();
				}
			}

			setState(953);
			declSpecifierSeq();
			setState(954);
			declarator();
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
	public static class ForRangeInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public ForRangeInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRangeInitializer; }
	}

	public final ForRangeInitializerContext forRangeInitializer() throws RecognitionException {
		ForRangeInitializerContext _localctx = new ForRangeInitializerContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_forRangeInitializer);
		try {
			setState(958);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case Alignof:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Const_cast:
			case Decltype:
			case Delete:
			case Double:
			case Dynamic_cast:
			case Float:
			case Int:
			case Long:
			case New:
			case Noexcept:
			case Operator:
			case Reinterpret_cast:
			case Short:
			case Signed:
			case Sizeof:
			case Static_cast:
			case This:
			case Throw:
			case Typeid_:
			case Typename_:
			case Unsigned:
			case Void:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Plus:
			case Minus:
			case Star:
			case And:
			case Or:
			case Tilde:
			case Not:
			case PlusPlus:
			case MinusMinus:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(956);
				expression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(957);
				bracedInitList();
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
	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode Break() { return getToken(CPP14Parser.Break, 0); }
		public TerminalNode Continue() { return getToken(CPP14Parser.Continue, 0); }
		public TerminalNode Return() { return getToken(CPP14Parser.Return, 0); }
		public TerminalNode Goto() { return getToken(CPP14Parser.Goto, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_jumpStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
				{
				setState(960);
				match(Break);
				}
				break;
			case Continue:
				{
				setState(961);
				match(Continue);
				}
				break;
			case Return:
				{
				setState(962);
				match(Return);
				setState(965);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IntegerLiteral:
				case CharacterLiteral:
				case FloatingLiteral:
				case StringLiteral:
				case BooleanLiteral:
				case PointerLiteral:
				case UserDefinedLiteral:
				case Alignof:
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Const_cast:
				case Decltype:
				case Delete:
				case Double:
				case Dynamic_cast:
				case Float:
				case Int:
				case Long:
				case New:
				case Noexcept:
				case Operator:
				case Reinterpret_cast:
				case Short:
				case Signed:
				case Sizeof:
				case Static_cast:
				case This:
				case Throw:
				case Typeid_:
				case Typename_:
				case Unsigned:
				case Void:
				case Wchar:
				case LeftParen:
				case LeftBracket:
				case Plus:
				case Minus:
				case Star:
				case And:
				case Or:
				case Tilde:
				case Not:
				case PlusPlus:
				case MinusMinus:
				case Doublecolon:
				case Identifier:
					{
					setState(963);
					expression();
					}
					break;
				case LeftBrace:
					{
					setState(964);
					bracedInitList();
					}
					break;
				case Semi:
					break;
				default:
					break;
				}
				}
				break;
			case Goto:
				{
				setState(967);
				match(Goto);
				setState(968);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(971);
			match(Semi);
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
	public static class DeclarationStatementContext extends ParserRuleContext {
		public BlockDeclarationContext blockDeclaration() {
			return getRuleContext(BlockDeclarationContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			blockDeclaration();
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
	public static class DeclarationseqContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationseq; }
	}

	public final DeclarationseqContext declarationseq() throws RecognitionException {
		DeclarationseqContext _localctx = new DeclarationseqContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_declarationseq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(976); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(975);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(978); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
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
	public static class DeclarationContext extends ParserRuleContext {
		public BlockDeclarationContext blockDeclaration() {
			return getRuleContext(BlockDeclarationContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public TemplateDeclarationContext templateDeclaration() {
			return getRuleContext(TemplateDeclarationContext.class,0);
		}
		public ExplicitInstantiationContext explicitInstantiation() {
			return getRuleContext(ExplicitInstantiationContext.class,0);
		}
		public ExplicitSpecializationContext explicitSpecialization() {
			return getRuleContext(ExplicitSpecializationContext.class,0);
		}
		public LinkageSpecificationContext linkageSpecification() {
			return getRuleContext(LinkageSpecificationContext.class,0);
		}
		public NamespaceDefinitionContext namespaceDefinition() {
			return getRuleContext(NamespaceDefinitionContext.class,0);
		}
		public EmptyDeclaration_Context emptyDeclaration_() {
			return getRuleContext(EmptyDeclaration_Context.class,0);
		}
		public AttributeDeclarationContext attributeDeclaration() {
			return getRuleContext(AttributeDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_declaration);
		try {
			setState(989);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(980);
				blockDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(981);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(982);
				templateDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(983);
				explicitInstantiation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(984);
				explicitSpecialization();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(985);
				linkageSpecification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(986);
				namespaceDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(987);
				emptyDeclaration_();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(988);
				attributeDeclaration();
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
	public static class BlockDeclarationContext extends ParserRuleContext {
		public SimpleDeclarationContext simpleDeclaration() {
			return getRuleContext(SimpleDeclarationContext.class,0);
		}
		public AsmDefinitionContext asmDefinition() {
			return getRuleContext(AsmDefinitionContext.class,0);
		}
		public NamespaceAliasDefinitionContext namespaceAliasDefinition() {
			return getRuleContext(NamespaceAliasDefinitionContext.class,0);
		}
		public UsingDeclarationContext usingDeclaration() {
			return getRuleContext(UsingDeclarationContext.class,0);
		}
		public UsingDirectiveContext usingDirective() {
			return getRuleContext(UsingDirectiveContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public AliasDeclarationContext aliasDeclaration() {
			return getRuleContext(AliasDeclarationContext.class,0);
		}
		public OpaqueEnumDeclarationContext opaqueEnumDeclaration() {
			return getRuleContext(OpaqueEnumDeclarationContext.class,0);
		}
		public BlockDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockDeclaration; }
	}

	public final BlockDeclarationContext blockDeclaration() throws RecognitionException {
		BlockDeclarationContext _localctx = new BlockDeclarationContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_blockDeclaration);
		try {
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(991);
				simpleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(992);
				asmDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(993);
				namespaceAliasDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(994);
				usingDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(995);
				usingDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(996);
				staticAssertDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(997);
				aliasDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(998);
				opaqueEnumDeclaration();
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
	public static class AliasDeclarationContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(CPP14Parser.Using, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public AliasDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasDeclaration; }
	}

	public final AliasDeclarationContext aliasDeclaration() throws RecognitionException {
		AliasDeclarationContext _localctx = new AliasDeclarationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_aliasDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1001);
			match(Using);
			setState(1002);
			match(Identifier);
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1003);
				attributeSpecifierSeq();
				}
			}

			setState(1006);
			match(Assign);
			setState(1007);
			theTypeId();
			setState(1008);
			match(Semi);
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
	public static class SimpleDeclarationContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public SimpleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDeclaration; }
	}

	public final SimpleDeclarationContext simpleDeclaration() throws RecognitionException {
		SimpleDeclarationContext _localctx = new SimpleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_simpleDeclaration);
		int _la;
		try {
			setState(1024);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Decltype:
			case Double:
			case Enum:
			case Explicit:
			case Extern:
			case Float:
			case Friend:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Operator:
			case Register:
			case Short:
			case Signed:
			case Static:
			case Struct:
			case Thread_local:
			case Typedef:
			case Typename_:
			case Union:
			case Unsigned:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case LeftParen:
			case Star:
			case And:
			case Tilde:
			case AndAnd:
			case Doublecolon:
			case Semi:
			case Ellipsis:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1011);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(1010);
					declSpecifierSeq();
					}
					break;
				}
				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Operator || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 215512868999425L) != 0)) {
					{
					setState(1013);
					initDeclaratorList();
					}
				}

				setState(1016);
				match(Semi);
				}
				break;
			case Alignas:
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1017);
				attributeSpecifierSeq();
				setState(1019);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(1018);
					declSpecifierSeq();
					}
					break;
				}
				setState(1021);
				initDeclaratorList();
				setState(1022);
				match(Semi);
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
	public static class StaticAssertDeclarationContext extends ParserRuleContext {
		public TerminalNode Static_assert() { return getToken(CPP14Parser.Static_assert, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TerminalNode StringLiteral() { return getToken(CPP14Parser.StringLiteral, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public StaticAssertDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticAssertDeclaration; }
	}

	public final StaticAssertDeclarationContext staticAssertDeclaration() throws RecognitionException {
		StaticAssertDeclarationContext _localctx = new StaticAssertDeclarationContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_staticAssertDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1026);
			match(Static_assert);
			setState(1027);
			match(LeftParen);
			setState(1028);
			constantExpression();
			setState(1029);
			match(Comma);
			setState(1030);
			match(StringLiteral);
			setState(1031);
			match(RightParen);
			setState(1032);
			match(Semi);
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
	public static class EmptyDeclaration_Context extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public EmptyDeclaration_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyDeclaration_; }
	}

	public final EmptyDeclaration_Context emptyDeclaration_() throws RecognitionException {
		EmptyDeclaration_Context _localctx = new EmptyDeclaration_Context(_ctx, getState());
		enterRule(_localctx, 132, RULE_emptyDeclaration_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1034);
			match(Semi);
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
	public static class AttributeDeclarationContext extends ParserRuleContext {
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDeclaration; }
	}

	public final AttributeDeclarationContext attributeDeclaration() throws RecognitionException {
		AttributeDeclarationContext _localctx = new AttributeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_attributeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			attributeSpecifierSeq();
			setState(1037);
			match(Semi);
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
	public static class DeclSpecifierContext extends ParserRuleContext {
		public StorageClassSpecifierContext storageClassSpecifier() {
			return getRuleContext(StorageClassSpecifierContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public FunctionSpecifierContext functionSpecifier() {
			return getRuleContext(FunctionSpecifierContext.class,0);
		}
		public TerminalNode Friend() { return getToken(CPP14Parser.Friend, 0); }
		public TerminalNode Typedef() { return getToken(CPP14Parser.Typedef, 0); }
		public TerminalNode Constexpr() { return getToken(CPP14Parser.Constexpr, 0); }
		public DeclSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSpecifier; }
	}

	public final DeclSpecifierContext declSpecifier() throws RecognitionException {
		DeclSpecifierContext _localctx = new DeclSpecifierContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_declSpecifier);
		try {
			setState(1045);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Extern:
			case Mutable:
			case Register:
			case Static:
			case Thread_local:
				enterOuterAlt(_localctx, 1);
				{
				setState(1039);
				storageClassSpecifier();
				}
				break;
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1040);
				typeSpecifier();
				}
				break;
			case Explicit:
			case Inline:
			case Virtual:
				enterOuterAlt(_localctx, 3);
				{
				setState(1041);
				functionSpecifier();
				}
				break;
			case Friend:
				enterOuterAlt(_localctx, 4);
				{
				setState(1042);
				match(Friend);
				}
				break;
			case Typedef:
				enterOuterAlt(_localctx, 5);
				{
				setState(1043);
				match(Typedef);
				}
				break;
			case Constexpr:
				enterOuterAlt(_localctx, 6);
				{
				setState(1044);
				match(Constexpr);
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
	public static class DeclSpecifierSeqContext extends ParserRuleContext {
		public List<DeclSpecifierContext> declSpecifier() {
			return getRuleContexts(DeclSpecifierContext.class);
		}
		public DeclSpecifierContext declSpecifier(int i) {
			return getRuleContext(DeclSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSpecifierSeq; }
	}

	public final DeclSpecifierSeqContext declSpecifierSeq() throws RecognitionException {
		DeclSpecifierSeqContext _localctx = new DeclSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_declSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1048); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(1047);
					declSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1050); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1053);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(1052);
				attributeSpecifierSeq();
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
	public static class StorageClassSpecifierContext extends ParserRuleContext {
		public TerminalNode Register() { return getToken(CPP14Parser.Register, 0); }
		public TerminalNode Static() { return getToken(CPP14Parser.Static, 0); }
		public TerminalNode Thread_local() { return getToken(CPP14Parser.Thread_local, 0); }
		public TerminalNode Extern() { return getToken(CPP14Parser.Extern, 0); }
		public TerminalNode Mutable() { return getToken(CPP14Parser.Mutable, 0); }
		public StorageClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageClassSpecifier; }
	}

	public final StorageClassSpecifierContext storageClassSpecifier() throws RecognitionException {
		StorageClassSpecifierContext _localctx = new StorageClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1055);
			_la = _input.LA(1);
			if ( !(((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 17316186113L) != 0)) ) {
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
	public static class FunctionSpecifierContext extends ParserRuleContext {
		public TerminalNode Inline() { return getToken(CPP14Parser.Inline, 0); }
		public TerminalNode Virtual() { return getToken(CPP14Parser.Virtual, 0); }
		public TerminalNode Explicit() { return getToken(CPP14Parser.Explicit, 0); }
		public FunctionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSpecifier; }
	}

	public final FunctionSpecifierContext functionSpecifier() throws RecognitionException {
		FunctionSpecifierContext _localctx = new FunctionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_functionSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			_la = _input.LA(1);
			if ( !(((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & 70368744178689L) != 0)) ) {
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
	public static class TypedefNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TypedefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefName; }
	}

	public final TypedefNameContext typedefName() throws RecognitionException {
		TypedefNameContext _localctx = new TypedefNameContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			match(Identifier);
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
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TrailingTypeSpecifierContext trailingTypeSpecifier() {
			return getRuleContext(TrailingTypeSpecifierContext.class,0);
		}
		public ClassSpecifierContext classSpecifier() {
			return getRuleContext(ClassSpecifierContext.class,0);
		}
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_typeSpecifier);
		try {
			setState(1064);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1061);
				trailingTypeSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1062);
				classSpecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1063);
				enumSpecifier();
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
	public static class TrailingTypeSpecifierContext extends ParserRuleContext {
		public SimpleTypeSpecifierContext simpleTypeSpecifier() {
			return getRuleContext(SimpleTypeSpecifierContext.class,0);
		}
		public ElaboratedTypeSpecifierContext elaboratedTypeSpecifier() {
			return getRuleContext(ElaboratedTypeSpecifierContext.class,0);
		}
		public TypeNameSpecifierContext typeNameSpecifier() {
			return getRuleContext(TypeNameSpecifierContext.class,0);
		}
		public CvQualifierContext cvQualifier() {
			return getRuleContext(CvQualifierContext.class,0);
		}
		public TrailingTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingTypeSpecifier; }
	}

	public final TrailingTypeSpecifierContext trailingTypeSpecifier() throws RecognitionException {
		TrailingTypeSpecifierContext _localctx = new TrailingTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_trailingTypeSpecifier);
		try {
			setState(1070);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Decltype:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Wchar:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1066);
				simpleTypeSpecifier();
				}
				break;
			case Class:
			case Enum:
			case Struct:
				enterOuterAlt(_localctx, 2);
				{
				setState(1067);
				elaboratedTypeSpecifier();
				}
				break;
			case Typename_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1068);
				typeNameSpecifier();
				}
				break;
			case Const:
			case Volatile:
				enterOuterAlt(_localctx, 4);
				{
				setState(1069);
				cvQualifier();
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
	public static class TypeSpecifierSeqContext extends ParserRuleContext {
		public List<TypeSpecifierContext> typeSpecifier() {
			return getRuleContexts(TypeSpecifierContext.class);
		}
		public TypeSpecifierContext typeSpecifier(int i) {
			return getRuleContext(TypeSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TypeSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifierSeq; }
	}

	public final TypeSpecifierSeqContext typeSpecifierSeq() throws RecognitionException {
		TypeSpecifierSeqContext _localctx = new TypeSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_typeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1073); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1072);
					typeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1075); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1078);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				setState(1077);
				attributeSpecifierSeq();
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
	public static class TrailingTypeSpecifierSeqContext extends ParserRuleContext {
		public List<TrailingTypeSpecifierContext> trailingTypeSpecifier() {
			return getRuleContexts(TrailingTypeSpecifierContext.class);
		}
		public TrailingTypeSpecifierContext trailingTypeSpecifier(int i) {
			return getRuleContext(TrailingTypeSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TrailingTypeSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingTypeSpecifierSeq; }
	}

	public final TrailingTypeSpecifierSeqContext trailingTypeSpecifierSeq() throws RecognitionException {
		TrailingTypeSpecifierSeqContext _localctx = new TrailingTypeSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_trailingTypeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1081); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1080);
					trailingTypeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1083); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1086);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(1085);
				attributeSpecifierSeq();
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
	public static class SimpleTypeLengthModifierContext extends ParserRuleContext {
		public TerminalNode Short() { return getToken(CPP14Parser.Short, 0); }
		public TerminalNode Long() { return getToken(CPP14Parser.Long, 0); }
		public SimpleTypeLengthModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeLengthModifier; }
	}

	public final SimpleTypeLengthModifierContext simpleTypeLengthModifier() throws RecognitionException {
		SimpleTypeLengthModifierContext _localctx = new SimpleTypeLengthModifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_simpleTypeLengthModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			_la = _input.LA(1);
			if ( !(_la==Long || _la==Short) ) {
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
	public static class SimpleTypeSignednessModifierContext extends ParserRuleContext {
		public TerminalNode Unsigned() { return getToken(CPP14Parser.Unsigned, 0); }
		public TerminalNode Signed() { return getToken(CPP14Parser.Signed, 0); }
		public SimpleTypeSignednessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeSignednessModifier; }
	}

	public final SimpleTypeSignednessModifierContext simpleTypeSignednessModifier() throws RecognitionException {
		SimpleTypeSignednessModifierContext _localctx = new SimpleTypeSignednessModifierContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_simpleTypeSignednessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090);
			_la = _input.LA(1);
			if ( !(_la==Signed || _la==Unsigned) ) {
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
	public static class SimpleTypeSpecifierContext extends ParserRuleContext {
		public TheTypeNameContext theTypeName() {
			return getRuleContext(TheTypeNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Char() { return getToken(CPP14Parser.Char, 0); }
		public TerminalNode Char16() { return getToken(CPP14Parser.Char16, 0); }
		public TerminalNode Char32() { return getToken(CPP14Parser.Char32, 0); }
		public TerminalNode Wchar() { return getToken(CPP14Parser.Wchar, 0); }
		public TerminalNode Bool() { return getToken(CPP14Parser.Bool, 0); }
		public TerminalNode Short() { return getToken(CPP14Parser.Short, 0); }
		public TerminalNode Int() { return getToken(CPP14Parser.Int, 0); }
		public TerminalNode Long() { return getToken(CPP14Parser.Long, 0); }
		public TerminalNode Float() { return getToken(CPP14Parser.Float, 0); }
		public TerminalNode Signed() { return getToken(CPP14Parser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(CPP14Parser.Unsigned, 0); }
		public TerminalNode Double() { return getToken(CPP14Parser.Double, 0); }
		public TerminalNode Void() { return getToken(CPP14Parser.Void, 0); }
		public TerminalNode Auto() { return getToken(CPP14Parser.Auto, 0); }
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public SimpleTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeSpecifier; }
	}

	public final SimpleTypeSpecifierContext simpleTypeSpecifier() throws RecognitionException {
		SimpleTypeSpecifierContext _localctx = new SimpleTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_simpleTypeSpecifier);
		try {
			setState(1116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(1092);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1095);
				theTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1096);
				nestedNameSpecifier(0);
				setState(1097);
				match(Template);
				setState(1098);
				simpleTemplateId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1100);
				match(Char);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1101);
				match(Char16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1102);
				match(Char32);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1103);
				match(Wchar);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1104);
				match(Bool);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1105);
				match(Short);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1106);
				match(Int);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1107);
				match(Long);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1108);
				match(Float);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1109);
				match(Signed);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1110);
				match(Unsigned);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1111);
				match(Float);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1112);
				match(Double);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1113);
				match(Void);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1114);
				match(Auto);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1115);
				decltypeSpecifier();
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
	public static class TheTypeNameContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TheTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theTypeName; }
	}

	public final TheTypeNameContext theTypeName() throws RecognitionException {
		TheTypeNameContext _localctx = new TheTypeNameContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_theTypeName);
		try {
			setState(1122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1118);
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1119);
				enumName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1120);
				typedefName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1121);
				simpleTemplateId();
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
	public static class DecltypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Decltype() { return getToken(CPP14Parser.Decltype, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Auto() { return getToken(CPP14Parser.Auto, 0); }
		public DecltypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decltypeSpecifier; }
	}

	public final DecltypeSpecifierContext decltypeSpecifier() throws RecognitionException {
		DecltypeSpecifierContext _localctx = new DecltypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_decltypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1124);
			match(Decltype);
			setState(1125);
			match(LeftParen);
			setState(1128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(1126);
				expression();
				}
				break;
			case 2:
				{
				setState(1127);
				match(Auto);
				}
				break;
			}
			setState(1130);
			match(RightParen);
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
	public static class ElaboratedTypeSpecifierContext extends ParserRuleContext {
		public ClassKeyContext classKey() {
			return getRuleContext(ClassKeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Enum() { return getToken(CPP14Parser.Enum, 0); }
		public ElaboratedTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elaboratedTypeSpecifier; }
	}

	public final ElaboratedTypeSpecifierContext elaboratedTypeSpecifier() throws RecognitionException {
		ElaboratedTypeSpecifierContext _localctx = new ElaboratedTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_elaboratedTypeSpecifier);
		int _la;
		try {
			setState(1154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Struct:
				enterOuterAlt(_localctx, 1);
				{
				setState(1132);
				classKey();
				setState(1147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(1134);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Alignas || _la==LeftBracket) {
						{
						setState(1133);
						attributeSpecifierSeq();
						}
					}

					setState(1137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
					case 1:
						{
						setState(1136);
						nestedNameSpecifier(0);
						}
						break;
					}
					setState(1139);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(1140);
					simpleTemplateId();
					}
					break;
				case 3:
					{
					setState(1141);
					nestedNameSpecifier(0);
					setState(1143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Template) {
						{
						setState(1142);
						match(Template);
						}
					}

					setState(1145);
					simpleTemplateId();
					}
					break;
				}
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 2);
				{
				setState(1149);
				match(Enum);
				setState(1151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
				case 1:
					{
					setState(1150);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1153);
				match(Identifier);
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
	public static class EnumNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public EnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumName; }
	}

	public final EnumNameContext enumName() throws RecognitionException {
		EnumNameContext _localctx = new EnumNameContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_enumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156);
			match(Identifier);
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
	public static class EnumSpecifierContext extends ParserRuleContext {
		public EnumHeadContext enumHead() {
			return getRuleContext(EnumHeadContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public EnumSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumSpecifier; }
	}

	public final EnumSpecifierContext enumSpecifier() throws RecognitionException {
		EnumSpecifierContext _localctx = new EnumSpecifierContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_enumSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			enumHead();
			setState(1159);
			match(LeftBrace);
			setState(1164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1160);
				enumeratorList();
				setState(1162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1161);
					match(Comma);
					}
				}

				}
			}

			setState(1166);
			match(RightBrace);
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
	public static class EnumHeadContext extends ParserRuleContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public EnumHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumHead; }
	}

	public final EnumHeadContext enumHead() throws RecognitionException {
		EnumHeadContext _localctx = new EnumHeadContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_enumHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168);
			enumkey();
			setState(1170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1169);
				attributeSpecifierSeq();
				}
			}

			setState(1176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
				{
				setState(1173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
				case 1:
					{
					setState(1172);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1175);
				match(Identifier);
				}
			}

			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1178);
				enumbase();
				}
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
	public static class OpaqueEnumDeclarationContext extends ParserRuleContext {
		public EnumkeyContext enumkey() {
			return getRuleContext(EnumkeyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public EnumbaseContext enumbase() {
			return getRuleContext(EnumbaseContext.class,0);
		}
		public OpaqueEnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opaqueEnumDeclaration; }
	}

	public final OpaqueEnumDeclarationContext opaqueEnumDeclaration() throws RecognitionException {
		OpaqueEnumDeclarationContext _localctx = new OpaqueEnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_opaqueEnumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1181);
			enumkey();
			setState(1183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1182);
				attributeSpecifierSeq();
				}
			}

			setState(1185);
			match(Identifier);
			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1186);
				enumbase();
				}
			}

			setState(1189);
			match(Semi);
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
	public static class EnumkeyContext extends ParserRuleContext {
		public TerminalNode Enum() { return getToken(CPP14Parser.Enum, 0); }
		public TerminalNode Class() { return getToken(CPP14Parser.Class, 0); }
		public TerminalNode Struct() { return getToken(CPP14Parser.Struct, 0); }
		public EnumkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumkey; }
	}

	public final EnumkeyContext enumkey() throws RecognitionException {
		EnumkeyContext _localctx = new EnumkeyContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_enumkey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1191);
			match(Enum);
			setState(1193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Class || _la==Struct) {
				{
				setState(1192);
				_la = _input.LA(1);
				if ( !(_la==Class || _la==Struct) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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
	public static class EnumbaseContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public EnumbaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumbase; }
	}

	public final EnumbaseContext enumbase() throws RecognitionException {
		EnumbaseContext _localctx = new EnumbaseContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_enumbase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1195);
			match(Colon);
			setState(1196);
			typeSpecifierSeq();
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
	public static class EnumeratorListContext extends ParserRuleContext {
		public List<EnumeratorDefinitionContext> enumeratorDefinition() {
			return getRuleContexts(EnumeratorDefinitionContext.class);
		}
		public EnumeratorDefinitionContext enumeratorDefinition(int i) {
			return getRuleContext(EnumeratorDefinitionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public EnumeratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorList; }
	}

	public final EnumeratorListContext enumeratorList() throws RecognitionException {
		EnumeratorListContext _localctx = new EnumeratorListContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_enumeratorList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1198);
			enumeratorDefinition();
			setState(1203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1199);
					match(Comma);
					setState(1200);
					enumeratorDefinition();
					}
					} 
				}
				setState(1205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
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
	public static class EnumeratorDefinitionContext extends ParserRuleContext {
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumeratorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorDefinition; }
	}

	public final EnumeratorDefinitionContext enumeratorDefinition() throws RecognitionException {
		EnumeratorDefinitionContext _localctx = new EnumeratorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_enumeratorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1206);
			enumerator();
			setState(1209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(1207);
				match(Assign);
				setState(1208);
				constantExpression();
				}
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
	public static class EnumeratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_enumerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1211);
			match(Identifier);
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
	public static class NamespaceNameContext extends ParserRuleContext {
		public OriginalNamespaceNameContext originalNamespaceName() {
			return getRuleContext(OriginalNamespaceNameContext.class,0);
		}
		public NamespaceAliasContext namespaceAlias() {
			return getRuleContext(NamespaceAliasContext.class,0);
		}
		public NamespaceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceName; }
	}

	public final NamespaceNameContext namespaceName() throws RecognitionException {
		NamespaceNameContext _localctx = new NamespaceNameContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_namespaceName);
		try {
			setState(1215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1213);
				originalNamespaceName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1214);
				namespaceAlias();
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
	public static class OriginalNamespaceNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public OriginalNamespaceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalNamespaceName; }
	}

	public final OriginalNamespaceNameContext originalNamespaceName() throws RecognitionException {
		OriginalNamespaceNameContext _localctx = new OriginalNamespaceNameContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_originalNamespaceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1217);
			match(Identifier);
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
	public static class NamespaceDefinitionContext extends ParserRuleContext {
		public DeclarationseqContext namespaceBody;
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public TerminalNode Inline() { return getToken(CPP14Parser.Inline, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public OriginalNamespaceNameContext originalNamespaceName() {
			return getRuleContext(OriginalNamespaceNameContext.class,0);
		}
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public NamespaceDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDefinition; }
	}

	public final NamespaceDefinitionContext namespaceDefinition() throws RecognitionException {
		NamespaceDefinitionContext _localctx = new NamespaceDefinitionContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_namespaceDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inline) {
				{
				setState(1219);
				match(Inline);
				}
			}

			setState(1222);
			match(Namespace);
			setState(1225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				{
				setState(1223);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(1224);
				originalNamespaceName();
				}
				break;
			}
			setState(1227);
			match(LeftBrace);
			setState(1229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1543754443169808157L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 459384754220313597L) != 0)) {
				{
				setState(1228);
				((NamespaceDefinitionContext)_localctx).namespaceBody = declarationseq();
				}
			}

			setState(1231);
			match(RightBrace);
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
	public static class NamespaceAliasContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public NamespaceAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceAlias; }
	}

	public final NamespaceAliasContext namespaceAlias() throws RecognitionException {
		NamespaceAliasContext _localctx = new NamespaceAliasContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_namespaceAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1233);
			match(Identifier);
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
	public static class NamespaceAliasDefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public QualifiednamespacespecifierContext qualifiednamespacespecifier() {
			return getRuleContext(QualifiednamespacespecifierContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public NamespaceAliasDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceAliasDefinition; }
	}

	public final NamespaceAliasDefinitionContext namespaceAliasDefinition() throws RecognitionException {
		NamespaceAliasDefinitionContext _localctx = new NamespaceAliasDefinitionContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_namespaceAliasDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1235);
			match(Namespace);
			setState(1236);
			match(Identifier);
			setState(1237);
			match(Assign);
			setState(1238);
			qualifiednamespacespecifier();
			setState(1239);
			match(Semi);
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
	public static class QualifiednamespacespecifierContext extends ParserRuleContext {
		public NamespaceNameContext namespaceName() {
			return getRuleContext(NamespaceNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public QualifiednamespacespecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiednamespacespecifier; }
	}

	public final QualifiednamespacespecifierContext qualifiednamespacespecifier() throws RecognitionException {
		QualifiednamespacespecifierContext _localctx = new QualifiednamespacespecifierContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_qualifiednamespacespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				{
				setState(1241);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1244);
			namespaceName();
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
	public static class UsingDeclarationContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(CPP14Parser.Using, 0); }
		public UnqualifiedIdContext unqualifiedId() {
			return getRuleContext(UnqualifiedIdContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public TerminalNode Typename_() { return getToken(CPP14Parser.Typename_, 0); }
		public UsingDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDeclaration; }
	}

	public final UsingDeclarationContext usingDeclaration() throws RecognitionException {
		UsingDeclarationContext _localctx = new UsingDeclarationContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_usingDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			match(Using);
			setState(1252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				{
				setState(1248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Typename_) {
					{
					setState(1247);
					match(Typename_);
					}
				}

				setState(1250);
				nestedNameSpecifier(0);
				}
				break;
			case 2:
				{
				setState(1251);
				match(Doublecolon);
				}
				break;
			}
			setState(1254);
			unqualifiedId();
			setState(1255);
			match(Semi);
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
	public static class UsingDirectiveContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(CPP14Parser.Using, 0); }
		public TerminalNode Namespace() { return getToken(CPP14Parser.Namespace, 0); }
		public NamespaceNameContext namespaceName() {
			return getRuleContext(NamespaceNameContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public UsingDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDirective; }
	}

	public final UsingDirectiveContext usingDirective() throws RecognitionException {
		UsingDirectiveContext _localctx = new UsingDirectiveContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_usingDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1257);
				attributeSpecifierSeq();
				}
			}

			setState(1260);
			match(Using);
			setState(1261);
			match(Namespace);
			setState(1263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(1262);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1265);
			namespaceName();
			setState(1266);
			match(Semi);
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
	public static class AsmDefinitionContext extends ParserRuleContext {
		public TerminalNode Asm() { return getToken(CPP14Parser.Asm, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode StringLiteral() { return getToken(CPP14Parser.StringLiteral, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AsmDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asmDefinition; }
	}

	public final AsmDefinitionContext asmDefinition() throws RecognitionException {
		AsmDefinitionContext _localctx = new AsmDefinitionContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_asmDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1268);
			match(Asm);
			setState(1269);
			match(LeftParen);
			setState(1270);
			match(StringLiteral);
			setState(1271);
			match(RightParen);
			setState(1272);
			match(Semi);
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
	public static class LinkageSpecificationContext extends ParserRuleContext {
		public TerminalNode Extern() { return getToken(CPP14Parser.Extern, 0); }
		public TerminalNode StringLiteral() { return getToken(CPP14Parser.StringLiteral, 0); }
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationseqContext declarationseq() {
			return getRuleContext(DeclarationseqContext.class,0);
		}
		public LinkageSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkageSpecification; }
	}

	public final LinkageSpecificationContext linkageSpecification() throws RecognitionException {
		LinkageSpecificationContext _localctx = new LinkageSpecificationContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_linkageSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1274);
			match(Extern);
			setState(1275);
			match(StringLiteral);
			setState(1282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				{
				setState(1276);
				match(LeftBrace);
				setState(1278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1543754443169808157L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 459384754220313597L) != 0)) {
					{
					setState(1277);
					declarationseq();
					}
				}

				setState(1280);
				match(RightBrace);
				}
				break;
			case Alignas:
			case Asm:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Decltype:
			case Double:
			case Enum:
			case Explicit:
			case Extern:
			case Float:
			case Friend:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Namespace:
			case Operator:
			case Register:
			case Short:
			case Signed:
			case Static:
			case Static_assert:
			case Struct:
			case Template:
			case Thread_local:
			case Typedef:
			case Typename_:
			case Union:
			case Unsigned:
			case Using:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Star:
			case And:
			case Tilde:
			case AndAnd:
			case Doublecolon:
			case Semi:
			case Ellipsis:
			case Identifier:
				{
				setState(1281);
				declaration();
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
	public static class AttributeSpecifierSeqContext extends ParserRuleContext {
		public List<AttributeSpecifierContext> attributeSpecifier() {
			return getRuleContexts(AttributeSpecifierContext.class);
		}
		public AttributeSpecifierContext attributeSpecifier(int i) {
			return getRuleContext(AttributeSpecifierContext.class,i);
		}
		public AttributeSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSpecifierSeq; }
	}

	public final AttributeSpecifierSeqContext attributeSpecifierSeq() throws RecognitionException {
		AttributeSpecifierSeqContext _localctx = new AttributeSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_attributeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1285); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1284);
					attributeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1287); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
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
	public static class AttributeSpecifierContext extends ParserRuleContext {
		public List<TerminalNode> LeftBracket() { return getTokens(CPP14Parser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPP14Parser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPP14Parser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPP14Parser.RightBracket, i);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public AlignmentspecifierContext alignmentspecifier() {
			return getRuleContext(AlignmentspecifierContext.class,0);
		}
		public AttributeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSpecifier; }
	}

	public final AttributeSpecifierContext attributeSpecifier() throws RecognitionException {
		AttributeSpecifierContext _localctx = new AttributeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_attributeSpecifier);
		int _la;
		try {
			setState(1297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1289);
				match(LeftBracket);
				setState(1290);
				match(LeftBracket);
				setState(1292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1291);
					attributeList();
					}
				}

				setState(1294);
				match(RightBracket);
				setState(1295);
				match(RightBracket);
				}
				break;
			case Alignas:
				enterOuterAlt(_localctx, 2);
				{
				setState(1296);
				alignmentspecifier();
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
	public static class AlignmentspecifierContext extends ParserRuleContext {
		public TerminalNode Alignas() { return getToken(CPP14Parser.Alignas, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public AlignmentspecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignmentspecifier; }
	}

	public final AlignmentspecifierContext alignmentspecifier() throws RecognitionException {
		AlignmentspecifierContext _localctx = new AlignmentspecifierContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_alignmentspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1299);
			match(Alignas);
			setState(1300);
			match(LeftParen);
			setState(1303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
			case 1:
				{
				setState(1301);
				theTypeId();
				}
				break;
			case 2:
				{
				setState(1302);
				constantExpression();
				}
				break;
			}
			setState(1306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1305);
				match(Ellipsis);
				}
			}

			setState(1308);
			match(RightParen);
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
	public static class AttributeListContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1310);
			attribute();
			setState(1315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1311);
				match(Comma);
				setState(1312);
				attribute();
				}
				}
				setState(1317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1318);
				match(Ellipsis);
				}
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
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributeNamespaceContext attributeNamespace() {
			return getRuleContext(AttributeNamespaceContext.class,0);
		}
		public TerminalNode Doublecolon() { return getToken(CPP14Parser.Doublecolon, 0); }
		public AttributeArgumentClauseContext attributeArgumentClause() {
			return getRuleContext(AttributeArgumentClauseContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				{
				setState(1321);
				attributeNamespace();
				setState(1322);
				match(Doublecolon);
				}
				break;
			}
			setState(1326);
			match(Identifier);
			setState(1328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(1327);
				attributeArgumentClause();
				}
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
	public static class AttributeNamespaceContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributeNamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeNamespace; }
	}

	public final AttributeNamespaceContext attributeNamespace() throws RecognitionException {
		AttributeNamespaceContext _localctx = new AttributeNamespaceContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_attributeNamespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1330);
			match(Identifier);
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
	public static class AttributeArgumentClauseContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public BalancedTokenSeqContext balancedTokenSeq() {
			return getRuleContext(BalancedTokenSeqContext.class,0);
		}
		public AttributeArgumentClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeArgumentClause; }
	}

	public final AttributeArgumentClauseContext attributeArgumentClause() throws RecognitionException {
		AttributeArgumentClauseContext _localctx = new AttributeArgumentClauseContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_attributeArgumentClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1332);
			match(LeftParen);
			setState(1334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -44040193L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 131071L) != 0)) {
				{
				setState(1333);
				balancedTokenSeq();
				}
			}

			setState(1336);
			match(RightParen);
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
	public static class BalancedTokenSeqContext extends ParserRuleContext {
		public List<BalancedtokenContext> balancedtoken() {
			return getRuleContexts(BalancedtokenContext.class);
		}
		public BalancedtokenContext balancedtoken(int i) {
			return getRuleContext(BalancedtokenContext.class,i);
		}
		public BalancedTokenSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedTokenSeq; }
	}

	public final BalancedTokenSeqContext balancedTokenSeq() throws RecognitionException {
		BalancedTokenSeqContext _localctx = new BalancedTokenSeqContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_balancedTokenSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1339); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1338);
				balancedtoken();
				}
				}
				setState(1341); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -44040193L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 131071L) != 0) );
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
	public static class BalancedtokenContext extends ParserRuleContext {
		public List<TerminalNode> LeftParen() { return getTokens(CPP14Parser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(CPP14Parser.LeftParen, i);
		}
		public BalancedTokenSeqContext balancedTokenSeq() {
			return getRuleContext(BalancedTokenSeqContext.class,0);
		}
		public List<TerminalNode> RightParen() { return getTokens(CPP14Parser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(CPP14Parser.RightParen, i);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(CPP14Parser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(CPP14Parser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(CPP14Parser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(CPP14Parser.RightBracket, i);
		}
		public List<TerminalNode> LeftBrace() { return getTokens(CPP14Parser.LeftBrace); }
		public TerminalNode LeftBrace(int i) {
			return getToken(CPP14Parser.LeftBrace, i);
		}
		public List<TerminalNode> RightBrace() { return getTokens(CPP14Parser.RightBrace); }
		public TerminalNode RightBrace(int i) {
			return getToken(CPP14Parser.RightBrace, i);
		}
		public BalancedtokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedtoken; }
	}

	public final BalancedtokenContext balancedtoken() throws RecognitionException {
		BalancedtokenContext _localctx = new BalancedtokenContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_balancedtoken);
		int _la;
		try {
			int _alt;
			setState(1360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(1343);
				match(LeftParen);
				setState(1344);
				balancedTokenSeq();
				setState(1345);
				match(RightParen);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1347);
				match(LeftBracket);
				setState(1348);
				balancedTokenSeq();
				setState(1349);
				match(RightBracket);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(1351);
				match(LeftBrace);
				setState(1352);
				balancedTokenSeq();
				setState(1353);
				match(RightBrace);
				}
				break;
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case LineBreakCombiner:
			case Alignas:
			case Alignof:
			case Asm:
			case Auto:
			case Bool:
			case Break:
			case Case:
			case Catch:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Constexpr:
			case Const_cast:
			case Continue:
			case Decltype:
			case Default:
			case Delete:
			case Do:
			case Double:
			case Dynamic_cast:
			case Else:
			case Enum:
			case Explicit:
			case Export:
			case Extern:
			case False_:
			case Final:
			case Float:
			case For:
			case Friend:
			case Goto:
			case If:
			case Inline:
			case Int:
			case Long:
			case Mutable:
			case Namespace:
			case New:
			case Noexcept:
			case Nullptr:
			case Operator:
			case Override:
			case Private:
			case Protected:
			case Public:
			case Register:
			case Reinterpret_cast:
			case Return:
			case Short:
			case Signed:
			case Sizeof:
			case Static:
			case Static_assert:
			case Static_cast:
			case Struct:
			case Switch:
			case Template:
			case This:
			case Thread_local:
			case Throw:
			case True_:
			case Try:
			case Typedef:
			case Typeid_:
			case Typename_:
			case Union:
			case Unsigned:
			case Using:
			case Virtual:
			case Void:
			case Volatile:
			case Wchar:
			case While:
			case Plus:
			case Minus:
			case Star:
			case Div:
			case Mod:
			case Caret:
			case And:
			case Or:
			case Tilde:
			case Not:
			case Assign:
			case Less:
			case Greater:
			case PlusAssign:
			case MinusAssign:
			case StarAssign:
			case DivAssign:
			case ModAssign:
			case XorAssign:
			case AndAssign:
			case OrAssign:
			case LeftShiftAssign:
			case RightShiftAssign:
			case Equal:
			case NotEqual:
			case LessEqual:
			case GreaterEqual:
			case AndAnd:
			case OrOr:
			case PlusPlus:
			case MinusMinus:
			case Comma:
			case ArrowStar:
			case Arrow:
			case Question:
			case Colon:
			case Doublecolon:
			case Semi:
			case Dot:
			case DotStar:
			case Ellipsis:
			case Identifier:
			case DecimalLiteral:
			case OctalLiteral:
			case HexadecimalLiteral:
			case BinaryLiteral:
			case Integersuffix:
			case UserDefinedIntegerLiteral:
			case UserDefinedFloatingLiteral:
			case UserDefinedStringLiteral:
			case UserDefinedCharacterLiteral:
			case Whitespace:
			case Newline:
			case BlockComment:
			case LineComment:
				enterOuterAlt(_localctx, 4);
				{
				setState(1356); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1355);
						_la = _input.LA(1);
						if ( _la <= 0 || (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 63L) != 0)) ) {
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
					setState(1358); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1362);
			initDeclarator();
			setState(1367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1363);
				match(Comma);
				setState(1364);
				initDeclarator();
				}
				}
				setState(1369);
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
	public static class InitDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1370);
			declarator();
			setState(1372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 65553L) != 0)) {
				{
				setState(1371);
				initializer();
				}
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
	public static class DeclaratorContext extends ParserRuleContext {
		public PointerDeclaratorContext pointerDeclarator() {
			return getRuleContext(PointerDeclaratorContext.class,0);
		}
		public NoPointerDeclaratorContext noPointerDeclarator() {
			return getRuleContext(NoPointerDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TrailingReturnTypeContext trailingReturnType() {
			return getRuleContext(TrailingReturnTypeContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_declarator);
		try {
			setState(1379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1374);
				pointerDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1375);
				noPointerDeclarator(0);
				setState(1376);
				parametersAndQualifiers();
				setState(1377);
				trailingReturnType();
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
	public static class PointerDeclaratorContext extends ParserRuleContext {
		public NoPointerDeclaratorContext noPointerDeclarator() {
			return getRuleContext(NoPointerDeclaratorContext.class,0);
		}
		public List<PointerOperatorContext> pointerOperator() {
			return getRuleContexts(PointerOperatorContext.class);
		}
		public PointerOperatorContext pointerOperator(int i) {
			return getRuleContext(PointerOperatorContext.class,i);
		}
		public List<TerminalNode> Const() { return getTokens(CPP14Parser.Const); }
		public TerminalNode Const(int i) {
			return getToken(CPP14Parser.Const, i);
		}
		public PointerDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerDeclarator; }
	}

	public final PointerDeclaratorContext pointerDeclarator() throws RecognitionException {
		PointerDeclaratorContext _localctx = new PointerDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_pointerDeclarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1381);
					pointerOperator();
					setState(1383);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Const) {
						{
						setState(1382);
						match(Const);
						}
					}

					}
					} 
				}
				setState(1389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			}
			setState(1390);
			noPointerDeclarator(0);
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
	public static class NoPointerDeclaratorContext extends ParserRuleContext {
		public DeclaratoridContext declaratorid() {
			return getRuleContext(DeclaratoridContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public PointerDeclaratorContext pointerDeclarator() {
			return getRuleContext(PointerDeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoPointerDeclaratorContext noPointerDeclarator() {
			return getRuleContext(NoPointerDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public NoPointerDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerDeclarator; }
	}

	public final NoPointerDeclaratorContext noPointerDeclarator() throws RecognitionException {
		return noPointerDeclarator(0);
	}

	private NoPointerDeclaratorContext noPointerDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoPointerDeclaratorContext _localctx = new NoPointerDeclaratorContext(_ctx, _parentState);
		NoPointerDeclaratorContext _prevctx = _localctx;
		int _startState = 230;
		enterRecursionRule(_localctx, 230, RULE_noPointerDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Ellipsis:
			case Identifier:
				{
				setState(1393);
				declaratorid();
				setState(1395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
				case 1:
					{
					setState(1394);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case LeftParen:
				{
				setState(1397);
				match(LeftParen);
				setState(1398);
				pointerDeclarator();
				setState(1399);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerDeclarator);
					setState(1403);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1413);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1404);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1405);
						match(LeftBracket);
						setState(1407);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767487L) != 0)) {
							{
							setState(1406);
							constantExpression();
							}
						}

						setState(1409);
						match(RightBracket);
						setState(1411);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
						case 1:
							{
							setState(1410);
							attributeSpecifierSeq();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(1419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
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
	public static class ParametersAndQualifiersContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public ParameterDeclarationClauseContext parameterDeclarationClause() {
			return getRuleContext(ParameterDeclarationClauseContext.class,0);
		}
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public RefqualifierContext refqualifier() {
			return getRuleContext(RefqualifierContext.class,0);
		}
		public ExceptionSpecificationContext exceptionSpecification() {
			return getRuleContext(ExceptionSpecificationContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ParametersAndQualifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersAndQualifiers; }
	}

	public final ParametersAndQualifiersContext parametersAndQualifiers() throws RecognitionException {
		ParametersAndQualifiersContext _localctx = new ParametersAndQualifiersContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_parametersAndQualifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1420);
			match(LeftParen);
			setState(1422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1237504995584196377L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 297237575406461917L) != 0)) {
				{
				setState(1421);
				parameterDeclarationClause();
				}
			}

			setState(1424);
			match(RightParen);
			setState(1426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				{
				setState(1425);
				cvqualifierseq();
				}
				break;
			}
			setState(1429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
			case 1:
				{
				setState(1428);
				refqualifier();
				}
				break;
			}
			setState(1432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				{
				setState(1431);
				exceptionSpecification();
				}
				break;
			}
			setState(1435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				{
				setState(1434);
				attributeSpecifierSeq();
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
	public static class TrailingReturnTypeContext extends ParserRuleContext {
		public TerminalNode Arrow() { return getToken(CPP14Parser.Arrow, 0); }
		public TrailingTypeSpecifierSeqContext trailingTypeSpecifierSeq() {
			return getRuleContext(TrailingTypeSpecifierSeqContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TrailingReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingReturnType; }
	}

	public final TrailingReturnTypeContext trailingReturnType() throws RecognitionException {
		TrailingReturnTypeContext _localctx = new TrailingReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_trailingReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1437);
			match(Arrow);
			setState(1438);
			trailingTypeSpecifierSeq();
			setState(1440);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				{
				setState(1439);
				abstractDeclarator();
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
	public static class PointerOperatorContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public CvqualifierseqContext cvqualifierseq() {
			return getRuleContext(CvqualifierseqContext.class,0);
		}
		public PointerOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerOperator; }
	}

	public final PointerOperatorContext pointerOperator() throws RecognitionException {
		PointerOperatorContext _localctx = new PointerOperatorContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_pointerOperator);
		int _la;
		try {
			setState(1456);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case AndAnd:
				enterOuterAlt(_localctx, 1);
				{
				setState(1442);
				_la = _input.LA(1);
				if ( !(_la==And || _la==AndAnd) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1444);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1443);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case Decltype:
			case Star:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1446);
					nestedNameSpecifier(0);
					}
				}

				setState(1449);
				match(Star);
				setState(1451);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
				case 1:
					{
					setState(1450);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(1454);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
				case 1:
					{
					setState(1453);
					cvqualifierseq();
					}
					break;
				}
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
	public static class CvqualifierseqContext extends ParserRuleContext {
		public List<CvQualifierContext> cvQualifier() {
			return getRuleContexts(CvQualifierContext.class);
		}
		public CvQualifierContext cvQualifier(int i) {
			return getRuleContext(CvQualifierContext.class,i);
		}
		public CvqualifierseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvqualifierseq; }
	}

	public final CvqualifierseqContext cvqualifierseq() throws RecognitionException {
		CvqualifierseqContext _localctx = new CvqualifierseqContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_cvqualifierseq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1459); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1458);
					cvQualifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1461); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,179,_ctx);
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
	public static class CvQualifierContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(CPP14Parser.Const, 0); }
		public TerminalNode Volatile() { return getToken(CPP14Parser.Volatile, 0); }
		public CvQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvQualifier; }
	}

	public final CvQualifierContext cvQualifier() throws RecognitionException {
		CvQualifierContext _localctx = new CvQualifierContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_cvQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1463);
			_la = _input.LA(1);
			if ( !(_la==Const || _la==Volatile) ) {
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
	public static class RefqualifierContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public RefqualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refqualifier; }
	}

	public final RefqualifierContext refqualifier() throws RecognitionException {
		RefqualifierContext _localctx = new RefqualifierContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_refqualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1465);
			_la = _input.LA(1);
			if ( !(_la==And || _la==AndAnd) ) {
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
	public static class DeclaratoridContext extends ParserRuleContext {
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public DeclaratoridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorid; }
	}

	public final DeclaratoridContext declaratorid() throws RecognitionException {
		DeclaratoridContext _localctx = new DeclaratoridContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_declaratorid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1467);
				match(Ellipsis);
				}
			}

			setState(1470);
			idExpression();
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
	public static class TheTypeIdContext extends ParserRuleContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TheTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theTypeId; }
	}

	public final TheTypeIdContext theTypeId() throws RecognitionException {
		TheTypeIdContext _localctx = new TheTypeIdContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_theTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472);
			typeSpecifierSeq();
			setState(1474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
			case 1:
				{
				setState(1473);
				abstractDeclarator();
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
	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public PointerAbstractDeclaratorContext pointerAbstractDeclarator() {
			return getRuleContext(PointerAbstractDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TrailingReturnTypeContext trailingReturnType() {
			return getRuleContext(TrailingReturnTypeContext.class,0);
		}
		public NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator() {
			return getRuleContext(NoPointerAbstractDeclaratorContext.class,0);
		}
		public AbstractPackDeclaratorContext abstractPackDeclarator() {
			return getRuleContext(AbstractPackDeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_abstractDeclarator);
		try {
			setState(1484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1476);
				pointerAbstractDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1478);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
				case 1:
					{
					setState(1477);
					noPointerAbstractDeclarator(0);
					}
					break;
				}
				setState(1480);
				parametersAndQualifiers();
				setState(1481);
				trailingReturnType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1483);
				abstractPackDeclarator();
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
	public static class PointerAbstractDeclaratorContext extends ParserRuleContext {
		public NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator() {
			return getRuleContext(NoPointerAbstractDeclaratorContext.class,0);
		}
		public List<PointerOperatorContext> pointerOperator() {
			return getRuleContexts(PointerOperatorContext.class);
		}
		public PointerOperatorContext pointerOperator(int i) {
			return getRuleContext(PointerOperatorContext.class,i);
		}
		public PointerAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerAbstractDeclarator; }
	}

	public final PointerAbstractDeclaratorContext pointerAbstractDeclarator() throws RecognitionException {
		PointerAbstractDeclaratorContext _localctx = new PointerAbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_pointerAbstractDeclarator);
		try {
			int _alt;
			setState(1495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1486);
				noPointerAbstractDeclarator(0);
				}
				break;
			case Decltype:
			case Star:
			case And:
			case AndAnd:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1487);
						pointerOperator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1490); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1493);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
				case 1:
					{
					setState(1492);
					noPointerAbstractDeclarator(0);
					}
					break;
				}
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
	public static class NoPointerAbstractDeclaratorContext extends ParserRuleContext {
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public PointerAbstractDeclaratorContext pointerAbstractDeclarator() {
			return getRuleContext(PointerAbstractDeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public List<NoPointerAbstractDeclaratorContext> noPointerAbstractDeclarator() {
			return getRuleContexts(NoPointerAbstractDeclaratorContext.class);
		}
		public NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator(int i) {
			return getRuleContext(NoPointerAbstractDeclaratorContext.class,i);
		}
		public NoPointerAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerAbstractDeclarator; }
	}

	public final NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator() throws RecognitionException {
		return noPointerAbstractDeclarator(0);
	}

	private NoPointerAbstractDeclaratorContext noPointerAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoPointerAbstractDeclaratorContext _localctx = new NoPointerAbstractDeclaratorContext(_ctx, _parentState);
		NoPointerAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 252;
		enterRecursionRule(_localctx, 252, RULE_noPointerAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				setState(1498);
				parametersAndQualifiers();
				}
				break;
			case 2:
				{
				setState(1499);
				match(LeftBracket);
				setState(1501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767487L) != 0)) {
					{
					setState(1500);
					constantExpression();
					}
				}

				setState(1503);
				match(RightBracket);
				setState(1505);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
				case 1:
					{
					setState(1504);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(1507);
				match(LeftParen);
				setState(1508);
				pointerAbstractDeclarator();
				setState(1509);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1528);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerAbstractDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerAbstractDeclarator);
					setState(1513);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(1524);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
					case 1:
						{
						setState(1514);
						parametersAndQualifiers();
						}
						break;
					case 2:
						{
						setState(1515);
						noPointerAbstractDeclarator(0);
						setState(1516);
						match(LeftBracket);
						setState(1518);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767487L) != 0)) {
							{
							setState(1517);
							constantExpression();
							}
						}

						setState(1520);
						match(RightBracket);
						setState(1522);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
						case 1:
							{
							setState(1521);
							attributeSpecifierSeq();
							}
							break;
						}
						}
						break;
					}
					}
					} 
				}
				setState(1530);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,193,_ctx);
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
	public static class AbstractPackDeclaratorContext extends ParserRuleContext {
		public NoPointerAbstractPackDeclaratorContext noPointerAbstractPackDeclarator() {
			return getRuleContext(NoPointerAbstractPackDeclaratorContext.class,0);
		}
		public List<PointerOperatorContext> pointerOperator() {
			return getRuleContexts(PointerOperatorContext.class);
		}
		public PointerOperatorContext pointerOperator(int i) {
			return getRuleContext(PointerOperatorContext.class,i);
		}
		public AbstractPackDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractPackDeclarator; }
	}

	public final AbstractPackDeclaratorContext abstractPackDeclarator() throws RecognitionException {
		AbstractPackDeclaratorContext _localctx = new AbstractPackDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_abstractPackDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Decltype || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & 566969237521L) != 0)) {
				{
				{
				setState(1531);
				pointerOperator();
				}
				}
				setState(1536);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1537);
			noPointerAbstractPackDeclarator(0);
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
	public static class NoPointerAbstractPackDeclaratorContext extends ParserRuleContext {
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public NoPointerAbstractPackDeclaratorContext noPointerAbstractPackDeclarator() {
			return getRuleContext(NoPointerAbstractPackDeclaratorContext.class,0);
		}
		public ParametersAndQualifiersContext parametersAndQualifiers() {
			return getRuleContext(ParametersAndQualifiersContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public NoPointerAbstractPackDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noPointerAbstractPackDeclarator; }
	}

	public final NoPointerAbstractPackDeclaratorContext noPointerAbstractPackDeclarator() throws RecognitionException {
		return noPointerAbstractPackDeclarator(0);
	}

	private NoPointerAbstractPackDeclaratorContext noPointerAbstractPackDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NoPointerAbstractPackDeclaratorContext _localctx = new NoPointerAbstractPackDeclaratorContext(_ctx, _parentState);
		NoPointerAbstractPackDeclaratorContext _prevctx = _localctx;
		int _startState = 256;
		enterRecursionRule(_localctx, 256, RULE_noPointerAbstractPackDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1540);
			match(Ellipsis);
			}
			_ctx.stop = _input.LT(-1);
			setState(1556);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerAbstractPackDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerAbstractPackDeclarator);
					setState(1542);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1552);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1543);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1544);
						match(LeftBracket);
						setState(1546);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767487L) != 0)) {
							{
							setState(1545);
							constantExpression();
							}
						}

						setState(1548);
						match(RightBracket);
						setState(1550);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
						case 1:
							{
							setState(1549);
							attributeSpecifierSeq();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(1558);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
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
	public static class ParameterDeclarationClauseContext extends ParserRuleContext {
		public ParameterDeclarationListContext parameterDeclarationList() {
			return getRuleContext(ParameterDeclarationListContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public ParameterDeclarationClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationClause; }
	}

	public final ParameterDeclarationClauseContext parameterDeclarationClause() throws RecognitionException {
		ParameterDeclarationClauseContext _localctx = new ParameterDeclarationClauseContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_parameterDeclarationClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1559);
			parameterDeclarationList();
			setState(1564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma || _la==Ellipsis) {
				{
				setState(1561);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1560);
					match(Comma);
					}
				}

				setState(1563);
				match(Ellipsis);
				}
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
	public static class ParameterDeclarationListContext extends ParserRuleContext {
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public ParameterDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationList; }
	}

	public final ParameterDeclarationListContext parameterDeclarationList() throws RecognitionException {
		ParameterDeclarationListContext _localctx = new ParameterDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_parameterDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1566);
			parameterDeclaration();
			setState(1571);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1567);
					match(Comma);
					setState(1568);
					parameterDeclaration();
					}
					} 
				}
				setState(1573);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
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
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1574);
				attributeSpecifierSeq();
				}
			}

			setState(1577);
			declSpecifierSeq();
			setState(1582);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				{
				setState(1578);
				declarator();
				}
				break;
			case 2:
				{
				setState(1580);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
				case 1:
					{
					setState(1579);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			}
			setState(1586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(1584);
				match(Assign);
				setState(1585);
				initializerClause();
				}
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public VirtualSpecifierSeqContext virtualSpecifierSeq() {
			return getRuleContext(VirtualSpecifierSeqContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1588);
				attributeSpecifierSeq();
				}
			}

			setState(1592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				{
				setState(1591);
				declSpecifierSeq();
				}
				break;
			}
			setState(1594);
			declarator();
			setState(1596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final || _la==Override) {
				{
				setState(1595);
				virtualSpecifierSeq();
				}
			}

			setState(1598);
			functionBody();
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
	public static class FunctionBodyContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ConstructorInitializerContext constructorInitializer() {
			return getRuleContext(ConstructorInitializerContext.class,0);
		}
		public FunctionTryBlockContext functionTryBlock() {
			return getRuleContext(FunctionTryBlockContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public TerminalNode Default() { return getToken(CPP14Parser.Default, 0); }
		public TerminalNode Delete() { return getToken(CPP14Parser.Delete, 0); }
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_functionBody);
		int _la;
		try {
			setState(1608);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Colon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1600);
					constructorInitializer();
					}
				}

				setState(1603);
				compoundStatement();
				}
				break;
			case Try:
				enterOuterAlt(_localctx, 2);
				{
				setState(1604);
				functionTryBlock();
				}
				break;
			case Assign:
				enterOuterAlt(_localctx, 3);
				{
				setState(1605);
				match(Assign);
				setState(1606);
				_la = _input.LA(1);
				if ( !(_la==Default || _la==Delete) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1607);
				match(Semi);
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
	public static class InitializerContext extends ParserRuleContext {
		public BraceOrEqualInitializerContext braceOrEqualInitializer() {
			return getRuleContext(BraceOrEqualInitializerContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_initializer);
		try {
			setState(1615);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1610);
				braceOrEqualInitializer();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(1611);
				match(LeftParen);
				setState(1612);
				expressionList();
				setState(1613);
				match(RightParen);
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
	public static class BraceOrEqualInitializerContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public InitializerClauseContext initializerClause() {
			return getRuleContext(InitializerClauseContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public BraceOrEqualInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceOrEqualInitializer; }
	}

	public final BraceOrEqualInitializerContext braceOrEqualInitializer() throws RecognitionException {
		BraceOrEqualInitializerContext _localctx = new BraceOrEqualInitializerContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_braceOrEqualInitializer);
		try {
			setState(1620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1617);
				match(Assign);
				setState(1618);
				initializerClause();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1619);
				bracedInitList();
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
	public static class InitializerClauseContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public InitializerClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerClause; }
	}

	public final InitializerClauseContext initializerClause() throws RecognitionException {
		InitializerClauseContext _localctx = new InitializerClauseContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_initializerClause);
		try {
			setState(1624);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case Alignof:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Const_cast:
			case Decltype:
			case Delete:
			case Double:
			case Dynamic_cast:
			case Float:
			case Int:
			case Long:
			case New:
			case Noexcept:
			case Operator:
			case Reinterpret_cast:
			case Short:
			case Signed:
			case Sizeof:
			case Static_cast:
			case This:
			case Throw:
			case Typeid_:
			case Typename_:
			case Unsigned:
			case Void:
			case Wchar:
			case LeftParen:
			case LeftBracket:
			case Plus:
			case Minus:
			case Star:
			case And:
			case Or:
			case Tilde:
			case Not:
			case PlusPlus:
			case MinusMinus:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1622);
				assignmentExpression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1623);
				bracedInitList();
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
	public static class InitializerListContext extends ParserRuleContext {
		public List<InitializerClauseContext> initializerClause() {
			return getRuleContexts(InitializerClauseContext.class);
		}
		public InitializerClauseContext initializerClause(int i) {
			return getRuleContext(InitializerClauseContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPP14Parser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPP14Parser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1626);
			initializerClause();
			setState(1628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1627);
				match(Ellipsis);
				}
			}

			setState(1637);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,216,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1630);
					match(Comma);
					setState(1631);
					initializerClause();
					setState(1633);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ellipsis) {
						{
						setState(1632);
						match(Ellipsis);
						}
					}

					}
					} 
				}
				setState(1639);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,216,_ctx);
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
	public static class BracedInitListContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public BracedInitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracedInitList; }
	}

	public final BracedInitListContext bracedInitList() throws RecognitionException {
		BracedInitListContext _localctx = new BracedInitListContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_bracedInitList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1640);
			match(LeftBrace);
			setState(1645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257204718907L) != 0)) {
				{
				setState(1641);
				initializerList();
				setState(1643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1642);
					match(Comma);
					}
				}

				}
			}

			setState(1647);
			match(RightBrace);
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
	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_className);
		try {
			setState(1651);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1649);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1650);
				simpleTemplateId();
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
	public static class ClassSpecifierContext extends ParserRuleContext {
		public ClassHeadContext classHead() {
			return getRuleContext(ClassHeadContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPP14Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPP14Parser.RightBrace, 0); }
		public MemberSpecificationContext memberSpecification() {
			return getRuleContext(MemberSpecificationContext.class,0);
		}
		public ClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classSpecifier; }
	}

	public final ClassSpecifierContext classSpecifier() throws RecognitionException {
		ClassSpecifierContext _localctx = new ClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_classSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1653);
			classHead();
			setState(1654);
			match(LeftBrace);
			setState(1656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1543877313594212121L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 463888353847684093L) != 0)) {
				{
				setState(1655);
				memberSpecification();
				}
			}

			setState(1658);
			match(RightBrace);
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
	public static class ClassHeadContext extends ParserRuleContext {
		public ClassKeyContext classKey() {
			return getRuleContext(ClassKeyContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public ClassHeadNameContext classHeadName() {
			return getRuleContext(ClassHeadNameContext.class,0);
		}
		public BaseClauseContext baseClause() {
			return getRuleContext(BaseClauseContext.class,0);
		}
		public ClassVirtSpecifierContext classVirtSpecifier() {
			return getRuleContext(ClassVirtSpecifierContext.class,0);
		}
		public TerminalNode Union() { return getToken(CPP14Parser.Union, 0); }
		public ClassHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHead; }
	}

	public final ClassHeadContext classHead() throws RecognitionException {
		ClassHeadContext _localctx = new ClassHeadContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_classHead);
		int _la;
		try {
			setState(1683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Struct:
				enterOuterAlt(_localctx, 1);
				{
				setState(1660);
				classKey();
				setState(1662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1661);
					attributeSpecifierSeq();
					}
				}

				setState(1668);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1664);
					classHeadName();
					setState(1666);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Final) {
						{
						setState(1665);
						classVirtSpecifier();
						}
					}

					}
				}

				setState(1671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1670);
					baseClause();
					}
				}

				}
				break;
			case Union:
				enterOuterAlt(_localctx, 2);
				{
				setState(1673);
				match(Union);
				setState(1675);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1674);
					attributeSpecifierSeq();
					}
				}

				setState(1681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1677);
					classHeadName();
					setState(1679);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Final) {
						{
						setState(1678);
						classVirtSpecifier();
						}
					}

					}
				}

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
	public static class ClassHeadNameContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public ClassHeadNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHeadName; }
	}

	public final ClassHeadNameContext classHeadName() throws RecognitionException {
		ClassHeadNameContext _localctx = new ClassHeadNameContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_classHeadName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,229,_ctx) ) {
			case 1:
				{
				setState(1685);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1688);
			className();
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
	public static class ClassVirtSpecifierContext extends ParserRuleContext {
		public TerminalNode Final() { return getToken(CPP14Parser.Final, 0); }
		public ClassVirtSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVirtSpecifier; }
	}

	public final ClassVirtSpecifierContext classVirtSpecifier() throws RecognitionException {
		ClassVirtSpecifierContext _localctx = new ClassVirtSpecifierContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_classVirtSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1690);
			match(Final);
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
	public static class ClassKeyContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(CPP14Parser.Class, 0); }
		public TerminalNode Struct() { return getToken(CPP14Parser.Struct, 0); }
		public ClassKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classKey; }
	}

	public final ClassKeyContext classKey() throws RecognitionException {
		ClassKeyContext _localctx = new ClassKeyContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_classKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1692);
			_la = _input.LA(1);
			if ( !(_la==Class || _la==Struct) ) {
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
	public static class MemberSpecificationContext extends ParserRuleContext {
		public List<MemberdeclarationContext> memberdeclaration() {
			return getRuleContexts(MemberdeclarationContext.class);
		}
		public MemberdeclarationContext memberdeclaration(int i) {
			return getRuleContext(MemberdeclarationContext.class,i);
		}
		public List<AccessSpecifierContext> accessSpecifier() {
			return getRuleContexts(AccessSpecifierContext.class);
		}
		public AccessSpecifierContext accessSpecifier(int i) {
			return getRuleContext(AccessSpecifierContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(CPP14Parser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(CPP14Parser.Colon, i);
		}
		public MemberSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberSpecification; }
	}

	public final MemberSpecificationContext memberSpecification() throws RecognitionException {
		MemberSpecificationContext _localctx = new MemberSpecificationContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_memberSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1698); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1698);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Alignas:
				case Auto:
				case Bool:
				case Char:
				case Char16:
				case Char32:
				case Class:
				case Const:
				case Constexpr:
				case Decltype:
				case Double:
				case Enum:
				case Explicit:
				case Extern:
				case Float:
				case Friend:
				case Inline:
				case Int:
				case Long:
				case Mutable:
				case Operator:
				case Register:
				case Short:
				case Signed:
				case Static:
				case Static_assert:
				case Struct:
				case Template:
				case Thread_local:
				case Typedef:
				case Typename_:
				case Union:
				case Unsigned:
				case Using:
				case Virtual:
				case Void:
				case Volatile:
				case Wchar:
				case LeftParen:
				case LeftBracket:
				case Star:
				case And:
				case Tilde:
				case AndAnd:
				case Colon:
				case Doublecolon:
				case Semi:
				case Ellipsis:
				case Identifier:
					{
					setState(1694);
					memberdeclaration();
					}
					break;
				case Private:
				case Protected:
				case Public:
					{
					setState(1695);
					accessSpecifier();
					setState(1696);
					match(Colon);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1700); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 1543877313594212121L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 463888353847684093L) != 0) );
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
	public static class MemberdeclarationContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CPP14Parser.Semi, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclSpecifierSeqContext declSpecifierSeq() {
			return getRuleContext(DeclSpecifierSeqContext.class,0);
		}
		public MemberDeclaratorListContext memberDeclaratorList() {
			return getRuleContext(MemberDeclaratorListContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public UsingDeclarationContext usingDeclaration() {
			return getRuleContext(UsingDeclarationContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public TemplateDeclarationContext templateDeclaration() {
			return getRuleContext(TemplateDeclarationContext.class,0);
		}
		public AliasDeclarationContext aliasDeclaration() {
			return getRuleContext(AliasDeclarationContext.class,0);
		}
		public EmptyDeclaration_Context emptyDeclaration_() {
			return getRuleContext(EmptyDeclaration_Context.class,0);
		}
		public MemberdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberdeclaration; }
	}

	public final MemberdeclarationContext memberdeclaration() throws RecognitionException {
		MemberdeclarationContext _localctx = new MemberdeclarationContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_memberdeclaration);
		int _la;
		try {
			setState(1718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1703);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
				case 1:
					{
					setState(1702);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(1706);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
				case 1:
					{
					setState(1705);
					declSpecifierSeq();
					}
					break;
				}
				setState(1709);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251799847240192L) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 217711892254981L) != 0)) {
					{
					setState(1708);
					memberDeclaratorList();
					}
				}

				setState(1711);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1712);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1713);
				usingDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1714);
				staticAssertDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1715);
				templateDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1716);
				aliasDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1717);
				emptyDeclaration_();
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
	public static class MemberDeclaratorListContext extends ParserRuleContext {
		public List<MemberDeclaratorContext> memberDeclarator() {
			return getRuleContexts(MemberDeclaratorContext.class);
		}
		public MemberDeclaratorContext memberDeclarator(int i) {
			return getRuleContext(MemberDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public MemberDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaratorList; }
	}

	public final MemberDeclaratorListContext memberDeclaratorList() throws RecognitionException {
		MemberDeclaratorListContext _localctx = new MemberDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_memberDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1720);
			memberDeclarator();
			setState(1725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1721);
				match(Comma);
				setState(1722);
				memberDeclarator();
				}
				}
				setState(1727);
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
	public static class MemberDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public VirtualSpecifierSeqContext virtualSpecifierSeq() {
			return getRuleContext(VirtualSpecifierSeqContext.class,0);
		}
		public PureSpecifierContext pureSpecifier() {
			return getRuleContext(PureSpecifierContext.class,0);
		}
		public BraceOrEqualInitializerContext braceOrEqualInitializer() {
			return getRuleContext(BraceOrEqualInitializerContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public MemberDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclarator; }
	}

	public final MemberDeclaratorContext memberDeclarator() throws RecognitionException {
		MemberDeclaratorContext _localctx = new MemberDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_memberDeclarator);
		int _la;
		try {
			setState(1748);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1728);
				declarator();
				setState(1737);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
				case 1:
					{
					setState(1729);
					virtualSpecifierSeq();
					}
					break;
				case 2:
					{
					setState(1730);
					if (!( IsPureSpecifierAllowed() )) throw new FailedPredicateException(this, " IsPureSpecifierAllowed() ");
					setState(1731);
					pureSpecifier();
					}
					break;
				case 3:
					{
					setState(1732);
					if (!( IsPureSpecifierAllowed() )) throw new FailedPredicateException(this, " IsPureSpecifierAllowed() ");
					setState(1733);
					virtualSpecifierSeq();
					setState(1734);
					pureSpecifier();
					}
					break;
				case 4:
					{
					setState(1736);
					braceOrEqualInitializer();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1739);
				declarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1741);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1740);
					match(Identifier);
					}
				}

				setState(1744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1743);
					attributeSpecifierSeq();
					}
				}

				setState(1746);
				match(Colon);
				setState(1747);
				constantExpression();
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
	public static class VirtualSpecifierSeqContext extends ParserRuleContext {
		public List<VirtualSpecifierContext> virtualSpecifier() {
			return getRuleContexts(VirtualSpecifierContext.class);
		}
		public VirtualSpecifierContext virtualSpecifier(int i) {
			return getRuleContext(VirtualSpecifierContext.class,i);
		}
		public VirtualSpecifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtualSpecifierSeq; }
	}

	public final VirtualSpecifierSeqContext virtualSpecifierSeq() throws RecognitionException {
		VirtualSpecifierSeqContext _localctx = new VirtualSpecifierSeqContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_virtualSpecifierSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1751); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1750);
				virtualSpecifier();
				}
				}
				setState(1753); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Final || _la==Override );
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
	public static class VirtualSpecifierContext extends ParserRuleContext {
		public TerminalNode Override() { return getToken(CPP14Parser.Override, 0); }
		public TerminalNode Final() { return getToken(CPP14Parser.Final, 0); }
		public VirtualSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtualSpecifier; }
	}

	public final VirtualSpecifierContext virtualSpecifier() throws RecognitionException {
		VirtualSpecifierContext _localctx = new VirtualSpecifierContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_virtualSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1755);
			_la = _input.LA(1);
			if ( !(_la==Final || _la==Override) ) {
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
	public static class PureSpecifierContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TerminalNode IntegerLiteral() { return getToken(CPP14Parser.IntegerLiteral, 0); }
		public PureSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureSpecifier; }
	}

	public final PureSpecifierContext pureSpecifier() throws RecognitionException {
		PureSpecifierContext _localctx = new PureSpecifierContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_pureSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1757);
			match(Assign);
			setState(1758);
			match(IntegerLiteral);
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
	public static class BaseClauseContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public BaseSpecifierListContext baseSpecifierList() {
			return getRuleContext(BaseSpecifierListContext.class,0);
		}
		public BaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseClause; }
	}

	public final BaseClauseContext baseClause() throws RecognitionException {
		BaseClauseContext _localctx = new BaseClauseContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_baseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1760);
			match(Colon);
			setState(1761);
			baseSpecifierList();
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
	public static class BaseSpecifierListContext extends ParserRuleContext {
		public List<BaseSpecifierContext> baseSpecifier() {
			return getRuleContexts(BaseSpecifierContext.class);
		}
		public BaseSpecifierContext baseSpecifier(int i) {
			return getRuleContext(BaseSpecifierContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPP14Parser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPP14Parser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public BaseSpecifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseSpecifierList; }
	}

	public final BaseSpecifierListContext baseSpecifierList() throws RecognitionException {
		BaseSpecifierListContext _localctx = new BaseSpecifierListContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_baseSpecifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1763);
			baseSpecifier();
			setState(1765);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1764);
				match(Ellipsis);
				}
			}

			setState(1774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1767);
				match(Comma);
				setState(1768);
				baseSpecifier();
				setState(1770);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1769);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1776);
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
	public static class BaseSpecifierContext extends ParserRuleContext {
		public BaseTypeSpecifierContext baseTypeSpecifier() {
			return getRuleContext(BaseTypeSpecifierContext.class,0);
		}
		public TerminalNode Virtual() { return getToken(CPP14Parser.Virtual, 0); }
		public AccessSpecifierContext accessSpecifier() {
			return getRuleContext(AccessSpecifierContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public BaseSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseSpecifier; }
	}

	public final BaseSpecifierContext baseSpecifier() throws RecognitionException {
		BaseSpecifierContext _localctx = new BaseSpecifierContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_baseSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1777);
				attributeSpecifierSeq();
				}
			}

			setState(1792);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Doublecolon:
			case Identifier:
				{
				setState(1780);
				baseTypeSpecifier();
				}
				break;
			case Virtual:
				{
				setState(1781);
				match(Virtual);
				setState(1783);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0)) {
					{
					setState(1782);
					accessSpecifier();
					}
				}

				setState(1785);
				baseTypeSpecifier();
				}
				break;
			case Private:
			case Protected:
			case Public:
				{
				setState(1786);
				accessSpecifier();
				setState(1788);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Virtual) {
					{
					setState(1787);
					match(Virtual);
					}
				}

				setState(1790);
				baseTypeSpecifier();
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
	public static class ClassOrDeclTypeContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public DecltypeSpecifierContext decltypeSpecifier() {
			return getRuleContext(DecltypeSpecifierContext.class,0);
		}
		public ClassOrDeclTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrDeclType; }
	}

	public final ClassOrDeclTypeContext classOrDeclType() throws RecognitionException {
		ClassOrDeclTypeContext _localctx = new ClassOrDeclTypeContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_classOrDeclType);
		try {
			setState(1799);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1795);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
				case 1:
					{
					setState(1794);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1797);
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1798);
				decltypeSpecifier();
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
	public static class BaseTypeSpecifierContext extends ParserRuleContext {
		public ClassOrDeclTypeContext classOrDeclType() {
			return getRuleContext(ClassOrDeclTypeContext.class,0);
		}
		public BaseTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseTypeSpecifier; }
	}

	public final BaseTypeSpecifierContext baseTypeSpecifier() throws RecognitionException {
		BaseTypeSpecifierContext _localctx = new BaseTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_baseTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1801);
			classOrDeclType();
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
	public static class AccessSpecifierContext extends ParserRuleContext {
		public TerminalNode Private() { return getToken(CPP14Parser.Private, 0); }
		public TerminalNode Protected() { return getToken(CPP14Parser.Protected, 0); }
		public TerminalNode Public() { return getToken(CPP14Parser.Public, 0); }
		public AccessSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessSpecifier; }
	}

	public final AccessSpecifierContext accessSpecifier() throws RecognitionException {
		AccessSpecifierContext _localctx = new AccessSpecifierContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_accessSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1803);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63050394783186944L) != 0)) ) {
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
	public static class ConversionFunctionIdContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(CPP14Parser.Operator, 0); }
		public ConversionTypeIdContext conversionTypeId() {
			return getRuleContext(ConversionTypeIdContext.class,0);
		}
		public ConversionFunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionFunctionId; }
	}

	public final ConversionFunctionIdContext conversionFunctionId() throws RecognitionException {
		ConversionFunctionIdContext _localctx = new ConversionFunctionIdContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_conversionFunctionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1805);
			match(Operator);
			setState(1806);
			conversionTypeId();
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
	public static class ConversionTypeIdContext extends ParserRuleContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public ConversionDeclaratorContext conversionDeclarator() {
			return getRuleContext(ConversionDeclaratorContext.class,0);
		}
		public ConversionTypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionTypeId; }
	}

	public final ConversionTypeIdContext conversionTypeId() throws RecognitionException {
		ConversionTypeIdContext _localctx = new ConversionTypeIdContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_conversionTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1808);
			typeSpecifierSeq();
			setState(1810);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
			case 1:
				{
				setState(1809);
				conversionDeclarator();
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
	public static class ConversionDeclaratorContext extends ParserRuleContext {
		public PointerOperatorContext pointerOperator() {
			return getRuleContext(PointerOperatorContext.class,0);
		}
		public ConversionDeclaratorContext conversionDeclarator() {
			return getRuleContext(ConversionDeclaratorContext.class,0);
		}
		public ConversionDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionDeclarator; }
	}

	public final ConversionDeclaratorContext conversionDeclarator() throws RecognitionException {
		ConversionDeclaratorContext _localctx = new ConversionDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_conversionDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1812);
			pointerOperator();
			setState(1814);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
			case 1:
				{
				setState(1813);
				conversionDeclarator();
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
	public static class ConstructorInitializerContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(CPP14Parser.Colon, 0); }
		public MemInitializerListContext memInitializerList() {
			return getRuleContext(MemInitializerListContext.class,0);
		}
		public ConstructorInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorInitializer; }
	}

	public final ConstructorInitializerContext constructorInitializer() throws RecognitionException {
		ConstructorInitializerContext _localctx = new ConstructorInitializerContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_constructorInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1816);
			match(Colon);
			setState(1817);
			memInitializerList();
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
	public static class MemInitializerListContext extends ParserRuleContext {
		public List<MemInitializerContext> memInitializer() {
			return getRuleContexts(MemInitializerContext.class);
		}
		public MemInitializerContext memInitializer(int i) {
			return getRuleContext(MemInitializerContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPP14Parser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPP14Parser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public MemInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memInitializerList; }
	}

	public final MemInitializerListContext memInitializerList() throws RecognitionException {
		MemInitializerListContext _localctx = new MemInitializerListContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_memInitializerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1819);
			memInitializer();
			setState(1821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1820);
				match(Ellipsis);
				}
			}

			setState(1830);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1823);
				match(Comma);
				setState(1824);
				memInitializer();
				setState(1826);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1825);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1832);
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
	public static class MemInitializerContext extends ParserRuleContext {
		public MeminitializeridContext meminitializerid() {
			return getRuleContext(MeminitializeridContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public BracedInitListContext bracedInitList() {
			return getRuleContext(BracedInitListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MemInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memInitializer; }
	}

	public final MemInitializerContext memInitializer() throws RecognitionException {
		MemInitializerContext _localctx = new MemInitializerContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_memInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1833);
			meminitializerid();
			setState(1840);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				{
				setState(1834);
				match(LeftParen);
				setState(1836);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257204718907L) != 0)) {
					{
					setState(1835);
					expressionList();
					}
				}

				setState(1838);
				match(RightParen);
				}
				break;
			case LeftBrace:
				{
				setState(1839);
				bracedInitList();
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
	public static class MeminitializeridContext extends ParserRuleContext {
		public ClassOrDeclTypeContext classOrDeclType() {
			return getRuleContext(ClassOrDeclTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public MeminitializeridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meminitializerid; }
	}

	public final MeminitializeridContext meminitializerid() throws RecognitionException {
		MeminitializeridContext _localctx = new MeminitializeridContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_meminitializerid);
		try {
			setState(1844);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1842);
				classOrDeclType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1843);
				match(Identifier);
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
	public static class OperatorFunctionIdContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(CPP14Parser.Operator, 0); }
		public TheOperatorContext theOperator() {
			return getRuleContext(TheOperatorContext.class,0);
		}
		public OperatorFunctionIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorFunctionId; }
	}

	public final OperatorFunctionIdContext operatorFunctionId() throws RecognitionException {
		OperatorFunctionIdContext _localctx = new OperatorFunctionIdContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_operatorFunctionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1846);
			match(Operator);
			setState(1847);
			theOperator();
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
	public static class LiteralOperatorIdContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(CPP14Parser.Operator, 0); }
		public TerminalNode StringLiteral() { return getToken(CPP14Parser.StringLiteral, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TerminalNode UserDefinedStringLiteral() { return getToken(CPP14Parser.UserDefinedStringLiteral, 0); }
		public LiteralOperatorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalOperatorId; }
	}

	public final LiteralOperatorIdContext literalOperatorId() throws RecognitionException {
		LiteralOperatorIdContext _localctx = new LiteralOperatorIdContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_literalOperatorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1849);
			match(Operator);
			setState(1853);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
				{
				setState(1850);
				match(StringLiteral);
				setState(1851);
				match(Identifier);
				}
				break;
			case UserDefinedStringLiteral:
				{
				setState(1852);
				match(UserDefinedStringLiteral);
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
	public static class TemplateDeclarationContext extends ParserRuleContext {
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TemplateparameterListContext templateparameterList() {
			return getRuleContext(TemplateparameterListContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TemplateDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateDeclaration; }
	}

	public final TemplateDeclarationContext templateDeclaration() throws RecognitionException {
		TemplateDeclarationContext _localctx = new TemplateDeclarationContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_templateDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1855);
			match(Template);
			setState(1856);
			match(Less);
			setState(1857);
			templateparameterList();
			setState(1858);
			match(Greater);
			setState(1859);
			declaration();
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
	public static class TemplateparameterListContext extends ParserRuleContext {
		public List<TemplateParameterContext> templateParameter() {
			return getRuleContexts(TemplateParameterContext.class);
		}
		public TemplateParameterContext templateParameter(int i) {
			return getRuleContext(TemplateParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public TemplateparameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateparameterList; }
	}

	public final TemplateparameterListContext templateparameterList() throws RecognitionException {
		TemplateparameterListContext _localctx = new TemplateparameterListContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_templateparameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1861);
			templateParameter();
			setState(1866);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1862);
				match(Comma);
				setState(1863);
				templateParameter();
				}
				}
				setState(1868);
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
	public static class TemplateParameterContext extends ParserRuleContext {
		public TypeParameterContext typeParameter() {
			return getRuleContext(TypeParameterContext.class,0);
		}
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public TemplateParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateParameter; }
	}

	public final TemplateParameterContext templateParameter() throws RecognitionException {
		TemplateParameterContext _localctx = new TemplateParameterContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_templateParameter);
		try {
			setState(1871);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1869);
				typeParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1870);
				parameterDeclaration();
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
	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(CPP14Parser.Class, 0); }
		public TerminalNode Typename_() { return getToken(CPP14Parser.Typename_, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TemplateparameterListContext templateparameterList() {
			return getRuleContext(TemplateparameterListContext.class,0);
		}
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Template:
				{
				setState(1878);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1873);
					match(Template);
					setState(1874);
					match(Less);
					setState(1875);
					templateparameterList();
					setState(1876);
					match(Greater);
					}
				}

				setState(1880);
				match(Class);
				}
				break;
			case Typename_:
				{
				setState(1881);
				match(Typename_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1895);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(1885);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1884);
					match(Ellipsis);
					}
				}

				setState(1888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1887);
					match(Identifier);
					}
				}

				}
				break;
			case 2:
				{
				setState(1891);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1890);
					match(Identifier);
					}
				}

				setState(1893);
				match(Assign);
				setState(1894);
				theTypeId();
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
	public static class SimpleTemplateIdContext extends ParserRuleContext {
		public TemplateNameContext templateName() {
			return getRuleContext(TemplateNameContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public TemplateArgumentListContext templateArgumentList() {
			return getRuleContext(TemplateArgumentListContext.class,0);
		}
		public SimpleTemplateIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTemplateId; }
	}

	public final SimpleTemplateIdContext simpleTemplateId() throws RecognitionException {
		SimpleTemplateIdContext _localctx = new SimpleTemplateIdContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_simpleTemplateId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1897);
			templateName();
			setState(1898);
			match(Less);
			setState(1900);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4182489736465495294L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4719772474384268307L) != 0) || _la==Identifier) {
				{
				setState(1899);
				templateArgumentList();
				}
			}

			setState(1902);
			match(Greater);
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
	public static class TemplateIdContext extends ParserRuleContext {
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public OperatorFunctionIdContext operatorFunctionId() {
			return getRuleContext(OperatorFunctionIdContext.class,0);
		}
		public LiteralOperatorIdContext literalOperatorId() {
			return getRuleContext(LiteralOperatorIdContext.class,0);
		}
		public TemplateArgumentListContext templateArgumentList() {
			return getRuleContext(TemplateArgumentListContext.class,0);
		}
		public TemplateIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateId; }
	}

	public final TemplateIdContext templateId() throws RecognitionException {
		TemplateIdContext _localctx = new TemplateIdContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_templateId);
		int _la;
		try {
			setState(1915);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1904);
				simpleTemplateId();
				}
				break;
			case Operator:
				enterOuterAlt(_localctx, 2);
				{
				setState(1907);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
				case 1:
					{
					setState(1905);
					operatorFunctionId();
					}
					break;
				case 2:
					{
					setState(1906);
					literalOperatorId();
					}
					break;
				}
				setState(1909);
				match(Less);
				setState(1911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4182489736465495294L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 4719772474384268307L) != 0) || _la==Identifier) {
					{
					setState(1910);
					templateArgumentList();
					}
				}

				setState(1913);
				match(Greater);
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
	public static class TemplateNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public TemplateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateName; }
	}

	public final TemplateNameContext templateName() throws RecognitionException {
		TemplateNameContext _localctx = new TemplateNameContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_templateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1917);
			match(Identifier);
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
	public static class TemplateArgumentListContext extends ParserRuleContext {
		public List<TemplateArgumentContext> templateArgument() {
			return getRuleContexts(TemplateArgumentContext.class);
		}
		public TemplateArgumentContext templateArgument(int i) {
			return getRuleContext(TemplateArgumentContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPP14Parser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPP14Parser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public TemplateArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateArgumentList; }
	}

	public final TemplateArgumentListContext templateArgumentList() throws RecognitionException {
		TemplateArgumentListContext _localctx = new TemplateArgumentListContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_templateArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1919);
			templateArgument();
			setState(1921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1920);
				match(Ellipsis);
				}
			}

			setState(1930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1923);
				match(Comma);
				setState(1924);
				templateArgument();
				setState(1926);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1925);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1932);
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
	public static class TemplateArgumentContext extends ParserRuleContext {
		public TheTypeIdContext theTypeId() {
			return getRuleContext(TheTypeIdContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public TemplateArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateArgument; }
	}

	public final TemplateArgumentContext templateArgument() throws RecognitionException {
		TemplateArgumentContext _localctx = new TemplateArgumentContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_templateArgument);
		try {
			setState(1936);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1933);
				theTypeId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1934);
				constantExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1935);
				idExpression();
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
	public static class TypeNameSpecifierContext extends ParserRuleContext {
		public TerminalNode Typename_() { return getToken(CPP14Parser.Typename_, 0); }
		public NestedNameSpecifierContext nestedNameSpecifier() {
			return getRuleContext(NestedNameSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CPP14Parser.Identifier, 0); }
		public SimpleTemplateIdContext simpleTemplateId() {
			return getRuleContext(SimpleTemplateIdContext.class,0);
		}
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TypeNameSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNameSpecifier; }
	}

	public final TypeNameSpecifierContext typeNameSpecifier() throws RecognitionException {
		TypeNameSpecifierContext _localctx = new TypeNameSpecifierContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_typeNameSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1938);
			match(Typename_);
			setState(1939);
			nestedNameSpecifier(0);
			setState(1945);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
			case 1:
				{
				setState(1940);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(1942);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1941);
					match(Template);
					}
				}

				setState(1944);
				simpleTemplateId();
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
	public static class ExplicitInstantiationContext extends ParserRuleContext {
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Extern() { return getToken(CPP14Parser.Extern, 0); }
		public ExplicitInstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitInstantiation; }
	}

	public final ExplicitInstantiationContext explicitInstantiation() throws RecognitionException {
		ExplicitInstantiationContext _localctx = new ExplicitInstantiationContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_explicitInstantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1948);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Extern) {
				{
				setState(1947);
				match(Extern);
				}
			}

			setState(1950);
			match(Template);
			setState(1951);
			declaration();
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
	public static class ExplicitSpecializationContext extends ParserRuleContext {
		public TerminalNode Template() { return getToken(CPP14Parser.Template, 0); }
		public TerminalNode Less() { return getToken(CPP14Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPP14Parser.Greater, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExplicitSpecializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitSpecialization; }
	}

	public final ExplicitSpecializationContext explicitSpecialization() throws RecognitionException {
		ExplicitSpecializationContext _localctx = new ExplicitSpecializationContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_explicitSpecialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1953);
			match(Template);
			setState(1954);
			match(Less);
			setState(1955);
			match(Greater);
			setState(1956);
			declaration();
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
	public static class TryBlockContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(CPP14Parser.Try, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public HandlerSeqContext handlerSeq() {
			return getRuleContext(HandlerSeqContext.class,0);
		}
		public TryBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryBlock; }
	}

	public final TryBlockContext tryBlock() throws RecognitionException {
		TryBlockContext _localctx = new TryBlockContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_tryBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1958);
			match(Try);
			setState(1959);
			compoundStatement();
			setState(1960);
			handlerSeq();
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
	public static class FunctionTryBlockContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(CPP14Parser.Try, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public HandlerSeqContext handlerSeq() {
			return getRuleContext(HandlerSeqContext.class,0);
		}
		public ConstructorInitializerContext constructorInitializer() {
			return getRuleContext(ConstructorInitializerContext.class,0);
		}
		public FunctionTryBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTryBlock; }
	}

	public final FunctionTryBlockContext functionTryBlock() throws RecognitionException {
		FunctionTryBlockContext _localctx = new FunctionTryBlockContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_functionTryBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1962);
			match(Try);
			setState(1964);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1963);
				constructorInitializer();
				}
			}

			setState(1966);
			compoundStatement();
			setState(1967);
			handlerSeq();
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
	public static class HandlerSeqContext extends ParserRuleContext {
		public List<HandlerContext> handler() {
			return getRuleContexts(HandlerContext.class);
		}
		public HandlerContext handler(int i) {
			return getRuleContext(HandlerContext.class,i);
		}
		public HandlerSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handlerSeq; }
	}

	public final HandlerSeqContext handlerSeq() throws RecognitionException {
		HandlerSeqContext _localctx = new HandlerSeqContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_handlerSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1970); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1969);
				handler();
				}
				}
				setState(1972); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Catch );
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
	public static class HandlerContext extends ParserRuleContext {
		public TerminalNode Catch() { return getToken(CPP14Parser.Catch, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ExceptionDeclarationContext exceptionDeclaration() {
			return getRuleContext(ExceptionDeclarationContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public HandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handler; }
	}

	public final HandlerContext handler() throws RecognitionException {
		HandlerContext _localctx = new HandlerContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_handler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1974);
			match(Catch);
			setState(1975);
			match(LeftParen);
			setState(1976);
			exceptionDeclaration();
			setState(1977);
			match(RightParen);
			setState(1978);
			compoundStatement();
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
	public static class ExceptionDeclarationContext extends ParserRuleContext {
		public TypeSpecifierSeqContext typeSpecifierSeq() {
			return getRuleContext(TypeSpecifierSeqContext.class,0);
		}
		public AttributeSpecifierSeqContext attributeSpecifierSeq() {
			return getRuleContext(AttributeSpecifierSeqContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(CPP14Parser.Ellipsis, 0); }
		public ExceptionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionDeclaration; }
	}

	public final ExceptionDeclarationContext exceptionDeclaration() throws RecognitionException {
		ExceptionDeclarationContext _localctx = new ExceptionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_exceptionDeclaration);
		int _la;
		try {
			setState(1989);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alignas:
			case Auto:
			case Bool:
			case Char:
			case Char16:
			case Char32:
			case Class:
			case Const:
			case Decltype:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Struct:
			case Typename_:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Wchar:
			case LeftBracket:
			case Doublecolon:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1981);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1980);
					attributeSpecifierSeq();
					}
				}

				setState(1983);
				typeSpecifierSeq();
				setState(1986);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,282,_ctx) ) {
				case 1:
					{
					setState(1984);
					declarator();
					}
					break;
				case 2:
					{
					setState(1985);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			case Ellipsis:
				enterOuterAlt(_localctx, 2);
				{
				setState(1988);
				match(Ellipsis);
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
	public static class ThrowExpressionContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(CPP14Parser.Throw, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ThrowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwExpression; }
	}

	public final ThrowExpressionContext throwExpression() throws RecognitionException {
		ThrowExpressionContext _localctx = new ThrowExpressionContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_throwExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1991);
			match(Throw);
			setState(1993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -7132127170771084673L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & -8928386257205767483L) != 0)) {
				{
				setState(1992);
				assignmentExpression();
				}
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
	public static class ExceptionSpecificationContext extends ParserRuleContext {
		public DynamicExceptionSpecificationContext dynamicExceptionSpecification() {
			return getRuleContext(DynamicExceptionSpecificationContext.class,0);
		}
		public NoeExceptSpecificationContext noeExceptSpecification() {
			return getRuleContext(NoeExceptSpecificationContext.class,0);
		}
		public ExceptionSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionSpecification; }
	}

	public final ExceptionSpecificationContext exceptionSpecification() throws RecognitionException {
		ExceptionSpecificationContext _localctx = new ExceptionSpecificationContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_exceptionSpecification);
		try {
			setState(1997);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Throw:
				enterOuterAlt(_localctx, 1);
				{
				setState(1995);
				dynamicExceptionSpecification();
				}
				break;
			case Noexcept:
				enterOuterAlt(_localctx, 2);
				{
				setState(1996);
				noeExceptSpecification();
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
	public static class DynamicExceptionSpecificationContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(CPP14Parser.Throw, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TypeIdListContext typeIdList() {
			return getRuleContext(TypeIdListContext.class,0);
		}
		public DynamicExceptionSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dynamicExceptionSpecification; }
	}

	public final DynamicExceptionSpecificationContext dynamicExceptionSpecification() throws RecognitionException {
		DynamicExceptionSpecificationContext _localctx = new DynamicExceptionSpecificationContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_dynamicExceptionSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1999);
			match(Throw);
			setState(2000);
			match(LeftParen);
			setState(2002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & -9213942612181769245L) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & 37154696925806707L) != 0)) {
				{
				setState(2001);
				typeIdList();
				}
			}

			setState(2004);
			match(RightParen);
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
	public static class TypeIdListContext extends ParserRuleContext {
		public List<TheTypeIdContext> theTypeId() {
			return getRuleContexts(TheTypeIdContext.class);
		}
		public TheTypeIdContext theTypeId(int i) {
			return getRuleContext(TheTypeIdContext.class,i);
		}
		public List<TerminalNode> Ellipsis() { return getTokens(CPP14Parser.Ellipsis); }
		public TerminalNode Ellipsis(int i) {
			return getToken(CPP14Parser.Ellipsis, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPP14Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPP14Parser.Comma, i);
		}
		public TypeIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdList; }
	}

	public final TypeIdListContext typeIdList() throws RecognitionException {
		TypeIdListContext _localctx = new TypeIdListContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2006);
			theTypeId();
			setState(2008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(2007);
				match(Ellipsis);
				}
			}

			setState(2017);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2010);
				match(Comma);
				setState(2011);
				theTypeId();
				setState(2013);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(2012);
					match(Ellipsis);
					}
				}

				}
				}
				setState(2019);
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
	public static class NoeExceptSpecificationContext extends ParserRuleContext {
		public TerminalNode Noexcept() { return getToken(CPP14Parser.Noexcept, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public NoeExceptSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noeExceptSpecification; }
	}

	public final NoeExceptSpecificationContext noeExceptSpecification() throws RecognitionException {
		NoeExceptSpecificationContext _localctx = new NoeExceptSpecificationContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_noeExceptSpecification);
		try {
			setState(2026);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2020);
				match(Noexcept);
				setState(2021);
				match(LeftParen);
				setState(2022);
				constantExpression();
				setState(2023);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2025);
				match(Noexcept);
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
	public static class TheOperatorContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(CPP14Parser.New, 0); }
		public TerminalNode LeftBracket() { return getToken(CPP14Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPP14Parser.RightBracket, 0); }
		public TerminalNode Delete() { return getToken(CPP14Parser.Delete, 0); }
		public TerminalNode Plus() { return getToken(CPP14Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CPP14Parser.Minus, 0); }
		public TerminalNode Star() { return getToken(CPP14Parser.Star, 0); }
		public TerminalNode Div() { return getToken(CPP14Parser.Div, 0); }
		public TerminalNode Mod() { return getToken(CPP14Parser.Mod, 0); }
		public TerminalNode Caret() { return getToken(CPP14Parser.Caret, 0); }
		public TerminalNode And() { return getToken(CPP14Parser.And, 0); }
		public TerminalNode Or() { return getToken(CPP14Parser.Or, 0); }
		public TerminalNode Tilde() { return getToken(CPP14Parser.Tilde, 0); }
		public TerminalNode Not() { return getToken(CPP14Parser.Not, 0); }
		public TerminalNode Assign() { return getToken(CPP14Parser.Assign, 0); }
		public List<TerminalNode> Greater() { return getTokens(CPP14Parser.Greater); }
		public TerminalNode Greater(int i) {
			return getToken(CPP14Parser.Greater, i);
		}
		public List<TerminalNode> Less() { return getTokens(CPP14Parser.Less); }
		public TerminalNode Less(int i) {
			return getToken(CPP14Parser.Less, i);
		}
		public TerminalNode GreaterEqual() { return getToken(CPP14Parser.GreaterEqual, 0); }
		public TerminalNode PlusAssign() { return getToken(CPP14Parser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPP14Parser.MinusAssign, 0); }
		public TerminalNode StarAssign() { return getToken(CPP14Parser.StarAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPP14Parser.ModAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPP14Parser.XorAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPP14Parser.AndAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPP14Parser.OrAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPP14Parser.RightShiftAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPP14Parser.LeftShiftAssign, 0); }
		public TerminalNode Equal() { return getToken(CPP14Parser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CPP14Parser.NotEqual, 0); }
		public TerminalNode LessEqual() { return getToken(CPP14Parser.LessEqual, 0); }
		public TerminalNode AndAnd() { return getToken(CPP14Parser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(CPP14Parser.OrOr, 0); }
		public TerminalNode PlusPlus() { return getToken(CPP14Parser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPP14Parser.MinusMinus, 0); }
		public TerminalNode Comma() { return getToken(CPP14Parser.Comma, 0); }
		public TerminalNode ArrowStar() { return getToken(CPP14Parser.ArrowStar, 0); }
		public TerminalNode Arrow() { return getToken(CPP14Parser.Arrow, 0); }
		public TerminalNode LeftParen() { return getToken(CPP14Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPP14Parser.RightParen, 0); }
		public TheOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theOperator; }
	}

	public final TheOperatorContext theOperator() throws RecognitionException {
		TheOperatorContext _localctx = new TheOperatorContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_theOperator);
		try {
			setState(2079);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2028);
				match(New);
				setState(2031);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
				case 1:
					{
					setState(2029);
					match(LeftBracket);
					setState(2030);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2033);
				match(Delete);
				setState(2036);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
				case 1:
					{
					setState(2034);
					match(LeftBracket);
					setState(2035);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2038);
				match(Plus);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2039);
				match(Minus);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2040);
				match(Star);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2041);
				match(Div);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2042);
				match(Mod);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2043);
				match(Caret);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2044);
				match(And);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2045);
				match(Or);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2046);
				match(Tilde);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2047);
				match(Not);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2048);
				match(Assign);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2049);
				match(Greater);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2050);
				match(Less);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(2051);
				match(GreaterEqual);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(2052);
				match(PlusAssign);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(2053);
				match(MinusAssign);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(2054);
				match(StarAssign);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(2055);
				match(ModAssign);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(2056);
				match(XorAssign);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(2057);
				match(AndAssign);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(2058);
				match(OrAssign);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(2059);
				match(Less);
				setState(2060);
				match(Less);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(2061);
				match(Greater);
				setState(2062);
				match(Greater);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(2063);
				match(RightShiftAssign);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(2064);
				match(LeftShiftAssign);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(2065);
				match(Equal);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(2066);
				match(NotEqual);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(2067);
				match(LessEqual);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(2068);
				match(AndAnd);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(2069);
				match(OrOr);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(2070);
				match(PlusPlus);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(2071);
				match(MinusMinus);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(2072);
				match(Comma);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(2073);
				match(ArrowStar);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(2074);
				match(Arrow);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(2075);
				match(LeftParen);
				setState(2076);
				match(RightParen);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(2077);
				match(LeftBracket);
				setState(2078);
				match(RightBracket);
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(CPP14Parser.IntegerLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(CPP14Parser.CharacterLiteral, 0); }
		public TerminalNode FloatingLiteral() { return getToken(CPP14Parser.FloatingLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(CPP14Parser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(CPP14Parser.BooleanLiteral, 0); }
		public TerminalNode PointerLiteral() { return getToken(CPP14Parser.PointerLiteral, 0); }
		public TerminalNode UserDefinedLiteral() { return getToken(CPP14Parser.UserDefinedLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2081);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return nestedNameSpecifier_sempred((NestedNameSpecifierContext)_localctx, predIndex);
		case 15:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 25:
			return noPointerNewDeclarator_sempred((NoPointerNewDeclaratorContext)_localctx, predIndex);
		case 115:
			return noPointerDeclarator_sempred((NoPointerDeclaratorContext)_localctx, predIndex);
		case 126:
			return noPointerAbstractDeclarator_sempred((NoPointerAbstractDeclaratorContext)_localctx, predIndex);
		case 128:
			return noPointerAbstractPackDeclarator_sempred((NoPointerAbstractPackDeclaratorContext)_localctx, predIndex);
		case 148:
			return memberDeclarator_sempred((MemberDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean nestedNameSpecifier_sempred(NestedNameSpecifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean noPointerNewDeclarator_sempred(NoPointerNewDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean noPointerDeclarator_sempred(NoPointerDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean noPointerAbstractDeclarator_sempred(NoPointerAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean noPointerAbstractPackDeclarator_sempred(NoPointerAbstractPackDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean memberDeclarator_sempred(MemberDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return  IsPureSpecifierAllowed() ;
		case 10:
			return  IsPureSpecifierAllowed() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0090\u0824\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"+
		"\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007"+
		"\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007"+
		"\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007"+
		"\u0095\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097\u0002\u0098\u0007"+
		"\u0098\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a\u0002\u009b\u0007"+
		"\u009b\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d\u0002\u009e\u0007"+
		"\u009e\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0\u0002\u00a1\u0007"+
		"\u00a1\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3\u0002\u00a4\u0007"+
		"\u00a4\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6\u0002\u00a7\u0007"+
		"\u00a7\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9\u0002\u00aa\u0007"+
		"\u00aa\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac\u0002\u00ad\u0007"+
		"\u00ad\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af\u0002\u00b0\u0007"+
		"\u00b0\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2\u0002\u00b3\u0007"+
		"\u00b3\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5\u0002\u00b6\u0007"+
		"\u00b6\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8\u0002\u00b9\u0007"+
		"\u00b9\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb\u0002\u00bc\u0007"+
		"\u00bc\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be\u0001\u0000\u0005"+
		"\u0000\u0180\b\u0000\n\u0000\f\u0000\u0183\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0004\u0001\u0188\b\u0001\u000b\u0001\f\u0001\u0189\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u0193\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002\u0197"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u01a0\b\u0003\u0001\u0003\u0003\u0003\u01a3"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u01a7\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u01af\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u01b6\b\u0005\u0001\u0005\u0003\u0005\u01b9\b\u0005\u0001"+
		"\u0005\u0005\u0005\u01bc\b\u0005\n\u0005\f\u0005\u01bf\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u01c3\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u01c9\b\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\u01d1\b\b\u0003\b\u01d3\b\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0005\n\u01da\b\n\n\n\f\n\u01dd\t\n\u0001\n"+
		"\u0003\n\u01e0\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u01e4\b\u000b\u0001"+
		"\f\u0003\f\u01e7\b\f\u0001\f\u0001\f\u0003\f\u01eb\b\f\u0001\r\u0003\r"+
		"\u01ee\b\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u01f5\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01f9\b\u000e\u0001"+
		"\u000e\u0003\u000e\u01fc\b\u000e\u0001\u000e\u0003\u000e\u01ff\b\u000e"+
		"\u0001\u000e\u0003\u000e\u0202\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0208\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u020c\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0210\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u021e\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0222\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0228\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u022f\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0235\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0239\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u023d\b\u000f\n\u000f\f\u000f\u0240\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0003\u0012"+
		"\u0247\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u024c\b"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u0259\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0260\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u026c\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0276"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0003\u0015\u027b\b\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u027f\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0286\b\u0015\u0001\u0015"+
		"\u0003\u0015\u0289\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u0291\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0295\b\u0018\u0001\u0018\u0003\u0018\u0298\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u029f"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u02a6\b\u0019\u0005\u0019\u02a8\b\u0019\n\u0019\f\u0019\u02ab\t"+
		"\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u02af\b\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u02b3\b\u001a\u0001\u001b\u0003\u001b\u02b6\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u02bb\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u02ca\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u02cf\b\u001e\n\u001e\f\u001e\u02d2\t\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0005\u001f\u02d7\b\u001f\n\u001f\f\u001f\u02da\t\u001f\u0001 "+
		"\u0001 \u0001 \u0005 \u02df\b \n \f \u02e2\t \u0001!\u0001!\u0001!\u0001"+
		"!\u0005!\u02e8\b!\n!\f!\u02eb\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0003"+
		"\"\u02f1\b\"\u0001#\u0001#\u0001#\u0005#\u02f6\b#\n#\f#\u02f9\t#\u0001"+
		"$\u0001$\u0001$\u0005$\u02fe\b$\n$\f$\u0301\t$\u0001%\u0001%\u0001%\u0005"+
		"%\u0306\b%\n%\f%\u0309\t%\u0001&\u0001&\u0001&\u0005&\u030e\b&\n&\f&\u0311"+
		"\t&\u0001\'\u0001\'\u0001\'\u0005\'\u0316\b\'\n\'\f\'\u0319\t\'\u0001"+
		"(\u0001(\u0001(\u0005(\u031e\b(\n(\f(\u0321\t(\u0001)\u0001)\u0001)\u0005"+
		")\u0326\b)\n)\f)\u0329\t)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u0331\b*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u0339\b+\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0005-\u0340\b-\n-\f-\u0343\t-\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0003/\u034a\b/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0003/\u0352\b/\u0003/\u0354\b/\u00010\u00030\u0357\b0\u0001"+
		"0\u00010\u00010\u00010\u00030\u035d\b0\u00010\u00010\u00010\u00011\u0003"+
		"1\u0363\b1\u00011\u00011\u00012\u00012\u00032\u0369\b2\u00012\u00012\u0001"+
		"3\u00043\u036e\b3\u000b3\f3\u036f\u00014\u00014\u00014\u00014\u00014\u0001"+
		"4\u00014\u00034\u0379\b4\u00014\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u0381\b4\u00015\u00015\u00035\u0385\b5\u00015\u00015\u00015\u00015\u0001"+
		"5\u00035\u038c\b5\u00035\u038e\b5\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00036\u03a2\b6\u00016\u00016\u00036\u03a6\b6\u00016\u0001"+
		"6\u00016\u00016\u00036\u03ac\b6\u00016\u00016\u00016\u00036\u03b1\b6\u0001"+
		"7\u00017\u00037\u03b5\b7\u00018\u00038\u03b8\b8\u00018\u00018\u00018\u0001"+
		"9\u00019\u00039\u03bf\b9\u0001:\u0001:\u0001:\u0001:\u0001:\u0003:\u03c6"+
		"\b:\u0001:\u0001:\u0003:\u03ca\b:\u0001:\u0001:\u0001;\u0001;\u0001<\u0004"+
		"<\u03d1\b<\u000b<\f<\u03d2\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0003=\u03de\b=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001>\u0003>\u03e8\b>\u0001?\u0001?\u0001?\u0003?\u03ed\b?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001@\u0003@\u03f4\b@\u0001@\u0003@\u03f7\b@\u0001"+
		"@\u0001@\u0001@\u0003@\u03fc\b@\u0001@\u0001@\u0001@\u0003@\u0401\b@\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001"+
		"C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0003D\u0416"+
		"\bD\u0001E\u0004E\u0419\bE\u000bE\fE\u041a\u0001E\u0003E\u041e\bE\u0001"+
		"F\u0001F\u0001G\u0001G\u0001H\u0001H\u0001I\u0001I\u0001I\u0003I\u0429"+
		"\bI\u0001J\u0001J\u0001J\u0001J\u0003J\u042f\bJ\u0001K\u0004K\u0432\b"+
		"K\u000bK\fK\u0433\u0001K\u0003K\u0437\bK\u0001L\u0004L\u043a\bL\u000b"+
		"L\fL\u043b\u0001L\u0003L\u043f\bL\u0001M\u0001M\u0001N\u0001N\u0001O\u0003"+
		"O\u0446\bO\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0003O\u045d\bO\u0001P\u0001P\u0001P\u0001P\u0003P\u0463"+
		"\bP\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u0469\bQ\u0001Q\u0001Q\u0001R\u0001"+
		"R\u0003R\u046f\bR\u0001R\u0003R\u0472\bR\u0001R\u0001R\u0001R\u0001R\u0003"+
		"R\u0478\bR\u0001R\u0001R\u0003R\u047c\bR\u0001R\u0001R\u0003R\u0480\b"+
		"R\u0001R\u0003R\u0483\bR\u0001S\u0001S\u0001T\u0001T\u0001T\u0001T\u0003"+
		"T\u048b\bT\u0003T\u048d\bT\u0001T\u0001T\u0001U\u0001U\u0003U\u0493\b"+
		"U\u0001U\u0003U\u0496\bU\u0001U\u0003U\u0499\bU\u0001U\u0003U\u049c\b"+
		"U\u0001V\u0001V\u0003V\u04a0\bV\u0001V\u0001V\u0003V\u04a4\bV\u0001V\u0001"+
		"V\u0001W\u0001W\u0003W\u04aa\bW\u0001X\u0001X\u0001X\u0001Y\u0001Y\u0001"+
		"Y\u0005Y\u04b2\bY\nY\fY\u04b5\tY\u0001Z\u0001Z\u0001Z\u0003Z\u04ba\bZ"+
		"\u0001[\u0001[\u0001\\\u0001\\\u0003\\\u04c0\b\\\u0001]\u0001]\u0001^"+
		"\u0003^\u04c5\b^\u0001^\u0001^\u0001^\u0003^\u04ca\b^\u0001^\u0001^\u0003"+
		"^\u04ce\b^\u0001^\u0001^\u0001_\u0001_\u0001`\u0001`\u0001`\u0001`\u0001"+
		"`\u0001`\u0001a\u0003a\u04db\ba\u0001a\u0001a\u0001b\u0001b\u0003b\u04e1"+
		"\bb\u0001b\u0001b\u0003b\u04e5\bb\u0001b\u0001b\u0001b\u0001c\u0003c\u04eb"+
		"\bc\u0001c\u0001c\u0001c\u0003c\u04f0\bc\u0001c\u0001c\u0001c\u0001d\u0001"+
		"d\u0001d\u0001d\u0001d\u0001d\u0001e\u0001e\u0001e\u0001e\u0003e\u04ff"+
		"\be\u0001e\u0001e\u0003e\u0503\be\u0001f\u0004f\u0506\bf\u000bf\ff\u0507"+
		"\u0001g\u0001g\u0001g\u0003g\u050d\bg\u0001g\u0001g\u0001g\u0003g\u0512"+
		"\bg\u0001h\u0001h\u0001h\u0001h\u0003h\u0518\bh\u0001h\u0003h\u051b\b"+
		"h\u0001h\u0001h\u0001i\u0001i\u0001i\u0005i\u0522\bi\ni\fi\u0525\ti\u0001"+
		"i\u0003i\u0528\bi\u0001j\u0001j\u0001j\u0003j\u052d\bj\u0001j\u0001j\u0003"+
		"j\u0531\bj\u0001k\u0001k\u0001l\u0001l\u0003l\u0537\bl\u0001l\u0001l\u0001"+
		"m\u0004m\u053c\bm\u000bm\fm\u053d\u0001n\u0001n\u0001n\u0001n\u0001n\u0001"+
		"n\u0001n\u0001n\u0001n\u0001n\u0001n\u0001n\u0001n\u0004n\u054d\bn\u000b"+
		"n\fn\u054e\u0003n\u0551\bn\u0001o\u0001o\u0001o\u0005o\u0556\bo\no\fo"+
		"\u0559\to\u0001p\u0001p\u0003p\u055d\bp\u0001q\u0001q\u0001q\u0001q\u0001"+
		"q\u0003q\u0564\bq\u0001r\u0001r\u0003r\u0568\br\u0005r\u056a\br\nr\fr"+
		"\u056d\tr\u0001r\u0001r\u0001s\u0001s\u0001s\u0003s\u0574\bs\u0001s\u0001"+
		"s\u0001s\u0001s\u0003s\u057a\bs\u0001s\u0001s\u0001s\u0001s\u0003s\u0580"+
		"\bs\u0001s\u0001s\u0003s\u0584\bs\u0003s\u0586\bs\u0005s\u0588\bs\ns\f"+
		"s\u058b\ts\u0001t\u0001t\u0003t\u058f\bt\u0001t\u0001t\u0003t\u0593\b"+
		"t\u0001t\u0003t\u0596\bt\u0001t\u0003t\u0599\bt\u0001t\u0003t\u059c\b"+
		"t\u0001u\u0001u\u0001u\u0003u\u05a1\bu\u0001v\u0001v\u0003v\u05a5\bv\u0001"+
		"v\u0003v\u05a8\bv\u0001v\u0001v\u0003v\u05ac\bv\u0001v\u0003v\u05af\b"+
		"v\u0003v\u05b1\bv\u0001w\u0004w\u05b4\bw\u000bw\fw\u05b5\u0001x\u0001"+
		"x\u0001y\u0001y\u0001z\u0003z\u05bd\bz\u0001z\u0001z\u0001{\u0001{\u0003"+
		"{\u05c3\b{\u0001|\u0001|\u0003|\u05c7\b|\u0001|\u0001|\u0001|\u0001|\u0003"+
		"|\u05cd\b|\u0001}\u0001}\u0004}\u05d1\b}\u000b}\f}\u05d2\u0001}\u0003"+
		"}\u05d6\b}\u0003}\u05d8\b}\u0001~\u0001~\u0001~\u0001~\u0003~\u05de\b"+
		"~\u0001~\u0001~\u0003~\u05e2\b~\u0001~\u0001~\u0001~\u0001~\u0003~\u05e8"+
		"\b~\u0001~\u0001~\u0001~\u0001~\u0001~\u0003~\u05ef\b~\u0001~\u0001~\u0003"+
		"~\u05f3\b~\u0003~\u05f5\b~\u0005~\u05f7\b~\n~\f~\u05fa\t~\u0001\u007f"+
		"\u0005\u007f\u05fd\b\u007f\n\u007f\f\u007f\u0600\t\u007f\u0001\u007f\u0001"+
		"\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001"+
		"\u0080\u0001\u0080\u0003\u0080\u060b\b\u0080\u0001\u0080\u0001\u0080\u0003"+
		"\u0080\u060f\b\u0080\u0003\u0080\u0611\b\u0080\u0005\u0080\u0613\b\u0080"+
		"\n\u0080\f\u0080\u0616\t\u0080\u0001\u0081\u0001\u0081\u0003\u0081\u061a"+
		"\b\u0081\u0001\u0081\u0003\u0081\u061d\b\u0081\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0005\u0082\u0622\b\u0082\n\u0082\f\u0082\u0625\t\u0082\u0001"+
		"\u0083\u0003\u0083\u0628\b\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0003"+
		"\u0083\u062d\b\u0083\u0003\u0083\u062f\b\u0083\u0001\u0083\u0001\u0083"+
		"\u0003\u0083\u0633\b\u0083\u0001\u0084\u0003\u0084\u0636\b\u0084\u0001"+
		"\u0084\u0003\u0084\u0639\b\u0084\u0001\u0084\u0001\u0084\u0003\u0084\u063d"+
		"\b\u0084\u0001\u0084\u0001\u0084\u0001\u0085\u0003\u0085\u0642\b\u0085"+
		"\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0003\u0085"+
		"\u0649\b\u0085\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086"+
		"\u0003\u0086\u0650\b\u0086\u0001\u0087\u0001\u0087\u0001\u0087\u0003\u0087"+
		"\u0655\b\u0087\u0001\u0088\u0001\u0088\u0003\u0088\u0659\b\u0088\u0001"+
		"\u0089\u0001\u0089\u0003\u0089\u065d\b\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0003\u0089\u0662\b\u0089\u0005\u0089\u0664\b\u0089\n\u0089\f\u0089"+
		"\u0667\t\u0089\u0001\u008a\u0001\u008a\u0001\u008a\u0003\u008a\u066c\b"+
		"\u008a\u0003\u008a\u066e\b\u008a\u0001\u008a\u0001\u008a\u0001\u008b\u0001"+
		"\u008b\u0003\u008b\u0674\b\u008b\u0001\u008c\u0001\u008c\u0001\u008c\u0003"+
		"\u008c\u0679\b\u008c\u0001\u008c\u0001\u008c\u0001\u008d\u0001\u008d\u0003"+
		"\u008d\u067f\b\u008d\u0001\u008d\u0001\u008d\u0003\u008d\u0683\b\u008d"+
		"\u0003\u008d\u0685\b\u008d\u0001\u008d\u0003\u008d\u0688\b\u008d\u0001"+
		"\u008d\u0001\u008d\u0003\u008d\u068c\b\u008d\u0001\u008d\u0001\u008d\u0003"+
		"\u008d\u0690\b\u008d\u0003\u008d\u0692\b\u008d\u0003\u008d\u0694\b\u008d"+
		"\u0001\u008e\u0003\u008e\u0697\b\u008e\u0001\u008e\u0001\u008e\u0001\u008f"+
		"\u0001\u008f\u0001\u0090\u0001\u0090\u0001\u0091\u0001\u0091\u0001\u0091"+
		"\u0001\u0091\u0004\u0091\u06a3\b\u0091\u000b\u0091\f\u0091\u06a4\u0001"+
		"\u0092\u0003\u0092\u06a8\b\u0092\u0001\u0092\u0003\u0092\u06ab\b\u0092"+
		"\u0001\u0092\u0003\u0092\u06ae\b\u0092\u0001\u0092\u0001\u0092\u0001\u0092"+
		"\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0003\u0092\u06b7\b\u0092"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0005\u0093\u06bc\b\u0093\n\u0093"+
		"\f\u0093\u06bf\t\u0093\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094"+
		"\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0003\u0094"+
		"\u06ca\b\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u06ce\b\u0094\u0001"+
		"\u0094\u0003\u0094\u06d1\b\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u06d5"+
		"\b\u0094\u0001\u0095\u0004\u0095\u06d8\b\u0095\u000b\u0095\f\u0095\u06d9"+
		"\u0001\u0096\u0001\u0096\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0098"+
		"\u0001\u0098\u0001\u0098\u0001\u0099\u0001\u0099\u0003\u0099\u06e6\b\u0099"+
		"\u0001\u0099\u0001\u0099\u0001\u0099\u0003\u0099\u06eb\b\u0099\u0005\u0099"+
		"\u06ed\b\u0099\n\u0099\f\u0099\u06f0\t\u0099\u0001\u009a\u0003\u009a\u06f3"+
		"\b\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0003\u009a\u06f8\b\u009a"+
		"\u0001\u009a\u0001\u009a\u0001\u009a\u0003\u009a\u06fd\b\u009a\u0001\u009a"+
		"\u0001\u009a\u0003\u009a\u0701\b\u009a\u0001\u009b\u0003\u009b\u0704\b"+
		"\u009b\u0001\u009b\u0001\u009b\u0003\u009b\u0708\b\u009b\u0001\u009c\u0001"+
		"\u009c\u0001\u009d\u0001\u009d\u0001\u009e\u0001\u009e\u0001\u009e\u0001"+
		"\u009f\u0001\u009f\u0003\u009f\u0713\b\u009f\u0001\u00a0\u0001\u00a0\u0003"+
		"\u00a0\u0717\b\u00a0\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a2\u0001"+
		"\u00a2\u0003\u00a2\u071e\b\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0003"+
		"\u00a2\u0723\b\u00a2\u0005\u00a2\u0725\b\u00a2\n\u00a2\f\u00a2\u0728\t"+
		"\u00a2\u0001\u00a3\u0001\u00a3\u0001\u00a3\u0003\u00a3\u072d\b\u00a3\u0001"+
		"\u00a3\u0001\u00a3\u0003\u00a3\u0731\b\u00a3\u0001\u00a4\u0001\u00a4\u0003"+
		"\u00a4\u0735\b\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a6\u0001"+
		"\u00a6\u0001\u00a6\u0001\u00a6\u0003\u00a6\u073e\b\u00a6\u0001\u00a7\u0001"+
		"\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a8\u0001"+
		"\u00a8\u0001\u00a8\u0005\u00a8\u0749\b\u00a8\n\u00a8\f\u00a8\u074c\t\u00a8"+
		"\u0001\u00a9\u0001\u00a9\u0003\u00a9\u0750\b\u00a9\u0001\u00aa\u0001\u00aa"+
		"\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0003\u00aa\u0757\b\u00aa\u0001\u00aa"+
		"\u0001\u00aa\u0003\u00aa\u075b\b\u00aa\u0001\u00aa\u0003\u00aa\u075e\b"+
		"\u00aa\u0001\u00aa\u0003\u00aa\u0761\b\u00aa\u0001\u00aa\u0003\u00aa\u0764"+
		"\b\u00aa\u0001\u00aa\u0001\u00aa\u0003\u00aa\u0768\b\u00aa\u0001\u00ab"+
		"\u0001\u00ab\u0001\u00ab\u0003\u00ab\u076d\b\u00ab\u0001\u00ab\u0001\u00ab"+
		"\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac\u0774\b\u00ac\u0001\u00ac"+
		"\u0001\u00ac\u0003\u00ac\u0778\b\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac"+
		"\u077c\b\u00ac\u0001\u00ad\u0001\u00ad\u0001\u00ae\u0001\u00ae\u0003\u00ae"+
		"\u0782\b\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0003\u00ae\u0787\b"+
		"\u00ae\u0005\u00ae\u0789\b\u00ae\n\u00ae\f\u00ae\u078c\t\u00ae\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0003\u00af\u0791\b\u00af\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0003\u00b0\u0797\b\u00b0\u0001\u00b0\u0003\u00b0"+
		"\u079a\b\u00b0\u0001\u00b1\u0003\u00b1\u079d\b\u00b1\u0001\u00b1\u0001"+
		"\u00b1\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b4\u0001"+
		"\u00b4\u0003\u00b4\u07ad\b\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b5\u0004\u00b5\u07b3\b\u00b5\u000b\u00b5\f\u00b5\u07b4\u0001\u00b6"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b7"+
		"\u0003\u00b7\u07be\b\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0003\u00b7"+
		"\u07c3\b\u00b7\u0001\u00b7\u0003\u00b7\u07c6\b\u00b7\u0001\u00b8\u0001"+
		"\u00b8\u0003\u00b8\u07ca\b\u00b8\u0001\u00b9\u0001\u00b9\u0003\u00b9\u07ce"+
		"\b\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba\u07d3\b\u00ba"+
		"\u0001\u00ba\u0001\u00ba\u0001\u00bb\u0001\u00bb\u0003\u00bb\u07d9\b\u00bb"+
		"\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0003\u00bb\u07de\b\u00bb\u0005\u00bb"+
		"\u07e0\b\u00bb\n\u00bb\f\u00bb\u07e3\t\u00bb\u0001\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0003\u00bc\u07eb\b\u00bc\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0003\u00bd\u07f0\b\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0003\u00bd\u07f5\b\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0003\u00bd\u0820\b\u00bd\u0001\u00be\u0001"+
		"\u00be\u0001\u00be\u0001\u041a\u0006\n\u001e2\u00e6\u00fc\u0100\u00bf"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca"+
		"\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2"+
		"\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa"+
		"\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112"+
		"\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a"+
		"\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142"+
		"\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a"+
		"\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172"+
		"\u0174\u0176\u0178\u017a\u017c\u0000\u0017\u0002\u0000``dd\u0004\u0000"+
		"\u0017\u0017\u001e\u001e99@@\u0002\u0000{{\u0080\u0080\u0001\u0000wx\u0002"+
		"\u0000Z\\`c\u0002\u0000zz\u0081\u0081\u0001\u0000\\^\u0001\u0000Z[\u0002"+
		"\u0000efst\u0001\u0000qr\u0002\u0000ddgp\u0005\u0000##..88>>EE\u0003\u0000"+
		"!!++OO\u0002\u0000--;;\u0002\u0000<<MM\u0002\u0000\u0014\u0014AA\u0001"+
		"\u0000TY\u0002\u0000``uu\u0002\u0000\u0015\u0015QQ\u0001\u0000\u001a\u001b"+
		"\u0002\u0000%%44\u0001\u000057\u0001\u0000\u0001\u0007\u0907\u0000\u0181"+
		"\u0001\u0000\u0000\u0000\u0002\u0192\u0001\u0000\u0000\u0000\u0004\u0196"+
		"\u0001\u0000\u0000\u0000\u0006\u01a2\u0001\u0000\u0000\u0000\b\u01a4\u0001"+
		"\u0000\u0000\u0000\n\u01aa\u0001\u0000\u0000\u0000\f\u01c0\u0001\u0000"+
		"\u0000\u0000\u000e\u01c6\u0001\u0000\u0000\u0000\u0010\u01d2\u0001\u0000"+
		"\u0000\u0000\u0012\u01d4\u0001\u0000\u0000\u0000\u0014\u01d6\u0001\u0000"+
		"\u0000\u0000\u0016\u01e3\u0001\u0000\u0000\u0000\u0018\u01ea\u0001\u0000"+
		"\u0000\u0000\u001a\u01ed\u0001\u0000\u0000\u0000\u001c\u01f2\u0001\u0000"+
		"\u0000\u0000\u001e\u0221\u0001\u0000\u0000\u0000 \u0241\u0001\u0000\u0000"+
		"\u0000\"\u0243\u0001\u0000\u0000\u0000$\u0258\u0001\u0000\u0000\u0000"+
		"&\u0275\u0001\u0000\u0000\u0000(\u0277\u0001\u0000\u0000\u0000*\u027a"+
		"\u0001\u0000\u0000\u0000,\u028a\u0001\u0000\u0000\u0000.\u028e\u0001\u0000"+
		"\u0000\u00000\u0297\u0001\u0000\u0000\u00002\u0299\u0001\u0000\u0000\u0000"+
		"4\u02b2\u0001\u0000\u0000\u00006\u02b5\u0001\u0000\u0000\u00008\u02be"+
		"\u0001\u0000\u0000\u0000:\u02c9\u0001\u0000\u0000\u0000<\u02cb\u0001\u0000"+
		"\u0000\u0000>\u02d3\u0001\u0000\u0000\u0000@\u02db\u0001\u0000\u0000\u0000"+
		"B\u02e3\u0001\u0000\u0000\u0000D\u02f0\u0001\u0000\u0000\u0000F\u02f2"+
		"\u0001\u0000\u0000\u0000H\u02fa\u0001\u0000\u0000\u0000J\u0302\u0001\u0000"+
		"\u0000\u0000L\u030a\u0001\u0000\u0000\u0000N\u0312\u0001\u0000\u0000\u0000"+
		"P\u031a\u0001\u0000\u0000\u0000R\u0322\u0001\u0000\u0000\u0000T\u032a"+
		"\u0001\u0000\u0000\u0000V\u0338\u0001\u0000\u0000\u0000X\u033a\u0001\u0000"+
		"\u0000\u0000Z\u033c\u0001\u0000\u0000\u0000\\\u0344\u0001\u0000\u0000"+
		"\u0000^\u0353\u0001\u0000\u0000\u0000`\u0356\u0001\u0000\u0000\u0000b"+
		"\u0362\u0001\u0000\u0000\u0000d\u0366\u0001\u0000\u0000\u0000f\u036d\u0001"+
		"\u0000\u0000\u0000h\u0380\u0001\u0000\u0000\u0000j\u038d\u0001\u0000\u0000"+
		"\u0000l\u03b0\u0001\u0000\u0000\u0000n\u03b4\u0001\u0000\u0000\u0000p"+
		"\u03b7\u0001\u0000\u0000\u0000r\u03be\u0001\u0000\u0000\u0000t\u03c9\u0001"+
		"\u0000\u0000\u0000v\u03cd\u0001\u0000\u0000\u0000x\u03d0\u0001\u0000\u0000"+
		"\u0000z\u03dd\u0001\u0000\u0000\u0000|\u03e7\u0001\u0000\u0000\u0000~"+
		"\u03e9\u0001\u0000\u0000\u0000\u0080\u0400\u0001\u0000\u0000\u0000\u0082"+
		"\u0402\u0001\u0000\u0000\u0000\u0084\u040a\u0001\u0000\u0000\u0000\u0086"+
		"\u040c\u0001\u0000\u0000\u0000\u0088\u0415\u0001\u0000\u0000\u0000\u008a"+
		"\u0418\u0001\u0000\u0000\u0000\u008c\u041f\u0001\u0000\u0000\u0000\u008e"+
		"\u0421\u0001\u0000\u0000\u0000\u0090\u0423\u0001\u0000\u0000\u0000\u0092"+
		"\u0428\u0001\u0000\u0000\u0000\u0094\u042e\u0001\u0000\u0000\u0000\u0096"+
		"\u0431\u0001\u0000\u0000\u0000\u0098\u0439\u0001\u0000\u0000\u0000\u009a"+
		"\u0440\u0001\u0000\u0000\u0000\u009c\u0442\u0001\u0000\u0000\u0000\u009e"+
		"\u045c\u0001\u0000\u0000\u0000\u00a0\u0462\u0001\u0000\u0000\u0000\u00a2"+
		"\u0464\u0001\u0000\u0000\u0000\u00a4\u0482\u0001\u0000\u0000\u0000\u00a6"+
		"\u0484\u0001\u0000\u0000\u0000\u00a8\u0486\u0001\u0000\u0000\u0000\u00aa"+
		"\u0490\u0001\u0000\u0000\u0000\u00ac\u049d\u0001\u0000\u0000\u0000\u00ae"+
		"\u04a7\u0001\u0000\u0000\u0000\u00b0\u04ab\u0001\u0000\u0000\u0000\u00b2"+
		"\u04ae\u0001\u0000\u0000\u0000\u00b4\u04b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u04bb\u0001\u0000\u0000\u0000\u00b8\u04bf\u0001\u0000\u0000\u0000\u00ba"+
		"\u04c1\u0001\u0000\u0000\u0000\u00bc\u04c4\u0001\u0000\u0000\u0000\u00be"+
		"\u04d1\u0001\u0000\u0000\u0000\u00c0\u04d3\u0001\u0000\u0000\u0000\u00c2"+
		"\u04da\u0001\u0000\u0000\u0000\u00c4\u04de\u0001\u0000\u0000\u0000\u00c6"+
		"\u04ea\u0001\u0000\u0000\u0000\u00c8\u04f4\u0001\u0000\u0000\u0000\u00ca"+
		"\u04fa\u0001\u0000\u0000\u0000\u00cc\u0505\u0001\u0000\u0000\u0000\u00ce"+
		"\u0511\u0001\u0000\u0000\u0000\u00d0\u0513\u0001\u0000\u0000\u0000\u00d2"+
		"\u051e\u0001\u0000\u0000\u0000\u00d4\u052c\u0001\u0000\u0000\u0000\u00d6"+
		"\u0532\u0001\u0000\u0000\u0000\u00d8\u0534\u0001\u0000\u0000\u0000\u00da"+
		"\u053b\u0001\u0000\u0000\u0000\u00dc\u0550\u0001\u0000\u0000\u0000\u00de"+
		"\u0552\u0001\u0000\u0000\u0000\u00e0\u055a\u0001\u0000\u0000\u0000\u00e2"+
		"\u0563\u0001\u0000\u0000\u0000\u00e4\u056b\u0001\u0000\u0000\u0000\u00e6"+
		"\u0579\u0001\u0000\u0000\u0000\u00e8\u058c\u0001\u0000\u0000\u0000\u00ea"+
		"\u059d\u0001\u0000\u0000\u0000\u00ec\u05b0\u0001\u0000\u0000\u0000\u00ee"+
		"\u05b3\u0001\u0000\u0000\u0000\u00f0\u05b7\u0001\u0000\u0000\u0000\u00f2"+
		"\u05b9\u0001\u0000\u0000\u0000\u00f4\u05bc\u0001\u0000\u0000\u0000\u00f6"+
		"\u05c0\u0001\u0000\u0000\u0000\u00f8\u05cc\u0001\u0000\u0000\u0000\u00fa"+
		"\u05d7\u0001\u0000\u0000\u0000\u00fc\u05e7\u0001\u0000\u0000\u0000\u00fe"+
		"\u05fe\u0001\u0000\u0000\u0000\u0100\u0603\u0001\u0000\u0000\u0000\u0102"+
		"\u0617\u0001\u0000\u0000\u0000\u0104\u061e\u0001\u0000\u0000\u0000\u0106"+
		"\u0627\u0001\u0000\u0000\u0000\u0108\u0635\u0001\u0000\u0000\u0000\u010a"+
		"\u0648\u0001\u0000\u0000\u0000\u010c\u064f\u0001\u0000\u0000\u0000\u010e"+
		"\u0654\u0001\u0000\u0000\u0000\u0110\u0658\u0001\u0000\u0000\u0000\u0112"+
		"\u065a\u0001\u0000\u0000\u0000\u0114\u0668\u0001\u0000\u0000\u0000\u0116"+
		"\u0673\u0001\u0000\u0000\u0000\u0118\u0675\u0001\u0000\u0000\u0000\u011a"+
		"\u0693\u0001\u0000\u0000\u0000\u011c\u0696\u0001\u0000\u0000\u0000\u011e"+
		"\u069a\u0001\u0000\u0000\u0000\u0120\u069c\u0001\u0000\u0000\u0000\u0122"+
		"\u06a2\u0001\u0000\u0000\u0000\u0124\u06b6\u0001\u0000\u0000\u0000\u0126"+
		"\u06b8\u0001\u0000\u0000\u0000\u0128\u06d4\u0001\u0000\u0000\u0000\u012a"+
		"\u06d7\u0001\u0000\u0000\u0000\u012c\u06db\u0001\u0000\u0000\u0000\u012e"+
		"\u06dd\u0001\u0000\u0000\u0000\u0130\u06e0\u0001\u0000\u0000\u0000\u0132"+
		"\u06e3\u0001\u0000\u0000\u0000\u0134\u06f2\u0001\u0000\u0000\u0000\u0136"+
		"\u0707\u0001\u0000\u0000\u0000\u0138\u0709\u0001\u0000\u0000\u0000\u013a"+
		"\u070b\u0001\u0000\u0000\u0000\u013c\u070d\u0001\u0000\u0000\u0000\u013e"+
		"\u0710\u0001\u0000\u0000\u0000\u0140\u0714\u0001\u0000\u0000\u0000\u0142"+
		"\u0718\u0001\u0000\u0000\u0000\u0144\u071b\u0001\u0000\u0000\u0000\u0146"+
		"\u0729\u0001\u0000\u0000\u0000\u0148\u0734\u0001\u0000\u0000\u0000\u014a"+
		"\u0736\u0001\u0000\u0000\u0000\u014c\u0739\u0001\u0000\u0000\u0000\u014e"+
		"\u073f\u0001\u0000\u0000\u0000\u0150\u0745\u0001\u0000\u0000\u0000\u0152"+
		"\u074f\u0001\u0000\u0000\u0000\u0154\u075a\u0001\u0000\u0000\u0000\u0156"+
		"\u0769\u0001\u0000\u0000\u0000\u0158\u077b\u0001\u0000\u0000\u0000\u015a"+
		"\u077d\u0001\u0000\u0000\u0000\u015c\u077f\u0001\u0000\u0000\u0000\u015e"+
		"\u0790\u0001\u0000\u0000\u0000\u0160\u0792\u0001\u0000\u0000\u0000\u0162"+
		"\u079c\u0001\u0000\u0000\u0000\u0164\u07a1\u0001\u0000\u0000\u0000\u0166"+
		"\u07a6\u0001\u0000\u0000\u0000\u0168\u07aa\u0001\u0000\u0000\u0000\u016a"+
		"\u07b2\u0001\u0000\u0000\u0000\u016c\u07b6\u0001\u0000\u0000\u0000\u016e"+
		"\u07c5\u0001\u0000\u0000\u0000\u0170\u07c7\u0001\u0000\u0000\u0000\u0172"+
		"\u07cd\u0001\u0000\u0000\u0000\u0174\u07cf\u0001\u0000\u0000\u0000\u0176"+
		"\u07d6\u0001\u0000\u0000\u0000\u0178\u07ea\u0001\u0000\u0000\u0000\u017a"+
		"\u081f\u0001\u0000\u0000\u0000\u017c\u0821\u0001\u0000\u0000\u0000\u017e"+
		"\u0180\u0003x<\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180\u0183\u0001"+
		"\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001"+
		"\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000\u0000\u0183\u0181\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0005\u0000\u0000\u0001\u0185\u0001\u0001"+
		"\u0000\u0000\u0000\u0186\u0188\u0003\u017c\u00be\u0000\u0187\u0186\u0001"+
		"\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u0187\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u0193\u0001"+
		"\u0000\u0000\u0000\u018b\u0193\u0005D\u0000\u0000\u018c\u018d\u0005T\u0000"+
		"\u0000\u018d\u018e\u0003Z-\u0000\u018e\u018f\u0005U\u0000\u0000\u018f"+
		"\u0193\u0001\u0000\u0000\u0000\u0190\u0193\u0003\u0004\u0002\u0000\u0191"+
		"\u0193\u0003\f\u0006\u0000\u0192\u0187\u0001\u0000\u0000\u0000\u0192\u018b"+
		"\u0001\u0000\u0000\u0000\u0192\u018c\u0001\u0000\u0000\u0000\u0192\u0190"+
		"\u0001\u0000\u0000\u0000\u0192\u0191\u0001\u0000\u0000\u0000\u0193\u0003"+
		"\u0001\u0000\u0000\u0000\u0194\u0197\u0003\u0006\u0003\u0000\u0195\u0197"+
		"\u0003\b\u0004\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0196\u0195\u0001"+
		"\u0000\u0000\u0000\u0197\u0005\u0001\u0000\u0000\u0000\u0198\u01a3\u0005"+
		"\u0083\u0000\u0000\u0199\u01a3\u0003\u014a\u00a5\u0000\u019a\u01a3\u0003"+
		"\u013c\u009e\u0000\u019b\u01a3\u0003\u014c\u00a6\u0000\u019c\u019f\u0005"+
		"b\u0000\u0000\u019d\u01a0\u0003\u0116\u008b\u0000\u019e\u01a0\u0003\u00a2"+
		"Q\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u019f\u019e\u0001\u0000\u0000"+
		"\u0000\u01a0\u01a3\u0001\u0000\u0000\u0000\u01a1\u01a3\u0003\u0158\u00ac"+
		"\u0000\u01a2\u0198\u0001\u0000\u0000\u0000\u01a2\u0199\u0001\u0000\u0000"+
		"\u0000\u01a2\u019a\u0001\u0000\u0000\u0000\u01a2\u019b\u0001\u0000\u0000"+
		"\u0000\u01a2\u019c\u0001\u0000\u0000\u0000\u01a2\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a3\u0007\u0001\u0000\u0000\u0000\u01a4\u01a6\u0003\n\u0005\u0000"+
		"\u01a5\u01a7\u0005C\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a9\u0003\u0006\u0003\u0000\u01a9\t\u0001\u0000\u0000\u0000\u01aa\u01ae"+
		"\u0006\u0005\uffff\uffff\u0000\u01ab\u01af\u0003\u00a0P\u0000\u01ac\u01af"+
		"\u0003\u00b8\\\u0000\u01ad\u01af\u0003\u00a2Q\u0000\u01ae\u01ab\u0001"+
		"\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae\u01ad\u0001"+
		"\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b1\u0005~\u0000\u0000\u01b1\u01bd\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b8\n\u0001\u0000\u0000\u01b3\u01b9\u0005\u0083\u0000"+
		"\u0000\u01b4\u01b6\u0005C\u0000\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b9\u0003\u0156\u00ab\u0000\u01b8\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b8\u01b5\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000"+
		"\u01ba\u01bc\u0005~\u0000\u0000\u01bb\u01b2\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd"+
		"\u01be\u0001\u0000\u0000\u0000\u01be\u000b\u0001\u0000\u0000\u0000\u01bf"+
		"\u01bd\u0001\u0000\u0000\u0000\u01c0\u01c2\u0003\u000e\u0007\u0000\u01c1"+
		"\u01c3\u0003\u001c\u000e\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c5\u0003d2\u0000\u01c5\r\u0001\u0000\u0000\u0000\u01c6\u01c8\u0005"+
		"V\u0000\u0000\u01c7\u01c9\u0003\u0010\b\u0000\u01c8\u01c7\u0001\u0000"+
		"\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cb\u0005W\u0000\u0000\u01cb\u000f\u0001\u0000\u0000"+
		"\u0000\u01cc\u01d3\u0003\u0014\n\u0000\u01cd\u01d0\u0003\u0012\t\u0000"+
		"\u01ce\u01cf\u0005y\u0000\u0000\u01cf\u01d1\u0003\u0014\n\u0000\u01d0"+
		"\u01ce\u0001\u0000\u0000\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d2\u01cc\u0001\u0000\u0000\u0000\u01d2"+
		"\u01cd\u0001\u0000\u0000\u0000\u01d3\u0011\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d5\u0007\u0000\u0000\u0000\u01d5\u0013\u0001\u0000\u0000\u0000\u01d6"+
		"\u01db\u0003\u0016\u000b\u0000\u01d7\u01d8\u0005y\u0000\u0000\u01d8\u01da"+
		"\u0003\u0016\u000b\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000\u01da\u01dd"+
		"\u0001\u0000\u0000\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc"+
		"\u0001\u0000\u0000\u0000\u01dc\u01df\u0001\u0000\u0000\u0000\u01dd\u01db"+
		"\u0001\u0000\u0000\u0000\u01de\u01e0\u0005\u0082\u0000\u0000\u01df\u01de"+
		"\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000\u0000\u0000\u01e0\u0015"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e4\u0003\u0018\f\u0000\u01e2\u01e4\u0003"+
		"\u001a\r\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e4\u0017\u0001\u0000\u0000\u0000\u01e5\u01e7\u0005`\u0000"+
		"\u0000\u01e6\u01e5\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01eb\u0005\u0083\u0000"+
		"\u0000\u01e9\u01eb\u0005D\u0000\u0000\u01ea\u01e6\u0001\u0000\u0000\u0000"+
		"\u01ea\u01e9\u0001\u0000\u0000\u0000\u01eb\u0019\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ee\u0005`\u0000\u0000\u01ed\u01ec\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ee\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01ef"+
		"\u01f0\u0005\u0083\u0000\u0000\u01f0\u01f1\u0003\u010c\u0086\u0000\u01f1"+
		"\u001b\u0001\u0000\u0000\u0000\u01f2\u01f4\u0005T\u0000\u0000\u01f3\u01f5"+
		"\u0003\u0102\u0081\u0000\u01f4\u01f3\u0001\u0000\u0000\u0000\u01f4\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6\u01f8"+
		"\u0005U\u0000\u0000\u01f7\u01f9\u0005.\u0000\u0000\u01f8\u01f7\u0001\u0000"+
		"\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fa\u01fc\u0003\u0172\u00b9\u0000\u01fb\u01fa\u0001\u0000"+
		"\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fe\u0001\u0000"+
		"\u0000\u0000\u01fd\u01ff\u0003\u00ccf\u0000\u01fe\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0201\u0001\u0000\u0000"+
		"\u0000\u0200\u0202\u0003\u00eau\u0000\u0201\u0200\u0001\u0000\u0000\u0000"+
		"\u0201\u0202\u0001\u0000\u0000\u0000\u0202\u001d\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0006\u000f\uffff\uffff\u0000\u0204\u0222\u0003\u0002\u0001"+
		"\u0000\u0205\u0208\u0003\u009eO\u0000\u0206\u0208\u0003\u0160\u00b0\u0000"+
		"\u0207\u0205\u0001\u0000\u0000\u0000\u0207\u0206\u0001\u0000\u0000\u0000"+
		"\u0208\u020f\u0001\u0000\u0000\u0000\u0209\u020b\u0005T\u0000\u0000\u020a"+
		"\u020c\u0003\"\u0011\u0000\u020b\u020a\u0001\u0000\u0000\u0000\u020b\u020c"+
		"\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d\u0210"+
		"\u0005U\u0000\u0000\u020e\u0210\u0003\u0114\u008a\u0000\u020f\u0209\u0001"+
		"\u0000\u0000\u0000\u020f\u020e\u0001\u0000\u0000\u0000\u0210\u0222\u0001"+
		"\u0000\u0000\u0000\u0211\u0212\u0007\u0001\u0000\u0000\u0212\u0213\u0005"+
		"e\u0000\u0000\u0213\u0214\u0003\u00f6{\u0000\u0214\u0215\u0005f\u0000"+
		"\u0000\u0215\u0216\u0005T\u0000\u0000\u0216\u0217\u0003Z-\u0000\u0217"+
		"\u0218\u0005U\u0000\u0000\u0218\u0222\u0001\u0000\u0000\u0000\u0219\u021a"+
		"\u0003 \u0010\u0000\u021a\u021d\u0005T\u0000\u0000\u021b\u021e\u0003Z"+
		"-\u0000\u021c\u021e\u0003\u00f6{\u0000\u021d\u021b\u0001\u0000\u0000\u0000"+
		"\u021d\u021c\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000"+
		"\u021f\u0220\u0005U\u0000\u0000\u0220\u0222\u0001\u0000\u0000\u0000\u0221"+
		"\u0203\u0001\u0000\u0000\u0000\u0221\u0207\u0001\u0000\u0000\u0000\u0221"+
		"\u0211\u0001\u0000\u0000\u0000\u0221\u0219\u0001\u0000\u0000\u0000\u0222"+
		"\u023e\u0001\u0000\u0000\u0000\u0223\u0224\n\u0007\u0000\u0000\u0224\u0227"+
		"\u0005V\u0000\u0000\u0225\u0228\u0003Z-\u0000\u0226\u0228\u0003\u0114"+
		"\u008a\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0227\u0226\u0001\u0000"+
		"\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022a\u0005W\u0000"+
		"\u0000\u022a\u023d\u0001\u0000\u0000\u0000\u022b\u022c\n\u0006\u0000\u0000"+
		"\u022c\u022e\u0005T\u0000\u0000\u022d\u022f\u0003\"\u0011\u0000\u022e"+
		"\u022d\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f"+
		"\u0230\u0001\u0000\u0000\u0000\u0230\u023d\u0005U\u0000\u0000\u0231\u0232"+
		"\n\u0004\u0000\u0000\u0232\u0238\u0007\u0002\u0000\u0000\u0233\u0235\u0005"+
		"C\u0000\u0000\u0234\u0233\u0001\u0000\u0000\u0000\u0234\u0235\u0001\u0000"+
		"\u0000\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0239\u0003\u0004"+
		"\u0002\u0000\u0237\u0239\u0003$\u0012\u0000\u0238\u0234\u0001\u0000\u0000"+
		"\u0000\u0238\u0237\u0001\u0000\u0000\u0000\u0239\u023d\u0001\u0000\u0000"+
		"\u0000\u023a\u023b\n\u0003\u0000\u0000\u023b\u023d\u0007\u0003\u0000\u0000"+
		"\u023c\u0223\u0001\u0000\u0000\u0000\u023c\u022b\u0001\u0000\u0000\u0000"+
		"\u023c\u0231\u0001\u0000\u0000\u0000\u023c\u023a\u0001\u0000\u0000\u0000"+
		"\u023d\u0240\u0001\u0000\u0000\u0000\u023e\u023c\u0001\u0000\u0000\u0000"+
		"\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u001f\u0001\u0000\u0000\u0000"+
		"\u0240\u023e\u0001\u0000\u0000\u0000\u0241\u0242\u0005J\u0000\u0000\u0242"+
		"!\u0001\u0000\u0000\u0000\u0243\u0244\u0003\u0112\u0089\u0000\u0244#\u0001"+
		"\u0000\u0000\u0000\u0245\u0247\u0003\n\u0005\u0000\u0246\u0245\u0001\u0000"+
		"\u0000\u0000\u0246\u0247\u0001\u0000\u0000\u0000\u0247\u024b\u0001\u0000"+
		"\u0000\u0000\u0248\u0249\u0003\u00a0P\u0000\u0249\u024a\u0005~\u0000\u0000"+
		"\u024a\u024c\u0001\u0000\u0000\u0000\u024b\u0248\u0001\u0000\u0000\u0000"+
		"\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000"+
		"\u024d\u024e\u0005b\u0000\u0000\u024e\u0259\u0003\u00a0P\u0000\u024f\u0250"+
		"\u0003\n\u0005\u0000\u0250\u0251\u0005C\u0000\u0000\u0251\u0252\u0003"+
		"\u0156\u00ab\u0000\u0252\u0253\u0005~\u0000\u0000\u0253\u0254\u0005b\u0000"+
		"\u0000\u0254\u0255\u0003\u00a0P\u0000\u0255\u0259\u0001\u0000\u0000\u0000"+
		"\u0256\u0257\u0005b\u0000\u0000\u0257\u0259\u0003\u00a2Q\u0000\u0258\u0246"+
		"\u0001\u0000\u0000\u0000\u0258\u024f\u0001\u0000\u0000\u0000\u0258\u0256"+
		"\u0001\u0000\u0000\u0000\u0259%\u0001\u0000\u0000\u0000\u025a\u0276\u0003"+
		"\u001e\u000f\u0000\u025b\u0260\u0005w\u0000\u0000\u025c\u0260\u0005x\u0000"+
		"\u0000\u025d\u0260\u0003(\u0014\u0000\u025e\u0260\u0005=\u0000\u0000\u025f"+
		"\u025b\u0001\u0000\u0000\u0000\u025f\u025c\u0001\u0000\u0000\u0000\u025f"+
		"\u025d\u0001\u0000\u0000\u0000\u025f\u025e\u0001\u0000\u0000\u0000\u0260"+
		"\u0261\u0001\u0000\u0000\u0000\u0261\u0276\u0003&\u0013\u0000\u0262\u026b"+
		"\u0005=\u0000\u0000\u0263\u0264\u0005T\u0000\u0000\u0264\u0265\u0003\u00f6"+
		"{\u0000\u0265\u0266\u0005U\u0000\u0000\u0266\u026c\u0001\u0000\u0000\u0000"+
		"\u0267\u0268\u0005\u0082\u0000\u0000\u0268\u0269\u0005T\u0000\u0000\u0269"+
		"\u026a\u0005\u0083\u0000\u0000\u026a\u026c\u0005U\u0000\u0000\u026b\u0263"+
		"\u0001\u0000\u0000\u0000\u026b\u0267\u0001\u0000\u0000\u0000\u026c\u0276"+
		"\u0001\u0000\u0000\u0000\u026d\u026e\u0005\n\u0000\u0000\u026e\u026f\u0005"+
		"T\u0000\u0000\u026f\u0270\u0003\u00f6{\u0000\u0270\u0271\u0005U\u0000"+
		"\u0000\u0271\u0276\u0001\u0000\u0000\u0000\u0272\u0276\u00038\u001c\u0000"+
		"\u0273\u0276\u0003*\u0015\u0000\u0274\u0276\u00036\u001b\u0000\u0275\u025a"+
		"\u0001\u0000\u0000\u0000\u0275\u025f\u0001\u0000\u0000\u0000\u0275\u0262"+
		"\u0001\u0000\u0000\u0000\u0275\u026d\u0001\u0000\u0000\u0000\u0275\u0272"+
		"\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0275\u0274"+
		"\u0001\u0000\u0000\u0000\u0276\'\u0001\u0000\u0000\u0000\u0277\u0278\u0007"+
		"\u0004\u0000\u0000\u0278)\u0001\u0000\u0000\u0000\u0279\u027b\u0005~\u0000"+
		"\u0000\u027a\u0279\u0001\u0000\u0000\u0000\u027a\u027b\u0001\u0000\u0000"+
		"\u0000\u027b\u027c\u0001\u0000\u0000\u0000\u027c\u027e\u00050\u0000\u0000"+
		"\u027d\u027f\u0003,\u0016\u0000\u027e\u027d\u0001\u0000\u0000\u0000\u027e"+
		"\u027f\u0001\u0000\u0000\u0000\u027f\u0285\u0001\u0000\u0000\u0000\u0280"+
		"\u0286\u0003.\u0017\u0000\u0281\u0282\u0005T\u0000\u0000\u0282\u0283\u0003"+
		"\u00f6{\u0000\u0283\u0284\u0005U\u0000\u0000\u0284\u0286\u0001\u0000\u0000"+
		"\u0000\u0285\u0280\u0001\u0000\u0000\u0000\u0285\u0281\u0001\u0000\u0000"+
		"\u0000\u0286\u0288\u0001\u0000\u0000\u0000\u0287\u0289\u00034\u001a\u0000"+
		"\u0288\u0287\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000"+
		"\u0289+\u0001\u0000\u0000\u0000\u028a\u028b\u0005T\u0000\u0000\u028b\u028c"+
		"\u0003\"\u0011\u0000\u028c\u028d\u0005U\u0000\u0000\u028d-\u0001\u0000"+
		"\u0000\u0000\u028e\u0290\u0003\u0096K\u0000\u028f\u0291\u00030\u0018\u0000"+
		"\u0290\u028f\u0001\u0000\u0000\u0000\u0290\u0291\u0001\u0000\u0000\u0000"+
		"\u0291/\u0001\u0000\u0000\u0000\u0292\u0294\u0003\u00ecv\u0000\u0293\u0295"+
		"\u00030\u0018\u0000\u0294\u0293\u0001\u0000\u0000\u0000\u0294\u0295\u0001"+
		"\u0000\u0000\u0000\u0295\u0298\u0001\u0000\u0000\u0000\u0296\u0298\u0003"+
		"2\u0019\u0000\u0297\u0292\u0001\u0000\u0000\u0000\u0297\u0296\u0001\u0000"+
		"\u0000\u0000\u02981\u0001\u0000\u0000\u0000\u0299\u029a\u0006\u0019\uffff"+
		"\uffff\u0000\u029a\u029b\u0005V\u0000\u0000\u029b\u029c\u0003Z-\u0000"+
		"\u029c\u029e\u0005W\u0000\u0000\u029d\u029f\u0003\u00ccf\u0000\u029e\u029d"+
		"\u0001\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000\u029f\u02a9"+
		"\u0001\u0000\u0000\u0000\u02a0\u02a1\n\u0001\u0000\u0000\u02a1\u02a2\u0005"+
		"V\u0000\u0000\u02a2\u02a3\u0003\\.\u0000\u02a3\u02a5\u0005W\u0000\u0000"+
		"\u02a4\u02a6\u0003\u00ccf\u0000\u02a5\u02a4\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a6\u0001\u0000\u0000\u0000\u02a6\u02a8\u0001\u0000\u0000\u0000\u02a7"+
		"\u02a0\u0001\u0000\u0000\u0000\u02a8\u02ab\u0001\u0000\u0000\u0000\u02a9"+
		"\u02a7\u0001\u0000\u0000\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa"+
		"3\u0001\u0000\u0000\u0000\u02ab\u02a9\u0001\u0000\u0000\u0000\u02ac\u02ae"+
		"\u0005T\u0000\u0000\u02ad\u02af\u0003\"\u0011\u0000\u02ae\u02ad\u0001"+
		"\u0000\u0000\u0000\u02ae\u02af\u0001\u0000\u0000\u0000\u02af\u02b0\u0001"+
		"\u0000\u0000\u0000\u02b0\u02b3\u0005U\u0000\u0000\u02b1\u02b3\u0003\u0114"+
		"\u008a\u0000\u02b2\u02ac\u0001\u0000\u0000\u0000\u02b2\u02b1\u0001\u0000"+
		"\u0000\u0000\u02b35\u0001\u0000\u0000\u0000\u02b4\u02b6\u0005~\u0000\u0000"+
		"\u02b5\u02b4\u0001\u0000\u0000\u0000\u02b5\u02b6\u0001\u0000\u0000\u0000"+
		"\u02b6\u02b7\u0001\u0000\u0000\u0000\u02b7\u02ba\u0005\u001b\u0000\u0000"+
		"\u02b8\u02b9\u0005V\u0000\u0000\u02b9\u02bb\u0005W\u0000\u0000\u02ba\u02b8"+
		"\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000\u02bb\u02bc"+
		"\u0001\u0000\u0000\u0000\u02bc\u02bd\u0003:\u001d\u0000\u02bd7\u0001\u0000"+
		"\u0000\u0000\u02be\u02bf\u00051\u0000\u0000\u02bf\u02c0\u0005T\u0000\u0000"+
		"\u02c0\u02c1\u0003Z-\u0000\u02c1\u02c2\u0005U\u0000\u0000\u02c29\u0001"+
		"\u0000\u0000\u0000\u02c3\u02ca\u0003&\u0013\u0000\u02c4\u02c5\u0005T\u0000"+
		"\u0000\u02c5\u02c6\u0003\u00f6{\u0000\u02c6\u02c7\u0005U\u0000\u0000\u02c7"+
		"\u02c8\u0003:\u001d\u0000\u02c8\u02ca\u0001\u0000\u0000\u0000\u02c9\u02c3"+
		"\u0001\u0000\u0000\u0000\u02c9\u02c4\u0001\u0000\u0000\u0000\u02ca;\u0001"+
		"\u0000\u0000\u0000\u02cb\u02d0\u0003:\u001d\u0000\u02cc\u02cd\u0007\u0005"+
		"\u0000\u0000\u02cd\u02cf\u0003:\u001d\u0000\u02ce\u02cc\u0001\u0000\u0000"+
		"\u0000\u02cf\u02d2\u0001\u0000\u0000\u0000\u02d0\u02ce\u0001\u0000\u0000"+
		"\u0000\u02d0\u02d1\u0001\u0000\u0000\u0000\u02d1=\u0001\u0000\u0000\u0000"+
		"\u02d2\u02d0\u0001\u0000\u0000\u0000\u02d3\u02d8\u0003<\u001e\u0000\u02d4"+
		"\u02d5\u0007\u0006\u0000\u0000\u02d5\u02d7\u0003<\u001e\u0000\u02d6\u02d4"+
		"\u0001\u0000\u0000\u0000\u02d7\u02da\u0001\u0000\u0000\u0000\u02d8\u02d6"+
		"\u0001\u0000\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000\u02d9?\u0001"+
		"\u0000\u0000\u0000\u02da\u02d8\u0001\u0000\u0000\u0000\u02db\u02e0\u0003"+
		">\u001f\u0000\u02dc\u02dd\u0007\u0007\u0000\u0000\u02dd\u02df\u0003>\u001f"+
		"\u0000\u02de\u02dc\u0001\u0000\u0000\u0000\u02df\u02e2\u0001\u0000\u0000"+
		"\u0000\u02e0\u02de\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000"+
		"\u0000\u02e1A\u0001\u0000\u0000\u0000\u02e2\u02e0\u0001\u0000\u0000\u0000"+
		"\u02e3\u02e9\u0003@ \u0000\u02e4\u02e5\u0003D\"\u0000\u02e5\u02e6\u0003"+
		"@ \u0000\u02e6\u02e8\u0001\u0000\u0000\u0000\u02e7\u02e4\u0001\u0000\u0000"+
		"\u0000\u02e8\u02eb\u0001\u0000\u0000\u0000\u02e9\u02e7\u0001\u0000\u0000"+
		"\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000\u02eaC\u0001\u0000\u0000\u0000"+
		"\u02eb\u02e9\u0001\u0000\u0000\u0000\u02ec\u02ed\u0005f\u0000\u0000\u02ed"+
		"\u02f1\u0005f\u0000\u0000\u02ee\u02ef\u0005e\u0000\u0000\u02ef\u02f1\u0005"+
		"e\u0000\u0000\u02f0\u02ec\u0001\u0000\u0000\u0000\u02f0\u02ee\u0001\u0000"+
		"\u0000\u0000\u02f1E\u0001\u0000\u0000\u0000\u02f2\u02f7\u0003B!\u0000"+
		"\u02f3\u02f4\u0007\b\u0000\u0000\u02f4\u02f6\u0003B!\u0000\u02f5\u02f3"+
		"\u0001\u0000\u0000\u0000\u02f6\u02f9\u0001\u0000\u0000\u0000\u02f7\u02f5"+
		"\u0001\u0000\u0000\u0000\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8G\u0001"+
		"\u0000\u0000\u0000\u02f9\u02f7\u0001\u0000\u0000\u0000\u02fa\u02ff\u0003"+
		"F#\u0000\u02fb\u02fc\u0007\t\u0000\u0000\u02fc\u02fe\u0003F#\u0000\u02fd"+
		"\u02fb\u0001\u0000\u0000\u0000\u02fe\u0301\u0001\u0000\u0000\u0000\u02ff"+
		"\u02fd\u0001\u0000\u0000\u0000\u02ff\u0300\u0001\u0000\u0000\u0000\u0300"+
		"I\u0001\u0000\u0000\u0000\u0301\u02ff\u0001\u0000\u0000\u0000\u0302\u0307"+
		"\u0003H$\u0000\u0303\u0304\u0005`\u0000\u0000\u0304\u0306\u0003H$\u0000"+
		"\u0305\u0303\u0001\u0000\u0000\u0000\u0306\u0309\u0001\u0000\u0000\u0000"+
		"\u0307\u0305\u0001\u0000\u0000\u0000\u0307\u0308\u0001\u0000\u0000\u0000"+
		"\u0308K\u0001\u0000\u0000\u0000\u0309\u0307\u0001\u0000\u0000\u0000\u030a"+
		"\u030f\u0003J%\u0000\u030b\u030c\u0005_\u0000\u0000\u030c\u030e\u0003"+
		"J%\u0000\u030d\u030b\u0001\u0000\u0000\u0000\u030e\u0311\u0001\u0000\u0000"+
		"\u0000\u030f\u030d\u0001\u0000\u0000\u0000\u030f\u0310\u0001\u0000\u0000"+
		"\u0000\u0310M\u0001\u0000\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000"+
		"\u0312\u0317\u0003L&\u0000\u0313\u0314\u0005a\u0000\u0000\u0314\u0316"+
		"\u0003L&\u0000\u0315\u0313\u0001\u0000\u0000\u0000\u0316\u0319\u0001\u0000"+
		"\u0000\u0000\u0317\u0315\u0001\u0000\u0000\u0000\u0317\u0318\u0001\u0000"+
		"\u0000\u0000\u0318O\u0001\u0000\u0000\u0000\u0319\u0317\u0001\u0000\u0000"+
		"\u0000\u031a\u031f\u0003N\'\u0000\u031b\u031c\u0005u\u0000\u0000\u031c"+
		"\u031e\u0003N\'\u0000\u031d\u031b\u0001\u0000\u0000\u0000\u031e\u0321"+
		"\u0001\u0000\u0000\u0000\u031f\u031d\u0001\u0000\u0000\u0000\u031f\u0320"+
		"\u0001\u0000\u0000\u0000\u0320Q\u0001\u0000\u0000\u0000\u0321\u031f\u0001"+
		"\u0000\u0000\u0000\u0322\u0327\u0003P(\u0000\u0323\u0324\u0005v\u0000"+
		"\u0000\u0324\u0326\u0003P(\u0000\u0325\u0323\u0001\u0000\u0000\u0000\u0326"+
		"\u0329\u0001\u0000\u0000\u0000\u0327\u0325\u0001\u0000\u0000\u0000\u0327"+
		"\u0328\u0001\u0000\u0000\u0000\u0328S\u0001\u0000\u0000\u0000\u0329\u0327"+
		"\u0001\u0000\u0000\u0000\u032a\u0330\u0003R)\u0000\u032b\u032c\u0005|"+
		"\u0000\u0000\u032c\u032d\u0003Z-\u0000\u032d\u032e\u0005}\u0000\u0000"+
		"\u032e\u032f\u0003V+\u0000\u032f\u0331\u0001\u0000\u0000\u0000\u0330\u032b"+
		"\u0001\u0000\u0000\u0000\u0330\u0331\u0001\u0000\u0000\u0000\u0331U\u0001"+
		"\u0000\u0000\u0000\u0332\u0339\u0003T*\u0000\u0333\u0334\u0003R)\u0000"+
		"\u0334\u0335\u0003X,\u0000\u0335\u0336\u0003\u0110\u0088\u0000\u0336\u0339"+
		"\u0001\u0000\u0000\u0000\u0337\u0339\u0003\u0170\u00b8\u0000\u0338\u0332"+
		"\u0001\u0000\u0000\u0000\u0338\u0333\u0001\u0000\u0000\u0000\u0338\u0337"+
		"\u0001\u0000\u0000\u0000\u0339W\u0001\u0000\u0000\u0000\u033a\u033b\u0007"+
		"\n\u0000\u0000\u033bY\u0001\u0000\u0000\u0000\u033c\u0341\u0003V+\u0000"+
		"\u033d\u033e\u0005y\u0000\u0000\u033e\u0340\u0003V+\u0000\u033f\u033d"+
		"\u0001\u0000\u0000\u0000\u0340\u0343\u0001\u0000\u0000\u0000\u0341\u033f"+
		"\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000\u0000\u0342[\u0001"+
		"\u0000\u0000\u0000\u0343\u0341\u0001\u0000\u0000\u0000\u0344\u0345\u0003"+
		"T*\u0000\u0345]\u0001\u0000\u0000\u0000\u0346\u0354\u0003`0\u0000\u0347"+
		"\u0354\u0003v;\u0000\u0348\u034a\u0003\u00ccf\u0000\u0349\u0348\u0001"+
		"\u0000\u0000\u0000\u0349\u034a\u0001\u0000\u0000\u0000\u034a\u0351\u0001"+
		"\u0000\u0000\u0000\u034b\u0352\u0003b1\u0000\u034c\u0352\u0003d2\u0000"+
		"\u034d\u0352\u0003h4\u0000\u034e\u0352\u0003l6\u0000\u034f\u0352\u0003"+
		"t:\u0000\u0350\u0352\u0003\u0166\u00b3\u0000\u0351\u034b\u0001\u0000\u0000"+
		"\u0000\u0351\u034c\u0001\u0000\u0000\u0000\u0351\u034d\u0001\u0000\u0000"+
		"\u0000\u0351\u034e\u0001\u0000\u0000\u0000\u0351\u034f\u0001\u0000\u0000"+
		"\u0000\u0351\u0350\u0001\u0000\u0000\u0000\u0352\u0354\u0001\u0000\u0000"+
		"\u0000\u0353\u0346\u0001\u0000\u0000\u0000\u0353\u0347\u0001\u0000\u0000"+
		"\u0000\u0353\u0349\u0001\u0000\u0000\u0000\u0354_\u0001\u0000\u0000\u0000"+
		"\u0355\u0357\u0003\u00ccf\u0000\u0356\u0355\u0001\u0000\u0000\u0000\u0356"+
		"\u0357\u0001\u0000\u0000\u0000\u0357\u035c\u0001\u0000\u0000\u0000\u0358"+
		"\u035d\u0005\u0083\u0000\u0000\u0359\u035a\u0005\u000f\u0000\u0000\u035a"+
		"\u035d\u0003\\.\u0000\u035b\u035d\u0005\u001a\u0000\u0000\u035c\u0358"+
		"\u0001\u0000\u0000\u0000\u035c\u0359\u0001\u0000\u0000\u0000\u035c\u035b"+
		"\u0001\u0000\u0000\u0000\u035d\u035e\u0001\u0000\u0000\u0000\u035e\u035f"+
		"\u0005}\u0000\u0000\u035f\u0360\u0003^/\u0000\u0360a\u0001\u0000\u0000"+
		"\u0000\u0361\u0363\u0003Z-\u0000\u0362\u0361\u0001\u0000\u0000\u0000\u0362"+
		"\u0363\u0001\u0000\u0000\u0000\u0363\u0364\u0001\u0000\u0000\u0000\u0364"+
		"\u0365\u0005\u007f\u0000\u0000\u0365c\u0001\u0000\u0000\u0000\u0366\u0368"+
		"\u0005X\u0000\u0000\u0367\u0369\u0003f3\u0000\u0368\u0367\u0001\u0000"+
		"\u0000\u0000\u0368\u0369\u0001\u0000\u0000\u0000\u0369\u036a\u0001\u0000"+
		"\u0000\u0000\u036a\u036b\u0005Y\u0000\u0000\u036be\u0001\u0000\u0000\u0000"+
		"\u036c\u036e\u0003^/\u0000\u036d\u036c\u0001\u0000\u0000\u0000\u036e\u036f"+
		"\u0001\u0000\u0000\u0000\u036f\u036d\u0001\u0000\u0000\u0000\u036f\u0370"+
		"\u0001\u0000\u0000\u0000\u0370g\u0001\u0000\u0000\u0000\u0371\u0372\u0005"+
		"*\u0000\u0000\u0372\u0373\u0005T\u0000\u0000\u0373\u0374\u0003j5\u0000"+
		"\u0374\u0375\u0005U\u0000\u0000\u0375\u0378\u0003^/\u0000\u0376\u0377"+
		"\u0005\u001f\u0000\u0000\u0377\u0379\u0003^/\u0000\u0378\u0376\u0001\u0000"+
		"\u0000\u0000\u0378\u0379\u0001\u0000\u0000\u0000\u0379\u0381\u0001\u0000"+
		"\u0000\u0000\u037a\u037b\u0005B\u0000\u0000\u037b\u037c\u0005T\u0000\u0000"+
		"\u037c\u037d\u0003j5\u0000\u037d\u037e\u0005U\u0000\u0000\u037e\u037f"+
		"\u0003^/\u0000\u037f\u0381\u0001\u0000\u0000\u0000\u0380\u0371\u0001\u0000"+
		"\u0000\u0000\u0380\u037a\u0001\u0000\u0000\u0000\u0381i\u0001\u0000\u0000"+
		"\u0000\u0382\u038e\u0003Z-\u0000\u0383\u0385\u0003\u00ccf\u0000\u0384"+
		"\u0383\u0001\u0000\u0000\u0000\u0384\u0385\u0001\u0000\u0000\u0000\u0385"+
		"\u0386\u0001\u0000\u0000\u0000\u0386\u0387\u0003\u008aE\u0000\u0387\u038b"+
		"\u0003\u00e2q\u0000\u0388\u0389\u0005d\u0000\u0000\u0389\u038c\u0003\u0110"+
		"\u0088\u0000\u038a\u038c\u0003\u0114\u008a\u0000\u038b\u0388\u0001\u0000"+
		"\u0000\u0000\u038b\u038a\u0001\u0000\u0000\u0000\u038c\u038e\u0001\u0000"+
		"\u0000\u0000\u038d\u0382\u0001\u0000\u0000\u0000\u038d\u0384\u0001\u0000"+
		"\u0000\u0000\u038ek\u0001\u0000\u0000\u0000\u038f\u0390\u0005S\u0000\u0000"+
		"\u0390\u0391\u0005T\u0000\u0000\u0391\u0392\u0003j5\u0000\u0392\u0393"+
		"\u0005U\u0000\u0000\u0393\u0394\u0003^/\u0000\u0394\u03b1\u0001\u0000"+
		"\u0000\u0000\u0395\u0396\u0005\u001c\u0000\u0000\u0396\u0397\u0003^/\u0000"+
		"\u0397\u0398\u0005S\u0000\u0000\u0398\u0399\u0005T\u0000\u0000\u0399\u039a"+
		"\u0003Z-\u0000\u039a\u039b\u0005U\u0000\u0000\u039b\u039c\u0005\u007f"+
		"\u0000\u0000\u039c\u03b1\u0001\u0000\u0000\u0000\u039d\u039e\u0005\'\u0000"+
		"\u0000\u039e\u03ab\u0005T\u0000\u0000\u039f\u03a1\u0003n7\u0000\u03a0"+
		"\u03a2\u0003j5\u0000\u03a1\u03a0\u0001\u0000\u0000\u0000\u03a1\u03a2\u0001"+
		"\u0000\u0000\u0000\u03a2\u03a3\u0001\u0000\u0000\u0000\u03a3\u03a5\u0005"+
		"\u007f\u0000\u0000\u03a4\u03a6\u0003Z-\u0000\u03a5\u03a4\u0001\u0000\u0000"+
		"\u0000\u03a5\u03a6\u0001\u0000\u0000\u0000\u03a6\u03ac\u0001\u0000\u0000"+
		"\u0000\u03a7\u03a8\u0003p8\u0000\u03a8\u03a9\u0005}\u0000\u0000\u03a9"+
		"\u03aa\u0003r9\u0000\u03aa\u03ac\u0001\u0000\u0000\u0000\u03ab\u039f\u0001"+
		"\u0000\u0000\u0000\u03ab\u03a7\u0001\u0000\u0000\u0000\u03ac\u03ad\u0001"+
		"\u0000\u0000\u0000\u03ad\u03ae\u0005U\u0000\u0000\u03ae\u03af\u0003^/"+
		"\u0000\u03af\u03b1\u0001\u0000\u0000\u0000\u03b0\u038f\u0001\u0000\u0000"+
		"\u0000\u03b0\u0395\u0001\u0000\u0000\u0000\u03b0\u039d\u0001\u0000\u0000"+
		"\u0000\u03b1m\u0001\u0000\u0000\u0000\u03b2\u03b5\u0003b1\u0000\u03b3"+
		"\u03b5\u0003\u0080@\u0000\u03b4\u03b2\u0001\u0000\u0000\u0000\u03b4\u03b3"+
		"\u0001\u0000\u0000\u0000\u03b5o\u0001\u0000\u0000\u0000\u03b6\u03b8\u0003"+
		"\u00ccf\u0000\u03b7\u03b6\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000"+
		"\u0000\u0000\u03b8\u03b9\u0001\u0000\u0000\u0000\u03b9\u03ba\u0003\u008a"+
		"E\u0000\u03ba\u03bb\u0003\u00e2q\u0000\u03bbq\u0001\u0000\u0000\u0000"+
		"\u03bc\u03bf\u0003Z-\u0000\u03bd\u03bf\u0003\u0114\u008a\u0000\u03be\u03bc"+
		"\u0001\u0000\u0000\u0000\u03be\u03bd\u0001\u0000\u0000\u0000\u03bfs\u0001"+
		"\u0000\u0000\u0000\u03c0\u03ca\u0005\u000e\u0000\u0000\u03c1\u03ca\u0005"+
		"\u0018\u0000\u0000\u03c2\u03c5\u0005:\u0000\u0000\u03c3\u03c6\u0003Z-"+
		"\u0000\u03c4\u03c6\u0003\u0114\u008a\u0000\u03c5\u03c3\u0001\u0000\u0000"+
		"\u0000\u03c5\u03c4\u0001\u0000\u0000\u0000\u03c5\u03c6\u0001\u0000\u0000"+
		"\u0000\u03c6\u03ca\u0001\u0000\u0000\u0000\u03c7\u03c8\u0005)\u0000\u0000"+
		"\u03c8\u03ca\u0005\u0083\u0000\u0000\u03c9\u03c0\u0001\u0000\u0000\u0000"+
		"\u03c9\u03c1\u0001\u0000\u0000\u0000\u03c9\u03c2\u0001\u0000\u0000\u0000"+
		"\u03c9\u03c7\u0001\u0000\u0000\u0000\u03ca\u03cb\u0001\u0000\u0000\u0000"+
		"\u03cb\u03cc\u0005\u007f\u0000\u0000\u03ccu\u0001\u0000\u0000\u0000\u03cd"+
		"\u03ce\u0003|>\u0000\u03cew\u0001\u0000\u0000\u0000\u03cf\u03d1\u0003"+
		"z=\u0000\u03d0\u03cf\u0001\u0000\u0000\u0000\u03d1\u03d2\u0001\u0000\u0000"+
		"\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d3y\u0001\u0000\u0000\u0000\u03d4\u03de\u0003|>\u0000\u03d5"+
		"\u03de\u0003\u0108\u0084\u0000\u03d6\u03de\u0003\u014e\u00a7\u0000\u03d7"+
		"\u03de\u0003\u0162\u00b1\u0000\u03d8\u03de\u0003\u0164\u00b2\u0000\u03d9"+
		"\u03de\u0003\u00cae\u0000\u03da\u03de\u0003\u00bc^\u0000\u03db\u03de\u0003"+
		"\u0084B\u0000\u03dc\u03de\u0003\u0086C\u0000\u03dd\u03d4\u0001\u0000\u0000"+
		"\u0000\u03dd\u03d5\u0001\u0000\u0000\u0000\u03dd\u03d6\u0001\u0000\u0000"+
		"\u0000\u03dd\u03d7\u0001\u0000\u0000\u0000\u03dd\u03d8\u0001\u0000\u0000"+
		"\u0000\u03dd\u03d9\u0001\u0000\u0000\u0000\u03dd\u03da\u0001\u0000\u0000"+
		"\u0000\u03dd\u03db\u0001\u0000\u0000\u0000\u03dd\u03dc\u0001\u0000\u0000"+
		"\u0000\u03de{\u0001\u0000\u0000\u0000\u03df\u03e8\u0003\u0080@\u0000\u03e0"+
		"\u03e8\u0003\u00c8d\u0000\u03e1\u03e8\u0003\u00c0`\u0000\u03e2\u03e8\u0003"+
		"\u00c4b\u0000\u03e3\u03e8\u0003\u00c6c\u0000\u03e4\u03e8\u0003\u0082A"+
		"\u0000\u03e5\u03e8\u0003~?\u0000\u03e6\u03e8\u0003\u00acV\u0000\u03e7"+
		"\u03df\u0001\u0000\u0000\u0000\u03e7\u03e0\u0001\u0000\u0000\u0000\u03e7"+
		"\u03e1\u0001\u0000\u0000\u0000\u03e7\u03e2\u0001\u0000\u0000\u0000\u03e7"+
		"\u03e3\u0001\u0000\u0000\u0000\u03e7\u03e4\u0001\u0000\u0000\u0000\u03e7"+
		"\u03e5\u0001\u0000\u0000\u0000\u03e7\u03e6\u0001\u0000\u0000\u0000\u03e8"+
		"}\u0001\u0000\u0000\u0000\u03e9\u03ea\u0005N\u0000\u0000\u03ea\u03ec\u0005"+
		"\u0083\u0000\u0000\u03eb\u03ed\u0003\u00ccf\u0000\u03ec\u03eb\u0001\u0000"+
		"\u0000\u0000\u03ec\u03ed\u0001\u0000\u0000\u0000\u03ed\u03ee\u0001\u0000"+
		"\u0000\u0000\u03ee\u03ef\u0005d\u0000\u0000\u03ef\u03f0\u0003\u00f6{\u0000"+
		"\u03f0\u03f1\u0005\u007f\u0000\u0000\u03f1\u007f\u0001\u0000\u0000\u0000"+
		"\u03f2\u03f4\u0003\u008aE\u0000\u03f3\u03f2\u0001\u0000\u0000\u0000\u03f3"+
		"\u03f4\u0001\u0000\u0000\u0000\u03f4\u03f6\u0001\u0000\u0000\u0000\u03f5"+
		"\u03f7\u0003\u00deo\u0000\u03f6\u03f5\u0001\u0000\u0000\u0000\u03f6\u03f7"+
		"\u0001\u0000\u0000\u0000\u03f7\u03f8\u0001\u0000\u0000\u0000\u03f8\u0401"+
		"\u0005\u007f\u0000\u0000\u03f9\u03fb\u0003\u00ccf\u0000\u03fa\u03fc\u0003"+
		"\u008aE\u0000\u03fb\u03fa\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001\u0000"+
		"\u0000\u0000\u03fc\u03fd\u0001\u0000\u0000\u0000\u03fd\u03fe\u0003\u00de"+
		"o\u0000\u03fe\u03ff\u0005\u007f\u0000\u0000\u03ff\u0401\u0001\u0000\u0000"+
		"\u0000\u0400\u03f3\u0001\u0000\u0000\u0000\u0400\u03f9\u0001\u0000\u0000"+
		"\u0000\u0401\u0081\u0001\u0000\u0000\u0000\u0402\u0403\u0005?\u0000\u0000"+
		"\u0403\u0404\u0005T\u0000\u0000\u0404\u0405\u0003\\.\u0000\u0405\u0406"+
		"\u0005y\u0000\u0000\u0406\u0407\u0005\u0004\u0000\u0000\u0407\u0408\u0005"+
		"U\u0000\u0000\u0408\u0409\u0005\u007f\u0000\u0000\u0409\u0083\u0001\u0000"+
		"\u0000\u0000\u040a\u040b\u0005\u007f\u0000\u0000\u040b\u0085\u0001\u0000"+
		"\u0000\u0000\u040c\u040d\u0003\u00ccf\u0000\u040d\u040e\u0005\u007f\u0000"+
		"\u0000\u040e\u0087\u0001\u0000\u0000\u0000\u040f\u0416\u0003\u008cF\u0000"+
		"\u0410\u0416\u0003\u0092I\u0000\u0411\u0416\u0003\u008eG\u0000\u0412\u0416"+
		"\u0005(\u0000\u0000\u0413\u0416\u0005I\u0000\u0000\u0414\u0416\u0005\u0016"+
		"\u0000\u0000\u0415\u040f\u0001\u0000\u0000\u0000\u0415\u0410\u0001\u0000"+
		"\u0000\u0000\u0415\u0411\u0001\u0000\u0000\u0000\u0415\u0412\u0001\u0000"+
		"\u0000\u0000\u0415\u0413\u0001\u0000\u0000\u0000\u0415\u0414\u0001\u0000"+
		"\u0000\u0000\u0416\u0089\u0001\u0000\u0000\u0000\u0417\u0419\u0003\u0088"+
		"D\u0000\u0418\u0417\u0001\u0000\u0000\u0000\u0419\u041a\u0001\u0000\u0000"+
		"\u0000\u041a\u041b\u0001\u0000\u0000\u0000\u041a\u0418\u0001\u0000\u0000"+
		"\u0000\u041b\u041d\u0001\u0000\u0000\u0000\u041c\u041e\u0003\u00ccf\u0000"+
		"\u041d\u041c\u0001\u0000\u0000\u0000\u041d\u041e\u0001\u0000\u0000\u0000"+
		"\u041e\u008b\u0001\u0000\u0000\u0000\u041f\u0420\u0007\u000b\u0000\u0000"+
		"\u0420\u008d\u0001\u0000\u0000\u0000\u0421\u0422\u0007\f\u0000\u0000\u0422"+
		"\u008f\u0001\u0000\u0000\u0000\u0423\u0424\u0005\u0083\u0000\u0000\u0424"+
		"\u0091\u0001\u0000\u0000\u0000\u0425\u0429\u0003\u0094J\u0000\u0426\u0429"+
		"\u0003\u0118\u008c\u0000\u0427\u0429\u0003\u00a8T\u0000\u0428\u0425\u0001"+
		"\u0000\u0000\u0000\u0428\u0426\u0001\u0000\u0000\u0000\u0428\u0427\u0001"+
		"\u0000\u0000\u0000\u0429\u0093\u0001\u0000\u0000\u0000\u042a\u042f\u0003"+
		"\u009eO\u0000\u042b\u042f\u0003\u00a4R\u0000\u042c\u042f\u0003\u0160\u00b0"+
		"\u0000\u042d\u042f\u0003\u00f0x\u0000\u042e\u042a\u0001\u0000\u0000\u0000"+
		"\u042e\u042b\u0001\u0000\u0000\u0000\u042e\u042c\u0001\u0000\u0000\u0000"+
		"\u042e\u042d\u0001\u0000\u0000\u0000\u042f\u0095\u0001\u0000\u0000\u0000"+
		"\u0430\u0432\u0003\u0092I\u0000\u0431\u0430\u0001\u0000\u0000\u0000\u0432"+
		"\u0433\u0001\u0000\u0000\u0000\u0433\u0431\u0001\u0000\u0000\u0000\u0433"+
		"\u0434\u0001\u0000\u0000\u0000\u0434\u0436\u0001\u0000\u0000\u0000\u0435"+
		"\u0437\u0003\u00ccf\u0000\u0436\u0435\u0001\u0000\u0000\u0000\u0436\u0437"+
		"\u0001\u0000\u0000\u0000\u0437\u0097\u0001\u0000\u0000\u0000\u0438\u043a"+
		"\u0003\u0094J\u0000\u0439\u0438\u0001\u0000\u0000\u0000\u043a\u043b\u0001"+
		"\u0000\u0000\u0000\u043b\u0439\u0001\u0000\u0000\u0000\u043b\u043c\u0001"+
		"\u0000\u0000\u0000\u043c\u043e\u0001\u0000\u0000\u0000\u043d\u043f\u0003"+
		"\u00ccf\u0000\u043e\u043d\u0001\u0000\u0000\u0000\u043e\u043f\u0001\u0000"+
		"\u0000\u0000\u043f\u0099\u0001\u0000\u0000\u0000\u0440\u0441\u0007\r\u0000"+
		"\u0000\u0441\u009b\u0001\u0000\u0000\u0000\u0442\u0443\u0007\u000e\u0000"+
		"\u0000\u0443\u009d\u0001\u0000\u0000\u0000\u0444\u0446\u0003\n\u0005\u0000"+
		"\u0445\u0444\u0001\u0000\u0000\u0000\u0445\u0446\u0001\u0000\u0000\u0000"+
		"\u0446\u0447\u0001\u0000\u0000\u0000\u0447\u045d\u0003\u00a0P\u0000\u0448"+
		"\u0449\u0003\n\u0005\u0000\u0449\u044a\u0005C\u0000\u0000\u044a\u044b"+
		"\u0003\u0156\u00ab\u0000\u044b\u045d\u0001\u0000\u0000\u0000\u044c\u045d"+
		"\u0005\u0011\u0000\u0000\u044d\u045d\u0005\u0012\u0000\u0000\u044e\u045d"+
		"\u0005\u0013\u0000\u0000\u044f\u045d\u0005R\u0000\u0000\u0450\u045d\u0005"+
		"\r\u0000\u0000\u0451\u045d\u0005;\u0000\u0000\u0452\u045d\u0005,\u0000"+
		"\u0000\u0453\u045d\u0005-\u0000\u0000\u0454\u045d\u0005&\u0000\u0000\u0455"+
		"\u045d\u0005<\u0000\u0000\u0456\u045d\u0005M\u0000\u0000\u0457\u045d\u0005"+
		"&\u0000\u0000\u0458\u045d\u0005\u001d\u0000\u0000\u0459\u045d\u0005P\u0000"+
		"\u0000\u045a\u045d\u0005\f\u0000\u0000\u045b\u045d\u0003\u00a2Q\u0000"+
		"\u045c\u0445\u0001\u0000\u0000\u0000\u045c\u0448\u0001\u0000\u0000\u0000"+
		"\u045c\u044c\u0001\u0000\u0000\u0000\u045c\u044d\u0001\u0000\u0000\u0000"+
		"\u045c\u044e\u0001\u0000\u0000\u0000\u045c\u044f\u0001\u0000\u0000\u0000"+
		"\u045c\u0450\u0001\u0000\u0000\u0000\u045c\u0451\u0001\u0000\u0000\u0000"+
		"\u045c\u0452\u0001\u0000\u0000\u0000\u045c\u0453\u0001\u0000\u0000\u0000"+
		"\u045c\u0454\u0001\u0000\u0000\u0000\u045c\u0455\u0001\u0000\u0000\u0000"+
		"\u045c\u0456\u0001\u0000\u0000\u0000\u045c\u0457\u0001\u0000\u0000\u0000"+
		"\u045c\u0458\u0001\u0000\u0000\u0000\u045c\u0459\u0001\u0000\u0000\u0000"+
		"\u045c\u045a\u0001\u0000\u0000\u0000\u045c\u045b\u0001\u0000\u0000\u0000"+
		"\u045d\u009f\u0001\u0000\u0000\u0000\u045e\u0463\u0003\u0116\u008b\u0000"+
		"\u045f\u0463\u0003\u00a6S\u0000\u0460\u0463\u0003\u0090H\u0000\u0461\u0463"+
		"\u0003\u0156\u00ab\u0000\u0462\u045e\u0001\u0000\u0000\u0000\u0462\u045f"+
		"\u0001\u0000\u0000\u0000\u0462\u0460\u0001\u0000\u0000\u0000\u0462\u0461"+
		"\u0001\u0000\u0000\u0000\u0463\u00a1\u0001\u0000\u0000\u0000\u0464\u0465"+
		"\u0005\u0019\u0000\u0000\u0465\u0468\u0005T\u0000\u0000\u0466\u0469\u0003"+
		"Z-\u0000\u0467\u0469\u0005\f\u0000\u0000\u0468\u0466\u0001\u0000\u0000"+
		"\u0000\u0468\u0467\u0001\u0000\u0000\u0000\u0469\u046a\u0001\u0000\u0000"+
		"\u0000\u046a\u046b\u0005U\u0000\u0000\u046b\u00a3\u0001\u0000\u0000\u0000"+
		"\u046c\u047b\u0003\u0120\u0090\u0000\u046d\u046f\u0003\u00ccf\u0000\u046e"+
		"\u046d\u0001\u0000\u0000\u0000\u046e\u046f\u0001\u0000\u0000\u0000\u046f"+
		"\u0471\u0001\u0000\u0000\u0000\u0470\u0472\u0003\n\u0005\u0000\u0471\u0470"+
		"\u0001\u0000\u0000\u0000\u0471\u0472\u0001\u0000\u0000\u0000\u0472\u0473"+
		"\u0001\u0000\u0000\u0000\u0473\u047c\u0005\u0083\u0000\u0000\u0474\u047c"+
		"\u0003\u0156\u00ab\u0000\u0475\u0477\u0003\n\u0005\u0000\u0476\u0478\u0005"+
		"C\u0000\u0000\u0477\u0476\u0001\u0000\u0000\u0000\u0477\u0478\u0001\u0000"+
		"\u0000\u0000\u0478\u0479\u0001\u0000\u0000\u0000\u0479\u047a\u0003\u0156"+
		"\u00ab\u0000\u047a\u047c\u0001\u0000\u0000\u0000\u047b\u046e\u0001\u0000"+
		"\u0000\u0000\u047b\u0474\u0001\u0000\u0000\u0000\u047b\u0475\u0001\u0000"+
		"\u0000\u0000\u047c\u0483\u0001\u0000\u0000\u0000\u047d\u047f\u0005 \u0000"+
		"\u0000\u047e\u0480\u0003\n\u0005\u0000\u047f\u047e\u0001\u0000\u0000\u0000"+
		"\u047f\u0480\u0001\u0000\u0000\u0000\u0480\u0481\u0001\u0000\u0000\u0000"+
		"\u0481\u0483\u0005\u0083\u0000\u0000\u0482\u046c\u0001\u0000\u0000\u0000"+
		"\u0482\u047d\u0001\u0000\u0000\u0000\u0483\u00a5\u0001\u0000\u0000\u0000"+
		"\u0484\u0485\u0005\u0083\u0000\u0000\u0485\u00a7\u0001\u0000\u0000\u0000"+
		"\u0486\u0487\u0003\u00aaU\u0000\u0487\u048c\u0005X\u0000\u0000\u0488\u048a"+
		"\u0003\u00b2Y\u0000\u0489\u048b\u0005y\u0000\u0000\u048a\u0489\u0001\u0000"+
		"\u0000\u0000\u048a\u048b\u0001\u0000\u0000\u0000\u048b\u048d\u0001\u0000"+
		"\u0000\u0000\u048c\u0488\u0001\u0000\u0000\u0000\u048c\u048d\u0001\u0000"+
		"\u0000\u0000\u048d\u048e\u0001\u0000\u0000\u0000\u048e\u048f\u0005Y\u0000"+
		"\u0000\u048f\u00a9\u0001\u0000\u0000\u0000\u0490\u0492\u0003\u00aeW\u0000"+
		"\u0491\u0493\u0003\u00ccf\u0000\u0492\u0491\u0001\u0000\u0000\u0000\u0492"+
		"\u0493\u0001\u0000\u0000\u0000\u0493\u0498\u0001\u0000\u0000\u0000\u0494"+
		"\u0496\u0003\n\u0005\u0000\u0495\u0494\u0001\u0000\u0000\u0000\u0495\u0496"+
		"\u0001\u0000\u0000\u0000\u0496\u0497\u0001\u0000\u0000\u0000\u0497\u0499"+
		"\u0005\u0083\u0000\u0000\u0498\u0495\u0001\u0000\u0000\u0000\u0498\u0499"+
		"\u0001\u0000\u0000\u0000\u0499\u049b\u0001\u0000\u0000\u0000\u049a\u049c"+
		"\u0003\u00b0X\u0000\u049b\u049a\u0001\u0000\u0000\u0000\u049b\u049c\u0001"+
		"\u0000\u0000\u0000\u049c\u00ab\u0001\u0000\u0000\u0000\u049d\u049f\u0003"+
		"\u00aeW\u0000\u049e\u04a0\u0003\u00ccf\u0000\u049f\u049e\u0001\u0000\u0000"+
		"\u0000\u049f\u04a0\u0001\u0000\u0000\u0000\u04a0\u04a1\u0001\u0000\u0000"+
		"\u0000\u04a1\u04a3\u0005\u0083\u0000\u0000\u04a2\u04a4\u0003\u00b0X\u0000"+
		"\u04a3\u04a2\u0001\u0000\u0000\u0000\u04a3\u04a4\u0001\u0000\u0000\u0000"+
		"\u04a4\u04a5\u0001\u0000\u0000\u0000\u04a5\u04a6\u0005\u007f\u0000\u0000"+
		"\u04a6\u00ad\u0001\u0000\u0000\u0000\u04a7\u04a9\u0005 \u0000\u0000\u04a8"+
		"\u04aa\u0007\u000f\u0000\u0000\u04a9\u04a8\u0001\u0000\u0000\u0000\u04a9"+
		"\u04aa\u0001\u0000\u0000\u0000\u04aa\u00af\u0001\u0000\u0000\u0000\u04ab"+
		"\u04ac\u0005}\u0000\u0000\u04ac\u04ad\u0003\u0096K\u0000\u04ad\u00b1\u0001"+
		"\u0000\u0000\u0000\u04ae\u04b3\u0003\u00b4Z\u0000\u04af\u04b0\u0005y\u0000"+
		"\u0000\u04b0\u04b2\u0003\u00b4Z\u0000\u04b1\u04af\u0001\u0000\u0000\u0000"+
		"\u04b2\u04b5\u0001\u0000\u0000\u0000\u04b3\u04b1\u0001\u0000\u0000\u0000"+
		"\u04b3\u04b4\u0001\u0000\u0000\u0000\u04b4\u00b3\u0001\u0000\u0000\u0000"+
		"\u04b5\u04b3\u0001\u0000\u0000\u0000\u04b6\u04b9\u0003\u00b6[\u0000\u04b7"+
		"\u04b8\u0005d\u0000\u0000\u04b8\u04ba\u0003\\.\u0000\u04b9\u04b7\u0001"+
		"\u0000\u0000\u0000\u04b9\u04ba\u0001\u0000\u0000\u0000\u04ba\u00b5\u0001"+
		"\u0000\u0000\u0000\u04bb\u04bc\u0005\u0083\u0000\u0000\u04bc\u00b7\u0001"+
		"\u0000\u0000\u0000\u04bd\u04c0\u0003\u00ba]\u0000\u04be\u04c0\u0003\u00be"+
		"_\u0000\u04bf\u04bd\u0001\u0000\u0000\u0000\u04bf\u04be\u0001\u0000\u0000"+
		"\u0000\u04c0\u00b9\u0001\u0000\u0000\u0000\u04c1\u04c2\u0005\u0083\u0000"+
		"\u0000\u04c2\u00bb\u0001\u0000\u0000\u0000\u04c3\u04c5\u0005+\u0000\u0000"+
		"\u04c4\u04c3\u0001\u0000\u0000\u0000\u04c4\u04c5\u0001\u0000\u0000\u0000"+
		"\u04c5\u04c6\u0001\u0000\u0000\u0000\u04c6\u04c9\u0005/\u0000\u0000\u04c7"+
		"\u04ca\u0005\u0083\u0000\u0000\u04c8\u04ca\u0003\u00ba]\u0000\u04c9\u04c7"+
		"\u0001\u0000\u0000\u0000\u04c9\u04c8\u0001\u0000\u0000\u0000\u04c9\u04ca"+
		"\u0001\u0000\u0000\u0000\u04ca\u04cb\u0001\u0000\u0000\u0000\u04cb\u04cd"+
		"\u0005X\u0000\u0000\u04cc\u04ce\u0003x<\u0000\u04cd\u04cc\u0001\u0000"+
		"\u0000\u0000\u04cd\u04ce\u0001\u0000\u0000\u0000\u04ce\u04cf\u0001\u0000"+
		"\u0000\u0000\u04cf\u04d0\u0005Y\u0000\u0000\u04d0\u00bd\u0001\u0000\u0000"+
		"\u0000\u04d1\u04d2\u0005\u0083\u0000\u0000\u04d2\u00bf\u0001\u0000\u0000"+
		"\u0000\u04d3\u04d4\u0005/\u0000\u0000\u04d4\u04d5\u0005\u0083\u0000\u0000"+
		"\u04d5\u04d6\u0005d\u0000\u0000\u04d6\u04d7\u0003\u00c2a\u0000\u04d7\u04d8"+
		"\u0005\u007f\u0000\u0000\u04d8\u00c1\u0001\u0000\u0000\u0000\u04d9\u04db"+
		"\u0003\n\u0005\u0000\u04da\u04d9\u0001\u0000\u0000\u0000\u04da\u04db\u0001"+
		"\u0000\u0000\u0000\u04db\u04dc\u0001\u0000\u0000\u0000\u04dc\u04dd\u0003"+
		"\u00b8\\\u0000\u04dd\u00c3\u0001\u0000\u0000\u0000\u04de\u04e4\u0005N"+
		"\u0000\u0000\u04df\u04e1\u0005K\u0000\u0000\u04e0\u04df\u0001\u0000\u0000"+
		"\u0000\u04e0\u04e1\u0001\u0000\u0000\u0000\u04e1\u04e2\u0001\u0000\u0000"+
		"\u0000\u04e2\u04e5\u0003\n\u0005\u0000\u04e3\u04e5\u0005~\u0000\u0000"+
		"\u04e4\u04e0\u0001\u0000\u0000\u0000\u04e4\u04e3\u0001\u0000\u0000\u0000"+
		"\u04e5\u04e6\u0001\u0000\u0000\u0000\u04e6\u04e7\u0003\u0006\u0003\u0000"+
		"\u04e7\u04e8\u0005\u007f\u0000\u0000\u04e8\u00c5\u0001\u0000\u0000\u0000"+
		"\u04e9\u04eb\u0003\u00ccf\u0000\u04ea\u04e9\u0001\u0000\u0000\u0000\u04ea"+
		"\u04eb\u0001\u0000\u0000\u0000\u04eb\u04ec\u0001\u0000\u0000\u0000\u04ec"+
		"\u04ed\u0005N\u0000\u0000\u04ed\u04ef\u0005/\u0000\u0000\u04ee\u04f0\u0003"+
		"\n\u0005\u0000\u04ef\u04ee\u0001\u0000\u0000\u0000\u04ef\u04f0\u0001\u0000"+
		"\u0000\u0000\u04f0\u04f1\u0001\u0000\u0000\u0000\u04f1\u04f2\u0003\u00b8"+
		"\\\u0000\u04f2\u04f3\u0005\u007f\u0000\u0000\u04f3\u00c7\u0001\u0000\u0000"+
		"\u0000\u04f4\u04f5\u0005\u000b\u0000\u0000\u04f5\u04f6\u0005T\u0000\u0000"+
		"\u04f6\u04f7\u0005\u0004\u0000\u0000\u04f7\u04f8\u0005U\u0000\u0000\u04f8"+
		"\u04f9\u0005\u007f\u0000\u0000\u04f9\u00c9\u0001\u0000\u0000\u0000\u04fa"+
		"\u04fb\u0005#\u0000\u0000\u04fb\u0502\u0005\u0004\u0000\u0000\u04fc\u04fe"+
		"\u0005X\u0000\u0000\u04fd\u04ff\u0003x<\u0000\u04fe\u04fd\u0001\u0000"+
		"\u0000\u0000\u04fe\u04ff\u0001\u0000\u0000\u0000\u04ff\u0500\u0001\u0000"+
		"\u0000\u0000\u0500\u0503\u0005Y\u0000\u0000\u0501\u0503\u0003z=\u0000"+
		"\u0502\u04fc\u0001\u0000\u0000\u0000\u0502\u0501\u0001\u0000\u0000\u0000"+
		"\u0503\u00cb\u0001\u0000\u0000\u0000\u0504\u0506\u0003\u00ceg\u0000\u0505"+
		"\u0504\u0001\u0000\u0000\u0000\u0506\u0507\u0001\u0000\u0000\u0000\u0507"+
		"\u0505\u0001\u0000\u0000\u0000\u0507\u0508\u0001\u0000\u0000\u0000\u0508"+
		"\u00cd\u0001\u0000\u0000\u0000\u0509\u050a\u0005V\u0000\u0000\u050a\u050c"+
		"\u0005V\u0000\u0000\u050b\u050d\u0003\u00d2i\u0000\u050c\u050b\u0001\u0000"+
		"\u0000\u0000\u050c\u050d\u0001\u0000\u0000\u0000\u050d\u050e\u0001\u0000"+
		"\u0000\u0000\u050e\u050f\u0005W\u0000\u0000\u050f\u0512\u0005W\u0000\u0000"+
		"\u0510\u0512\u0003\u00d0h\u0000\u0511\u0509\u0001\u0000\u0000\u0000\u0511"+
		"\u0510\u0001\u0000\u0000\u0000\u0512\u00cf\u0001\u0000\u0000\u0000\u0513"+
		"\u0514\u0005\t\u0000\u0000\u0514\u0517\u0005T\u0000\u0000\u0515\u0518"+
		"\u0003\u00f6{\u0000\u0516\u0518\u0003\\.\u0000\u0517\u0515\u0001\u0000"+
		"\u0000\u0000\u0517\u0516\u0001\u0000\u0000\u0000\u0518\u051a\u0001\u0000"+
		"\u0000\u0000\u0519\u051b\u0005\u0082\u0000\u0000\u051a\u0519\u0001\u0000"+
		"\u0000\u0000\u051a\u051b\u0001\u0000\u0000\u0000\u051b\u051c\u0001\u0000"+
		"\u0000\u0000\u051c\u051d\u0005U\u0000\u0000\u051d\u00d1\u0001\u0000\u0000"+
		"\u0000\u051e\u0523\u0003\u00d4j\u0000\u051f\u0520\u0005y\u0000\u0000\u0520"+
		"\u0522\u0003\u00d4j\u0000\u0521\u051f\u0001\u0000\u0000\u0000\u0522\u0525"+
		"\u0001\u0000\u0000\u0000\u0523\u0521\u0001\u0000\u0000\u0000\u0523\u0524"+
		"\u0001\u0000\u0000\u0000\u0524\u0527\u0001\u0000\u0000\u0000\u0525\u0523"+
		"\u0001\u0000\u0000\u0000\u0526\u0528\u0005\u0082\u0000\u0000\u0527\u0526"+
		"\u0001\u0000\u0000\u0000\u0527\u0528\u0001\u0000\u0000\u0000\u0528\u00d3"+
		"\u0001\u0000\u0000\u0000\u0529\u052a\u0003\u00d6k\u0000\u052a\u052b\u0005"+
		"~\u0000\u0000\u052b\u052d\u0001\u0000\u0000\u0000\u052c\u0529\u0001\u0000"+
		"\u0000\u0000\u052c\u052d\u0001\u0000\u0000\u0000\u052d\u052e\u0001\u0000"+
		"\u0000\u0000\u052e\u0530\u0005\u0083\u0000\u0000\u052f\u0531\u0003\u00d8"+
		"l\u0000\u0530\u052f\u0001\u0000\u0000\u0000\u0530\u0531\u0001\u0000\u0000"+
		"\u0000\u0531\u00d5\u0001\u0000\u0000\u0000\u0532\u0533\u0005\u0083\u0000"+
		"\u0000\u0533\u00d7\u0001\u0000\u0000\u0000\u0534\u0536\u0005T\u0000\u0000"+
		"\u0535\u0537\u0003\u00dam\u0000\u0536\u0535\u0001\u0000\u0000\u0000\u0536"+
		"\u0537\u0001\u0000\u0000\u0000\u0537\u0538\u0001\u0000\u0000\u0000\u0538"+
		"\u0539\u0005U\u0000\u0000\u0539\u00d9\u0001\u0000\u0000\u0000\u053a\u053c"+
		"\u0003\u00dcn\u0000\u053b\u053a\u0001\u0000\u0000\u0000\u053c\u053d\u0001"+
		"\u0000\u0000\u0000\u053d\u053b\u0001\u0000\u0000\u0000\u053d\u053e\u0001"+
		"\u0000\u0000\u0000\u053e\u00db\u0001\u0000\u0000\u0000\u053f\u0540\u0005"+
		"T\u0000\u0000\u0540\u0541\u0003\u00dam\u0000\u0541\u0542\u0005U\u0000"+
		"\u0000\u0542\u0551\u0001\u0000\u0000\u0000\u0543\u0544\u0005V\u0000\u0000"+
		"\u0544\u0545\u0003\u00dam\u0000\u0545\u0546\u0005W\u0000\u0000\u0546\u0551"+
		"\u0001\u0000\u0000\u0000\u0547\u0548\u0005X\u0000\u0000\u0548\u0549\u0003"+
		"\u00dam\u0000\u0549\u054a\u0005Y\u0000\u0000\u054a\u0551\u0001\u0000\u0000"+
		"\u0000\u054b\u054d\b\u0010\u0000\u0000\u054c\u054b\u0001\u0000\u0000\u0000"+
		"\u054d\u054e\u0001\u0000\u0000\u0000\u054e\u054c\u0001\u0000\u0000\u0000"+
		"\u054e\u054f\u0001\u0000\u0000\u0000\u054f\u0551\u0001\u0000\u0000\u0000"+
		"\u0550\u053f\u0001\u0000\u0000\u0000\u0550\u0543\u0001\u0000\u0000\u0000"+
		"\u0550\u0547\u0001\u0000\u0000\u0000\u0550\u054c\u0001\u0000\u0000\u0000"+
		"\u0551\u00dd\u0001\u0000\u0000\u0000\u0552\u0557\u0003\u00e0p\u0000\u0553"+
		"\u0554\u0005y\u0000\u0000\u0554\u0556\u0003\u00e0p\u0000\u0555\u0553\u0001"+
		"\u0000\u0000\u0000\u0556\u0559\u0001\u0000\u0000\u0000\u0557\u0555\u0001"+
		"\u0000\u0000\u0000\u0557\u0558\u0001\u0000\u0000\u0000\u0558\u00df\u0001"+
		"\u0000\u0000\u0000\u0559\u0557\u0001\u0000\u0000\u0000\u055a\u055c\u0003"+
		"\u00e2q\u0000\u055b\u055d\u0003\u010c\u0086\u0000\u055c\u055b\u0001\u0000"+
		"\u0000\u0000\u055c\u055d\u0001\u0000\u0000\u0000\u055d\u00e1\u0001\u0000"+
		"\u0000\u0000\u055e\u0564\u0003\u00e4r\u0000\u055f\u0560\u0003\u00e6s\u0000"+
		"\u0560\u0561\u0003\u00e8t\u0000\u0561\u0562\u0003\u00eau\u0000\u0562\u0564"+
		"\u0001\u0000\u0000\u0000\u0563\u055e\u0001\u0000\u0000\u0000\u0563\u055f"+
		"\u0001\u0000\u0000\u0000\u0564\u00e3\u0001\u0000\u0000\u0000\u0565\u0567"+
		"\u0003\u00ecv\u0000\u0566\u0568\u0005\u0015\u0000\u0000\u0567\u0566\u0001"+
		"\u0000\u0000\u0000\u0567\u0568\u0001\u0000\u0000\u0000\u0568\u056a\u0001"+
		"\u0000\u0000\u0000\u0569\u0565\u0001\u0000\u0000\u0000\u056a\u056d\u0001"+
		"\u0000\u0000\u0000\u056b\u0569\u0001\u0000\u0000\u0000\u056b\u056c\u0001"+
		"\u0000\u0000\u0000\u056c\u056e\u0001\u0000\u0000\u0000\u056d\u056b\u0001"+
		"\u0000\u0000\u0000\u056e\u056f\u0003\u00e6s\u0000\u056f\u00e5\u0001\u0000"+
		"\u0000\u0000\u0570\u0571\u0006s\uffff\uffff\u0000\u0571\u0573\u0003\u00f4"+
		"z\u0000\u0572\u0574\u0003\u00ccf\u0000\u0573\u0572\u0001\u0000\u0000\u0000"+
		"\u0573\u0574\u0001\u0000\u0000\u0000\u0574\u057a\u0001\u0000\u0000\u0000"+
		"\u0575\u0576\u0005T\u0000\u0000\u0576\u0577\u0003\u00e4r\u0000\u0577\u0578"+
		"\u0005U\u0000\u0000\u0578\u057a\u0001\u0000\u0000\u0000\u0579\u0570\u0001"+
		"\u0000\u0000\u0000\u0579\u0575\u0001\u0000\u0000\u0000\u057a\u0589\u0001"+
		"\u0000\u0000\u0000\u057b\u0585\n\u0002\u0000\u0000\u057c\u0586\u0003\u00e8"+
		"t\u0000\u057d\u057f\u0005V\u0000\u0000\u057e\u0580\u0003\\.\u0000\u057f"+
		"\u057e\u0001\u0000\u0000\u0000\u057f\u0580\u0001\u0000\u0000\u0000\u0580"+
		"\u0581\u0001\u0000\u0000\u0000\u0581\u0583\u0005W\u0000\u0000\u0582\u0584"+
		"\u0003\u00ccf\u0000\u0583\u0582\u0001\u0000\u0000\u0000\u0583\u0584\u0001"+
		"\u0000\u0000\u0000\u0584\u0586\u0001\u0000\u0000\u0000\u0585\u057c\u0001"+
		"\u0000\u0000\u0000\u0585\u057d\u0001\u0000\u0000\u0000\u0586\u0588\u0001"+
		"\u0000\u0000\u0000\u0587\u057b\u0001\u0000\u0000\u0000\u0588\u058b\u0001"+
		"\u0000\u0000\u0000\u0589\u0587\u0001\u0000\u0000\u0000\u0589\u058a\u0001"+
		"\u0000\u0000\u0000\u058a\u00e7\u0001\u0000\u0000\u0000\u058b\u0589\u0001"+
		"\u0000\u0000\u0000\u058c\u058e\u0005T\u0000\u0000\u058d\u058f\u0003\u0102"+
		"\u0081\u0000\u058e\u058d\u0001\u0000\u0000\u0000\u058e\u058f\u0001\u0000"+
		"\u0000\u0000\u058f\u0590\u0001\u0000\u0000\u0000\u0590\u0592\u0005U\u0000"+
		"\u0000\u0591\u0593\u0003\u00eew\u0000\u0592\u0591\u0001\u0000\u0000\u0000"+
		"\u0592\u0593\u0001\u0000\u0000\u0000\u0593\u0595\u0001\u0000\u0000\u0000"+
		"\u0594\u0596\u0003\u00f2y\u0000\u0595\u0594\u0001\u0000\u0000\u0000\u0595"+
		"\u0596\u0001\u0000\u0000\u0000\u0596\u0598\u0001\u0000\u0000\u0000\u0597"+
		"\u0599\u0003\u0172\u00b9\u0000\u0598\u0597\u0001\u0000\u0000\u0000\u0598"+
		"\u0599\u0001\u0000\u0000\u0000\u0599\u059b\u0001\u0000\u0000\u0000\u059a"+
		"\u059c\u0003\u00ccf\u0000\u059b\u059a\u0001\u0000\u0000\u0000\u059b\u059c"+
		"\u0001\u0000\u0000\u0000\u059c\u00e9\u0001\u0000\u0000\u0000\u059d\u059e"+
		"\u0005{\u0000\u0000\u059e\u05a0\u0003\u0098L\u0000\u059f\u05a1\u0003\u00f8"+
		"|\u0000\u05a0\u059f\u0001\u0000\u0000\u0000\u05a0\u05a1\u0001\u0000\u0000"+
		"\u0000\u05a1\u00eb\u0001\u0000\u0000\u0000\u05a2\u05a4\u0007\u0011\u0000"+
		"\u0000\u05a3\u05a5\u0003\u00ccf\u0000\u05a4\u05a3\u0001\u0000\u0000\u0000"+
		"\u05a4\u05a5\u0001\u0000\u0000\u0000\u05a5\u05b1\u0001\u0000\u0000\u0000"+
		"\u05a6\u05a8\u0003\n\u0005\u0000\u05a7\u05a6\u0001\u0000\u0000\u0000\u05a7"+
		"\u05a8\u0001\u0000\u0000\u0000\u05a8\u05a9\u0001\u0000\u0000\u0000\u05a9"+
		"\u05ab\u0005\\\u0000\u0000\u05aa\u05ac\u0003\u00ccf\u0000\u05ab\u05aa"+
		"\u0001\u0000\u0000\u0000\u05ab\u05ac\u0001\u0000\u0000\u0000\u05ac\u05ae"+
		"\u0001\u0000\u0000\u0000\u05ad\u05af\u0003\u00eew\u0000\u05ae\u05ad\u0001"+
		"\u0000\u0000\u0000\u05ae\u05af\u0001\u0000\u0000\u0000\u05af\u05b1\u0001"+
		"\u0000\u0000\u0000\u05b0\u05a2\u0001\u0000\u0000\u0000\u05b0\u05a7\u0001"+
		"\u0000\u0000\u0000\u05b1\u00ed\u0001\u0000\u0000\u0000\u05b2\u05b4\u0003"+
		"\u00f0x\u0000\u05b3\u05b2\u0001\u0000\u0000\u0000\u05b4\u05b5\u0001\u0000"+
		"\u0000\u0000\u05b5\u05b3\u0001\u0000\u0000\u0000\u05b5\u05b6\u0001\u0000"+
		"\u0000\u0000\u05b6\u00ef\u0001\u0000\u0000\u0000\u05b7\u05b8\u0007\u0012"+
		"\u0000\u0000\u05b8\u00f1\u0001\u0000\u0000\u0000\u05b9\u05ba\u0007\u0011"+
		"\u0000\u0000\u05ba\u00f3\u0001\u0000\u0000\u0000\u05bb\u05bd\u0005\u0082"+
		"\u0000\u0000\u05bc\u05bb\u0001\u0000\u0000\u0000\u05bc\u05bd\u0001\u0000"+
		"\u0000\u0000\u05bd\u05be\u0001\u0000\u0000\u0000\u05be\u05bf\u0003\u0004"+
		"\u0002\u0000\u05bf\u00f5\u0001\u0000\u0000\u0000\u05c0\u05c2\u0003\u0096"+
		"K\u0000\u05c1\u05c3\u0003\u00f8|\u0000\u05c2\u05c1\u0001\u0000\u0000\u0000"+
		"\u05c2\u05c3\u0001\u0000\u0000\u0000\u05c3\u00f7\u0001\u0000\u0000\u0000"+
		"\u05c4\u05cd\u0003\u00fa}\u0000\u05c5\u05c7\u0003\u00fc~\u0000\u05c6\u05c5"+
		"\u0001\u0000\u0000\u0000\u05c6\u05c7\u0001\u0000\u0000\u0000\u05c7\u05c8"+
		"\u0001\u0000\u0000\u0000\u05c8\u05c9\u0003\u00e8t\u0000\u05c9\u05ca\u0003"+
		"\u00eau\u0000\u05ca\u05cd\u0001\u0000\u0000\u0000\u05cb\u05cd\u0003\u00fe"+
		"\u007f\u0000\u05cc\u05c4\u0001\u0000\u0000\u0000\u05cc\u05c6\u0001\u0000"+
		"\u0000\u0000\u05cc\u05cb\u0001\u0000\u0000\u0000\u05cd\u00f9\u0001\u0000"+
		"\u0000\u0000\u05ce\u05d8\u0003\u00fc~\u0000\u05cf\u05d1\u0003\u00ecv\u0000"+
		"\u05d0\u05cf\u0001\u0000\u0000\u0000\u05d1\u05d2\u0001\u0000\u0000\u0000"+
		"\u05d2\u05d0\u0001\u0000\u0000\u0000\u05d2\u05d3\u0001\u0000\u0000\u0000"+
		"\u05d3\u05d5\u0001\u0000\u0000\u0000\u05d4\u05d6\u0003\u00fc~\u0000\u05d5"+
		"\u05d4\u0001\u0000\u0000\u0000\u05d5\u05d6\u0001\u0000\u0000\u0000\u05d6"+
		"\u05d8\u0001\u0000\u0000\u0000\u05d7\u05ce\u0001\u0000\u0000\u0000\u05d7"+
		"\u05d0\u0001\u0000\u0000\u0000\u05d8\u00fb\u0001\u0000\u0000\u0000\u05d9"+
		"\u05da\u0006~\uffff\uffff\u0000\u05da\u05e8\u0003\u00e8t\u0000\u05db\u05dd"+
		"\u0005V\u0000\u0000\u05dc\u05de\u0003\\.\u0000\u05dd\u05dc\u0001\u0000"+
		"\u0000\u0000\u05dd\u05de\u0001\u0000\u0000\u0000\u05de\u05df\u0001\u0000"+
		"\u0000\u0000\u05df\u05e1\u0005W\u0000\u0000\u05e0\u05e2\u0003\u00ccf\u0000"+
		"\u05e1\u05e0\u0001\u0000\u0000\u0000\u05e1\u05e2\u0001\u0000\u0000\u0000"+
		"\u05e2\u05e8\u0001\u0000\u0000\u0000\u05e3\u05e4\u0005T\u0000\u0000\u05e4"+
		"\u05e5\u0003\u00fa}\u0000\u05e5\u05e6\u0005U\u0000\u0000\u05e6\u05e8\u0001"+
		"\u0000\u0000\u0000\u05e7\u05d9\u0001\u0000\u0000\u0000\u05e7\u05db\u0001"+
		"\u0000\u0000\u0000\u05e7\u05e3\u0001\u0000\u0000\u0000\u05e8\u05f8\u0001"+
		"\u0000\u0000\u0000\u05e9\u05f4\n\u0004\u0000\u0000\u05ea\u05f5\u0003\u00e8"+
		"t\u0000\u05eb\u05ec\u0003\u00fc~\u0000\u05ec\u05ee\u0005V\u0000\u0000"+
		"\u05ed\u05ef\u0003\\.\u0000\u05ee\u05ed\u0001\u0000\u0000\u0000\u05ee"+
		"\u05ef\u0001\u0000\u0000\u0000\u05ef\u05f0\u0001\u0000\u0000\u0000\u05f0"+
		"\u05f2\u0005W\u0000\u0000\u05f1\u05f3\u0003\u00ccf\u0000\u05f2\u05f1\u0001"+
		"\u0000\u0000\u0000\u05f2\u05f3\u0001\u0000\u0000\u0000\u05f3\u05f5\u0001"+
		"\u0000\u0000\u0000\u05f4\u05ea\u0001\u0000\u0000\u0000\u05f4\u05eb\u0001"+
		"\u0000\u0000\u0000\u05f5\u05f7\u0001\u0000\u0000\u0000\u05f6\u05e9\u0001"+
		"\u0000\u0000\u0000\u05f7\u05fa\u0001\u0000\u0000\u0000\u05f8\u05f6\u0001"+
		"\u0000\u0000\u0000\u05f8\u05f9\u0001\u0000\u0000\u0000\u05f9\u00fd\u0001"+
		"\u0000\u0000\u0000\u05fa\u05f8\u0001\u0000\u0000\u0000\u05fb\u05fd\u0003"+
		"\u00ecv\u0000\u05fc\u05fb\u0001\u0000\u0000\u0000\u05fd\u0600\u0001\u0000"+
		"\u0000\u0000\u05fe\u05fc\u0001\u0000\u0000\u0000\u05fe\u05ff\u0001\u0000"+
		"\u0000\u0000\u05ff\u0601\u0001\u0000\u0000\u0000\u0600\u05fe\u0001\u0000"+
		"\u0000\u0000\u0601\u0602\u0003\u0100\u0080\u0000\u0602\u00ff\u0001\u0000"+
		"\u0000\u0000\u0603\u0604\u0006\u0080\uffff\uffff\u0000\u0604\u0605\u0005"+
		"\u0082\u0000\u0000\u0605\u0614\u0001\u0000\u0000\u0000\u0606\u0610\n\u0002"+
		"\u0000\u0000\u0607\u0611\u0003\u00e8t\u0000\u0608\u060a\u0005V\u0000\u0000"+
		"\u0609\u060b\u0003\\.\u0000\u060a\u0609\u0001\u0000\u0000\u0000\u060a"+
		"\u060b\u0001\u0000\u0000\u0000\u060b\u060c\u0001\u0000\u0000\u0000\u060c"+
		"\u060e\u0005W\u0000\u0000\u060d\u060f\u0003\u00ccf\u0000\u060e\u060d\u0001"+
		"\u0000\u0000\u0000\u060e\u060f\u0001\u0000\u0000\u0000\u060f\u0611\u0001"+
		"\u0000\u0000\u0000\u0610\u0607\u0001\u0000\u0000\u0000\u0610\u0608\u0001"+
		"\u0000\u0000\u0000\u0611\u0613\u0001\u0000\u0000\u0000\u0612\u0606\u0001"+
		"\u0000\u0000\u0000\u0613\u0616\u0001\u0000\u0000\u0000\u0614\u0612\u0001"+
		"\u0000\u0000\u0000\u0614\u0615\u0001\u0000\u0000\u0000\u0615\u0101\u0001"+
		"\u0000\u0000\u0000\u0616\u0614\u0001\u0000\u0000\u0000\u0617\u061c\u0003"+
		"\u0104\u0082\u0000\u0618\u061a\u0005y\u0000\u0000\u0619\u0618\u0001\u0000"+
		"\u0000\u0000\u0619\u061a\u0001\u0000\u0000\u0000\u061a\u061b\u0001\u0000"+
		"\u0000\u0000\u061b\u061d\u0005\u0082\u0000\u0000\u061c\u0619\u0001\u0000"+
		"\u0000\u0000\u061c\u061d\u0001\u0000\u0000\u0000\u061d\u0103\u0001\u0000"+
		"\u0000\u0000\u061e\u0623\u0003\u0106\u0083\u0000\u061f\u0620\u0005y\u0000"+
		"\u0000\u0620\u0622\u0003\u0106\u0083\u0000\u0621\u061f\u0001\u0000\u0000"+
		"\u0000\u0622\u0625\u0001\u0000\u0000\u0000\u0623\u0621\u0001\u0000\u0000"+
		"\u0000\u0623\u0624\u0001\u0000\u0000\u0000\u0624\u0105\u0001\u0000\u0000"+
		"\u0000\u0625\u0623\u0001\u0000\u0000\u0000\u0626\u0628\u0003\u00ccf\u0000"+
		"\u0627\u0626\u0001\u0000\u0000\u0000\u0627\u0628\u0001\u0000\u0000\u0000"+
		"\u0628\u0629\u0001\u0000\u0000\u0000\u0629\u062e\u0003\u008aE\u0000\u062a"+
		"\u062f\u0003\u00e2q\u0000\u062b\u062d\u0003\u00f8|\u0000\u062c\u062b\u0001"+
		"\u0000\u0000\u0000\u062c\u062d\u0001\u0000\u0000\u0000\u062d\u062f\u0001"+
		"\u0000\u0000\u0000\u062e\u062a\u0001\u0000\u0000\u0000\u062e\u062c\u0001"+
		"\u0000\u0000\u0000\u062f\u0632\u0001\u0000\u0000\u0000\u0630\u0631\u0005"+
		"d\u0000\u0000\u0631\u0633\u0003\u0110\u0088\u0000\u0632\u0630\u0001\u0000"+
		"\u0000\u0000\u0632\u0633\u0001\u0000\u0000\u0000\u0633\u0107\u0001\u0000"+
		"\u0000\u0000\u0634\u0636\u0003\u00ccf\u0000\u0635\u0634\u0001\u0000\u0000"+
		"\u0000\u0635\u0636\u0001\u0000\u0000\u0000\u0636\u0638\u0001\u0000\u0000"+
		"\u0000\u0637\u0639\u0003\u008aE\u0000\u0638\u0637\u0001\u0000\u0000\u0000"+
		"\u0638\u0639\u0001\u0000\u0000\u0000\u0639\u063a\u0001\u0000\u0000\u0000"+
		"\u063a\u063c\u0003\u00e2q\u0000\u063b\u063d\u0003\u012a\u0095\u0000\u063c"+
		"\u063b\u0001\u0000\u0000\u0000\u063c\u063d\u0001\u0000\u0000\u0000\u063d"+
		"\u063e\u0001\u0000\u0000\u0000\u063e\u063f\u0003\u010a\u0085\u0000\u063f"+
		"\u0109\u0001\u0000\u0000\u0000\u0640\u0642\u0003\u0142\u00a1\u0000\u0641"+
		"\u0640\u0001\u0000\u0000\u0000\u0641\u0642\u0001\u0000\u0000\u0000\u0642"+
		"\u0643\u0001\u0000\u0000\u0000\u0643\u0649\u0003d2\u0000\u0644\u0649\u0003"+
		"\u0168\u00b4\u0000\u0645\u0646\u0005d\u0000\u0000\u0646\u0647\u0007\u0013"+
		"\u0000\u0000\u0647\u0649\u0005\u007f\u0000\u0000\u0648\u0641\u0001\u0000"+
		"\u0000\u0000\u0648\u0644\u0001\u0000\u0000\u0000\u0648\u0645\u0001\u0000"+
		"\u0000\u0000\u0649\u010b\u0001\u0000\u0000\u0000\u064a\u0650\u0003\u010e"+
		"\u0087\u0000\u064b\u064c\u0005T\u0000\u0000\u064c\u064d\u0003\"\u0011"+
		"\u0000\u064d\u064e\u0005U\u0000\u0000\u064e\u0650\u0001\u0000\u0000\u0000"+
		"\u064f\u064a\u0001\u0000\u0000\u0000\u064f\u064b\u0001\u0000\u0000\u0000"+
		"\u0650\u010d\u0001\u0000\u0000\u0000\u0651\u0652\u0005d\u0000\u0000\u0652"+
		"\u0655\u0003\u0110\u0088\u0000\u0653\u0655\u0003\u0114\u008a\u0000\u0654"+
		"\u0651\u0001\u0000\u0000\u0000\u0654\u0653\u0001\u0000\u0000\u0000\u0655"+
		"\u010f\u0001\u0000\u0000\u0000\u0656\u0659\u0003V+\u0000\u0657\u0659\u0003"+
		"\u0114\u008a\u0000\u0658\u0656\u0001\u0000\u0000\u0000\u0658\u0657\u0001"+
		"\u0000\u0000\u0000\u0659\u0111\u0001\u0000\u0000\u0000\u065a\u065c\u0003"+
		"\u0110\u0088\u0000\u065b\u065d\u0005\u0082\u0000\u0000\u065c\u065b\u0001"+
		"\u0000\u0000\u0000\u065c\u065d\u0001\u0000\u0000\u0000\u065d\u0665\u0001"+
		"\u0000\u0000\u0000\u065e\u065f\u0005y\u0000\u0000\u065f\u0661\u0003\u0110"+
		"\u0088\u0000\u0660\u0662\u0005\u0082\u0000\u0000\u0661\u0660\u0001\u0000"+
		"\u0000\u0000\u0661\u0662\u0001\u0000\u0000\u0000\u0662\u0664\u0001\u0000"+
		"\u0000\u0000\u0663\u065e\u0001\u0000\u0000\u0000\u0664\u0667\u0001\u0000"+
		"\u0000\u0000\u0665\u0663\u0001\u0000\u0000\u0000\u0665\u0666\u0001\u0000"+
		"\u0000\u0000\u0666\u0113\u0001\u0000\u0000\u0000\u0667\u0665\u0001\u0000"+
		"\u0000\u0000\u0668\u066d\u0005X\u0000\u0000\u0669\u066b\u0003\u0112\u0089"+
		"\u0000\u066a\u066c\u0005y\u0000\u0000\u066b\u066a\u0001\u0000\u0000\u0000"+
		"\u066b\u066c\u0001\u0000\u0000\u0000\u066c\u066e\u0001\u0000\u0000\u0000"+
		"\u066d\u0669\u0001\u0000\u0000\u0000\u066d\u066e\u0001\u0000\u0000\u0000"+
		"\u066e\u066f\u0001\u0000\u0000\u0000\u066f\u0670\u0005Y\u0000\u0000\u0670"+
		"\u0115\u0001\u0000\u0000\u0000\u0671\u0674\u0005\u0083\u0000\u0000\u0672"+
		"\u0674\u0003\u0156\u00ab\u0000\u0673\u0671\u0001\u0000\u0000\u0000\u0673"+
		"\u0672\u0001\u0000\u0000\u0000\u0674\u0117\u0001\u0000\u0000\u0000\u0675"+
		"\u0676\u0003\u011a\u008d\u0000\u0676\u0678\u0005X\u0000\u0000\u0677\u0679"+
		"\u0003\u0122\u0091\u0000\u0678\u0677\u0001\u0000\u0000\u0000\u0678\u0679"+
		"\u0001\u0000\u0000\u0000\u0679\u067a\u0001\u0000\u0000\u0000\u067a\u067b"+
		"\u0005Y\u0000\u0000\u067b\u0119\u0001\u0000\u0000\u0000\u067c\u067e\u0003"+
		"\u0120\u0090\u0000\u067d\u067f\u0003\u00ccf\u0000\u067e\u067d\u0001\u0000"+
		"\u0000\u0000\u067e\u067f\u0001\u0000\u0000\u0000\u067f\u0684\u0001\u0000"+
		"\u0000\u0000\u0680\u0682\u0003\u011c\u008e\u0000\u0681\u0683\u0003\u011e"+
		"\u008f\u0000\u0682\u0681\u0001\u0000\u0000\u0000\u0682\u0683\u0001\u0000"+
		"\u0000\u0000\u0683\u0685\u0001\u0000\u0000\u0000\u0684\u0680\u0001\u0000"+
		"\u0000\u0000\u0684\u0685\u0001\u0000\u0000\u0000\u0685\u0687\u0001\u0000"+
		"\u0000\u0000\u0686\u0688\u0003\u0130\u0098\u0000\u0687\u0686\u0001\u0000"+
		"\u0000\u0000\u0687\u0688\u0001\u0000\u0000\u0000\u0688\u0694\u0001\u0000"+
		"\u0000\u0000\u0689\u068b\u0005L\u0000\u0000\u068a\u068c\u0003\u00ccf\u0000"+
		"\u068b\u068a\u0001\u0000\u0000\u0000\u068b\u068c\u0001\u0000\u0000\u0000"+
		"\u068c\u0691\u0001\u0000\u0000\u0000\u068d\u068f\u0003\u011c\u008e\u0000"+
		"\u068e\u0690\u0003\u011e\u008f\u0000\u068f\u068e\u0001\u0000\u0000\u0000"+
		"\u068f\u0690\u0001\u0000\u0000\u0000\u0690\u0692\u0001\u0000\u0000\u0000"+
		"\u0691\u068d\u0001\u0000\u0000\u0000\u0691\u0692\u0001\u0000\u0000\u0000"+
		"\u0692\u0694\u0001\u0000\u0000\u0000\u0693\u067c\u0001\u0000\u0000\u0000"+
		"\u0693\u0689\u0001\u0000\u0000\u0000\u0694\u011b\u0001\u0000\u0000\u0000"+
		"\u0695\u0697\u0003\n\u0005\u0000\u0696\u0695\u0001\u0000\u0000\u0000\u0696"+
		"\u0697\u0001\u0000\u0000\u0000\u0697\u0698\u0001\u0000\u0000\u0000\u0698"+
		"\u0699\u0003\u0116\u008b\u0000\u0699\u011d\u0001\u0000\u0000\u0000\u069a"+
		"\u069b\u0005%\u0000\u0000\u069b\u011f\u0001\u0000\u0000\u0000\u069c\u069d"+
		"\u0007\u000f\u0000\u0000\u069d\u0121\u0001\u0000\u0000\u0000\u069e\u06a3"+
		"\u0003\u0124\u0092\u0000\u069f\u06a0\u0003\u013a\u009d\u0000\u06a0\u06a1"+
		"\u0005}\u0000\u0000\u06a1\u06a3\u0001\u0000\u0000\u0000\u06a2\u069e\u0001"+
		"\u0000\u0000\u0000\u06a2\u069f\u0001\u0000\u0000\u0000\u06a3\u06a4\u0001"+
		"\u0000\u0000\u0000\u06a4\u06a2\u0001\u0000\u0000\u0000\u06a4\u06a5\u0001"+
		"\u0000\u0000\u0000\u06a5\u0123\u0001\u0000\u0000\u0000\u06a6\u06a8\u0003"+
		"\u00ccf\u0000\u06a7\u06a6\u0001\u0000\u0000\u0000\u06a7\u06a8\u0001\u0000"+
		"\u0000\u0000\u06a8\u06aa\u0001\u0000\u0000\u0000\u06a9\u06ab\u0003\u008a"+
		"E\u0000\u06aa\u06a9\u0001\u0000\u0000\u0000\u06aa\u06ab\u0001\u0000\u0000"+
		"\u0000\u06ab\u06ad\u0001\u0000\u0000\u0000\u06ac\u06ae\u0003\u0126\u0093"+
		"\u0000\u06ad\u06ac\u0001\u0000\u0000\u0000\u06ad\u06ae\u0001\u0000\u0000"+
		"\u0000\u06ae\u06af\u0001\u0000\u0000\u0000\u06af\u06b7\u0005\u007f\u0000"+
		"\u0000\u06b0\u06b7\u0003\u0108\u0084\u0000\u06b1\u06b7\u0003\u00c4b\u0000"+
		"\u06b2\u06b7\u0003\u0082A\u0000\u06b3\u06b7\u0003\u014e\u00a7\u0000\u06b4"+
		"\u06b7\u0003~?\u0000\u06b5\u06b7\u0003\u0084B\u0000\u06b6\u06a7\u0001"+
		"\u0000\u0000\u0000\u06b6\u06b0\u0001\u0000\u0000\u0000\u06b6\u06b1\u0001"+
		"\u0000\u0000\u0000\u06b6\u06b2\u0001\u0000\u0000\u0000\u06b6\u06b3\u0001"+
		"\u0000\u0000\u0000\u06b6\u06b4\u0001\u0000\u0000\u0000\u06b6\u06b5\u0001"+
		"\u0000\u0000\u0000\u06b7\u0125\u0001\u0000\u0000\u0000\u06b8\u06bd\u0003"+
		"\u0128\u0094\u0000\u06b9\u06ba\u0005y\u0000\u0000\u06ba\u06bc\u0003\u0128"+
		"\u0094\u0000\u06bb\u06b9\u0001\u0000\u0000\u0000\u06bc\u06bf\u0001\u0000"+
		"\u0000\u0000\u06bd\u06bb\u0001\u0000\u0000\u0000\u06bd\u06be\u0001\u0000"+
		"\u0000\u0000\u06be\u0127\u0001\u0000\u0000\u0000\u06bf\u06bd\u0001\u0000"+
		"\u0000\u0000\u06c0\u06c9\u0003\u00e2q\u0000\u06c1\u06ca\u0003\u012a\u0095"+
		"\u0000\u06c2\u06c3\u0004\u0094\t\u0000\u06c3\u06ca\u0003\u012e\u0097\u0000"+
		"\u06c4\u06c5\u0004\u0094\n\u0000\u06c5\u06c6\u0003\u012a\u0095\u0000\u06c6"+
		"\u06c7\u0003\u012e\u0097\u0000\u06c7\u06ca\u0001\u0000\u0000\u0000\u06c8"+
		"\u06ca\u0003\u010e\u0087\u0000\u06c9\u06c1\u0001\u0000\u0000\u0000\u06c9"+
		"\u06c2\u0001\u0000\u0000\u0000\u06c9\u06c4\u0001\u0000\u0000\u0000\u06c9"+
		"\u06c8\u0001\u0000\u0000\u0000\u06ca\u06d5\u0001\u0000\u0000\u0000\u06cb"+
		"\u06d5\u0003\u00e2q\u0000\u06cc\u06ce\u0005\u0083\u0000\u0000\u06cd\u06cc"+
		"\u0001\u0000\u0000\u0000\u06cd\u06ce\u0001\u0000\u0000\u0000\u06ce\u06d0"+
		"\u0001\u0000\u0000\u0000\u06cf\u06d1\u0003\u00ccf\u0000\u06d0\u06cf\u0001"+
		"\u0000\u0000\u0000\u06d0\u06d1\u0001\u0000\u0000\u0000\u06d1\u06d2\u0001"+
		"\u0000\u0000\u0000\u06d2\u06d3\u0005}\u0000\u0000\u06d3\u06d5\u0003\\"+
		".\u0000\u06d4\u06c0\u0001\u0000\u0000\u0000\u06d4\u06cb\u0001\u0000\u0000"+
		"\u0000\u06d4\u06cd\u0001\u0000\u0000\u0000\u06d5\u0129\u0001\u0000\u0000"+
		"\u0000\u06d6\u06d8\u0003\u012c\u0096\u0000\u06d7\u06d6\u0001\u0000\u0000"+
		"\u0000\u06d8\u06d9\u0001\u0000\u0000\u0000\u06d9\u06d7\u0001\u0000\u0000"+
		"\u0000\u06d9\u06da\u0001\u0000\u0000\u0000\u06da\u012b\u0001\u0000\u0000"+
		"\u0000\u06db\u06dc\u0007\u0014\u0000\u0000\u06dc\u012d\u0001\u0000\u0000"+
		"\u0000\u06dd\u06de\u0005d\u0000\u0000\u06de\u06df\u0005\u0001\u0000\u0000"+
		"\u06df\u012f\u0001\u0000\u0000\u0000\u06e0\u06e1\u0005}\u0000\u0000\u06e1"+
		"\u06e2\u0003\u0132\u0099\u0000\u06e2\u0131\u0001\u0000\u0000\u0000\u06e3"+
		"\u06e5\u0003\u0134\u009a\u0000\u06e4\u06e6\u0005\u0082\u0000\u0000\u06e5"+
		"\u06e4\u0001\u0000\u0000\u0000\u06e5\u06e6\u0001\u0000\u0000\u0000\u06e6"+
		"\u06ee\u0001\u0000\u0000\u0000\u06e7\u06e8\u0005y\u0000\u0000\u06e8\u06ea"+
		"\u0003\u0134\u009a\u0000\u06e9\u06eb\u0005\u0082\u0000\u0000\u06ea\u06e9"+
		"\u0001\u0000\u0000\u0000\u06ea\u06eb\u0001\u0000\u0000\u0000\u06eb\u06ed"+
		"\u0001\u0000\u0000\u0000\u06ec\u06e7\u0001\u0000\u0000\u0000\u06ed\u06f0"+
		"\u0001\u0000\u0000\u0000\u06ee\u06ec\u0001\u0000\u0000\u0000\u06ee\u06ef"+
		"\u0001\u0000\u0000\u0000\u06ef\u0133\u0001\u0000\u0000\u0000\u06f0\u06ee"+
		"\u0001\u0000\u0000\u0000\u06f1\u06f3\u0003\u00ccf\u0000\u06f2\u06f1\u0001"+
		"\u0000\u0000\u0000\u06f2\u06f3\u0001\u0000\u0000\u0000\u06f3\u0700\u0001"+
		"\u0000\u0000\u0000\u06f4\u0701\u0003\u0138\u009c\u0000\u06f5\u06f7\u0005"+
		"O\u0000\u0000\u06f6\u06f8\u0003\u013a\u009d\u0000\u06f7\u06f6\u0001\u0000"+
		"\u0000\u0000\u06f7\u06f8\u0001\u0000\u0000\u0000\u06f8\u06f9\u0001\u0000"+
		"\u0000\u0000\u06f9\u0701\u0003\u0138\u009c\u0000\u06fa\u06fc\u0003\u013a"+
		"\u009d\u0000\u06fb\u06fd\u0005O\u0000\u0000\u06fc\u06fb\u0001\u0000\u0000"+
		"\u0000\u06fc\u06fd\u0001\u0000\u0000\u0000\u06fd\u06fe\u0001\u0000\u0000"+
		"\u0000\u06fe\u06ff\u0003\u0138\u009c\u0000\u06ff\u0701\u0001\u0000\u0000"+
		"\u0000\u0700\u06f4\u0001\u0000\u0000\u0000\u0700\u06f5\u0001\u0000\u0000"+
		"\u0000\u0700\u06fa\u0001\u0000\u0000\u0000\u0701\u0135\u0001\u0000\u0000"+
		"\u0000\u0702\u0704\u0003\n\u0005\u0000\u0703\u0702\u0001\u0000\u0000\u0000"+
		"\u0703\u0704\u0001\u0000\u0000\u0000\u0704\u0705\u0001\u0000\u0000\u0000"+
		"\u0705\u0708\u0003\u0116\u008b\u0000\u0706\u0708\u0003\u00a2Q\u0000\u0707"+
		"\u0703\u0001\u0000\u0000\u0000\u0707\u0706\u0001\u0000\u0000\u0000\u0708"+
		"\u0137\u0001\u0000\u0000\u0000\u0709\u070a\u0003\u0136\u009b\u0000\u070a"+
		"\u0139\u0001\u0000\u0000\u0000\u070b\u070c\u0007\u0015\u0000\u0000\u070c"+
		"\u013b\u0001\u0000\u0000\u0000\u070d\u070e\u00053\u0000\u0000\u070e\u070f"+
		"\u0003\u013e\u009f\u0000\u070f\u013d\u0001\u0000\u0000\u0000\u0710\u0712"+
		"\u0003\u0096K\u0000\u0711\u0713\u0003\u0140\u00a0\u0000\u0712\u0711\u0001"+
		"\u0000\u0000\u0000\u0712\u0713\u0001\u0000\u0000\u0000\u0713\u013f\u0001"+
		"\u0000\u0000\u0000\u0714\u0716\u0003\u00ecv\u0000\u0715\u0717\u0003\u0140"+
		"\u00a0\u0000\u0716\u0715\u0001\u0000\u0000\u0000\u0716\u0717\u0001\u0000"+
		"\u0000\u0000\u0717\u0141\u0001\u0000\u0000\u0000\u0718\u0719\u0005}\u0000"+
		"\u0000\u0719\u071a\u0003\u0144\u00a2\u0000\u071a\u0143\u0001\u0000\u0000"+
		"\u0000\u071b\u071d\u0003\u0146\u00a3\u0000\u071c\u071e\u0005\u0082\u0000"+
		"\u0000\u071d\u071c\u0001\u0000\u0000\u0000\u071d\u071e\u0001\u0000\u0000"+
		"\u0000\u071e\u0726\u0001\u0000\u0000\u0000\u071f\u0720\u0005y\u0000\u0000"+
		"\u0720\u0722\u0003\u0146\u00a3\u0000\u0721\u0723\u0005\u0082\u0000\u0000"+
		"\u0722\u0721\u0001\u0000\u0000\u0000\u0722\u0723\u0001\u0000\u0000\u0000"+
		"\u0723\u0725\u0001\u0000\u0000\u0000\u0724\u071f\u0001\u0000\u0000\u0000"+
		"\u0725\u0728\u0001\u0000\u0000\u0000\u0726\u0724\u0001\u0000\u0000\u0000"+
		"\u0726\u0727\u0001\u0000\u0000\u0000\u0727\u0145\u0001\u0000\u0000\u0000"+
		"\u0728\u0726\u0001\u0000\u0000\u0000\u0729\u0730\u0003\u0148\u00a4\u0000"+
		"\u072a\u072c\u0005T\u0000\u0000\u072b\u072d\u0003\"\u0011\u0000\u072c"+
		"\u072b\u0001\u0000\u0000\u0000\u072c\u072d\u0001\u0000\u0000\u0000\u072d"+
		"\u072e\u0001\u0000\u0000\u0000\u072e\u0731\u0005U\u0000\u0000\u072f\u0731"+
		"\u0003\u0114\u008a\u0000\u0730\u072a\u0001\u0000\u0000\u0000\u0730\u072f"+
		"\u0001\u0000\u0000\u0000\u0731\u0147\u0001\u0000\u0000\u0000\u0732\u0735"+
		"\u0003\u0136\u009b\u0000\u0733\u0735\u0005\u0083\u0000\u0000\u0734\u0732"+
		"\u0001\u0000\u0000\u0000\u0734\u0733\u0001\u0000\u0000\u0000\u0735\u0149"+
		"\u0001\u0000\u0000\u0000\u0736\u0737\u00053\u0000\u0000\u0737\u0738\u0003"+
		"\u017a\u00bd\u0000\u0738\u014b\u0001\u0000\u0000\u0000\u0739\u073d\u0005"+
		"3\u0000\u0000\u073a\u073b\u0005\u0004\u0000\u0000\u073b\u073e\u0005\u0083"+
		"\u0000\u0000\u073c\u073e\u0005\u008b\u0000\u0000\u073d\u073a\u0001\u0000"+
		"\u0000\u0000\u073d\u073c\u0001\u0000\u0000\u0000\u073e\u014d\u0001\u0000"+
		"\u0000\u0000\u073f\u0740\u0005C\u0000\u0000\u0740\u0741\u0005e\u0000\u0000"+
		"\u0741\u0742\u0003\u0150\u00a8\u0000\u0742\u0743\u0005f\u0000\u0000\u0743"+
		"\u0744\u0003z=\u0000\u0744\u014f\u0001\u0000\u0000\u0000\u0745\u074a\u0003"+
		"\u0152\u00a9\u0000\u0746\u0747\u0005y\u0000\u0000\u0747\u0749\u0003\u0152"+
		"\u00a9\u0000\u0748\u0746\u0001\u0000\u0000\u0000\u0749\u074c\u0001\u0000"+
		"\u0000\u0000\u074a\u0748\u0001\u0000\u0000\u0000\u074a\u074b\u0001\u0000"+
		"\u0000\u0000\u074b\u0151\u0001\u0000\u0000\u0000\u074c\u074a\u0001\u0000"+
		"\u0000\u0000\u074d\u0750\u0003\u0154\u00aa\u0000\u074e\u0750\u0003\u0106"+
		"\u0083\u0000\u074f\u074d\u0001\u0000\u0000\u0000\u074f\u074e\u0001\u0000"+
		"\u0000\u0000\u0750\u0153\u0001\u0000\u0000\u0000\u0751\u0752\u0005C\u0000"+
		"\u0000\u0752\u0753\u0005e\u0000\u0000\u0753\u0754\u0003\u0150\u00a8\u0000"+
		"\u0754\u0755\u0005f\u0000\u0000\u0755\u0757\u0001\u0000\u0000\u0000\u0756"+
		"\u0751\u0001\u0000\u0000\u0000\u0756\u0757\u0001\u0000\u0000\u0000\u0757"+
		"\u0758\u0001\u0000\u0000\u0000\u0758\u075b\u0005\u0014\u0000\u0000\u0759"+
		"\u075b\u0005K\u0000\u0000\u075a\u0756\u0001\u0000\u0000\u0000\u075a\u0759"+
		"\u0001\u0000\u0000\u0000\u075b\u0767\u0001\u0000\u0000\u0000\u075c\u075e"+
		"\u0005\u0082\u0000\u0000\u075d\u075c\u0001\u0000\u0000\u0000\u075d\u075e"+
		"\u0001\u0000\u0000\u0000\u075e\u0760\u0001\u0000\u0000\u0000\u075f\u0761"+
		"\u0005\u0083\u0000\u0000\u0760\u075f\u0001\u0000\u0000\u0000\u0760\u0761"+
		"\u0001\u0000\u0000\u0000\u0761\u0768\u0001\u0000\u0000\u0000\u0762\u0764"+
		"\u0005\u0083\u0000\u0000\u0763\u0762\u0001\u0000\u0000\u0000\u0763\u0764"+
		"\u0001\u0000\u0000\u0000\u0764\u0765\u0001\u0000\u0000\u0000\u0765\u0766"+
		"\u0005d\u0000\u0000\u0766\u0768\u0003\u00f6{\u0000\u0767\u075d\u0001\u0000"+
		"\u0000\u0000\u0767\u0763\u0001\u0000\u0000\u0000\u0768\u0155\u0001\u0000"+
		"\u0000\u0000\u0769\u076a\u0003\u015a\u00ad\u0000\u076a\u076c\u0005e\u0000"+
		"\u0000\u076b\u076d\u0003\u015c\u00ae\u0000\u076c\u076b\u0001\u0000\u0000"+
		"\u0000\u076c\u076d\u0001\u0000\u0000\u0000\u076d\u076e\u0001\u0000\u0000"+
		"\u0000\u076e\u076f\u0005f\u0000\u0000\u076f\u0157\u0001\u0000\u0000\u0000"+
		"\u0770\u077c\u0003\u0156\u00ab\u0000\u0771\u0774\u0003\u014a\u00a5\u0000"+
		"\u0772\u0774\u0003\u014c\u00a6\u0000\u0773\u0771\u0001\u0000\u0000\u0000"+
		"\u0773\u0772\u0001\u0000\u0000\u0000\u0774\u0775\u0001\u0000\u0000\u0000"+
		"\u0775\u0777\u0005e\u0000\u0000\u0776\u0778\u0003\u015c\u00ae\u0000\u0777"+
		"\u0776\u0001\u0000\u0000\u0000\u0777\u0778\u0001\u0000\u0000\u0000\u0778"+
		"\u0779\u0001\u0000\u0000\u0000\u0779\u077a\u0005f\u0000\u0000\u077a\u077c"+
		"\u0001\u0000\u0000\u0000\u077b\u0770\u0001\u0000\u0000\u0000\u077b\u0773"+
		"\u0001\u0000\u0000\u0000\u077c\u0159\u0001\u0000\u0000\u0000\u077d\u077e"+
		"\u0005\u0083\u0000\u0000\u077e\u015b\u0001\u0000\u0000\u0000\u077f\u0781"+
		"\u0003\u015e\u00af\u0000\u0780\u0782\u0005\u0082\u0000\u0000\u0781\u0780"+
		"\u0001\u0000\u0000\u0000\u0781\u0782\u0001\u0000\u0000\u0000\u0782\u078a"+
		"\u0001\u0000\u0000\u0000\u0783\u0784\u0005y\u0000\u0000\u0784\u0786\u0003"+
		"\u015e\u00af\u0000\u0785\u0787\u0005\u0082\u0000\u0000\u0786\u0785\u0001"+
		"\u0000\u0000\u0000\u0786\u0787\u0001\u0000\u0000\u0000\u0787\u0789\u0001"+
		"\u0000\u0000\u0000\u0788\u0783\u0001\u0000\u0000\u0000\u0789\u078c\u0001"+
		"\u0000\u0000\u0000\u078a\u0788\u0001\u0000\u0000\u0000\u078a\u078b\u0001"+
		"\u0000\u0000\u0000\u078b\u015d\u0001\u0000\u0000\u0000\u078c\u078a\u0001"+
		"\u0000\u0000\u0000\u078d\u0791\u0003\u00f6{\u0000\u078e\u0791\u0003\\"+
		".\u0000\u078f\u0791\u0003\u0004\u0002\u0000\u0790\u078d\u0001\u0000\u0000"+
		"\u0000\u0790\u078e\u0001\u0000\u0000\u0000\u0790\u078f\u0001\u0000\u0000"+
		"\u0000\u0791\u015f\u0001\u0000\u0000\u0000\u0792\u0793\u0005K\u0000\u0000"+
		"\u0793\u0799\u0003\n\u0005\u0000\u0794\u079a\u0005\u0083\u0000\u0000\u0795"+
		"\u0797\u0005C\u0000\u0000\u0796\u0795\u0001\u0000\u0000\u0000\u0796\u0797"+
		"\u0001\u0000\u0000\u0000\u0797\u0798\u0001\u0000\u0000\u0000\u0798\u079a"+
		"\u0003\u0156\u00ab\u0000\u0799\u0794\u0001\u0000\u0000\u0000\u0799\u0796"+
		"\u0001\u0000\u0000\u0000\u079a\u0161\u0001\u0000\u0000\u0000\u079b\u079d"+
		"\u0005#\u0000\u0000\u079c\u079b\u0001\u0000\u0000\u0000\u079c\u079d\u0001"+
		"\u0000\u0000\u0000\u079d\u079e\u0001\u0000\u0000\u0000\u079e\u079f\u0005"+
		"C\u0000\u0000\u079f\u07a0\u0003z=\u0000\u07a0\u0163\u0001\u0000\u0000"+
		"\u0000\u07a1\u07a2\u0005C\u0000\u0000\u07a2\u07a3\u0005e\u0000\u0000\u07a3"+
		"\u07a4\u0005f\u0000\u0000\u07a4\u07a5\u0003z=\u0000\u07a5\u0165\u0001"+
		"\u0000\u0000\u0000\u07a6\u07a7\u0005H\u0000\u0000\u07a7\u07a8\u0003d2"+
		"\u0000\u07a8\u07a9\u0003\u016a\u00b5\u0000\u07a9\u0167\u0001\u0000\u0000"+
		"\u0000\u07aa\u07ac\u0005H\u0000\u0000\u07ab\u07ad\u0003\u0142\u00a1\u0000"+
		"\u07ac\u07ab\u0001\u0000\u0000\u0000\u07ac\u07ad\u0001\u0000\u0000\u0000"+
		"\u07ad\u07ae\u0001\u0000\u0000\u0000\u07ae\u07af\u0003d2\u0000\u07af\u07b0"+
		"\u0003\u016a\u00b5\u0000\u07b0\u0169\u0001\u0000\u0000\u0000\u07b1\u07b3"+
		"\u0003\u016c\u00b6\u0000\u07b2\u07b1\u0001\u0000\u0000\u0000\u07b3\u07b4"+
		"\u0001\u0000\u0000\u0000\u07b4\u07b2\u0001\u0000\u0000\u0000\u07b4\u07b5"+
		"\u0001\u0000\u0000\u0000\u07b5\u016b\u0001\u0000\u0000\u0000\u07b6\u07b7"+
		"\u0005\u0010\u0000\u0000\u07b7\u07b8\u0005T\u0000\u0000\u07b8\u07b9\u0003"+
		"\u016e\u00b7\u0000\u07b9\u07ba\u0005U\u0000\u0000\u07ba\u07bb\u0003d2"+
		"\u0000\u07bb\u016d\u0001\u0000\u0000\u0000\u07bc\u07be\u0003\u00ccf\u0000"+
		"\u07bd\u07bc\u0001\u0000\u0000\u0000\u07bd\u07be\u0001\u0000\u0000\u0000"+
		"\u07be\u07bf\u0001\u0000\u0000\u0000\u07bf\u07c2\u0003\u0096K\u0000\u07c0"+
		"\u07c3\u0003\u00e2q\u0000\u07c1\u07c3\u0003\u00f8|\u0000\u07c2\u07c0\u0001"+
		"\u0000\u0000\u0000\u07c2\u07c1\u0001\u0000\u0000\u0000\u07c2\u07c3\u0001"+
		"\u0000\u0000\u0000\u07c3\u07c6\u0001\u0000\u0000\u0000\u07c4\u07c6\u0005"+
		"\u0082\u0000\u0000\u07c5\u07bd\u0001\u0000\u0000\u0000\u07c5\u07c4\u0001"+
		"\u0000\u0000\u0000\u07c6\u016f\u0001\u0000\u0000\u0000\u07c7\u07c9\u0005"+
		"F\u0000\u0000\u07c8\u07ca\u0003V+\u0000\u07c9\u07c8\u0001\u0000\u0000"+
		"\u0000\u07c9\u07ca\u0001\u0000\u0000\u0000\u07ca\u0171\u0001\u0000\u0000"+
		"\u0000\u07cb\u07ce\u0003\u0174\u00ba\u0000\u07cc\u07ce\u0003\u0178\u00bc"+
		"\u0000\u07cd\u07cb\u0001\u0000\u0000\u0000\u07cd\u07cc\u0001\u0000\u0000"+
		"\u0000\u07ce\u0173\u0001\u0000\u0000\u0000\u07cf\u07d0\u0005F\u0000\u0000"+
		"\u07d0\u07d2\u0005T\u0000\u0000\u07d1\u07d3\u0003\u0176\u00bb\u0000\u07d2"+
		"\u07d1\u0001\u0000\u0000\u0000\u07d2\u07d3\u0001\u0000\u0000\u0000\u07d3"+
		"\u07d4\u0001\u0000\u0000\u0000\u07d4\u07d5\u0005U\u0000\u0000\u07d5\u0175"+
		"\u0001\u0000\u0000\u0000\u07d6\u07d8\u0003\u00f6{\u0000\u07d7\u07d9\u0005"+
		"\u0082\u0000\u0000\u07d8\u07d7\u0001\u0000\u0000\u0000\u07d8\u07d9\u0001"+
		"\u0000\u0000\u0000\u07d9\u07e1\u0001\u0000\u0000\u0000\u07da\u07db\u0005"+
		"y\u0000\u0000\u07db\u07dd\u0003\u00f6{\u0000\u07dc\u07de\u0005\u0082\u0000"+
		"\u0000\u07dd\u07dc\u0001\u0000\u0000\u0000\u07dd\u07de\u0001\u0000\u0000"+
		"\u0000\u07de\u07e0\u0001\u0000\u0000\u0000\u07df\u07da\u0001\u0000\u0000"+
		"\u0000\u07e0\u07e3\u0001\u0000\u0000\u0000\u07e1\u07df\u0001\u0000\u0000"+
		"\u0000\u07e1\u07e2\u0001\u0000\u0000\u0000\u07e2\u0177\u0001\u0000\u0000"+
		"\u0000\u07e3\u07e1\u0001\u0000\u0000\u0000\u07e4\u07e5\u00051\u0000\u0000"+
		"\u07e5\u07e6\u0005T\u0000\u0000\u07e6\u07e7\u0003\\.\u0000\u07e7\u07e8"+
		"\u0005U\u0000\u0000\u07e8\u07eb\u0001\u0000\u0000\u0000\u07e9\u07eb\u0005"+
		"1\u0000\u0000\u07ea\u07e4\u0001\u0000\u0000\u0000\u07ea\u07e9\u0001\u0000"+
		"\u0000\u0000\u07eb\u0179\u0001\u0000\u0000\u0000\u07ec\u07ef\u00050\u0000"+
		"\u0000\u07ed\u07ee\u0005V\u0000\u0000\u07ee\u07f0\u0005W\u0000\u0000\u07ef"+
		"\u07ed\u0001\u0000\u0000\u0000\u07ef\u07f0\u0001\u0000\u0000\u0000\u07f0"+
		"\u0820\u0001\u0000\u0000\u0000\u07f1\u07f4\u0005\u001b\u0000\u0000\u07f2"+
		"\u07f3\u0005V\u0000\u0000\u07f3\u07f5\u0005W\u0000\u0000\u07f4\u07f2\u0001"+
		"\u0000\u0000\u0000\u07f4\u07f5\u0001\u0000\u0000\u0000\u07f5\u0820\u0001"+
		"\u0000\u0000\u0000\u07f6\u0820\u0005Z\u0000\u0000\u07f7\u0820\u0005[\u0000"+
		"\u0000\u07f8\u0820\u0005\\\u0000\u0000\u07f9\u0820\u0005]\u0000\u0000"+
		"\u07fa\u0820\u0005^\u0000\u0000\u07fb\u0820\u0005_\u0000\u0000\u07fc\u0820"+
		"\u0005`\u0000\u0000\u07fd\u0820\u0005a\u0000\u0000\u07fe\u0820\u0005b"+
		"\u0000\u0000\u07ff\u0820\u0005c\u0000\u0000\u0800\u0820\u0005d\u0000\u0000"+
		"\u0801\u0820\u0005f\u0000\u0000\u0802\u0820\u0005e\u0000\u0000\u0803\u0820"+
		"\u0005t\u0000\u0000\u0804\u0820\u0005g\u0000\u0000\u0805\u0820\u0005h"+
		"\u0000\u0000\u0806\u0820\u0005i\u0000\u0000\u0807\u0820\u0005k\u0000\u0000"+
		"\u0808\u0820\u0005l\u0000\u0000\u0809\u0820\u0005m\u0000\u0000\u080a\u0820"+
		"\u0005n\u0000\u0000\u080b\u080c\u0005e\u0000\u0000\u080c\u0820\u0005e"+
		"\u0000\u0000\u080d\u080e\u0005f\u0000\u0000\u080e\u0820\u0005f\u0000\u0000"+
		"\u080f\u0820\u0005p\u0000\u0000\u0810\u0820\u0005o\u0000\u0000\u0811\u0820"+
		"\u0005q\u0000\u0000\u0812\u0820\u0005r\u0000\u0000\u0813\u0820\u0005s"+
		"\u0000\u0000\u0814\u0820\u0005u\u0000\u0000\u0815\u0820\u0005v\u0000\u0000"+
		"\u0816\u0820\u0005w\u0000\u0000\u0817\u0820\u0005x\u0000\u0000\u0818\u0820"+
		"\u0005y\u0000\u0000\u0819\u0820\u0005z\u0000\u0000\u081a\u0820\u0005{"+
		"\u0000\u0000\u081b\u081c\u0005T\u0000\u0000\u081c\u0820\u0005U\u0000\u0000"+
		"\u081d\u081e\u0005V\u0000\u0000\u081e\u0820\u0005W\u0000\u0000\u081f\u07ec"+
		"\u0001\u0000\u0000\u0000\u081f\u07f1\u0001\u0000\u0000\u0000\u081f\u07f6"+
		"\u0001\u0000\u0000\u0000\u081f\u07f7\u0001\u0000\u0000\u0000\u081f\u07f8"+
		"\u0001\u0000\u0000\u0000\u081f\u07f9\u0001\u0000\u0000\u0000\u081f\u07fa"+
		"\u0001\u0000\u0000\u0000\u081f\u07fb\u0001\u0000\u0000\u0000\u081f\u07fc"+
		"\u0001\u0000\u0000\u0000\u081f\u07fd\u0001\u0000\u0000\u0000\u081f\u07fe"+
		"\u0001\u0000\u0000\u0000\u081f\u07ff\u0001\u0000\u0000\u0000\u081f\u0800"+
		"\u0001\u0000\u0000\u0000\u081f\u0801\u0001\u0000\u0000\u0000\u081f\u0802"+
		"\u0001\u0000\u0000\u0000\u081f\u0803\u0001\u0000\u0000\u0000\u081f\u0804"+
		"\u0001\u0000\u0000\u0000\u081f\u0805\u0001\u0000\u0000\u0000\u081f\u0806"+
		"\u0001\u0000\u0000\u0000\u081f\u0807\u0001\u0000\u0000\u0000\u081f\u0808"+
		"\u0001\u0000\u0000\u0000\u081f\u0809\u0001\u0000\u0000\u0000\u081f\u080a"+
		"\u0001\u0000\u0000\u0000\u081f\u080b\u0001\u0000\u0000\u0000\u081f\u080d"+
		"\u0001\u0000\u0000\u0000\u081f\u080f\u0001\u0000\u0000\u0000\u081f\u0810"+
		"\u0001\u0000\u0000\u0000\u081f\u0811\u0001\u0000\u0000\u0000\u081f\u0812"+
		"\u0001\u0000\u0000\u0000\u081f\u0813\u0001\u0000\u0000\u0000\u081f\u0814"+
		"\u0001\u0000\u0000\u0000\u081f\u0815\u0001\u0000\u0000\u0000\u081f\u0816"+
		"\u0001\u0000\u0000\u0000\u081f\u0817\u0001\u0000\u0000\u0000\u081f\u0818"+
		"\u0001\u0000\u0000\u0000\u081f\u0819\u0001\u0000\u0000\u0000\u081f\u081a"+
		"\u0001\u0000\u0000\u0000\u081f\u081b\u0001\u0000\u0000\u0000\u081f\u081d"+
		"\u0001\u0000\u0000\u0000\u0820\u017b\u0001\u0000\u0000\u0000\u0821\u0822"+
		"\u0007\u0016\u0000\u0000\u0822\u017d\u0001\u0000\u0000\u0000\u0126\u0181"+
		"\u0189\u0192\u0196\u019f\u01a2\u01a6\u01ae\u01b5\u01b8\u01bd\u01c2\u01c8"+
		"\u01d0\u01d2\u01db\u01df\u01e3\u01e6\u01ea\u01ed\u01f4\u01f8\u01fb\u01fe"+
		"\u0201\u0207\u020b\u020f\u021d\u0221\u0227\u022e\u0234\u0238\u023c\u023e"+
		"\u0246\u024b\u0258\u025f\u026b\u0275\u027a\u027e\u0285\u0288\u0290\u0294"+
		"\u0297\u029e\u02a5\u02a9\u02ae\u02b2\u02b5\u02ba\u02c9\u02d0\u02d8\u02e0"+
		"\u02e9\u02f0\u02f7\u02ff\u0307\u030f\u0317\u031f\u0327\u0330\u0338\u0341"+
		"\u0349\u0351\u0353\u0356\u035c\u0362\u0368\u036f\u0378\u0380\u0384\u038b"+
		"\u038d\u03a1\u03a5\u03ab\u03b0\u03b4\u03b7\u03be\u03c5\u03c9\u03d2\u03dd"+
		"\u03e7\u03ec\u03f3\u03f6\u03fb\u0400\u0415\u041a\u041d\u0428\u042e\u0433"+
		"\u0436\u043b\u043e\u0445\u045c\u0462\u0468\u046e\u0471\u0477\u047b\u047f"+
		"\u0482\u048a\u048c\u0492\u0495\u0498\u049b\u049f\u04a3\u04a9\u04b3\u04b9"+
		"\u04bf\u04c4\u04c9\u04cd\u04da\u04e0\u04e4\u04ea\u04ef\u04fe\u0502\u0507"+
		"\u050c\u0511\u0517\u051a\u0523\u0527\u052c\u0530\u0536\u053d\u054e\u0550"+
		"\u0557\u055c\u0563\u0567\u056b\u0573\u0579\u057f\u0583\u0585\u0589\u058e"+
		"\u0592\u0595\u0598\u059b\u05a0\u05a4\u05a7\u05ab\u05ae\u05b0\u05b5\u05bc"+
		"\u05c2\u05c6\u05cc\u05d2\u05d5\u05d7\u05dd\u05e1\u05e7\u05ee\u05f2\u05f4"+
		"\u05f8\u05fe\u060a\u060e\u0610\u0614\u0619\u061c\u0623\u0627\u062c\u062e"+
		"\u0632\u0635\u0638\u063c\u0641\u0648\u064f\u0654\u0658\u065c\u0661\u0665"+
		"\u066b\u066d\u0673\u0678\u067e\u0682\u0684\u0687\u068b\u068f\u0691\u0693"+
		"\u0696\u06a2\u06a4\u06a7\u06aa\u06ad\u06b6\u06bd\u06c9\u06cd\u06d0\u06d4"+
		"\u06d9\u06e5\u06ea\u06ee\u06f2\u06f7\u06fc\u0700\u0703\u0707\u0712\u0716"+
		"\u071d\u0722\u0726\u072c\u0730\u0734\u073d\u074a\u074f\u0756\u075a\u075d"+
		"\u0760\u0763\u0767\u076c\u0773\u0777\u077b\u0781\u0786\u078a\u0790\u0796"+
		"\u0799\u079c\u07ac\u07b4\u07bd\u07c2\u07c5\u07c9\u07cd\u07d2\u07d8\u07dd"+
		"\u07e1\u07ea\u07ef\u07f4\u081f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}