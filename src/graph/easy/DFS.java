package graph.easy;
import java.util.*;

public class DFS {
	
	static class Node {
	    String name;
	    List<Node> children = new ArrayList<Node>();

	    public Node(String name) {
	      this.name = name;
	    }

	    public List<String> depthFirstSearch(List<String> array) {
	      // Write your code here.
				if(array == null){
					array = new ArrayList<String>();
				}
	      return depthFirstSearch(array, this);
	    }
			
			public List<String> depthFirstSearch(List<String> array, Node node) {
	      // Write your code here.
				if(node == null){
					return array;
				}
				array.add(node.name);
				for(int i = 0;i < node.children.size();i++){
						depthFirstSearch(array, node.children.get(i));
				}
				return array;
	    }
			
		public List<String> depthFirstSearchBest(List<String> array) {
			array.add(this.name);
			for(int i = 0;i < children.size();i++) {
				children.get(i).depthFirstSearch(array);
			}
			return array;
		}
			

	    public Node addChild(String name) {
	      Node child = new Node(name);
	      children.add(child);
	      return this;
	    }
	  }

}
