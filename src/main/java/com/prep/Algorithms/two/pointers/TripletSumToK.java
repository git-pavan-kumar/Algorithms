package com.prep.Algorithms.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToK {

	public static void main(String[] args) {
		int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2}; //O/P: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
		List<List<Integer>> res = findTripletSumToK(arr, 3);
		System.out.println(res);
		//res.stream().forEach(ele -> ele.forEach(System.out::println));
	}

	private static List<List<Integer>> findTripletSumToK(int[] arr, int k) {
		int l=1, h=arr.length-1;
		List<List<Integer>> lst = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0; i<arr.length-2; i++) {
			l = i + 1;
			h = arr.length - 1;
			while(l < h) {		
				int res = arr[l] + arr[h];
				if(res == k - arr[i]) {
					lst.add(Arrays.asList(arr[i],arr[l], arr[h]));
					l++;
					h--;
				} else if(res < -arr[i]) {
					l++;
				} else {
					h--;
				}
			}
			
		}
		
		return lst;
	}

}
