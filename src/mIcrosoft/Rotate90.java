package mIcrosoft;

public class Rotate90 {
	
	 public void rotate(int[][] source_buffer) {
	        int m = source_buffer.length;
	        int n = source_buffer[0].length;
	        int[][] dest_buffer = new int[m][n];
	        for (int r = 0; r < m; r++){
	        for (int c = 0; c < n; c++){
	      // Hint: Map each source element indices into
	      // indices of destination matrix element.
	            dest_buffer [ c ] [ m - r - 1 ] = source_buffer [ r ] [ c ];
	            }
	        }
	            
	        for (int r = 0; r < m; r++){
	        for (int c = 0; c < n; c++){
	            source_buffer [ r ] [ c ] = dest_buffer[r][c];
	            }
	        }
	  }
	 
	 
	 public void rotateBest(int[][] matrix) {
	        int n = matrix.length;
	        for(int i = 0;i < (n + 1)/2;i++) {
	            
	            for(int j = 0;j < n / 2;j++) {
	                int temp = matrix[n - 1 - j][i];
	                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
	                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
	                matrix[j][n - 1 - i] = matrix[i][j];
	                matrix[i][j] = temp;
	            }
	            
	        }
	       
	  }

}
