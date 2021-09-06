package mIcrosoft;

public class SingleNonRepeating {
	
	 public int singleNumber(int[] nums) {
	        int num = 0;
	        for(int i = 0;i < nums.length;i++) {
	            num = num ^ nums[i];
	        }
	        return num;
	    }
	 
	 public int singleNumber(int[] nums) {
	       HashSet<Integer> set = new HashSet<>();
	        for(int num: nums) {
	            if(set.contains(num)) set.remove(num);
	            else set.add(num);
	        }
	        
	        return set.toArray(new Integer[1])[0];
	    }

}
