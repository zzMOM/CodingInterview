package chapter2;

/**
 * Write code to remove duplicates from an unsorted linked list
 */
import java.util.Hashtable;
import java.util.LinkedList;

public class RemoveDuplicates {

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
}
