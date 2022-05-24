package com.leetcode.learningcards.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPostorder {
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
		int[] postorder = {9, 15, 7, 20, 3};

		TreeNode root = null;
		root = generateBinaryTree(root, inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
		levelorderTraversal(root);
	}

	static TreeNode generateBinaryTree(TreeNode root, int[] inorder, int[] postorder, int start_post, int end_post, int start_in, int end_in) {
		if (start_post <= end_post) {
			root = new TreeNode(postorder[end_post]);
			int index_in = findIndexInInorder(inorder, postorder[end_post]);
			int index_post = end_post;
			int x = end_in - index_in;

			int left_start_inorder = start_in;
			int left_end_inorder = index_in - 1;
			int right_start_inorder = index_in + 1;
			int right_end_inorder = end_in;

			int right_start = index_post - x;
			int right_end = index_post - 1;
			int left_start = start_post;
			int left_end = index_post - x - 1;
			root.left = generateBinaryTree(root.left, inorder, postorder, left_start, left_end, left_start_inorder, left_end_inorder);
			root.right = generateBinaryTree(root.right, inorder, postorder, right_start, right_end, right_start_inorder, right_end_inorder);
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
