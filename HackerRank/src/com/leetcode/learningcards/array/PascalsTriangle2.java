package com.leetcode.learningcards.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
	public static void main(String[] args) {
		int rowIndex = 7;

		List<Integer> lst = new ArrayList<>();

		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i; j >= 0; j--) {
				if (j == i) {
					lst.add(1);
				} else if (j > 0) {
					lst.set(j, lst.get(j - 1) + lst.get(j));
				}
			}
		}
		System.out.println(lst);
	}
}
