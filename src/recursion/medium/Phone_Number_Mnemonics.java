package recursion.medium;
import java.util.*;

public class Phone_Number_Mnemonics {
	
	 public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
		    // Write your code here.
				HashMap<Integer, ArrayList<Character>> charMap = new HashMap<>();
				createMap(charMap);
				ArrayList<String> mnemonics = new ArrayList<>();
				createMnemonics(mnemonics, charMap,phoneNumber, 0, "");
		    return mnemonics;
		  }
			
			private static void createMnemonics(ArrayList<String> mnemonics,
																				 HashMap<Integer, ArrayList<Character>> charMap,
																				 String phoneNumber, int idx,
																				 String mnemonic){
				if(idx == phoneNumber.length()) { // Wrong code check  idx == phoneNumber.length() - 1
					mnemonics.add(mnemonic);
					return;
				}
				
				int digit = Character.getNumericValue(phoneNumber.charAt(idx));
				ArrayList<Character> chars = charMap.get(digit);
				for(Character ch: chars) {
						String nextString = mnemonic + Character.toString(ch);
						createMnemonics(mnemonics, charMap,phoneNumber, idx + 1, nextString);	
				}
			}
			
			private static void createMap(HashMap<Integer, ArrayList<Character>> map) {
					
					char first = 'a';
					int key = 0;
					while(key < 10){
					int numOfChar = (key == 7 || key == 9)?4:3;
					ArrayList<Character> list = new ArrayList<>();
					if(key == 0 || key == 1) {
							numOfChar = 0;
							list.add(new Character((char)('0' + key)));
					}
					int idx = 0;
					for(;idx < numOfChar;idx++) {
							list.add(new Character((char)(first + idx)));
					}
					first = (char)(first + idx);
					map.put(key, list);
					key++;
			}
			}

}
