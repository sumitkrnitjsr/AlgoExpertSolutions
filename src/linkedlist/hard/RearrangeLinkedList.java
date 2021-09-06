package linkedlist.hard;

public class RearrangeLinkedList {
	
	 public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
		    // Write your code here.
				LinkedList headLess = null;
				LinkedList tailLess = null;
				LinkedList headMore = null;
				LinkedList tailMore = null;
				LinkedList headEqual = null;
				LinkedList tailEqual = null;
				LinkedList temp = head;
				while(temp != null) {
						if(temp.value < k) {
								if(headLess == null) {
										headLess = temp;
										tailLess = temp;
								}else{
										tailLess.next = temp;
										tailLess = tailLess.next;
								}
						}else if(temp.value > k) {
								if(headMore == null) {
										headMore = temp;
										tailMore = temp;
								}else{
										tailMore.next = temp;
										tailMore = tailMore.next;
								}
						}else{
								if(headEqual == null) {
										headEqual = temp;
										tailEqual = temp;
								}else{
										tailEqual.next = temp;
										tailEqual = tailEqual.next;
								}
						}
					temp = temp.next;
				}
			

				if(tailEqual != null) tailEqual.next = null;
				if(tailLess != null) tailLess.next = null;
				if(tailMore != null) tailMore.next = null;
				
				if(headLess == null) {
						if(headEqual == null) return headMore;
						tailEqual.next = headMore;
						return headEqual;
				}
			
				if(headEqual == null) {
						tailLess.next = headMore;
						return headLess;
				}
				
				if(headMore == null) {
						tailLess.next = headEqual;
						return headLess;
				}
				
				tailLess.next = headEqual;
				tailEqual.next = headMore;
				
				return headLess;
		   
		  }


}
