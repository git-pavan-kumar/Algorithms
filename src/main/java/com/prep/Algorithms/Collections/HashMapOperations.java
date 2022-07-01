package com.prep.Algorithms.Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapOperations {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		m.put("India", 1);
		m.put("USA", 2);
		m.put("Aus", 3);
		
		m.compute("Aus", (k,v) -> k == null ? v-1 : m.remove(k));
		//m.computeIfAbsent("Vietnam", k -> 4);
		m.computeIfPresent("USA", (k,v) -> v == 0 ? m.remove(k) : v-1);
		m.computeIfPresent("USA", (k,v) -> v == 0 ? m.remove(k) : v-1);
		m.computeIfPresent("USA", (k,v) -> v == 0 ? m.remove(k) : v-1);
		System.out.println(m);
	}
}
