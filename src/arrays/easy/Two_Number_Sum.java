package arrays.easy;
import java.util.*;

/*

Notes : import java.util.HashSet; is better as get() method will be O(1) and not O(n) in worst case
https://www.tutorialspoint.com/difference-between-arraylist-and-hashset-in-java#:~:text=ArrayList%20maintains%20the%20insertion%20order,doesn't%20maintain%20any%20order.&text=ArrayList%20allows%20duplicate%20values%20in,are%20not%20allowed%20in%20Hashset.
https://www.geeksforgeeks.org/difference-between-arraylist-and-hashset-in-java/
https://stackoverflow.com/questions/17985029/hashset-vs-arraylist
Whenever the bottleneck is searching same things again & again, hashing can make things faster
*/

public class Two_Number_Sum {
	
	public static int[] twoNumberSum(int[] array, int targetSum) {
	    // Write your code here.
			ArrayList<Integer> list = new ArrayList<>();
			list.add(array[0]);
			for(int i = 1;i < array.length;i++){
					int difference = targetSum - array[i];
					if(list.contains(difference)){
						int[] result = new int[2];
						result[0] = array[i];
						result[1] = difference;
						return result;
					}
				list.add(array[i]); // Forgot to add elements to the list
			}
	    return new int[0];
	  }

	
	
	 public static int[] twoNumberSumWorst(int[] array, int targetSum) {
		    // Write your code here.
				int index = 0;
				for(int i = 0;i < array.length - 1;i++){
						for(int j = i+1;j < array.length;j++){
							if(array[i] + array[j] == targetSum){
								int[] result = new int[2];
								result[0] = array[i];
								result[1] = array[j];
								return result;
							}
						}
				}
		    return new int[0];
		  }
	 
	 
	 public static int[] twoNumberSumAverage(int[] array, int targetSum) {
		    // Write your code here.
				Arrays.sort(array); // Do  not use Collections
				int left = 0;
				int right = array.length - 1;
				while(left < right){
					if(array[left] + array[right] == targetSum){
						 int[] result = {array[left], array[right]};
						return result;
					}else if(array[left] + array[right] < targetSum){
						left++;
					}else if(array[left] + array[right] > targetSum){
						right--;
					}
				}
		    return new int[0];
		  }

}
