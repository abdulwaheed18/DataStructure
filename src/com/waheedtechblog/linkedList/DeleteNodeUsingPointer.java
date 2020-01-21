package com.waheedtechblog.linkedList;

/**
 *
 * Problem Statement:
 * https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
 * Given only a pointer/reference to a node to be deleted in a singly linked list
 */
public class DeleteNodeUsingPointer {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(8);
        linkedList.addFirst(6);
        linkedList.addFirst(4);
        linkedList.addFirst(2);

        // display
        linkedList.printLinkedList();

        Node head = linkedList.getHead();

        //Get some random node that need to be deleted
        Node toBeDeleted = getNode(head,6);

        //delete the node
        deleteSpecificNode(toBeDeleted);
        System.out.println("List after deleting node " + toBeDeleted.data);
        linkedList.printLinkedList();

    }

    /**
     * Rather than deleting specific node, we can copy the next node to current node and delete the next one.
     * @param node
     */
    static void deleteSpecificNode(Node node){
        if(node == null)
            return;
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        temp = null;
    }

    /**
     * Utils to get the Node
     * @param head head of the node
     * @param n node to be find out
     * @return Node
     */
    static Node getNode(Node head, int n){
        Node curr = head;
        while(curr.next != null){
            if(curr.data==n){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }


}
