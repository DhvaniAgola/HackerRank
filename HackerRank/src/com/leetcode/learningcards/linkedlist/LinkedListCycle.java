package com.leetcode.learningcards.linkedlist;

public class LinkedListCycle {
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
//		myLinkedList.addAtTail(1);
//		myLinkedList.addAtTail(2);
//		myLinkedList.addAtTail(3);
//		myLinkedList.addAtTail(4);
//		myLinkedList.addAtTail(5);
		if (myLinkedList.head == null) {
			System.out.println(false);
			return;
		}
		System.out.println(hasCycle(myLinkedList.head, myLinkedList.head.next));
	}

	static boolean hasCycle(Node head1, Node head2) {
		if (head1 == null || head2 == null)
			return false;
		if (head1 == head2)
			return true;
		if (head1.next == null || head2.next == null) {
			return false;
		}
		return hasCycle(head1.next, head2.next.next);
//		return false;
	}
}
