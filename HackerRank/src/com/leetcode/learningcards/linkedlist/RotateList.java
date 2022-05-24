package com.leetcode.learningcards.linkedlist;

public class RotateList {
	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
//		l1.addAtTail(1);
//		l1.addAtTail(2);
//		l1.addAtTail(3);
//		l1.addAtTail(4);

		if (l1.head == null) {
			l1.traverse();
			return;
		}
		int k = 4;
		Node head1 = l1.head;
		Node head2 = l1.head;

		int size = 1;
		while (head2.next != null) {
			head2 = head2.next;
			size++;
		}
		k = k % size;

		for (int i = 0; i < (size - k) - 1; i++) {
			head1 = head1.next;
		}

		head2.next = l1.head;
		l1.head = head1.next;
		head1.next = null;

		l1.traverse();
	}
}
