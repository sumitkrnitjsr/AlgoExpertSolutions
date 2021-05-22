package heap.difficult;
import java.util.*;
import heap.medium.Min_Heap;
import heap.difficult.Merge_Sorted_Arays2.MinHeap;


public class Laptop_Rentals {
	
	public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
	    // Write your code here.
			ArrayList<Integer> startTimes = new ArrayList<>();
			ArrayList<Integer> endTimes = new ArrayList<>();
			for(ArrayList<Integer> time: times) {
					startTimes.add(time.get(0));
					endTimes.add(time.get(1));
			}
			Collections.sort(startTimes);
			Collections.sort(endTimes);
			int startIdx = 0;
			int endIdx = 0;
			int count = 0;
			int maxCount = 0;
			while(startIdx < startTimes.size()) {
						int start = startTimes.get(startIdx);
						int end = endTimes.get(endIdx);
						if(start < end) {
								startIdx++;
								count++;
						}else {
								endIdx++;
								count--;
						}
						maxCount = Math.max(count, maxCount);
			}
				
	    return maxCount;
	  }

	
	public int laptopRentals2(ArrayList<ArrayList<Integer>> times) {
			if(times.size() == 0) return 0;
			int usedLaptops = 0;
			ArrayList<Integer> startTimes = new ArrayList<>();
			ArrayList<Integer> endTimes = new ArrayList<>();
			
			for(ArrayList<Integer> interval : times) {
				startTimes.add(interval.get(0));
				endTimes.add(interval.get(1));
			}
			
			Collections.sort(startTimes);
			Collections.sort(endTimes);
			
			int startIterator = 0;
			int endIterator = 0;
			while(startIterator < times.size()) {
				if(startTimes.get(startIterator) >= endTimes.get(endIterator)) {
					usedLaptops -= 1;
					endIterator += 1;
				}
				
				usedLaptops += 1;
				startIterator += 1;
			}
			
			return usedLaptops;
	}
	
	public int laptopRentals3(ArrayList<ArrayList<Integer>> times) {
			Collections.sort(times, (a,b) -> Integer.compare(a.get(0), b.get(0)));
			
			ArrayList<ArrayList<Integer>> timesWhenLaptopIsUsed = new ArrayList<>();
			timesWhenLaptopIsUsed.add(times.get(0));
			MinHeap heap  = new MinHeap(timesWhenLaptopIsUsed);
			
			for(int idx = 1;idx < times.size();idx++) {
				ArrayList<Integer> currentInterval = times.get(idx);
				if(heap.peek().get(1) <= currentInterval.get(0)) {
						heap.remove();
				}
				heap.insert(currentInterval);
			}
		
			return timesWhenLaptopIsUsed.size();
	}
}
