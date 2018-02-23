import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.Queue;

public class State {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private ArrayList<Node> children = new ArrayList<Node>();
    private Document root;
    State(ArrayList<Node> nodes) {
    		this.nodes = nodes;
    }
    public static void printall(ArrayList<Node> list){
        if (list.size() == 0) System.out.println("empty contex");
        else for (int i = 0; i < list.size(); i++){
            System.out.println("Name: " + list.get(i).getNodeName() + "Text: " + list.get(i).getTextContent());
        }
    }


    public void add(ArrayList<Node> nodelist) {
    		nodes.addAll(nodelist);
    }
    
    public ArrayList<Node> getNodes() {
    		return nodes;
    }

    public ArrayList<Node> getChildren(){
        ArrayList<Node> res = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++){
            NodeList tmp = nodes.get(i).getChildNodes();
            for (int j = 0; j < tmp.getLength(); j++) {
                res.add(tmp.item(j));
            }
        }
        return res;
    }
    
    public ArrayList<Node> getParents(){
    		ArrayList<Node> res = new ArrayList<>();
        for(Node temp : nodes) {
            if(res.contains(temp.getParentNode())) continue; 
                res.add(temp.getParentNode());
        }
        return res;
    }

    public ArrayList<Node> getAllChildren(){
    		ArrayList<Node> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList();
        res.addAll(nodes);
        queue.addAll(nodes);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            res.addAll(children(temp));
            queue.addAll(children(temp));
        }
        return res;
    }
    
    static ArrayList<Node> children(Node n) {
//      System.out.println("children");
        ArrayList<Node> childrenList = new ArrayList<Node>();
        for(int i = 0; i < n.getChildNodes().getLength(); i++){
            childrenList.add((Node)n.getChildNodes().item(i));
        }
        return childrenList;
    }
}