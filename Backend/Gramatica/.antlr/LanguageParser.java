// Generated from /home/manuelimal02/Documentos/Compiladores 2/OLC2_Proyecto1_202201524/Backend/Gramatica/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TIPO=13, ENTERO=14, DECIMAL=15, CADENA=16, 
		BOOLEANO=17, CARACTER=18, IDENTIFICADOR=19, WS=20, COMENTARIO=21, COMENTARIOL=22, 
		COMENTARIOLN=23;
	public static final int
		RULE_program = 0, RULE_declaraciones = 1, RULE_declaracion_variable = 2, 
		RULE_sentencia = 3, RULE_expresion = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaraciones", "declaracion_variable", "sentencia", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'fmt.Println('", "','", "')'", 
			"'-'", "'*'", "'/'", "'+'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TIPO", "ENTERO", "DECIMAL", "CADENA", "BOOLEANO", "CARACTER", 
			"IDENTIFICADOR", "WS", "COMENTARIO", "COMENTARIOL", "COMENTARIOLN"
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclaracionesContext> declaraciones() {
			return getRuleContexts(DeclaracionesContext.class);
		}
		public DeclaracionesContext declaraciones(int i) {
			return getRuleContext(DeclaracionesContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1036578L) != 0)) {
				{
				{
				setState(10);
				declaraciones();
				}
				}
				setState(15);
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
	public static class DeclaracionesContext extends ParserRuleContext {
		public Declaracion_variableContext declaracion_variable() {
			return getRuleContext(Declaracion_variableContext.class,0);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public DeclaracionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraciones; }
	}

	public final DeclaracionesContext declaraciones() throws RecognitionException {
		DeclaracionesContext _localctx = new DeclaracionesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaraciones);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				declaracion_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				sentencia();
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
	public static class Declaracion_variableContext extends ParserRuleContext {
		public Declaracion_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_variable; }
	 
		public Declaracion_variableContext() { }
		public void copyFrom(Declaracion_variableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionPorDefectoContext extends Declaracion_variableContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public DeclaracionPorDefectoContext(Declaracion_variableContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionExplicitaContext extends Declaracion_variableContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionExplicitaContext(Declaracion_variableContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionImplicitaContext extends Declaracion_variableContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionImplicitaContext(Declaracion_variableContext ctx) { copyFrom(ctx); }
	}

	public final Declaracion_variableContext declaracion_variable() throws RecognitionException {
		Declaracion_variableContext _localctx = new Declaracion_variableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracion_variable);
		int _la;
		try {
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(T__0);
				setState(21);
				match(IDENTIFICADOR);
				setState(22);
				match(TIPO);
				setState(23);
				match(T__1);
				setState(24);
				expresion(0);
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(25);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__0);
				setState(29);
				match(IDENTIFICADOR);
				setState(30);
				match(TIPO);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(31);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(IDENTIFICADOR);
				setState(35);
				match(T__3);
				setState(36);
				expresion(0);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(37);
					match(T__2);
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
	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprStmtContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaPrintlnContext extends SentenciaContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public FuncionEmbebidaPrintlnContext(SentenciaContext ctx) { copyFrom(ctx); }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentencia);
		int _la;
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__11:
			case ENTERO:
			case DECIMAL:
			case CADENA:
			case BOOLEANO:
			case CARACTER:
			case IDENTIFICADOR:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				expresion(0);
				setState(43);
				match(T__2);
				}
				break;
			case T__4:
				_localctx = new FuncionEmbebidaPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__4);
				setState(46);
				expresion(0);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(47);
					match(T__5);
					setState(48);
					expresion(0);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(T__6);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(55);
					match(T__2);
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
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaracterContext extends ExpresionContext {
		public TerminalNode CARACTER() { return getToken(LanguageParser.CARACTER, 0); }
		public CaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(LanguageParser.DECIMAL, 0); }
		public DecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnteroContext extends ExpresionContext {
		public TerminalNode ENTERO() { return getToken(LanguageParser.ENTERO, 0); }
		public EnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public MulDivContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AddSubContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesisContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ParentesisContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CadenaContext extends ExpresionContext {
		public TerminalNode CADENA() { return getToken(LanguageParser.CADENA, 0); }
		public CadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RestaUnariaContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public RestaUnariaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanoContext extends ExpresionContext {
		public TerminalNode BOOLEANO() { return getToken(LanguageParser.BOOLEANO, 0); }
		public BooleanoContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public IdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				_localctx = new RestaUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(61);
				match(T__7);
				setState(62);
				expresion(10);
				}
				break;
			case BOOLEANO:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(BOOLEANO);
				}
				break;
			case DECIMAL:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				match(DECIMAL);
				}
				break;
			case CARACTER:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(CARACTER);
				}
				break;
			case CADENA:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(CADENA);
				}
				break;
			case ENTERO:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(ENTERO);
				}
				break;
			case IDENTIFICADOR:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(IDENTIFICADOR);
				}
				break;
			case T__11:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(T__11);
				setState(70);
				expresion(0);
				setState(71);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(75);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(76);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(77);
						expresion(10);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(78);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(79);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__10) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						expresion(9);
						}
						break;
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017W\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0013\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u001b\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002!\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0003\u0002"+
		")\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u00032\b\u0003\n\u0003\f\u00035\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u00039\b\u0003\u0003\u0003;\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004J\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004R\b\u0004\n\u0004\f\u0004U\t"+
		"\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000\u0002\u0004\u0006\b\u0000"+
		"\u0002\u0001\u0000\t\n\u0002\u0000\b\b\u000b\u000bd\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000"+
		"\u0000\u0006:\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\n\f\u0003"+
		"\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000\f\u000f\u0001\u0000"+
		"\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000"+
		"\u0000\u000e\u0001\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000"+
		"\u0010\u0013\u0003\u0004\u0002\u0000\u0011\u0013\u0003\u0006\u0003\u0000"+
		"\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0011\u0001\u0000\u0000\u0000"+
		"\u0013\u0003\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0001\u0000\u0000"+
		"\u0015\u0016\u0005\u0013\u0000\u0000\u0016\u0017\u0005\r\u0000\u0000\u0017"+
		"\u0018\u0005\u0002\u0000\u0000\u0018\u001a\u0003\b\u0004\u0000\u0019\u001b"+
		"\u0005\u0003\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b)\u0001\u0000\u0000\u0000\u001c\u001d\u0005"+
		"\u0001\u0000\u0000\u001d\u001e\u0005\u0013\u0000\u0000\u001e \u0005\r"+
		"\u0000\u0000\u001f!\u0005\u0003\u0000\u0000 \u001f\u0001\u0000\u0000\u0000"+
		" !\u0001\u0000\u0000\u0000!)\u0001\u0000\u0000\u0000\"#\u0005\u0013\u0000"+
		"\u0000#$\u0005\u0004\u0000\u0000$&\u0003\b\u0004\u0000%\'\u0005\u0003"+
		"\u0000\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001"+
		"\u0000\u0000\u0000(\u0014\u0001\u0000\u0000\u0000(\u001c\u0001\u0000\u0000"+
		"\u0000(\"\u0001\u0000\u0000\u0000)\u0005\u0001\u0000\u0000\u0000*+\u0003"+
		"\b\u0004\u0000+,\u0005\u0003\u0000\u0000,;\u0001\u0000\u0000\u0000-.\u0005"+
		"\u0005\u0000\u0000.3\u0003\b\u0004\u0000/0\u0005\u0006\u0000\u000002\u0003"+
		"\b\u0004\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000068\u0005\u0007\u0000\u000079\u0005\u0003\u0000"+
		"\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000"+
		"\u0000\u0000:*\u0001\u0000\u0000\u0000:-\u0001\u0000\u0000\u0000;\u0007"+
		"\u0001\u0000\u0000\u0000<=\u0006\u0004\uffff\uffff\u0000=>\u0005\b\u0000"+
		"\u0000>J\u0003\b\u0004\n?J\u0005\u0011\u0000\u0000@J\u0005\u000f\u0000"+
		"\u0000AJ\u0005\u0012\u0000\u0000BJ\u0005\u0010\u0000\u0000CJ\u0005\u000e"+
		"\u0000\u0000DJ\u0005\u0013\u0000\u0000EF\u0005\f\u0000\u0000FG\u0003\b"+
		"\u0004\u0000GH\u0005\u0007\u0000\u0000HJ\u0001\u0000\u0000\u0000I<\u0001"+
		"\u0000\u0000\u0000I?\u0001\u0000\u0000\u0000I@\u0001\u0000\u0000\u0000"+
		"IA\u0001\u0000\u0000\u0000IB\u0001\u0000\u0000\u0000IC\u0001\u0000\u0000"+
		"\u0000ID\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000JS\u0001\u0000"+
		"\u0000\u0000KL\n\t\u0000\u0000LM\u0007\u0000\u0000\u0000MR\u0003\b\u0004"+
		"\nNO\n\b\u0000\u0000OP\u0007\u0001\u0000\u0000PR\u0003\b\u0004\tQK\u0001"+
		"\u0000\u0000\u0000QN\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\t\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000\f\r\u0012\u001a &(38:IQS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}