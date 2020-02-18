package com.waheedtechblog.tree;

public class IsTreeBST {
    static Node prev;

    public static void main(String[] args) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        Node root = newNode(7);
        root.left = newNode(5);
        root.right = newNode(8);
        root.left.left = newNode(1);
        root.left.right = newNode(6);

        System.out.println("\n====== Using first BST===============");
        if (isBST1(root, min, max))
            System.out.print("Given Tree is Balance Search Tree");
        else
            System.out.print("Given Tree is NOT Balance Search Tree");

        System.out.println("\n====== Using second BST===============");
        if (isBSTUsingInorder(root))
            System.out.print("Given Tree is Balance Search Tree");
        else
            System.out.print("Given Tree is NOT Balance Search Tree");

    }

    public static boolean isBST1(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;
        return (isBST1(root.left, min, root.data - 1) && isBST1(root.right, root.data + 1, max));
    }

    /**
     * Balance Tree will always be in sorted in Ascending order
     *
     * @param root
     * @return
     */
    public static boolean isBSTUsingInorder(Node root) {
        if (root != null) {
            // CHeck left node
            if (!isBSTUsingInorder(root.left))
                return false;
            // current node data should be greater than previous node
            if (prev != null && root.data < prev.data)
                return false;
            prev = root;
            return isBSTUsingInorder(root.right);
        }
        return true;
    }

    static Node newNode(int data) {
        Node node = new Node(data);
        node.left = null;
        node.right = null;
        return node;
    }

}

/**
 * ====== Using first BST===============
 * Given Tree is Balance Search Tree
 * ====== Using second BST===============
 * Given Tree is Balance Search Tree
 */
