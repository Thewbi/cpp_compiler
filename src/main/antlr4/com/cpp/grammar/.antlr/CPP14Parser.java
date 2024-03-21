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
		PreProcessorLiteral=1, IntegerLiteral=2, CharacterLiteral=3, FloatingLiteral=4, 
		StringLiteral=5, BooleanLiteral=6, PointerLiteral=7, UserDefinedLiteral=8, 
		LineBreakCombiner=9, Pragma_Once=10, Preprocessor_Include=11, Preprocessor_If=12, 
		Preprocessor_Endif=13, Alignas=14, Alignof=15, Asm=16, Auto=17, Bool=18, 
		Break=19, Case=20, Catch=21, Char=22, Char16=23, Char32=24, Class=25, 
		Const=26, Constexpr=27, Const_cast=28, Continue=29, Decltype=30, Default=31, 
		Delete=32, Do=33, Double=34, Dynamic_cast=35, Else=36, Enum=37, Explicit=38, 
		Export=39, Extern=40, False_=41, Final=42, Float=43, For=44, Friend=45, 
		Goto=46, If=47, Inline=48, Int=49, Long=50, Mutable=51, Namespace=52, 
		New=53, Noexcept=54, Nullptr=55, Operator=56, Override=57, Private=58, 
		Protected=59, Public=60, Register=61, Reinterpret_cast=62, Return=63, 
		Short=64, Signed=65, Sizeof=66, Static=67, Static_assert=68, Static_cast=69, 
		Struct=70, Switch=71, Template=72, This=73, Thread_local=74, Throw=75, 
		True_=76, Try=77, Typedef=78, Typeid_=79, Typename_=80, Union=81, Unsigned=82, 
		Using=83, Virtual=84, Void=85, Volatile=86, Wchar=87, While=88, LeftParen=89, 
		RightParen=90, LeftBracket=91, RightBracket=92, LeftBrace=93, RightBrace=94, 
		Plus=95, Minus=96, Star=97, Div=98, Mod=99, Caret=100, And=101, Or=102, 
		Tilde=103, Not=104, Assign=105, Less=106, Greater=107, PlusAssign=108, 
		MinusAssign=109, StarAssign=110, DivAssign=111, ModAssign=112, XorAssign=113, 
		AndAssign=114, OrAssign=115, LeftShiftAssign=116, RightShiftAssign=117, 
		Equal=118, NotEqual=119, LessEqual=120, GreaterEqual=121, AndAnd=122, 
		OrOr=123, PlusPlus=124, MinusMinus=125, Comma=126, ArrowStar=127, Arrow=128, 
		Question=129, Colon=130, Doublecolon=131, Semi=132, Dot=133, DotStar=134, 
		Ellipsis=135, Identifier=136, DecimalLiteral=137, OctalLiteral=138, HexadecimalLiteral=139, 
		BinaryLiteral=140, Integersuffix=141, UserDefinedIntegerLiteral=142, UserDefinedFloatingLiteral=143, 
		UserDefinedStringLiteral=144, UserDefinedCharacterLiteral=145, Whitespace=146, 
		Newline=147, BlockComment=148, LineComment=149;
	public static final int
		RULE_translationUnit = 0, RULE_pragma_directive = 1, RULE_preprocessor_directive = 2, 
		RULE_primaryExpression = 3, RULE_idExpression = 4, RULE_unqualifiedId = 5, 
		RULE_qualifiedId = 6, RULE_nestedNameSpecifier = 7, RULE_lambdaExpression = 8, 
		RULE_lambdaIntroducer = 9, RULE_lambdaCapture = 10, RULE_captureDefault = 11, 
		RULE_captureList = 12, RULE_capture = 13, RULE_simpleCapture = 14, RULE_initcapture = 15, 
		RULE_lambdaDeclarator = 16, RULE_postfixExpression = 17, RULE_typeIdOfTheTypeId = 18, 
		RULE_expressionList = 19, RULE_pseudoDestructorName = 20, RULE_unaryExpression = 21, 
		RULE_unaryOperator = 22, RULE_newExpression_ = 23, RULE_newPlacement = 24, 
		RULE_newTypeId = 25, RULE_newDeclarator_ = 26, RULE_noPointerNewDeclarator = 27, 
		RULE_newInitializer_ = 28, RULE_deleteExpression = 29, RULE_noExceptExpression = 30, 
		RULE_castExpression = 31, RULE_pointerMemberExpression = 32, RULE_multiplicativeExpression = 33, 
		RULE_additiveExpression = 34, RULE_shiftExpression = 35, RULE_shiftOperator = 36, 
		RULE_relationalExpression = 37, RULE_equalityExpression = 38, RULE_andExpression = 39, 
		RULE_exclusiveOrExpression = 40, RULE_inclusiveOrExpression = 41, RULE_logicalAndExpression = 42, 
		RULE_logicalOrExpression = 43, RULE_conditionalExpression = 44, RULE_assignmentExpression = 45, 
		RULE_assignmentOperator = 46, RULE_expression = 47, RULE_constantExpression = 48, 
		RULE_statement = 49, RULE_labeledStatement = 50, RULE_expressionStatement = 51, 
		RULE_compoundStatement = 52, RULE_statementSeq = 53, RULE_selectionStatement = 54, 
		RULE_condition = 55, RULE_iterationStatement = 56, RULE_forInitStatement = 57, 
		RULE_forRangeDeclaration = 58, RULE_forRangeInitializer = 59, RULE_jumpStatement = 60, 
		RULE_declarationStatement = 61, RULE_declarationseq = 62, RULE_declaration = 63, 
		RULE_blockDeclaration = 64, RULE_aliasDeclaration = 65, RULE_simpleDeclaration = 66, 
		RULE_staticAssertDeclaration = 67, RULE_emptyDeclaration_ = 68, RULE_attributeDeclaration = 69, 
		RULE_declSpecifier = 70, RULE_declSpecifierSeq = 71, RULE_storageClassSpecifier = 72, 
		RULE_functionSpecifier = 73, RULE_typedefName = 74, RULE_typeSpecifier = 75, 
		RULE_trailingTypeSpecifier = 76, RULE_typeSpecifierSeq = 77, RULE_trailingTypeSpecifierSeq = 78, 
		RULE_simpleTypeLengthModifier = 79, RULE_simpleTypeSignednessModifier = 80, 
		RULE_simpleTypeSpecifier = 81, RULE_theTypeName = 82, RULE_decltypeSpecifier = 83, 
		RULE_elaboratedTypeSpecifier = 84, RULE_enumName = 85, RULE_enumSpecifier = 86, 
		RULE_enumHead = 87, RULE_opaqueEnumDeclaration = 88, RULE_enumkey = 89, 
		RULE_enumbase = 90, RULE_enumeratorList = 91, RULE_enumeratorDefinition = 92, 
		RULE_enumerator = 93, RULE_namespaceName = 94, RULE_originalNamespaceName = 95, 
		RULE_namespaceDefinition = 96, RULE_namespaceAlias = 97, RULE_namespaceAliasDefinition = 98, 
		RULE_qualifiednamespacespecifier = 99, RULE_usingDeclaration = 100, RULE_usingDirective = 101, 
		RULE_asmDefinition = 102, RULE_linkageSpecification = 103, RULE_attributeSpecifierSeq = 104, 
		RULE_attributeSpecifier = 105, RULE_alignmentspecifier = 106, RULE_attributeList = 107, 
		RULE_attribute = 108, RULE_attributeNamespace = 109, RULE_attributeArgumentClause = 110, 
		RULE_balancedTokenSeq = 111, RULE_balancedtoken = 112, RULE_initDeclaratorList = 113, 
		RULE_initDeclarator = 114, RULE_declarator = 115, RULE_pointerDeclarator = 116, 
		RULE_noPointerDeclarator = 117, RULE_parametersAndQualifiers = 118, RULE_trailingReturnType = 119, 
		RULE_pointerOperator = 120, RULE_cvqualifierseq = 121, RULE_cvQualifier = 122, 
		RULE_refqualifier = 123, RULE_declaratorid = 124, RULE_theTypeId = 125, 
		RULE_abstractDeclarator = 126, RULE_pointerAbstractDeclarator = 127, RULE_noPointerAbstractDeclarator = 128, 
		RULE_abstractPackDeclarator = 129, RULE_noPointerAbstractPackDeclarator = 130, 
		RULE_parameterDeclarationClause = 131, RULE_parameterDeclarationList = 132, 
		RULE_parameterDeclaration = 133, RULE_functionDefinition = 134, RULE_functionBody = 135, 
		RULE_initializer = 136, RULE_braceOrEqualInitializer = 137, RULE_initializerClause = 138, 
		RULE_initializerList = 139, RULE_bracedInitList = 140, RULE_className = 141, 
		RULE_classSpecifier = 142, RULE_classHead = 143, RULE_classHeadName = 144, 
		RULE_classVirtSpecifier = 145, RULE_classKey = 146, RULE_memberSpecification = 147, 
		RULE_memberdeclaration = 148, RULE_memberDeclaratorList = 149, RULE_memberDeclarator = 150, 
		RULE_virtualSpecifierSeq = 151, RULE_virtualSpecifier = 152, RULE_pureSpecifier = 153, 
		RULE_baseClause = 154, RULE_baseSpecifierList = 155, RULE_baseSpecifier = 156, 
		RULE_classOrDeclType = 157, RULE_baseTypeSpecifier = 158, RULE_accessSpecifier = 159, 
		RULE_conversionFunctionId = 160, RULE_conversionTypeId = 161, RULE_conversionDeclarator = 162, 
		RULE_constructorInitializer = 163, RULE_memInitializerList = 164, RULE_memInitializer = 165, 
		RULE_meminitializerid = 166, RULE_operatorFunctionId = 167, RULE_literalOperatorId = 168, 
		RULE_templateDeclaration = 169, RULE_templateparameterList = 170, RULE_templateParameter = 171, 
		RULE_typeParameter = 172, RULE_simpleTemplateId = 173, RULE_templateId = 174, 
		RULE_templateName = 175, RULE_templateArgumentList = 176, RULE_templateArgument = 177, 
		RULE_typeNameSpecifier = 178, RULE_explicitInstantiation = 179, RULE_explicitSpecialization = 180, 
		RULE_tryBlock = 181, RULE_functionTryBlock = 182, RULE_handlerSeq = 183, 
		RULE_handler = 184, RULE_exceptionDeclaration = 185, RULE_throwExpression = 186, 
		RULE_exceptionSpecification = 187, RULE_dynamicExceptionSpecification = 188, 
		RULE_typeIdList = 189, RULE_noeExceptSpecification = 190, RULE_theOperator = 191, 
		RULE_literal = 192;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "pragma_directive", "preprocessor_directive", "primaryExpression", 
			"idExpression", "unqualifiedId", "qualifiedId", "nestedNameSpecifier", 
			"lambdaExpression", "lambdaIntroducer", "lambdaCapture", "captureDefault", 
			"captureList", "capture", "simpleCapture", "initcapture", "lambdaDeclarator", 
			"postfixExpression", "typeIdOfTheTypeId", "expressionList", "pseudoDestructorName", 
			"unaryExpression", "unaryOperator", "newExpression_", "newPlacement", 
			"newTypeId", "newDeclarator_", "noPointerNewDeclarator", "newInitializer_", 
			"deleteExpression", "noExceptExpression", "castExpression", "pointerMemberExpression", 
			"multiplicativeExpression", "additiveExpression", "shiftExpression", 
			"shiftOperator", "relationalExpression", "equalityExpression", "andExpression", 
			"exclusiveOrExpression", "inclusiveOrExpression", "logicalAndExpression", 
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
			null, null, null, null, null, null, null, null, null, null, "'#pragma once'", 
			"'#include'", "'#if'", "'#endif'", "'alignas'", "'alignof'", "'asm'", 
			"'auto'", "'bool'", "'break'", "'case'", "'catch'", "'char'", "'char16_t'", 
			"'char32_t'", "'class'", "'const'", "'constexpr'", "'const_cast'", "'continue'", 
			"'decltype'", "'default'", "'delete'", "'do'", "'double'", "'dynamic_cast'", 
			"'else'", "'enum'", "'explicit'", "'export'", "'extern'", "'false'", 
			"'final'", "'float'", "'for'", "'friend'", "'goto'", "'if'", "'inline'", 
			"'int'", "'long'", "'mutable'", "'namespace'", "'new'", "'noexcept'", 
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
			null, "PreProcessorLiteral", "IntegerLiteral", "CharacterLiteral", "FloatingLiteral", 
			"StringLiteral", "BooleanLiteral", "PointerLiteral", "UserDefinedLiteral", 
			"LineBreakCombiner", "Pragma_Once", "Preprocessor_Include", "Preprocessor_If", 
			"Preprocessor_Endif", "Alignas", "Alignof", "Asm", "Auto", "Bool", "Break", 
			"Case", "Catch", "Char", "Char16", "Char32", "Class", "Const", "Constexpr", 
			"Const_cast", "Continue", "Decltype", "Default", "Delete", "Do", "Double", 
			"Dynamic_cast", "Else", "Enum", "Explicit", "Export", "Extern", "False_", 
			"Final", "Float", "For", "Friend", "Goto", "If", "Inline", "Int", "Long", 
			"Mutable", "Namespace", "New", "Noexcept", "Nullptr", "Operator", "Override", 
			"Private", "Protected", "Public", "Register", "Reinterpret_cast", "Return", 
			"Short", "Signed", "Sizeof", "Static", "Static_assert", "Static_cast", 
			"Struct", "Switch", "Template", "This", "Thread_local", "Throw", "True_", 
			"Try", "Typedef", "Typeid_", "Typename_", "Union", "Unsigned", "Using", 
			"Virtual", "Void", "Volatile", "Wchar", "While", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", 
			"Star", "Div", "Mod", "Caret", "And", "Or", "Tilde", "Not", "Assign", 
			"Less", "Greater", "PlusAssign", "MinusAssign", "StarAssign", "DivAssign", 
			"ModAssign", "XorAssign", "AndAssign", "OrAssign", "LeftShiftAssign", 
			"RightShiftAssign", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
			"AndAnd", "OrOr", "PlusPlus", "MinusMinus", "Comma", "ArrowStar", "Arrow", 
			"Question", "Colon", "Doublecolon", "Semi", "Dot", "DotStar", "Ellipsis", 
			"Identifier", "DecimalLiteral", "OctalLiteral", "HexadecimalLiteral", 
			"BinaryLiteral", "Integersuffix", "UserDefinedIntegerLiteral", "UserDefinedFloatingLiteral", 
			"UserDefinedStringLiteral", "UserDefinedCharacterLiteral", "Whitespace", 
			"Newline", "BlockComment", "LineComment"
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
		public List<Pragma_directiveContext> pragma_directive() {
			return getRuleContexts(Pragma_directiveContext.class);
		}
		public Pragma_directiveContext pragma_directive(int i) {
			return getRuleContext(Pragma_directiveContext.class,i);
		}
		public List<Preprocessor_directiveContext> preprocessor_directive() {
			return getRuleContexts(Preprocessor_directiveContext.class);
		}
		public Preprocessor_directiveContext preprocessor_directive(int i) {
			return getRuleContext(Preprocessor_directiveContext.class,i);
		}
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
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 6253327017007378911L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 7350156067525017553L) != 0)) {
				{
				setState(389);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Pragma_Once:
					{
					setState(386);
					pragma_directive();
					}
					break;
				case Preprocessor_Include:
				case Preprocessor_If:
				case Preprocessor_Endif:
					{
					setState(387);
					preprocessor_directive();
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
					setState(388);
					declarationseq();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(394);
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
	public static class Pragma_directiveContext extends ParserRuleContext {
		public TerminalNode Pragma_Once() { return getToken(CPP14Parser.Pragma_Once, 0); }
		public Pragma_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_directive; }
	}

	public final Pragma_directiveContext pragma_directive() throws RecognitionException {
		Pragma_directiveContext _localctx = new Pragma_directiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pragma_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(Pragma_Once);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		public TerminalNode Preprocessor_Include() { return getToken(CPP14Parser.Preprocessor_Include, 0); }
		public TerminalNode UserDefinedStringLiteral() { return getToken(CPP14Parser.UserDefinedStringLiteral, 0); }
		public TerminalNode PreProcessorLiteral() { return getToken(CPP14Parser.PreProcessorLiteral, 0); }
		public TerminalNode Preprocessor_If() { return getToken(CPP14Parser.Preprocessor_If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Preprocessor_Endif() { return getToken(CPP14Parser.Preprocessor_Endif, 0); }
		public Preprocessor_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocessor_directive; }
	}

	public final Preprocessor_directiveContext preprocessor_directive() throws RecognitionException {
		Preprocessor_directiveContext _localctx = new Preprocessor_directiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_preprocessor_directive);
		int _la;
		try {
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Preprocessor_Include:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				match(Preprocessor_Include);
				setState(399);
				_la = _input.LA(1);
				if ( !(_la==PreProcessorLiteral || _la==UserDefinedStringLiteral) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case Preprocessor_If:
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				match(Preprocessor_If);
				setState(401);
				expression();
				}
				break;
			case Preprocessor_Endif:
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				match(Preprocessor_Endif);
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
		enterRule(_localctx, 6, RULE_primaryExpression);
		try {
			int _alt;
			setState(417);
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
				setState(406); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(405);
						literal();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(408); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				match(This);
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 3);
				{
				setState(411);
				match(LeftParen);
				setState(412);
				expression();
				setState(413);
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
				setState(415);
				idExpression();
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 5);
				{
				setState(416);
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
		enterRule(_localctx, 8, RULE_idExpression);
		try {
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				unqualifiedId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
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
		enterRule(_localctx, 10, RULE_unqualifiedId);
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				operatorFunctionId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(425);
				conversionFunctionId();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(426);
				literalOperatorId();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(427);
				match(Tilde);
				setState(430);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(428);
					className();
					}
					break;
				case Decltype:
					{
					setState(429);
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
				setState(432);
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
		enterRule(_localctx, 12, RULE_qualifiedId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			nestedNameSpecifier(0);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_nestedNameSpecifier, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(442);
				theTypeName();
				}
				break;
			case 2:
				{
				setState(443);
				namespaceName();
				}
				break;
			case 3:
				{
				setState(444);
				decltypeSpecifier();
				}
				break;
			}
			setState(447);
			match(Doublecolon);
			}
			_ctx.stop = _input.LT(-1);
			setState(460);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NestedNameSpecifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_nestedNameSpecifier);
					setState(449);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(455);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(450);
						match(Identifier);
						}
						break;
					case 2:
						{
						setState(452);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Template) {
							{
							setState(451);
							match(Template);
							}
						}

						setState(454);
						simpleTemplateId();
						}
						break;
					}
					setState(457);
					match(Doublecolon);
					}
					} 
				}
				setState(462);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 16, RULE_lambdaExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			lambdaIntroducer();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(464);
				lambdaDeclarator();
				}
			}

			setState(467);
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
		enterRule(_localctx, 18, RULE_lambdaIntroducer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(LeftBracket);
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & -9223372032291373055L) != 0)) {
				{
				setState(470);
				lambdaCapture();
				}
			}

			setState(473);
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
		enterRule(_localctx, 20, RULE_lambdaCapture);
		int _la;
		try {
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				captureList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				captureDefault();
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(477);
					match(Comma);
					setState(478);
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
		enterRule(_localctx, 22, RULE_captureDefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
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
		enterRule(_localctx, 24, RULE_captureList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			capture();
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(486);
				match(Comma);
				setState(487);
				capture();
				}
				}
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(493);
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
		enterRule(_localctx, 26, RULE_capture);
		try {
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				simpleCapture();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
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
		enterRule(_localctx, 28, RULE_simpleCapture);
		int _la;
		try {
			setState(505);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==And) {
					{
					setState(500);
					match(And);
					}
				}

				setState(503);
				match(Identifier);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
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
		enterRule(_localctx, 30, RULE_initcapture);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(507);
				match(And);
				}
			}

			setState(510);
			match(Identifier);
			setState(511);
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
		enterRule(_localctx, 32, RULE_lambdaDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(LeftParen);
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1237504995584196377L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 297237575406461917L) != 0)) {
				{
				setState(514);
				parameterDeclarationClause();
				}
			}

			setState(517);
			match(RightParen);
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Mutable) {
				{
				setState(518);
				match(Mutable);
				}
			}

			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Noexcept || _la==Throw) {
				{
				setState(521);
				exceptionSpecification();
				}
			}

			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(524);
				attributeSpecifierSeq();
				}
			}

			setState(528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Arrow) {
				{
				setState(527);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(531);
				primaryExpression();
				}
				break;
			case 2:
				{
				setState(534);
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
					setState(532);
					simpleTypeSpecifier();
					}
					break;
				case Typename_:
					{
					setState(533);
					typeNameSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(542);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
					{
					setState(536);
					match(LeftParen);
					setState(538);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766591152720423L) != 0) || _la==Doublecolon || _la==Identifier) {
						{
						setState(537);
						expressionList();
						}
					}

					setState(540);
					match(RightParen);
					}
					break;
				case LeftBrace:
					{
					setState(541);
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
				setState(544);
				_la = _input.LA(1);
				if ( !(((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 2216203124865L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(545);
				match(Less);
				setState(546);
				theTypeId();
				setState(547);
				match(Greater);
				setState(548);
				match(LeftParen);
				setState(549);
				expression();
				setState(550);
				match(RightParen);
				}
				break;
			case 4:
				{
				setState(552);
				typeIdOfTheTypeId();
				setState(553);
				match(LeftParen);
				setState(556);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(554);
					expression();
					}
					break;
				case 2:
					{
					setState(555);
					theTypeId();
					}
					break;
				}
				setState(558);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(589);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(587);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(562);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(563);
						match(LeftBracket);
						setState(566);
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
							setState(564);
							expression();
							}
							break;
						case LeftBrace:
							{
							setState(565);
							bracedInitList();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(568);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(570);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(571);
						match(LeftParen);
						setState(573);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766591152720423L) != 0) || _la==Doublecolon || _la==Identifier) {
							{
							setState(572);
							expressionList();
							}
						}

						setState(575);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(576);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(577);
						_la = _input.LA(1);
						if ( !(_la==Arrow || _la==Dot) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(583);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
						case 1:
							{
							setState(579);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Template) {
								{
								setState(578);
								match(Template);
								}
							}

							setState(581);
							idExpression();
							}
							break;
						case 2:
							{
							setState(582);
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
						setState(585);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(586);
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
				setState(591);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		enterRule(_localctx, 36, RULE_typeIdOfTheTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
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
		enterRule(_localctx, 38, RULE_expressionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
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
		enterRule(_localctx, 40, RULE_pseudoDestructorName);
		int _la;
		try {
			setState(615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(597);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(596);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(599);
					theTypeName();
					setState(600);
					match(Doublecolon);
					}
				}

				setState(604);
				match(Tilde);
				setState(605);
				theTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(606);
				nestedNameSpecifier(0);
				setState(607);
				match(Template);
				setState(608);
				simpleTemplateId();
				setState(609);
				match(Doublecolon);
				setState(610);
				match(Tilde);
				setState(611);
				theTypeName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(613);
				match(Tilde);
				setState(614);
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
		enterRule(_localctx, 42, RULE_unaryExpression);
		try {
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(622);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PlusPlus:
					{
					setState(618);
					match(PlusPlus);
					}
					break;
				case MinusMinus:
					{
					setState(619);
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
					setState(620);
					unaryOperator();
					}
					break;
				case Sizeof:
					{
					setState(621);
					match(Sizeof);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(624);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(625);
				match(Sizeof);
				setState(634);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
					{
					setState(626);
					match(LeftParen);
					setState(627);
					theTypeId();
					setState(628);
					match(RightParen);
					}
					break;
				case Ellipsis:
					{
					setState(630);
					match(Ellipsis);
					setState(631);
					match(LeftParen);
					setState(632);
					match(Identifier);
					setState(633);
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
				setState(636);
				match(Alignof);
				setState(637);
				match(LeftParen);
				setState(638);
				theTypeId();
				setState(639);
				match(RightParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(641);
				noExceptExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(642);
				newExpression_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(643);
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
		enterRule(_localctx, 44, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			_la = _input.LA(1);
			if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 967L) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_newExpression_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doublecolon) {
				{
				setState(648);
				match(Doublecolon);
				}
			}

			setState(651);
			match(New);
			setState(653);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(652);
				newPlacement();
				}
				break;
			}
			setState(660);
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
				setState(655);
				newTypeId();
				}
				break;
			case LeftParen:
				{
				setState(656);
				match(LeftParen);
				setState(657);
				theTypeId();
				setState(658);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(663);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(662);
				newInitializer_();
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
		enterRule(_localctx, 48, RULE_newPlacement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			match(LeftParen);
			setState(666);
			expressionList();
			setState(667);
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
		enterRule(_localctx, 50, RULE_newTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			typeSpecifierSeq();
			setState(671);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(670);
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
		enterRule(_localctx, 52, RULE_newDeclarator_);
		try {
			setState(678);
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
				setState(673);
				pointerOperator();
				setState(675);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(674);
					newDeclarator_();
					}
					break;
				}
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(677);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_noPointerNewDeclarator, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(681);
			match(LeftBracket);
			setState(682);
			expression();
			setState(683);
			match(RightBracket);
			setState(685);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(684);
				attributeSpecifierSeq();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(696);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerNewDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerNewDeclarator);
					setState(687);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(688);
					match(LeftBracket);
					setState(689);
					constantExpression();
					setState(690);
					match(RightBracket);
					setState(692);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						setState(691);
						attributeSpecifierSeq();
						}
						break;
					}
					}
					} 
				}
				setState(698);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		enterRule(_localctx, 56, RULE_newInitializer_);
		int _la;
		try {
			setState(705);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(699);
				match(LeftParen);
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766591152720423L) != 0) || _la==Doublecolon || _la==Identifier) {
					{
					setState(700);
					expressionList();
					}
				}

				setState(703);
				match(RightParen);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(704);
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
		enterRule(_localctx, 58, RULE_deleteExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doublecolon) {
				{
				setState(707);
				match(Doublecolon);
				}
			}

			setState(710);
			match(Delete);
			setState(713);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(711);
				match(LeftBracket);
				setState(712);
				match(RightBracket);
				}
				break;
			}
			setState(715);
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
		enterRule(_localctx, 60, RULE_noExceptExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			match(Noexcept);
			setState(718);
			match(LeftParen);
			setState(719);
			expression();
			setState(720);
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
		enterRule(_localctx, 62, RULE_castExpression);
		try {
			setState(728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(722);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(723);
				match(LeftParen);
				setState(724);
				theTypeId();
				setState(725);
				match(RightParen);
				setState(726);
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
		enterRule(_localctx, 64, RULE_pointerMemberExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			castExpression();
			setState(735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ArrowStar || _la==DotStar) {
				{
				{
				setState(731);
				_la = _input.LA(1);
				if ( !(_la==ArrowStar || _la==DotStar) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(732);
				castExpression();
				}
				}
				setState(737);
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
		enterRule(_localctx, 66, RULE_multiplicativeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			pointerMemberExpression();
			setState(743);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(739);
					_la = _input.LA(1);
					if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & 7L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(740);
					pointerMemberExpression();
					}
					} 
				}
				setState(745);
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
		enterRule(_localctx, 68, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			multiplicativeExpression();
			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Plus || _la==Minus) {
				{
				{
				setState(747);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(748);
				multiplicativeExpression();
				}
				}
				setState(753);
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
		enterRule(_localctx, 70, RULE_shiftExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(754);
			additiveExpression();
			setState(760);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(755);
					shiftOperator();
					setState(756);
					additiveExpression();
					}
					} 
				}
				setState(762);
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
		enterRule(_localctx, 72, RULE_shiftOperator);
		try {
			setState(767);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Greater:
				enterOuterAlt(_localctx, 1);
				{
				setState(763);
				match(Greater);
				setState(764);
				match(Greater);
				}
				break;
			case Less:
				enterOuterAlt(_localctx, 2);
				{
				setState(765);
				match(Less);
				setState(766);
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
		enterRule(_localctx, 74, RULE_relationalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			shiftExpression();
			setState(774);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(770);
					_la = _input.LA(1);
					if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 49155L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(771);
					shiftExpression();
					}
					} 
				}
				setState(776);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
		enterRule(_localctx, 76, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			relationalExpression();
			setState(782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Equal || _la==NotEqual) {
				{
				{
				setState(778);
				_la = _input.LA(1);
				if ( !(_la==Equal || _la==NotEqual) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(779);
				relationalExpression();
				}
				}
				setState(784);
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
		enterRule(_localctx, 78, RULE_andExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			equalityExpression();
			setState(790);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(786);
					match(And);
					setState(787);
					equalityExpression();
					}
					} 
				}
				setState(792);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
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
		enterRule(_localctx, 80, RULE_exclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			andExpression();
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Caret) {
				{
				{
				setState(794);
				match(Caret);
				setState(795);
				andExpression();
				}
				}
				setState(800);
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
		enterRule(_localctx, 82, RULE_inclusiveOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			exclusiveOrExpression();
			setState(806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(802);
				match(Or);
				setState(803);
				exclusiveOrExpression();
				}
				}
				setState(808);
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
		enterRule(_localctx, 84, RULE_logicalAndExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			inclusiveOrExpression();
			setState(814);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(810);
					match(AndAnd);
					setState(811);
					inclusiveOrExpression();
					}
					} 
				}
				setState(816);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
		enterRule(_localctx, 86, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			logicalAndExpression();
			setState(822);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OrOr) {
				{
				{
				setState(818);
				match(OrOr);
				setState(819);
				logicalAndExpression();
				}
				}
				setState(824);
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
		enterRule(_localctx, 88, RULE_conditionalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			logicalOrExpression();
			setState(831);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Question) {
				{
				setState(826);
				match(Question);
				setState(827);
				expression();
				setState(828);
				match(Colon);
				setState(829);
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
		enterRule(_localctx, 90, RULE_assignmentExpression);
		try {
			setState(839);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(833);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(834);
				logicalOrExpression();
				setState(835);
				assignmentOperator();
				setState(836);
				initializerClause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(838);
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
		enterRule(_localctx, 92, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			_la = _input.LA(1);
			if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 8185L) != 0)) ) {
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
		enterRule(_localctx, 94, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			assignmentExpression();
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(844);
				match(Comma);
				setState(845);
				assignmentExpression();
				}
				}
				setState(850);
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
		enterRule(_localctx, 96, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
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
		enterRule(_localctx, 98, RULE_statement);
		try {
			setState(866);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(853);
				labeledStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(854);
				declarationStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(856);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(855);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(864);
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
					setState(858);
					expressionStatement();
					}
					break;
				case LeftBrace:
					{
					setState(859);
					compoundStatement();
					}
					break;
				case If:
				case Switch:
					{
					setState(860);
					selectionStatement();
					}
					break;
				case Do:
				case For:
				case While:
					{
					setState(861);
					iterationStatement();
					}
					break;
				case Break:
				case Continue:
				case Goto:
				case Return:
					{
					setState(862);
					jumpStatement();
					}
					break;
				case Try:
					{
					setState(863);
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
		enterRule(_localctx, 100, RULE_labeledStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(868);
				attributeSpecifierSeq();
				}
			}

			setState(875);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(871);
				match(Identifier);
				}
				break;
			case Case:
				{
				setState(872);
				match(Case);
				setState(873);
				constantExpression();
				}
				break;
			case Default:
				{
				setState(874);
				match(Default);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(877);
			match(Colon);
			setState(878);
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
		enterRule(_localctx, 102, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590615849511L) != 0) || _la==Doublecolon || _la==Identifier) {
				{
				setState(880);
				expression();
				}
			}

			setState(883);
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
		enterRule(_localctx, 104, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			match(LeftBrace);
			setState(887);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2197763833703972356L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3746996967327133439L) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & 51L) != 0)) {
				{
				setState(886);
				statementSeq();
				}
			}

			setState(889);
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
		enterRule(_localctx, 106, RULE_statementSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(891);
				statement();
				}
				}
				setState(894); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2197763833703972356L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3746996967327133439L) != 0) || ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & 51L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 108, RULE_selectionStatement);
		try {
			setState(911);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(896);
				match(If);
				setState(897);
				match(LeftParen);
				setState(898);
				condition();
				setState(899);
				match(RightParen);
				setState(900);
				statement();
				setState(903);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(901);
					match(Else);
					setState(902);
					statement();
					}
					break;
				}
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 2);
				{
				setState(905);
				match(Switch);
				setState(906);
				match(LeftParen);
				setState(907);
				condition();
				setState(908);
				match(RightParen);
				setState(909);
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
		enterRule(_localctx, 110, RULE_condition);
		int _la;
		try {
			setState(924);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(913);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(915);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(914);
					attributeSpecifierSeq();
					}
				}

				setState(917);
				declSpecifierSeq();
				setState(918);
				declarator();
				setState(922);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Assign:
					{
					setState(919);
					match(Assign);
					setState(920);
					initializerClause();
					}
					break;
				case LeftBrace:
					{
					setState(921);
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
		enterRule(_localctx, 112, RULE_iterationStatement);
		int _la;
		try {
			setState(959);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(926);
				match(While);
				setState(927);
				match(LeftParen);
				setState(928);
				condition();
				setState(929);
				match(RightParen);
				setState(930);
				statement();
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(932);
				match(Do);
				setState(933);
				statement();
				setState(934);
				match(While);
				setState(935);
				match(LeftParen);
				setState(936);
				expression();
				setState(937);
				match(RightParen);
				setState(938);
				match(Semi);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(940);
				match(For);
				setState(941);
				match(LeftParen);
				setState(954);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(942);
					forInitStatement();
					setState(944);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7020875893828927996L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590621240943L) != 0) || _la==Doublecolon || _la==Identifier) {
						{
						setState(943);
						condition();
						}
					}

					setState(946);
					match(Semi);
					setState(948);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590615849511L) != 0) || _la==Doublecolon || _la==Identifier) {
						{
						setState(947);
						expression();
						}
					}

					}
					break;
				case 2:
					{
					setState(950);
					forRangeDeclaration();
					setState(951);
					match(Colon);
					setState(952);
					forRangeInitializer();
					}
					break;
				}
				setState(956);
				match(RightParen);
				setState(957);
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
		enterRule(_localctx, 114, RULE_forInitStatement);
		try {
			setState(963);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(961);
				expressionStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(962);
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
		enterRule(_localctx, 116, RULE_forRangeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(965);
				attributeSpecifierSeq();
				}
			}

			setState(968);
			declSpecifierSeq();
			setState(969);
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
		enterRule(_localctx, 118, RULE_forRangeInitializer);
		try {
			setState(973);
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
				setState(971);
				expression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(972);
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
		enterRule(_localctx, 120, RULE_jumpStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
				{
				setState(975);
				match(Break);
				}
				break;
			case Continue:
				{
				setState(976);
				match(Continue);
				}
				break;
			case Return:
				{
				setState(977);
				match(Return);
				setState(980);
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
					setState(978);
					expression();
					}
					break;
				case LeftBrace:
					{
					setState(979);
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
				setState(982);
				match(Goto);
				setState(983);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(986);
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
		enterRule(_localctx, 122, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
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
		enterRule(_localctx, 124, RULE_declarationseq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(991); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(990);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(993); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
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
		enterRule(_localctx, 126, RULE_declaration);
		try {
			setState(1004);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(995);
				blockDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(996);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(997);
				templateDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(998);
				explicitInstantiation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(999);
				explicitSpecialization();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1000);
				linkageSpecification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1001);
				namespaceDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1002);
				emptyDeclaration_();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1003);
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
		enterRule(_localctx, 128, RULE_blockDeclaration);
		try {
			setState(1014);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1006);
				simpleDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1007);
				asmDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1008);
				namespaceAliasDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1009);
				usingDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1010);
				usingDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1011);
				staticAssertDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1012);
				aliasDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1013);
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
		enterRule(_localctx, 130, RULE_aliasDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1016);
			match(Using);
			setState(1017);
			match(Identifier);
			setState(1019);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1018);
				attributeSpecifierSeq();
				}
			}

			setState(1021);
			match(Assign);
			setState(1022);
			theTypeId();
			setState(1023);
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
		enterRule(_localctx, 132, RULE_simpleDeclaration);
		int _la;
		try {
			setState(1039);
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
				setState(1026);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(1025);
					declSpecifierSeq();
					}
					break;
				}
				setState(1029);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Operator || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 215512868999425L) != 0)) {
					{
					setState(1028);
					initDeclaratorList();
					}
				}

				setState(1031);
				match(Semi);
				}
				break;
			case Alignas:
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1032);
				attributeSpecifierSeq();
				setState(1034);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(1033);
					declSpecifierSeq();
					}
					break;
				}
				setState(1036);
				initDeclaratorList();
				setState(1037);
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
		enterRule(_localctx, 134, RULE_staticAssertDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1041);
			match(Static_assert);
			setState(1042);
			match(LeftParen);
			setState(1043);
			constantExpression();
			setState(1044);
			match(Comma);
			setState(1045);
			match(StringLiteral);
			setState(1046);
			match(RightParen);
			setState(1047);
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
		enterRule(_localctx, 136, RULE_emptyDeclaration_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1049);
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
		enterRule(_localctx, 138, RULE_attributeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1051);
			attributeSpecifierSeq();
			setState(1052);
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
		enterRule(_localctx, 140, RULE_declSpecifier);
		try {
			setState(1060);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Extern:
			case Mutable:
			case Register:
			case Static:
			case Thread_local:
				enterOuterAlt(_localctx, 1);
				{
				setState(1054);
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
				setState(1055);
				typeSpecifier();
				}
				break;
			case Explicit:
			case Inline:
			case Virtual:
				enterOuterAlt(_localctx, 3);
				{
				setState(1056);
				functionSpecifier();
				}
				break;
			case Friend:
				enterOuterAlt(_localctx, 4);
				{
				setState(1057);
				match(Friend);
				}
				break;
			case Typedef:
				enterOuterAlt(_localctx, 5);
				{
				setState(1058);
				match(Typedef);
				}
				break;
			case Constexpr:
				enterOuterAlt(_localctx, 6);
				{
				setState(1059);
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
		enterRule(_localctx, 142, RULE_declSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1063); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(1062);
					declSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1065); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1068);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(1067);
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
		enterRule(_localctx, 144, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1070);
			_la = _input.LA(1);
			if ( !(((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & 17316186113L) != 0)) ) {
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
		enterRule(_localctx, 146, RULE_functionSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072);
			_la = _input.LA(1);
			if ( !(((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & 70368744178689L) != 0)) ) {
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
		enterRule(_localctx, 148, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1074);
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
		enterRule(_localctx, 150, RULE_typeSpecifier);
		try {
			setState(1079);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1076);
				trailingTypeSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1077);
				classSpecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1078);
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
		enterRule(_localctx, 152, RULE_trailingTypeSpecifier);
		try {
			setState(1085);
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
				setState(1081);
				simpleTypeSpecifier();
				}
				break;
			case Class:
			case Enum:
			case Struct:
				enterOuterAlt(_localctx, 2);
				{
				setState(1082);
				elaboratedTypeSpecifier();
				}
				break;
			case Typename_:
				enterOuterAlt(_localctx, 3);
				{
				setState(1083);
				typeNameSpecifier();
				}
				break;
			case Const:
			case Volatile:
				enterOuterAlt(_localctx, 4);
				{
				setState(1084);
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
		enterRule(_localctx, 154, RULE_typeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1088); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1087);
					typeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1090); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1093);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(1092);
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
		enterRule(_localctx, 156, RULE_trailingTypeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1096); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1095);
					trailingTypeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1098); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(1100);
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
		enterRule(_localctx, 158, RULE_simpleTypeLengthModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1103);
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
		enterRule(_localctx, 160, RULE_simpleTypeSignednessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1105);
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
		enterRule(_localctx, 162, RULE_simpleTypeSpecifier);
		try {
			setState(1131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(1107);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1110);
				theTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1111);
				nestedNameSpecifier(0);
				setState(1112);
				match(Template);
				setState(1113);
				simpleTemplateId();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1115);
				match(Char);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1116);
				match(Char16);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1117);
				match(Char32);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1118);
				match(Wchar);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1119);
				match(Bool);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1120);
				match(Short);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1121);
				match(Int);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1122);
				match(Long);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1123);
				match(Float);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1124);
				match(Signed);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1125);
				match(Unsigned);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1126);
				match(Float);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1127);
				match(Double);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1128);
				match(Void);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1129);
				match(Auto);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1130);
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
		enterRule(_localctx, 164, RULE_theTypeName);
		try {
			setState(1137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1133);
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1134);
				enumName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1135);
				typedefName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1136);
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
		enterRule(_localctx, 166, RULE_decltypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			match(Decltype);
			setState(1140);
			match(LeftParen);
			setState(1143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				{
				setState(1141);
				expression();
				}
				break;
			case 2:
				{
				setState(1142);
				match(Auto);
				}
				break;
			}
			setState(1145);
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
		enterRule(_localctx, 168, RULE_elaboratedTypeSpecifier);
		int _la;
		try {
			setState(1169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Struct:
				enterOuterAlt(_localctx, 1);
				{
				setState(1147);
				classKey();
				setState(1162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
				case 1:
					{
					setState(1149);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Alignas || _la==LeftBracket) {
						{
						setState(1148);
						attributeSpecifierSeq();
						}
					}

					setState(1152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
					case 1:
						{
						setState(1151);
						nestedNameSpecifier(0);
						}
						break;
					}
					setState(1154);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(1155);
					simpleTemplateId();
					}
					break;
				case 3:
					{
					setState(1156);
					nestedNameSpecifier(0);
					setState(1158);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Template) {
						{
						setState(1157);
						match(Template);
						}
					}

					setState(1160);
					simpleTemplateId();
					}
					break;
				}
				}
				break;
			case Enum:
				enterOuterAlt(_localctx, 2);
				{
				setState(1164);
				match(Enum);
				setState(1166);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
				case 1:
					{
					setState(1165);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1168);
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
		enterRule(_localctx, 170, RULE_enumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1171);
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
		enterRule(_localctx, 172, RULE_enumSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1173);
			enumHead();
			setState(1174);
			match(LeftBrace);
			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1175);
				enumeratorList();
				setState(1177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1176);
					match(Comma);
					}
				}

				}
			}

			setState(1181);
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
		enterRule(_localctx, 174, RULE_enumHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1183);
			enumkey();
			setState(1185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1184);
				attributeSpecifierSeq();
				}
			}

			setState(1191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
				{
				setState(1188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
				case 1:
					{
					setState(1187);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1190);
				match(Identifier);
				}
			}

			setState(1194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1193);
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
		enterRule(_localctx, 176, RULE_opaqueEnumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			enumkey();
			setState(1198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1197);
				attributeSpecifierSeq();
				}
			}

			setState(1200);
			match(Identifier);
			setState(1202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1201);
				enumbase();
				}
			}

			setState(1204);
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
		enterRule(_localctx, 178, RULE_enumkey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1206);
			match(Enum);
			setState(1208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Class || _la==Struct) {
				{
				setState(1207);
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
		enterRule(_localctx, 180, RULE_enumbase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1210);
			match(Colon);
			setState(1211);
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
		enterRule(_localctx, 182, RULE_enumeratorList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1213);
			enumeratorDefinition();
			setState(1218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1214);
					match(Comma);
					setState(1215);
					enumeratorDefinition();
					}
					} 
				}
				setState(1220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
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
		enterRule(_localctx, 184, RULE_enumeratorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1221);
			enumerator();
			setState(1224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(1222);
				match(Assign);
				setState(1223);
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
		enterRule(_localctx, 186, RULE_enumerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1226);
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
		enterRule(_localctx, 188, RULE_namespaceName);
		try {
			setState(1230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1228);
				originalNamespaceName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1229);
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
		enterRule(_localctx, 190, RULE_originalNamespaceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1232);
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
		enterRule(_localctx, 192, RULE_namespaceDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Inline) {
				{
				setState(1234);
				match(Inline);
				}
			}

			setState(1237);
			match(Namespace);
			setState(1240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				{
				setState(1238);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(1239);
				originalNamespaceName();
				}
				break;
			}
			setState(1242);
			match(LeftBrace);
			setState(1244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1543754443169808157L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 459384754220313597L) != 0)) {
				{
				setState(1243);
				((NamespaceDefinitionContext)_localctx).namespaceBody = declarationseq();
				}
			}

			setState(1246);
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
		enterRule(_localctx, 194, RULE_namespaceAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1248);
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
		enterRule(_localctx, 196, RULE_namespaceAliasDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1250);
			match(Namespace);
			setState(1251);
			match(Identifier);
			setState(1252);
			match(Assign);
			setState(1253);
			qualifiednamespacespecifier();
			setState(1254);
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
		enterRule(_localctx, 198, RULE_qualifiednamespacespecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				{
				setState(1256);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1259);
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
		enterRule(_localctx, 200, RULE_usingDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1261);
			match(Using);
			setState(1267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				{
				setState(1263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Typename_) {
					{
					setState(1262);
					match(Typename_);
					}
				}

				setState(1265);
				nestedNameSpecifier(0);
				}
				break;
			case 2:
				{
				setState(1266);
				match(Doublecolon);
				}
				break;
			}
			setState(1269);
			unqualifiedId();
			setState(1270);
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
		enterRule(_localctx, 202, RULE_usingDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1272);
				attributeSpecifierSeq();
				}
			}

			setState(1275);
			match(Using);
			setState(1276);
			match(Namespace);
			setState(1278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1277);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1280);
			namespaceName();
			setState(1281);
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
		enterRule(_localctx, 204, RULE_asmDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1283);
			match(Asm);
			setState(1284);
			match(LeftParen);
			setState(1285);
			match(StringLiteral);
			setState(1286);
			match(RightParen);
			setState(1287);
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
		enterRule(_localctx, 206, RULE_linkageSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1289);
			match(Extern);
			setState(1290);
			match(StringLiteral);
			setState(1297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				{
				setState(1291);
				match(LeftBrace);
				setState(1293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1543754443169808157L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 459384754220313597L) != 0)) {
					{
					setState(1292);
					declarationseq();
					}
				}

				setState(1295);
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
				setState(1296);
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
		enterRule(_localctx, 208, RULE_attributeSpecifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1300); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1299);
					attributeSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1302); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
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
		enterRule(_localctx, 210, RULE_attributeSpecifier);
		int _la;
		try {
			setState(1312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1304);
				match(LeftBracket);
				setState(1305);
				match(LeftBracket);
				setState(1307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1306);
					attributeList();
					}
				}

				setState(1309);
				match(RightBracket);
				setState(1310);
				match(RightBracket);
				}
				break;
			case Alignas:
				enterOuterAlt(_localctx, 2);
				{
				setState(1311);
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
		enterRule(_localctx, 212, RULE_alignmentspecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1314);
			match(Alignas);
			setState(1315);
			match(LeftParen);
			setState(1318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
			case 1:
				{
				setState(1316);
				theTypeId();
				}
				break;
			case 2:
				{
				setState(1317);
				constantExpression();
				}
				break;
			}
			setState(1321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1320);
				match(Ellipsis);
				}
			}

			setState(1323);
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
		enterRule(_localctx, 214, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1325);
			attribute();
			setState(1330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1326);
				match(Comma);
				setState(1327);
				attribute();
				}
				}
				setState(1332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1333);
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
		enterRule(_localctx, 216, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				{
				setState(1336);
				attributeNamespace();
				setState(1337);
				match(Doublecolon);
				}
				break;
			}
			setState(1341);
			match(Identifier);
			setState(1343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(1342);
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
		enterRule(_localctx, 218, RULE_attributeNamespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1345);
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
		enterRule(_localctx, 220, RULE_attributeArgumentClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1347);
			match(LeftParen);
			setState(1349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1409286145L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4194303L) != 0)) {
				{
				setState(1348);
				balancedTokenSeq();
				}
			}

			setState(1351);
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
		enterRule(_localctx, 222, RULE_balancedTokenSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1354); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1353);
				balancedtoken();
				}
				}
				setState(1356); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -2L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1409286145L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4194303L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 224, RULE_balancedtoken);
		int _la;
		try {
			int _alt;
			setState(1375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(1358);
				match(LeftParen);
				setState(1359);
				balancedTokenSeq();
				setState(1360);
				match(RightParen);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1362);
				match(LeftBracket);
				setState(1363);
				balancedTokenSeq();
				setState(1364);
				match(RightBracket);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 3);
				{
				setState(1366);
				match(LeftBrace);
				setState(1367);
				balancedTokenSeq();
				setState(1368);
				match(RightBrace);
				}
				break;
			case PreProcessorLiteral:
			case IntegerLiteral:
			case CharacterLiteral:
			case FloatingLiteral:
			case StringLiteral:
			case BooleanLiteral:
			case PointerLiteral:
			case UserDefinedLiteral:
			case LineBreakCombiner:
			case Pragma_Once:
			case Preprocessor_Include:
			case Preprocessor_If:
			case Preprocessor_Endif:
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
				setState(1371); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1370);
						_la = _input.LA(1);
						if ( _la <= 0 || (((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 63L) != 0)) ) {
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
					setState(1373); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
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
		enterRule(_localctx, 226, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1377);
			initDeclarator();
			setState(1382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1378);
				match(Comma);
				setState(1379);
				initDeclarator();
				}
				}
				setState(1384);
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
		enterRule(_localctx, 228, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1385);
			declarator();
			setState(1387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 65553L) != 0)) {
				{
				setState(1386);
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
		enterRule(_localctx, 230, RULE_declarator);
		try {
			setState(1394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1389);
				pointerDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1390);
				noPointerDeclarator(0);
				setState(1391);
				parametersAndQualifiers();
				setState(1392);
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
		enterRule(_localctx, 232, RULE_pointerDeclarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1402);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1396);
					pointerOperator();
					setState(1398);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Const) {
						{
						setState(1397);
						match(Const);
						}
					}

					}
					} 
				}
				setState(1404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			setState(1405);
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
		int _startState = 234;
		enterRecursionRule(_localctx, 234, RULE_noPointerDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Operator:
			case Tilde:
			case Doublecolon:
			case Ellipsis:
			case Identifier:
				{
				setState(1408);
				declaratorid();
				setState(1410);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
				case 1:
					{
					setState(1409);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case LeftParen:
				{
				setState(1412);
				match(LeftParen);
				setState(1413);
				pointerDeclarator();
				setState(1414);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1432);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerDeclarator);
					setState(1418);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1428);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1419);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1420);
						match(LeftBracket);
						setState(1422);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590615847463L) != 0) || _la==Doublecolon || _la==Identifier) {
							{
							setState(1421);
							constantExpression();
							}
						}

						setState(1424);
						match(RightBracket);
						setState(1426);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
						case 1:
							{
							setState(1425);
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
				setState(1434);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
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
		enterRule(_localctx, 236, RULE_parametersAndQualifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1435);
			match(LeftParen);
			setState(1437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1237504995584196377L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 297237575406461917L) != 0)) {
				{
				setState(1436);
				parameterDeclarationClause();
				}
			}

			setState(1439);
			match(RightParen);
			setState(1441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				{
				setState(1440);
				cvqualifierseq();
				}
				break;
			}
			setState(1444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				{
				setState(1443);
				refqualifier();
				}
				break;
			}
			setState(1447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				{
				setState(1446);
				exceptionSpecification();
				}
				break;
			}
			setState(1450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
			case 1:
				{
				setState(1449);
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
		enterRule(_localctx, 238, RULE_trailingReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1452);
			match(Arrow);
			setState(1453);
			trailingTypeSpecifierSeq();
			setState(1455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
			case 1:
				{
				setState(1454);
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
		enterRule(_localctx, 240, RULE_pointerOperator);
		int _la;
		try {
			setState(1471);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case AndAnd:
				enterOuterAlt(_localctx, 1);
				{
				setState(1457);
				_la = _input.LA(1);
				if ( !(_la==And || _la==AndAnd) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1459);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
				case 1:
					{
					setState(1458);
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
				setState(1462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1461);
					nestedNameSpecifier(0);
					}
				}

				setState(1464);
				match(Star);
				setState(1466);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
				case 1:
					{
					setState(1465);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(1469);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
				case 1:
					{
					setState(1468);
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
		enterRule(_localctx, 242, RULE_cvqualifierseq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1474); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1473);
					cvQualifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1476); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
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
		enterRule(_localctx, 244, RULE_cvQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
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
		enterRule(_localctx, 246, RULE_refqualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1480);
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
		enterRule(_localctx, 248, RULE_declaratorid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1482);
				match(Ellipsis);
				}
			}

			setState(1485);
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
		enterRule(_localctx, 250, RULE_theTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1487);
			typeSpecifierSeq();
			setState(1489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				{
				setState(1488);
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
		enterRule(_localctx, 252, RULE_abstractDeclarator);
		try {
			setState(1499);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1491);
				pointerAbstractDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1493);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
				case 1:
					{
					setState(1492);
					noPointerAbstractDeclarator(0);
					}
					break;
				}
				setState(1495);
				parametersAndQualifiers();
				setState(1496);
				trailingReturnType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1498);
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
		enterRule(_localctx, 254, RULE_pointerAbstractDeclarator);
		try {
			int _alt;
			setState(1510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1501);
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
				setState(1503); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1502);
						pointerOperator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1505); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1508);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
				case 1:
					{
					setState(1507);
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
		int _startState = 256;
		enterRecursionRule(_localctx, 256, RULE_noPointerAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				{
				setState(1513);
				parametersAndQualifiers();
				}
				break;
			case 2:
				{
				setState(1514);
				match(LeftBracket);
				setState(1516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590615847463L) != 0) || _la==Doublecolon || _la==Identifier) {
					{
					setState(1515);
					constantExpression();
					}
				}

				setState(1518);
				match(RightBracket);
				setState(1520);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
				case 1:
					{
					setState(1519);
					attributeSpecifierSeq();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(1522);
				match(LeftParen);
				setState(1523);
				pointerAbstractDeclarator();
				setState(1524);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerAbstractDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerAbstractDeclarator);
					setState(1528);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(1539);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
					case 1:
						{
						setState(1529);
						parametersAndQualifiers();
						}
						break;
					case 2:
						{
						setState(1530);
						noPointerAbstractDeclarator(0);
						setState(1531);
						match(LeftBracket);
						setState(1533);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590615847463L) != 0) || _la==Doublecolon || _la==Identifier) {
							{
							setState(1532);
							constantExpression();
							}
						}

						setState(1535);
						match(RightBracket);
						setState(1537);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
						case 1:
							{
							setState(1536);
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
				setState(1545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
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
		enterRule(_localctx, 258, RULE_abstractPackDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Decltype || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & 566969237521L) != 0)) {
				{
				{
				setState(1546);
				pointerOperator();
				}
				}
				setState(1551);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1552);
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
		int _startState = 260;
		enterRecursionRule(_localctx, 260, RULE_noPointerAbstractPackDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1555);
			match(Ellipsis);
			}
			_ctx.stop = _input.LT(-1);
			setState(1571);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NoPointerAbstractPackDeclaratorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_noPointerAbstractPackDeclarator);
					setState(1557);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1567);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LeftParen:
						{
						setState(1558);
						parametersAndQualifiers();
						}
						break;
					case LeftBracket:
						{
						setState(1559);
						match(LeftBracket);
						setState(1561);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590615847463L) != 0) || _la==Doublecolon || _la==Identifier) {
							{
							setState(1560);
							constantExpression();
							}
						}

						setState(1563);
						match(RightBracket);
						setState(1565);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
						case 1:
							{
							setState(1564);
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
				setState(1573);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
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
		enterRule(_localctx, 262, RULE_parameterDeclarationClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1574);
			parameterDeclarationList();
			setState(1579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma || _la==Ellipsis) {
				{
				setState(1576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1575);
					match(Comma);
					}
				}

				setState(1578);
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
		enterRule(_localctx, 264, RULE_parameterDeclarationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1581);
			parameterDeclaration();
			setState(1586);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1582);
					match(Comma);
					setState(1583);
					parameterDeclaration();
					}
					} 
				}
				setState(1588);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
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
		enterRule(_localctx, 266, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1589);
				attributeSpecifierSeq();
				}
			}

			setState(1592);
			declSpecifierSeq();
			setState(1597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				{
				setState(1593);
				declarator();
				}
				break;
			case 2:
				{
				setState(1595);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
				case 1:
					{
					setState(1594);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			}
			setState(1601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(1599);
				match(Assign);
				setState(1600);
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
		enterRule(_localctx, 268, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1603);
				attributeSpecifierSeq();
				}
			}

			setState(1607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
			case 1:
				{
				setState(1606);
				declSpecifierSeq();
				}
				break;
			}
			setState(1609);
			declarator();
			setState(1611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Final || _la==Override) {
				{
				setState(1610);
				virtualSpecifierSeq();
				}
			}

			setState(1613);
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
		enterRule(_localctx, 270, RULE_functionBody);
		int _la;
		try {
			setState(1623);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Colon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1615);
					constructorInitializer();
					}
				}

				setState(1618);
				compoundStatement();
				}
				break;
			case Try:
				enterOuterAlt(_localctx, 2);
				{
				setState(1619);
				functionTryBlock();
				}
				break;
			case Assign:
				enterOuterAlt(_localctx, 3);
				{
				setState(1620);
				match(Assign);
				setState(1621);
				_la = _input.LA(1);
				if ( !(_la==Default || _la==Delete) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1622);
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
		enterRule(_localctx, 272, RULE_initializer);
		try {
			setState(1630);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1625);
				braceOrEqualInitializer();
				}
				break;
			case LeftParen:
				enterOuterAlt(_localctx, 2);
				{
				setState(1626);
				match(LeftParen);
				setState(1627);
				expressionList();
				setState(1628);
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
		enterRule(_localctx, 274, RULE_braceOrEqualInitializer);
		try {
			setState(1635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(1632);
				match(Assign);
				setState(1633);
				initializerClause();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1634);
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
		enterRule(_localctx, 276, RULE_initializerClause);
		try {
			setState(1639);
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
				setState(1637);
				assignmentExpression();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(1638);
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
		enterRule(_localctx, 278, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1641);
			initializerClause();
			setState(1643);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1642);
				match(Ellipsis);
				}
			}

			setState(1652);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,218,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1645);
					match(Comma);
					setState(1646);
					initializerClause();
					setState(1648);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ellipsis) {
						{
						setState(1647);
						match(Ellipsis);
						}
					}

					}
					} 
				}
				setState(1654);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,218,_ctx);
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
		enterRule(_localctx, 280, RULE_bracedInitList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
			match(LeftBrace);
			setState(1660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766591152720423L) != 0) || _la==Doublecolon || _la==Identifier) {
				{
				setState(1656);
				initializerList();
				setState(1658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1657);
					match(Comma);
					}
				}

				}
			}

			setState(1662);
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
		enterRule(_localctx, 282, RULE_className);
		try {
			setState(1666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1664);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1665);
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
		enterRule(_localctx, 284, RULE_classSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1668);
			classHead();
			setState(1669);
			match(LeftBrace);
			setState(1671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1543877313594212121L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 463888353847684093L) != 0)) {
				{
				setState(1670);
				memberSpecification();
				}
			}

			setState(1673);
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
		enterRule(_localctx, 286, RULE_classHead);
		int _la;
		try {
			setState(1698);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Struct:
				enterOuterAlt(_localctx, 1);
				{
				setState(1675);
				classKey();
				setState(1677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1676);
					attributeSpecifierSeq();
					}
				}

				setState(1683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1679);
					classHeadName();
					setState(1681);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Final) {
						{
						setState(1680);
						classVirtSpecifier();
						}
					}

					}
				}

				setState(1686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1685);
					baseClause();
					}
				}

				}
				break;
			case Union:
				enterOuterAlt(_localctx, 2);
				{
				setState(1688);
				match(Union);
				setState(1690);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1689);
					attributeSpecifierSeq();
					}
				}

				setState(1696);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Decltype || _la==Doublecolon || _la==Identifier) {
					{
					setState(1692);
					classHeadName();
					setState(1694);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Final) {
						{
						setState(1693);
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
		enterRule(_localctx, 288, RULE_classHeadName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				{
				setState(1700);
				nestedNameSpecifier(0);
				}
				break;
			}
			setState(1703);
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
		enterRule(_localctx, 290, RULE_classVirtSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1705);
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
		enterRule(_localctx, 292, RULE_classKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1707);
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
		enterRule(_localctx, 294, RULE_memberSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1713); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1713);
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
					setState(1709);
					memberdeclaration();
					}
					break;
				case Private:
				case Protected:
				case Public:
					{
					setState(1710);
					accessSpecifier();
					setState(1711);
					match(Colon);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1715); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1543877313594212121L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 463888353847684093L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 296, RULE_memberdeclaration);
		int _la;
		try {
			setState(1733);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1718);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
				case 1:
					{
					setState(1717);
					attributeSpecifierSeq();
					}
					break;
				}
				setState(1721);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
				case 1:
					{
					setState(1720);
					declSpecifierSeq();
					}
					break;
				}
				setState(1724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057595111686144L) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 217711892254981L) != 0)) {
					{
					setState(1723);
					memberDeclaratorList();
					}
				}

				setState(1726);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1727);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1728);
				usingDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1729);
				staticAssertDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1730);
				templateDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1731);
				aliasDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1732);
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
		enterRule(_localctx, 298, RULE_memberDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1735);
			memberDeclarator();
			setState(1740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1736);
				match(Comma);
				setState(1737);
				memberDeclarator();
				}
				}
				setState(1742);
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
		enterRule(_localctx, 300, RULE_memberDeclarator);
		int _la;
		try {
			setState(1763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1743);
				declarator();
				setState(1752);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
				case 1:
					{
					setState(1744);
					virtualSpecifierSeq();
					}
					break;
				case 2:
					{
					setState(1745);
					if (!( IsPureSpecifierAllowed() )) throw new FailedPredicateException(this, " IsPureSpecifierAllowed() ");
					setState(1746);
					pureSpecifier();
					}
					break;
				case 3:
					{
					setState(1747);
					if (!( IsPureSpecifierAllowed() )) throw new FailedPredicateException(this, " IsPureSpecifierAllowed() ");
					setState(1748);
					virtualSpecifierSeq();
					setState(1749);
					pureSpecifier();
					}
					break;
				case 4:
					{
					setState(1751);
					braceOrEqualInitializer();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1754);
				declarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1756);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1755);
					match(Identifier);
					}
				}

				setState(1759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1758);
					attributeSpecifierSeq();
					}
				}

				setState(1761);
				match(Colon);
				setState(1762);
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
		enterRule(_localctx, 302, RULE_virtualSpecifierSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1766); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1765);
				virtualSpecifier();
				}
				}
				setState(1768); 
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
		enterRule(_localctx, 304, RULE_virtualSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1770);
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
		enterRule(_localctx, 306, RULE_pureSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1772);
			match(Assign);
			setState(1773);
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
		enterRule(_localctx, 308, RULE_baseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			match(Colon);
			setState(1776);
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
		enterRule(_localctx, 310, RULE_baseSpecifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1778);
			baseSpecifier();
			setState(1780);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1779);
				match(Ellipsis);
				}
			}

			setState(1789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1782);
				match(Comma);
				setState(1783);
				baseSpecifier();
				setState(1785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1784);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1791);
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
		enterRule(_localctx, 312, RULE_baseSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alignas || _la==LeftBracket) {
				{
				setState(1792);
				attributeSpecifierSeq();
				}
			}

			setState(1807);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Decltype:
			case Doublecolon:
			case Identifier:
				{
				setState(1795);
				baseTypeSpecifier();
				}
				break;
			case Virtual:
				{
				setState(1796);
				match(Virtual);
				setState(1798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017612633061982208L) != 0)) {
					{
					setState(1797);
					accessSpecifier();
					}
				}

				setState(1800);
				baseTypeSpecifier();
				}
				break;
			case Private:
			case Protected:
			case Public:
				{
				setState(1801);
				accessSpecifier();
				setState(1803);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Virtual) {
					{
					setState(1802);
					match(Virtual);
					}
				}

				setState(1805);
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
		enterRule(_localctx, 314, RULE_classOrDeclType);
		try {
			setState(1814);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1810);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
				case 1:
					{
					setState(1809);
					nestedNameSpecifier(0);
					}
					break;
				}
				setState(1812);
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1813);
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
		enterRule(_localctx, 316, RULE_baseTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1816);
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
		enterRule(_localctx, 318, RULE_accessSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1818);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017612633061982208L) != 0)) ) {
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
		enterRule(_localctx, 320, RULE_conversionFunctionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1820);
			match(Operator);
			setState(1821);
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
		enterRule(_localctx, 322, RULE_conversionTypeId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1823);
			typeSpecifierSeq();
			setState(1825);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				{
				setState(1824);
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
		enterRule(_localctx, 324, RULE_conversionDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1827);
			pointerOperator();
			setState(1829);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
			case 1:
				{
				setState(1828);
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
		enterRule(_localctx, 326, RULE_constructorInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1831);
			match(Colon);
			setState(1832);
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
		enterRule(_localctx, 328, RULE_memInitializerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1834);
			memInitializer();
			setState(1836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1835);
				match(Ellipsis);
				}
			}

			setState(1845);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1838);
				match(Comma);
				setState(1839);
				memInitializer();
				setState(1841);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1840);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1847);
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
		enterRule(_localctx, 330, RULE_memInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1848);
			meminitializerid();
			setState(1855);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				{
				setState(1849);
				match(LeftParen);
				setState(1851);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712462913389363708L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766591152720423L) != 0) || _la==Doublecolon || _la==Identifier) {
					{
					setState(1850);
					expressionList();
					}
				}

				setState(1853);
				match(RightParen);
				}
				break;
			case LeftBrace:
				{
				setState(1854);
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
		enterRule(_localctx, 332, RULE_meminitializerid);
		try {
			setState(1859);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1857);
				classOrDeclType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1858);
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
		enterRule(_localctx, 334, RULE_operatorFunctionId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1861);
			match(Operator);
			setState(1862);
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
		enterRule(_localctx, 336, RULE_literalOperatorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1864);
			match(Operator);
			setState(1868);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
				{
				setState(1865);
				match(StringLiteral);
				setState(1866);
				match(Identifier);
				}
				break;
			case UserDefinedStringLiteral:
				{
				setState(1867);
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
		enterRule(_localctx, 338, RULE_templateDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1870);
			match(Template);
			setState(1871);
			match(Less);
			setState(1872);
			templateparameterList();
			setState(1873);
			match(Greater);
			setState(1874);
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
		enterRule(_localctx, 340, RULE_templateparameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1876);
			templateParameter();
			setState(1881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1877);
				match(Comma);
				setState(1878);
				templateParameter();
				}
				}
				setState(1883);
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
		enterRule(_localctx, 342, RULE_templateParameter);
		try {
			setState(1886);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1884);
				typeParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1885);
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
		enterRule(_localctx, 344, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1897);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Template:
				{
				setState(1893);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1888);
					match(Template);
					setState(1889);
					match(Less);
					setState(1890);
					templateparameterList();
					setState(1891);
					match(Greater);
					}
				}

				setState(1895);
				match(Class);
				}
				break;
			case Typename_:
				{
				setState(1896);
				match(Typename_);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1910);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
			case 1:
				{
				setState(1900);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1899);
					match(Ellipsis);
					}
				}

				setState(1903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1902);
					match(Identifier);
					}
				}

				}
				break;
			case 2:
				{
				setState(1906);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(1905);
					match(Identifier);
					}
				}

				setState(1908);
				match(Assign);
				setState(1909);
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
		enterRule(_localctx, 346, RULE_simpleTemplateId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1912);
			templateName();
			setState(1913);
			match(Less);
			setState(1915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712463050928980476L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590620172903L) != 0) || _la==Doublecolon || _la==Identifier) {
				{
				setState(1914);
				templateArgumentList();
				}
			}

			setState(1917);
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
		enterRule(_localctx, 348, RULE_templateId);
		int _la;
		try {
			setState(1930);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1919);
				simpleTemplateId();
				}
				break;
			case Operator:
				enterOuterAlt(_localctx, 2);
				{
				setState(1922);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
				case 1:
					{
					setState(1920);
					operatorFunctionId();
					}
					break;
				case 2:
					{
					setState(1921);
					literalOperatorId();
					}
					break;
				}
				setState(1924);
				match(Less);
				setState(1926);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4712463050928980476L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 3458766590620172903L) != 0) || _la==Doublecolon || _la==Identifier) {
					{
					setState(1925);
					templateArgumentList();
					}
				}

				setState(1928);
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
		enterRule(_localctx, 350, RULE_templateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1932);
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
		enterRule(_localctx, 352, RULE_templateArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1934);
			templateArgument();
			setState(1936);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(1935);
				match(Ellipsis);
				}
			}

			setState(1945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1938);
				match(Comma);
				setState(1939);
				templateArgument();
				setState(1941);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1940);
					match(Ellipsis);
					}
				}

				}
				}
				setState(1947);
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
		enterRule(_localctx, 354, RULE_templateArgument);
		try {
			setState(1951);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1948);
				theTypeId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1949);
				constantExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1950);
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
		enterRule(_localctx, 356, RULE_typeNameSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1953);
			match(Typename_);
			setState(1954);
			nestedNameSpecifier(0);
			setState(1960);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,279,_ctx) ) {
			case 1:
				{
				setState(1955);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(1957);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Template) {
					{
					setState(1956);
					match(Template);
					}
				}

				setState(1959);
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
		enterRule(_localctx, 358, RULE_explicitInstantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Extern) {
				{
				setState(1962);
				match(Extern);
				}
			}

			setState(1965);
			match(Template);
			setState(1966);
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
		enterRule(_localctx, 360, RULE_explicitSpecialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1968);
			match(Template);
			setState(1969);
			match(Less);
			setState(1970);
			match(Greater);
			setState(1971);
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
		enterRule(_localctx, 362, RULE_tryBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1973);
			match(Try);
			setState(1974);
			compoundStatement();
			setState(1975);
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
		enterRule(_localctx, 364, RULE_functionTryBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1977);
			match(Try);
			setState(1979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1978);
				constructorInitializer();
				}
			}

			setState(1981);
			compoundStatement();
			setState(1982);
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
		enterRule(_localctx, 366, RULE_handlerSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1985); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1984);
				handler();
				}
				}
				setState(1987); 
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
		enterRule(_localctx, 368, RULE_handler);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1989);
			match(Catch);
			setState(1990);
			match(LeftParen);
			setState(1991);
			exceptionDeclaration();
			setState(1992);
			match(RightParen);
			setState(1993);
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
		enterRule(_localctx, 370, RULE_exceptionDeclaration);
		int _la;
		try {
			setState(2004);
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
				setState(1996);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Alignas || _la==LeftBracket) {
					{
					setState(1995);
					attributeSpecifierSeq();
					}
				}

				setState(1998);
				typeSpecifierSeq();
				setState(2001);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
				case 1:
					{
					setState(1999);
					declarator();
					}
					break;
				case 2:
					{
					setState(2000);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			case Ellipsis:
				enterOuterAlt(_localctx, 2);
				{
				setState(2003);
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
		enterRule(_localctx, 372, RULE_throwExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2006);
			match(Throw);
			setState(2008);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
			case 1:
				{
				setState(2007);
				assignmentExpression();
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
		enterRule(_localctx, 374, RULE_exceptionSpecification);
		try {
			setState(2012);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Throw:
				enterOuterAlt(_localctx, 1);
				{
				setState(2010);
				dynamicExceptionSpecification();
				}
				break;
			case Noexcept:
				enterOuterAlt(_localctx, 2);
				{
				setState(2011);
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
		enterRule(_localctx, 376, RULE_dynamicExceptionSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2014);
			match(Throw);
			setState(2015);
			match(LeftParen);
			setState(2017);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & -9213942612181769245L) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 37154696925806707L) != 0)) {
				{
				setState(2016);
				typeIdList();
				}
			}

			setState(2019);
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
		enterRule(_localctx, 378, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2021);
			theTypeId();
			setState(2023);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(2022);
				match(Ellipsis);
				}
			}

			setState(2032);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2025);
				match(Comma);
				setState(2026);
				theTypeId();
				setState(2028);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(2027);
					match(Ellipsis);
					}
				}

				}
				}
				setState(2034);
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
		enterRule(_localctx, 380, RULE_noeExceptSpecification);
		try {
			setState(2041);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2035);
				match(Noexcept);
				setState(2036);
				match(LeftParen);
				setState(2037);
				constantExpression();
				setState(2038);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2040);
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
		enterRule(_localctx, 382, RULE_theOperator);
		try {
			setState(2094);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2043);
				match(New);
				setState(2046);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
				case 1:
					{
					setState(2044);
					match(LeftBracket);
					setState(2045);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2048);
				match(Delete);
				setState(2051);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
				case 1:
					{
					setState(2049);
					match(LeftBracket);
					setState(2050);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2053);
				match(Plus);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2054);
				match(Minus);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2055);
				match(Star);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2056);
				match(Div);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2057);
				match(Mod);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2058);
				match(Caret);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2059);
				match(And);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2060);
				match(Or);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2061);
				match(Tilde);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2062);
				match(Not);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2063);
				match(Assign);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2064);
				match(Greater);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2065);
				match(Less);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(2066);
				match(GreaterEqual);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(2067);
				match(PlusAssign);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(2068);
				match(MinusAssign);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(2069);
				match(StarAssign);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(2070);
				match(ModAssign);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(2071);
				match(XorAssign);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(2072);
				match(AndAssign);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(2073);
				match(OrAssign);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(2074);
				match(Less);
				setState(2075);
				match(Less);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(2076);
				match(Greater);
				setState(2077);
				match(Greater);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(2078);
				match(RightShiftAssign);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(2079);
				match(LeftShiftAssign);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(2080);
				match(Equal);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(2081);
				match(NotEqual);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(2082);
				match(LessEqual);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(2083);
				match(AndAnd);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(2084);
				match(OrOr);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(2085);
				match(PlusPlus);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(2086);
				match(MinusMinus);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(2087);
				match(Comma);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(2088);
				match(ArrowStar);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(2089);
				match(Arrow);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(2090);
				match(LeftParen);
				setState(2091);
				match(RightParen);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(2092);
				match(LeftBracket);
				setState(2093);
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
		enterRule(_localctx, 384, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2096);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 508L) != 0)) ) {
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
		case 7:
			return nestedNameSpecifier_sempred((NestedNameSpecifierContext)_localctx, predIndex);
		case 17:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 27:
			return noPointerNewDeclarator_sempred((NoPointerNewDeclaratorContext)_localctx, predIndex);
		case 117:
			return noPointerDeclarator_sempred((NoPointerDeclaratorContext)_localctx, predIndex);
		case 128:
			return noPointerAbstractDeclarator_sempred((NoPointerAbstractDeclaratorContext)_localctx, predIndex);
		case 130:
			return noPointerAbstractPackDeclarator_sempred((NoPointerAbstractPackDeclaratorContext)_localctx, predIndex);
		case 150:
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
		"\u0004\u0001\u0095\u0833\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\u00bc\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be\u0002\u00bf\u0007"+
		"\u00bf\u0002\u00c0\u0007\u00c0\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0186\b\u0000\n\u0000\f\u0000\u0189\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002\u0194\b\u0002\u0001\u0003\u0004\u0003\u0197\b"+
		"\u0003\u000b\u0003\f\u0003\u0198\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u01a2\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u01a6\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u01af"+
		"\b\u0005\u0001\u0005\u0003\u0005\u01b2\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u01b6\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u01be\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u01c5\b\u0007\u0001\u0007"+
		"\u0003\u0007\u01c8\b\u0007\u0001\u0007\u0005\u0007\u01cb\b\u0007\n\u0007"+
		"\f\u0007\u01ce\t\u0007\u0001\b\u0001\b\u0003\b\u01d2\b\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0003\t\u01d8\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u01e0\b\n\u0003\n\u01e2\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u01e9\b\f\n\f\f\f\u01ec\t\f\u0001\f\u0003"+
		"\f\u01ef\b\f\u0001\r\u0001\r\u0003\r\u01f3\b\r\u0001\u000e\u0003\u000e"+
		"\u01f6\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01fa\b\u000e\u0001"+
		"\u000f\u0003\u000f\u01fd\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0204\b\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u0208\b\u0010\u0001\u0010\u0003\u0010\u020b\b\u0010\u0001\u0010"+
		"\u0003\u0010\u020e\b\u0010\u0001\u0010\u0003\u0010\u0211\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0217\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u021b\b\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u021f\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u022d\b\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0231\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0237\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u023e\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0244\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0248"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u024c\b\u0011\n\u0011\f\u0011"+
		"\u024f\t\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0003\u0014\u0256\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u025b\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0268\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u026f\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u027b\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0285\b\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0003\u0017\u028a\b"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u028e\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0295\b\u0017\u0001"+
		"\u0017\u0003\u0017\u0298\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u02a0\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u02a4\b\u001a\u0001\u001a\u0003\u001a\u02a7\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u02ae\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u02b5\b\u001b\u0005\u001b\u02b7\b\u001b\n\u001b\f\u001b\u02ba"+
		"\t\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u02be\b\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u02c2\b\u001c\u0001\u001d\u0003\u001d\u02c5\b"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u02ca\b\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u02d9\b\u001f\u0001 \u0001 \u0001 \u0005 \u02de\b "+
		"\n \f \u02e1\t \u0001!\u0001!\u0001!\u0005!\u02e6\b!\n!\f!\u02e9\t!\u0001"+
		"\"\u0001\"\u0001\"\u0005\"\u02ee\b\"\n\"\f\"\u02f1\t\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0005#\u02f7\b#\n#\f#\u02fa\t#\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u0300\b$\u0001%\u0001%\u0001%\u0005%\u0305\b%\n%\f%\u0308\t%\u0001&"+
		"\u0001&\u0001&\u0005&\u030d\b&\n&\f&\u0310\t&\u0001\'\u0001\'\u0001\'"+
		"\u0005\'\u0315\b\'\n\'\f\'\u0318\t\'\u0001(\u0001(\u0001(\u0005(\u031d"+
		"\b(\n(\f(\u0320\t(\u0001)\u0001)\u0001)\u0005)\u0325\b)\n)\f)\u0328\t"+
		")\u0001*\u0001*\u0001*\u0005*\u032d\b*\n*\f*\u0330\t*\u0001+\u0001+\u0001"+
		"+\u0005+\u0335\b+\n+\f+\u0338\t+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0003,\u0340\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u0348"+
		"\b-\u0001.\u0001.\u0001/\u0001/\u0001/\u0005/\u034f\b/\n/\f/\u0352\t/"+
		"\u00010\u00010\u00011\u00011\u00011\u00031\u0359\b1\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00031\u0361\b1\u00031\u0363\b1\u00012\u00032\u0366"+
		"\b2\u00012\u00012\u00012\u00012\u00032\u036c\b2\u00012\u00012\u00012\u0001"+
		"3\u00033\u0372\b3\u00013\u00013\u00014\u00014\u00034\u0378\b4\u00014\u0001"+
		"4\u00015\u00045\u037d\b5\u000b5\f5\u037e\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00036\u0388\b6\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00036\u0390\b6\u00017\u00017\u00037\u0394\b7\u00017\u00017\u00017\u0001"+
		"7\u00017\u00037\u039b\b7\u00037\u039d\b7\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00038\u03b1\b8\u00018\u00018\u00038\u03b5\b8\u0001"+
		"8\u00018\u00018\u00018\u00038\u03bb\b8\u00018\u00018\u00018\u00038\u03c0"+
		"\b8\u00019\u00019\u00039\u03c4\b9\u0001:\u0003:\u03c7\b:\u0001:\u0001"+
		":\u0001:\u0001;\u0001;\u0003;\u03ce\b;\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0003<\u03d5\b<\u0001<\u0001<\u0003<\u03d9\b<\u0001<\u0001<\u0001=\u0001"+
		"=\u0001>\u0004>\u03e0\b>\u000b>\f>\u03e1\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0003?\u03ed\b?\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0001@\u0001@\u0001@\u0003@\u03f7\b@\u0001A\u0001A\u0001A\u0003"+
		"A\u03fc\bA\u0001A\u0001A\u0001A\u0001A\u0001B\u0003B\u0403\bB\u0001B\u0003"+
		"B\u0406\bB\u0001B\u0001B\u0001B\u0003B\u040b\bB\u0001B\u0001B\u0001B\u0003"+
		"B\u0410\bB\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001"+
		"D\u0001D\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0003F\u0425\bF\u0001G\u0004G\u0428\bG\u000bG\fG\u0429\u0001G\u0003"+
		"G\u042d\bG\u0001H\u0001H\u0001I\u0001I\u0001J\u0001J\u0001K\u0001K\u0001"+
		"K\u0003K\u0438\bK\u0001L\u0001L\u0001L\u0001L\u0003L\u043e\bL\u0001M\u0004"+
		"M\u0441\bM\u000bM\fM\u0442\u0001M\u0003M\u0446\bM\u0001N\u0004N\u0449"+
		"\bN\u000bN\fN\u044a\u0001N\u0003N\u044e\bN\u0001O\u0001O\u0001P\u0001"+
		"P\u0001Q\u0003Q\u0455\bQ\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u046c\bQ\u0001R\u0001R\u0001R\u0001"+
		"R\u0003R\u0472\bR\u0001S\u0001S\u0001S\u0001S\u0003S\u0478\bS\u0001S\u0001"+
		"S\u0001T\u0001T\u0003T\u047e\bT\u0001T\u0003T\u0481\bT\u0001T\u0001T\u0001"+
		"T\u0001T\u0003T\u0487\bT\u0001T\u0001T\u0003T\u048b\bT\u0001T\u0001T\u0003"+
		"T\u048f\bT\u0001T\u0003T\u0492\bT\u0001U\u0001U\u0001V\u0001V\u0001V\u0001"+
		"V\u0003V\u049a\bV\u0003V\u049c\bV\u0001V\u0001V\u0001W\u0001W\u0003W\u04a2"+
		"\bW\u0001W\u0003W\u04a5\bW\u0001W\u0003W\u04a8\bW\u0001W\u0003W\u04ab"+
		"\bW\u0001X\u0001X\u0003X\u04af\bX\u0001X\u0001X\u0003X\u04b3\bX\u0001"+
		"X\u0001X\u0001Y\u0001Y\u0003Y\u04b9\bY\u0001Z\u0001Z\u0001Z\u0001[\u0001"+
		"[\u0001[\u0005[\u04c1\b[\n[\f[\u04c4\t[\u0001\\\u0001\\\u0001\\\u0003"+
		"\\\u04c9\b\\\u0001]\u0001]\u0001^\u0001^\u0003^\u04cf\b^\u0001_\u0001"+
		"_\u0001`\u0003`\u04d4\b`\u0001`\u0001`\u0001`\u0003`\u04d9\b`\u0001`\u0001"+
		"`\u0003`\u04dd\b`\u0001`\u0001`\u0001a\u0001a\u0001b\u0001b\u0001b\u0001"+
		"b\u0001b\u0001b\u0001c\u0003c\u04ea\bc\u0001c\u0001c\u0001d\u0001d\u0003"+
		"d\u04f0\bd\u0001d\u0001d\u0003d\u04f4\bd\u0001d\u0001d\u0001d\u0001e\u0003"+
		"e\u04fa\be\u0001e\u0001e\u0001e\u0003e\u04ff\be\u0001e\u0001e\u0001e\u0001"+
		"f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001g\u0001g\u0001g\u0001g\u0003"+
		"g\u050e\bg\u0001g\u0001g\u0003g\u0512\bg\u0001h\u0004h\u0515\bh\u000b"+
		"h\fh\u0516\u0001i\u0001i\u0001i\u0003i\u051c\bi\u0001i\u0001i\u0001i\u0003"+
		"i\u0521\bi\u0001j\u0001j\u0001j\u0001j\u0003j\u0527\bj\u0001j\u0003j\u052a"+
		"\bj\u0001j\u0001j\u0001k\u0001k\u0001k\u0005k\u0531\bk\nk\fk\u0534\tk"+
		"\u0001k\u0003k\u0537\bk\u0001l\u0001l\u0001l\u0003l\u053c\bl\u0001l\u0001"+
		"l\u0003l\u0540\bl\u0001m\u0001m\u0001n\u0001n\u0003n\u0546\bn\u0001n\u0001"+
		"n\u0001o\u0004o\u054b\bo\u000bo\fo\u054c\u0001p\u0001p\u0001p\u0001p\u0001"+
		"p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0004p\u055c"+
		"\bp\u000bp\fp\u055d\u0003p\u0560\bp\u0001q\u0001q\u0001q\u0005q\u0565"+
		"\bq\nq\fq\u0568\tq\u0001r\u0001r\u0003r\u056c\br\u0001s\u0001s\u0001s"+
		"\u0001s\u0001s\u0003s\u0573\bs\u0001t\u0001t\u0003t\u0577\bt\u0005t\u0579"+
		"\bt\nt\ft\u057c\tt\u0001t\u0001t\u0001u\u0001u\u0001u\u0003u\u0583\bu"+
		"\u0001u\u0001u\u0001u\u0001u\u0003u\u0589\bu\u0001u\u0001u\u0001u\u0001"+
		"u\u0003u\u058f\bu\u0001u\u0001u\u0003u\u0593\bu\u0003u\u0595\bu\u0005"+
		"u\u0597\bu\nu\fu\u059a\tu\u0001v\u0001v\u0003v\u059e\bv\u0001v\u0001v"+
		"\u0003v\u05a2\bv\u0001v\u0003v\u05a5\bv\u0001v\u0003v\u05a8\bv\u0001v"+
		"\u0003v\u05ab\bv\u0001w\u0001w\u0001w\u0003w\u05b0\bw\u0001x\u0001x\u0003"+
		"x\u05b4\bx\u0001x\u0003x\u05b7\bx\u0001x\u0001x\u0003x\u05bb\bx\u0001"+
		"x\u0003x\u05be\bx\u0003x\u05c0\bx\u0001y\u0004y\u05c3\by\u000by\fy\u05c4"+
		"\u0001z\u0001z\u0001{\u0001{\u0001|\u0003|\u05cc\b|\u0001|\u0001|\u0001"+
		"}\u0001}\u0003}\u05d2\b}\u0001~\u0001~\u0003~\u05d6\b~\u0001~\u0001~\u0001"+
		"~\u0001~\u0003~\u05dc\b~\u0001\u007f\u0001\u007f\u0004\u007f\u05e0\b\u007f"+
		"\u000b\u007f\f\u007f\u05e1\u0001\u007f\u0003\u007f\u05e5\b\u007f\u0003"+
		"\u007f\u05e7\b\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0003"+
		"\u0080\u05ed\b\u0080\u0001\u0080\u0001\u0080\u0003\u0080\u05f1\b\u0080"+
		"\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0003\u0080\u05f7\b\u0080"+
		"\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0003\u0080"+
		"\u05fe\b\u0080\u0001\u0080\u0001\u0080\u0003\u0080\u0602\b\u0080\u0003"+
		"\u0080\u0604\b\u0080\u0005\u0080\u0606\b\u0080\n\u0080\f\u0080\u0609\t"+
		"\u0080\u0001\u0081\u0005\u0081\u060c\b\u0081\n\u0081\f\u0081\u060f\t\u0081"+
		"\u0001\u0081\u0001\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0082\u0003\u0082\u061a\b\u0082\u0001\u0082"+
		"\u0001\u0082\u0003\u0082\u061e\b\u0082\u0003\u0082\u0620\b\u0082\u0005"+
		"\u0082\u0622\b\u0082\n\u0082\f\u0082\u0625\t\u0082\u0001\u0083\u0001\u0083"+
		"\u0003\u0083\u0629\b\u0083\u0001\u0083\u0003\u0083\u062c\b\u0083\u0001"+
		"\u0084\u0001\u0084\u0001\u0084\u0005\u0084\u0631\b\u0084\n\u0084\f\u0084"+
		"\u0634\t\u0084\u0001\u0085\u0003\u0085\u0637\b\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0085\u0003\u0085\u063c\b\u0085\u0003\u0085\u063e\b\u0085"+
		"\u0001\u0085\u0001\u0085\u0003\u0085\u0642\b\u0085\u0001\u0086\u0003\u0086"+
		"\u0645\b\u0086\u0001\u0086\u0003\u0086\u0648\b\u0086\u0001\u0086\u0001"+
		"\u0086\u0003\u0086\u064c\b\u0086\u0001\u0086\u0001\u0086\u0001\u0087\u0003"+
		"\u0087\u0651\b\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001"+
		"\u0087\u0003\u0087\u0658\b\u0087\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0003\u0088\u065f\b\u0088\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0003\u0089\u0664\b\u0089\u0001\u008a\u0001\u008a\u0003\u008a\u0668"+
		"\b\u008a\u0001\u008b\u0001\u008b\u0003\u008b\u066c\b\u008b\u0001\u008b"+
		"\u0001\u008b\u0001\u008b\u0003\u008b\u0671\b\u008b\u0005\u008b\u0673\b"+
		"\u008b\n\u008b\f\u008b\u0676\t\u008b\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0003\u008c\u067b\b\u008c\u0003\u008c\u067d\b\u008c\u0001\u008c\u0001"+
		"\u008c\u0001\u008d\u0001\u008d\u0003\u008d\u0683\b\u008d\u0001\u008e\u0001"+
		"\u008e\u0001\u008e\u0003\u008e\u0688\b\u008e\u0001\u008e\u0001\u008e\u0001"+
		"\u008f\u0001\u008f\u0003\u008f\u068e\b\u008f\u0001\u008f\u0001\u008f\u0003"+
		"\u008f\u0692\b\u008f\u0003\u008f\u0694\b\u008f\u0001\u008f\u0003\u008f"+
		"\u0697\b\u008f\u0001\u008f\u0001\u008f\u0003\u008f\u069b\b\u008f\u0001"+
		"\u008f\u0001\u008f\u0003\u008f\u069f\b\u008f\u0003\u008f\u06a1\b\u008f"+
		"\u0003\u008f\u06a3\b\u008f\u0001\u0090\u0003\u0090\u06a6\b\u0090\u0001"+
		"\u0090\u0001\u0090\u0001\u0091\u0001\u0091\u0001\u0092\u0001\u0092\u0001"+
		"\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0004\u0093\u06b2\b\u0093\u000b"+
		"\u0093\f\u0093\u06b3\u0001\u0094\u0003\u0094\u06b7\b\u0094\u0001\u0094"+
		"\u0003\u0094\u06ba\b\u0094\u0001\u0094\u0003\u0094\u06bd\b\u0094\u0001"+
		"\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001"+
		"\u0094\u0003\u0094\u06c6\b\u0094\u0001\u0095\u0001\u0095\u0001\u0095\u0005"+
		"\u0095\u06cb\b\u0095\n\u0095\f\u0095\u06ce\t\u0095\u0001\u0096\u0001\u0096"+
		"\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096"+
		"\u0001\u0096\u0003\u0096\u06d9\b\u0096\u0001\u0096\u0001\u0096\u0003\u0096"+
		"\u06dd\b\u0096\u0001\u0096\u0003\u0096\u06e0\b\u0096\u0001\u0096\u0001"+
		"\u0096\u0003\u0096\u06e4\b\u0096\u0001\u0097\u0004\u0097\u06e7\b\u0097"+
		"\u000b\u0097\f\u0097\u06e8\u0001\u0098\u0001\u0098\u0001\u0099\u0001\u0099"+
		"\u0001\u0099\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009b\u0001\u009b"+
		"\u0003\u009b\u06f5\b\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0003\u009b"+
		"\u06fa\b\u009b\u0005\u009b\u06fc\b\u009b\n\u009b\f\u009b\u06ff\t\u009b"+
		"\u0001\u009c\u0003\u009c\u0702\b\u009c\u0001\u009c\u0001\u009c\u0001\u009c"+
		"\u0003\u009c\u0707\b\u009c\u0001\u009c\u0001\u009c\u0001\u009c\u0003\u009c"+
		"\u070c\b\u009c\u0001\u009c\u0001\u009c\u0003\u009c\u0710\b\u009c\u0001"+
		"\u009d\u0003\u009d\u0713\b\u009d\u0001\u009d\u0001\u009d\u0003\u009d\u0717"+
		"\b\u009d\u0001\u009e\u0001\u009e\u0001\u009f\u0001\u009f\u0001\u00a0\u0001"+
		"\u00a0\u0001\u00a0\u0001\u00a1\u0001\u00a1\u0003\u00a1\u0722\b\u00a1\u0001"+
		"\u00a2\u0001\u00a2\u0003\u00a2\u0726\b\u00a2\u0001\u00a3\u0001\u00a3\u0001"+
		"\u00a3\u0001\u00a4\u0001\u00a4\u0003\u00a4\u072d\b\u00a4\u0001\u00a4\u0001"+
		"\u00a4\u0001\u00a4\u0003\u00a4\u0732\b\u00a4\u0005\u00a4\u0734\b\u00a4"+
		"\n\u00a4\f\u00a4\u0737\t\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0003"+
		"\u00a5\u073c\b\u00a5\u0001\u00a5\u0001\u00a5\u0003\u00a5\u0740\b\u00a5"+
		"\u0001\u00a6\u0001\u00a6\u0003\u00a6\u0744\b\u00a6\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0003\u00a8"+
		"\u074d\b\u00a8\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0001\u00a9\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0005\u00aa\u0758\b\u00aa"+
		"\n\u00aa\f\u00aa\u075b\t\u00aa\u0001\u00ab\u0001\u00ab\u0003\u00ab\u075f"+
		"\b\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0003"+
		"\u00ac\u0766\b\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac\u076a\b\u00ac"+
		"\u0001\u00ac\u0003\u00ac\u076d\b\u00ac\u0001\u00ac\u0003\u00ac\u0770\b"+
		"\u00ac\u0001\u00ac\u0003\u00ac\u0773\b\u00ac\u0001\u00ac\u0001\u00ac\u0003"+
		"\u00ac\u0777\b\u00ac\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0003\u00ad\u077c"+
		"\b\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0003"+
		"\u00ae\u0783\b\u00ae\u0001\u00ae\u0001\u00ae\u0003\u00ae\u0787\b\u00ae"+
		"\u0001\u00ae\u0001\u00ae\u0003\u00ae\u078b\b\u00ae\u0001\u00af\u0001\u00af"+
		"\u0001\u00b0\u0001\u00b0\u0003\u00b0\u0791\b\u00b0\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0003\u00b0\u0796\b\u00b0\u0005\u00b0\u0798\b\u00b0\n\u00b0"+
		"\f\u00b0\u079b\t\u00b0\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0003\u00b1"+
		"\u07a0\b\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0003\u00b2"+
		"\u07a6\b\u00b2\u0001\u00b2\u0003\u00b2\u07a9\b\u00b2\u0001\u00b3\u0003"+
		"\u00b3\u07ac\b\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b5\u0001\u00b5\u0001"+
		"\u00b5\u0001\u00b5\u0001\u00b6\u0001\u00b6\u0003\u00b6\u07bc\b\u00b6\u0001"+
		"\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b7\u0004\u00b7\u07c2\b\u00b7\u000b"+
		"\u00b7\f\u00b7\u07c3\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0001\u00b9\u0003\u00b9\u07cd\b\u00b9\u0001\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u07d2\b\u00b9\u0001\u00b9\u0003\u00b9\u07d5"+
		"\b\u00b9\u0001\u00ba\u0001\u00ba\u0003\u00ba\u07d9\b\u00ba\u0001\u00bb"+
		"\u0001\u00bb\u0003\u00bb\u07dd\b\u00bb\u0001\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0003\u00bc\u07e2\b\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bd\u0001\u00bd"+
		"\u0003\u00bd\u07e8\b\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0003\u00bd"+
		"\u07ed\b\u00bd\u0005\u00bd\u07ef\b\u00bd\n\u00bd\f\u00bd\u07f2\t\u00bd"+
		"\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be"+
		"\u0003\u00be\u07fa\b\u00be\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0003\u00bf"+
		"\u07ff\b\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0003\u00bf\u0804\b"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0003"+
		"\u00bf\u082f\b\u00bf\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u0429\u0006"+
		"\u000e\"6\u00ea\u0100\u0104\u00c1\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4"+
		"\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec"+
		"\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104"+
		"\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c"+
		"\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134"+
		"\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c"+
		"\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164"+
		"\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c"+
		"\u017e\u0180\u0000\u0018\u0002\u0000\u0001\u0001\u0090\u0090\u0002\u0000"+
		"eeii\u0004\u0000\u001c\u001c##>>EE\u0002\u0000\u0080\u0080\u0085\u0085"+
		"\u0001\u0000|}\u0002\u0000_aeh\u0002\u0000\u007f\u007f\u0086\u0086\u0001"+
		"\u0000ac\u0001\u0000_`\u0002\u0000jkxy\u0001\u0000vw\u0002\u0000iilu\u0005"+
		"\u0000((33==CCJJ\u0003\u0000&&00TT\u0002\u000022@@\u0002\u0000AARR\u0002"+
		"\u0000\u0019\u0019FF\u0001\u0000Y^\u0002\u0000eezz\u0002\u0000\u001a\u001a"+
		"VV\u0001\u0000\u001f \u0002\u0000**99\u0001\u0000:<\u0001\u0000\u0002"+
		"\b\u0918\u0000\u0187\u0001\u0000\u0000\u0000\u0002\u018c\u0001\u0000\u0000"+
		"\u0000\u0004\u0193\u0001\u0000\u0000\u0000\u0006\u01a1\u0001\u0000\u0000"+
		"\u0000\b\u01a5\u0001\u0000\u0000\u0000\n\u01b1\u0001\u0000\u0000\u0000"+
		"\f\u01b3\u0001\u0000\u0000\u0000\u000e\u01b9\u0001\u0000\u0000\u0000\u0010"+
		"\u01cf\u0001\u0000\u0000\u0000\u0012\u01d5\u0001\u0000\u0000\u0000\u0014"+
		"\u01e1\u0001\u0000\u0000\u0000\u0016\u01e3\u0001\u0000\u0000\u0000\u0018"+
		"\u01e5\u0001\u0000\u0000\u0000\u001a\u01f2\u0001\u0000\u0000\u0000\u001c"+
		"\u01f9\u0001\u0000\u0000\u0000\u001e\u01fc\u0001\u0000\u0000\u0000 \u0201"+
		"\u0001\u0000\u0000\u0000\"\u0230\u0001\u0000\u0000\u0000$\u0250\u0001"+
		"\u0000\u0000\u0000&\u0252\u0001\u0000\u0000\u0000(\u0267\u0001\u0000\u0000"+
		"\u0000*\u0284\u0001\u0000\u0000\u0000,\u0286\u0001\u0000\u0000\u0000."+
		"\u0289\u0001\u0000\u0000\u00000\u0299\u0001\u0000\u0000\u00002\u029d\u0001"+
		"\u0000\u0000\u00004\u02a6\u0001\u0000\u0000\u00006\u02a8\u0001\u0000\u0000"+
		"\u00008\u02c1\u0001\u0000\u0000\u0000:\u02c4\u0001\u0000\u0000\u0000<"+
		"\u02cd\u0001\u0000\u0000\u0000>\u02d8\u0001\u0000\u0000\u0000@\u02da\u0001"+
		"\u0000\u0000\u0000B\u02e2\u0001\u0000\u0000\u0000D\u02ea\u0001\u0000\u0000"+
		"\u0000F\u02f2\u0001\u0000\u0000\u0000H\u02ff\u0001\u0000\u0000\u0000J"+
		"\u0301\u0001\u0000\u0000\u0000L\u0309\u0001\u0000\u0000\u0000N\u0311\u0001"+
		"\u0000\u0000\u0000P\u0319\u0001\u0000\u0000\u0000R\u0321\u0001\u0000\u0000"+
		"\u0000T\u0329\u0001\u0000\u0000\u0000V\u0331\u0001\u0000\u0000\u0000X"+
		"\u0339\u0001\u0000\u0000\u0000Z\u0347\u0001\u0000\u0000\u0000\\\u0349"+
		"\u0001\u0000\u0000\u0000^\u034b\u0001\u0000\u0000\u0000`\u0353\u0001\u0000"+
		"\u0000\u0000b\u0362\u0001\u0000\u0000\u0000d\u0365\u0001\u0000\u0000\u0000"+
		"f\u0371\u0001\u0000\u0000\u0000h\u0375\u0001\u0000\u0000\u0000j\u037c"+
		"\u0001\u0000\u0000\u0000l\u038f\u0001\u0000\u0000\u0000n\u039c\u0001\u0000"+
		"\u0000\u0000p\u03bf\u0001\u0000\u0000\u0000r\u03c3\u0001\u0000\u0000\u0000"+
		"t\u03c6\u0001\u0000\u0000\u0000v\u03cd\u0001\u0000\u0000\u0000x\u03d8"+
		"\u0001\u0000\u0000\u0000z\u03dc\u0001\u0000\u0000\u0000|\u03df\u0001\u0000"+
		"\u0000\u0000~\u03ec\u0001\u0000\u0000\u0000\u0080\u03f6\u0001\u0000\u0000"+
		"\u0000\u0082\u03f8\u0001\u0000\u0000\u0000\u0084\u040f\u0001\u0000\u0000"+
		"\u0000\u0086\u0411\u0001\u0000\u0000\u0000\u0088\u0419\u0001\u0000\u0000"+
		"\u0000\u008a\u041b\u0001\u0000\u0000\u0000\u008c\u0424\u0001\u0000\u0000"+
		"\u0000\u008e\u0427\u0001\u0000\u0000\u0000\u0090\u042e\u0001\u0000\u0000"+
		"\u0000\u0092\u0430\u0001\u0000\u0000\u0000\u0094\u0432\u0001\u0000\u0000"+
		"\u0000\u0096\u0437\u0001\u0000\u0000\u0000\u0098\u043d\u0001\u0000\u0000"+
		"\u0000\u009a\u0440\u0001\u0000\u0000\u0000\u009c\u0448\u0001\u0000\u0000"+
		"\u0000\u009e\u044f\u0001\u0000\u0000\u0000\u00a0\u0451\u0001\u0000\u0000"+
		"\u0000\u00a2\u046b\u0001\u0000\u0000\u0000\u00a4\u0471\u0001\u0000\u0000"+
		"\u0000\u00a6\u0473\u0001\u0000\u0000\u0000\u00a8\u0491\u0001\u0000\u0000"+
		"\u0000\u00aa\u0493\u0001\u0000\u0000\u0000\u00ac\u0495\u0001\u0000\u0000"+
		"\u0000\u00ae\u049f\u0001\u0000\u0000\u0000\u00b0\u04ac\u0001\u0000\u0000"+
		"\u0000\u00b2\u04b6\u0001\u0000\u0000\u0000\u00b4\u04ba\u0001\u0000\u0000"+
		"\u0000\u00b6\u04bd\u0001\u0000\u0000\u0000\u00b8\u04c5\u0001\u0000\u0000"+
		"\u0000\u00ba\u04ca\u0001\u0000\u0000\u0000\u00bc\u04ce\u0001\u0000\u0000"+
		"\u0000\u00be\u04d0\u0001\u0000\u0000\u0000\u00c0\u04d3\u0001\u0000\u0000"+
		"\u0000\u00c2\u04e0\u0001\u0000\u0000\u0000\u00c4\u04e2\u0001\u0000\u0000"+
		"\u0000\u00c6\u04e9\u0001\u0000\u0000\u0000\u00c8\u04ed\u0001\u0000\u0000"+
		"\u0000\u00ca\u04f9\u0001\u0000\u0000\u0000\u00cc\u0503\u0001\u0000\u0000"+
		"\u0000\u00ce\u0509\u0001\u0000\u0000\u0000\u00d0\u0514\u0001\u0000\u0000"+
		"\u0000\u00d2\u0520\u0001\u0000\u0000\u0000\u00d4\u0522\u0001\u0000\u0000"+
		"\u0000\u00d6\u052d\u0001\u0000\u0000\u0000\u00d8\u053b\u0001\u0000\u0000"+
		"\u0000\u00da\u0541\u0001\u0000\u0000\u0000\u00dc\u0543\u0001\u0000\u0000"+
		"\u0000\u00de\u054a\u0001\u0000\u0000\u0000\u00e0\u055f\u0001\u0000\u0000"+
		"\u0000\u00e2\u0561\u0001\u0000\u0000\u0000\u00e4\u0569\u0001\u0000\u0000"+
		"\u0000\u00e6\u0572\u0001\u0000\u0000\u0000\u00e8\u057a\u0001\u0000\u0000"+
		"\u0000\u00ea\u0588\u0001\u0000\u0000\u0000\u00ec\u059b\u0001\u0000\u0000"+
		"\u0000\u00ee\u05ac\u0001\u0000\u0000\u0000\u00f0\u05bf\u0001\u0000\u0000"+
		"\u0000\u00f2\u05c2\u0001\u0000\u0000\u0000\u00f4\u05c6\u0001\u0000\u0000"+
		"\u0000\u00f6\u05c8\u0001\u0000\u0000\u0000\u00f8\u05cb\u0001\u0000\u0000"+
		"\u0000\u00fa\u05cf\u0001\u0000\u0000\u0000\u00fc\u05db\u0001\u0000\u0000"+
		"\u0000\u00fe\u05e6\u0001\u0000\u0000\u0000\u0100\u05f6\u0001\u0000\u0000"+
		"\u0000\u0102\u060d\u0001\u0000\u0000\u0000\u0104\u0612\u0001\u0000\u0000"+
		"\u0000\u0106\u0626\u0001\u0000\u0000\u0000\u0108\u062d\u0001\u0000\u0000"+
		"\u0000\u010a\u0636\u0001\u0000\u0000\u0000\u010c\u0644\u0001\u0000\u0000"+
		"\u0000\u010e\u0657\u0001\u0000\u0000\u0000\u0110\u065e\u0001\u0000\u0000"+
		"\u0000\u0112\u0663\u0001\u0000\u0000\u0000\u0114\u0667\u0001\u0000\u0000"+
		"\u0000\u0116\u0669\u0001\u0000\u0000\u0000\u0118\u0677\u0001\u0000\u0000"+
		"\u0000\u011a\u0682\u0001\u0000\u0000\u0000\u011c\u0684\u0001\u0000\u0000"+
		"\u0000\u011e\u06a2\u0001\u0000\u0000\u0000\u0120\u06a5\u0001\u0000\u0000"+
		"\u0000\u0122\u06a9\u0001\u0000\u0000\u0000\u0124\u06ab\u0001\u0000\u0000"+
		"\u0000\u0126\u06b1\u0001\u0000\u0000\u0000\u0128\u06c5\u0001\u0000\u0000"+
		"\u0000\u012a\u06c7\u0001\u0000\u0000\u0000\u012c\u06e3\u0001\u0000\u0000"+
		"\u0000\u012e\u06e6\u0001\u0000\u0000\u0000\u0130\u06ea\u0001\u0000\u0000"+
		"\u0000\u0132\u06ec\u0001\u0000\u0000\u0000\u0134\u06ef\u0001\u0000\u0000"+
		"\u0000\u0136\u06f2\u0001\u0000\u0000\u0000\u0138\u0701\u0001\u0000\u0000"+
		"\u0000\u013a\u0716\u0001\u0000\u0000\u0000\u013c\u0718\u0001\u0000\u0000"+
		"\u0000\u013e\u071a\u0001\u0000\u0000\u0000\u0140\u071c\u0001\u0000\u0000"+
		"\u0000\u0142\u071f\u0001\u0000\u0000\u0000\u0144\u0723\u0001\u0000\u0000"+
		"\u0000\u0146\u0727\u0001\u0000\u0000\u0000\u0148\u072a\u0001\u0000\u0000"+
		"\u0000\u014a\u0738\u0001\u0000\u0000\u0000\u014c\u0743\u0001\u0000\u0000"+
		"\u0000\u014e\u0745\u0001\u0000\u0000\u0000\u0150\u0748\u0001\u0000\u0000"+
		"\u0000\u0152\u074e\u0001\u0000\u0000\u0000\u0154\u0754\u0001\u0000\u0000"+
		"\u0000\u0156\u075e\u0001\u0000\u0000\u0000\u0158\u0769\u0001\u0000\u0000"+
		"\u0000\u015a\u0778\u0001\u0000\u0000\u0000\u015c\u078a\u0001\u0000\u0000"+
		"\u0000\u015e\u078c\u0001\u0000\u0000\u0000\u0160\u078e\u0001\u0000\u0000"+
		"\u0000\u0162\u079f\u0001\u0000\u0000\u0000\u0164\u07a1\u0001\u0000\u0000"+
		"\u0000\u0166\u07ab\u0001\u0000\u0000\u0000\u0168\u07b0\u0001\u0000\u0000"+
		"\u0000\u016a\u07b5\u0001\u0000\u0000\u0000\u016c\u07b9\u0001\u0000\u0000"+
		"\u0000\u016e\u07c1\u0001\u0000\u0000\u0000\u0170\u07c5\u0001\u0000\u0000"+
		"\u0000\u0172\u07d4\u0001\u0000\u0000\u0000\u0174\u07d6\u0001\u0000\u0000"+
		"\u0000\u0176\u07dc\u0001\u0000\u0000\u0000\u0178\u07de\u0001\u0000\u0000"+
		"\u0000\u017a\u07e5\u0001\u0000\u0000\u0000\u017c\u07f9\u0001\u0000\u0000"+
		"\u0000\u017e\u082e\u0001\u0000\u0000\u0000\u0180\u0830\u0001\u0000\u0000"+
		"\u0000\u0182\u0186\u0003\u0002\u0001\u0000\u0183\u0186\u0003\u0004\u0002"+
		"\u0000\u0184\u0186\u0003|>\u0000\u0185\u0182\u0001\u0000\u0000\u0000\u0185"+
		"\u0183\u0001\u0000\u0000\u0000\u0185\u0184\u0001\u0000\u0000\u0000\u0186"+
		"\u0189\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0187"+
		"\u0188\u0001\u0000\u0000\u0000\u0188\u018a\u0001\u0000\u0000\u0000\u0189"+
		"\u0187\u0001\u0000\u0000\u0000\u018a\u018b\u0005\u0000\u0000\u0001\u018b"+
		"\u0001\u0001\u0000\u0000\u0000\u018c\u018d\u0005\n\u0000\u0000\u018d\u0003"+
		"\u0001\u0000\u0000\u0000\u018e\u018f\u0005\u000b\u0000\u0000\u018f\u0194"+
		"\u0007\u0000\u0000\u0000\u0190\u0191\u0005\f\u0000\u0000\u0191\u0194\u0003"+
		"^/\u0000\u0192\u0194\u0005\r\u0000\u0000\u0193\u018e\u0001\u0000\u0000"+
		"\u0000\u0193\u0190\u0001\u0000\u0000\u0000\u0193\u0192\u0001\u0000\u0000"+
		"\u0000\u0194\u0005\u0001\u0000\u0000\u0000\u0195\u0197\u0003\u0180\u00c0"+
		"\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000"+
		"\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000"+
		"\u0000\u0199\u01a2\u0001\u0000\u0000\u0000\u019a\u01a2\u0005I\u0000\u0000"+
		"\u019b\u019c\u0005Y\u0000\u0000\u019c\u019d\u0003^/\u0000\u019d\u019e"+
		"\u0005Z\u0000\u0000\u019e\u01a2\u0001\u0000\u0000\u0000\u019f\u01a2\u0003"+
		"\b\u0004\u0000\u01a0\u01a2\u0003\u0010\b\u0000\u01a1\u0196\u0001\u0000"+
		"\u0000\u0000\u01a1\u019a\u0001\u0000\u0000\u0000\u01a1\u019b\u0001\u0000"+
		"\u0000\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1\u01a0\u0001\u0000"+
		"\u0000\u0000\u01a2\u0007\u0001\u0000\u0000\u0000\u01a3\u01a6\u0003\n\u0005"+
		"\u0000\u01a4\u01a6\u0003\f\u0006\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000"+
		"\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6\t\u0001\u0000\u0000\u0000\u01a7"+
		"\u01b2\u0005\u0088\u0000\u0000\u01a8\u01b2\u0003\u014e\u00a7\u0000\u01a9"+
		"\u01b2\u0003\u0140\u00a0\u0000\u01aa\u01b2\u0003\u0150\u00a8\u0000\u01ab"+
		"\u01ae\u0005g\u0000\u0000\u01ac\u01af\u0003\u011a\u008d\u0000\u01ad\u01af"+
		"\u0003\u00a6S\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae\u01ad\u0001"+
		"\u0000\u0000\u0000\u01af\u01b2\u0001\u0000\u0000\u0000\u01b0\u01b2\u0003"+
		"\u015c\u00ae\u0000\u01b1\u01a7\u0001\u0000\u0000\u0000\u01b1\u01a8\u0001"+
		"\u0000\u0000\u0000\u01b1\u01a9\u0001\u0000\u0000\u0000\u01b1\u01aa\u0001"+
		"\u0000\u0000\u0000\u01b1\u01ab\u0001\u0000\u0000\u0000\u01b1\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b2\u000b\u0001\u0000\u0000\u0000\u01b3\u01b5\u0003"+
		"\u000e\u0007\u0000\u01b4\u01b6\u0005H\u0000\u0000\u01b5\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b8\u0003\n\u0005\u0000\u01b8\r\u0001\u0000\u0000"+
		"\u0000\u01b9\u01bd\u0006\u0007\uffff\uffff\u0000\u01ba\u01be\u0003\u00a4"+
		"R\u0000\u01bb\u01be\u0003\u00bc^\u0000\u01bc\u01be\u0003\u00a6S\u0000"+
		"\u01bd\u01ba\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000"+
		"\u01bd\u01bc\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000"+
		"\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005\u0083\u0000\u0000"+
		"\u01c0\u01cc\u0001\u0000\u0000\u0000\u01c1\u01c7\n\u0001\u0000\u0000\u01c2"+
		"\u01c8\u0005\u0088\u0000\u0000\u01c3\u01c5\u0005H\u0000\u0000\u01c4\u01c3"+
		"\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5\u01c6"+
		"\u0001\u0000\u0000\u0000\u01c6\u01c8\u0003\u015a\u00ad\u0000\u01c7\u01c2"+
		"\u0001\u0000\u0000\u0000\u01c7\u01c4\u0001\u0000\u0000\u0000\u01c8\u01c9"+
		"\u0001\u0000\u0000\u0000\u01c9\u01cb\u0005\u0083\u0000\u0000\u01ca\u01c1"+
		"\u0001\u0000\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000\u0000\u01cd\u000f"+
		"\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01cf\u01d1"+
		"\u0003\u0012\t\u0000\u01d0\u01d2\u0003 \u0010\u0000\u01d1\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0003h4\u0000\u01d4\u0011\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d7\u0005[\u0000\u0000\u01d6\u01d8\u0003\u0014\n\u0000"+
		"\u01d7\u01d6\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000"+
		"\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u01da\u0005\\\u0000\u0000\u01da"+
		"\u0013\u0001\u0000\u0000\u0000\u01db\u01e2\u0003\u0018\f\u0000\u01dc\u01df"+
		"\u0003\u0016\u000b\u0000\u01dd\u01de\u0005~\u0000\u0000\u01de\u01e0\u0003"+
		"\u0018\f\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e2\u0001\u0000\u0000\u0000\u01e1\u01db\u0001\u0000"+
		"\u0000\u0000\u01e1\u01dc\u0001\u0000\u0000\u0000\u01e2\u0015\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e4\u0007\u0001\u0000\u0000\u01e4\u0017\u0001\u0000"+
		"\u0000\u0000\u01e5\u01ea\u0003\u001a\r\u0000\u01e6\u01e7\u0005~\u0000"+
		"\u0000\u01e7\u01e9\u0003\u001a\r\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e9\u01ec\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000"+
		"\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ee\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ed\u01ef\u0005\u0087\u0000\u0000"+
		"\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000"+
		"\u01ef\u0019\u0001\u0000\u0000\u0000\u01f0\u01f3\u0003\u001c\u000e\u0000"+
		"\u01f1\u01f3\u0003\u001e\u000f\u0000\u01f2\u01f0\u0001\u0000\u0000\u0000"+
		"\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f3\u001b\u0001\u0000\u0000\u0000"+
		"\u01f4\u01f6\u0005e\u0000\u0000\u01f5\u01f4\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f6\u0001\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7"+
		"\u01fa\u0005\u0088\u0000\u0000\u01f8\u01fa\u0005I\u0000\u0000\u01f9\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000\u01fa\u001d"+
		"\u0001\u0000\u0000\u0000\u01fb\u01fd\u0005e\u0000\u0000\u01fc\u01fb\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001"+
		"\u0000\u0000\u0000\u01fe\u01ff\u0005\u0088\u0000\u0000\u01ff\u0200\u0003"+
		"\u0110\u0088\u0000\u0200\u001f\u0001\u0000\u0000\u0000\u0201\u0203\u0005"+
		"Y\u0000\u0000\u0202\u0204\u0003\u0106\u0083\u0000\u0203\u0202\u0001\u0000"+
		"\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0205\u0001\u0000"+
		"\u0000\u0000\u0205\u0207\u0005Z\u0000\u0000\u0206\u0208\u00053\u0000\u0000"+
		"\u0207\u0206\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000"+
		"\u0208\u020a\u0001\u0000\u0000\u0000\u0209\u020b\u0003\u0176\u00bb\u0000"+
		"\u020a\u0209\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000\u0000\u0000"+
		"\u020b\u020d\u0001\u0000\u0000\u0000\u020c\u020e\u0003\u00d0h\u0000\u020d"+
		"\u020c\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e"+
		"\u0210\u0001\u0000\u0000\u0000\u020f\u0211\u0003\u00eew\u0000\u0210\u020f"+
		"\u0001\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000\u0211!\u0001"+
		"\u0000\u0000\u0000\u0212\u0213\u0006\u0011\uffff\uffff\u0000\u0213\u0231"+
		"\u0003\u0006\u0003\u0000\u0214\u0217\u0003\u00a2Q\u0000\u0215\u0217\u0003"+
		"\u0164\u00b2\u0000\u0216\u0214\u0001\u0000\u0000\u0000\u0216\u0215\u0001"+
		"\u0000\u0000\u0000\u0217\u021e\u0001\u0000\u0000\u0000\u0218\u021a\u0005"+
		"Y\u0000\u0000\u0219\u021b\u0003&\u0013\u0000\u021a\u0219\u0001\u0000\u0000"+
		"\u0000\u021a\u021b\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000"+
		"\u0000\u021c\u021f\u0005Z\u0000\u0000\u021d\u021f\u0003\u0118\u008c\u0000"+
		"\u021e\u0218\u0001\u0000\u0000\u0000\u021e\u021d\u0001\u0000\u0000\u0000"+
		"\u021f\u0231\u0001\u0000\u0000\u0000\u0220\u0221\u0007\u0002\u0000\u0000"+
		"\u0221\u0222\u0005j\u0000\u0000\u0222\u0223\u0003\u00fa}\u0000\u0223\u0224"+
		"\u0005k\u0000\u0000\u0224\u0225\u0005Y\u0000\u0000\u0225\u0226\u0003^"+
		"/\u0000\u0226\u0227\u0005Z\u0000\u0000\u0227\u0231\u0001\u0000\u0000\u0000"+
		"\u0228\u0229\u0003$\u0012\u0000\u0229\u022c\u0005Y\u0000\u0000\u022a\u022d"+
		"\u0003^/\u0000\u022b\u022d\u0003\u00fa}\u0000\u022c\u022a\u0001\u0000"+
		"\u0000\u0000\u022c\u022b\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000"+
		"\u0000\u0000\u022e\u022f\u0005Z\u0000\u0000\u022f\u0231\u0001\u0000\u0000"+
		"\u0000\u0230\u0212\u0001\u0000\u0000\u0000\u0230\u0216\u0001\u0000\u0000"+
		"\u0000\u0230\u0220\u0001\u0000\u0000\u0000\u0230\u0228\u0001\u0000\u0000"+
		"\u0000\u0231\u024d\u0001\u0000\u0000\u0000\u0232\u0233\n\u0007\u0000\u0000"+
		"\u0233\u0236\u0005[\u0000\u0000\u0234\u0237\u0003^/\u0000\u0235\u0237"+
		"\u0003\u0118\u008c\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0236\u0235"+
		"\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u0239"+
		"\u0005\\\u0000\u0000\u0239\u024c\u0001\u0000\u0000\u0000\u023a\u023b\n"+
		"\u0006\u0000\u0000\u023b\u023d\u0005Y\u0000\u0000\u023c\u023e\u0003&\u0013"+
		"\u0000\u023d\u023c\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000"+
		"\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u024c\u0005Z\u0000\u0000"+
		"\u0240\u0241\n\u0004\u0000\u0000\u0241\u0247\u0007\u0003\u0000\u0000\u0242"+
		"\u0244\u0005H\u0000\u0000\u0243\u0242\u0001\u0000\u0000\u0000\u0243\u0244"+
		"\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000\u0245\u0248"+
		"\u0003\b\u0004\u0000\u0246\u0248\u0003(\u0014\u0000\u0247\u0243\u0001"+
		"\u0000\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0248\u024c\u0001"+
		"\u0000\u0000\u0000\u0249\u024a\n\u0003\u0000\u0000\u024a\u024c\u0007\u0004"+
		"\u0000\u0000\u024b\u0232\u0001\u0000\u0000\u0000\u024b\u023a\u0001\u0000"+
		"\u0000\u0000\u024b\u0240\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000"+
		"\u0000\u0000\u024c\u024f\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000"+
		"\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e#\u0001\u0000\u0000"+
		"\u0000\u024f\u024d\u0001\u0000\u0000\u0000\u0250\u0251\u0005O\u0000\u0000"+
		"\u0251%\u0001\u0000\u0000\u0000\u0252\u0253\u0003\u0116\u008b\u0000\u0253"+
		"\'\u0001\u0000\u0000\u0000\u0254\u0256\u0003\u000e\u0007\u0000\u0255\u0254"+
		"\u0001\u0000\u0000\u0000\u0255\u0256\u0001\u0000\u0000\u0000\u0256\u025a"+
		"\u0001\u0000\u0000\u0000\u0257\u0258\u0003\u00a4R\u0000\u0258\u0259\u0005"+
		"\u0083\u0000\u0000\u0259\u025b\u0001\u0000\u0000\u0000\u025a\u0257\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u025c\u0001"+
		"\u0000\u0000\u0000\u025c\u025d\u0005g\u0000\u0000\u025d\u0268\u0003\u00a4"+
		"R\u0000\u025e\u025f\u0003\u000e\u0007\u0000\u025f\u0260\u0005H\u0000\u0000"+
		"\u0260\u0261\u0003\u015a\u00ad\u0000\u0261\u0262\u0005\u0083\u0000\u0000"+
		"\u0262\u0263\u0005g\u0000\u0000\u0263\u0264\u0003\u00a4R\u0000\u0264\u0268"+
		"\u0001\u0000\u0000\u0000\u0265\u0266\u0005g\u0000\u0000\u0266\u0268\u0003"+
		"\u00a6S\u0000\u0267\u0255\u0001\u0000\u0000\u0000\u0267\u025e\u0001\u0000"+
		"\u0000\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0268)\u0001\u0000\u0000"+
		"\u0000\u0269\u0285\u0003\"\u0011\u0000\u026a\u026f\u0005|\u0000\u0000"+
		"\u026b\u026f\u0005}\u0000\u0000\u026c\u026f\u0003,\u0016\u0000\u026d\u026f"+
		"\u0005B\u0000\u0000\u026e\u026a\u0001\u0000\u0000\u0000\u026e\u026b\u0001"+
		"\u0000\u0000\u0000\u026e\u026c\u0001\u0000\u0000\u0000\u026e\u026d\u0001"+
		"\u0000\u0000\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270\u0285\u0003"+
		"*\u0015\u0000\u0271\u027a\u0005B\u0000\u0000\u0272\u0273\u0005Y\u0000"+
		"\u0000\u0273\u0274\u0003\u00fa}\u0000\u0274\u0275\u0005Z\u0000\u0000\u0275"+
		"\u027b\u0001\u0000\u0000\u0000\u0276\u0277\u0005\u0087\u0000\u0000\u0277"+
		"\u0278\u0005Y\u0000\u0000\u0278\u0279\u0005\u0088\u0000\u0000\u0279\u027b"+
		"\u0005Z\u0000\u0000\u027a\u0272\u0001\u0000\u0000\u0000\u027a\u0276\u0001"+
		"\u0000\u0000\u0000\u027b\u0285\u0001\u0000\u0000\u0000\u027c\u027d\u0005"+
		"\u000f\u0000\u0000\u027d\u027e\u0005Y\u0000\u0000\u027e\u027f\u0003\u00fa"+
		"}\u0000\u027f\u0280\u0005Z\u0000\u0000\u0280\u0285\u0001\u0000\u0000\u0000"+
		"\u0281\u0285\u0003<\u001e\u0000\u0282\u0285\u0003.\u0017\u0000\u0283\u0285"+
		"\u0003:\u001d\u0000\u0284\u0269\u0001\u0000\u0000\u0000\u0284\u026e\u0001"+
		"\u0000\u0000\u0000\u0284\u0271\u0001\u0000\u0000\u0000\u0284\u027c\u0001"+
		"\u0000\u0000\u0000\u0284\u0281\u0001\u0000\u0000\u0000\u0284\u0282\u0001"+
		"\u0000\u0000\u0000\u0284\u0283\u0001\u0000\u0000\u0000\u0285+\u0001\u0000"+
		"\u0000\u0000\u0286\u0287\u0007\u0005\u0000\u0000\u0287-\u0001\u0000\u0000"+
		"\u0000\u0288\u028a\u0005\u0083\u0000\u0000\u0289\u0288\u0001\u0000\u0000"+
		"\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a\u028b\u0001\u0000\u0000"+
		"\u0000\u028b\u028d\u00055\u0000\u0000\u028c\u028e\u00030\u0018\u0000\u028d"+
		"\u028c\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028e"+
		"\u0294\u0001\u0000\u0000\u0000\u028f\u0295\u00032\u0019\u0000\u0290\u0291"+
		"\u0005Y\u0000\u0000\u0291\u0292\u0003\u00fa}\u0000\u0292\u0293\u0005Z"+
		"\u0000\u0000\u0293\u0295\u0001\u0000\u0000\u0000\u0294\u028f\u0001\u0000"+
		"\u0000\u0000\u0294\u0290\u0001\u0000\u0000\u0000\u0295\u0297\u0001\u0000"+
		"\u0000\u0000\u0296\u0298\u00038\u001c\u0000\u0297\u0296\u0001\u0000\u0000"+
		"\u0000\u0297\u0298\u0001\u0000\u0000\u0000\u0298/\u0001\u0000\u0000\u0000"+
		"\u0299\u029a\u0005Y\u0000\u0000\u029a\u029b\u0003&\u0013\u0000\u029b\u029c"+
		"\u0005Z\u0000\u0000\u029c1\u0001\u0000\u0000\u0000\u029d\u029f\u0003\u009a"+
		"M\u0000\u029e\u02a0\u00034\u001a\u0000\u029f\u029e\u0001\u0000\u0000\u0000"+
		"\u029f\u02a0\u0001\u0000\u0000\u0000\u02a03\u0001\u0000\u0000\u0000\u02a1"+
		"\u02a3\u0003\u00f0x\u0000\u02a2\u02a4\u00034\u001a\u0000\u02a3\u02a2\u0001"+
		"\u0000\u0000\u0000\u02a3\u02a4\u0001\u0000\u0000\u0000\u02a4\u02a7\u0001"+
		"\u0000\u0000\u0000\u02a5\u02a7\u00036\u001b\u0000\u02a6\u02a1\u0001\u0000"+
		"\u0000\u0000\u02a6\u02a5\u0001\u0000\u0000\u0000\u02a75\u0001\u0000\u0000"+
		"\u0000\u02a8\u02a9\u0006\u001b\uffff\uffff\u0000\u02a9\u02aa\u0005[\u0000"+
		"\u0000\u02aa\u02ab\u0003^/\u0000\u02ab\u02ad\u0005\\\u0000\u0000\u02ac"+
		"\u02ae\u0003\u00d0h\u0000\u02ad\u02ac\u0001\u0000\u0000\u0000\u02ad\u02ae"+
		"\u0001\u0000\u0000\u0000\u02ae\u02b8\u0001\u0000\u0000\u0000\u02af\u02b0"+
		"\n\u0001\u0000\u0000\u02b0\u02b1\u0005[\u0000\u0000\u02b1\u02b2\u0003"+
		"`0\u0000\u02b2\u02b4\u0005\\\u0000\u0000\u02b3\u02b5\u0003\u00d0h\u0000"+
		"\u02b4\u02b3\u0001\u0000\u0000\u0000\u02b4\u02b5\u0001\u0000\u0000\u0000"+
		"\u02b5\u02b7\u0001\u0000\u0000\u0000\u02b6\u02af\u0001\u0000\u0000\u0000"+
		"\u02b7\u02ba\u0001\u0000\u0000\u0000\u02b8\u02b6\u0001\u0000\u0000\u0000"+
		"\u02b8\u02b9\u0001\u0000\u0000\u0000\u02b97\u0001\u0000\u0000\u0000\u02ba"+
		"\u02b8\u0001\u0000\u0000\u0000\u02bb\u02bd\u0005Y\u0000\u0000\u02bc\u02be"+
		"\u0003&\u0013\u0000\u02bd\u02bc\u0001\u0000\u0000\u0000\u02bd\u02be\u0001"+
		"\u0000\u0000\u0000\u02be\u02bf\u0001\u0000\u0000\u0000\u02bf\u02c2\u0005"+
		"Z\u0000\u0000\u02c0\u02c2\u0003\u0118\u008c\u0000\u02c1\u02bb\u0001\u0000"+
		"\u0000\u0000\u02c1\u02c0\u0001\u0000\u0000\u0000\u02c29\u0001\u0000\u0000"+
		"\u0000\u02c3\u02c5\u0005\u0083\u0000\u0000\u02c4\u02c3\u0001\u0000\u0000"+
		"\u0000\u02c4\u02c5\u0001\u0000\u0000\u0000\u02c5\u02c6\u0001\u0000\u0000"+
		"\u0000\u02c6\u02c9\u0005 \u0000\u0000\u02c7\u02c8\u0005[\u0000\u0000\u02c8"+
		"\u02ca\u0005\\\u0000\u0000\u02c9\u02c7\u0001\u0000\u0000\u0000\u02c9\u02ca"+
		"\u0001\u0000\u0000\u0000\u02ca\u02cb\u0001\u0000\u0000\u0000\u02cb\u02cc"+
		"\u0003>\u001f\u0000\u02cc;\u0001\u0000\u0000\u0000\u02cd\u02ce\u00056"+
		"\u0000\u0000\u02ce\u02cf\u0005Y\u0000\u0000\u02cf\u02d0\u0003^/\u0000"+
		"\u02d0\u02d1\u0005Z\u0000\u0000\u02d1=\u0001\u0000\u0000\u0000\u02d2\u02d9"+
		"\u0003*\u0015\u0000\u02d3\u02d4\u0005Y\u0000\u0000\u02d4\u02d5\u0003\u00fa"+
		"}\u0000\u02d5\u02d6\u0005Z\u0000\u0000\u02d6\u02d7\u0003>\u001f\u0000"+
		"\u02d7\u02d9\u0001\u0000\u0000\u0000\u02d8\u02d2\u0001\u0000\u0000\u0000"+
		"\u02d8\u02d3\u0001\u0000\u0000\u0000\u02d9?\u0001\u0000\u0000\u0000\u02da"+
		"\u02df\u0003>\u001f\u0000\u02db\u02dc\u0007\u0006\u0000\u0000\u02dc\u02de"+
		"\u0003>\u001f\u0000\u02dd\u02db\u0001\u0000\u0000\u0000\u02de\u02e1\u0001"+
		"\u0000\u0000\u0000\u02df\u02dd\u0001\u0000\u0000\u0000\u02df\u02e0\u0001"+
		"\u0000\u0000\u0000\u02e0A\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000"+
		"\u0000\u0000\u02e2\u02e7\u0003@ \u0000\u02e3\u02e4\u0007\u0007\u0000\u0000"+
		"\u02e4\u02e6\u0003@ \u0000\u02e5\u02e3\u0001\u0000\u0000\u0000\u02e6\u02e9"+
		"\u0001\u0000\u0000\u0000\u02e7\u02e5\u0001\u0000\u0000\u0000\u02e7\u02e8"+
		"\u0001\u0000\u0000\u0000\u02e8C\u0001\u0000\u0000\u0000\u02e9\u02e7\u0001"+
		"\u0000\u0000\u0000\u02ea\u02ef\u0003B!\u0000\u02eb\u02ec\u0007\b\u0000"+
		"\u0000\u02ec\u02ee\u0003B!\u0000\u02ed\u02eb\u0001\u0000\u0000\u0000\u02ee"+
		"\u02f1\u0001\u0000\u0000\u0000\u02ef\u02ed\u0001\u0000\u0000\u0000\u02ef"+
		"\u02f0\u0001\u0000\u0000\u0000\u02f0E\u0001\u0000\u0000\u0000\u02f1\u02ef"+
		"\u0001\u0000\u0000\u0000\u02f2\u02f8\u0003D\"\u0000\u02f3\u02f4\u0003"+
		"H$\u0000\u02f4\u02f5\u0003D\"\u0000\u02f5\u02f7\u0001\u0000\u0000\u0000"+
		"\u02f6\u02f3\u0001\u0000\u0000\u0000\u02f7\u02fa\u0001\u0000\u0000\u0000"+
		"\u02f8\u02f6\u0001\u0000\u0000\u0000\u02f8\u02f9\u0001\u0000\u0000\u0000"+
		"\u02f9G\u0001\u0000\u0000\u0000\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fb"+
		"\u02fc\u0005k\u0000\u0000\u02fc\u0300\u0005k\u0000\u0000\u02fd\u02fe\u0005"+
		"j\u0000\u0000\u02fe\u0300\u0005j\u0000\u0000\u02ff\u02fb\u0001\u0000\u0000"+
		"\u0000\u02ff\u02fd\u0001\u0000\u0000\u0000\u0300I\u0001\u0000\u0000\u0000"+
		"\u0301\u0306\u0003F#\u0000\u0302\u0303\u0007\t\u0000\u0000\u0303\u0305"+
		"\u0003F#\u0000\u0304\u0302\u0001\u0000\u0000\u0000\u0305\u0308\u0001\u0000"+
		"\u0000\u0000\u0306\u0304\u0001\u0000\u0000\u0000\u0306\u0307\u0001\u0000"+
		"\u0000\u0000\u0307K\u0001\u0000\u0000\u0000\u0308\u0306\u0001\u0000\u0000"+
		"\u0000\u0309\u030e\u0003J%\u0000\u030a\u030b\u0007\n\u0000\u0000\u030b"+
		"\u030d\u0003J%\u0000\u030c\u030a\u0001\u0000\u0000\u0000\u030d\u0310\u0001"+
		"\u0000\u0000\u0000\u030e\u030c\u0001\u0000\u0000\u0000\u030e\u030f\u0001"+
		"\u0000\u0000\u0000\u030fM\u0001\u0000\u0000\u0000\u0310\u030e\u0001\u0000"+
		"\u0000\u0000\u0311\u0316\u0003L&\u0000\u0312\u0313\u0005e\u0000\u0000"+
		"\u0313\u0315\u0003L&\u0000\u0314\u0312\u0001\u0000\u0000\u0000\u0315\u0318"+
		"\u0001\u0000\u0000\u0000\u0316\u0314\u0001\u0000\u0000\u0000\u0316\u0317"+
		"\u0001\u0000\u0000\u0000\u0317O\u0001\u0000\u0000\u0000\u0318\u0316\u0001"+
		"\u0000\u0000\u0000\u0319\u031e\u0003N\'\u0000\u031a\u031b\u0005d\u0000"+
		"\u0000\u031b\u031d\u0003N\'\u0000\u031c\u031a\u0001\u0000\u0000\u0000"+
		"\u031d\u0320\u0001\u0000\u0000\u0000\u031e\u031c\u0001\u0000\u0000\u0000"+
		"\u031e\u031f\u0001\u0000\u0000\u0000\u031fQ\u0001\u0000\u0000\u0000\u0320"+
		"\u031e\u0001\u0000\u0000\u0000\u0321\u0326\u0003P(\u0000\u0322\u0323\u0005"+
		"f\u0000\u0000\u0323\u0325\u0003P(\u0000\u0324\u0322\u0001\u0000\u0000"+
		"\u0000\u0325\u0328\u0001\u0000\u0000\u0000\u0326\u0324\u0001\u0000\u0000"+
		"\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327S\u0001\u0000\u0000\u0000"+
		"\u0328\u0326\u0001\u0000\u0000\u0000\u0329\u032e\u0003R)\u0000\u032a\u032b"+
		"\u0005z\u0000\u0000\u032b\u032d\u0003R)\u0000\u032c\u032a\u0001\u0000"+
		"\u0000\u0000\u032d\u0330\u0001\u0000\u0000\u0000\u032e\u032c\u0001\u0000"+
		"\u0000\u0000\u032e\u032f\u0001\u0000\u0000\u0000\u032fU\u0001\u0000\u0000"+
		"\u0000\u0330\u032e\u0001\u0000\u0000\u0000\u0331\u0336\u0003T*\u0000\u0332"+
		"\u0333\u0005{\u0000\u0000\u0333\u0335\u0003T*\u0000\u0334\u0332\u0001"+
		"\u0000\u0000\u0000\u0335\u0338\u0001\u0000\u0000\u0000\u0336\u0334\u0001"+
		"\u0000\u0000\u0000\u0336\u0337\u0001\u0000\u0000\u0000\u0337W\u0001\u0000"+
		"\u0000\u0000\u0338\u0336\u0001\u0000\u0000\u0000\u0339\u033f\u0003V+\u0000"+
		"\u033a\u033b\u0005\u0081\u0000\u0000\u033b\u033c\u0003^/\u0000\u033c\u033d"+
		"\u0005\u0082\u0000\u0000\u033d\u033e\u0003Z-\u0000\u033e\u0340\u0001\u0000"+
		"\u0000\u0000\u033f\u033a\u0001\u0000\u0000\u0000\u033f\u0340\u0001\u0000"+
		"\u0000\u0000\u0340Y\u0001\u0000\u0000\u0000\u0341\u0348\u0003X,\u0000"+
		"\u0342\u0343\u0003V+\u0000\u0343\u0344\u0003\\.\u0000\u0344\u0345\u0003"+
		"\u0114\u008a\u0000\u0345\u0348\u0001\u0000\u0000\u0000\u0346\u0348\u0003"+
		"\u0174\u00ba\u0000\u0347\u0341\u0001\u0000\u0000\u0000\u0347\u0342\u0001"+
		"\u0000\u0000\u0000\u0347\u0346\u0001\u0000\u0000\u0000\u0348[\u0001\u0000"+
		"\u0000\u0000\u0349\u034a\u0007\u000b\u0000\u0000\u034a]\u0001\u0000\u0000"+
		"\u0000\u034b\u0350\u0003Z-\u0000\u034c\u034d\u0005~\u0000\u0000\u034d"+
		"\u034f\u0003Z-\u0000\u034e\u034c\u0001\u0000\u0000\u0000\u034f\u0352\u0001"+
		"\u0000\u0000\u0000\u0350\u034e\u0001\u0000\u0000\u0000\u0350\u0351\u0001"+
		"\u0000\u0000\u0000\u0351_\u0001\u0000\u0000\u0000\u0352\u0350\u0001\u0000"+
		"\u0000\u0000\u0353\u0354\u0003X,\u0000\u0354a\u0001\u0000\u0000\u0000"+
		"\u0355\u0363\u0003d2\u0000\u0356\u0363\u0003z=\u0000\u0357\u0359\u0003"+
		"\u00d0h\u0000\u0358\u0357\u0001\u0000\u0000\u0000\u0358\u0359\u0001\u0000"+
		"\u0000\u0000\u0359\u0360\u0001\u0000\u0000\u0000\u035a\u0361\u0003f3\u0000"+
		"\u035b\u0361\u0003h4\u0000\u035c\u0361\u0003l6\u0000\u035d\u0361\u0003"+
		"p8\u0000\u035e\u0361\u0003x<\u0000\u035f\u0361\u0003\u016a\u00b5\u0000"+
		"\u0360\u035a\u0001\u0000\u0000\u0000\u0360\u035b\u0001\u0000\u0000\u0000"+
		"\u0360\u035c\u0001\u0000\u0000\u0000\u0360\u035d\u0001\u0000\u0000\u0000"+
		"\u0360\u035e\u0001\u0000\u0000\u0000\u0360\u035f\u0001\u0000\u0000\u0000"+
		"\u0361\u0363\u0001\u0000\u0000\u0000\u0362\u0355\u0001\u0000\u0000\u0000"+
		"\u0362\u0356\u0001\u0000\u0000\u0000\u0362\u0358\u0001\u0000\u0000\u0000"+
		"\u0363c\u0001\u0000\u0000\u0000\u0364\u0366\u0003\u00d0h\u0000\u0365\u0364"+
		"\u0001\u0000\u0000\u0000\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u036b"+
		"\u0001\u0000\u0000\u0000\u0367\u036c\u0005\u0088\u0000\u0000\u0368\u0369"+
		"\u0005\u0014\u0000\u0000\u0369\u036c\u0003`0\u0000\u036a\u036c\u0005\u001f"+
		"\u0000\u0000\u036b\u0367\u0001\u0000\u0000\u0000\u036b\u0368\u0001\u0000"+
		"\u0000\u0000\u036b\u036a\u0001\u0000\u0000\u0000\u036c\u036d\u0001\u0000"+
		"\u0000\u0000\u036d\u036e\u0005\u0082\u0000\u0000\u036e\u036f\u0003b1\u0000"+
		"\u036fe\u0001\u0000\u0000\u0000\u0370\u0372\u0003^/\u0000\u0371\u0370"+
		"\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372\u0373"+
		"\u0001\u0000\u0000\u0000\u0373\u0374\u0005\u0084\u0000\u0000\u0374g\u0001"+
		"\u0000\u0000\u0000\u0375\u0377\u0005]\u0000\u0000\u0376\u0378\u0003j5"+
		"\u0000\u0377\u0376\u0001\u0000\u0000\u0000\u0377\u0378\u0001\u0000\u0000"+
		"\u0000\u0378\u0379\u0001\u0000\u0000\u0000\u0379\u037a\u0005^\u0000\u0000"+
		"\u037ai\u0001\u0000\u0000\u0000\u037b\u037d\u0003b1\u0000\u037c\u037b"+
		"\u0001\u0000\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000\u037e\u037c"+
		"\u0001\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037fk\u0001"+
		"\u0000\u0000\u0000\u0380\u0381\u0005/\u0000\u0000\u0381\u0382\u0005Y\u0000"+
		"\u0000\u0382\u0383\u0003n7\u0000\u0383\u0384\u0005Z\u0000\u0000\u0384"+
		"\u0387\u0003b1\u0000\u0385\u0386\u0005$\u0000\u0000\u0386\u0388\u0003"+
		"b1\u0000\u0387\u0385\u0001\u0000\u0000\u0000\u0387\u0388\u0001\u0000\u0000"+
		"\u0000\u0388\u0390\u0001\u0000\u0000\u0000\u0389\u038a\u0005G\u0000\u0000"+
		"\u038a\u038b\u0005Y\u0000\u0000\u038b\u038c\u0003n7\u0000\u038c\u038d"+
		"\u0005Z\u0000\u0000\u038d\u038e\u0003b1\u0000\u038e\u0390\u0001\u0000"+
		"\u0000\u0000\u038f\u0380\u0001\u0000\u0000\u0000\u038f\u0389\u0001\u0000"+
		"\u0000\u0000\u0390m\u0001\u0000\u0000\u0000\u0391\u039d\u0003^/\u0000"+
		"\u0392\u0394\u0003\u00d0h\u0000\u0393\u0392\u0001\u0000\u0000\u0000\u0393"+
		"\u0394\u0001\u0000\u0000\u0000\u0394\u0395\u0001\u0000\u0000\u0000\u0395"+
		"\u0396\u0003\u008eG\u0000\u0396\u039a\u0003\u00e6s\u0000\u0397\u0398\u0005"+
		"i\u0000\u0000\u0398\u039b\u0003\u0114\u008a\u0000\u0399\u039b\u0003\u0118"+
		"\u008c\u0000\u039a\u0397\u0001\u0000\u0000\u0000\u039a\u0399\u0001\u0000"+
		"\u0000\u0000\u039b\u039d\u0001\u0000\u0000\u0000\u039c\u0391\u0001\u0000"+
		"\u0000\u0000\u039c\u0393\u0001\u0000\u0000\u0000\u039do\u0001\u0000\u0000"+
		"\u0000\u039e\u039f\u0005X\u0000\u0000\u039f\u03a0\u0005Y\u0000\u0000\u03a0"+
		"\u03a1\u0003n7\u0000\u03a1\u03a2\u0005Z\u0000\u0000\u03a2\u03a3\u0003"+
		"b1\u0000\u03a3\u03c0\u0001\u0000\u0000\u0000\u03a4\u03a5\u0005!\u0000"+
		"\u0000\u03a5\u03a6\u0003b1\u0000\u03a6\u03a7\u0005X\u0000\u0000\u03a7"+
		"\u03a8\u0005Y\u0000\u0000\u03a8\u03a9\u0003^/\u0000\u03a9\u03aa\u0005"+
		"Z\u0000\u0000\u03aa\u03ab\u0005\u0084\u0000\u0000\u03ab\u03c0\u0001\u0000"+
		"\u0000\u0000\u03ac\u03ad\u0005,\u0000\u0000\u03ad\u03ba\u0005Y\u0000\u0000"+
		"\u03ae\u03b0\u0003r9\u0000\u03af\u03b1\u0003n7\u0000\u03b0\u03af\u0001"+
		"\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000\u0000\u0000\u03b1\u03b2\u0001"+
		"\u0000\u0000\u0000\u03b2\u03b4\u0005\u0084\u0000\u0000\u03b3\u03b5\u0003"+
		"^/\u0000\u03b4\u03b3\u0001\u0000\u0000\u0000\u03b4\u03b5\u0001\u0000\u0000"+
		"\u0000\u03b5\u03bb\u0001\u0000\u0000\u0000\u03b6\u03b7\u0003t:\u0000\u03b7"+
		"\u03b8\u0005\u0082\u0000\u0000\u03b8\u03b9\u0003v;\u0000\u03b9\u03bb\u0001"+
		"\u0000\u0000\u0000\u03ba\u03ae\u0001\u0000\u0000\u0000\u03ba\u03b6\u0001"+
		"\u0000\u0000\u0000\u03bb\u03bc\u0001\u0000\u0000\u0000\u03bc\u03bd\u0005"+
		"Z\u0000\u0000\u03bd\u03be\u0003b1\u0000\u03be\u03c0\u0001\u0000\u0000"+
		"\u0000\u03bf\u039e\u0001\u0000\u0000\u0000\u03bf\u03a4\u0001\u0000\u0000"+
		"\u0000\u03bf\u03ac\u0001\u0000\u0000\u0000\u03c0q\u0001\u0000\u0000\u0000"+
		"\u03c1\u03c4\u0003f3\u0000\u03c2\u03c4\u0003\u0084B\u0000\u03c3\u03c1"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c2\u0001\u0000\u0000\u0000\u03c4s\u0001"+
		"\u0000\u0000\u0000\u03c5\u03c7\u0003\u00d0h\u0000\u03c6\u03c5\u0001\u0000"+
		"\u0000\u0000\u03c6\u03c7\u0001\u0000\u0000\u0000\u03c7\u03c8\u0001\u0000"+
		"\u0000\u0000\u03c8\u03c9\u0003\u008eG\u0000\u03c9\u03ca\u0003\u00e6s\u0000"+
		"\u03cau\u0001\u0000\u0000\u0000\u03cb\u03ce\u0003^/\u0000\u03cc\u03ce"+
		"\u0003\u0118\u008c\u0000\u03cd\u03cb\u0001\u0000\u0000\u0000\u03cd\u03cc"+
		"\u0001\u0000\u0000\u0000\u03cew\u0001\u0000\u0000\u0000\u03cf\u03d9\u0005"+
		"\u0013\u0000\u0000\u03d0\u03d9\u0005\u001d\u0000\u0000\u03d1\u03d4\u0005"+
		"?\u0000\u0000\u03d2\u03d5\u0003^/\u0000\u03d3\u03d5\u0003\u0118\u008c"+
		"\u0000\u03d4\u03d2\u0001\u0000\u0000\u0000\u03d4\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d4\u03d5\u0001\u0000\u0000\u0000\u03d5\u03d9\u0001\u0000\u0000"+
		"\u0000\u03d6\u03d7\u0005.\u0000\u0000\u03d7\u03d9\u0005\u0088\u0000\u0000"+
		"\u03d8\u03cf\u0001\u0000\u0000\u0000\u03d8\u03d0\u0001\u0000\u0000\u0000"+
		"\u03d8\u03d1\u0001\u0000\u0000\u0000\u03d8\u03d6\u0001\u0000\u0000\u0000"+
		"\u03d9\u03da\u0001\u0000\u0000\u0000\u03da\u03db\u0005\u0084\u0000\u0000"+
		"\u03dby\u0001\u0000\u0000\u0000\u03dc\u03dd\u0003\u0080@\u0000\u03dd{"+
		"\u0001\u0000\u0000\u0000\u03de\u03e0\u0003~?\u0000\u03df\u03de\u0001\u0000"+
		"\u0000\u0000\u03e0\u03e1\u0001\u0000\u0000\u0000\u03e1\u03df\u0001\u0000"+
		"\u0000\u0000\u03e1\u03e2\u0001\u0000\u0000\u0000\u03e2}\u0001\u0000\u0000"+
		"\u0000\u03e3\u03ed\u0003\u0080@\u0000\u03e4\u03ed\u0003\u010c\u0086\u0000"+
		"\u03e5\u03ed\u0003\u0152\u00a9\u0000\u03e6\u03ed\u0003\u0166\u00b3\u0000"+
		"\u03e7\u03ed\u0003\u0168\u00b4\u0000\u03e8\u03ed\u0003\u00ceg\u0000\u03e9"+
		"\u03ed\u0003\u00c0`\u0000\u03ea\u03ed\u0003\u0088D\u0000\u03eb\u03ed\u0003"+
		"\u008aE\u0000\u03ec\u03e3\u0001\u0000\u0000\u0000\u03ec\u03e4\u0001\u0000"+
		"\u0000\u0000\u03ec\u03e5\u0001\u0000\u0000\u0000\u03ec\u03e6\u0001\u0000"+
		"\u0000\u0000\u03ec\u03e7\u0001\u0000\u0000\u0000\u03ec\u03e8\u0001\u0000"+
		"\u0000\u0000\u03ec\u03e9\u0001\u0000\u0000\u0000\u03ec\u03ea\u0001\u0000"+
		"\u0000\u0000\u03ec\u03eb\u0001\u0000\u0000\u0000\u03ed\u007f\u0001\u0000"+
		"\u0000\u0000\u03ee\u03f7\u0003\u0084B\u0000\u03ef\u03f7\u0003\u00ccf\u0000"+
		"\u03f0\u03f7\u0003\u00c4b\u0000\u03f1\u03f7\u0003\u00c8d\u0000\u03f2\u03f7"+
		"\u0003\u00cae\u0000\u03f3\u03f7\u0003\u0086C\u0000\u03f4\u03f7\u0003\u0082"+
		"A\u0000\u03f5\u03f7\u0003\u00b0X\u0000\u03f6\u03ee\u0001\u0000\u0000\u0000"+
		"\u03f6\u03ef\u0001\u0000\u0000\u0000\u03f6\u03f0\u0001\u0000\u0000\u0000"+
		"\u03f6\u03f1\u0001\u0000\u0000\u0000\u03f6\u03f2\u0001\u0000\u0000\u0000"+
		"\u03f6\u03f3\u0001\u0000\u0000\u0000\u03f6\u03f4\u0001\u0000\u0000\u0000"+
		"\u03f6\u03f5\u0001\u0000\u0000\u0000\u03f7\u0081\u0001\u0000\u0000\u0000"+
		"\u03f8\u03f9\u0005S\u0000\u0000\u03f9\u03fb\u0005\u0088\u0000\u0000\u03fa"+
		"\u03fc\u0003\u00d0h\u0000\u03fb\u03fa\u0001\u0000\u0000\u0000\u03fb\u03fc"+
		"\u0001\u0000\u0000\u0000\u03fc\u03fd\u0001\u0000\u0000\u0000\u03fd\u03fe"+
		"\u0005i\u0000\u0000\u03fe\u03ff\u0003\u00fa}\u0000\u03ff\u0400\u0005\u0084"+
		"\u0000\u0000\u0400\u0083\u0001\u0000\u0000\u0000\u0401\u0403\u0003\u008e"+
		"G\u0000\u0402\u0401\u0001\u0000\u0000\u0000\u0402\u0403\u0001\u0000\u0000"+
		"\u0000\u0403\u0405\u0001\u0000\u0000\u0000\u0404\u0406\u0003\u00e2q\u0000"+
		"\u0405\u0404\u0001\u0000\u0000\u0000\u0405\u0406\u0001\u0000\u0000\u0000"+
		"\u0406\u0407\u0001\u0000\u0000\u0000\u0407\u0410\u0005\u0084\u0000\u0000"+
		"\u0408\u040a\u0003\u00d0h\u0000\u0409\u040b\u0003\u008eG\u0000\u040a\u0409"+
		"\u0001\u0000\u0000\u0000\u040a\u040b\u0001\u0000\u0000\u0000\u040b\u040c"+
		"\u0001\u0000\u0000\u0000\u040c\u040d\u0003\u00e2q\u0000\u040d\u040e\u0005"+
		"\u0084\u0000\u0000\u040e\u0410\u0001\u0000\u0000\u0000\u040f\u0402\u0001"+
		"\u0000\u0000\u0000\u040f\u0408\u0001\u0000\u0000\u0000\u0410\u0085\u0001"+
		"\u0000\u0000\u0000\u0411\u0412\u0005D\u0000\u0000\u0412\u0413\u0005Y\u0000"+
		"\u0000\u0413\u0414\u0003`0\u0000\u0414\u0415\u0005~\u0000\u0000\u0415"+
		"\u0416\u0005\u0005\u0000\u0000\u0416\u0417\u0005Z\u0000\u0000\u0417\u0418"+
		"\u0005\u0084\u0000\u0000\u0418\u0087\u0001\u0000\u0000\u0000\u0419\u041a"+
		"\u0005\u0084\u0000\u0000\u041a\u0089\u0001\u0000\u0000\u0000\u041b\u041c"+
		"\u0003\u00d0h\u0000\u041c\u041d\u0005\u0084\u0000\u0000\u041d\u008b\u0001"+
		"\u0000\u0000\u0000\u041e\u0425\u0003\u0090H\u0000\u041f\u0425\u0003\u0096"+
		"K\u0000\u0420\u0425\u0003\u0092I\u0000\u0421\u0425\u0005-\u0000\u0000"+
		"\u0422\u0425\u0005N\u0000\u0000\u0423\u0425\u0005\u001b\u0000\u0000\u0424"+
		"\u041e\u0001\u0000\u0000\u0000\u0424\u041f\u0001\u0000\u0000\u0000\u0424"+
		"\u0420\u0001\u0000\u0000\u0000\u0424\u0421\u0001\u0000\u0000\u0000\u0424"+
		"\u0422\u0001\u0000\u0000\u0000\u0424\u0423\u0001\u0000\u0000\u0000\u0425"+
		"\u008d\u0001\u0000\u0000\u0000\u0426\u0428\u0003\u008cF\u0000\u0427\u0426"+
		"\u0001\u0000\u0000\u0000\u0428\u0429\u0001\u0000\u0000\u0000\u0429\u042a"+
		"\u0001\u0000\u0000\u0000\u0429\u0427\u0001\u0000\u0000\u0000\u042a\u042c"+
		"\u0001\u0000\u0000\u0000\u042b\u042d\u0003\u00d0h\u0000\u042c\u042b\u0001"+
		"\u0000\u0000\u0000\u042c\u042d\u0001\u0000\u0000\u0000\u042d\u008f\u0001"+
		"\u0000\u0000\u0000\u042e\u042f\u0007\f\u0000\u0000\u042f\u0091\u0001\u0000"+
		"\u0000\u0000\u0430\u0431\u0007\r\u0000\u0000\u0431\u0093\u0001\u0000\u0000"+
		"\u0000\u0432\u0433\u0005\u0088\u0000\u0000\u0433\u0095\u0001\u0000\u0000"+
		"\u0000\u0434\u0438\u0003\u0098L\u0000\u0435\u0438\u0003\u011c\u008e\u0000"+
		"\u0436\u0438\u0003\u00acV\u0000\u0437\u0434\u0001\u0000\u0000\u0000\u0437"+
		"\u0435\u0001\u0000\u0000\u0000\u0437\u0436\u0001\u0000\u0000\u0000\u0438"+
		"\u0097\u0001\u0000\u0000\u0000\u0439\u043e\u0003\u00a2Q\u0000\u043a\u043e"+
		"\u0003\u00a8T\u0000\u043b\u043e\u0003\u0164\u00b2\u0000\u043c\u043e\u0003"+
		"\u00f4z\u0000\u043d\u0439\u0001\u0000\u0000\u0000\u043d\u043a\u0001\u0000"+
		"\u0000\u0000\u043d\u043b\u0001\u0000\u0000\u0000\u043d\u043c\u0001\u0000"+
		"\u0000\u0000\u043e\u0099\u0001\u0000\u0000\u0000\u043f\u0441\u0003\u0096"+
		"K\u0000\u0440\u043f\u0001\u0000\u0000\u0000\u0441\u0442\u0001\u0000\u0000"+
		"\u0000\u0442\u0440\u0001\u0000\u0000\u0000\u0442\u0443\u0001\u0000\u0000"+
		"\u0000\u0443\u0445\u0001\u0000\u0000\u0000\u0444\u0446\u0003\u00d0h\u0000"+
		"\u0445\u0444\u0001\u0000\u0000\u0000\u0445\u0446\u0001\u0000\u0000\u0000"+
		"\u0446\u009b\u0001\u0000\u0000\u0000\u0447\u0449\u0003\u0098L\u0000\u0448"+
		"\u0447\u0001\u0000\u0000\u0000\u0449\u044a\u0001\u0000\u0000\u0000\u044a"+
		"\u0448\u0001\u0000\u0000\u0000\u044a\u044b\u0001\u0000\u0000\u0000\u044b"+
		"\u044d\u0001\u0000\u0000\u0000\u044c\u044e\u0003\u00d0h\u0000\u044d\u044c"+
		"\u0001\u0000\u0000\u0000\u044d\u044e\u0001\u0000\u0000\u0000\u044e\u009d"+
		"\u0001\u0000\u0000\u0000\u044f\u0450\u0007\u000e\u0000\u0000\u0450\u009f"+
		"\u0001\u0000\u0000\u0000\u0451\u0452\u0007\u000f\u0000\u0000\u0452\u00a1"+
		"\u0001\u0000\u0000\u0000\u0453\u0455\u0003\u000e\u0007\u0000\u0454\u0453"+
		"\u0001\u0000\u0000\u0000\u0454\u0455\u0001\u0000\u0000\u0000\u0455\u0456"+
		"\u0001\u0000\u0000\u0000\u0456\u046c\u0003\u00a4R\u0000\u0457\u0458\u0003"+
		"\u000e\u0007\u0000\u0458\u0459\u0005H\u0000\u0000\u0459\u045a\u0003\u015a"+
		"\u00ad\u0000\u045a\u046c\u0001\u0000\u0000\u0000\u045b\u046c\u0005\u0016"+
		"\u0000\u0000\u045c\u046c\u0005\u0017\u0000\u0000\u045d\u046c\u0005\u0018"+
		"\u0000\u0000\u045e\u046c\u0005W\u0000\u0000\u045f\u046c\u0005\u0012\u0000"+
		"\u0000\u0460\u046c\u0005@\u0000\u0000\u0461\u046c\u00051\u0000\u0000\u0462"+
		"\u046c\u00052\u0000\u0000\u0463\u046c\u0005+\u0000\u0000\u0464\u046c\u0005"+
		"A\u0000\u0000\u0465\u046c\u0005R\u0000\u0000\u0466\u046c\u0005+\u0000"+
		"\u0000\u0467\u046c\u0005\"\u0000\u0000\u0468\u046c\u0005U\u0000\u0000"+
		"\u0469\u046c\u0005\u0011\u0000\u0000\u046a\u046c\u0003\u00a6S\u0000\u046b"+
		"\u0454\u0001\u0000\u0000\u0000\u046b\u0457\u0001\u0000\u0000\u0000\u046b"+
		"\u045b\u0001\u0000\u0000\u0000\u046b\u045c\u0001\u0000\u0000\u0000\u046b"+
		"\u045d\u0001\u0000\u0000\u0000\u046b\u045e\u0001\u0000\u0000\u0000\u046b"+
		"\u045f\u0001\u0000\u0000\u0000\u046b\u0460\u0001\u0000\u0000\u0000\u046b"+
		"\u0461\u0001\u0000\u0000\u0000\u046b\u0462\u0001\u0000\u0000\u0000\u046b"+
		"\u0463\u0001\u0000\u0000\u0000\u046b\u0464\u0001\u0000\u0000\u0000\u046b"+
		"\u0465\u0001\u0000\u0000\u0000\u046b\u0466\u0001\u0000\u0000\u0000\u046b"+
		"\u0467\u0001\u0000\u0000\u0000\u046b\u0468\u0001\u0000\u0000\u0000\u046b"+
		"\u0469\u0001\u0000\u0000\u0000\u046b\u046a\u0001\u0000\u0000\u0000\u046c"+
		"\u00a3\u0001\u0000\u0000\u0000\u046d\u0472\u0003\u011a\u008d\u0000\u046e"+
		"\u0472\u0003\u00aaU\u0000\u046f\u0472\u0003\u0094J\u0000\u0470\u0472\u0003"+
		"\u015a\u00ad\u0000\u0471\u046d\u0001\u0000\u0000\u0000\u0471\u046e\u0001"+
		"\u0000\u0000\u0000\u0471\u046f\u0001\u0000\u0000\u0000\u0471\u0470\u0001"+
		"\u0000\u0000\u0000\u0472\u00a5\u0001\u0000\u0000\u0000\u0473\u0474\u0005"+
		"\u001e\u0000\u0000\u0474\u0477\u0005Y\u0000\u0000\u0475\u0478\u0003^/"+
		"\u0000\u0476\u0478\u0005\u0011\u0000\u0000\u0477\u0475\u0001\u0000\u0000"+
		"\u0000\u0477\u0476\u0001\u0000\u0000\u0000\u0478\u0479\u0001\u0000\u0000"+
		"\u0000\u0479\u047a\u0005Z\u0000\u0000\u047a\u00a7\u0001\u0000\u0000\u0000"+
		"\u047b\u048a\u0003\u0124\u0092\u0000\u047c\u047e\u0003\u00d0h\u0000\u047d"+
		"\u047c\u0001\u0000\u0000\u0000\u047d\u047e\u0001\u0000\u0000\u0000\u047e"+
		"\u0480\u0001\u0000\u0000\u0000\u047f\u0481\u0003\u000e\u0007\u0000\u0480"+
		"\u047f\u0001\u0000\u0000\u0000\u0480\u0481\u0001\u0000\u0000\u0000\u0481"+
		"\u0482\u0001\u0000\u0000\u0000\u0482\u048b\u0005\u0088\u0000\u0000\u0483"+
		"\u048b\u0003\u015a\u00ad\u0000\u0484\u0486\u0003\u000e\u0007\u0000\u0485"+
		"\u0487\u0005H\u0000\u0000\u0486\u0485\u0001\u0000\u0000\u0000\u0486\u0487"+
		"\u0001\u0000\u0000\u0000\u0487\u0488\u0001\u0000\u0000\u0000\u0488\u0489"+
		"\u0003\u015a\u00ad\u0000\u0489\u048b\u0001\u0000\u0000\u0000\u048a\u047d"+
		"\u0001\u0000\u0000\u0000\u048a\u0483\u0001\u0000\u0000\u0000\u048a\u0484"+
		"\u0001\u0000\u0000\u0000\u048b\u0492\u0001\u0000\u0000\u0000\u048c\u048e"+
		"\u0005%\u0000\u0000\u048d\u048f\u0003\u000e\u0007\u0000\u048e\u048d\u0001"+
		"\u0000\u0000\u0000\u048e\u048f\u0001\u0000\u0000\u0000\u048f\u0490\u0001"+
		"\u0000\u0000\u0000\u0490\u0492\u0005\u0088\u0000\u0000\u0491\u047b\u0001"+
		"\u0000\u0000\u0000\u0491\u048c\u0001\u0000\u0000\u0000\u0492\u00a9\u0001"+
		"\u0000\u0000\u0000\u0493\u0494\u0005\u0088\u0000\u0000\u0494\u00ab\u0001"+
		"\u0000\u0000\u0000\u0495\u0496\u0003\u00aeW\u0000\u0496\u049b\u0005]\u0000"+
		"\u0000\u0497\u0499\u0003\u00b6[\u0000\u0498\u049a\u0005~\u0000\u0000\u0499"+
		"\u0498\u0001\u0000\u0000\u0000\u0499\u049a\u0001\u0000\u0000\u0000\u049a"+
		"\u049c\u0001\u0000\u0000\u0000\u049b\u0497\u0001\u0000\u0000\u0000\u049b"+
		"\u049c\u0001\u0000\u0000\u0000\u049c\u049d\u0001\u0000\u0000\u0000\u049d"+
		"\u049e\u0005^\u0000\u0000\u049e\u00ad\u0001\u0000\u0000\u0000\u049f\u04a1"+
		"\u0003\u00b2Y\u0000\u04a0\u04a2\u0003\u00d0h\u0000\u04a1\u04a0\u0001\u0000"+
		"\u0000\u0000\u04a1\u04a2\u0001\u0000\u0000\u0000\u04a2\u04a7\u0001\u0000"+
		"\u0000\u0000\u04a3\u04a5\u0003\u000e\u0007\u0000\u04a4\u04a3\u0001\u0000"+
		"\u0000\u0000\u04a4\u04a5\u0001\u0000\u0000\u0000\u04a5\u04a6\u0001\u0000"+
		"\u0000\u0000\u04a6\u04a8\u0005\u0088\u0000\u0000\u04a7\u04a4\u0001\u0000"+
		"\u0000\u0000\u04a7\u04a8\u0001\u0000\u0000\u0000\u04a8\u04aa\u0001\u0000"+
		"\u0000\u0000\u04a9\u04ab\u0003\u00b4Z\u0000\u04aa\u04a9\u0001\u0000\u0000"+
		"\u0000\u04aa\u04ab\u0001\u0000\u0000\u0000\u04ab\u00af\u0001\u0000\u0000"+
		"\u0000\u04ac\u04ae\u0003\u00b2Y\u0000\u04ad\u04af\u0003\u00d0h\u0000\u04ae"+
		"\u04ad\u0001\u0000\u0000\u0000\u04ae\u04af\u0001\u0000\u0000\u0000\u04af"+
		"\u04b0\u0001\u0000\u0000\u0000\u04b0\u04b2\u0005\u0088\u0000\u0000\u04b1"+
		"\u04b3\u0003\u00b4Z\u0000\u04b2\u04b1\u0001\u0000\u0000\u0000\u04b2\u04b3"+
		"\u0001\u0000\u0000\u0000\u04b3\u04b4\u0001\u0000\u0000\u0000\u04b4\u04b5"+
		"\u0005\u0084\u0000\u0000\u04b5\u00b1\u0001\u0000\u0000\u0000\u04b6\u04b8"+
		"\u0005%\u0000\u0000\u04b7\u04b9\u0007\u0010\u0000\u0000\u04b8\u04b7\u0001"+
		"\u0000\u0000\u0000\u04b8\u04b9\u0001\u0000\u0000\u0000\u04b9\u00b3\u0001"+
		"\u0000\u0000\u0000\u04ba\u04bb\u0005\u0082\u0000\u0000\u04bb\u04bc\u0003"+
		"\u009aM\u0000\u04bc\u00b5\u0001\u0000\u0000\u0000\u04bd\u04c2\u0003\u00b8"+
		"\\\u0000\u04be\u04bf\u0005~\u0000\u0000\u04bf\u04c1\u0003\u00b8\\\u0000"+
		"\u04c0\u04be\u0001\u0000\u0000\u0000\u04c1\u04c4\u0001\u0000\u0000\u0000"+
		"\u04c2\u04c0\u0001\u0000\u0000\u0000\u04c2\u04c3\u0001\u0000\u0000\u0000"+
		"\u04c3\u00b7\u0001\u0000\u0000\u0000\u04c4\u04c2\u0001\u0000\u0000\u0000"+
		"\u04c5\u04c8\u0003\u00ba]\u0000\u04c6\u04c7\u0005i\u0000\u0000\u04c7\u04c9"+
		"\u0003`0\u0000\u04c8\u04c6\u0001\u0000\u0000\u0000\u04c8\u04c9\u0001\u0000"+
		"\u0000\u0000\u04c9\u00b9\u0001\u0000\u0000\u0000\u04ca\u04cb\u0005\u0088"+
		"\u0000\u0000\u04cb\u00bb\u0001\u0000\u0000\u0000\u04cc\u04cf\u0003\u00be"+
		"_\u0000\u04cd\u04cf\u0003\u00c2a\u0000\u04ce\u04cc\u0001\u0000\u0000\u0000"+
		"\u04ce\u04cd\u0001\u0000\u0000\u0000\u04cf\u00bd\u0001\u0000\u0000\u0000"+
		"\u04d0\u04d1\u0005\u0088\u0000\u0000\u04d1\u00bf\u0001\u0000\u0000\u0000"+
		"\u04d2\u04d4\u00050\u0000\u0000\u04d3\u04d2\u0001\u0000\u0000\u0000\u04d3"+
		"\u04d4\u0001\u0000\u0000\u0000\u04d4\u04d5\u0001\u0000\u0000\u0000\u04d5"+
		"\u04d8\u00054\u0000\u0000\u04d6\u04d9\u0005\u0088\u0000\u0000\u04d7\u04d9"+
		"\u0003\u00be_\u0000\u04d8\u04d6\u0001\u0000\u0000\u0000\u04d8\u04d7\u0001"+
		"\u0000\u0000\u0000\u04d8\u04d9\u0001\u0000\u0000\u0000\u04d9\u04da\u0001"+
		"\u0000\u0000\u0000\u04da\u04dc\u0005]\u0000\u0000\u04db\u04dd\u0003|>"+
		"\u0000\u04dc\u04db\u0001\u0000\u0000\u0000\u04dc\u04dd\u0001\u0000\u0000"+
		"\u0000\u04dd\u04de\u0001\u0000\u0000\u0000\u04de\u04df\u0005^\u0000\u0000"+
		"\u04df\u00c1\u0001\u0000\u0000\u0000\u04e0\u04e1\u0005\u0088\u0000\u0000"+
		"\u04e1\u00c3\u0001\u0000\u0000\u0000\u04e2\u04e3\u00054\u0000\u0000\u04e3"+
		"\u04e4\u0005\u0088\u0000\u0000\u04e4\u04e5\u0005i\u0000\u0000\u04e5\u04e6"+
		"\u0003\u00c6c\u0000\u04e6\u04e7\u0005\u0084\u0000\u0000\u04e7\u00c5\u0001"+
		"\u0000\u0000\u0000\u04e8\u04ea\u0003\u000e\u0007\u0000\u04e9\u04e8\u0001"+
		"\u0000\u0000\u0000\u04e9\u04ea\u0001\u0000\u0000\u0000\u04ea\u04eb\u0001"+
		"\u0000\u0000\u0000\u04eb\u04ec\u0003\u00bc^\u0000\u04ec\u00c7\u0001\u0000"+
		"\u0000\u0000\u04ed\u04f3\u0005S\u0000\u0000\u04ee\u04f0\u0005P\u0000\u0000"+
		"\u04ef\u04ee\u0001\u0000\u0000\u0000\u04ef\u04f0\u0001\u0000\u0000\u0000"+
		"\u04f0\u04f1\u0001\u0000\u0000\u0000\u04f1\u04f4\u0003\u000e\u0007\u0000"+
		"\u04f2\u04f4\u0005\u0083\u0000\u0000\u04f3\u04ef\u0001\u0000\u0000\u0000"+
		"\u04f3\u04f2\u0001\u0000\u0000\u0000\u04f4\u04f5\u0001\u0000\u0000\u0000"+
		"\u04f5\u04f6\u0003\n\u0005\u0000\u04f6\u04f7\u0005\u0084\u0000\u0000\u04f7"+
		"\u00c9\u0001\u0000\u0000\u0000\u04f8\u04fa\u0003\u00d0h\u0000\u04f9\u04f8"+
		"\u0001\u0000\u0000\u0000\u04f9\u04fa\u0001\u0000\u0000\u0000\u04fa\u04fb"+
		"\u0001\u0000\u0000\u0000\u04fb\u04fc\u0005S\u0000\u0000\u04fc\u04fe\u0005"+
		"4\u0000\u0000\u04fd\u04ff\u0003\u000e\u0007\u0000\u04fe\u04fd\u0001\u0000"+
		"\u0000\u0000\u04fe\u04ff\u0001\u0000\u0000\u0000\u04ff\u0500\u0001\u0000"+
		"\u0000\u0000\u0500\u0501\u0003\u00bc^\u0000\u0501\u0502\u0005\u0084\u0000"+
		"\u0000\u0502\u00cb\u0001\u0000\u0000\u0000\u0503\u0504\u0005\u0010\u0000"+
		"\u0000\u0504\u0505\u0005Y\u0000\u0000\u0505\u0506\u0005\u0005\u0000\u0000"+
		"\u0506\u0507\u0005Z\u0000\u0000\u0507\u0508\u0005\u0084\u0000\u0000\u0508"+
		"\u00cd\u0001\u0000\u0000\u0000\u0509\u050a\u0005(\u0000\u0000\u050a\u0511"+
		"\u0005\u0005\u0000\u0000\u050b\u050d\u0005]\u0000\u0000\u050c\u050e\u0003"+
		"|>\u0000\u050d\u050c\u0001\u0000\u0000\u0000\u050d\u050e\u0001\u0000\u0000"+
		"\u0000\u050e\u050f\u0001\u0000\u0000\u0000\u050f\u0512\u0005^\u0000\u0000"+
		"\u0510\u0512\u0003~?\u0000\u0511\u050b\u0001\u0000\u0000\u0000\u0511\u0510"+
		"\u0001\u0000\u0000\u0000\u0512\u00cf\u0001\u0000\u0000\u0000\u0513\u0515"+
		"\u0003\u00d2i\u0000\u0514\u0513\u0001\u0000\u0000\u0000\u0515\u0516\u0001"+
		"\u0000\u0000\u0000\u0516\u0514\u0001\u0000\u0000\u0000\u0516\u0517\u0001"+
		"\u0000\u0000\u0000\u0517\u00d1\u0001\u0000\u0000\u0000\u0518\u0519\u0005"+
		"[\u0000\u0000\u0519\u051b\u0005[\u0000\u0000\u051a\u051c\u0003\u00d6k"+
		"\u0000\u051b\u051a\u0001\u0000\u0000\u0000\u051b\u051c\u0001\u0000\u0000"+
		"\u0000\u051c\u051d\u0001\u0000\u0000\u0000\u051d\u051e\u0005\\\u0000\u0000"+
		"\u051e\u0521\u0005\\\u0000\u0000\u051f\u0521\u0003\u00d4j\u0000\u0520"+
		"\u0518\u0001\u0000\u0000\u0000\u0520\u051f\u0001\u0000\u0000\u0000\u0521"+
		"\u00d3\u0001\u0000\u0000\u0000\u0522\u0523\u0005\u000e\u0000\u0000\u0523"+
		"\u0526\u0005Y\u0000\u0000\u0524\u0527\u0003\u00fa}\u0000\u0525\u0527\u0003"+
		"`0\u0000\u0526\u0524\u0001\u0000\u0000\u0000\u0526\u0525\u0001\u0000\u0000"+
		"\u0000\u0527\u0529\u0001\u0000\u0000\u0000\u0528\u052a\u0005\u0087\u0000"+
		"\u0000\u0529\u0528\u0001\u0000\u0000\u0000\u0529\u052a\u0001\u0000\u0000"+
		"\u0000\u052a\u052b\u0001\u0000\u0000\u0000\u052b\u052c\u0005Z\u0000\u0000"+
		"\u052c\u00d5\u0001\u0000\u0000\u0000\u052d\u0532\u0003\u00d8l\u0000\u052e"+
		"\u052f\u0005~\u0000\u0000\u052f\u0531\u0003\u00d8l\u0000\u0530\u052e\u0001"+
		"\u0000\u0000\u0000\u0531\u0534\u0001\u0000\u0000\u0000\u0532\u0530\u0001"+
		"\u0000\u0000\u0000\u0532\u0533\u0001\u0000\u0000\u0000\u0533\u0536\u0001"+
		"\u0000\u0000\u0000\u0534\u0532\u0001\u0000\u0000\u0000\u0535\u0537\u0005"+
		"\u0087\u0000\u0000\u0536\u0535\u0001\u0000\u0000\u0000\u0536\u0537\u0001"+
		"\u0000\u0000\u0000\u0537\u00d7\u0001\u0000\u0000\u0000\u0538\u0539\u0003"+
		"\u00dam\u0000\u0539\u053a\u0005\u0083\u0000\u0000\u053a\u053c\u0001\u0000"+
		"\u0000\u0000\u053b\u0538\u0001\u0000\u0000\u0000\u053b\u053c\u0001\u0000"+
		"\u0000\u0000\u053c\u053d\u0001\u0000\u0000\u0000\u053d\u053f\u0005\u0088"+
		"\u0000\u0000\u053e\u0540\u0003\u00dcn\u0000\u053f\u053e\u0001\u0000\u0000"+
		"\u0000\u053f\u0540\u0001\u0000\u0000\u0000\u0540\u00d9\u0001\u0000\u0000"+
		"\u0000\u0541\u0542\u0005\u0088\u0000\u0000\u0542\u00db\u0001\u0000\u0000"+
		"\u0000\u0543\u0545\u0005Y\u0000\u0000\u0544\u0546\u0003\u00deo\u0000\u0545"+
		"\u0544\u0001\u0000\u0000\u0000\u0545\u0546\u0001\u0000\u0000\u0000\u0546"+
		"\u0547\u0001\u0000\u0000\u0000\u0547\u0548\u0005Z\u0000\u0000\u0548\u00dd"+
		"\u0001\u0000\u0000\u0000\u0549\u054b\u0003\u00e0p\u0000\u054a\u0549\u0001"+
		"\u0000\u0000\u0000\u054b\u054c\u0001\u0000\u0000\u0000\u054c\u054a\u0001"+
		"\u0000\u0000\u0000\u054c\u054d\u0001\u0000\u0000\u0000\u054d\u00df\u0001"+
		"\u0000\u0000\u0000\u054e\u054f\u0005Y\u0000\u0000\u054f\u0550\u0003\u00de"+
		"o\u0000\u0550\u0551\u0005Z\u0000\u0000\u0551\u0560\u0001\u0000\u0000\u0000"+
		"\u0552\u0553\u0005[\u0000\u0000\u0553\u0554\u0003\u00deo\u0000\u0554\u0555"+
		"\u0005\\\u0000\u0000\u0555\u0560\u0001\u0000\u0000\u0000\u0556\u0557\u0005"+
		"]\u0000\u0000\u0557\u0558\u0003\u00deo\u0000\u0558\u0559\u0005^\u0000"+
		"\u0000\u0559\u0560\u0001\u0000\u0000\u0000\u055a\u055c\b\u0011\u0000\u0000"+
		"\u055b\u055a\u0001\u0000\u0000\u0000\u055c\u055d\u0001\u0000\u0000\u0000"+
		"\u055d\u055b\u0001\u0000\u0000\u0000\u055d\u055e\u0001\u0000\u0000\u0000"+
		"\u055e\u0560\u0001\u0000\u0000\u0000\u055f\u054e\u0001\u0000\u0000\u0000"+
		"\u055f\u0552\u0001\u0000\u0000\u0000\u055f\u0556\u0001\u0000\u0000\u0000"+
		"\u055f\u055b\u0001\u0000\u0000\u0000\u0560\u00e1\u0001\u0000\u0000\u0000"+
		"\u0561\u0566\u0003\u00e4r\u0000\u0562\u0563\u0005~\u0000\u0000\u0563\u0565"+
		"\u0003\u00e4r\u0000\u0564\u0562\u0001\u0000\u0000\u0000\u0565\u0568\u0001"+
		"\u0000\u0000\u0000\u0566\u0564\u0001\u0000\u0000\u0000\u0566\u0567\u0001"+
		"\u0000\u0000\u0000\u0567\u00e3\u0001\u0000\u0000\u0000\u0568\u0566\u0001"+
		"\u0000\u0000\u0000\u0569\u056b\u0003\u00e6s\u0000\u056a\u056c\u0003\u0110"+
		"\u0088\u0000\u056b\u056a\u0001\u0000\u0000\u0000\u056b\u056c\u0001\u0000"+
		"\u0000\u0000\u056c\u00e5\u0001\u0000\u0000\u0000\u056d\u0573\u0003\u00e8"+
		"t\u0000\u056e\u056f\u0003\u00eau\u0000\u056f\u0570\u0003\u00ecv\u0000"+
		"\u0570\u0571\u0003\u00eew\u0000\u0571\u0573\u0001\u0000\u0000\u0000\u0572"+
		"\u056d\u0001\u0000\u0000\u0000\u0572\u056e\u0001\u0000\u0000\u0000\u0573"+
		"\u00e7\u0001\u0000\u0000\u0000\u0574\u0576\u0003\u00f0x\u0000\u0575\u0577"+
		"\u0005\u001a\u0000\u0000\u0576\u0575\u0001\u0000\u0000\u0000\u0576\u0577"+
		"\u0001\u0000\u0000\u0000\u0577\u0579\u0001\u0000\u0000\u0000\u0578\u0574"+
		"\u0001\u0000\u0000\u0000\u0579\u057c\u0001\u0000\u0000\u0000\u057a\u0578"+
		"\u0001\u0000\u0000\u0000\u057a\u057b\u0001\u0000\u0000\u0000\u057b\u057d"+
		"\u0001\u0000\u0000\u0000\u057c\u057a\u0001\u0000\u0000\u0000\u057d\u057e"+
		"\u0003\u00eau\u0000\u057e\u00e9\u0001\u0000\u0000\u0000\u057f\u0580\u0006"+
		"u\uffff\uffff\u0000\u0580\u0582\u0003\u00f8|\u0000\u0581\u0583\u0003\u00d0"+
		"h\u0000\u0582\u0581\u0001\u0000\u0000\u0000\u0582\u0583\u0001\u0000\u0000"+
		"\u0000\u0583\u0589\u0001\u0000\u0000\u0000\u0584\u0585\u0005Y\u0000\u0000"+
		"\u0585\u0586\u0003\u00e8t\u0000\u0586\u0587\u0005Z\u0000\u0000\u0587\u0589"+
		"\u0001\u0000\u0000\u0000\u0588\u057f\u0001\u0000\u0000\u0000\u0588\u0584"+
		"\u0001\u0000\u0000\u0000\u0589\u0598\u0001\u0000\u0000\u0000\u058a\u0594"+
		"\n\u0002\u0000\u0000\u058b\u0595\u0003\u00ecv\u0000\u058c\u058e\u0005"+
		"[\u0000\u0000\u058d\u058f\u0003`0\u0000\u058e\u058d\u0001\u0000\u0000"+
		"\u0000\u058e\u058f\u0001\u0000\u0000\u0000\u058f\u0590\u0001\u0000\u0000"+
		"\u0000\u0590\u0592\u0005\\\u0000\u0000\u0591\u0593\u0003\u00d0h\u0000"+
		"\u0592\u0591\u0001\u0000\u0000\u0000\u0592\u0593\u0001\u0000\u0000\u0000"+
		"\u0593\u0595\u0001\u0000\u0000\u0000\u0594\u058b\u0001\u0000\u0000\u0000"+
		"\u0594\u058c\u0001\u0000\u0000\u0000\u0595\u0597\u0001\u0000\u0000\u0000"+
		"\u0596\u058a\u0001\u0000\u0000\u0000\u0597\u059a\u0001\u0000\u0000\u0000"+
		"\u0598\u0596\u0001\u0000\u0000\u0000\u0598\u0599\u0001\u0000\u0000\u0000"+
		"\u0599\u00eb\u0001\u0000\u0000\u0000\u059a\u0598\u0001\u0000\u0000\u0000"+
		"\u059b\u059d\u0005Y\u0000\u0000\u059c\u059e\u0003\u0106\u0083\u0000\u059d"+
		"\u059c\u0001\u0000\u0000\u0000\u059d\u059e\u0001\u0000\u0000\u0000\u059e"+
		"\u059f\u0001\u0000\u0000\u0000\u059f\u05a1\u0005Z\u0000\u0000\u05a0\u05a2"+
		"\u0003\u00f2y\u0000\u05a1\u05a0\u0001\u0000\u0000\u0000\u05a1\u05a2\u0001"+
		"\u0000\u0000\u0000\u05a2\u05a4\u0001\u0000\u0000\u0000\u05a3\u05a5\u0003"+
		"\u00f6{\u0000\u05a4\u05a3\u0001\u0000\u0000\u0000\u05a4\u05a5\u0001\u0000"+
		"\u0000\u0000\u05a5\u05a7\u0001\u0000\u0000\u0000\u05a6\u05a8\u0003\u0176"+
		"\u00bb\u0000\u05a7\u05a6\u0001\u0000\u0000\u0000\u05a7\u05a8\u0001\u0000"+
		"\u0000\u0000\u05a8\u05aa\u0001\u0000\u0000\u0000\u05a9\u05ab\u0003\u00d0"+
		"h\u0000\u05aa\u05a9\u0001\u0000\u0000\u0000\u05aa\u05ab\u0001\u0000\u0000"+
		"\u0000\u05ab\u00ed\u0001\u0000\u0000\u0000\u05ac\u05ad\u0005\u0080\u0000"+
		"\u0000\u05ad\u05af\u0003\u009cN\u0000\u05ae\u05b0\u0003\u00fc~\u0000\u05af"+
		"\u05ae\u0001\u0000\u0000\u0000\u05af\u05b0\u0001\u0000\u0000\u0000\u05b0"+
		"\u00ef\u0001\u0000\u0000\u0000\u05b1\u05b3\u0007\u0012\u0000\u0000\u05b2"+
		"\u05b4\u0003\u00d0h\u0000\u05b3\u05b2\u0001\u0000\u0000\u0000\u05b3\u05b4"+
		"\u0001\u0000\u0000\u0000\u05b4\u05c0\u0001\u0000\u0000\u0000\u05b5\u05b7"+
		"\u0003\u000e\u0007\u0000\u05b6\u05b5\u0001\u0000\u0000\u0000\u05b6\u05b7"+
		"\u0001\u0000\u0000\u0000\u05b7\u05b8\u0001\u0000\u0000\u0000\u05b8\u05ba"+
		"\u0005a\u0000\u0000\u05b9\u05bb\u0003\u00d0h\u0000\u05ba\u05b9\u0001\u0000"+
		"\u0000\u0000\u05ba\u05bb\u0001\u0000\u0000\u0000\u05bb\u05bd\u0001\u0000"+
		"\u0000\u0000\u05bc\u05be\u0003\u00f2y\u0000\u05bd\u05bc\u0001\u0000\u0000"+
		"\u0000\u05bd\u05be\u0001\u0000\u0000\u0000\u05be\u05c0\u0001\u0000\u0000"+
		"\u0000\u05bf\u05b1\u0001\u0000\u0000\u0000\u05bf\u05b6\u0001\u0000\u0000"+
		"\u0000\u05c0\u00f1\u0001\u0000\u0000\u0000\u05c1\u05c3\u0003\u00f4z\u0000"+
		"\u05c2\u05c1\u0001\u0000\u0000\u0000\u05c3\u05c4\u0001\u0000\u0000\u0000"+
		"\u05c4\u05c2\u0001\u0000\u0000\u0000\u05c4\u05c5\u0001\u0000\u0000\u0000"+
		"\u05c5\u00f3\u0001\u0000\u0000\u0000\u05c6\u05c7\u0007\u0013\u0000\u0000"+
		"\u05c7\u00f5\u0001\u0000\u0000\u0000\u05c8\u05c9\u0007\u0012\u0000\u0000"+
		"\u05c9\u00f7\u0001\u0000\u0000\u0000\u05ca\u05cc\u0005\u0087\u0000\u0000"+
		"\u05cb\u05ca\u0001\u0000\u0000\u0000\u05cb\u05cc\u0001\u0000\u0000\u0000"+
		"\u05cc\u05cd\u0001\u0000\u0000\u0000\u05cd\u05ce\u0003\b\u0004\u0000\u05ce"+
		"\u00f9\u0001\u0000\u0000\u0000\u05cf\u05d1\u0003\u009aM\u0000\u05d0\u05d2"+
		"\u0003\u00fc~\u0000\u05d1\u05d0\u0001\u0000\u0000\u0000\u05d1\u05d2\u0001"+
		"\u0000\u0000\u0000\u05d2\u00fb\u0001\u0000\u0000\u0000\u05d3\u05dc\u0003"+
		"\u00fe\u007f\u0000\u05d4\u05d6\u0003\u0100\u0080\u0000\u05d5\u05d4\u0001"+
		"\u0000\u0000\u0000\u05d5\u05d6\u0001\u0000\u0000\u0000\u05d6\u05d7\u0001"+
		"\u0000\u0000\u0000\u05d7\u05d8\u0003\u00ecv\u0000\u05d8\u05d9\u0003\u00ee"+
		"w\u0000\u05d9\u05dc\u0001\u0000\u0000\u0000\u05da\u05dc\u0003\u0102\u0081"+
		"\u0000\u05db\u05d3\u0001\u0000\u0000\u0000\u05db\u05d5\u0001\u0000\u0000"+
		"\u0000\u05db\u05da\u0001\u0000\u0000\u0000\u05dc\u00fd\u0001\u0000\u0000"+
		"\u0000\u05dd\u05e7\u0003\u0100\u0080\u0000\u05de\u05e0\u0003\u00f0x\u0000"+
		"\u05df\u05de\u0001\u0000\u0000\u0000\u05e0\u05e1\u0001\u0000\u0000\u0000"+
		"\u05e1\u05df\u0001\u0000\u0000\u0000\u05e1\u05e2\u0001\u0000\u0000\u0000"+
		"\u05e2\u05e4\u0001\u0000\u0000\u0000\u05e3\u05e5\u0003\u0100\u0080\u0000"+
		"\u05e4\u05e3\u0001\u0000\u0000\u0000\u05e4\u05e5\u0001\u0000\u0000\u0000"+
		"\u05e5\u05e7\u0001\u0000\u0000\u0000\u05e6\u05dd\u0001\u0000\u0000\u0000"+
		"\u05e6\u05df\u0001\u0000\u0000\u0000\u05e7\u00ff\u0001\u0000\u0000\u0000"+
		"\u05e8\u05e9\u0006\u0080\uffff\uffff\u0000\u05e9\u05f7\u0003\u00ecv\u0000"+
		"\u05ea\u05ec\u0005[\u0000\u0000\u05eb\u05ed\u0003`0\u0000\u05ec\u05eb"+
		"\u0001\u0000\u0000\u0000\u05ec\u05ed\u0001\u0000\u0000\u0000\u05ed\u05ee"+
		"\u0001\u0000\u0000\u0000\u05ee\u05f0\u0005\\\u0000\u0000\u05ef\u05f1\u0003"+
		"\u00d0h\u0000\u05f0\u05ef\u0001\u0000\u0000\u0000\u05f0\u05f1\u0001\u0000"+
		"\u0000\u0000\u05f1\u05f7\u0001\u0000\u0000\u0000\u05f2\u05f3\u0005Y\u0000"+
		"\u0000\u05f3\u05f4\u0003\u00fe\u007f\u0000\u05f4\u05f5\u0005Z\u0000\u0000"+
		"\u05f5\u05f7\u0001\u0000\u0000\u0000\u05f6\u05e8\u0001\u0000\u0000\u0000"+
		"\u05f6\u05ea\u0001\u0000\u0000\u0000\u05f6\u05f2\u0001\u0000\u0000\u0000"+
		"\u05f7\u0607\u0001\u0000\u0000\u0000\u05f8\u0603\n\u0004\u0000\u0000\u05f9"+
		"\u0604\u0003\u00ecv\u0000\u05fa\u05fb\u0003\u0100\u0080\u0000\u05fb\u05fd"+
		"\u0005[\u0000\u0000\u05fc\u05fe\u0003`0\u0000\u05fd\u05fc\u0001\u0000"+
		"\u0000\u0000\u05fd\u05fe\u0001\u0000\u0000\u0000\u05fe\u05ff\u0001\u0000"+
		"\u0000\u0000\u05ff\u0601\u0005\\\u0000\u0000\u0600\u0602\u0003\u00d0h"+
		"\u0000\u0601\u0600\u0001\u0000\u0000\u0000\u0601\u0602\u0001\u0000\u0000"+
		"\u0000\u0602\u0604\u0001\u0000\u0000\u0000\u0603\u05f9\u0001\u0000\u0000"+
		"\u0000\u0603\u05fa\u0001\u0000\u0000\u0000\u0604\u0606\u0001\u0000\u0000"+
		"\u0000\u0605\u05f8\u0001\u0000\u0000\u0000\u0606\u0609\u0001\u0000\u0000"+
		"\u0000\u0607\u0605\u0001\u0000\u0000\u0000\u0607\u0608\u0001\u0000\u0000"+
		"\u0000\u0608\u0101\u0001\u0000\u0000\u0000\u0609\u0607\u0001\u0000\u0000"+
		"\u0000\u060a\u060c\u0003\u00f0x\u0000\u060b\u060a\u0001\u0000\u0000\u0000"+
		"\u060c\u060f\u0001\u0000\u0000\u0000\u060d\u060b\u0001\u0000\u0000\u0000"+
		"\u060d\u060e\u0001\u0000\u0000\u0000\u060e\u0610\u0001\u0000\u0000\u0000"+
		"\u060f\u060d\u0001\u0000\u0000\u0000\u0610\u0611\u0003\u0104\u0082\u0000"+
		"\u0611\u0103\u0001\u0000\u0000\u0000\u0612\u0613\u0006\u0082\uffff\uffff"+
		"\u0000\u0613\u0614\u0005\u0087\u0000\u0000\u0614\u0623\u0001\u0000\u0000"+
		"\u0000\u0615\u061f\n\u0002\u0000\u0000\u0616\u0620\u0003\u00ecv\u0000"+
		"\u0617\u0619\u0005[\u0000\u0000\u0618\u061a\u0003`0\u0000\u0619\u0618"+
		"\u0001\u0000\u0000\u0000\u0619\u061a\u0001\u0000\u0000\u0000\u061a\u061b"+
		"\u0001\u0000\u0000\u0000\u061b\u061d\u0005\\\u0000\u0000\u061c\u061e\u0003"+
		"\u00d0h\u0000\u061d\u061c\u0001\u0000\u0000\u0000\u061d\u061e\u0001\u0000"+
		"\u0000\u0000\u061e\u0620\u0001\u0000\u0000\u0000\u061f\u0616\u0001\u0000"+
		"\u0000\u0000\u061f\u0617\u0001\u0000\u0000\u0000\u0620\u0622\u0001\u0000"+
		"\u0000\u0000\u0621\u0615\u0001\u0000\u0000\u0000\u0622\u0625\u0001\u0000"+
		"\u0000\u0000\u0623\u0621\u0001\u0000\u0000\u0000\u0623\u0624\u0001\u0000"+
		"\u0000\u0000\u0624\u0105\u0001\u0000\u0000\u0000\u0625\u0623\u0001\u0000"+
		"\u0000\u0000\u0626\u062b\u0003\u0108\u0084\u0000\u0627\u0629\u0005~\u0000"+
		"\u0000\u0628\u0627\u0001\u0000\u0000\u0000\u0628\u0629\u0001\u0000\u0000"+
		"\u0000\u0629\u062a\u0001\u0000\u0000\u0000\u062a\u062c\u0005\u0087\u0000"+
		"\u0000\u062b\u0628\u0001\u0000\u0000\u0000\u062b\u062c\u0001\u0000\u0000"+
		"\u0000\u062c\u0107\u0001\u0000\u0000\u0000\u062d\u0632\u0003\u010a\u0085"+
		"\u0000\u062e\u062f\u0005~\u0000\u0000\u062f\u0631\u0003\u010a\u0085\u0000"+
		"\u0630\u062e\u0001\u0000\u0000\u0000\u0631\u0634\u0001\u0000\u0000\u0000"+
		"\u0632\u0630\u0001\u0000\u0000\u0000\u0632\u0633\u0001\u0000\u0000\u0000"+
		"\u0633\u0109\u0001\u0000\u0000\u0000\u0634\u0632\u0001\u0000\u0000\u0000"+
		"\u0635\u0637\u0003\u00d0h\u0000\u0636\u0635\u0001\u0000\u0000\u0000\u0636"+
		"\u0637\u0001\u0000\u0000\u0000\u0637\u0638\u0001\u0000\u0000\u0000\u0638"+
		"\u063d\u0003\u008eG\u0000\u0639\u063e\u0003\u00e6s\u0000\u063a\u063c\u0003"+
		"\u00fc~\u0000\u063b\u063a\u0001\u0000\u0000\u0000\u063b\u063c\u0001\u0000"+
		"\u0000\u0000\u063c\u063e\u0001\u0000\u0000\u0000\u063d\u0639\u0001\u0000"+
		"\u0000\u0000\u063d\u063b\u0001\u0000\u0000\u0000\u063e\u0641\u0001\u0000"+
		"\u0000\u0000\u063f\u0640\u0005i\u0000\u0000\u0640\u0642\u0003\u0114\u008a"+
		"\u0000\u0641\u063f\u0001\u0000\u0000\u0000\u0641\u0642\u0001\u0000\u0000"+
		"\u0000\u0642\u010b\u0001\u0000\u0000\u0000\u0643\u0645\u0003\u00d0h\u0000"+
		"\u0644\u0643\u0001\u0000\u0000\u0000\u0644\u0645\u0001\u0000\u0000\u0000"+
		"\u0645\u0647\u0001\u0000\u0000\u0000\u0646\u0648\u0003\u008eG\u0000\u0647"+
		"\u0646\u0001\u0000\u0000\u0000\u0647\u0648\u0001\u0000\u0000\u0000\u0648"+
		"\u0649\u0001\u0000\u0000\u0000\u0649\u064b\u0003\u00e6s\u0000\u064a\u064c"+
		"\u0003\u012e\u0097\u0000\u064b\u064a\u0001\u0000\u0000\u0000\u064b\u064c"+
		"\u0001\u0000\u0000\u0000\u064c\u064d\u0001\u0000\u0000\u0000\u064d\u064e"+
		"\u0003\u010e\u0087\u0000\u064e\u010d\u0001\u0000\u0000\u0000\u064f\u0651"+
		"\u0003\u0146\u00a3\u0000\u0650\u064f\u0001\u0000\u0000\u0000\u0650\u0651"+
		"\u0001\u0000\u0000\u0000\u0651\u0652\u0001\u0000\u0000\u0000\u0652\u0658"+
		"\u0003h4\u0000\u0653\u0658\u0003\u016c\u00b6\u0000\u0654\u0655\u0005i"+
		"\u0000\u0000\u0655\u0656\u0007\u0014\u0000\u0000\u0656\u0658\u0005\u0084"+
		"\u0000\u0000\u0657\u0650\u0001\u0000\u0000\u0000\u0657\u0653\u0001\u0000"+
		"\u0000\u0000\u0657\u0654\u0001\u0000\u0000\u0000\u0658\u010f\u0001\u0000"+
		"\u0000\u0000\u0659\u065f\u0003\u0112\u0089\u0000\u065a\u065b\u0005Y\u0000"+
		"\u0000\u065b\u065c\u0003&\u0013\u0000\u065c\u065d\u0005Z\u0000\u0000\u065d"+
		"\u065f\u0001\u0000\u0000\u0000\u065e\u0659\u0001\u0000\u0000\u0000\u065e"+
		"\u065a\u0001\u0000\u0000\u0000\u065f\u0111\u0001\u0000\u0000\u0000\u0660"+
		"\u0661\u0005i\u0000\u0000\u0661\u0664\u0003\u0114\u008a\u0000\u0662\u0664"+
		"\u0003\u0118\u008c\u0000\u0663\u0660\u0001\u0000\u0000\u0000\u0663\u0662"+
		"\u0001\u0000\u0000\u0000\u0664\u0113\u0001\u0000\u0000\u0000\u0665\u0668"+
		"\u0003Z-\u0000\u0666\u0668\u0003\u0118\u008c\u0000\u0667\u0665\u0001\u0000"+
		"\u0000\u0000\u0667\u0666\u0001\u0000\u0000\u0000\u0668\u0115\u0001\u0000"+
		"\u0000\u0000\u0669\u066b\u0003\u0114\u008a\u0000\u066a\u066c\u0005\u0087"+
		"\u0000\u0000\u066b\u066a\u0001\u0000\u0000\u0000\u066b\u066c\u0001\u0000"+
		"\u0000\u0000\u066c\u0674\u0001\u0000\u0000\u0000\u066d\u066e\u0005~\u0000"+
		"\u0000\u066e\u0670\u0003\u0114\u008a\u0000\u066f\u0671\u0005\u0087\u0000"+
		"\u0000\u0670\u066f\u0001\u0000\u0000\u0000\u0670\u0671\u0001\u0000\u0000"+
		"\u0000\u0671\u0673\u0001\u0000\u0000\u0000\u0672\u066d\u0001\u0000\u0000"+
		"\u0000\u0673\u0676\u0001\u0000\u0000\u0000\u0674\u0672\u0001\u0000\u0000"+
		"\u0000\u0674\u0675\u0001\u0000\u0000\u0000\u0675\u0117\u0001\u0000\u0000"+
		"\u0000\u0676\u0674\u0001\u0000\u0000\u0000\u0677\u067c\u0005]\u0000\u0000"+
		"\u0678\u067a\u0003\u0116\u008b\u0000\u0679\u067b\u0005~\u0000\u0000\u067a"+
		"\u0679\u0001\u0000\u0000\u0000\u067a\u067b\u0001\u0000\u0000\u0000\u067b"+
		"\u067d\u0001\u0000\u0000\u0000\u067c\u0678\u0001\u0000\u0000\u0000\u067c"+
		"\u067d\u0001\u0000\u0000\u0000\u067d\u067e\u0001\u0000\u0000\u0000\u067e"+
		"\u067f\u0005^\u0000\u0000\u067f\u0119\u0001\u0000\u0000\u0000\u0680\u0683"+
		"\u0005\u0088\u0000\u0000\u0681\u0683\u0003\u015a\u00ad\u0000\u0682\u0680"+
		"\u0001\u0000\u0000\u0000\u0682\u0681\u0001\u0000\u0000\u0000\u0683\u011b"+
		"\u0001\u0000\u0000\u0000\u0684\u0685\u0003\u011e\u008f\u0000\u0685\u0687"+
		"\u0005]\u0000\u0000\u0686\u0688\u0003\u0126\u0093\u0000\u0687\u0686\u0001"+
		"\u0000\u0000\u0000\u0687\u0688\u0001\u0000\u0000\u0000\u0688\u0689\u0001"+
		"\u0000\u0000\u0000\u0689\u068a\u0005^\u0000\u0000\u068a\u011d\u0001\u0000"+
		"\u0000\u0000\u068b\u068d\u0003\u0124\u0092\u0000\u068c\u068e\u0003\u00d0"+
		"h\u0000\u068d\u068c\u0001\u0000\u0000\u0000\u068d\u068e\u0001\u0000\u0000"+
		"\u0000\u068e\u0693\u0001\u0000\u0000\u0000\u068f\u0691\u0003\u0120\u0090"+
		"\u0000\u0690\u0692\u0003\u0122\u0091\u0000\u0691\u0690\u0001\u0000\u0000"+
		"\u0000\u0691\u0692\u0001\u0000\u0000\u0000\u0692\u0694\u0001\u0000\u0000"+
		"\u0000\u0693\u068f\u0001\u0000\u0000\u0000\u0693\u0694\u0001\u0000\u0000"+
		"\u0000\u0694\u0696\u0001\u0000\u0000\u0000\u0695\u0697\u0003\u0134\u009a"+
		"\u0000\u0696\u0695\u0001\u0000\u0000\u0000\u0696\u0697\u0001\u0000\u0000"+
		"\u0000\u0697\u06a3\u0001\u0000\u0000\u0000\u0698\u069a\u0005Q\u0000\u0000"+
		"\u0699\u069b\u0003\u00d0h\u0000\u069a\u0699\u0001\u0000\u0000\u0000\u069a"+
		"\u069b\u0001\u0000\u0000\u0000\u069b\u06a0\u0001\u0000\u0000\u0000\u069c"+
		"\u069e\u0003\u0120\u0090\u0000\u069d\u069f\u0003\u0122\u0091\u0000\u069e"+
		"\u069d\u0001\u0000\u0000\u0000\u069e\u069f\u0001\u0000\u0000\u0000\u069f"+
		"\u06a1\u0001\u0000\u0000\u0000\u06a0\u069c\u0001\u0000\u0000\u0000\u06a0"+
		"\u06a1\u0001\u0000\u0000\u0000\u06a1\u06a3\u0001\u0000\u0000\u0000\u06a2"+
		"\u068b\u0001\u0000\u0000\u0000\u06a2\u0698\u0001\u0000\u0000\u0000\u06a3"+
		"\u011f\u0001\u0000\u0000\u0000\u06a4\u06a6\u0003\u000e\u0007\u0000\u06a5"+
		"\u06a4\u0001\u0000\u0000\u0000\u06a5\u06a6\u0001\u0000\u0000\u0000\u06a6"+
		"\u06a7\u0001\u0000\u0000\u0000\u06a7\u06a8\u0003\u011a\u008d\u0000\u06a8"+
		"\u0121\u0001\u0000\u0000\u0000\u06a9\u06aa\u0005*\u0000\u0000\u06aa\u0123"+
		"\u0001\u0000\u0000\u0000\u06ab\u06ac\u0007\u0010\u0000\u0000\u06ac\u0125"+
		"\u0001\u0000\u0000\u0000\u06ad\u06b2\u0003\u0128\u0094\u0000\u06ae\u06af"+
		"\u0003\u013e\u009f\u0000\u06af\u06b0\u0005\u0082\u0000\u0000\u06b0\u06b2"+
		"\u0001\u0000\u0000\u0000\u06b1\u06ad\u0001\u0000\u0000\u0000\u06b1\u06ae"+
		"\u0001\u0000\u0000\u0000\u06b2\u06b3\u0001\u0000\u0000\u0000\u06b3\u06b1"+
		"\u0001\u0000\u0000\u0000\u06b3\u06b4\u0001\u0000\u0000\u0000\u06b4\u0127"+
		"\u0001\u0000\u0000\u0000\u06b5\u06b7\u0003\u00d0h\u0000\u06b6\u06b5\u0001"+
		"\u0000\u0000\u0000\u06b6\u06b7\u0001\u0000\u0000\u0000\u06b7\u06b9\u0001"+
		"\u0000\u0000\u0000\u06b8\u06ba\u0003\u008eG\u0000\u06b9\u06b8\u0001\u0000"+
		"\u0000\u0000\u06b9\u06ba\u0001\u0000\u0000\u0000\u06ba\u06bc\u0001\u0000"+
		"\u0000\u0000\u06bb\u06bd\u0003\u012a\u0095\u0000\u06bc\u06bb\u0001\u0000"+
		"\u0000\u0000\u06bc\u06bd\u0001\u0000\u0000\u0000\u06bd\u06be\u0001\u0000"+
		"\u0000\u0000\u06be\u06c6\u0005\u0084\u0000\u0000\u06bf\u06c6\u0003\u010c"+
		"\u0086\u0000\u06c0\u06c6\u0003\u00c8d\u0000\u06c1\u06c6\u0003\u0086C\u0000"+
		"\u06c2\u06c6\u0003\u0152\u00a9\u0000\u06c3\u06c6\u0003\u0082A\u0000\u06c4"+
		"\u06c6\u0003\u0088D\u0000\u06c5\u06b6\u0001\u0000\u0000\u0000\u06c5\u06bf"+
		"\u0001\u0000\u0000\u0000\u06c5\u06c0\u0001\u0000\u0000\u0000\u06c5\u06c1"+
		"\u0001\u0000\u0000\u0000\u06c5\u06c2\u0001\u0000\u0000\u0000\u06c5\u06c3"+
		"\u0001\u0000\u0000\u0000\u06c5\u06c4\u0001\u0000\u0000\u0000\u06c6\u0129"+
		"\u0001\u0000\u0000\u0000\u06c7\u06cc\u0003\u012c\u0096\u0000\u06c8\u06c9"+
		"\u0005~\u0000\u0000\u06c9\u06cb\u0003\u012c\u0096\u0000\u06ca\u06c8\u0001"+
		"\u0000\u0000\u0000\u06cb\u06ce\u0001\u0000\u0000\u0000\u06cc\u06ca\u0001"+
		"\u0000\u0000\u0000\u06cc\u06cd\u0001\u0000\u0000\u0000\u06cd\u012b\u0001"+
		"\u0000\u0000\u0000\u06ce\u06cc\u0001\u0000\u0000\u0000\u06cf\u06d8\u0003"+
		"\u00e6s\u0000\u06d0\u06d9\u0003\u012e\u0097\u0000\u06d1\u06d2\u0004\u0096"+
		"\t\u0000\u06d2\u06d9\u0003\u0132\u0099\u0000\u06d3\u06d4\u0004\u0096\n"+
		"\u0000\u06d4\u06d5\u0003\u012e\u0097\u0000\u06d5\u06d6\u0003\u0132\u0099"+
		"\u0000\u06d6\u06d9\u0001\u0000\u0000\u0000\u06d7\u06d9\u0003\u0112\u0089"+
		"\u0000\u06d8\u06d0\u0001\u0000\u0000\u0000\u06d8\u06d1\u0001\u0000\u0000"+
		"\u0000\u06d8\u06d3\u0001\u0000\u0000\u0000\u06d8\u06d7\u0001\u0000\u0000"+
		"\u0000\u06d9\u06e4\u0001\u0000\u0000\u0000\u06da\u06e4\u0003\u00e6s\u0000"+
		"\u06db\u06dd\u0005\u0088\u0000\u0000\u06dc\u06db\u0001\u0000\u0000\u0000"+
		"\u06dc\u06dd\u0001\u0000\u0000\u0000\u06dd\u06df\u0001\u0000\u0000\u0000"+
		"\u06de\u06e0\u0003\u00d0h\u0000\u06df\u06de\u0001\u0000\u0000\u0000\u06df"+
		"\u06e0\u0001\u0000\u0000\u0000\u06e0\u06e1\u0001\u0000\u0000\u0000\u06e1"+
		"\u06e2\u0005\u0082\u0000\u0000\u06e2\u06e4\u0003`0\u0000\u06e3\u06cf\u0001"+
		"\u0000\u0000\u0000\u06e3\u06da\u0001\u0000\u0000\u0000\u06e3\u06dc\u0001"+
		"\u0000\u0000\u0000\u06e4\u012d\u0001\u0000\u0000\u0000\u06e5\u06e7\u0003"+
		"\u0130\u0098\u0000\u06e6\u06e5\u0001\u0000\u0000\u0000\u06e7\u06e8\u0001"+
		"\u0000\u0000\u0000\u06e8\u06e6\u0001\u0000\u0000\u0000\u06e8\u06e9\u0001"+
		"\u0000\u0000\u0000\u06e9\u012f\u0001\u0000\u0000\u0000\u06ea\u06eb\u0007"+
		"\u0015\u0000\u0000\u06eb\u0131\u0001\u0000\u0000\u0000\u06ec\u06ed\u0005"+
		"i\u0000\u0000\u06ed\u06ee\u0005\u0002\u0000\u0000\u06ee\u0133\u0001\u0000"+
		"\u0000\u0000\u06ef\u06f0\u0005\u0082\u0000\u0000\u06f0\u06f1\u0003\u0136"+
		"\u009b\u0000\u06f1\u0135\u0001\u0000\u0000\u0000\u06f2\u06f4\u0003\u0138"+
		"\u009c\u0000\u06f3\u06f5\u0005\u0087\u0000\u0000\u06f4\u06f3\u0001\u0000"+
		"\u0000\u0000\u06f4\u06f5\u0001\u0000\u0000\u0000\u06f5\u06fd\u0001\u0000"+
		"\u0000\u0000\u06f6\u06f7\u0005~\u0000\u0000\u06f7\u06f9\u0003\u0138\u009c"+
		"\u0000\u06f8\u06fa\u0005\u0087\u0000\u0000\u06f9\u06f8\u0001\u0000\u0000"+
		"\u0000\u06f9\u06fa\u0001\u0000\u0000\u0000\u06fa\u06fc\u0001\u0000\u0000"+
		"\u0000\u06fb\u06f6\u0001\u0000\u0000\u0000\u06fc\u06ff\u0001\u0000\u0000"+
		"\u0000\u06fd\u06fb\u0001\u0000\u0000\u0000\u06fd\u06fe\u0001\u0000\u0000"+
		"\u0000\u06fe\u0137\u0001\u0000\u0000\u0000\u06ff\u06fd\u0001\u0000\u0000"+
		"\u0000\u0700\u0702\u0003\u00d0h\u0000\u0701\u0700\u0001\u0000\u0000\u0000"+
		"\u0701\u0702\u0001\u0000\u0000\u0000\u0702\u070f\u0001\u0000\u0000\u0000"+
		"\u0703\u0710\u0003\u013c\u009e\u0000\u0704\u0706\u0005T\u0000\u0000\u0705"+
		"\u0707\u0003\u013e\u009f\u0000\u0706\u0705\u0001\u0000\u0000\u0000\u0706"+
		"\u0707\u0001\u0000\u0000\u0000\u0707\u0708\u0001\u0000\u0000\u0000\u0708"+
		"\u0710\u0003\u013c\u009e\u0000\u0709\u070b\u0003\u013e\u009f\u0000\u070a"+
		"\u070c\u0005T\u0000\u0000\u070b\u070a\u0001\u0000\u0000\u0000\u070b\u070c"+
		"\u0001\u0000\u0000\u0000\u070c\u070d\u0001\u0000\u0000\u0000\u070d\u070e"+
		"\u0003\u013c\u009e\u0000\u070e\u0710\u0001\u0000\u0000\u0000\u070f\u0703"+
		"\u0001\u0000\u0000\u0000\u070f\u0704\u0001\u0000\u0000\u0000\u070f\u0709"+
		"\u0001\u0000\u0000\u0000\u0710\u0139\u0001\u0000\u0000\u0000\u0711\u0713"+
		"\u0003\u000e\u0007\u0000\u0712\u0711\u0001\u0000\u0000\u0000\u0712\u0713"+
		"\u0001\u0000\u0000\u0000\u0713\u0714\u0001\u0000\u0000\u0000\u0714\u0717"+
		"\u0003\u011a\u008d\u0000\u0715\u0717\u0003\u00a6S\u0000\u0716\u0712\u0001"+
		"\u0000\u0000\u0000\u0716\u0715\u0001\u0000\u0000\u0000\u0717\u013b\u0001"+
		"\u0000\u0000\u0000\u0718\u0719\u0003\u013a\u009d\u0000\u0719\u013d\u0001"+
		"\u0000\u0000\u0000\u071a\u071b\u0007\u0016\u0000\u0000\u071b\u013f\u0001"+
		"\u0000\u0000\u0000\u071c\u071d\u00058\u0000\u0000\u071d\u071e\u0003\u0142"+
		"\u00a1\u0000\u071e\u0141\u0001\u0000\u0000\u0000\u071f\u0721\u0003\u009a"+
		"M\u0000\u0720\u0722\u0003\u0144\u00a2\u0000\u0721\u0720\u0001\u0000\u0000"+
		"\u0000\u0721\u0722\u0001\u0000\u0000\u0000\u0722\u0143\u0001\u0000\u0000"+
		"\u0000\u0723\u0725\u0003\u00f0x\u0000\u0724\u0726\u0003\u0144\u00a2\u0000"+
		"\u0725\u0724\u0001\u0000\u0000\u0000\u0725\u0726\u0001\u0000\u0000\u0000"+
		"\u0726\u0145\u0001\u0000\u0000\u0000\u0727\u0728\u0005\u0082\u0000\u0000"+
		"\u0728\u0729\u0003\u0148\u00a4\u0000\u0729\u0147\u0001\u0000\u0000\u0000"+
		"\u072a\u072c\u0003\u014a\u00a5\u0000\u072b\u072d\u0005\u0087\u0000\u0000"+
		"\u072c\u072b\u0001\u0000\u0000\u0000\u072c\u072d\u0001\u0000\u0000\u0000"+
		"\u072d\u0735\u0001\u0000\u0000\u0000\u072e\u072f\u0005~\u0000\u0000\u072f"+
		"\u0731\u0003\u014a\u00a5\u0000\u0730\u0732\u0005\u0087\u0000\u0000\u0731"+
		"\u0730\u0001\u0000\u0000\u0000\u0731\u0732\u0001\u0000\u0000\u0000\u0732"+
		"\u0734\u0001\u0000\u0000\u0000\u0733\u072e\u0001\u0000\u0000\u0000\u0734"+
		"\u0737\u0001\u0000\u0000\u0000\u0735\u0733\u0001\u0000\u0000\u0000\u0735"+
		"\u0736\u0001\u0000\u0000\u0000\u0736\u0149\u0001\u0000\u0000\u0000\u0737"+
		"\u0735\u0001\u0000\u0000\u0000\u0738\u073f\u0003\u014c\u00a6\u0000\u0739"+
		"\u073b\u0005Y\u0000\u0000\u073a\u073c\u0003&\u0013\u0000\u073b\u073a\u0001"+
		"\u0000\u0000\u0000\u073b\u073c\u0001\u0000\u0000\u0000\u073c\u073d\u0001"+
		"\u0000\u0000\u0000\u073d\u0740\u0005Z\u0000\u0000\u073e\u0740\u0003\u0118"+
		"\u008c\u0000\u073f\u0739\u0001\u0000\u0000\u0000\u073f\u073e\u0001\u0000"+
		"\u0000\u0000\u0740\u014b\u0001\u0000\u0000\u0000\u0741\u0744\u0003\u013a"+
		"\u009d\u0000\u0742\u0744\u0005\u0088\u0000\u0000\u0743\u0741\u0001\u0000"+
		"\u0000\u0000\u0743\u0742\u0001\u0000\u0000\u0000\u0744\u014d\u0001\u0000"+
		"\u0000\u0000\u0745\u0746\u00058\u0000\u0000\u0746\u0747\u0003\u017e\u00bf"+
		"\u0000\u0747\u014f\u0001\u0000\u0000\u0000\u0748\u074c\u00058\u0000\u0000"+
		"\u0749\u074a\u0005\u0005\u0000\u0000\u074a\u074d\u0005\u0088\u0000\u0000"+
		"\u074b\u074d\u0005\u0090\u0000\u0000\u074c\u0749\u0001\u0000\u0000\u0000"+
		"\u074c\u074b\u0001\u0000\u0000\u0000\u074d\u0151\u0001\u0000\u0000\u0000"+
		"\u074e\u074f\u0005H\u0000\u0000\u074f\u0750\u0005j\u0000\u0000\u0750\u0751"+
		"\u0003\u0154\u00aa\u0000\u0751\u0752\u0005k\u0000\u0000\u0752\u0753\u0003"+
		"~?\u0000\u0753\u0153\u0001\u0000\u0000\u0000\u0754\u0759\u0003\u0156\u00ab"+
		"\u0000\u0755\u0756\u0005~\u0000\u0000\u0756\u0758\u0003\u0156\u00ab\u0000"+
		"\u0757\u0755\u0001\u0000\u0000\u0000\u0758\u075b\u0001\u0000\u0000\u0000"+
		"\u0759\u0757\u0001\u0000\u0000\u0000\u0759\u075a\u0001\u0000\u0000\u0000"+
		"\u075a\u0155\u0001\u0000\u0000\u0000\u075b\u0759\u0001\u0000\u0000\u0000"+
		"\u075c\u075f\u0003\u0158\u00ac\u0000\u075d\u075f\u0003\u010a\u0085\u0000"+
		"\u075e\u075c\u0001\u0000\u0000\u0000\u075e\u075d\u0001\u0000\u0000\u0000"+
		"\u075f\u0157\u0001\u0000\u0000\u0000\u0760\u0761\u0005H\u0000\u0000\u0761"+
		"\u0762\u0005j\u0000\u0000\u0762\u0763\u0003\u0154\u00aa\u0000\u0763\u0764"+
		"\u0005k\u0000\u0000\u0764\u0766\u0001\u0000\u0000\u0000\u0765\u0760\u0001"+
		"\u0000\u0000\u0000\u0765\u0766\u0001\u0000\u0000\u0000\u0766\u0767\u0001"+
		"\u0000\u0000\u0000\u0767\u076a\u0005\u0019\u0000\u0000\u0768\u076a\u0005"+
		"P\u0000\u0000\u0769\u0765\u0001\u0000\u0000\u0000\u0769\u0768\u0001\u0000"+
		"\u0000\u0000\u076a\u0776\u0001\u0000\u0000\u0000\u076b\u076d\u0005\u0087"+
		"\u0000\u0000\u076c\u076b\u0001\u0000\u0000\u0000\u076c\u076d\u0001\u0000"+
		"\u0000\u0000\u076d\u076f\u0001\u0000\u0000\u0000\u076e\u0770\u0005\u0088"+
		"\u0000\u0000\u076f\u076e\u0001\u0000\u0000\u0000\u076f\u0770\u0001\u0000"+
		"\u0000\u0000\u0770\u0777\u0001\u0000\u0000\u0000\u0771\u0773\u0005\u0088"+
		"\u0000\u0000\u0772\u0771\u0001\u0000\u0000\u0000\u0772\u0773\u0001\u0000"+
		"\u0000\u0000\u0773\u0774\u0001\u0000\u0000\u0000\u0774\u0775\u0005i\u0000"+
		"\u0000\u0775\u0777\u0003\u00fa}\u0000\u0776\u076c\u0001\u0000\u0000\u0000"+
		"\u0776\u0772\u0001\u0000\u0000\u0000\u0777\u0159\u0001\u0000\u0000\u0000"+
		"\u0778\u0779\u0003\u015e\u00af\u0000\u0779\u077b\u0005j\u0000\u0000\u077a"+
		"\u077c\u0003\u0160\u00b0\u0000\u077b\u077a\u0001\u0000\u0000\u0000\u077b"+
		"\u077c\u0001\u0000\u0000\u0000\u077c\u077d\u0001\u0000\u0000\u0000\u077d"+
		"\u077e\u0005k\u0000\u0000\u077e\u015b\u0001\u0000\u0000\u0000\u077f\u078b"+
		"\u0003\u015a\u00ad\u0000\u0780\u0783\u0003\u014e\u00a7\u0000\u0781\u0783"+
		"\u0003\u0150\u00a8\u0000\u0782\u0780\u0001\u0000\u0000\u0000\u0782\u0781"+
		"\u0001\u0000\u0000\u0000\u0783\u0784\u0001\u0000\u0000\u0000\u0784\u0786"+
		"\u0005j\u0000\u0000\u0785\u0787\u0003\u0160\u00b0\u0000\u0786\u0785\u0001"+
		"\u0000\u0000\u0000\u0786\u0787\u0001\u0000\u0000\u0000\u0787\u0788\u0001"+
		"\u0000\u0000\u0000\u0788\u0789\u0005k\u0000\u0000\u0789\u078b\u0001\u0000"+
		"\u0000\u0000\u078a\u077f\u0001\u0000\u0000\u0000\u078a\u0782\u0001\u0000"+
		"\u0000\u0000\u078b\u015d\u0001\u0000\u0000\u0000\u078c\u078d\u0005\u0088"+
		"\u0000\u0000\u078d\u015f\u0001\u0000\u0000\u0000\u078e\u0790\u0003\u0162"+
		"\u00b1\u0000\u078f\u0791\u0005\u0087\u0000\u0000\u0790\u078f\u0001\u0000"+
		"\u0000\u0000\u0790\u0791\u0001\u0000\u0000\u0000\u0791\u0799\u0001\u0000"+
		"\u0000\u0000\u0792\u0793\u0005~\u0000\u0000\u0793\u0795\u0003\u0162\u00b1"+
		"\u0000\u0794\u0796\u0005\u0087\u0000\u0000\u0795\u0794\u0001\u0000\u0000"+
		"\u0000\u0795\u0796\u0001\u0000\u0000\u0000\u0796\u0798\u0001\u0000\u0000"+
		"\u0000\u0797\u0792\u0001\u0000\u0000\u0000\u0798\u079b\u0001\u0000\u0000"+
		"\u0000\u0799\u0797\u0001\u0000\u0000\u0000\u0799\u079a\u0001\u0000\u0000"+
		"\u0000\u079a\u0161\u0001\u0000\u0000\u0000\u079b\u0799\u0001\u0000\u0000"+
		"\u0000\u079c\u07a0\u0003\u00fa}\u0000\u079d\u07a0\u0003`0\u0000\u079e"+
		"\u07a0\u0003\b\u0004\u0000\u079f\u079c\u0001\u0000\u0000\u0000\u079f\u079d"+
		"\u0001\u0000\u0000\u0000\u079f\u079e\u0001\u0000\u0000\u0000\u07a0\u0163"+
		"\u0001\u0000\u0000\u0000\u07a1\u07a2\u0005P\u0000\u0000\u07a2\u07a8\u0003"+
		"\u000e\u0007\u0000\u07a3\u07a9\u0005\u0088\u0000\u0000\u07a4\u07a6\u0005"+
		"H\u0000\u0000\u07a5\u07a4\u0001\u0000\u0000\u0000\u07a5\u07a6\u0001\u0000"+
		"\u0000\u0000\u07a6\u07a7\u0001\u0000\u0000\u0000\u07a7\u07a9\u0003\u015a"+
		"\u00ad\u0000\u07a8\u07a3\u0001\u0000\u0000\u0000\u07a8\u07a5\u0001\u0000"+
		"\u0000\u0000\u07a9\u0165\u0001\u0000\u0000\u0000\u07aa\u07ac\u0005(\u0000"+
		"\u0000\u07ab\u07aa\u0001\u0000\u0000\u0000\u07ab\u07ac\u0001\u0000\u0000"+
		"\u0000\u07ac\u07ad\u0001\u0000\u0000\u0000\u07ad\u07ae\u0005H\u0000\u0000"+
		"\u07ae\u07af\u0003~?\u0000\u07af\u0167\u0001\u0000\u0000\u0000\u07b0\u07b1"+
		"\u0005H\u0000\u0000\u07b1\u07b2\u0005j\u0000\u0000\u07b2\u07b3\u0005k"+
		"\u0000\u0000\u07b3\u07b4\u0003~?\u0000\u07b4\u0169\u0001\u0000\u0000\u0000"+
		"\u07b5\u07b6\u0005M\u0000\u0000\u07b6\u07b7\u0003h4\u0000\u07b7\u07b8"+
		"\u0003\u016e\u00b7\u0000\u07b8\u016b\u0001\u0000\u0000\u0000\u07b9\u07bb"+
		"\u0005M\u0000\u0000\u07ba\u07bc\u0003\u0146\u00a3\u0000\u07bb\u07ba\u0001"+
		"\u0000\u0000\u0000\u07bb\u07bc\u0001\u0000\u0000\u0000\u07bc\u07bd\u0001"+
		"\u0000\u0000\u0000\u07bd\u07be\u0003h4\u0000\u07be\u07bf\u0003\u016e\u00b7"+
		"\u0000\u07bf\u016d\u0001\u0000\u0000\u0000\u07c0\u07c2\u0003\u0170\u00b8"+
		"\u0000\u07c1\u07c0\u0001\u0000\u0000\u0000\u07c2\u07c3\u0001\u0000\u0000"+
		"\u0000\u07c3\u07c1\u0001\u0000\u0000\u0000\u07c3\u07c4\u0001\u0000\u0000"+
		"\u0000\u07c4\u016f\u0001\u0000\u0000\u0000\u07c5\u07c6\u0005\u0015\u0000"+
		"\u0000\u07c6\u07c7\u0005Y\u0000\u0000\u07c7\u07c8\u0003\u0172\u00b9\u0000"+
		"\u07c8\u07c9\u0005Z\u0000\u0000\u07c9\u07ca\u0003h4\u0000\u07ca\u0171"+
		"\u0001\u0000\u0000\u0000\u07cb\u07cd\u0003\u00d0h\u0000\u07cc\u07cb\u0001"+
		"\u0000\u0000\u0000\u07cc\u07cd\u0001\u0000\u0000\u0000\u07cd\u07ce\u0001"+
		"\u0000\u0000\u0000\u07ce\u07d1\u0003\u009aM\u0000\u07cf\u07d2\u0003\u00e6"+
		"s\u0000\u07d0\u07d2\u0003\u00fc~\u0000\u07d1\u07cf\u0001\u0000\u0000\u0000"+
		"\u07d1\u07d0\u0001\u0000\u0000\u0000\u07d1\u07d2\u0001\u0000\u0000\u0000"+
		"\u07d2\u07d5\u0001\u0000\u0000\u0000\u07d3\u07d5\u0005\u0087\u0000\u0000"+
		"\u07d4\u07cc\u0001\u0000\u0000\u0000\u07d4\u07d3\u0001\u0000\u0000\u0000"+
		"\u07d5\u0173\u0001\u0000\u0000\u0000\u07d6\u07d8\u0005K\u0000\u0000\u07d7"+
		"\u07d9\u0003Z-\u0000\u07d8\u07d7\u0001\u0000\u0000\u0000\u07d8\u07d9\u0001"+
		"\u0000\u0000\u0000\u07d9\u0175\u0001\u0000\u0000\u0000\u07da\u07dd\u0003"+
		"\u0178\u00bc\u0000\u07db\u07dd\u0003\u017c\u00be\u0000\u07dc\u07da\u0001"+
		"\u0000\u0000\u0000\u07dc\u07db\u0001\u0000\u0000\u0000\u07dd\u0177\u0001"+
		"\u0000\u0000\u0000\u07de\u07df\u0005K\u0000\u0000\u07df\u07e1\u0005Y\u0000"+
		"\u0000\u07e0\u07e2\u0003\u017a\u00bd\u0000\u07e1\u07e0\u0001\u0000\u0000"+
		"\u0000\u07e1\u07e2\u0001\u0000\u0000\u0000\u07e2\u07e3\u0001\u0000\u0000"+
		"\u0000\u07e3\u07e4\u0005Z\u0000\u0000\u07e4\u0179\u0001\u0000\u0000\u0000"+
		"\u07e5\u07e7\u0003\u00fa}\u0000\u07e6\u07e8\u0005\u0087\u0000\u0000\u07e7"+
		"\u07e6\u0001\u0000\u0000\u0000\u07e7\u07e8\u0001\u0000\u0000\u0000\u07e8"+
		"\u07f0\u0001\u0000\u0000\u0000\u07e9\u07ea\u0005~\u0000\u0000\u07ea\u07ec"+
		"\u0003\u00fa}\u0000\u07eb\u07ed\u0005\u0087\u0000\u0000\u07ec\u07eb\u0001"+
		"\u0000\u0000\u0000\u07ec\u07ed\u0001\u0000\u0000\u0000\u07ed\u07ef\u0001"+
		"\u0000\u0000\u0000\u07ee\u07e9\u0001\u0000\u0000\u0000\u07ef\u07f2\u0001"+
		"\u0000\u0000\u0000\u07f0\u07ee\u0001\u0000\u0000\u0000\u07f0\u07f1\u0001"+
		"\u0000\u0000\u0000\u07f1\u017b\u0001\u0000\u0000\u0000\u07f2\u07f0\u0001"+
		"\u0000\u0000\u0000\u07f3\u07f4\u00056\u0000\u0000\u07f4\u07f5\u0005Y\u0000"+
		"\u0000\u07f5\u07f6\u0003`0\u0000\u07f6\u07f7\u0005Z\u0000\u0000\u07f7"+
		"\u07fa\u0001\u0000\u0000\u0000\u07f8\u07fa\u00056\u0000\u0000\u07f9\u07f3"+
		"\u0001\u0000\u0000\u0000\u07f9\u07f8\u0001\u0000\u0000\u0000\u07fa\u017d"+
		"\u0001\u0000\u0000\u0000\u07fb\u07fe\u00055\u0000\u0000\u07fc\u07fd\u0005"+
		"[\u0000\u0000\u07fd\u07ff\u0005\\\u0000\u0000\u07fe\u07fc\u0001\u0000"+
		"\u0000\u0000\u07fe\u07ff\u0001\u0000\u0000\u0000\u07ff\u082f\u0001\u0000"+
		"\u0000\u0000\u0800\u0803\u0005 \u0000\u0000\u0801\u0802\u0005[\u0000\u0000"+
		"\u0802\u0804\u0005\\\u0000\u0000\u0803\u0801\u0001\u0000\u0000\u0000\u0803"+
		"\u0804\u0001\u0000\u0000\u0000\u0804\u082f\u0001\u0000\u0000\u0000\u0805"+
		"\u082f\u0005_\u0000\u0000\u0806\u082f\u0005`\u0000\u0000\u0807\u082f\u0005"+
		"a\u0000\u0000\u0808\u082f\u0005b\u0000\u0000\u0809\u082f\u0005c\u0000"+
		"\u0000\u080a\u082f\u0005d\u0000\u0000\u080b\u082f\u0005e\u0000\u0000\u080c"+
		"\u082f\u0005f\u0000\u0000\u080d\u082f\u0005g\u0000\u0000\u080e\u082f\u0005"+
		"h\u0000\u0000\u080f\u082f\u0005i\u0000\u0000\u0810\u082f\u0005k\u0000"+
		"\u0000\u0811\u082f\u0005j\u0000\u0000\u0812\u082f\u0005y\u0000\u0000\u0813"+
		"\u082f\u0005l\u0000\u0000\u0814\u082f\u0005m\u0000\u0000\u0815\u082f\u0005"+
		"n\u0000\u0000\u0816\u082f\u0005p\u0000\u0000\u0817\u082f\u0005q\u0000"+
		"\u0000\u0818\u082f\u0005r\u0000\u0000\u0819\u082f\u0005s\u0000\u0000\u081a"+
		"\u081b\u0005j\u0000\u0000\u081b\u082f\u0005j\u0000\u0000\u081c\u081d\u0005"+
		"k\u0000\u0000\u081d\u082f\u0005k\u0000\u0000\u081e\u082f\u0005u\u0000"+
		"\u0000\u081f\u082f\u0005t\u0000\u0000\u0820\u082f\u0005v\u0000\u0000\u0821"+
		"\u082f\u0005w\u0000\u0000\u0822\u082f\u0005x\u0000\u0000\u0823\u082f\u0005"+
		"z\u0000\u0000\u0824\u082f\u0005{\u0000\u0000\u0825\u082f\u0005|\u0000"+
		"\u0000\u0826\u082f\u0005}\u0000\u0000\u0827\u082f\u0005~\u0000\u0000\u0828"+
		"\u082f\u0005\u007f\u0000\u0000\u0829\u082f\u0005\u0080\u0000\u0000\u082a"+
		"\u082b\u0005Y\u0000\u0000\u082b\u082f\u0005Z\u0000\u0000\u082c\u082d\u0005"+
		"[\u0000\u0000\u082d\u082f\u0005\\\u0000\u0000\u082e\u07fb\u0001\u0000"+
		"\u0000\u0000\u082e\u0800\u0001\u0000\u0000\u0000\u082e\u0805\u0001\u0000"+
		"\u0000\u0000\u082e\u0806\u0001\u0000\u0000\u0000\u082e\u0807\u0001\u0000"+
		"\u0000\u0000\u082e\u0808\u0001\u0000\u0000\u0000\u082e\u0809\u0001\u0000"+
		"\u0000\u0000\u082e\u080a\u0001\u0000\u0000\u0000\u082e\u080b\u0001\u0000"+
		"\u0000\u0000\u082e\u080c\u0001\u0000\u0000\u0000\u082e\u080d\u0001\u0000"+
		"\u0000\u0000\u082e\u080e\u0001\u0000\u0000\u0000\u082e\u080f\u0001\u0000"+
		"\u0000\u0000\u082e\u0810\u0001\u0000\u0000\u0000\u082e\u0811\u0001\u0000"+
		"\u0000\u0000\u082e\u0812\u0001\u0000\u0000\u0000\u082e\u0813\u0001\u0000"+
		"\u0000\u0000\u082e\u0814\u0001\u0000\u0000\u0000\u082e\u0815\u0001\u0000"+
		"\u0000\u0000\u082e\u0816\u0001\u0000\u0000\u0000\u082e\u0817\u0001\u0000"+
		"\u0000\u0000\u082e\u0818\u0001\u0000\u0000\u0000\u082e\u0819\u0001\u0000"+
		"\u0000\u0000\u082e\u081a\u0001\u0000\u0000\u0000\u082e\u081c\u0001\u0000"+
		"\u0000\u0000\u082e\u081e\u0001\u0000\u0000\u0000\u082e\u081f\u0001\u0000"+
		"\u0000\u0000\u082e\u0820\u0001\u0000\u0000\u0000\u082e\u0821\u0001\u0000"+
		"\u0000\u0000\u082e\u0822\u0001\u0000\u0000\u0000\u082e\u0823\u0001\u0000"+
		"\u0000\u0000\u082e\u0824\u0001\u0000\u0000\u0000\u082e\u0825\u0001\u0000"+
		"\u0000\u0000\u082e\u0826\u0001\u0000\u0000\u0000\u082e\u0827\u0001\u0000"+
		"\u0000\u0000\u082e\u0828\u0001\u0000\u0000\u0000\u082e\u0829\u0001\u0000"+
		"\u0000\u0000\u082e\u082a\u0001\u0000\u0000\u0000\u082e\u082c\u0001\u0000"+
		"\u0000\u0000\u082f\u017f\u0001\u0000\u0000\u0000\u0830\u0831\u0007\u0017"+
		"\u0000\u0000\u0831\u0181\u0001\u0000\u0000\u0000\u0128\u0185\u0187\u0193"+
		"\u0198\u01a1\u01a5\u01ae\u01b1\u01b5\u01bd\u01c4\u01c7\u01cc\u01d1\u01d7"+
		"\u01df\u01e1\u01ea\u01ee\u01f2\u01f5\u01f9\u01fc\u0203\u0207\u020a\u020d"+
		"\u0210\u0216\u021a\u021e\u022c\u0230\u0236\u023d\u0243\u0247\u024b\u024d"+
		"\u0255\u025a\u0267\u026e\u027a\u0284\u0289\u028d\u0294\u0297\u029f\u02a3"+
		"\u02a6\u02ad\u02b4\u02b8\u02bd\u02c1\u02c4\u02c9\u02d8\u02df\u02e7\u02ef"+
		"\u02f8\u02ff\u0306\u030e\u0316\u031e\u0326\u032e\u0336\u033f\u0347\u0350"+
		"\u0358\u0360\u0362\u0365\u036b\u0371\u0377\u037e\u0387\u038f\u0393\u039a"+
		"\u039c\u03b0\u03b4\u03ba\u03bf\u03c3\u03c6\u03cd\u03d4\u03d8\u03e1\u03ec"+
		"\u03f6\u03fb\u0402\u0405\u040a\u040f\u0424\u0429\u042c\u0437\u043d\u0442"+
		"\u0445\u044a\u044d\u0454\u046b\u0471\u0477\u047d\u0480\u0486\u048a\u048e"+
		"\u0491\u0499\u049b\u04a1\u04a4\u04a7\u04aa\u04ae\u04b2\u04b8\u04c2\u04c8"+
		"\u04ce\u04d3\u04d8\u04dc\u04e9\u04ef\u04f3\u04f9\u04fe\u050d\u0511\u0516"+
		"\u051b\u0520\u0526\u0529\u0532\u0536\u053b\u053f\u0545\u054c\u055d\u055f"+
		"\u0566\u056b\u0572\u0576\u057a\u0582\u0588\u058e\u0592\u0594\u0598\u059d"+
		"\u05a1\u05a4\u05a7\u05aa\u05af\u05b3\u05b6\u05ba\u05bd\u05bf\u05c4\u05cb"+
		"\u05d1\u05d5\u05db\u05e1\u05e4\u05e6\u05ec\u05f0\u05f6\u05fd\u0601\u0603"+
		"\u0607\u060d\u0619\u061d\u061f\u0623\u0628\u062b\u0632\u0636\u063b\u063d"+
		"\u0641\u0644\u0647\u064b\u0650\u0657\u065e\u0663\u0667\u066b\u0670\u0674"+
		"\u067a\u067c\u0682\u0687\u068d\u0691\u0693\u0696\u069a\u069e\u06a0\u06a2"+
		"\u06a5\u06b1\u06b3\u06b6\u06b9\u06bc\u06c5\u06cc\u06d8\u06dc\u06df\u06e3"+
		"\u06e8\u06f4\u06f9\u06fd\u0701\u0706\u070b\u070f\u0712\u0716\u0721\u0725"+
		"\u072c\u0731\u0735\u073b\u073f\u0743\u074c\u0759\u075e\u0765\u0769\u076c"+
		"\u076f\u0772\u0776\u077b\u0782\u0786\u078a\u0790\u0795\u0799\u079f\u07a5"+
		"\u07a8\u07ab\u07bb\u07c3\u07cc\u07d1\u07d4\u07d8\u07dc\u07e1\u07e7\u07ec"+
		"\u07f0\u07f9\u07fe\u0803\u082e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}