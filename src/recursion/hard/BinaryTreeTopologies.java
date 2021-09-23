package recursion.hard;
import java.util.*;


public class BinaryTreeTopologies {
	
	 public static int numberOfBinaryTreeTopologies(int n) {
		    // Write your code here.
				HashMap<Integer, Integer> countMap = new HashMap<>();
				countMap.put(0, 1);countMap.put(1, 1);
		    return countNum(n, countMap);
		  }
			
			private static int countNum(int n, HashMap<Integer, Integer> map) {
					if(map.containsKey(n)) return map.get(n);
					int sum = 0;
					for(int i = 0;i < n;i++) {
							sum += (countNum(i, map) * countNum(n - i - 1, map));
					}
					map.put(n, sum);
					return sum;
			}
			
			
		public static int numberOfBinaryTreeTopologiesBest(int n) {
				List<Integer> cache = new ArrayList<>();
				cache.add(1);
				for(int m = 1;m < n + 1; m++) {
					int numberOfTrees = 0;
					for(int leftTreeSize = 0;leftTreeSize < m;leftTreeSize++) {
						int rightTreeSize = m - 1 - leftTreeSize;
						int numberOfLeftTree = cache.get(leftTreeSize);
						int numberOfRightTree = cache.get(rightTreeSize);
						numberOfTrees += numberOfLeftTree * numberOfRightTree;
					}
					cache.add(numberOfTrees);
				}
				return cache.get(n);
		}

}
