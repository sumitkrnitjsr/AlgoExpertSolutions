package trees.easy;
import java.util.*;

// O(h) | O(n) 
public class Node_Depths {
	
	public static int nodeDepths(BinaryTree root) {
		   return nodeDepths(root, 0);
	}

	private static int nodeDepths(BinaryTree root, int depth){
				
			if(root == null){
					return 0;
				}	
			
			if(root.left == null && root.right == null){
					return depth;
				}
			
				
			
				int lDepthSum =  nodeDepths(root.left, depth + 1);
				int rDepthSum =  nodeDepths(root.right, depth + 1);
			
				return lDepthSum + rDepthSum + depth;
	}
	
	public static int nodeDepthsIterative(BinaryTree root) {
		   int sumOfDepths = 0;
		   List<Level> stack = new ArrayList<Level>();
		   stack.add(new Level(root, 0));
		   while(stack.size() > 0) {
			   Level top = stack.remove(stack.size() - 1);
			   BinaryTree node= top.root;
			   int depth = top.depth;
			   if(node == null) continue;
			   sumOfDepths += depth;
			   stack.add(new Level(root.left, depth + 1));
			   stack.add(new Level(root.right, depth + 1));
		   }
		   
		   return sumOfDepths;
	}
	
	
		static class Level {
			BinaryTree root;
			int depth;
			public  Level(BinaryTree node,int depth) {
				this.root = node;
				this.depth = depth;
			}
		}

		  static class BinaryTree {
		    int value;
		    BinaryTree left;
		    BinaryTree right;

		    public BinaryTree(int value) {
		      this.value = value;
		      left = null;
		      right = null;
		    }
		  }

}
