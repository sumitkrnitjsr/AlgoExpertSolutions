package mIcrosoft.random;
import java.util.*;

public class MedianFinder {
	
	  PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    public MedianFinder() {
	        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
	            // should be Integer not int
	            public int compare(Integer a,Integer b) {
	                return Integer.compare(b, a);
	            }
	        });
	    }
	    
	    public void addNum(int num) {
	        int max = maxHeap.size() == 0 ? Integer.MAX_VALUE : maxHeap.peek();
	        int min = minHeap.size() == 0 ? Integer.MIN_VALUE : minHeap.peek();
	        if(num < max) {
	            if(maxHeap.size() <= minHeap.size()) {
	                maxHeap.add(num);    
	            }else {
	                maxHeap.poll();
	                // Using Math.max is important
	                maxHeap.add(Math.min(num, max));
	                minHeap.add(Math.max(max, num));
	            }
	        }else{
	            if(minHeap.size() <= maxHeap.size()) {
	                minHeap.add(num);
	            }else {
	                minHeap.poll();
	                minHeap.add(Math.max(num, min));
	                maxHeap.add(Math.min(num, min));
	            }
	        }
	    }
	    
	    public double findMedian() {
	        System.out.println(maxHeap.peek() + " "  + maxHeap.size());
	        if(maxHeap.size() == minHeap.size()) return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
	        
	        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
	        
	        return maxHeap.peek();
	    }

}
