package graph.difficult;
import java.util.*;

public class AirportConnections {
	
	static class Node {
		String airport;
		List<String> connections;
		boolean isReachable;
		List<String> unreachableConnections;
		Node(String airport) {
			this.airport = airport;
			connections = new ArrayList<String>();
			isReachable = true;
			unreachableConnections = new ArrayList<String>();
		}
			
}
public static int airportConnections(
  List<String> airports, List<List<String>> routes, String startingAirport) {
// Write your code here.
		Map<String,Node> graph = new HashMap<>();
		for(String airport: airports) 
				graph.put(airport, new Node(airport));
		for(List<String> route: routes) 
				graph.get(route.get(0)).connections.add(route.get(1));
		
		List<Node> unreachable = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		dfs(graph, startingAirport, visited);
		for(String airport: airports) {
				if(visited.contains(airport)) continue;
				graph.get(airport).isReachable = false;
				unreachable.add(graph.get(airport));
		}
	
		for(Node airport: unreachable) {
					List<String> unreachableNodes = new ArrayList<>();
					Set<String> visitedNodes = new HashSet<>();
					dfsUnreachable(graph, airport.airport, unreachableNodes, visitedNodes);
					airport.unreachableConnections = unreachableNodes;
		}
	
	unreachable.sort((a1, a2) -> a2.unreachableConnections.size() - a1.unreachableConnections.size());
	int newConnections = 0;
	for(Node node: unreachable) {
			if(node.isReachable) continue;
			newConnections++;
			for(String connection: node.unreachableConnections)
				graph.get(connection).isReachable = true;
	}
return newConnections;
}

private static void dfs(Map<String, Node> graph, String airport, Set<String> visited) {
			if(visited.contains(airport)) return;
			visited.add(airport);
			for(String connection: graph.get(airport).connections) 
					dfs(graph, connection,visited);
}

private static void dfsUnreachable(Map<String, Node> graph, String airport, List<String> unreachableNodes, Set<String> visited) {
		if(graph.get(airport).isReachable) return;
		if(visited.contains(airport)) return;
		visited.add(airport);
		unreachableNodes.add(airport);
		for(String node: graph.get(airport).connections)
			dfsUnreachable(graph,node,unreachableNodes,visited);
}

}
