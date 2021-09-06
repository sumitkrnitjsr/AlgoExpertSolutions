package mIcrosoft;

public class NumberOfIslands {
	
	 public int numIslands(char[][] grid) {
	        if(grid.length == 0) return 0;
	        
	        int count = 0;
	        for(int i = 0;i < grid.length;i++) {
	            for(int j = 0;j < grid[0].length;j++) {
	                    if(grid[i][j] == '1') {
	                        count++;
	                        markVisited(grid, i, j);
	                    }
	            }
	        }
	        
	        return count;
	    }
	    
	    public void markVisited(char[][] grid,int row,int col) {
	            if(row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) return;
	            if(grid[row][col] == '0')     return;
	            grid[row][col] = '0';
	            markVisited(grid, row - 1, col);
	            markVisited(grid, row + 1, col);
	            markVisited(grid, row, col - 1);
	            markVisited(grid, row, col + 1);
	    }

}
