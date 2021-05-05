package arrays.easy;
import java.util.*;

public class Non_Constructible_Change {
	
	 public int nonConstructibleChange(int[] coins) {
		    // Write your code here.
				HashSet<Integer> allSums = new HashSet<>();
				allSums.add(new Integer(0));
				addAllSums(coins, allSums, 0);
				for(int i = 1;;i++) {
						if(!allSums.contains(i)) {
								return i;
						}
				}
				
		    //return -1;
		  }
			
		private static void addAllSums(int[] coins, HashSet<Integer> allSums, int index) {
						if(index == coins.length){
								return;
						}		
						HashSet<Integer> currentElementIncluded = new HashSet<>();
						for(Integer sum:allSums) {
								currentElementIncluded.add(sum + coins[index]);
						}
						allSums.addAll(currentElementIncluded);
						addAllSums(coins, allSums, index + 1); // not index++
		}
		
		 public int nonConstructibleChangeBest(int[] coins) {
			    // Write your code here.
					Arrays.sort(coins);
					int currentChange = 0;
					for(int i = 0;i < coins.length;i++) {
							if(coins[i] <= currentChange + 1){
									currentChange += coins[i];
							}else {
									return currentChange + 1;
							}
					}
			    return currentChange + 1;
			  }

}
