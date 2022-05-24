package com.leetcode.learningcards.queue;

public class PerfectSquare {

	public static void main(String[] args) {
		int n = 13;

		int dp[] = new int[n + 1];
		int num[] = new int[n + 1];

		dp[0] = 0;
		num[0] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i] = (int) Math.pow((int) (Math.sqrt((double) i)), (double) 2);
			num[i] = 1;

			for (int j = 1; j <= Math.sqrt(i); j++) {

				if (i >= j * j) {
					int cal = dp[i - j * j] + j * j;

					if (dp[i] < cal) {
						dp[i] = cal;
						num[i] = num[i - j * j] + 1;
					} else if (dp[i] == cal) {
						num[i] = Math.min(num[i], num[i - j * j] + 1);
					}

				}
			}
		}
		System.out.println(num[n]);
	}
}
