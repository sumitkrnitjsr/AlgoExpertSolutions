package arrays.medium;

public class Monotonic_Array {
	
	 public static boolean isMonotonic(int[] array) {
		    // Write your code here.
				if(array.length < 2) {
						return true;
				}
				
				int index = 0;
				while(index < array.length - 1 && array[index] <= array[index + 1]) { index++; }
				if(index == array.length - 1) return true;
				
				index = 0;
				while(index < array.length - 1 && array[index] >= array[index + 1]) index++;
				if(index == array.length - 1) return true;
					
		    return false;
	}
	 
	 
	public static boolean isMonotonic2(int[] array) {
		if(array.length <= 2) return true;
		var direction = array[1] - array[0];
		
		for(int i = 2;i < array.length;i++) {
			if(direction == 0) {
				direction = array[i] - array[i - 1];
				continue;
			}
			
			if(breaksDirection(direction, array[ i -1], array[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private static boolean breaksDirection(int direction, int previous, int current) {
		var difference = current - previous;
		if(direction > 0) return difference < 0;
		return difference > 0;
	}
	
	
	public static boolean isMonotonicBest(int[] array) {
		var isNonDecreasing = true;
		var isNonIncreasing = true;
		
		for(int i = 1;i < array.length;i++) {
			if(array[i] < array[i - 1]) {
				isNonDecreasing = false;
			}
			if(array[i] > array[i - 1]) {
				isNonIncreasing = false;
			}
		}
		
		return isNonIncreasing || isNonDecreasing;
	}
	

}
