package com.example.linkedlist;

import java.util.Vector;

public class LinkedList {

	Node head;
	
	public LinkedList(){};
	
	public LinkedList(Node head){
		this.head = head;
	}
	
	public void insert(int data) {
		Node node = new Node();
		node.setData(data);
		
		if(this.head == null) {
			head = node;
		}else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void insertAtStart(int data) {
		Node n = new Node();
		Node temp = new Node();
		n = head;
		temp.setData(data);
		temp.next = n;
		head = temp;
	}
	
	public void insertAtPosition(int data, int pos){
		Node node = new Node();
		node.setData(data);
		Node n = head; 
//		Node temp = new Node();
//		temp.setData(data);
		int currPos = 0;
		while(n.next != null) {
			if(currPos == pos-1) {
				Node temp = new Node();
				temp = node;
				temp.next = n.next;
				n.next = temp;
				break;
			}
			n = n.next;
			currPos++;
			
		}
	}
	
	public void insertAtLast(int data) {
		Node temp = new Node();
		temp.setData(data);
		Node n = head;
		while(n.next!=null) {
			n = n.next;
		}
		//n = n.next;
		n.next = temp;
	}
	
	public void show() {
		Node node = new Node();
		node = this.head;
		
		while(node.next != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		
		System.out.println(node.data);
	}
	
    public Node reverseList(Node head) {
    	Node prev = head;
        Node curr = head.next;
        while(curr != null) {
        	Node next = curr.next;
        	curr.next = prev;
        	
        	prev = curr;
        	curr = next;
        }
        head.next = null;
        head = prev;
        return prev;
    }
    
    public Node mergeSort(Node node) {
    	if((node == null) || (node.next == null)){
    		return node;
    	}
    	Node middle = middle(node);
    	Node right = middle.next;	
    	middle.next = null;
    	Node a = mergeSort(node);
    	Node b = mergeSort(right);
    	Node temp = merge(a, b);
    	return temp;
    }
    
    public Node merge(Node a, Node b) {
    	Node temp = new Node();
    	Node finalList = temp;
    	while(a != null && b != null) {
    		if(a.data < b.data) {
    			temp.next = a;
    			a = a.next;
    		}else {
    			temp.next = b;
    			b = b.next;
    		}
    		temp = temp.next;
    	}
    	temp.next = (a==null) ? b : a;
    	return finalList.next;
    }
    
    public Node middle(Node node) {
    	if(node == null) {
    		return node;
    	}
    	Node a = node;
    	Node b = node.next;
    	while(b != null && b.next != null) {
    		a = a.next;
    		b = b.next.next;
    	}
    	return a;
    }
	
}
