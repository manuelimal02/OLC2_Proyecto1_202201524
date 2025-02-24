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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, TIPO=33, ENTERO=34, DECIMAL=35, CADENA=36, BOOLEANO=37, CARACTER=38, 
		IDENTIFICADOR=39, WS=40, COMENTARIOL=41, COMENTARIOLN=42;
	public static final int
		RULE_program = 0, RULE_declaraciones = 1, RULE_declaracion_variable = 2, 
		RULE_declaracion_arreglo = 3, RULE_sentencia = 4, RULE_expresion = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaraciones", "declaracion_variable", "declaracion_arreglo", 
			"sentencia", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'['", "']'", "'{'", "','", "'}'", 
			"'fmt.Println('", "')'", "'strconv.Atoi('", "'strconv.ParseFloat('", 
			"'reflect.TypeOf('", "'slices.Index('", "'-'", "'!'", "'*'", "'/'", "'%'", 
			"'+'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", 
			"'+='", "'-='", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TIPO", "ENTERO", 
			"DECIMAL", "CADENA", "BOOLEANO", "CARACTER", "IDENTIFICADOR", "WS", "COMENTARIOL", 
			"COMENTARIOLN"
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
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1086626985090L) != 0)) {
				{
				{
				setState(12);
				declaraciones();
				}
				}
				setState(17);
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
		public Declaracion_arregloContext declaracion_arreglo() {
			return getRuleContext(Declaracion_arregloContext.class,0);
		}
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
			setState(21);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				declaracion_arreglo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				declaracion_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
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
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(T__0);
				setState(24);
				match(IDENTIFICADOR);
				setState(25);
				match(TIPO);
				setState(26);
				match(T__1);
				setState(27);
				expresion(0);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(28);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__0);
				setState(32);
				match(IDENTIFICADOR);
				setState(33);
				match(TIPO);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(34);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(IDENTIFICADOR);
				setState(38);
				match(T__3);
				setState(39);
				expresion(0);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(40);
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
	public static class Declaracion_arregloContext extends ParserRuleContext {
		public Declaracion_arregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_arreglo; }
	 
		public Declaracion_arregloContext() { }
		public void copyFrom(Declaracion_arregloContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionArregloPorDefectoContext extends Declaracion_arregloContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public DeclaracionArregloPorDefectoContext(Declaracion_arregloContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionArregloExplicitaContext extends Declaracion_arregloContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public DeclaracionArregloExplicitaContext(Declaracion_arregloContext ctx) { copyFrom(ctx); }
	}

	public final Declaracion_arregloContext declaracion_arreglo() throws RecognitionException {
		Declaracion_arregloContext _localctx = new Declaracion_arregloContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion_arreglo);
		int _la;
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFICADOR:
				_localctx = new DeclaracionArregloExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(IDENTIFICADOR);
				setState(46);
				match(T__3);
				setState(47);
				match(T__4);
				setState(48);
				match(T__5);
				setState(49);
				match(TIPO);
				setState(50);
				match(T__6);
				{
				setState(51);
				expresion(0);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(52);
					match(T__7);
					setState(53);
					expresion(0);
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(59);
				match(T__8);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(60);
					match(T__2);
					}
				}

				}
				break;
			case T__0:
				_localctx = new DeclaracionArregloPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__0);
				setState(64);
				match(IDENTIFICADOR);
				setState(65);
				match(T__4);
				setState(66);
				match(T__5);
				setState(67);
				match(TIPO);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(68);
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
		enterRule(_localctx, 8, RULE_sentencia);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__31:
			case ENTERO:
			case DECIMAL:
			case CADENA:
			case BOOLEANO:
			case CARACTER:
			case IDENTIFICADOR:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				expresion(0);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(74);
					match(T__2);
					}
				}

				}
				break;
			case T__9:
				_localctx = new FuncionEmbebidaPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__9);
				setState(78);
				expresion(0);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(79);
					match(T__7);
					setState(80);
					expresion(0);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(T__10);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(87);
					match(T__2);
					}
				}

				}
				break;
			case T__6:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__6);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1086626985090L) != 0)) {
					{
					{
					setState(91);
					declaraciones();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
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
	public static class AsignacionVariableContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AsignacionVariableContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IgualdadDesigualdadContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public IgualdadDesigualdadContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionVariableRestaContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AsignacionVariableRestaContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class BooleanoContext extends ExpresionContext {
		public TerminalNode BOOLEANO() { return getToken(LanguageParser.BOOLEANO, 0); }
		public BooleanoContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaSlicesIndexContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaSlicesIndexContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegacionUnariaContext extends ExpresionContext {
		public Token operador;
		public ExpresionContext izquierda;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public NegacionUnariaContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class LogicoAndContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public LogicoAndContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionVariableSumaContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AsignacionVariableSumaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegacionLogicaContext extends ExpresionContext {
		public Token operador;
		public ExpresionContext izquierda;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public NegacionLogicaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaracterContext extends ExpresionContext {
		public TerminalNode CARACTER() { return getToken(LanguageParser.CARACTER, 0); }
		public CaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicoOrContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public LogicoOrContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaReflectTypeOfContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaReflectTypeOfContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(LanguageParser.DECIMAL, 0); }
		public DecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelacionalContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public RelacionalContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnteroContext extends ExpresionContext {
		public TerminalNode ENTERO() { return getToken(LanguageParser.ENTERO, 0); }
		public EnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaParseFloatContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaParseFloatContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaAtoiContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaAtoiContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public IdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicacionDivisionModuloContext extends ExpresionContext {
		public ExpresionContext izquierda;
		public Token operador;
		public ExpresionContext derecha;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public MultiplicacionDivisionModuloContext(ExpresionContext ctx) { copyFrom(ctx); }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new FuncionEmbebidaAtoiContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(101);
				match(T__11);
				setState(102);
				expresion(0);
				setState(103);
				match(T__10);
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(104);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 2:
				{
				_localctx = new FuncionEmbebidaParseFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(T__12);
				setState(108);
				expresion(0);
				setState(109);
				match(T__10);
				setState(111);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(110);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new FuncionEmbebidaReflectTypeOfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(T__13);
				setState(114);
				expresion(0);
				setState(115);
				match(T__10);
				setState(117);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(116);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new FuncionEmbebidaSlicesIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(T__14);
				setState(120);
				match(IDENTIFICADOR);
				setState(121);
				match(T__7);
				setState(122);
				expresion(0);
				setState(123);
				match(T__10);
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(124);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new NegacionUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				((NegacionUnariaContext)_localctx).operador = match(T__15);
				setState(128);
				((NegacionUnariaContext)_localctx).izquierda = expresion(18);
				}
				break;
			case 6:
				{
				_localctx = new NegacionLogicaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				((NegacionLogicaContext)_localctx).operador = match(T__16);
				setState(130);
				((NegacionLogicaContext)_localctx).izquierda = expresion(17);
				}
				break;
			case 7:
				{
				_localctx = new AsignacionVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(IDENTIFICADOR);
				setState(132);
				match(T__1);
				setState(133);
				expresion(10);
				}
				break;
			case 8:
				{
				_localctx = new AsignacionVariableSumaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(IDENTIFICADOR);
				setState(135);
				match(T__29);
				setState(136);
				expresion(9);
				}
				break;
			case 9:
				{
				_localctx = new AsignacionVariableRestaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(IDENTIFICADOR);
				setState(138);
				match(T__30);
				setState(139);
				expresion(8);
				}
				break;
			case 10:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(BOOLEANO);
				}
				break;
			case 11:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(DECIMAL);
				}
				break;
			case 12:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(CARACTER);
				}
				break;
			case 13:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(CADENA);
				}
				break;
			case 14:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(ENTERO);
				}
				break;
			case 15:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(IDENTIFICADOR);
				}
				break;
			case 16:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(T__31);
				setState(147);
				expresion(0);
				setState(148);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionDivisionModuloContext(new ExpresionContext(_parentctx, _parentState));
						((MultiplicacionDivisionModuloContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(152);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(153);
						((MultiplicacionDivisionModuloContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
							((MultiplicacionDivisionModuloContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						((MultiplicacionDivisionModuloContext)_localctx).derecha = expresion(17);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						((SumaRestaContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(155);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(156);
						((SumaRestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__20) ) {
							((SumaRestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						((SumaRestaContext)_localctx).derecha = expresion(16);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalContext(new ExpresionContext(_parentctx, _parentState));
						((RelacionalContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(158);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(159);
						((RelacionalContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
							((RelacionalContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						((RelacionalContext)_localctx).derecha = expresion(15);
						}
						break;
					case 4:
						{
						_localctx = new IgualdadDesigualdadContext(new ExpresionContext(_parentctx, _parentState));
						((IgualdadDesigualdadContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(161);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(162);
						((IgualdadDesigualdadContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((IgualdadDesigualdadContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(163);
						((IgualdadDesigualdadContext)_localctx).derecha = expresion(14);
						}
						break;
					case 5:
						{
						_localctx = new LogicoAndContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoAndContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(164);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(165);
						((LogicoAndContext)_localctx).operador = match(T__27);
						setState(166);
						((LogicoAndContext)_localctx).derecha = expresion(13);
						}
						break;
					case 6:
						{
						_localctx = new LogicoOrContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoOrContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(167);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(168);
						((LogicoOrContext)_localctx).operador = match(T__28);
						setState(169);
						((LogicoOrContext)_localctx).derecha = expresion(12);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		case 5:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u00b0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0016\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u001e\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002$\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002*\b\u0002\u0003\u0002,\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u00037\b\u0003\n\u0003\f\u0003:\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003>\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003F\b\u0003\u0003\u0003"+
		"H\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004L\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004R\b\u0004\n\u0004\f\u0004U\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004Y\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004]\b\u0004\n\u0004\f\u0004`\t\u0004\u0001\u0004\u0003"+
		"\u0004c\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005j\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005p\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005v\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005~\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0097\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u00ab\b\u0005\n\u0005\f\u0005\u00ae\t\u0005\u0001\u0005\u0000\u0001"+
		"\n\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0004\u0001\u0000\u0012\u0014"+
		"\u0002\u0000\u0010\u0010\u0015\u0015\u0001\u0000\u0016\u0019\u0001\u0000"+
		"\u001a\u001b\u00d4\u0000\u000f\u0001\u0000\u0000\u0000\u0002\u0015\u0001"+
		"\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000"+
		"\u0000\bb\u0001\u0000\u0000\u0000\n\u0096\u0001\u0000\u0000\u0000\f\u000e"+
		"\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000\u000e\u0011\u0001"+
		"\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000"+
		"\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0012\u0016\u0003\u0006\u0003\u0000\u0013\u0016\u0003\u0004"+
		"\u0002\u0000\u0014\u0016\u0003\b\u0004\u0000\u0015\u0012\u0001\u0000\u0000"+
		"\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0014\u0001\u0000\u0000"+
		"\u0000\u0016\u0003\u0001\u0000\u0000\u0000\u0017\u0018\u0005\u0001\u0000"+
		"\u0000\u0018\u0019\u0005\'\u0000\u0000\u0019\u001a\u0005!\u0000\u0000"+
		"\u001a\u001b\u0005\u0002\u0000\u0000\u001b\u001d\u0003\n\u0005\u0000\u001c"+
		"\u001e\u0005\u0003\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e,\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0001\u0000\u0000 !\u0005\'\u0000\u0000!#\u0005!\u0000\u0000\"$\u0005"+
		"\u0003\u0000\u0000#\"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$,\u0001\u0000\u0000\u0000%&\u0005\'\u0000\u0000&\'\u0005\u0004\u0000"+
		"\u0000\')\u0003\n\u0005\u0000(*\u0005\u0003\u0000\u0000)(\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+\u0017"+
		"\u0001\u0000\u0000\u0000+\u001f\u0001\u0000\u0000\u0000+%\u0001\u0000"+
		"\u0000\u0000,\u0005\u0001\u0000\u0000\u0000-.\u0005\'\u0000\u0000./\u0005"+
		"\u0004\u0000\u0000/0\u0005\u0005\u0000\u000001\u0005\u0006\u0000\u0000"+
		"12\u0005!\u0000\u000023\u0005\u0007\u0000\u000038\u0003\n\u0005\u0000"+
		"45\u0005\b\u0000\u000057\u0003\n\u0005\u000064\u0001\u0000\u0000\u0000"+
		"7:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;=\u0005\t\u0000"+
		"\u0000<>\u0005\u0003\u0000\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000"+
		"\u0000\u0000>H\u0001\u0000\u0000\u0000?@\u0005\u0001\u0000\u0000@A\u0005"+
		"\'\u0000\u0000AB\u0005\u0005\u0000\u0000BC\u0005\u0006\u0000\u0000CE\u0005"+
		"!\u0000\u0000DF\u0005\u0003\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000G-\u0001\u0000\u0000\u0000"+
		"G?\u0001\u0000\u0000\u0000H\u0007\u0001\u0000\u0000\u0000IK\u0003\n\u0005"+
		"\u0000JL\u0005\u0003\u0000\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000Lc\u0001\u0000\u0000\u0000MN\u0005\n\u0000\u0000NS\u0003\n"+
		"\u0005\u0000OP\u0005\b\u0000\u0000PR\u0003\n\u0005\u0000QO\u0001\u0000"+
		"\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VX\u0005\u000b\u0000\u0000WY\u0005\u0003\u0000\u0000XW\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Yc\u0001\u0000\u0000\u0000Z^\u0005\u0007"+
		"\u0000\u0000[]\u0003\u0002\u0001\u0000\\[\u0001\u0000\u0000\u0000]`\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ac\u0005\t\u0000\u0000"+
		"bI\u0001\u0000\u0000\u0000bM\u0001\u0000\u0000\u0000bZ\u0001\u0000\u0000"+
		"\u0000c\t\u0001\u0000\u0000\u0000de\u0006\u0005\uffff\uffff\u0000ef\u0005"+
		"\f\u0000\u0000fg\u0003\n\u0005\u0000gi\u0005\u000b\u0000\u0000hj\u0005"+
		"\u0003\u0000\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"j\u0097\u0001\u0000\u0000\u0000kl\u0005\r\u0000\u0000lm\u0003\n\u0005"+
		"\u0000mo\u0005\u000b\u0000\u0000np\u0005\u0003\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000p\u0097\u0001\u0000\u0000\u0000"+
		"qr\u0005\u000e\u0000\u0000rs\u0003\n\u0005\u0000su\u0005\u000b\u0000\u0000"+
		"tv\u0005\u0003\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000v\u0097\u0001\u0000\u0000\u0000wx\u0005\u000f\u0000\u0000xy\u0005"+
		"\'\u0000\u0000yz\u0005\b\u0000\u0000z{\u0003\n\u0005\u0000{}\u0005\u000b"+
		"\u0000\u0000|~\u0005\u0003\u0000\u0000}|\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u0097\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0010"+
		"\u0000\u0000\u0080\u0097\u0003\n\u0005\u0012\u0081\u0082\u0005\u0011\u0000"+
		"\u0000\u0082\u0097\u0003\n\u0005\u0011\u0083\u0084\u0005\'\u0000\u0000"+
		"\u0084\u0085\u0005\u0002\u0000\u0000\u0085\u0097\u0003\n\u0005\n\u0086"+
		"\u0087\u0005\'\u0000\u0000\u0087\u0088\u0005\u001e\u0000\u0000\u0088\u0097"+
		"\u0003\n\u0005\t\u0089\u008a\u0005\'\u0000\u0000\u008a\u008b\u0005\u001f"+
		"\u0000\u0000\u008b\u0097\u0003\n\u0005\b\u008c\u0097\u0005%\u0000\u0000"+
		"\u008d\u0097\u0005#\u0000\u0000\u008e\u0097\u0005&\u0000\u0000\u008f\u0097"+
		"\u0005$\u0000\u0000\u0090\u0097\u0005\"\u0000\u0000\u0091\u0097\u0005"+
		"\'\u0000\u0000\u0092\u0093\u0005 \u0000\u0000\u0093\u0094\u0003\n\u0005"+
		"\u0000\u0094\u0095\u0005\u000b\u0000\u0000\u0095\u0097\u0001\u0000\u0000"+
		"\u0000\u0096d\u0001\u0000\u0000\u0000\u0096k\u0001\u0000\u0000\u0000\u0096"+
		"q\u0001\u0000\u0000\u0000\u0096w\u0001\u0000\u0000\u0000\u0096\u007f\u0001"+
		"\u0000\u0000\u0000\u0096\u0081\u0001\u0000\u0000\u0000\u0096\u0083\u0001"+
		"\u0000\u0000\u0000\u0096\u0086\u0001\u0000\u0000\u0000\u0096\u0089\u0001"+
		"\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000\u0000\u0096\u008d\u0001"+
		"\u0000\u0000\u0000\u0096\u008e\u0001\u0000\u0000\u0000\u0096\u008f\u0001"+
		"\u0000\u0000\u0000\u0096\u0090\u0001\u0000\u0000\u0000\u0096\u0091\u0001"+
		"\u0000\u0000\u0000\u0096\u0092\u0001\u0000\u0000\u0000\u0097\u00ac\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\n\u0010\u0000\u0000\u0099\u009a\u0007\u0000"+
		"\u0000\u0000\u009a\u00ab\u0003\n\u0005\u0011\u009b\u009c\n\u000f\u0000"+
		"\u0000\u009c\u009d\u0007\u0001\u0000\u0000\u009d\u00ab\u0003\n\u0005\u0010"+
		"\u009e\u009f\n\u000e\u0000\u0000\u009f\u00a0\u0007\u0002\u0000\u0000\u00a0"+
		"\u00ab\u0003\n\u0005\u000f\u00a1\u00a2\n\r\u0000\u0000\u00a2\u00a3\u0007"+
		"\u0003\u0000\u0000\u00a3\u00ab\u0003\n\u0005\u000e\u00a4\u00a5\n\f\u0000"+
		"\u0000\u00a5\u00a6\u0005\u001c\u0000\u0000\u00a6\u00ab\u0003\n\u0005\r"+
		"\u00a7\u00a8\n\u000b\u0000\u0000\u00a8\u00a9\u0005\u001d\u0000\u0000\u00a9"+
		"\u00ab\u0003\n\u0005\f\u00aa\u0098\u0001\u0000\u0000\u0000\u00aa\u009b"+
		"\u0001\u0000\u0000\u0000\u00aa\u009e\u0001\u0000\u0000\u0000\u00aa\u00a1"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000\u00aa\u00a7"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u000b"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u0016\u000f"+
		"\u0015\u001d#)+8=EGKSX^biou}\u0096\u00aa\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}