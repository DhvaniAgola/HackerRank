package com.leetcode.learningcards.BinarySearchTree;

public class SortedArrayToBST {

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
		int[] nodes = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = generateTree(nodes, 0, nodes.length - 1);


//		System.out.println(isBalancedTree(root));
		preTravesal(root);
	}


	static void preTravesal(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preTravesal(root.left);
		preTravesal(root.right);
	}

	static TreeNode generateTree(int[] nodes, int left, int right) {

		if (left > right)
			return null;

		TreeNode node = new TreeNode(nodes[(right + left + 1) / 2]);

		node.left = generateTree(nodes, left, ((right + left + 1) / 2) - 1);
		node.right = generateTree(nodes, ((right + left + 1) / 2) + 1, right);

		return node;
	}
}
