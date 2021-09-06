package mIcrosoft.random;
import java.util.*;

public class RemoveAllAdjacentDuplicates {
	
	// TLE solution
	 public String removeDuplicates(String s) {
         if(s.length() < 1) return s;
         
         StringBuilder str = new StringBuilder();
         int idx = 0;
         boolean foundDuplicates = false;
         while(idx < s.length() - 1) {
                 char ch = s.charAt(idx);
                 char ch1 = s.charAt(idx + 1);
                 if(ch == ch1){
                     idx += 2;
                      foundDuplicates = true;
                 }else{
                     str.append(ch);
                     idx++;
                 }
         }
     
     // Forgot to update last character
     if(idx == s.length() - 1) str.append(s.charAt(idx));
     
     // Forgot to handle recursion stop
     if(!foundDuplicates) return s;
     
     return removeDuplicates(str.toString());
 }
	 
	 
	 
	 public String removeDuplicatesBest(String s) {
         Stack<Character> stack = new Stack<>();
          int  idx = 0;
          while(idx < s.length()) {
                  char ch = s.charAt(idx);
                  if(stack.isEmpty() || stack.peek() != ch) {
                      stack.push(ch);
                  }else if(stack.peek() == ch){
                      stack.pop();
                  }
              idx++;
          }
      
      StringBuilder str = new StringBuilder();
      
      while(!stack.isEmpty()) {
              str.append(stack.pop());
      }
      
      return str.reverse().toString();
  }

}
