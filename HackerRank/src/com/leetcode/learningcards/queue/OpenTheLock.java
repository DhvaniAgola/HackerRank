package com.leetcode.learningcards.queue;

import java.util.*;

public class OpenTheLock {

	public static void main(String[] args) {
//		String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
//		String target = "8888";

//		String[] deadends = {"8888"};
//		String target = "0009";

		String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
		String target = "0202";

		System.out.println(findNumberOfMoves(deadends, target));
	}

	static int findNumberOfMoves(String[] deadends, String target) {
		List<String> dead_ends = new ArrayList<>(Arrays.asList(deadends));
		List<String> visited = new ArrayList<>();

		Queue<String> queue = new LinkedList<>();

		queue.add("0000");
		visited.add("0000");

		int i = 0;
		int level = 0;
		while (!queue.isEmpty()) {
			int current_size = queue.size();
			while (current_size > 0) {
				String current_pass = queue.poll();

				if (current_pass.equals(target)) {
					return level;
				}

				if (dead_ends.contains(current_pass)) {
					current_size--;
					continue;
				}


				for (i = 0; i < 4; i++) {
					String s1 = current_pass.substring(0, i) + (current_pass.charAt(i) == '9' ? '0' : (char) (current_pass.charAt(i) + 1)) + current_pass.substring(i + 1, 4);
					String s2 = current_pass.substring(0, i) + (current_pass.charAt(i) == '0' ? '9' : (char) (current_pass.charAt(i) - 1)) + current_pass.substring(i + 1, 4);

					if (!visited.contains(s1) && !dead_ends.contains(s1)) {
						queue.add(s1);
						visited.add(current_pass);
					}
					if (!visited.contains(s2) && !dead_ends.contains(s2)) {
						queue.add(s2);
						visited.add(current_pass);
					}
				}
				current_size--;
			}
			level++;
		}
		return -1;
	}
}
