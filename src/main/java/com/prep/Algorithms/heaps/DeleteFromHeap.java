package com.prep.Algorithms.heaps;

public class DeleteFromHeap {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,4,6,13,10,9,8,15,17};
		createMaxHeapify(arr, arr.length);// O(n), but inserting individual ele is O(log N)
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		deleteFromHeap(arr, arr.length); //O(log N)
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " "); //Array sorted, O(n logN)
		
	}

	private static void deleteFromHeap(int[] arr, int len) {
		int last = len - 1;
		if(last < 0)
			return;
		swap(arr, 0, last);
		len = last - 1;
		createMaxHeapify(arr, len);
		
		deleteFromHeap(arr, last);
	}

	private static void createMaxHeapify(int[] arr, int length) {
		int nonLeaf = length/1-2;
		for(int i=nonLeaf; i>=0; i--) {
			maxHeapify(arr, i, length);
		}
		
	}

	private static void maxHeapify(int[] arr, int i, int len) {
		int large = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < len && arr[large] < arr[left]) 
			large = left;
		if(right < len && arr[large] < arr[right])
			large = right;
		
		if(large != i) {
			swap(arr, large, i);
			maxHeapify(arr, large, len);
		}
		
	}

	private static void swap(int[] arr, int x, int y) {
		System.out.println("Swapped " + arr[x] + " and " + arr[y]);
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;	
	}

}
