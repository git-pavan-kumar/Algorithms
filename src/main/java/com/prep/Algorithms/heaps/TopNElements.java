package com.prep.Algorithms.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class TopNElements {

	public static void main(String[] args) {
		int[] arr = new int[] {8,1,3,2,6,7};
		int k = 3;
		
		//Building heap --> O(n)
		//Deleting k elements --> O(k log N)
		Queue<Integer> heap = new PriorityQueue<>((x, y) -> x - y); //Use min heap for Top, max heap for last k elements
		
		for(int i=0; i<k; i++) {
			heap.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			if(arr[i] > heap.peek()) {
				heap.poll();
				heap.add(arr[i]);
			}
		}
		
		System.out.println(heap);
	}

}
