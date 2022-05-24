package com.leetcode.learningcards.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KruskalMST {

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

	static HashMap<Integer, Integer> parent = new HashMap<>();

	public static void main(String[] args) {
		int[][] edges = {
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
		Edge[] edge = new Edge[edges.length];
		for (int i = 0; i < edges.length; i++) {
			edge[i] = new Edge(edges[i][0], edges[i][1], edges[i][2]);
		}

		Arrays.sort(edge);

		kruskal(edge, nodes);

	}

	static List<Edge> mst = new ArrayList<>();

	static void kruskal(Edge[] edge, int nodes) {

		int i = 0;
		while (mst.size() < nodes - 1) {
			Edge minEdge = edge[i];

			if (!samePatents(minEdge.s, minEdge.d)) {
				union(edge[i]);
			}
			i++;
		}

		printMST();
	}

	static boolean samePatents(int s, int d) {
		if (parent.containsKey(s) && parent.containsKey(d)) {
			if (parent.get(s) == parent.get(d))
				return true;
			else {
				int destParent = parent.get(d);
				int sourceParent = parent.get(s);
				for (int key : parent.keySet()) {
					if (parent.get(key) == destParent) {
						parent.put(key, sourceParent);
					}
				}
				return false;
			}
		} else if (parent.containsKey(s) || parent.containsKey(d)) {
			if (parent.containsKey(s)) {
				parent.put(d, parent.get(s));
			} else if (parent.containsKey(d)) {
				parent.put(s, parent.get(d));
			}
			return false;
		} else {
			parent.put(s, s);
			parent.put(d, s);
			return false;
		}
	}

	static void union(Edge edge) {
		mst.add(edge);
	}

	static void printMST() {
		for (Edge e : mst) {
			System.out.println(e.s + " : " + e.d);
		}
	}
}
