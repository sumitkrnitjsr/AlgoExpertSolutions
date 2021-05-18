package stack.medium;
import java.util.*;

public class Sort_Stack {
	
	 public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
		    // Write your code here.
				if(stack.size() == 0) {
						return stack;
				}
				
				int element = pop(stack);
				sortStack(stack);
				pushSorted(stack, element);
		    return stack;
		  }
			
			private static void pushSorted(ArrayList<Integer> stack, int element) {
					if(stack.size() == 0 || stack.get(stack.size() - 1) <= element) {
							push(stack, element);
							return;
					}			
					int top = pop(stack);
					pushSorted(stack, element);
					push(stack, top);
			}
			
			private static void push(ArrayList<Integer> stack,int num) {
					stack.add(num);
			}
			
			private static int pop(ArrayList<Integer> stack) {
				
					int num = stack.get(stack.size() - 1);
					stack.remove(stack.size() - 1);
					return num;
				
	}

}
