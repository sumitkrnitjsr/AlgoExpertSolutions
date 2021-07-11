package mIcrosoft;

public class Buy_Sell_Stock {
	
	
	public int maxProfitBest(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0;i < prices.length;i++) {
			if(prices[i] < minPrice) {
				minPrice = prices[i];			
			}else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		
		return maxProfit;
	}
	
	 public int maxProfit(int[] prices) {
	        
	        int[] highPrice = new int[prices.length];
	        int max = prices[prices.length - 1];
	        highPrice[prices.length - 1] = Integer.MIN_VALUE;
	        for(int i = prices.length - 2;i >= 0;i--) {
	                highPrice[i] = (prices[i] >= max)?Integer.MIN_VALUE:max;
	                max = Math.max(max, prices[i]);
	        }
	        int maxProfit = 0;
	        for(int i = 0;i < prices.length;i++) {
	            if(highPrice[i] > prices[i]){
	                maxProfit = Math.max(highPrice[i] - prices[i], maxProfit);
	            }
	        }
	        
	        return maxProfit;
	    }

}
