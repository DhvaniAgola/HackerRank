package com.leetcode.learningcards.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KeysAndRooms {

	public static void main(String[] args) {
		int[][] rooms = {{1}, {2}, {3}, {0}};

		Set<Integer> notvisited = new HashSet<>();

		for (int i = 0; i < rooms.length; i++) {
			int[] temp = rooms[i];
			for (int j = 0; j < temp.length; j++) {
				notvisited.add(rooms[i][j]);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < rooms[0].length; i++)
			q.add(rooms[0][i]);
		notvisited.remove(Integer.valueOf(0));
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (notvisited.contains(curr)) {
				for (int i = 0; i < rooms[curr].length; i++) {
					q.add(rooms[curr][i]);
				}
				notvisited.remove(Integer.valueOf(curr));
			}
		}
		System.out.println(notvisited.size() == 0);
	}
}
