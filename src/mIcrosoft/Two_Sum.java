package mIcrosoft;
import java.util.*;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/


public class Two_Sum {
	
	  // Need to return indices instead of the Number itself
    public int[] twoSum(int[] nums, int target) {
        
      int[] result = new int[2];
      result[0] = result[1] = -1;
      // HashMap instead of HashSet if indices needs to be returned
      HashMap<Integer, Integer> visited = new HashMap<>();
      int idx = -1;
        for(int num: nums) {
            idx++;
            int companionNum = target - num;
            // HashMap instead of HashSet containsKey instead of contains
            if(visited.containsKey(companionNum)) {
                return new int[]{Math.min(idx,visited.get(companionNum)), Math.max(idx,visited.get(companionNum))};
            }
            // HashMap instead of HashSet put instead of add
            visited.put(num, idx);
        }
		return result;
    }
    
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
