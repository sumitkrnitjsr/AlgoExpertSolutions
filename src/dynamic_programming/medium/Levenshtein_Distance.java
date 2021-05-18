package dynamic_programming.medium;

public class Levenshtein_Distance {
	
	 public static int levenshteinDistance(String str1, String str2) {
		    // Write your code here.
				if(str1 == null || str1.length() == 0) return str2.length();
				
				if(str2 == null || str2.length() == 0) return str1.length();
				
				int substituteLength =  levenshteinDistance(str1.substring(1), str2.substring(1));
				
				if(str1.charAt(0) == str2.charAt(0)) return substituteLength;
				
		    return Math.min(substituteLength,Math.min(levenshteinDistance(str1, str2.substring(1)),
											 levenshteinDistance(str1.substring(1), str2))) + 1;
	 }
	 
	 private int levenshteinDistanceBetter(String str1, String str2) {
		 int[][] edits = new int[str2.length() + 1][str1.length() + 1];
		 for(int i = 0;i < str2.length() + 1;i++)  {
			 for(int j = 0;j < str1.length() + 1;j++) {
				 	edits[i][j] = j;
			 }
			 edits[i][0] = i;
		 }
		 
		 for(int i = 1;i < str2.length() + 1;i++) {
			 for(int j = 1;j < str1.length() + 1;j++) {
				 if(str1.charAt(j - 1) == str2.charAt(i - 1)) {
					 edits[i][j] = edits[i - 1][j - 1];
				 }else {
					 edits[i][j] = Math.min(edits[i - 1][j - 1], Math.min(edits[i-1][j], edits[i][j - 1])) + 1;
				 }
			 }
		 }
		 
		 return edits[str2.length()][str1.length()];
	 }
	 
	 private int levenshteinDistanceBest(String str1, String str2) {
		 String small = str1.length() < str2.length() ? str1 : str2;
		 String big = str1.length() >= str2.length() ? str1 : str2;
		 
		 int[] evenEdits = new int[small.length() + 1];
		 int[] oddEdits = new int[small.length() + 1];
		 
		 for(int j = 0;j < small.length();j++) {
			 evenEdits[j] = j;
		 }
		 
		 int[] currentEdits;
		 int[] previousEdits;
		 
		 for(int i = 1;i < big.length() + 1;i++) {
			 if(i % 2 == 1) {
				 currentEdits = oddEdits;
				 previousEdits = evenEdits;
			 }else {
				 currentEdits = evenEdits;
				 previousEdits = oddEdits;
			 }
			 
			 for(int j = 1;j < small.length() + 1;j++) {
				 if(big.charAt(i - 1) == small.charAt(j - 1)) {
					 currentEdits[j] = previousEdits[j - 1];
				 }else {
					 currentEdits[j] = 1 + Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j - 1]));
				 }
			 }
		 }
		 
		 return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
	 }

}
