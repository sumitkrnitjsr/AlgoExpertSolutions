package graph.difficult;
import java.util.*;

public class BoggleBoard {
	

	  public static List<String> boggleBoard(char[][] board, String[] words) {
	    // Write your code here.
			ArrayList<Node> trie = new ArrayList<>();
			makeTrie(words, trie);
			HashSet<String> wordsInBoard = new HashSet<>();
			boolean[][] visited = new boolean[board.length][board[0].length];
			// forgot both loops
			for(int i = 0;i < board.length;i++) {
				for(int j = 0;j < board[0].length;j++) 
						traverse(board, visited, trie, wordsInBoard, i, j, "");
			}
			ArrayList<String> finalWords = new ArrayList<>();
	    wordsInBoard.stream().forEach(elem->finalWords.add(elem));
			return finalWords;
	  }
		
		private static void traverse(ArrayList<Node> nodes) {
				if(nodes == null) return;
				for(Node node: nodes) {
						System.out.print(node.ch);
						traverse(node.child);
				}
		}
		
		private static void traverse(char[][] board, boolean[][] visited, ArrayList<Node> trie, HashSet<String> words, int row,int col, String word) {
				
				if(!valid(row, board.length) || !valid(col, board[0].length)) return;
			
				if(visited[row][col]) return;
			
				char ch = board[row][col];
			
				Node child = contains(trie, ch);
				if(child == null) return;
					
				String newWord = word + Character.toString(ch);
				if(containsWord(child.child)) words.add(newWord);
			
				visited[row][col] = true;
				
				traverse(board, visited, child.child, words, row, col + 1, newWord);
				traverse(board, visited, child.child, words, row, col - 1, newWord);
				traverse(board, visited, child.child, words, row + 1, col, newWord);
				traverse(board, visited, child.child, words, row - 1, col, newWord);
				// forgot diagonals
				traverse(board, visited, child.child, words, row - 1, col - 1, newWord);
				traverse(board, visited, child.child, words, row - 1, col + 1, newWord);
				traverse(board, visited, child.child, words, row + 1, col - 1, newWord);
				traverse(board, visited, child.child, words, row + 1, col + 1, newWord);
			
				visited[row][col] = false;
		}
		
		private static boolean containsWord(ArrayList<Node> trie) {
						for(Node node: trie) {
							if(node.ch == '*') {
									return true;
							}
						}
				return false;
		}
		
		private static Node contains(ArrayList<Node> trie, char ch) {
				for(Node node: trie) {
						if(node.ch == ch) return node;
				}
				return null;
		}
		
		private static boolean valid(int rc, int max) {
				return rc >= 0 && rc < max;
		}
		
		private static void makeTrie(String[] words, ArrayList<Node> trie)	 {
				for(String word: words)		{
						addToTrie(word, trie, 0);
				}
		}
		
		private static void addToTrie(String word, ArrayList<Node> trie, int idx) {
				char ch = ' ';
				if(idx == word.length()) {
						ch = '*';
				}else{
						ch = word.charAt(idx);
				}
			
				Node node = contains(trie, ch);			
				if(node == null) {
						node = new Node();
						node.ch = ch;
						if(ch != '*')
							node.child = new ArrayList<Node>();
						trie.add(node);
				}

				if(idx < word.length())
				addToTrie(word, node.child, idx + 1);
			
		}
		
}


class Node {
			char ch;
			ArrayList<Node> child;
}

