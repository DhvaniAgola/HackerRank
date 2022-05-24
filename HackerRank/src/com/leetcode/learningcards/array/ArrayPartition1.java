package com.leetcode.learningcards.array;

import java.util.Arrays;

public class ArrayPartition1 {
	public static void main(String[] args) {
		int[] nums = {6, 2, 6, 5, 1, 2};

		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		System.out.println(sum);
	}
}
