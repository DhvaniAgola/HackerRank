package com.leetcode.learningcards.string;

public class StrStr {

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issipi";
		if (needle.equals("")) {
			System.out.println("0");
		}
		if (needle.length() > haystack.length())
			System.out.println("-1");

		boolean found = false;
		L1:
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				L2:
				for (int k = i, j = 0; j < needle.length(); j++, k++) {
					if (haystack.charAt(k) == needle.charAt(j)) {
						if (j == needle.length() - 1) {
							found = true;
							System.out.println(i);
							break L1;
						}
					} else {
						j = 0;
						break L2;
					}
				}
			}
		}
		if (!found)
			System.out.println("-1");
	}
}
