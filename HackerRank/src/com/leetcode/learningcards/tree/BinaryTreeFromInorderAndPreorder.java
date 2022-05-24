package com.leetcode.learningcards.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPreorder {
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

		int[] inorder = {9, 3, 15, 20, 7};
		int[] preorder = {3, 9, 20, 15, 7};

		TreeNode root = null;
		root = generateBinaryTree(root, inorder, preorder, 0, preorder.length - 1, 0, inorder.length - 1);
		levelorderTraversal(root);
	}

	static TreeNode generateBinaryTree(TreeNode root, int[] inorder, int[] preorder, int start_pre, int end_pre, int start_in, int end_in) {
		if (start_pre <= end_pre) {
			root = new TreeNode(preorder[start_pre]);
			int index_in = findIndexInInorder(inorder, preorder[start_pre]);
			int index_pre = start_pre;
			int x = end_in - index_in;

			int left_start_inorder = start_in;
			int left_end_inorder = index_in - 1;
			int right_start_inorder = index_in + 1;
			int right_end_inorder = end_in;

			int right_start = end_pre - x + 1;
			int right_end = end_pre;
			int left_start = index_pre + 1;
			int left_end = end_pre - x;
			root.left = generateBinaryTree(root.left, inorder, preorder, left_start, left_end, left_start_inorder, left_end_inorder);
			root.right = generateBinaryTree(root.right, inorder, preorder, right_start, right_end, right_start_inorder, right_end_inorder);
		}
		return root;
	}

	static int findIndexInInorder(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val) {
				return i;
			}
		}
		return -1;
	}

	static void levelorderTraversal(TreeNode root) {
		List<TreeNode> lst = new ArrayList<>();

		lst.add(root);
//		System.out.println(root.val);
		int i = 0;
		while (i < lst.size()) {
			if (lst.get(i) != null) {
				if (lst.get(i).left != null)
					lst.add(lst.get(i).left);
				else
					lst.add(null);

				if (lst.get(i).right != null)
					lst.add(lst.get(i).right);
				else
					lst.add(null);
			}
			i++;
		}

		for (i = lst.size() - 1; i >= 0; i--) {
			if (lst.get(i) == null)
				lst.remove(lst.size() - 1);
			else
				break;
		}
		System.out.println();
		for (i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i) != null ? lst.get(i).val + ", " : "null" + ", ");
		}
	}

}
