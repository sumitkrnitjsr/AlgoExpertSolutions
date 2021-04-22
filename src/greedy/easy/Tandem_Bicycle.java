package greedy.easy;
import java.util.Arrays;

public class Tandem_Bicycle {

	
	 public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
	    	Arrays.sort(redShirtSpeeds);
				Arrays.sort(blueShirtSpeeds);
				int fastestSpeed = 0;
				int slowestSpeed = 0;
		
					for(int i = 0;i < redShirtSpeeds.length;i++){
						slowestSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
						fastestSpeed +=  Math.max(redShirtSpeeds[i], blueShirtSpeeds[redShirtSpeeds.length - 1 - i]);
					}
					 
	    return fastest?fastestSpeed:slowestSpeed;
	  }
}
