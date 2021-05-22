package heap.difficult;
import java.util.function.BiFunction;
import java.util.*;
;


public class ContinuousMedianHandler {
	
		    double median = 0;
				PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) ->  Integer.compare(y, x));
				PriorityQueue<Integer> minHeap = new PriorityQueue<>();
				
		    public void insert(int number) {
		      // Write your code here.	
					if(maxHeap.size() == minHeap.size()) {
							if(maxHeap.size() > 0 && number > maxHeap.peek()) {
									minHeap.add(number);
							}else {
									maxHeap.add(number);
							}
						median = minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
					}else {
							if(maxHeap.size() > minHeap.size()) {
									if(number > maxHeap.peek()) {
											minHeap.add(number);
									}else {
											int top = maxHeap.poll();
											minHeap.add(top);
											maxHeap.add(number);
									}
							}else{
									if(number < minHeap.peek()) {
											maxHeap.add(number);
									}else {
											int top = minHeap.poll();
											minHeap.add(number);
											maxHeap.add(top);
									}
							}
						median = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
					}
					
		    }

		    public double getMedian() {
		      return median;
		  }
		    
		   Heap lowers = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<Integer>());
		   Heap greaters = new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<Integer>());
		   
		   public void insertNum(int number) {
			   if(lowers.length == 0|| number < lowers.peek()) {
				   	lowers.insert(number);
			   }else {
				   greaters.insert(number);
			   }
			   rebalance();
			   updateMedian();
		   }
		   
		   public void rebalance() {
			   	if(lowers.length - greaters.length == 2) {
			   		greaters.insert(lowers.remove());
			   	}else {
			   		lowers.insert(greaters.remove());
			   	}
		   }
		   
		   public void updateMedian() {
			   if(lowers.length == greaters.length) {
				   median = (double)(lowers.peek() + greaters.peek()) / 2.0;
			   }else if (lowers.length > greaters.length) {
				   median = lowers.peek();
			   }else {
				   median = greaters.peek();
			   }
		   }
		   
		   static class Heap {
			   List<Integer> heap = new ArrayList<Integer> ();
			   BiFunction<Integer,Integer, Boolean> comparisonFunc;
			   int length;
			   
			   public Heap(BiFunction<Integer, Integer, Boolean> func, List<Integer> array) {
				   	comparisonFunc = func;
				   	heap = buildHeap(array);
				   	length = heap.size();
			   }
			   
			   public List<Integer> buildHeap(List<Integer> array) {
				   int firstParentIdx = (array.size() - 2) / 2;
				   for(int currentIdx = firstParentIdx;currentIdx >= 0;currentIdx--) {
					   siftDown(currentIdx, array.size() - 1, array);
				   }
				   return array;
			   }
			   
			   public int peek() {
				   return heap.get(0);
			   }
			   
			   public int remove() {
				   swap(0, heap.size() - 1, heap);
				   int valueToRemove = heap.get(heap.size() - 1);
				   heap.remove(heap.size() - 1);
				   length--;
				   siftDown(0, heap.size() - 1, heap);
				   return valueToRemove;
			   }
			   
			   public void insert(int number) {
				   heap.add(number);
				   length++;
				   siftUp(heap.size() - 1, heap);
			   }
			   
			   public void swap(int i, int j, List<Integer> heap) {
			    	Integer temp = heap.get(j);
			    	heap.set(j, heap.get(i));
			    	heap.set(i, temp);
			    }
			   
			   public static boolean MAX_HEAP_FUNC(Integer a,Integer b) {
				   return a > b;
			   }
			   
			   public static boolean MIN_HEAP_FUNC(Integer a, Integer b) {
				   return a < b;
			   }
			   
			   public void siftUp(int currentIdx,List<Integer> heap) {
				   	int parentIdx = (currentIdx - 1) / 2;
				   	while(currentIdx > 0) {
				   		if(comparisonFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
				   			swap(currentIdx, parentIdx, heap);
				   			currentIdx = parentIdx;
				   			parentIdx = (currentIdx - 1) / 2;
				   		}else {
				   			return;
				   		}
				   	}
			   }
			   
			   public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
				   int childOneIdx = (2 * currentIdx)  +1;
				   while(childOneIdx <= endIdx) {
					   int childTwoIdx = childOneIdx + 1 <= endIdx ? childOneIdx + 1 : -1;
					   int idxToSwap;
					   if(childTwoIdx != -1) {
						   if(comparisonFunc.apply(heap.get(childTwoIdx), heap.get(childOneIdx))) {
							   idxToSwap = childTwoIdx;
						   }else {
							   idxToSwap = childOneIdx;
						   }
					   }else {
						   idxToSwap = childOneIdx;
					   }
					   
					   if(comparisonFunc.apply(heap.get(idxToSwap), heap.get(currentIdx))) {
						   swap(currentIdx, idxToSwap, heap);
						   currentIdx = idxToSwap;
						   childOneIdx = currentIdx * 2 + 1;
					   }else {
						   	return;
					   }
				   }
			   }
			   
		   }
}
