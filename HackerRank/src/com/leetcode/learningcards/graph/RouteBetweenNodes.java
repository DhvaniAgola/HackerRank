package com.leetcode.learningcards.graph;

public class RouteBetweenNodes {
	static int minPath = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] edges = {
			{0, 1},
			{1, 2},
			{1, 3},
			{2, 3},
			{4, 5}
		};

		Graph g = new Graph(6);
		g.addEdge(edges);

		int s = 1;
		int e = 3;
		boolean[] visited = new boolean[6];
//		System.out.println(isRouteAvailable(g, s, e, visited));
		findMinPath(g, s, e, visited, 0);
		System.out.println(minPath);

	}

	static boolean isRouteAvailable(Graph g, int s, int e, boolean[] visited) {
		visited[s] = true;
		boolean found = false;
		if (s == e)
			return true;

		for (int i : g.ll[s]) {
			if (!visited[i]) {
				found = isRouteAvailable(g, i, e, visited);
				if (found)
					break;
			}
		}
		visited[s] = false;
		return found;
	}

	static void findMinPath(Graph g, int s, int e, boolean[] visited, int path) {
		visited[s] = true;
		if (s == e) {
			minPath = Math.min(minPath, path);
			visited[s] = false;
			return;
		}

		for (int i : g.ll[s]) {
			if (!visited[i]) {
				findMinPath(g, i, e, visited, path + 1);
			}
		}
		visited[s] = false;
	}
}
