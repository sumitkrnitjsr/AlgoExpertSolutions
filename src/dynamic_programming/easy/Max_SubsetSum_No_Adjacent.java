package dynamic_programming.easy;

public class Max_SubsetSum_No_Adjacent {

	
	 public static int maxSubsetSumNoAdjacent(int[] array) {
	    	if(array.length == 0){
					return 0;
				}
	    return maxSubsetSumNoAdjacent(array, 0);
	  }
		
		private static int maxSubsetSumNoAdjacent(int[] array, int index){
			if(index >= array.length){
				return 0;
			}
			int sumWithCurrentIndex = maxSubsetSumNoAdjacent(array, index + 2);
			sumWithCurrentIndex += array[index];
			
			int sumWithoutCurrentIndex = maxSubsetSumNoAdjacent(array, index + 1);
			
			return Math.max(sumWithCurrentIndex, sumWithoutCurrentIndex);
			
		}
		
		
		 public static int maxSubsetSumNoAdjacentBetter(int[] array) {
				if(array.length == 0){
					return 0;
				}
				if(array.length == 1){
					return array[0];
				}
				
				int[] maxSums = array.clone();
				maxSums[1] = Math.max(array[0], array[1]);
				
				for(int i = 2;i < array.length;i++){
					maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
				}
				
		    return maxSums[array.length - 1];
		  }
		 
		 public static int maxSubsetSumNoAdjacentBest(int[] array) {
			    // Write your code here.
					if(array.length == 0){
						return 0;
					}
					if(array.length == 1){
						return array[0];
					}
					
					int maxSumLastIndex = Math.max(array[1], array[0]);
					int maxSumSecondLastIndex = array[0];
					
					for(int i = 2;i < array.length;i++){
							int currentMaxSum = Math.max(maxSumLastIndex, (maxSumSecondLastIndex + array[i]));
							maxSumSecondLastIndex = maxSumLastIndex;
							maxSumLastIndex = currentMaxSum;
					}
					
			    return Math.max(maxSumLastIndex, maxSumSecondLastIndex);
			  }
}
