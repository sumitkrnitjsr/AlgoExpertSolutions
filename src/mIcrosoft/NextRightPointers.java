package mIcrosoft;
import java.util.*;

public class NextRightPointers {
	
	public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        Queue<Node> levelOrderNodes = new LinkedList<>();
        levelOrderNodes.add(root);
        while(!levelOrderNodes.isEmpty()){
                int size = levelOrderNodes.size();
                Node prev = null;
                for(int i = 0;i < size;i++) {
                    Node front = levelOrderNodes.poll();
                    if(prev != null) {
                        prev.next = front;
                    }
                    prev = front;
                    if(prev.left != null)
                    levelOrderNodes.add(prev.left);
                    if(prev.right != null)
                    levelOrderNodes.add(prev.right);
                }
                prev.next = null;
        }
        
        return root;
    }

	
	class Solution {
	    public Node connectBest(Node root) {
	        
	        if (root == null) {
	            return root;
	        }
	        
	        // Start with the root node. There are no next pointers
	        // that need to be set up on the first level
	        Node leftmost = root;
	        
	        // Once we reach the final level, we are done
	        while (leftmost.left != null) {
	            
	            // Iterate the "linked list" starting from the head
	            // node and using the next pointers, establish the 
	            // corresponding links for the next level
	            Node head = leftmost;
	            
	            while (head != null) {
	                
	                // CONNECTION 1
	                head.left.next = head.right;
	                
	                // CONNECTION 2
	                if (head.next != null) {
	                    head.right.next = head.next.left;
	                }
	                
	                // Progress along the list (nodes on the current level)
	                head = head.next;
	            }
	            
	            // Move onto the next level
	            leftmost = leftmost.left;
	        }
	        
	        return root;
	    }
	}
}
