package com.prep.Algorithms.searching;

public class RotatedArrayIndex {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 6};

		int index = getIndexOfRotatedArray(arr, 0, arr.length - 1);
		System.out.println("Index of rotated array == " + index);
	}

	private static int getIndexOfRotatedArray(int[] arr, int l, int h) {
		
		if(l == h) {
			return l;
		}
		
		while(l <= h) {
			int mid = (l + h) / 2;
			if(arr[mid] < arr[h]) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		
		return l;
	}

}
