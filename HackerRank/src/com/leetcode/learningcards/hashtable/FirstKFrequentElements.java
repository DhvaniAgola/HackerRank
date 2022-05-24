package com.leetcode.learningcards.hashtable;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {5, 5, 5, 3, 3, 3, 3, 8, 8, 11};
		int k = 3;

		HashMap<Integer, Integer> count = new HashMap();

		for (int i : nums) {
			count.put(i, count.getOrDefault(i, 0) + 1);
		}

		Queue<Integer> q = new PriorityQueue<>(
			(n1, n2) -> count.get(n1) - count.get(n2));

		for (int key : count.keySet()) {
			q.add(key);
			if (q.size() > k)
				q.poll();
		}

		int[] ans = new int[q.size()];
		for (int i = k - 1; i >= 0; i--) {
			ans[i] = q.poll();
			System.out.println(ans[i]);
		}

	}
}
