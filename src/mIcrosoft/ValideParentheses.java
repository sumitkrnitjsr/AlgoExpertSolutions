package mIcrosoft;
import java.util.*;

public class ValideParentheses {

	
	public boolean isValid(String s) {   
        Stack<Character> brackets = new Stack<>();
        HashMap<Character, Character> bracketPair = new HashMap<>();
        bracketPair.put('[', ']');
        bracketPair.put('(', ')');
        bracketPair.put('{', '}');
        int idx = 0;
        while(idx < s.length()) {
            char ch = s.charAt(idx);
            if(bracketPair.get(ch) != null) {
                brackets.push(ch);
            }else {
                if(brackets.isEmpty()) return false;
                char topChar = brackets.pop();
                if( ch != bracketPair.get(topChar)) return false;
            }
            idx++;
        }
        
        return brackets.isEmpty();
    }
	
}
