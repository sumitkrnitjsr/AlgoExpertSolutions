package graph.easy;

public class Single_Cycle_Check {
	
	 public static boolean hasSingleCycle(int[] array) {
		    // Write your code here.
				int count = 1;
				int currentIndex = 0;
				int visitedFirstIndex = 1;
				
				while(count < array.length + 1){  // Wrong number of iterations check
							int nextIndex = array[currentIndex];
							boolean negative = (nextIndex < 0);
							nextIndex = Math.abs(nextIndex) % array.length;
							if(!negative){
									nextIndex = (nextIndex + currentIndex);
							}else{
									nextIndex = currentIndex - nextIndex;
									nextIndex = array.length + nextIndex;
							}
							currentIndex = nextIndex % array.length;
							if(currentIndex == 0){
									visitedFirstIndex++; // Didn't check for loop
							}
							count++; 		
				}
				
				if(currentIndex == 0 && visitedFirstIndex == 2){
						return true;
				}
				
		    return false;
	 }
	 
	 
	 public static boolean hasSingleCycle2(int[] array) {
		 int numElementsVisited = 0;
		 int currentIdx = 0;
		 
		 while(numElementsVisited < array.length) {
			 if(numElementsVisited > 0 && currentIdx == 0) return false;
			 numElementsVisited++;
			 currentIdx = getNextIdx(currentIdx, array);
		 }
		 
		 return currentIdx == 0;
	 }
	 
	 
	 
	 private static int getNextIdx(int currentIdx, int[] array) {
		 int jump = array[currentIdx];
		 int nextIdx = (currentIdx + jump) % array.length;
		 return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
	 }

}
