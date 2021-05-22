package sorting.difficult;

import java.lang.reflect.Array;

public class Heap_Sort {
	
	 public static int[] heapSort(int[] array) {
		    // Write your code here.
				for(int idx = 1;idx < array.length;idx++) {
						int i = idx;
						int parent = (i - 1) / 2;
						while(i > 0 && array[parent] <= array[i]) {
									swap(parent, i, array);
									i = parent;
									parent = (i - 1) / 2;
						}
				}
				
				for(int i = 0;i < array.length - 1;i++) {
						int endIdx = array.length - i - 1;
						swap(0, endIdx, array);
						int lchild = 1;
						int rchild = 2 < endIdx ? 2 : -1;
						int parent = 0;
						while(lchild < endIdx){
									int child = lchild;
									if(rchild != -1 && array[rchild] > array[lchild]) child = rchild;
									// Forgot to stop 
									if(array[child] < array[parent]) break;
									swap(parent, child, array);
									parent = child;
									lchild = parent * 2 + 1;
									rchild = parent * 2 + 2 < endIdx ? parent * 2 + 2 : -1;
						}
				}
		    return array;
		  }
			
			private static void swap(int i,int j,int[] array) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
			}
			
			public static int[] heapSort2(int[] array) {
				
				buildMaxHeap(array);
				for(int endIdx = array.length - 1;endIdx >0;endIdx--) {
						swap(0, endIdx, array);
						siftDown(0, endIdx - 1, array);
				}
				
				return array;
				
			}
			
			public static void buildMaxHeap(int[] array) {
					int firstParentIdx = (array.length - 2) / 2;
					for(int currentIdx = firstParentIdx;currentIdx >= 0;currentIdx--) {
							siftDown(currentIdx, array.length - 1, array);
					}
			}
			
			private static void siftDown(int currentIdx,int endIdx, int[] array) {
				int childOneIdx = currentIdx * 2 + 1;
				while(childOneIdx <= endIdx) {
						int childTwoIdx = childOneIdx + 1 <= endIdx ? childOneIdx + 1 : -1;
						int idxToSwap;
						if(childTwoIdx != -1 && array[childTwoIdx] > array[childOneIdx]) {
								idxToSwap = childTwoIdx;
						}else {
								idxToSwap = childOneIdx;
						}
						
						if(array[idxToSwap] > array[currentIdx]) {
								swap(currentIdx, idxToSwap, array);
								currentIdx = idxToSwap;
								childOneIdx = currentIdx * 2 + 1;
						}else {
								return;
						}
				}
			}

}
