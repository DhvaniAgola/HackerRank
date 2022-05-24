package com.leetcode.learningcards.stack;

import java.util.Stack;

public class MinimumOfStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}

class MinStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> min = new Stack<>();


	public MinStack() {

	}

	public void push(int val) {
		stack.push(val);
		min.push(min.size() > 0 ? Math.min(val, min.peek()) : val);
	}

	public void pop() {
		stack.pop();
		min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
