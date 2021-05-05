package trees.medium;
import java.util.*;

public class Find_Successor {
	
	 static class BinaryTree {
		    public int value;
		    public BinaryTree left = null;
		    public BinaryTree right = null;
		    public BinaryTree parent = null;

		    public BinaryTree(int value) {
		      this.value = value;
		    }
		  }

		  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		    // Write your code here.
		    Stack<BinaryTree> stack = new Stack<>();
				BinaryTree currentNode = tree;
				boolean isNext = false;
				
				while(currentNode != null || !stack.isEmpty()){
							
							while(currentNode != null) {
								stack.push(currentNode);
								currentNode = currentNode.left;
							}
					
							currentNode = stack.pop();
							
							if(isNext) {
									return currentNode;
							}
					
							if(currentNode == node) {
									isNext = true;
							}
					
							currentNode = currentNode.right;
				}
				
				return null;
		  }
		  
		  
		  public BinaryTree findSuccessorBest(BinaryTree tree, BinaryTree node) {
			    // Write your code here.
					if(node.right != null){
												// return node.right; Wrong Judgement Need to go deeper in tree
						BinaryTree successorNode = node.right;
						while(successorNode.left != null) {
									successorNode = successorNode.left;
						}
						
						return successorNode;
					}
					
					BinaryTree leftParent = node;
					while(leftParent != tree){
								BinaryTree parentNode = leftParent.parent;
								if(parentNode.left == leftParent){
										return parentNode;
								}
								leftParent = parentNode;
					}
					
			    return null;
		}
		  
		public BinaryTree findSuccessorBest2(BinaryTree tree, BinaryTree node) {
				if(node.right == null) return getLeftmostChild(node.right);
				return getRightmostParent(node);
		}
		
		private BinaryTree getLeftmostChild(BinaryTree node) {
				BinaryTree currentNode = node;
				while(currentNode.left != null) {
					currentNode = currentNode.left;
				}
				
				return currentNode;
		}
		
		private BinaryTree getRightmostParent(BinaryTree node) {
				BinaryTree currentNode = node;
				while(currentNode.parent != null && currentNode.parent.right == currentNode) {
					currentNode = currentNode.parent;
				}
				
				return currentNode.parent;
		}
		
		public BinaryTree findSuccessor3(BinaryTree tree, BinaryTree node) {
			ArrayList<BinaryTree> inOrderTraversalOrder = new ArrayList<BinaryTree>();
			getInOrderTraversalOrder(tree, inOrderTraversalOrder);
			
			for(int i = 0;i < inOrderTraversalOrder.size();i++) {
				BinaryTree currentNode = inOrderTraversalOrder.get(i);
				if(currentNode != node) {
					continue;
				}
				if(i == inOrderTraversalOrder.size() - 1) {
					return null;
				}
				return inOrderTraversalOrder.get(i + 1);
			}
				return null;
		}
		
		void getInOrderTraversalOrder(BinaryTree node, ArrayList<BinaryTree> order) {
				if(node == null) {
					return;
				}
				
				getInOrderTraversalOrder(node.left, order);
				order.add(node);
				getInOrderTraversalOrder(node.right, order);
		}
			

}
