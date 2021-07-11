package mIcrosoft;


// Write a function that reverses a string. The input string is given as an array of characters s.


public class ReverseString {
	
	  public void reverseString(char[] s) {
	        
	        if(s == null || s.length < 2) return;
	        
	        int left = 0;
	        int right = s.length - 1;
	        
	        while(left < right) {
	            char temp = s[left];
	            s[left] = s[right];
	            s[right] = temp;
	            left++;
	            right--;
	        }
	    }

}
