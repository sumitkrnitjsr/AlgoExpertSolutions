package sorting.easy;

public class Insertion_Sort {
	
	 public static int[] insertionSort(int[] array) {
		  	int i = 1;
				while(i < array.length){
					int itr = i;
					while(itr > 0 && array[itr] < array[itr - 1]){
							int swap = array[itr];
							array[itr] = array[itr - 1];
							array[itr - 1] = swap;
						itr--;
					}
					i++;
				}
		    return array;
		  }

}
