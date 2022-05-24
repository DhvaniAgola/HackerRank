package com.leetcode.learningcards.hashtable;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {

	public static void main(String[] args) {
//		char[][] board = {
//			{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//		};
		char[][] board = {
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
			, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
			, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
			, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
			, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
			, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
			, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
			, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
			, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		System.out.println(validateSudoku(board));
	}

	static boolean validateSudoku(char[][] board) {
		List<Character>[] rows = new ArrayList[9];
		List<Character>[] cols = new ArrayList[9];
		List<Character>[] boxes = new ArrayList[9];

		for (int i = 0; i < 9; i++) {
			rows[i] = new ArrayList<>();
			cols[i] = new ArrayList<>();
			boxes[i] = new ArrayList<>();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (rows[i].contains(board[i][j]))
						return false;
					else {
						rows[i].add(board[i][j]);
					}

					if (cols[j].contains(board[i][j]))
						return false;
					else {
						cols[j].add(board[i][j]);
					}

					int boxNo = ((i / 3) * 3) + (j / 3);
					if (boxes[boxNo].contains(board[i][j]))
						return false;
					else {
						boxes[boxNo].add(board[i][j]);
					}
				}
			}
		}
		return true;
	}
}
