package com.prep.Algorithms.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 12, 11, -1, 12  };
		int k = 3;
		
		Queue<Integer> heap = new PriorityQueue<>((x, y) -> y - x); //Use max heap
		for(int i=0; i<k; i++) { //O(log k)
			heap.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) { //O((n-k)log k)
			if(arr[i] < heap.peek()) {
				heap.poll();
				heap.add(arr[i]);
			}
		}
		
		System.out.println(heap.poll()); // Total: O(log k) + O((n-k)log k) = O(n * log k)
	}

}
