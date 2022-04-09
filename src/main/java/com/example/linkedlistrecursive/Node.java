package com.example.linkedlistrecursive;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void insertData(int value) {
		if(next == null) {
			this.next = new Node(value);
		}else {
			next.insertData(value);
		}
	}
	
	public void show() {
		System.out.println(data);
		if(next != null) {
			next.show();
		}
	}
	
	public void insertAtStart(int data) {
		Node node = new Node(data);
		Node temp = this;
		node.next = temp;
		temp = node;
	}
	
	
}
