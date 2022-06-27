package com.prep.Algorithms.in.place.reversal.ll;

public class ReverseEveryKElementInLinkedList {

	
	private static class LinkedList {
		private int val;
		private LinkedList next;
		
		LinkedList(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("LinkedList [val=");
			builder.append(val);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
		int[] inpArr = new int[] {1,2,3,4,5,6,7,8};
		LinkedList head = createLinekdList(inpArr);
		int size = printLinkedList(head);
		int k = 2;
		int from = 1;
		int to = k;
		
		while(to <= size) {
			head = reverse(from, to, head);
			//from = to + 1;
			//to = to + k;
			to = to*2 + 1;
			from = to;
			to = to + k - 1;
			System.out.println(from + " " + to);
		}
		printLinkedList(head);
		
	}

	private static LinkedList reverse(int from, int to, LinkedList head) {
		LinkedList t = head;
		int p = 1;
		LinkedList leftBoundry = null;
		LinkedList rightBoundry = null;
		
		while(t != null) {
			if(p == from -1)
				leftBoundry = t;
			else if(p == to + 1)
				rightBoundry = t;
			t = t.next;
			p++;
		}
		
		
		LinkedList prev = null;
		LinkedList next = from == 1 ? head : leftBoundry.next;
		
		prev = reverseLinkedList(next, prev, next, rightBoundry);
		
		if(from == 1) {
			head.next = rightBoundry;
			head = prev;
		} else {
			leftBoundry.next = prev;
			t = prev;
			while(t.next != null) {
				t = t.next;
			}
			t.next = rightBoundry;
		}
		
		
		
		return head;
	}

	private static LinkedList reverseLinkedList(LinkedList head, LinkedList prev, LinkedList next, LinkedList rightBoundry) {
		while(next != rightBoundry) {
			head = head.next;
			next.next = prev;
			prev = next;
			next = head;
		}
		return prev;
	}

	private static LinkedList createLinekdList(int[] inpArr) {
		LinkedList head = null;
		LinkedList tail = null;
		for(int i=0; i<inpArr.length; i++) {
			LinkedList newll = new LinkedList(inpArr[i]);
			if(null == head) {
				head = newll;
				tail = newll;
			} else {
				tail.next = newll;
				tail = newll;
			}
		}
		return head;
	}

	private static int printLinkedList(LinkedList head) {
		int size = 0;
		LinkedList t = head;
		while(t != null) {
			System.out.print(t.val + " --> ");
			t = t.next;
			size++;
		}
		System.out.println("null");
		return size;
	}
}
