package com.prep.Algorithms.mergeSort;

import java.util.Arrays;

public class MergeSortAlgorithm {

	public static void main(String[] args) {
		Integer[] arr = {10, 2, 8, 6, 5};
		
		mergeSort(arr, arr.length);
		
		System.out.println("Sorted array == " + Arrays.asList(arr));
	}

	private static void mergeSort(Integer[] arr, int length) {
		//Exist condition
		if(length < 2) return;
		
		//Split orig arr into 2 sub arrays
		int mid = length/2;
		int k = 0;
		Integer[] leftArr = new Integer[mid];
		Integer[] rightArr = new Integer[length - mid];
		
		for(int i=0; i<length; i++) {
			if(i < mid) {
				leftArr[i] = arr[i];
			} else {
				rightArr[k++] = arr[i];
			}
		}
		
		mergeSort(leftArr, mid);
		mergeSort(rightArr, length - mid);
		merge(leftArr, rightArr, arr, mid, length - mid);
	}

	private static void merge(Integer[] leftArr, Integer[] rightArr, Integer[] arr, int l, int h) {
		
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < l && j < h) {
			if(leftArr[i] < rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}
		
		if(i < l) {
			while(i < l) {
				arr[k++] = leftArr[i++];
			}
		}
		
		if(j < h) {
			while(j < h) {
				arr[k++] = rightArr[j++];
			}
		}
	}
	
	
}
