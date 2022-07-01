package com.prep.Algorithms.bitwise.xor;

public class FindNumberWhichIsNotDuplicate {

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,2,1,3,2,3};
		int x = 0;
		for(int i=0; i<arr.length; i++) {
			x = x ^ arr[i];
		}
		System.out.println(x);
	}
}
