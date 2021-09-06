package dynamic_programming.difficult;
import java.util.*;


public class LongestCommonSubsequence {
	
	
	 public static List<Character> longestCommonSubsequence(String str1, String str2) {
		    // Write your code here.
				List<Character> charList = new ArrayList<>();
				
				if(str1.length() == 0 || str2.length() == 0) return charList;
				
				int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
				
				for(int i = 0; i <= str1.length();i++) {
						matrix[i][0] = 0;			
				}
				for(int i = 0; i <= str2.length();i++) {
								matrix[0][i] = 0;
				}
				
				for(int i = 1;i <= str1.length();i++) {
						for(int j = 1;j <= str2.length();j++) {
									if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
											matrix[i][j] = matrix[i - 1][j - 1] + 1;
									}else {
											matrix[i][j] = Math.max(matrix[i - 1][j],matrix[i][j - 1]);
									}
						}
				}
				
				int i = str1.length();
				int j = str2.length();
				// System.out.println(matrix[i][j]);
				
				while(i > 0 && j > 0) {
					if(matrix[i][j] == matrix[i - 1][j]) {
							i--;
					}else if(matrix[i][j] == matrix[i][j - 1]) {
							j--;
					}else {
							charList.add(0, str1.charAt(i - 1));
							i--; j--;
					}
				}
				return charList;
	}

}
