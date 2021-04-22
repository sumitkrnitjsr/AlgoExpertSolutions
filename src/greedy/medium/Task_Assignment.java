package greedy.medium;
import java.util.*;


public class Task_Assignment {
	
	 public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
	   		ArrayList<Task> sortedList = new ArrayList<>();
				int index = 0;
				for(Integer task: tasks){
					sortedList.add(new Task(task,  index));
					index++;
				}
				Collections.sort(sortedList);
				ArrayList<ArrayList<Integer>> assignedList = new ArrayList<ArrayList<Integer>>();
				for(int i = 0;i < k;i++){
					ArrayList<Integer> individualTasks = new ArrayList<>();
					individualTasks.add(sortedList.get(i).index);
					individualTasks.add(sortedList.get(tasks.size() - 1 - i).index);
					assignedList.add(individualTasks);
				}
			
			return assignedList;
	  }
	 
	 public ArrayList<ArrayList<Integer>> taskAssignment2(int k, ArrayList<Integer> tasks) {
	
		 ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
		 HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = getTaskDurationsToIndices(tasks);
		 
		 ArrayList<Integer> sortedTasks = tasks;
		 Collections.sort(sortedTasks);
		 
		 for(int idx = 0;idx < k; idx++) {
			 int task1Duration = sortedTasks.get(idx);
			 ArrayList<Integer> indicesWithTask1Duration = taskDurationToIndices.get(task1Duration);
			 int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size() - 1);
			 
			 int task2SortedIndex = tasks.size() - 1 - idx;
			 int task2Duration = sortedTasks.get(task2SortedIndex);
			 ArrayList<Integer> indicesWithTask2Duration = taskDurationToIndices.get(task2Duration);
			 int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);
			 
			 ArrayList<Integer> pairedTask = new ArrayList<Integer>();
			 pairedTask.add(task1Index);
			 pairedTask.add(task2Index);
			 pairedTasks.add(pairedTask);
		 }
		 
		 return pairedTasks;
		 
	 }
	 
	 private HashMap<Integer, ArrayList<Integer>> getTaskDurationsToIndices(ArrayList<Integer> tasks){
		 HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = new HashMap<>();
		 
		 for(int idx = 0;idx < tasks.size();idx++) {
			 int taskDuration = tasks.get(idx);
			 if(taskDurationToIndices.containsKey(taskDuration)) {
				 taskDurationToIndices.get(taskDuration).add(idx);
			 }else {
				 ArrayList<Integer> temp = new ArrayList<>();
				 temp.add(idx);
				 taskDurationToIndices.put(taskDuration, temp);
			 }
		 }
		 
		 return taskDurationToIndices;
	 }
	 
	 
	 
		
		static class Task implements Comparable<Task>{
			Integer duration;
			Integer index;
			public Task(int duration, int index){
				this.duration = duration;
				this.index = index;
			}
			
			public int compareTo(Task secondTask){
				return this.duration.compareTo(secondTask.duration);
			}
		}

}
