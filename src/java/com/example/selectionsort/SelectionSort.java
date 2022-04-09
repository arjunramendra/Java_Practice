package com.example.selectionsort;

public class SelectionSort {

	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				int smallest = i;
				if(arr[i] > arr[j] && arr[i] != arr[j]) {
					smallest = j;
				}
				swap(arr, i, smallest);
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
