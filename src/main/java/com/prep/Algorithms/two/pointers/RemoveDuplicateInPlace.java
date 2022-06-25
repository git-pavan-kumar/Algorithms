package com.prep.Algorithms.two.pointers;

public class RemoveDuplicateInPlace {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {2,3,3,3,6,9,9}; //O/P: 4 --> {2,3,6,9,6,9,9}
		
		Integer res = countOfUniqueNumbers(arr);
		
		System.out.println(res);
	}

	private static Integer countOfUniqueNumbers(Integer[] arr) {
		int len = arr.length;
		int u = 1;
		
		for(int l = 0; l < len; l++) {	
			if(arr[u-1] != arr[l]) {
				arr[u] = arr[l];
				u++;
			}
		}
	
		return u;
	}

}
