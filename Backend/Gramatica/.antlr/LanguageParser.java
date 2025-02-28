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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		TIPO=46, ENTERO=47, DECIMAL=48, CADENA=49, BOOLEANO=50, CARACTER=51, IDENTIFICADOR=52, 
		WS=53, COMENTARIOL=54, COMENTARIOLN=55;
	public static final int
		RULE_program = 0, RULE_declaraciones = 1, RULE_declaracion_variable = 2, 
		RULE_declaracion_arreglo = 3, RULE_sentencia = 4, RULE_casos_switch = 5, 
		RULE_default_switch = 6, RULE_for_init = 7, RULE_expresion = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaraciones", "declaracion_variable", "declaracion_arreglo", 
			"sentencia", "casos_switch", "default_switch", "for_init", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'['", "']'", "'{'", "','", "'}'", 
			"'fmt.Println('", "')'", "'if'", "'('", "'else'", "'switch'", "'for'", 
			"'break'", "'continue'", "'return'", "'case'", "':'", "'default'", "'append('", 
			"'strconv.Atoi('", "'strconv.ParseFloat('", "'reflect.TypeOf('", "'slices.Index('", 
			"'strings.Join('", "'len('", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", 
			"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'+='", 
			"'-='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "TIPO", "ENTERO", 
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8866466053993602L) != 0)) {
				{
				{
				setState(18);
				declaraciones();
				}
				}
				setState(23);
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
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				declaracion_arreglo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				declaracion_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
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
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(T__0);
				setState(30);
				match(IDENTIFICADOR);
				setState(31);
				match(TIPO);
				setState(32);
				match(T__1);
				setState(33);
				expresion(0);
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
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(T__0);
				setState(38);
				match(IDENTIFICADOR);
				setState(39);
				match(TIPO);
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
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(IDENTIFICADOR);
				setState(44);
				match(T__3);
				setState(45);
				expresion(0);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(46);
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFICADOR:
				_localctx = new DeclaracionArregloExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(IDENTIFICADOR);
				setState(52);
				match(T__3);
				setState(53);
				match(T__4);
				setState(54);
				match(T__5);
				setState(55);
				match(TIPO);
				setState(56);
				match(T__6);
				{
				setState(57);
				expresion(0);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(58);
					match(T__7);
					setState(59);
					expresion(0);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(65);
				match(T__8);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(66);
					match(T__2);
					}
				}

				}
				break;
			case T__0:
				_localctx = new DeclaracionArregloPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(T__0);
				setState(70);
				match(IDENTIFICADOR);
				setState(71);
				match(T__4);
				setState(72);
				match(T__5);
				setState(73);
				match(TIPO);
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
	public static class SentenciaReturnContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaReturnContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaBreakContext extends SentenciaContext {
		public SentenciaBreakContext(SentenciaContext ctx) { copyFrom(ctx); }
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
	public static class SentenciaContinueContext extends SentenciaContext {
		public SentenciaContinueContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionSentenciaContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExpresionSentenciaContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaForComplejaContext extends SentenciaContext {
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SentenciaForComplejaContext(SentenciaContext ctx) { copyFrom(ctx); }
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
	public static class SentenciaForSimpleContext extends SentenciaContext {
		public ExpresionContext condicion;
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaForSimpleContext(SentenciaContext ctx) { copyFrom(ctx); }
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
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ExpresionSentenciaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				expresion(0);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(80);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new FuncionEmbebidaPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(T__9);
				setState(84);
				expresion(0);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(85);
					match(T__7);
					setState(86);
					expresion(0);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				match(T__10);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(93);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(T__6);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8866466053993602L) != 0)) {
					{
					{
					setState(97);
					declaraciones();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new SentenciaIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				match(T__11);
				setState(110);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(105);
					match(T__12);
					setState(106);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					setState(107);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(109);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(112);
				sentencia();
				setState(115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(113);
					match(T__13);
					setState(114);
					sentencia();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new SentenciaSwitchContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				match(T__14);
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(118);
					match(T__12);
					setState(119);
					((SentenciaSwitchContext)_localctx).condicion = expresion(0);
					setState(120);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(122);
					((SentenciaSwitchContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(125);
				match(T__6);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(126);
					casos_switch();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(132);
					default_switch();
					}
				}

				setState(135);
				match(T__8);
				}
				break;
			case 6:
				_localctx = new SentenciaForSimpleContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(137);
				match(T__15);
				setState(143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(138);
					match(T__12);
					setState(139);
					((SentenciaForSimpleContext)_localctx).condicion = expresion(0);
					setState(140);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(142);
					((SentenciaForSimpleContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(145);
				sentencia();
				}
				break;
			case 7:
				_localctx = new SentenciaForComplejaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(T__15);
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(148);
					match(T__12);
					setState(149);
					for_init();
					setState(150);
					expresion(0);
					setState(151);
					match(T__2);
					setState(152);
					expresion(0);
					setState(153);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(155);
					for_init();
					setState(156);
					expresion(0);
					setState(157);
					match(T__2);
					setState(158);
					expresion(0);
					}
					break;
				}
				setState(162);
				sentencia();
				}
				break;
			case 8:
				_localctx = new SentenciaBreakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(164);
				match(T__16);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(165);
					match(T__2);
					}
				}

				}
				break;
			case 9:
				_localctx = new SentenciaContinueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(168);
				match(T__17);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(169);
					match(T__2);
					}
				}

				}
				break;
			case 10:
				_localctx = new SentenciaReturnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(172);
				match(T__18);
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(173);
					expresion(0);
					}
					break;
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(176);
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
			setState(181);
			match(T__19);
			setState(182);
			expresion(0);
			setState(183);
			match(T__20);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8866466053993602L) != 0)) {
				{
				{
				setState(184);
				declaraciones();
				}
				}
				setState(189);
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
			setState(190);
			match(T__21);
			setState(191);
			match(T__20);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8866466053993602L) != 0)) {
				{
				{
				setState(192);
				declaraciones();
				}
				}
				setState(197);
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
	public static class For_initContext extends ParserRuleContext {
		public Declaracion_variableContext declaracion_variable() {
			return getRuleContext(Declaracion_variableContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_for_init);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				declaracion_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				expresion(0);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new FuncionEmbebidaAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(203);
				match(T__22);
				setState(204);
				match(IDENTIFICADOR);
				setState(205);
				match(T__7);
				setState(206);
				expresion(0);
				setState(207);
				match(T__10);
				setState(209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(208);
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
				setState(211);
				match(T__23);
				setState(212);
				expresion(0);
				setState(213);
				match(T__10);
				setState(215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(214);
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
				setState(217);
				match(T__24);
				setState(218);
				expresion(0);
				setState(219);
				match(T__10);
				setState(221);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(220);
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
				setState(223);
				match(T__25);
				setState(224);
				expresion(0);
				setState(225);
				match(T__10);
				setState(227);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(226);
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
				setState(229);
				match(T__26);
				setState(230);
				match(IDENTIFICADOR);
				setState(231);
				match(T__7);
				setState(232);
				expresion(0);
				setState(233);
				match(T__10);
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(234);
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
				setState(237);
				match(T__27);
				setState(238);
				match(IDENTIFICADOR);
				setState(239);
				match(T__7);
				setState(240);
				expresion(0);
				setState(241);
				match(T__10);
				setState(243);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(242);
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
				setState(245);
				match(T__28);
				setState(246);
				match(IDENTIFICADOR);
				setState(247);
				match(T__10);
				setState(249);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(248);
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
				setState(251);
				((NegacionUnariaContext)_localctx).operador = match(T__29);
				setState(252);
				((NegacionUnariaContext)_localctx).izquierda = expresion(20);
				}
				break;
			case 9:
				{
				_localctx = new NegacionLogicaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				((NegacionLogicaContext)_localctx).operador = match(T__30);
				setState(254);
				((NegacionLogicaContext)_localctx).izquierda = expresion(19);
				}
				break;
			case 10:
				{
				_localctx = new AccesoArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(IDENTIFICADOR);
				setState(256);
				match(T__4);
				setState(257);
				expresion(0);
				setState(258);
				match(T__5);
				}
				break;
			case 11:
				{
				_localctx = new AsignacionArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(IDENTIFICADOR);
				setState(261);
				match(T__4);
				setState(262);
				((AsignacionArregloContext)_localctx).indice = expresion(0);
				setState(263);
				match(T__5);
				setState(264);
				match(T__1);
				setState(265);
				((AsignacionArregloContext)_localctx).valornuevo = expresion(11);
				}
				break;
			case 12:
				{
				_localctx = new AsignacionVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				match(IDENTIFICADOR);
				setState(268);
				match(T__1);
				setState(269);
				expresion(10);
				}
				break;
			case 13:
				{
				_localctx = new AsignacionVariableSumaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(IDENTIFICADOR);
				setState(271);
				match(T__43);
				setState(272);
				expresion(9);
				}
				break;
			case 14:
				{
				_localctx = new AsignacionVariableRestaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(IDENTIFICADOR);
				setState(274);
				match(T__44);
				setState(275);
				expresion(8);
				}
				break;
			case 15:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(BOOLEANO);
				}
				break;
			case 16:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(DECIMAL);
				}
				break;
			case 17:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(CARACTER);
				}
				break;
			case 18:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				match(CADENA);
				}
				break;
			case 19:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				match(ENTERO);
				}
				break;
			case 20:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				match(IDENTIFICADOR);
				}
				break;
			case 21:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(T__12);
				setState(283);
				expresion(0);
				setState(284);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(306);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionDivisionModuloContext(new ExpresionContext(_parentctx, _parentState));
						((MultiplicacionDivisionModuloContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(288);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(289);
						((MultiplicacionDivisionModuloContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) ) {
							((MultiplicacionDivisionModuloContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(290);
						((MultiplicacionDivisionModuloContext)_localctx).derecha = expresion(19);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						((SumaRestaContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(291);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(292);
						((SumaRestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__34) ) {
							((SumaRestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(293);
						((SumaRestaContext)_localctx).derecha = expresion(18);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalContext(new ExpresionContext(_parentctx, _parentState));
						((RelacionalContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(294);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(295);
						((RelacionalContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1030792151040L) != 0)) ) {
							((RelacionalContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(296);
						((RelacionalContext)_localctx).derecha = expresion(17);
						}
						break;
					case 4:
						{
						_localctx = new IgualdadDesigualdadContext(new ExpresionContext(_parentctx, _parentState));
						((IgualdadDesigualdadContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(297);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(298);
						((IgualdadDesigualdadContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__39 || _la==T__40) ) {
							((IgualdadDesigualdadContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(299);
						((IgualdadDesigualdadContext)_localctx).derecha = expresion(16);
						}
						break;
					case 5:
						{
						_localctx = new LogicoAndContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoAndContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(300);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(301);
						((LogicoAndContext)_localctx).operador = match(T__41);
						setState(302);
						((LogicoAndContext)_localctx).derecha = expresion(15);
						}
						break;
					case 6:
						{
						_localctx = new LogicoOrContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoOrContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(303);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(304);
						((LogicoOrContext)_localctx).operador = match(T__42);
						setState(305);
						((LogicoOrContext)_localctx).derecha = expresion(14);
						}
						break;
					}
					} 
				}
				setState(310);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
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
		"\u0004\u00017\u0138\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017"+
		"\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001c\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002$\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002*\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00020\b\u0002\u0003\u00022\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003=\b\u0003\n\u0003\f\u0003@\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003D\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003L\b\u0003\u0003\u0003N\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004R\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004X\b\u0004\n\u0004\f\u0004[\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004_\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004c\b\u0004\n\u0004\f\u0004f\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"o\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004t\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004|\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0080\b\u0004\n\u0004"+
		"\f\u0004\u0083\t\u0004\u0001\u0004\u0003\u0004\u0086\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0090\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00a1\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00a7\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00ab\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00af\b\u0004\u0001\u0004\u0003"+
		"\u0004\u00b2\b\u0004\u0003\u0004\u00b4\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00ba\b\u0005\n\u0005\f\u0005\u00bd"+
		"\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00c2\b\u0006"+
		"\n\u0006\f\u0006\u00c5\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00c9"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00d2\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00d8\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\u00de\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u00e4\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00ec\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00f4"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00fa\b\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u011f\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u0133\b\b\n\b\f\b\u0136\t\b\u0001\b\u0000\u0001\u0010\t\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0000\u0004\u0001\u0000 \"\u0002\u0000"+
		"\u001e\u001e##\u0001\u0000$\'\u0001\u0000()\u0176\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000"+
		"\u0000\u0006M\u0001\u0000\u0000\u0000\b\u00b3\u0001\u0000\u0000\u0000"+
		"\n\u00b5\u0001\u0000\u0000\u0000\f\u00be\u0001\u0000\u0000\u0000\u000e"+
		"\u00c8\u0001\u0000\u0000\u0000\u0010\u011e\u0001\u0000\u0000\u0000\u0012"+
		"\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014"+
		"\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0001\u0000\u0000\u0000\u0016\u0001\u0001\u0000\u0000\u0000\u0017"+
		"\u0015\u0001\u0000\u0000\u0000\u0018\u001c\u0003\u0006\u0003\u0000\u0019"+
		"\u001c\u0003\u0004\u0002\u0000\u001a\u001c\u0003\b\u0004\u0000\u001b\u0018"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0005\u0001\u0000\u0000\u001e\u001f\u00054\u0000\u0000\u001f \u0005."+
		"\u0000\u0000 !\u0005\u0002\u0000\u0000!#\u0003\u0010\b\u0000\"$\u0005"+
		"\u0003\u0000\u0000#\"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$2\u0001\u0000\u0000\u0000%&\u0005\u0001\u0000\u0000&\'\u00054\u0000\u0000"+
		"\')\u0005.\u0000\u0000(*\u0005\u0003\u0000\u0000)(\u0001\u0000\u0000\u0000"+
		")*\u0001\u0000\u0000\u0000*2\u0001\u0000\u0000\u0000+,\u00054\u0000\u0000"+
		",-\u0005\u0004\u0000\u0000-/\u0003\u0010\b\u0000.0\u0005\u0003\u0000\u0000"+
		"/.\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000\u0000"+
		"\u00001\u001d\u0001\u0000\u0000\u00001%\u0001\u0000\u0000\u00001+\u0001"+
		"\u0000\u0000\u00002\u0005\u0001\u0000\u0000\u000034\u00054\u0000\u0000"+
		"45\u0005\u0004\u0000\u000056\u0005\u0005\u0000\u000067\u0005\u0006\u0000"+
		"\u000078\u0005.\u0000\u000089\u0005\u0007\u0000\u00009>\u0003\u0010\b"+
		"\u0000:;\u0005\b\u0000\u0000;=\u0003\u0010\b\u0000<:\u0001\u0000\u0000"+
		"\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AC\u0005"+
		"\t\u0000\u0000BD\u0005\u0003\u0000\u0000CB\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DN\u0001\u0000\u0000\u0000EF\u0005\u0001\u0000\u0000"+
		"FG\u00054\u0000\u0000GH\u0005\u0005\u0000\u0000HI\u0005\u0006\u0000\u0000"+
		"IK\u0005.\u0000\u0000JL\u0005\u0003\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000M3\u0001\u0000\u0000"+
		"\u0000ME\u0001\u0000\u0000\u0000N\u0007\u0001\u0000\u0000\u0000OQ\u0003"+
		"\u0010\b\u0000PR\u0005\u0003\u0000\u0000QP\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000R\u00b4\u0001\u0000\u0000\u0000ST\u0005\n\u0000\u0000"+
		"TY\u0003\u0010\b\u0000UV\u0005\b\u0000\u0000VX\u0003\u0010\b\u0000WU\u0001"+
		"\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000\\^\u0005\u000b\u0000\u0000]_\u0005\u0003\u0000\u0000^]\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_\u00b4\u0001\u0000\u0000\u0000"+
		"`d\u0005\u0007\u0000\u0000ac\u0003\u0002\u0001\u0000ba\u0001\u0000\u0000"+
		"\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000g\u00b4"+
		"\u0005\t\u0000\u0000hn\u0005\f\u0000\u0000ij\u0005\r\u0000\u0000jk\u0003"+
		"\u0010\b\u0000kl\u0005\u000b\u0000\u0000lo\u0001\u0000\u0000\u0000mo\u0003"+
		"\u0010\b\u0000ni\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000ps\u0003\b\u0004\u0000qr\u0005\u000e\u0000\u0000rt\u0003"+
		"\b\u0004\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u00b4"+
		"\u0001\u0000\u0000\u0000u{\u0005\u000f\u0000\u0000vw\u0005\r\u0000\u0000"+
		"wx\u0003\u0010\b\u0000xy\u0005\u000b\u0000\u0000y|\u0001\u0000\u0000\u0000"+
		"z|\u0003\u0010\b\u0000{v\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}\u0081\u0005\u0007\u0000\u0000~\u0080\u0003"+
		"\n\u0005\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000"+
		"\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0084\u0086\u0003\f\u0006\u0000\u0085\u0084\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005\t\u0000\u0000\u0088\u00b4\u0001\u0000\u0000\u0000"+
		"\u0089\u008f\u0005\u0010\u0000\u0000\u008a\u008b\u0005\r\u0000\u0000\u008b"+
		"\u008c\u0003\u0010\b\u0000\u008c\u008d\u0005\u000b\u0000\u0000\u008d\u0090"+
		"\u0001\u0000\u0000\u0000\u008e\u0090\u0003\u0010\b\u0000\u008f\u008a\u0001"+
		"\u0000\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0003\b\u0004\u0000\u0092\u00b4\u0001\u0000"+
		"\u0000\u0000\u0093\u00a0\u0005\u0010\u0000\u0000\u0094\u0095\u0005\r\u0000"+
		"\u0000\u0095\u0096\u0003\u000e\u0007\u0000\u0096\u0097\u0003\u0010\b\u0000"+
		"\u0097\u0098\u0005\u0003\u0000\u0000\u0098\u0099\u0003\u0010\b\u0000\u0099"+
		"\u009a\u0005\u000b\u0000\u0000\u009a\u00a1\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0003\u000e\u0007\u0000\u009c\u009d\u0003\u0010\b\u0000\u009d\u009e"+
		"\u0005\u0003\u0000\u0000\u009e\u009f\u0003\u0010\b\u0000\u009f\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a0\u0094\u0001\u0000\u0000\u0000\u00a0\u009b\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0003"+
		"\b\u0004\u0000\u00a3\u00b4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0005\u0011"+
		"\u0000\u0000\u00a5\u00a7\u0005\u0003\u0000\u0000\u00a6\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00b4\u0001\u0000"+
		"\u0000\u0000\u00a8\u00aa\u0005\u0012\u0000\u0000\u00a9\u00ab\u0005\u0003"+
		"\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ab\u00b4\u0001\u0000\u0000\u0000\u00ac\u00ae\u0005\u0013"+
		"\u0000\u0000\u00ad\u00af\u0003\u0010\b\u0000\u00ae\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b2\u0005\u0003\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b3O\u0001\u0000\u0000\u0000\u00b3S\u0001\u0000\u0000\u0000\u00b3"+
		"`\u0001\u0000\u0000\u0000\u00b3h\u0001\u0000\u0000\u0000\u00b3u\u0001"+
		"\u0000\u0000\u0000\u00b3\u0089\u0001\u0000\u0000\u0000\u00b3\u0093\u0001"+
		"\u0000\u0000\u0000\u00b3\u00a4\u0001\u0000\u0000\u0000\u00b3\u00a8\u0001"+
		"\u0000\u0000\u0000\u00b3\u00ac\u0001\u0000\u0000\u0000\u00b4\t\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0005\u0014\u0000\u0000\u00b6\u00b7\u0003\u0010"+
		"\b\u0000\u00b7\u00bb\u0005\u0015\u0000\u0000\u00b8\u00ba\u0003\u0002\u0001"+
		"\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u000b\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0005\u0016\u0000\u0000\u00bf\u00c3\u0005\u0015\u0000"+
		"\u0000\u00c0\u00c2\u0003\u0002\u0001\u0000\u00c1\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\r\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c9\u0003\u0004\u0002\u0000"+
		"\u00c7\u00c9\u0003\u0010\b\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u000f\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0006\b\uffff\uffff\u0000\u00cb\u00cc\u0005\u0017\u0000\u0000\u00cc"+
		"\u00cd\u00054\u0000\u0000\u00cd\u00ce\u0005\b\u0000\u0000\u00ce\u00cf"+
		"\u0003\u0010\b\u0000\u00cf\u00d1\u0005\u000b\u0000\u0000\u00d0\u00d2\u0005"+
		"\u0003\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u011f\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		"\u0018\u0000\u0000\u00d4\u00d5\u0003\u0010\b\u0000\u00d5\u00d7\u0005\u000b"+
		"\u0000\u0000\u00d6\u00d8\u0005\u0003\u0000\u0000\u00d7\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u011f\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005\u0019\u0000\u0000\u00da\u00db\u0003\u0010"+
		"\b\u0000\u00db\u00dd\u0005\u000b\u0000\u0000\u00dc\u00de\u0005\u0003\u0000"+
		"\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de\u011f\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u001a\u0000"+
		"\u0000\u00e0\u00e1\u0003\u0010\b\u0000\u00e1\u00e3\u0005\u000b\u0000\u0000"+
		"\u00e2\u00e4\u0005\u0003\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u011f\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e6\u0005\u001b\u0000\u0000\u00e6\u00e7\u00054\u0000\u0000\u00e7"+
		"\u00e8\u0005\b\u0000\u0000\u00e8\u00e9\u0003\u0010\b\u0000\u00e9\u00eb"+
		"\u0005\u000b\u0000\u0000\u00ea\u00ec\u0005\u0003\u0000\u0000\u00eb\u00ea"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u011f"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u001c\u0000\u0000\u00ee\u00ef"+
		"\u00054\u0000\u0000\u00ef\u00f0\u0005\b\u0000\u0000\u00f0\u00f1\u0003"+
		"\u0010\b\u0000\u00f1\u00f3\u0005\u000b\u0000\u0000\u00f2\u00f4\u0005\u0003"+
		"\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f4\u011f\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u001d"+
		"\u0000\u0000\u00f6\u00f7\u00054\u0000\u0000\u00f7\u00f9\u0005\u000b\u0000"+
		"\u0000\u00f8\u00fa\u0005\u0003\u0000\u0000\u00f9\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u011f\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0005\u001e\u0000\u0000\u00fc\u011f\u0003\u0010\b\u0014"+
		"\u00fd\u00fe\u0005\u001f\u0000\u0000\u00fe\u011f\u0003\u0010\b\u0013\u00ff"+
		"\u0100\u00054\u0000\u0000\u0100\u0101\u0005\u0005\u0000\u0000\u0101\u0102"+
		"\u0003\u0010\b\u0000\u0102\u0103\u0005\u0006\u0000\u0000\u0103\u011f\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u00054\u0000\u0000\u0105\u0106\u0005\u0005"+
		"\u0000\u0000\u0106\u0107\u0003\u0010\b\u0000\u0107\u0108\u0005\u0006\u0000"+
		"\u0000\u0108\u0109\u0005\u0002\u0000\u0000\u0109\u010a\u0003\u0010\b\u000b"+
		"\u010a\u011f\u0001\u0000\u0000\u0000\u010b\u010c\u00054\u0000\u0000\u010c"+
		"\u010d\u0005\u0002\u0000\u0000\u010d\u011f\u0003\u0010\b\n\u010e\u010f"+
		"\u00054\u0000\u0000\u010f\u0110\u0005,\u0000\u0000\u0110\u011f\u0003\u0010"+
		"\b\t\u0111\u0112\u00054\u0000\u0000\u0112\u0113\u0005-\u0000\u0000\u0113"+
		"\u011f\u0003\u0010\b\b\u0114\u011f\u00052\u0000\u0000\u0115\u011f\u0005"+
		"0\u0000\u0000\u0116\u011f\u00053\u0000\u0000\u0117\u011f\u00051\u0000"+
		"\u0000\u0118\u011f\u0005/\u0000\u0000\u0119\u011f\u00054\u0000\u0000\u011a"+
		"\u011b\u0005\r\u0000\u0000\u011b\u011c\u0003\u0010\b\u0000\u011c\u011d"+
		"\u0005\u000b\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u00ca"+
		"\u0001\u0000\u0000\u0000\u011e\u00d3\u0001\u0000\u0000\u0000\u011e\u00d9"+
		"\u0001\u0000\u0000\u0000\u011e\u00df\u0001\u0000\u0000\u0000\u011e\u00e5"+
		"\u0001\u0000\u0000\u0000\u011e\u00ed\u0001\u0000\u0000\u0000\u011e\u00f5"+
		"\u0001\u0000\u0000\u0000\u011e\u00fb\u0001\u0000\u0000\u0000\u011e\u00fd"+
		"\u0001\u0000\u0000\u0000\u011e\u00ff\u0001\u0000\u0000\u0000\u011e\u0104"+
		"\u0001\u0000\u0000\u0000\u011e\u010b\u0001\u0000\u0000\u0000\u011e\u010e"+
		"\u0001\u0000\u0000\u0000\u011e\u0111\u0001\u0000\u0000\u0000\u011e\u0114"+
		"\u0001\u0000\u0000\u0000\u011e\u0115\u0001\u0000\u0000\u0000\u011e\u0116"+
		"\u0001\u0000\u0000\u0000\u011e\u0117\u0001\u0000\u0000\u0000\u011e\u0118"+
		"\u0001\u0000\u0000\u0000\u011e\u0119\u0001\u0000\u0000\u0000\u011e\u011a"+
		"\u0001\u0000\u0000\u0000\u011f\u0134\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\n\u0012\u0000\u0000\u0121\u0122\u0007\u0000\u0000\u0000\u0122\u0133\u0003"+
		"\u0010\b\u0013\u0123\u0124\n\u0011\u0000\u0000\u0124\u0125\u0007\u0001"+
		"\u0000\u0000\u0125\u0133\u0003\u0010\b\u0012\u0126\u0127\n\u0010\u0000"+
		"\u0000\u0127\u0128\u0007\u0002\u0000\u0000\u0128\u0133\u0003\u0010\b\u0011"+
		"\u0129\u012a\n\u000f\u0000\u0000\u012a\u012b\u0007\u0003\u0000\u0000\u012b"+
		"\u0133\u0003\u0010\b\u0010\u012c\u012d\n\u000e\u0000\u0000\u012d\u012e"+
		"\u0005*\u0000\u0000\u012e\u0133\u0003\u0010\b\u000f\u012f\u0130\n\r\u0000"+
		"\u0000\u0130\u0131\u0005+\u0000\u0000\u0131\u0133\u0003\u0010\b\u000e"+
		"\u0132\u0120\u0001\u0000\u0000\u0000\u0132\u0123\u0001\u0000\u0000\u0000"+
		"\u0132\u0126\u0001\u0000\u0000\u0000\u0132\u0129\u0001\u0000\u0000\u0000"+
		"\u0132\u012c\u0001\u0000\u0000\u0000\u0132\u012f\u0001\u0000\u0000\u0000"+
		"\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0011\u0001\u0000\u0000\u0000"+
		"\u0136\u0134\u0001\u0000\u0000\u0000\'\u0015\u001b#)/1>CKMQY^dns{\u0081"+
		"\u0085\u008f\u00a0\u00a6\u00aa\u00ae\u00b1\u00b3\u00bb\u00c3\u00c8\u00d1"+
		"\u00d7\u00dd\u00e3\u00eb\u00f3\u00f9\u011e\u0132\u0134";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}