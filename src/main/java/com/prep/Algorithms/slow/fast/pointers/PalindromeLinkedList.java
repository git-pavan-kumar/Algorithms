/**
 * 
 */
package com.prep.Algorithms.slow.fast.pointers;

/**
 * @author pavan
 *
 */
public class PalindromeLinkedList {

	private static class LinkedList<T extends Number> {
		private T val;
		LinkedList<T> next;
		
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
		Boolean isPalindrome = isPalindrome(head);
		System.out.println("Is Palindrome ? " + isPalindrome);
	}
	
	//Detect Palindrome
	private static Boolean isPalindrome(LinkedList<Integer> head) {
		Boolean isPalindrome = true;
		LinkedList<Integer> middle = getMiddleOfLinkedList(head);
		LinkedList<Integer> reverseHead = reverseLinkedList(middle);
		LinkedList<Integer> p1 = head;
		LinkedList<Integer> p2 = reverseHead;
		while(p1 != null && p2 != null) {
			if(!p1.val.equals(p2.val)) {
				isPalindrome = false;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return isPalindrome;
	}
	
	//Reverse linked list
	private static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> head) {
		LinkedList<Integer> prev = null;
		LinkedList<Integer> next = head;
		
		while(next != null) {
			head = head.next;
			next.next = prev;
			prev = next;
			next = head;
		}
		
		System.out.println("-- Reversed linked list --");
		printLinkedList(prev);
		return prev;
	}
	
	
	//Find middle of Linked list
	private static LinkedList<Integer> getMiddleOfLinkedList(LinkedList<Integer> head) {
		LinkedList<Integer> slow = head;
		LinkedList<Integer> fast = head;
		while(fast !=null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle of linked list: " + slow);
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
