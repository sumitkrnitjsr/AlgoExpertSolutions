package mIcrosoft;

public class AddTwoNumbers2 {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	        int length1 = findLength(l1);
	        int length2 = findLength(l2);
	        ListNode longNode, shortNode;
	        int l, s;
	        
	        if(length1 > length2) {
	            longNode = l1;
	            shortNode = l2;
	            l = length1;
	            s = length2;
	        }else {
	            longNode = l2;
	            shortNode = l1;
	            l = length2;
	            s = length1;
	        }
	        ListNode prev = null;
	        ListNode newHead = null;
	        while(s < l) {
	                ListNode newNode = new ListNode(0);
	                if(prev !=  null) { 
	                    prev.next = newNode; 
	                }else {
	                    newHead = newNode;
	                }
	                prev = newNode;
	                s++;
	        }
	        if(prev != null) {
	            prev.next = shortNode;
	            shortNode = newHead;
	        }
	        
	         Result result = sum(longNode, shortNode);
	        if(result.carry == 0) {
	            return result.node;
	        }
	        ListNode carryNode = new ListNode(result.carry);
	        carryNode.next = result.node;
	        
	        return carryNode;
	    }
	    
	    private int findLength(ListNode head) {
	        int l = 0;
	        while(head.next != null){
	                head = head.next;
	                l++;
	        }
	        return l;
	    }
	    
	    private Result sum(ListNode l1,ListNode l2) {
	        if(l1.next == null && l2.next == null) {
	            int sumDigit = (l1.val + l2.val) % 10;
	            int carry = (l1.val + l2.val) / 10;
	            ListNode newNode = new ListNode(sumDigit);
	            Result result = new Result(newNode, carry);
	            return result;
	        }
	        Result next = sum(l1.next, l2.next);
	        int sum = next.carry + l1.val + l2.val;
	        int digit = sum % 10;
	        int carry = sum / 10;
	        ListNode newNode = new ListNode(digit);
	        // Forgot to update link to next node
	        newNode.next = next.node;
	        return new Result(newNode, carry);
	    }
	}
	class Result {
	    ListNode node;
	    int carry;
	    public Result(ListNode n,int c) {
	        node = n;
	        carry = c;
	    }

}
