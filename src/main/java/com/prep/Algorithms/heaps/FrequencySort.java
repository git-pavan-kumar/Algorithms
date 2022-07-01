package com.prep.Algorithms.heaps;

import java.util.HashMap;
import java.util.Map;

public class FrequencySort {

	public static void main(String[] args) {
		String inp = "Programming";
		char[] arr = new char[inp.length()];
		Map<Character, Integer> map = new HashMap<>();
		//Set<Map.Entry<Character, Integer>> set = new TreeSet<Map.Entry<Character, Integer>>(Comparator.reverseOrder());
		
		for(int i=0; i< inp.length(); i++) {
			char chr = (char) inp.charAt(i);
			map.put(chr, map.getOrDefault(chr, 0) + 1);
			arr[i] = chr;
		}
		
		System.out.println(map);
		
	}

}
