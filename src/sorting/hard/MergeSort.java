package sorting.hard;

import java.util.Arrays;

public class MergeSort {
	
	 public static int[] mergeSort(int[] array) {
		    // Write your code here.
				mergeSort(array, 0, array.length - 1);
		    return array;
		  }
			
			private static void mergeSort(int[] array,int startIdx,int endIdx) {
					if(startIdx < endIdx) {
							int mid = startIdx + (endIdx - startIdx) / 2;
							mergeSort(array, startIdx, mid);
							mergeSort(array, mid + 1,endIdx);
							merge(array, startIdx, mid, endIdx);
					}
			}
			
			private static void merge(int[] array,int startIdx,int midIdx,int endIdx) {
					int[] mergedArray = new int[endIdx - startIdx + 1];
					int firstIdx = startIdx;
					int secondIdx = midIdx + 1;
					int currentIdx = 0;
					while(firstIdx <= midIdx && secondIdx <= endIdx) {
								if(array[firstIdx] < array[secondIdx]) {
										mergedArray[currentIdx] = array[firstIdx];
										firstIdx++;
								}else{
										mergedArray[currentIdx] = array[secondIdx];
										secondIdx++;
								}
								currentIdx++;
					}
				
					while(firstIdx <= midIdx) {
							mergedArray[currentIdx] = array[firstIdx];
							currentIdx++; firstIdx++;
					}
				
					while(secondIdx <= endIdx) {
							mergedArray[currentIdx] = array[secondIdx];
							currentIdx++; secondIdx++;
					}
				
					for(int idx = 0;idx < mergedArray.length;idx++) {
							array[startIdx + idx] = mergedArray[idx];
					}
			}
			
			
			// Second Solution Below ---------------------
			
			public static int[] mergeSort2(int[] array) {
				if(array.length <= 1) {
						return array;
				}
				
				int middleIdx = array.length / 2;
				int[] leftHalf = Arrays.copyOfRange(array, 0, middleIdx);
				int[] rightHalf = Arrays.copyOfRange(array, middleIdx + 1, array.length);
				return mergeSortedArrays(mergeSort(leftHalf),mergeSort(rightHalf));
			}
			
			private static int[] mergeSortedArrays(int[] leftHalf,int[] rightHalf) {
				int[] sortedArray = new int[leftHalf.length + rightHalf.length];
				int i = 0;
				int j = 0;
				int k = 0;
				
				while(i < leftHalf.length && j < rightHalf.length) {
					if(leftHalf[i] <= rightHalf[j]) {
						sortedArray[k++] = leftHalf[i++];
					}else {
						sortedArray[k++] = rightHalf[j++];
					}
				}
				
				while(i < leftHalf.length) {
					sortedArray[k++] = leftHalf[i++];
				}
				
				while(i < rightHalf.length) {
					sortedArray[k++] = rightHalf[j++];
				}
				return sortedArray;
			}
			

}
