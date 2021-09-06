package stack.difficult;
import java.util.*;


public class LargestRectangleSkyline {
	
	public int largestRectangleUnderSkyline(ArrayList<Integer> building) {
	    // Write your code here.
			Stack<Integer> stack = new Stack<>();
			int max = 0;
			building.add(0);
			
			for(int i = 0;i < building.size();i++) {
				
					while(!stack.isEmpty() && building.get(stack.peek()) >= building.get(i) ) {
							int topHeightIdx = stack.pop();
							int topHeight = building.get(topHeightIdx);
							if(stack.isEmpty()) {
									max = Math.max(max, topHeight * i);
							}else{
									max = Math.max(max, topHeight * (i - stack.peek() - 1));
							}
					}
					
				stack.push(i);	
				
			}
			
			
			
	    return max;
			
	  }

}
