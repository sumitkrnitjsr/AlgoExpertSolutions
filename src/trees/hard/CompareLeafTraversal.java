package trees.hard;
import java.util.*;

public class CompareLeafTraversal {
	
	 static class BinaryTree {
		    public int value;
		    public BinaryTree left = null;
		    public BinaryTree right = null;

		    public BinaryTree(int value) {
		      this.value = value;
		    }
		  }

		  public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
		    // Write your code here.
				List<BinaryTree> leafNodes1 = new ArrayList<>();
				List<BinaryTree> leafNodes2 = new ArrayList<>();
				traverse(tree1, leafNodes1);
				traverse(tree2, leafNodes2);
				if(leafNodes1.size() != leafNodes2.size()) return false;
				int idx = 0;
				while(idx < leafNodes1.size()) {
						if(!equal(leafNodes1.get(idx), leafNodes2.get(idx))) return false;
						idx++;
				}
		    return true;
		  }
			
			private boolean equal(BinaryTree node1, BinaryTree node2) {
					return node1.value == node2.value;
			}
			
			private void traverse(BinaryTree node, List<BinaryTree> nodeList) {
					if(node == null) return;
					traverse(node.left, nodeList);
					if(node.left == null && node.right == null) {
							nodeList.add(node);
					}
					traverse(node.right, nodeList);
			}
			
			
			public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
				Stack<BinaryTree> tree1Stack = new Stack<>();
				tree1Stack.push(tree1);
				Stack<BinaryTree> tree2Stack = new Stack<>();
				tree2Stack.push(tree2);
				
				while(tree1Stack.size() > 0  && tree2Stack.size() > 0) {
						BinaryTree tree1Leaf = getNextLeafNode();
						BinaryTree tree2Leaf = getNextLeafNode(tree2Stack);
						
						if(tree1Leaf.value != tree2Leaf.value) return false;
				}
				
				return tree1Stack.size() == 0 && tree2Stack.size() == 0;
				
			}
			
			public BinaryTree getNextLeafNode(Stack<BinaryTree> traversalStack) {
					BinaryTree currentNode = traversalStack.pop();
					while(!isLeafNode(currentNode)) {
							if(currentNode.left != null) {
								traversalStack.push(currentNode.left);
							}
						
							if(currentNode.right != null) {
								traversalStack.push(currentNode.right);
							}
							
							currentNode = traversalStack.pop();
							
					}
					
					return currentNode;
			}
			
			public boolean isLeafNode(BinaryTree node) {
				return node.left == null && node.right == null;
			}

}
