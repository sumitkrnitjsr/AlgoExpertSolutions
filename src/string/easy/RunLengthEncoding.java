package string.easy;

public class RunLengthEncoding {
	
	 public String runLengthEncoding(String string) {
		    // Write your code here.
		    return runLengthEncoding(string, 0, "");
		  }
			
			private String runLengthEncoding(String str,int idx,String enc) {
					if(idx == str.length()) {
							return enc;
					}
					char ch = str.charAt(idx);
					int currIdx = idx;
					while(currIdx < str.length() && ch == str.charAt(currIdx)) currIdx++;
					int numChar = currIdx - idx; // Wrong calculation int numChar = currIdx - idx + 1;
					String encChar = "";
					while(numChar >= 9) {
									encChar = encChar + "9" + Character.toString(ch);
									numChar -= 9;
					}
					if(numChar > 0) {
						encChar = encChar + Integer.toString(numChar) + Character.toString(ch);
					}
							
					enc = enc + encChar;
							
					return runLengthEncoding(str, currIdx, enc);
					
		}
			
	public String runLengthEncoding2(String string) {
		StringBuilder encodedStringCharacters = new StringBuilder();
		int currentRunLength = 1;
		for(int i = 1;i < string.length();i++) {
			char currentCharacter = string.charAt(i);
			char previousCharacter = string.charAt(i - 1);
			if((currentCharacter != previousCharacter) || (currentRunLength == 9)) {
				encodedStringCharacters.append(Integer.toString(currentRunLength));
				encodedStringCharacters.append(previousCharacter);
				currentRunLength = 0;
			}
			
			currentRunLength += 1;
		}
		
		encodedStringCharacters.append(Integer.toString(currentRunLength));
		encodedStringCharacters.append(string.charAt(string.length() - 1));
		
		return encodedStringCharacters.toString();
	}

}
