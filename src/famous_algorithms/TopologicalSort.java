package famous_algorithms;
import java.util.*;

public class TopologicalSort {
	
	 public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		    // Write your code here.
				JobGraph jobGraph = new JobGraph(jobs);
				for(Integer[] dep: deps) {
						jobGraph.addDep(dep[1], dep[0]);
				}
				List<Integer> orderedJobs = new ArrayList<Integer>();
				List<JobNode> nodes = new ArrayList<JobNode>(jobGraph.nodes);
				while(nodes.size() > 0) {
						JobNode node = nodes.get(nodes.size() - 1);
						nodes.remove(nodes.size() - 1);
						boolean containsCycle = dfs(node, orderedJobs);
						if(containsCycle) return new ArrayList<Integer>();
				}
		    return orderedJobs;
		  }
			
			private static boolean dfs(JobNode node, List<Integer> orderedJobs) {
						if(node.visited)	return false;
						if(node.visiting) return true;
						node.visiting = true;
						for(JobNode prereqNode: node.deps) {
								if(dfs(prereqNode, orderedJobs)) return true;
						}
						node.visited = true;
						node.visiting = false;
						orderedJobs.add(node.job);
						return false;
			}
			
			
			static class JobNode {
				public Integer job;
				public List<JobNode> deps;
				public Integer numOfPrereqs;
				public boolean visiting;
				public boolean visited;
				
				public JobNode(Integer job){
						this.job = job;
						deps = new ArrayList<>();
						numOfPrereqs = 0;
				}
			}
			
			static class JobGraph {
				public List<JobNode> nodes;
				public Map<Integer, JobNode> graph;
				
				public JobGraph(List<Integer> jobs) {
						nodes = new ArrayList<JobNode>();
						graph = new HashMap<Integer, JobNode>();
					
						for(Integer job: jobs) {
								addNode(job);
						}
				}
				
				public void addDep(Integer job, Integer dep) {
						JobNode jobNode = getNode(job);
						JobNode depNode = getNode(dep);
						jobNode.deps.add(depNode);
						depNode.numOfPrereqs++;
				}
				
				public void addNode(Integer job) {
						graph.put(job, new JobNode(job));
						nodes.add(graph.get(job));
				}
				
				public JobNode getNode(Integer job) {
					if(!graph.containsKey(job)) addNode(job);
					return graph.get(job);
				}
				
			}

}
