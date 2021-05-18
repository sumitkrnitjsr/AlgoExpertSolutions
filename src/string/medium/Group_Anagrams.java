package string.medium;
import java.util.*;

public class Group_Anagrams {
	
	 public static List<List<String>> groupAnagrams(List<String> words) {
		    // Write your code here.
				HashMap<String, ArrayList<Integer>> strMap = new HashMap<>();
				int idx = 0;
				for(String word:words) {
						char[] array = word.toCharArray();
						Arrays.sort(array);
						String sorted = String.valueOf(array);
					
						ArrayList<Integer> indices = strMap.get(sorted);
						
						if(indices == null) {
								indices = new ArrayList<Integer>();
						}
						indices.add(idx);
						strMap.put(sorted, indices);
						idx++;
				}
				List<List<String>> anagrams = new ArrayList<>();
				for(Map.Entry<String, ArrayList<Integer>> set: strMap.entrySet()) {
						List<Integer> indices = set.getValue();
						ArrayList<String> anagram = new ArrayList<>();
						for(Integer index: indices) {
								anagram.add(words.get(index));
						}
						anagrams.add(anagram);
				}
				
		    return anagrams;
		}
	 
	 public static List<List<String>> groupAnagramsBest(List<String> words) {
		 Map<String, List<String>> anagrams = new HashMap<>();
		 
		 for(String word: words) {
			 char[] charArray = word.toCharArray();
			 Arrays.sort(charArray);
			 String sortedWord = new String(charArray);
			 
			 if(anagrams.containsKey(sortedWord)) {
				 anagrams.get(sortedWord).add(word);
			 } else {
				 anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
			 }
		 }
		 
		 return new ArrayList<>(anagrams.values());
	 }

}
