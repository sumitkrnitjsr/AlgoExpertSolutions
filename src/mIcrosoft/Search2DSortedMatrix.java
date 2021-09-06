package mIcrosoft;

public class Search2DSortedMatrix {
	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        
	        int col = matrix[0].length - 1;
	        int row = 0;
	        while(col >= 0 && row >= 0 && col < matrix[0].length && row < matrix.length) {
	                if(matrix[row][col] == target) return true;
	                if(matrix[row][col] > target) col--;
	                else row++;
	        }
	        
	        return false;
	    }
	 
	 class Solution {
		    public boolean searchMatrix(int[][] matrix, int target) {
		        // start our "pointer" in the bottom-left
		        int row = matrix.length-1;
		        int col = 0;

		        while (row >= 0 && col < matrix[0].length) {
		            if (matrix[row][col] > target) {
		                row--;
		            } else if (matrix[row][col] < target) {
		                col++;
		            } else { // found it
		                return true;
		            }
		        }

		        return false;
		    }
		}

}
