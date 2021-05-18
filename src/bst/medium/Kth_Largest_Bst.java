package bst.medium;
import java.util.*;

public class Kth_Largest_Bst {
	
	 // This is an input class. Do not edit.
	  static class BST {
	    public int value;
	    public BST left = null;
	    public BST right = null;

	    public BST(int value) {
	      this.value = value;
	    }
	  }

	  public int findKthLargestValueInBst(BST tree, int k) {
	    // Write your code here
			return findKthLargestValueInBst(tree,k,0).value;
	  }
		
		private Info findKthLargestValueInBst(BST tree, int k, int currentIdx) {
					Info info = new Info();
					if(tree == null) {
							info.idx = currentIdx;
							info.value = -1;
							return info;
					}
				
					Info rightInfo = findKthLargestValueInBst(tree.right, k, currentIdx);
					if(rightInfo.idx == k) return rightInfo;
					currentIdx = rightInfo.idx + 1;
					if(currentIdx == k) {
							info.idx = k;
							info.value = tree.value;
							return info;
					}
			
					return findKthLargestValueInBst(tree.left, k,currentIdx);
		}
		
		static class Info {
				int idx;
				int value;
		}
		
		private int findKthLargestValue(BST tree,int k) {
			ArrayList<Integer> sortedNodeValues = new ArrayList<>();
			inOrderTraverse(tree, sortedNodeValues);
			return sortedNodeValues.get(sortedNodeValues.size() - k);
			
		}
		
		private void inOrderTraverse(BST node, ArrayList<Integer> sortedNodeValues) {
			if(node == null) return;
			
			inOrderTraverse(node.left, sortedNodeValues);
			sortedNodeValues.add(node.value);
			inOrderTraverse(node.right, sortedNodeValues);
		}
		
		static class TreeInfo {
			public int numberOfNodesVisited;
			public int latestVisitedNodeValue;
			
			public TreeInfo(int numberOfNodesVisited, int latestVisitedNodeValue) {
				this.numberOfNodesVisited = numberOfNodesVisited;
				this.latestVisitedNodeValue = latestVisitedNodeValue;
			}
		}
		
		private int findKthLargestValueBest(BST tree,int k) {
			TreeInfo treeInfo = new TreeInfo(0, -1);
			reverseInOrderTraverse(tree, k, treeInfo);
			return treeInfo.latestVisitedNodeValue;
		}
		
		public void reverseInOrderTraverse(BST node, int k, TreeInfo treeInfo) {
			if(node == null || treeInfo.numberOfNodesVisited >= k) return;
			reverseInOrderTraverse(node.right, k, treeInfo);
			
			if(treeInfo.numberOfNodesVisited < k) {
				treeInfo.numberOfNodesVisited += 1;
				treeInfo.latestVisitedNodeValue = node.value;
				reverseInOrderTraverse(node.left, k, treeInfo);
			}
			
		}

}
