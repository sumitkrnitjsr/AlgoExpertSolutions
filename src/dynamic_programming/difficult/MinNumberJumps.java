package dynamic_programming.difficult;
import java.util.*;

public class MinNumberJumps {
	
	 public static int minNumberOfJumps(int[] array) {
		    // Write your code here.
		    return minJumps(array, 0, 0);
		  }
			
			private static int minJumps(int[] array,int idx,int steps) {
					if(idx == array.length - 1) return steps;
					if(idx >= array.length)  return Integer.MAX_VALUE;
				
					int minStep = Integer.MAX_VALUE;
					for(int i = 1;i <= array[idx];i++) {
							int jump = minJumps(array, idx + i, steps + 1);
							minStep = Math.min(minStep, jump);
					}
					return minStep;
			}
			
			public static int minNumberOfJumpsBetter(int[] array) {
				int[] jumps = new int[array.length];
				Arrays.fill(jumps, Integer.MAX_VALUE);
				jumps[0] = 0;
				for(int i = 1;i < array.length;i++) {
					for(int j = 0;j < i;j++) {
						if(array[j] >= i - j) {
							jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
						}
					}
				}
				
				return jumps[jumps.length - 1];
			}
			
			 public static int minNumberOfJumpsBetter2(int[] array) {
					if(array.length < 2) return 0;
			    // Write your code here.
					int currIdx = -1;
					int jumps = 0;
					int jumpLeft = 1;
					int maxReachableIdx = 0;
					
					while(currIdx < array.length - 1) {
								currIdx++;
								maxReachableIdx = Math.max(maxReachableIdx, currIdx + array[currIdx]);
								jumpLeft--;
								if(jumpLeft == 0) {
										jumpLeft = maxReachableIdx - currIdx;
										if(currIdx != array.length - 1)
										jumps++;
								}
					}
				
					return jumps;
			  }
			 
			 public static int minNUmberOfJumpsBest(int[] array) {
				 if(array.length == 1) return 0;
				 int jumps = 0;
				 int maxReach = array[0];
				 int steps = array[0];
				 for(int i = 1;i < array.length;i++) {
					 maxReach = Math.max(maxReach, i + array[i]);
					 steps--;
					 if(steps == 0) {
						 jumps++;
						 steps = maxReach  - 1;
					 }
				 }
				 
				 return jumps + 1;
			 }

}
