package com.prep.Algorithms.heaps;

public class HeapifyMinAndMax {

	public static void main(String[] args) {
		int[] arr = new int[] {8,1,3,2,6,7}; //{1,3,5,4,6,13,10,9,8,15,17};
		createMaxHeapify(arr, arr.length);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		createMinHeap(arr, arr.length);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	private static void createMinHeap(int[] arr, int length) {
		int nonLeafIndex = length/2 -1;
		for(int i=nonLeafIndex; i>=0; i--) {
			minHeapify(arr, i);
		}
		
	}

	private static void createMaxHeapify(int[] arr, int len) {
		int nonLeaf = (len/2)-1;
		for(int i=nonLeaf; i>=0; i--) {
			maxHeapify(arr, i);
		}
		
	}

	private static void maxHeapify(int[] arr, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < arr.length && arr[left] > arr[largest])
			largest = left;
		if(right < arr.length && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i) {
			swap(arr,largest, i);
			maxHeapify(arr, largest);
		}
		
	}

	private static void swap(int[] arr, int x, int y) {
		System.out.println("Swapped " + arr[x] + " and " + arr[y]);
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;	
	}
	
	private static void minHeapify(int[] arr, int i) {
		int smallest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left <  arr.length && arr[smallest] > arr[left])
			smallest = left;
		if(right < arr.length && arr[smallest] > arr[right])
			smallest = right;
		
		if(smallest != i) {
			swap(arr, smallest, i);
			minHeapify(arr, smallest);
		}
	}
}
