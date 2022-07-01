package com.prep.Algorithms.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKFrequentlyOccuringElements {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 3, 5, 12, 11, 12, 11 };
		int k = 3;
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[k];
		
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		System.out.println(map);
		
		Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>((x, y) -> {
			if(x.getValue() - y.getValue() == 0) {
				return x.getKey() - y.getKey();
			} else {
				return x.getValue() - y.getValue();
			}
		});
		
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for(Map.Entry<Integer, Integer> entry : set) {
			heap.add(entry);
		}
		
		System.out.println(heap);
		
		for(int i=0; i<k; i++) {
			res[i] = heap.poll().getKey();
		}
		
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + " "); //Total: O(n log k)
		}
	}

}
