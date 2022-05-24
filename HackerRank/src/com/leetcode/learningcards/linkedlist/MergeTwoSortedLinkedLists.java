package com.leetcode.learningcards.linkedlist;

public class MergeTwoSortedLinkedLists {

	public static void main(String[] args) {
		MyLinkedList list1 = new MyLinkedList();
//		list1.addAtTail(1);
//		list1.addAtTail(2);
//		list1.addAtTail(3);
//		list1.addAtTail(4);
//		list1.addAtTail(5);

		MyLinkedList list2 = new MyLinkedList();
		list2.addAtTail(1);
		list2.addAtTail(2);
//		list2.addAtTail(3);
		list2.addAtTail(4);
//		list2.addAtTail(5);
		list2.addAtTail(6);

		MyLinkedList merged = new MyLinkedList();


		while (list1.head != null || list2.head != null) {
			if (list1.head != null && list2.head != null) {
				if (list1.head.val < list2.head.val) {
					merged.addAtTail(list1.head.val);
					list1.head = list1.head.next;
				} else {
					merged.addAtTail(list2.head.val);
					list2.head = list2.head.next;
				}
			} else if (list1.head == null) {
				merged.addAtTail(list2.head.val);
				list2.head = list2.head.next;
			} else {
				merged.addAtTail(list1.head.val);
				list1.head = list1.head.next;
			}
		}
		merged.traverse();
	}
}
