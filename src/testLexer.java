// Generated from C:/Users/lhr4108/Desktop/untitled1/src\test.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class testLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		END=1, IDENT=2, LPar=3, RPar=4, FUNCTYPE=5, LBrace=6, RBrace=7, RETURN=8, 
		Semicolon=9, Nonzerodigit=10, Octaldigit=11, Hexadecimaldigit=12, Hexadecimalprefix=13, 
		SL_COMMENT=14, SL_COMMENT_1=15, UnaryOp=16, UnaryOp_1=17, WHITE_SPACE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"END", "IDENT", "LPar", "RPar", "FUNCTYPE", "LBrace", "RBrace", "RETURN", 
			"Semicolon", "Nonzerodigit", "Octaldigit", "Hexadecimaldigit", "Hexadecimalprefix", 
			"SL_COMMENT", "SL_COMMENT_1", "UnaryOp", "UnaryOp_1", "WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'hello'", "'main'", "'('", "')'", "'int'", "'{'", "'}'", "'return'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "END", "IDENT", "LPar", "RPar", "FUNCTYPE", "LBrace", "RBrace", 
			"RETURN", "Semicolon", "Nonzerodigit", "Octaldigit", "Hexadecimaldigit", 
			"Hexadecimalprefix", "SL_COMMENT", "SL_COMMENT_1", "UnaryOp", "UnaryOp_1", 
			"WHITE_SPACE"
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


	public testLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "test.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u008b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\7\13J\n\13\f\13\16\13M\13\13\3\13\5\13P\n\13\3\f\3\f\6"+
		"\fT\n\f\r\f\16\fU\3\r\6\rY\n\r\r\r\16\rZ\3\16\3\16\3\16\3\16\5\16a\n\16"+
		"\3\16\6\16d\n\16\r\16\16\16e\3\17\3\17\3\17\3\17\7\17l\n\17\f\17\16\17"+
		"o\13\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20z\n\20\f\20\16"+
		"\20}\13\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\4m{\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\3\2\n\3\2\63;\3\2\62;\3\2\62\62\3\2\62"+
		"9\5\2\62;CHch\4\2--//\5\2\'\',,\61\61\4\2\13\f\"\"\2\u0093\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\3\'\3\2\2\2\5-\3\2\2\2\7\62\3\2\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r:\3"+
		"\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23E\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31"+
		"X\3\2\2\2\33`\3\2\2\2\35g\3\2\2\2\37t\3\2\2\2!\u0083\3\2\2\2#\u0085\3"+
		"\2\2\2%\u0087\3\2\2\2\'(\7j\2\2()\7g\2\2)*\7n\2\2*+\7n\2\2+,\7q\2\2,\4"+
		"\3\2\2\2-.\7o\2\2./\7c\2\2/\60\7k\2\2\60\61\7p\2\2\61\6\3\2\2\2\62\63"+
		"\7*\2\2\63\b\3\2\2\2\64\65\7+\2\2\65\n\3\2\2\2\66\67\7k\2\2\678\7p\2\2"+
		"89\7v\2\29\f\3\2\2\2:;\7}\2\2;\16\3\2\2\2<=\7\177\2\2=\20\3\2\2\2>?\7"+
		"t\2\2?@\7g\2\2@A\7v\2\2AB\7w\2\2BC\7t\2\2CD\7p\2\2D\22\3\2\2\2EF\7=\2"+
		"\2F\24\3\2\2\2GK\t\2\2\2HJ\t\3\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2"+
		"\2\2LP\3\2\2\2MK\3\2\2\2NP\t\4\2\2OG\3\2\2\2ON\3\2\2\2P\26\3\2\2\2QS\t"+
		"\4\2\2RT\t\5\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\30\3\2\2\2W"+
		"Y\t\6\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\32\3\2\2\2\\]\7\62"+
		"\2\2]a\7z\2\2^_\7\62\2\2_a\7Z\2\2`\\\3\2\2\2`^\3\2\2\2ac\3\2\2\2bd\t\6"+
		"\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\34\3\2\2\2gh\7\61\2\2hi"+
		"\7\61\2\2im\3\2\2\2jl\13\2\2\2kj\3\2\2\2lo\3\2\2\2mn\3\2\2\2mk\3\2\2\2"+
		"np\3\2\2\2om\3\2\2\2pq\7\f\2\2qr\3\2\2\2rs\b\17\2\2s\36\3\2\2\2tu\7\61"+
		"\2\2uv\7,\2\2v{\3\2\2\2wz\13\2\2\2xz\7\f\2\2yw\3\2\2\2yx\3\2\2\2z}\3\2"+
		"\2\2{|\3\2\2\2{y\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7,\2\2\177\u0080\7\61"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\20\2\2\u0082 \3\2\2\2\u0083\u0084"+
		"\t\7\2\2\u0084\"\3\2\2\2\u0085\u0086\t\b\2\2\u0086$\3\2\2\2\u0087\u0088"+
		"\t\t\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\23\2\2\u008a&\3\2\2\2\f\2K"+
		"OUZ`emy{\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}