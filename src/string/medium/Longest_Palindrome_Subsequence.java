package string.medium;

public class Longest_Palindrome_Subsequence {
	
	 public static String longestPalindromicSubstring(String str) {
		    // Write your code here.
				if(str.length() == 0) return "";
				
				String longestPalin = Character.toString(str.charAt(0));
				for(int i = 1;i < str.length() - 1;i++) {
						String palin = findPalin(str, i);
						String doublePalin = findPalinDouble(str, i, i + 1);
						String compare = palin.length() > doublePalin.length() ? palin:doublePalin;
						if(longestPalin.length() < compare.length()) {
								longestPalin = compare;
						}
				}
		    return longestPalin;
		  }
			
			private static String findPalin(String str, int idx) {
					int left = idx;
					int right = idx;
					while(left >= 0 && right < str.length()) {
								if(str.charAt(left) == str.charAt(right)) {
										left--;
										right++;
								}else {
										break;
								}
					}
				
				return str.substring(left + 1, right);
			}
			
				private static String findPalinDouble(String str, int leftIdx,int rightIdx) {
					if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
							return "";
					}
					if(leftIdx == 0 || rightIdx == str.length() - 1) {
							return str.substring(leftIdx, rightIdx + 1);
					}
					
					int left = leftIdx;
					int right = rightIdx;
					while(left >= 0 && right < str.length()) {
								if(str.charAt(left) == str.charAt(right)) {
										left--;
										right++;
								}else {
										break;
								}
					}
				
				return str.substring(left + 1, right);
			}
				
			public static String longestPalindromicSubstring2(String str) {
				int[] currentLongest = {0,1};
				for(int i = 1;i < str.length();i++) {
					int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
					int[] even = getLongestPalindromeFrom(str, i - 1, i);
					int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd: even;
					
					currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] 
										? currentLongest
										: longest;
				}
				
				return str.substring(currentLongest[0], currentLongest[1]);
			}
			
			private static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
				while(leftIdx >= 0 && rightIdx < str.length()) {
					if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
						break;
					}
					leftIdx--;
					rightIdx++;
				}
				
				return new int[] {leftIdx + 1, rightIdx};
			}
			
			public static String longestPalindromicSubString(String str) {
					String longest = "";
					
					for(int i = 0;i < str.length();i++) {
						for(int j = i;j < str.length();j++) {
							String substring = str.substring(i, j + 1);
							if(substring.length() > longest.length() && ispalindrome(substring)) {
								longest = substring;
							}
						}
					}
					
					return longest;
			}
			
			private static boolean ispalindrome(String str) {
				int leftIdx = 0;
				int rightIdx = str.length()  - 1;
				while(leftIdx < rightIdx) {
					if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
						return false;
					}
					leftIdx++;
					rightIdx--;
				}
				
				return true;
			}
				

}
