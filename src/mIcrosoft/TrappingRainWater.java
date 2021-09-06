package mIcrosoft;

public class TrappingRainWater {
	
	  public int trap(int[] height) {
	        
	      if(height.length < 3) return 0;
	    
	        int lmax = height[0];
	        int rmax = height[height.length - 1];
	        int left = 1;
	        int right = height.length - 2;
	        int sum = 0;
	        while(left <= right) {
	                if(lmax < rmax) {
	                    sum += Math.max(0, lmax - height[left]);
	                    lmax = Math.max(lmax, height[left]);
	                    left++;
	                }else {
	                    sum += Math.max(0, rmax - height[right]);
	                    rmax = Math.max(rmax, height[right]);
	                    right--;
	                }
	        }
	        return sum;
	    }

}
