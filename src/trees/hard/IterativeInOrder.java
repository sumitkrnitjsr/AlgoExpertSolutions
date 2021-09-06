package trees.hard;
import java.util.*;

public class IterativeInOrder {
	
	public static void iterativeInOrderTraversal(
		    BinaryTree tree, Function<BinaryTree, Void> callback) {
		    // Write your code here.
				Stack<BinaryTree> stack = new Stack<>();
				 do{ 
		        while (tree != null){ 
		            stack.push(tree);
		            tree = tree.left;
		        }

		        // If there are nodes in the stack to which we can move up
		        // then pop it
		        if (!stack.empty()){ 
		            tree = stack.pop();
		            callback.apply(tree);
		            // vistit the right child now
		            tree = tree.right;
		        }
		    // while the stack is not empty or there is a valid node
		    }while(!stack.empty() || tree != null);
				
	}
	
	public void Inorder(BinaryTree root) {
			BinaryTree previousNode = null;
			BinaryTree currentNode = root;
			
			while(currentNode != null) {
					BinaryTree nextNode;
					if(previousNode == null || previousNode == currentNode.parent) {
						if(currentNode.left != null) {
							nextNode = currentNode.left;
						}else {
							System.out.println(currentNode);
							nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
						}
					}else if(previousNode == currentNode.left) {
						System.out.println(currentNode);
						nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
					}else {
						nextNode = currentNode.parent;
					}
					previousNode = currentNode;
					currentNode = nextNode;
			}
	}

}
