/**
 * 
 */
package com.prep.Algorithms.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author pavan
 *
 */
public class InsertIntervalMerged {

	private static class Interval {
		private int start, end;
		
		Interval(int x, int y) {
			this.start = x;
			this.end = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Interval [start=");
			builder.append(start);
			builder.append(", end=");
			builder.append(end);
			builder.append("]");
			return builder.toString();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		Interval[] arr = new Interval[] {new Interval(1,3), new Interval(5,7), new Interval(8,12)};
		input = Arrays.asList(arr);
		System.out.println("Enter the input: ");
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();
		in.close();
		String[] inpArr = inp.split(",");
		Interval mergeArr = new Interval(Integer.valueOf(inpArr[0]), Integer.valueOf(inpArr[1]));
		System.out.println(mergeArr);
		List<Interval> result = getMergedIntervals(input, mergeArr);
		System.out.println(result);
	}

	private static List<Interval> getMergedIntervals(List<Interval> input, Interval mergeArr) {
		List<Interval> result = new ArrayList<>();
		if(null == input) {
			return result;
		}
		boolean merged = false;
		int start = 0, end = 0;
		Iterator<Interval> itr = input.iterator();
		
		while(itr.hasNext()) {
			Interval interval = itr.next();
			if(interval.end >= mergeArr.start) {
				//result.add(new Interval(Math.min(mergeArr.start, interval.start), Math.max(mergeArr.end, interval.end)));
				//merged = true;
				mergeArr.start = Math.min(mergeArr.start, interval.start);
				mergeArr.end = Math.max(mergeArr.end, interval.end);
			} else {
				result.add(interval);
			}
		}
		result.add(mergeArr);
		
		return result;
	}

}
