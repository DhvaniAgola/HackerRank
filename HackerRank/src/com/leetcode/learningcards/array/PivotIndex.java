package com.leetcode.learningcards.array;

public class PivotIndex {
	public static void main(String[] args) {
		int[] arr = {2, 1, -1, -3, 3};
		int len = arr.length;
		int sum[] = new int[len];
		sum[0] = arr[0];
		for (int i = 1; i < len; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}

		int pivotIndex = -1;
		int left = 0;
		int right = 0;
		for (int i = 0; i < len; i++) {
			left = sum[i] - arr[i];
			right = sum[len - 1] - sum[i];
			if (left == right) {
				pivotIndex = i;
				break;
			}
		}
		System.out.println(pivotIndex);
	}
}
