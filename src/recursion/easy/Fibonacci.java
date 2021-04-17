package recursion.easy;

public class Fibonacci {
	
	public static int getNthFib(int n) {
	    // Write your code here.
			if(n == 1){
				return 0;
			}
			if(n == 2 || n == 3){
				return 1;
			}
			
	    return getNthFib(n-1) + getNthFib(n-2);
	  }
	
	public static int getNthFibCached(int n) {
    	if(n == 1){ 
				return 0;
			}
			int[] fib = new int[n + 1];
			fib[1] = 0;
			fib[2] = 1; // To avoid ArrayOutofBoundError
		for(int i = 3;i <= n;i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
    return fib[n];
  }
	
	 public static int getNthFibBest(int n) {
		    // Write your code here.
				int fib1 = 0;
				int fib2 = 1;
				if(n == 1){
					return fib1;
				}
				if(n == 2){
					return fib2;
				}
				int fib = 1;
				for(int i = 3;i <= n;i++){
						fib = fib1 + fib2;
						fib1 = fib2;
						fib2 = fib;
				}
		    return fib;
		  }

}
