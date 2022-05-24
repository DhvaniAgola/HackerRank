package com.leetcode.learningcards.linkedlist;

public class RemoveElementsByValue {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtTail(1);
		list.addAtTail(1);
		list.addAtTail(2);
		list.addAtTail(3);
		list.addAtTail(4);
		list.addAtTail(4);
		list.addAtTail(5);
		list.addAtTail(4);
		list.addAtTail(4);

		list.head = remove(list.head, 5);
		list.traverse();
	}

	static Node remove(Node head, int val) {
		if (head == null)
			return null;
		if (head.val == val) {
			head = head.next;
			head = remove(head, val);
		} else
			head.next = remove(head.next, val);
		return head;
	}
}
