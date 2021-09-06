package dynamic_programming.difficult;
import java.util.*;


// O(n ^ 2) time && O( n ) space
public class MaximumSumIncreasingSubsequence {
	
	
	
	public List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		int[] sequences = new int[array.length];
		Arrays.fill(sequences, Integer.MIN_VALUE);
		int[] sums = array.clone();
		int maxSumIdx = 0;
		for(int i = 0;i < array.length;i++) {
			int currentNum = array[i];
			for(int j = 0;j < i;j++) {
				int otherNum = array[j];
				if(otherNum < currentNum && sums[j] + currentNum >= sums[i]) {
					// Store sum to track maxSumIdx
					sums[i] = sums[j] + currentNum;
					// Last Idx with less value but highest sum
					sequences[i] = j;
				}
			}
			if(sums[i] >= sums[maxSumIdx]) {
				maxSumIdx = i;
			}
		}
		return buildSequence(array, sequences, maxSumIdx, sums[maxSumIdx]);
	}
	
	private List<List<Integer>> buildSequence(int[] array, int[] sequences, int currentIdx, int sums) {
		List<List<Integer>> sequence = new ArrayList<>();
		sequence.add(new ArrayList<Integer>());
		sequence.add(new ArrayList<Integer>());
		sequence.get(0).add(sums);
		while(currentIdx != Integer.MIN_VALUE) {
			sequence.get(1).add(0, array[currentIdx]);
			currentIdx = sequences[currentIdx];
		}
		
		return sequence;
	}
	
	
	
	 public static List<List<Integer>> maxSumIncreasingSubsequenceRecursion(int[] array) {
		    // Write your code here.
				List<Integer> subsequence = new ArrayList<>();
		   	return maxSumIncreasingSubsequence(array, 0, -1, 0, subsequence);
		  }
			
			public static List<List<Integer>> maxSumIncreasingSubsequence(
										int[] array, int idx,int lastIdx, int sum, List<Integer> subsequence) {
				List<List<Integer>> withCurrentIdx = new ArrayList<List<Integer>>();
				List<List<Integer>> withoutCurrentIdx = new ArrayList<List<Integer>>();
				withCurrentIdx.add(List.of(Integer.MIN_VALUE));
				withoutCurrentIdx.add(List.of(Integer.MIN_VALUE));
				withCurrentIdx.add(new ArrayList<Integer>());
				withoutCurrentIdx.add(new ArrayList<Integer>());
				
					if(idx == array.length) {
						 if(subsequence.size() == 0) return withoutCurrentIdx;
							return new ArrayList<List<Integer>>() {
		      		{
		        		add(List.of(sum)); 
		        		add(subsequence); 
		      		}
		    };
				}
				
				withoutCurrentIdx = maxSumIncreasingSubsequence(array, idx + 1, lastIdx, sum, subsequence);
				
				if(lastIdx == -1 || array[lastIdx] < array[idx]) {
					  List<Integer> sequence = new ArrayList<>();
						sequence.addAll(subsequence);
						sequence.add(array[idx]);
						withCurrentIdx = maxSumIncreasingSubsequence(array, idx + 1, idx, sum + array[idx], sequence);
				}
				
				
				
				return withCurrentIdx.get(0).get(0) > withoutCurrentIdx.get(0).get(0) 
								? withCurrentIdx
								: withoutCurrentIdx;
			}

}
