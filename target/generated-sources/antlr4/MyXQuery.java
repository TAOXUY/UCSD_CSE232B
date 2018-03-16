import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.Tool;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;

import javax.swing.plaf.synth.SynthTextAreaUI;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyXQuery {
    public static void main(String[] args) throws Exception{
     	String fname = "milestone3_230.txt";
        boolean Rewritten =  rewriteFile(fname);
        File input = Rewritten ? new File("rewrite.txt") : new File(fname);
        
        FileInputStream fileinput = new FileInputStream(input);
        ANTLRInputStream inputStream = new ANTLRInputStream(fileinput);
        XQueryLexer lex = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        XQueryParser parser = new XQueryParser(tokenStream);
        ParseTree tree = parser.xq();
        XQueryMyVisitor myVistor = new XQueryMyVisitor();
        ArrayList<Node> result = new ArrayList<Node>();
        result = (ArrayList<Node>) myVistor.visit(tree);

        for (Node n : result) System.out.println(nodeToString(n));

    }
    
    public static boolean rewriteFile(String fname) throws IOException {
   
        File input = new File(fname);
        FileInputStream fileinput = new FileInputStream(input);
        
        ANTLRInputStream inputStream = new ANTLRInputStream(fileinput);
        XQueryLexer lex = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        XQueryParser parser = new XQueryParser(tokenStream);
        XQueryParser.XqContext statement = parser.xq();

        	boolean res = true;
        XQueryRewriter rewriter = new XQueryRewriter();
        rewriter.construct(statement);
        File fout = new File("rewrite.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        String output = rewriter.output_rewrite();
        bw.write(output);
        bw.close();
        return output.startsWith("Error") ? false : true;
    }
    
    public static void removeNodes(Node node) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            removeNodes(list.item(i));
        }
        boolean emptyElement = node.getNodeType() == Node.ELEMENT_NODE
                && node.getChildNodes().getLength() == 0;
        boolean emptyText = node.getNodeType() == Node.TEXT_NODE
                && node.getNodeValue().trim().isEmpty();
        if (emptyElement || emptyText) {
            node.getParentNode().removeChild(node);
        }
    }
    public static String nodeToString(Node node) throws Exception{
        StringWriter sw = new StringWriter();
          Transformer t = TransformerFactory.newInstance().newTransformer();
          t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
          t.setOutputProperty(OutputKeys.INDENT, "yes");
          t.transform(new DOMSource(node), new StreamResult(sw));

        return sw.toString();
      }
    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    //////////////////////////////////////////////////////////////////////////////////////////////////////
//    private String reWriter(XQueryParser.FLWRContext ctx){
//        //PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//        String output = "";
//
//        int numFor;// nums of for clause
//        numFor = ctx.forClause().var().size();
//        List<HashSet<String>> classify = new LinkedList<HashSet<String>>();
//        List<String> relation = new LinkedList<String>();
//        for(int i=0; i < numFor;i++) {
//            String key = ctx.forClause().var(i).getText();
//            String parent = ctx.forClause().xq(i).getText().split("/")[0];
//            int size = classify.size();
//            boolean found = false;
//            // construct the classification
//            for(int j = 0; j < size; j++) {
//                HashSet<String> curSet = classify.get(j);
//                if(curSet.contains(parent)) {
//                    curSet.add(key);
//                    found = true;
//                    break;
//                }
//            }
//            if(!found) {
//                HashSet<String> newSet = new HashSet<String>();
//                newSet.add(key);
//                classify.add(newSet);
//                relation.add(key);
//            }
//        }
//        //where clause
//        String[] where = ctx.whereClause().cond().getText().split("and");
//        String[][] cond = new String[where.length][2];
//        for(int i = 0; i < where.length;i++) {
//            cond[i][0] = where[i].split("eq|=")[0];
//            cond[i][1] = where[i].split("eq|=")[1];
//        }
//
//        if(classify.size() == 1) {
//            System.out.println("No need to join!");
//            return "";
//        }
//        /*
//        the relation that the where condition belongs to. it could belong to two relations at most
//         */
//        int[][] relaWhere = new int[cond.length][2];
//
//        for(int i=0; i < cond.length; i++) {
//            String cur0 = cond[i][0];
//            String cur1 = cond[i][1];
//            relaWhere[i][0] = -1;
//            relaWhere[i][1] = -1;
//            for(int j = 0; j < classify.size();j++) {
//                if(classify.get(j).contains(cur0)) {
//                    relaWhere[i][0] = j;
//                }
//                if(classify.get(j).contains(cur1)) {
//                    relaWhere[i][1] = j;
//                }
//            }
//        }
//
//
//        int class_size = classify.size();
//        //print out
//        output += "for $tuple in";
//        //writer.print("For $tuple in join  (");
//        System.out.print("for $tuple in");
//        for (int i = 1; i < class_size;i++) {
//
//                output += " join (";
//                System.out.print(" join (");
//
//        }
//        //for clause
//        //print eq: [af1,al1],[af21,al21]
//        output = Print2Join(classify, ctx, output,cond,relaWhere);
//
//        if(class_size > 2) {
//            output = Print3Join(classify, ctx, output, cond, relaWhere);
//        }
//        if(class_size > 3) {
//            output = Print4Join(classify, ctx, output, cond, relaWhere);
//        }
//        if(class_size > 4) {
//            output = Print5Join(classify, ctx, output, cond, relaWhere);
//        }
//        if(class_size > 5) {
//            output = Print6Join(classify, ctx, output, cond, relaWhere);
//        }
//
//        /*
//            return clause
//        */
//        String retClause = ctx.returnClause().xq().getText();
//        String[] tempRet = retClause.split("\\$");
//        for (int i = 0; i < tempRet.length-1; i++) {
//            tempRet[i] = tempRet[i]+"$tuple/";
//        }
//        retClause  = tempRet[0];
//        for (int i = 1; i < tempRet.length; i++) {
//            String[] cur1 = tempRet[i].split(",",2);
//            String[] cur2 = tempRet[i].split("}",2);
//            String[] cur3 = tempRet[i].split("/",2);
//            String[] cur = cur1;
//            if(cur2[0].length() < cur[0].length()) {
//                cur = cur2;
//            }
//            if(cur3[0].length() < cur[0].length()) {
//                cur = cur3;
//            }
//            tempRet[i] = cur[0] + "/*";
////            if(cur[1].charAt(0) == '$' || cur[1].charAt(0) == '<') {
////                tempRet[i] += ",";
////            }else {
////                tempRet[i] += "/";
////            }
//            if(cur == cur1) {
//                tempRet[i] += ",";
//            }else if(cur == cur2) {
//                tempRet[i] += "}";
//            }else {
//                tempRet[i] += "/";
//            }
//            tempRet[i] += cur[1];
//            retClause = retClause + tempRet[i];
//        }
////        int end = tempRet.length-1;
////        String[] cur = tempRet[end].split("}",2);
////        tempRet[end] = cur[0] + "/*}";
////        tempRet[end] += cur[1];
////        retClause = retClause + tempRet[end];
//
//        output += "return\n";
//        output += retClause+"\n";
//        System.out.println("return");
//        System.out.println(retClause);
//        /*
//            write in txt
//         */
////        writer w = new writer();
////        w.writing("input/output.txt",output);
//        return output;
//    }
//
//    private String PrintJoinCond(LinkedList<String> ret0, LinkedList<String> ret1, String output) {
//        output += "                 [";
//        System.out.print("                 [");
//        for(int i = 0; i < ret0.size();i++) {
//            output +=ret0.get(i);
//            System.out.print(ret0.get(i));
//            if(i != ret0.size()-1) {
//                output +=",";
//                System.out.print(",");
//            }
//        }
//        output +="], [";
//        System.out.print("], [");
//        for(int i = 0; i < ret1.size();i++) {
//            output +=ret1.get(i);
//            System.out.print(ret1.get(i));
//            if(i != ret1.size()-1) {
//                output +=",";
//                System.out.print(",");
//            }
//        }
//        output += "]  ";
//        System.out.print("]  ");
//        return output;
//    }
//
//    private String Print2Join(List<HashSet<String>> classify, XQueryParser.FLWRContext ctx, String output,String[][] cond,int[][] relaWhere) {
//        //for clause
//        int numFor = ctx.forClause().var().size();
//        //for(int i = 0; i < classify.size(); i++) {
//        for(int i = 0; i < 2; i++) {
//            HashSet<String> curSet = classify.get(i);
//            String tuples = "";
//            int count = 0;
//            //print for
//            for(int k = 0; k < numFor; k++) {
//                String key = ctx.forClause().var(k).getText();
//                if(curSet.contains(key)){
//                    if(count == 0) {
//                        output += "for " + key + " in " + ctx.forClause().xq(k).getText();
//                        System.out.print("for " + key + " in " + ctx.forClause().xq(k).getText());
//                        count++;
//                    }else {
//                        output += ",\n";
//                        output += "                   " + key + " in " + ctx.forClause().xq(k).getText();
//                        System.out.println(",");
//                        System.out.print("                   " + key + " in " + ctx.forClause().xq(k).getText());
//                    }
//                    if(tuples.equals("")) {
//                        tuples = tuples + " <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                    }else {
//                        tuples = tuples + ", <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                    }
//                }
//            }
//            output += "\n";
//            System.out.print("\n");
//            //print where
//            for(int j = 0;j < cond.length;j++) {
//                int count1 = 0;
//                if(relaWhere[j][1] == -1 && curSet.contains(cond[j][0])) {
//                    if(count1 == 0){
//                        count1++;
//                        output += "where " + cond[j][0] + " eq " + cond[j][1] +"\n";
//                        System.out.println("where " + cond[j][0] + " eq " + cond[j][1]);
//                    }else {
//                        output += " and  " + cond[j][0] + " eq " + cond[j][1] + "\n";
//                        System.out.println(" and  " + cond[j][0] + " eq " + cond[j][1]);
//                    }
//                }
//            }
//            //print return
//            tuples = "<tuple> "+tuples+" </tuple>,";
//            output += "                  return" + tuples + "\n";
//            System.out.println("                  return" + tuples);
//        }
//        //return
//        LinkedList<String> ret0 = new LinkedList<String>();
//        LinkedList<String> ret1 = new LinkedList<String>();
//        for(int i = 0; i < cond.length; i++) {
//            if (relaWhere[i][0] == 1 && relaWhere[i][1] == 0) {
//                ret0.add(cond[i][1].substring(1));
//                ret1.add(cond[i][0].substring(1));
//            }else if(relaWhere[i][0] == 0 && relaWhere[i][1] == 1) {
//                ret0.add(cond[i][0].substring(1));
//                ret1.add(cond[i][1].substring(1));
//            }
//        }
//        output = PrintJoinCond(ret0,ret1,output);
//        output += ")\n";
//        System.out.println(")");
//        return output;
//    }
//    private String Print3Join(List<HashSet<String>> classify, XQueryParser.FLWRContext ctx,String output,String[][] cond,int[][] relaWhere) {
//        int numFor = ctx.forClause().var().size();
//        HashSet<String> curSet = classify.get(2);
//        String tuples = "";
//        int count = 0;
//        //print for
//        for(int k = 0; k < numFor; k++) {
//            String key = ctx.forClause().var(k).getText();
//            if(curSet.contains(key)){
//                if(count == 0) {
//                    output += ",for " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.print(",for " + key + " in " + ctx.forClause().xq(k).getText());
//                    count++;
//                }else {
//                    output += ",\n";
//                    output += "                   " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.println(",");
//                    System.out.print("                   " + key + " in " + ctx.forClause().xq(k).getText());
//                }
//                if(tuples.equals("")) {
//                    tuples = tuples + " <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }else {
//                    tuples = tuples + ", <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }
//            }
//        }
//        output += "\n";
//        System.out.print("\n");
//        //print where
//        for(int j = 0;j < cond.length;j++) {
//            int count1 = 0;
//            if(relaWhere[j][1] == -1 && curSet.contains(cond[j][0])) {
//                if(count1 == 0){
//                    count1++;
//                    output += "where " + cond[j][0] + " eq " + cond[j][1] +"\n";
//                    System.out.println("where " + cond[j][0] + " eq " + cond[j][1]);
//                }else {
//                    output += " and  " + cond[j][0] + " eq " + cond[j][1] + "\n";
//                    System.out.println(" and  " + cond[j][0] + " eq " + cond[j][1]);
//                }
//            }
//        }
//        //print return
//        tuples = "<tuple> "+tuples+" </tuple>,";
//        output += "                  return" + tuples + "\n";
//        System.out.println("                  return" + tuples);
//
//        LinkedList<String> ret0 = new LinkedList<String>();
//        LinkedList<String> ret2 = new LinkedList<String>();
//        for(int i = 0; i < cond.length; i++) {
//            if (relaWhere[i][0] == 2 && (relaWhere[i][1] == 1 || relaWhere[i][1] == 0)){
//                ret0.add(cond[i][1].substring(1));
//                ret2.add(cond[i][0].substring(1));
//            }else if((relaWhere[i][0] == 1 || relaWhere[i][0] == 0) && relaWhere[i][1] == 2) {
//                ret0.add(cond[i][0].substring(1));
//                ret2.add(cond[i][1].substring(1));
//            }
//        }
//        output = PrintJoinCond(ret0,ret2,output);
//        output += ")\n";
//        System.out.println(")");
//        return output;
//    }
//    private String Print4Join(List<HashSet<String>> classify, XQueryParser.FLWRContext ctx,String output,String[][] cond,int[][] relaWhere) {
//        int numFor = ctx.forClause().var().size();
//        HashSet<String> curSet = classify.get(3);
//        String tuples = "";
//        int count = 0;
//        //print for
//        for(int k = 0; k < numFor; k++) {
//            String key = ctx.forClause().var(k).getText();
//            if(curSet.contains(key)){
//                if(count == 0) {
//                    output += ",for " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.print(",for " + key + " in " + ctx.forClause().xq(k).getText());
//                    count++;
//                }else {
//                    output += ",\n";
//                    output += "                   " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.println(",");
//                    System.out.print("                   " + key + " in " + ctx.forClause().xq(k).getText());
//                }
//                if(tuples.equals("")) {
//                    tuples = tuples + " <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }else {
//                    tuples = tuples + ", <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }
//            }
//        }
//        output += "\n";
//        System.out.print("\n");
//        //print where
//        for(int j = 0;j < cond.length;j++) {
//            int count1 = 0;
//            if(relaWhere[j][1] == -1 && curSet.contains(cond[j][0])) {
//                if(count1 == 0){
//                    count1++;
//                    output += "where " + cond[j][0] + " eq " + cond[j][1] +"\n";
//                    System.out.println("where " + cond[j][0] + " eq " + cond[j][1]);
//                }else {
//                    output += " and  " + cond[j][0] + " eq " + cond[j][1] + "\n";
//                    System.out.println(" and  " + cond[j][0] + " eq " + cond[j][1]);
//                }
//            }
//        }
//        //print return
//        tuples = "<tuple> "+tuples+" </tuple>,";
//        output += "                  return" + tuples + "\n";
//        System.out.println("                  return" + tuples);
//
//        LinkedList<String> ret0 = new LinkedList<String>();
//        LinkedList<String> ret2 = new LinkedList<String>();
//        for(int i = 0; i < cond.length; i++) {
//            if (relaWhere[i][0] == 3 && (relaWhere[i][1] >= 0 && relaWhere[i][1] <= 2)){
//                ret0.add(cond[i][1].substring(1));
//                ret2.add(cond[i][0].substring(1));
//            }else if((relaWhere[i][0] >= 0 && relaWhere[i][0] <= 2) && relaWhere[i][1] == 3) {
//                ret0.add(cond[i][0].substring(1));
//                ret2.add(cond[i][1].substring(1));
//            }
//        }
//        output = PrintJoinCond(ret0,ret2,output);
//        output += ")\n";
//        System.out.println(")");
//        return output;
//    }
//    private String Print5Join(List<HashSet<String>> classify, XQueryParser.FLWRContext ctx,String output,String[][] cond,int[][] relaWhere) {
//        int numFor = ctx.forClause().var().size();
//        HashSet<String> curSet = classify.get(4);
//        String tuples = "";
//        int count = 0;
//        //print for
//        for(int k = 0; k < numFor; k++) {
//            String key = ctx.forClause().var(k).getText();
//            if(curSet.contains(key)){
//                if(count == 0) {
//                    output += ",for " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.print(",for " + key + " in " + ctx.forClause().xq(k).getText());
//                    count++;
//                }else {
//                    output += ",\n";
//                    output += "                   " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.println(",");
//                    System.out.print("                   " + key + " in " + ctx.forClause().xq(k).getText());
//                }
//                if(tuples.equals("")) {
//                    tuples = tuples + " <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }else {
//                    tuples = tuples + ", <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }
//            }
//        }
//        output += "\n";
//        System.out.print("\n");
//        //print where
//        for(int j = 0;j < cond.length;j++) {
//            int count1 = 0;
//            if(relaWhere[j][1] == -1 && curSet.contains(cond[j][0])) {
//                if(count1 == 0){
//                    count1++;
//                    output += "where " + cond[j][0] + " eq " + cond[j][1] +"\n";
//                    System.out.println("where " + cond[j][0] + " eq " + cond[j][1]);
//                }else {
//                    output += " and  " + cond[j][0] + " eq " + cond[j][1] + "\n";
//                    System.out.println(" and  " + cond[j][0] + " eq " + cond[j][1]);
//                }
//            }
//        }
//        //print return
//        tuples = "<tuple> "+tuples+" </tuple>,";
//        output += "                  return" + tuples + "\n";
//        System.out.println("                  return" + tuples);
//
//        LinkedList<String> ret0 = new LinkedList<String>();
//        LinkedList<String> ret2 = new LinkedList<String>();
//        for(int i = 0; i < cond.length; i++) {
//            if (relaWhere[i][0] == 2 && (relaWhere[i][1] == 1 || relaWhere[i][1] == 0)){
//                ret0.add(cond[i][1].substring(1));
//                ret2.add(cond[i][0].substring(1));
//            }else if((relaWhere[i][0] == 1 || relaWhere[i][0] == 0) && relaWhere[i][1] == 2) {
//                ret0.add(cond[i][0].substring(1));
//                ret2.add(cond[i][1].substring(1));
//            }
//        }
//        output = PrintJoinCond(ret0,ret2,output);
//        output += ")\n";
//        System.out.println(")");
//        return output;
//    }
//    private String Print6Join(List<HashSet<String>> classify, XQueryParser.FLWRContext ctx,String output,String[][] cond,int[][] relaWhere) {
//        int numFor = ctx.forClause().var().size();
//        HashSet<String> curSet = classify.get(5);
//        String tuples = "";
//        int count = 0;
//        //print for
//        for(int k = 0; k < numFor; k++) {
//            String key = ctx.forClause().var(k).getText();
//            if(curSet.contains(key)){
//                if(count == 0) {
//                    output += ",for " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.print(",for " + key + " in " + ctx.forClause().xq(k).getText());
//                    count++;
//                }else {
//                    output += ",\n";
//                    output += "                   " + key + " in " + ctx.forClause().xq(k).getText();
//                    System.out.println(",");
//                    System.out.print("                   " + key + " in " + ctx.forClause().xq(k).getText());
//                }
//                if(tuples.equals("")) {
//                    tuples = tuples + " <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }else {
//                    tuples = tuples + ", <" + key.substring(1) + "> " + " {" + key + "} " + " </" + key.substring(1) + ">";
//                }
//            }
//        }
//        output += "\n";
//        System.out.print("\n");
//        //print where
//        for(int j = 0;j < cond.length;j++) {
//            int count1 = 0;
//            if(relaWhere[j][1] == -1 && curSet.contains(cond[j][0])) {
//                if(count1 == 0){
//                    count1++;
//                    output += "where " + cond[j][0] + " eq " + cond[j][1] +"\n";
//                    System.out.println("where " + cond[j][0] + " eq " + cond[j][1]);
//                }else {
//                    output += " and  " + cond[j][0] + " eq " + cond[j][1] + "\n";
//                    System.out.println(" and  " + cond[j][0] + " eq " + cond[j][1]);
//                }
//            }
//        }
//        //print return
//        tuples = "<tuple> "+tuples+" </tuple>,";
//        output += "                  return" + tuples + "\n";
//        System.out.println("                  return" + tuples);
//
//        LinkedList<String> ret0 = new LinkedList<String>();
//        LinkedList<String> ret2 = new LinkedList<String>();
//        for(int i = 0; i < cond.length; i++) {
//            if (relaWhere[i][0] == 2 && (relaWhere[i][1] == 1 || relaWhere[i][1] == 0)){
//                ret0.add(cond[i][1].substring(1));
//                ret2.add(cond[i][0].substring(1));
//            }else if((relaWhere[i][0] == 1 || relaWhere[i][0] == 0) && relaWhere[i][1] == 2) {
//                ret0.add(cond[i][0].substring(1));
//                ret2.add(cond[i][1].substring(1));
//            }
//        }
//        output = PrintJoinCond(ret0,ret2,output);
//        output += ")\n";
//        System.out.println(")");
//        return output;
//    }

}