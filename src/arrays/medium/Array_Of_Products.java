package arrays.medium;

public class Array_Of_Products {
	
	 public int[] arrayOfProducts(int[] array) {
		    // Write your code here.
				int[] result = new int[array.length];
				
				for(int i = 0;i < array.length;i++) {
						result[i] = 1;
				}
					
				
				for(int i = 0;i < array.length;i++) {
						for(int j = 0;j < array.length;j++) {
								if(i == j) continue;
									result[i] *= array[j];
						}
				}
				
		    return result;
	}
	 
	 
	 public int[] arrayOfProducts2(int[] array) {
		    // Write your code here.
				int[] leftProduct = new int[array.length];
				int[] rightProduct = new int[array.length];
				leftProduct[0] = 1;
				for(int i = 1;i < array.length;i++) {
						leftProduct[i] = leftProduct[i - 1] * array[i - 1];
				}
				
				rightProduct[array.length - 1] = 1;
				
				for(int j = array.length - 2;j >= 0;j--) {
						rightProduct[j] = rightProduct[j + 1] * array[j + 1];
				}
				
				int[] productArray = new int[array.length];
				
				for(int i = 0;i < array.length;i++) {
						productArray[i] = leftProduct[i] * rightProduct[i];
				}
				
		    return productArray;
				
	}
	 
	 
	 public int[] arrayOfProductsBest(int[] array) {
		 	int[] products = new int[array.length];
		 	
		 	int leftRunningProduct = 1;
		 	
		 	for(int i = 0;i < array.length;i++) {
		 		products[i] = leftRunningProduct;
		 		leftRunningProduct *= array[i];
		 	}
		 	
		 	int rightRunningProduct = 1;
		 	for(int j = array.length - 1;j >= 0;j--) {
		 		products[j] *= rightRunningProduct;
		 		rightRunningProduct *= array[j];
		 	}
		 	
		 	return products;
	 }

}
