package chapter2;

import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome
 * @author weiwu
 *
 */
public class PalindromeLinkedList {

	/*solution #1: Reverse and compare
	 * 
	 */
	public boolean isPalindrome1(Node head){
		if(head == null){
			return true;
		}
		if(head.next == null){
			return true;
		}
		
		//create reverse
		Node n;
		n = head;
		Node head2 = new Node();
		head2.elem = head.elem;
		head2.next = null;
		int size = 0;
		while(n.next != null){
			Node newNode = new Node();
			newNode.elem = n.next.elem;
			newNode.next = head2;
			head2 = newNode;
			n = n.next;
			size++;
		}
		//compare
		n = head;
		Node n2 = head2;
		int i = 0;
		while(i <= size / 2){
			if(n != n2){
				return false;
			} 
			n = n.next;
		}
		return true;
		
	}
	
	/*solution #2: Iterative Approach
	 * fast and slow
	 * put the first half into stack, when fast reach the end, the slow in the middle
	 */
	public boolean isPalindrome2(Node head){
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stack.push(Integer.parseInt(slow.elem.toString()));
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//Has odd number of elements, skip the middle element
		if(fast != null){
			slow = slow.next;
		}
		
		while(slow != null){
			int top = stack.pop().intValue();
			if(top != Integer.parseInt(slow.elem.toString())){
				return false;
			} 
			slow = slow.next;
		}
		return true;
	} 
	
	/* Recusive Approach
	 * 
	 */
	Result isPalindromeRec(Node head, int length){
		if(head == null || length == 0){
			return new Result(null, true);
		} else if(head.next == null){
			return new Result(head.next, true);
		} else if(head.next.next == null){
			return new Result(head.next.next, Integer.parseInt(head.elem.toString()) == Integer.parseInt(head.next.elem.toString()));
		}
		
		Result res = isPalindromeRec(head.next, length - 2);
		if(!res.result || res.node == null){
			return res;
		} else {
			res.result = head.elem == res.node.elem;
			res.node = res.node.next;
			return res;
		}
	}
	
	public int listSize(Node head){
		Node n = head;
		int size = 0;
		while(n != null){
			size++;
			n = n.next;
		}
		return size;
	}
	
	public boolean isPalindrome3(Node head){
		Result p = isPalindromeRec(head, listSize(head));
		return p.result;
	}
}
