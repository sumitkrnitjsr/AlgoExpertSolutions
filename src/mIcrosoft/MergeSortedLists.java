package mIcrosoft;

public class MergeSortedLists {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null) return l2;
	        // Edge cases
	        if(l2 == null) return l1;
	        
	        ListNode newHead = l1.val < l2.val ? l1 : l2;
	        ListNode newTail = newHead;
	        ListNode l1Head = newHead == l1 ? l1.next : l1;
	        ListNode l2Head = newHead == l2 ? l2.next : l2;
	        
	        while(l1Head != null || l2Head != null) {
	                                 // Null Pointer check for l2Head
	            if(l1Head == null || (l2Head != null && l2Head.val < l1Head.val)) {
	                newTail.next = l2Head;
	                newTail = newTail.next;
	                l2Head = l2Head.next;
	            }else {
	                newTail.next = l1Head;
	                l1Head = l1Head.next;
	                newTail = newTail.next;
	            }
	        }
	        
	        return newHead;
	    }
	 
	 
		    public ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
		        // maintain an unchanging reference to node ahead of the return node.
		        ListNode prehead = new ListNode(-1);

		        ListNode prev = prehead;
		        while (l1 != null && l2 != null) {
		            if (l1.val <= l2.val) {
		                prev.next = l1;
		                l1 = l1.next;
		            } else {
		                prev.next = l2;
		                l2 = l2.next;
		            }
		            prev = prev.next;
		        }

		        // At least one of l1 and l2 can still have nodes at this point, so connect
		        // the non-null list to the end of the merged list.
		        prev.next = l1 == null ? l2 : l1;

		        return prehead.next;
		    }

}
