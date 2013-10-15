package chapter2;

/**
 * Write code to remove duplicates from an unsorted linked list
 */
import java.util.Hashtable;
import java.util.LinkedList;

public class RemoveDuplicates {

	public void deleteDups1(Node n){
		Hashtable table = new Hashtable();
		Node previous = null;
		while(n != null){
			if(table.contains(n.elem)){
				previous.next = n.next;
			} else {
				table.put(n.elem, true);
				previous = n;
			}
			n = n.next;
		}
	}
}
