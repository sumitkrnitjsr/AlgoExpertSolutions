package mIcrosoft;

// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.



public class Valid_Palindrome {
	
	
	 public boolean isPalindrome(String s) {
	        if(s == null || s.length() < 2) return true;
	        
	        int leftIdx = 0;
	        int rightIdx = s.length() - 1;
	        
	        while(leftIdx < rightIdx) {
	            // Ignoring cases as per question
	            char leftChar = Character.toLowerCase(s.charAt(leftIdx));
	            char rightChar = Character.toLowerCase(s.charAt(rightIdx));
	            
	            // Ignoring illegal characters
	            if(!withinRange(leftChar)) {
	                leftIdx++;
	                continue;
	            }
	            if(!withinRange(rightChar)) {
	                rightIdx--;
	                continue;
	            }
	            if(leftChar != rightChar) return false;
	            leftIdx++; rightIdx--;
	        }
	        
	        return true;
	   }
    
    private boolean withinRange(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
    
    public boolean isPalindromeUsingStreams(String s) {
        StringBuilder builder = new StringBuilder();

        s.chars()
            .filter(c -> Character.isLetterOrDigit(c))
            .mapToObj(c -> Character.toLowerCase((char) c))
            .forEach(builder::append);

        return builder.toString().equals(builder.reverse().toString());
      }
    

}
