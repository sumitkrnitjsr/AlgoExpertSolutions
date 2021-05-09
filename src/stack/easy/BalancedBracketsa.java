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
			
			private static boolean balancedBrackets2(String str) {
					String openingBrackets = "([{";
					String closingBrackets = ")]}";
					Map<Character, Character> matchingBrackets = new HashMap<>();
					matchingBrackets.put(')','(');
					matchingBrackets.put(']','[');
					matchingBrackets.put('}','{');
					List<Character> stack = new ArrayList<>();
					for(int i = 0;i < str.length();i++) {
						char letter = str.charAt(i);
						if(openingBrackets.indexOf(letter) != -1) {
							stack.add(letter);
						} else if(closingBrackets.indexOf(letter) != -1) {
							if(stack.size() == 0) {
								return false;
							}
							
							if(stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {
								stack.remove(stack.size() - 1);
							}else {
								return false;
							}
						}
					}
					
					return stack.size() == 0;
			}

}
