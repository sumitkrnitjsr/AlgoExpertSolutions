package linkedlist.easy;

public class Remove_Duplicate {

		
	 // This is an input class. Do not edit.
	  public static class LinkedList {
	    public int value;
	    public LinkedList next;

	    public LinkedList(int value) {
	      this.value = value;
	      this.next = null;
	    }
	  }

	  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
				if(linkedList == null || linkedList.next == null){
					return linkedList;
				}
	    
				while(linkedList.next != null && linkedList.value == linkedList.next.value){
							linkedList.next = linkedList.next.next;
				}
				
				removeDuplicatesFromLinkedList(linkedList.next);
			
				return linkedList;
	  }
	  
	  public LinkedList removeDuplicatesFromLinkedListBest(LinkedList linkedList) {
		  
		  LinkedList currentNode = linkedList;
		  while(currentNode != null) {
			  LinkedList nextDistinctNode = currentNode.next;
			  
			  while(nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
				  nextDistinctNode = nextDistinctNode.next;
			  }
			  
			  currentNode.next = nextDistinctNode;
			  currentNode = nextDistinctNode;
		  }
		  
		  return linkedList;
	  }
	  
	  
}
