package recursion.medium;
import java.util.*;

public class Phone_Number_Mnemonics2 {
	
	public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();
	
	static {
		DIGIT_LETTERS.put('0', new String[] {"0"});
		DIGIT_LETTERS.put('1', new String[] {"1"});
		DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
		DIGIT_LETTERS.put('3', new String[] {"d","e","f"});
		DIGIT_LETTERS.put('4', new String[] {"g","h","i"});
		DIGIT_LETTERS.put('5', new String[] {"j","k","l"});
		DIGIT_LETTERS.put('6', new String[] {"m","n","o"});
		DIGIT_LETTERS.put('7', new String[] {"p","q","r","s"});
		DIGIT_LETTERS.put('8', new String[] {"t","u","v"});
		DIGIT_LETTERS.put('9', new String[] {"w","x","y","z"});
	}
	
	public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
			String[] currentMnemonic = new String[phoneNumber.length()];
			Arrays.fill(currentMnemonic, "0");
			
			ArrayList<String> mnemonicsFound = new ArrayList<>();
			phoneNumberMnemonicHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);
			return mnemonicsFound;
	}
	
	private static void phoneNumberMnemonicHelper(int idx, String phoneNumber, String[] currentMnemonic
			, ArrayList<String> mnemonicsFound) {
		
		if(idx == phoneNumber.length()) {
				String mnemonic = String.join("", currentMnemonic);
				mnemonicsFound.add(mnemonic);
		}else {
			char digit = phoneNumber.charAt(idx);
			String[] letters = DIGIT_LETTERS.get(digit);
			for(String letter :letters) {
				currentMnemonic[idx] = letter;
				phoneNumberMnemonicHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
			}
		}
	}

}
