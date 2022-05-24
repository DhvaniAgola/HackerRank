package com.leetcode.learningcards.linkedlist;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtTail(1);
		list.addAtTail(2);
		list.addAtTail(3);
		list.addAtTail(4);
		list.addAtTail(5);
		list.addAtTail(6);
//		list.addAtTail(7);
		if (list.head == null || list.head.next == null) {
			list.traverse();
			return;
		}
		Node prev = list.head.next;
		Node head2 = list.head.next.next;
		list.head = oddEven(list.head, prev, head2);
		list.traverse();
	}

	static Node oddEven(Node head, Node prev, Node head2) {
		if (head2 == null) {
			return head;
		}
		prev.next = head2.next;
		head2.next = head.next;
		head.next = head2;

		if (prev.next != null) {
//			head2 = head2.next.next.next;
			head.next = oddEven(head.next, prev.next, prev.next.next);
		}
		return head;
	}
}
