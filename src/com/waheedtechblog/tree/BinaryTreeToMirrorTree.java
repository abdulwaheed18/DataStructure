package com.waheedtechblog.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToMirrorTree {

    public static void main(String[] args) {
        Node root1 = newNode(7);
        root1.left = newNode(5);
        root1.right = newNode(8);
        root1.left.left = newNode(1);
        root1.left.right = newNode(6);

        System.out.println("Current Tree");
        inOrderTraversal(root1);
        System.out.println("\nMirror image tree");
        Node root2 = mirrorUsingRecursion(root1);
        inOrderTraversal(root2);

        System.out.println("\nMirror image tree after again mirroring");
        mirrorUsingIteration(root2);
        inOrderTraversal(root2);

    }

    static Node newNode(int data) {
        Node node = new Node(data);
        node.left = null;
        node.right = null;
        return node;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print("" + root.data + " ");
        inOrderTraversal(root.right);
    }

    public static Node mirrorUsingRecursion(Node root) {
        if (root == null)
            return null;
        Node left = mirrorUsingRecursion(root.left);
        Node right = mirrorUsingRecursion(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void mirrorUsingIteration(Node root) {
        if (root == null)
            return;
        // DO BFS and keep switching nodes
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            Node curr = queue.remove();

            //swap nodes
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // push if child not null
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    public static boolean areMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.data == root2.data && areMirror(root1.left, root2.right)
                && areMirror(root1.right, root2.left);
    }
}

/**
 * Current Tree
 * 1 5 6 7 8
 * Mirror image tree
 * 8 7 6 5 1
 * Mirror image tree after again mirroring
 * 1 5 6 7 8
 */
