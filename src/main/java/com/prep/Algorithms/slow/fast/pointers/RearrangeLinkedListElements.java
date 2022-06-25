/**
 * 
 */
package com.prep.Algorithms.slow.fast.pointers;

/**
 * @author pavan
 *
 */
public class RearrangeLinkedListElements {

	private static class LinkedList<T> {
		private T val;
		private LinkedList<T> next;
		
		LinkedList(T val) {
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
		LinkedList<Integer> head = createLinkedListFromArray(new Integer[] {2,4,6,4,2,4});
		printLinkedList(head);
		LinkedList<Integer> middle = findMiddleElement(head);
		LinkedList<Integer> revHead = reverse(middle);
		System.out.println("-- Reversed list --");
		printLinkedList(revHead);
		printLinkedList(head);
		rearrange(head, revHead);
		printLinkedList(head);
	}
	
	private static LinkedList<Integer> rearrange(LinkedList<Integer> h1, LinkedList<Integer> h2) {
		while(h1 != null && h2 != null) {
			LinkedList<Integer> temp = h1.next;
			h1.next = h2;
			h1 = temp;
			
			temp = h2.next;
			h2.next = h1;
			h2 = temp;
		}
		return h1;
	}
	
	private static LinkedList<Integer> reverse(LinkedList<Integer> head) {
		LinkedList<Integer> prev = null;
		
		while(head != null) {
			LinkedList<Integer> next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	private static LinkedList<Integer> findMiddleElement(LinkedList<Integer> head) {
		LinkedList<Integer> slow = head;
		LinkedList<Integer> fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle element : " + slow);
		return slow;
	}
	
	//Print Linked list
	private static void printLinkedList(LinkedList<Integer> head) {
		LinkedList<Integer> altHead = head;
		while(altHead != null) {
			System.out.print(altHead.val + " --> ");
			altHead = altHead.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	//Create Linked list w/o cycle
	private static LinkedList<Integer> createLinkedListFromArray(Integer[] arr) {
		LinkedList<Integer> head = null;
		LinkedList<Integer> tail = null;
		for(int i=0; i< arr.length; i++) {
			LinkedList<Integer> ll = new LinkedList<>(arr[i]);
			if(head == null) {
				head = ll;
				tail = ll;
			} else {
				tail.next = ll;
				tail = ll;
			}
		}
		return head;
	}

}
