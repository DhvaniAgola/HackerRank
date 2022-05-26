package com.DataStructure.string;

public class FlipStringToMonotoneIncreasing {
	public static void main(String[] args) {
		String s = "010110";

		int[] sum = new int[s.length() + 1];
		sum[0] = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0')
				sum[i + 1] = sum[i];
			else
				sum[i + 1] = 1 + sum[i];
		}

		int minFlips = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			int temp = sum[i] + s.length() - i - (sum[sum.length - 1] - sum[i]);
//			System.out.println(temp);
			if (temp < minFlips)
				minFlips = temp;
		}

		System.out.println(minFlips);
	}
}
