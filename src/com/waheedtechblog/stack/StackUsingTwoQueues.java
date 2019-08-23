package com.waheedtechblog.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of Stack using 2 Queues
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class StackUsingTwoQueues {

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	StackUsingTwoQueues() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int data) {
		if (queue1.isEmpty()) {
			queue1.add(data);
		} else {
			queue2.addAll(queue1);
			queue1.clear();
			queue1.add(data);
			queue1.addAll(queue2);
			queue2.clear();
		}
	}

	public Integer pop() {
		if (queue1.isEmpty()) {
			System.err.println("Stack is Empty");
			return -1;
		} else {
			return queue1.poll();
		}
	}

	public Integer peek() {
		if (queue1.isEmpty()) {
			System.err.println("Stack is Empty");
			return -1;
		} else {
			return queue1.peek();
		}
	}

	public void display() {
		queue1.forEach(v -> System.out.println(v));
	}

	public static void main(String[] args) {
		StackUsingTwoQueues stack = new StackUsingTwoQueues();
		stack.push(20);
		stack.push(40);
		stack.push(70);
		stack.push(50);
		stack.push(90);
		stack.push(110);
		stack.push(30);
		stack.display();
		System.out.println("Removed element : " + stack.pop());
		System.out.println("=============================");
		stack.push(170);
		stack.display();
		System.out.println("Removed element : " + stack.pop());
		System.out.println("=============================");
		stack.display();
	}

}
