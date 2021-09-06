package mIcrosoft;

public class MergeKSortedLists {
	
	 public ListNode mergeKLists(ListNode[] lists) {
         PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>(){
             public int compare(ListNode a,ListNode b) {
                 return Integer.compare(a.val, b.val);
             }
         });
         for(int i = 0;i < lists.length;i++) {
             if(lists[i] == null) continue;
             heap.add(lists[i]);
         }
         ListNode root = new ListNode();
         ListNode itr = root;
         while(!heap.isEmpty()) {
                 ListNode top = heap.poll();
                 itr.next = top;
                 if(top.next != null) {
                     heap.add(top.next);
                 }
                 // forgot to move pointer forward
                 itr = itr.next;
         }
         // forgot to end the list
         itr.next = null;
         return root.next;
	 }

}
