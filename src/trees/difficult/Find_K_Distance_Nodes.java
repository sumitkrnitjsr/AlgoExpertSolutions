package trees.difficult;
import java.util.*;

public class Find_K_Distance_Nodes {
	
	// This is an input class. Do not edit.
	  static class BinaryTree {
	    public int value;
	    public BinaryTree left = null;
	    public BinaryTree right = null;

	    public BinaryTree(int value) {
	      this.value = value;
	    }
	  }

	  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
	    // Write your code here.
			ArrayList<Integer> list = new ArrayList<Integer>();
			findNodesDistanceK(tree, target, k, -1, list);
			return list;
	  }
		
		private static int findNodesDistanceK(BinaryTree node, int target, int k, int currentPos, List<Integer> list) {
			
				if(node == null) return -1;
				if(node.value == target) {
						findNodesDistanceK(node.left, target, k, 1, list);
						findNodesDistanceK(node.right, target, k, 1, list);
						return 1;
				}else if(k == currentPos){
						list.add(node.value);
						return -1;
				}else if(currentPos != -1){
						findNodesDistanceK(node.left, target, k, currentPos + 1, list);
						findNodesDistanceK(node.right, target, k,  currentPos + 1, list);
						return -1;
				}else{
						int left = findNodesDistanceK(node.left, target, k, currentPos, list);
						if(left != -1){
								if(left == k) {
										list.add(node.value);
										return -1;
								}else {
										findNodesDistanceK(node.right, target, k,  left + 1, list);				
										return left + 1;
								}
						} 
						int right = findNodesDistanceK(node.right, target, k, currentPos, list);
						if(right != -1){
								if(right == k) {
										list.add(node.value);
										return -1;
								}else {
										findNodesDistanceK(node.left, target, k,  right + 1, list);				
										return right + 1;
								}
						}
						return -1;
				}

		}
		
		 public ArrayList<Integer> findNodesDistanceK2(BinaryTree tree, int target, int k) {
			    // Write your code here.
					ArrayList<Integer> nodesDistanceK = new ArrayList<Integer>();
					findDistanceFromNodeToTarget(tree, target, k, nodesDistanceK);
					return nodesDistanceK;
		}
		 
		private static int findDistanceFromNodeToTarget(BinaryTree node, int target, int k, ArrayList<Integer> nodesDistanceK) {
			
			if(node == null) return -1;
			
			if(node.value == target) {
				addSubTreeNodeAtDistanceK(node, 0, k, nodesDistanceK);
				return 1;
			}
			
			int leftDistance = findDistanceFromNodeToTarget(node.left, target, k, nodesDistanceK);
			int rightDistance = findDistanceFromNodeToTarget(node.right, target, k, nodesDistanceK);
			
			if(leftDistance == k || rightDistance == k) nodesDistanceK.add(node.value);
			
			if(leftDistance != -1) {
					addSubTreeNodeAtDistanceK(node.right, leftDistance + 1, k, nodesDistanceK);
					return leftDistance + 1;
			}
			
			if(rightDistance != -1) {
					addSubTreeNodeAtDistanceK(node.left, rightDistance + 1, k, nodesDistanceK);
					return rightDistance + 1;
			}
			
			return -1;
			
		}
		
		private static void addSubTreeNodeAtDistanceK(BinaryTree node, int distance,int k,List<Integer> list) {
			
			if(node == null) return;
					
					if(distance == k) {
						list.add(node.value);
					}else {
						addSubTreeNodeAtDistanceK(node.left, distance + 1, k, list);
						addSubTreeNodeAtDistanceK(node.right, distance + 1, k, list);
					}
				
		}
		
		static class Pair<U, V>{
			public final U first;
			public final V second;
			
			private Pair(U first, V second) {
				this.first = first;
				this.second = second;
			}
		}
		
		public void findNodesDistanceK3(BinaryTree node, int target, int k) {
			
			HashMap<Integer, BinaryTree> nodesToParents = new HashMap<>();
			populateNodesToParents(node, nodesToParents, null);
			BinaryTree targetNode = getNodeFromValue(target, node, nodesToParents);
			breadthFirstSearch(targetNode, nodesToParents, k);
		}
		
		private void populateNodesToParents(BinaryTree node, HashMap<Integer, BinaryTree> map, BinaryTree parent) {
			
			if(node != null) {
					map.put(node.value, parent);
					populateNodesToParents(node.left, map, node );
					populateNodesToParents(node.right, map, node );
			}
		}
		
		BinaryTree getNodeFromValue(int target, BinaryTree tree, HashMap<Integer, BinaryTree> map) {
			if(tree.value == target) return tree;
			
			BinaryTree nodeParent = map.get(target);
			
			if(nodeParent.left != null && nodeParent.left.value == target) return nodeParent.left;
			
			return nodeParent.right;
			
		}
		
		public ArrayList<Integer> breadthFirstSearch(BinaryTree targetNode, HashMap<Integer, BinaryTree> nodesToParents,
							int k) {
			
			Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
			queue.offer(new Pair<BinaryTree, Integer>(targetNode, 0));
			
			HashSet<Integer> seen = new HashSet<>(targetNode.value);
			seen.add(targetNode.value);
			
			while(queue.size() > 0) {
				Pair<BinaryTree, Integer> vals = queue.poll();
				BinaryTree currentNode = vals.first;
				int distanceFromTarget = vals.second;
				
				if(distanceFromTarget == k) {
					ArrayList<Integer> nodeDistanceK = new ArrayList<>();
					for(Pair<BinaryTree, Integer> pair: queue) {
						nodeDistanceK.add(pair.first.value);
					}
						nodeDistanceK.add(currentNode.value);
						return nodeDistanceK;
				}
				
				List<BinaryTree> connectedNode = new ArrayList<>();
				connectedNode.add(currentNode.left);
				connectedNode.add(currentNode.right);
				connectedNode.add(nodesToParents.get(currentNode.value));
				
				for(BinaryTree node : connectedNode) {
					
					if(node == null) continue;
					
					if(seen.contains(node.value)) continue;
					
					seen.add(node.value);
					
					queue.add(new Pair<BinaryTree, Integer>(node, distanceFromTarget + 1));
				}
				
				
			}
			
			return new ArrayList<Integer>();
		}
		
		

}
