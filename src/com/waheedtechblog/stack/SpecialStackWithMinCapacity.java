package com.waheedtechblog.stack;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1).
 */
public class SpecialStackWithMinCapacity {

    private Stack<Integer> specialStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        SpecialStackWithMinCapacity s = new SpecialStackWithMinCapacity();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        s.push(2);
        System.out.println(s.getMin());
    }


    public void push(int data) {
        // push all the data to main stack
        specialStack.push(data);
        // if min stack is not empty and top element is not minimum then update it
        if (!minStack.isEmpty()) {
            int isMin = minStack.peek();
            if (data < isMin) {
                minStack.push(data);
            }
        } else {
            minStack.push(data);
        }
    }

    public int pop() {
        // delete the element from main stack and if min top element is same as pop element then removed it from minimum as well
        int pop = specialStack.pop();
        int peek = minStack.peek();
        if (pop == peek)
            minStack.pop();
        return pop;
    }

    public int getMin() {
        return minStack.peek();
    }


}
