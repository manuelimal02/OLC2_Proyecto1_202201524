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
		T__45=46, TIPO=47, ENTERO=48, DECIMAL=49, CADENA=50, BOOLEANO=51, CARACTER=52, 
		IDENTIFICADOR=53, WS=54, COMENTARIOL=55, COMENTARIOLN=56;
	public static final int
		RULE_program = 0, RULE_declaraciones = 1, RULE_declaracion_variable = 2, 
		RULE_declaracion_arreglo = 3, RULE_declaracion_matriz = 4, RULE_dimensiones = 5, 
		RULE_contenido_matriz = 6, RULE_elementos_matriz = 7, RULE_elemento_matriz = 8, 
		RULE_lista_valores = 9, RULE_sentencia = 10, RULE_casos_switch = 11, RULE_default_switch = 12, 
		RULE_for_init = 13, RULE_expresion = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaraciones", "declaracion_variable", "declaracion_arreglo", 
			"declaracion_matriz", "dimensiones", "contenido_matriz", "elementos_matriz", 
			"elemento_matriz", "lista_valores", "sentencia", "casos_switch", "default_switch", 
			"for_init", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'['", "']'", "'{'", "','", "'}'", 
			"'fmt.Println('", "')'", "'if'", "'('", "'else'", "'switch'", "'for'", 
			"'range'", "'break'", "'continue'", "'return'", "'case'", "':'", "'default'", 
			"'append('", "'strconv.Atoi('", "'strconv.ParseFloat('", "'reflect.TypeOf('", 
			"'slices.Index('", "'strings.Join('", "'len('", "'-'", "'!'", "'*'", 
			"'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", 
			"'||'", "'+='", "'-='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "TIPO", 
			"ENTERO", "DECIMAL", "CADENA", "BOOLEANO", "CARACTER", "IDENTIFICADOR", 
			"WS", "COMENTARIOL", "COMENTARIOLN"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732932107875458L) != 0)) {
				{
				{
				setState(30);
				declaraciones();
				}
				}
				setState(35);
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
		public Declaracion_matrizContext declaracion_matriz() {
			return getRuleContext(Declaracion_matrizContext.class,0);
		}
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
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				declaracion_matriz();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				declaracion_arreglo();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				declaracion_variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
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
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DeclaracionExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				match(T__0);
				setState(43);
				match(IDENTIFICADOR);
				setState(44);
				match(TIPO);
				setState(45);
				match(T__1);
				setState(46);
				expresion(0);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(47);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new DeclaracionPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__0);
				setState(51);
				match(IDENTIFICADOR);
				setState(52);
				match(TIPO);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(53);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new DeclaracionImplicitaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(IDENTIFICADOR);
				setState(57);
				match(T__3);
				setState(58);
				expresion(0);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(59);
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFICADOR:
				_localctx = new DeclaracionArregloExplicitaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(IDENTIFICADOR);
				setState(65);
				match(T__3);
				setState(66);
				match(T__4);
				setState(67);
				match(T__5);
				setState(68);
				match(TIPO);
				setState(69);
				match(T__6);
				{
				setState(70);
				expresion(0);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(71);
					match(T__7);
					setState(72);
					expresion(0);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(78);
				match(T__8);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(79);
					match(T__2);
					}
				}

				}
				break;
			case T__0:
				_localctx = new DeclaracionArregloPorDefectoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(T__0);
				setState(83);
				match(IDENTIFICADOR);
				setState(84);
				match(T__4);
				setState(85);
				match(T__5);
				setState(86);
				match(TIPO);
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
	public static class Declaracion_matrizContext extends ParserRuleContext {
		public Declaracion_matrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion_matriz; }
	 
		public Declaracion_matrizContext() { }
		public void copyFrom(Declaracion_matrizContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionMatrizExplicitaContext extends Declaracion_matrizContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public DimensionesContext dimensiones() {
			return getRuleContext(DimensionesContext.class,0);
		}
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public Contenido_matrizContext contenido_matriz() {
			return getRuleContext(Contenido_matrizContext.class,0);
		}
		public DeclaracionMatrizExplicitaContext(Declaracion_matrizContext ctx) { copyFrom(ctx); }
	}

	public final Declaracion_matrizContext declaracion_matriz() throws RecognitionException {
		Declaracion_matrizContext _localctx = new Declaracion_matrizContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracion_matriz);
		int _la;
		try {
			_localctx = new DeclaracionMatrizExplicitaContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IDENTIFICADOR);
			setState(93);
			match(T__3);
			setState(94);
			dimensiones();
			setState(95);
			match(TIPO);
			setState(96);
			contenido_matriz();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(97);
				match(T__2);
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
	public static class DimensionesContext extends ParserRuleContext {
		public DimensionesContext dimensiones() {
			return getRuleContext(DimensionesContext.class,0);
		}
		public DimensionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensiones; }
	}

	public final DimensionesContext dimensiones() throws RecognitionException {
		DimensionesContext _localctx = new DimensionesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dimensiones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__4);
			setState(101);
			match(T__5);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(102);
				dimensiones();
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
	public static class Contenido_matrizContext extends ParserRuleContext {
		public Elementos_matrizContext elementos_matriz() {
			return getRuleContext(Elementos_matrizContext.class,0);
		}
		public Contenido_matrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contenido_matriz; }
	}

	public final Contenido_matrizContext contenido_matriz() throws RecognitionException {
		Contenido_matrizContext _localctx = new Contenido_matrizContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_contenido_matriz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__6);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(106);
				elementos_matriz();
				}
			}

			setState(109);
			match(T__8);
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
	public static class Elementos_matrizContext extends ParserRuleContext {
		public List<Elemento_matrizContext> elemento_matriz() {
			return getRuleContexts(Elemento_matrizContext.class);
		}
		public Elemento_matrizContext elemento_matriz(int i) {
			return getRuleContext(Elemento_matrizContext.class,i);
		}
		public Elementos_matrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementos_matriz; }
	}

	public final Elementos_matrizContext elementos_matriz() throws RecognitionException {
		Elementos_matrizContext _localctx = new Elementos_matrizContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elementos_matriz);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			elemento_matriz();
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(112);
					match(T__7);
					setState(113);
					elemento_matriz();
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(119);
				match(T__7);
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
	public static class Elemento_matrizContext extends ParserRuleContext {
		public Contenido_matrizContext contenido_matriz() {
			return getRuleContext(Contenido_matrizContext.class,0);
		}
		public Lista_valoresContext lista_valores() {
			return getRuleContext(Lista_valoresContext.class,0);
		}
		public Elemento_matrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemento_matriz; }
	}

	public final Elemento_matrizContext elemento_matriz() throws RecognitionException {
		Elemento_matrizContext _localctx = new Elemento_matrizContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elemento_matriz);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				contenido_matriz();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				lista_valores();
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
	public static class Lista_valoresContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public Lista_valoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_valores; }
	}

	public final Lista_valoresContext lista_valores() throws RecognitionException {
		Lista_valoresContext _localctx = new Lista_valoresContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lista_valores);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__6);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732932105936896L) != 0)) {
				{
				setState(127);
				expresion(0);
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(128);
						match(T__7);
						setState(129);
						expresion(0);
						}
						} 
					}
					setState(134);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(135);
					match(T__7);
					}
				}

				}
			}

			setState(140);
			match(T__8);
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
	public static class SentenciaForRangeContext extends SentenciaContext {
		public Token indice;
		public Token valor;
		public Token slice;
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(LanguageParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(LanguageParser.IDENTIFICADOR, i);
		}
		public SentenciaForRangeContext(SentenciaContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaForCompuestaContext extends SentenciaContext {
		public ExpresionContext condicion;
		public ExpresionContext incremento;
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SentenciaForCompuestaContext(SentenciaContext ctx) { copyFrom(ctx); }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentencia);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new ExpresionSentenciaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				expresion(0);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(143);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				_localctx = new FuncionEmbebidaPrintlnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(T__9);
				setState(147);
				expresion(0);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(148);
					match(T__7);
					setState(149);
					expresion(0);
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(155);
				match(T__10);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(156);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(T__6);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732932107875458L) != 0)) {
					{
					{
					setState(160);
					declaraciones();
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new SentenciaIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(T__11);
				setState(173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(168);
					match(T__12);
					setState(169);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					setState(170);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(172);
					((SentenciaIfContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(175);
				sentencia();
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(176);
					match(T__13);
					setState(177);
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
				setState(180);
				match(T__14);
				setState(186);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(181);
					match(T__12);
					setState(182);
					((SentenciaSwitchContext)_localctx).condicion = expresion(0);
					setState(183);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(185);
					((SentenciaSwitchContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(188);
				match(T__6);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(189);
					casos_switch();
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(195);
					default_switch();
					}
				}

				setState(198);
				match(T__8);
				}
				break;
			case 6:
				_localctx = new SentenciaForSimpleContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				match(T__15);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(201);
					match(T__12);
					setState(202);
					((SentenciaForSimpleContext)_localctx).condicion = expresion(0);
					setState(203);
					match(T__10);
					}
					break;
				case 2:
					{
					setState(205);
					((SentenciaForSimpleContext)_localctx).condicion = expresion(0);
					}
					break;
				}
				setState(208);
				sentencia();
				}
				break;
			case 7:
				_localctx = new SentenciaForCompuestaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(210);
				match(T__15);
				setState(211);
				for_init();
				setState(212);
				((SentenciaForCompuestaContext)_localctx).condicion = expresion(0);
				setState(213);
				match(T__2);
				setState(214);
				((SentenciaForCompuestaContext)_localctx).incremento = expresion(0);
				setState(215);
				sentencia();
				}
				break;
			case 8:
				_localctx = new SentenciaForRangeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(217);
				match(T__15);
				setState(218);
				((SentenciaForRangeContext)_localctx).indice = match(IDENTIFICADOR);
				setState(219);
				match(T__7);
				setState(220);
				((SentenciaForRangeContext)_localctx).valor = match(IDENTIFICADOR);
				setState(221);
				match(T__3);
				setState(222);
				match(T__16);
				setState(223);
				((SentenciaForRangeContext)_localctx).slice = match(IDENTIFICADOR);
				setState(224);
				sentencia();
				}
				break;
			case 9:
				_localctx = new SentenciaBreakContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(225);
				match(T__17);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(226);
					match(T__2);
					}
				}

				}
				break;
			case 10:
				_localctx = new SentenciaContinueContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(229);
				match(T__18);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(230);
					match(T__2);
					}
				}

				}
				break;
			case 11:
				_localctx = new SentenciaReturnContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(233);
				match(T__19);
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(234);
					expresion(0);
					}
					break;
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(237);
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
		enterRule(_localctx, 22, RULE_casos_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__20);
			setState(243);
			expresion(0);
			setState(244);
			match(T__21);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732932107875458L) != 0)) {
				{
				{
				setState(245);
				declaraciones();
				}
				}
				setState(250);
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
		enterRule(_localctx, 24, RULE_default_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__22);
			setState(252);
			match(T__21);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732932107875458L) != 0)) {
				{
				{
				setState(253);
				declaraciones();
				}
				}
				setState(258);
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
		enterRule(_localctx, 26, RULE_for_init);
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				declaracion_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
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
	public static class AccesoMatrizContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AccesoMatrizContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionMatrizContext extends ExpresionContext {
		public ExpresionContext valornuevo;
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AsignacionMatrizContext(ExpresionContext ctx) { copyFrom(ctx); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				_localctx = new FuncionEmbebidaAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(264);
				match(T__23);
				setState(265);
				match(IDENTIFICADOR);
				setState(266);
				match(T__7);
				setState(267);
				expresion(0);
				setState(268);
				match(T__10);
				setState(270);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(269);
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
				setState(272);
				match(T__24);
				setState(273);
				expresion(0);
				setState(274);
				match(T__10);
				setState(276);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(275);
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
				setState(278);
				match(T__25);
				setState(279);
				expresion(0);
				setState(280);
				match(T__10);
				setState(282);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(281);
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
				setState(284);
				match(T__26);
				setState(285);
				expresion(0);
				setState(286);
				match(T__10);
				setState(288);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(287);
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
				setState(290);
				match(T__27);
				setState(291);
				match(IDENTIFICADOR);
				setState(292);
				match(T__7);
				setState(293);
				expresion(0);
				setState(294);
				match(T__10);
				setState(296);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(295);
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
				setState(298);
				match(T__28);
				setState(299);
				match(IDENTIFICADOR);
				setState(300);
				match(T__7);
				setState(301);
				expresion(0);
				setState(302);
				match(T__10);
				setState(304);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(303);
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
				setState(306);
				match(T__29);
				setState(307);
				match(IDENTIFICADOR);
				setState(308);
				match(T__10);
				setState(310);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(309);
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
				setState(312);
				((NegacionUnariaContext)_localctx).operador = match(T__30);
				setState(313);
				((NegacionUnariaContext)_localctx).izquierda = expresion(22);
				}
				break;
			case 9:
				{
				_localctx = new NegacionLogicaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				((NegacionLogicaContext)_localctx).operador = match(T__31);
				setState(315);
				((NegacionLogicaContext)_localctx).izquierda = expresion(21);
				}
				break;
			case 10:
				{
				_localctx = new AccesoMatrizContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(316);
				match(IDENTIFICADOR);
				setState(321); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(317);
						match(T__4);
						setState(318);
						expresion(0);
						setState(319);
						match(T__5);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(323); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 11:
				{
				_localctx = new AccesoArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				match(IDENTIFICADOR);
				setState(326);
				match(T__4);
				setState(327);
				expresion(0);
				setState(328);
				match(T__5);
				}
				break;
			case 12:
				{
				_localctx = new AsignacionArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				match(IDENTIFICADOR);
				setState(331);
				match(T__4);
				setState(332);
				((AsignacionArregloContext)_localctx).indice = expresion(0);
				setState(333);
				match(T__5);
				setState(334);
				match(T__1);
				setState(335);
				((AsignacionArregloContext)_localctx).valornuevo = expresion(12);
				}
				break;
			case 13:
				{
				_localctx = new AsignacionMatrizContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337);
				match(IDENTIFICADOR);
				setState(342); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(338);
					match(T__4);
					setState(339);
					expresion(0);
					setState(340);
					match(T__5);
					}
					}
					setState(344); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				setState(346);
				match(T__1);
				setState(347);
				((AsignacionMatrizContext)_localctx).valornuevo = expresion(11);
				}
				break;
			case 14:
				{
				_localctx = new AsignacionVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349);
				match(IDENTIFICADOR);
				setState(350);
				match(T__1);
				setState(351);
				expresion(10);
				}
				break;
			case 15:
				{
				_localctx = new AsignacionVariableSumaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(352);
				match(IDENTIFICADOR);
				setState(353);
				match(T__44);
				setState(354);
				expresion(9);
				}
				break;
			case 16:
				{
				_localctx = new AsignacionVariableRestaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(355);
				match(IDENTIFICADOR);
				setState(356);
				match(T__45);
				setState(357);
				expresion(8);
				}
				break;
			case 17:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(358);
				match(BOOLEANO);
				}
				break;
			case 18:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(359);
				match(DECIMAL);
				}
				break;
			case 19:
				{
				_localctx = new CaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(360);
				match(CARACTER);
				}
				break;
			case 20:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(361);
				match(CADENA);
				}
				break;
			case 21:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362);
				match(ENTERO);
				}
				break;
			case 22:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(363);
				match(IDENTIFICADOR);
				}
				break;
			case 23:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				match(T__12);
				setState(365);
				expresion(0);
				setState(366);
				match(T__10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(388);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionDivisionModuloContext(new ExpresionContext(_parentctx, _parentState));
						((MultiplicacionDivisionModuloContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(370);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(371);
						((MultiplicacionDivisionModuloContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
							((MultiplicacionDivisionModuloContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(372);
						((MultiplicacionDivisionModuloContext)_localctx).derecha = expresion(21);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						((SumaRestaContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(373);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(374);
						((SumaRestaContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__35) ) {
							((SumaRestaContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(375);
						((SumaRestaContext)_localctx).derecha = expresion(20);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalContext(new ExpresionContext(_parentctx, _parentState));
						((RelacionalContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(376);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(377);
						((RelacionalContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2061584302080L) != 0)) ) {
							((RelacionalContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(378);
						((RelacionalContext)_localctx).derecha = expresion(19);
						}
						break;
					case 4:
						{
						_localctx = new IgualdadDesigualdadContext(new ExpresionContext(_parentctx, _parentState));
						((IgualdadDesigualdadContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(379);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(380);
						((IgualdadDesigualdadContext)_localctx).operador = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__40 || _la==T__41) ) {
							((IgualdadDesigualdadContext)_localctx).operador = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(381);
						((IgualdadDesigualdadContext)_localctx).derecha = expresion(18);
						}
						break;
					case 5:
						{
						_localctx = new LogicoAndContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoAndContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(382);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(383);
						((LogicoAndContext)_localctx).operador = match(T__42);
						setState(384);
						((LogicoAndContext)_localctx).derecha = expresion(17);
						}
						break;
					case 6:
						{
						_localctx = new LogicoOrContext(new ExpresionContext(_parentctx, _parentState));
						((LogicoOrContext)_localctx).izquierda = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(385);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(386);
						((LogicoOrContext)_localctx).operador = match(T__43);
						setState(387);
						((LogicoOrContext)_localctx).derecha = expresion(16);
						}
						break;
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		case 14:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u018a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00021\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003J\b\u0003"+
		"\n\u0003\f\u0003M\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003Q\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003Y\b\u0003\u0003\u0003[\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004c\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005h\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0003\u0006l\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007s\b\u0007\n\u0007\f\u0007v\t\u0007\u0001"+
		"\u0007\u0003\u0007y\b\u0007\u0001\b\u0001\b\u0003\b}\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0083\b\t\n\t\f\t\u0086\t\t\u0001\t\u0003\t"+
		"\u0089\b\t\u0003\t\u008b\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u0091"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0097\b\n\n\n\f\n\u009a\t"+
		"\n\u0001\n\u0001\n\u0003\n\u009e\b\n\u0001\n\u0001\n\u0005\n\u00a2\b\n"+
		"\n\n\f\n\u00a5\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00ae\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b3\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bb\b\n\u0001\n\u0001"+
		"\n\u0005\n\u00bf\b\n\n\n\f\n\u00c2\t\n\u0001\n\u0003\n\u00c5\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00cf"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00e4\b\n\u0001\n\u0001\n\u0003\n\u00e8\b\n\u0001\n"+
		"\u0001\n\u0003\n\u00ec\b\n\u0001\n\u0003\n\u00ef\b\n\u0003\n\u00f1\b\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00f7\b\u000b"+
		"\n\u000b\f\u000b\u00fa\t\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00ff\b"+
		"\f\n\f\f\f\u0102\t\f\u0001\r\u0001\r\u0003\r\u0106\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u010f\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0115\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u011b\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0121\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0129\b\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0131\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0137\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0142\b\u000e\u000b\u000e\f"+
		"\u000e\u0143\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0004\u000e\u0157\b\u000e\u000b\u000e\f\u000e\u0158\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0171\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0185"+
		"\b\u000e\n\u000e\f\u000e\u0188\t\u000e\u0001\u000e\u0000\u0001\u001c\u000f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u0000\u0004\u0001\u0000!#\u0002\u0000\u001f\u001f$$\u0001\u0000"+
		"%(\u0001\u0000)*\u01d0\u0000!\u0001\u0000\u0000\u0000\u0002(\u0001\u0000"+
		"\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006Z\u0001\u0000\u0000\u0000"+
		"\b\\\u0001\u0000\u0000\u0000\nd\u0001\u0000\u0000\u0000\fi\u0001\u0000"+
		"\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010|\u0001\u0000\u0000\u0000"+
		"\u0012~\u0001\u0000\u0000\u0000\u0014\u00f0\u0001\u0000\u0000\u0000\u0016"+
		"\u00f2\u0001\u0000\u0000\u0000\u0018\u00fb\u0001\u0000\u0000\u0000\u001a"+
		"\u0105\u0001\u0000\u0000\u0000\u001c\u0170\u0001\u0000\u0000\u0000\u001e"+
		" \u0003\u0002\u0001\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"\u0001\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$)\u0003"+
		"\b\u0004\u0000%)\u0003\u0006\u0003\u0000&)\u0003\u0004\u0002\u0000\')"+
		"\u0003\u0014\n\u0000($\u0001\u0000\u0000\u0000(%\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000)\u0003\u0001\u0000"+
		"\u0000\u0000*+\u0005\u0001\u0000\u0000+,\u00055\u0000\u0000,-\u0005/\u0000"+
		"\u0000-.\u0005\u0002\u0000\u0000.0\u0003\u001c\u000e\u0000/1\u0005\u0003"+
		"\u0000\u00000/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001?\u0001"+
		"\u0000\u0000\u000023\u0005\u0001\u0000\u000034\u00055\u0000\u000046\u0005"+
		"/\u0000\u000057\u0005\u0003\u0000\u000065\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u00007?\u0001\u0000\u0000\u000089\u00055\u0000\u00009:\u0005"+
		"\u0004\u0000\u0000:<\u0003\u001c\u000e\u0000;=\u0005\u0003\u0000\u0000"+
		"<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000"+
		"\u0000>*\u0001\u0000\u0000\u0000>2\u0001\u0000\u0000\u0000>8\u0001\u0000"+
		"\u0000\u0000?\u0005\u0001\u0000\u0000\u0000@A\u00055\u0000\u0000AB\u0005"+
		"\u0004\u0000\u0000BC\u0005\u0005\u0000\u0000CD\u0005\u0006\u0000\u0000"+
		"DE\u0005/\u0000\u0000EF\u0005\u0007\u0000\u0000FK\u0003\u001c\u000e\u0000"+
		"GH\u0005\b\u0000\u0000HJ\u0003\u001c\u000e\u0000IG\u0001\u0000\u0000\u0000"+
		"JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u0005\t\u0000"+
		"\u0000OQ\u0005\u0003\u0000\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000Q[\u0001\u0000\u0000\u0000RS\u0005\u0001\u0000\u0000ST\u0005"+
		"5\u0000\u0000TU\u0005\u0005\u0000\u0000UV\u0005\u0006\u0000\u0000VX\u0005"+
		"/\u0000\u0000WY\u0005\u0003\u0000\u0000XW\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000Z@\u0001\u0000\u0000\u0000"+
		"ZR\u0001\u0000\u0000\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u00055\u0000"+
		"\u0000]^\u0005\u0004\u0000\u0000^_\u0003\n\u0005\u0000_`\u0005/\u0000"+
		"\u0000`b\u0003\f\u0006\u0000ac\u0005\u0003\u0000\u0000ba\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000c\t\u0001\u0000\u0000\u0000de\u0005\u0005"+
		"\u0000\u0000eg\u0005\u0006\u0000\u0000fh\u0003\n\u0005\u0000gf\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000h\u000b\u0001\u0000\u0000\u0000"+
		"ik\u0005\u0007\u0000\u0000jl\u0003\u000e\u0007\u0000kj\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005\t\u0000"+
		"\u0000n\r\u0001\u0000\u0000\u0000ot\u0003\u0010\b\u0000pq\u0005\b\u0000"+
		"\u0000qs\u0003\u0010\b\u0000rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000"+
		"\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000ux\u0001\u0000"+
		"\u0000\u0000vt\u0001\u0000\u0000\u0000wy\u0005\b\u0000\u0000xw\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000y\u000f\u0001\u0000\u0000\u0000"+
		"z}\u0003\f\u0006\u0000{}\u0003\u0012\t\u0000|z\u0001\u0000\u0000\u0000"+
		"|{\u0001\u0000\u0000\u0000}\u0011\u0001\u0000\u0000\u0000~\u008a\u0005"+
		"\u0007\u0000\u0000\u007f\u0084\u0003\u001c\u000e\u0000\u0080\u0081\u0005"+
		"\b\u0000\u0000\u0081\u0083\u0003\u001c\u000e\u0000\u0082\u0080\u0001\u0000"+
		"\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000"+
		"\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0089\u0005\b\u0000"+
		"\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u007f\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0005\t\u0000\u0000\u008d\u0013\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0003\u001c\u000e\u0000\u008f\u0091\u0005\u0003\u0000\u0000"+
		"\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u00f1\u0001\u0000\u0000\u0000\u0092\u0093\u0005\n\u0000\u0000\u0093"+
		"\u0098\u0003\u001c\u000e\u0000\u0094\u0095\u0005\b\u0000\u0000\u0095\u0097"+
		"\u0003\u001c\u000e\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009b\u009d\u0005\u000b\u0000\u0000\u009c\u009e"+
		"\u0005\u0003\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u00f1\u0001\u0000\u0000\u0000\u009f\u00a3"+
		"\u0005\u0007\u0000\u0000\u00a0\u00a2\u0003\u0002\u0001\u0000\u00a1\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00f1"+
		"\u0005\t\u0000\u0000\u00a7\u00ad\u0005\f\u0000\u0000\u00a8\u00a9\u0005"+
		"\r\u0000\u0000\u00a9\u00aa\u0003\u001c\u000e\u0000\u00aa\u00ab\u0005\u000b"+
		"\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00ae\u0003\u001c"+
		"\u000e\u0000\u00ad\u00a8\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b2\u0003\u0014"+
		"\n\u0000\u00b0\u00b1\u0005\u000e\u0000\u0000\u00b1\u00b3\u0003\u0014\n"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3\u00f1\u0001\u0000\u0000\u0000\u00b4\u00ba\u0005\u000f\u0000"+
		"\u0000\u00b5\u00b6\u0005\r\u0000\u0000\u00b6\u00b7\u0003\u001c\u000e\u0000"+
		"\u00b7\u00b8\u0005\u000b\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bb\u0003\u001c\u000e\u0000\u00ba\u00b5\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00c0\u0005\u0007\u0000\u0000\u00bd\u00bf\u0003\u0016\u000b\u0000"+
		"\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c5\u0003\u0018\f\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0005\t\u0000\u0000\u00c7\u00f1\u0001\u0000\u0000\u0000\u00c8\u00ce"+
		"\u0005\u0010\u0000\u0000\u00c9\u00ca\u0005\r\u0000\u0000\u00ca\u00cb\u0003"+
		"\u001c\u000e\u0000\u00cb\u00cc\u0005\u000b\u0000\u0000\u00cc\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cf\u0003\u001c\u000e\u0000\u00ce\u00c9\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0003\u0014\n\u0000\u00d1\u00f1\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0005\u0010\u0000\u0000\u00d3\u00d4\u0003\u001a"+
		"\r\u0000\u00d4\u00d5\u0003\u001c\u000e\u0000\u00d5\u00d6\u0005\u0003\u0000"+
		"\u0000\u00d6\u00d7\u0003\u001c\u000e\u0000\u00d7\u00d8\u0003\u0014\n\u0000"+
		"\u00d8\u00f1\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\u0010\u0000\u0000"+
		"\u00da\u00db\u00055\u0000\u0000\u00db\u00dc\u0005\b\u0000\u0000\u00dc"+
		"\u00dd\u00055\u0000\u0000\u00dd\u00de\u0005\u0004\u0000\u0000\u00de\u00df"+
		"\u0005\u0011\u0000\u0000\u00df\u00e0\u00055\u0000\u0000\u00e0\u00f1\u0003"+
		"\u0014\n\u0000\u00e1\u00e3\u0005\u0012\u0000\u0000\u00e2\u00e4\u0005\u0003"+
		"\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e4\u00f1\u0001\u0000\u0000\u0000\u00e5\u00e7\u0005\u0013"+
		"\u0000\u0000\u00e6\u00e8\u0005\u0003\u0000\u0000\u00e7\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00f1\u0001\u0000"+
		"\u0000\u0000\u00e9\u00eb\u0005\u0014\u0000\u0000\u00ea\u00ec\u0003\u001c"+
		"\u000e\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00ef\u0005\u0003"+
		"\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u008e\u0001\u0000"+
		"\u0000\u0000\u00f0\u0092\u0001\u0000\u0000\u0000\u00f0\u009f\u0001\u0000"+
		"\u0000\u0000\u00f0\u00a7\u0001\u0000\u0000\u0000\u00f0\u00b4\u0001\u0000"+
		"\u0000\u0000\u00f0\u00c8\u0001\u0000\u0000\u0000\u00f0\u00d2\u0001\u0000"+
		"\u0000\u0000\u00f0\u00d9\u0001\u0000\u0000\u0000\u00f0\u00e1\u0001\u0000"+
		"\u0000\u0000\u00f0\u00e5\u0001\u0000\u0000\u0000\u00f0\u00e9\u0001\u0000"+
		"\u0000\u0000\u00f1\u0015\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0015"+
		"\u0000\u0000\u00f3\u00f4\u0003\u001c\u000e\u0000\u00f4\u00f8\u0005\u0016"+
		"\u0000\u0000\u00f5\u00f7\u0003\u0002\u0001\u0000\u00f6\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u0017\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005\u0017"+
		"\u0000\u0000\u00fc\u0100\u0005\u0016\u0000\u0000\u00fd\u00ff\u0003\u0002"+
		"\u0001\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000"+
		"\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000"+
		"\u0000\u0000\u0101\u0019\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000"+
		"\u0000\u0000\u0103\u0106\u0003\u0004\u0002\u0000\u0104\u0106\u0003\u001c"+
		"\u000e\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0104\u0001\u0000"+
		"\u0000\u0000\u0106\u001b\u0001\u0000\u0000\u0000\u0107\u0108\u0006\u000e"+
		"\uffff\uffff\u0000\u0108\u0109\u0005\u0018\u0000\u0000\u0109\u010a\u0005"+
		"5\u0000\u0000\u010a\u010b\u0005\b\u0000\u0000\u010b\u010c\u0003\u001c"+
		"\u000e\u0000\u010c\u010e\u0005\u000b\u0000\u0000\u010d\u010f\u0005\u0003"+
		"\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u0171\u0001\u0000\u0000\u0000\u0110\u0111\u0005\u0019"+
		"\u0000\u0000\u0111\u0112\u0003\u001c\u000e\u0000\u0112\u0114\u0005\u000b"+
		"\u0000\u0000\u0113\u0115\u0005\u0003\u0000\u0000\u0114\u0113\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0171\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0005\u001a\u0000\u0000\u0117\u0118\u0003\u001c"+
		"\u000e\u0000\u0118\u011a\u0005\u000b\u0000\u0000\u0119\u011b\u0005\u0003"+
		"\u0000\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000"+
		"\u0000\u0000\u011b\u0171\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u001b"+
		"\u0000\u0000\u011d\u011e\u0003\u001c\u000e\u0000\u011e\u0120\u0005\u000b"+
		"\u0000\u0000\u011f\u0121\u0005\u0003\u0000\u0000\u0120\u011f\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0171\u0001\u0000"+
		"\u0000\u0000\u0122\u0123\u0005\u001c\u0000\u0000\u0123\u0124\u00055\u0000"+
		"\u0000\u0124\u0125\u0005\b\u0000\u0000\u0125\u0126\u0003\u001c\u000e\u0000"+
		"\u0126\u0128\u0005\u000b\u0000\u0000\u0127\u0129\u0005\u0003\u0000\u0000"+
		"\u0128\u0127\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000"+
		"\u0129\u0171\u0001\u0000\u0000\u0000\u012a\u012b\u0005\u001d\u0000\u0000"+
		"\u012b\u012c\u00055\u0000\u0000\u012c\u012d\u0005\b\u0000\u0000\u012d"+
		"\u012e\u0003\u001c\u000e\u0000\u012e\u0130\u0005\u000b\u0000\u0000\u012f"+
		"\u0131\u0005\u0003\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0130"+
		"\u0131\u0001\u0000\u0000\u0000\u0131\u0171\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0005\u001e\u0000\u0000\u0133\u0134\u00055\u0000\u0000\u0134\u0136"+
		"\u0005\u000b\u0000\u0000\u0135\u0137\u0005\u0003\u0000\u0000\u0136\u0135"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0171"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0005\u001f\u0000\u0000\u0139\u0171"+
		"\u0003\u001c\u000e\u0016\u013a\u013b\u0005 \u0000\u0000\u013b\u0171\u0003"+
		"\u001c\u000e\u0015\u013c\u0141\u00055\u0000\u0000\u013d\u013e\u0005\u0005"+
		"\u0000\u0000\u013e\u013f\u0003\u001c\u000e\u0000\u013f\u0140\u0005\u0006"+
		"\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013d\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0171\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u00055\u0000\u0000\u0146\u0147\u0005\u0005\u0000"+
		"\u0000\u0147\u0148\u0003\u001c\u000e\u0000\u0148\u0149\u0005\u0006\u0000"+
		"\u0000\u0149\u0171\u0001\u0000\u0000\u0000\u014a\u014b\u00055\u0000\u0000"+
		"\u014b\u014c\u0005\u0005\u0000\u0000\u014c\u014d\u0003\u001c\u000e\u0000"+
		"\u014d\u014e\u0005\u0006\u0000\u0000\u014e\u014f\u0005\u0002\u0000\u0000"+
		"\u014f\u0150\u0003\u001c\u000e\f\u0150\u0171\u0001\u0000\u0000\u0000\u0151"+
		"\u0156\u00055\u0000\u0000\u0152\u0153\u0005\u0005\u0000\u0000\u0153\u0154"+
		"\u0003\u001c\u000e\u0000\u0154\u0155\u0005\u0006\u0000\u0000\u0155\u0157"+
		"\u0001\u0000\u0000\u0000\u0156\u0152\u0001\u0000\u0000\u0000\u0157\u0158"+
		"\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159"+
		"\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b"+
		"\u0005\u0002\u0000\u0000\u015b\u015c\u0003\u001c\u000e\u000b\u015c\u0171"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u00055\u0000\u0000\u015e\u015f\u0005"+
		"\u0002\u0000\u0000\u015f\u0171\u0003\u001c\u000e\n\u0160\u0161\u00055"+
		"\u0000\u0000\u0161\u0162\u0005-\u0000\u0000\u0162\u0171\u0003\u001c\u000e"+
		"\t\u0163\u0164\u00055\u0000\u0000\u0164\u0165\u0005.\u0000\u0000\u0165"+
		"\u0171\u0003\u001c\u000e\b\u0166\u0171\u00053\u0000\u0000\u0167\u0171"+
		"\u00051\u0000\u0000\u0168\u0171\u00054\u0000\u0000\u0169\u0171\u00052"+
		"\u0000\u0000\u016a\u0171\u00050\u0000\u0000\u016b\u0171\u00055\u0000\u0000"+
		"\u016c\u016d\u0005\r\u0000\u0000\u016d\u016e\u0003\u001c\u000e\u0000\u016e"+
		"\u016f\u0005\u000b\u0000\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170"+
		"\u0107\u0001\u0000\u0000\u0000\u0170\u0110\u0001\u0000\u0000\u0000\u0170"+
		"\u0116\u0001\u0000\u0000\u0000\u0170\u011c\u0001\u0000\u0000\u0000\u0170"+
		"\u0122\u0001\u0000\u0000\u0000\u0170\u012a\u0001\u0000\u0000\u0000\u0170"+
		"\u0132\u0001\u0000\u0000\u0000\u0170\u0138\u0001\u0000\u0000\u0000\u0170"+
		"\u013a\u0001\u0000\u0000\u0000\u0170\u013c\u0001\u0000\u0000\u0000\u0170"+
		"\u0145\u0001\u0000\u0000\u0000\u0170\u014a\u0001\u0000\u0000\u0000\u0170"+
		"\u0151\u0001\u0000\u0000\u0000\u0170\u015d\u0001\u0000\u0000\u0000\u0170"+
		"\u0160\u0001\u0000\u0000\u0000\u0170\u0163\u0001\u0000\u0000\u0000\u0170"+
		"\u0166\u0001\u0000\u0000\u0000\u0170\u0167\u0001\u0000\u0000\u0000\u0170"+
		"\u0168\u0001\u0000\u0000\u0000\u0170\u0169\u0001\u0000\u0000\u0000\u0170"+
		"\u016a\u0001\u0000\u0000\u0000\u0170\u016b\u0001\u0000\u0000\u0000\u0170"+
		"\u016c\u0001\u0000\u0000\u0000\u0171\u0186\u0001\u0000\u0000\u0000\u0172"+
		"\u0173\n\u0014\u0000\u0000\u0173\u0174\u0007\u0000\u0000\u0000\u0174\u0185"+
		"\u0003\u001c\u000e\u0015\u0175\u0176\n\u0013\u0000\u0000\u0176\u0177\u0007"+
		"\u0001\u0000\u0000\u0177\u0185\u0003\u001c\u000e\u0014\u0178\u0179\n\u0012"+
		"\u0000\u0000\u0179\u017a\u0007\u0002\u0000\u0000\u017a\u0185\u0003\u001c"+
		"\u000e\u0013\u017b\u017c\n\u0011\u0000\u0000\u017c\u017d\u0007\u0003\u0000"+
		"\u0000\u017d\u0185\u0003\u001c\u000e\u0012\u017e\u017f\n\u0010\u0000\u0000"+
		"\u017f\u0180\u0005+\u0000\u0000\u0180\u0185\u0003\u001c\u000e\u0011\u0181"+
		"\u0182\n\u000f\u0000\u0000\u0182\u0183\u0005,\u0000\u0000\u0183\u0185"+
		"\u0003\u001c\u000e\u0010\u0184\u0172\u0001\u0000\u0000\u0000\u0184\u0175"+
		"\u0001\u0000\u0000\u0000\u0184\u0178\u0001\u0000\u0000\u0000\u0184\u017b"+
		"\u0001\u0000\u0000\u0000\u0184\u017e\u0001\u0000\u0000\u0000\u0184\u0181"+
		"\u0001\u0000\u0000\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184"+
		"\u0001\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u001d"+
		"\u0001\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u00001!(06<>KP"+
		"XZbgktx|\u0084\u0088\u008a\u0090\u0098\u009d\u00a3\u00ad\u00b2\u00ba\u00c0"+
		"\u00c4\u00ce\u00e3\u00e7\u00eb\u00ee\u00f0\u00f8\u0100\u0105\u010e\u0114"+
		"\u011a\u0120\u0128\u0130\u0136\u0143\u0158\u0170\u0184\u0186";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}