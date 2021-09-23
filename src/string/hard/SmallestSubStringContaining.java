package string.hard;
import java.util.*;

public class SmallestSubStringContaining {
	
	 public static String smallestSubstringContaining(String bigString, String smallString) {
		    // Write your code here.
				HashMap<Character, Integer> countMap = new HashMap<>();
				ArrayList<Integer> bounds = new ArrayList<>(Arrays.asList(0, Integer.MAX_VALUE));
				for(int i = 0;i < smallString.length();i++) 
						countMap.put(smallString.charAt(i), countMap.getOrDefault(smallString.charAt(i), 0) + 1);
				
				int charsDone = 0;
				int leftIdx = 0;
				int rightIdx = 0;
				HashMap<Character, Integer> countMapSub = new HashMap<>();
				while(rightIdx < bigString.length()) {
							if(!countMap.containsKey(bigString.charAt(rightIdx))){
									rightIdx++; continue;
							}
							countMapSub.put(bigString.charAt(rightIdx), countMapSub.getOrDefault(bigString.charAt(rightIdx), 0) + 1);
							if(countMapSub.get(bigString.charAt(rightIdx)) == countMap.get(bigString.charAt(rightIdx)))
									charsDone++;
							while(charsDone == countMap.size() && leftIdx <= rightIdx) {
										bounds = (rightIdx - leftIdx) < (bounds.get(1) - bounds.get(0)) ? 
															new ArrayList<Integer>(Arrays.asList(leftIdx, rightIdx)):
															bounds;
										if(!countMap.containsKey(bigString.charAt(leftIdx))) {
												leftIdx++; continue;
										}
										if(countMapSub.get(bigString.charAt(leftIdx)).equals(countMap.get(bigString.charAt(leftIdx)))) {
												charsDone--;
										}
										countMapSub.put(bigString.charAt(leftIdx), countMapSub.getOrDefault(bigString.charAt(leftIdx), 1) - 1);
										leftIdx++;
							}
							rightIdx++;
				}
					
				
		    return bounds.get(1) == Integer.MAX_VALUE ? "" : bigString.substring(bounds.get(0), bounds.get(1) + 1);
		  }

}
