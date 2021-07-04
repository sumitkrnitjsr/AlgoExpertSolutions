package bst.difficult;

public class Validate_Three_Nodes {

	 static class BST {
		    public int value;
		    public BST left = null;
		    public BST right = null;

		    public BST(int value) {
		      this.value = value;
		    }
		  }

		  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
		    // Write your code here.
				if(nodeTwo == nodeOne || nodeTwo == nodeThree) return false;
				
				BST childNode = findChildNode(nodeOne, nodeThree, nodeTwo);
				if(childNode == null) return false;
				
				BST parentNode = (childNode == nodeOne)?nodeThree:nodeOne;
				
		    return isParent(parentNode, nodeTwo);
		  }
			
			private static BST findChildNode(BST nodeOne, BST nodeTwo, BST midNode) {
					
						if(midNode == null) return null;
				
						if(midNode == nodeOne) return nodeOne;
				
						if(midNode == nodeTwo) return nodeTwo;
						BST lChild = findChildNode(nodeOne, nodeTwo, midNode.left);
						
						if(lChild == null) return findChildNode(nodeOne, nodeTwo, midNode.right);
				
						return lChild;
						
				
			}
			
			private static boolean isParent(BST parentNode, BST childNode) {
					if(parentNode == null) return false;
					if(parentNode == childNode) return true;
					return isParent(parentNode.left, childNode) || isParent(parentNode.right, childNode);
			}
			
			private boolean isDescendant(BST node, BST target) {
				if(node == null) return false;
				if(node == target) return true;
				
				return (target.value < node.value)?isDescendant(node.left, target):isDescendant(node.right, target);
			}
			
			private boolean isDescendantBest(BST node, BST target) {
				while(node != null && node != target) {
					node = (target.value < node.value)?node.left:node.right;
				}
				
				return node == target;
			}
			
			
			private boolean validateThreeNodesBest(BST nodeOne, BST nodeTwo, BST nodeThree) {
				BST searchOne = nodeOne;
				BST searchTwo = nodeThree;
				
				while(true) {
					boolean foundThreeFromOne = searchOne == nodeThree;
					boolean foundOneFromThree = searchTwo == nodeOne;
					boolean foundNodeTwo = (searchOne == nodeTwo) || (searchTwo == nodeTwo);
					
					boolean finishedSearching = (searchOne == null) && (searchTwo == null);
					if(foundThreeFromOne || foundOneFromThree || foundNodeTwo || finishedSearching) {
						break;
					}
					
					if(searchOne != null) {
						searchOne = (searchOne.value > nodeTwo.value)?searchOne.left:searchOne.right;
					}
					
					if(searchTwo != null) {
						searchTwo = (searchTwo.value > nodeTwo.value)?searchTwo.left:searchTwo.right;
					}
					
				}
				
				boolean foundNodeFromOther = (searchOne == nodeThree) || (searchTwo == nodeOne);
				boolean foundNodeTwo = (searchOne == nodeTwo) || (searchTwo == nodeTwo);
				
				if(!foundNodeTwo || foundNodeFromOther) return false;
				
				return isDescendantBest(nodeTwo, (searchOne == nodeTwo) ? nodeThree : nodeOne);
				
				
			}
			
			
}
