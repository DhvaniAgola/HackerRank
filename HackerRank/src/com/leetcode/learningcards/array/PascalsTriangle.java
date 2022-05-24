package com.leetcode.learningcards.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		int numRows = 5;

		List<List<Integer>> answer = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> lst = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					lst.add(1);
				} else if (j == i) {
					lst.add(1);
				} else {
					lst.add(answer.get(answer.size() - 1).get(j - 1) + answer.get(answer.size() - 1).get(j));
				}
			}
			answer.add(lst);
		}

		for (int i = 0; i < answer.size(); i++) {

			for (int j = 0; j < answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j));
			}
			System.out.println();
		}
	}
}
