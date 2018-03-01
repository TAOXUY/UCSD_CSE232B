import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XQueryMyVisitor extends XQueryBaseVisitor<Object> {
	private boolean hasAttribute = false;
	private Map<String, List<Node>> binding = new HashMap<>();
	private Stack<State> stateStack = new Stack<State>();
	private Stack<ArrayList<Node>> retStack = new Stack<ArrayList<Node>>();
	private Document doc;

	XQueryMyVisitor() {
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<Node> remoeDup(ArrayList<Node> node_list) {
		HashSet<Node> set = new HashSet<>();
		ArrayList<Node> res = new ArrayList<>();
		for (Node node : node_list) {
			if (set.contains(node))
				continue;
			res.add(node);
			set.add(node);
		}
		return res;
	}

	@Override
	public Object visitXQVariable(XQueryParser.XQVariableContext ctx) {
		String name = ctx.var().NAME().getText();
		ArrayList<Node> var_list = new ArrayList<>();
		var_list.addAll(binding.get(name));
		return var_list;
	}

	@Override
	public Object visitXQStringConst(XQueryParser.XQStringConstContext ctx) {
		String text = ctx.StringConst().getText();
		int len = text.length();
		text = text.substring(1, len - 1);
		Node textNode = doc.createTextNode(text);
		List<Node> res = new ArrayList<>();
		res.add(textNode);
		return res;
	}

	@Override
	public Object visitXQAp(XQueryParser.XQApContext ctx) {
		return (ArrayList<Node>) visit(ctx.ap());
	}

	@Override
	public Object visitXQPar(XQueryParser.XQParContext ctx) {
		return visit(ctx.xq());
	}

	@Override
	public Object visitXQChild(XQueryParser.XQChildContext ctx) {
		// System.out.println("visitXQChild");
		ArrayList<Node> subRes = (ArrayList<Node>) visit(ctx.xq());
		State now = new State(subRes);
		stateStack.push(now);
		ArrayList<Node> ans = (ArrayList<Node>) visit(ctx.rp());
		ArrayList<Node> res = remoeDup(ans);
		stateStack.pop();
		return res;
	}

	@Override
	public Object visitXQAll(XQueryParser.XQAllContext ctx) {
		ArrayList<Node> excute = (ArrayList<Node>) visit(ctx.xq());
		State cur = new State(excute);
		ArrayList<Node> children = cur.getAllChildren();
		State now = new State(children);
		stateStack.push(now);
		ArrayList<Node> ans = (ArrayList<Node>) visit(ctx.rp());
		ArrayList<Node> result = remoeDup(ans);
		stateStack.pop();
		return result;
	}

	@Override
	public Object visitXQDot(XQueryParser.XQDotContext ctx) {
		ArrayList<Node> result = new ArrayList<>();
		result.addAll((ArrayList<Node>) visit(ctx.xq(0)));
		result.addAll((ArrayList<Node>) visit(ctx.xq(1)));
		return result;
	}

	@Override
	public Object visitXQTag(XQueryParser.XQTagContext ctx) {
		String tagname = ctx.NAME(0).getText();
		ArrayList<Node> res = (ArrayList<Node>) visit(ctx.xq());
		ArrayList<Node> ans = new ArrayList<Node>();
		Node tag = doc.createElement(tagname);
		for (Node node : res) {
			Node child = doc.importNode(node, true);
			tag.appendChild(child);
		}
		ans.add(tag);

		return ans;
	}

	@Override
	public Object visitFLWR(XQueryParser.FLWRContext ctx) {
		retStack.push(new ArrayList<>());
		FLWRhelper(ctx.forClause().var(), ctx.forClause().xq(), ctx.letClause(), ctx.whereClause(), ctx.returnClause());
		return retStack.pop();
	}

	public Object FLWRhelper(List<XQueryParser.VarContext> vars, List<XQueryParser.XqContext> xql,
			XQueryParser.LetClauseContext l, XQueryParser.WhereClauseContext w, XQueryParser.ReturnClauseContext r) {
		if (vars.size() == 0) {
			if (l != null)
				visit(l);
			if (w == null || (boolean) visit(w)) {
//				System.out.println("pass cond");
				visit(r);
			}
			return null;
		}
		XQueryParser.VarContext currentvar = vars.get(0);
		XQueryParser.XqContext currentxq = xql.get(0);
		vars.remove(0);
		xql.remove(0);
//		State pre = stateStack.peek();
		ArrayList<Node> varbuffer = (ArrayList<Node>) visit(currentxq);
//		stateStack.pop();
//		stateStack.push(pre);
		String varname = currentvar.getText();
//		System.out.println(varbuffer.size());
		for (int i = 0; i < varbuffer.size(); i++) {
			ArrayList<Node> temp = new ArrayList<>();
			temp.add(varbuffer.get(i));
			binding.put(varname, temp);
			FLWRhelper(vars, xql, l, w, r);
		}
		vars.add(0, currentvar);
		xql.add(0, currentxq);
		return null;
	}

	@Override
	public Object visitXQLet(XQueryParser.XQLetContext ctx) {
		visit(ctx.letClause());
		return visit(ctx.xq());
	}

	@Override
	public Object visitVar(XQueryParser.VarContext ctx) {
		String name = ctx.getText();
		ArrayList<Node> variable = new ArrayList<Node>();
		variable.add((Node) binding.get(name));
		return variable;
	}

	@Override
	public Object visitForClause(XQueryParser.ForClauseContext ctx) {
		return null;
	}

	@Override
	public Object visitLetClause(XQueryParser.LetClauseContext ctx) {
		List<XQueryParser.VarContext> var_list = ctx.var();
		ArrayList<Node> temp;
		int len = var_list.size();
		for (int i = 0; i < len; i++) {
			temp = (ArrayList<Node>) visit(ctx.xq(i));
			binding.put(var_list.get(i).getText(), temp);
		}
		return null;
	}

	@Override
	public Boolean visitWhereClause(XQueryParser.WhereClauseContext ctx) {
		State pre = stateStack.peek();
		boolean res = (boolean) visit(ctx.cond());
		stateStack.pop();
		stateStack.push(pre);
		return res;
	}

	@Override
	public Object visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
		ArrayList<Node> ans = (ArrayList<Node>) visit(ctx.xq());
		retStack.peek().addAll(ans);
		return null;
	}

	@Override
	public Boolean visitXQCondEqual(XQueryParser.XQCondEqualContext ctx) {
		State preState = stateStack.peek();
		ArrayList<Node> xq1 = (ArrayList<Node>) visit(ctx.xq(0));
		stateStack.pop();
		stateStack.push(preState);
		ArrayList<Node> xq2 = (ArrayList<Node>) visit(ctx.xq(1));
		stateStack.pop();
		stateStack.push(preState);

		int len1 = xq1.size();
		int len2 = xq2.size();
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				Node node1 = xq1.get(i);
				Node node2 = xq2.get(j);
				try {
					if (node2.getTextContent().equals("SCENE II.  A public place.")) {
//						System.out.println(MyXQuery.nodeToString(node1));
//						System.out.println(MyXQuery.nodeToString(node2) + "\n");
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (!node1.isEqualNode(node2))
					continue;
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitXQCondIs(XQueryParser.XQCondIsContext ctx) {
		ArrayList<Node> xq1 = (ArrayList<Node>) visit(ctx.xq(0));
		ArrayList<Node> xq2 = (ArrayList<Node>) visit(ctx.xq(1));

		int len1 = xq1.size();
		int len2 = xq2.size();

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (!xq1.get(i).isSameNode(xq2.get(j)))
					continue;
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitXQCondEmpty(XQueryParser.XQCondEmptyContext ctx) {
		boolean t1 = ((ArrayList<Node>) visit(ctx.xq())).isEmpty();
		return t1;
	}

	@Override
	public Boolean visitXQCondSome(XQueryParser.XQCondSomeContext ctx) {
//		System.out.println("XQCondSome");
		return (boolean) condSomeHelper(ctx.var(), ctx.xq(), ctx.cond());
	}

	public Object condSomeHelper(List<XQueryParser.VarContext> vars, List<XQueryParser.XqContext> xql,
			XQueryParser.CondContext c) {
		if (vars.size() == 0) {
			return visit(c);
		}
		XQueryParser.VarContext currentvar = vars.get(0);
		XQueryParser.XqContext currentxq = xql.get(0);
		vars.remove(0);
		xql.remove(0);
		ArrayList<Node> varbuffer = (ArrayList<Node>) visit(currentxq);
		String varname = currentvar.getText();
//		System.out.println(varbuffer.size());
		for (int i = 0; i < varbuffer.size(); i++) {
			ArrayList<Node> temp = new ArrayList<>();
			temp.add(varbuffer.get(i));
			binding.put(varname, temp);
			if ((boolean) condSomeHelper(vars, xql, c)) {
//				System.out.println("true");
				return true;
			}
		}
		vars.add(0, currentvar);
		xql.add(0, currentxq);
//		System.out.println("false");
		return false;
	}

	@Override
	public Boolean visitXQCondPar(XQueryParser.XQCondParContext ctx) {
		return (boolean) visit(ctx.cond());
	}

	@Override
	public Boolean visitXQCondAnd(XQueryParser.XQCondAndContext ctx) {
		boolean t1 = (boolean) visit(ctx.cond(0));
		boolean t2 = (boolean) visit(ctx.cond(1));
		return t1 && t2;
	}

	@Override
	public Boolean visitXQCondOr(XQueryParser.XQCondOrContext ctx) {
		boolean t1 = (boolean) visit(ctx.cond(0));
		boolean t2 = (boolean) visit(ctx.cond(1));
		return t1 || t2;
	}

	@Override
	public Boolean visitXQCondNot(XQueryParser.XQCondNotContext ctx) {
		// System.out.println("not");
		return !((boolean) visit(ctx.cond()));
	}

	/////////////////////////////////////////////////////////////

	@Override
	public ArrayList<Node> visitDoc(XQueryParser.DocContext ctx) {
		// System.out.println("visitDoc");
		File xmlFltre = new File(ctx.fname().getText()); // dont know whats in xmlFltre
		DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
		DocumentBuilder docB = null;
		// System.out.println("aa");
		try {
			docB = docBF.newDocumentBuilder();
		} catch (ParserConfigurationException pE1) {
			pE1.printStackTrace();
		}
		Document doc = null; // use for what
		try {
			if (docB != null) {
				doc = docB.parse(xmlFltre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (doc != null) {
			doc.getDocumentElement().normalize();
		}
		ArrayList<Node> res = new ArrayList<>();
		res.add((Node) doc);
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public ArrayList<Node> visitAPChildren(XQueryParser.APChildrenContext ctx) {
		visit(ctx.doc());
		ArrayList<Node> res = stateStack.pop().getChildren();
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public ArrayList<Node> visitAPAll(XQueryParser.APAllContext ctx) {
		// System.out.println("visitAPAll");

		visit(ctx.doc());
		ArrayList<Node> res = stateStack.pop().getAllChildren();
		stateStack.push(new State(res));
		return (ArrayList<Node>) visit(ctx.rp());
	}

	@Override
	public ArrayList<Node> visitTagName(XQueryParser.TagNameContext ctx) {
		// System.out.println("visitTagName");
		ArrayList<Node> res = new ArrayList<>();
		String tName = ctx.getText();
		ArrayList<Node> curChildren = stateStack.pop().getChildren();
		for (Node child : curChildren) {
			if (!child.getNodeName().equals(tName))
				continue;
			res.add(child);
		}
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public ArrayList<Node> visitAllChildren(XQueryParser.AllChildrenContext ctx) {
		// System.out.println("visitAllChildren");
		ArrayList<Node> res = stateStack.pop().getChildren();
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public ArrayList<Node> visitCurrent(XQueryParser.CurrentContext ctx) {
		return stateStack.peek().getNodes();
	}

	@Override
	public ArrayList<Node> visitParent(XQueryParser.ParentContext ctx) {
		// System.out.println("visitParent");
		ArrayList<Node> res = stateStack.pop().getParents();
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public Object visitText(XQueryParser.TextContext ctx) {
		State cs = stateStack.peek();
		ArrayList<Node> tmp = cs.getChildren();
		ArrayList<Node> result = new ArrayList<>();
		for (Node node : tmp) {
			if (node.getNodeType() == node.TEXT_NODE) {
				result.add(node);
			}
		}

		return result;
	}

	@Override
	public ArrayList<Node> visitAttribute(XQueryParser.AttributeContext ctx) { // ???
		// System.out.println("visitAttribute");
		ArrayList<Node> res = new ArrayList<>();
		hasAttribute = true;
		ArrayList<Node> curNodes = stateStack.pop().getNodes();
		for (Node temp : curNodes) {
			Element e = (Element) temp;
			String attr = e.getAttribute(ctx.NAME().getText());
			if (attr.equals(""))
				continue;
			res.add(temp);
			attr = ctx.NAME().getText() + "=\"" + attr + "\"";
			System.out.println(attr);
		}
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public ArrayList<Node> visitRpChildren(XQueryParser.RpChildrenContext ctx) {
		// System.out.println("visitRpChildren");
		visit(ctx.rp(0));

		return (ArrayList<Node>) visit(ctx.rp(1));
	}

	@Override
	public ArrayList<Node> visitRpAll(XQueryParser.RpAllContext ctx) {
		ArrayList<Node> res = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		visit(ctx.rp(0));
		res = stateStack.pop().getAllChildren();
		stateStack.push(new State(res));
		return (ArrayList<Node>) visit(ctx.rp(1));
	}

	@Override
	public ArrayList<Node> visitTwoRp(XQueryParser.TwoRpContext ctx) { 
		ArrayList<Node> res = new ArrayList<>();
		ArrayList<Node> res2 = new ArrayList<>();
		State preState = stateStack.peek();
		res.addAll((ArrayList<Node>) visit(ctx.rp(0)));
		stateStack.pop();
		stateStack.push(preState);
		res.addAll((ArrayList<Node>) visit(ctx.rp(1)));
		stateStack.push(new State(res));
		return res;
	}

	@Override
	public ArrayList<Node> visitRpFltr(XQueryParser.RpFltrContext ctx) { 
		ArrayList<Node> nodes = (ArrayList<Node>) visit(ctx.rp());
		ArrayList<Node> res = new ArrayList();
		for (Node node : nodes) {
			ArrayList<Node> temp = new ArrayList<>();
			temp.add(node);
			stateStack.push(new State(temp));
			if ((Boolean) visit(ctx.fltr())) {
				res.add(node);
			}
			stateStack.pop();
		}
//		stateStack.pop();
		stateStack.push(new State(res));
		return res;
//		if (hasAttribute) {
//			hasAttribute = false;
//			return Fltrter;
//		} else if (Fltrter.isEmpty()) {
//			return new ArrayList<>();
//		} else {
//			return res;
//		}
	}

	public ArrayList<Node> visitRpwithP(XQueryParser.RpwithPContext ctx) {
		return (ArrayList<Node>) visit(ctx.rp());
	}

	@Override
	public Boolean visitFltrRp(XQueryParser.FltrRpContext ctx) {
		ArrayList<Node> res = (ArrayList<Node>) visit(ctx.rp());
		return !res.isEmpty();
	}

	@Override
	public Boolean visitFltrEqual(XQueryParser.FltrEqualContext ctx) {
		State preState = stateStack.peek();
		ArrayList<Node> left = (ArrayList<Node>) visit(ctx.rp(0));
		stateStack.pop();
		stateStack.push(preState);
		ArrayList<Node> right = (ArrayList<Node>) visit(ctx.rp(1));
		stateStack.pop();
		stateStack.push(preState);
		for (Node i : left) {
			for (Node j : right) {
				if (!i.isEqualNode(j))
					continue;
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitFltrIs(XQueryParser.FltrIsContext ctx) {
		State preState = stateStack.peek();
		ArrayList<Node> left = (ArrayList<Node>) visit(ctx.rp(0));
		stateStack.pop();
		stateStack.push(preState);
		ArrayList<Node> right = (ArrayList<Node>) visit(ctx.rp(1));
		stateStack.pop();
		stateStack.push(preState);
		for (Node i : left) {
			for (Node j : right) {
				if (!i.isSameNode(j))
					continue;
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitFltrwithP(XQueryParser.FltrwithPContext ctx) {
		return (Boolean) visit(ctx.fltr());
	}

	@Override
	public Boolean visitFltrAnd(XQueryParser.FltrAndContext ctx) {
		State preState = stateStack.peek();
		boolean left = (boolean) visit(ctx.fltr(0));
		stateStack.pop();
		stateStack.push(preState);
		boolean right = (boolean) visit(ctx.fltr(1));
		stateStack.pop();
		stateStack.push(preState);
		return left && right;
	}

	@Override
	public Boolean visitFltrOr(XQueryParser.FltrOrContext ctx) {
		State preState = stateStack.peek();
		boolean left = (boolean) visit(ctx.fltr(0));
		stateStack.pop();
		stateStack.push(preState);
		boolean right = (boolean) visit(ctx.fltr(1));
		stateStack.pop();
		stateStack.push(preState);
		return left || right;
	}

	@Override
	public Boolean visitFltrNot(XQueryParser.FltrNotContext ctx) {
		boolean res = (boolean) visit(ctx.fltr());
		return !res;
	}
}
