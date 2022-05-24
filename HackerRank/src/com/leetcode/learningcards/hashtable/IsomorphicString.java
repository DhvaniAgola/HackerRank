package com.leetcode.learningcards.hashtable;

import java.util.HashMap;

public class IsomorphicString {

	public static void main(String[] args) {
		String s = "paper";
		String t = "title";

		System.out.println(isIsomorphic(s, t));
	}

	static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> sTot = new HashMap<>();
		HashMap<Character, Character> tTos = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c_s;
			char c_t;
			if (!sTot.containsKey(s.charAt(i)) && !tTos.containsKey(t.charAt(i))) {
				sTot.put(s.charAt(i), t.charAt(i));
				tTos.put(t.charAt(i), s.charAt(i));
			} else if (!(sTot.containsKey(s.charAt(i)) && sTot.get(s.charAt(i)) == t.charAt(i) &&
				tTos.containsKey(t.charAt(i)) && tTos.get(t.charAt(i)) == s.charAt(i))) {

				return false;
			}

		}
		return true;
	}
}
