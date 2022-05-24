package com.leetcode.learningcards.graph;

import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgorithm {
	static List<Integer> nonVisited = new ArrayList<>();

	public static void main(String[] args) {
		int[][] arr = {
			{1, 0, 9},
			{1, 1, 1},
			{0, 0, 0},
			{1, 1, 1}
		};

		int target_i = 0;
		int target_j = 0;

		int l = arr.length;
		int w = arr[0].length;

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 9) {
					target_i = i;
					target_j = j;
				}
				nonVisited.add(i * w + j);
			}
		}

		int[] mat = new int[l * w];

		mat[0] = 0;
		for (int i = 1; i < mat.length; i++) {
			mat[i] = -1;
		}
		int i = 0;
		int j = 0;

		int node;
		while (!nonVisited.isEmpty()) {

			int min = findMin(mat);
			if (min == -1) {
				break;
			}
			i = min / w;
			j = min % w;
			node = i * w + j;
			int node2;
			if (j + 1 < w && arr[i][j + 1] > 0) {
				node2 = i * w + j + 1;
				mat[node2] = mat[node2] == -1 ? (mat[node] + 1) : Math.min(mat[node] + 1, mat[node2]);
			}
			if (i + 1 < l && arr[i + 1][j] > 0) {
				node2 = (i + 1) * w + j;
				mat[node2] = mat[node2] == -1 ? (mat[node] + 1) : Math.min(mat[node] + 1, mat[node2]);
			}
			if (j - 1 >= 0 && arr[i][j - 1] > 0) {
				node2 = i * w + j - 1;
				mat[node2] = mat[node2] == -1 ? (mat[node] + 1) : Math.min(mat[node] + 1, mat[node2]);
			}
			if (i - 1 >= 0 && arr[i - 1][j] > 0) {
				node2 = (i - 1) * w + j;
				mat[node2] = mat[node2] == -1 ? (mat[node] + 1) : Math.min(mat[node] + 1, mat[node2]);
			}
			nonVisited.remove(Integer.valueOf(node));

		}

		System.out.println(mat[target_i * w + target_j]);
	}

	static int findMin(int[] mat) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i : nonVisited) {
			if (mat[i] >= 0 && mat[i] < min) {
				min = mat[i];
				minIndex = i;
			}

		}
		return minIndex;
	}
}
