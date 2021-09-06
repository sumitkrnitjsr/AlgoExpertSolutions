package mIcrosoft;
import java.util.*;

// Count is important to use for lengths

public class PreorderInorderConstruction {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] pre,int[] in, int pre_s,int pre_e,int in_s,int in_e ) {
            if(pre_s > pre_e || in_s > in_e) return null;
            TreeNode currentRoot = new TreeNode(pre[pre_s]);
            int i;
            for(i = in_s;i <= in_e;i++) {
                if(in[i] == pre[pre_s]) break;
            }
            int left_s = in_s;
            int left_e = i - 1;
            int right_s = i + 1;
            int right_e = in_e;
        
            int left_l = Math.max(0, (left_e - left_s) + 1);
            int right_l = Math.max(0, (right_s - right_e) + 1);
        
            currentRoot.left = buildTreeHelper(pre, in, pre_s + 1,pre_s + left_l, left_s, left_e );
            currentRoot.right = buildTreeHelper(pre, in, pre_s + left_l + 1,pre_e, right_s, right_e );
        
            return currentRoot;
    }
    
    
    class Solution {
        int preorderIndex;
        Map<Integer, Integer> inorderIndexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            // build a hashmap to store value -> its index relations
            inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return arrayToTree(preorder, 0, preorder.length - 1);
        }

        private TreeNode arrayToTree(int[] preorder, int left, int right) {
            // if there are no elements to construct the tree
            if (left > right) return null;

            // select the preorder_index element as the root and increment it
            int rootValue = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootValue);

            // build left and right subtree
            // excluding inorderIndexMap[rootValue] element because it's the root
            root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
            root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
            return root;
        }
    }

}
