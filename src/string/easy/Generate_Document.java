package string.easy;
import java.util.*;


public class Generate_Document {
	

	  public boolean generateDocument(String characters, String document) {
	    // Write your code here.
			if(document.length() < 1) {
					return true;
			}
			
			HashMap<Character, Integer> charFrequency = new HashMap<>();
			for(int i = 0;i < characters.length();i++) {
					Character character = characters.charAt(i);
					Integer frequency = charFrequency.get(character);
					if(frequency == null) {
							frequency = 0;
					}
					frequency += 1;
					charFrequency.put(character, frequency);
			}
			
			for(int i = 0;i < document.length();i++) {
					Character character = document.charAt(i);
					Integer frequency = charFrequency.get(character);
					if(frequency == null || frequency < 1) {
							return false;
					}
					frequency -= 1;
					charFrequency.put(character, frequency);
			}
			
	    return true;
	  }
	  
	  
	  public boolean generateDocumentWorst(String characters, String document) {
		  for(int idx = 0;idx < document.length();idx++) {
			  	char character = document.charAt(idx);
			  	int documentFrequency = countCharacterFrequency(character, document);
			  	int charactersFrequency = countCharacterFrequency(character, characters);
			  	
			  	if(documentFrequency > charactersFrequency) {
			  		return false;
			  	}
		  }
		  
		  return true;
	  }
	  
	  private int countCharacterFrequency(char character,String target) {
		  	int frequency = 0;
		  	for(int Idx = 0;Idx < target.length();Idx++) {
		  		char c = target.charAt(Idx);
		  		if(c == character) {
		  			frequency++;
		  		}
		  	}
		  	
		  	return frequency;
	 }
	 
	  
	 public boolean generateDocumentBetter(String characters, String document) {
		 Set<Character> alreadyCounted = new HashSet<>();
		 
		 for(int idx = 0;idx < document.length();idx++) {
			 char character = document.charAt(idx);
			 if(alreadyCounted.contains(character)) {
				 continue;
			 }
			 
			 int documentFrequency = countCharacterFrequency(character, document);
			 int charactersFrequency = countCharacterFrequency(character, characters);
			  	
			  	if(documentFrequency > charactersFrequency) {
			  		return false;
			  }
			  	
			 alreadyCounted.add(character);
		 }
		 
		 return true;
	 }
	 

}
