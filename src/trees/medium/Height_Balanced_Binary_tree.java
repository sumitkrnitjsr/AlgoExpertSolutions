package trees.medium;

public class Height_Balanced_Binary_tree {
	
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
			public int treeHeight;
			public boolean isBalanced;
		}

	  public boolean heightBalancedBinaryTree(BinaryTree tree) {
	    // Write your code here.
	    return heightBalancedBinaryTreeHelper(tree).isBalanced;
	  }
		
		private Result heightBalancedBinaryTreeHelper(BinaryTree tree) {
						Result result = new Result();
						if(tree.left == null && tree.right == null) {
								result.treeHeight = 1;	
								result.isBalanced = true;
								return result;
						}
						
						Result leftResult = new Result();
						Result rightResult = new Result();
						leftResult.isBalanced = rightResult.isBalanced = true;
						
						if(tree.left != null)
						leftResult = heightBalancedBinaryTreeHelper(tree.left);
						
						if(tree.right != null)
						rightResult = heightBalancedBinaryTreeHelper(tree.right);
						
						result.treeHeight = Math.max(leftResult.treeHeight, rightResult.treeHeight);
						result.treeHeight++;
						result.isBalanced = leftResult.isBalanced && rightResult.isBalanced && (Math.abs(leftResult.treeHeight - rightResult.treeHeight) < 2); // forgot to check difference between left and right subtree
			
						return result;					
	}
		
	static class TreeInfo {
		public boolean isBalanced;
		public int height;
		
		public TreeInfo(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
		
	}
	public boolean heightBalancedBinaryTree2(BinaryTree tree) {
		TreeInfo treeInfo = getTreeInfo(tree);
		return treeInfo.isBalanced;
	}
	
	public TreeInfo getTreeInfo(BinaryTree node) {
		if(node == null) {
			return new TreeInfo(true, -1);
		}
		
		TreeInfo leftSubTreeInfo = getTreeInfo(node.left);
		TreeInfo rightSubTreeInfo = getTreeInfo(node.right);
		boolean isBalanced = leftSubTreeInfo.isBalanced && rightSubTreeInfo.isBalanced 
								&& Math.abs(leftSubTreeInfo.height - rightSubTreeInfo.height) <= 1;
		
		int height = Math.max(leftSubTreeInfo.height, rightSubTreeInfo.height) + 1;
		return new TreeInfo(isBalanced, height);
		
	}

}
