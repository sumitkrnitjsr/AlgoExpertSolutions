package mIcrosoft;
import java.util.*;

public class SpiralOrderMatrix {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
	       int row_s = 0;
	       int row_e = matrix.length - 1;
	       int col_s = 0;
	        int col_e = matrix[0].length - 1;
	        List<Integer> spiralList = new ArrayList<>();
	        // Using OR here may lead to loop with row overflow
	        while(row_s <= row_e && col_s <= col_e) {
	                for(int i = col_s;i <= col_e;i++) {
	                    spiralList.add(matrix[row_s][i]);
	                }
	                for(int i = row_s + 1;i <= row_e;i++) {
	                    spiralList.add(matrix[i][col_e]);
	                }
	                if(row_s != row_e) {
	                   for(int i = col_e - 1;i >= col_s;i--) {
	                       spiralList.add(matrix[row_e][i]);
	                   }
	                }
	                if(col_s != col_e) {
	                   for(int i = row_e - 1;i > row_s;i--) {
	                       spiralList.add(matrix[i][col_s]);
	                   }
	                }
	                row_s++; row_e--;
	                col_s++; col_e--;
	        }
	        
	        return spiralList;
	    }

}
