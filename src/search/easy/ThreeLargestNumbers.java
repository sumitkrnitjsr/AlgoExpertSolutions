package search.easy;
import java.util.*;

public class ThreeLargestNumbers {
	
	 public static int[] findThreeLargestNumbers(int[] array) {
		    // Write your code here.
				int[] largestNums = new int[3];
				largestNums[0] = Integer.MIN_VALUE;
				largestNums[1] = Integer.MIN_VALUE;
				largestNums[2] = Integer.MIN_VALUE;
				
				for(int i = 0;i < array.length;i++) {
						if(array[i] >= largestNums[0]) {
								largestNums[2] = largestNums[1];
								largestNums[1] = largestNums[0];
								largestNums[0] = array[i];
						}else if(array[i] >= largestNums[1]) {
								largestNums[2] = largestNums[1];
								largestNums[1] = array[i];
						}	else if(array[i] > largestNums[2]) {
								largestNums[2] = array[i];
						}
				}
				
				Arrays.sort(largestNums);
				
		    return largestNums;
	}
	 
	 public static int[] findThreeLargestNumbers2(int[] array) {
		 	int[] threeLargest = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		 	for(int num:array) {
		 		updateLargest(threeLargest, num);
		 	}
		 	return threeLargest;
	 }
	 
	 private static void updateLargest(int[] threeLargest, int num) {
		 if(num > threeLargest[2]) {
			 shiftAndUpdate(threeLargest, num, 2);
		 }else if(num > threeLargest[1]) {
			 shiftAndUpdate(threeLargest, num, 1);
		 }else if(num > threeLargest[0]) {
			 shiftAndUpdate(threeLargest, num, 0);
		 }
	 }
	 
	 private static void shiftAndUpdate(int[] threeLargest, int num, int index) {
		 for(int i = 0;i <= index;i++) {
			 if(i == index) {
				 threeLargest[i] = num;
			 }else {
				 threeLargest[i] = threeLargest[i + 1];
			 }
			 
		 }
	 }

}
