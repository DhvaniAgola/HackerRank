package com.leetcode.learningcards.array;

public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {3, 3};
		int val = 3;

//		method1(nums, val);
		System.out.println("=====");
		method2(nums, val);

	}

	static void method1(int[] nums, int val) {
		int i = 0;

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == val) {

			} else {
				nums[i] = nums[j];
				i++;
			}
		}
		System.out.println(i);
		for (int j = 0; j < i; j++)
			System.out.println(nums[j]);
	}

	static void method2(int[] nums, int val) {
		if (nums.length == 0) {
			System.out.println(0);
			return;
		}
		if (nums.length == 1) {
			if (nums[0] == val) {
				System.out.println(0);
				return;
			} else {
				System.out.println(1);
				return;
			}
		}
		int i = 0;
		int j = nums.length - 1;

		while (j >= 0 && nums[j] == val) {
			j--;
		}
		while (i < j) {
			if (nums[i] == val) {
				nums[i] = nums[j];
				nums[j] = val;
				j--;
			}
			i++;
		}
		System.out.println(j + 1);
		for (int k = 0; k < j; k++)
			System.out.println(nums[k]);
	}
}
