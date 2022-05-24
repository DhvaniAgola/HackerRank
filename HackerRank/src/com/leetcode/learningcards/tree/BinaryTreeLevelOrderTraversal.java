package com.leetcode.learningcards.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	static class Node {
		Node left;
		Node right;
		int val;

		Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
//		int[] nodes = {6, 4, 5, 10, 2, 1, 3, 8, 7, 9, 11, 15};
		int[] nodes = {5, 4, 3, 2, 1};
		Node root = new Node(nodes[0]);
		for (int i = 1; i < nodes.length; i++) {
			root = addNode(root, nodes[i]);
		}

		preOrderTraversal(root);

		levelOrderTraversal(root);
	}

	static Node addNode(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		if (val < root.val) {
			root.left = addNode(root.left, val);
		} else {
			root.right = addNode(root.right, val);
		}
		return root;
	}

	static void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	static void levelOrderTraversal(Node root) {

		List<List<Integer>> levelOrder = new ArrayList<>();
		if (root != null) {
			List<Node> lst = new ArrayList<>();
			List<Integer> level = new ArrayList<>();

			lst.add(root);
			level.add(root.val);
			levelOrder.add(level);
			List<Node> lstTemp = new ArrayList<>();
			while (true) {
				List<Integer> lvl = new ArrayList<>();
				for (int i = 0; i < lst.size(); i++) {
					if (lst.get(i) != null) {
						if (lst.get(i).left != null) {
							lstTemp.add(lst.get(i).left);
							lvl.add(lst.get(i).left.val);
						}
						if (lst.get(i).right != null) {
							lstTemp.add(lst.get(i).right);
							lvl.add(lst.get(i).right.val);
						}
					}
				}
				if (lvl.size() == 0)
					break;
				lst.clear();
				lst.addAll(lstTemp);
				lstTemp.clear();
				levelOrder.add(lvl);
			}

			System.out.println(levelOrder);
		}
	}
}
