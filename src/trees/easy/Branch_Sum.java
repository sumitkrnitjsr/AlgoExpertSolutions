package trees.easy;
import java.util.*;


public class Branch_Sum {
	
	public static class BinaryTree {
	    int value;
	    BinaryTree left;
	    BinaryTree right;

	    BinaryTree(int value) {
	      this.value = value;
	      this.left = null;
	      this.right = null;
	    }
	  }

	  public static List<Integer> branchSums(BinaryTree root) {
	    	ArrayList<Integer> result = new ArrayList<>();
				if(root == null){
						return result;
					}
				
				if(root.left == null && root.right == null){
						result.add(root.value);
						return result;
				}
			
				List<Integer> left = branchSums(root.left);
				List<Integer> right = branchSums(root.right);
			
				for(Integer itr: left){
						result.add(new Integer(itr + root.value));
				}
			
				for(Integer itr: right){
						result.add(new Integer(itr + root.value));
				}
			
				return result;
	  }
	  
	  
	  public static List<Integer> branchSum(BinaryTree root){
		  	List<Integer> sums = new ArrayList<Integer>();
		  	calculateBranchSum(root, 0, sums);
		  	return sums;
	  }
	  
	  private static void calculateBranchSum(BinaryTree node, int runningSum, List<Integer> sums) {
		  if(node == null) return;
		  
		  int newRunningSum = runningSum + node.value;
		  
		  if(node.left == null && node.right == null) {
			  sums.add(newRunningSum);
			  return;
		  }
		  
		  calculateBranchSum(node.left, newRunningSum, sums);
		  calculateBranchSum(node.right, newRunningSum, sums);
		  
	  }

}
