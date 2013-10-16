package chapter2;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 * @author weiwu
 *
 */
public class KtoLastElem {

	//solution 1: if the size is known, print elements at length - k
	
	//solution 2: size unknown.
	//Recursive
	public int ktoLast1(Node head, int k){
		if(head == null) return 0;
		
		int i = ktoLast1(head.next, k) + 1;
		if(i == k){
			System.out.println(head.elem.toString());
		}
		return i;
	}
	
	//Recursive, create a wrapper class
	public class IntWrapper{
		public int value = 0;
	}
	
	Node ktoLast2(Node head, int k, IntWrapper i){
		if(head == null) return null;
		
		Node node = ktoLast2(head.next, k, i);
		i.value = i.value + 1;
		if(i.value == k){
			return head;
		}
		return node;
	}
	
	//Iterative, two pointer p1 and p2
	public Node ktoLast3(Node head, int k){
		if(k <= 0) return null;
		
		Node p1 = head;
		Node p2 = head;
		
		//move p2 forward k nodes into the list
		for(int i = 0; i < k - 1; i++){
			if( p2 == null) return null; //error check
			p2 = p2.next;
		}
		if(p2 == null) return null;
		
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
