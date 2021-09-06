package mIcrosoft.random;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	
	 public int lengthOfLongestSubstring(String s) {
         if(s == null || s.length() < 1) return 0;
         if(s.length() == 1) return 1;
         int currIdx = 0;
         int maxLength = Integer.MIN_VALUE;
         int currLength = 0;
         int firstIdx = 0;
         HashMap<Character, Integer> posMap = new HashMap<>();
         while(currIdx < s.length()) {
             char ch = s.charAt(currIdx);
             Integer pos = posMap.get(ch);
             if(pos == null) {
                 currLength++;
                 posMap.put(new Character(ch), currIdx);
                 currIdx++;
                 continue;
             }
             maxLength = Math.max(maxLength, (currIdx - firstIdx));
             firstIdx = pos.intValue() + 1;
             currLength = currIdx - firstIdx + 1;
             // Forgot to clear characters past duplicate one
             removeChars(pos.intValue(), posMap);
             posMap.remove(new Character(ch));
             // forgot to update the new position of character
             posMap.put(new Character(ch), currIdx);
             currIdx++;
         }
         
         maxLength = Math.max(maxLength, (currIdx - firstIdx));
         
         return maxLength;
 }
 
 private void removeChars(int pos, HashMap<Character, Integer> posMap) {
         posMap.entrySet().removeIf(entry -> (entry.getValue().intValue() <= pos));
 }

 
 public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	}
 
}
