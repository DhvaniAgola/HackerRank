package com.leetcode.learningcards.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (tokens[i].equals("-")) {
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2 - val1);
			} else if (tokens[i].equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (tokens[i].equals("/")) {
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2 / val1);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		System.out.println(stack.pop());
	}
}
