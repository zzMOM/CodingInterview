package chapter2;

/**You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * @author weiwu
 *
 */
public class ReverseSum {
	public Node addLists1(Node l1, Node l2, int carry){
		//We are done if both lists are null and the carry value is 0
		if(l1 == null && l2 == null && carry ==0){
			return null;
		}
		
		Node result = new Node();
		Node head = result;
		int value = carry;
		if(l1 != null){
			value += Integer.parseInt(l1.elem.toString());
		}
		if(l2 != null){
			value += Integer.parseInt(l2.elem.toString());
		}
		
		result.elem = value % 10;
		
		//Recurse
		if(l1 != null || l2 != null || value >= 10){
			Node more = addLists1(l1 == null? null : l1.next,
								 l2 == null? null : l2.next,
								 value >= 10? 1 : 0);
			result.next = more;
		}
		return head;
	}
	
	//change the order to forward order
	public Node addLists2(Node l1, Node l2){
		if(l1 == null && l2 == null) return null;
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		int len1 = getLength(l1);
		int len2 = getLength(l2);
		
		//padding the shorter list with zeros
		if(len1 < len2){
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		PartialSum sum = addListHelper(l1, l2);
		if(sum.carry == 0){
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
	}
	
	
	public int getLength(Node n){
		int len = 0;
		if(n == null) return 0;
		while(n != null){
			len += 1;
			n = n.next;
		}
		return len;
	}
	
	public Node padList(Node l, int padding){
		Node head = l;
		for(int i = 0; i < padding; i++){
			Node n = new Node();
			n.elem = 0;
			n.next = head;
			head = n;
		}
		return head;
	}
	
	public PartialSum addListHelper(Node n1, Node n2){
		if(n1 == null && n2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListHelper(n1.next, n2.next);
		
		int value = Integer.parseInt(n1.elem.toString()) + Integer.parseInt(n2.elem.toString()) + sum.carry;
		Node n = insertBefore(sum.sum, value % 10);
		sum.sum = n;
		sum.carry = value / 10;
		return sum;
	}
	
	Node insertBefore(Node list, int data){
		Node head = new Node();
		head.elem = data;
		head.next = null;
		if(list != null){
			head.next = list;
		}
		return head;
	}
	
}
