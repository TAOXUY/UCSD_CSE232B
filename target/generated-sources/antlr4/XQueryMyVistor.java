import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XQueryMyVistor extends XQueryBaseVisitor<ArrayList<Node>> {
	private ArrayList<Node> curNodes = new ArrayList<>();
    private boolean hasAttribute = false;
    
	private static ArrayList<Node> children(Node n) {
		ArrayList<Node> childrenList = new ArrayList<Node>();
        for(int i = 0; i < n.getChildNodes().getLength(); i++){
            childrenList.add((Node)n.getChildNodes().item(i));
        }
        return childrenList;
	}
	
	
	@Override
    public ArrayList<Node> visitDoc(XQueryParser.DocContext ctx) {
        File xmlFltre = new File(ctx.fname().getText()); //dont know whats in xmlFltre
        DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docB = null;
        System.out.println("aa");
        try {
            docB = docBF.newDocumentBuilder();
        } catch (ParserConfigurationException pE1) {
            pE1.printStackTrace();
        }
        Document doc = null; //use for what
        try {
            if (docB != null) {
                doc = docB.parse(xmlFltre);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        ArrayList<Node> res = new ArrayList<>();
        res.add((Node)doc);
        curNodes = res;
        return res;
    }
	
	@Override
    public ArrayList<Node> visitAPChildren(XQueryParser.APChildrenContext ctx) {
		visit(ctx.doc());
		ArrayList<Node> res = new ArrayList<>();
        for(Node temp : curNodes) {
            res.addAll(children(temp));
        }
        curNodes = res;
        return res;
    }
	
//	@Override
//    public ArrayList<Node> visitAPAll(XQueryParser.APAllContext ctx) {
//        return visitChildren(ctx); // ???
//    }
	
	@Override
    public ArrayList<Node> visitAPAll(XQueryParser.APAllContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        visit(ctx.doc());
        res.addAll(curNodes);
        queue.addAll(curNodes);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            res.addAll(children(temp));
            queue.addAll(children(temp));
        }
        curNodes = res;
        return visit(ctx.rp());
    }

//    @Override
//    public ArrayList<Node> visitAllChildren(XQueryParser.AllChildrenContext ctx) {
//        ArrayList<Node> res = new ArrayList<>();
//        for(Node temp : curNodes) {
//            res.addAll(children(temp));
//        }
//        curNodes = res;
//        return res;
//    }
    
    
    @Override
    public ArrayList<Node> visitTagName(XQueryParser.TagNameContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        String tName = ctx.getText();
        for(Node temp : curNodes) {
            ArrayList<Node> nodeList = children(temp);
            for(Node i : nodeList) {
                if(!i.getNodeName().equals(tName)) continue; 
                	res.add(i);
            }
        }
        curNodes = res;
        return res;
    }
    
    @Override
    public ArrayList<Node> visitAllChildren(XQueryParser.AllChildrenContext ctx) {
    	 	ArrayList<Node> res = new ArrayList<>();
         for(Node temp : curNodes) {
             res.addAll(children(temp));
         }
         curNodes = res;
         return res;
    }
    

    @Override
    public ArrayList<Node> visitCurrent(XQueryParser.CurrentContext ctx) {
        return curNodes;
    }
    
    @Override
    public ArrayList<Node> visitParent(XQueryParser.ParentContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        for(Node temp : curNodes) {
            if(res.contains(temp.getParentNode())) continue; 
            	res.add(temp.getParentNode());
        }
        curNodes = res;
        return res;
    }
    
    
    @Override
    public ArrayList<Node> visitText(XQueryParser.TextContext ctx) { //???
    		ArrayList<Node> res = new ArrayList<>();
        for (Node temp :curNodes) {
            for (int i = 0; i < temp.getChildNodes().getLength(); i++) {
                if (temp.getChildNodes().item(i).getNodeType() != Node.TEXT_NODE) continue;
                if (temp.getChildNodes().item(i).getTextContent().equals("\n")) continue;
                res.add((Node) temp.getChildNodes().item(i));
//                System.out.print(temp.getChildNodes().item(i).getTextContent());
            }
        }
        curNodes = res;
        return curNodes; //curNodes didnt change why return it
    }
    
    @Override
    public ArrayList<Node> visitAttribute(XQueryParser.AttributeContext ctx) { //???
        ArrayList<Node> res = new ArrayList<>();
        hasAttribute = true;
        for (Node temp : curNodes) {
            Element e = (Element) temp;
            String attr = e.getAttribute(ctx.NAME().getText());
            if (attr.equals("")) continue;
            res.add(temp);
            attr = ctx.NAME().getText()+"=\""+ attr +"\"";
            System.out.println(attr);
        }
        curNodes = res;
        return res;
    }
    
    @Override
    public ArrayList<Node> visitRpChildren(XQueryParser.RpChildrenContext ctx) {
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        return curNodes;
    }


    @Override
    public ArrayList<Node> visitRpAll(XQueryParser.RpAllContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        visit(ctx.rp(0));
        res.addAll(curNodes);
        queue.addAll(curNodes);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            res.addAll(children(temp));
            queue.addAll(children(temp));
        }
        curNodes = res;
        return visit(ctx.rp(1));
    }
    
    @Override
    public ArrayList<Node> visitTwoRp(XQueryParser.TwoRpContext ctx) { //???
        ArrayList<Node> res1 = new ArrayList<>();
        ArrayList<Node> res2 = new ArrayList<>();
        ArrayList<Node> preCtx = new ArrayList<>(curNodes);
        res1.addAll(visit(ctx.rp(0)));
        curNodes = preCtx;
        res2.addAll(visit(ctx.rp(1)));
        res1.addAll(res2);
        curNodes = res1;
        return res1;
    }
    

//    @Override
//    public ArrayList<Node> visitRpFltrter(XQueryParser.RpFltrterContext ctx) { //???
//        ArrayList<Node> res = visit(ctx.rp());
//        ArrayList<Node> Fltrter= visit(ctx.Fltrter());
//        if (hasAttribute) {
//            curNodes = Fltrter;
//            hasAttribute = false;
//            return Fltrter;
//        } else if (Fltrter.isEmpty()) {
//            return new ArrayList<>();
//        }
//        else return res;
//    }

    public ArrayList<Node> visitRpwithP(XQueryParser.RpwithPContext ctx) {
        return visit(ctx.rp());
    }

    @Override
    public ArrayList<Node> visitFltrRp(XQueryParser.FltrRpContext ctx) {
        ArrayList<Node> tempList = curNodes;
        ArrayList<Node> res = visit(ctx.rp());
        curNodes = tempList;
        return res;
    }
    
    @Override
    public ArrayList<Node> visitFltrEqual(XQueryParser.FltrEqualContext ctx) {
        ArrayList<Node> tempList = curNodes;
        ArrayList<Node> left = visit(ctx.rp(0));
        curNodes = tempList;
        ArrayList<Node> right = visit(ctx.rp(1));
        curNodes = tempList;
        for (Node i : left) {
            for (Node j : right) {
                if (!i.isEqualNode(j)) continue;
                 return tempList;
            }
        }
        return new ArrayList<>();
    }
    
    @Override
    public ArrayList<Node> visitFltrIs(XQueryParser.FltrIsContext ctx) {
        ArrayList<Node> tempList = curNodes;
        ArrayList<Node> left = visit(ctx.rp(0));
        curNodes = tempList;
        ArrayList<Node> right = visit(ctx.rp(1));
        curNodes = tempList;
        for (Node i : left) {
            for (Node j : right) {
                if (i != j) continue;
                return tempList;
            }
        }
        return new ArrayList<>();
    }
    
    @Override
    public ArrayList<Node> visitFltrwithP(XQueryParser.FltrwithPContext ctx) {
        return visit(ctx.fltr());
    }
    
    @Override
    public ArrayList<Node> visitFltrAnd(XQueryParser.FltrAndContext ctx) {
        ArrayList<Node> left = visit(ctx.fltr(0));
        ArrayList<Node> right = visit(ctx.fltr(1));
        if (!left.isEmpty() && !right.isEmpty()) {
            return curNodes;
        }
        return new ArrayList<>();
    }
    
    @Override public ArrayList<Node> visitFltrOr(XQueryParser.FltrOrContext ctx) {
        ArrayList<Node> left = visit(ctx.fltr(0));
        ArrayList<Node> right = visit(ctx.fltr(1));
        if (!left.isEmpty() || !right.isEmpty()) {
            return curNodes;
        }
        else return new ArrayList<>();
    }

    @Override
    public ArrayList<Node> visitFltrNot(XQueryParser.FltrNotContext ctx) {
        ArrayList<Node> res = visit(ctx.fltr());
        if (!res.isEmpty()) {
            return curNodes;
        }
        return new ArrayList<>();
    }
}
