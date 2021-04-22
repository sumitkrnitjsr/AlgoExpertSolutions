package trees.medium;
import java.util.*;

// // Recursion vs Iterative solutions differ in space complexity as O(log(N)) vs O(N) 

public class Invert_BinaryTree {
	
	public static void invertBinaryTree(BinaryTree tree) {
    	if(tree == null){
				return;
			}
		
		BinaryTree leftNode = tree.left;
		tree.left = tree.right;
		tree.right = leftNode;
		invertBinaryTree(tree.left);
		invertBinaryTree(tree.right);
  }

	
	public static void invertBinaryTreeIterative(BinaryTree tree) {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(tree);
		while(!queue.isEmpty()){
				BinaryTree frontNode = queue.poll();
				if(frontNode.left != null){
					queue.add(frontNode.left);
				}
				if(frontNode.right != null){
					queue.add(frontNode.right);
				}
				BinaryTree temp = frontNode.left;
				frontNode.left = frontNode.right;
				frontNode.right = temp;
		}
}
	
  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

}
