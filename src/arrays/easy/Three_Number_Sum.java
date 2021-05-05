package arrays.easy;
import java.util.*;

public class Three_Number_Sum {
	
	 public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		    // Write your code here.
				Arrays.sort(array);
				ArrayList<Integer[]> threeNumberSumList = new ArrayList<Integer[]>();
				for(int i = 0;i < array.length;i++) {
					for(int j = i + 1;j < array.length;j++) {
						for(int k = j + 1;k < array.length;k++) {
							if(array[i] + array[j] + array[k] == targetSum) {
								Integer[] numbers = new Integer[3];
								numbers[0] = array[i]; numbers[1] = array[j]; numbers[2] = array[k];
								threeNumberSumList.add(numbers);
							}
						}
					}
				}
		    return threeNumberSumList;
	}
	 
	  public static List<Integer[]> threeNumberSumBest(int[] array, int targetSum) {
		    // Write your code here.
				ArrayList<Integer[]> threeNumberSumList = new ArrayList<Integer[]>();
				Arrays.sort(array);
				for(int i = 0;i < array.length - 2;i++) {
						int currentNumber = array[i];
						int sumRequired = targetSum - currentNumber;
						int left = i + 1;
						int right = array.length - 1;
			
						while(left < right) {
							int sum = array[right] + array[left];
							if(sum == sumRequired){
								Integer[] list = new Integer[3];
								list[0] = array[i]; list[1] = array[left]; list[2] = array[right];
								threeNumberSumList.add(list);
								left++;
								right--;
							}
							if(sum < sumRequired){
									left++;
							}else{
									right--;
							}
						}
					
				}
		    return threeNumberSumList;
		  }

}
