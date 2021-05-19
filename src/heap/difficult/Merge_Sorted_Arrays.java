package heap.difficult;
import java.util.*;


public class Merge_Sorted_Arrays {
	
	 public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
		    // Write your code here.
				PriorityQueue<QueueNode> topElements = new PriorityQueue<>();
				List<Integer> mergedList = new ArrayList<>();
				int idx = 0;
				for(List<Integer> list: arrays) {
						topElements.add(new QueueNode(list.get(0), idx));
						list.remove(0);
						idx++;
				}
				
				while(!topElements.isEmpty()) {
						QueueNode top = topElements.poll();
						mergedList.add(top.value);
						List<Integer> array = arrays.get(top.idx);
						if(array != null && array.size() > 0) {
							int nextElement = array.get(0);
							array.remove(0);
							topElements.add(new QueueNode(nextElement, top.idx));
						}
				}
				
		    return mergedList;
		  }
			
			static class QueueNode implements Comparable<QueueNode>{
					int value;
					int idx;
				public QueueNode(int v,int i) {
						value = v;
						idx = i;
				}
				
				public int compareTo(QueueNode node) {
						return this.value - node.value;
				}
				
			}
			
		private static List<Integer> mergeSortedArrays2(List<List<Integer>> arrays) {
			List<Integer> sortedList = new ArrayList<>();
			List<Integer> elementIdxs = new ArrayList<Integer>(Collections.nCopies(arrays.size(), 0));
			while(true) {
				List<Item> smallestItems = new ArrayList<Item>();
				for(int arrayIdx = 0;arrayIdx < arrays.size();arrayIdx++) {
					List<Integer> relevantArray = arrays.get(arrayIdx);
					int elementIdx = elementIdxs.get(arrayIdx);
					if(elementIdx == relevantArray.size()) continue;
					smallestItems.add(new Item(arrayIdx, relevantArray.get(elementIdx)));
				}
				
				if(smallestItems.size() == 0) break;
				
				Item nextItem = getMinValue(smallestItems);
				sortedList.add(nextItem.num);
				elementIdxs.set(nextItem.arrayIdx, elementIdxs.get(nextItem.arrayIdx) + 1);
			}
			return sortedList;
		}
		
		static class Item {
			public int arrayIdx;
			public int num;
			public Item(int i,int n) {
				arrayIdx = i;
				num = n;
			}
		}
		
		public static Item getMinValue(List<Item> list) {
			int minValueIdx = 0;
			for(int i = 1;i < list.size();i++) {
				if(list.get(i).num < list.get(minValueIdx).num) minValueIdx = i;
			}
			return list.get(minValueIdx);
		}

}
