package com.leetcode.learningcards.array;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		int k = 4;

//		method1_justPrint(nums, k);
		method2_inSameArray_noExtraSpace(nums, k);

	}

	static void method1_justPrint(int[] nums, int k) {
		int startIndex = nums.length - k;
		int len = nums.length;

		for (int i = 0; i < nums.length; i++) {
			startIndex = startIndex % len;
			System.out.println(nums[startIndex]);
			startIndex++;
		}
	}

	static void method2_inSameArray_noExtraSpace(int[] nums, int k) {
		int index;
		int initIndex;
		int val;
		int temp;
		int len = nums.length;
		for (int i = 0, j = 0; i < nums.length; j++) {
			index = (j + k) % len;
			initIndex = index;
			val = nums[j];

			while (true) {
				temp = nums[index];
				nums[index] = val;
				val = temp;
				i++;
				index = (index + k) % len;
				if (initIndex == index || i >= len) {
					break;
				}
			}
		}
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
}
