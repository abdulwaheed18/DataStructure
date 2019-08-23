package com.waheedtechblog.stack;

/**
 * Implementation of Stack using LinkedList
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class CustomStackUsingLinkedList {

	private Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public int pop() {
		int data = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Stack is Empty...");
		} else {
			data = head.data;
			head = head.next;
		}
		return data;

	}

	public int peek() {
		int data = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Stack is Empty...");
		} else {
			data = head.data;
		}
		return data;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else
			return false;
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CustomStackUsingLinkedList lls = new CustomStackUsingLinkedList();
		lls.push(20);
		lls.push(50);
		lls.push(80);
		lls.push(40);
		lls.push(60);
		lls.push(75);
		printList(lls.head);
		System.out.println("=============================");
		System.out.println("Element removed from LinkedList: " + lls.pop());
		System.out.println("Element removed from LinkedList: " + lls.pop());
		lls.push(10);
		System.out.println("Element removed from LinkedList: " + lls.pop());
		printList(lls.head);
	}
}
