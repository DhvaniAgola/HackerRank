package com.leetcode.learningcards.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
	public static void main(String[] args) {
		int[][] points = {{1, 3}, {-2, 2}};
		int k = 1;
		Queue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.dis - p2.dis);

		for (int i = 0; i < points.length; i++) {
			q.add(new Pair(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]));
		}

		for (int i = 0; i < k; i++) {
			Pair p = q.poll();
			System.out.println(points[p.index][0] + ": " + points[p.index][1]);
		}
	}
}

class Pair {
	int index;
	int dis;

	Pair(int index, int dis) {
		this.index = index;
		this.dis = dis;
	}
}