package arrays.difficult;
import java.util.*;

public class Largest_Range {

	
	 public static int[] largestRange(int[] array) {
		    // Write your code here.
				Arrays.sort(array);
				int[] maxLength = new int[]{-1, -1};
				int length = 0;
				for(int idx = 0;idx < array.length;idx++) {
						int count = 1;
						int startIdx = idx;
						// Forgot to handle equal number cases
						while(idx < array.length - 1 && ((array[idx + 1] - array[idx] == 1) || array[idx] == array[idx + 1])) {
								// Forgot to handle only equal number series	
								if(!(array[idx] == array[idx + 1])) {
										count++;
									}
									idx++;
						}
						int endIdx = idx;
						if(count > length) {
								length = count;
								maxLength = new int[]{array[startIdx], array[endIdx]};
						}
				}
				return maxLength;
	}
	 
	 public static int largestRangeBest(int[] array) {
		 	int[] bestRange = new int[2];
		 	int longestLength = 0;
		 	Map<Integer, Boolean> nums = new HashMap<>();
		 	for(int num:array) {
		 		nums.put(num, true);
		 	}
		 	for(int num:array) {
		 		if(!nums.get(nums))
		 			continue;
		 		
		 		nums.put(num, false);
		 		int currentLength = 1;
		 		int left = num - 1;
		 		int right = num + 1;
		 		while(nums.containsKey(left)) {
		 			nums.put(left, false);
		 			currentLength++;
		 			left--;
		 		}
		 		while(nums.containsKey(right)) {
		 			nums.put(right, false);
		 			currentLength++;
		 			right++;
		 		}
		 		
		 		if(currentLength > longestLength) {
		 				longestLength = currentLength;
		 				bestRange = new int[] {left + 1, right - 1};
		 		}
		 	}
		 	
		 	if(bestRange[1] == bestRange[0]) {
		 		return 1;
		 	}
		 	
		 	return (bestRange[1] - bestRange[0] + 1);
		 	
	 }
}
