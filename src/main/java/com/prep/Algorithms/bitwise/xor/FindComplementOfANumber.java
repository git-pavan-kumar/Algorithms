package com.prep.Algorithms.bitwise.xor;

public class FindComplementOfANumber {

	public static void main(String[] args) {
		int x = 8; //1010
		
		//num ^ 1111 --> no of 1's depends on num of bits in num
		
		int num = x;
		int y = num;
		int noOfOnes = 0;
		
		while(y > 0) {
			noOfOnes++;
			y = y >> 1;
		}
		
		int allOnes = (int) (Math.pow(2, noOfOnes) - 1);
		
		int res = x ^ allOnes;
		
		System.out.println(res);
 
	}

}
