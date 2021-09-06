package mIcrosoft;


// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.


public class SortColors {
	
	public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0;i < nums.length;i++) {
                count[nums[i]]++;
        }
        int idx = 0;
        for(int i = 0;i < nums.length;i++) {
            while(count[idx] == 0) idx++;
            nums[i] = idx;
            count[idx]--;
        }
	}
	
	  public void sortColorsDNF(int[] nums) {
          int low = 0;
           int mid = 0;
           int high = nums.length - 1;
       
       while(mid <= high) {
           if(nums[mid] == 0) {
               int temp = nums[low];
               nums[low] = nums[mid];
               nums[mid] = temp;
               low++; mid++;
           }else if(nums[mid] == 2) {
               int temp = nums[high];
               nums[high] = nums[mid];
               nums[mid] = temp;
               high--;
           }else{
               mid++;    
           }
           
       }
   }

}
