package com.waheedtechblog.linkedList;

/**
 * Check if loop exists in LinkedList and yes then find the start node
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class DetectLoop {

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

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	public boolean ifLoopExists() {
		Node slowPtr = head;
		Node fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}

	public Node findStartNode() {
		Node sp = head;
		Node fp = head;
		boolean isLoopExists = false;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;
			if (sp == fp) {
				isLoopExists = true;
				break;
			}
		}
		if (isLoopExists) {
			sp = head;
			while (sp != fp) {
				sp = sp.next;
				fp = fp.next;
			}
		} else {
			System.err.println("Loop does not exist");
			sp = null;
		}

		return sp;

	}

	public static void main(String[] args) {
		DetectLoop detectLoop = new DetectLoop();

		Node loopNode = new Node(30);
		detectLoop.addToTheLast(new Node(10));
		detectLoop.addToTheLast(new Node(20));
		detectLoop.addToTheLast(loopNode);
		detectLoop.addToTheLast(new Node(40));
		detectLoop.addToTheLast(new Node(50));

		detectLoop.display();
		// creating a loop
		detectLoop.addToTheLast(loopNode);
		System.out.println("Loop existed-->" + detectLoop.ifLoopExists());

		Node startNode = detectLoop.findStartNode();
		if (startNode != null) {
			System.out.println("Start Node: " + startNode.value);
		}

	}

}
