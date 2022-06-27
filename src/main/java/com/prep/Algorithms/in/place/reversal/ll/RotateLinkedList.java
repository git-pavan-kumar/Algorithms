/**
 * 
 */
package com.prep.Algorithms.in.place.reversal.ll;

import java.util.Scanner;

/**
 * @author pavan
 *
 */
public class RotateLinkedList {

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
		int[] inp = new int[] {1,2,3,4,5,6,7,8};
		//int k = 3;
		Scanner in = new Scanner(System.in);
		int k = Integer.valueOf(in.nextLine());
		LinkedList head = createLinkedList(inp);
		printLinkedList(head);
		LinkedList rotatedHead = rotate(head, k);
		printLinkedList(rotatedHead);
	}
	private static LinkedList rotate(LinkedList head, int k) {
		LinkedList t = head;
		int p = 1;
		LinkedList rotateNode = null;
		LinkedList tail = null;
		
		while(t!=null) {
			if(p == k) {
				rotateNode = t;
			}
			p++;
			if(t.next == null)
				tail = t;
			t = t.next;
		}
		
		
		tail.next = head;
		head = rotateNode.next;
		rotateNode.next = null;
		
		return head;
	}
	private static void printLinkedList(LinkedList head) {
		LinkedList t = head;
		while(t != null) {
			System.out.print(t.val + " --> ");
			t = t.next;
		}
		System.out.println("null");
	}
	private static LinkedList createLinkedList(int[] inp) {
		LinkedList head = null;
		LinkedList tail = null;
		for(int i=0; i< inp.length; i++) {
			LinkedList newll = new LinkedList(inp[i]);
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

}
