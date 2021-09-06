package mIcrosoft;

/**
 * To serialize a binary tree means to
 * Encode tree structure.
 * Encode node values.
 * Choose delimiters to separate the values in the encoded string.
 *
 *	Let's use here the fact that BST could be constructed from preorder or postorder traversal only.
 *	Convert each integer into 4-bytes string.
 */

public class SearializeDeserializeBST {
	
	  // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        postOrder(root, str);
        //  if(str.length() > 0) str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    public void postOrder(TreeNode root, StringBuilder str) {
            if(root == null) return;
            postOrder(root.left, str);
            postOrder(root.right, str);
            str.append(intToString(root.val));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {   
            if(data == null || data.isEmpty()) return null;
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            // for(String s: data.split("\\s+")) nums.add(Integer.valueOf(s));
            
            for(int i = 0;i < (int) (data.length() / 4); i++) {
                nums.add(stringToInt(data.substring(4 * i, 4 * i + 4)))    ;
            }

            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        
    }
    
    private TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            if(nums.isEmpty()) return null;
            int val = nums.getLast();
            if(val < lower || val >upper) return null;
        
            nums.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);
            return root;
    }
    
    private String intToString(int x) {
            char[] bytes = new char[4];
            for(int i = 3;i > -1;i--) {
                bytes[3 - i] = (char)   (x >> (i * 8) & 0xff);
            }
            return new String(bytes);
    }
    
    private int stringToInt(String bytes) {
            int result = 0;
            for(char b : bytes.toCharArray()) {
                result = (result << 8) + (int)b;
            }
            return result;
    }

}
