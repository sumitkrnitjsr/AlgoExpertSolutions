package bst.medium;

public class ValidateBST {
	
	 public static boolean validateBst(BST tree) {
		    // Write your code here.
				if(tree == null) return true;
		    return validateBstHelper(tree).isValidBST;
		  }
			
			private static Result validateBstHelper(BST tree) {
					Result result = new Result();
					if((tree.left == null && tree.right == null)) {
							result.isValidBST = true;
							result.min = tree.value;
							result.max = tree.value;
							return result;
					}
				
					Result leftSubTree = new Result();
					if(tree.left != null) {
							leftSubTree = validateBstHelper(tree.left);
					}
					Result rightSubTree = new Result();
					if(tree.right != null) {
							rightSubTree = validateBstHelper(tree.right);
					}
				
					result.isValidBST = (leftSubTree.isValidBST && rightSubTree.isValidBST
															&& (tree.value > leftSubTree.max 
																	&& tree.value <= rightSubTree.min));
				
					result.min = Math.min(tree.value, Math.min(leftSubTree.min, rightSubTree.min));
					result.max = Math.max(tree.value, Math.max(leftSubTree.max, rightSubTree.max));
				
					return result;
			}

		  static class BST {
		    public int value;
		    public BST left;
		    public BST right;

		    public BST(int value) {
		      this.value = value;
		    }
		  }
			
			static class Result { 
				boolean isValidBST;
				int max;
				int min;
				public Result() {
						isValidBST = true;
						max = Integer.MIN_VALUE;
						min = Integer.MAX_VALUE;
				}
		}
			
			public static boolean validateBSTBest(BST tree) {
				return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
			}
			
			private static boolean validateBst(BST tree, int minValue, int maxValue) {
				if(tree.value < minValue || tree.value >= maxValue) {
					return false;
				}
				
				if(tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
					return false;
				}
				
				if(tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
					return false;
				}
				
				return true;
			}

}
