// Generated from XQuery.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, TXT=21, NAME=22, WS=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'doc(\"'", "'['", "'..'", "'//'", "'=='", "']'", 
		"'='", "'@'", "'or'", "'\"'", "'eq'", "'('", "')'", "'is'", "'*'", "'and'", 
		"','", "'not'", "'.'", "'text()'", "NAME", "WS"
	};
	public static final int
		RULE_fltr = 0, RULE_ap = 1, RULE_rp = 2, RULE_doc = 3, RULE_fname = 4;
	public static final String[] ruleNames = {
		"fltr", "ap", "rp", "doc", "fname"
	};

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FltrContext extends ParserRuleContext {
		public FltrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fltr; }
	 
		public FltrContext() { }
		public void copyFrom(FltrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FltrEqualContext extends FltrContext {
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public FltrEqualContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrAndContext extends FltrContext {
		public FltrContext fltr(int i) {
			return getRuleContext(FltrContext.class,i);
		}
		public List<FltrContext> fltr() {
			return getRuleContexts(FltrContext.class);
		}
		public FltrAndContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrIsContext extends FltrContext {
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public FltrIsContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrNotContext extends FltrContext {
		public FltrContext fltr() {
			return getRuleContext(FltrContext.class,0);
		}
		public FltrNotContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrRpContext extends FltrContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FltrRpContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrwithPContext extends FltrContext {
		public FltrContext fltr() {
			return getRuleContext(FltrContext.class,0);
		}
		public FltrwithPContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrwithP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrwithP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrwithP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FltrOrContext extends FltrContext {
		public FltrContext fltr(int i) {
			return getRuleContext(FltrContext.class,i);
		}
		public List<FltrContext> fltr() {
			return getRuleContexts(FltrContext.class);
		}
		public FltrOrContext(FltrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFltrOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFltrOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFltrOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FltrContext fltr() throws RecognitionException {
		return fltr(0);
	}

	private FltrContext fltr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FltrContext _localctx = new FltrContext(_ctx, _parentState);
		FltrContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_fltr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new FltrNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(11); match(T__1);
				setState(12); fltr(1);
				}
				break;
			case 2:
				{
				_localctx = new FltrRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13); rp(0);
				}
				break;
			case 3:
				{
				_localctx = new FltrEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14); rp(0);
				setState(15); match(T__12);
				setState(16); rp(0);
				}
				break;
			case 4:
				{
				_localctx = new FltrEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18); rp(0);
				setState(19); match(T__8);
				setState(20); rp(0);
				}
				break;
			case 5:
				{
				_localctx = new FltrIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22); rp(0);
				setState(23); match(T__14);
				setState(24); rp(0);
				}
				break;
			case 6:
				{
				_localctx = new FltrIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26); rp(0);
				setState(27); match(T__5);
				setState(28); rp(0);
				}
				break;
			case 7:
				{
				_localctx = new FltrwithPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30); match(T__7);
				setState(31); fltr(0);
				setState(32); match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(42);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new FltrAndContext(new FltrContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_fltr);
						setState(36);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(37); match(T__3);
						setState(38); fltr(4);
						}
						break;
					case 2:
						{
						_localctx = new FltrOrContext(new FltrContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_fltr);
						setState(39);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(40); match(T__10);
						setState(41); fltr(3);
						}
						break;
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class APChildrenContext extends ApContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public APChildrenContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAPChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAPChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAPChildren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class APAllContext extends ApContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public APAllContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAPAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAPAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAPAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ap);
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new APChildrenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47); doc();
				setState(48); match(T__19);
				setState(49); rp(0);
				}
				break;
			case 2:
				_localctx = new APAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51); doc();
				setState(52); match(T__15);
				setState(53); rp(0);
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

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllChildrenContext extends RpContext {
		public AllChildrenContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAllChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAllChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAllChildren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpwithPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpwithPContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpwithP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpwithP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpwithP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TagNameContext extends RpContext {
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpAllContext extends RpContext {
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpAllContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentContext extends RpContext {
		public ParentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeContext extends RpContext {
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public AttributeContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpChildrenContext extends RpContext {
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpChildrenContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpChildren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpChildren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpChildren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextContext extends RpContext {
		public TerminalNode TXT() { return getToken(XQueryParser.TXT, 0); }
		public TextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpFltrContext extends RpContext {
		public FltrContext fltr() {
			return getRuleContext(FltrContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpFltrContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpFltr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpFltr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpFltr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CurrentContext extends RpContext {
		public CurrentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCurrent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCurrent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCurrent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TwoRpContext extends RpContext {
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public TwoRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTwoRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTwoRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTwoRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(58); match(NAME);
				}
				break;
			case T__4:
				{
				_localctx = new AllChildrenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); match(T__4);
				}
				break;
			case T__0:
				{
				_localctx = new CurrentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); match(T__0);
				}
				break;
			case T__16:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61); match(T__16);
				}
				break;
			case TXT:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62); match(TXT);
				}
				break;
			case T__11:
				{
				_localctx = new AttributeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63); match(T__11);
				setState(64); match(NAME);
				}
				break;
			case T__7:
				{
				_localctx = new RpwithPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); match(T__7);
				setState(66); rp(0);
				setState(67); match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(85);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new RpChildrenContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(71);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(72); match(T__19);
						setState(73); rp(6);
						}
						break;
					case 2:
						{
						_localctx = new RpAllContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(74);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(75); match(T__15);
						setState(76); rp(5);
						}
						break;
					case 3:
						{
						_localctx = new TwoRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78); match(T__2);
						setState(79); rp(4);
						}
						break;
					case 4:
						{
						_localctx = new RpFltrContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81); match(T__17);
						setState(82); fltr(0);
						setState(83); match(T__13);
						}
						break;
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class DocContext extends ParserRuleContext {
		public FnameContext fname() {
			return getRuleContext(FnameContext.class,0);
		}
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_doc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(T__18);
			setState(91); fname();
			setState(92); match(T__9);
			setState(93); match(T__6);
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

	public static class FnameContext extends ParserRuleContext {
		public TerminalNode NAME(int i) {
			return getToken(XQueryParser.NAME, i);
		}
		public List<TerminalNode> NAME() { return getTokens(XQueryParser.NAME); }
		public FnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnameContext fname() throws RecognitionException {
		FnameContext _localctx = new FnameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(NAME);
			setState(98);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(96); match(T__0);
				setState(97); match(NAME);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return fltr_sempred((FltrContext)_localctx, predIndex);
		case 2: return rp_sempred((RpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean fltr_sempred(FltrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 5);
		case 3: return precpred(_ctx, 4);
		case 4: return precpred(_ctx, 3);
		case 5: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31g\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2%\n\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4H\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4X\n\4\f\4"+
		"\16\4[\13\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6e\n\6\3\6\2\4\2\6\7\2\4"+
		"\6\b\n\2\2u\2$\3\2\2\2\49\3\2\2\2\6G\3\2\2\2\b\\\3\2\2\2\na\3\2\2\2\f"+
		"\r\b\2\1\2\r\16\7\25\2\2\16%\5\2\2\3\17%\5\6\4\2\20\21\5\6\4\2\21\22\7"+
		"\n\2\2\22\23\5\6\4\2\23%\3\2\2\2\24\25\5\6\4\2\25\26\7\16\2\2\26\27\5"+
		"\6\4\2\27%\3\2\2\2\30\31\5\6\4\2\31\32\7\b\2\2\32\33\5\6\4\2\33%\3\2\2"+
		"\2\34\35\5\6\4\2\35\36\7\21\2\2\36\37\5\6\4\2\37%\3\2\2\2 !\7\17\2\2!"+
		"\"\5\2\2\2\"#\7\20\2\2#%\3\2\2\2$\f\3\2\2\2$\17\3\2\2\2$\20\3\2\2\2$\24"+
		"\3\2\2\2$\30\3\2\2\2$\34\3\2\2\2$ \3\2\2\2%.\3\2\2\2&\'\f\5\2\2\'(\7\23"+
		"\2\2(-\5\2\2\6)*\f\4\2\2*+\7\f\2\2+-\5\2\2\5,&\3\2\2\2,)\3\2\2\2-\60\3"+
		"\2\2\2.,\3\2\2\2./\3\2\2\2/\3\3\2\2\2\60.\3\2\2\2\61\62\5\b\5\2\62\63"+
		"\7\3\2\2\63\64\5\6\4\2\64:\3\2\2\2\65\66\5\b\5\2\66\67\7\7\2\2\678\5\6"+
		"\4\28:\3\2\2\29\61\3\2\2\29\65\3\2\2\2:\5\3\2\2\2;<\b\4\1\2<H\7\30\2\2"+
		"=H\7\22\2\2>H\7\26\2\2?H\7\6\2\2@H\7\27\2\2AB\7\13\2\2BH\7\30\2\2CD\7"+
		"\17\2\2DE\5\6\4\2EF\7\20\2\2FH\3\2\2\2G;\3\2\2\2G=\3\2\2\2G>\3\2\2\2G"+
		"?\3\2\2\2G@\3\2\2\2GA\3\2\2\2GC\3\2\2\2HY\3\2\2\2IJ\f\7\2\2JK\7\3\2\2"+
		"KX\5\6\4\bLM\f\6\2\2MN\7\7\2\2NX\5\6\4\7OP\f\5\2\2PQ\7\24\2\2QX\5\6\4"+
		"\6RS\f\4\2\2ST\7\5\2\2TU\5\2\2\2UV\7\t\2\2VX\3\2\2\2WI\3\2\2\2WL\3\2\2"+
		"\2WO\3\2\2\2WR\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\7\3\2\2\2[Y\3\2"+
		"\2\2\\]\7\4\2\2]^\5\n\6\2^_\7\r\2\2_`\7\20\2\2`\t\3\2\2\2ad\7\30\2\2b"+
		"c\7\26\2\2ce\7\30\2\2db\3\2\2\2de\3\2\2\2e\13\3\2\2\2\n$,.9GWYd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}