package com.example.mergesort;

public class Runner {

	public static void main(String[] args) {
		int arr[] = {1,2,5,8,4,9,10,0,18181, 7898};
		MergeSort.mergeSort(arr);
		System.out.println(arr.toString());
	}
	
}
