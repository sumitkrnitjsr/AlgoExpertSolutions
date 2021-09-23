package dynamic_programming.difficult;
import java.util.*;

public class NumbersInPi {
	
	public static int numbersInPi(String pi, String[] numbers) {
	    // Write your code here.
			HashSet<String> set = new HashSet<>();
			for(String str: numbers) set.add(str);
			HashMap<Integer, Integer> cache = new HashMap<>();
			for(int i = pi.length() - 1;i >= 0;i--) {
					getMinSpace(pi, set, cache, i);
			}
	    return cache.get(0) == Integer.MAX_VALUE ? -1 : cache.get(0);
	  }
		
		private static int getMinSpace(String pi, HashSet<String> set, HashMap<Integer, Integer> cache, int idx) {
				if(idx == pi.length()) return -1;
				if(cache.containsKey(idx)) return cache.get(idx);
				int minSpace = Integer.MAX_VALUE;
				for(int i = idx;i < pi.length();i++) {
						String prefix = pi.substring(idx, i + 1);
						if(set.contains(prefix)) {
								int minSpaceSuffix = getMinSpace(pi, set, cache, i + 1);
								if(minSpaceSuffix == Integer.MAX_VALUE) {
										minSpace = Math.min(minSpace, minSpaceSuffix);
								} else {
										minSpace = Math.min(minSpace, minSpaceSuffix + 1);
								}
						}
				}
				cache.put(idx, minSpace);
				return cache.get(idx);
		}

}
