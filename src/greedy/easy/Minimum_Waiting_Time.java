package greedy.easy;
import java.util.*;

public class Minimum_Waiting_Time {
	
	 public int minimumWaitingTime(int[] queries) {
			
			Arrays.sort(queries);
			int waitTime = 0;
		
			for(int i = 0;i < queries.length - 1;i++){
					waitTime	+= ((queries.length - i - 1) * queries[i]);
			}
		
			return waitTime;
	 }

}
