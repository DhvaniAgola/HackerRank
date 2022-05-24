package com.leetcode.learningcards.linkedlist;

public class RemoveNthNodeFromEnd {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addAtTail(1);
		list.addAtTail(2);
		list.addAtTail(3);
		list.addAtTail(4);
		list.addAtTail(5);

		Node node2 = list.head;
		int n = 0;
		for (int i = 0; i < n; i++) {
			if (node2 == null) {
				System.out.println("not found");
				return;
			}
			node2 = node2.next;
		}


		list.head = removeNode(list.head, node2);

		list.traverse();
	}

	static Node removeNode(Node head, Node head2) {
		if (head2 == null) {
			head = head.next;
			return head;
		}
		if (head2.next == null) {
			if (head.next != null)
				head.next = head.next.next;
			return head;
		}
		head.next = removeNode(head.next, head2.next);
		return head;

	}
}
