package mIcrosoft;

public class LinkedListCycle {
	
	 public boolean hasCycle(ListNode head) {
	        
	        if(head == null || head.next == null) return false;
	        
	        ListNode slowIdx = head;
	        ListNode fastIdx = head.next.next;
	        
	        while(fastIdx != null && fastIdx.next != null && slowIdx != fastIdx) {
	                slowIdx = slowIdx.next;
	                fastIdx = fastIdx.next.next;
	        }
	        
	        return slowIdx == fastIdx;
	    }

}
