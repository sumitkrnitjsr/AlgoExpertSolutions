package arrays.difficult;

public class SubArray_Sort {
	
	 public static int[] subarraySort(int[] array) {
		    // Write your code here.
				int[] indices = new int[]{-1, -1};
				int leftIdx = 0;
				// Wrong check case (array[leftIdx] < array[leftIdx + 1])
				while(leftIdx < array.length - 1 && array[leftIdx] <= array[leftIdx + 1]) {
							leftIdx++;
				}
				// Wrong check case (leftIdx == array.length)
				if(leftIdx == array.length - 1) return indices;
				
				int rightIdx = array.length - 1;
				while(rightIdx > 0 && array[rightIdx] >= array[rightIdx - 1]) {
						rightIdx--;
				}
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				for(int i = leftIdx;i <= rightIdx;i++) {
						max = Math.max(max, array[i]);
						min = Math.min(min, array[i]);
				}
				rightIdx = array.length - 1;
				while(rightIdx > 0 && array[rightIdx] >= max) {
						rightIdx--;
				}
				
				leftIdx = 0;
				while(leftIdx < array.length && array[leftIdx] <= min) {
							leftIdx++;
				}
				
		    return new int[]{leftIdx, rightIdx};
		}
	 
	 public static int[] subarraySortBest(int[] array) {
		 int minOutOfOrder = Integer.MAX_VALUE;
		 int maxOutOfOrder = Integer.MIN_VALUE;
		 
		 for(int i = 0;i < array.length;i++) {
			 int num = array[i];
			 if(isOutOfOrder(i, num, array)) {
				 minOutOfOrder = Math.min(minOutOfOrder, num);
				 maxOutOfOrder = Math.max(maxOutOfOrder, num);
			 }
		 }
		 
		 if(minOutOfOrder == Integer.MAX_VALUE) return new int[] {-1,-1};
		 int subArrayLeftIdx = 0;
		 while(minOutOfOrder >= array[subArrayLeftIdx]) subArrayLeftIdx++;
		 int subArrayRightIdx = array.length - 1;
		 while(maxOutOfOrder <= array[subArrayRightIdx]) subArrayRightIdx--;
		 
		 return new int[] {subArrayLeftIdx, subArrayRightIdx};
	 }
	 
	 private static boolean isOutOfOrder(int i,int num, int[] array) {
		 		if(i == 0) return num > array[i + 1];
		 		
		 		if(i == array.length - 1) return num < array[i - 1];
		 		
		 		return num > array[i + 1] || num < array[i - 1];
	 }

}
