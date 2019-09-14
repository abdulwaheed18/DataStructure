package com.waheedtechblog.linkedList;

public class IsPallindrome {

	private Node head;

	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;

		}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	public Node findMiddleElement() {
		Node sp, fp;
		sp = fp = head;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;
		}
		return sp;
	}

	public Node reverse(Node head) {
		Node prevNode, currentNode, nextNode;
		currentNode = head;
		prevNode = nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		return prevNode;
	}

	public boolean isPallindrome() {

		Node middleNode = findMiddleElement();

		Node secondHead = middleNode;
		middleNode.next = null;

		Node reverseList = reverse(secondHead);
		Node fh = head;
		while (fh != null & reverseList != null) {
			if (fh.value == reverseList.value) {
				fh = fh.next;
				reverseList = reverseList.next;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		IsPallindrome list = new IsPallindrome();
		Node head = new Node(1);
		list.addToTheLast(head);
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(1));
	//	list.addToTheLast(new Node(1));

		list.printList();
		
		System.out.println("Is list Pallindrome: " + list.isPallindrome());
	}

}
