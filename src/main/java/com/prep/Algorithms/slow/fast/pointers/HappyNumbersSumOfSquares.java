package com.prep.Algorithms.slow.fast.pointers;

public class HappyNumbersSumOfSquares {

	public static void main(String[] args) {
		int num = 23;
		int slow = num, fast = num;
		do {
			slow = findSumOfSquares(slow);
			fast = findSumOfSquares(findSumOfSquares(fast));
		} while(slow != fast);
		
		System.out.println(slow == 1);
	}

	private static int findSumOfSquares(int num) {
		//15
		int sum = 0;
		while(num > 0) {
			int r = num % 10;
			num = num / 10;
			sum = sum + (r*r);
		}
		return sum;
	}

}
