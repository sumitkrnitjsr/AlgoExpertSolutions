package linkedlist.hard;

public class ZipLinkedList {
	
	 public static class LinkedList {
		    public int value;
		    public LinkedList next;

		    public LinkedList(int value) {
		      this.value = value;
		      this.next = null;
		    }
		  }

		  public LinkedList zipLinkedList(LinkedList linkedList) {
		    // Write your code here.
				if(linkedList == null || linkedList.next == null || linkedList.next.next == null) return linkedList;
				
				LinkedList midNode = getMid(linkedList);
				LinkedList secondHead = midNode.next;
				midNode.next = null;
				secondHead = reverse(secondHead);
				merge(linkedList, secondHead);
		    return linkedList;
		  }
			
			private LinkedList getMid(LinkedList node) {
					LinkedList fast = node;
					LinkedList slow = node;
				
					while(fast.next != null && fast.next.next != null) {
								fast = fast.next.next;
								slow = slow.next;
					}
				
					return slow;
			}
			
			private LinkedList reverse(LinkedList node) {
							LinkedList prev = null;
							LinkedList curr = node;
							LinkedList next = null;
							while(curr != null) {
									next = curr.next;
									curr.next = prev;
									prev = curr;
									curr = next;
							}
							return prev;
			}
			
			private void merge(LinkedList firstNode, LinkedList secondNode) {
						if(firstNode == null || secondNode == null) return;
						while(firstNode != null && secondNode != null) {
									LinkedList firstNextNode = firstNode.next;
									LinkedList secondNextNode = secondNode.next;
									firstNode.next = secondNode;
									secondNode.next = firstNextNode;
									firstNode = firstNextNode;
									secondNode = secondNextNode;
						}
			}

}
