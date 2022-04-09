package com.example.bubblesort;

public class BubbleSort {

	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j] && arr[i] != arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}
	
	private static int[] swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		return array;
	}
	
}
