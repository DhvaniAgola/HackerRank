package com.leetcode.learningcards.stack;

import java.util.Stack;

public class DailyTemperatures {
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

		int[] answers = dailyTemperatures(temperatures);
		for (int i = 0; i < answers.length; i++) {
			System.out.println(answers[i]);
		}

	}

	static int[] dailyTemperatures(int[] temperatures) {
		int[] answers = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();
		int top;
		for (int i = 0; i < temperatures.length; i++) {
			if (stack.empty()) {
				stack.push(i);
			} else {
				while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
					top = stack.pop();
					answers[top] = i - top;
				}
				stack.push(i);
			}
		}


		return answers;
	}
}
