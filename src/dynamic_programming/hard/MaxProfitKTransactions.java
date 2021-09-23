package dynamic_programming.hard;

public class MaxProfitKTransactions {
	
	 public static int maxProfitWithKTransactions(int[] prices, int k) {
		    // Write your code here.
				if(prices.length == 0) return 0;
				int[] evenProfits = new int[prices.length];
				int[] oddProfits = new int[prices.length];
				int[] currentProfits;
				int[] previousProfits;
				
				for(int t = 1;t <= k;t++) {
						int max = Integer.MIN_VALUE;
						if(t % 2 == 1) {
								currentProfits = oddProfits;
								previousProfits = evenProfits;
						}else {
								currentProfits = evenProfits;
								previousProfits = oddProfits;
						}
						for(int d = 1;d < prices.length;d++) {
								max = Math.max(max, previousProfits[d - 1] - prices[d - 1]);
								currentProfits[d] = Math.max(currentProfits[d - 1], max + prices[d]);
						}
				}
		    return k % 2 == 0 ? evenProfits[prices.length - 1] : oddProfits[prices.length - 1];
		  }

}
