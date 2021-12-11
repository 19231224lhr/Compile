// Generated from C:/Users/lhr4108/Desktop/大三上学习资料/编译原理/Test\Compile.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CompileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONST_KW=1, INT_KW=2, VOID_KW=3, IF_KW=4, ELSE_KW=5, WHILE_KW=6, BREAK_KW=7, 
		CONTINUE_KW=8, RETURN_KW=9, STRING=10, PLUS=11, MINUS=12, NOT=13, MUL=14, 
		DIV=15, MOD=16, ASSIGN=17, EQ=18, NEQ=19, LT=20, GT=21, LE=22, GE=23, 
		AND=24, OR=25, L_PAREN=26, R_PAREN=27, L_BRACE=28, R_BRACE=29, L_BRACKT=30, 
		R_BRACKT=31, COMMA=32, SEMICOLON=33, DOUBLE_QUOTE=34, IDENT=35, DECIMAL_CONST=36, 
		OCTAL_CONST=37, HEXADECIMAL_CONST=38, WS=39, LINE_COMMENT=40, MULTILINE_COMMENT=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CONST_KW", "INT_KW", "VOID_KW", "IF_KW", "ELSE_KW", "WHILE_KW", "BREAK_KW", 
			"CONTINUE_KW", "RETURN_KW", "STRING", "REGULAR_CHAR", "ESC", "PLUS", 
			"MINUS", "NOT", "MUL", "DIV", "MOD", "ASSIGN", "EQ", "NEQ", "LT", "GT", 
			"LE", "GE", "AND", "OR", "L_PAREN", "R_PAREN", "L_BRACE", "R_BRACE", 
			"L_BRACKT", "R_BRACKT", "COMMA", "SEMICOLON", "DOUBLE_QUOTE", "IDENT", 
			"DECIMAL_CONST", "OCTAL_CONST", "HEXADECIMAL_CONST", "WS", "LINE_COMMENT", 
			"MULTILINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "'int'", "'void'", "'if'", "'else'", "'while'", "'break'", 
			"'continue'", "'return'", null, "'+'", "'-'", "'!'", "'*'", "'/'", "'%'", 
			"'='", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "','", "';'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONST_KW", "INT_KW", "VOID_KW", "IF_KW", "ELSE_KW", "WHILE_KW", 
			"BREAK_KW", "CONTINUE_KW", "RETURN_KW", "STRING", "PLUS", "MINUS", "NOT", 
			"MUL", "DIV", "MOD", "ASSIGN", "EQ", "NEQ", "LT", "GT", "LE", "GE", "AND", 
			"OR", "L_PAREN", "R_PAREN", "L_BRACE", "R_BRACE", "L_BRACKT", "R_BRACKT", 
			"COMMA", "SEMICOLON", "DOUBLE_QUOTE", "IDENT", "DECIMAL_CONST", "OCTAL_CONST", 
			"HEXADECIMAL_CONST", "WS", "LINE_COMMENT", "MULTILINE_COMMENT"
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


	public CompileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Compile.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\7\13\u008f\n\13\f\13\16\13\u0092\13\13\3\13\3\13\3\f\3\f\5\f"+
		"\u0098\n\f\3\r\3\r\3\r\3\r\5\r\u009e\n\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\7&\u00d8\n&\f&\16&\u00db\13&\3\'\3\'\3\'\6\'\u00e0\n\'"+
		"\r\'\16\'\u00e1\5\'\u00e4\n\'\3(\3(\3(\6(\u00e9\n(\r(\16(\u00ea\5(\u00ed"+
		"\n(\3)\3)\3)\3)\5)\u00f3\n)\3)\6)\u00f6\n)\r)\16)\u00f7\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\7+\u0102\n+\f+\16+\u0105\13+\3+\3+\3,\3,\3,\3,\7,\u010d\n,"+
		"\f,\16,\u0110\13,\3,\3,\3,\3,\3,\4\u0090\u010e\2-\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%"+
		"M&O\'Q(S)U*W+\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2\629"+
		"\5\2\62;CHch\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u011f\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5_\3\2\2\2"+
		"\7c\3\2\2\2\th\3\2\2\2\13k\3\2\2\2\rp\3\2\2\2\17v\3\2\2\2\21|\3\2\2\2"+
		"\23\u0085\3\2\2\2\25\u008c\3\2\2\2\27\u0097\3\2\2\2\31\u009d\3\2\2\2\33"+
		"\u009f\3\2\2\2\35\u00a1\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2\2#\u00a7"+
		"\3\2\2\2%\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00ad\3\2\2\2+\u00b0\3\2\2\2"+
		"-\u00b3\3\2\2\2/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63\u00ba\3\2\2\2\65\u00bd"+
		"\3\2\2\2\67\u00c0\3\2\2\29\u00c3\3\2\2\2;\u00c5\3\2\2\2=\u00c7\3\2\2\2"+
		"?\u00c9\3\2\2\2A\u00cb\3\2\2\2C\u00cd\3\2\2\2E\u00cf\3\2\2\2G\u00d1\3"+
		"\2\2\2I\u00d3\3\2\2\2K\u00d5\3\2\2\2M\u00e3\3\2\2\2O\u00ec\3\2\2\2Q\u00f2"+
		"\3\2\2\2S\u00f9\3\2\2\2U\u00fd\3\2\2\2W\u0108\3\2\2\2YZ\7e\2\2Z[\7q\2"+
		"\2[\\\7p\2\2\\]\7u\2\2]^\7v\2\2^\4\3\2\2\2_`\7k\2\2`a\7p\2\2ab\7v\2\2"+
		"b\6\3\2\2\2cd\7x\2\2de\7q\2\2ef\7k\2\2fg\7f\2\2g\b\3\2\2\2hi\7k\2\2ij"+
		"\7h\2\2j\n\3\2\2\2kl\7g\2\2lm\7n\2\2mn\7u\2\2no\7g\2\2o\f\3\2\2\2pq\7"+
		"y\2\2qr\7j\2\2rs\7k\2\2st\7n\2\2tu\7g\2\2u\16\3\2\2\2vw\7d\2\2wx\7t\2"+
		"\2xy\7g\2\2yz\7c\2\2z{\7m\2\2{\20\3\2\2\2|}\7e\2\2}~\7q\2\2~\177\7p\2"+
		"\2\177\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083"+
		"\7w\2\2\u0083\u0084\7g\2\2\u0084\22\3\2\2\2\u0085\u0086\7t\2\2\u0086\u0087"+
		"\7g\2\2\u0087\u0088\7v\2\2\u0088\u0089\7w\2\2\u0089\u008a\7t\2\2\u008a"+
		"\u008b\7p\2\2\u008b\24\3\2\2\2\u008c\u0090\5I%\2\u008d\u008f\5\27\f\2"+
		"\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u0091\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\5I%\2\u0094"+
		"\26\3\2\2\2\u0095\u0098\5\31\r\2\u0096\u0098\13\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0096\3\2\2\2\u0098\30\3\2\2\2\u0099\u009a\7^\2\2\u009a\u009e"+
		"\7$\2\2\u009b\u009c\7^\2\2\u009c\u009e\7^\2\2\u009d\u0099\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\32\3\2\2\2\u009f\u00a0\7-\2\2\u00a0\34\3\2\2\2\u00a1"+
		"\u00a2\7/\2\2\u00a2\36\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4 \3\2\2\2\u00a5"+
		"\u00a6\7,\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8$\3\2\2\2\u00a9"+
		"\u00aa\7\'\2\2\u00aa&\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac(\3\2\2\2\u00ad"+
		"\u00ae\7?\2\2\u00ae\u00af\7?\2\2\u00af*\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1"+
		"\u00b2\7?\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4.\3\2\2\2\u00b5\u00b6"+
		"\7@\2\2\u00b6\60\3\2\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9\7?\2\2\u00b9\62"+
		"\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb\u00bc\7?\2\2\u00bc\64\3\2\2\2\u00bd"+
		"\u00be\7(\2\2\u00be\u00bf\7(\2\2\u00bf\66\3\2\2\2\u00c0\u00c1\7~\2\2\u00c1"+
		"\u00c2\7~\2\2\u00c28\3\2\2\2\u00c3\u00c4\7*\2\2\u00c4:\3\2\2\2\u00c5\u00c6"+
		"\7+\2\2\u00c6<\3\2\2\2\u00c7\u00c8\7}\2\2\u00c8>\3\2\2\2\u00c9\u00ca\7"+
		"\177\2\2\u00ca@\3\2\2\2\u00cb\u00cc\7]\2\2\u00ccB\3\2\2\2\u00cd\u00ce"+
		"\7_\2\2\u00ceD\3\2\2\2\u00cf\u00d0\7.\2\2\u00d0F\3\2\2\2\u00d1\u00d2\7"+
		"=\2\2\u00d2H\3\2\2\2\u00d3\u00d4\7$\2\2\u00d4J\3\2\2\2\u00d5\u00d9\t\2"+
		"\2\2\u00d6\u00d8\t\3\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00daL\3\2\2\2\u00db\u00d9\3\2\2\2"+
		"\u00dc\u00e4\t\4\2\2\u00dd\u00df\t\4\2\2\u00de\u00e0\t\5\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e3\u00dd\3\2\2\2\u00e4N\3\2\2\2"+
		"\u00e5\u00ed\7\62\2\2\u00e6\u00e8\7\62\2\2\u00e7\u00e9\t\6\2\2\u00e8\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ed\3\2\2\2\u00ec\u00e5\3\2\2\2\u00ec\u00e6\3\2\2\2\u00edP\3\2\2\2"+
		"\u00ee\u00ef\7\62\2\2\u00ef\u00f3\7z\2\2\u00f0\u00f1\7\62\2\2\u00f1\u00f3"+
		"\7Z\2\2\u00f2\u00ee\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4"+
		"\u00f6\t\7\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8R\3\2\2\2\u00f9\u00fa\t\b\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fc\b*\2\2\u00fcT\3\2\2\2\u00fd\u00fe\7\61\2\2\u00fe"+
		"\u00ff\7\61\2\2\u00ff\u0103\3\2\2\2\u0100\u0102\n\t\2\2\u0101\u0100\3"+
		"\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\b+\2\2\u0107V\3\2\2\2\u0108"+
		"\u0109\7\61\2\2\u0109\u010a\7,\2\2\u010a\u010e\3\2\2\2\u010b\u010d\13"+
		"\2\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010f\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7,"+
		"\2\2\u0112\u0113\7\61\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b,\2\2\u0115"+
		"X\3\2\2\2\17\2\u0090\u0097\u009d\u00d9\u00e1\u00e3\u00ea\u00ec\u00f2\u00f7"+
		"\u0103\u010e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}