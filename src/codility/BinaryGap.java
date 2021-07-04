package codility;

/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

*/


public class BinaryGap {
	
	 public int solution(int N) {
	        // write your code in Java SE 8
	        if(N < 5) return 0;
	        int count = 0;
	        int maxCount = 0;
	        boolean visited = false;

	        while(N > 0) {
	            int bit = N%2;
	            N /= 2;
	            if(bit == 1) {
	                if(count > 0) {
	                    maxCount = Math.max(count, maxCount);
	                    count = 0;
	                }
	                visited = true;
	            }else {
	                if(visited ) {
	                    count++;
	                }   
	            }
	        }

	        return maxCount;
	    }

}
