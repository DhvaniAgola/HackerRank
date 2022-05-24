package com.leetcode.learningcards.BinarySearchTree;

public class LowestCommonAncestorBST {
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
		int[] nodes = {6, 4, 5, 3, 8, 7, 9};
		TreeNode root = new TreeNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}
		preTravesal(root);
		int p = 9;
		int q = 8;
		TreeNode node = lowestCommonAncestor(root, Math.min(p, q), Math.max(p, q));
		System.out.println(node.val);
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

	static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
		if (root == null || (p <= root.val && q > root.val) || (p < root.val && q >= root.val))
			return root;
		if (p < root.val && q < root.val)
			return lowestCommonAncestor(root.left, p, q);
		return lowestCommonAncestor(root.right, p, q);
	}
}
