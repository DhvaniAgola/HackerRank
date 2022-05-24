package com.leetcode.learningcards.linkedlist;

public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
		MyLinkedList listA = new MyLinkedList();
		listA.addAtTail(1);
//		listA.addAtTail(2);
//		listA.addAtTail(3);
//		listA.addAtTail(7);
		listA.addAtTail(8);

		MyLinkedList listB = new MyLinkedList();
		listB.addAtTail(5);
		listB.addAtTail(6);
		listB.addAtTail(7);
		listB.addAtTail(8);


		int listASize = getSize(listA.head, 0);
		int listBSize = getSize(listB.head, 0);

		if (listASize < listBSize) {
			for (int i = 0; i < (listBSize - listASize); i++)
				listB.head = listB.head.next;
		}
		if (listASize > listBSize) {
			for (int i = 0; i < (listASize - listBSize); i++)
				listA.head = listB.head.next;
		}
		Node node = findIntersection(listA.head, listB.head);
		System.out.println(node != null ? node.val : "null");

	}

	static int getSize(Node head, int index) {
		if (head == null)
			return index;
		return getSize(head.next, index + 1);
	}

	static Node findIntersection(Node headA, Node headB) {
		if (headA == null || headB == null)
			return null;
		if (headA == headB)
			return headA;
		return findIntersection(headA.next, headB.next);
	}
}
