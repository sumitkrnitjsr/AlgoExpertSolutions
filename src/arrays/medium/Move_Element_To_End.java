package arrays.medium;
import java.util.*;


public class Move_Element_To_End {
	
	 public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		    // Write your code here.
				int Idxothers = 0;
				int IdxtoMove = array.size() - 1;
				
				while(Idxothers < IdxtoMove) {
						while(Idxothers < array.size() && array.get(Idxothers) != toMove) {
								Idxothers++;
						}
					
						while(IdxtoMove >=0 && array.get(IdxtoMove) == toMove) {
								IdxtoMove--;
						}
					
						if(Idxothers < IdxtoMove) { // sequence of checks important
								array.set(Idxothers, array.get(IdxtoMove));
								array.set(IdxtoMove, toMove);
						}
					
						Idxothers++;
						IdxtoMove--;
				}
				
				
				
		    return array;
	}
	 
	public static List<Integer> moveElementToEnd2(List<Integer> array, int toMove) {
			int i = 0;
			int j = array.size() - 1;
			while(i < j) {
				
				while(i < j && array.get(j) == toMove) j--;
				if(array.get(i) == toMove) swap(i, j, array);
				i++;
			}
			return array;
	}
	
	private static void swap(int i,int j, List<Integer> array) {
		int temp = array.get(i);
		array.set(j, array.get(i));
		array.set(i, temp);
	}

}
