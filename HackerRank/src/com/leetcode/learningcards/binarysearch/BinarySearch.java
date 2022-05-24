package com.leetcode.learningcards.binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 13;

		System.out.println(binarySearch(nums, 0, nums.length - 1, target));

	}

	static int binarySearch(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int middle = (right + left) / 2;
		if (nums[middle] == target)
			return middle;
		else if (nums[middle] > target)
			return binarySearch(nums, left, middle - 1, target);
		else
			return binarySearch(nums, middle + 1, right, target);

	}
}
