/**
 * 
 */
package com.prep.Algorithms.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pavan
 *
 */
public class LogestSubStrWithMaxKDistinctChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "cbbebi";
		int k = 3;
		//Time comp: O(N)
		int min = findLogestSubStrWithMaxKDistinctChars(s, k);
		System.out.println("Longest sub string: " + min);

	}

	private static int findLogestSubStrWithMaxKDistinctChars(String s, int k) {
		int first = 0;
		int max = 0;
		Map<Character, Integer> hm = new HashMap<>();

		for(int last = 0; last < s.length(); last++) {
			hm.compute(s.charAt(last), (key,val) -> val == null ? 1 : val+1);
			while(hm.size() > k) {
				hm.computeIfPresent(s.charAt(first), (key, val) -> val-1 == 0 ? hm.remove(key) : val-1);
				max = Math.max(max, last - first);
				first++;
			}
		}
		return max;
	}

}
