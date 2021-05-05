package linkedlist.difficult;

public class Shift_Linked_List {
	
	 public static LinkedList shiftLinkedList(LinkedList head, int k) {
		    // Write your code here.
				if(k == 0 || head == null || head.next == null){
					return head;
				}
				int length = 1;
				LinkedList node = head;
				while(node.next != null){
							node = node.next;
							length++;
				}
				if(k%length == 0){
						return head;
				}
				k = k%length;
				k = (k < 0)?(length + k):k; //forgot to neutralise the negative values
				LinkedList postHeadNode = head;
				LinkedList preTailNode = node;
				int count = 1;
				LinkedList postTailNode = head;
				while(count < (length - k)){ // wrong condition check count < (length - k - 1)
							postTailNode = postTailNode.next;
							count++;
				}
				LinkedList preHeadNode = postTailNode.next;
				
				preTailNode.next = postHeadNode;
				postTailNode.next = null;
				
		    return preHeadNode;
		  }

	 
	 public static LinkedList shiftLinkedList2(LinkedList head, int k) {
		    // Write your code here.
		 	int listLength = 1;
		 	LinkedList listTail = head;
		 	while(listTail.next != null) {
		 			listTail = listTail.next;
		 			listLength++;
		 	}
		 	
		 	int offset = Math.abs(k) % listLength;
		 	if(offset == 0) return head;
		 	int newTailPosition = k > 0 ? listLength - offset : offset;
		 	LinkedList newTail = head;
		 	
		 	for(int i = 1;i < newTailPosition;i++) {
		 		newTail = newTail.next;
		 	}
		 	
		 	LinkedList newHead = newTail.next;
		 	newTail.next = null;
		 	listTail.next = head;
		 	
		 	return newHead;
				
		  }

		  static class LinkedList {
		    public int value;
		    public LinkedList next;

		    public LinkedList(int value) {
		      this.value = value;
		      next = null;
		    }
		  }

}
