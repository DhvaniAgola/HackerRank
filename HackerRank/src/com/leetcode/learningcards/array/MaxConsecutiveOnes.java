package com.leetcode.learningcards.array;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1};

		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				if (maxCount < count)
					maxCount = count;
				count = 0;
			}
		}
		System.out.println(Math.max(maxCount, count));
	}
}
