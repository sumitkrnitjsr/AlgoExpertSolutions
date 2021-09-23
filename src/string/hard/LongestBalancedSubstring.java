package string.hard;

public class LongestBalancedSubstring {
	
	 public int longestBalancedSubstring(String string) {
		    // Write your code here.
				int maxLength = 0;
				int openCount = 0;
				int closeCount = 0;
				for(int i = 0;i < string.length();i++) {
						char c = string.charAt(i);
						if(c == '(')  openCount++;
						else 	closeCount++;
						if(openCount == closeCount) maxLength = Math.max(maxLength, closeCount * 2);
						else if(openCount < closeCount)	{
							openCount = 0;
							closeCount = 0;
						}
		  }
				
			openCount = closeCount = 0;
				for(int  i = string.length() - 1;i > -1;i--) {
						char c = string.charAt(i);
						if(c == '(') openCount++;
						else closeCount++;
						if(openCount == closeCount) maxLength = Math.max(maxLength, openCount * 2);
						else if(closeCount < openCount) {
							openCount = 0;
							closeCount = 0;
						}
				}
										
				return maxLength;
		}

}
