package mIcrosoft.random;

public class NegativeNumbersSortedMatrix {
	
// Think of two directions each with different conditions, if movement in both directions lead to similar behavior, then we are cofused	
	 public int countNegatives(int[][] grid) {
	        int row = grid.length - 1;
	        int col = grid[0].length - 1;
	        int c = col;
	        col = 0;
	        int count = 0;
	        while(row >= 0 && c >= col) {
	                if(grid[row][col] < 0) {
	                    count += (c - col + 1);
	                    row--;
	                }else {
	                    col++;
	                }
	        }
	        
	        return count;
	  }

}
