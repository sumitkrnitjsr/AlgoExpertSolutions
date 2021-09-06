package trees.hard;

public class RIghtSiblingTree {
	
	public static BinaryTree rightSiblingTree(BinaryTree root) {
	    // Write your code here.
			if(root == null) return root;
			
			Queue<BinaryTree> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);
			BinaryTree currNode = null;
			BinaryTree prevNode = null;

			while(!queue.isEmpty()){
					int size = queue.size();
					for(int i = 0;i < size;i++) {
							currNode = queue.poll();
							if(currNode == null){
									if(prevNode != null) {
											prevNode.right = null;
									}
									prevNode = null;
									continue;
							}
							queue.add(currNode.left);
							queue.add(currNode.right);
							if(prevNode != null) {
								prevNode.right = currNode;
							}
							prevNode = currNode;	
					}
							if(prevNode != null) 
								prevNode.right = null;
				if(queue.isEmpty()) break;
						queue.add(null);
			}
			
	    return root;
	  }
	
	public static BinaryTree rightSiblingTree(BinaryTree root) {
	    // Write your code here.
		mutate(root, null, false);
	    return root;
	 }
	
	private static void mutate(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
		if(node == null) return;
		
		BinaryTree left = node.left;
		BinaryTree right = node.right;
		
		mutate(left, node, true);
		
		if(parent == null) {
			node.right = null;
		}else if(isLeftChild) {
			node.right = parent.right;
		}else {
			if(parent.right == null) {
				node.right = null;
			}else {
				node.right = parent.right.left;
			}
		}
		
		mutate(right, node, false);
	}

}
