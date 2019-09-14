/**
 * 
 */
package com.waheedtechblog.linkedList;

import java.util.Optional;

/**
 * 
 * Find Intersection of two linked lists.
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class IntersectionList {

	private Node head;

	private static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}

	}

	public void addLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public Node ifIntersectionExist(Node head1, Node head2) {

		Node temp1 = head1, temp2 = head2;
		// if anyone is null returns null
		if (temp1 == null || temp2 == null) {
			return null;
		}

		int length1 = 0, length2 = 0;
		while (temp1 != null) {
			temp1 = temp1.next;
			length1++;
		}
		while (temp2 != null) {
			temp2 = temp2.next;
			length2++;
		}

		temp1 = head1;
		temp2 = head2;
		int diff = 0;
		int i = 0;
		if (length1 > length2) {
			diff = length1 - length2;
			while (i < diff) {
				temp1 = temp1.next;
				i++;
			}
		} else {
			diff = length2 - length1;
			while (i < diff) {
				temp2 = temp2.next;
				i++;
			}
		}

		// now search for common Node
		while (temp1 != null && temp2 != null) {
			if (temp1 == temp2) {
				return temp1;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntersectionList list1 = new IntersectionList();
		IntersectionList list2 = new IntersectionList();

		Node head1 = new Node(1);
		Node head2 = new Node(4);
		Node intersection = new Node(3);

		list1.addLast(head1);
		list1.addLast(new Node(2));
		list1.addLast(intersection);
		list1.addLast(new Node(6));
		list1.addLast(new Node(7));
		list1.addLast(new Node(8));

		list2.addLast(head2);
		list2.addLast(intersection);

		Optional<Node> intersectionNode = Optional.ofNullable(list1.ifIntersectionExist(head1, head2));
		if (intersectionNode.isPresent()) {
			System.out.println("Intersection Node: " + intersectionNode.get().value);
		} else {
			System.err.println("No intersection");
		}

	}

}
