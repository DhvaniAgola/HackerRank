package com.leetcode.learningcards.string;

public class ReverseWordsInString {
	public static void main(String[] args) {
		String s = "the sky is blue";

//		method1(s);
		method2_noExtraSpace(s);
	}

	static void method1(String s) {
		s = s.trim();
		String reverse = "";
		String word = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				word = s.charAt(i) + word;
			} else {
				reverse = reverse.trim() + ' ' + word;
				word = "";
			}
		}
		reverse = reverse.trim();
		if (reverse.equals("")) {
			reverse = word;
		} else
			reverse += ' ' + word;
		System.out.println(reverse);
	}

	//TODO
	static void method2_noExtraSpace(String s) {
//		s = s.trim();
//		int len = s.length();
//		String word = "";
//		int i;
//		for (i = 1; i <= len; i++) {
//			if (s.charAt(s.length() - i) != ' ') {
//				word = s.charAt(s.length() - i) + word;
//			} else {
//				if (!word.equals("")) {
//					s = word + " " + s;
//					word = "";
//				}
//			}
//		}
//		s = s.substring(0, s.length() - i);
//		System.out.println(s);

	}
}
