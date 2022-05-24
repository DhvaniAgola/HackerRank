package com.leetcode.learningcards.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtTail(1);
		list.addAtTail(2);
		list.addAtTail(3);
		list.addAtTail(4);
		list.addAtTail(5);

//		Node head2 = list.head.next;
//		list.head.next = null;

		Node prev = null;
		Node current = list.head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;

		list.traverse();
	}
}
