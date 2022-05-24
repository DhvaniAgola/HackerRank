package com.leetcode.learningcards.linkedlist;

public class MyLinkedList {

	Node head;

	public MyLinkedList() {
	}

	public int get(int index) {
		return get(head, index, 0);
	}

	public void addAtHead(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
	}

	public void addAtTail(int val) {
		head = insertAtEnd(head, val);
	}

	public void addAtIndex(int index, int val) {
		addAtIndex(head, index, val, 0);
	}

	public void deleteAtIndex(int index) {
		deleteAtIndex(head, index, 0);
	}

	public void traverse() {
		traverse(head);
	}

	//will create a cycle by setting a node of 'index' as a next node of last node
	public void createCycle(int index) {
		createCycle(head, index);
	}

	private Node insertAtEnd(Node head, int val) {
		if (head == null)
			return new Node(val);
		head.next = insertAtEnd(head.next, val);
		return head;
	}

	private void addAtIndex(Node head, int index, int val, int currentIndex) {
		if (index == 0) {
			Node newNode = new Node(val);
			newNode.next = head;
			this.head = newNode;
			return;
		} else if (head == null) {
			return;
		} else if (index == currentIndex + 1) {
			Node newNode = new Node(val);
			newNode.next = head.next;
			head.next = newNode;
			return;
		}
		addAtIndex(head.next, index, val, currentIndex + 1);
	}

	private void deleteAtIndex(Node head, int index, int currentIndex) {
		if (head == null)
			return;
		if (index == 0) {
			this.head = head.next;
			return;
		}
		if (index == currentIndex + 1) {
			if (head.next != null)
				head.next = head.next.next;
			return;
		}
		deleteAtIndex(head.next, index, currentIndex + 1);
	}

	private int get(Node head, int index, int currentIndex) {
		if (head == null)
			return -1;
		if (index == currentIndex)
			return head.val;
		return get(head.next, index, currentIndex + 1);
	}

	private void traverse(Node head) {
		if (head == null)
			return;
		System.out.println(head.val);
		traverse(head.next);
	}

	private void createCycle(Node head, int index) {

	}
}

class Node {

	Node next;
	int val;

	Node(int val) {
		this.val = val;
		this.next = null;
	}
}