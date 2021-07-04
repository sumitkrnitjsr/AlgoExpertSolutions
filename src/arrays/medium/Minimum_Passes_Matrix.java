package arrays.medium;
import java.util.*;

public class Minimum_Passes_Matrix {
	
	 public int minimumPassesOfMatrix(int[][] matrix) {
			Queue<Integer[]> primary = new LinkedList<>();
			Queue<Integer[]> secondary = new LinkedList<>();
			for(int i = 0;i < matrix.length;i++) {
				for(int j = 0;j < matrix[0].length;j++) {
						if(matrix[i][j] > 0) primary.add(new Integer[]{i, j});
				}
			}
			
			int pass = 1;
			while(!primary.isEmpty() || !secondary.isEmpty()) {
						Queue<Integer[]> processing = primary.isEmpty()?secondary:primary;
						Queue<Integer[]> store = primary.isEmpty()?primary:secondary;
				
						while(!processing.isEmpty()) {
									Integer[] front = processing.poll();
									processNeighbours(front, store, pass, matrix);
						}
						pass++;
			}
			
			for(int i = 0;i < matrix.length;i++) {
				for(int j = 0;j < matrix[0].length;j++) {
						if(matrix[i][j] < 0) return -1;
				}
			}
		
	    return pass - 2;
	  }
		
		private void processNeighbours(Integer[] idx, Queue<Integer[]> store, int pass, int[][] matrix) {
				int row, col;
				if(idx[0] > 0) {
						row = idx[0] - 1;
						col = idx[1];
						updateMatrixQueue(row, col, matrix, store, pass);
				}
				
				if(idx[0] < matrix.length - 1) {
						row = idx[0] + 1;
						col = idx[1];
						updateMatrixQueue(row, col, matrix, store, pass);
				}
			
				if(idx[1] > 0) {
						row = idx[0];
						col = idx[1] - 1;
						updateMatrixQueue(row, col, matrix, store, pass);
				}
			
				if(idx[1] < matrix[0].length - 1) {
						row = idx[0];
						col = idx[1] + 1;
						updateMatrixQueue(row, col, matrix, store, pass);
				}
			
				
		}
		
		private void updateMatrixQueue(int row, int col, int[][] matrix, Queue<Integer[]> store,int pass) {
				if(matrix[row][col] < 0) {
								matrix[row][col] = pass;
								store.add(new Integer[]{row, col});
				}
		}
		

}
