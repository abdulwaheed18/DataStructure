package com.waheedtechblog.stack;

import java.util.*;

/**
 * Sorting of Stack using temp Stack
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class StackSortUsingTempStack {

	// Sort a stack using another stack
	public Stack<Integer> sortStack(Stack<Integer> stack) {

		Stack<Integer> tempStack = new Stack<>();
		while (!stack.isEmpty()) {
			int currentData = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
				stack.push(tempStack.pop());
			}
			tempStack.push(currentData);
		}
		return tempStack;
	}

	public void display(Stack<Integer> stack) {
		stack.forEach(v -> System.out.println(v));
	}

	public static void main(String[] args) {

		StackSortUsingTempStack sortUsingTempStack = new StackSortUsingTempStack();
		System.out.println("=================");
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(30);
		stack.push(50);
		stack.push(40);
		sortUsingTempStack.display(stack);

		stack = sortUsingTempStack.sortStack(stack);
		System.out.println("=================");
		System.out.println("After Sorting :");
		System.out.println("=================");
		sortUsingTempStack.display(stack);

	}

}
