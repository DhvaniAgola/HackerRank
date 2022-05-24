package com.leetcode.learningcards.graph;

import java.util.LinkedList;

public class Graph {
	LinkedList<Integer> ll[];

	Graph(int n) {
		ll = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			ll[i] = new LinkedList<>();
		}
	}

	void addEdgeDirected(int a, int b) {
		ll[a].add(b);
	}

	void addEdgeDirected(int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			ll[arr[i][0]].add(arr[i][1]);
	}

	void addEdge(int a, int b) {
		ll[a].add(b);
		ll[b].add(a);
	}

	void addEdge(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			ll[arr[i][0]].add(arr[i][1]);
			ll[arr[i][1]].add(arr[i][0]);
		}
	}
}
