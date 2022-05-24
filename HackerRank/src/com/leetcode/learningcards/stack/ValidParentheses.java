package com.leetcode.learningcards.stack;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "{{[(()]}}";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (!stack.empty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (s.charAt(i) == ']') {
				if (!stack.empty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else if (s.charAt(i) == '}') {
				if (!stack.empty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else
				stack.push(s.charAt(i));
		}
		return stack.empty();
	}
}
