package com.prep.Algorithms.searching;

public class BinarySearchNonRecursive {

	private static int binarySearch(int[] arr, int n, int x) {
		int l = 0;
		int h = n - 1;
		int mid = 0;
		int index = -1;
		int noOfIterations = 1;
		
		while(l <= h) {
			mid = (l + h)/2;
			if(arr[mid] == x) {
				index = mid;
				break;
			} else if(arr[l] == x) { 
				index = l;
				break;
			} else if(arr[h] == x) {
				index = h;
				break;
			} else if(x < arr[mid]) {
				h = mid - 1;
				l++;
			} else {
				l = mid + 1;
				h--;
			}
			noOfIterations++;
		}
		
		System.out.println("no of iterations == " + noOfIterations);
		return index;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {3, 5, 7, 8, 10, 15, 66, 70, 100, 255, 432, 555, 763};
		int n = arr.length;
		System.out.println("Arr length == " + n);
		int index = binarySearch(arr, n, 2);
		
		System.out.println("Index  === " + index);
	}
}
