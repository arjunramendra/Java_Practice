package com.example.biarysearchalgo;

import java.util.Arrays;

public class BinarySearchRecursive {

	public boolean search(int[] array, int data, int left, int right) {
		
		Arrays.sort(array);
		if(left > right) {
			return false;
		}
		
		int mid = (left + right) / 2;
		
		if(array[mid] == data) {
			return true;
		}else if(data < array[mid]) {
			return search(array, data, left, mid - 1);
		}else {
			return search(array, data, mid + 1, right);
		}
	}
	
}
