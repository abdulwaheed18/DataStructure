package com.waheedtechblog.stack;

/**
 * Implementation of Stack using Array.
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class CustomStackUsingArray {

	private int ar[];
	private int top = -1;
	private int stackSize;

	CustomStackUsingArray(int stackSize) {
		this.stackSize = stackSize;
		ar = new int[stackSize];
	}

	public void push(int value) {
		if (!isFull()) {
			++top;
			ar[top] = value;
			System.out.println("Element pushed: " + value);
		} else {
			System.err.println("Stack is full");
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int popElement = ar[top--];
			System.out.println("Popped element :" + popElement);
			return popElement;
		} else {
			System.err.println("Stack is empty !");
			return -1;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return ar[top];
		} else {
			System.err.println("Stack is empty !");
			return -1;
		}
	}

	public boolean isFull() {
		if (stackSize - 1 == top) {
			return true;
		} else
			return false;
	}

	private boolean isEmpty() {
		if (top == -1) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		CustomStackUsingArray customStack = new CustomStackUsingArray(3);
		customStack.pop();
		System.out.println("=================");
		customStack.push(10);
		customStack.push(30);
		customStack.push(50);
		customStack.push(40);
		System.out.println("=================");
		customStack.pop();
		customStack.pop();
		customStack.pop();
		customStack.pop();
		System.out.println("=================");
	}

}
