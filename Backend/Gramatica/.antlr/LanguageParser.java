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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, TIPO=42, ENTERO=43, DECIMAL=44, CADENA=45, 
		BOOLEANO=46, CARACTER=47, IDENTIFICADOR=48, WS=49, COMENTARIOL=50, COMENTARIOLN=51;
	public static final int
		RULE_program = 0, RULE_declaraciones = 1, RULE_declaracion_variable = 2, 
		RULE_declaracion_arreglo = 3, RULE_sentencia = 4, RULE_casos_switch = 5, 
		RULE_default_switch = 6, RULE_expresion = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaraciones", "declaracion_variable", "declaracion_arreglo", 
			"sentencia", "casos_switch", "default_switch", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'['", "']'", "'{'", "','", "'}'", 
			"'fmt.Println('", "')'", "'if'", "'('", "'else'", "'switch'", "'case'", 
			"':'", "'default'", "'append('", "'strconv.Atoi('", "'strconv.ParseFloat('", 
			"'reflect.TypeOf('", "'slices.Index('", "'strings.Join('", "'len('", 
			"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", 
			"'=='", "'!='", "'&&'", "'||'", "'+='", "'-='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "TIPO", "ENTERO", "DECIMAL", "CADENA", 
			"BOOLEANO", "CARACTER", "IDENTIFICADOR", "WS", "COMENTARIOL", "COMENTARIOLN"
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
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554154128356482L) != 0)) {
				{
				{
				setState(16);
				declaraciones();
				}
				}
				setState(21);
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
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				declaracion_arreglo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				declaracion_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
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
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(T__0);
				setState(28);
				match(IDENTIFICADOR);
				setState(29);
				match(TIPO);
				setState(30);
				match(T__1);
				setState(31);
				expresion(0);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(32);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(T__0);
				setState(36);
				match(IDENTIFICADOR);
				setState(37);
				match(TIPO);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(38);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(IDENTIFICADOR);
				setState(42);
				match(T__3);
				setState(43);
				expresion(0);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(44);
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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFICADOR:
				_localctx = new DeclaracionArregloExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(IDENTIFICADOR);
				setState(50);
				match(T__3);
				setState(51);
				match(T__4);
				setState(52);
				match(T__5);
				setState(53);
				match(TIPO);
				setState(54);
				match(T__6);
				{
				setState(55);
				expresion(0);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(56);
					match(T__7);
					setState(57);
					expresion(0);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(63);
				match(T__8);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(64);
					match(T__2);
					}
				}

				}
				break;
			case T__0:
				_localctx = new DeclaracionArregloPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(T__0);
				setState(68);
				match(IDENTIFICADOR);
				setState(69);
				match(T__4);
				setState(70);
				match(T__5);
				setState(71);
				match(TIPO);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(72);
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
	public static class SentenciaSwitchContext extends SentenciaContext {
		public ExpresionContext condicion;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<Casos_switchContext> casos_switch() {
			return getRuleContexts(Casos_switchContext.class);
		}
		public Casos_switchContext casos_switch(int i) {
			return getRuleContext(Casos_switchContext.class,i);
		}
		public Default_switchContext default_switch() {
			return getRuleContext(Default_switchContext.class,0);
		}
		public SentenciaSwitchContext(SentenciaContext ctx) { copyFrom(ctx); }
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
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case ENTERO:
			case DECIMAL:
			case CADENA:
			case BOOLEANO:
			case CARACTER:
			case IDENTIFICADOR:
				_localctx = new ExpresionSentenciaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				expresion(0);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(78);
					match(T__2);
					}
				}

				}
				break;
			case T__9:
				_localctx = new FuncionEmbebidaPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__9);
				setState(82);
				expresion(0);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(83);
					match(T__7);
					setState(84);
					expresion(0);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(T__10);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(91);
					match(T__2);
					}
				}

				}
				break;
			case T__6:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(T__6);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554154128356482L) != 0)) {
					{
					{
					setState(95);
					declaraciones();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				match(T__8);
				}
				break;
			case T__11:
				_localctx = new SentenciaIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				match(T__11);
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(103);
					match(T__12);
					setState(104);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					setState(105);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(107);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(110);
				sentencia();
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(111);
					match(T__13);
					setState(112);
					sentencia();
					}
					break;
				}
				}
				break;
			case T__14:
				_localctx = new SentenciaSwitchContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(T__14);
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(116);
					match(T__12);
					setState(117);
					((SentenciaSwitchContext)_localctx).condicion = expresion(0);
					setState(118);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(120);
					((SentenciaSwitchContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(123);
				match(T__6);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(124);
					casos_switch();
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(130);
					default_switch();
					}
				}

				setState(133);
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
	public static class Casos_switchContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<DeclaracionesContext> declaraciones() {
			return getRuleContexts(DeclaracionesContext.class);
		}
		public DeclaracionesContext declaraciones(int i) {
			return getRuleContext(DeclaracionesContext.class,i);
		}
		public Casos_switchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casos_switch; }
	}

	public final Casos_switchContext casos_switch() throws RecognitionException {
		Casos_switchContext _localctx = new Casos_switchContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_casos_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__15);
			setState(138);
			expresion(0);
			setState(139);
			match(T__16);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554154128356482L) != 0)) {
				{
				{
				setState(140);
				declaraciones();
				}
				}
				setState(145);
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
	public static class Default_switchContext extends ParserRuleContext {
		public List<DeclaracionesContext> declaraciones() {
			return getRuleContexts(DeclaracionesContext.class);
		}
		public DeclaracionesContext declaraciones(int i) {
			return getRuleContext(DeclaracionesContext.class,i);
		}
		public Default_switchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_switch; }
	}

	public final Default_switchContext default_switch() throws RecognitionException {
		Default_switchContext _localctx = new Default_switchContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_default_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__17);
			setState(147);
			match(T__16);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554154128356482L) != 0)) {
				{
				{
				setState(148);
				declaraciones();
				}
				}
				setState(153);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new FuncionEmbebidaAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
				match(T__18);
				setState(156);
				match(IDENTIFICADOR);
				setState(157);
				match(T__7);
				setState(158);
				expresion(0);
				setState(159);
				match(T__10);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(160);
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
				setState(163);
				match(T__19);
				setState(164);
				expresion(0);
				setState(165);
				match(T__10);
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(166);
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
				setState(169);
				match(T__20);
				setState(170);
				expresion(0);
				setState(171);
				match(T__10);
				setState(173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(172);
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
				setState(175);
				match(T__21);
				setState(176);
				expresion(0);
				setState(177);
				match(T__10);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(178);
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
				setState(181);
				match(T__22);
				setState(182);
				match(IDENTIFICADOR);
				setState(183);
				match(T__7);
				setState(184);
				expresion(0);
				setState(185);
				match(T__10);
				setState(187);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(186);
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
				setState(189);
				match(T__23);
				setState(190);
				match(IDENTIFICADOR);
				setState(191);
				match(T__7);
				setState(192);
				expresion(0);
				setState(193);
				match(T__10);
				setState(195);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(194);
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
				setState(197);
				match(T__24);
				setState(198);
				match(IDENTIFICADOR);
				setState(199);
				match(T__10);
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(200);
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
				setState(203);
				((NegacionUnariaContext)_localctx).operador = match(T__25);
				setState(204);
				((NegacionUnariaContext)_localctx).izquierda = expresion(20);
				}
				break;
			case 9:
				{
				_localctx = new NegacionLogicaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				((NegacionLogicaContext)_localctx).operador = match(T__26);
				setState(206);
				((NegacionLogicaContext)_localctx).izquierda = expresion(19);
				}
				break;
			case 10:
				{
				_localctx = new AccesoArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(IDENTIFICADOR);
				setState(208);
				match(T__4);
				setState(209);
				expresion(0);
				setState(210);
				match(T__5);
				}
				break;
			case 11:
				{
				_localctx = new AsignacionArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(IDENTIFICADOR);
				setState(213);
				match(T__4);
				setState(214);
				((AsignacionArregloContext)_localctx).indice = expresion(0);
				setState(215);
				match(T__5);
				setState(216);
				match(T__1);
				setState(217);
				((AsignacionArregloContext)_localctx).valornuevo = expresion(11);
				}
				break;
			case 12:
				{
				_localctx = new AsignacionVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(IDENTIFICADOR);
				setState(220);
				match(T__1);
				setState(221);
				expresion(10);
				}
				break;
			case 13:
				{
				_localctx = new AsignacionVariableSumaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(IDENTIFICADOR);
				setState(223);
				match(T__39);
				setState(224);
				expresion(9);
				}
				break;
			case 14:
				{
				_localctx = new AsignacionVariableRestaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(IDENTIFICADOR);
				setState(226);
				match(T__40);
				setState(227);
				expresion(8);
				}
				break;
			case 15:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(BOOLEANO);
				}
				break;
			case 16:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(DECIMAL);
				}
				break;
			case 17:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(CARACTER);
				}
				break;
			case 18:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(CADENA);
				}
				break;
			case 19:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(ENTERO);
				}
				break;
			case 20:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				match(IDENTIFICADOR);
				}
				break;
			case 21:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(T__12);
				setState(235);
				expresion(0);
				setState(236);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionDivisionModuloContext(new ExpresionContext(_parentctx, _parentState));
						((MultiplicacionDivisionModuloContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(240);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(241);
						((MultiplicacionDivisionModuloContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
							((MultiplicacionDivisionModuloContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(242);
						((MultiplicacionDivisionModuloContext)_localctx).derecha = expresion(19);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						((SumaRestaContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(243);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(244);
						((SumaRestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__30) ) {
							((SumaRestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						((SumaRestaContext)_localctx).derecha = expresion(18);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalContext(new ExpresionContext(_parentctx, _parentState));
						((RelacionalContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(246);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(247);
						((RelacionalContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
							((RelacionalContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						((RelacionalContext)_localctx).derecha = expresion(17);
						}
						break;
					case 4:
						{
						_localctx = new IgualdadDesigualdadContext(new ExpresionContext(_parentctx, _parentState));
						((IgualdadDesigualdadContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(249);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(250);
						((IgualdadDesigualdadContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__36) ) {
							((IgualdadDesigualdadContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						((IgualdadDesigualdadContext)_localctx).derecha = expresion(16);
						}
						break;
					case 5:
						{
						_localctx = new LogicoAndContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoAndContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(252);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(253);
						((LogicoAndContext)_localctx).operador = match(T__37);
						setState(254);
						((LogicoAndContext)_localctx).derecha = expresion(15);
						}
						break;
					case 6:
						{
						_localctx = new LogicoOrContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoOrContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(255);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(256);
						((LogicoOrContext)_localctx).operador = match(T__38);
						setState(257);
						((LogicoOrContext)_localctx).derecha = expresion(14);
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		case 7:
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
		"\u0004\u00013\u0108\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\"\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002(\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002.\b\u0002"+
		"\u0003\u00020\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		";\b\u0003\n\u0003\f\u0003>\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"B\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003J\b\u0003\u0003\u0003L\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004P\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004V\b\u0004\n\u0004\f\u0004Y\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004]\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004a\b\u0004"+
		"\n\u0004\f\u0004d\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004m\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004r\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004z\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081\t"+
		"\u0004\u0001\u0004\u0003\u0004\u0084\b\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u0088\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u008e\b\u0005\n\u0005\f\u0005\u0091\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0096\b\u0006\n\u0006\f\u0006\u0099\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00a2\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00a8\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00ae\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00b4\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00bc\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c4"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ca"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00ef\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0103\b\u0007\n\u0007\f\u0007\u0106\t\u0007"+
		"\u0001\u0007\u0000\u0001\u000e\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000"+
		"\u0004\u0001\u0000\u001c\u001e\u0002\u0000\u001a\u001a\u001f\u001f\u0001"+
		"\u0000 #\u0001\u0000$%\u013b\u0000\u0013\u0001\u0000\u0000\u0000\u0002"+
		"\u0019\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006K\u0001"+
		"\u0000\u0000\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u0089\u0001\u0000"+
		"\u0000\u0000\f\u0092\u0001\u0000\u0000\u0000\u000e\u00ee\u0001\u0000\u0000"+
		"\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000"+
		"\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000"+
		"\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000"+
		"\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0016\u001a\u0003\u0006\u0003"+
		"\u0000\u0017\u001a\u0003\u0004\u0002\u0000\u0018\u001a\u0003\b\u0004\u0000"+
		"\u0019\u0016\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000"+
		"\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u0003\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0005\u0001\u0000\u0000\u001c\u001d\u00050\u0000\u0000\u001d"+
		"\u001e\u0005*\u0000\u0000\u001e\u001f\u0005\u0002\u0000\u0000\u001f!\u0003"+
		"\u000e\u0007\u0000 \"\u0005\u0003\u0000\u0000! \u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"0\u0001\u0000\u0000\u0000#$\u0005\u0001\u0000"+
		"\u0000$%\u00050\u0000\u0000%\'\u0005*\u0000\u0000&(\u0005\u0003\u0000"+
		"\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(0\u0001\u0000"+
		"\u0000\u0000)*\u00050\u0000\u0000*+\u0005\u0004\u0000\u0000+-\u0003\u000e"+
		"\u0007\u0000,.\u0005\u0003\u0000\u0000-,\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/\u001b\u0001\u0000\u0000"+
		"\u0000/#\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000\u00000\u0005\u0001"+
		"\u0000\u0000\u000012\u00050\u0000\u000023\u0005\u0004\u0000\u000034\u0005"+
		"\u0005\u0000\u000045\u0005\u0006\u0000\u000056\u0005*\u0000\u000067\u0005"+
		"\u0007\u0000\u00007<\u0003\u000e\u0007\u000089\u0005\b\u0000\u00009;\u0003"+
		"\u000e\u0007\u0000:8\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000"+
		"\u0000><\u0001\u0000\u0000\u0000?A\u0005\t\u0000\u0000@B\u0005\u0003\u0000"+
		"\u0000A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BL\u0001\u0000"+
		"\u0000\u0000CD\u0005\u0001\u0000\u0000DE\u00050\u0000\u0000EF\u0005\u0005"+
		"\u0000\u0000FG\u0005\u0006\u0000\u0000GI\u0005*\u0000\u0000HJ\u0005\u0003"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001"+
		"\u0000\u0000\u0000K1\u0001\u0000\u0000\u0000KC\u0001\u0000\u0000\u0000"+
		"L\u0007\u0001\u0000\u0000\u0000MO\u0003\u000e\u0007\u0000NP\u0005\u0003"+
		"\u0000\u0000ON\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0088"+
		"\u0001\u0000\u0000\u0000QR\u0005\n\u0000\u0000RW\u0003\u000e\u0007\u0000"+
		"ST\u0005\b\u0000\u0000TV\u0003\u000e\u0007\u0000US\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z\\\u0005\u000b"+
		"\u0000\u0000[]\u0005\u0003\u0000\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\u0088\u0001\u0000\u0000\u0000^b\u0005\u0007\u0000"+
		"\u0000_a\u0003\u0002\u0001\u0000`_\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000e\u0088\u0005\t\u0000\u0000"+
		"fl\u0005\f\u0000\u0000gh\u0005\r\u0000\u0000hi\u0003\u000e\u0007\u0000"+
		"ij\u0005\u000b\u0000\u0000jm\u0001\u0000\u0000\u0000km\u0003\u000e\u0007"+
		"\u0000lg\u0001\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000nq\u0003\b\u0004\u0000op\u0005\u000e\u0000\u0000pr\u0003\b"+
		"\u0004\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0088"+
		"\u0001\u0000\u0000\u0000sy\u0005\u000f\u0000\u0000tu\u0005\r\u0000\u0000"+
		"uv\u0003\u000e\u0007\u0000vw\u0005\u000b\u0000\u0000wz\u0001\u0000\u0000"+
		"\u0000xz\u0003\u000e\u0007\u0000yt\u0001\u0000\u0000\u0000yx\u0001\u0000"+
		"\u0000\u0000z{\u0001\u0000\u0000\u0000{\u007f\u0005\u0007\u0000\u0000"+
		"|~\u0003\n\u0005\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0003\f\u0006\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005\t\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087M"+
		"\u0001\u0000\u0000\u0000\u0087Q\u0001\u0000\u0000\u0000\u0087^\u0001\u0000"+
		"\u0000\u0000\u0087f\u0001\u0000\u0000\u0000\u0087s\u0001\u0000\u0000\u0000"+
		"\u0088\t\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0010\u0000\u0000\u008a"+
		"\u008b\u0003\u000e\u0007\u0000\u008b\u008f\u0005\u0011\u0000\u0000\u008c"+
		"\u008e\u0003\u0002\u0001\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u000b\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0012\u0000\u0000\u0093"+
		"\u0097\u0005\u0011\u0000\u0000\u0094\u0096\u0003\u0002\u0001\u0000\u0095"+
		"\u0094\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097"+
		"\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098"+
		"\r\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0006\u0007\uffff\uffff\u0000\u009b\u009c\u0005\u0013\u0000\u0000\u009c"+
		"\u009d\u00050\u0000\u0000\u009d\u009e\u0005\b\u0000\u0000\u009e\u009f"+
		"\u0003\u000e\u0007\u0000\u009f\u00a1\u0005\u000b\u0000\u0000\u00a0\u00a2"+
		"\u0005\u0003\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00ef\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0005\u0014\u0000\u0000\u00a4\u00a5\u0003\u000e\u0007\u0000\u00a5\u00a7"+
		"\u0005\u000b\u0000\u0000\u00a6\u00a8\u0005\u0003\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ef"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0015\u0000\u0000\u00aa\u00ab"+
		"\u0003\u000e\u0007\u0000\u00ab\u00ad\u0005\u000b\u0000\u0000\u00ac\u00ae"+
		"\u0005\u0003\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ef\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0005\u0016\u0000\u0000\u00b0\u00b1\u0003\u000e\u0007\u0000\u00b1\u00b3"+
		"\u0005\u000b\u0000\u0000\u00b2\u00b4\u0005\u0003\u0000\u0000\u00b3\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00ef"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0017\u0000\u0000\u00b6\u00b7"+
		"\u00050\u0000\u0000\u00b7\u00b8\u0005\b\u0000\u0000\u00b8\u00b9\u0003"+
		"\u000e\u0007\u0000\u00b9\u00bb\u0005\u000b\u0000\u0000\u00ba\u00bc\u0005"+
		"\u0003\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ef\u0001\u0000\u0000\u0000\u00bd\u00be\u0005"+
		"\u0018\u0000\u0000\u00be\u00bf\u00050\u0000\u0000\u00bf\u00c0\u0005\b"+
		"\u0000\u0000\u00c0\u00c1\u0003\u000e\u0007\u0000\u00c1\u00c3\u0005\u000b"+
		"\u0000\u0000\u00c2\u00c4\u0005\u0003\u0000\u0000\u00c3\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00ef\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0019\u0000\u0000\u00c6\u00c7\u00050\u0000"+
		"\u0000\u00c7\u00c9\u0005\u000b\u0000\u0000\u00c8\u00ca\u0005\u0003\u0000"+
		"\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ca\u00ef\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u001a\u0000"+
		"\u0000\u00cc\u00ef\u0003\u000e\u0007\u0014\u00cd\u00ce\u0005\u001b\u0000"+
		"\u0000\u00ce\u00ef\u0003\u000e\u0007\u0013\u00cf\u00d0\u00050\u0000\u0000"+
		"\u00d0\u00d1\u0005\u0005\u0000\u0000\u00d1\u00d2\u0003\u000e\u0007\u0000"+
		"\u00d2\u00d3\u0005\u0006\u0000\u0000\u00d3\u00ef\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u00050\u0000\u0000\u00d5\u00d6\u0005\u0005\u0000\u0000\u00d6"+
		"\u00d7\u0003\u000e\u0007\u0000\u00d7\u00d8\u0005\u0006\u0000\u0000\u00d8"+
		"\u00d9\u0005\u0002\u0000\u0000\u00d9\u00da\u0003\u000e\u0007\u000b\u00da"+
		"\u00ef\u0001\u0000\u0000\u0000\u00db\u00dc\u00050\u0000\u0000\u00dc\u00dd"+
		"\u0005\u0002\u0000\u0000\u00dd\u00ef\u0003\u000e\u0007\n\u00de\u00df\u0005"+
		"0\u0000\u0000\u00df\u00e0\u0005(\u0000\u0000\u00e0\u00ef\u0003\u000e\u0007"+
		"\t\u00e1\u00e2\u00050\u0000\u0000\u00e2\u00e3\u0005)\u0000\u0000\u00e3"+
		"\u00ef\u0003\u000e\u0007\b\u00e4\u00ef\u0005.\u0000\u0000\u00e5\u00ef"+
		"\u0005,\u0000\u0000\u00e6\u00ef\u0005/\u0000\u0000\u00e7\u00ef\u0005-"+
		"\u0000\u0000\u00e8\u00ef\u0005+\u0000\u0000\u00e9\u00ef\u00050\u0000\u0000"+
		"\u00ea\u00eb\u0005\r\u0000\u0000\u00eb\u00ec\u0003\u000e\u0007\u0000\u00ec"+
		"\u00ed\u0005\u000b\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee"+
		"\u009a\u0001\u0000\u0000\u0000\u00ee\u00a3\u0001\u0000\u0000\u0000\u00ee"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ee\u00af\u0001\u0000\u0000\u0000\u00ee"+
		"\u00b5\u0001\u0000\u0000\u0000\u00ee\u00bd\u0001\u0000\u0000\u0000\u00ee"+
		"\u00c5\u0001\u0000\u0000\u0000\u00ee\u00cb\u0001\u0000\u0000\u0000\u00ee"+
		"\u00cd\u0001\u0000\u0000\u0000\u00ee\u00cf\u0001\u0000\u0000\u0000\u00ee"+
		"\u00d4\u0001\u0000\u0000\u0000\u00ee\u00db\u0001\u0000\u0000\u0000\u00ee"+
		"\u00de\u0001\u0000\u0000\u0000\u00ee\u00e1\u0001\u0000\u0000\u0000\u00ee"+
		"\u00e4\u0001\u0000\u0000\u0000\u00ee\u00e5\u0001\u0000\u0000\u0000\u00ee"+
		"\u00e6\u0001\u0000\u0000\u0000\u00ee\u00e7\u0001\u0000\u0000\u0000\u00ee"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ee\u00e9\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ef\u0104\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\n\u0012\u0000\u0000\u00f1\u00f2\u0007\u0000\u0000\u0000\u00f2\u0103"+
		"\u0003\u000e\u0007\u0013\u00f3\u00f4\n\u0011\u0000\u0000\u00f4\u00f5\u0007"+
		"\u0001\u0000\u0000\u00f5\u0103\u0003\u000e\u0007\u0012\u00f6\u00f7\n\u0010"+
		"\u0000\u0000\u00f7\u00f8\u0007\u0002\u0000\u0000\u00f8\u0103\u0003\u000e"+
		"\u0007\u0011\u00f9\u00fa\n\u000f\u0000\u0000\u00fa\u00fb\u0007\u0003\u0000"+
		"\u0000\u00fb\u0103\u0003\u000e\u0007\u0010\u00fc\u00fd\n\u000e\u0000\u0000"+
		"\u00fd\u00fe\u0005&\u0000\u0000\u00fe\u0103\u0003\u000e\u0007\u000f\u00ff"+
		"\u0100\n\r\u0000\u0000\u0100\u0101\u0005\'\u0000\u0000\u0101\u0103\u0003"+
		"\u000e\u0007\u000e\u0102\u00f0\u0001\u0000\u0000\u0000\u0102\u00f3\u0001"+
		"\u0000\u0000\u0000\u0102\u00f6\u0001\u0000\u0000\u0000\u0102\u00f9\u0001"+
		"\u0000\u0000\u0000\u0102\u00fc\u0001\u0000\u0000\u0000\u0102\u00ff\u0001"+
		"\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u000f\u0001"+
		"\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000 \u0013\u0019!\'"+
		"-/<AIKOW\\blqy\u007f\u0083\u0087\u008f\u0097\u00a1\u00a7\u00ad\u00b3\u00bb"+
		"\u00c3\u00c9\u00ee\u0102\u0104";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}