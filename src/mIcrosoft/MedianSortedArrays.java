package mIcrosoft;

public class MedianSortedArrays {
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int m = nums1.length;
	        int n = nums2.length;
	        int mid = (m + n)  / 2;
	        int mid1, mid2;
	        if((m + n) % 2 == 0) {
	            mid1 = mid - 1;
	            mid2 = mid;
	        }else {
	            mid1 = mid2 = mid;
	        }
	        int idx = -1;
	        int idx1 = 0;
	        int idx2 = 0;
	        int median = 0;
	        while(idx1 < m || idx2 < n) {
	                int medianNum = 0;
	                if(idx2 >= n || (idx1 < m && nums1[idx1] < nums2[idx2])) {
	                    medianNum = nums1[idx1];
	                    idx1++;
	                }else{
	                    medianNum = nums2[idx2];
	                    idx2++;
	                }
	                idx++;
	                 if(idx == mid1) {
	                    median += medianNum;
	                }
	                if(idx == mid2) {
	                    median += medianNum;
	                    break;
	                }
	        }
	        
	        return median / 2.0;
	 }
	 
	 public double findMedianSortedArraysBest(int[] A, int[] B) {
		    int m = A.length, n = B.length;
		    int l = (m + n + 1) / 2;
		    int r = (m + n + 2) / 2;
		    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
		}

	public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1) return B[bStart + k - 1];            
		if (bStart > B.length - 1) return A[aStart + k - 1];                
		if (k == 1) return Math.min(A[aStart], B[bStart]);
		
		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
		if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
		
		if (aMid < bMid) 
		    return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
		else 
		    return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
	}

}
