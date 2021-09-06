package mIcrosoft.random;

public class SignOfArrayProduct {
	
	 public int arraySign(int[] nums) {
	        if(nums == null || nums.length < 1) return 0;
	        int countNegative = 0;
	        for(int num: nums) {
	            if(num < 0) countNegative++;
	            if(num == 0) return 0;
	        }
	        return (countNegative % 2) == 0 ? 1 : -1;
	 }

}
