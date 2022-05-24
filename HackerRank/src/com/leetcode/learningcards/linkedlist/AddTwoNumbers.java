package com.leetcode.learningcards.linkedlist;

public class AddTwoNumbers {
	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		l1.addAtTail(9);
		l1.addAtTail(9);
		l1.addAtTail(9);

		MyLinkedList l2 = new MyLinkedList();
		l2.addAtTail(9);
		l2.addAtTail(9);
//		l2.addAtTail(3);

		MyLinkedList addition = new MyLinkedList();
		int carry = 0;
		int sum = 0;
		while (l1.head != null || l2.head != null) {
			sum = 0;
			if (l1.head != null && l2.head != null) {
				sum = carry + l1.head.val + l2.head.val;
				if (sum > 9) {
					sum -= 10;
					carry = 1;
				} else {
					carry = 0;
				}
				addition.addAtTail(sum);
				l1.head = l1.head.next;
				l2.head = l2.head.next;
			} else if (l1.head == null) {
				sum = carry + l2.head.val;
				if (sum > 9) {
					sum -= 10;
					carry = 1;
				} else {
					carry = 0;
				}
				addition.addAtTail(sum);
				l2.head = l2.head.next;
			} else {
				sum = carry + l1.head.val;
				if (sum > 9) {
					sum -= 10;
					carry = 1;
				} else {
					carry = 0;
				}
				addition.addAtTail(sum);
				l1.head = l1.head.next;
			}
		}
		if (carry != 0) {
			addition.addAtTail(carry);
		}

		addition.traverse();
	}
}
