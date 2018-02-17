// Generated from XQuery.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryParser#fname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFname(@NotNull XQueryParser.FnameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrEqual}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrEqual(@NotNull XQueryParser.FltrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code APChildren}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAPChildren(@NotNull XQueryParser.APChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrAnd}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrAnd(@NotNull XQueryParser.FltrAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(@NotNull XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(@NotNull XQueryParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(@NotNull XQueryParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpChildren(@NotNull XQueryParser.RpChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrwithP}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrwithP(@NotNull XQueryParser.FltrwithPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull XQueryParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code APAll}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAPAll(@NotNull XQueryParser.APAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllChildren(@NotNull XQueryParser.AllChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpwithP}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpwithP(@NotNull XQueryParser.RpwithPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpAll}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAll(@NotNull XQueryParser.RpAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrIs}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrIs(@NotNull XQueryParser.FltrIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrNot}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrNot(@NotNull XQueryParser.FltrNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrRp}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrRp(@NotNull XQueryParser.FltrRpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(@NotNull XQueryParser.DocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpFltr}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFltr(@NotNull XQueryParser.RpFltrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FltrOr}
	 * labeled alternative in {@link XQueryParser#fltr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFltrOr(@NotNull XQueryParser.FltrOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrent(@NotNull XQueryParser.CurrentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TwoRp}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoRp(@NotNull XQueryParser.TwoRpContext ctx);
}