package string.easy;
import java.util.*;

public class Minimum_Number_Of_Characters {
	
	 public String[] minimumCharactersForWords(String[] words) {
		    // Write your code here.
				HashMap<Character, Integer> charSet = new HashMap<>();
				for(int idx = 0;idx < words.length;idx++) {
					HashMap<Character, Integer> wordSet = new HashMap<>();
				for(int itr = 0;itr < words[idx].length();itr++) {
						char character = words[idx].charAt(itr);
						int charcount = wordSet.get(character) == null ? 0 : wordSet.get(character);
						wordSet.put(character, charcount + 1);
				}
				for(Map.Entry<Character, Integer> keySet: wordSet.entrySet()) {
					int currentCount = charSet.get(keySet.getKey()) == null ? 0 : charSet.get(keySet.getKey());
								if(currentCount < keySet.getValue()) {
										charSet.put(keySet.getKey(), keySet.getValue());
								}
				}	
				
			}
				
				int totalCount  = 0;
				for(Map.Entry<Character, Integer> keySet: charSet.entrySet()) {
					totalCount += keySet.getValue();
				}
				
				String[] characterList = new String[totalCount];
				int idx = 0;
				for(Map.Entry<Character, Integer> keySet: charSet.entrySet()) {
						char character = keySet.getKey();
						for(int i = 0;i < keySet.getValue();i++)
						characterList[idx++] = Character.toString(character);
				}
		    return characterList;
	}
	 
	 public char[] minimumCharactersForWords2(String[] words) {
		 HashMap<Character, Integer> maximumCharacterFrequencies = new HashMap<>();
		 
		 for(String word: words) {
			 HashMap<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
			 updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
		 }
		 
		 return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
	 }
	 
	 public HashMap<Character, Integer> countCharacterFrequencies(String string) {
		 	HashMap<Character, Integer> characterFrequencies = new HashMap<>();
		 	for(char character : string.toCharArray()) {
		 		characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
		 	}
		 	return characterFrequencies;
	 }
	 
	 public void updateMaximumFrequencies(HashMap<Character, Integer> frequencies, HashMap<Character, Integer> maximum) {
		 	for(Map.Entry<Character, Integer> frequency : frequencies.entrySet()) {
		 		char character = frequency.getKey();
		 		int characterFrequency = frequency.getValue();
		 		
		 		if(maximum.containsKey(character)) {
		 			maximum.put(character, Math.max(characterFrequency, Math.max(characterFrequency, maximum.get(character))));
		 		}else {
		 			maximum.put(character, characterFrequency);
		 		}
		 	}
	 }
	 

	 public char[] makeArrayFromCharacterFrequencies(HashMap<Character, Integer> characterFrequencies) {
		 ArrayList<Character> characters = new ArrayList<>();
		 for(Map.Entry<Character, Integer> frequency : characterFrequencies.entrySet()) {
			 	char character = frequency.getKey();
			 	int characterFrequency = frequency.getValue();
			 	
			 	for(int idx = 0;idx < characterFrequency;idx++) {
			 		characters.add(character);
			 	}
		 }
		 
		 char[] charactersArray = new char[characters.size()];
		 
		 for(int idx = 0;idx < characters.size();idx++) {
			 charactersArray[idx] = characters.get(idx);
		 }
		 
		 return charactersArray;
	 }


	 
}
