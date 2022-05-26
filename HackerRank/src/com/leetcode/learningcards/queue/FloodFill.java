package com.leetcode.learningcards.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	public static void main(String[] args) {
		int[][] image = {{0, 0, 0}, {0, 1, 1}};
		int sr = 1;
		int sc = 1;
		int newColor = 1;

		int l = image.length;
		int w = image[0].length;
		int oldColor = image[sr][sc];
		if (oldColor == newColor) {
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(image[i][j] + ", ");
				}
				System.out.println();
			}
			return;
		}
		Queue<Integer> q = new LinkedList<>();

		q.add(sr * w + sc);

		while (!q.isEmpty()) {
			int cur = q.poll();
			int i = cur / w;
			int j = cur % w;

			image[i][j] = newColor;

			if (j + 1 < w && image[i][j + 1] == oldColor) {
				q.add(i * w + j + 1);
			}
			if (i + 1 < l && image[i + 1][j] == oldColor) {
				q.add((i + 1) * w + j);
			}
			if (j - 1 >= 0 && image[i][j - 1] == oldColor) {
				q.add(i * w + j - 1);
			}
			if (i - 1 >= 0 && image[i - 1][j] == oldColor) {
				q.add((i - 1) * w + j);
			}
		}

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(image[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
