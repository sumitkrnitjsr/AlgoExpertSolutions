package dynamic_programming.hard;
import java.util.*;

public class SquareOfZeroes {
	
	static class Cell{
		int below;
		int right;
		Cell(int b,int r) {
				below = b;
				right = r;
		}
	}
	
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
    // Write your code here.
		List<List<Cell>> cellMatrix = new ArrayList<>();
		for(int i = 0;i < matrix.size();i++) {
				List<Cell> inner = new ArrayList<>();
				for(int j = 0;j < matrix.get(i).size();j++) {
						int numZeroes = matrix.get(i).get(j) == 0 ? 1 : 0;
						inner.add(new Cell(numZeroes, numZeroes));
				}
				cellMatrix.add(inner);
		}
		
		int lastIdx = matrix.size() - 1;
		for(int row = lastIdx;row >= 0;row--)
			for(int col = lastIdx;col >= 0;col--) {
					if(matrix.get(row).get(col) == 1) continue;
					if(row < lastIdx) 
							cellMatrix.get(row).get(col).below += cellMatrix.get(row + 1).get(col).below;
					if(col < lastIdx)
							cellMatrix.get(row).get(col).right += cellMatrix.get(row).get(col + 1).right;
			}
		
		for(int topRow = 0;topRow < matrix.size();topRow++)
			for(int leftCol = 0;leftCol < matrix.size();leftCol++) {
					int squareLength = 2;
					while(squareLength <= matrix.size() - leftCol && squareLength <= matrix.size() - topRow) {
							int bottomRow = topRow + squareLength - 1;
							int rightCol = leftCol + squareLength - 1;
							if(cellMatrix.get(topRow).get(leftCol).right >= (rightCol - leftCol + 1)
								&& cellMatrix.get(topRow).get(leftCol).below >= (rightCol - leftCol + 1)
								&& cellMatrix.get(bottomRow).get(leftCol).right >= (rightCol - leftCol + 1)
								&& cellMatrix.get(topRow).get(rightCol).below >= (rightCol - leftCol + 1)
								)
								return true;
								squareLength++;
					}
			}
		
		
    return false;
  }

}
