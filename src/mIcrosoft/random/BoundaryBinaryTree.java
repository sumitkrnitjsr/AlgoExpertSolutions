package mIcrosoft.random;

public class BoundaryBinaryTree {
	
	  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	        List<Integer> boundaryList = new ArrayList<>();
	        if(root == null) return boundaryList;
	        
	        // Forgot to handle single node case
	        if(root.left == null && root.right == null) {
	            boundaryList.add(root.val);
	            return boundaryList;
	        }
	        
	        
	        boundaryList.add(root.val);
	        getLeftBoundary(root.left, boundaryList);
	        getLeafBoundary(root, boundaryList);
	        List<Integer> rightBoundary = new ArrayList<>();
	        getRightBoundary(root.right, rightBoundary);
	        Collections.reverse(rightBoundary);
	        boundaryList.addAll(rightBoundary);
	        return boundaryList;
	    }
	    
	    private void getLeftBoundary(TreeNode root, List<Integer> boundaryList) {
	        if(root == null || (root.left == null && root.right == null)) return ;
	        boundaryList.add(root.val);
	        // Forgot to handle missing child cases
	        if(root.left != null)
	            getLeftBoundary(root.left, boundaryList);
	        else
	            getLeftBoundary(root.right, boundaryList);
	    }
	    
	    private void getLeafBoundary(TreeNode root, List<Integer> boundaryList) {
	        if(root == null) return ;
	        if(root.right == null && root.left == null) {
	            boundaryList.add(root.val);
	            return;
	        }
	        getLeafBoundary(root.left, boundaryList);
	        getLeafBoundary(root.right, boundaryList);
	    }
	    
	    private void getRightBoundary(TreeNode root, List<Integer> boundaryList) {
	        if(root == null || (root.left == null && root.right == null)) return ;
	        boundaryList.add(root.val);
	        // Forgot to handle missing child cases
	        if(root.right != null)
	            getRightBoundary(root.right, boundaryList);
	        else
	            getRightBoundary(root.left, boundaryList);
	    }

}
