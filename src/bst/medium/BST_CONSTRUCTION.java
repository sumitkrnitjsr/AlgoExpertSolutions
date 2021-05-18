package bst.medium;

public class BST_CONSTRUCTION {
	
	static class BST {
		public int value;
		public BST left;
		public BST right;
		
		public BST(int value) {
			this.value = value;
		}
		
		public BST insert(int value) {
				if(value < this.value ) {
					if(left == null) {
						BST newBST = new BST(value);
						left = newBST;
					}else {
						left.insert(value);
					}
				}else {
					if(right == null) {
						BST newBST = new BST(value);
						right = newBST;
					}else {
						right.insert(value);
					}
				}
				return this;
		}
		
		public boolean contains(int value) {
			if(value < this.value) {
				if(left == null) return false;
			else {
				return left.contains(value);
			}
			}else if(value > this.value) {
				if(right == null) return false;
				else return right.contains(value);
			}
			return true;
		}
		
		public BST remove(int value) {
			remove(value, null);
			return this;
		}
		
		public void remove(int value, BST parent) {
				if(value < this.value) {
					if(left != null) {
						left.remove(value, this);
					}
				}else if(value > this.value) {
						if(right != null) {
							right.remove(value, this);
						}
					}else {
						if(left != null & right != null) {
							this.value = right.getMinValue();
							right.remove(this.value, this);
						}else if(parent == null) {
							if(left != null) {
								this.value = left.value;
								right = left.right;
								left = left.left;
							}else if(right != null) {
								this.value = right.value;
								left = right.left;
								right = right.right;
							}else {
								
							}
						}else if(parent.left == this) {
							parent.left = left != null?left:right;
						}else if(parent.right == this) {
							parent.right = left != null?left:right;
						}
					}
		}
		
		
		public int getMinValue() {
			if(left == null) {
				return this.value;
			}
			return left.getMinValue();
		}
		
		public boolean containsIterative(int value) {
			BST currentNode = this;
			while(currentNode != null) {
				if(currentNode.value > value) {
					currentNode = currentNode.left;
				}else if(currentNode.value < value) {
					currentNode = currentNode.right;
				}else {
					return true;
				}
			}
			return false;
		}
		
		public BST insertIterative(int value) {
			BST currentNode = this;
			while(true) {
				if(value < currentNode.value) {
					if(currentNode.left == null) {
						BST newNode = new BST(value);
						currentNode.left = newNode;
						break;
					}else {
						currentNode = currentNode.left;
					}
				}else {
					if(currentNode.right == null) {
						BST newNode = new BST(value);
						currentNode.right = newNode;
						break;
					}else {
						currentNode = currentNode.right;
					}
				}
			}
			return this;
		}
		
		// In removal, needs parent node reference
		public void removeIterative(int value,BST parentNode) {
			BST currentNode = this;
			while(currentNode != null) {
				if(currentNode.value > value) {
					parentNode = currentNode;
					currentNode = currentNode.left;
				}else if(currentNode.value > value) {
					parentNode = currentNode;
					currentNode = currentNode.right;
				}else {
					if(currentNode.left != null && currentNode.right != null) {
						currentNode.value = currentNode.right.getMinValue();
						currentNode.right.remove(currentNode.value, currentNode);
					}else if (parentNode == null) {
						if(currentNode.left != null) {
							currentNode.value = currentNode.left.value;
							currentNode.right = currentNode.left.right;
							currentNode.left = currentNode.left.left;
						}else if(currentNode.right != null) {
							currentNode.value = currentNode.right.value;
							currentNode.right = currentNode.right.right;
							currentNode.left = currentNode.right.left;
						}else {
							
						}
					}else if(parentNode.left == currentNode) {
						parentNode.left = currentNode.left != null ?currentNode.left : currentNode.right;
					}else if(parentNode.right == currentNode) {
						parentNode.right = currentNode.left != null ?currentNode.left : currentNode.right; 
					}
					break;
				}
				
			}
		}
	}
	
	

}
