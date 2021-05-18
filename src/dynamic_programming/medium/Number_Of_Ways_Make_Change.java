package dynamic_programming.medium;

public class Number_Of_Ways_Make_Change {
	
	 public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		    // Write your code here.
				int[] numberOfWays = new int[n + 1];
				numberOfWays[0] = 1;
				for(int i = 0;i < denoms.length;i++) {
						int num = denoms[i];
						int idx = num;
						while(idx <= n) {
								numberOfWays[idx] += numberOfWays[idx - num];
								idx++;
						}
				}
				
				return numberOfWays[n];
	}
	 
	private static int numberOfWaysToMakeChange2(int n, int[] denoms) {
			int[] ways = new int[n + 1];
			ways[0] = 1;
			for(int denom:denoms) {
				for(int amount = 1;amount < n + 1; amount++) {
					if(denom <= amount) {
						ways[amount] += ways[amount -  denom];
					}
				}
			}
			
			return ways[n];
	}

}
