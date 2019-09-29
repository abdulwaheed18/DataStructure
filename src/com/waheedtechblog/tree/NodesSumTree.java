package com.waheedtechblog.tree;

/**
 * Java program to sum of all nodes
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class NodesSumTree {

	Node root;

	NodesSumTree() {
		root = null;
	}

	private int sum(Node root) {

		if (root == null)
			return 0;

		return (root.data + sum(root.left) + sum(root.right));
	}

	public int sum() {
		return sum(root);
	}

	public static void main(String[] args) {

		NodesSumTree tree = new NodesSumTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(9);
		tree.root.left.right = new Node(5);

		System.out.println("Sum of tree is: " + tree.sum());

	}
}

/**
 * Output: Sum of tree is: 20
 */
