package com.leetcode.learningcards.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> answer = new ArrayList<>();
		answer = getAnagrams(strs);
		for (int i = 0; i < answer.size(); i++) {
			List<String> l = new ArrayList<>();
			l = answer.get(i);
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j) + ", ");
			}
			System.out.println();
		}

	}

	static List<List<String>> getAnagrams(String[] strs) {
		List<List<String>> answers = new ArrayList<>();

		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String temp = new String(c);
			if (map.containsKey(temp)) {
				List<String> lst = map.get(temp);
				lst.add(strs[i]);
				map.put(temp, lst);
			} else {
				List<String> lst = new ArrayList<>();
				lst.add(strs[i]);
				map.put(temp, lst);
			}
		}
		for (List<String> l : map.values()) {
			answers.add(l);
		}
		return answers;
	}
}
