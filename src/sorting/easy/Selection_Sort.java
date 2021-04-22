package sorting.easy;

public class Selection_Sort {
	
	 public static int[] selectionSort(int[] array) {
		    int counter = array.length - 1;
				int maxIndex = 0;
				while(counter > 0){
					maxIndex = 0;
					for(int i = 1;i <= counter;i++){
						if(array[i] > array[maxIndex]){
							maxIndex = i;
						}
					}
					int temp = array[maxIndex];
					array[maxIndex] = array[counter];
					array[counter] = temp;
					counter--;
				}
		    return array;
		  }

}
