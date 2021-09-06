package mIcrosoft;

// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.


public class LinkedListIntersection {
	
		// Visually a + c + b == b + c + a (forcing 2 pointers to travel this distance will meet at intersection) 
	
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode pA = headA;
	        ListNode pB = headB;
	        while (pA != pB) {
	            pA = pA == null ? headB : pA.next;
	            pB = pB == null ? headA : pB.next;
	        }
	        return pA;
	    }
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthA = 0;
        int lengthB = 0;
        ListNode temp = headA;
        while(temp != null) {
            lengthA++; temp = temp.next;
        }
       temp = headB;
       while(temp != null) {
            lengthB++; temp = temp.next;
        }
        int diff = Math.abs(lengthA - lengthB);
        temp = lengthA > lengthB ? headA : headB;
        ListNode temp2 = lengthA > lengthB ? headB : headA;
        while(diff > 0) {
            temp = temp.next;  diff--;
        }
        while(temp != null && temp2 != null && temp != temp2) {
               temp = temp.next;
               temp2 = temp2.next;
        }
       
        if(temp == null || temp2 == null) return null;
       
        return temp;
   }

}
