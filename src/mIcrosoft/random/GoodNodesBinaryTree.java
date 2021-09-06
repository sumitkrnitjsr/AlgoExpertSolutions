package mIcrosoft.random;

// Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class GoodNodesBinaryTree {
	
	 public int goodNodes(TreeNode root) {
	        return goodNodes(root, root.val);
	    }
	    public int goodNodes(TreeNode root, int max) {
	        if(root == null) return 0;
	        int sum = 0;
	        if(root.val >= max) sum++;
	        sum += goodNodes(root.left, Math.max(max, root.val));
	        sum += goodNodes(root.right, Math.max(max, root.val));
	        return sum;
	    }

	   
	    
	    class Pair {
	        public TreeNode node;
	        public int maxSoFar;
	        
	        public Pair(TreeNode node, int maxSoFar) {
	            this.node = node;
	            this.maxSoFar = maxSoFar;
	        }
	    }

	    class Solution {
	        public int goodNodes(TreeNode root) {
	            int numGoodNodes = 0;
	            Stack<Pair> stack = new Stack<>();
	            stack.push(new Pair(root, Integer.MIN_VALUE));
	            
	            while (stack.size() > 0) {
	                Pair curr = stack.pop();
	                if (curr.maxSoFar <= curr.node.val) {
	                    numGoodNodes++;
	                }
	                
	                if (curr.node.left != null) {
	                    stack.push(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
	                }
	                
	                if (curr.node.right != null) {
	                    stack.push(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
	                }
	            }

	            return numGoodNodes;
	        }
	    }
}
