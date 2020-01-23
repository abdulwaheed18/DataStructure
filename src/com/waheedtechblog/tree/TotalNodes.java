package com.waheedtechblog.tree;

/**
 * Count total number of nodes present in Tree
 */
public class TotalNodes {

    Node root;

    public TotalNodes() {
        this.root = null;
    }

    public int countNodes(Node root){
        if(root ==null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        TotalNodes tree = new TotalNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(5);

        System.out.println("Total Nodes: " + tree.countNodes(tree.root));
    }
}

/**
 * Output:
 * Total Nodes: 5
 */
