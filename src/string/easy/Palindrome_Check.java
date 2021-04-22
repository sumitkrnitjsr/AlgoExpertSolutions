package string.easy;

public class Palindrome_Check {
	
	 public static boolean isPalindrome(String str) {
			
			char[] temp = new char[str.length()];
			int length = str.length() - 1;
			for(int i = 0;i < length; i++){
				temp[i] = str.charAt(length - i);
			}
				
			for(int i = 0;i < length;i++){
					if(temp[i] != str.charAt(i)){
						return false;
					}	
			}
			
	    return true;
	  }
	 
	 public static boolean isPalindromeRecursion(String str) {
		   	
			if(str == null || str.length() < 2){
				return true;
			}
			
			if(str.charAt(0) != str.charAt(str.length() - 1)){
				return false;
			}
			
			
	    return isPalindrome(str.substring(1, str.length() - 1));
	  }

	 
	 public static boolean isPalindromeBest(String str) {
		    int start = 0;
				int end = str.length() - 1;
				
				while(start < end){
					if(str.charAt(start) != str.charAt(end)){
						return false;
					}
					start++;
					end--;
				}
		    return true;
		  }
}
