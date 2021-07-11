package mIcrosoft;
import java.util.*;


public class BinaryTreeInorderTraversal {
	
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> inOrderList = new ArrayList<>();
	        if(root == null) return inOrderList;
	        Stack<TreeNode> nodeStack = new Stack<>();
	        // We only push in recursion, so don't push before while loop
	        TreeNode currentNode = root;
	        while(currentNode != null || !nodeStack.isEmpty()) {
	                while(currentNode != null) {
	                        nodeStack.push(currentNode);
	                        currentNode = currentNode.left;
	                }
	                currentNode = nodeStack.pop();
	                inOrderList.add(currentNode.val);
	                currentNode = currentNode.right;
	        }
	        
	        return inOrderList;
	    }

}
