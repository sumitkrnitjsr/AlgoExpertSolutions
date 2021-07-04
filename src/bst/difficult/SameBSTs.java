package bst.difficult;
import java.util.*;

public class SameBSTs {

	 public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		    // Write your code here.
				if(arrayOne.size() == 0 && arrayTwo.size() == 0) return true;
				// Check for only one in pair with zero size
				if(arrayOne.size() != arrayTwo.size()) return false;
				
				if(arrayOne.get(0) != arrayTwo.get(0)) return false;
				
				List<Integer> listright = new ArrayList<>();
				List<Integer> listleft = new ArrayList<>();
				for(int i = 1;i < arrayOne.size();i++){
						if(arrayOne.get(i) >= arrayOne.get(0)) {
								listright.add(arrayOne.get(i));
						}else {
								listleft.add(arrayOne.get(i));
						}
				}
				
				List<Integer> listright2 = new ArrayList<>();
				List<Integer> listleft2 = new ArrayList<>();
				for(int i = 1;i < arrayTwo.size();i++){
						if(arrayTwo.get(i) >= arrayTwo.get(0)) {
								listright2.add(arrayTwo.get(i));
						}else {
								listleft2.add(arrayTwo.get(i));
						}
				}
				
		    return sameBsts(listright, listright2) && sameBsts(listleft, listleft2);
		  }
	 
	 public static boolean sameBstsBest(List<Integer> arrayOne, List<Integer> arrayTwo) {
		 	return sameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	 }
	 
	 public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo,
			 						int minVal,int maxVal) {
		 
		 if(rootIdxOne == -1 || rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;
		 
		 if(arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) return false;
		 
		 int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
		 int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
		 int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
		 int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);
		 
		 int currentValue = arrayOne.get(rootIdxOne);
		 boolean leftAreSame = sameBsts(arrayOne, arrayTwo,leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
		 boolean rightAreSame = sameBsts(arrayOne, arrayTwo,rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);
		 
		 return leftAreSame && rightAreSame;
	 }
	 
	 
	 public static int getIdxOfFirstSmaller(List<Integer> array,int startingIdx, int minVal) {
		 
		 for(int i = startingIdx + 1;i < array.size();i++) {
			 if(array.get(i) < array.get(startingIdx) && array.get(i) >= minVal) {
				 return i;
			 }
		 }
		 
		 return -1;
	 }
	 
 public static int getIdxOfFirstBiggerOrEqual(List<Integer> array,int startingIdx, int maxVal) {
		 
		 for(int i = startingIdx + 1;i < array.size();i++) {
			 if(array.get(i) >= array.get(startingIdx) && array.get(i) < maxVal) {
				 return i;
			 }
		 }
		 
		 return -1;
	 }
	 
	 
}
