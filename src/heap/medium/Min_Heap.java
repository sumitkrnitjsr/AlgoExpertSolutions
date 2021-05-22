package heap.medium;
import java.util.*;


public class Min_Heap {
	
	public  static class MinHeap {
		    List<Integer> heap = new ArrayList<Integer>();

		    public MinHeap(List<Integer> array) {
		      heap = buildHeap(array);
		    }

		    public List<Integer> buildHeap(List<Integer> array) {
		      // Write your code here.
					for(int i = 1;i < array.size();i++) {
							siftUp(i, array);
					}
		      return array;
		    }
		    
		    public List<Integer> buildHeapBest(List<Integer> array) {
		    	int firstParentIdx = (array.size() - 2) / 2;
		    	for(int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
		    		siftDown(currentIdx, array.size() - 1, array);
		    	}
		    	return array;
		    }
		    
		    public void siftDownBest(int currentIdx, int endIdx, List<Integer> heap) {
		    	int childOneIdx = currentIdx * 2 + 1;
		    	while(childOneIdx <= endIdx) {
		    		int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
		    		int idxToSwap;
		    		if(childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
		    			idxToSwap = childTwoIdx;
		    		}else {
		    			idxToSwap = childOneIdx;
		    		}
		    		
		    		if(heap.get(idxToSwap) < heap.get(currentIdx)) {
		    			swap(currentIdx, idxToSwap, heap);
		    			currentIdx = idxToSwap;
		    			childOneIdx = currentIdx * 2 + 1;
		    		}else {
		    			return;
		    		}
		    	}
		    }
		    
		    public void swap(int i, int j, List<Integer> heap) {
		    	Integer temp = heap.get(j);
		    	heap.set(j, heap.get(i));
		    	heap.set(i, temp);
		    }

		    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
		      // Write your code here.
					while(currentIdx <= endIdx) {
							int leftIdx = (2 * currentIdx) + 1;
							if(leftIdx > endIdx) return;
							int rightIdx = (2 * currentIdx) + 2;
							if(rightIdx > endIdx) rightIdx = leftIdx;
							int minIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
							int minValue = heap.get(minIdx);
							int currValue = heap.get(currentIdx);
							if(currValue > minValue) {
									heap.set(minIdx, currValue);
									heap.set(currentIdx, minValue);
									currentIdx = minIdx;
							}else {
								break;
							}
					}
		    }

		    public void siftUp(int currentIdx, List<Integer> heap) {
		      // Write your code here.
					if(heap.size() < 2) return;
					while(currentIdx > 0) {
							int parent = (currentIdx - 1) / 2;
							int pValue = heap.get(parent);
							int currValue = heap.get(currentIdx);
							if(pValue > currValue) {
										heap.set(currentIdx, pValue);
										heap.set(parent, currValue);
										currentIdx = parent;
							}else {
								break;
							}
					}
		    }
		    
		    public void siftUpBest(int currentIdx, List<Integer> heap) {
		    	int parentIdx = (currentIdx - 1) / 2;
		    	while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
		    		swap(currentIdx, parentIdx, heap);
		    		currentIdx = parentIdx;
		    		parentIdx = (currentIdx - 1) / 2;
		    	}
		    }
		    

		    public int peek() {
		      // Write your code here.
					if(heap.size() == 0)
		      		return -1;	  
					return heap.get(0);
		    }

		    public int remove() {
		      // Write your code here.
					int firstIdx = 0;
					int lastIdx = heap.size() - 1;
					int element = heap.get(firstIdx);
					heap.set(firstIdx, heap.get(lastIdx));
					heap.remove(lastIdx);
					siftDown(0, lastIdx - 1, heap);
		      return element;
		    }

		    public void insert(int value) {
		      // Write your code here. 2*n  + 1/2 children
					heap.add(value);
					siftUp(heap.size() - 1, heap);
		    }
	 }

}
