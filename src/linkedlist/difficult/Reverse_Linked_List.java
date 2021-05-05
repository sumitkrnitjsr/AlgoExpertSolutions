package linkedlist.difficult;

public class Reverse_Linked_List {
	
	public static LinkedList reverseLinkedList(LinkedList head) {
	    if(head == null || head.next == null) {
				return head;
			}
	    return revereseLinkedListRecursive(head).head;
	  }
		
		private static LinkedListNodes revereseLinkedListRecursive(LinkedList head) {
				LinkedListNodes result = new LinkedListNodes();
				if(head == null){
						result.head = null;
						result.tail = null;
						return result;
				}
			
				if(head.next == null){
						result.head = head;
						result.tail = head;
						return result;
				}
			
				LinkedListNodes leftList = revereseLinkedListRecursive(head.next);
				result.head = leftList.head;
				leftList.tail.next = head;
				leftList.tail = leftList.tail.next;
				result.tail = leftList.tail;
				result.tail.next = null;
			
				return result;
		}
		
		
		 public static LinkedList reverseLinkedListBest(LinkedList head) {
			    // Write your code here.
					if(head == null || head.next == null){
						return head;
					}
					
					LinkedList previousHead = null;
					LinkedList currentNode = head;
					LinkedList nextNode = head.next;
					
					while(currentNode != null){
								currentNode.next = previousHead;
								previousHead = currentNode;
								currentNode = nextNode;
								nextNode = (currentNode != null)?currentNode.next:null;  // NullpointerException
					}
					
					
					return previousHead;
		}

	  static class LinkedList {
	    int value;
	    LinkedList next = null;

	    public LinkedList(int value) {
	      this.value = value;
	    }
	  }
		
		static class LinkedListNodes {
			LinkedList head;
			LinkedList tail;
		}

}
