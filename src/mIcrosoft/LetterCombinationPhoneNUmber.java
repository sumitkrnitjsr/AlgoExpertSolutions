package mIcrosoft;
import java.util.*;

public class LetterCombinationPhoneNUmber {
	
	
	 public List<String> letterCombinations1(String digits) {
	        List<String> allCombinations = new ArrayList<>();
	        List<String> temp = new ArrayList<>();
	        for(int i = 0;i < digits.length();i++) {
	            
	                char ch = digits.charAt(i);
	                List<Character> chars = numToChar(ch);
	            
	                if(allCombinations.size() == 0) {
	                    for(Character character: chars) {
	                            temp.add(Character.toString(character));
	                    }
	                }else {
	                    for(String combination: allCombinations) {
	                        for(Character character: chars) {
	                        temp.add(combination + Character.toString(character));
	                    }
	                    }
	                }
	                // temp.addAll(allCombinations);
	                allCombinations.clear();
	                allCombinations.addAll(temp);
	                temp.clear();
	        }
	        
	        return allCombinations;
	    }
	    
	    public List<Character> numToChar(char num) {
	        List<Character> charList = new ArrayList<>();
	        
	        switch(num) {
	                
	                case '2' : 
	                    charList.add('a'); charList.add('b'); charList.add('c');
	                    break;
	                case '3' : 
	                    charList.add('d'); charList.add('e'); charList.add('f');
	                    break;
	                case '4' : 
	                    charList.add('g'); charList.add('h'); charList.add('i');
	                    break;
	                case '5' : 
	                    charList.add('j'); charList.add('k'); charList.add('l');
	                    break;
	                case '6' : 
	                    charList.add('m'); charList.add('n'); charList.add('o');
	                    break;
	                case '7' : 
	                    charList.add('p'); charList.add('q'); charList.add('r'); charList.add('s');
	                    break;
	                case '8' : 
	                    charList.add('t'); charList.add('u'); charList.add('v');
	                    break;
	                case '9' : 
	                    charList.add('w'); charList.add('x'); charList.add('y'); charList.add('z');
	                    break;
	                
	        }
	        
	        return charList;
	    }
	    
	

	    private List<String> combinations = new ArrayList<>();
	    private Map<Character, String> letters = Map.of(
	        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
	        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
	    private String phoneDigits;
	    
	    public List<String> letterCombinations(String digits) {
	        // If the input is empty, immediately return an empty answer array
	        if (digits.length() == 0) {
	            return combinations;
	        }
	        
	        // Initiate backtracking with an empty path and starting index of 0
	        phoneDigits = digits;
	        backtrack(0, new StringBuilder());
	        return combinations;
	    }
	    
	    private void backtrack(int index, StringBuilder path) {
	        // If the path is the same length as digits, we have a complete combination
	        if (path.length() == phoneDigits.length()) {
	            combinations.add(path.toString());
	            return; // Backtrack
	        }
	        
	        // Get the letters that the current digit maps to, and loop through them
	        String possibleLetters = letters.get(phoneDigits.charAt(index));
	        for (char letter: possibleLetters.toCharArray()) {
	            // Add the letter to our current path
	            path.append(letter);
	            // Move on to the next digit
	            backtrack(index + 1, path);
	            // Backtrack by removing the letter before moving onto the next
	            path.deleteCharAt(path.length() - 1);
	        }
	    }
	

}
