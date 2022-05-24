package com.leetcode.learningcards.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

	static int parent[];
	static List<Integer> visited;

	public static void main(String[] args) {
//		int[][] isConnected = {
//			{1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//			{1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//			{0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//			{0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
//			{0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
//			{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
//			{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
//			{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
//			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
//		};
//		int[][] isConnected = {
//			{1, 0, 0, 1},
//			{0, 1, 1, 0},
//			{0, 1, 1, 1},
//			{1, 0, 1, 1}
//		};
		int[][] isConnected = {
			{1, 1, 0},
			{1, 1, 0},
			{0, 0, 1},
		};


		parent = new int[isConnected.length];
		visited = new ArrayList<>();
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			visited.add(i);
		}

		int provinces = 0;
		while (!visited.isEmpty()) {
			provinces++;
			traverseGraph(isConnected, visited.get(0), visited.get(0));
		}

//		for (int i = 0; i < parent.length; i++) {
//			if (parent[i] == i)
//				provinces++;
//		}

		System.out.println(provinces);
	}

	static void traverseGraph(int[][] isConnected, int node, int parent) {
		visited.remove(Integer.valueOf(node));
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[node][j] == 1 && visited.contains(j)) {
				traverseGraph(isConnected, j, node);
			}
		}
	}
}
