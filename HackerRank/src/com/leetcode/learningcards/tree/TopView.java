package com.leetcode.learningcards.tree;

public class TopView {
	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		int[] nodes = {1, 2};
		Node root = new Node(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = insertNode(root, nodes[i]);
		}

		preorder(root);

		topView(root);
		System.out.println(topView);
	}

	static String topView = "";
	static int maxWidth = 0;

	private static void topView(Node root) {

		leftTopView(root.left, true, 1);
		topView += root.val + ", ";
		maxWidth = 0;
		rightTopView(root.right, true, 1);
	}

	private static void rightTopView(Node root, boolean isRightNode, int width) {
		if (root == null)
			return;
		if (isRightNode && width > maxWidth) {
			topView += root.val + ", ";
			maxWidth = width;
		}
		rightTopView(root.left, false, width - 1);
		rightTopView(root.right, true, width + 1);

	}

	private static void leftTopView(Node root, boolean isLeftNode, int width) {
		if (root == null)
			return;
		if (isLeftNode && width > maxWidth) {
			topView = root.val + ", " + topView;
			maxWidth = width;
		}
		leftTopView(root.left, true, width + 1);
		leftTopView(root.right, false, width - 1);

	}

	static Node insertNode(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		if (val < root.val)
			root.left = insertNode(root.left, val);
		else
			root.right = insertNode(root.right, val);
		return root;
	}

	static void preorder(Node root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
}
