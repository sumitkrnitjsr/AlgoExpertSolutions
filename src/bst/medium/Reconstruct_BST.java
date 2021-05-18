package bst.medium;
import java.util.*;

public class Reconstruct_BST {
	
	 static class BST {
		    public int value;
		    public BST left = null;
		    public BST right = null;

		    public BST(int value) {
		      this.value = value;
		    }
		  }

		  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		    // Write your code here.
				
		    return reconstruct(preOrderTraversalValues, 0, 
															preOrderTraversalValues.size() - 1);
		  }
			
			private BST reconstruct(ArrayList<Integer> values, int startIdx,
														 		int endIdx) {
					if(startIdx > endIdx) {
							return null;
					}
					int nodeValue = values.get(startIdx);
					BST node = new BST(nodeValue);
					int leftSubTreeStartIdx = startIdx + 1;
					int leftSubTreeEndIdx = leftSubTreeStartIdx;
					while(leftSubTreeEndIdx <= endIdx && 
							 values.get(leftSubTreeEndIdx) < nodeValue) {
								leftSubTreeEndIdx++;
					}
					leftSubTreeEndIdx--;
				
					int rightSubTreeStartIdx = leftSubTreeEndIdx + 1;
					int rightSubTreeEndIdx = endIdx;
					
					node.left = reconstruct(values,leftSubTreeStartIdx, leftSubTreeEndIdx);
					node.right = reconstruct(values,rightSubTreeStartIdx, rightSubTreeEndIdx);
					return node;
			}
			
			static class TreeInfo {
				int rootIdx;
				
				public TreeInfo(int value) {
					rootIdx = value;
				}
			}
			
			public BST reconstructBst(List<Integer> preOrderTraversalValues) {
				TreeInfo treeInfo = new TreeInfo(0);
				return reconstructFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE,
						preOrderTraversalValues, treeInfo);
			}
			
			private static BST reconstructFromRange(int lowerBound,int upperBound,
									List<Integer> preOrderTraversalValues,TreeInfo currentSubTreeInfo) {
				
				if(currentSubTreeInfo.rootIdx == preOrderTraversalValues.size()) {
						return null;
				}
				
				int rootValue = preOrderTraversalValues.get(currentSubTreeInfo.rootIdx);
				if(rootValue < lowerBound || rootValue >= upperBound) {
					return null;
				}
				currentSubTreeInfo.rootIdx += 1;
				BST leftSubTree = 
						reconstructFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubTreeInfo);
				BST rightSubTree = 
						reconstructFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubTreeInfo);
				
				BST bst = new BST(rootValue);
				bst.left = leftSubTree;
				bst.right = rightSubTree;
				return bst;
				
			}
			
			

}
