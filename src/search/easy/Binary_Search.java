package search.easy;

public class Binary_Search {
	
	 public static int binarySearch(int[] array, int target) {
		    if(array == null || array.length == 0){
					return -1;
				}
				int left = 0;
				int right = array.length - 1;
				while(left <= right){
					int mid = left + (right - left)/2;
					if(array[mid] == target){
						return mid;
					}
					if(array[mid] > target){
						right = mid - 1;
					}else{
						left = mid + 1;
					}
				}
				
				
		    return -1;
		  }

}
