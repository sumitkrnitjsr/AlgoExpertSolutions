package mIcrosoft.random;

public class MinimumDeletionCostRepeatingCharacter {

	
	 public int minCost(String s, int[] cost) {
	        
	        if(s == null || s.length() < 2) return 0;
	        
	        int idx = 0;
	        int finalCount = 0;
	        while(idx < s.length()) {
	            char ch = s.charAt(idx);
	            int totalCount = 0;
	            // Track max value not min value
	            int max = Integer.MIN_VALUE;
	            // forgot to add initial repeating character
	            int repeatingIdx = idx;
	            idx++;
	            while(idx < s.length() && s.charAt(idx) == ch) {
	                totalCount += cost[idx];
	                max = Math.max(max,cost[idx]);
	                idx++;
	            }
	            
	            if(totalCount > 0) {
	                totalCount += cost[repeatingIdx];
	                max = Math.max(max, cost[repeatingIdx]);
	                finalCount += (totalCount - max);
	            }
	            
	        }
	        
	        return finalCount;
	    }
	 
}
