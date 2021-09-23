package recursion.difficult;
import java.util.*;

public class NonAttackingQueen {
	
	 public int nonAttackingQueens(int n) {
		    // Write your code here.
				HashSet<Integer> blockedColumns = new HashSet<>();
				HashSet<Integer> blockedUDiagonals = new HashSet<>();
				HashSet<Integer> blockedDDiagonals = new HashSet<>();
				return countPlacements(0, blockedColumns, blockedUDiagonals,blockedDDiagonals, n);
		  }
			
			private int countPlacements(int row, HashSet<Integer> blockedColumns, HashSet<Integer> blockedUDiagonals, HashSet<Integer> blockedDDiagonals,int size) {
					if(row == size) return 1;
					int validCount = 0;
					for(int col = 0;col < size;col++) {
							if(isNonAttacking(row, col, blockedColumns, blockedUDiagonals, blockedDDiagonals)) {
									blockedColumns.add(col);
									blockedUDiagonals.add(row + col);
									blockedDDiagonals.add(row - col);
									validCount += countPlacements(row + 1, blockedColumns, blockedUDiagonals,blockedDDiagonals,size);
									blockedColumns.remove(col);
									blockedUDiagonals.remove(row + col);
									blockedDDiagonals.remove(row - col);
							}
					}
				
					return validCount;
			}
			
			private boolean isNonAttacking(int row,int col, HashSet<Integer> blockedColumns, HashSet<Integer> blockedUDiagonals,HashSet<Integer> blockedDDiagonals) {
					if(blockedColumns.contains(col) || blockedDDiagonals.contains(row  - col) || blockedUDiagonals.contains(row + col))
							return false;
						
					return true;
			}

}
