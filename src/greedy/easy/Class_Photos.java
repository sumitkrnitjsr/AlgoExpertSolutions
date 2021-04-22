package greedy.easy;
import java.util.*;

public class Class_Photos {
	
	 public boolean classPhotos(
		      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		    		Collections.sort(redShirtHeights);
						Collections.sort(blueShirtHeights);
						boolean[] possible = {true, true};
						for(int i = 0;i < redShirtHeights.size(); i++){
								if(redShirtHeights.get(i) < blueShirtHeights.get(i)){
									possible[0] = false;
								}else if(redShirtHeights.get(i) > blueShirtHeights.get(i)){
									possible[1] = false;
								}else{
									possible[0] = possible[1] = false;
									break;
								}
						}
						
		    return possible[0] || possible[1];
		  }

}
