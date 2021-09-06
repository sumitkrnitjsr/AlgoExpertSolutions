package sorting.difficult;
import java.util.*;

public class RadixSortDuplicate {
	
	 public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
		    // Write your code here.
				if(array.size() < 2) return array;
				int maxNumber = Collections.max(array);
				int digit = 0;
				
				while((maxNumber / Math.pow(10, digit)) > 0) {
							countSort(array, digit);
							digit++;
				}
				
				return array;
		  }
			
			public void countSort(ArrayList<Integer> array, int digit) {
					int[] sortedArray = new int[array.size()];
					int[] countArray = new int[10];
				
					int digitColumn = (int) Math.pow(10, digit);
					for(int num : array) {
							int countIndex = (num / digitColumn) % 10;
							countArray[countIndex]++;
					}
				
					for(int idx = 1;idx < 10;idx++) {
							countArray[idx] += countArray[idx - 1];		
					}
				
					for(int idx = array.size() - 1;idx > -1;idx--) {
							int countIndex = ( array.get(idx) / digitColumn ) % 10;
							countArray[countIndex]--;
							int sortedIndex = countArray[countIndex];
							sortedArray[sortedIndex] = array.get(idx);
					}
				
					for(int idx = 0;idx < array.size(); idx++) {
							array.set(idx, sortedArray[idx]);
					}
			}

}
