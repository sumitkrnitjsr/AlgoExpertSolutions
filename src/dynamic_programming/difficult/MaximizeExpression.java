package dynamic_programming.difficult;
import java.util.*;

public class MaximizeExpression {
	
	 public static int maximizeExpression(int[] array) {
		    // Write your code here.
				if(array.length < 4) return 0;
				ArrayList<Integer> a = new ArrayList<>();
				ArrayList<Integer> ab = new ArrayList<>();
				ArrayList<Integer> abc = new ArrayList<>();
				ArrayList<Integer> abcd = new ArrayList<>();
				
				a.add(array[0]);
				for(int idx = 1;idx < array.length;idx++) 
						a.add(Math.max(a.get(idx - 1), array[idx]));
				
				ab.add(Integer.MIN_VALUE);
				for(int idx = 1;idx < array.length;idx++) 
						ab.add(Math.max(ab.get(idx - 1), a.get(idx - 1) - array[idx]));
				
				abc.add(Integer.MIN_VALUE);abc.add(Integer.MIN_VALUE);
				for(int idx = 2;idx < array.length;idx++) 
						abc.add(Math.max(abc.get(idx - 1), ab.get(idx - 1) + array[idx]));
				
				abcd.add(Integer.MIN_VALUE);abcd.add(Integer.MIN_VALUE);abcd.add(Integer.MIN_VALUE);
				for(int idx = 3;idx < array.length;idx++) 
						abcd.add(Math.max(abcd.get(idx - 1), abc.get(idx - 1) - array[idx]));
				
				return abcd.get(abcd.size() - 1);
				
		  }
	  
	  public static void main(String[] args) {
		  int[] array = {1,2,3,4,5,6,7,8,8};
		  System.out.println(maximizeExpression(array));
	  }

}
