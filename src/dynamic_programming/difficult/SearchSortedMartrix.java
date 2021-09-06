package dynamic_programming.difficult;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/



public class SearchSortedMartrix {
	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        int topRow = 0;
	        int bottomRow = matrix.length - 1;
	        int topCol = 0;
	        int rightCol = matrix[0].length - 1;
	        
	        while(topRow <= bottomRow && topCol <= rightCol) {
	                int midRow = (topRow + bottomRow) / 2;
	                int midCol = (topCol + rightCol) / 2;
	                if(matrix[midRow][midCol] == target) return true;
	                if(target > matrix[midRow][rightCol]){
	                    topRow = midRow + 1;
	                } else if(target < matrix[midRow][topCol]){
	                    bottomRow = midRow - 1;
	                }else {
	                    topRow = bottomRow = midRow;
	                }
	                if(topRow == bottomRow) {
	                    if(target < matrix[topRow][midCol]) {
	                            rightCol = midCol - 1;
	                    }else if(target > matrix[topRow][midCol]){
	                            topCol = midCol + 1;
	                    }
	                }
	                
	        }
	            
	        return false;
	    }
	 
	 class Solution {
		 	// Consider 2-D matrix as stretched 1-D matrix
		    public boolean searchMatrix(int[][] matrix, int target) {
		        int m = matrix.length;
		        if (m == 0)
		            return false;
		        int n = matrix[0].length;

		        // binary search
		        int left = 0, right = m * n - 1;
		        int pivotIdx, pivotElement;
		        while (left <= right) {
		            pivotIdx = (left + right) / 2;
		            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
		            if (target == pivotElement)
		                return true;
		            else {
		                if (target < pivotElement)
		                    right = pivotIdx - 1;
		                else
		                    left = pivotIdx + 1;
		            }
		        }
		        return false;
		    }
		}

}
