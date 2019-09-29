package com.waheedtechblog.tree;

/**
 * Basic structure of Tree Node
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class Node {
	int data;
	// height is useful during AVL Tree
	int height;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		height = 1;
	}
}