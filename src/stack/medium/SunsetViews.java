package stack.medium;
import java.util.*;


public class SunsetViews {
	
	 public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
		    // Write your code here.
				boolean right = (direction.equals("EAST"));
				int idx = right?buildings.length - 1: 0;
				int max = Integer.MIN_VALUE;
				ArrayList<Integer> indices = new ArrayList<>();
				
				while(idx >= 0 && idx < buildings.length) {
							int current = buildings[idx];
							if(current > max) {
								indices.add(idx);
									max = current;
							}
								
							idx = right?idx - 1 :idx + 1;
				}
				
				Collections.sort(indices);
		    return indices;
	}
	 
	 public ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {
		    // Write your code here.
			ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<>();
			
			int startIdx = buildings.length - 1;
			int step = -1;
			
			if(direction.equals("WEST")) {
				startIdx = 0;
				step = 1;
			}
			
			int idx = startIdx;
			int runningMaxHeight = 0;
			
			while(idx >= 0 && idx < buildings.length) {
				int buildingHeight = buildings[idx];
				
				if(buildingHeight > runningMaxHeight) {
					buildingsWithSunsetViews.add(idx);
				}
				
				runningMaxHeight = Math.max(runningMaxHeight, buildingHeight);
				
				idx += step;
			}
			
			if(direction.equals("EAST")) {
				Collections.reverse(buildingsWithSunsetViews);
			}
			
			return buildingsWithSunsetViews;
		    
	}

}
