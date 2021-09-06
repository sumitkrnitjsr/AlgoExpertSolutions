package trees.hard;

public class FlattenBinaryTree {
	
	 public static BinaryTree flattenBinaryTree(BinaryTree root) {
		    // Write your code here.
		    return flatten(root)[0];
		  }
			
			private static BinaryTree[] flatten(BinaryTree root) {
					BinaryTree[] endNodes = new BinaryTree[2]	;
					endNodes[0] = null;
					endNodes[1] = null;
					if(root == null) return null;
					if(root.left == null && root.right == null){
							endNodes[0] = root;
							endNodes[1] = root;
							return endNodes;
					}
				
					BinaryTree[] leftEnds = flatten(root.left);
					BinaryTree[] rightEnds = flatten(root.right);
					BinaryTree leftNode, rightNode;
				
					if(leftEnds != null){
							leftEnds[1].right = root;
							root.left = leftEnds[1];
							leftNode = leftEnds[0];
					}else {
							root.left = null;
							leftNode = root;
					}
				
					if(rightEnds != null){
							rightEnds[0].left = root;
							root.right = rightEnds[0];
							rightNode = rightEnds[1];
					}else {
							root.right = null;
							rightNode = root;
					}
				
					return new BinaryTree[] {leftNode, rightNode};
					
			}

		  // This is the class of the input root. Do not edit it.
		  static class BinaryTree {
		    int value;
		    BinaryTree left = null;
		    BinaryTree right = null;

		    public BinaryTree(int value) {
		      this.value = value;
		    }
		  }

}
