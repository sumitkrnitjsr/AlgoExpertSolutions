package mIcrosoft;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
	        // Edge case for infinite loop
	        if(root == null) return levelOrderTraversal;
	        nodeQueue.add(root);
	        nodeQueue.add(null);
	        
	        List<Integer> levelIntegers = new ArrayList<>();
	        while(!nodeQueue.isEmpty()) {
	                TreeNode frontNode = nodeQueue.poll();
	                if(frontNode == null) {
	                    //Edge case for infinite loop
	                    if(!nodeQueue.isEmpty())
	                    nodeQueue.add(null);
	                    levelOrderTraversal.add(levelIntegers);
	                    levelIntegers = new ArrayList<>();
	                    continue;
	                }
	                levelIntegers.add(frontNode.val);
	                if(frontNode.left != null)
	                nodeQueue.add(frontNode.left);
	                if(frontNode.right != null)
	                nodeQueue.add(frontNode.right);
	        }
	        
	        return levelOrderTraversal;
	    }
	 
	 
		 List<List<Integer>> levels = new ArrayList<List<Integer>>();

		    public void helper(TreeNode node, int level) {
		        // start the current level
		        if (levels.size() == level)
		            levels.add(new ArrayList<Integer>());

		         // fulfil the current level
		         levels.get(level).add(node.val);

		         // process child nodes for the next level
		         if (node.left != null)
		            helper(node.left, level + 1);
		         if (node.right != null)
		            helper(node.right, level + 1);
		    }
		    
		    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
		        if (root == null) return levels;
		        helper(root, 0);
		        return levels;
		    }
		    
		    
		    
		    class Solution {
		    	  public List<List<Integer>> levelOrderBEST(TreeNode root) {
		    	    List<List<Integer>> levels = new ArrayList<List<Integer>>();
		    	    if (root == null) return levels;

		    	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
		    	    queue.add(root);
		    	    int level = 0;
		    	    while ( !queue.isEmpty() ) {
		    	      // start the current level
		    	      levels.add(new ArrayList<Integer>());

		    	      // number of elements in the current level
		    	      int level_length = queue.size();
		    	      for(int i = 0; i < level_length; ++i) {
		    	        TreeNode node = queue.remove();

		    	        // fulfill the current level
		    	        levels.get(level).add(node.val);

		    	        // add child nodes of the current level
		    	        // in the queue for the next level
		    	        if (node.left != null) queue.add(node.left);
		    	        if (node.right != null) queue.add(node.right);
		    	      }
		    	      // go to next level
		    	      level++;
		    	    }
		    	    return levels;
		    	  }
		    	}

}
