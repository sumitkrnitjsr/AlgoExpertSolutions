package search.difficult;

public class Range_Search {
	
	 public static int[] searchForRange(int[] array, int target) {
		    // Write your code here.
				int left = -1;
				int right = -1;
				
				int mid = getFirstIdx(array, target, 0, array.length - 1);
				
				if(mid == -1) return new int[] {left, right};
				
				if(mid == 0 || (array[mid] > array[mid - 1])){
						left = mid;
				}else {
						left = findLeftIdx(array, target,0, mid,true);	
				}
				
				if(mid == array.length - 1 || (array[mid] < array[mid + 1])) {
						right = mid;
				}else {
						right = findLeftIdx(array, target, mid + 1, array.length - 1, false);	
				}
				
		    return new int[] {left, right};
		  }
			
			private static int getFirstIdx(int[] array,int target,int i,int j) {
						if(i > j) return -1;
						int mid = (i + j) / 2;
						if(array[mid] == target) return mid;
						if(array[mid] > target)
								return getFirstIdx(array, target, i, mid - 1);
						return getFirstIdx(array, target, mid + 1, j);
			}
			
			private static int findLeftIdx(int[] array,int target, int start,int end,boolean left) {
							if(start > end) return -1;
							int mid = (start + end) / 2;
							boolean isTarget = array[mid] == target;
							boolean leftCondition = mid == 0 || array[mid] > array[mid - 1];
							boolean rightCondition = mid == array.length - 1 || array[mid] < array[mid + 1];
							
							boolean isResult = isTarget && ((left && leftCondition)
																							|| (!left && rightCondition));
							if(isResult) return mid;
				
							boolean leftSide = (!isTarget && left) || (!left && isTarget);
							if(leftSide) {
									return findLeftIdx(array, target, mid + 1, end, left);
							}else{
									return findLeftIdx(array, target, start, mid - 1, left);
							}
						
			}
			
			public int[] searchForRange2(int[] array,int target) {
					int[] finalRange = {-1, -1};
					alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
					alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
					return finalRange;
			}
			
			public void alteredBinarySearch(int[] array, int target, int left,int right, int[] finalRange, boolean goLeft) {
				
				if(left > right) return;
				int mid = (left + right) / 2;
				
				if(array[mid] < target){
					alteredBinarySearch(array, target, mid + 1, right, finalRange,goLeft);
				} else if(array[mid] > target) {
					alteredBinarySearch(array, target,left, mid - 1, finalRange,goLeft);
				}else {
					if(goLeft) {
						if(mid == 0 || array[mid -1] != target) {
							finalRange[0] = mid;
						}else {
							alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft); 
						}
					}else {
						if(mid == array.length - 1 || array[mid + 1] != target) {
							finalRange[1] = mid;
						}else {
							alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
						}
					}
				}
			}
			
			public int[] searchForRange3(int[] array,int target) {
				int[] finalRange = {-1,-1};
				alteredBinarySearch(array, target,0, array.length - 1, finalRange, true);
				alteredBinarySearch(array, target,0, array.length - 1, finalRange, false);
				return finalRange;
			}
			
			public void alteredBinarySearch2(int[] array,int target, int left,int right,int[] finalRange, boolean goLeft) {
				
				while(left < right) {
					int mid = (left + right) / 2;
					if(array[mid] < target) {
						left = mid + 1;
					}else if(array[mid] > target) {
						right = mid - 1;
					}else {
						if(goLeft) {
							if(mid == 0 || array[mid - 1] != target) {
								finalRange[0] = mid;
								return;
							}else {
								right = mid - 1;
							}
						}else {
							if(mid == array.length - 1 || array[mid + 1] != target) {
								finalRange[1] = mid;
								return;
							}else {
								left = mid + 1;
							}
						}
					}
				}
			}
 
}
