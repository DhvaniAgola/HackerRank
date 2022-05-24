package com.leetcode.learningcards.BinarySearchTree;

public class ValidateBST {
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

	static boolean valid = true;

	public static void main(String[] args) {
		int[] nodes = {6, 4, 5, 3, 8, 7, 9};
		TreeNode root = new TreeNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}
		preTravesal(root);
		validateTree(root, null, null);
		System.out.println(valid);
	}

	static TreeNode addNode(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val > root.val) {
			root.left = addNode(root.left, val);
		}
		if (val < root.val) {
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

	static boolean validateTree(TreeNode root, Integer low, Integer high) {
		if (root == null)
			return true;
		if ((low != null && !(root.val > low)) || (high != null && !(root.val < high)))
			return false;

		return valid = validateTree(root.left, low, root.val) && validateTree(root.right, root.val, high);

	}
}
