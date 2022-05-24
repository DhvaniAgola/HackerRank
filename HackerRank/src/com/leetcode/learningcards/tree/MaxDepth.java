package com.leetcode.learningcards.tree;

public class MaxDepth {
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
		TreeNode root = new TreeNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}
		treeDepth(root);
		System.out.println(depth);
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

	static int depth = 0;

	static void treeDepth(TreeNode root) {
		int count = 0;
		traverseForDepth(root, count);
	}

	static void traverseForDepth(TreeNode root, int count) {
		if (root == null) {
			return;
		}
		System.out.println(root.val + " : " + (++count));
		if (root.left == null && root.right == null)
			depth = Math.max(depth, count);

		traverseForDepth(root.left, count);
		traverseForDepth(root.right, count);
	}
}
