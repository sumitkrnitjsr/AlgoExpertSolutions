package recursion.difficult;
import java.util.*;

public class GenerateDivTags {
	
	private String openTag = "<div>";
	private String closeTag = "</div>";
	
  public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
		ArrayList<String> divTags = new ArrayList<>();
		generateTags(0, 0, numberOfTags, "", divTags);
    return divTags;
  }
	
	private void generateTags(int numOpen,int numClose, int total, String str, ArrayList<String> list) {
			if(numOpen < total)	 {
					generateTags(numOpen + 1, numClose,total ,  str + openTag, list);
			}
			if(numOpen > numClose)	 {
					generateTags(numOpen, numClose + 1,total , str + closeTag, list);
			}
			if(numClose == total) list.add(str);
	}

}
