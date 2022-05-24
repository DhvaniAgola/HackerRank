package com.leetcode.learningcards.array;

public class FindTarget {
	static int minPath = Integer.MAX_VALUE;
	static boolean find = false;

	public static void main(String[] args) {
		int[][] arr = {
			{1, 1, 1},
			{9, 1, 0},
			{1, 1, 1},
			{0, 0, 0}};

//		System.out.println(findDestination(arr, 0, 0));
		findMinPath(arr, 0, 0, 0);
		findMinFaster(arr, 0, 0);
		System.out.println(find ? minPath : 0);
	}

	static boolean findDestination(int[][] arr, int i, int j) {
		if (arr[i][j] == 9) {
			return true;
		}
		boolean find = false;
		arr[i][j] = -1;
		if (j + 1 < arr[0].length && arr[i][j + 1] > 0 && !find)
			find = findDestination(arr, i, j + 1);
		if (i + 1 < arr.length && arr[i + 1][j] > 0 && !find)
			find = findDestination(arr, i + 1, j);
		if (j - 1 >= 0 && arr[i][j - 1] > 0 && !find)
			find = findDestination(arr, i, j - 1);
		if (i - 1 >= 0 && arr[i - 1][j] > 0 && !find)
			find = findDestination(arr, i - 1, j);
		return find;
	}

	static void findMinPath(int[][] arr, int i, int j, int path) {
		if (arr[i][j] == 9) {
			minPath = Math.min(minPath, path);
			find = true;
			return;
		}
		arr[i][j] = -1;
		if (j + 1 < arr[0].length && arr[i][j + 1] > 0)
			findMinPath(arr, i, j + 1, path + 1);
		if (i + 1 < arr.length && arr[i + 1][j] > 0)
			findMinPath(arr, i + 1, j, path + 1);
		if (j - 1 >= 0 && arr[i][j - 1] > 0)
			findMinPath(arr, i, j - 1, path + 1);
		if (i - 1 >= 0 && arr[i - 1][j] > 0)
			findMinPath(arr, i - 1, j, path + 1);
		arr[i][j] = 1;
	}

	static void findMinFaster(int[][] arr, int i, int j) {

	}
}

