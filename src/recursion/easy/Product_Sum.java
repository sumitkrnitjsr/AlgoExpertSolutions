package recursion.easy;
import java.util.*;

public class Product_Sum {
	
	
	public static int productSum(List<Object> array) {
		    // Write your code here.
				return productSum(array, 1);
	}
			
	
	
	private static int productSum(List<Object> array, int level) {
					int sum = 0;
					for(Object element : array) {
						
						if(element instanceof List<?>) {
							int childSum = productSum((List<Object>)element, level + 1);
							sum += childSum;
						}else {
							sum += (Integer)element;
						}
						
				}
		    return sum * level;
	}
	
	

}
