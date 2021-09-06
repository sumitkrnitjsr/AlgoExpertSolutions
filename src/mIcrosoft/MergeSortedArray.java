package mIcrosoft;

public class MergeSortedArray {
	
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        
	        int i, j;
	        for(i = nums1.length - 1, j = m - 1;j >= 0;i--, j--) {
	                nums1[i] = nums1[j];
	        }
	        
	        int itr1 = i + 1;
	        int itr2 = 0;
	        int itr3 = 0;
	        
	        while(itr1 < nums1.length && itr2 < n) {
	                if(nums1[itr1] < nums2[itr2]) {
	                    nums1[itr3] = nums1[itr1];
	                    itr1++;
	                }else {
	                    nums1[itr3] = nums2[itr2];
	                    itr2++;
	                }        
	                itr3++;
	        }
	        
	        while(itr1 < nums1.length) {
	                nums1[itr3] = nums1[itr1];
	                itr1++; itr3++;
	        }
	        
	        while(itr2 < n) {
	                nums1[itr3] = nums2[itr2];
	                itr2++; itr3++;
	        }
	        
	    }
	 
	 
	 	// Start from the end 
		public void mergeBest(int[] nums1, int m, int[] nums2, int n) {
		        // Set p1 and p2 to point to the end of their respective arrays.
		        int p1 = m - 1;
		        int p2 = n - 1;
		        
		        // And move p backwards through the array, each time writing
		        // the smallest value pointed at by p1 or p2.
		        for (int p = m + n - 1; p >= 0; p--) {
		            if (p2 < 0) {
		                break;
		            }
		            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
		                nums1[p] = nums1[p1--];
		            } else {
		                nums1[p] = nums2[p2--];
		            }
		        }
		 }
		

}
