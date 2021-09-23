package graph.hard;
import java.util.*;

public class RectangleMania {
	
	 public static int rectangleMania(List<Integer[]> coords) {
		    // Write your code here.
				Set<String> coordTable = new HashSet<String>();
				for(Integer[] coord: coords) {
						coordTable.add(coord[0] + ":" + coord[1]);
				}
				int rectangleCount = 0;
				for(Integer[] coord1:coords) {
					for(Integer[] coord2: coords) {
							if(coord2[0] <= coord1[0] || coord2[1] <= coord1[1]) continue;
							if(coordTable.contains(coord1[0] + ":" + coord2[1])
									&& coordTable.contains(coord2[0] + ":" + coord1[1])) rectangleCount++;
					}
						
				}
		    return rectangleCount;
		  }

		  static class Point {
		    public int x;
		    public int y;

		    public Point(int x, int y) {
		      this.x = x;
		      this.y = y;
		    }
		  }

}
