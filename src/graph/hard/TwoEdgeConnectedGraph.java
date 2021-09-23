package graph.hard;
import java.util.*;

public class TwoEdgeConnectedGraph {
	
	 public boolean twoEdgeConnectedGraph(int[][] edges) {
		    // Write your code here.
				if(edges.length == 0) return true;
				int[] arrivalTime = new int[edges.length];
				Arrays.fill(arrivalTime, -1);
				int start = 0;
				if(minArrivalTime(start, -1, 0, arrivalTime, edges) == -1) return false;
					
		    for(int time: arrivalTime) 
						if(time == -1) return false;
				
				return true;
		  }
			
			private int minArrivalTime(int vertex,int parent, int currentTime, int[] arrivalTime,int[][] edges) {
					arrivalTime[vertex] = currentTime;
					int minTime = currentTime;
					for(int dest: edges[vertex]) {
							if(arrivalTime[dest] == -1) {
									minTime = Math.min(minTime, minArrivalTime(dest, vertex, currentTime + 1, arrivalTime, edges));
							}else if(dest != parent){
									minTime = Math.min(minTime, arrivalTime[dest]);
							}
					}
					if(minTime == currentTime && parent != -1) return -1;
				
					return minTime;
			}

}
