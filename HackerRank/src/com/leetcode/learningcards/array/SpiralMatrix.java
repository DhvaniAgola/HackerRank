package com.leetcode.learningcards.array;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

		int round = 0;
		int len_start = 0, wid_start = 0;
		int len_end = matrix.length - 1;
		int wid_end = matrix[0].length - 1;
		int i = 0, j = 0;
		while (true) {
			if (len_start <= len_end && wid_start <= wid_end) {
				if (round == 3) {
					for (; i >= len_start; i--) {
						System.out.println(matrix[i][j]);
					}
					wid_start++;
					i++;
					j++;
				} else if (round == 2) {
					for (; j >= wid_start; j--) {
						System.out.println(matrix[i][j]);
					}
					len_end--;
					j++;
					i--;
				} else if (round == 1) {
					for (; i <= len_end; i++) {
						System.out.println(matrix[i][j]);
					}
					wid_end--;
					i--;
					j--;
				} else {
					for (; j <= wid_end; j++) {
						System.out.println(matrix[i][j]);
					}
					len_start++;
					j--;
					i++;
				}
				round = (round + 1) % 4;
			} else {
				break;
			}
		}
	}
}
