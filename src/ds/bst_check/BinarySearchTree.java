package ds.bst_check;

/**
Checks whether the given binary tree is binary search tree or not.

For binary tree meets the following condition, it should be a binary search tree.
Every node in the left subtree should be less than the current node and every node  in the right subtree.

Refer: http://en.wikipedia.org/wiki/Binary_search_tree

HOW?

*/

public class BinarySearchTree {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Node(Node left, int data, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	//inserts data in sorted order
	private Node insert(Node node, int data) {

		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	 public void inorder() {
		 inorder(root);
	 }

	//traverse left , root and then right
	 private void inorder(Node node) {
		 if (node != null) {
			 inorder(node.left);
			 System.out.println(node.data);
			 inorder(node.right);
		 }
	 }


	 public void searchReplace(int oldVal, int newVal)
	 {
		 searchReplace(root, oldVal, newVal);
	 }

	 private void searchReplace(Node node, int oldVal, int newVal)
	 {

		 if( node.data == oldVal ) {
			 node.data = newVal;
			 return;
		 }

		 if( oldVal < node.data ) {
			 searchReplace(node.left, oldVal, newVal);
		 }else {
			 searchReplace(node.right, oldVal, newVal);
		 }

	 }
	 
	 //checks whether the binary tree is binary search tree or not
	 public boolean isBST() {

		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	 }

	 private boolean isBST(Node node, int minData, int maxData) {
		 if(node == null) {
			 return true;
		 }
		 if(node.data < minData || node.data > maxData) {
			 return false;
		 }

		 return isBST(node.left, minData, node.data) && isBST(node.right, node.data, maxData);
	 }

	public static void main(String[] args) {
		int[] nums = {14, 2, 40, 9, 31, 25, 18,5};

		BinarySearchTree bst = new BinarySearchTree();
		for(int n : nums ) {
			bst.insert(n);
		}

		bst.inorder();

		System.out.println("isBST : " + bst.isBST());

		// make this tree as non binary search tree
		bst.searchReplace(2, 20);

		bst.inorder();
		System.out.println("isBST : " + bst.isBST());

	}

}
