package com.leetcode.learningcards.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
	public static void main(String[] args) {

		int digits[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int carry = 0;
		int inc;
		List<Integer> lst = Arrays.stream(digits).boxed().collect(Collectors.toList());
		for (int i = lst.size() - 1; i >= 0; i--) {
			if (i == lst.size() - 1) {
				inc = lst.get(i) + 1;


			} else {
				inc = carry + lst.get(i);
			}
			if (inc > 9) {
				lst.set(i, inc % 10);
				carry = inc / 10;
			} else {
				lst.set(i, inc);
				carry = 0;
			}
		}
		if (carry != 0) {
			lst.add(0, carry);
		}
		int arrAnswer[] = lst.stream()
			.mapToInt(Integer::intValue)
			.toArray();

		for (int i = 0; i < arrAnswer.length; i++)
			System.out.println(arrAnswer[i]);
	}
}
