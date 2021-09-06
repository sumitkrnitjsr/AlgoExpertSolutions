package mIcrosoft.random;

public class DeleteLinkListNodeWIthoutRoot {
	
	public void deleteNode(ListNode node) {
        if(node == null || node.next == null)
            return;
        node.val = node.next.val;
        if(node.next.next == null){
            node.next = null;
            return;
        }
        deleteNode(node.next);
    }

}
