/**
 * 
 */
package com.prep.Algorithms.sliding.window;

/**
 * @author pavan
 *
 */
public class MaxSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] {2, 3, 4, 1, 5};
		int k = 1;
		if(arr.length == 0)
			System.out.println("Error: Arr len 0");
		else if(arr.length < k)
			System.out.println("Error: k cannot be greate than len of array");
		else {
			int max = 0;
			int[] result = findMaxSumSubArray(arr, k);
			for(int i : result) {
				if(i > max)
					max = i;
			}
			System.out.println("Total sub arrays: "+ result.length);
			System.out.println("Max sum sub array = " + max);
		}
	}

	private static int[] findMaxSumSubArray(int[] arr, int k) {
		int start = 0;
		int sum = 0;
		int arrLen = arr.length;
		int[] res = new int[arrLen - k + 1];
		
		for(int end = 0; end < arrLen; end++) {
			sum = sum + arr[end];
			
			if((end - start) >= (k-1)) {
				System.out.println("Sub arr");
				res[start] = sum;
				sum = sum - arr[start];
				start++;
			}
		}
		
		return res;
	}

}
