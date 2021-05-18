package dynamic_programming.medium;

public class Number_Of_Ways_Traverse_Graph {
	
	 public int numberOfWaysToTraverseGraph(int width, int height) {
		    // Write your code here.
		    return numberOfWays(width, height, 0 , 0);
		  }
			
			private int numberOfWays(int width,int height, int row,int col) {
					if(col == width - 1 && row == height - 1)		 {
							return 1;
					}
					if(col == width) return 0;
					if(row == height) return 0;
				
					int count = 0;
					count += numberOfWays(width, height, row + 1, col);
					count += numberOfWays(width, height, row, col + 1);
				
					return count;
	}
			
	private int numberOfWays(int width,int height) {
		if(width == 1 || height == 1) return 1;
		
		return numberOfWays(width - 1, height) + numberOfWays(width, height - 1);
	}
	
	public int numberOfWaysToTraverseGraphBetter(int width, int height) {
	    // Write your code here.
			int[][] matrix = new int[height][width];
			for(int i = 0;i < height;i++) {
				for(int j = 0;j < width;j++) {
						// Forgot to set boundaries as 1
						if(i == 0 || j == 0) {
								matrix[i][j] = 1;
									continue;
						}
						int totalWays = 0;
						if(i > 0) totalWays += matrix[i - 1][j];
						if(j > 0) totalWays += matrix[i][j - 1];
						matrix[i][j] = totalWays;
				}
			}
	    return matrix[height - 1][width - 1];
	  }
	
	public int numberOfWaysBest(int width,int height) {
		int numberOfLeftInPermutation = width - 1;
		int numberOfHeightInPermutation = height - 1;
		
		int numerator = factorial(numberOfLeftInPermutation + numberOfHeightInPermutation);
		int denominator = factorial(numberOfLeftInPermutation) * factorial(numberOfHeightInPermutation);
		
				
		return numerator / denominator;
	}
	
	
	
	private int factorial(int num) {
		int result = 1;
		for(int n = 2;n <= num;n++) {
			result *= n;
		}
		return result;
	}
	

}
