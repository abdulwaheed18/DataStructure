package com.waheedtechblog.queue;

public class CustomQueueUsingArray {

	public int queueSize;
	public int ar[];
	int front;
	int rear;
	int capacity;

	CustomQueueUsingArray(int queueSize) {
		this.queueSize = queueSize;
		ar = new int[queueSize];
		front = 0;
		rear = -1;
		capacity = 0;
	}

	public boolean isFull() {
		return (capacity == queueSize );
	}

	public boolean isEmpty() {
		return (capacity == 0);
	}

	public void add(int data) {
		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			if (rear == queueSize - 1) {
				rear = 0;
			} else {
				rear++;
			}
			ar[rear] = data;
			capacity++;
			System.out.println("Data added to queue: " + data);
		}
	}

	public int peek() {
		int data = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			data = ar[front];
		}
		return data;
	}

	public int poll() {
		int data = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			data = ar[front];
			if (front == queueSize - 1)
				front = 0;
			else
				front++;
			capacity--;
		}
		return data;
	}

	public static void main(String[] args) {
		// create a queue of capacity 5
		CustomQueueUsingArray q = new CustomQueueUsingArray(5);

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		System.out.println("Front element is: " + q.peek());
		q.poll();
		System.out.println("Front element is: " + q.peek());

		q.poll();
		System.out.println("Front element is: " + q.peek());
		q.poll();

		if (q.isEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");

	}

}
