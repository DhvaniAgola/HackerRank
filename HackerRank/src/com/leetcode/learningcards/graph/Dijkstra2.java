package com.leetcode.learningcards.graph;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra2 {

	public static void main(String[] args) {
		int[][] arr = {
			{1, 1, 0},
			{1, 1, 1},
			{9, 1, 0},
			{1, 1, 1}
		};
//		int l = arr.length;
//		int w = arr[0].length;
		int target = getTragetNode(arr);
		int[][] arrMat = convertArr(arr);
		for (int i = 0; i < arrMat.length; i++) {
			for (int j = 0; j < arrMat[0].length; j++) {
				System.out.print(arrMat[i][j] + ", ");
			}
			System.out.println();
		}

		System.out.println(dijkstra(arrMat, target));

	}

	static List<Integer> notVisited = new ArrayList<>();

	private static int dijkstra(int[][] arrMat, int target) {
		int[] dis = new int[arrMat.length];

		notVisited.add(0);
		for (int i = 1; i < dis.length; i++) {
			dis[i] = -1;
			notVisited.add(i);
		}

		int cur;
		while (!notVisited.isEmpty()) {
			cur = getMin(dis);
			if (cur == -1)
				break;

			for (int i = 1; i < arrMat[0].length; i++) {
				if (arrMat[cur][i] > 0) {


					if (dis[i] == -1 || dis[i] > (dis[cur] + arrMat[cur][i])) {
						dis[i] = (dis[cur] + arrMat[cur][i]);
					}
				}
			}
			notVisited.remove(Integer.valueOf(cur));
		}
		return dis[target];
	}

	private static int getMin(int[] dis) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != -1 && notVisited.contains(i) && min > dis[i]) {
				min = dis[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	static int[][] convertArr(int[][] arr) {
		int l = arr.length;
		int w = arr[0].length;
		int[][] ans = new int[l * w][l * w];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < w; j++) {
				int node = i * w + j;
				if (arr[i][j] > 0) {
					if ((j + 1) < w) {
						if (arr[i][j + 1] > 0) {
							ans[node][i * w + j + 1] = 1;
						} else {
							ans[node][i * w + j + 1] = -1;
						}
					}
					if ((i + 1) < l) {
						if (arr[i + 1][j] > 0) {
							ans[node][(i + 1) * w + j] = 1;
						} else {
							ans[node][(i + 1) * w + j] = -1;
						}
					}
					if ((j - 1) >= 0) {
						if (arr[i][j - 1] > 0) {
							ans[node][i * w + j - 1] = 1;
						} else {
							ans[node][i * w + j - 1] = -1;
						}
					}
					if ((i - 1) >= 0) {
						if (arr[i - 1][j] > 0) {
							ans[node][(i - 1) * w + j] = 1;
						} else {
							ans[node][(i - 1) * w + j] = -1;
						}
					}
				}
				for (int k = 0; k < l * w; k++) {
					if (k != node && ans[node][k] == 0)
						ans[node][k] = -1;
				}
			}
		}
		return ans;
	}

	static int getTragetNode(int[][] arr) {
		int target = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 9)
					return i * arr[0].length + j;
			}
		}
		return target;
	}


}
