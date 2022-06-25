/**
 * 
 */
package com.prep.Algorithms.sliding.window;

/**
 * @author pavan
 *
 */
public class SmallestSubArrWithGreaterSumThanS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] {2, 1, 5, 2, 8};
		int s = 7;
		//Time comp: O(N)
		int min = findSmallestSubArrWithGreaterSumThanS(arr, s);
		System.out.println("Min sub arr len: " + min);
	}

	private static int findSmallestSubArrWithGreaterSumThanS(int[] arr, int s) {
		
		int first = 0;
		int sum = 0;
		int minSubArrLen = 1000;
		
		for(int last = 0; last < arr.length; last++) {
			sum = sum + arr[last];
			
			while(sum >= s) {
				minSubArrLen = Math.min(minSubArrLen, last - first + 1);
				sum = sum - arr[first];
				first++;
			}
		}
		return minSubArrLen;
	}

	
}
