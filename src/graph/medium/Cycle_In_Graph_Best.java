package graph.medium;

import java.util.Arrays;

public class Cycle_In_Graph_Best {
	
	int WHITE = 0;
	int GREY = 1;
	int BLACK = 3;
	
	public boolean cycleinGraph(int[][] edges) {
		int numberOfNodes = edges.length;
		int[] colors = new int[numberOfNodes];
		
		Arrays.fill(colors, WHITE);
		
		for(int node = 0;node < numberOfNodes;node++) {
			if(colors[node] != WHITE) continue;
			
			boolean containsCycle = traverseAndColorNodes(node, edges, colors);
			if(containsCycle) return true;
		}
		
		return false;
	}
	
	private boolean traverseAndColorNodes(int node,int[][] edges,int[] colors) {
		colors[node] = GREY;
		
		int[] neighbours = edges[node];
		for(int neighbour: neighbours) {
			int neighborColor = colors[neighbour];
			if(neighborColor == GREY) return true;
			
			if(neighborColor == BLACK) continue;
			
			boolean containsCycle = traverseAndColorNodes(neighbour, edges, colors);
			if(containsCycle) return true;
			
		}
		
		colors[node] = BLACK;
		return false;
		
	}
	
	public boolean cycleInGraph2(int[][] edges) {
		int numberOfNodes = edges.length;
		boolean[] visited = new boolean[numberOfNodes];
		boolean[] currentlyInStack = new boolean[numberOfNodes];
		
		Arrays.fill(visited, false);
		Arrays.fill(currentlyInStack, false);
		
		for(int node = 0;node < numberOfNodes;node++) {
			if(visited[node]) continue;
			boolean containsCycle = isNodeInCycle(node, edges, visited, currentlyInStack);
			if(containsCycle) return true;
		}
		
		return false;
	}
	
	private boolean isNodeInCycle(int node,int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
			visited[node] = true;
			currentlyInStack[node] = true;
			
			boolean containsCycle = false;
			
			int[] neighbors = edges[node];
			for(int neighbour: neighbors) {
				if(!visited[neighbour]) {
					containsCycle = isNodeInCycle(neighbour,edges, visited, currentlyInStack);
				}
				
				if(containsCycle || currentlyInStack[neighbour] ) return true;
			}
			
			currentlyInStack[node] = false;
			return false;
	}

}
