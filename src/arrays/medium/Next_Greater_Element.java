package arrays.medium;
import java.util.*;


public class Next_Greater_Element {
	
	 public int[] nextGreaterElement(int[] array) {
		    // Write your code here.
				Stack<Integer> maxStack = new Stack<>();
				int[] nextBigElem = new int[array.length];
				Arrays.fill(nextBigElem, -1);
				maxStack.push(0);
				int idx = 1;
				int index = 1;
				while(!maxStack.isEmpty() && index < (2 * array.length)) {
							idx = (index )%array.length;
							while(!maxStack.isEmpty() && array[maxStack.peek()] < array[idx] ) {
										int i = maxStack.pop();
										nextBigElem[i] = array[idx];
							}
							maxStack.push(idx);
							index++;
				}
				
				return nextBigElem;
	}
	 
	 public int[] nextGreaterElement2(int[] array) {
		    // Write your code here.
				Stack<Integer> stack = new Stack<>();
				int[] result = new int[array.length];
				Arrays.fill(result, -1);
				
				for(int idx = 0;idx < 2 * array.length;idx++ ) {
					int circularIdx = idx % array.length;
					
					while(stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
						int top = stack.pop();
						result[top] = array[circularIdx];
					}
					
					stack.push(circularIdx);
				}
						
				return result;
	}
	 
	 public int[] nextGreaterElement3(int[] array) {
		    // Write your code here.
				Stack<Integer> stack = new Stack<>();
				int[] result = new int[array.length];
				Arrays.fill(result, -1);
				
				for(int idx = 2 * array.length - 1;idx >= 0;idx-- ) {
					int circularIdx = idx % array.length;
					
					while(stack.size() > 0) {
						if(stack.peek() <= array[circularIdx] ) {
							stack.pop();
						}else {
							result[circularIdx] = stack.peek();
							break;
						}
					}
					
					stack.push(array[circularIdx]);
				}
						
				return result;
	}
	 
	 

}
