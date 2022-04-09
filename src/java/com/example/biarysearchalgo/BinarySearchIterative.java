package com.example.biarysearchalgo;

public class BinarySearchIterative {
	public boolean search(int[] array, int data) {
		int left = 0;
		int right = array.length - 1;
		while(left<=right) {
			int mid = left + (( right - left) / 2);
			if(array[mid] == data) {
				return true;
			}else if(data < array[mid]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return false;
	}
}
