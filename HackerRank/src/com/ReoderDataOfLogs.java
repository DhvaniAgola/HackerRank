package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReoderDataOfLogs {

	public static void main(String[] args) {
//		String[] arr = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
		String[] arr = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"};
		List<String> let = new ArrayList<>();

		List<String> dig = new ArrayList<>();

		List<Character> nums = new ArrayList<>();
		nums.add('0');
		nums.add('1');
		nums.add('2');
		nums.add('3');
		nums.add('4');
		nums.add('5');
		nums.add('6');
		nums.add('7');
		nums.add('8');
		nums.add('9');
		for (int i = 0; i < arr.length; i++) {
			if (nums.contains(arr[i].split(" ")[1].charAt(0)))
				dig.add(arr[i]);
			else
				let.add(arr[i]);
		}

		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num = o1.split(" ", 2)[1].compareTo(o2.split(" ", 2)[1]);
				if (num == 0) {
					return o1.split(" ", 2)[0].compareTo(o2.split(" ", 2)[0]);
				} else
					return num;
			}
		};

		Collections.sort(let, comp);

		String[] ans = new String[arr.length];

		for (int i = 0; i < let.size(); i++) {
			ans[i] = let.get(i);
		}

		for (int i = let.size(), j = 0; j < dig.size(); j++, i++) {
			ans[i] = dig.get(j);
		}

		for (String a : ans) {
			System.out.println(a);
		}
//		Queue<Integer> q = new PriorityQueue<>((n1, n2) -> n2 - n1);
//		q.add(3);
//		q.add(7);
//		q.add(2);
//		q.add(1);
//		System.out.println(q);
//		System.out.println(let);
//		System.out.println("===");
//		while (!q.isEmpty()) {
//			System.out.println(q.poll());
//		}
	}
}
