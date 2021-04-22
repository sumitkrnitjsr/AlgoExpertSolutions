package famous_algorithms;

public class Kadanes {
	
	 public static int kadanesAlgorithm(int[] array) {
		    // Write your code here.
				int maxSumIdx = Integer.MIN_VALUE;
				int currentSumIdx = 0;
				
				for(int i = 0;i < array.length;i++){
						currentSumIdx += array[i];
						if(currentSumIdx > maxSumIdx){
								maxSumIdx = currentSumIdx;
						}
						if(currentSumIdx < 0){
								currentSumIdx = 0;
						}
				}
				
		    return maxSumIdx;
	}
	 
	public static int kadanesAlgorithm2(int[] array) {
		
		int maxEndingHere = array[0];
		int maxSoFar = array[0];
		for(int i = 1;i < array.length;i++) {
			int num = array[i];
			maxEndingHere = Math.max(num, maxEndingHere + num);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

}
