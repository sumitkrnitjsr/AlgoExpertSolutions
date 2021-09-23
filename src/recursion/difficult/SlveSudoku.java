package recursion.difficult;
import java.util.*;

public class SlveSudoku {
	
	 public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
		    // Write your code here.
				solve(0, 0, board);
		    return board;
		  }
			
			public boolean solve(int row, int col, ArrayList<ArrayList<Integer>> board) {	
				int currentRow = row;
				int currentCol = col;
				
				if(currentCol == board.get(currentRow).size()) {
						currentRow++;
						currentCol = 0;
						if(currentRow == board.size()) {
								return true;
						}
				}
				
				if(board.get(currentRow).get(currentCol) == 0) {
						return tryDigitsAtPosition(currentRow, currentCol, board);
				}
				
				return solve(currentRow, currentCol + 1, board);
			
			}
			
			private boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
					for(int digit = 1;digit < 10;digit++) {
							if(isValidAtPosition(digit, row, col, board)) {
									board.get(row).set(col, digit);
									if(solve(row, col + 1, board)) {
										return true;
									}
							}
					}
				
					board.get(row).set(col, 0);
					return false;
			}
			
			public boolean isValidAtPosition(int val, int row, int col, ArrayList<ArrayList<Integer>> board) {
					boolean isRowValid = !board.get(row).contains(val);
					boolean isColValid = true;
				
					for(int r = 0;r < board.size();r++) {
							if(board.get(r).get(col) == val) return false;
					}
					if(!isRowValid || !isColValid) return false;
					int subgridRow = (row / 3) * 3;
					int subgridCol = (col / 3) * 3;
					for(int rowIdx = 0;rowIdx < 3;rowIdx++) {
							for(int colIdx = 0;colIdx < 3;colIdx++) {
									int rowToCheck = subgridRow + rowIdx;
									int colToCheck = subgridCol + colIdx;
									int existingValue = board.get(rowToCheck).get(colToCheck);
								
									if(existingValue == val) return false;
							}
					}
				
					return true;
			}

}
