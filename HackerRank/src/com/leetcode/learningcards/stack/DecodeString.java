package com.leetcode.learningcards.stack;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String str = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

		String decoded = decode(str);
		System.out.println(decoded);
	}

	static String decode(String str) {
		Stack<Character> stack = new Stack<>();
		String st = "";
		String temp = "";

		String temp2 = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ']') {

				while (stack.peek() != '[') {
					temp2 = stack.pop() + temp2;
				}
				stack.pop();
				if (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
					String num = "";
					while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
						num = stack.pop() + num;
					}
					int count = Integer.parseInt(num);
					while (count > 0) {
						temp += temp2;
						count--;
					}
				}

				for (int j = 0; j < temp.length(); j++) {
					stack.push(temp.charAt(j));
				}
				temp2 = "";
				temp = "";
			} else {
				stack.push(str.charAt(i));
			}
		}
		temp = "";
		while (!stack.empty()) {
			temp = stack.pop() + temp;
		}
		st += temp2 + temp;
		return temp;
	}
}
