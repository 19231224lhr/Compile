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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\7\13J\n\13\f\13\16\13M\13\13\3\f\3\f\6\fQ\n\f\r\f\16\f"+
		"R\3\r\6\rV\n\r\r\r\16\rW\3\16\3\16\3\16\3\16\5\16^\n\16\3\16\6\16a\n\16"+
		"\r\16\16\16b\3\17\3\17\3\17\3\17\7\17i\n\17\f\17\16\17l\13\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20w\n\20\f\20\16\20z\13\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\4jx\2\24"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\3\2\n\3\2\63;\3\2\62;\3\2\62\62\3\2\629\5\2\62;CHc"+
		"h\4\2--//\5\2\'\',,\61\61\4\2\13\f\"\"\2\u008f\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2"+
		"\2\2\5-\3\2\2\2\7\62\3\2\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r:\3\2\2\2\17"+
		"<\3\2\2\2\21>\3\2\2\2\23E\3\2\2\2\25G\3\2\2\2\27N\3\2\2\2\31U\3\2\2\2"+
		"\33]\3\2\2\2\35d\3\2\2\2\37q\3\2\2\2!\u0080\3\2\2\2#\u0082\3\2\2\2%\u0084"+
		"\3\2\2\2\'(\7j\2\2()\7g\2\2)*\7n\2\2*+\7n\2\2+,\7q\2\2,\4\3\2\2\2-.\7"+
		"o\2\2./\7c\2\2/\60\7k\2\2\60\61\7p\2\2\61\6\3\2\2\2\62\63\7*\2\2\63\b"+
		"\3\2\2\2\64\65\7+\2\2\65\n\3\2\2\2\66\67\7k\2\2\678\7p\2\289\7v\2\29\f"+
		"\3\2\2\2:;\7}\2\2;\16\3\2\2\2<=\7\177\2\2=\20\3\2\2\2>?\7t\2\2?@\7g\2"+
		"\2@A\7v\2\2AB\7w\2\2BC\7t\2\2CD\7p\2\2D\22\3\2\2\2EF\7=\2\2F\24\3\2\2"+
		"\2GK\t\2\2\2HJ\t\3\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\26\3\2"+
		"\2\2MK\3\2\2\2NP\t\4\2\2OQ\t\5\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2"+
		"\2\2S\30\3\2\2\2TV\t\6\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\32"+
		"\3\2\2\2YZ\7\62\2\2Z^\7z\2\2[\\\7\62\2\2\\^\7Z\2\2]Y\3\2\2\2][\3\2\2\2"+
		"^`\3\2\2\2_a\t\6\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\34\3\2\2"+
		"\2de\7\61\2\2ef\7\61\2\2fj\3\2\2\2gi\13\2\2\2hg\3\2\2\2il\3\2\2\2jk\3"+
		"\2\2\2jh\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\f\2\2no\3\2\2\2op\b\17\2\2p\36"+
		"\3\2\2\2qr\7\61\2\2rs\7,\2\2sx\3\2\2\2tw\13\2\2\2uw\7\f\2\2vt\3\2\2\2"+
		"vu\3\2\2\2wz\3\2\2\2xy\3\2\2\2xv\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7,\2\2"+
		"|}\7\61\2\2}~\3\2\2\2~\177\b\20\2\2\177 \3\2\2\2\u0080\u0081\t\7\2\2\u0081"+
		"\"\3\2\2\2\u0082\u0083\t\b\2\2\u0083$\3\2\2\2\u0084\u0085\t\t\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\b\23\2\2\u0087&\3\2\2\2\13\2KRW]bjvx\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}