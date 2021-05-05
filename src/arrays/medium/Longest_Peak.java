package arrays.medium;

public class Longest_Peak {
	
	 public static int longestPeak(int[] array) {
		    // Write your code here.
				int currentPeakCount = 0;
				int maxPeakCount = 0;
				int arrayIdx = 0;
				
				while(arrayIdx < array.length - 2) {
							
							while(array[arrayIdx] == array[arrayIdx + 1]) { // Forgot to handle equal number cases
										arrayIdx++;
							}
							
							int increasingSequence = 0;
					
							while(arrayIdx < array.length - 1 && array[arrayIdx] < array[arrayIdx + 1]) {
										increasingSequence++;
										arrayIdx++;
							}
							
							if(increasingSequence == 0) { // Forgot to handle cases without increasing & decreasing sequence
									arrayIdx++;
									continue;
							}
							
							int decreasingSequence = 1;
							while(arrayIdx < array.length - 1  && array[arrayIdx] > array[arrayIdx + 1]) {
									decreasingSequence++;
									arrayIdx++;
							}
							
							if(decreasingSequence == 1) { // Forgot to handle cases without decreasing sequence
									continue; 
							}
					
							currentPeakCount = increasingSequence + decreasingSequence;
							if(currentPeakCount > maxPeakCount) {
									maxPeakCount = currentPeakCount;
							}
							
				}
				
		    return maxPeakCount;
	}
	 
	public static int longestPeak2(int[] array) {
			int longestPeakLength = 0;
			int i = 1;
			
			while(i < array.length - 1) {
					boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
					if(!isPeak) {
						i += 1;
						continue;
					}
					
					int leftIdx = i - 2;
					while(leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
						leftIdx--;
					}
					
					int rightIdx = i + 2;
					while(rightIdx < array.length & array[rightIdx] < array[rightIdx - 1]) {
							rightIdx++;
					}
					
					int currentPeakLength = rightIdx - leftIdx - 1;
					if(currentPeakLength > longestPeakLength) {
						longestPeakLength = currentPeakLength;
					}
					
					i = rightIdx;
			}
			
			return longestPeakLength;
	}

}
