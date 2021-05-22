package search.difficult;

// If you know you have to do 'n' operations and sorting takes 'nlogn', so each operations, cost, 'log n'

public class Quick_Select {
	
	 public static int quickselect(int[] array, int k) {
		    // Write your code here.
		    return kthquicksort(array, k, 0, array.length - 1);
		  }
			
			private static int kthquicksort(int[] array,int k, int start,int end) {
							int pivot = findPos(array, start,end);
							if(pivot == k - 1) {
									return array[pivot];						
							}
								
							if(pivot < k - 1) {
									return kthquicksort(array, k, pivot + 1, end);						
							}
							return kthquicksort(array, k, start, pivot - 1);
			}
			
			private static int findPos(int[] array,int start,int end) {
						int pivot = array[start];
						int left = start + 1;
						int right = end;
						// if you miss <= here, below case will fail ({2, 15})
						while(left <= right) {
									// <= should be handled by left not right
									while(left <= end && array[left] <= pivot) left++;
									while(right >= start && array[right] > pivot) right--;
										
									if(left < right) {
											int temp = array[right];
											array[right] = array[left];
											array[left] = temp;
									}
						}
						// Stackoverflow error in case used left instead of right
						array[start] = array[right];
						array[right] = pivot;
						return right;
			}
			
			public static int quickselect(int[] array,int startIdx,int endIdx,int position) {
						while(true) {
							int pivotIdx = startIdx;
							int leftIdx = startIdx + 1;
							int rightIdx = endIdx;
							while(leftIdx <= rightIdx) {
									if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
										swap(leftIdx, rightIdx, array);
									}
									if(array[leftIdx] <= array[pivotIdx]) leftIdx++;
									if(array[rightIdx] >= array[pivotIdx]) rightIdx--;
							}
							
							swap(pivotIdx,rightIdx, array);
							
							if(rightIdx == position) {
								return array[rightIdx];
							}else if(rightIdx < position) {
								startIdx = rightIdx + 1;
							}else {
								endIdx = rightIdx - 1;
							}
						}
			
			}
			
			
			private static void swap(int i,int j,int[] array) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
			}

}
