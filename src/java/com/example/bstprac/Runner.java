package com.example.bstprac;

import com.example.bstprac.Node;

public class Runner {

	
	public static void main(String[] args) {
		Node node = new Node(10);
		node.insert(5);
		node.insert(11);
		node.insert(4);
		node.insert(6);
		node.insert(7);
		//node.inOrder();
		//node.preOrder();
		//node.postOrder();
		node.levelOrder();
		//System.out.println();
		//node.levelOrder();
	}
}
