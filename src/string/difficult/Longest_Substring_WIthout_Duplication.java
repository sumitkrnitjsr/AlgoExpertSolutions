package string.difficult;
import java.util.*;

public class Longest_Substring_WIthout_Duplication {
	
	 public static String longestSubstringWithoutDuplication(String str) {
		    // Write your code here
				if(str.length() == 0) return "";
				
				HashMap<Character, Integer> charMap = new HashMap<>();
				int maxStart = 0;
				int maxEnd = 1;
				int startIdx = 0;
				// Forgot to update first index 
				charMap.put(str.charAt(0), 0);
				int endIdx = 1;
				while(endIdx < str.length()) {
						int maxLength = maxEnd - maxStart;
						char ch = str.charAt(endIdx);
						while(endIdx < str.length() && charMap.get(str.charAt(endIdx)) == null) {
									charMap.put(str.charAt(endIdx), endIdx);
									endIdx++;
						}
						int length = endIdx - startIdx;
						if(length > maxLength) {
								maxStart = startIdx;
								maxEnd = endIdx;
						}
						if(endIdx != str.length()) {
								int duplicatePos = charMap.get(str.charAt(endIdx));
								//Forgot to remove all middle characters
								while(startIdx <= duplicatePos) {
											charMap.remove(str.charAt(startIdx));
											startIdx++;	
								}
								
								charMap.remove(str.charAt(endIdx));
						}
						
				}
		    
				
				return str.substring(maxStart, maxEnd);
		  }
	 
	 public static String longestSubstringWithoutDuplicattionBest(String str) {
		 		Map<Character, Integer> lastSeen = new HashMap<>();
		 		int[] longest = {0,1};
		 		int startIdx = 0;
		 		
		 		for(int i = 0;i < str.length();i++) {
		 			char c = str.charAt(i);
		 			if(lastSeen.containsKey(c)) {
		 				startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
		 			}
		 			if(longest[1] - longest[0] < i + 1 - startIdx) {
		 				longest = new int[] {startIdx, i + 1};
		 			}
		 			lastSeen.put(c, i);
		 		}
		 		
		 		return str.substring(longest[0], longest[1]);
	 }

}
