package heap.difficult;
import java.util.*;

public class Sort_K_Sorted_Array {
	 public int[] sortKSortedArray(int[] array, int k) {
		    // Write your code here.
				PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
				int i = 0;
				// Be Aware of position (k + 1) not k
				for(i = 0;i < Math.min(array.length,k + 1);i++) {
						heap.add(array[i]);
				}
				
				int sortedIdx = 0;
				int inputIdx = i;
				while(inputIdx < array.length) {
							array[sortedIdx] = heap.poll();
							sortedIdx++;
							heap.add(array[inputIdx]);
							inputIdx++;
				}
				
				while(!heap.isEmpty()) {
						array[sortedIdx] = heap.poll();
						sortedIdx++;
				}
				
		    return array;
	}

}
