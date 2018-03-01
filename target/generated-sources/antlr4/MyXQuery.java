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
import java.util.ArrayList;


public class MyXQuery {
    public static void main(String[] args) throws Exception{
        String fname = "inputQuery.txt";
        File input = new File(fname);
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

}