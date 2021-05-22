package search.difficult;

public class Index_Equals_Value {
	
	public int indexEqualsValue(int[] array) {
	    // Write your code here.
			int left = 0;
			int right = array.length - 1;
			// don't forget to add <= 
			while(left <= right) {
					int mid = (left + right) / 2;
					if(array[mid] == mid && (mid == 0 || array[mid - 1] != mid - 1)){
							return mid;
					}
					if(array[mid] >= mid) {
							right = mid - 1;
					}else {
							left = mid + 1;
					}
			}
				
	    return -1;
	  }

}
