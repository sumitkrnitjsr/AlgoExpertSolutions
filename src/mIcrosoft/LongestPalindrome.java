package mIcrosoft;


// Manacher's Algorithm


public class LongestPalindrome {
	
	 public String longestPalindrome(String s) {
	        if(s == null || s.length() < 2) return s;
	        
	        String longestPalindrome = s.substring(0,1);
	        
	        for(int i = 1;i < s.length();i++) {
	            int left = i;
	            int right = i;
	            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	                    left--; right++;
	            }
	            right--; left++;
	            int oddlength = Math.max(1, right  - left + 1);
	            if(oddlength > longestPalindrome.length()) {
	                                                // right + 1 to include right character
	                longestPalindrome = s.substring(left, right + 1);
	            }
	            left = i - 1;
	            right = i;
	            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	                    left--; right++;
	            }
	            right--; left++;
	            oddlength = Math.max(1, right  - left + 1);
	            if(oddlength > longestPalindrome.length()) {
	                                                // right + 1 to include right character
	                longestPalindrome = s.substring(left, right + 1);
	            }
	            
	        }
	        
	        return longestPalindrome;   
	    }

}
