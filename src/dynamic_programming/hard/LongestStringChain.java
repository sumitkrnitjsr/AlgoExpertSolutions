package dynamic_programming.hard;
import java.util.*;

public class LongestStringChain {
	
	static class Chain{
		String nextString;
		Integer maxLength;
		Chain(String next, Integer length) {
			nextString = next;
			maxLength = length;
		}
}

public static List<String> longestStringChain(List<String> strings) {
// Write your code here.
	List<String> sortedString = new ArrayList<>(strings);
	sortedString.sort((a,b) -> a.length() - b.length());
	
	Map<String, Chain> stringChain = new HashMap<>();
	for(String string: sortedString) 
			stringChain.put(string, new Chain("",1));
	
	for(String string: sortedString) 
			for(int i = 0;i < string.length();i++) {
					String smallerString = string.substring(0, i) + string.substring(i + 1);
					if(!stringChain.containsKey(smallerString)) continue;
					if(stringChain.get(smallerString).maxLength + 1 > 
							stringChain.get(string).maxLength){
							stringChain.get(string).maxLength = stringChain.get(smallerString).maxLength + 1;
							stringChain.get(string).nextString = smallerString;
					}
			}
	
	int maxLength = 0;
	String startString = "";
	for(String string: strings) 
			if(stringChain.get(string).maxLength > maxLength) {
					maxLength = stringChain.get(string).maxLength;
					startString = string;
			}
	
	List<String> longestChain = new ArrayList<String>();
	String currentString = startString;
	while(currentString != "") {
			longestChain.add(currentString);
			currentString = stringChain.get(currentString).nextString;
	}
		
return longestChain.size() == 1 ? new ArrayList<String>() : longestChain;
}

}
