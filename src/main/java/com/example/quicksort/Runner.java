package com.example.quicksort;

public class Runner {

	public static void main(String[] args) {
		
		int arr[] = {1,2,5,8,4,9,10,0,18181, 7898};
		QuickSort.sort(arr, 0, arr.length -1);
		System.out.println(arr);
	}
	
}
