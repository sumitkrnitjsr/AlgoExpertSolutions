package trees.medium;

public class BInary_Tree_Diameter {
	
	 // This is an input class. Do not edit.
	  static class BinaryTree {
	    public int value;
	    public BinaryTree left = null;
	    public BinaryTree right = null;

	    public BinaryTree(int value) {
	      this.value = value;
	    }
	  }
		
		static class Result { 
			public int maxDepth;
			public int maxDiameter;
		}

	  public int binaryTreeDiameter(BinaryTree tree) {
	    // Write your code here.
			if(tree == null){
				return 0;
			}
	    return binaryTreeDiameterHelper(tree).maxDiameter;
	  }
		
		private Result binaryTreeDiameterHelper(BinaryTree tree){
				Result result = new Result();
				if(tree.left == null && tree.right == null){
					result.maxDepth = 0;
					result.maxDiameter = 0;
					return result;
				}
			
				int leftDiameter = 0;
				int rightDiameter = 0;
				int maxLeftHeight = 0;
				int maxRightHeight = 0;
				
				if(tree.left != null) {
					Result leftResult = binaryTreeDiameterHelper(tree.left);
					leftDiameter = leftResult.maxDiameter;
					maxLeftHeight = leftResult.maxDepth;
					maxLeftHeight++;
				}
				
				if(tree.right != null) {
					Result rightResult = binaryTreeDiameterHelper(tree.right);
					rightDiameter = rightResult.maxDiameter;
					maxRightHeight = rightResult.maxDepth;
					maxRightHeight++;
				}
			
				result.maxDepth = Math.max(maxLeftHeight, maxRightHeight);
				result.maxDiameter = Math.max(maxLeftHeight + maxRightHeight, Math.max(leftDiameter, rightDiameter));	// forgot to put maxLeftHeight + maxRightHeight	
				
				return result;
		}
		

}
