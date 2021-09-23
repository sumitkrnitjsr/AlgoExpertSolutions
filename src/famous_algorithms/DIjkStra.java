package famous_algorithms;
import java.util.*;

public class DIjkStra {
	
	 public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		    // Write your code here.
				int[] minDistances = new int[edges.length];
				Arrays.fill(minDistances, Integer.MAX_VALUE);
				minDistances[start] = 0;
				
				Set<Integer> visited = new HashSet<>();
				while(visited.size() != edges.length) {
						int[] closestVertex = getClosestVertex(minDistances, visited);
						if(closestVertex[1] == Integer.MAX_VALUE) break;
						visited.add(closestVertex[0]);
						for(int[] edge : edges[closestVertex[0]]) {
								int newDistance = closestVertex[1] + edge[1];
								if(newDistance < minDistances[edge[0]]) {
										minDistances[edge[0]] = newDistance;
								}
						}
				}
				for(int i = 0;i < minDistances.length;i++) {
						if(minDistances[i] == Integer.MAX_VALUE) {
								 minDistances[i] = -1;
						}
				}
				
		    return minDistances;
		  }
			
			private int[] getClosestVertex(int[] distances, Set<Integer> visited) {	
					int minDistance = Integer.MAX_VALUE;
					int vertex = -1;
				
					for(int vIdx = 0;vIdx < distances.length; vIdx++) {
							int distance = distances[vIdx];
							if(visited.contains(vIdx)) continue;
							if(distance < minDistance) {
									vertex = vIdx;
									minDistance = distance;
							}
					}
				
					return new int[] {vertex, minDistance};
			}

}
