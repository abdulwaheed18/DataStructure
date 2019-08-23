package com.waheedtechblog.linkedList;

public class ReverseLinkList {

	public static void main(String[] args) {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.addFirst(8);
		linkedList.addFirst(6);
		linkedList.addFirst(4);
		linkedList.addFirst(2);

		// display
		linkedList.printLinkedList();

		ReverseLinkList reverseLinkList = new ReverseLinkList();
		Node reverseList = reverseLinkList.reverseLinkedList(linkedList.getHead());
		reverseLinkList.printLinkedList(reverseList);

	}

	public Node reverseLinkedList(Node head) {
		Node currentNode = head, previousNode = null, NextNode = null;
		while (currentNode != null) {
			NextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = NextNode;
		}
		return previousNode;

	}

	public void printLinkedList(Node head) {
		System.out.println("Printing LinkedList (head --> last) ");
		Node current = head;
		while (current != null) {
			System.out.print(" " + current.data);
			current = current.next;
		}
		System.out.println();
	}

}
