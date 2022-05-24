package com.leetcode.learningcards.hashtable;

public class LongestSubStringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "pwwkew";

		System.out.println(getLength(s));
	}

	static int getLength(String s) {

		int[] count = new int[256];
		int i = 0;
		int j = 0;
		int maxLength = 0;
		while (j < s.length()) {
			count[s.charAt(j)]++;

			while (count[s.charAt(j)] > 1) {
				count[s.charAt(i)]--;
				i++;
			}
			if (maxLength < (j - i + 1))
				maxLength = j - i + 1;
			j++;
		}
		return maxLength;
	}
}
