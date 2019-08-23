package com.waheedtechblog.linkedList;

/**
 * Implementation of LinkedList
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class CustomLinkedList {

	private Node head;

	public void addFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		} else {
			node.next = head;
			head = node;
			return;
		}
	}

	public Node getHead() {
		return head;
	}

	public void addLast(int data) {
		Node node = new Node(data);
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		return;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	// used to delete node from start of linked list
	public Node deleteFirst() {
		Node temp = head;
		head = head.next;
		return temp;
	}

	// For printing Linked List
	public void printLinkedList() {
		System.out.println("Printing LinkedList (head --> last) ");
		Node current = head;
		while (current != null) {
			System.out.print(" " + current.data);
			current = current.next;
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

}
