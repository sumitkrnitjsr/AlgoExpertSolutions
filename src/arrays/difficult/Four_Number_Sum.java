package arrays.difficult;
import java.util.*;


public class Four_Number_Sum {
	
	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
	    // Write your code here.
			ArrayList<Integer[]> quadrupleList = new ArrayList<Integer[]>();
			
			for(int i = 0;i < array.length;i++) {
				for(int j = i + 1;j < array.length;j++) {
					for(int k = j + 1;k < array.length;k++) {
						for(int l = k + 1;l < array.length;l++) {
								if(array[i] + array[j] + array[k] + array[l] == targetSum) {
											Integer[] quadruple = new Integer[]{array[i], array[j], array[k], array[l]};
											quadrupleList.add(quadruple);
								}
						}
					}
				}
			}
	    return quadrupleList;
	 }
	

}
