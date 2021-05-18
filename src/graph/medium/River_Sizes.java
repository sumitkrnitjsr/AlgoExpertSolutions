package graph.medium;
import java.util.*;


public class River_Sizes {
	
	 public static List<Integer> riverSizes(int[][] matrix) {
		    // Write your code here.
				int height = matrix.length;
				int width = matrix[0].length;
				ArrayList<Integer> riverSizes = new ArrayList<>();
				for(int i = 0;i < height;i++) {
					for(int j = 0;j < width;j++) {
							if(matrix[i][j] == 1) {
									int count = 0;
									riverSizes.add(getNeighboursCount(matrix, i ,j,height,width));
							}
					}
				}
				
		    return riverSizes;
		  }
			
			private static int getNeighboursCount(int[][] matrix,int i,int j,int h,int w) {
							if(i < 0 || j < 0 || 
								 i == h || j == w || matrix[i][j] == 0) return 0;
				
							int count = 1;
							matrix[i][j] = 0;
							count += getNeighboursCount(matrix,i + 1,j,h,w);
							count += getNeighboursCount(matrix,i - 1,j,h,w);
							count += getNeighboursCount(matrix,i,j + 1,h,w);
							count += getNeighboursCount(matrix,i,j - 1,h,w);
							
							return count;
		}
			
			
		public static List<Integer> riverSize(int[][] matrix) {
			
			boolean[][] visited = new boolean[matrix.length][matrix[0].length];
			ArrayList<Integer> sizes = new ArrayList<>();
			
			for(int i = 0;i < matrix.length;i++) {
				for(int j = 0;j < matrix[0].length;j++) {
					if(visited[i][j]) continue;
					traverseNode(i,j,matrix, visited, sizes);
				}
			}
			return sizes;
		}
		
		private static void traverseNode(int i,int j,int[][] matrix,boolean[][] visited, List<Integer> sizes) {
			
			int currentRiverSize = 0;
			Stack<Integer[]> nodesToExplore = new Stack<>();
			nodesToExplore.push(new Integer[] {i,j});
			while(!nodesToExplore.isEmpty()) {
				Integer[] currentNode = nodesToExplore.pop();
				i = currentNode[0];
				j = currentNode[1];
				if(visited[i][j]) continue;
				visited[i][j] = true;
				if(matrix[i][j] == 0) continue;	
				currentRiverSize++;
				List<Integer[]> unvisitedNeighbours = getUnvisitedNeighbours(i,j,matrix,visited);
				for(Integer[] neighbour:unvisitedNeighbours) {
					nodesToExplore.add(neighbour);
				}
			}
			if(currentRiverSize > 0) {
				sizes.add(currentRiverSize);
			}
		}
		
		private static List<Integer[]> getUnvisitedNeighbours(int i,int j,int[][] matrix,boolean[][] visited) {
			List<Integer[]> unvisitedNeighbours = new ArrayList<>();
			
			if(i > 0 && !visited[i - 1][j]) unvisitedNeighbours.add(new Integer[] {i - 1, j});
			
			if(j > 0 && !visited[i][j - 1]) unvisitedNeighbours.add(new Integer[] {i, j - 1});
			
			if(i < matrix.length - 1 && !visited[i + 1][j]) unvisitedNeighbours.add(new Integer[] {i + 1, j});
			
			if(j < matrix[0].length - 1 && !visited[i][j + 1]) unvisitedNeighbours.add(new Integer[] {i, j + 1});
			
			
			return unvisitedNeighbours;
		}
		

}
