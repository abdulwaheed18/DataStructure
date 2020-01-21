package com.waheedtechblog.tree;

/**
 * Sum Tree
 * A tree is a sum tree if sum of left and right child should equal to parent sum.
 *
 * Problem Statement
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class IsSumTree {

    Node root;

    public boolean isSumTree(Node node){
        /**
         * An emptry is also a subtree
         */
        if(node == null || node.left == null || node.right == null)
            return true;
        int ls, rs;
        ls = sum(node.left);
        rs = sum(node.right);
        if(node.data == ls+rs && isSumTree(node.left) && isSumTree(node.right))
            return true;
        return false;
    }

    int sum(Node node){
        if(node == null)
            return 0;
        return sum(node.left) + node.data + sum(node.right);
    }


    public static void main(String[] args) {

        IsSumTree tree = new IsSumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(1);

        if(tree.isSumTree(tree.root)){
            System.out.println("Tree is Sum tree");
        } else {
            System.out.println("Tree is not sum tree");
        }

    }
}
