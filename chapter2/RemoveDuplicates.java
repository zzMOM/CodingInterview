package chapter2;

/**
 * Write code to remove duplicates from an unsorted linked list
 */
import java.util.Hashtable;
import java.util.LinkedList;

public class RemoveDuplicates {

	//method use additional buffer, O(N)
	public void deleteDups1(Node n){
		Hashtable<Object, Boolean> table = new Hashtable<Object, Boolean>();
		Node previous = null;
		while(n != null){
			if(table.containsKey(n.elem.toString().charAt(0))){
				previous.next = n.next;
				//System.out.print(n.elem.toString() + " ");
			} else {
				table.put(n.elem.toString().charAt(0), true);
				previous = n;
				System.out.print(n.elem.toString() + " ");
			}
			n = n.next;
		}
	}
	
	//method not use temporary buffer, O(1)space, O(n^2) time
	public void deleteDups2(Node head){
		if(head == null) return;
		
		Node current = head;
		while(current != null){
			/*remove all future nodes that have the same values*/
			Node runner = current;
			while(runner.next != null){
				//toString().charAt(0) to compare, or it will be wrong
				if(runner.next.elem.toString().charAt(0) == current.elem.toString().charAt(0)){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
		current = head;
		while(current != null){

			System.out.print(current.elem.toString() + " ");
			current = current.next;
		}
	}
}
