package com.example.biarysearchtree;

public class Runner {

	public static void main(String[] args) {
		Node node = new Node(10);
		node.insert(5);
		node.insert(11);
		node.insert(4);
		node.insert(6);
		node.insert(7);
		System.out.println(node.contains(7));
		//node.inOrder();
//		node.preOrder();
		//node.postOrder();
//		node.levelOrder();
//		node.printZigZagTraversal();
//		System.out.println();
//		System.out.println(node.validateBST());
//		System.out.println(node.maxDepth(node));
		//node.levelOrder();
	}
	
//				10
//			5        	11
//		4		6
//					7
//	
}
