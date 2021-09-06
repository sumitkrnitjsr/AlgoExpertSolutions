package mIcrosoft;
import java.util.*;

public class SerializeDeserialzeBT {
	
	 public String serialize(TreeNode root) {
	       return serialize(root, "");
	    }

	    private String serialize(TreeNode root, String str) {
	        if(root == null) {
	            str += "null,";
	        }else{
	            str += str.valueOf(root.val+",");
	            str = serialize(root.left, str);
	            str = serialize(root.right, str);
	        }
	        return str;
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] dataArray = data.split(",");
	        List<String> data_list = new LinkedList<String>(Arrays.asList(dataArray));
	        return deserialize(data_list);
	    }
	    
	    private TreeNode deserialize(List<String> list) {
	        if(list.get(0).equals("null")){
	            list.remove(0);
	            return null;
	        }
	        
	        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
	        list.remove(0);
	        root.left = deserialize(list);
	        root.right = deserialize(list);
	        return root;
	    }

}
