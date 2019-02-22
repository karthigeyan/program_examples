package ds.bst_leaf_count;

/**
WHAT?
Counts number of leaf nodes in a binary tree.

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

	//counts number of leaf nodes in a binary tree
	public int countLeafNode() {
		return countLeafNode(root);
	}

	private int countLeafNode(Node node) {
		if( node == null ) {
			return 0;
		}
		if ( node.left == null && node.right == null ) {
			return 1;
		}
		return countLeafNode(node.left) + countLeafNode(node.right);
	}


	public static void main(String[] args) {
		int[] nums = {14, 2, 40, 9, 31, 25, 18,5};

		BinarySearchTree bst = new BinarySearchTree();
		for(int n : nums ) {
			bst.insert(n);
		}

		System.out.println("Leaf nodes : " + bst.countLeafNode());
	}

}
