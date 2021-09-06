package mIcrosoft.random;
import java.util.*;

public class MaxDepthBinaryTree {
	
	 public int maxDepth(TreeNode root) {
	        return maxDepth(root , 0);
	    }
	    
	    private int maxDepth(TreeNode root, int currentDepth) {
	            if(root == null) return currentDepth;
	        
	        return Math.max(maxDepth(root.left, currentDepth + 1),
	                       maxDepth(root.right, currentDepth + 1));
	    }
	    
	    
	    public int maxDepth(TreeNode root) {
	        if(root == null) return 0;
	        Stack<Node> stack = new Stack<>();
	        stack.push(new Node(root, 1));
	        int maxDepth = 1;
	        while(!stack.isEmpty()) {
	            Node node = stack.pop();
	            maxDepth = Math.max(maxDepth, node.depth);
	            if(node.node.left != null)
	                stack.push(new Node(node.node.left, node.depth + 1));
	            if(node.node.right != null)
	                stack.push(new Node(node.node.right, node.depth + 1));
	        }
	        
	        return maxDepth;
	    }

}
