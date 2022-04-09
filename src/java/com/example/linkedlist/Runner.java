package com.example.linkedlist;

public class Runner {

	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(4);
		list.insert(8);
		list.show();
		list.insertAtStart(5);
		list.show();
		list.insertAtPosition(10, 2);
		list.show();
		list.insertAtPosition(15, 3);
		list.show();
		list.insertAtPosition(20, 5);
		list.show();
		list.insertAtLast(30);
		list.show();
		list.insertAtStart(40);
		list.insertAtStart(41);
		list.show();
//		list.mergeSort(list.head);
//		list.show();
		System.out.println(list.middle(list.head).data);
		new LinkedList(list.reverseList(list.head)).show();
	}
}
