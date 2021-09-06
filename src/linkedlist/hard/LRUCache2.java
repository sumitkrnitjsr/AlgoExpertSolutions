package linkedlist.hard;
import java.util.*;

public class LRUCache2 {
	
	static class LRUCache{
		
		Map<String, DoublyLinkedListNode> cache = new HashMap<>();
		int maxSize = 0;
		int currentSize = 0;
		
		DoublyLinkedList mostRecent = new DoublyLinkedList();
		
		public LRUCache(int maxSize) {
			this.maxSize = maxSize > 1 ? maxSize : 1;
		}
		
		public void insertKeyValuePair(String key, int value) {
			if(!cache.containsKey(key)) {
				if(currentSize == maxSize) {
					evictLeastRecent();
				} else {
					currentSize++;
				}
				cache.put(key, new DoublyLinkedListNode(key, value));
			} else {
				replaceKey(key, value);
			}
			updateMostRecent(cache.get(key));
		}
		
		public int getValueFromKey(String key) {
			if(!cache.containsKey(key)) {
				return -1;
			}
			updateMostRecent(cache.get(key));
			return cache.get(key).value;
		}
		
		public String getMostRecentKey() {
			if(mostRecent == null) return "";
			return mostRecent.head.key;
		}
		
		public void evictLeastRecent() {
			String keyToremove = mostRecent.tail.key;
			mostRecent.removeTail();
			cache.remove(keyToremove);
		}
		
		public void updateMostRecent(DoublyLinkedListNode node) {
			mostRecent.setHeadTo(node);
		}
		
		public void replaceKey(String key, int value) {
			if(!this.cache.containsKey(key)) {
				return;
			}
			cache.get(key).value = value;
		}
		
	}
	
	
	
	
	
	
	
	
	static class DoublyLinkedList {
		DoublyLinkedListNode head = null;
		DoublyLinkedListNode tail = null;
		
		public void setHeadTo(DoublyLinkedListNode node) {
			if(head == node) return;
			else if (head == null) {
				head = node;
				tail = node;
			}else if(head == tail) {
				tail.prev = node;
				head = node;
				head.next = tail;
			}else {
				if(tail == node) {
					removeTail();
				}
				node.removeBindings();
				head.prev = node;
				node.next = head;
				head = node;
			}
		}
		
		public void removeTail() {
			if(tail == null) return;
			if(head == tail) {
				head = null;
				tail = null;
				return;
			}
			tail = tail.prev;
			tail.next = null;
		}
	}
	
	
	
	
	static class DoublyLinkedListNode {
		String key;
		int value;
		DoublyLinkedListNode prev = null;
		DoublyLinkedListNode next = null;
		
		public DoublyLinkedListNode(String key, int value) {
			this.key = key;
			this.value = value;
		}
				
		
		public void removeBindings() {
			if(prev != null) {
				prev.next = next;
			}
			if(next != null) {
				next.prev= prev;
			}
			
			prev = null;
			next = null;
		}
	}

}
