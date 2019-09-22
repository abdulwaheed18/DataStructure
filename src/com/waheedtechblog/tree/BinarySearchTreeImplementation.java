package com.waheedtechblog.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementatin of Binary Search tree
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class BinarySearchTreeImplementation {

	private Node root;

	public BinarySearchTreeImplementation() {
		root = null;
	}

	private Node search(Node root, int value) {
		if (root == null)
			return null;
		if (root.data == value)
			return root;
		else if (root.data > value)
			return search(root.left, value);
		else
			return search(root.right, value);
	}

	/**
	 * Time Complexity O(n log n) Space Complexity O(n log n)
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	public Node search(int value) {
		return search(root, value);
	}

	private void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	/**
	 * Time Complexity O(n) Space Complexity O(n)
	 */
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	/**
	 * Time Complexity O(n) Space Complexity O(n)
	 */
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	/**
	 * Time Complexity O(n) Space Complexity O(n)
	 */
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queues = new LinkedList<>();
		queues.add(root);
		while (!queues.isEmpty()) {
			Node node = queues.poll();
			if (node.left != null)
				queues.add(node.left);
			if (node.right != null)
				queues.add(node.right);
			System.out.print(node.data + " ");

		}
	}

	private Node insertNode(Node root, int value) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(value);
			return root;
		} else if (root.data >= value)
			root.left = insertNode(root.left, value);
		else {
			root.right = insertNode(root.right, value);
		}
		return root;
	}

	/**
	 * Time Complexity O(n log n) Space Complexity O(n log n)
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	public void insertNode(int value) {
		root = insertNode(root, value);
	}

	/**
	 * Time Complexity O(n) Space Complexity O(n)
	 */
	public void levelOrderTraversal() {
		levelOrderTraversal(root);
	}

	private int minKey(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

	public void deleteNode(int value) {
		root = deleteNode(root, value);
	}

	private Node deleteNode(Node root, int value) {

		// if tree is empty
		if (root == null)
			return root;

		// trvarse to get the Node to be deleted
		if (root.data > value)
			root.left = deleteNode(root.left, value);
		else if (root.data < value)
			root.right = deleteNode(root.right, value);
		else {
			// We are at the Node which has to be deleted

			// if node to be deleted has 1 or 0 child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// Get the inorder successor (smallest
			// in the right subtree)
			int minkey = minKey(root.right);
			root.right = deleteNode(root.right, minkey);
		}
		return root;
	}

	public static void main(String[] args) {
		BinarySearchTreeImplementation tree = new BinarySearchTreeImplementation();

		tree.insertNode(50);
		tree.insertNode(30);
		tree.insertNode(20);
		tree.insertNode(40);
		tree.insertNode(70);
		tree.insertNode(60);
		tree.insertNode(80);

		System.out.println("Inorder traversal of the given tree");
		tree.inOrderTraversal();

		System.out.println("\nDelete 20");
		tree.deleteNode(20);
		System.out.println("\nInorder traversal of the modified tree");
		tree.inOrderTraversal();

		System.out.println("\nDelete 30");
		tree.deleteNode(30);
		System.out.println("\nInorder traversal of the modified tree");
		tree.inOrderTraversal();

		System.out.println("\nDelete 50");
		tree.deleteNode(50);
		System.out.println("\nInorder traversal of the modified tree");
		tree.inOrderTraversal();
	}
}

/**
 * Output:
 * 
 * Inorder traversal of the given tree
20 30 40 50 60 70 80 
Delete 20

Inorder traversal of the modified tree
30 40 50 60 70 80 
Delete 30

Inorder traversal of the modified tree
40 50 60 70 80 
Delete 50

Inorder traversal of the modified tree
40 50 70 80 
 */
