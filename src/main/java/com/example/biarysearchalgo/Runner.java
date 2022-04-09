package com.example.biarysearchalgo;

public class Runner {

	public static void main(String[] args) {
		BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();
		BinarySearchIterative binarySearchIterative = new BinarySearchIterative();
		
		int arr[] = {1,2,5,8,4,9,10,0,18181, 7898};
		System.out.println(binarySearchRecursive.search(arr, 0, 0, arr.length - 1));
		System.out.println(binarySearchIterative.search(arr, 18181));
	}
}
