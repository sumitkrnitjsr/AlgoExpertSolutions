package sorting.medium;

public class Three_Number_Sort {
	
	 public int[] threeNumberSort(int[] array, int[] order) {
	    	int[] count = new int[3];
				
				for(int i = 0;i < array.length;i++){
						int orderIndex = -1;
						if(array[i] == order[0]){
							orderIndex = 0;
						}else if(array[i] == order[1]){
							orderIndex = 1;
						}else{
							orderIndex = 2;
						}
						count[orderIndex]++;
				}
			
				for(int i = 0;i < array.length;i++){
						if(count[0] != 0){
							array[i] = order[0];
							count[0]--;
						}else if (count[1] != 0){
							array[i] = order[1];
							count[1]--;
						}else{
							array[i] = order[2];
						}
				}
			
			
	    return array;
	  }
	 
	 public int[] threeNumberSort2(int[] array, int[] order) {
	    	int[] valueCounts  = new int[3];
	    	for(int element: array) {
	    		int orderIdx = getIndex(order,element);
	    		valueCounts[orderIdx]++;
	    	}
	    	
	    	for(int i = 0;i < 3;i++) {
	    		int value = order[i];
	    		int count = valueCounts[i];
	    		
	    		int numElementsBefore = getSum(valueCounts, i);
	    		
	    		for(int n = 0;n < count;n++) {
	    			int currentIdx = numElementsBefore + n;
	    			array[currentIdx] = value;
	    		}
	    	}
	    	
	    	return array;
	  }
	 
	 private int getIndex(int[] array, int element) {
		 for(int i = 0;i < array.length;i++) {
			 if(array[i] == element) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
	 private int getSum(int[] array, int index) {
		 int sum = 0;
		 for(int i = 0;i < index;i++) {
			 sum += array[i];
		 }
		 return sum;
	 }

}
