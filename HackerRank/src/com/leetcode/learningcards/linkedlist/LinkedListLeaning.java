package com.leetcode.learningcards.linkedlist;

class LLNode {
	int data;
	LLNode next;

	LLNode(int d) {
		data = d;
		next = null;
	}
}

public class LinkedListLeaning {
	LLNode head;    //Head of list

	//Inserts a new node at the front of the list
	public void push(int new_data) {
		//Allocate new node and putting data
		LLNode new_LL_node = new LLNode(new_data);

		//Make next of new node as head
		new_LL_node.next = head;

		//Move the head to point to new Node
		head = new_LL_node;
	}

	//Checks whether the value x is present in linked list
	public boolean search(LLNode head, int x) {
		LLNode current = head;    //Initialize current
		while (current != null) {
			if (current.data == x)
				return true;    //data found
			current = current.next;
		}
		return false;    //data not found
	}

	//Driver function to test the above functions
	public static void main(String args[]) {

		//Start with the empty list
		LinkedListLeaning llist = new LinkedListLeaning();

        /*Use push() to construct below list
        14->21->11->30->10  */
//		llist.push(10);
//		llist.push(30);
//		llist.push(11);
//		llist.push(21);
//		llist.push(14);

		llist.head = pushAtEnd(llist.head, 10);
		llist.head = pushAtEnd(llist.head, 30);
		llist.head = pushAtEnd(llist.head, 11);
		llist.head = pushAtEnd(llist.head, 21);
		llist.head = pushAtEnd(llist.head, 14);

		traverse(llist.head);
//		if (llist.search(llist.head, 21))
//			System.out.println("Yes");
//		else
//			System.out.println("No");
	}


	static void traverse(LLNode head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		traverse(head.next);
	}

	static LLNode pushAtEnd(LLNode head, int val) {
		if (head == null) {
			return new LLNode(val);
		}
		head.next = pushAtEnd(head.next, val);
		return head;

	}

}
