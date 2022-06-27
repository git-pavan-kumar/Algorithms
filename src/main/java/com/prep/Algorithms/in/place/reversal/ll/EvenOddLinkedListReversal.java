/**
 * 
 */
package com.prep.Algorithms.in.place.reversal.ll;

/**
 * @author pavan
 *
 */
public class EvenOddLinkedListReversal {

	static class LinkedList {
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inputArr = new int[] {1,2,3,4,5};
		LinkedList r1Head = null;
		LinkedList r2Head = null;
		LinkedList head = createLinkedList(inputArr);
		int size = printLinkedList(head);
		if(size % 2 == 0) {
			r1Head = reverse(1, (size/2), head);
			r2Head = reverse((size/2 + 1), size, r1Head);
		} else {
			r1Head = reverse(1, (size/2), head);
			r2Head = reverse((size/2 + 2), size, r1Head);
		}
		printLinkedList(r2Head);
	}
	
	
	private static LinkedList reverse(int i, int j, LinkedList head) {
		LinkedList next = head;
		LinkedList prev = null;
		LinkedList leftBoundry = null;
		LinkedList rightBoundry = null;
		LinkedList t = head;
		int p = 1;
		
		while(t != null) {
			if(p == i-1)
				leftBoundry = t;
			else if(p == j+1)
				rightBoundry = t;
			t = t.next;
			p++;
		}
		
		next = i == 1 ? head : leftBoundry.next; 
		
		prev = reverseLinkedList(next, next, prev, rightBoundry);
		
		if(i == 1) {
			head.next = rightBoundry;
			head = prev;
		} else {
			leftBoundry.next = prev;
		}
		
		return head;
	}


	private static LinkedList reverseLinkedList(LinkedList head, LinkedList next, LinkedList prev,
			LinkedList rightBoundry) {
		while(next != rightBoundry) {
			head = head.next;
			next.next = prev;
			prev = next;
			next = head;
		}
		return prev;
	}


	private static LinkedList createLinkedList(int[] inputArr) {
		LinkedList head = null;
		LinkedList tail = null;
		for(int i=0; i<inputArr.length; i++) {
			LinkedList newll = new LinkedList(inputArr[i]);
			if(head == null) {
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
		LinkedList p = head;
		int size = 0;
		while(p != null) {
			System.out.print(p.val + " --> ");
			p = p.next;
			size++;
		}
		System.out.println("null");
		return size;
	}
}
