package search.difficult;

public class Shifted_Binary_Search {
	
	 public static int shiftedBinarySearch(int[] array, int target) {
		    // Write your code here.
				int mid = getMaxIdx(array);
				int firstIdx = binSearch(array, 0, mid, target);
				int secondIdx = binSearch(array, mid + 1, array.length - 1, target);
				
		    return Math.max(firstIdx, secondIdx);
		  }
			
			private static int getMaxIdx(int[] array) {
						int left = 0;
						int right = array.length - 1;
						while(left <= right) {
								int mid = (left + right) / 2;
								int prev = mid == 0 ? array.length - 1 : mid - 1;
								int next = mid == array.length - 1 ? 0 : mid + 1;
							
								if(array[prev] < array[mid] && array[next] < array[mid]) {
										return mid;
								}
								
								if(mid == 0) {
										left = mid + 1;
								}else if(mid == array.length - 1){
										right = mid - 1;
								}else {
										// The most important part of logic
										if(array[mid] < array[right] && array[right] < array[left]) {
												right = mid - 1;
										}else {
												left = mid + 1;
										}
								}
						}
				
				 return -1;
			}
			
			private static int binSearch(int[] array,int startIdx,int endIdx,int target) {
							while(startIdx <= endIdx) {
									int mid = (startIdx + endIdx) / 2;
									if(array[mid] == target) {
											return mid;
									}
									if(array[mid] < target) {
											startIdx = mid + 1;
									}else {
											endIdx = mid - 1;
									}
							}
							return -1;
			}
			
			private int shiftedBinarySearch(int[] array, int target,int left,int right) {
					if(left > right) return -1;
					
					int middle = (left + right) / 2;
					int potentialMatch = array[middle];
					int leftNum = array[left];
					int rightNum = array[right];
					if(target == potentialMatch) {
						return middle;
					}else if(leftNum <= potentialMatch) {
						if(target < potentialMatch && target >= leftNum) {
							return shiftedBinarySearch(array, target, left, middle - 1);
						}else {
							return shiftedBinarySearch(array, target, middle + 1, right);
						}
					}else {
						if(target > potentialMatch && target <= rightNum) {
							return shiftedBinarySearch(array, target, middle + 1, right);
						}else {
							return shiftedBinarySearch(array, target,left, middle - 1);
						}
					}
							
			}
			
			private int shiftedBinarySearch2(int[] array,int target,int left,int right) {
				
				while(left <= right) {
					int middle = (left + right) / 2;
					int potentialMatch = array[middle];
					int leftNum = array[left];
					int rightNum = array[right];	
					if(target == potentialMatch) {
						return middle;
					}else if(leftNum <= potentialMatch) {
						if(target < potentialMatch && target >= leftNum) {
							right = middle - 1;
						}else {
							left = middle + 1;
						}
					}else {
						if(target > potentialMatch && target <= rightNum) {
							left = middle + 1;
						}else {
							right = middle - 1;
						}
					}
				}
				
				return -1;
			}

}
