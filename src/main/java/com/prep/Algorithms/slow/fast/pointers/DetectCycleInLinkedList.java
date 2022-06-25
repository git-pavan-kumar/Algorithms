/**
 * 
 */
package com.prep.Algorithms.slow.fast.pointers;

/**
 * @author pavan
 *
 */
public class DetectCycleInLinkedList {

	/**
	 * @param args
	 */
	
	static class LinkedList<T> {
		private T val;
		private LinkedList<Integer> next;
		
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
	
	public static void main(String[] args) {
		LinkedList<Integer> head = createLinkedListFromArray(new Integer[] {1,2,3,4,5,6});
		printLinkedList(head);
		
		System.out.println("---- LL with cycle ----");
		LinkedList<Integer> cycleHead = createLinkedListWithCycle(new Integer[] {1,2,3,4,5,6}, 2);
		Boolean hasCycle = hasCycleInLinkedList(cycleHead);
		System.out.println("Cycle detected --> " + hasCycle);
		Integer cycleLength = getLenghtOfLinkedListCycle(cycleHead);
		System.out.println("Cycle length --> " + cycleLength);
		LinkedList<Integer> startNode = getStartingNodeInCycle(cycleHead);
		System.out.println("Starting node of the cycle --> " + startNode);
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
	
	//Create Linked list with cycle
	private static LinkedList<Integer> createLinkedListWithCycle(Integer[] arr, Integer index) {
		LinkedList<Integer> head = null;
		LinkedList<Integer> tail = null;
		LinkedList<Integer> startCycle = null;
		for(int i=0; i<arr.length; i++) {
			LinkedList<Integer> ll = new LinkedList<>(arr[i]);
			if(i == index) {
				startCycle = ll;
			}
			if(i == arr.length - 1) {
				tail.next = ll;
				ll.next = startCycle;
				tail = ll;
			} else if(head == null){
				ll.next = null;
				head = ll;
				tail = head;
			} else {
				tail.next = ll;
				tail = ll;
			}
		}
		return head;
	}
	
	//Has cycle ?
	private static Boolean hasCycleInLinkedList(LinkedList<Integer> head) {
		Boolean hasCycle = false;
		LinkedList<Integer> slow = head;
		LinkedList<Integer> fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				hasCycle = true;
				break;
			}
		}
		return hasCycle;
	}
	
	//Length of cycle
	private static Integer getLenghtOfLinkedListCycle(LinkedList<Integer> head) {
		Integer cycleLength = 0;
		LinkedList<Integer> slow = head;
		LinkedList<Integer> fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				LinkedList<Integer> altSlow = slow;
				do {
					altSlow = altSlow.next;
					cycleLength++;
				} while(altSlow != fast);
				break;
			}
		}
		return cycleLength;
	}
	
	//Get starting node of a cycle - jump by cycle length for fast pointer
	private static LinkedList<Integer> getStartingNodeInCycle(LinkedList<Integer> head) {
		Integer length = getLenghtOfLinkedListCycle(head);
		LinkedList<Integer> slow = head;
		LinkedList<Integer> fast = head;
		if(length > 0) {
			while(length > 0) {
				fast = fast.next;
				length--;
			}
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
		} else {
			System.out.println("No cycle detected !!!");
		}
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
	
}

