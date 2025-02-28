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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, TIPO=38, ENTERO=39, 
		DECIMAL=40, CADENA=41, BOOLEANO=42, CARACTER=43, IDENTIFICADOR=44, WS=45, 
		COMENTARIOL=46, COMENTARIOLN=47;
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
			"'fmt.Println('", "')'", "'if'", "'('", "'else'", "'append('", "'strconv.Atoi('", 
			"'strconv.ParseFloat('", "'reflect.TypeOf('", "'slices.Index('", "'strings.Join('", 
			"'len('", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", 
			"'>='", "'=='", "'!='", "'&&'", "'||'", "'+='", "'-='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TIPO", "ENTERO", "DECIMAL", "CADENA", "BOOLEANO", "CARACTER", 
			"IDENTIFICADOR", "WS", "COMENTARIOL", "COMENTARIOLN"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34634633032834L) != 0)) {
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
	public static class ExpresionSentenciaContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpresionSentenciaContext(SentenciaContext ctx) { copyFrom(ctx); }
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
	public static class SentenciaIfContext extends SentenciaContext {
		public ExpresionContext condicion;
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaIfContext(SentenciaContext ctx) { copyFrom(ctx); }
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
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case ENTERO:
			case DECIMAL:
			case CADENA:
			case BOOLEANO:
			case CARACTER:
			case IDENTIFICADOR:
				_localctx = new ExpresionSentenciaContext(_localctx);
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34634633032834L) != 0)) {
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
			case T__11:
				_localctx = new SentenciaIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(T__11);
				setState(104);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(99);
					match(T__12);
					setState(100);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					setState(101);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(103);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(106);
				sentencia();
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(107);
					match(T__13);
					setState(108);
					sentencia();
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
	public static class AsignacionArregloContext extends ExpresionContext {
		public ExpresionContext indice;
		public ExpresionContext valornuevo;
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AsignacionArregloContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class AccesoArregloContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AccesoArregloContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaStringsJoinContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaStringsJoinContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class FuncionEmbebidaAtoiContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaAtoiContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class FuncionEmbebidaReflectTypeOfContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaReflectTypeOfContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class FuncionEmbebidaLenContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public FuncionEmbebidaLenContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEmbebidaAppendContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FuncionEmbebidaAppendContext(ExpresionContext ctx) { copyFrom(ctx); }
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				_localctx = new FuncionEmbebidaAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(114);
				match(T__14);
				setState(115);
				match(IDENTIFICADOR);
				setState(116);
				match(T__7);
				setState(117);
				expresion(0);
				setState(118);
				match(T__10);
				setState(120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(119);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 2:
				{
				_localctx = new FuncionEmbebidaAtoiContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(T__15);
				setState(123);
				expresion(0);
				setState(124);
				match(T__10);
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(125);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new FuncionEmbebidaParseFloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(T__16);
				setState(129);
				expresion(0);
				setState(130);
				match(T__10);
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(131);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new FuncionEmbebidaReflectTypeOfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(T__17);
				setState(135);
				expresion(0);
				setState(136);
				match(T__10);
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(137);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new FuncionEmbebidaSlicesIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(T__18);
				setState(141);
				match(IDENTIFICADOR);
				setState(142);
				match(T__7);
				setState(143);
				expresion(0);
				setState(144);
				match(T__10);
				setState(146);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(145);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new FuncionEmbebidaStringsJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(T__19);
				setState(149);
				match(IDENTIFICADOR);
				setState(150);
				match(T__7);
				setState(151);
				expresion(0);
				setState(152);
				match(T__10);
				setState(154);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(153);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new FuncionEmbebidaLenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(T__20);
				setState(157);
				match(IDENTIFICADOR);
				setState(158);
				match(T__10);
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(159);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new NegacionUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				((NegacionUnariaContext)_localctx).operador = match(T__21);
				setState(163);
				((NegacionUnariaContext)_localctx).izquierda = expresion(20);
				}
				break;
			case 9:
				{
				_localctx = new NegacionLogicaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				((NegacionLogicaContext)_localctx).operador = match(T__22);
				setState(165);
				((NegacionLogicaContext)_localctx).izquierda = expresion(19);
				}
				break;
			case 10:
				{
				_localctx = new AccesoArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(IDENTIFICADOR);
				setState(167);
				match(T__4);
				setState(168);
				expresion(0);
				setState(169);
				match(T__5);
				}
				break;
			case 11:
				{
				_localctx = new AsignacionArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(IDENTIFICADOR);
				setState(172);
				match(T__4);
				setState(173);
				((AsignacionArregloContext)_localctx).indice = expresion(0);
				setState(174);
				match(T__5);
				setState(175);
				match(T__1);
				setState(176);
				((AsignacionArregloContext)_localctx).valornuevo = expresion(11);
				}
				break;
			case 12:
				{
				_localctx = new AsignacionVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(IDENTIFICADOR);
				setState(179);
				match(T__1);
				setState(180);
				expresion(10);
				}
				break;
			case 13:
				{
				_localctx = new AsignacionVariableSumaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(IDENTIFICADOR);
				setState(182);
				match(T__35);
				setState(183);
				expresion(9);
				}
				break;
			case 14:
				{
				_localctx = new AsignacionVariableRestaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(IDENTIFICADOR);
				setState(185);
				match(T__36);
				setState(186);
				expresion(8);
				}
				break;
			case 15:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(BOOLEANO);
				}
				break;
			case 16:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				match(DECIMAL);
				}
				break;
			case 17:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				match(CARACTER);
				}
				break;
			case 18:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(CADENA);
				}
				break;
			case 19:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(ENTERO);
				}
				break;
			case 20:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(IDENTIFICADOR);
				}
				break;
			case 21:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(T__12);
				setState(194);
				expresion(0);
				setState(195);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionDivisionModuloContext(new ExpresionContext(_parentctx, _parentState));
						((MultiplicacionDivisionModuloContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(199);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(200);
						((MultiplicacionDivisionModuloContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440512L) != 0)) ) {
							((MultiplicacionDivisionModuloContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(201);
						((MultiplicacionDivisionModuloContext)_localctx).derecha = expresion(19);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						((SumaRestaContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(202);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(203);
						((SumaRestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__26) ) {
							((SumaRestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(204);
						((SumaRestaContext)_localctx).derecha = expresion(18);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalContext(new ExpresionContext(_parentctx, _parentState));
						((RelacionalContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(205);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(206);
						((RelacionalContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026531840L) != 0)) ) {
							((RelacionalContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(207);
						((RelacionalContext)_localctx).derecha = expresion(17);
						}
						break;
					case 4:
						{
						_localctx = new IgualdadDesigualdadContext(new ExpresionContext(_parentctx, _parentState));
						((IgualdadDesigualdadContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(208);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(209);
						((IgualdadDesigualdadContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
							((IgualdadDesigualdadContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(210);
						((IgualdadDesigualdadContext)_localctx).derecha = expresion(16);
						}
						break;
					case 5:
						{
						_localctx = new LogicoAndContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoAndContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(211);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(212);
						((LogicoAndContext)_localctx).operador = match(T__33);
						setState(213);
						((LogicoAndContext)_localctx).derecha = expresion(15);
						}
						break;
					case 6:
						{
						_localctx = new LogicoOrContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoOrContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(214);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(215);
						((LogicoOrContext)_localctx).operador = match(T__34);
						setState(216);
						((LogicoOrContext)_localctx).derecha = expresion(14);
						}
						break;
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u00df\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0004\u0005\u0004]\b\u0004\n\u0004\f\u0004`\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004i\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004n\b\u0004"+
		"\u0003\u0004p\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005y\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u007f\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0085\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u008b\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u0093\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u009b\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00a1\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u00c6\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00da\b\u0005"+
		"\n\u0005\f\u0005\u00dd\t\u0005\u0001\u0005\u0000\u0001\n\u0006\u0000\u0002"+
		"\u0004\u0006\b\n\u0000\u0004\u0001\u0000\u0018\u001a\u0002\u0000\u0016"+
		"\u0016\u001b\u001b\u0001\u0000\u001c\u001f\u0001\u0000 !\u010e\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004+\u0001"+
		"\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000\bo\u0001\u0000\u0000"+
		"\u0000\n\u00c5\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000"+
		"\r\f\u0001\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f"+
		"\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0001"+
		"\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0016"+
		"\u0003\u0006\u0003\u0000\u0013\u0016\u0003\u0004\u0002\u0000\u0014\u0016"+
		"\u0003\b\u0004\u0000\u0015\u0012\u0001\u0000\u0000\u0000\u0015\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0003\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0005\u0001\u0000\u0000\u0018\u0019\u0005"+
		",\u0000\u0000\u0019\u001a\u0005&\u0000\u0000\u001a\u001b\u0005\u0002\u0000"+
		"\u0000\u001b\u001d\u0003\n\u0005\u0000\u001c\u001e\u0005\u0003\u0000\u0000"+
		"\u001d\u001c\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000"+
		"\u001e,\u0001\u0000\u0000\u0000\u001f \u0005\u0001\u0000\u0000 !\u0005"+
		",\u0000\u0000!#\u0005&\u0000\u0000\"$\u0005\u0003\u0000\u0000#\"\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$,\u0001\u0000\u0000\u0000"+
		"%&\u0005,\u0000\u0000&\'\u0005\u0004\u0000\u0000\')\u0003\n\u0005\u0000"+
		"(*\u0005\u0003\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*,\u0001\u0000\u0000\u0000+\u0017\u0001\u0000\u0000\u0000+\u001f"+
		"\u0001\u0000\u0000\u0000+%\u0001\u0000\u0000\u0000,\u0005\u0001\u0000"+
		"\u0000\u0000-.\u0005,\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0005\u0005"+
		"\u0000\u000001\u0005\u0006\u0000\u000012\u0005&\u0000\u000023\u0005\u0007"+
		"\u0000\u000038\u0003\n\u0005\u000045\u0005\b\u0000\u000057\u0003\n\u0005"+
		"\u000064\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000;=\u0005\t\u0000\u0000<>\u0005\u0003\u0000\u0000=<\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>H\u0001\u0000\u0000\u0000"+
		"?@\u0005\u0001\u0000\u0000@A\u0005,\u0000\u0000AB\u0005\u0005\u0000\u0000"+
		"BC\u0005\u0006\u0000\u0000CE\u0005&\u0000\u0000DF\u0005\u0003\u0000\u0000"+
		"ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000"+
		"\u0000G-\u0001\u0000\u0000\u0000G?\u0001\u0000\u0000\u0000H\u0007\u0001"+
		"\u0000\u0000\u0000IK\u0003\n\u0005\u0000JL\u0005\u0003\u0000\u0000KJ\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000Lp\u0001\u0000\u0000\u0000"+
		"MN\u0005\n\u0000\u0000NS\u0003\n\u0005\u0000OP\u0005\b\u0000\u0000PR\u0003"+
		"\n\u0005\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000VX\u0005\u000b\u0000\u0000WY\u0005\u0003\u0000"+
		"\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Yp\u0001\u0000"+
		"\u0000\u0000Z^\u0005\u0007\u0000\u0000[]\u0003\u0002\u0001\u0000\\[\u0001"+
		"\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000ap\u0005\t\u0000\u0000bh\u0005\f\u0000\u0000cd\u0005\r\u0000\u0000"+
		"de\u0003\n\u0005\u0000ef\u0005\u000b\u0000\u0000fi\u0001\u0000\u0000\u0000"+
		"gi\u0003\n\u0005\u0000hc\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jm\u0003\b\u0004\u0000kl\u0005\u000e\u0000\u0000"+
		"ln\u0003\b\u0004\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"np\u0001\u0000\u0000\u0000oI\u0001\u0000\u0000\u0000oM\u0001\u0000\u0000"+
		"\u0000oZ\u0001\u0000\u0000\u0000ob\u0001\u0000\u0000\u0000p\t\u0001\u0000"+
		"\u0000\u0000qr\u0006\u0005\uffff\uffff\u0000rs\u0005\u000f\u0000\u0000"+
		"st\u0005,\u0000\u0000tu\u0005\b\u0000\u0000uv\u0003\n\u0005\u0000vx\u0005"+
		"\u000b\u0000\u0000wy\u0005\u0003\u0000\u0000xw\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000y\u00c6\u0001\u0000\u0000\u0000z{\u0005\u0010"+
		"\u0000\u0000{|\u0003\n\u0005\u0000|~\u0005\u000b\u0000\u0000}\u007f\u0005"+
		"\u0003\u0000\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u00c6\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0011\u0000"+
		"\u0000\u0081\u0082\u0003\n\u0005\u0000\u0082\u0084\u0005\u000b\u0000\u0000"+
		"\u0083\u0085\u0005\u0003\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u00c6\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005\u0012\u0000\u0000\u0087\u0088\u0003\n\u0005\u0000\u0088"+
		"\u008a\u0005\u000b\u0000\u0000\u0089\u008b\u0005\u0003\u0000\u0000\u008a"+
		"\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u00c6\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0013\u0000\u0000\u008d"+
		"\u008e\u0005,\u0000\u0000\u008e\u008f\u0005\b\u0000\u0000\u008f\u0090"+
		"\u0003\n\u0005\u0000\u0090\u0092\u0005\u000b\u0000\u0000\u0091\u0093\u0005"+
		"\u0003\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u00c6\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u0014\u0000\u0000\u0095\u0096\u0005,\u0000\u0000\u0096\u0097\u0005\b"+
		"\u0000\u0000\u0097\u0098\u0003\n\u0005\u0000\u0098\u009a\u0005\u000b\u0000"+
		"\u0000\u0099\u009b\u0005\u0003\u0000\u0000\u009a\u0099\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00c6\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0005\u0015\u0000\u0000\u009d\u009e\u0005,\u0000\u0000"+
		"\u009e\u00a0\u0005\u000b\u0000\u0000\u009f\u00a1\u0005\u0003\u0000\u0000"+
		"\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u00c6\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0016\u0000\u0000"+
		"\u00a3\u00c6\u0003\n\u0005\u0014\u00a4\u00a5\u0005\u0017\u0000\u0000\u00a5"+
		"\u00c6\u0003\n\u0005\u0013\u00a6\u00a7\u0005,\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0005\u0000\u0000\u00a8\u00a9\u0003\n\u0005\u0000\u00a9\u00aa\u0005"+
		"\u0006\u0000\u0000\u00aa\u00c6\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		",\u0000\u0000\u00ac\u00ad\u0005\u0005\u0000\u0000\u00ad\u00ae\u0003\n"+
		"\u0005\u0000\u00ae\u00af\u0005\u0006\u0000\u0000\u00af\u00b0\u0005\u0002"+
		"\u0000\u0000\u00b0\u00b1\u0003\n\u0005\u000b\u00b1\u00c6\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0005,\u0000\u0000\u00b3\u00b4\u0005\u0002\u0000\u0000"+
		"\u00b4\u00c6\u0003\n\u0005\n\u00b5\u00b6\u0005,\u0000\u0000\u00b6\u00b7"+
		"\u0005$\u0000\u0000\u00b7\u00c6\u0003\n\u0005\t\u00b8\u00b9\u0005,\u0000"+
		"\u0000\u00b9\u00ba\u0005%\u0000\u0000\u00ba\u00c6\u0003\n\u0005\b\u00bb"+
		"\u00c6\u0005*\u0000\u0000\u00bc\u00c6\u0005(\u0000\u0000\u00bd\u00c6\u0005"+
		"+\u0000\u0000\u00be\u00c6\u0005)\u0000\u0000\u00bf\u00c6\u0005\'\u0000"+
		"\u0000\u00c0\u00c6\u0005,\u0000\u0000\u00c1\u00c2\u0005\r\u0000\u0000"+
		"\u00c2\u00c3\u0003\n\u0005\u0000\u00c3\u00c4\u0005\u000b\u0000\u0000\u00c4"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c5q\u0001\u0000\u0000\u0000\u00c5z\u0001"+
		"\u0000\u0000\u0000\u00c5\u0080\u0001\u0000\u0000\u0000\u00c5\u0086\u0001"+
		"\u0000\u0000\u0000\u00c5\u008c\u0001\u0000\u0000\u0000\u00c5\u0094\u0001"+
		"\u0000\u0000\u0000\u00c5\u009c\u0001\u0000\u0000\u0000\u00c5\u00a2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00a4\u0001\u0000\u0000\u0000\u00c5\u00a6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00ab\u0001\u0000\u0000\u0000\u00c5\u00b2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00b5\u0001\u0000\u0000\u0000\u00c5\u00b8\u0001"+
		"\u0000\u0000\u0000\u00c5\u00bb\u0001\u0000\u0000\u0000\u00c5\u00bc\u0001"+
		"\u0000\u0000\u0000\u00c5\u00bd\u0001\u0000\u0000\u0000\u00c5\u00be\u0001"+
		"\u0000\u0000\u0000\u00c5\u00bf\u0001\u0000\u0000\u0000\u00c5\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c1\u0001\u0000\u0000\u0000\u00c6\u00db\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\n\u0012\u0000\u0000\u00c8\u00c9\u0007\u0000"+
		"\u0000\u0000\u00c9\u00da\u0003\n\u0005\u0013\u00ca\u00cb\n\u0011\u0000"+
		"\u0000\u00cb\u00cc\u0007\u0001\u0000\u0000\u00cc\u00da\u0003\n\u0005\u0012"+
		"\u00cd\u00ce\n\u0010\u0000\u0000\u00ce\u00cf\u0007\u0002\u0000\u0000\u00cf"+
		"\u00da\u0003\n\u0005\u0011\u00d0\u00d1\n\u000f\u0000\u0000\u00d1\u00d2"+
		"\u0007\u0003\u0000\u0000\u00d2\u00da\u0003\n\u0005\u0010\u00d3\u00d4\n"+
		"\u000e\u0000\u0000\u00d4\u00d5\u0005\"\u0000\u0000\u00d5\u00da\u0003\n"+
		"\u0005\u000f\u00d6\u00d7\n\r\u0000\u0000\u00d7\u00d8\u0005#\u0000\u0000"+
		"\u00d8\u00da\u0003\n\u0005\u000e\u00d9\u00c7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00d9\u00cd\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d9\u00d3\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d6\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u000b\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u001b"+
		"\u000f\u0015\u001d#)+8=EGKSX^hmox~\u0084\u008a\u0092\u009a\u00a0\u00c5"+
		"\u00d9\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}