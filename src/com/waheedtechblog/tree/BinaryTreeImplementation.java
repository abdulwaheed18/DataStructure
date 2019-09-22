/**
 * 
 */
package com.waheedtechblog.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementatin of Binary Tree (NOT BINARY SEARCH TREE)
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class BinaryTreeImplementation {

	// Root of Binary Tree
	Node root;

	BinaryTreeImplementation() {
		this.root = null;
	}

	private void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

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

	public void levelOrderTraversal() {
		levelOrderTraversal(root);
	}

	public Node isValueExist(int num) {
		if (root == null)
			return null;
		Queue<Node> queues = new LinkedList<>();
		queues.add(root);
		while (!queues.isEmpty()) {
			Node node = queues.poll();
			if (node.data == num)
				return node;
			if (node.left != null)
				queues.add(node.left);
			if (node.right != null)
				queues.add(node.right);
		}
		return null;
	}

	public void insertNode(Node newNode) {
		if (root == null)
			return;
		Queue<Node> queues = new LinkedList<>();
		queues.add(root);
		while (!queues.isEmpty()) {
			Node node = queues.poll();
			if (node.left != null)
				queues.add(node.left);
			else {
				node.left = newNode;
				return;
			}
			if (node.right != null)
				queues.add(node.right);
			else {
				node.right = newNode;
				return;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinaryTreeImplementation tree = new BinaryTreeImplementation();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Pre Order Traversal");
		tree.preOrderTraversal();

		System.out.println("\nIn Order Traversal");
		tree.inOrderTraversal();

		System.out.println("\nPost Order Traversal");
		tree.postOrderTraversal();

		System.out.println("\nLevel Order Traversal");
		tree.levelOrderTraversal();

		int num1 = 5;
		System.out.println("\n\nIs Value '" + num1 + "' exist in Tree ");
		if (tree.isValueExist(num1) != null)
			System.out.println("Yes");
		else
			System.out.println("No");

		int num2 = 10;
		System.out.println("\nIs Value '" + num2 + "' exist in Tree ");
		if (tree.isValueExist(num2) != null)
			System.out.println("Yes");
		else
			System.out.println("No");

		Node newNode = new Node(6);
		System.out.println("\nAdding new node '6' to existing tree");
		tree.insertNode(newNode);

		System.out.println("Level Order Traversal after adding new node 6");
		tree.levelOrderTraversal();
	}
}
