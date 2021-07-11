package mIcrosoft;

public class Validate_BST {
	
	// Need Integer objects to cover cases where numbers are beyond Integer ranges
	// Be careful about Integer.MAX/MIN_VALUE for edge cases
	
	 public boolean isValidBST(TreeNode root) {
	        return isValidBST(root, null,null);
	    }
	    
	    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
	            if(root == null) return true;
	        
	            if( (min != null && root.val <= min) || (max != null && root.val >= max)) return false;
	        
	            return isValidBST(root.left, min, root.val)
	                    && isValidBST(root.right, root.val, max);
	    }

}
