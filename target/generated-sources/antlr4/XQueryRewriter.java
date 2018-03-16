import java.lang.reflect.Array;
import java.util.*;

class JoinTable {
	ArrayList<Pair<String, String>> vars;
	ArrayList<String> whereStats;
	int index;

	JoinTable(int idx) {
		vars = new ArrayList<>();
		whereStats = new ArrayList<>();
		index = idx;
	}
}

class Pair<K, V> {
	private final K v0;
	private final V v1;

	public static <K, V> Pair<K, V> mkPair(K v0, V v1) {
		return new Pair<K, V>(v0, v1);
	}

	public Pair(K e0, V e1) {
		this.v0 = e0;
		this.v1 = e1;
	}

	public K getV0() {
		return v0;
	}

	public V getV1() {
		return v1;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Pair)) {
			return false;
		}
		Pair<K, V> other = (Pair<K, V>) o;
		return v0.equals(other.getV0()) && v1.equals(other.getV1());
	}

	@Override
	public int hashCode() {
		return v0.hashCode() * v1.hashCode();
	}
}

class XQueryRewriter {

	private ArrayList<JoinTable> tables;
	private String finalReturnString;
	private HashMap<String, Integer> varToTable;
	private HashMap<Pair<Integer, Integer>, ArrayList<Pair<String, String>>> edgeToEqualPair;

	XQueryRewriter() {
		finalReturnString = "";
		tables = new ArrayList<>();
		varToTable = new HashMap<>();
		edgeToEqualPair = new HashMap<>();
	}

	public static void swap(Object a, Object b) {
		Object temp = a;
		a = b;
		b = temp;
	}

	void construct(XQueryParser.XqContext statement) {
		if (!(statement instanceof XQueryParser.FLWRContext)) {
			return;
		}
		XQueryParser.ForClauseContext forClauseContext = ((XQueryParser.FLWRContext) statement).forClause();
		XQueryParser.WhereClauseContext whereClauseContext = ((XQueryParser.FLWRContext) statement).whereClause();
		XQueryParser.ReturnClauseContext returnClauseContext = ((XQueryParser.FLWRContext) statement).returnClause();

		// Analyze FOR clause.
		for (int i = 0, size = forClauseContext.var().size(); i < size; i++) {
			String varName = "$" + forClauseContext.var(i).getText();
			String statementStr = forClauseContext.xq(i).getText();

			// Combine variable with its corresponding statement definition.
			Pair<String, String> varStatement = Pair.mkPair(varName, statementStr);

			// Get which table this variable should belong to.
			Integer tableIdx;
			if (statementStr.startsWith("doc")) {
				// Statement contains 'DOC' as prefix. This is a new table. Create one.
				tableIdx = tables.size();
				tables.add(new JoinTable(tableIdx));
			} else {
				// Look for which table current variable belongs to by looking at its prefix
				// variable.
				int slashPos = statementStr.indexOf('/') == -1 ? statementStr.length() : statementStr.indexOf('/');
				String prefixVar = statementStr.substring(0, slashPos);
				// System.out.println(prefixVar);
				tableIdx = varToTable.get(prefixVar);
			}
			tables.get(tableIdx).vars.add(varStatement);
			varToTable.put(varName, tableIdx);
			// System.out.println(varName + " " + tableIdx);
		}

		// Analyze WHERE clause.
		XQueryParser.CondContext condition = whereClauseContext.cond();
		dfs(condition);

		// Analyse RETURN clause
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

		if (condition instanceof XQueryParser.XQCondEqualContext) {
			XQueryParser.XQCondEqualContext equalContext = (XQueryParser.XQCondEqualContext) condition;
			String eqStr1 = equalContext.xq(0).getText();
			String eqStr2 = equalContext.xq(1).getText();
			//const
			int len1 = eqStr1.length(), len2 = eqStr2.length();
//			int len1 = eqStr1.indexOf("/") == -1 ? eqStr1.length() : eqStr1.indexOf("/");
//			int len2 = eqStr2.indexOf("/") == -1 ? eqStr2.length() : eqStr2.indexOf("/");
			Integer tblIdx1 = varToTable.get(eqStr1.substring(0, len1));
			Integer tblIdx2 = varToTable.get(eqStr2.substring(0, len2));
			if (!eqStr1.startsWith("$") || !eqStr2.startsWith("$")) {
				Integer tableIdx;
				tableIdx = eqStr1.startsWith("$") ? tblIdx1 : tblIdx2;
				tables.get(tableIdx).whereStats.add(condition.getText().replace("eq", " eq "));
				return;
			}


			System.out.println(eqStr1 + ";" + eqStr2);
			System.out.println(tblIdx1 + ";" + tblIdx2);
			if (tblIdx1 > tblIdx2) {
				XQueryRewriter.swap(tblIdx1, tblIdx2);
				XQueryRewriter.swap(eqStr1, eqStr2);
			}
			Pair<Integer, Integer> edge = Pair.mkPair(tblIdx1, tblIdx2);
			Pair<String, String> eqVars = Pair.mkPair(eqStr1, eqStr2);

			//same table
			if (tblIdx1.equals(tblIdx2)) {
				tables.get(tblIdx1).whereStats.add(condition.getText().replace("eq", " eq "));
				return;
			}
			if (!edgeToEqualPair.containsKey(edge)) {
				edgeToEqualPair.put(edge, new ArrayList<>());
			}
			edgeToEqualPair.get(edge).add(eqVars);

		}

	}

	ArrayList<ArrayList<JoinTable>> getJoinTableGroup() {
		ArrayList<ArrayList<JoinTable>> joinTables = new ArrayList();
		ArrayList<Integer> groupIdx = new ArrayList<>();
		for (int i = 0, size = tables.size(); i < size; i++) {
			groupIdx.add(i);
		}

		for (Pair<Integer, Integer> edge : edgeToEqualPair.keySet()) {
			int left = edge.getV0(), right = edge.getV1();
			if (qFind(groupIdx, left) != qFind(groupIdx, right)) {
				qUnion(groupIdx, left, right);
			}
		}

		HashMap<Integer, ArrayList<JoinTable>> tableToGroup = new HashMap<>();
		for (int i = 0, size = groupIdx.size(); i < size; i++) {
			int rootTableIdx = qFind(groupIdx, i);
			if (!tableToGroup.containsKey(rootTableIdx)) {
				tableToGroup.put(rootTableIdx, new ArrayList<>());
			}

			tableToGroup.get(rootTableIdx).add(tables.get(i));
		}
		joinTables.addAll(tableToGroup.values());
		return joinTables;
	}

	String output_rewrite() {
		if (tables.size() < 2) {
			return "Error: less than two tables";
		}

		String initFor = "for $tuple in ";

		ArrayList<ArrayList<JoinTable>> joinTables = getJoinTableGroup();

		Collections.sort(joinTables, (a, b) -> {
			int sumVars1 = 0, sumVars2 = 0;
			for (JoinTable t : a) sumVars1 += t.vars.size();
			for (JoinTable t : b) sumVars2 += t.vars.size();
			return sumVars1 - sumVars2;
		});

		String totalJoin = "";

		for (ArrayList<JoinTable> tableGroup : joinTables) {
			if (tableGroup.size() == 0) {
				continue;
			}

			// Join the tables with most selection conditions first
			Collections.sort(tableGroup, (a, b) -> a.index - b.index);
			String inGroupJoin = getSingleTableFWR(tableGroup.get(0));
			for (int end = 1, size = tableGroup.size(); end < size; end++) {
				ArrayList<Pair<String, String>> mergedPairs = new ArrayList<>();
				for (int start = 0; start < end; start++) {
					Pair<Integer, Integer> edge = Pair.mkPair(tableGroup.get(start).index, tableGroup.get(end).index);
					if (edge.getV0() > edge.getV1()) {
						int v0 = edge.getV0(), v1 = edge.getV1();
						edge = Pair.mkPair(v1, v0);
					}

					if (edgeToEqualPair.containsKey(edge)) {
						mergedPairs.addAll(edgeToEqualPair.get(edge));
					}
				}
				inGroupJoin = getJoinStr(inGroupJoin, tableGroup.get(end), mergedPairs);
			}

			if (totalJoin.equals("")) {
				totalJoin = inGroupJoin;
			} else {
				totalJoin = "join (\n " + totalJoin + ",\n" + inGroupJoin + ", \n" + " [], [] ) \n";
			}
		}

		return initFor + totalJoin + "\n" + finalReturnString;

	}

	private int qFind(ArrayList<Integer> groupIdx, int left) {
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

	private void qUnion(ArrayList<Integer> groupIdx, int left, int right) {
		int leftRoot = qFind(groupIdx, left);
		int rightRoot = qFind(groupIdx, right);
		groupIdx.set(rightRoot, leftRoot);
	}

	private String getJoinStr(String prevJoin, JoinTable curTable, ArrayList<Pair<String, String>> mergedPairs) {
		String currentJoin = "join ( \n";
		currentJoin += prevJoin + ",\n";
		currentJoin += getSingleTableFWR(curTable) + ",\n";

		String leftVars = "", rightVars = "";
		for (Pair<String, String> pairVars : mergedPairs) {
			leftVars += pairVars.getV0().substring(1) + ", ";
			rightVars += pairVars.getV1().substring(1) + ", ";
		}

		if (leftVars.length() > 0) {
			leftVars = leftVars.substring(0, leftVars.length() - 2);
			rightVars = rightVars.substring(0, rightVars.length() - 2);
		}
		currentJoin += "[" + leftVars + "], [" + rightVars + "]";
		currentJoin += ")";

		return currentJoin;
	}

	private String getSingleTableFWR(JoinTable table) {
		String result = "for ", returnString = "";
		ArrayList<Pair<String, String>> varStatements = table.vars;
		for (Pair<String, String> entry : varStatements) {
			String varName = entry.getV0();
			String varNoPrefix = varName.substring(1, varName.length());
			String statement = entry.getV1();
			result += varName + " in " + statement + ",\n";
			returnString += "<" + varNoPrefix + ">{" + varName + "} </" + varNoPrefix + ">,\n";
		}
		result = result.substring(0, result.length() - 2);
		result = result + "\n";
		returnString = returnString.substring(0, returnString.length() - 2);
		returnString += "\n";
		ArrayList<String> whereClauses = table.whereStats;
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
