//
//import java.io.*;
//import java.util.*;
//
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.antlr.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.*;
//
//public class MyXQuery {
//
//	public static void main(String[] args) throws Exception {
////		String content0 = new Scanner(new File("target/generated-sources/antlr4/XQueryExample.txt")).useDelimiter("\\Z")
////				.next();
////		String fn0 = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
////		String fn1 = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE";
////		String fn2 = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE";
////		String fn3 = "doc(\"j_caesar.xml\")//ACT[(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE";
//		String fp = "inputQuery4.txt";
//		System.out.println(new File(".").getAbsoluteFile());
//		
//        File input = new File(fp);
//        System.out.println(input.canRead());
//        FileInputStream fileinput = new FileInputStream(input);
//
//        ANTLRInputStream inputStream = new ANTLRInputStream(fileinput);
//
//        XQueryLexer lexer = new XQueryLexer(inputStream);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        XQueryParser parser = new XQueryParser(tokens);
//        XQueryMyVistor eval = new XQueryMyVistor();
//        LinkedList<Node> finalResult = (LinkedList<Node>) eval.visit(parser.ap());
//        System.out.println("finalResult size: " + finalResult.size());
//        for(Node n:finalResult) {
//        	System.out.println(nodeToString(n));
////            System.out.println(n.getNodeName());
//        }
//    }
//	
//	
//	private static Element dfs(Document doc, Node node){
//        if (node.getNodeType() == Node.ELEMENT_NODE) {
//            Element element = doc.createElement(node.getNodeName());
//            NodeList tmp = node.getChildNodes();
//            for (int i = 0; i < tmp.getLength(); i++) {
//                if (tmp.item(i).getNodeType() == Node.TEXT_NODE) {
//                    Node txt = doc.createTextNode(node.getTextContent());
//                    element.appendChild(txt);
//                } else element.appendChild(dfs(doc, tmp.item(i)));
//            }
//            return element;
//        }
//        return null;
//    }
//	
//	private static String nodeToString(Node node) {
//	    StringWriter sw = new StringWriter();
//	    try {
//	      Transformer t = TransformerFactory.newInstance().newTransformer();
//	      t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//	      t.setOutputProperty(OutputKeys.INDENT, "yes");
//	      t.transform(new DOMSource(node), new StreamResult(sw));
//	    } catch (TransformerException te) {
//	      System.out.println("nodeToString Transformer Exception");
//	    }
//	    return sw.toString();
//	  }
//}



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
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.LinkedList;


public class MyXQuery {
    public static void main(String[] args) throws Exception{
        String fname = "inputQuery4.txt";
        File input = new File(fname);
        FileInputStream fileinput = new FileInputStream(input);
        ANTLRInputStream inputStream = new ANTLRInputStream(fileinput);

        XQueryLexer lex = new XQueryLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        XQueryParser parser = new XQueryParser(tokenStream);
        ParseTree tree = parser.xq();
        XQueryMyVisitor myVistor = new XQueryMyVisitor();
        LinkedList<Node> result = new LinkedList<Node>();
        result = (LinkedList<Node>) myVistor.visit(tree);
        for (Node n : result){
        	removeNodes(n);
        System.out.println(nodeToString(n));
        }

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
    private static String nodeToString(Node node) throws Exception{
        StringWriter sw = new StringWriter();

          Transformer t = TransformerFactory.newInstance().newTransformer();
          t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
          t.setOutputProperty(OutputKeys.INDENT, "yes");
          t.transform(new DOMSource(node), new StreamResult(sw));

        return sw.toString();
      }

}