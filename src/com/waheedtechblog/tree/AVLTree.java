package com.waheedtechblog.tree;

public class AVLTree {

	Node root;

	public int height(Node node) {
		if (node == null) {
			return -1;
		} else {
			return node.height;
		}
	}

	public int max(int left, int right) {
		return left > right ? left : right;
	}

	public Node leftRotate(Node currentNode) {
		Node newNode = currentNode.right;
		Node leftOfNewNode = newNode.left;

		// rotate the nodes
		newNode.left = currentNode;
		currentNode.right = leftOfNewNode;

		// updates the height
		newNode.height = max(height(newNode.left), height(newNode.right)) + 1;
		currentNode.height = max(height(currentNode.left), height(currentNode.right)) + 1;
		return newNode;
	}

	public Node rightRotate(Node currentNode) {
		Node newNode = currentNode.left;
		Node rightofNewNode = newNode.right;

		newNode.right = currentNode;
		currentNode.left = rightofNewNode;

		// updates the height
		newNode.height = max(height(newNode.left), height(newNode.right)) + 1;
		currentNode.height = max(height(currentNode.left), height(currentNode.right)) + 1;
		return newNode;
	}

	public int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	public Node insertNode(Node root, int key) {

		if (root == null) {
			return root = new Node(key);
		}

		// add new node
		if (key < root.data) {
			root.left = insertNode(root.left, key);
		} else if (key > root.data) {
			root.right = insertNode(root.right, key);
		} else
			return root;

		// update
		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		// LL case
		if (balance > 1 && key < root.left.data) {
			return rightRotate(root);
		}

		// RR case
		if (balance < -1 && key > root.right.data) {
			return leftRotate(root);
		}

		// LR case
		if (balance > 1 && key > root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// RR case
		if (balance < -1 && key < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	Node minValueNode(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null)
			current = current.left;

		return current;
	}

	Node deleteNode(Node root, int key) {
		// DELETE operation js like BST
		if (root == null)
			return root;

		if (key < root.data)
			root.left = deleteNode(root.left, key);
		else if (key > root.data)
			root.right = deleteNode(root.right, key);
		else {

			// if node to be deleted has 1 or 0 child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// Get the inorder successor (smallest
			// in the right subtree)
			Node minkey = minValueNode(root.right);
			root.data = minkey.data;
			root.right = deleteNode(root.right, minkey.data);

		}

		// now Balance tree operation perform just like we did in insertion
		if (root == null)
			return root;

		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);

		// Left Right Case
		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.data + " ");
		inOrderTraversal(root.right);
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insertNode(tree.root, 10);
		tree.root = tree.insertNode(tree.root, 20);
		tree.root = tree.insertNode(tree.root, 30);
		tree.root = tree.insertNode(tree.root, 40);
		tree.root = tree.insertNode(tree.root, 50);
		tree.root = tree.insertNode(tree.root, 25);

		System.out.println("InOrder traversal of constructed tree is : ");
		tree.inOrderTraversal(tree.root);

		tree.deleteNode(tree.root, 30);

		System.out.println("\nInOrder traversal of constructed tree after deletion : ");
		tree.inOrderTraversal(tree.root);

	}

}
