package mIcrosoft;
import java.util.*;


public class LCABT {
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> visitedNodes = new ArrayList<>();
        List<TreeNode> visited = lcaHelper(root, p, q);
        return visited.get(2);
}

public List<TreeNode> lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        List<TreeNode> visited = new ArrayList<>();
    
        if(root == p) visited.add(p);
        if(root == q) visited.add(q);
    
        List<TreeNode> leftVisited = lcaHelper(root.left, p, q);
        List<TreeNode> rightVisited = lcaHelper(root.right, p, q);
        
        if(leftVisited != null) {
            if(leftVisited.size() == 3)  return leftVisited;    
            visited.addAll(leftVisited);
        }
        
        if(rightVisited != null) {
            if(rightVisited.size() == 3)  return rightVisited;
            visited.addAll(rightVisited);
        }
    
        if(visited.size() == 2) visited.add(root);
            else if(visited.size() == 0) visited = null;
    
        return visited;
}


class Solution {

    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}




}
