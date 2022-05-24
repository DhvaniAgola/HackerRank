package com.leetcode.learningcards.string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower", "flower"};

		if (strs.length == 1) {
			System.out.println(strs[0].length());
		}
		int prefixLength = 0;
		L1:
		for (int i = 0; i < strs[0].length(); i++) {
			L2:
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length()) {
					prefixLength = i;
					break L1;
				}
				if (strs[j].charAt(i) != strs[0].charAt(i)) {
					prefixLength = i;
					break L1;
				}
			}
			if (i == strs[0].length() - 1)
				prefixLength = i + 1;
		}
		System.out.println(strs[0].substring(0, prefixLength));
	}
}
