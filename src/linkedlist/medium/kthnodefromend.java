package linkedlist.medium;

public class kthnodefromend {
	
	 public static void removeKthNodeFromEnd(LinkedList head, int k) {
		    // Write your code here.
				LinkedList node = head;
				LinkedList kthPreviousNode = head;
				LinkedList secondLastNode = head;
				int i = 1;
				while(i < k){
					node = node.next;
					i++;
				}
				
				while(node.next != null){
						node = node.next;
						secondLastNode = kthPreviousNode;
						kthPreviousNode = kthPreviousNode.next;
				}
				
				if(kthPreviousNode == head) {
						head.value = head.next.value;
						head.next = head.next.next;
						return;
				}
				
				secondLastNode.next = kthPreviousNode.next;
				kthPreviousNode.next = null;
				
	}
	 
	public static void removekthNodeFromEnd(LinkedList head, int k) {
		int counter = 1;
		LinkedList first = head;
		LinkedList second = head;
		
		while(counter <= k) {
			second = second.next;
			counter++;
		}
		
		if(second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		
		while(second.next != null) {
			second = second.next;
			first = first.next;
		}
		
		first.next = first.next.next;
		
	}

		  static class LinkedList {
		    int value;
		    LinkedList next = null;

		    public LinkedList(int value) {
		      this.value = value;
		    }
		  }

}
