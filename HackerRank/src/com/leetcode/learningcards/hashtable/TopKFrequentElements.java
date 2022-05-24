package com.leetcode.learningcards.hashtable;

import java.util.TreeMap;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int nums[] = {1, 1, 1, 2, 2, 3};
		int k = 2;
	}

	static int[] findElements(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();

		int count = 1;
//		map.put(count,nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
			} else {
				if (map.size() < k) {
					map.put(count, nums[i - 1]);
				} else if (map.size() == k) {
//					if (map.ge
				}
			}
		}
		return null;
	}
}
