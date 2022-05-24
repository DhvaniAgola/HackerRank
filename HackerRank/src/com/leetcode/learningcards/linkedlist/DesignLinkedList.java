package com.leetcode.learningcards.linkedlist;

public class DesignLinkedList {

	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addAtIndex(0, 10);
		myLinkedList.addAtIndex(0, 20);
		myLinkedList.addAtIndex(1, 30);
		myLinkedList.traverse();
		System.out.println(myLinkedList.get(0));
//		myLinkedList.addAtTail(5);
//		myLinkedList.addAtTail(10);
//		myLinkedList.addAtTail(15);
//		myLinkedList.addAtHead(2);
//		myLinkedList.addAtIndex(2, 8);
//		myLinkedList.traverse();
//		System.out.println("==");
//		myLinkedList.deleteAtIndex(5);
//		myLinkedList.traverse();
//		System.out.println("==");
//		System.out.println(myLinkedList.get(0));
//		System.out.println("==");
//		System.out.println(myLinkedList.get(2));
	}
}

