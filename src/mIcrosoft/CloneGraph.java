package mIcrosoft;
import java.util.*;

public class CloneGraph {
	
	 public Node cloneGraph(Node node) {
	        HashMap<Integer, Node> visitedNodes = new HashMap<>();
	        
	        return cloneGraph(node, visitedNodes);
	    }
	    
	    private Node cloneGraph(Node node, HashMap<Integer, Node> visited) {
	            if(node == null) return null;
	            int val = node.val;
	            if(visited.containsKey(val)) return null;
	            Node currentNode = new Node(val);
	            ArrayList<Node> currentNeighbours = new ArrayList<Node>();
	            visited.put(val, currentNode);
	            List<Node> neighbours = node.neighbors;
	            for(Node neighbour: neighbours) {
	                if(visited.containsKey(neighbour.val)) {
	                    currentNeighbours.add(visited.get(neighbour.val));
	                }else {
	                    currentNeighbours.add(cloneGraph(neighbour, visited));
	                }
	            }
	            // Forgot to update neighbours 
	            currentNode.neighbors = currentNeighbours;
	            return currentNode;
	    }
	    
	    
	    /*
	 // Definition for a Node.
	 class Node {
	     public int val;
	     public List<Node> neighbors;

	     public Node() {}

	     public Node(int _val,List<Node> _neighbors) {
	         val = _val;
	         neighbors = _neighbors;
	     }
	 };
	 */
	 class Solution {
	     private HashMap <Node, Node> visited = new HashMap <> ();
	     public Node cloneGraph(Node node) {
	         if (node == null) {
	             return node;
	         }

	         // If the node was already visited before.
	         // Return the clone from the visited dictionary.
	         if (visited.containsKey(node)) {
	             return visited.get(node);
	         }

	         // Create a clone for the given node.
	         // Note that we don't have cloned neighbors as of now, hence [].
	         Node cloneNode = new Node(node.val, new ArrayList());
	         // The key is original node and value being the clone node.
	         visited.put(node, cloneNode);

	         // Iterate through the neighbors to generate their clones
	         // and prepare a list of cloned neighbors to be added to the cloned node.
	         for (Node neighbor: node.neighbors) {
	             cloneNode.neighbors.add(cloneGraph(neighbor));
	         }
	         return cloneNode;
	     }
	 }

}
