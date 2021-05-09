package linkedlist.hard;

public class LinkedListPalindrome {
	
	 public static class LinkedList {
		    public int value;
		    public LinkedList next;

		    public LinkedList(int value) {
		      this.value = value;
		      this.next = null;
		    }
		  }

		  public boolean linkedListPalindrome(LinkedList head) {
		    // Write your code here.
				if(head == null || head.next == null) {
						return true;
				}
				LinkedList midNode = findMidNode(head);
				LinkedList nextHead = midNode.next;
				midNode.next = null;
				LinkedList secondHead = reverse(nextHead).head;
		    return compareLinkedList(head, secondHead);
		  }
			
			private static boolean compareLinkedList(LinkedList fHead, LinkedList sHead) {
						if(fHead == null && sHead == null) {
								return true;
						}
						if(fHead.next == null && sHead == null) {
								return true;
						}
						System.out.println(fHead.value + " " + sHead.value);
						if(fHead.value != sHead.value) {
								return false;
						}
						
						return compareLinkedList(fHead.next, sHead.next);
			}
			
			private static LinkedList findMidNode(LinkedList head) {
					LinkedList fast = head;
					LinkedList slow = head;
					while(fast.next != null && fast.next.next != null) {
									fast = fast.next.next;
									slow = slow.next;
					}
					return slow;
			}
			
			private static NodeResult reverse(LinkedList head) {
						NodeResult nodeResult = new NodeResult();
						if(head.next == null) {
								nodeResult.head = head;
								nodeResult.tail = head;
								return nodeResult;
						}
						NodeResult result = reverse(head.next);
						result.tail.next = head;
						result.tail = head;
						result.tail.next = null;
						return result;
			}
			
			static class NodeResult {
					LinkedList head;
					LinkedList tail;
			}

			
			public boolean linkedlistpalindrome2(LinkedList head) {
				LinkedListInfo isPalindromeResults = isPalindrome(head, head);
				return isPalindromeResults.outerNodesAreEqual;
			}
			
			// Use one parameter to traverse from right to left and the returned parameter to traverse reveres
			// The head is bein passed till the end so that it can be traversed from start to beginning
			public LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode) {
				if(rightNode == null) return new LinkedListInfo(true, leftNode);
				
				LinkedListInfo recursiveCallResults = isPalindrome(leftNode, rightNode.next);
				LinkedList leftNodeToCompare = recursiveCallResults.leftNodeToCompare;
				boolean outerNodesAreEqual = recursiveCallResults.outerNodesAreEqual;
				
				boolean recursiveIsEqual = outerNodesAreEqual && (leftNodeToCompare.value == rightNode.value);
				LinkedList nextLeftNodeToCompare = leftNodeToCompare.next;
				
				return new LinkedListInfo(recursiveIsEqual, nextLeftNodeToCompare);
			}
			
			public class LinkedListInfo {
				public boolean outerNodesAreEqual;
				public LinkedList leftNodeToCompare;
				
				public LinkedListInfo(boolean outerNodesAreEqual, LinkedList leftNodeToCompare) {
					this.outerNodesAreEqual = outerNodesAreEqual;
					this.leftNodeToCompare = leftNodeToCompare;
				}
			}
			
			
			public boolean 	linkedListPalindrome3(LinkedList head) {
					LinkedList slowNode = head;
					LinkedList fastNode = head;
					
					while(fastNode != null && fastNode.next != null) {
						slowNode = slowNode.next;
						fastNode = fastNode.next.next;
					}
					
					LinkedList reversedSecondHalfNode = reverseLinkedList(slowNode);
					LinkedList firstHalfNode = head;
					
					while(reversedSecondHalfNode != null) {
						if(reversedSecondHalfNode.value != firstHalfNode.value) return false;
						reversedSecondHalfNode = reversedSecondHalfNode.next;
						firstHalfNode = firstHalfNode.next;
					}
					
					return true;
					
			}
			
			private static LinkedList reverseLinkedList(LinkedList head) {
					LinkedList previousNode = null;
					LinkedList currentNode = head;
					while(currentNode != null) {
						LinkedList nextNode = currentNode.next;
						currentNode.next = previousNode;
						previousNode = currentNode;
						currentNode = nextNode;
					}
					return previousNode;
			}
}
