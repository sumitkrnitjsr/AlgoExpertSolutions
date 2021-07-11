package arrays.difficult;
import java.util.*;
import java.util.stream.IntStream;

public class Minimum_Rewards {
	
	 public static int minRewards(int[] scores) {
		    // Write your code here.
				int[] rewards = new int[scores.length];
				Arrays.fill(rewards, 1);
				for(int idx = 1;idx < scores.length;idx++) {
							if(scores[idx] > scores[idx - 1]) {
									rewards[idx] = Math.max(rewards[idx], rewards[idx - 1] + 1);
							}
				}
				
				for(int idx = scores.length - 2;idx >= 0;idx--) {
							if(scores[idx] > scores[idx + 1]) {
									rewards[idx] = Math.max(rewards[idx], rewards[idx + 1] + 1);
							}
				}
				
				int sum = 0;
				for(int reward:rewards) {
						sum += reward;
				}
				
		    return sum;
	}
	 
	 public static int minRewardsNaive(int[] scores) {
		    // Write your code here.
				int[] rewards = new int[scores.length];
				Arrays.fill(rewards,  1);
				for(int i = 1;i < scores.length;i++) {
					int j = i - 1;
					if(scores[i] > scores[j]) {
						rewards[i] = rewards[j] + 1;
					}else {
						while(j >=0 && scores[j] > scores[j + 1]) {
							rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
							j--;
						}
					}
				}
				
		    return IntStream.of(rewards).sum();
	}
	 
	 
	public static int minRewardsBetter(int[] scores) {
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		List<Integer> localMins = getLocalMinIdxs(scores);
		for(Integer localMin: localMins) {
				expandFromLocalMinIdx(localMin, scores, rewards);
		}
		
		return IntStream.of(rewards).sum();
	}
	
	public static List<Integer> getLocalMinIdxs(int[] array) {
		List<Integer> localMinIdxs = new ArrayList<>();
		if(array.length == 1) {
			localMinIdxs.add(0);
			return localMinIdxs;
		}
		
		for(int i = 0;i < array.length;i++) {
			if(i == 0 && array[i] < array[i + 1]) localMinIdxs.add(i);
			if(i == array.length - 1 && array[i] < array[i - 1]) localMinIdxs.add(i);
			if(i == 0 || i == array.length - 1) continue;
			if(array[i] < array[i + 1] && array[i] < array[i - 1]) localMinIdxs.add(i);
		}
		
		return localMinIdxs;
		
	}
	
	public static void expandFromLocalMinIdx(int localMinIdx, int[] scores, int[] rewards) {
			int leftIdx = localMinIdx - 1;
			while(leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
					rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
					leftIdx--;
			}
			
			int rightIdx = localMinIdx + 1;
			
			while(rightIdx < scores.length && scores[rightIdx] > scores[rightIdx - 1]) {
				rewards[rightIdx] = rewards[rightIdx - 1] + 1;
				rightIdx++;
		}
	}
	 

}
