package arrays.hard;
import java.util.*;

public class MinAreaRectangle1 {
	
	 public int minimumAreaRectangle(int[][] points) {
		    // Write your code here.
				HashSet<String> pointSet = createSet(points);
				int minArea = Integer.MAX_VALUE;
				
				for(int i = 0;i < points.length;i++) {
						for(int j = 0;j < points.length;j++) {
								if(points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
								
								if(otherDiagonalExists(points, i, j,pointSet)) {
										int currArea = Math.abs(points[i][0] - points[j][0])	* 
																		Math.abs(points[i][1] - points[j][1]);
										minArea = Math.min(minArea, currArea);
								}
							
						}
				}
				
		    return minArea != Integer.MAX_VALUE ? minArea : 0;
		  }
			
			private boolean otherDiagonalExists(int[][] points, int i,int j, HashSet<String> pSet) {
					return ( pSet.contains(points[i][0] + ":" + points[j][1])
									&& pSet.contains(points[j][0] + ":" + points[i][1]));
			}
			
			private HashSet<String> createSet(int[][] points) {
					HashSet<String> set = new HashSet<>();
					for(int[] point: points) {
							int x = point[0];
							int y = point[1];
							set.add(Integer.toString(x) + ":" + Integer.toString(y));
					}
					return set;
			}

}
