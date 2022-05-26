package com.DataStructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {


	public static void main(String[] args) {
		int[] arr = {4, 2, 2, 8, 5, 5, 5, 8, 3};

		int k = 3;
		Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

		for (int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}
		int prev;
		prev = heap.poll();
		k--;
		while (!heap.isEmpty()) {
			if (heap.peek() != prev) {
				prev = heap.poll();
				k--;
				if (k == 0)
					break;
			} else
				heap.poll();
		}
		System.out.println(prev);

	}
}
