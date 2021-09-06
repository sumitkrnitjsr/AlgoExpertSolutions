package mIcrosoft;

public class AddTwoNumbers {
	
	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode sum = new ListNode();
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	        int carry = 0;
	        ListNode itr = sum;
	        while(l1 != null || l2 != null) {
	                int l1num = l1 == null ? 0 : l1.val;
	                int l2num = l2 == null ? 0 : l2.val;
	                int digit = (l1num + l2num + carry)%10;
	                ListNode newNode = new ListNode(digit);
	                carry = (l1num + l2num + carry)/10;
	                itr.next = newNode;
	                itr = itr.next;
	                l1 = (l1 == null) ? l1 : l1.next;
	                l2 = (l2 == null) ? l2 : l2.next;
	        }
	        
	        if(carry != 0) {
	            itr.next = new ListNode(carry);
	        }
	        return sum.next;
	    }

}
