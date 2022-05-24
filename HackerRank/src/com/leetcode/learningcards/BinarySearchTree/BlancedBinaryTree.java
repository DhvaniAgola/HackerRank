package com.leetcode.learningcards.BinarySearchTree;

public class BlancedBinaryTree {
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
		int[] nodes = {6, 4, 5, 3, 8, 2};
		TreeNode root = new TreeNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}
		preTravesal(root);

		System.out.println(isBalancedTree(root));
	}

	static TreeNode addNode(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			root.left = addNode(root.left, val);
		}
		if (val > root.val) {
			root.right = addNode(root.right, val);
		}
		return root;
	}

	static void preTravesal(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preTravesal(root.left);
		preTravesal(root.right);
	}

	static boolean isBalancedTree(TreeNode root) {
		if (root == null)
			return true;
		int hl = height(root.left);
		int hr = height(root.right);
		return (Math.abs(hl - hr) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right));
	}

	static int height(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}
}
