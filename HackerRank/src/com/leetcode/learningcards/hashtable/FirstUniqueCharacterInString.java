package com.leetcode.learningcards.hashtable;

import java.util.HashMap;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		String s = "leetcode";

		System.out.println(getIndex(s));
	}

	static int getIndex(String s) {
		HashMap<Character, Integer> indexmap = new HashMap<>();

		HashMap<Character, Integer> countmap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (!indexmap.containsKey(s.charAt(i))) {
				indexmap.put(s.charAt(i), i);
			}
			if (countmap.containsKey(s.charAt(i))) {
				countmap.put(s.charAt(i), countmap.get(s.charAt(i)) + 1);
			} else {
				countmap.put(s.charAt(i), 1);
			}
		}

		int mincount = s.length();
		int minindex = s.length() - 1;
		for (char c : countmap.keySet()) {
			if (countmap.get(c) == 1 && indexmap.get(c) <= minindex) {
				mincount = 1;
				minindex = indexmap.get(c);
			}
		}
		if (mincount == 1)
			return minindex;
		return -1;
	}
}
