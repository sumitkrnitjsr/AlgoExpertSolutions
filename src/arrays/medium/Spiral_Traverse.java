package arrays.medium;
import java.util.*;


public class Spiral_Traverse {
	
	 public static List<Integer> spiralTraverse(int[][] array) {
		    // Write your code here.
				ArrayList<Integer> spiralArray = new ArrayList<Integer>();
				int rowStart, rowEnd, colStart, colEnd;
				rowStart = 0;
				rowEnd = array.length - 1;
				colStart = 0;
				colEnd = array[0].length - 1;
				
				while(rowStart <= rowEnd && colStart <= colEnd) {
							for(int i = colStart;i <= colEnd;i++) {
									spiralArray.add(array[rowStart][i]);
							}
							for(int i = rowStart + 1;i <= rowEnd;i++) {
									spiralArray.add(array[i][colEnd]);
							}
					
							if(rowStart != rowEnd) {
									for(int i = colEnd - 1;i >= colStart;i--) {
											spiralArray.add(array[rowEnd][i]);
									}
							}
					
							if(colStart != colEnd) {
									for(int i = rowEnd - 1;i > rowStart;i--) {
											spiralArray.add(array[i][colStart]);
									}
							}
							
							rowStart++; rowEnd--;
							colStart++; colEnd--;
				}
				
				
		    return spiralArray;
	}
	 
	 
	public static List<Integer> spiralTraverseRecursive(int[][] array) {
			if(array.length == 0) return new ArrayList<Integer> ();
			
			var result = new ArrayList<Integer>();
			spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
			return result;
	}
	
	private static void spiralFill(int[][] array, int startRow,int endRow, int startCol,int endCol, ArrayList<Integer> result) {
			if(startRow > endRow || startCol > endCol) {
				return;
			}
			
			for(int col = startCol;col <= endCol;col++) {
				result.add(array[startCol][endCol]);
			}
			
			for(int row = startRow + 1;row <= endRow;row++) {
				result.add(array[row][endCol]);
			}
			
			for(int col = endCol - 1;col >= startCol;col--) {
					if(startRow == endRow) break;
					result.add(array[endRow][col]);
			}
			
			for(int row = endRow - 1;row > startRow;row--) {
					if(startCol == endCol)	break;
					result.add(array[row][startCol]);
			}
			
			spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
	}

}
