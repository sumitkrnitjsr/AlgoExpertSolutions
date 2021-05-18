package arrays.medium;
import java.util.*;

public class Merge_Overlapping_Intervals {
	
	 public int[][] mergeOverlappingIntervals(int[][] intervals) {
		    // Write your code here.
				Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
				HashMap<Integer, Integer> sets = new HashMap<>();
				for(int i = 0;i < intervals.length;i++) { // Wrong check i < intervals.length - 1
						int startSet = intervals[i][0];
						int endSet = intervals[i][1];
						while(i < intervals.length - 1 && canMerge(intervals,i,endSet)) {
									endSet = Math.max(endSet, intervals[i + 1][1]);
									i++;
						}
						sets.put(startSet, endSet);
				}
				int[][] overlapIntervals = new int[sets.size()][2];
				int idx = 0;
				for(Map.Entry<Integer, Integer> set:sets.entrySet()) {
						overlapIntervals[idx][0] = set.getKey();
						overlapIntervals[idx][1] = set.getValue();
							idx++;
				}
		    return overlapIntervals;
	 }
			
			private static boolean canMerge(int[][] intervals, int idx,int endSet) {
						if(intervals[idx + 1][0] <= endSet) {
								return true;
						}
						return false;
			}
			
			public int[][] mergeOverlapIntervals(int[][] intervals) {
				int[][] sortedIntervals = intervals.clone();
				Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
				
				List<int[]> mergedIntervals = new ArrayList<>();
				int[] currentInterval = sortedIntervals[0];
				mergedIntervals.add(currentInterval);
				
				for(int[] nextInterval:sortedIntervals) {
					int currentIntervalEnd = currentInterval[1];
					int nextIntervalStart = nextInterval[0];
					int nextIntervalEnd = nextInterval[1];
					
					if(currentIntervalEnd >= nextIntervalStart) {
						currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
					}else {
						currentInterval = nextInterval;
						mergedIntervals.add(currentInterval);
					}
				}
				
				
				return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
			}

}
