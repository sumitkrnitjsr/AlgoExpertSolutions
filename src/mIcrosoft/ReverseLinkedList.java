package mIcrosoft;

public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

}
