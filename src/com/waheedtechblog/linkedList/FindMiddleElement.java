package com.waheedtechblog.linkedList;

/**
 * Find midle element from the linked list
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class FindMiddleElement {

	public static void main(String[] args) {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.addFirst(10);
		linkedList.addFirst(8);
		linkedList.addFirst(6);
		linkedList.addFirst(4);
		// linkedList.addFirst(2);

		// display
		linkedList.printLinkedList();

		FindMiddleElement middleElement = new FindMiddleElement();
		Node head = linkedList.getHead();
		int data = middleElement.getMiddleElement(head);
		System.out.println("Middle Element: " + data);

	}

	public int getMiddleElement(Node head) {
		Node slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;

	}

}
