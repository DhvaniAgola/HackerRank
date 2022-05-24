package com.leetcode.learningcards.binarysearch;

public class SquareRoot {
	public static void main(String[] args) {
		int x = 2147395599;

		if (x == 0) {
			System.out.println(0);
			return;
		}
		if (x == 1) {
			System.out.println(1);
			return;
		}
		System.out.println(sqrt(x, 0, x / 2));
	}

	static int sqrt(int x, int left, int right) {
		if (left == right)
			return left;
		int mid = (left + right) / 2;
		long midSq = ((long) mid * (long) mid);
		long midPlusOneSq = ((long) mid + 1) * ((long) mid + 1);
		if (midSq < x && midPlusOneSq <= x) {
			return sqrt(x, mid + 1, right);
		} else if (midSq <= x && midPlusOneSq > x) {
			return sqrt(x, left, mid);
		} else
			return sqrt(x, left, mid - 1);

	}
}
