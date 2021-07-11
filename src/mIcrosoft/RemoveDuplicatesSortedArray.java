package mIcrosoft;


//  Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

public class RemoveDuplicatesSortedArray {
	
public int removeDuplicates(int[] nums) {
        
        int idx = 0;
        int k = 0;
        while(k < nums.length) {
                int current = nums[k];
                while(k < nums.length && nums[k] == current) k++;
                nums[idx] = current;
                idx++;
        }
        
        return idx;
    }

}
