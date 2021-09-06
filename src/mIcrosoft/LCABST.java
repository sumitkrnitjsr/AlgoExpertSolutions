package mIcrosoft;

public class LCABST {
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
         // Handle one node parent of another node
         if(root == p) return p;
     
         // Handle one node parent of another node
         if(root == q) return q;
     
         // Not given that p.val < q.val
         TreeNode lessNode = p.val < q.val ? p : q;
         TreeNode moreNode = p.val > q.val ? p : q;
         p = lessNode;
         q = moreNode;
         if(root.val > p.val && root.val < q.val) {
             return root;
         }
         
         if(root.val < p.val && root.val < q.val) {
             return lowestCommonAncestor(root.right, p, q);
         }
         return lowestCommonAncestor(root.left, p, q);
 }
	 
	 
	 class Solution {
		    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		        // Value of p
		        int pVal = p.val;

		        // Value of q;
		        int qVal = q.val;

		        // Start from the root node of the tree
		        TreeNode node = root;

		        // Traverse the tree
		        while (node != null) {

		            // Value of ancestor/parent node.
		            int parentVal = node.val;

		            if (pVal > parentVal && qVal > parentVal) {
		                // If both p and q are greater than parent
		                node = node.right;
		            } else if (pVal < parentVal && qVal < parentVal) {
		                // If both p and q are lesser than parent
		                node = node.left;
		            } else {
		                // We have found the split point, i.e. the LCA node.
		                return node;
		            }
		        }
		        return null;
		    }
		}

}
