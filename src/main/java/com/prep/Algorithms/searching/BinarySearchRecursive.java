package com.prep.Algorithms.searching;

public class BinarySearchRecursive {

	private static int noOfIterations = 1;
	private static int binarySearch(int[] arr, int l, int h, int x) {
		
		if(l >= h)
			return -1;
		noOfIterations++;
		int mid = (l + h)/2;
		if(arr[mid] == x)
			return mid;
		
		if(x < arr[mid])
			return binarySearch(arr, l, mid, x);
		else
			return binarySearch(arr, mid + 1, h, x);

	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 7, 8, 10, 15, 66, 70, 100, 255, 432, 555, 763};
		int n = arr.length;
		int index = binarySearch(arr, 0, n, 2);
		System.out.println("noOfIterations == " + noOfIterations);
		System.out.println("Index result === " + index);
		
	}
}
