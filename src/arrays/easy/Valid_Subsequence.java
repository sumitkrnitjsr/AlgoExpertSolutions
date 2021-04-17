package arrays.easy;
import java.util.*;


public class Valid_Subsequence {
	
	public static boolean isValidSubsequenceEasiest(List<Integer> array, List<Integer> sequence) {
	    // Write your code here.
			int begin = sequence.get(0);
			for(int i = 0;i < array.size();i++){
					if(array.get(i) ==  begin){
						int index = 1;
						for(int j = i+1;j < array.size() && index < sequence.size();j++){
							if(array.get(j) == sequence.get(index)){
								index++;
							}
						}
						if(index == sequence.size()){
							return true;
						}
					}
			}
	    return false;
	  }
	
	 public static boolean isValidSubsequenceBest(List<Integer> array, List<Integer> sequence) {
		    // Write your code here.
				int index = 0;
				for(int i = 0;i < array.size();i++){
						if(index < sequence.size() && array.get(i) == sequence.get(index)){
							index++;
						}
				}
				
				if(index == sequence.size()){
					return true;
				}
				
		    return false;
		  }

}
