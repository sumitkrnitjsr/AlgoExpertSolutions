package arrays.easy;
import java.util.*;

// // No need to think about IntegerOverflow, Think about Square of Negative and Positive Numbers
// Need to visualize the number distribution that the larger will be at extremes and minimum will be at the center

public class Sorted_Square_Array {
	
	 public int[] sortedSquaredArray(int[] array) {
		    int[] result = new int[array.length];
				for(int i = 0;i < result.length;i++){
					result[i] = array[i] * array[i];
				}
				Arrays.sort(result);
		    return result;
	}
	 
	 
	 public int[] sortedSquareArrayBest(int[] array) {
		 int[] result = new int[array.length];
		 int smallIndex = 0;
		 int largeIndex = array.length - 1;
		 for(int i = array.length - 1; i >= 0;i--) {
			 int small = array[smallIndex];
			 int large = array[largeIndex];
			 if(Math.abs(small) > Math.abs(large)) {
				 result[i] = small * small;
				 smallIndex++;
			 }else {
				 result[i] = large * large;
				 large--;
			 }
		 }
		 
		 return result;
	 }
	 
	 
	 public int[] squareHelper(int[] array){
			for(int i = 0;i < array.length;i++){
				array[i] = array[i] * array[i];
			}
			return array;
	}
	 
		
	public void reverseNegativeHelper(int[] array,int start,int end){ // Forgot to reverse negative numbers
				
			while(start < end){
					int temp = array[start];
					array[start] = array[end] * -1;
					array[end] = temp * -1;
					start++;
					end--;
				}
	}
	
		
	 public int[] sortedSquaredArrayBest(int[] array) {
				int index = 0;
				while(index < array.length && array[index] < 0){ // ArrayIndexOutOfBound
					index++;
				}
			
				if(index == 0){
						return squareHelper(array);
				}
			
				index--;
			
				reverseNegativeHelper(array, 0, index);
			
				if(index == array.length - 1){
					return squareHelper(array);
				}
			
				int tempIndex = 0;
				int[] result = new int[array.length];
				int firstIndex = 0;
				int secondIndex = index + 1;
			
				while(firstIndex <= index && secondIndex < array.length){
					if(array[firstIndex] < array[secondIndex]){
							result[tempIndex] = array[firstIndex];
							firstIndex++;
					}else{
						result[tempIndex] = array[secondIndex];
						secondIndex++;
					}
					tempIndex++;
				}
			
				while(firstIndex <= index){
							result[tempIndex] = array[firstIndex];
							firstIndex++;
							tempIndex++;
				}
			
			while(secondIndex < array.length){
							result[tempIndex] = array[secondIndex];
							secondIndex++;
							tempIndex++;
				}
				
				return squareHelper(result);
	  
	  }

}
