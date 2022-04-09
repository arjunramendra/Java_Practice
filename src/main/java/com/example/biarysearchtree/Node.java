package com.example.biarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {

	Integer data;
	Node left, right;
		
	public Node(Integer data) {
		this.data = data;
	}
	
	public void insert(Integer value) {
		if(value < data) {
			if(left != null) {
				left.insert(value);
			}else {
				left = new Node(value);
			}
		}
		else {
			if(right != null) {
				right.insert(value);
			}else {
				right = new Node(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if (value == data) {
			return true;
		}else if(value < data){
			if(left == null) {
				return false;
			}else {
				return left.contains(value);
			}
		}else {
			if(right == null) {
				return false;
			}else {
				return right.contains(value);
			}
		}
	}
	
	public void inOrder() {
		if(left != null) {
			left.inOrder();
		}
		System.out.println(this.data);
		if(right != null) {
			right.inOrder();
		}
	}
	
	public void preOrder() {
		System.out.println(this.data);
		if(left != null) {
			left.preOrder();
		}
		if(right != null) {
			right.preOrder();
		}
	}
	
	public void postOrder() {
		if(left != null) {
			left.postOrder();
		}
		if(right != null) {
			right.postOrder();
		}
		System.out.println(this.data);
	}
	
	public void levelOrder() {
		Queue<Node> visited = new LinkedList<>();
		visited.add(this);
		while(!visited.isEmpty()) {
			if(visited.peek().left != null) {
				visited.add(visited.peek().left);
			}
			if(visited.peek().right != null) {
				visited.add(visited.peek().right);
			}
			System.out.print(visited.poll().data + " ");
		}
	}
	
	public void printZigZagTraversal() {
		Stack<Node> current = new Stack<>();
		Stack<Node> next = new Stack<>();
		boolean leftToRight = true;
		current.add(this);
		
		while(!current.isEmpty()) {
			Node temp = current.pop();
			System.out.print(temp.data + " ");
			if(leftToRight) {
				if(temp.left!= null) {
					next.push(temp.left);
				}if(temp.right != null) {
					next.push(temp.right);
				}
			}
			if(!leftToRight) {
				if(temp.right!= null) {
					next.push(temp.right);
				}if(temp.left != null) {
					next.push(temp.left);
				}
			}
			if(current.isEmpty()) {
				leftToRight = !leftToRight; 
				current = next;
			}
		}
	}
	
	public boolean validateBST() {
		Integer data = left.data;
		if(left != null) {
			if(data <= left.data) {
				return false;
			}else {
				left.validateBST();
			}
		}
		if(right != null) {
			if(data >= right.data) {
				return false;
			}else {
				right.validateBST();
			}
		}
		return true;
	}
	
	public int maxDepth(Node root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
