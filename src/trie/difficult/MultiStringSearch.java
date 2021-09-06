package trie.difficult;
import java.util.*;


public class MultiStringSearch {
	
	public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
	    // Write your code here.
			Trie trie = new Trie();
			for(String str: smallStrings) {
					trie.insert(str);
			}
			Set<String> containedStrings = new HashSet<>();
			for(int i = 0;i < bigString.length();i++) {
					findSmallStringsIn(bigString, i, trie, containedStrings);
			}
			
			List<Boolean> result = new ArrayList<>();
			for(String str: smallStrings) {
					result.add(containedStrings.contains(str));
			}
			
	    return result;
	  }
		
		private static void findSmallStringsIn(String str, int startIdx, Trie trie, Set<String> containedStrings) {
				TrieNode currentNode = trie.root;
				for(int i = startIdx; i< str.length();i++) {
						char currentChar = str.charAt(i);
						if(!currentNode.children.containsKey(currentChar)) {
								break;
						}
						currentNode = currentNode.children.get(currentChar);
						if(currentNode.children.containsKey(trie.end)) {
								containedStrings.add(currentNode.word);
						}
				}
		}
	}

	class TrieNode{
		Map<Character, TrieNode> children = new HashMap<>();
		String word;
	}

	 class Trie {
			TrieNode root = new TrieNode();
			char end = '*';
		
			public void insert(String str) {
				TrieNode node = root;
				for(int i = 0;i < str.length();i++) {
						char letter = str.charAt(i);
						if(!node.children.containsKey(letter)) {
								TrieNode newNode = new TrieNode();
								node.children.put(letter, newNode);
						}
						node = node.children.get(letter);
				}
				
				node.children.put(end, null);
				node.word = str;
			}

}
