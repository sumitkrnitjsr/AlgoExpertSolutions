package arrays.difficult;
import java.util.*;


public class LineThroughPoints {
	
	 public int lineThroughPoints(int[][] points) {
		    // Write your code here.
				int maxNumberOfLines = 1;
				
				for(int i = 0;i < points.length;i++) {
						int[] p1 = points[i];
						HashMap<String, Integer> slopes = new HashMap<>();	
					for(int j = i + 1;j < points.length;j++) {
							int[] p2 = points[j];
							int[] slope = new int[] {1, 0};
							if(p1[1] == p2[1]) {
									slope = new int[] {0, 1};
							}else if(p1[0] != p2[0]) {
									slope = gcd(p1[0], p2[0], p1[1], p2[1]);
							}
						  String slopestr = Integer.toString(slope[0]) + ":" + Integer.toString(slope[1]);
							//System.out.println(slopestr);
							if(!slopes.containsKey(slopestr)) {
									slopes.put(slopestr, 1);
							}
							slopes.put(slopestr, slopes.get(slopestr) + 1);
					}
					
							int currentMaxNumberOfpointsOnLine = maxSlope(slopes);
							
							maxNumberOfLines = Math.max(maxNumberOfLines, currentMaxNumberOfpointsOnLine);
				}
		    return maxNumberOfLines;
		  }
			
			private int maxSlope(HashMap<String, Integer> slopes) {
					int currMax = 0;
					for(Map.Entry<String, Integer> slope: slopes.entrySet()) {
							currMax = Math.max(slope.getValue(), currMax);
					}
					return currMax;
			}
			
			private int[] gcd(int a,int b,int c, int d) {
					int numerator = (a - b);
					int denominator = (c - d);
					boolean sign = Integer.signum(numerator) == Integer.signum(denominator);
					int mul = sign ? 1 : -1;
					int gcd = getgcd(Math.abs(numerator), Math.abs(denominator));
					return new int[] {Math.abs(denominator) * mul / gcd,Math.abs(numerator) / gcd };
			}
			
			private int getgcd(int a, int b) {
					if(a == 0) return b;
					if(b == 0) return a;
					int min = Math.min(a, b);
					int max = Math.max(a, b);
				
					int remainder = max % min;
					if(remainder == 0) return min;
				
					return getgcd(min, remainder);
			}
			
			

}
