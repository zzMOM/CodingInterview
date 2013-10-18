package chapter2;

/**
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop
 * @author weiwu
 *
 */
public class CircularLinkedList {
	/*Detect if Linked List has a loop
	 * FastRunner and SlowRunner
	 * Fast 2 times faster than sloww
	 * slowRunner return to head when they meet, and both run 1 step rate, then meet at the beginning
	 */
	
	public Node findBeginning(Node head){
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		
		//error check no meeting point
		if(fast == null || fast.next == null){
			return null;
		}
		
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
