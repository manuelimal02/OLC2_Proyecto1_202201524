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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, TIPO=15, ENTERO=16, DECIMAL=17, 
		CADENA=18, BOOLEANO=19, CARACTER=20, IDENTIFICADOR=21, WS=22, COMENTARIOL=23, 
		COMENTARIOLN=24;
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
			"'{'", "'}'", "'-'", "'*'", "'/'", "'+'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TIPO", "ENTERO", "DECIMAL", "CADENA", "BOOLEANO", 
			"CARACTER", "IDENTIFICADOR", "WS", "COMENTARIOL", "COMENTARIOLN"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4146466L) != 0)) {
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
	public static class BloqueContext extends SentenciaContext {
		public List<DeclaracionesContext> declaraciones() {
			return getRuleContexts(DeclaracionesContext.class);
		}
		public DeclaracionesContext declaraciones(int i) {
			return getRuleContext(DeclaracionesContext.class,i);
		}
		public BloqueContext(SentenciaContext ctx) { copyFrom(ctx); }
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__13:
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
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(43);
					match(T__2);
					}
				}

				}
				break;
			case T__4:
				_localctx = new FuncionEmbebidaPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(T__4);
				setState(47);
				expresion(0);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(48);
					match(T__5);
					setState(49);
					expresion(0);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(T__6);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(56);
					match(T__2);
					}
				}

				}
				break;
			case T__7:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__7);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4146466L) != 0)) {
					{
					{
					setState(60);
					declaraciones();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				match(T__8);
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
	public static class MultiplicacionDivisionContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public MultiplicacionDivisionContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class SumaRestaContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SumaRestaContext(ExpresionContext ctx) { copyFrom(ctx); }
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				_localctx = new RestaUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70);
				match(T__9);
				setState(71);
				expresion(10);
				}
				break;
			case BOOLEANO:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(BOOLEANO);
				}
				break;
			case DECIMAL:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(DECIMAL);
				}
				break;
			case CARACTER:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(CARACTER);
				}
				break;
			case CADENA:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(CADENA);
				}
				break;
			case ENTERO:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(ENTERO);
				}
				break;
			case IDENTIFICADOR:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(IDENTIFICADOR);
				}
				break;
			case T__13:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(T__13);
				setState(79);
				expresion(0);
				setState(80);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(90);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionDivisionContext(new ExpresionContext(_parentctx, _parentState));
						((MultiplicacionDivisionContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(84);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(85);
						((MultiplicacionDivisionContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((MultiplicacionDivisionContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(86);
						((MultiplicacionDivisionContext)_localctx).derecha = expresion(10);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						((SumaRestaContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(87);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(88);
						((SumaRestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__12) ) {
							((SumaRestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(89);
						((SumaRestaContext)_localctx).derecha = expresion(9);
						}
						break;
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		"\u0004\u0001\u0018`\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0013\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u001b\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002!\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0003\u0002"+
		")\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003-\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u00033\b\u0003\n\u0003\f\u00036\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003:\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003>\b\u0003\n\u0003\f\u0003A\t\u0003\u0001\u0003\u0003"+
		"\u0003D\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004S\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004[\b"+
		"\u0004\n\u0004\f\u0004^\t\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000"+
		"\u0002\u0004\u0006\b\u0000\u0002\u0001\u0000\u000b\f\u0002\u0000\n\n\r"+
		"\rp\u0000\r\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000"+
		"\u0004(\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bR\u0001"+
		"\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000"+
		"\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000"+
		"\r\u000e\u0001\u0000\u0000\u0000\u000e\u0001\u0001\u0000\u0000\u0000\u000f"+
		"\r\u0001\u0000\u0000\u0000\u0010\u0013\u0003\u0004\u0002\u0000\u0011\u0013"+
		"\u0003\u0006\u0003\u0000\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0011"+
		"\u0001\u0000\u0000\u0000\u0013\u0003\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0005\u0001\u0000\u0000\u0015\u0016\u0005\u0015\u0000\u0000\u0016\u0017"+
		"\u0005\u000f\u0000\u0000\u0017\u0018\u0005\u0002\u0000\u0000\u0018\u001a"+
		"\u0003\b\u0004\u0000\u0019\u001b\u0005\u0003\u0000\u0000\u001a\u0019\u0001"+
		"\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b)\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0005\u0001\u0000\u0000\u001d\u001e\u0005\u0015"+
		"\u0000\u0000\u001e \u0005\u000f\u0000\u0000\u001f!\u0005\u0003\u0000\u0000"+
		" \u001f\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!)\u0001\u0000"+
		"\u0000\u0000\"#\u0005\u0015\u0000\u0000#$\u0005\u0004\u0000\u0000$&\u0003"+
		"\b\u0004\u0000%\'\u0005\u0003\u0000\u0000&%\u0001\u0000\u0000\u0000&\'"+
		"\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(\u0014\u0001\u0000"+
		"\u0000\u0000(\u001c\u0001\u0000\u0000\u0000(\"\u0001\u0000\u0000\u0000"+
		")\u0005\u0001\u0000\u0000\u0000*,\u0003\b\u0004\u0000+-\u0005\u0003\u0000"+
		"\u0000,+\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-D\u0001\u0000"+
		"\u0000\u0000./\u0005\u0005\u0000\u0000/4\u0003\b\u0004\u000001\u0005\u0006"+
		"\u0000\u000013\u0003\b\u0004\u000020\u0001\u0000\u0000\u000036\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000079\u0005\u0007\u0000\u0000"+
		"8:\u0005\u0003\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:D\u0001\u0000\u0000\u0000;?\u0005\b\u0000\u0000<>\u0003\u0002\u0001"+
		"\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000BD\u0005\t\u0000\u0000C*\u0001\u0000\u0000\u0000C.\u0001"+
		"\u0000\u0000\u0000C;\u0001\u0000\u0000\u0000D\u0007\u0001\u0000\u0000"+
		"\u0000EF\u0006\u0004\uffff\uffff\u0000FG\u0005\n\u0000\u0000GS\u0003\b"+
		"\u0004\nHS\u0005\u0013\u0000\u0000IS\u0005\u0011\u0000\u0000JS\u0005\u0014"+
		"\u0000\u0000KS\u0005\u0012\u0000\u0000LS\u0005\u0010\u0000\u0000MS\u0005"+
		"\u0015\u0000\u0000NO\u0005\u000e\u0000\u0000OP\u0003\b\u0004\u0000PQ\u0005"+
		"\u0007\u0000\u0000QS\u0001\u0000\u0000\u0000RE\u0001\u0000\u0000\u0000"+
		"RH\u0001\u0000\u0000\u0000RI\u0001\u0000\u0000\u0000RJ\u0001\u0000\u0000"+
		"\u0000RK\u0001\u0000\u0000\u0000RL\u0001\u0000\u0000\u0000RM\u0001\u0000"+
		"\u0000\u0000RN\u0001\u0000\u0000\u0000S\\\u0001\u0000\u0000\u0000TU\n"+
		"\t\u0000\u0000UV\u0007\u0000\u0000\u0000V[\u0003\b\u0004\nWX\n\b\u0000"+
		"\u0000XY\u0007\u0001\u0000\u0000Y[\u0003\b\u0004\tZT\u0001\u0000\u0000"+
		"\u0000ZW\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]\t\u0001\u0000\u0000\u0000^\\"+
		"\u0001\u0000\u0000\u0000\u000e\r\u0012\u001a &(,49?CRZ\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}