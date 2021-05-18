package bst.medium;
import java.util.*;


public class MinHeightBST {
	
	public static BST minHeightBst(List<Integer> array) {
	    // Write your code here.
	    BST root = minHeightBst(array, 0, array.size() - 1);
			return root;
	  }
		
		private static BST minHeightBst(List<Integer> array, int left,int right) {
				if(left > right) { // Wrong check case left < right
						return null;
				}
				int mid = (left + right) / 2;
				int value = array.get(mid);
				BST node = new BST(value);
				node.left = minHeightBst(array, left, mid - 1);
				node.right = minHeightBst(array, mid + 1, right);
				
				return node;
		}

	  static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	      left = null;
	      right = null;
	    }

	    public void insert(int value) {
	      if (value < this.value) {
	        if (left == null) {
	          left = new BST(value);
	        } else {
	          left.insert(value);
	        }
	      } else {
	        if (right == null) {
	          right = new BST(value);
	        } else {
	          right.insert(value);
	        }
	      }
	    }
	  }

}
