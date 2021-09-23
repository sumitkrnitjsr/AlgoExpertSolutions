package famous_algorithms.hard;
import java.util.*;

public class AStarAlgorithm {
	
	 public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
		    // Write your code here.
				List<List<Node>> nodes = new ArrayList<>();
				for(int i = 0;i < graph.length;i++) {
						List<Node> nodeList = new ArrayList<>();
						nodes.add(nodeList);
						for(int j = 0;j < graph[i].length;j++) {
								nodes.get(i).add(new Node(i, j, graph[i][j]));
						}
				}
				Node startNode = nodes.get(startRow).get(startCol);
				Node endNode = nodes.get(endRow).get(endCol);
				
				startNode.startDistance = 0;
				startNode.endDistance = Math.abs(startNode.row - endNode.row) + Math.abs(startNode.col - endNode.col);
				
				PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
						public int compare(Node a,Node b) {
							return a.endDistance - b.endDistance;
						}
				});
				minHeap.add(startNode);
				while(!minHeap.isEmpty()) {
						Node nearestNode = minHeap.remove();
						if(nearestNode == endNode) break;
						List<Node> neighbours = getNeighbours(nearestNode, nodes);
						for(Node neighbor: neighbours) {
								if(neighbor.value == 1) continue;
								if(nearestNode.startDistance + 1 >= neighbor.startDistance) continue;
								neighbor.parent = nearestNode;
								neighbor.startDistance = nearestNode.startDistance + 1;
								neighbor.endDistance = neighbor.startDistance + 
													Math.abs(neighbor.row - endNode.row) + Math.abs(neighbor.col - endNode.col);
								if(!minHeap.contains(neighbor)) 
										minHeap.add(neighbor);
								else {
										minHeap.remove(neighbor);
										minHeap.add(neighbor);
								}
										
						}
				}
				
				if(endNode.parent == null)
					return new int[][] {};
				
				Node currentNode = endNode;
				List<List<Integer>> path = new ArrayList<>();
				while(currentNode != null) {
						List<Integer> nodeData = new ArrayList<>();
						nodeData.add(currentNode.row);
						nodeData.add(currentNode.col);
						path.add(nodeData);
						currentNode = currentNode.parent;
				}
				
				int[][] result = new int[path.size()][2];
				for(int i = 0;i < result.length;i++) {
						result[i][0] = path.get(result.length - 1 - i).get(0);
						result[i][1] = path.get(result.length - 1 - i).get(1);
				}
				
				return result;
		  }
			
			private List<Node> getNeighbours(Node node, List<List<Node>> nodes) {
					List<Node> neighbours = new ArrayList<>();
					if(node.row < nodes.size() - 1) neighbours.add(nodes.get(node.row + 1).get(node.col));
					if(node.row > 0) neighbours.add(nodes.get(node.row - 1).get(node.col));
					if(node.col < nodes.get(0).size() - 1) neighbours.add(nodes.get(node.row).get(node.col + 1));
					if(node.col > 0) neighbours.add(nodes.get(node.row).get(node.col - 1));
					return neighbours;
			}
			
			class Node {
					String id;
					int row;
					int col;
					int value;
					int startDistance;
					int endDistance;
					Node parent;
					Node(int row,int col,int val) {
						id = Integer.toString(row) + "-" + Integer.toString(col);
						this.row = row;
						this.col = col;
						value = val;
						startDistance = Integer.MAX_VALUE;
						endDistance = Integer.MAX_VALUE;;
						parent = null;
					}
			}

}
