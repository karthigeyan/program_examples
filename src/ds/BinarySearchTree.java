package ds;

/**

Refer: http://en.wikipedia.org/wiki/Binary_search_tree

Implement the following  additional methods
1. delete(int data )
2. boolean search(int data)
6. int count() - count number of nodes in the tree
7. int leafCount() - count number of leaves in the tree
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

	 public void preorder() {
		 preorder(root);
	 }

	//traverse root, left and then right
	 private void preorder(Node node) {
		 if (node != null) {
			 System.out.println(node.data);
			 preorder(node.left);
			 preorder(node.right);
		 }
	 }

	 public void postorder() {
		 postorder(root);
	 }

	//traverse left, right and then root
	 private void postorder(Node node) {
		 if (node != null) {
			 postorder(node.left);
			 postorder(node.right);
			 System.out.println(node.data);
		 }
	 }



	public static void main(String[] args) {
		int[] nums = {14, 2, 40, 9, 31, 25, 18,5};

		BinarySearchTree bst = new BinarySearchTree();
		for(int n : nums ) {
			bst.insert(n);
		}

		//prints sorted numbers
		//inorder traversing , prints number in sorted order
		bst.inorder();

	}

}
