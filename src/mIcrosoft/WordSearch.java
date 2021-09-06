package mIcrosoft;

public class WordSearch {
	
	  public List<String> findWords(char[][] board, String[] words) {
	        
	        if(words.length == 0 || board.length == 0)
	            return new ArrayList<String>();
	        List<String> containedWords = new ArrayList<>();
	        for(String word: words) {
	            boolean[][] visited = new boolean[board.length][board[0].length];
	            boolean found = false;
	            // Handle multiple starting cells
	            for(int i = 0;i < board.length;i++) {
	                for(int j = 0;j < board[0].length;j++) {
	                    if(board[i][j] == word.charAt(0)
	                        && findWord(board, word, i, j, board.length, board[0].length, 0, visited)) {
	                containedWords.add(word);
	                        found = true;
	                 break;       
	            }        
	                }
	                if(found) break;
	            }
	            
	        }
	        return containedWords;
	    }
	    
	    private boolean findWord(char[][] board, String word,int row, int col,int n,int m,int idx, boolean[][] visited) {
	        if(idx == word.length()) return true;
	        // Handle negative row col values
	        if(row >= n || col >= m || row < 0 || col < 0) return false;
	        if(visited[row][col]) return false;
	        if(word.charAt(idx) != board[row][col]) return false;
	        visited[row][col] = true;
	        idx++;
	        boolean result = (findWord(board, word, row, col + 1, board.length, board[0].length, idx, visited)) || 
	            (findWord(board, word, row, col - 1, board.length, board[0].length, idx, visited)) || 
	            (findWord(board, word, row + 1, col, board.length, board[0].length, idx, visited)) || 
	            (findWord(board, word, row - 1, col, board.length, board[0].length, idx, visited));
	        visited[row][col] = false;
	        
	        return result;
	    }

}
