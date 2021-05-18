package search.medium;

public class Search_Sorted_Matrix {
	
	 public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		    // Write your code here.
			 	return searchInSortedMatrix(matrix, target, 0, 0);
		  }
			
			private static int[] searchInSortedMatrix(int[][] matrix,int target,int row, int col) {
					
				if(row >= matrix.length || col >= matrix[0].length) {
						return new int[]{-1, -1};
				}
				
				if(matrix[row][col] == target) {
						return new int[]{row, col};
				}
				
				int[] nextRow = {-1, -1};
				int[] nextCol = {-1, -1};
				
				if(matrix[row][col] < target) {
						nextRow = searchInSortedMatrix(matrix, target, row + 1, col);
						nextCol = searchInSortedMatrix(matrix, target, row, col + 1);
				}
				
				return new int[]{Math.max(nextRow[0], nextCol[0]),
												 Math.max(nextRow[1], nextCol[1])};
				
		}
			
		public static int[] searchInSortedMatrix2(int[][] matrix, int target) {
				int row = 0;
				int col = matrix[0].length - 1;
				while(row < matrix.length && col >= 0) {
					if(matrix[row][col] > target) {
						col--;
					}else if(matrix[row][col] < target) {
						row++;
					}else {
						return new int[] {row, col};
					}
				}
				
				return new int[] {-1, -1};
		}

}
