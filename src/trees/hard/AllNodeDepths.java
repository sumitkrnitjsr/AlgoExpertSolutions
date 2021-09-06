package trees.hard;

public class AllNodeDepths {
	
	 public static int allKindsOfNodeDepths(BinaryTree root) {
		    // Write your code here.
		    return sumDepths(root, 0);
		  }
			
			private static int sumDepths(BinaryTree root, int depth) {
					if(root == null) return 0;
					int sum = 0;
					sum += (depth * (depth + 1) / 2);
					sum += sumDepths(root.right, depth + 1);
					sum += sumDepths(root.left, depth + 1);
					return sum;
	}

}
