package arrays.hard;
import java.util.*;

public class ApartmentHunting {
	
	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
	    // Write your code here.
			ArrayList<Map<String, Integer>> distanceSum = new ArrayList<>();		
			for(int i = 0;i < blocks.size();i++) {
					Map<String, Boolean> block = blocks.get(i);
					Map<String, Integer> distances = new HashMap<>();
				
					for(String req: reqs) {
								if(!block.get(req)) {
										if(i == 0 || distanceSum.get(i - 1).get(req) == Integer.MAX_VALUE) {
												distances.put(req, Integer.MAX_VALUE);
										}else {
												distances.put(req, distanceSum.get(i - 1).get(req) + 1);
										}
								}else {
										distances.put(req, 0);
								}
					}
					distanceSum.add(distances);
			}
			
			for(int i = blocks.size() - 2;i >= 0;i--) {
					Map<String, Boolean> block = blocks.get(i);
					Map<String, Integer> distances = distanceSum.get(i);
				
					for(String req: reqs) {
								if(!block.get(req) && 
									distanceSum.get(i + 1).get(req) != Integer.MAX_VALUE) {
									
									distances.put(req, 
																Math.min(
																	distanceSum.get(i).get(req),
																	distanceSum.get(i + 1).get(req) + 1));
										
								}
					}
				
					distanceSum.set(i, distances);
			}


			Result minDistance = new Result();
			minDistance.totalD = minDistance.farthestD = Integer.MAX_VALUE;
			int minIdx = -1;
			
			for(int i = 0;i < distanceSum.size();i++) {
					Result result = getDistance(distanceSum.get(i));
					if(minDistance.farthestD > result.farthestD) {
							minDistance = result;
							minIdx = i;
					}
			}
			
	    return minIdx;
	  }
		
		private static Result getDistance(Map<String, Integer> map) {
				int distance = 0;
				int farthest = -1;
				Result result = new Result();
				
				for(Map.Entry<String, Integer> set : map.entrySet()) {
							if(set.getValue() == Integer.MAX_VALUE) {
									result.totalD = result.farthestD = Integer.MAX_VALUE;
									return result;
							}
							farthest = Math.max(set.getValue(), farthest);
							distance += set.getValue();
				}
				
				result.totalD = distance;
				result.farthestD = farthest;
			
			return result;
		}
		
	}

	

class Result {
			int totalD;
			int farthestD;
}


