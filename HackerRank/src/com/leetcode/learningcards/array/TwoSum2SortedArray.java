package com.leetcode.learningcards.array;

public class TwoSum2SortedArray {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 2, 3, 4};
		int target = 5;

		int i = 0, j = numbers.length - 1;
		int sum = numbers[i] + numbers[j];
		int[] indexes = new int[2];
		while (i < j) {
			if (sum == target) {
				indexes[0] = i;
				indexes[1] = j;
				break;
			}
			if (sum < target) {
				sum -= numbers[i];
				i++;
				sum += numbers[i];
			} else if (sum > target) {
				sum -= numbers[j];
				j--;
				sum += numbers[j];
			}
		}
		System.out.println(indexes[0] + " : " + indexes[1]);
	}
}
