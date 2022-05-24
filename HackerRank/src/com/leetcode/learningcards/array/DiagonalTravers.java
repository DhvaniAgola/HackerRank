package com.leetcode.learningcards.array;

public class DiagonalTravers {
	public static void main(String[] args) {
		int[][] arr = {{00, 01, 02, 03}, {10, 11, 12, 13}, {20, 21, 22, 23}};

		int row = arr.length;
		int col = arr[0].length;
		for (int i = 0, j = 0, k = 0; k < (row + col - 1); k++) {
			while (true) {
				System.out.println(arr[i][j]);

				if (k % 2 == 0 && i - 1 >= 0 && j + 1 < col) {
					i--;
					j++;
				} else if (k % 2 != 0 && i + 1 < row && j - 1 >= 0) {
					i++;
					j--;
				} else {
					break;
				}
			}

			if (k % 2 == 0 && j < col - 1) {
				j++;
			} else if (k % 2 == 0 && j == col - 1) {
				i++;
			} else if (k % 2 != 0 && i < row - 1) {
				i++;
			} else if (k % 2 != 0 && i == row - 1) {
				j++;
			}
		}
	}
}
