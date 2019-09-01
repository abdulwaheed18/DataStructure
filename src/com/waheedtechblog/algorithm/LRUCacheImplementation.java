package com.waheedtechblog.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of LRU Cache
 * 
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class LRUCacheImplementation {

	private int lruSize;
	private Map<Integer, Node> map = null;
	private Node head;
	private Node tail;

	public LRUCacheImplementation(int lruSize) {
		super();
		this.lruSize = lruSize;
		this.map = new HashMap<>(lruSize);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			deleteNode(node);
			addAtHead(node);
			return node.value;
		} else
			return -1;
	}

	private void deleteNode(Node node) {
		// node is head
		if (node.prev == null) {
			head = head.next;
		} else {
			node.prev.next = node.next;
		}

		// Node is tail
		if (node.next == null) {
			tail = tail.prev;
		} else {
			node.next.prev = node.prev;
		}
	}

	private void addAtHead(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;

		if (head.next == null) {
			tail = head;
		}
	}

	public void setValue(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addAtHead(node);
		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= lruSize) {
				map.remove(tail.key);
				deleteNode(tail);
			}
			addAtHead(newNode);
			map.put(key, newNode);
		}
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println("key is:  " + temp.key + " and value is: " + temp.value);
			temp = temp.next;
		}
	}

	public static void main(String args[]) {

		LRUCacheImplementation cacheImplementation = new LRUCacheImplementation(4);
		cacheImplementation.setValue(1, 1000);
		cacheImplementation.setValue(2, 2000);
		cacheImplementation.setValue(3, 3000);
		cacheImplementation.setValue(4, 4000);
		cacheImplementation.setValue(4, 5000);
		cacheImplementation.setValue(4, 6000);
		cacheImplementation.setValue(5, 7000); // must delete key 1 to add key 5

		// key 1 should get deleted and return -1 and 5 should be head here
		cacheImplementation.display();
		System.out.println("Is Key 1 present: " + cacheImplementation.get(1));
		System.out.println("=============================================");

		// add few more values
		cacheImplementation.setValue(12, 20000);
		cacheImplementation.setValue(3, 30000);
		cacheImplementation.display();
		cacheImplementation.setValue(14, 4000);

		// 14 should be head here
		System.out.println("=============================================");
		cacheImplementation.display();

	}

	class Node {
		int key;
		int value;
		Node next = null;
		Node prev = null;

		public Node(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

}

/**
 * 
 * 
 * Output:
 * 
 * key is:  5 and value is: 7000
key is:  4 and value is: 6000
key is:  3 and value is: 3000
key is:  2 and value is: 2000
Is Key 1 present: -1
=============================================
key is:  3 and value is: 30000
key is:  12 and value is: 20000
key is:  5 and value is: 7000
key is:  4 and value is: 6000
=============================================
key is:  14 and value is: 4000
key is:  3 and value is: 30000
key is:  12 and value is: 20000
key is:  5 and value is: 7000
 * 
 * */
