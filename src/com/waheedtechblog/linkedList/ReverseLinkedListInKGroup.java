package com.waheedtechblog.linkedList;

public class ReverseLinkedListInKGroup {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.addFirst(8);
        linkedList.addFirst(6);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(7);
        linkedList.addFirst(1);
        linkedList.addFirst(10);

        // display
        linkedList.printLinkedList();
        Node head = linkedList.getHead();
        Node reverseNode = reverse(head,2);
        display(reverseNode);
    }

    /* Function to print linked list */
    public static void display(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head, int K){
        int count=0;
        Node current = head;
        Node next = null;
        Node prev = null;

        while(current !=null && count <K){
            next = current.next;
            current.next = prev;
            prev=current;
            current = next;
            count++;
        }
        if(next != null){
            head.next = reverse(next,K);
        }
        return prev;
    }
}
