// Generated from XQuery.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code XQJoin}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQJoin(@NotNull XQueryParser.XQJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQJoin}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQJoin(@NotNull XQueryParser.XQJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterFLWR(@NotNull XQueryParser.FLWRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitFLWR(@NotNull XQueryParser.FLWRContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code APChildren}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAPChildren(@NotNull XQueryParser.APChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code APChildren}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAPChildren(@NotNull XQueryParser.APChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrAnd}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrAnd(@NotNull XQueryParser.FltrAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrAnd}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrAnd(@NotNull XQueryParser.FltrAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQStringConst}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQStringConst(@NotNull XQueryParser.XQStringConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQStringConst}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQStringConst(@NotNull XQueryParser.XQStringConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAllChildren(@NotNull XQueryParser.AllChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAllChildren(@NotNull XQueryParser.AllChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQAll}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQAll(@NotNull XQueryParser.XQAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQAll}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQAll(@NotNull XQueryParser.XQAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQPar}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQPar(@NotNull XQueryParser.XQParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQPar}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQPar(@NotNull XQueryParser.XQParContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(@NotNull XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(@NotNull XQueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrNot}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrNot(@NotNull XQueryParser.FltrNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrNot}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrNot(@NotNull XQueryParser.FltrNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondOr(@NotNull XQueryParser.XQCondOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondOr(@NotNull XQueryParser.XQCondOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoAttrs}
	 * labeled alternative in {@link XQueryParser#attrs}.
	 * @param ctx the parse tree
	 */
	void enterNoAttrs(@NotNull XQueryParser.NoAttrsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoAttrs}
	 * labeled alternative in {@link XQueryParser#attrs}.
	 * @param ctx the parse tree
	 */
	void exitNoAttrs(@NotNull XQueryParser.NoAttrsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQLet(@NotNull XQueryParser.XQLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQLet(@NotNull XQueryParser.XQLetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQChild}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQChild(@NotNull XQueryParser.XQChildContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQChild}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQChild(@NotNull XQueryParser.XQChildContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQTag}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQTag(@NotNull XQueryParser.XQTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQTag}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQTag(@NotNull XQueryParser.XQTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQAp(@NotNull XQueryParser.XQApContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQAp(@NotNull XQueryParser.XQApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondIs}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondIs(@NotNull XQueryParser.XQCondIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondIs}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondIs(@NotNull XQueryParser.XQCondIsContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#fname}.
	 * @param ctx the parse tree
	 */
	void enterFname(@NotNull XQueryParser.FnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#fname}.
	 * @param ctx the parse tree
	 */
	void exitFname(@NotNull XQueryParser.FnameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrEqual}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrEqual(@NotNull XQueryParser.FltrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrEqual}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrEqual(@NotNull XQueryParser.FltrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondEmpty}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondEmpty(@NotNull XQueryParser.XQCondEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondEmpty}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondEmpty(@NotNull XQueryParser.XQCondEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrwithP}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrwithP(@NotNull XQueryParser.FltrwithPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrwithP}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrwithP(@NotNull XQueryParser.FltrwithPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpwithP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpwithP(@NotNull XQueryParser.RpwithPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpwithP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpwithP(@NotNull XQueryParser.RpwithPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondAnd(@NotNull XQueryParser.XQCondAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondAnd(@NotNull XQueryParser.XQCondAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondNot(@NotNull XQueryParser.XQCondNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondNot(@NotNull XQueryParser.XQCondNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrIs}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrIs(@NotNull XQueryParser.FltrIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrIs}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrIs(@NotNull XQueryParser.FltrIsContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(@NotNull XQueryParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(@NotNull XQueryParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCurrent(@NotNull XQueryParser.CurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCurrent(@NotNull XQueryParser.CurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondEqual(@NotNull XQueryParser.XQCondEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondEqual}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondEqual(@NotNull XQueryParser.XQCondEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllAttrs}
	 * labeled alternative in {@link XQueryParser#attrs}.
	 * @param ctx the parse tree
	 */
	void enterAllAttrs(@NotNull XQueryParser.AllAttrsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllAttrs}
	 * labeled alternative in {@link XQueryParser#attrs}.
	 * @param ctx the parse tree
	 */
	void exitAllAttrs(@NotNull XQueryParser.AllAttrsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagName(@NotNull XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagName(@NotNull XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParent(@NotNull XQueryParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParent(@NotNull XQueryParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull XQueryParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull XQueryParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpChildren(@NotNull XQueryParser.RpChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpChildren(@NotNull XQueryParser.RpChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondSome}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondSome(@NotNull XQueryParser.XQCondSomeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondSome}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondSome(@NotNull XQueryParser.XQCondSomeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQCondPar}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterXQCondPar(@NotNull XQueryParser.XQCondParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQCondPar}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitXQCondPar(@NotNull XQueryParser.XQCondParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code APAll}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAPAll(@NotNull XQueryParser.APAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code APAll}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAPAll(@NotNull XQueryParser.APAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQVariable}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQVariable(@NotNull XQueryParser.XQVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQVariable}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQVariable(@NotNull XQueryParser.XQVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpAll}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAll(@NotNull XQueryParser.RpAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpAll}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAll(@NotNull XQueryParser.RpAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrRp}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrRp(@NotNull XQueryParser.FltrRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrRp}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrRp(@NotNull XQueryParser.FltrRpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attr}.
	 * @param ctx the parse tree
	 */
	void enterAttr(@NotNull XQueryParser.AttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attr}.
	 * @param ctx the parse tree
	 */
	void exitAttr(@NotNull XQueryParser.AttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TwoRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTwoRp(@NotNull XQueryParser.TwoRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TwoRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTwoRp(@NotNull XQueryParser.TwoRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull XQueryParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull XQueryParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(@NotNull XQueryParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(@NotNull XQueryParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQDot}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQDot(@NotNull XQueryParser.XQDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQDot}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQDot(@NotNull XQueryParser.XQDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(@NotNull XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(@NotNull XQueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpFltr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFltr(@NotNull XQueryParser.RpFltrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpFltr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFltr(@NotNull XQueryParser.RpFltrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FltrOr}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void enterFltrOr(@NotNull XQueryParser.FltrOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FltrOr}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 */
	void exitFltrOr(@NotNull XQueryParser.FltrOrContext ctx);
}