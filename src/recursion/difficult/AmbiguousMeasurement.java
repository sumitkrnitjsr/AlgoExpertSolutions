package recursion.difficult;
import java.util.*;

public class AmbiguousMeasurement {
	
	 public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
		    // Write your code here.
				HashMap<String, Boolean> map = new HashMap<>();
				return tryMeasure(measuringCups, low, high, map);
		  }
			
			private boolean tryMeasure(int[][] cups, int low,int high, HashMap<String, Boolean> map) {
					String key = String.valueOf(low) + ":" + String.valueOf(high);
					if(map.containsKey(key)) return map.get(key);
				
					if(low <= 0 && high <= 0) return false;
				
					boolean canMeasure = false;
					for(int[] cup:cups) {
							if(low <= cup[0] && high >= cup[1]) {
									canMeasure = true;
									break;
							}
							canMeasure = tryMeasure(cups, Math.max(0, low - cup[0]),Math.max(0, high - cup[1]), map);
							if(canMeasure) break;
					}
						map.put(key, canMeasure);
						return canMeasure;
			}

}
