package com.prep.Algorithms.bitwise.xor;

public class ReverseAndComplementAMatrix {

	public static void main(String[] args) {
		int[][] inp = new int[][] {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		
		for(int[] x : inp) {
			for(int i=0; i<x.length/2; i++) {
				int temp = x[i] ^ 1;
				x[i] = x[x.length-1-i] ^ 1;
				x[x.length-1-i] = temp;
			}
		}
		
		for(int i=0; i<inp.length; i++) {
			for(int j=0; j<inp[i].length; j++) {
				System.out.print(inp[i][j] + " ");
			}
			System.out.println();
		}
	}

}
