// Generated from XQuery.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
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
}