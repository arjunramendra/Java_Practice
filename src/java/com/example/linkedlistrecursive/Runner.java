package com.example.linkedlistrecursive;

public class Runner {

	public static void main(String[] args) {
		Node node = new Node(10);
		node.insertData(11);
		node.insertData(12);
		node.insertData(15);
		node.insertData(20);
		node.insertAtStart(50);
		node.show();
	}	
}
