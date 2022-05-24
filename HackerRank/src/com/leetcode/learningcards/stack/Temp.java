package com.leetcode.learningcards.stack;

import java.util.ArrayList;
import java.util.List;

public class Temp {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		lst.add(6);
		Integer a = lst.get(0);
		System.out.println(a);
		lst.set(0, 7);
		System.out.println(a);
	}
}
