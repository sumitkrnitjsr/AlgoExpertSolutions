package dynamic_programming.difficult;
import java.util.*;

public class DiskStackingSelf {
	
	 public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		    // Write your code here.
				disks.sort((disk1, disk2) -> disk2[2].compareTo(disk1[2]));
				ArrayList<ArrayList<Integer[]>> stacks = new ArrayList<>();
				for(int i = 0;i < disks.size();i++) {
						Integer[] disk = disks.get(i);
						ArrayList<ArrayList<Integer[]>> newStacks = findStack(stacks, disk);
						stacks.addAll(newStacks);
				}
				
				ArrayList<Integer[]> maxStack = new ArrayList<>();
				int maxSize = 0;
				for(ArrayList<Integer[]> stack: stacks) {
						int size = 0;
						for(Integer[] d: stack) {
								size += d[2];
						}
					
						if(size > maxSize)	{
								maxSize = size;
								maxStack = stack;
						}
				}
				
				Collections.reverse(maxStack);
				
		    return maxStack;
		  }
			
			private static ArrayList<ArrayList<Integer[]>> findStack(ArrayList<ArrayList<Integer[]>> stacks, Integer[] disk)  {
					ArrayList<ArrayList<Integer[]>> newStacks = new ArrayList<>();
					for(ArrayList<Integer[]> stack: stacks) {
								Integer[] top = stack.get(stack.size() - 1);
								if(top[0] > disk[0] && top[1] > disk[1] && top[2] > disk[2]) {
										ArrayList<Integer[]> list = new ArrayList<>();
										list.addAll(stack);
										list.add(disk);
										newStacks.add(list);
								}
					}
					ArrayList<Integer[]> list = new ArrayList<>();
					list.add(disk);
					newStacks.add(list);
				return newStacks;
			}

}
