package string.medium;
import java.util.*;

public class Reverse_Words_String {

	
	 public String reverseWordsInString(String string) {
		    // Write your code here.
				Stack<String> stack = new Stack<>();
				String reversedString = "";
				int idx = 0;
				while(idx < string.length()) {
						String word = "";
						while(idx < string.length() && string.charAt(idx) == ' ')	{
								word = word + " ";
								idx++;
						}
						if(word.length() > 0) {
								stack.push(word);
						}
						word = "";
						while((idx < string.length() && string.charAt(idx) != ' ')){
										word = word + string.charAt(idx);
										idx++;
						}
						stack.push(word);
				}
		    
				while(!stack.isEmpty()) {
						reversedString = reversedString + stack.pop();
				}
				
				return reversedString;
		}
}
