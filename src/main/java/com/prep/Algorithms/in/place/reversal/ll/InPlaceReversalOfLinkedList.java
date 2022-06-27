/**
 * 
 */
package com.prep.Algorithms.in.place.reversal.ll;

/**
 * @author pavan
 *
 */
public class InPlaceReversalOfLinkedList {

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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList input = createLinkedList(new int[] {1,2,3,4,5,6,7,8});
		printLinkedList(input);
		int x = 4, y = 8;
		LinkedList revHead = reverse(input, x, y);
		printLinkedList(revHead);
	}

	private static LinkedList reverse(LinkedList input, int x, int y) {
		int p = 1;
		LinkedList n = input;
		LinkedList leftBoundry = null;
		LinkedList rightBoundry = null;
		while(n != null) {
			if(p == (x-1)) {
				leftBoundry = n;
			} else if(p == (y+1)) {
				rightBoundry = n;
			}
			n = n.next;
			p++;
		}
		System.out.println("leftBoundry: " + leftBoundry);
		System.out.println("rightBoundry :" + rightBoundry);
		
		LinkedList head = leftBoundry == null ? input : leftBoundry.next;
		n = head;
		LinkedList prev = null;
		LinkedList revHead = leftBoundry == null ? input : leftBoundry.next;
		
		while(n != rightBoundry) {
			head = head.next;
			n.next = prev;
			prev = n;
			n = head;
		}
		
		revHead.next = rightBoundry;
		if(leftBoundry == null) {
			input = prev;
		} else
			leftBoundry.next = prev;
		
		return input;
	}

	private static LinkedList createLinkedList(int[] arr) {
		LinkedList head = null;
		LinkedList tail = null;
		
		for(int i=0; i<arr.length; i++) {
			LinkedList newll = new LinkedList(arr[i]);
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
	
	private static void printLinkedList(LinkedList input) {
		while(input != null) {
			System.out.print(input.val + " --> ");
			input = input.next;
		}
		System.out.print("null");
		System.out.println();
	}

}
