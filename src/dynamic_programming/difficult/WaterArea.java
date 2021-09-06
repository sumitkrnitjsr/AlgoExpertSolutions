package dynamic_programming.difficult;

public class WaterArea {
	
	 public static int waterArea(int[] heights) {
			if(heights.length < 1){
					return 0;
			}
	    // Write your code here.
			int[] left = new int[heights.length];
			int[] right = new int[heights.length];
			
			int max = heights[heights.length - 1];
			for(int i = heights.length - 1;i >= 0;i--) {
					max = right[i] = Math.max(max, heights[i]);
			}
			
			max = heights[0];
			for(int i = 0;i < heights.length;i++) {
					max = left[i] = Math.max(max, heights[i]);
			}
			
			int waterArea = 0;
			for(int i = 1;i < heights.length - 1;i++) {
					if(Math.min(left[i], right[i]) > heights[i]) {
							waterArea += Math.min(left[i], right[i]) - heights[i];
					}
			}
	    return waterArea;
	  }
	 
	 public int trapBest(int[] height) {
	        
	        if(height.length == 0) return 0;
	        
	        int lIdx = 0;
	        int lMax = height[0];
	        int rIdx = height.length - 1;
	        int rMax = height[rIdx];
	        int totalArea = 0;
	        
	        while(rIdx > lIdx) {
	            if(height[lIdx] < height[rIdx]) {
	                lIdx++;
	                lMax = Math.max(lMax, height[lIdx]);
	                totalArea += lMax - height[lIdx];
	            }else {
	                 rIdx--;
	                rMax = Math.max(rMax, height[rIdx]);
	                totalArea += rMax - height[rIdx];
	            }
	        }
	        
	        return totalArea;
	    }

}
