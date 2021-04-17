package sorting.easy;

// O(1) | O(n^2)

public class Bubble_Sort {
	
	public static int[] bubbleSort(int[] array) {
	    for(int i = 0;i < array.length - 1;i++){
					boolean swap = false;
					for(int j = 0;j < array.length - i - 1;j++){
							if(array[j] > array[j+1]){
									swap = true;
									int temp = array[j];
									array[j] = array[j + 1];
									array[j + 1] = temp;
							}
					}
					if(!swap){
						return array;
					}
			}
	    return array;
	  }
	
	public static int[] bubbleSortBest(int[] array) {
		boolean isSorted = false;
		int counter = 0;
		while(!isSorted) {
			isSorted = true;
			for(int i = 0;i < array.length - 1 - counter;i++){
				if(array[i] > array[i + 1]) {
					swap(i, i + 1, array);
					isSorted = false;
				}
		}
			counter++;
	}
	return array;
	}
	
	private static void swap(int x,int y,int[] array) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
