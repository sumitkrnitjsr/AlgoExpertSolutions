package stack.easy;
import java.util.*;

public class BalancedBracketsa {
	
	 public static boolean balancedBrackets(String str) {
		    // Write your code here.
				Stack<Character> stack = new Stack<>();
				int Idx = 0;
				while(Idx < str.length()) {
						char ch = str.charAt(Idx);
						boolean result = checkAndUpdate(stack, ch);
						if(!result) {
								return result;
						}
						Idx++;
				}
				
				if(!stack.isEmpty()) { // Forgot to handle additional brackets which are unbalanced
						return false;
				}
				
		    return true;
		  }
			
			private static boolean checkAndUpdate(Stack<Character> stack, char ch) {
					
					Character topChar = null;
					if(!stack.isEmpty()) {
							topChar = stack.peek();
					}
				
					switch(ch) {
							case '(' : 
							case '[' : 
							case '{' : 
									stack.add(new Character(ch));
									return true;
							case ')' :
								if(topChar == null || topChar != '(')
										return false;
									stack.pop();
									return true;
							case ']' : 
								if(topChar == null || topChar != '[')
										return false;
									stack.pop();
									return true;
							case '}' :
							if(topChar == null || topChar != '{')
										return false;
									stack.pop();
									return true;
							default : 
								return true;
					}
			}

}
