package graph.medium;
import java.util.*;

public class Remove_Islands {
	
	 public int[][] removeIslands(int[][] matrix) {
		    // Write your code here.
				int h = matrix.length;
				int w = matrix[0].length;
				
				for(int i = 0;i < h;i++) {
					for(int j = 0;j < w;j++) {
							if(i == 0 || i == h - 1 || j == 0 || j == w - 1) {
									neutralizeBorderIslands(matrix, i, j,h , w);
							}
					}
				}
				
				for(int i = 0;i < h;i++) {
					for(int j = 0;j < w;j++) {
							matrix[i][j] = (matrix[i][j] == 2)?1:0;
					}
				}
				
		    return matrix;
		  }
			
			private void neutralizeBorderIslands(int[][] matrix,int i,int j,int h,
																						int w) {
						if( i < 0 || j < 0 || i == h || j == w || matrix[i][j] == 0
							|| matrix[i][j] == 2) return;
				
						matrix[i][j] = 2;
						neutralizeBorderIslands(matrix, i + 1, j, h, w);
						neutralizeBorderIslands(matrix, i - 1, j, h, w);
						neutralizeBorderIslands(matrix, i, j + 1, h, w);
						neutralizeBorderIslands(matrix, i, j - 1, h, w);
			}
			
			
			public int[][] removeIslands2(int[][] matrix) {
					boolean[][] connectedToBorder = new boolean[matrix.length][matrix[0].length];
					for(int i = 0;i < matrix.length;i++) {
						connectedToBorder[i][matrix[0].length - 1] = false;
					}
					
					for(int row = 0;row < matrix.length;row++) {
						for(int col = 0;col < matrix[0].length;col++) {
							boolean isBorder = row == 0 || col == 0 || row == matrix.length - 1 || col == matrix[0].length - 1;
							
							if(!isBorder || matrix[row][col] != 1) continue;
							
							findOnesConnectedToBorder(matrix, row, col, connectedToBorder);
						}
					}
					
					for(int row = 1;row < matrix.length;row++) {
						for(int col = 1;col < matrix[0].length;col++) {
							if(connectedToBorder[row][col]) continue;
								matrix[row][col] = 0;
						}
					}
					
					return matrix;
			}
			
			
			public void findOnesConnectedToBorder(int[][] matrix, int r,int c, boolean[][] connectedToBorder) {
				Stack<int[]> stack = new Stack<>();
				stack.push(new int[] {r,c});
				while(!stack.isEmpty()) {
					int[] currentPosition = stack.pop();
					int currRow = currentPosition[0];
					int currCol = currentPosition[1];
					
					boolean alreadyVisited = connectedToBorder[currRow][currCol];
					if(alreadyVisited) continue;
					
					connectedToBorder[currRow][currCol] = true;
					
					int[][] neighbours = getNeighbours(matrix, currRow, currCol);
					
					for(int[] neighbour: neighbours) {
						int row = neighbour[0];
						int col = neighbour[1];
						
						if(matrix[row][col] != 1) continue;
						
						stack.push(new int[] {row,col});
					}
				}
			}
			
			public int[][] getNeighbours(int[][] matrix,int r,int c) {
				int nRows = matrix.length;
				int nCols = matrix[0].length;
				ArrayList<int[]> temp = new ArrayList<>();
				
				if(r - 1 >= 0) temp.add(new int[] {r - 1, c});
				if(r + 1 < nRows) temp.add(new int[] {r + 1, c});
				if(c - 1 >= 0) temp.add(new int[] {r, c - 1});
				if(c + 1 < nCols) temp.add(new int[] {r, c + 1});
				
				
				int[][] neighbours = new int[temp.size()][2];
			
				for(int i = 0;i < temp.size();i++) {
						neighbours[i] = temp.get(i);
				}
				return neighbours;
			}

}
