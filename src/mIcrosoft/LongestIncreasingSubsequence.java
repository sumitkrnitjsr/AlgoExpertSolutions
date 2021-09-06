package mIcrosoft;
import java.util.*;


public class LongestIncreasingSubsequence {
	
	 public int lengthOfLIS(int[] nums) {
	        if(nums.length < 1) {
	            return 0;
	        }
	        int[] length = new int[nums.length];
	        // Edge case for only one element in the middle of array
	        Arrays.fill(length, 1);
	        
	        for(int i = 1;i < nums.length;i++) {
	            for(int j = 0;j < i;j++) {
	                if(nums[j] < nums[i]) {
	                    length[i] = Math.max(length[i], length[j] + 1);
	                }
	            }
	        }
	        int max = Integer.MIN_VALUE;
	        for(int i = 0;i < length.length;i++) {
	            max = Math.max(max, length[i]);
	        }
	        
	        return max;
	    }
	 
	 class Solution {
		 
		 	// this algorithm does not always generate a valid subsequence of the input, but the length of the subsequence will always equal the length of the longest increasing subsequence.
		 
		    public int lengthOfLIS(int[] nums) {
		        ArrayList<Integer> sub = new ArrayList<>();
		        sub.add(nums[0]);
		        
		        for (int i = 1; i < nums.length; i++) {
		            int num = nums[i];
		            if (num > sub.get(sub.size() - 1)) {
		                sub.add(num);
		            } else {
		                int j = binarySearch(sub, num);
		                sub.set(j, num);
		            }
		        }
		        
		        return sub.size();
		    }
		    
		    private int binarySearch(ArrayList<Integer> sub, int num) {
		        int left = 0;
		        int right = sub.size() - 1;
		        int mid = (left + right) / 2;
		        
		        while (left < right) {
		            mid = (left + right) / 2;
		            if (sub.get(mid) == num) {
		                return mid;
		            }
		            
		            if (sub.get(mid) < num) {
		                left = mid + 1;
		            } else {
		                right = mid;
		            }
		        }
		        
		        return left;
		    }
		}

}
