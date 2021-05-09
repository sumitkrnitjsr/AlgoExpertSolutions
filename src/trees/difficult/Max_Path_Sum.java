package trees.difficult;
import java.util.*;

public class Max_Path_Sum {
	
	 public static int maxPathSum(BinaryTree tree) {
		    // Write your code here.
		   	return maxPathSumHelper(tree).maxSum;
		  }
			
			private static Result maxPathSumHelper(BinaryTree tree) {
					Result result = new Result();
					if(tree.left == null && tree.right == null) {
							result.maxSum = tree.value;
							result.sum = tree.value;
							return result;
					}
				
					Result leftResult = new Result();
					Result rightResult = new Result();
					if(tree.left != null) {
							leftResult = maxPathSumHelper(tree.left);
					}
				
					if(tree.right != null) {
							rightResult = maxPathSumHelper(tree.right);
					}
				
					int leftMax = Math.max(0, leftResult.sum);
					int rightMax = Math.max(0, rightResult.sum);
					int currentPath = tree.value + leftMax + rightMax;
					result.sum = Math.max(leftMax, rightMax) + tree.value;
					 // result.sum = tree.value + leftMax + rightMax; Only pick one
					result.maxSum = Math.max(Math.max(currentPath, result.sum), Math.max(leftResult.maxSum, rightResult.maxSum));
					return result;
			}
			

		  static class BinaryTree {
		    public int value;
		    public BinaryTree left;
		    public BinaryTree right;

		    public BinaryTree(int value) {
		      this.value = value;
		    }
		  }
			
			static class Result {
					int maxSum;
					int sum;
				public Result() {
						maxSum = Integer.MIN_VALUE;
						sum = Integer.MIN_VALUE;
				}
			}
	
			
			public static int maxPathSum2(BinaryTree tree) {
				List<Integer> maxSumArray = findMaxSum(tree);
				return maxSumArray.get(1);
 			}
			
			private static List<Integer> findMaxSum(BinaryTree tree) {
				if(tree == null) {
					return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));
				}
				
				List<Integer> leftMaxSumArray = findMaxSum(tree.left);
				Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
				Integer leftMaxPathSum = leftMaxSumArray.get(1);
				
				List<Integer> rightMaxSumArray = findMaxSum(tree.left);
				Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
				Integer rightMaxPathSum = rightMaxSumArray.get(1);
				
				Integer maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
				Integer maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);
				
				Integer maxSumAsRootNode = Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch,
													maxSumAsBranch);
				int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
				
				return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
			}

}
