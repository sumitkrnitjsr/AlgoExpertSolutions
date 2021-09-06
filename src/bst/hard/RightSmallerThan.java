package bst.hard;
import java.util.*;

public class RightSmallerThan {
	
	 public static List<Integer> rightSmallerThan(List<Integer> array) {
		    // Write your code here.
		    List<Integer> rightSmallerCounts = new ArrayList<Integer>();
		    for(int i = 0;i < array.size();i++) {
		    	int rightSmallerCount = 0;
		    	for(int j = i + 1;j < array.size();i++) {
		    		if(array.get(i) > array.get(j)) {
		    			rightSmallerCount++;
		    		}
		    	}
		    	rightSmallerCounts.add(rightSmallerCount);
		    }
		    
		    return rightSmallerCounts;
	}
	 
	 
	 public static List<Integer> rightSmallerThanBest(List<Integer> array) {
		    // Write your code here.
				if(array.size() == 0)
		    return new ArrayList<Integer>();
				
				List<Integer> rightSmallerCounts = new ArrayList<>(array);
				int lastIdx = array.size() - 1;
				BST bst = new BST(array.get(lastIdx));
				rightSmallerCounts.set(lastIdx, 0);
				for(int i = lastIdx - 1; i >= 0;i--) {
						bst.insert(array.get(i), i, rightSmallerCounts);
				}
				
				return rightSmallerCounts;
		  }
			
			static class BST{
				int value;
				int leftTreeSize;
				BST left;
				BST right;
				
				public BST(int val) {
						value = val;
						leftTreeSize = 0;
				}
				
				public void insert(int val, int idx, List<Integer> rightSmallerCounts) {
						insert(val, idx, rightSmallerCounts,0);
				}
				
				public void insert(int val,int idx, List<Integer> rightSmallerCounts,int numSmallerAtInsertTime) {
						if(val < value) {
								leftTreeSize++;
								if(left == null) {
										left = new BST(val);
										rightSmallerCounts.set(idx, numSmallerAtInsertTime);
								}else {
										left.insert(val, idx, rightSmallerCounts, numSmallerAtInsertTime);
								}
						}else {
								numSmallerAtInsertTime += leftTreeSize;
								if(val > value) numSmallerAtInsertTime++;
								if(right == null) {
										right = new BST(val);
										rightSmallerCounts.set(idx, numSmallerAtInsertTime);
								}else {
										right.insert(val, idx, rightSmallerCounts, numSmallerAtInsertTime);
								}
						}
				}
			}

}
