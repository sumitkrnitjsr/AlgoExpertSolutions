package dynamic_programming.difficult;

public class MaxSumSubmatrix {
	
	  public int maximumSumSubmatrix(int[][] matrix, int size) {
		    // Write your code here.
				int[][] sumMap = new int[matrix.length][matrix[0].length];
				for(int i = 0;i < matrix.length;i++) {
						for(int j = 0;j < matrix[0].length;j++) {
								int top = i == 0 ? 0 : sumMap[i - 1][j];
								int left = j == 0 ? 0 : sumMap[i][j - 1];
								int diagonal = i == 0 || j == 0 ? 0 : sumMap[i - 1][j - 1];
								sumMap[i][j] = matrix[i][j] + top + left - diagonal;
						}
				}
				
				int maxSum = Integer.MIN_VALUE;
				
				for(int i = matrix.length - 1;i + 1 - size >= 0;i--) {
						for(int j = matrix[0].length - 1;j + 1 - size >= 0;j--) {
									int top = i + 1 - size == 0? 0 : sumMap[i - size][j];
									int left = j  + 1 - size == 0 ? 0 : sumMap[i][j - size];
									int diagonal = i + 1 - size == 0 || j  + 1 - size == 0 ? 0 : sumMap[i - size][j - size];
									maxSum = Math.max(maxSum, (sumMap[i][j] + diagonal - top - left));
									
						}
				}
			
		    return maxSum;
		  }

}
