package mIcrosoft.random;
import java.util.*;

public class UNiqueCharacterFrequency {
	
	 public int minDeletions(String s) {
	        if(s == null || s.length() < 2) return 0;
	        int[] map = new int[26];
	        for(int i = 0;i < s.length();i++) {
	            map[s.charAt(i) - 'a']++;
	        }
	        Arrays.sort(map);
	        int numDel = 0;
	        
	        for(int i = 24;i >= 0;i--) {
	            // Forgot to handle end character case
	            if(map[i] == 0) break;
	            
	            if(map[i] >= map[i + 1]) {
	                numDel += map[i] - map[i + 1] + 1;
	                map[i] = Math.max(0,map[i + 1] - 1);
	            }
	           
	            if(map[i] == 0) {
	                while(i >= 0) {
	                    numDel += map[i];
	                    i--;
	                }
	            }
	        }
	        
	        return numDel;
	    }

}
