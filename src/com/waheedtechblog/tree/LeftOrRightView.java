package com.waheedtechblog.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftOrRightView {

    private static int max_level = 0;
    private static boolean debug = false;
    private static int steps = 1;

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(1);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);

        System.out.println("\nDisplay Tree : ");
        printLevelOrder(root);

        System.out.println("\nLeft Subtree is : ");
        leftViewUtil(root, 1);
        max_level = 0;

        System.out.println("\nLeft Subtree using levelTraversal : ");
        leftViewUsingLevelOrder(root);

        System.out.println("\nRight Subtree is : ");
        rightViewUtil(root, 1);

        System.out.println("\nRight Subtree using levelTraversal : ");
        rightViewUsingLevelOrder(root);
    }

    public static void leftViewUtil(Node node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (debug) {
            System.out.println("Steps :" + steps + ", level : " + level + ", Max level : " + max_level + ", root : " + node.data);
            steps++;
        }
        if (max_level < level) {
            System.out.print(node.data + " ");
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void rightViewUtil(Node node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (debug) {
            System.out.println("Steps :" + steps + ", level : " + level + ", Max level : " + max_level + ", root : " + node.data);
            steps++;
        }
        if (max_level < level) {
            System.out.print(node.data + " ");
            max_level = level;
        }

        // Recur for first right and then left
        rightViewUtil(node.right, level + 1);
        rightViewUtil(node.left, level + 1);
    }

    public static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static void leftViewUsingLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int i = 0;
            while (i++ < size) {
                Node temp = q.poll();
                if(i==1)
                    System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }

        }

    }

    public static void rightViewUsingLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int i = 0;
            while (i++ < size) {
                Node temp = q.poll();
                if(i==size)
                    System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }

        }
    }
}

/**
 * Display Tree :
 * 4 5 2 3 1 6 7
 * Left Subtree is :
 * 4 5 3 6
 * Left Subtree using levelTraversal :
 * 4 5 3 6
 * Right Subtree is :
 * 4 2 1 7
 * Right Subtree using levelTraversal :
 * 4 2 1 7
 */
