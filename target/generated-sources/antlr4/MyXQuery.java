
import java.io.*;
import java.util.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;

public class MyXQuery {

	public static void main(String[] args) throws Exception {
//		String content0 = new Scanner(new File("target/generated-sources/antlr4/XQueryExample.txt")).useDelimiter("\\Z")
//				.next();
//		String fn0 = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
//		String fn1 = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE";
//		String fn2 = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE";
//		String fn3 = "doc(\"j_caesar.xml\")//ACT[(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE";
		String fn0 = "inputQuery4.txt";
		System.out.println(new File(".").getAbsoluteFile());
		
        File input = new File(fn0);
        System.out.println(input.canRead());
        FileInputStream fileinput = new FileInputStream(input);

        ANTLRInputStream inputStream = new ANTLRInputStream(fileinput);

        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        XQueryMyVistor eval = new XQueryMyVistor();
        ArrayList<Node> finalResult = eval.visit(parser.ap());

        System.out.println("finalResult size: " + finalResult.size());
        for(Node n:finalResult) {
        	System.out.println(nodeToString(n));
//            System.out.println(n.getNodeName());
        }
    }
	
	
	private static Element dfs(Document doc, Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = doc.createElement(node.getNodeName());
            NodeList tmp = node.getChildNodes();
            for (int i = 0; i < tmp.getLength(); i++) {
                if (tmp.item(i).getNodeType() == Node.TEXT_NODE) {
                    Node txt = doc.createTextNode(node.getTextContent());
                    element.appendChild(txt);
                } else element.appendChild(dfs(doc, tmp.item(i)));
            }
            return element;
        }
        return null;
    }
	
	private static String nodeToString(Node node) {
	    StringWriter sw = new StringWriter();
	    try {
	      Transformer t = TransformerFactory.newInstance().newTransformer();
	      t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	      t.setOutputProperty(OutputKeys.INDENT, "yes");
	      t.transform(new DOMSource(node), new StreamResult(sw));
	    } catch (TransformerException te) {
	      System.out.println("nodeToString Transformer Exception");
	    }
	    return sw.toString();
	  }
}