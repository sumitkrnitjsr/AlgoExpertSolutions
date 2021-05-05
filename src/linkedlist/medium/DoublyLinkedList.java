package linkedlist.medium;

public class DoublyLinkedList {
		    public Node head;
		    public Node tail;

		    public void setHead(Node node) {
		      // Write your code here.
					if(head == null){
							head = node;
							tail = node;
							return;
					}
					insertBefore(head, node);
		    }

		    public void setTail(Node node) {
					if(tail == null){
						 setHead(node);
						return;
					}
					insertAfter(tail, node);
		    }

		    public void insertBefore(Node node, Node nodeToInsert) {
						if(nodeToInsert == head && nodeToInsert == tail){
							return;
						}
						remove(nodeToInsert);
						if(node == head){
							head.prev = nodeToInsert;
							nodeToInsert.next = head;
							head = head.prev;
							return;
						}
						Node previousNode = node.prev;
						previousNode.next = nodeToInsert;
						nodeToInsert.prev = previousNode;
						nodeToInsert.next = node;
						node.prev = nodeToInsert;
		    }

		    public void insertAfter(Node node, Node nodeToInsert) {
							if(nodeToInsert == head && nodeToInsert == tail){
								return;
							}
							remove(nodeToInsert);
							if(node == tail){
									tail.next = nodeToInsert;
									nodeToInsert.prev = tail;
									tail = tail.next;
								return;
							}
							node.next.prev = nodeToInsert;
							nodeToInsert.next = node.next;
							nodeToInsert.prev = node;
							node.next = nodeToInsert;
		    }

		    public void insertAtPosition(int position, Node nodeToInsert) {
							if(position == 1){
									setHead(nodeToInsert);
									return;
							}
					
							Node temp = head;
							int currentPosition = 1;
							while(temp != null && currentPosition < position){
										temp = temp.next;
										currentPosition++;
							}
					
							if(temp == null){
									setTail(nodeToInsert);
									return;
							}
					
							insertBefore(temp, nodeToInsert);
		    }

		    public void removeNodesWithValue(int value) {
					Node node = head;
					while(node != null){
							Node nodeToRemove = node;
							node = node.next;
							if(nodeToRemove.value == value){
								remove(nodeToRemove);
							}
					}
					
		    }

		    public void remove(Node node) {			
							if(node == head) {
								head = head.next;
							}
							if(node == tail){
								tail = tail.prev;
							}
							clearNode(node);
		    }

				private void clearNode(Node node){
						if(node.prev != null) node.prev.next = node.next;
						if(node.next != null) node.next.prev = node.prev;
						node.next = null;
						node.prev = null;
				}
				
		    public boolean containsNodeWithValue(int value) {
					Node temp = head;
					while(temp != null){
							if(temp.value == value){
								return true;
							}
							temp = temp.next;
					}
					
					return false;
		    }
				

		  // Do not edit the class below.
		  static class Node {
		    public int value;
		    public Node prev;
		    public Node next;

		    public Node(int value) {
		      this.value = value;
		    }
		  }

}
