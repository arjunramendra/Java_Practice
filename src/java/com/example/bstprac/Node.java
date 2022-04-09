package com.example.bstprac;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

	int data;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void insert(int val) {
		if(val < this.data) {
			if(left != null) {
				left.insert(val);
			}else {
				left = new Node(val);
			}
		}if (val > this.data) {
			if(right != null) {
				right.insert(val);
			}else {
				right = new Node(val);
			}
		}
	}
	
	public void preOrder() {
		System.out.print(this.data + " ");
		if(left!=null) {
			left.preOrder();
		}
		if(right!=null) {
			right.preOrder();
		}
	}
	
	public void inOrder() {
		if(left!=null) {
			left.inOrder();
		}
		System.out.print(this.data + " ");
		if(right!=null) {
			right.inOrder();
		}
	}
	
	public void postOrder() {
		if(left!=null) {
			left.postOrder();
		}
		if(right!=null) {
			right.postOrder();
		}
		System.out.print(this.data + " ");
	}
	
	public void levelOrder() {
		Queue<Node> visited = new LinkedList<>();
		visited.add(this);
		while(!visited.isEmpty()) {
			if(visited.peek().left!= null) {
				visited.add(visited.peek().left);
			}if(visited.peek().right!= null) {
				visited.add(visited.peek().right);	
			}
			System.out.print(visited.peek().data + " ");
			visited.poll();
		}
		System.out.println();
	}
}
