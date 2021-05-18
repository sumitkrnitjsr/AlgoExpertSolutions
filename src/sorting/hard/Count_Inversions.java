package sorting.hard;

public class Count_Inversions {
	
	 public int countInversions(int[] array) {
		    // Write your code here.
				int count = 0;
				for(int i = 0;i < array.length;i++) {
					for(int j = i+ 1;j < array.length;j++) {
							if(array[i] > array[j]) {
								count++;
							}
					}
				}
		    return count;
	}
	 
	 public int countInversionsBest(int[] array) {
		    // Write your code here.
		    return countInversions(array, 0, array.length - 1);
		  }
			
			private int countInversions(int[] array,int startIdx,int endIdx) {
					int count = 0;
					if(startIdx < endIdx) {
						int mid = startIdx + (endIdx - startIdx) / 2;
						//Forgot to add leftCount && rightCount
						int leftCount = countInversions(array, startIdx, mid);
						int rightCount = countInversions(array, mid + 1, endIdx);
						return leftCount + rightCount + mergeCount(array, startIdx, mid, endIdx);
					}
					return count;
			}
			
			private int mergeCount(int[] array,int startIdx,int midIdx,int endIdx) {
					int count = 0;
					int[] temp = new int[endIdx - startIdx + 1];
					int firstIdx = startIdx;
					int secondIdx = midIdx + 1;
					int idx = 0;
				
					while(firstIdx <= midIdx && secondIdx <= endIdx) {
								if(array[firstIdx] > array[secondIdx]) {
									count += (midIdx - firstIdx + 1);
									temp[idx] = array[secondIdx];
									idx++; secondIdx++;
								}else {
									temp[idx] = array[firstIdx];
									idx++; firstIdx++;
								}
					}
				
					while(firstIdx <= midIdx) {
									temp[idx] = array[firstIdx];
									idx++; firstIdx++;
					}
				
					while(secondIdx <= endIdx) {
							temp[idx] = array[secondIdx];
							idx++; secondIdx++;
					}
				
					for(int i = 0;i < temp.length;i++) {
							array[startIdx + i] = temp[i];
					}
				
				return count;
			}
			

}
