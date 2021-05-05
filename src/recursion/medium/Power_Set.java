package recursion.medium;
import java.util.*;


public class Power_Set {
	
	 public static List<List<Integer>> powerset(List<Integer> array) {
		    // Write your code here.
		   	return powerSet(array, 0);
		  }
			
			public static List<List<Integer>> powerSet(List<Integer> array, int index) {
				if(index == array.size()) {
						List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
						ArrayList<Integer> smallestSet = new ArrayList<Integer>();
						powerSet.add(smallestSet);
						return powerSet;
				}
				List<List<Integer>> subSet = powerSet(array, index + 1);
				List<List<Integer>> fullSet = new ArrayList<List<Integer>>();
				fullSet.addAll(subSet);
				for(List<Integer> set: subSet) {
						ArrayList<Integer> newSet = new ArrayList<Integer>();
						newSet.add(array.get(index));
						newSet.addAll(set);
						fullSet.add(newSet);
				}
				
				return fullSet;
	}

}
