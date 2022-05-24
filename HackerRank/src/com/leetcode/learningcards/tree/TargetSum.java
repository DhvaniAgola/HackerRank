package com.leetcode.learningcards.tree;

public class TargetSum {
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		int[] nodes = {6, 4, 5, 10, 2, 1, 3, 8, 7, 9, 11, 15};
//		int[] nodes = {5, 4, 3, 2, 1};
		TreeNode root = new TreeNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}
		traverseForSum(root, 0);
		System.out.println(isPath);
	}

	static TreeNode addNode(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			root.left = addNode(root.left, val);
		} else {
			root.right = addNode(root.right, val);
		}
		return root;
	}

	static int targetSum = 13;
	static boolean isPath = false;

	static void traverseForSum(TreeNode root, int sum) {
		if (root == null)
			return;
		sum += root.val;
		System.out.println(root.val + " : " + sum);
		if (root.left == null && root.right == null && sum == targetSum)
			isPath = true;
		traverseForSum(root.left, sum);
		traverseForSum(root.right, sum);
	}
}
