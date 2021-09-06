package mIcrosoft;

public class NextRightPointers2 {
	
	 public Node connect(Node root) {
	        if(root == null || (root.left == null && root.right == null)) {
	            return root;
	        }
	        
	        Node leftmost = root;
	        
	        while(leftmost != null) {
	            
	            Node current = leftmost;
	            leftmost = null;
	            Node prev = null;
	            while(current != null) {
	                   while(current != null && current.left == null && current.right == null) {
	                        current = current.next;
	                   }
	                    // Forgot to handle null check
	                    if(current == null) break;
	                
	                   if(current.left != null) {
	                       leftmost = leftmost == null ? current.left  : leftmost;
	                       if(prev != null) prev.next = current.left;
	                       prev = current.left;
	                   }
	                   if(current.right != null) {
	                       leftmost = leftmost == null ? current.right  : leftmost;
	                       // forgot null check 
	                       if(prev != null)  prev.next = current.right;
	                       prev = current.right;
	                   }
	                    current = current.next;
	            }
	        }
	        return root;
	    }
	 
	 
	 

}
