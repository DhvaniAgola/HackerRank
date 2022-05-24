package com.leetcode.learningcards.string;

public class ReverseWordsInString3 {
	public static void main(String[] args) {
		String s = "  the sky is    blue  ";

		String word = "";
		String reverse = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				word = s.charAt(i) + word;
			} else {
				if (!word.equals("")) {
					reverse += word + " ";
					word = "";
				}
			}
		}
		if (!word.equals("")) {
			reverse += word;
		}
		System.out.println(reverse.trim());

	}
}
