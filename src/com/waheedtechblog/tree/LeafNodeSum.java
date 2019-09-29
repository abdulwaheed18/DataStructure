package com.waheedtechblog.tree;

public class LeafNodeSum {

	Node root;

	LeafNodeSum() {
		this.root = null;
	}

	int sum = 0;

	public int sumLeafNode() {
		sumLeafNode(root);
		return sum;
	}

	private void sumLeafNode(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			sum += root.data;
		}
		sumLeafNode(root.left);
		sumLeafNode(root.right);
	}

	public static void main(String[] args) {
		LeafNodeSum tree = new LeafNodeSum();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(9);
		tree.root.left.right = new Node(5);

		System.out.println("Sum of Leaf Node is: " + tree.sumLeafNode());

	}
}

/**
 * Output: Sum of Leaf Node is: 17
 */
