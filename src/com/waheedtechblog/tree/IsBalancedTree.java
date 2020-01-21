package com.waheedtechblog.tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Problem Statement:
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * <p>
 * Check if tree is balanced or not?
 */
public class IsBalancedTree {

    Node root;

    /**
     * A tree is balanced when the left and right child diff should not be more than 1
     *
     * @param node
     * @return
     */
    boolean isBalanced(Node node) {

        int lh = 0, rh = 0;

        lh = height(node.left);
        rh = height(node.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * Get height of the tree
     *
     * @param node
     * @return
     */
    static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


    public static void main(String[] args) {
        IsBalancedTree tree = new IsBalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

       if(tree.isBalanced(tree.root)){
           System.out.println("Tree is Balanced");
       }  else
           System.out.println("Tree is not Balanced");

    }
}
