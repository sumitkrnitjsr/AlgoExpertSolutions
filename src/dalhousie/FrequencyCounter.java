package dalhousie;
import java.util.*;


public class FrequencyCounter {
	
	 public static void main(String[] args) {
	        String str;
	        char c;
	        int count;

	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter number of tests: ");
	        int n = sc.nextInt();
	        String words[] = new String[n];
	        sc.nextLine();
	        
	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter word: ");
	            String w = sc.nextLine();
	            words[i] = w;
	        }
	        
	        for(int i=0;i<words.length;i++)
	        {
	            //Implementation start
	            String word = words[i];
	            System.out.print(word + " counts ->  ");
	            int[] chars = new int[26];
	            for(int j = 0;j < word.length();j++) {
	            	char ch = word.charAt(j);
	            	if(ch < 'a' || ch > 'z') continue;
	            	int pos = ch - 'a';
	            	chars[pos]++;
	            }
	            for(int j = 0;j < 26;j++) {
	            	if(chars[j] > 0) {
	            		char ch = (char)('a' + j);
	            		System.out.print(ch + "" + chars[j] + " ");
	            	}
	            }
	            //Implementation end
	            System.out.println();
	        }

	    }

}
