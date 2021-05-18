package dynamic_programming.medium;

public class Min_Number_Coins_Change {
	
	 public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		    // Write your code here.
				int[] minNumberOfCoins = new int[n + 1];
				for(int i = 0;i <= n;i++) {
						minNumberOfCoins[i] = Integer.MAX_VALUE;
				}
				minNumberOfCoins[0] = 0;
					
				for(int idx = 0;idx < denoms.length;idx++) {
						int startIdx = denoms[idx];
						int coin = denoms[idx];
						while(startIdx <= n) {
									int currentCount = minNumberOfCoins[startIdx];
									int minCount = Integer.MAX_VALUE;
									// Forgot to handle variations of multiple options for single coin
									for(int i = 1;i <= (startIdx / coin);i++) {
									int newCoinCount =  i;
									int remainder = startIdx - (coin * i);
									int remainderCoinCount = minNumberOfCoins[remainder];
									newCoinCount = remainderCoinCount == Integer.MAX_VALUE ?
															Integer.MAX_VALUE : 
															(newCoinCount + remainderCoinCount);
									minCount = Math.min(minCount, newCoinCount);
									}
									minNumberOfCoins[startIdx] = Math.min(minCount, currentCount);
									startIdx++;
						}
				}
				
		    return minNumberOfCoins[n] == Integer.MAX_VALUE ? -1 : minNumberOfCoins[n];
		}
	 
	 
	 public static int minNumberOfCoinsForChangeBest(int n, int[] denoms) {
		    // Write your code here.
				int[] minNumberOfCoins = new int[n + 1];
				for(int i = 0;i <= n;i++) {
						minNumberOfCoins[i] = Integer.MAX_VALUE;
				}
				minNumberOfCoins[0] = 0;
					
				for(int idx = 0;idx < denoms.length;idx++) {
						int startIdx = denoms[idx];
						int coin = denoms[idx];
						while(startIdx <= n) {
									int currentCount = minNumberOfCoins[startIdx];
									int remainder = startIdx - coin;
									int remainderCoinCount = minNumberOfCoins[remainder] == Integer.MAX_VALUE?
																			Integer.MAX_VALUE:minNumberOfCoins[remainder] + 1;
									minNumberOfCoins[startIdx] = Math.min(remainderCoinCount, currentCount);
									startIdx++;
						}
				}
				
		    return minNumberOfCoins[n] == Integer.MAX_VALUE ? -1 : minNumberOfCoins[n];
		}

}
