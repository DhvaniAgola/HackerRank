package com.leetcode.learningcards.string;

public class AddBinary {
	public static void main(String[] args) {
		String a = "1011";
		String b = "1010";
		int a_len = a.length();
		int b_len = b.length();

		if (a_len != b_len) {
			if (a_len < b_len) {
				String temp = a;
				a = "";
				for (int i = 0; i < (b_len - a_len); i++) {
					a += "0";
				}
				for (int i = 0; i < temp.length(); i++) {
					a += temp.charAt(i);
				}
			}
			if (a_len > b_len) {
				String temp = b;
				b = "";
				for (int i = 0; i < (-b_len + a_len); i++) {
					b += "0";
				}
				for (int i = 0; i < temp.length(); i++) {
					b += temp.charAt(i);
				}
			}
		}

		String carry = "0";
		String addedString = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			String add = "00";
//			if (a.charAt(i) == '0' && b.charAt(i) == '0') {
//				add = "00";
//			}
			if ((a.charAt(i) == '0' && b.charAt(i) == '1') || (a.charAt(i) == '1' && b.charAt(i) == '0')) {
				add = "01";
			}
			if (a.charAt(i) == '1' && b.charAt(i) == '1') {
				add = "10";
			}
			String finalAddition = addCarry(add, carry);
			addedString = finalAddition.charAt(1) + addedString;
			carry = String.valueOf(finalAddition.charAt(0));
		}
		if (carry.equals("1"))
			addedString = carry + addedString;
		System.out.println(addedString);
	}

	static String addCarry(String add, String carry) {
		String finalAddition;
		if (carry.equals("0")) {
			return add;
		} else {
			if (add.equals("00"))
				finalAddition = "01";
			else if (add.equals("01"))
				finalAddition = "10";
			else
				finalAddition = "11";
		}
		return finalAddition;
	}
}
