package recursion.medium;
import java.util.*;

public class Permutations {
	
	 public static List<List<Integer>> getPermutations(List<Integer> array) {
		    // Write your code here.
				List<List<Integer>> permutations = new ArrayList<List<Integer>>();
				if(array.size() < 1) {
						return permutations;
				}
				getPermutationsHelper(array, 0, permutations);
				return permutations;	
		  }
			
			private static void getPermutationsHelper(List<Integer> array,int idx, List<List<Integer>> perm) {
				
					if(idx == array.size()) {
							List<Integer> permutation = new ArrayList<Integer>();
							permutation.addAll(array);
							perm.add(permutation);
							return;
					}
				
					for(int i = idx;i < array.size();i++) {
							swap(array, idx, i);
							getPermutationsHelper(array, idx + 1, perm);
							swap(array, idx, i); // Forgot to put numbers back
					}
			}
			
			private static void swap(List<Integer> array, int i,int j) {
						int temp = array.get(i);
						array.set(i, array.get(j));
						array.set(j, temp);
		}

		public static List<List<Integer>> getPermutationsWorst(List<Integer> array) {
			List<List<Integer>> permutations = new ArrayList<List<Integer>>();
			getPermutations(array, new ArrayList<Integer>(), permutations);
			return permutations;
		}
		
		private static void getPermutations(List<Integer> array, List<Integer> currentPermutation,
				List<List<Integer>> permutations) {
				
				if(array.size() == 0 && currentPermutation.size() > 0) {
					permutations.add(currentPermutation);
				}else {
					for(int i = 0;i < array.size();i++) {
						List<Integer> newArray = new ArrayList<>(array);
						newArray.remove(i);
						List<Integer> newPermutation = new ArrayList<>(currentPermutation);
						newPermutation.add(array.get(i));
						getPermutations(newArray, newPermutation, permutations);
					}
				}
			
		}
}
