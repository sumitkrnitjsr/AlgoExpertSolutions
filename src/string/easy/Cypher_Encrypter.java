package string.easy;

public class Cypher_Encrypter {
	
	 public static String caesarCypherEncryptor(String str, int key) {
	    	
			StringBuilder stringBuilder = new StringBuilder("");
			for(int i = 0;i < str.length();i++){
					char ch = str.charAt(i);
					int position = ch - 'a';
					position = (position + key)%26;
					ch = (char)('a' + position);
					stringBuilder.append(Character.toString(ch));
			}	
			
	    return stringBuilder.toString();
	  }

	 
	 public static String caesarCypherEncryptorBest(String str, int key) {
		 char[] result = new char[str.length()];
		 int newKey = key%26;
		 String alphabet = "abcdefghijklmnopqrstuvwxyz";
		 for(int i = 0;i < str.length();i++) {
			 result[i] = getNewLetter(str.charAt(i), newKey, alphabet);
		 }
		 return new String(result);
	 }
	 
	 private static char getNewLetter(char ch, int newKey, String alphabet) {
		 int newLetterCode = alphabet.indexOf(ch) + newKey;
		 return alphabet.charAt(newLetterCode % 26);
	 }
}
