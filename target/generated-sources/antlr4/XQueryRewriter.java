import java.lang.reflect.Array;
import java.util.*;



class XQueryRewriter {

	private ArrayList<JoinList> Lists;
	private String finalReturnString;
	private HashMap<String, Integer> varToList;
	private HashMap<Pair<Integer, Integer>, ArrayList<Pair<String, String>>> edgeToEqualPair;

	XQueryRewriter() {
		finalReturnString = "";
		Lists = new ArrayList<>();
		varToList = new HashMap<>();
		edgeToEqualPair = new HashMap<>();
	}

	

	void build(XQueryParser.XqContext xp) {
		if (!(xp instanceof XQueryParser.FLWRContext)) {
			return;
		}
		XQueryParser.ForClauseContext forClauseContext = ((XQueryParser.FLWRContext) xp).forClause();
		XQueryParser.WhereClauseContext whereClauseContext = ((XQueryParser.FLWRContext) xp).whereClause();
		XQueryParser.ReturnClauseContext returnClauseContext = ((XQueryParser.FLWRContext) xp).returnClause();

		// Analyze FOR clause.
		for (int i = 0, size = forClauseContext.var().size(); i < size; i++) {
			String varName = "$" + forClauseContext.var(i).getText();
			String xpStr = forClauseContext.xq(i).getText();
			Pair<String, String> varxp = Pair.mkPair(varName, xpStr);
			Integer ListIdx;
			if (xpStr.startsWith("doc")) {
				ListIdx = Lists.size();
				Lists.add(new JoinList(ListIdx));
			} else {
				int slashPos = xpStr.indexOf('/') == -1 ? xpStr.length() : xpStr.indexOf('/');
				String prefixVar = xpStr.substring(0, slashPos);
				
				
				ListIdx = varToList.get(prefixVar);
			}
			Lists.get(ListIdx).vars.add(varxp);
			varToList.put(varName, ListIdx);
		}
		XQueryParser.CondContext condition = whereClauseContext.cond();
		dfs(condition);
		finalReturnString = returnClauseContext.getText().replace("return", "return ");
		finalReturnString = finalReturnString.replaceAll("\\$([A-Za-z0-9_]+)", "\\$tuple/$1/*");
	}

	// Method for assisting WHERE clause analysis.
	private void dfs(XQueryParser.CondContext condition) {
		if (condition instanceof XQueryParser.XQCondAndContext) {
			XQueryParser.XQCondAndContext andContext = (XQueryParser.XQCondAndContext) condition;
			dfs(andContext.cond(0));
			dfs(andContext.cond(1));
		}

		else if (condition instanceof XQueryParser.XQCondEqualContext) {
			XQueryParser.XQCondEqualContext equalContext = (XQueryParser.XQCondEqualContext) condition;
			String eqStr1 = equalContext.xq(0).getText();
			String eqStr2 = equalContext.xq(1).getText();

			//const
//			int len1 = eqStr1.length(), len2 = eqStr2.length();
////			int len1 = eqStr1.indexOf("/") == -1 ? eqStr1.length() : eqStr1.indexOf("/");
////			int len2 = eqStr2.indexOf("/") == -1 ? eqStr2.length() : eqStr2.indexOf("/");
//			Integer tblIdx1 = varToList.get(eqStr1.substring(0, len1));
//			Integer tblIdx2 = varToList.get(eqStr2.substring(0, len2));
//			if (!eqStr1.startsWith("$") || !eqStr2.startsWith("$")) {
//				Integer ListIdx;
//				ListIdx = eqStr1.startsWith("$") ? tblIdx1 : tblIdx2;
//				Lists.get(ListIdx).whereStats.add(condition.getText().replace("eq", " eq "));
//				return;
//			}
//
//
//			System.out.println(eqStr1 + ";" + eqStr2);
//			System.out.println(tblIdx1 + ";" + tblIdx2);
//			if (tblIdx1 > tblIdx2) {
//				XQueryRewriter.swap(tblIdx1, tblIdx2);
//				XQueryRewriter.swap(eqStr1, eqStr2);
//			}
			
			//const
//			System.out.println(varToList);
			if (!eqStr1.startsWith("$") || !eqStr2.startsWith("$")) {
				Integer ListIdx;
				ListIdx = eqStr1.startsWith("$") ? varToList.get(eqStr1) : varToList.get(eqStr2);
				Lists.get(ListIdx).whereStats.add(condition.getText().replace("eq", " eq "));
				return;
			}
			Integer tblIdx1 = varToList.get(eqStr1);
			Integer tblIdx2 = varToList.get(eqStr2);
			
			if (tblIdx1 > tblIdx2) {
				Integer temp = tblIdx1;
				tblIdx1 = tblIdx2;
				tblIdx2 = temp;
				String tempStr = eqStr1;
				eqStr1 = eqStr2;
				eqStr2 = tempStr;
			}

			Pair<Integer, Integer> edge = Pair.mkPair(tblIdx1, tblIdx2);
			Pair<String, String> eqVars = Pair.mkPair(eqStr1, eqStr2);	
			if (tblIdx1.equals(tblIdx2)) {
			
				Lists.get(tblIdx1).whereStats.add(condition.getText().replace("eq", " eq "));
				return;
			}
			if (!edgeToEqualPair.containsKey(edge)) {
				edgeToEqualPair.put(edge, new ArrayList<>());
			}
			edgeToEqualPair.get(edge).add(eqVars);
			
		}

	}

	ArrayList<ArrayList<JoinList>> getJoinListGroup() {
		ArrayList<ArrayList<JoinList>> joinLists = new ArrayList();
		ArrayList<Integer> groupIdx = new ArrayList<>();
		for (int i = 0, size = Lists.size(); i < size; i++) {
			groupIdx.add(i);
		}

		for (Pair<Integer, Integer> edge : edgeToEqualPair.keySet()) {
			int left = edge.getfirst(), right = edge.getsecond();
			if (find(groupIdx, left) != find(groupIdx, right)) {
				union(groupIdx, left, right);
			}
		}

		HashMap<Integer, ArrayList<JoinList>> ListToGroup = new HashMap<>();
		for (int i = 0, size = groupIdx.size(); i < size; i++) {
			int rootListIdx = find(groupIdx, i);
			if (!ListToGroup.containsKey(rootListIdx)) {
				ListToGroup.put(rootListIdx, new ArrayList<>());
			}

			ListToGroup.get(rootListIdx).add(Lists.get(i));
		}
		joinLists.addAll(ListToGroup.values());
		return joinLists;
	}

	String output_rewrite() {
		if (Lists.size() < 2) {
			return "Error: less than two Lists";
		}

		String initFor = "for $tuple in ";

		ArrayList<ArrayList<JoinList>> joinLists = getJoinListGroup();

		Collections.sort(joinLists, (a, b) -> {
			int sumVars1 = 0, sumVars2 = 0;
			for (JoinList t : a) sumVars1 += t.vars.size();
			for (JoinList t : b) sumVars2 += t.vars.size();
			return sumVars1 - sumVars2;
		});

		String totalJoin = "";
		
		for (ArrayList<JoinList> ListGroup : joinLists) {
//			System.out.println("ListGroup Size " + ListGroup.size());
			if (ListGroup.size() == 0) {
				continue;
			}

			// Join the Lists with most selection conditions first
			Collections.sort(ListGroup, (a, b) -> a.index - b.index);
			String inGroupJoin = getSingleListFWR(ListGroup.get(0));
			for (int end = 1, size = ListGroup.size(); end < size; end++) {
				ArrayList<Pair<String, String>> mergedPairs = new ArrayList<>();
				for (int start = 0; start < end; start++) {
					Pair<Integer, Integer> edge = Pair.mkPair(ListGroup.get(start).index, ListGroup.get(end).index);
//					System.out.println("start " + start);
//					System.out.println("end " + end);
					if (edge.getfirst() > edge.getsecond()) {
						int first = edge.getfirst(), second = edge.getsecond();
						edge = Pair.mkPair(second, first);
					}

					if (edgeToEqualPair.containsKey(edge)) {
						mergedPairs.addAll(edgeToEqualPair.get(edge));
//						System.out.println(edgeToEqualPair.get(edge)s);
					}
				}
				inGroupJoin = getJoin(inGroupJoin, ListGroup.get(end), mergedPairs);
			}

			if (totalJoin.equals("")) {
				totalJoin = inGroupJoin;
			} else {
				totalJoin = "join (\n " + totalJoin + ",\n" + inGroupJoin + ", \n" + " [], [] ) \n";
			}
		}

		return initFor + totalJoin + "\n" + finalReturnString;

	}

	private int find(ArrayList<Integer> groupIdx, int left) {
		ArrayList<Integer> path = new ArrayList<>();
		while (groupIdx.get(left) != left) {
			path.add(left);
			left = groupIdx.get(left);
		}
		for (int node : path) {
			groupIdx.set(node, left);
		}
		return left;
	}

	private void union(ArrayList<Integer> groupIdx, int left, int right) {
		int leftRoot = find(groupIdx, left);
		int rightRoot = find(groupIdx, right);
		groupIdx.set(rightRoot, leftRoot);
	}

	private String getJoin(String prevJoin, JoinList curList, ArrayList<Pair<String, String>> mergedPairs) {
		String currentJoin = "join ( \n";
		currentJoin += prevJoin + ",\n";
		currentJoin += getSingleListFWR(curList) + ",\n";

		String leftVars = "", rightVars = "";
		for (Pair<String, String> pairVars : mergedPairs) {
			leftVars += pairVars.getfirst().substring(1) + ", ";
			rightVars += pairVars.getsecond().substring(1) + ", ";
		}
//		System.out.println(mergedPairs);
		if (leftVars.length() > 0) {
			leftVars = leftVars.substring(0, leftVars.length() - 2);
			rightVars = rightVars.substring(0, rightVars.length() - 2);
		}
//		System.out.println(leftVars + ";");
//		System.out.println(rightVars + ";");
		currentJoin += "[" + leftVars + "], [" + rightVars + "]";
		currentJoin += ")";

		return currentJoin;
	}

	private String getSingleListFWR(JoinList List) {
		String result = "for ", returnString = "";
		ArrayList<Pair<String, String>> varxps = List.vars;
		for (Pair<String, String> entry : varxps) {
			String varName = entry.getfirst();
			String varNoPrefix = varName.substring(1, varName.length());
			String xp = entry.getsecond();
			result += varName + " in " + xp + ",\n";
			returnString += "<" + varNoPrefix + ">{" + varName + "} </" + varNoPrefix + ">,\n";
		}
		result = result.substring(0, result.length() - 2);
		result = result + "\n";
		returnString = returnString.substring(0, returnString.length() - 2);
		returnString += "\n";
		ArrayList<String> whereClauses = List.whereStats;
		if (whereClauses.size() > 0) {
			result += "where ";
			for (String entry : whereClauses) {
				result += entry + "\n";
			}
		}

		result += "return <tuple> {" + returnString + "} </tuple>\n";
		return result;
	}

}

class JoinList {
	ArrayList<Pair<String, String>> vars;
	ArrayList<String> whereStats;
	int index;

	JoinList(int idx) {
		vars = new ArrayList<>();
		whereStats = new ArrayList<>();
		index = idx;
	}
}

class Pair<K, V> {
	private final K first;
	private final V second;
	public static <K, V> Pair<K, V> mkPair(K first, V second) {
		return new Pair<K, V>(first, second);
	}

	public Pair(K e0, V e1) {
		this.first = e0;
		this.second = e1;
	}

	public K getfirst() {
		return first;
	}

	public V getsecond() {
		return second;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Pair)) {
			return false;
		}
		Pair<K, V> other = (Pair<K, V>) o;
		return first.equals(other.getfirst()) && second.equals(other.getsecond());
	}

	@Override
	public int hashCode() {
		return first.hashCode() * second.hashCode();
	}
}