package com.leetcode.learningcards.array;

public class MinSizeSubArraySum {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
		int target = 11;

		int i = 0, j = 0;
		int minSizeArray = Integer.MAX_VALUE;
		boolean found = false;
		int sum = 0;
		while (i <= j) {
			if (sum < target && j < nums.length) {
				sum += nums[j];
				j++;
			} else if (sum >= target && i < nums.length) {
				sum -= nums[i];
				i++;
			} else {
				break;
			}
			if (sum >= target && minSizeArray > (j - i)) {
				found = true;
				minSizeArray = j - i;
			}
		}
		System.out.println(found ? minSizeArray : 0);
	}
}
