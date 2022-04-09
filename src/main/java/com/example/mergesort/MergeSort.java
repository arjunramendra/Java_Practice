package com.example.mergesort;

public class MergeSort {

	public static void mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}
	
	public static void mergeSort(int[] array, int[] temp, int left, int right) {
		if(left >= right) {
			return;
		}
		int median = (left + right) /2;
		mergeSort(array,temp, left, median);
		mergeSort(array,temp, median + 1, right);
		mergeHalves(array,temp, left, right);
	}
	
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) /2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int i = leftStart;
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[i] = array[left];
				left++;
			}else {
				temp[i] = array[right];
				right++;
			}
			i++;
		}
		System.arraycopy(array, left, temp, i, leftEnd - left + 1);
		System.arraycopy(array, right, temp, i, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
		System.out.println(array);
	}
	
}
