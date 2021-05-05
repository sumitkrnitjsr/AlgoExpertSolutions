package codility;
import java.util.*;

public class Juice_Mix {
	
	 public int solution(int[] juice, int[] capacity) {
	        // write your code in Java SE 8
	        capacityInfo[] leftCapacity = new capacityInfo[juice.length];
	        capacityInfo[] juiceInfo = new capacityInfo[juice.length];

	        for(int i = 0;i < juice.length;i++) {
	            juiceInfo[i] = new capacityInfo();
	            leftCapacity[i] = new capacityInfo();
	            juiceInfo[i].index = leftCapacity[i].index = i;
	            juiceInfo[i].leftCapacity = juice[i];
	            leftCapacity[i].leftCapacity = capacity[i] - juice[i];
	        }
	        
	        Arrays.sort(leftCapacity);
	        Arrays.sort(juiceInfo);

	        
	        int maxCount = 0;

	        for(int i = 0;i < juice.length;i++) {
	        int count = 1;
	        int maxIndex = i;
	        int minIndex = 0;

	        while(minIndex < juice.length && leftCapacity[maxIndex].leftCapacity > 0) {
	                if(leftCapacity[maxIndex].index == juiceInfo[minIndex].index) {
	                    minIndex++;
	                    continue;
	                }
	                if(leftCapacity[maxIndex].leftCapacity - juiceInfo[minIndex].leftCapacity >= 0) {
	                    count++;
	                   leftCapacity[maxIndex].leftCapacity -= juiceInfo[minIndex].leftCapacity;
	                }
	                minIndex++; 
	            }
	            if(count > maxCount) {
	                maxCount = count;
	            }

	        }

	        return maxCount;
	    }

	    class capacityInfo implements Comparable<capacityInfo> {

	        int index;
	        int leftCapacity;

	        public capacityInfo() {}
	        public capacityInfo(int index,int capacity) {
	        	this.index = index;
	        	this.leftCapacity = capacity;
	        }
	        public int compareTo(capacityInfo info) {
	            return (this.leftCapacity - info.leftCapacity);
	        }
	}

}
