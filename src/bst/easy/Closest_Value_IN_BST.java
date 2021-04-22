package bst.easy;

public class Closest_Value_IN_BST {
	
	 public static int findClosestValueInBst(BST tree, int target) {
		    
			if(tree == null){
				return Integer.MAX_VALUE;
			}
			
			int dif = tree.value - target;
			dif = Math.abs(dif);
			
	    if(dif == 0 || (tree.left == null && tree.right == null)){
				return tree.value;
			}
		
			int lchilddif = findClosestValueInBst(tree.left, target);
			int rchilddif = findClosestValueInBst(tree.right, target);
			
			int ldif = Integer.MAX_VALUE;
			int rdif = Integer.MAX_VALUE;
			
			if (lchilddif != Integer.MAX_VALUE){
				ldif = Math.abs(lchilddif - target);	
			}
			
			if (rchilddif != Integer.MAX_VALUE){
				rdif = Math.abs(rchilddif - target);	
			}
			
			if(dif < ldif && dif < rdif){
				return tree.value;
			}else if(ldif < rdif){
				return lchilddif;
			}
			return rchilddif;
	  }
	 
	 
	 public static int findClosestValueInBSTBest(BST node,int target) {
		 return findClosestValueInBST(node, target, node.value);
	 }
	 
	 private static int findClosestValueInBST(BST tree, int target, int closest) {
		 if(Math.abs(target - closest) > Math.abs(target - tree.value)) {
			 closest = tree.value;
		 }
		 
		 if(target < tree.value && tree.left != null) {
			 return findClosestValueInBST(tree.left, target, closest);
		 } else if(target > tree.value && tree.right != null) {
			 return findClosestValueInBST(tree.right, target, closest);
		 }
		 return closest;
	 }

	  static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	    }
	  }

}
