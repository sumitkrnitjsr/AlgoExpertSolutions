package linkedlist.difficult;

public class Merge_Linked_Lists {
	
	 // This is an input class. Do not edit.
	  public static class LinkedList {
	    int value;
	    LinkedList next;

	    LinkedList(int value) {
	      this.value = value;
	      this.next = null;
	    }
	  }

	  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
	    // Write your code here.
			LinkedList mergedHead = null;
			LinkedList mergedTail = null;
	    return mergeLinkedLists(headOne, headTwo, mergedHead, mergedTail);
	  }
		
		private static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo, LinkedList mergedHead, LinkedList mergedTail) {
						if(headOne == null && headTwo == null){
							return mergedHead;
						}
			
						if(headOne == null){
								mergedTail.next = headTwo;
								return mergedHead;
						}
			
						if(headTwo == null){
							mergedTail.next = headOne;
							return mergedHead;
						}
			
						LinkedList currentNode = null;
						currentNode = (headOne.value < headTwo.value)?headOne:headTwo;
						if(mergedHead == null){
								mergedHead = currentNode;
								mergedTail = currentNode;
						}else{
								mergedTail.next = currentNode;
								mergedTail = mergedTail.next; // Forgot to move forward the tail
						}
						
						if(currentNode == headOne){
								return mergeLinkedLists(headOne.next, headTwo, mergedHead, mergedTail);
						}
			
						return mergeLinkedLists(headOne, headTwo.next, mergedHead, mergedTail);
	}
		
	private static LinkedList mergeLinkedLists2(LinkedList headOne, LinkedList headTwo) {
		recursiveMerge(headOne, headTwo, null);
		return (headOne.value < headTwo.value)?headOne:headTwo;
	}
	
	private static void recursiveMerge(LinkedList p1, LinkedList p2, LinkedList p1prev) {
			if(p1 == null) {
				p1prev.next = p2;
				return;
			}
			
			if(p2 == null) {
				p1prev.next = p1;
				return;
			}
			
			if(p1.value < p2.value) {
				recursiveMerge(p1.next, p2, p1);
			}else {
				if(p1prev != null) {
					p1prev.next = p2;
				}
				
				LinkedList newp2 = p2.next;
				p2.next = p1;
				recursiveMerge(p1, newp2, p2);
			}
		
		
	}
	
	 public static LinkedList mergeLinkedListsBest(LinkedList headOne, LinkedList headTwo) {
		    // Write your code here.
				LinkedList currentHead = headOne.value < headTwo.value?headOne:headTwo;
				LinkedList currentTail = currentHead;
				headOne = (headOne == currentHead)?headOne.next:headOne;
				headTwo = (headTwo == currentHead)?headTwo.next:headTwo;
				while(headOne != null && headTwo != null){
						if(headOne.value < headTwo.value) {
							currentTail.next = headOne;
							headOne = headOne.next;
						}else{
							currentTail.next = headTwo;
							headTwo = headTwo.next;
						}
						currentTail = currentTail.next;
				}
				
				if(headOne ==  null){
					currentTail.next = headTwo;
				}
				if(headTwo == null){
					currentTail.next = headOne;
				}
		    return currentHead;
	}
	 
	 public static LinkedList mergeLinkedListsBest2(LinkedList headOne, LinkedList headTwo) {
		 LinkedList p1 = headOne;
		 LinkedList p1prev = null;
		 LinkedList p2 = headTwo;
		 
		 while(p1 != null && p2 != null) {
			 
			 if(p1.value < p2.value) {
				 p1prev = p1;
				 p1 = p1.next;
			 }else {
				 if(p1prev != null) {
					 p1prev.next = p2;
				 }
				 p1prev = p2;
				 p2 = p2.next;
				 p1prev.next = p1;
			 }
			 
		 }
		 
		 if(p1 == null) {
			 p1prev.next = p2;
		 }
		 
		 
		 return (headOne.value < headTwo.value)?headOne:headTwo;
	 }
	
		
		

}
