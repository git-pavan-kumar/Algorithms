/**
 * 
 */
package com.prep.Algorithms.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author pavan
 *
 */
public class MergeAllOverlappingIntervals {

	static class Intervals {
		private int start;
		private int end;
		
		Intervals(int s, int e) {
			this.start = s;
			this.end = e;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Intevals [start=");
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

		List<Intervals> input = new ArrayList<>();
		input.add(new Intervals(1, 4));
	    input.add(new Intervals(2, 5));
	    input.add(new Intervals(7, 9));
	    
	    List<Intervals> result = mergeIntervals(input);
	    System.out.println("Result: ");
	    result.forEach(e -> System.out.println(e));
	}
	
	private static List<Intervals> mergeIntervals(List<Intervals> input) {
		List<Intervals> result = new ArrayList<>();
		
		Collections.sort(input, (a,b) -> Integer.compare(a.start, b.start));
		
		Iterator<Intervals> itr = input.iterator();
		Intervals first = itr.next();
		int start = first.start;
		int end = first.end;
		
		
		while(itr.hasNext()) {
			Intervals next = itr.next();
			
			//Overlap
			if(next.start <= end) {
				start = Math.min(next.start, start);
				end = Math.max(next.end, end);
			} else { //No overlap
				result.add(new Intervals(start, end));
				start = next.start;
				end = next.end;
			}
		}
		result.add(new Intervals(start, end));
		
		return result;
	}

}
