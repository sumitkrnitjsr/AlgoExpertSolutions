package linkedlist.hard;

import linkedlist.hard.LinkedListPalindrome.LinkedList;

public class pairSwap {
	
	public LinkedList nodeSwap(LinkedList head) {
	    // Write your code here.
			if(head == null || head.next == null) return head;
			
			LinkedList currNode = head;
			LinkedList nextNode = null, nextNextNode = null, newHead = null, prevNode = null;
			newHead = head.next;
			
			while(currNode != null && currNode.next != null) {
						nextNode = currNode.next;
						nextNextNode = nextNode.next;
						if(prevNode != null) {
								prevNode.next = nextNode;
						}
						nextNode.next = currNode;
						currNode.next = nextNextNode;
						prevNode = currNode;
						currNode = nextNextNode;
			}
			
	    return newHead;
	  }
	
		public LinkedList nodeSwap(LinkedList head) {
				if(head == null || head.next == null) return head;
				
				LinkedList nextNode = head.next;
				head.next = nodeSwap(head.next.next);
				nextNode.next = head;
				return nextNode;
		}

}
