package mIcrosoft.random;
import java.util.*;

public class Trie {
	
	  ArrayList<Node> root = new ArrayList<>(26);
	    
	    /** Initialize your data structure here. */
	    public Trie() {
	        for(int i = 0;i < 26;i++){
	            root.add(null);
	        }
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        
	        insert(word, root, 0);
	    }
	    
	    private void insert(String word, ArrayList<Node> root, int idx) {
	        Node node = new Node();
	        node.ch = word.charAt(idx);
	        node.isEnd = idx == word.length() - 1;
	        int rootIdx = node.ch - 'a';
	        if(root.get(rootIdx) == null)
	            root.set(rootIdx, node);
	        else if (node.isEnd)
	            root.get(rootIdx).isEnd = true;
	        
	        if(idx != word.length() - 1) insert(word, root.get(rootIdx).child, idx + 1);
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        
	        return search(word, root, 0);
	    }
	    
	    private boolean search(String word, ArrayList<Node> root, int idx) {
	            int chIdx = word.charAt(idx) - 'a';
	        
	            if(idx == word.length() - 1) {
	                    return root.get(chIdx) != null && root.get(chIdx).isEnd;
	            }
	            if(root.get(chIdx) == null) return false;
	            return search(word, root.get(chIdx).child, idx + 1);
	        
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        
	        return prefix(prefix, root, 0);
	    }
	    
	     private boolean prefix(String word, ArrayList<Node> root, int idx) {
	            int chIdx = word.charAt(idx) - 'a';
	        
	            if(idx == word.length() - 1) {
	                    return root.get(chIdx) != null;
	            }
	         
	            
	            if(root.get(chIdx) == null) return false;
	            
	            return prefix(word, root.get(chIdx).child, idx + 1);
	        
	    }

}
