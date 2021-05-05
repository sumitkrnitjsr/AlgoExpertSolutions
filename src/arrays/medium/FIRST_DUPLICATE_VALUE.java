package arrays.medium;
import java.util.*;

public class FIRST_DUPLICATE_VALUE {
	
	public int firstDuplicateValue(int[] array) {
	    // Write your code here.
			int duplicateIndex = -1;
			for(int i = 0;i < array.length;i++) {
					for(int j = i + 1;j < array.length;j++) {
							if(array[i] == array[j]) {
									if(duplicateIndex == -1) {
											duplicateIndex = j;
									}else {
											if(j < duplicateIndex) {
													duplicateIndex = j;
											}
									}
							}
					}
					
					if(i == duplicateIndex)	{ // Misplaced this inside J LOOP
							return array[duplicateIndex];
					}
			}
	    return -1;
	}
	
	
	public int firstDuplicateValue2(int[] array) {
			
			int minSecondIndex = array.length;
			
			for(int i = 0;i < array.length;i++) {
				int value = array[i];
			for(int j = i + 1;j < array.length;j++) {
				int valueToCompare = array[j];
				if(value == valueToCompare) {
					minSecondIndex = Math.min(minSecondIndex, j);
				}
			}
			}
			
			if(minSecondIndex == array.length) {
				return -1;
			}
			
			return array[minSecondIndex];
			
 	}
	
	
	public int firstDuplicateValueBetter(int[] array) {
			
			HashSet<Integer> seen = new HashSet<>();
			for(int value: array) {
				if(seen.contains(value)) return value;
				seen.add(value);
			}
			
			return -1;
	}
	
	
	 public int firstDuplicateValueBest(int[] array) {
		    // Write your code here.
				for(int i = 0;i < array.length;i++) {
						int absValue = Math.abs(array[i]);
					
						if(array[absValue - 1] < 0) {
								return absValue;
						}
					
						array[absValue - 1] *= -1;
				}
				
		    return -1;
	}

}
