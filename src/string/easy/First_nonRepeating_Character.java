package string.easy;
import java.util.*;


public class First_nonRepeating_Character {
	
	  public int firstNonRepeatingCharacter(String string) {
		    // Write your code here.
				Map<Character, Integer> charSet = new HashMap<>();
				for(int Idx = 0;Idx < string.length();Idx++){
						Character character = string.charAt(Idx);
						charSet.put(character, charSet.getOrDefault(character, 0) + 1);
				}
				
				for(int idx = 0;idx < string.length();idx++) {
						if(charSet.get(string.charAt(idx)) == 1) {
								return idx;
						}
				}
				
		    return -1;
	  }
	  
	  public int firstNonRepeatingCharacterWorst(String string) {
		    // Write your code here.
				for(int idx = 0;idx < string.length();idx++) {
						char ch = string.charAt(idx);
						boolean found = false;
						for(int idx2 = 0;idx2 < string.length();idx2++) {
								if(string.charAt(idx2) == ch && idx != idx2) {
										found = true;
										break;
								}
						}
						if(!found) {
								return idx;
						}
				}
		    return -1;
	}

}
