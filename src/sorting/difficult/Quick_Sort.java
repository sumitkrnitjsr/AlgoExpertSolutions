package sorting.difficult;

public class Quick_Sort {
	
	 public static int[] quickSort(int[] array) {
		    // Write your code here.
		    return quickSortHelper(array, 0, array.length - 1);
		  }
			
			private static int[] quickSortHelper(int[] array, int startIndex, int endIndex) {
					if(startIndex < endIndex) {
							int position = getPosition(array, startIndex, endIndex);
							quickSortHelper(array, startIndex, position - 1);
							quickSortHelper(array, position + 1, endIndex);
					}
					return array;
			}
			
			private static int getPosition(int[] array, int startIdx, int endIdx) {
						int pivot = array[startIdx];
						int left = startIdx + 1;
						int right = endIdx;
						
						while(left <= right) {
								while(left <= endIdx && array[left] <= pivot) left++;
								while(right >= startIdx && array[right] > pivot) right--;
								if(left < right) {
										int temp = array[right];
										array[right] = array[left];
										array[left] = temp;
										left++;
										right--;
								}
						}
				
						int position = right;
						array[startIdx] = array[right];
						array[position] = pivot;
						return position;
		}
			
		public static void main(String[] args) {
			int[] array = new int[] {2,15};
			quickSort(array);
			System.out.println(array[0]);
		}
			

}
