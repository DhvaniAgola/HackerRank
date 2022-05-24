package com.leetcode.learningcards.linkedlist;

import java.util.Stack;

public class PalindromLinkedList {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtTail(1);
//		list.addAtTail(2);
//		list.addAtTail(3);
////		list.addAtTail(4);
////		list.addAtTail(5);
////		list.addAtTail(5);
//		list.addAtTail(1);
////		list.addAtTail(4);
//		list.addAtTail(3);
//		list.addAtTail(2);
		list.addAtTail(1);

		if (list.head.next == null) {
			System.out.println(true);
			return;
		}
		Stack<Integer> stc = new Stack<>();
		System.out.println(isPalindrom(list.head, list.head.next, stc));
	}

	static boolean isPalindrom(Node h1, Node h2, Stack<Integer> stc) {
		if (h2 == null) {
			if (stc.isEmpty() && h1 == null)
				return true;
			else if (stc.peek() == h1.val) {
				stc.pop();
//				return true;
				return isPalindrom(h1.next, h2, stc);
			} else
				return false;
		} else {
			stc.push(h1.val);
			if (h2.next == null) {
				h2 = null;
				h1 = h1.next;
			} else if (h2.next.next == null) {
				h2 = h2.next.next;
				h1 = h1.next.next;
			} else {
				h2 = h2.next.next;
				h1 = h1.next;
			}
			return isPalindrom(h1, h2, stc);
		}
	}
}
