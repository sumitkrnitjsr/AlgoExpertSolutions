package arrays.difficult;
import java.util.*;

public class ZIgZag_Traverse {
	
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
	    // Write your code here.
			int r = 0;
			int c = 0;
			int rows = array.size() - 1;
			int cols = array.get(0).size() - 1;
			ArrayList<Integer> zigzagList = new ArrayList<>();
			while(r <= rows || c <= cols) {
						// Traverse Up - Down
						while(r <= rows && c >= 0) {
								int elem = array.get(r).get(c);
								zigzagList.add(elem);
								r++; c--;
						}
		
						if(r > rows){
								c += 2;
								r = rows;
						}else{
								c = 0;
						}
				
						if(c > cols) break;
						// Traverse Down - Up
						while(r >= 0 && c <= cols) {
								int elem = array.get(r).get(c);
								zigzagList.add(elem);
								r--; c++;
						}
				
						if(c > cols) {
								r += 2;
								c = cols;
						}else{
								r = 0;	
						}
						
			}
	    return zigzagList;
	  }
	
	public static List<Integer> zigzagTraverse2(List<List<Integer>> array) {
		
			int height = array.size() - 1;
			int width = array.get(0).size() - 1;
			
			List<Integer> result = new ArrayList<Integer>();
			int row = 0;
			int col = 0;
			boolean goingDown = false;
			while(!isOutOfBounds(row, col, height, width)) {
				result.add(array.get(row).get(col));
				if(goingDown) {
					if(col == 0 || row == height) {
						goingDown = false;
						if(row == height) {
							col++;
						}else {
							row++;
						}
					}else {
						row++;
						col--;
					}
					}else {
						if(row == 0 || col == width) {
							goingDown = true;
							if(col == width) {
								row++;
							}else {
								col++;
							}
						}else {
							row--;
							col++;
						}
					}
				}
			
			return result;
				
	}
	
	public static boolean isOutOfBounds(int row, int col, int height, int width) {
		return row < 0 || row > height || col < 0 || col > width;
	}
	

}
