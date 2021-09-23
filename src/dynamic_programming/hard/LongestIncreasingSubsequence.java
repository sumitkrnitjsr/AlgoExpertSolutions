package dynamic_programming.hard;
import java.util.*;

public class LongestIncreasingSubsequence {
	
	 public static List<Integer> longestIncreasingSubsequence(int[] array) {
		    // Write your code here.
				int[] sequences = new int[array.length];
				int[] indices = new int[array.length + 1];
				Arrays.fill(indices,Integer.MIN_VALUE);
				int length = 0;
				for(int i = 0;i < array.length;i++) {
						int newLength = bst(1, length, indices, array,array[i]); 
						sequences[i] = indices[newLength - 1];
						indices[newLength] = i;
						length = Math.max(length, newLength);
				}
				List<Integer> sequence = new ArrayList<Integer>();
				int currentIdx = indices[length];
				while(currentIdx != Integer.MIN_VALUE){
						sequence.add(0, array[currentIdx]);
						currentIdx = sequences[currentIdx];
				}
		    return sequence;
		  }

		private static int bst(int startIdx,int endIdx,int[] indices, int[] array,int num) {
				if(startIdx > endIdx) return startIdx;
				int midIdx = (startIdx + endIdx) / 2;
				if(array[indices[midIdx]] < num) startIdx = midIdx + 1;
				else	endIdx = midIdx - 1;
				return bst(startIdx, endIdx, indices, array,num);
		}

}
