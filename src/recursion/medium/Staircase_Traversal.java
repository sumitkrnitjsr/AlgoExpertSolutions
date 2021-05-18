package recursion.medium;
import java.util.*;

public class Staircase_Traversal {
	
	public int staircaseTraversal(int height, int maxSteps) {
	    // Write your code here.
	    return staircaseTraversal(height, maxSteps, 0);
	  }
		
		private int staircaseTraversal(int height, int maxSteps,int currentHeight) {
			if(currentHeight == height) {
					return 1;
			}
			
			int steps = 0;
			for(int i = 1;i <= maxSteps;i++) {
					if(currentHeight + i <= height) {
							steps += staircaseTraversal(height, maxSteps,currentHeight + i);
					}
			}
			return steps;
		}
		
		private int staircaseTraversalMemoise(int height, int maxSteps) {
			HashMap<Integer, Integer> memoize = new HashMap<>();
			memoize.put(0,1);
			memoize.put(1,1);
			return numberOfWaysToTop(height, maxSteps,memoize);
		}
		
		private int numberOfWaysToTop(int height,int maxSteps, HashMap<Integer,Integer> memoize) {
			if(memoize.containsKey(height)) return memoize.get(height);
			
			int numberOfSteps = 0;
			for(int steps = 0;steps < Math.min(maxSteps, height) + 1;steps++) {
				numberOfSteps += numberOfWaysToTop(height - steps, maxSteps, memoize);
			}
			
			memoize.put(height, numberOfSteps);
			return numberOfSteps;
		}
		
		private int staircaseTraversalBetter(int height,int maxSteps) {
				int[] waysToTop = new int[height + 1];
				waysToTop[0] = 1;
				waysToTop[1] = 1;
				
				for(int currentHeight = 2;currentHeight < height + 1;currentHeight++) {
					int step = 1;
					while(step <= maxSteps && step <= currentHeight) {
						waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - step];
						step++;
					}
				}
				
				return waysToTop[height];
		}
		
		private int staircaseTraversalBest(int height, int maxSteps) {
			int currentNumberOfWays = 0;
			ArrayList<Integer> waysToTop = new ArrayList<>();
			waysToTop.add(1);
			
			for(int currentHeight = 1;currentHeight < height + 1;currentHeight++) {
				int startOfWindow = currentHeight - maxSteps - 1;
				int endOfWindow = currentHeight - 1;
				
				if(startOfWindow >= 0) {
					currentNumberOfWays -= waysToTop.get(startOfWindow);
				}
				
				currentNumberOfWays += waysToTop.get(endOfWindow);
				waysToTop.add(currentNumberOfWays);
			}
			
			return waysToTop.get(height);
		}

}
