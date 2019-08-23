package com.waheedtechblog.linkedList;

/**
 * Find nth element from end of linked list
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class FindNthElement {

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

		FindNthElement element = new FindNthElement();

		int data = element.getNEleemntFromEnd(head, 3);
		System.out.println("Nth Element from end: " + data);

	}

	public int getNEleemntFromEnd(Node head, int pos) {
		Node fast = head;
		Node slow = head;

		for (int i = 0; i < pos; i++) {
			fast = fast.next;

		}

		if (fast == null) {
			// invalid
			return Integer.MIN_VALUE;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

}
