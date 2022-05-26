package com.leetcode.learningcards.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KruskalMST2 {

	static class Edge implements Comparable<Edge> {
		int s;
		int d;
		int w;

		Edge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) {
		int[][] input = {
			{0, 1, 4},
			{0, 7, 8},
			{1, 7, 11},
			{1, 2, 8},
			{2, 3, 7},
			{2, 5, 4},
			{2, 8, 2},
			{7, 8, 7},
			{6, 8, 6},
			{6, 7, 1},
			{5, 6, 2},
			{3, 4, 9},
			{4, 5, 10},
			{3, 5, 14}
		};

		int nodes = 9;

		Edge[] edges = new Edge[input.length];

		for (int i = 0; i < input.length; i++) {
			edges[i] = new Edge(input[i][0], input[i][1], input[i][2]);
		}

		Arrays.sort(edges);

		List<Edge> mst = new ArrayList<>();

		int i = 0;
		while (mst.size() < nodes - 1) {
			if (!sameParent(edges[i])) {
				mst.add(edges[i]);
			}
			i++;
		}

		for (Edge e : mst)
			System.out.println(e.s + ", " + e.d + ", " + e.w);
	}

	static HashMap<Integer, Integer> parent = new HashMap<>();

	private static boolean sameParent(Edge edge) {
		if (parent.containsKey(edge.s) && parent.containsKey(edge.d)) {
			if (parent.get(edge.s) == parent.get(edge.d)) {
				return true;
			} else {
				int s_parent = parent.get(edge.s);
				int d_parent = parent.get(edge.d);
				for (int k : parent.keySet()) {
					if (parent.get(k) == d_parent)
						parent.put(k, s_parent);
				}
				return false;
			}
		} else if (parent.containsKey(edge.s)) {
			parent.put(edge.d, parent.get(edge.s));
			return false;
		} else if (parent.containsKey(edge.d)) {
			parent.put(edge.s, parent.get(edge.d));
			return false;
		} else {
			parent.put(edge.s, edge.s);
			parent.put(edge.d, edge.s);
			return false;
		}
	}

}
