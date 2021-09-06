package dynamic_programming.difficult;
import java.util.*;

public class Knapsack01 {
	
	 public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		    // Write your code here.
		    // Replace the code below.
				int[][] knapsack = new int[items.length + 1][capacity + 1];
				
				for(int i = 1;i <= items.length;i++) {			
						for(int j = 1;j <= capacity;j++) {
								if(items[i - 1][1] > j) {
										// Wrong assumption : knapsack[i][j] = Math.max(knapsack[i][j - 1], knapsack[i - 1][j]);
										knapsack[i][j] = knapsack[i - 1][j];
								}else {
									 /*
										knapsack[i][j] = Math.max(Math.max(0, knapsack[i - 1][j]),
																						 Math.max(knapsack[i][j - 1],items[i - 1][0] + knapsack[i][j - items[i - 1][1]]));
									 */
										knapsack[i][j] = Math.max(knapsack[i - 1][j]
																						 ,items[i - 1][0] + knapsack[i - 1][j - items[i - 1][1]]);
								}
						}
				}
				
				List<Integer> finalItems = new ArrayList<>();
				int i = items.length;
				int j = capacity;
				
					while(i > 0 && j > 0) {
							
							if(knapsack[i][j] == knapsack[i - 1][j]) {
									i--;	
							}else {
									finalItems.add(i - 1);
									j = j - items[i - 1][1];
									i--;
							}
							
					}
				
		    List<Integer> totalValue = Arrays.asList(knapsack[items.length][capacity]);
		    var result = new ArrayList<List<Integer>>();
		    result.add(totalValue);
		    result.add(finalItems);
		    return result;
		  }

}
