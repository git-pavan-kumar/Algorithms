package com.prep.Algorithms.bitwise.xor;

public class FindMissingNumberInASequence {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,5,6}; //4 is missing
		
		int x = 0;
		for(int i=0; i<arr.length; i++) {
			x = x ^ arr[i];
		}
		
		int y = 1;
		for(int i=2; i<=arr.length+1; i++) {
			y = y ^ i;
		}

		int res = x ^ y; //(xor of given arr) xor (xor of complete sequence) 
		
		System.out.println("missing num: " + res);
	}

}
