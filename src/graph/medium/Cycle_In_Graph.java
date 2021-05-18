package graph.medium;

public class Cycle_In_Graph {
	
	  public boolean cycleInGraph(int[][] edges) {
		    // Write your code here.
				boolean[] visited = new boolean[edges.length];
				
				for(int i = 0;i < edges.length;i++) {
						if(!visited[i] && traverse(edges, i, visited)) return true;
				}
		    return false;
		  }
			
			private static boolean traverse(int[][] edges,int idx,boolean[] visited) {
						boolean result = false;
						visited[idx] = true;
						for(int i = 0;i < edges[idx].length;i++) {
								int edge = edges[idx][i];
										if(visited[edge]) {
												if(pathExist(edges, edge, idx)) {
														return true;
												}
										}else {
												// Forgot to merge the results
												result = result && traverse(edges, edge, visited);	
										}
								
						}
						return result;
			}
			
			private static boolean pathExist(int[][] edges,int start,int end) {
					boolean visited[] = new boolean[edges.length];
					checkPath(edges, start, visited);
					return visited[end];
			}
			
			private static void checkPath(int[][] edges,int start, boolean[] visited) {
						visited[start] = true;
						for(int i = 0;i < edges[start].length;i++) {
								int edge = edges[start][i];
										if(visited[edge]) continue;
											checkPath(edges, edge, visited);
						}
			}

}
