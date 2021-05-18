package trie.medium;
import java.util.*;

public class SuffixTrie {
	
	
	  // Do not edit the class below except for the
	  // populateSuffixTrieFrom and contains methods.
	  // Feel free to add new properties and methods
	  // to the class.
	  static class TrieNode {
	    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	  }

	  static class SuffixTries {
	    TrieNode root = new TrieNode();
	    char endSymbol = '*';

	    public SuffixTries(String str) {
	      populateSuffixTrieFrom(str);
	    }

	    public void populateSuffixTrieFrom(String str) {
	      // Write your code here.
				for(int idx = str.length() - 1;idx >= 0;idx--) {
						String substring = str.substring(idx, str.length());
						//System.out.println(substring + " ");
						TrieNode node = root;
						//System.out.println(node.children.keySet());
						for(int j = 0;j < substring.length();j++) {
								char ch = substring.charAt(j);	
								TrieNode child = node.children.get(ch);
								if(child == null) {
										child = new TrieNode();
								}
								node.children.put(new Character(ch), child);
								node = child;
						}
						node.children.put(new Character(endSymbol), null);
				}
	    }
	    
	    public void populateSuffixTrieFrom2(String str) {
	    	for(int i = 0;i < str.length();i++) {
	    		insertSubstringStartingAt(i, str);
	    	}
	    }
	    
	    public void insertSubstringStartingAt(int i, String str) {
	    	TrieNode node = root;
	    	for(int j = i;j < str.length();j++) {
	    		char letter = str.charAt(j);
	    		if(!node.children.containsKey(letter)) {
	    			TrieNode newNode = new TrieNode();
	    			node.children.put(letter, newNode);
	    		}
	    		
	    		node = node.children.get(letter);
	    	}
	    	node.children.put(endSymbol, null);
	    }
	    
	    public boolean contains2(String str) {
	    	TrieNode node = root;
	    	for(int i = 0;i < str.length();i++) {
	    		char letter = str.charAt(i);
	    		if(!node.children.containsKey(letter)) return false;
	    		node = node.children.get(letter);
	    	}
	    	
	    	return node.children.containsKey(endSymbol);
	    }

	    public boolean contains(String str) {
	      // Write your code here.
				TrieNode node = root;
				for(int idx = 0;idx < str.length();idx++) {
							char ch = str.charAt(idx);
							System.out.print(ch + " ");
							node = node.children.get(new Character(ch));
							if(node == null)	return false;
				}
				
				boolean result = node != null 
								&& (node.children.containsKey(new Character(endSymbol)));
	      return result;
	    }
	  }

}
