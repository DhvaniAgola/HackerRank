package com.leetcode.learningcards.queue;

public class MyCircularQueue {

	int[] queue;
	int front;
	int rear;

	public MyCircularQueue(int k) {
		queue = new int[k];
		front = -1;
		rear = -1;
	}

	public boolean enQueue(int value) {
		if (!isFull()) {
			rear = (rear + 1) % queue.length;
			queue[rear] = value;
			if (front == -1)
				front = 0;
			return true;
		}
		return false;
	}

	public boolean deQueue() {
		if (!isEmpty()) {
			if (front != rear)
				front = (front + 1) % queue.length;
			else {
				front = -1;
				rear = -1;
			}
			return true;
		}
		return false;
	}

	public int Front() {
		if (front >= 0)
			return queue[front];
		return -1;
	}

	public int Rear() {
		if (rear >= 0)
			return queue[rear];
		return -1;
	}

	public boolean isEmpty() {
		if (front == -1 && rear == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		if (front == (rear + 1) % queue.length)
			return true;
		return false;
	}
}
