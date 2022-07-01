package com.prep.Algorithms.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
		int k = 2;
		
		Queue<Point> heap = new PriorityQueue<>((x, y) -> y.EucledianDistance().compareTo(x.EucledianDistance()));

		for(int i=0; i<k; i++) {
			heap.add(points[i]);
		}
		
		for(int i=k; i<points.length; i++) {
			if(points[i].EucledianDistance() < heap.peek().EucledianDistance()) {
				heap.poll();
				heap.add(points[i]);
			}
		}
		
		System.out.println(heap); //O(n * log K)
	}

}

class Point {
	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Double EucledianDistance() {
		return Math.pow(this.x, 2) * Math.pow(this.y, 2);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Point [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}
}
