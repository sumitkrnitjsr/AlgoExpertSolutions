package linkedlist.medium;

public class Sum_Of_Linked_List {
	
	 // This is an input class. Do not edit.
	  public static class LinkedList {
	    public int value;
	    public LinkedList next;

	    public LinkedList(int value) {
	      this.value = value;
	      this.next = null;
	    }
	  }

	  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
	    // Write your code here.
			LinkedList result = null;
			LinkedList answer = null;
			LinkedList first = linkedListOne;
			LinkedList second = linkedListTwo;
			int carry  = 0;
			int sum = 0;
			
			while(first != null || second != null || carry != 0){
						if(first != null){
								sum += first.value;
						}
						if(second != null){
								sum += second.value;
						}
						sum += carry;
						carry = sum/10;
						sum = sum%10;
						LinkedList temp = new LinkedList(sum);
						if(result == null){
							result = temp;
							answer = result;
						}else{
								result.next = temp;
								result = result.next;
						}
						if(first != null) {
							first = first.next;	
						}
						if(second != null) {
							second = second.next;
						}
						sum = 0;
			}
			
			
	    return answer;
	  }
	  
	  
	  public LinkedList sumOfLinkedLists2(LinkedList listOne, LinkedList listTwo) {
		  LinkedList newLinkedListHeadPointer = new LinkedList(0);
		  LinkedList currentNode = newLinkedListHeadPointer;
		  int carry = 0;
		  
		  LinkedList nodeOne = listOne;
		  LinkedList nodeTwo = listTwo;
		  
		  while(nodeOne != null || nodeTwo != null || carry != 0) {
			  int valueOne = (nodeOne != null)?nodeOne.value:0;
			  int valueTwo = (nodeTwo != null)?nodeTwo.value:0;
			  int sumOfValues = valueOne + valueTwo + carry;
			  
			  int newValue = sumOfValues % 10;
			  LinkedList newNode = new LinkedList(newValue);
			  currentNode.next = newNode;
			  currentNode = newNode;
			  
			  carry = sumOfValues/10;
			  nodeOne = (nodeOne != null) ? nodeOne.next : null;
			  nodeTwo = (nodeTwo != null) ? nodeTwo.next : null;
			  
		  }
		  
		  return newLinkedListHeadPointer;
	  }

}
