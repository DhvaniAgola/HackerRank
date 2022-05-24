package com.leetcode.learningcards.array;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 4, 5, 5, 5, 6, 7};

		int i, j;
		for (i = 0, j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		System.out.println(i + 1);
	}
}
