package linkedlist.difficult;

public class FindLoop {
	
	 public static LinkedList findLoop(LinkedList head) {
		    // Write your code here.
				LinkedList fast = head;
				LinkedList slow = head;
				while(true) {
							fast = fast.next.next;
							slow = slow.next;
							if(slow == fast) break;
				}
				
				slow = head;
				while(slow != fast) {
							slow = slow.next;
							fast = fast.next;
				}
		    return slow;
		  }

		  static class LinkedList {
		    int value;
		    LinkedList next = null;

		    public LinkedList(int value) {
		      this.value = value;
		    }
		  }
		  

}
