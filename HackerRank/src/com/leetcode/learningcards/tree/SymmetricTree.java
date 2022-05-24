package com.leetcode.learningcards.tree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
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
//		int[] nodes = {6, 4, 5, 10, 2, 1, 3, 8, 7, 9, 11, 15};
		int[] nodes = {5, 4, 3, 2, 1};
		TreeNode root = new TreeNode(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}
		System.out.println(isSymmetricTree(root));
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

	static List<Integer> leftRight = new ArrayList<>();
	static List<Integer> rightLeft = new ArrayList<>();

	static boolean isSymmetricTree(TreeNode root) {
		preorderTraverseLeftRight(root);
		preorderTraverseRightLeft(root);
		for (int i = 0; i < leftRight.size(); i++) {
			if (leftRight.get(i) != rightLeft.get(i))
				return false;
		}
		return true;
	}

	static void preorderTraverseLeftRight(TreeNode root) {
		if (root == null) {
			leftRight.add(null);
			return;
		}
		leftRight.add(root.val);
		preorderTraverseLeftRight(root.left);
		preorderTraverseLeftRight(root.right);

	}

	static void preorderTraverseRightLeft(TreeNode root) {
		if (root == null) {
			rightLeft.add(null);
			return;
		}
		rightLeft.add(root.val);
		preorderTraverseRightLeft(root.right);
		preorderTraverseRightLeft(root.left);
	}
}
