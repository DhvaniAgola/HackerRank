package com.leetcode.learningcards.array;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = {3, 0, 4, 2, 0};
		int i, j;
		for (i = 0, j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[i] = nums[j];
				i++;
			}
		}
		for (; i < nums.length; i++) {
			nums[i] = 0;
		}
		for (int k = 0; k < nums.length; k++) {
			System.out.println(nums[k]);
		}
	}
}
