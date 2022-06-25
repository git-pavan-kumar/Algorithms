package com.prep.Algorithms.two.pointers;

public class SquaringSortedArray {

	public static void main(String[] args) {

		//int[] arr = new int[] {-2,-1,0,2,3}; //O/P: 0,1,4,4,9
		int[] arr = new int[] {-3, -1, 0, 1, 2}; //O/P: 0,1,1,4,9
		int[] res = squareSortedArry(arr);
		for(int i=0; i< arr.length; i++) {
			System.out.print(res[i]);
		}
		
	}

	private static int[] squareSortedArry(int[] arr) {

		int l = 0, h = arr.length - 1, index=arr.length-1;
		int[] newArr = new int[arr.length];
		while(l < h) {
			int lowSq = arr[l] * arr[l];
			int highSq = arr[h]*arr[h];
			if(lowSq > highSq) {
				newArr[index--] = lowSq;
				l++;
			} else {
				newArr[index--] = highSq;
				h--;
			}
		}
		
		return newArr;
	}

}
