package com.leetcode.learningcards.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwap {

	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		String s = "bcda";
		List<List<Integer>> pairs = new ArrayList<>();
		List<Integer> lst1 = new ArrayList<>();
		lst1.add(0);
		lst1.add(3);

		List<Integer> lst2 = new ArrayList<>();
		lst2.add(1);
		lst2.add(2);

		pairs.add(lst1);
		pairs.add(lst2);

		visited = new boolean[s.length()];
		adj = new ArrayList[s.length()];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new ArrayList<>();

		char[] answers = new char[s.length()];

		for (List<Integer> edge : pairs) {
			adj[edge.get(0)].add(edge.get(1));
			adj[edge.get(1)].add(edge.get(0));
		}

		for (int i = 0; i < s.length(); i++) {
			if (!visited[i]) {
				List<Character> chars = new ArrayList<>();
				List<Integer> indices = new ArrayList<>();

				DFS(s, i, chars, indices);

				Collections.sort(chars);
				Collections.sort(indices);

				for (int j = 0; j < indices.size(); j++) {
					answers[indices.get(j)] = chars.get(j);
				}
			}
		}

		System.out.println(String.valueOf(answers));
	}

	static void DFS(String s, int i, List<Character> chars, List<Integer> indices) {
		visited[i] = true;
		chars.add(s.charAt(i));
		indices.add(i);
		for (int adjecents : adj[i]) {
			if (!visited[adjecents]) {
				DFS(s, adjecents, chars, indices);
			}
		}
	}
}
