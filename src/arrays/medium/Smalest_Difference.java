package arrays.medium;
import java.util.*;


public class Smalest_Difference {
	
	 public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		    // Write your code here.
				int[] result = new int[2];
				Arrays.sort(arrayOne);
				Arrays.sort(arrayTwo);
				int indexOne = 0;
				int indexTwo = 0;
				int minDiff = Integer.MAX_VALUE;
				while(indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
							int currentDiff = Math.abs(arrayOne[indexOne] - arrayTwo[indexTwo]);
							if(currentDiff < minDiff) {
									minDiff = currentDiff;
									result[0] = arrayOne[indexOne];
									result[1] = arrayTwo[indexTwo];
									if(minDiff == 0) {
											return result;
									}
							}else {
									if(arrayOne[indexOne] < arrayTwo[indexTwo]) {
											indexOne++;
									}else {
											indexTwo++;
									}
							}
				}
				
				return result;
	}
	 
	public static int[] smallestDifference2(int[] arrayOne,int[] arrayTwo) {
				Arrays.sort(arrayOne);
				Arrays.sort(arrayTwo);
				int IdxOne = 0;
				int IdxTwo = 0;
				int smallest = Integer.MAX_VALUE;
				int current = Integer.MAX_VALUE;
				int[] smallestPair = new int[2];
				
				while(IdxOne < arrayOne.length && IdxTwo < arrayTwo.length) {
					int firstNum = arrayOne[IdxOne];
					int secondNum = arrayTwo[IdxTwo];
					if(firstNum < secondNum) {
						current = secondNum - firstNum;
						IdxOne++;
					}else if(secondNum < firstNum) {
						current = firstNum - secondNum;
						IdxTwo++;
					}else {
						return new int[] {firstNum, secondNum};
					}
					if(smallest > current) {
						smallest = current;
						smallestPair = new int[] {firstNum, secondNum};
					}
				}
				
				return smallestPair;
				
	}

}
