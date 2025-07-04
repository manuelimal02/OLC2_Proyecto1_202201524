//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.13.2
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from ./Gramatica/Gramatica.g4 by ANTLR 4.13.2

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

namespace Analizador {
using System;
using System.IO;
using System.Text;
using System.Diagnostics;
using System.Collections.Generic;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.CLSCompliant(false)]
public partial class GramaticaParser : Parser {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, WS=12, ID=13;
	public const int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_stmt = 3, RULE_expr = 4;
	public static readonly string[] ruleNames = {
		"program", "dcl", "varDcl", "stmt", "expr"
	};

	private static readonly string[] _LiteralNames = {
		null, "'var'", "'='", "';'", "'print('", "')'", "'-'", "'*'", "'/'", "'+'", 
		"'('"
	};
	private static readonly string[] _SymbolicNames = {
		null, null, null, null, null, null, null, null, null, null, null, "INT", 
		"WS", "ID"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "Gramatica.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override int[] SerializedAtn { get { return _serializedATN; } }

	static GramaticaParser() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}

		public GramaticaParser(ITokenStream input) : this(input, Console.Out, Console.Error) { }

		public GramaticaParser(ITokenStream input, TextWriter output, TextWriter errorOutput)
		: base(input, output, errorOutput)
	{
		Interpreter = new ParserATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	public partial class ProgramContext : ParserRuleContext {
		[System.Diagnostics.DebuggerNonUserCode] public DclContext[] dcl() {
			return GetRuleContexts<DclContext>();
		}
		[System.Diagnostics.DebuggerNonUserCode] public DclContext dcl(int i) {
			return GetRuleContext<DclContext>(i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_program; } }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitProgram(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public ProgramContext program() {
		ProgramContext _localctx = new ProgramContext(Context, State);
		EnterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			EnterOuterAlt(_localctx, 1);
			{
			State = 13;
			ErrorHandler.Sync(this);
			_la = TokenStream.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 11346L) != 0)) {
				{
				{
				State = 10;
				dcl();
				}
				}
				State = 15;
				ErrorHandler.Sync(this);
				_la = TokenStream.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			ErrorHandler.ReportError(this, re);
			ErrorHandler.Recover(this, re);
		}
		finally {
			ExitRule();
		}
		return _localctx;
	}

	public partial class DclContext : ParserRuleContext {
		[System.Diagnostics.DebuggerNonUserCode] public VarDclContext varDcl() {
			return GetRuleContext<VarDclContext>(0);
		}
		[System.Diagnostics.DebuggerNonUserCode] public StmtContext stmt() {
			return GetRuleContext<StmtContext>(0);
		}
		public DclContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_dcl; } }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitDcl(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public DclContext dcl() {
		DclContext _localctx = new DclContext(Context, State);
		EnterRule(_localctx, 2, RULE_dcl);
		try {
			State = 18;
			ErrorHandler.Sync(this);
			switch (TokenStream.LA(1)) {
			case T__0:
				EnterOuterAlt(_localctx, 1);
				{
				State = 16;
				varDcl();
				}
				break;
			case T__3:
			case T__5:
			case T__9:
			case INT:
			case ID:
				EnterOuterAlt(_localctx, 2);
				{
				State = 17;
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			ErrorHandler.ReportError(this, re);
			ErrorHandler.Recover(this, re);
		}
		finally {
			ExitRule();
		}
		return _localctx;
	}

	public partial class VarDclContext : ParserRuleContext {
		[System.Diagnostics.DebuggerNonUserCode] public ITerminalNode ID() { return GetToken(GramaticaParser.ID, 0); }
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public VarDclContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_varDcl; } }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitVarDcl(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public VarDclContext varDcl() {
		VarDclContext _localctx = new VarDclContext(Context, State);
		EnterRule(_localctx, 4, RULE_varDcl);
		try {
			EnterOuterAlt(_localctx, 1);
			{
			State = 20;
			Match(T__0);
			State = 21;
			Match(ID);
			State = 22;
			Match(T__1);
			State = 23;
			expr(0);
			State = 24;
			Match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			ErrorHandler.ReportError(this, re);
			ErrorHandler.Recover(this, re);
		}
		finally {
			ExitRule();
		}
		return _localctx;
	}

	public partial class StmtContext : ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_stmt; } }
	 
		public StmtContext() { }
		public virtual void CopyFrom(StmtContext context) {
			base.CopyFrom(context);
		}
	}
	public partial class PrintStmtContext : StmtContext {
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public PrintStmtContext(StmtContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitPrintStmt(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class ExprStmtContext : StmtContext {
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public ExprStmtContext(StmtContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitExprStmt(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public StmtContext stmt() {
		StmtContext _localctx = new StmtContext(Context, State);
		EnterRule(_localctx, 6, RULE_stmt);
		try {
			State = 34;
			ErrorHandler.Sync(this);
			switch (TokenStream.LA(1)) {
			case T__5:
			case T__9:
			case INT:
			case ID:
				_localctx = new ExprStmtContext(_localctx);
				EnterOuterAlt(_localctx, 1);
				{
				State = 26;
				expr(0);
				State = 27;
				Match(T__2);
				}
				break;
			case T__3:
				_localctx = new PrintStmtContext(_localctx);
				EnterOuterAlt(_localctx, 2);
				{
				State = 29;
				Match(T__3);
				State = 30;
				expr(0);
				State = 31;
				Match(T__4);
				State = 32;
				Match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			ErrorHandler.ReportError(this, re);
			ErrorHandler.Recover(this, re);
		}
		finally {
			ExitRule();
		}
		return _localctx;
	}

	public partial class ExprContext : ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_expr; } }
	 
		public ExprContext() { }
		public virtual void CopyFrom(ExprContext context) {
			base.CopyFrom(context);
		}
	}
	public partial class IdentifierContext : ExprContext {
		[System.Diagnostics.DebuggerNonUserCode] public ITerminalNode ID() { return GetToken(GramaticaParser.ID, 0); }
		public IdentifierContext(ExprContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitIdentifier(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class NumberContext : ExprContext {
		[System.Diagnostics.DebuggerNonUserCode] public ITerminalNode INT() { return GetToken(GramaticaParser.INT, 0); }
		public NumberContext(ExprContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitNumber(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class MulDivContext : ExprContext {
		public IToken op;
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext[] expr() {
			return GetRuleContexts<ExprContext>();
		}
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr(int i) {
			return GetRuleContext<ExprContext>(i);
		}
		public MulDivContext(ExprContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitMulDiv(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class AddSubContext : ExprContext {
		public IToken op;
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext[] expr() {
			return GetRuleContexts<ExprContext>();
		}
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr(int i) {
			return GetRuleContext<ExprContext>(i);
		}
		public AddSubContext(ExprContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitAddSub(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class ParensContext : ExprContext {
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public ParensContext(ExprContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitParens(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class NegateContext : ExprContext {
		[System.Diagnostics.DebuggerNonUserCode] public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public NegateContext(ExprContext context) { CopyFrom(context); }
		[System.Diagnostics.DebuggerNonUserCode]
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			IGramaticaVisitor<TResult> typedVisitor = visitor as IGramaticaVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitNegate(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public ExprContext expr() {
		return expr(0);
	}

	private ExprContext expr(int _p) {
		ParserRuleContext _parentctx = Context;
		int _parentState = State;
		ExprContext _localctx = new ExprContext(Context, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		EnterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			EnterOuterAlt(_localctx, 1);
			{
			State = 45;
			ErrorHandler.Sync(this);
			switch (TokenStream.LA(1)) {
			case T__5:
				{
				_localctx = new NegateContext(_localctx);
				Context = _localctx;
				_prevctx = _localctx;

				State = 37;
				Match(T__5);
				State = 38;
				expr(6);
				}
				break;
			case INT:
				{
				_localctx = new NumberContext(_localctx);
				Context = _localctx;
				_prevctx = _localctx;
				State = 39;
				Match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdentifierContext(_localctx);
				Context = _localctx;
				_prevctx = _localctx;
				State = 40;
				Match(ID);
				}
				break;
			case T__9:
				{
				_localctx = new ParensContext(_localctx);
				Context = _localctx;
				_prevctx = _localctx;
				State = 41;
				Match(T__9);
				State = 42;
				expr(0);
				State = 43;
				Match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			Context.Stop = TokenStream.LT(-1);
			State = 55;
			ErrorHandler.Sync(this);
			_alt = Interpreter.AdaptivePredict(TokenStream,5,Context);
			while ( _alt!=2 && _alt!=global::Antlr4.Runtime.Atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( ParseListeners!=null )
						TriggerExitRuleEvent();
					_prevctx = _localctx;
					{
					State = 53;
					ErrorHandler.Sync(this);
					switch ( Interpreter.AdaptivePredict(TokenStream,4,Context) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						PushNewRecursionContext(_localctx, _startState, RULE_expr);
						State = 47;
						if (!(Precpred(Context, 5))) throw new FailedPredicateException(this, "Precpred(Context, 5)");
						State = 48;
						((MulDivContext)_localctx).op = TokenStream.LT(1);
						_la = TokenStream.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((MulDivContext)_localctx).op = ErrorHandler.RecoverInline(this);
						}
						else {
							ErrorHandler.ReportMatch(this);
						    Consume();
						}
						State = 49;
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						PushNewRecursionContext(_localctx, _startState, RULE_expr);
						State = 50;
						if (!(Precpred(Context, 4))) throw new FailedPredicateException(this, "Precpred(Context, 4)");
						State = 51;
						((AddSubContext)_localctx).op = TokenStream.LT(1);
						_la = TokenStream.LA(1);
						if ( !(_la==T__5 || _la==T__8) ) {
							((AddSubContext)_localctx).op = ErrorHandler.RecoverInline(this);
						}
						else {
							ErrorHandler.ReportMatch(this);
						    Consume();
						}
						State = 52;
						expr(5);
						}
						break;
					}
					} 
				}
				State = 57;
				ErrorHandler.Sync(this);
				_alt = Interpreter.AdaptivePredict(TokenStream,5,Context);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			ErrorHandler.ReportError(this, re);
			ErrorHandler.Recover(this, re);
		}
		finally {
			UnrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public override bool Sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private bool expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return Precpred(Context, 5);
		case 1: return Precpred(Context, 4);
		}
		return true;
	}

	private static int[] _serializedATN = {
		4,1,13,59,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,1,0,5,0,12,8,0,10,0,
		12,0,15,9,0,1,1,1,1,3,1,19,8,1,1,2,1,2,1,2,1,2,1,2,1,2,1,3,1,3,1,3,1,3,
		1,3,1,3,1,3,1,3,3,3,35,8,3,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,3,4,46,
		8,4,1,4,1,4,1,4,1,4,1,4,1,4,5,4,54,8,4,10,4,12,4,57,9,4,1,4,0,1,8,5,0,
		2,4,6,8,0,2,1,0,7,8,2,0,6,6,9,9,61,0,13,1,0,0,0,2,18,1,0,0,0,4,20,1,0,
		0,0,6,34,1,0,0,0,8,45,1,0,0,0,10,12,3,2,1,0,11,10,1,0,0,0,12,15,1,0,0,
		0,13,11,1,0,0,0,13,14,1,0,0,0,14,1,1,0,0,0,15,13,1,0,0,0,16,19,3,4,2,0,
		17,19,3,6,3,0,18,16,1,0,0,0,18,17,1,0,0,0,19,3,1,0,0,0,20,21,5,1,0,0,21,
		22,5,13,0,0,22,23,5,2,0,0,23,24,3,8,4,0,24,25,5,3,0,0,25,5,1,0,0,0,26,
		27,3,8,4,0,27,28,5,3,0,0,28,35,1,0,0,0,29,30,5,4,0,0,30,31,3,8,4,0,31,
		32,5,5,0,0,32,33,5,3,0,0,33,35,1,0,0,0,34,26,1,0,0,0,34,29,1,0,0,0,35,
		7,1,0,0,0,36,37,6,4,-1,0,37,38,5,6,0,0,38,46,3,8,4,6,39,46,5,11,0,0,40,
		46,5,13,0,0,41,42,5,10,0,0,42,43,3,8,4,0,43,44,5,5,0,0,44,46,1,0,0,0,45,
		36,1,0,0,0,45,39,1,0,0,0,45,40,1,0,0,0,45,41,1,0,0,0,46,55,1,0,0,0,47,
		48,10,5,0,0,48,49,7,0,0,0,49,54,3,8,4,6,50,51,10,4,0,0,51,52,7,1,0,0,52,
		54,3,8,4,5,53,47,1,0,0,0,53,50,1,0,0,0,54,57,1,0,0,0,55,53,1,0,0,0,55,
		56,1,0,0,0,56,9,1,0,0,0,57,55,1,0,0,0,6,13,18,34,45,53,55
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}
} // namespace Analizador
