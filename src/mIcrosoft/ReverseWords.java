package mIcrosoft;

public class ReverseWords {
	
	 public String reverseWords(String s) {
	        if(s.length() == 0) return s;
	        // String[] words = s.split("\\s+");
	        String[] words = s.split(" ");
	        StringBuilder str = new StringBuilder();
	        for(int i = words.length - 1;i >= 0;i--) {
	            if(words[i].trim().length() < 1) continue;
	            str.append(words[i]);
	            str.append(" ");
	        }
	        
	        return str.toString().trim();
	    }
	 
	 public String reverseWords(String s) {
	        Stack<String> stack = new Stack<>();
	        for(int i = 0;i < s.length();i++) {
	            if(s.charAt(i) == ' ') continue;
	            StringBuilder str = new StringBuilder();
	            while(i < s.length() && s.charAt(i) != ' ') {
	                    str.append(s.charAt(i));
	                    i++;
	            }
	            stack.push(str.toString());
	        }
	        
	        StringBuilder str = new StringBuilder();
	        while(!stack.isEmpty()) {
	                str.append(stack.pop());
	                str.append(" ");
	        }
	        return str.toString().trim();
	    }

}
